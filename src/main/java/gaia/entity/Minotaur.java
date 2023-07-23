package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
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
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
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

public class Minotaur extends AbstractGaiaEntity implements PowerableMob {
	private static final EntityDataAccessor<Integer> ANIMATION_STATE = SynchedEntityData.defineId(Minotaur.class, EntityDataSerializers.INT);
	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_3, true);

	private int buffEffect;
	private boolean animationPlay;
	private int animationTimer;

	public Minotaur(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		xpReward = SharedEntityData.EXPERIENCE_VALUE_3;

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
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth3())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_3)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage3())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_3)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_3)

				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 5.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 3;
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
		if (state == 0) {
			setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(GaiaRegistry.MINOTAUR_HAMMER.get()));
		} else {
			setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
		}
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense3();
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = getBaseDamage(source, damage);
		if (isPowered()) {
			return !(source instanceof IndirectEntityDamageSource) && super.hurt(source, input);
		}
		return super.hurt(source, input);
	}

	@Override
	public boolean isPowered() {
		return getHealth() < getMaxHealth() / 2.0F;
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			if (entityIn instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (this.level.getDifficulty() == Difficulty.NORMAL) {
					effectTime = 20;
				} else if (this.level.getDifficulty() == Difficulty.HARD) {
					effectTime = 30;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime * 20, 0));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, effectTime * 20, 0));
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

		if (!this.level.isClientSide && isPassenger()) {
			stopRiding();
		}

		if (this.getDeltaMovement().horizontalDistanceSqr() > (double) 2.5000003E-7F && this.random.nextInt(5) == 0) {
			int i = Mth.floor(this.getX());
			int j = Mth.floor(this.getY() - (double) 0.2F);
			int k = Mth.floor(this.getZ());
			BlockPos pos = new BlockPos(i, j, k);
			BlockState blockstate = this.level.getBlockState(pos);
			if (!blockstate.isAir()) {
				this.level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getX() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(), this.getY() + 0.1D, this.getZ() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(), 4.0D * ((double) this.random.nextFloat() - 0.5D), 0.5D, ((double) this.random.nextFloat() - 0.5D) * 4.0D);
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
		if (id == 1) {
			this.goalSelector.removeGoal(mobAttackGoal);
		} else {
			this.goalSelector.addGoal(1, mobAttackGoal);
		}
	}

	private void setCombatTask() {
		this.goalSelector.removeGoal(mobAttackGoal);
		setGoals(0);
	}

	private void setBuff() {
		level.broadcastEntityEvent(this, (byte) 7);
		addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 60, 0));
		addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 60, 0));
	}

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaiaRegistry.MINOTAUR_HAMMER.get()));

		ItemStack swimmingBoots = new ItemStack(Items.LEATHER_BOOTS);
		setItemSlot(EquipmentSlot.FEET, swimmingBoots);
		swimmingBoots.enchant(Enchantments.DEPTH_STRIDER, 2);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		populateDefaultEquipmentSlots(difficultyInstance);
		populateDefaultEquipmentEnchantments(difficultyInstance);

		setCombatTask();

		return data;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	public boolean causeFallDamage(float distance, float multiplier, DamageSource source) {
		return false;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		setCombatTask();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.MINOTAUR.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.MINOTAUR.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.MINOTAUR.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(GaiaRegistry.MINOTAUR.getStep(), 0.15F, 1.0F);
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_3;
	}

	public static boolean checkMinotaurSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}