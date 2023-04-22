package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Valkyrie extends AbstractAssistGaiaEntity implements IDayMob, PowerableMob {
	private static final EntityDataAccessor<Boolean> IS_BUFFED = SynchedEntityData.defineId(Valkyrie.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ANNOYED = SynchedEntityData.defineId(Valkyrie.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> ANIMATION_STATE = SynchedEntityData.defineId(Valkyrie.class, EntityDataSerializers.INT);
	private final MeleeAttackGoal meleeAttackGoal = new MeleeAttackGoal(this, SharedEntityData.ATTACK_SPEED_3, true);


	private int aggression;
	private int aggressive;

	private int buffEffect;
	private boolean animationPlay;
	private int animationTimer;

	public Valkyrie(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_3;

		aggression = 0;
		aggressive = 0;

		buffEffect = 0;
		animationPlay = false;
		animationTimer = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth3())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_3)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage3())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_3)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_3)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 3;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(IS_BUFFED, false);
		this.entityData.define(ANNOYED, false);
		this.entityData.define(ANIMATION_STATE, 0);
	}

	public boolean isBuffed() {
		return this.entityData.get(IS_BUFFED);
	}

	public void setBuffed(boolean isBuffed) {
		this.entityData.set(IS_BUFFED, isBuffed);
	}

	public boolean isAnnoyed() {
		return this.entityData.get(ANNOYED);
	}

	public void setAnnoyed(boolean value) {
		this.entityData.set(ANNOYED, value);
	}

	public int getAnimationState() {
		return this.entityData.get(ANIMATION_STATE);
	}

	public void setAnimationState(int state) {
		this.entityData.set(ANIMATION_STATE, state);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense3();
	}

	public boolean isArmored() {
		return getHealth() <= this.getMaxHealth() / 2.0F;
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			if (entityIn instanceof LivingEntity livingEntity) {
				int effectTime = 0;
				int effectTime2 = 0;

				if (level.getDifficulty() == Difficulty.NORMAL) {
					effectTime = 20;
					effectTime2 = 10;
				} else if (level.getDifficulty() == Difficulty.HARD) {
					effectTime = 30;
					effectTime2 = 20;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime * 20, 0));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, effectTime2 * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		Vec3 motion = this.getDeltaMovement();
		if (!this.onGround && motion.y < 0.0D) {
			this.setDeltaMovement(motion.multiply(1.0D, 0.6D, 1.0D));
		}

		if (!level.isClientSide && isPassenger()) {
			stopRiding();
		}

		/* AGGRESSION */
		if (!isAnnoyed()) {
			if (aggressive <= 4) {
				if (playerDetection(6, TargetingConditions.forCombat())) {
					if (aggression <= 60) {
						aggression += 1;
					} else {
						aggression = 0;
						aggressive += 1;
					}

					if (aggression >= 50) {
						level.broadcastEntityEvent(this, (byte) 11);
					}
				}
			} else {
				setAnnoyed(true);

				setGoals(0);
				setGoals(1);
				giveShield();
			}
		}

		if (getHealth() < getMaxHealth() && !isAnnoyed()) {
			setAnnoyed(true);

			setGoals(0);
			setGoals(1);
			giveShield();
		}
		/* AGGRESSION */

		/* BUFF */
		if (getHealth() <= getMaxHealth() * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
			setGoals(2);
			setAnimationState(1);
			setBuffed(true);
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
				setBuffed(false);
				setGoals(1);
				setAnimationState(0);
				animationPlay = false;
			}
		}
		/* BUFF */

		if (isDeadOrDying()) {
			for (int i = 0; i < 2; ++i) {
				level.addParticle(ParticleTypes.EXPLOSION,
						getX() + (random.nextDouble() - 0.5D) * getBbWidth(),
						getY() + random.nextDouble() * getBbHeight(),
						getZ() + (random.nextDouble() - 0.5D) * getBbWidth(), 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.aiStep();
		}
	}

	private void setGoals(int id) {
		if (level.isClientSide) return;

		if (id == 2) {
			this.goalSelector.removeGoal(meleeAttackGoal);
		} else if (id == 1) {
			this.goalSelector.addGoal(1, meleeAttackGoal);
		} else {
			this.targetSelector.addGoal(2, targetPlayerGoal);
		}
	}

	private void giveShield() {
		ItemStack shield = new ItemStack(GaiaRegistry.IRON_SHIELD.get());
		setItemSlot(EquipmentSlot.OFFHAND, shield);
	}

	private void setBuff() {
		level.broadcastEntityEvent(this, (byte) 7);
		addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 60, 0));
		addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 60, 0));
	}

	private void setCombatTask() {
		this.goalSelector.removeGoal(meleeAttackGoal);
		this.targetSelector.removeGoal(targetPlayerGoal);
		if (isAnnoyed()) {
			setGoals(0);
			setGoals(1);
		}
	}

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
		populateDefaultEquipmentEnchantments(instance);

		ItemStack swimmingBoots = new ItemStack(Items.LEATHER_BOOTS);
		setItemSlot(EquipmentSlot.FEET, swimmingBoots);
		swimmingBoots.enchant(Enchantments.DEPTH_STRIDER, 3);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		setGoals(1);

		if (random.nextInt(4) == 0) {
			setVariant(1);
		}
		if (random.nextInt(10) == 0) {
			setBaby(true);
		}
		this.populateDefaultEquipmentSlots(difficultyInstance);

		setCombatTask();

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("annoyed", isAnnoyed());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("annoyed")) {
			setAnnoyed(tag.getBoolean("annoyed"));
		}
		setCombatTask();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.VALKYRIE.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.VALKYRIE.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.VALKYRIE.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_3;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	protected MovementEmission getMovementEmission() {
		return MovementEmission.NONE;
	}

	public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
		return false;
	}

	protected void checkFallDamage(double p_27754_, boolean p_27755_, BlockState state, BlockPos pos) {
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	public static boolean checkValkyrieSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	@Override
	public boolean isPowered() {
		return getHealth() < getMaxHealth() / 2.0F;
	}
}