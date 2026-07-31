package gaia.entity;

import gaia.attachment.AttachmentHandler;
import gaia.attachment.friended.Friended;
import gaia.config.GaiaConfig;
import gaia.entity.goal.MobAttackGoal;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Bee extends AbstractAssistGaiaEntity implements IDayMob, RangedAttackMob {
	private static final EntityDataAccessor<Boolean> MOVING = SynchedEntityData.defineId(Bee.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> ANIMATION_STATE = SynchedEntityData.defineId(Bee.class, EntityDataSerializers.INT);

	private final RangedAttackGoal rangedAttackGoal = new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, 20, 60, 15.0F);
	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, true);

	private int timer;
	private int switchDetect;
	private int switchEquip;

	private boolean animationPlay;
	private int animationTimer;

	public Bee(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new FlyingMoveControl(this, 20, true);
		this.setPathfindingMalus(PathType.FIRE, -1.0F);
		this.setPathfindingMalus(PathType.WATER, -1.0F);
		this.setPathfindingMalus(PathType.WATER_BORDER, 16.0F);
		this.setPathfindingMalus(PathType.COCOA, -1.0F);
		this.setPathfindingMalus(PathType.FENCE, -1.0F);

		timer = 0;
		switchDetect = 0;
		switchEquip = 0;

		animationPlay = false;
		animationTimer = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(3, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.25D, i -> i.is(ItemTags.BEE_FOOD), false));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));

		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
	}

	public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
		return reader.getBlockState(pos).isAir() ? 10.0F : 0.0F;
	}

	@Override
	protected PathNavigation createNavigation(Level level) {
		FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, level) {
			public boolean isStableDestination(BlockPos pos) {
				return !level().getBlockState(pos.below()).isAir();
			}

			public void tick() {
				super.tick();
			}
		};
		flyingpathnavigation.setCanOpenDoors(false);
		flyingpathnavigation.setCanFloat(false);
		return flyingpathnavigation;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_RANGED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.FLYING_SPEED, (double) 0.5F)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_1)
				.add(Attributes.STEP_HEIGHT, 1.0F)
				.add(Attributes.TEMPT_RANGE, 10.0);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(MOVING, false);
		builder.define(ANIMATION_STATE, 0);
	}

	public boolean isFlying() {
		return !this.onGround();
	}

	public boolean isMoving() {
		return this.entityData.get(MOVING);
	}

	public void setMoving(boolean flag) {
		this.entityData.set(MOVING, flag);
	}

	public int getAnimationState() {
		return this.entityData.get(ANIMATION_STATE);
	}

	public void setAnimationState(int state) {
		this.entityData.set(ANIMATION_STATE, state);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		return super.hurtServer(level, source, damage);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.poison(target, this, distanceFactor);

			setAnimationState(1);
			animationPlay = true;
			animationTimer = 0;
		}
	}

	@Override
	public boolean doHurtTarget(ServerLevel level, Entity target) {
		if (super.doHurtTarget(level, target)) {
			if (target instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (this.level().getDifficulty() == Difficulty.NORMAL) {
					effectTime = 10;
				} else if (this.level().getDifficulty() == Difficulty.HARD) {
					effectTime = 20;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, effectTime * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		if (!this.level().isClientSide() && (getHealth() >= getMaxHealth())) {
			if (detectMovement() && !isMoving()) {
				setMoving(true);
			}

			if (!detectMovement() && isMoving()) {
				setMoving(false);
			}
		}

		if (playerDetection(3, TargetingConditions.forCombat())) {
			if (switchDetect == 0) {
				switchDetect = 1;
			}
		} else {
			if (switchDetect == 1) {
				switchDetect = 0;
			}
		}

		if (switchDetect == 1 && switchEquip == 0) {
			if (timer <= 20) {
				++timer;
			} else {
				setGoals(1);
				timer = 0;
				switchEquip = 1;
			}
		}

		if (switchDetect == 0 && switchEquip == 1) {
			if (timer <= 20) {
				++timer;
			} else {
				setGoals(0);
				timer = 0;
				switchEquip = 0;
			}
		}

		if (animationPlay) {
			if (animationTimer != 20) {
				animationTimer += 1;
			} else {
				setAnimationState(0);
				animationPlay = false;
			}
		}

		super.aiStep();
	}

	@Override
	public void onFriendlyChange(Friended cap) {
		if (cap.isFriendly()) {
			setGoals(1);
			timer = 0;
			switchEquip = 1;
		}
	}

	private boolean detectMovement() {
		if (this.getDeltaMovement().horizontalDistanceSqr() > (double) 2.5000003E-7F) {
			BlockState blockstate = this.level().getBlockState(blockPosition().below());
			return !blockstate.isAir();
		}

		return false;
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(rangedAttackGoal);
			this.goalSelector.addGoal(0, mobAttackGoal);
		} else {
			Friended friended = AttachmentHandler.getFriended(this);
			if (!friended.isFriendly()) {
				this.goalSelector.removeGoal(mobAttackGoal);
				this.goalSelector.addGoal(0, rangedAttackGoal);

				setAnimationState(0);
				animationPlay = false;
				animationTimer = 0;
			}
		}
	}

	private void setCombatTask() {
		setGoals(0);
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);

		setCombatTask();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.BEE.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.BEE.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.BEE.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
	}

	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return effectInstance.getEffect() != MobEffects.POISON && super.canBeAffected(effectInstance);
	}

	@Override
	public boolean causeFallDamage(double fallDistance, float damageModifier, DamageSource damageSource) {
		return false;
	}

	@Override
	protected void checkFallDamage(double p_27754_, boolean p_27755_, BlockState state, BlockPos pos) {
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkBeeSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	@Override
	public void setPersistentAngerEndTime(long endTime) {

	}
}