package gaia.entity;

import gaia.GrimoireOfGaia;
import gaia.config.GaiaConfig;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import org.jspecify.annotations.Nullable;

public class EnderEye extends AbstractAssistGaiaEntity {
	private static final Identifier SPEED_ID = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "ender_eye_speed");
	private static final AttributeModifier SPEED_MODIFIER_ATTACKING = new AttributeModifier(SPEED_ID, SharedEntityData.ATTACK_SPEED_BOOST, AttributeModifier.Operation.ADD_VALUE);
	private static final EntityDataAccessor<Boolean> SCREAMING = SynchedEntityData.defineId(EnderEye.class, EntityDataSerializers.BOOLEAN);

	private int targetChangeTime;

	public EnderEye(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		this.moveControl = new FlyingMoveControl(this, 20, true);
		this.setPathfindingMalus(PathType.WATER, -1.0F);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.0F));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new FloatGoal(this));
		this.targetSelector.addGoal(1, new LookForPlayerGoal(this, this::isAngryAt));
		this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
	}

	@Override
	public boolean isAngryAt(LivingEntity entity, ServerLevel level) {
		if (!this.canAttack(entity)) {
			return false;
		} else {
			return this.getTarget() != null && entity.getType() == EntityType.PLAYER;
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
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.FLYING_SPEED, 0.35D)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_1)

				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}

	@Override
	public void setTarget(@Nullable LivingEntity livingEntity) {
		AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
		if (livingEntity == null) {
			this.targetChangeTime = 0;
			this.entityData.set(SCREAMING, false);
			attributeinstance.removeModifier(SPEED_ID);
		} else {
			this.targetChangeTime = this.tickCount;
			this.entityData.set(SCREAMING, true);
			if (!attributeinstance.hasModifier(SPEED_ID)) {
				attributeinstance.addTransientModifier(SPEED_MODIFIER_ATTACKING);
			}
		}

		super.setTarget(livingEntity);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(SCREAMING, false);
	}

	public boolean isScreaming() {
		return this.entityData.get(SCREAMING);
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		if (this.isInvulnerableTo(level, source)) {
			return false;
		} else if (!source.isDirect()) {
			Entity entity = source.getDirectEntity();
			boolean flag1;
			if (entity instanceof AbstractThrownPotion thrownPotion) {
				flag1 = this.hurtWithCleanWater(level, source, thrownPotion, damage);
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
			boolean flag = super.hurtServer(level, source, damage);
			if (!this.level().isClientSide() && !(source.getEntity() instanceof LivingEntity) && this.random.nextInt(10) != 0) {
				this.teleportRandomly();
			}

			return flag;
		}
	}

	private boolean hurtWithCleanWater(ServerLevel level, DamageSource pSource, AbstractThrownPotion pPotion, float pAmount) {
		ItemStack itemstack = pPotion.getItem();
		PotionContents potioncontents = itemstack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
		return potioncontents.is(Potions.WATER) && super.hurtServer(level, pSource, pAmount);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public void aiStep() {
		if (!this.level().isClientSide() && isPassenger()) {
			stopRiding();
		}

		Vec3 motion = this.getDeltaMovement();
		if (!this.onGround() && motion.y < 0.0D) {
			this.setDeltaMovement(motion.multiply(1.0D, 0.6D, 1.0D));
		}

		for (int i = 0; i < 2; ++i) {
			this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
		}

		this.jumping = false;

		super.aiStep();
	}

	@Override
	protected void customServerAiStep(ServerLevel level) {
		if (isInWaterOrRain()) {
			hurt(damageSources().drown(), 1.0F);
		}

		if (level.isBrightOutside() && this.tickCount >= this.targetChangeTime + 600) {
			float f = this.getLightLevelDependentMagicValue();
			if (f > 0.5F && level.canSeeSky(this.blockPosition()) && this.random.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
				this.setTarget((LivingEntity) null);
				this.teleportRandomly();
			}
		}

		super.customServerAiStep(level);
	}


	private boolean isBeingStaredBy(Player player) {
		return PLAYER_NOT_WEARING_DISGUISE_ITEM_FOR_TARGET.test(player, this) &&
				this.isLookingAtMe(player, 0.025, true, false, this.getEyeY());
	}

	protected boolean teleportRandomly() {
		if (!this.level().isClientSide() && this.isAlive()) {
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

		while (blockpos$mutableblockpos.getY() > this.level().getMinY() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
			blockpos$mutableblockpos.move(Direction.DOWN);
		}

		BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
		boolean flag = blockstate.blocksMotion();
		boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
		if (flag && !flag1) {
			EntityTeleportEvent.EnderEntity event = EventHooks.onEnderTeleport(this, x, y, z);
			if (event.isCanceled()) return false;
			boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
			if (flag2 && !this.isSilent()) {
				this.level().playSound((Player) null, this.xo, this.yo, this.zo, GaiaSounds.ENDER_EYE_TELEPORT.get(), this.getSoundSource(), 1.0F, 1.0F);
				this.playSound(GaiaSounds.ENDER_EYE_TELEPORT.get(), 1.0F, 1.0F);
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

	@Override
	public boolean causeFallDamage(double fallDistance, float damageModifier, DamageSource damageSource) {
		return false;
	}

	@Override
	protected void checkFallDamage(double p_27754_, boolean p_27755_, BlockState state, BlockPos pos) {
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return isScreaming() ? GaiaSounds.ENDER_EYE_SCREAM.get() : GaiaRegistry.ENDER_EYE.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.ENDER_EYE.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.ENDER_EYE.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkEnderEyeSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkBelowSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	static class LookForPlayerGoal extends NearestAttackableTargetGoal<Player> {
		private final EnderEye enderEye;
		@Nullable
		private Player pendingTarget;
		private int aggroTime;
		private int teleportTime;
		private final TargetingConditions startAggroTargetConditions;
		private final TargetingConditions continueAggroTargetConditions = TargetingConditions.forCombat().ignoreLineOfSight();

		public LookForPlayerGoal(EnderEye enderEye, TargetingConditions.@Nullable Selector livingEntityPredicate) {
			super(enderEye, Player.class, 10, false, false, livingEntityPredicate);
			this.enderEye = enderEye;
			this.startAggroTargetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector((livingEntity, level) -> {
				return enderEye.isBeingStaredBy((Player) livingEntity);
			});
		}

		public boolean canUse() {
			this.pendingTarget = getServerLevel(this.enderEye).getNearestPlayer(this.startAggroTargetConditions, this.enderEye);
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
				if (!this.enderEye.isBeingStaredBy(this.pendingTarget)) {
					return false;
				} else {
					this.enderEye.lookAt(this.pendingTarget, 10.0F, 10.0F);
					return true;
				}
			} else {
				return this.target != null && this.continueAggroTargetConditions.test(getServerLevel(this.enderEye), this.enderEye, this.target) ||
						super.canContinueToUse();
			}
		}

		public void tick() {
			if (this.enderEye.getTarget() == null) {
				super.setTarget((LivingEntity) null);
			}

			if (this.pendingTarget != null) {
				if (--this.aggroTime <= 0) {
					this.target = this.pendingTarget;
					this.pendingTarget = null;
					super.start();
				}
			} else {
				if (this.target != null && !this.enderEye.isPassenger()) {
					if (this.enderEye.isBeingStaredBy((Player) this.target)) {
						if (this.target.distanceToSqr(this.enderEye) < 16.0D) {
							this.enderEye.teleportRandomly();
						}

						this.teleportTime = 0;
					} else if (this.target.distanceToSqr(this.enderEye) > 256.0D && this.teleportTime++ >= this.adjustedTickDelay(30) && this.enderEye.teleportTowards(this.target)) {
						this.teleportTime = 0;
					}
				}

				super.tick();
			}

		}
	}
}