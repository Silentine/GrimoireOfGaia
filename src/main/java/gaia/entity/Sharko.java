package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
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

import java.util.Random;

public class Sharko extends AbstractGaiaEntity {
	private static final EntityDataAccessor<Integer> ANIMATION_STATE = SynchedEntityData.defineId(Sharko.class, EntityDataSerializers.INT);
	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, true);
	protected final WaterBoundPathNavigation waterNavigation;
	protected final GroundPathNavigation groundNavigation;
	private int buffEffect;
	private boolean animationPlay;
	private int animationTimer;

	private byte inWaterTimer;

	public Sharko(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new SharkoMoveControl(this);

		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;
		this.setPathfindingMalus(BlockPathTypes.WATER, 8.0F);

		buffEffect = 0;
		animationPlay = false;
		animationTimer = 0;

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
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth2())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_RANGED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage2())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_2)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 2;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ANIMATION_STATE, 0);
	}

	public int getAnimationState() {
		return this.entityData.get(ANIMATION_STATE);
	}

	public void setAnimationState(int state) {
		this.entityData.set(ANIMATION_STATE, state);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			if (entityIn instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (this.level.getDifficulty() == Difficulty.NORMAL) {
					effectTime = 10;
				} else if (this.level.getDifficulty() == Difficulty.HARD) {
					effectTime = 20;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime * 20, 0));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, effectTime * 20, 2));
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
			if (isPassenger()) {
				stopRiding();
			}

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

		/* BUFF */
		if (getHealth() <= getMaxHealth() * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
			setGoals(1);
			setAnimationState(1);
			buffEffect = 1;
			animationPlay = true;
		}

		if (getHealth() > getMaxHealth() * 0.25F && buffEffect == 1) {
			buffEffect = 0;
			animationPlay = false;
			animationTimer = 0;
		}

		if (animationPlay) {
			if (animationTimer != 15) {
				animationTimer += 1;
			} else {
				setBuff();
				setGoals(0);
				setAnimationState(0);
				animationPlay = false;
			}
		}

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(mobAttackGoal);
		} else {
			this.goalSelector.addGoal(1, mobAttackGoal);
		}
	}

	private void setBuff() {
		level.broadcastEntityEvent(this, (byte) 7);
		addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 60, 0));
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

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
		setItemSlot(EquipmentSlot.FEET, bootsSwimming);
	}

	@Override
	protected void populateDefaultEquipmentEnchantments(DifficultyInstance instance) {
		super.populateDefaultEquipmentEnchantments(instance);
		getItemBySlot(EquipmentSlot.FEET).enchant(Enchantments.DEPTH_STRIDER, 2);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		setGoals(0);

		this.populateDefaultEquipmentSlots(difficultyInstance);
		this.populateDefaultEquipmentEnchantments(difficultyInstance);

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("AnimationState", getAnimationState());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("AnimationState")) {
			setAnimationState(tag.getInt("AnimationState"));
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.SHARKO.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.SHARKO.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.SHARKO.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_UNDERGROUND;
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
	protected int getFireImmuneTicks() {
		return 10;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader reader) {
		return reader.isUnobstructed(this);
	}

	public static boolean checkSharkoSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		boolean daysPassed = checkDaysPassed(levelAccessor);
		boolean isNight = !checkDaytime(levelAccessor);
		boolean inWater = checkInWater(levelAccessor, pos, 20);
		boolean darkEnough = isDarkEnoughToSpawn(levelAccessor, pos, random);
		boolean notPeaceful = checkNotPeaceful(levelAccessor);
		boolean matchRandom = random.nextInt(30) == 0;

		return daysPassed && isNight && inWater && darkEnough && notPeaceful & matchRandom;


	}

	static class SharkoMoveControl extends MoveControl {
		private final Sharko sharko;

		public SharkoMoveControl(Sharko mermaid) {
			super(mermaid);
			this.sharko = mermaid;
		}

		public void tick() {
			LivingEntity livingentity = this.sharko.getTarget();
			if (this.sharko.wantsToSwim() && this.sharko.isInWater()) {
				if (livingentity != null && livingentity.getY() > this.sharko.getY()) {
					this.sharko.setDeltaMovement(this.sharko.getDeltaMovement().add(0.0D, 0.002D, 0.0D));
				}

				if (this.operation != MoveControl.Operation.MOVE_TO || this.sharko.getNavigation().isDone()) {
					this.sharko.setSpeed(0.0F);
					return;
				}

				double d0 = this.wantedX - this.sharko.getX();
				double d1 = this.wantedY - this.sharko.getY();
				double d2 = this.wantedZ - this.sharko.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
				d1 /= d3;
				float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
				this.sharko.setYRot(this.rotlerp(this.sharko.getYRot(), f, 90.0F));
				this.sharko.yBodyRot = this.sharko.getYRot();
				float f1 = (float) (this.speedModifier * this.sharko.getAttributeValue(Attributes.MOVEMENT_SPEED));
				float f2 = Mth.lerp(0.125F, this.sharko.getSpeed(), f1);
				this.sharko.setSpeed(f2);
				this.sharko.setDeltaMovement(this.sharko.getDeltaMovement().add((double) f2 * d0 * 0.005D, (double) f2 * d1 * 0.1D, (double) f2 * d2 * 0.005D));
			} else {
				if (!this.sharko.onGround) {
					this.sharko.setDeltaMovement(this.sharko.getDeltaMovement().add(0.0D, -0.008D, 0.0D));
				}

				super.tick();
			}
		}
	}
}