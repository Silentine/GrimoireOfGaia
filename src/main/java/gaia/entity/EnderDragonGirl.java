package gaia.entity;

import gaia.GrimoireOfGaia;
import gaia.config.GaiaConfig;
import gaia.entity.goal.MobAttackGoal;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import org.jspecify.annotations.Nullable;

public class EnderDragonGirl extends AbstractAssistGaiaEntity {
	private static final Identifier SPEED_ID = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "ender_dragon_speed");
	private static final AttributeModifier SPEED_MODIFIER_ATTACKING = new AttributeModifier(SPEED_ID, SharedEntityData.ATTACK_SPEED_BOOST, AttributeModifier.Operation.ADD_VALUE);
	private static final EntityDataAccessor<Boolean> SCREAMING = SynchedEntityData.defineId(EnderDragonGirl.class, EntityDataSerializers.BOOLEAN);
	private int targetChangeTime;

	public EnderDragonGirl(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		this.setPathfindingMalus(PathType.WATER, -1.0F);
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

	@Override
	public boolean isAngryAt(LivingEntity entity, ServerLevel level) {
		if (!this.canAttack(entity)) {
			return false;
		} else {
			return this.getTarget() != null && entity.getType() == EntityType.PLAYER;
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 80.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_2)

				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.add(Attributes.STEP_HEIGHT, 1.0F);
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

	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		if (this.isInvulnerableTo(level, source)) {
			return false;
		} else if (!source.isDirect()) {
			Entity entity = source.getDirectEntity();
			boolean flag1;
			if (entity instanceof AbstractThrownPotion abstractThrownPotion) {
				flag1 = this.hurtWithCleanWater(level, source, abstractThrownPotion, damage);
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
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	public void aiStep() {
		if (!this.level().isClientSide()) {
			for (int i = 0; i < 2; ++i) {
				this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D);
			}
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
				this.level().playSound((Player) null, this.xo, this.yo, this.zo, GaiaSounds.ENDER_DRAGON_GIRL_TELEPORT.get(), this.getSoundSource(), 1.0F, 1.0F);
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

	@Override
	public boolean causeFallDamage(double fallDistance, float damageModifier, DamageSource damageSource) {
		return false;
	}

	@Override
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
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkEnderDragonGirlSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
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

		public LookForPlayerGoal(EnderDragonGirl enderDragonGirl, TargetingConditions.@Nullable Selector livingEntityPredicate) {
			super(enderDragonGirl, Player.class, 10, false, false, livingEntityPredicate);
			this.enderDragonGirl = enderDragonGirl;
			this.startAggroTargetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector((livingEntity, serverLevel) -> {
				return enderDragonGirl.isBeingStaredBy((Player) livingEntity);
			});
		}

		public boolean canUse() {
			this.pendingTarget = getServerLevel(this.enderDragonGirl).getNearestPlayer(this.startAggroTargetConditions, this.enderDragonGirl);
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
				if (!this.enderDragonGirl.isBeingStaredBy(this.pendingTarget)) {
					return false;
				} else {
					this.enderDragonGirl.lookAt(this.pendingTarget, 10.0F, 10.0F);
					return true;
				}
			} else {
				return this.target != null && this.continueAggroTargetConditions.test(getServerLevel(this.enderDragonGirl), this.enderDragonGirl, this.target) ||
						super.canContinueToUse();
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
					if (this.enderDragonGirl.isBeingStaredBy((Player) this.target)) {
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