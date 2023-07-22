package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class GraveMite extends PathfinderMob {
	private static final int MAX_LIFE = 2400;
	private int life;

	public GraveMite(EntityType<? extends PathfinderMob> entityType, Level level) {
		super(entityType, level);

		xpReward = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
		return 0.13F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 1.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.25D)
				.add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	protected Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.EVENTS;
	}

	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.GRAVEMITE.getSay();
	}

	protected SoundEvent getHurtSound(DamageSource source) {
		return GaiaRegistry.GRAVEMITE.getHurt();
	}

	protected SoundEvent getDeathSound() {
		return GaiaRegistry.GRAVEMITE.getDeath();
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(GaiaRegistry.GRAVEMITE.getStep(), 0.15F, 1.0F);
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.life = tag.getInt("Lifetime");
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Lifetime", this.life);
	}

	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Override
	public void aiStep() {
		super.aiStep();

		if (!this.level.isClientSide && isPassenger()) {
			stopRiding();
		}

		if (!this.level.isClientSide) {
			if (!this.isPersistenceRequired()) {
				++this.life;
			}

			if (this.life >= MAX_LIFE) {
				this.discard();
			}
		}
	}

	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return effectInstance.getEffect() != MobEffects.POISON && super.canBeAffected(effectInstance);
	}

	public static boolean checkMiteSpawnRules(EntityType<? extends PathfinderMob> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return (GaiaConfig.COMMON.disableYRestriction.get() || pos.getY() > levelAccessor.getSeaLevel()) &&
				checkMobSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}
