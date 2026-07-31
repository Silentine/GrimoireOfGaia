package gaia.entity;

import gaia.attachment.AttachmentHandler;
import gaia.attachment.friended.Friended;
import gaia.config.GaiaConfig;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.Tags;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public abstract class AbstractGaiaEntity extends Monster {
	private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(AbstractGaiaEntity.class, EntityDataSerializers.INT);
	protected Goal targetPlayerGoal;
	protected final Goal targetMobGoal = new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity, level) -> {
		return livingEntity instanceof Enemy && !(livingEntity instanceof Creeper) &&
				(livingEntity instanceof AbstractAssistGaiaEntity assistMob && assistMob.isAngryAt(this, level));
	});

	public AbstractGaiaEntity(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_1;
	}

	public void finalizeAttributes() {
		switch (getGaiaLevel()) {
			default -> {
				getAttribute(Attributes.MAX_HEALTH).setBaseValue(SharedEntityData.getMaxHealth1());
				getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(SharedEntityData.getAttackDamage1());
			}
			case 2 -> {
				getAttribute(Attributes.MAX_HEALTH).setBaseValue(SharedEntityData.getMaxHealth2());
				getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(SharedEntityData.getAttackDamage2());
			}
			case 3 -> {
				getAttribute(Attributes.MAX_HEALTH).setBaseValue(SharedEntityData.getMaxHealth3());
				getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(SharedEntityData.getAttackDamage3());
			}
		}
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(VARIANT, 0);
	}

	public int getGaiaLevel() {
		return 1;
	}

	public int getVariant() {
		return this.entityData.get(VARIANT);
	}

	public void setVariant(int index) {
		this.entityData.set(VARIANT, Mth.clamp(index, 0, maxVariants()));
	}

	public int maxVariants() {
		return 0;
	}

	public abstract float getBaseDefense();

	protected float getBaseDamage(DamageSource source, float damage) {
		if (getBaseDefense() > 0) {
			return source.is(DamageTypes.FELL_OUT_OF_WORLD) ? damage : Math.min(damage, getBaseDefense());
		}
		return damage;
	}

	protected void spawnLingeringCloud(List<MobEffectInstance> effectInstances) {
		if (!effectInstances.isEmpty()) {
			AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
			areaeffectcloud.setRadius(2.5F);
			areaeffectcloud.setRadiusOnUse(-0.5F);
			areaeffectcloud.setWaitTime(10);
			areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
			areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());

			for (MobEffectInstance mobeffectinstance : effectInstances) {
				areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
			}

			this.level().addFreshEntity(areaeffectcloud);
		}
	}

	protected GaiaHorse createHorse(DifficultyInstance difficulty) {
		Entity entity = GaiaRegistry.HORSE.getEntityType().create(this.level(), EntitySpawnReason.MOB_SUMMONED);
		if (entity instanceof GaiaHorse horse) {
			horse.finalizeSpawn((ServerLevel) this.level(), difficulty, EntitySpawnReason.JOCKEY, (SpawnGroupData) null);
			horse.setPos(this.getX(), this.getY(), this.getZ());
			horse.setTamed(true);
			horse.setAge(0);
			this.level().addFreshEntity(horse);
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

	/**
	 * Detects if there are any Player nearby
	 */
	protected boolean playerDetection(int range, TargetingConditions conditions) {
		AABB box = new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1).inflate(range);
		if (this.level() instanceof ServerLevel serverLevel) {
			List<Player> list = serverLevel.getNearbyPlayers(conditions, this, box);

			return !list.isEmpty();
		}
		return false;
	}

	/**
	 * Gets nearby entities and applies the given consumer to them
	 *
	 * @param range  The range to search for entities
	 * @param action The action to apply to the entities
	 */
	protected void beaconMonster(int range, Consumer<LivingEntity> action) {
		if (!this.level().isClientSide()) {
			AABB aabb = (new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1)).inflate(range);
			List<LivingEntity> entities = this.level().getEntitiesOfClass(LivingEntity.class, aabb);
			for (LivingEntity livingEntity : entities) {
				action.accept(livingEntity);
			}
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
	                                    EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);
		this.finalizeAttributes();

		//Setup health changes
		switch (getGaiaLevel()) {
			default -> {
				AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
				if (healthAttribute != null)
					healthAttribute.setBaseValue(SharedEntityData.getMaxHealth1());
				AttributeInstance damageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);
				if (damageAttribute != null)
					damageAttribute.setBaseValue(SharedEntityData.getAttackDamage1());
			}
			case 2 -> {
				AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
				if (healthAttribute != null)
					healthAttribute.setBaseValue(SharedEntityData.getMaxHealth2());
				AttributeInstance damageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);
				if (damageAttribute != null)
					damageAttribute.setBaseValue(SharedEntityData.getAttackDamage2());
			}
			case 3 -> {
				AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
				if (healthAttribute != null)
					healthAttribute.setBaseValue(SharedEntityData.getMaxHealth3());
				AttributeInstance damageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);
				if (damageAttribute != null)
					damageAttribute.setBaseValue(SharedEntityData.getAttackDamage3());
			}
		}
		this.setHealth(getMaxHealth()); //Set max health since it's not done automatically when changing the attribute

		if (GaiaConfig.COMMON.passiveHostileMobs.get()) {
			this.goalSelector.removeGoal(targetPlayerGoal);
		}

		return data;
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putInt("Variant", getVariant());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		int variant = input.getIntOr("Variant", 0);
		setVariant(variant);
		setupFriendGoals(isFriendly());
	}

	/**
	 * @return true if this entity is a friend of the player
	 */
	public boolean isFriendly() {
		return AttachmentHandler.getFriended(this).isFriendly();
	}

	/**
	 * Sets the entity to friendly or not friendly
	 *
	 * @param value      true for friendly, false for not friendly
	 * @param friendedBy the player who set the entity to friendly
	 */
	public void setFriendly(boolean value, UUID friendedBy) {
		Friended friended = getData(AttachmentHandler.FRIENDED);
		this.setTarget((LivingEntity) null);
		Friended newFriended = new Friended.Builder()
				.setFriended(value)
				.setFriendedBy(friendedBy).build();
		if (friended.equals(newFriended)) {
			setData(AttachmentHandler.FRIENDED, newFriended);
			onFriendlyChange(newFriended);
		}
		setupFriendGoals(value);
		if (GaiaConfig.COMMON.friendlyPersistence.get()) {
			setPersistenceRequired();
		}
	}

	/**
	 * Adjusts AI goals based on if the entity is friendly or not
	 *
	 * @param friendly true if the entity is friendly, false if not
	 */
	protected void setupFriendGoals(boolean friendly) {
		if (this.targetPlayerGoal == null) {
			this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		}
		switch (getGaiaLevel()) {
			case 1 -> {
				//Iron Golem AI
				if (friendly) {
					this.targetSelector.removeGoal(this.targetPlayerGoal);
					this.targetSelector.addGoal(2, this.targetMobGoal);
				} else {
					this.targetSelector.removeGoal(this.targetMobGoal);
					if (this instanceof AbstractAssistGaiaEntity) {
						if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
							this.targetSelector.addGoal(2, this.targetPlayerGoal);
						}
					} else {
						if (!GaiaConfig.COMMON.passiveHostileMobs.get()) {
							this.targetSelector.addGoal(2, this.targetPlayerGoal);
						}
					}
				}
			}
			case 2 -> {
				//Just don't target players actively
				if (friendly) {
					this.targetSelector.removeGoal(this.targetPlayerGoal);
				} else {
					if (this instanceof AbstractAssistGaiaEntity) {
						if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
							this.targetSelector.addGoal(2, this.targetPlayerGoal);
						}
					} else {
						if (!GaiaConfig.COMMON.passiveHostileMobs.get()) {
							this.targetSelector.addGoal(2, this.targetPlayerGoal);
						}
					}
				}
			}
		}
	}

	/**
	 * Called when the friendly status of the entity changes
	 *
	 * @param cap the capability
	 */
	public void onFriendlyChange(Friended cap) {

	}

	public double getMyRidingOffset() {
		return this.isBaby() ? 0.0D : -0.6D;
	}

	public void rideTick() {
		super.rideTick();
		if (this.getVehicle() instanceof PathfinderMob pathfindermob) {
			this.yBodyRot = pathfindermob.yBodyRot;
		}
	}

	@Override
	public boolean canAttack(LivingEntity target) {
		if (this instanceof AbstractAssistGaiaEntity) {
			return !target.is(this) && (!target.is(EntityTypes.CREEPER) && super.canAttack(target));
		}
		return super.canAttack(target);
	}

	@Override
	public float getWalkTargetValue(BlockPos pos, LevelReader levelReader) {
		return this instanceof IDayMob ? 0.0F : super.getWalkTargetValue(pos, levelReader);
	}

	public static boolean checkGaiaDaySpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaylight(levelAccessor, pos) && checkAnyLightMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	/**
	 * Check if the lighting is good for spawning
	 */
	protected static boolean checkDaylight(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return levelAccessor.canSeeSky(pos) && levelAccessor.getBrightness(LightLayer.BLOCK, pos) == 0;
	}

	/**
	 * Check if the lighting is good for spawning underwater
	 */
	protected static boolean checkUnderwaterDaylight(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return levelAccessor.canSeeSkyFromBelowWater(pos) && levelAccessor.getBrightness(LightLayer.BLOCK, pos) == 0;
	}

	/**
	 * Checks if the position is above sea level so the entity can spawn
	 */
	protected static boolean checkAboveSeaLevel(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return checkAboveY(pos, levelAccessor.getSeaLevel());
	}

	/**
	 * Checks if the position is above a given Y level so the entity can spawn
	 */
	protected static boolean checkAboveY(BlockPos pos, int yLevel) {
		return GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() > yLevel;
	}

	/**
	 * Checks if the position is below sea level so the entity can spawn
	 */
	protected static boolean checkBelowSeaLevel(ServerLevelAccessor levelAccessor, BlockPos pos) {
		return checkBelowY(pos, levelAccessor.getSeaLevel());
	}

	/**
	 * Check if the position is below sea level and in water so the entity can spawn
	 */
	public static boolean checkInWater(LevelAccessor levelAccessor, BlockPos pos, int yOffset) {
		int seaLevel = levelAccessor.getSeaLevel();
		int belowSeaLevel = seaLevel - yOffset;
		boolean below = pos.getY() <= belowSeaLevel;
		boolean inWater = levelAccessor.getFluidState(pos.below()).is(FluidTags.WATER) && levelAccessor.getBlockState(pos.above()).is(Blocks.WATER);
		return below && inWater;
	}

	/**
	 * Check if the position is below sea level and in water so the entity can spawn
	 */
	public static boolean checkNotPeaceful(LevelAccessor levelAccessor) {
		return levelAccessor.getDifficulty() != Difficulty.PEACEFUL;
	}


	/**
	 * Check if the position is below sea level and in water so the entity can spawn
	 */
	public static boolean checkSpawner(LevelAccessor levelAccessor) {
		return levelAccessor.getDifficulty() != Difficulty.PEACEFUL;
	}

	/**
	 * Checks if the position is above a given Y level so the entity can spawn
	 */
	protected static boolean checkBelowY(BlockPos pos, int yLevel) {
		return GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() < yLevel;
	}

	/**
	 * Checks if the block under the spawn location is in the given tag so the entity can spawn
	 */
	protected static boolean checkTagBlocks(ServerLevelAccessor levelAccessor, BlockPos pos, TagKey<Block> blockTag) {
		return levelAccessor.getBlockState(pos.below()).is(blockTag);
	}

	/**
	 * Checks if it's day time so the entity can spawn
	 */
	protected static boolean checkDaytime(ServerLevelAccessor levelAccessor) {
		return !levelAccessor.dimensionType().hasFixedTime() && levelAccessor.getSkyDarken() < 4;
	}

	/**
	 * Checks if it's raining so the entity can spawn
	 */
	protected static boolean checkRaining(ServerLevelAccessor levelAccessor) {
		return GaiaConfig.COMMON.spawnWeather.get() || levelAccessor.getLevel().isRaining();
	}

	/**
	 * Checks if the configured amount of days has passed so the entity can spawn
	 */
	protected static boolean checkDaysPassed(ServerLevelAccessor levelAccessor) {
		if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
			return (int) (levelAccessor.getGameTime() / 24000L) >= GaiaConfig.COMMON.spawnDaysSet.get();
		} else {
			return true;
		}
	}

	protected boolean hasShield() {
		ItemStack offStack = this.getItemBySlot(EquipmentSlot.OFFHAND);
		return offStack.is(Tags.Items.TOOLS_SHIELD); //TODO: Check behavior since ItemAbilities SHIELD is gone?
	}
}
