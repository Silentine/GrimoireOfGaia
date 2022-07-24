package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.entity.type.IAssistMob;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Random;

public abstract class AbstractGaiaEntity extends Monster {
	private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(AbstractGaiaEntity.class, EntityDataSerializers.INT);

	public AbstractGaiaEntity(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_1;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
	}

	public int getVariant() {
		return this.entityData.get(VARIANT);
	}

	public void setVariant(int index) {
		this.entityData.set(VARIANT, Mth.clamp(index, 0, maxVariants()));
	}

	public abstract int maxVariants();

	public abstract float getBaseDefense();

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, getBaseDefense());
		return super.hurt(source, input);
	}

	protected void spawnLingeringCloud(List<MobEffectInstance> effectInstances) {
		if (!effectInstances.isEmpty()) {
			AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
			areaeffectcloud.setRadius(2.5F);
			areaeffectcloud.setRadiusOnUse(-0.5F);
			areaeffectcloud.setWaitTime(10);
			areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
			areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());

			for (MobEffectInstance mobeffectinstance : effectInstances) {
				areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
			}

			this.level.addFreshEntity(areaeffectcloud);
		}
	}

	protected GaiaHorse createHorse(DifficultyInstance difficulty) {
		Entity entity = GaiaRegistry.HORSE.getEntityType().create(level);
		if (entity instanceof GaiaHorse horse) {
			horse.finalizeSpawn((ServerLevel) level, difficulty, null, (SpawnGroupData) null, (CompoundTag) null);
			horse.setPos(this.getX(), this.getY(), this.getZ());
			horse.setTamed(true);
			horse.setAge(0);
			level.addFreshEntity(horse);
			return horse;
		}
		return null;
	}

	protected static boolean isHalloween() {
		LocalDate localdate = LocalDate.now();
		int i = localdate.get(ChronoField.DAY_OF_MONTH);
		int j = localdate.get(ChronoField.MONTH_OF_YEAR);
		return j == 10 && i >= 20 || j == 11 && i <= 3;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Variant", getVariant());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("Variant")) {
			int variant = tag.getInt("Variant");
			setVariant(variant);
		}
	}

	public double getMyRidingOffset() {
		return -0.6D;
	}

	public void rideTick() {
		super.rideTick();
		if (this.getVehicle() instanceof PathfinderMob pathfindermob) {
			this.yBodyRot = pathfindermob.yBodyRot;
		}
	}

	@Override
	public boolean canAttackType(EntityType<?> type) {
		if (this instanceof IAssistMob) {
			return type != getType() && (type != EntityType.CREEPER && super.canAttackType(type));
		}
		return super.canAttackType(type);
	}

	@Override
	public float getWalkTargetValue(BlockPos pos, LevelReader levelReader) {
		return 0.0F;
	}

	public static boolean checkGaiaDaySpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaylight(levelAccessor, pos) && checkAnyLightMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	protected static boolean checkDaylight(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return levelAccessor.canSeeSky(pos) && levelAccessor.getBrightness(LightLayer.BLOCK, pos) == 0;
	}

	protected static boolean checkAboveSeaLevel(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() > levelAccessor.getSeaLevel() - 16;
	}

	protected static boolean checkBelowSeaLevel(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() < levelAccessor.getSeaLevel() - 16;
	}

	protected static boolean checkTagBlocks(ServerLevelAccessor levelAccessor, BlockPos pos, TagKey<Block> blockTag) {
		return levelAccessor.getBlockState(pos.below()).is(blockTag);
	}

	protected static boolean checkDaytime(ServerLevelAccessor levelAccessor) {
		return !levelAccessor.dimensionType().hasFixedTime() && levelAccessor.getSkyDarken() < 4;
	}

	protected static boolean checkRaining(ServerLevelAccessor levelAccessor) {
		return GaiaConfig.COMMON.spawnWeather.get() || levelAccessor.getLevelData().isRaining();
	}

	protected static boolean checkDaysPassed(ServerLevelAccessor levelAccessor) {
		if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
			return GaiaConfig.COMMON.spawnDaysSet.get() <= levelAccessor.dayTime() % 24000;
		} else {
			return true;
		}
	}
}
