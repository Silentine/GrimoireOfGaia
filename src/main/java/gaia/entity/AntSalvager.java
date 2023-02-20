package gaia.entity;

import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AntSalvager extends AbstractGaiaEntity implements IDayMob, RangedAttackMob {
	private static final EntityDataAccessor<Boolean> HIDING = SynchedEntityData.defineId(AntSalvager.class, EntityDataSerializers.BOOLEAN);
	private final RangedAttackGoal rangedAttackGoal = new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, 20, 60, 15.0F);

	private boolean canHide;

	public AntSalvager(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		canHide = false;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(AntSalvager.class, Sporeling.class));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth1())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_RANGED)
				.add(Attributes.MOVEMENT_SPEED, -0.25F)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage1())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(HIDING, false);
	}

	public boolean isHiding() {
		return this.getEntityData().get(HIDING);
	}

	public void setHiding(boolean value) {
		this.getEntityData().set(HIDING, value);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		if (isHiding() && source != DamageSource.OUT_OF_WORLD) {
			return false;
		}
		float input = getBaseDamage(source, damage);
		return super.hurt(source, input);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.poison(target, this, distanceFactor);
		}
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			if (entityIn instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (level.getDifficulty() == Difficulty.NORMAL) {
					effectTime = 5;
				} else if (level.getDifficulty() == Difficulty.HARD) {
					effectTime = 10;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime * 20, 1));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, effectTime * 20, 1));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		if (!level.isClientSide && isPassenger()) {
			stopRiding();
		}

		if (!isOnGround() && tickCount > 40) {
			level.broadcastEntityEvent(this, (byte) 11);
			remove(RemovalReason.KILLED);
		}

		if (tickCount % 60 == 0 && !canHide) {
			canHide = true;
		}

		if (playerDetection(4, TargetingConditions.forCombat())) {
			if (canHide && !isHiding()) {
				setGoals(1);
				setHiding(true);
			}
			if (isHiding()) {
				addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 0));
			}
		} else {
			if (isHiding()) {
				level.broadcastEntityEvent(this, (byte) 12);
				setGoals(0);
				removeEffect(MobEffects.INVISIBILITY);
				setHiding(false);
				canHide = false;
			}
		}

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(rangedAttackGoal);
		} else {
			this.goalSelector.addGoal(1, rangedAttackGoal);
		}
	}

	private void setCombatTask() {
		if (!isHiding()) {
			setGoals(0);
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		setCombatTask();

		return data;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return effectInstance.getEffect() != MobEffects.POISON && super.canBeAffected(effectInstance);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("canHide", isHiding());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("Hiding")) {
			setHiding(tag.getBoolean("Hiding"));
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.ANT_SALVAGER.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.ANT_SALVAGER.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.ANT_SALVAGER.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	public static boolean checkAntSalvagerSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}