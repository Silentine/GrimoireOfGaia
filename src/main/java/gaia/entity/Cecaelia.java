package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

public class Cecaelia extends AbstractGaiaEntity implements RangedAttackMob {
	private static final EntityDataAccessor<Boolean> THROWING = SynchedEntityData.defineId(Cecaelia.class, EntityDataSerializers.BOOLEAN);

	private final RangedAttackGoal rangedAttackGoal = new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, 20, 60, 15.0F);
	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true);
	protected final WaterBoundPathNavigation waterNavigation;
	protected final GroundPathNavigation groundNavigation;

	private int timer;
	private int switchDetect;
	private int switchEquip;

	private boolean animationPlay;
	private int animationTimer;

	private byte inWaterTimer;

	public Cecaelia(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new CecaeliaMermaidMoveControl(this);

		this.setPathfindingMalus(BlockPathTypes.WATER, 8.0F);

		timer = 0;
		switchDetect = 0;
		switchEquip = 0;

		animationPlay = false;
		animationTimer = 0;

		inWaterTimer = 0;

		this.waterNavigation = new WaterBoundPathNavigation(this, level);
		this.groundNavigation = new GroundPathNavigation(this, level);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_1)

				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 1;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(THROWING, false);
	}

	public boolean isThrowing() {
		return this.entityData.get(THROWING);
	}

	public void setThrowing(boolean flag) {
		this.entityData.set(THROWING, flag);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.bubble(target, this, distanceFactor);

			setThrowing(true);
			animationPlay = true;
			animationTimer = 0;
		}
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			if (entityIn instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (this.level.getDifficulty() == Difficulty.NORMAL) {
					effectTime = 5;
				} else if (this.level.getDifficulty() == Difficulty.HARD) {
					effectTime = 10;
				}

				if (effectTime > 0) {
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
		if (!this.level.isClientSide) {
			if (isInWater()) {
				if (inWaterTimer <= 100) {
					++inWaterTimer;
				} else {
					level.broadcastEntityEvent(this, (byte) 8);
					heal(getMaxHealth() * 0.10F);
					addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5 * 20, 0));
					inWaterTimer = 0;
				}
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
				if (!hasEffect(MobEffects.MOVEMENT_SPEED)) {
					addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10 * 20, 0));
				}
				setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaiaRegistry.METAL_DAGGER.get()));
				setGoals(1);
				timer = 0;
				switchEquip = 1;
			}
		}

		if (switchDetect == 0 && switchEquip == 1) {
			if (timer <= 20) {
				++timer;
			} else {
				if (hasEffect(MobEffects.MOVEMENT_SPEED)) {
					removeEffect(MobEffects.MOVEMENT_SPEED);
				}
				setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
				setGoals(0);
				timer = 0;
				switchEquip = 0;
			}
		}

		if (animationPlay) {
			if (animationTimer != 20) {
				animationTimer += 1;
			} else {
				setThrowing(false);
				animationPlay = false;
			}
		}

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(rangedAttackGoal);
			this.goalSelector.addGoal(1, mobAttackGoal);
		} else {
			this.goalSelector.removeGoal(mobAttackGoal);
			this.goalSelector.addGoal(1, rangedAttackGoal);

			setThrowing(false);
			animationPlay = false;
			animationTimer = 0;
		}
	}

	boolean wantsToSwim() {
		LivingEntity livingentity = this.getTarget();
		return livingentity != null && livingentity.isInWater();
	}

	public void updateSwimming() {
		if (!this.level.isClientSide) {
			if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
				this.navigation = this.waterNavigation;
				this.setSwimming(true);
			} else {
				this.navigation = this.groundNavigation;
				this.setSwimming(false);
			}
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		ItemStack itemstack = getMainHandItem();
		if (itemstack.isEmpty()) {
			setGoals(0);
		} else {
			setGoals(1);
		}

		ItemStack swimmingBoots = new ItemStack(Items.LEATHER_BOOTS);
		setItemSlot(EquipmentSlot.FEET, swimmingBoots);
		swimmingBoots.enchant(Enchantments.DEPTH_STRIDER, 2);

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.CECAELIA.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.CECAELIA.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.CECAELIA.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public boolean canAttackType(EntityType<?> type) {
		return super.canAttackType(type) && type != GaiaRegistry.CECAELIA.getEntityType();
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader reader) {
		return reader.isUnobstructed(this);
	}

	public static boolean checkCecaeliaSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && !checkDaytime(levelAccessor) && checkAboveY(pos, (levelAccessor.getSeaLevel() - 16)) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	static class CecaeliaMermaidMoveControl extends MoveControl {
		private final Cecaelia cecaelia;

		public CecaeliaMermaidMoveControl(Cecaelia cecaelia) {
			super(cecaelia);
			this.cecaelia = cecaelia;
		}

		public void tick() {
			LivingEntity livingentity = this.cecaelia.getTarget();
			if (this.cecaelia.wantsToSwim() && this.cecaelia.isInWater()) {
				if (livingentity != null && livingentity.getY() > this.cecaelia.getY()) {
					this.cecaelia.setDeltaMovement(this.cecaelia.getDeltaMovement().add(0.0D, 0.002D, 0.0D));
				}

				if (this.operation != MoveControl.Operation.MOVE_TO || this.cecaelia.getNavigation().isDone()) {
					this.cecaelia.setSpeed(0.0F);
					return;
				}

				double d0 = this.wantedX - this.cecaelia.getX();
				double d1 = this.wantedY - this.cecaelia.getY();
				double d2 = this.wantedZ - this.cecaelia.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
				d1 /= d3;
				float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
				this.cecaelia.setYRot(this.rotlerp(this.cecaelia.getYRot(), f, 90.0F));
				this.cecaelia.yBodyRot = this.cecaelia.getYRot();
				float f1 = (float) (this.speedModifier * this.cecaelia.getAttributeValue(Attributes.MOVEMENT_SPEED));
				float f2 = Mth.lerp(0.125F, this.cecaelia.getSpeed(), f1);
				this.cecaelia.setSpeed(f2);
				this.cecaelia.setDeltaMovement(this.cecaelia.getDeltaMovement().add((double) f2 * d0 * 0.005D, (double) f2 * d1 * 0.1D, (double) f2 * d2 * 0.005D));
			} else {
				if (!this.cecaelia.onGround) {
					this.cecaelia.setDeltaMovement(this.cecaelia.getDeltaMovement().add(0.0D, -0.008D, 0.0D));
				}

				super.tick();
			}
		}
	}
}