package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class EnderDragonGirl extends AbstractAssistGaiaEntity {
	private static final UUID SPEED_MODIFIER_ATTACKING_UUID = UUID.fromString("411AF4FD-812A-4D90-802A-6FD57A7777C2");
	private static final AttributeModifier SPEED_MODIFIER_ATTACKING = new AttributeModifier(SPEED_MODIFIER_ATTACKING_UUID, "Attacking speed boost", SharedEntityData.ATTACK_SPEED_BOOST, AttributeModifier.Operation.ADDITION);
	private static final EntityDataAccessor<Boolean> SCREAMING = SynchedEntityData.defineId(EnderDragonGirl.class, EntityDataSerializers.BOOLEAN);
	private int targetChangeTime;

	public EnderDragonGirl(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MobAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new EnderDragonGirl.LookForPlayerGoal(this, this::isAngryAt));
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
	}

	public boolean isAngryAt(LivingEntity livingEntity) {
		if (!this.canAttack(livingEntity)) {
			return false;
		} else {
			return this.getTarget() != null && livingEntity.getType() == EntityType.PLAYER;
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 80.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_2)

				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 2;
	}

	@Override
	public void setTarget(@Nullable LivingEntity livingEntity) {
		AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
		if (livingEntity == null) {
			this.targetChangeTime = 0;
			this.entityData.set(SCREAMING, false);
			attributeinstance.removeModifier(SPEED_MODIFIER_ATTACKING);
		} else {
			this.targetChangeTime = this.tickCount;
			this.entityData.set(SCREAMING, true);
			if (!attributeinstance.hasModifier(SPEED_MODIFIER_ATTACKING)) {
				attributeinstance.addTransientModifier(SPEED_MODIFIER_ATTACKING);
			}
		}

		super.setTarget(livingEntity);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SCREAMING, false);
	}

	public boolean isScreaming() {
		return this.entityData.get(SCREAMING);
	}

	public boolean hurt(DamageSource source, float damage) {
		float input = getBaseDamage(source, damage);
		if (this.isInvulnerableTo(source)) {
			return false;
		} else if (source instanceof IndirectEntityDamageSource) {
			Entity entity = source.getDirectEntity();
			boolean flag1;
			if (entity instanceof ThrownPotion) {
				flag1 = this.hurtWithCleanWater(source, (ThrownPotion) entity, input);
			} else {
				flag1 = false;
			}

			for (int i = 0; i < 64; ++i) {
				if (this.teleportRandomly()) {
					return true;
				}
			}

			return flag1;
		} else {
			boolean flag = super.hurt(source, input);
			if (!this.level.isClientSide() && !(source.getEntity() instanceof LivingEntity) && this.random.nextInt(10) != 0) {
				this.teleportRandomly();
			}

			return flag;
		}
	}

	private boolean hurtWithCleanWater(DamageSource damageSource, ThrownPotion thrownPotion, float damage) {
		ItemStack itemstack = thrownPotion.getItem();
		Potion potion = PotionUtils.getPotion(itemstack);
		List<MobEffectInstance> list = PotionUtils.getMobEffects(itemstack);
		boolean flag = potion == Potions.WATER && list.isEmpty();
		return flag && super.hurt(damageSource, damage);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	public void aiStep() {
		if (!this.level.isClientSide) {
			for (int i = 0; i < 2; ++i) {
				this.level.addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
			}
		}

		this.jumping = false;

		super.aiStep();
	}

	protected void customServerAiStep() {
		if (isInWaterOrRain()) {
			hurt(DamageSource.DROWN, 1.0F);
		}

		if (this.level.isDay() && this.tickCount >= this.targetChangeTime + 600) {
			float f = this.getLightLevelDependentMagicValue();
			if (f > 0.5F && this.level.canSeeSky(this.blockPosition()) && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
				this.setTarget((LivingEntity) null);
				this.teleportRandomly();
			}
		}

		super.customServerAiStep();
	}

	public boolean shouldAttackPlayer(Player player) {
		ItemStack itemstack = player.getInventory().armor.get(3);
		if (itemstack.isEnderMask(player, null)) {
			return false;
		} else {
			Vec3 vec3 = player.getViewVector(1.0F).normalize();
			Vec3 vec31 = new Vec3(this.getX() - player.getX(), this.getEyeY() - player.getEyeY(), this.getZ() - player.getZ());
			double d0 = vec31.length();
			vec31 = vec31.normalize();
			double d1 = vec3.dot(vec31);
			return d1 > 1.0D - 0.025D / d0 && player.hasLineOfSight(this);
		}
	}

	protected boolean teleportRandomly() {
		if (!this.level.isClientSide() && this.isAlive()) {
			double d0 = this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
			double d1 = this.getY() + (double) (this.random.nextInt(64) - 32);
			double d2 = this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
			return this.teleport(d0, d1, d2);
		} else {
			return false;
		}
	}

	private boolean teleport(double x, double y, double z) {
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

		while (blockpos$mutableblockpos.getY() > this.level.getMinBuildHeight() && !this.level.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMotion()) {
			blockpos$mutableblockpos.move(Direction.DOWN);
		}

		BlockState blockstate = this.level.getBlockState(blockpos$mutableblockpos);
		boolean flag = blockstate.getMaterial().blocksMotion();
		boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
		if (flag && !flag1) {
			net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, x, y, z);
			if (event.isCanceled()) return false;
			boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
			if (flag2 && !this.isSilent()) {
				this.level.playSound((Player) null, this.xo, this.yo, this.zo, GaiaSounds.ENDER_DRAGON_GIRL_TELEPORT.get(), this.getSoundSource(), 1.0F, 1.0F);
				this.playSound(GaiaSounds.ENDER_DRAGON_GIRL_TELEPORT.get(), 1.0F, 1.0F);
			}

			return flag2;
		} else {
			return false;
		}
	}

	boolean teleportTowards(Entity entity) {
		Vec3 vec3 = new Vec3(this.getX() - entity.getX(), this.getY(0.5D) - entity.getEyeY(), this.getZ() - entity.getZ());
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3.x * 16.0D;
		double d2 = this.getY() + (double) (this.random.nextInt(16) - 8) - vec3.y * 16.0D;
		double d3 = this.getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3.z * 16.0D;
		return this.teleport(d1, d2, d3);
	}

	public boolean causeFallDamage(float distance, float multiplier, DamageSource source) {
		return false;
	}

	protected void checkFallDamage(double p_27754_, boolean p_27755_, BlockState state, BlockPos pos) {
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return isScreaming() ? GaiaSounds.ENDER_DRAGON_GIRL_SCREAM.get() : GaiaRegistry.ENDER_DRAGON_GIRL.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.ENDER_DRAGON_GIRL.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.ENDER_DRAGON_GIRL.getDeath();
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
	public boolean fireImmune() {
		return true;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkEnderDragonGirlSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkAnyLightMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	static class LookForPlayerGoal extends NearestAttackableTargetGoal<Player> {
		private final EnderDragonGirl enderDragonGirl;
		@Nullable
		private Player pendingTarget;
		private int aggroTime;
		private int teleportTime;
		private final TargetingConditions startAggroTargetConditions;
		private final TargetingConditions continueAggroTargetConditions = TargetingConditions.forCombat().ignoreLineOfSight();

		public LookForPlayerGoal(EnderDragonGirl enderDragonGirl, @Nullable Predicate<LivingEntity> livingEntityPredicate) {
			super(enderDragonGirl, Player.class, 10, false, false, livingEntityPredicate);
			this.enderDragonGirl = enderDragonGirl;
			this.startAggroTargetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector((livingEntity) -> {
				return enderDragonGirl.shouldAttackPlayer((Player) livingEntity);
			});
		}

		public boolean canUse() {
			this.pendingTarget = this.enderDragonGirl.level.getNearestPlayer(this.startAggroTargetConditions, this.enderDragonGirl);
			return this.pendingTarget != null;
		}

		public void start() {
			this.aggroTime = this.adjustedTickDelay(5);
			this.teleportTime = 0;
		}

		public void stop() {
			this.pendingTarget = null;
			super.stop();
		}

		public boolean canContinueToUse() {
			if (this.pendingTarget != null) {
				if (!this.enderDragonGirl.shouldAttackPlayer(this.pendingTarget)) {
					return false;
				} else {
					this.enderDragonGirl.lookAt(this.pendingTarget, 10.0F, 10.0F);
					return true;
				}
			} else {
				return this.target != null && this.continueAggroTargetConditions.test(this.enderDragonGirl, this.target) || super.canContinueToUse();
			}
		}

		public void tick() {
			if (this.enderDragonGirl.getTarget() == null) {
				super.setTarget((LivingEntity) null);
			}

			if (this.pendingTarget != null) {
				if (--this.aggroTime <= 0) {
					this.target = this.pendingTarget;
					this.pendingTarget = null;
					super.start();
				}
			} else {
				if (this.target != null && !this.enderDragonGirl.isPassenger()) {
					if (this.enderDragonGirl.shouldAttackPlayer((Player) this.target)) {
						if (this.target.distanceToSqr(this.enderDragonGirl) < 16.0D) {
							this.enderDragonGirl.teleportRandomly();
						}

						this.teleportTime = 0;
					} else if (this.target.distanceToSqr(this.enderDragonGirl) > 256.0D && this.teleportTime++ >= this.adjustedTickDelay(30) && this.enderDragonGirl.teleportTowards(this.target)) {
						this.teleportTime = 0;
					}
				}

				super.tick();
			}

		}
	}
}