package gaia.entity;

import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class Banshee extends AbstractGaiaEntity {
	protected static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Banshee.class, EntityDataSerializers.BYTE);

	@Nullable
	private BlockPos boundOrigin;

	public Banshee(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new BansheeMoveControl(this);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;
	}

	public void move(MoverType moverType, Vec3 pos) {
		super.move(moverType, pos);
		this.checkInsideBlocks();
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));

		this.goalSelector.addGoal(1, new BansheeChargeAttackGoal(this));
		this.goalSelector.addGoal(2, new BansheeRandomMoveGoal(this));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, LivingEntity.class, 8.0F));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 80.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
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
		this.entityData.define(DATA_FLAGS_ID, (byte) 0);
	}

	@Nullable
	public BlockPos getBoundOrigin() {
		return this.boundOrigin;
	}

	public void setBoundOrigin(@Nullable BlockPos pos) {
		this.boundOrigin = pos;
	}

	private boolean getBansheeFlag(int mask) {
		int i = this.entityData.get(DATA_FLAGS_ID);
		return (i & mask) != 0;
	}

	private void setBansheeFlag(int mask, boolean value) {
		int i = this.entityData.get(DATA_FLAGS_ID);
		if (value) {
			i |= mask;
		} else {
			i &= ~mask;
		}

		this.entityData.set(DATA_FLAGS_ID, (byte) (i & 255));
	}

	public boolean isCharging() {
		return this.getBansheeFlag(1);
	}

	public void setIsCharging(boolean charging) {
		this.setBansheeFlag(1, charging);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = getBaseDamage(source, damage);
		Entity entity = source.getDirectEntity();

		if (entity instanceof Arrow) {
			input += 2;
		}

		if (entity instanceof SpectralArrow) {
			input += 4;
		}

		return super.hurt(source, input);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			entityIn.setSecondsOnFire(6);

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void tick() {
		this.noPhysics = true;
		super.tick();
		this.noPhysics = false;
		this.setNoGravity(true);
	}

	@Override
	public void aiStep() {
		if (!this.level().isClientSide) {
			if (isPassenger()) {
				stopRiding();
			}

			if (this.isAlive() && this.isSunBurnTick()) {
				this.level().broadcastEntityEvent(this, (byte) 11);
				hurt(damageSources().fellOutOfWorld(), getMaxHealth() * 0.25F);
			}
		}

		for (int i = 0; i < 2; ++i) {
			this.level().addParticle(ParticleTypes.PORTAL,
					getX() + (random.nextDouble() - 0.5D) * getBbWidth(),
					getY() + random.nextDouble() * getBbHeight(),
					getZ() + (random.nextDouble() - 0.5D) * getBbWidth(), 0.0D, 0.0D, 0.0D);
		}

		super.aiStep();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		if (this.boundOrigin != null) {
			tag.putInt("BoundX", this.boundOrigin.getX());
			tag.putInt("BoundY", this.boundOrigin.getY());
			tag.putInt("BoundZ", this.boundOrigin.getZ());
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("BoundX")) {
			this.boundOrigin = new BlockPos(tag.getInt("BoundX"), tag.getInt("BoundY"), tag.getInt("BoundZ"));
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.BANSHEE.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.BANSHEE.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.BANSHEE.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkBansheeSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}

	static class BansheeMoveControl extends MoveControl {

		public BansheeMoveControl(Banshee banshee) {
			super(banshee);
		}

		public void tick() {
			if (this.operation == MoveControl.Operation.MOVE_TO) {
				Vec3 vec3 = new Vec3(this.wantedX - this.mob.getX(), this.wantedY - this.mob.getY(), this.wantedZ - this.mob.getZ());
				double d0 = vec3.length();
				if (d0 < this.mob.getBoundingBox().getSize()) {
					this.operation = MoveControl.Operation.WAIT;
					this.mob.setDeltaMovement(this.mob.getDeltaMovement().scale(0.5D));
				} else {
					this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(vec3.scale(this.speedModifier * 0.05D / d0)));
					if (this.mob.getTarget() == null) {
						Vec3 vec31 = this.mob.getDeltaMovement();
						this.mob.setYRot(-((float) Mth.atan2(vec31.x, vec31.z)) * (180F / (float) Math.PI));
						this.mob.yBodyRot = this.mob.getYRot();
					} else {
						double d2 = this.mob.getTarget().getX() - this.mob.getX();
						double d1 = this.mob.getTarget().getZ() - this.mob.getZ();
						this.mob.setYRot(-((float) Mth.atan2(d2, d1)) * (180F / (float) Math.PI));
						this.mob.yBodyRot = this.mob.getYRot();
					}
				}
			}
		}
	}


	static class BansheeChargeAttackGoal extends Goal {
		protected final Banshee banshee;

		public BansheeChargeAttackGoal(Banshee banshee) {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			this.banshee = banshee;
		}

		public boolean canUse() {
			if (this.banshee.getTarget() != null && !this.banshee.getMoveControl().hasWanted() && this.banshee.getRandom().nextInt(reducedTickDelay(7)) == 0) {
				return this.banshee.distanceToSqr(this.banshee.getTarget()) > 4.0D;
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			return this.banshee.getMoveControl().hasWanted() && this.banshee.isCharging() && this.banshee.getTarget() != null && this.banshee.getTarget().isAlive();
		}

		public void start() {
			LivingEntity livingentity = this.banshee.getTarget();
			if (livingentity != null) {
				Vec3 vec3 = livingentity.getEyePosition();
				this.banshee.getMoveControl().setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0D);
			}

			this.banshee.setIsCharging(true);
			this.banshee.playSound(SoundEvents.VEX_CHARGE, 1.0F, 1.0F);
		}

		public void stop() {
			this.banshee.setIsCharging(false);
		}

		public boolean requiresUpdateEveryTick() {
			return true;
		}

		public void tick() {
			LivingEntity livingentity = this.banshee.getTarget();
			if (livingentity != null) {
				if (this.banshee.getBoundingBox().intersects(livingentity.getBoundingBox())) {
					this.banshee.doHurtTarget(livingentity);
					this.banshee.setIsCharging(false);
				} else {
					double d0 = this.banshee.distanceToSqr(livingentity);
					if (d0 < 9.0D) {
						Vec3 vec3 = livingentity.getEyePosition();
						this.banshee.getMoveControl().setWantedPosition(vec3.x, vec3.y, vec3.z, 1.0D);
					}
				}

			}
		}
	}

	static class BansheeRandomMoveGoal extends Goal {
		protected final Banshee banshee;

		public BansheeRandomMoveGoal(Banshee banshee) {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
			this.banshee = banshee;
		}

		public boolean canUse() {
			return !this.banshee.getMoveControl().hasWanted() && this.banshee.getRandom().nextInt(reducedTickDelay(7)) == 0;
		}

		public boolean canContinueToUse() {
			return false;
		}

		public void tick() {
			BlockPos blockpos = this.banshee.getBoundOrigin();
			if (blockpos == null) {
				blockpos = this.banshee.blockPosition();
			}

			for (int i = 0; i < 3; ++i) {
				BlockPos blockpos1 = blockpos.offset(this.banshee.random.nextInt(15) - 7, this.banshee.random.nextInt(11) - 5, this.banshee.random.nextInt(15) - 7);
				if (this.banshee.level().isEmptyBlock(blockpos1)) {
					this.banshee.getMoveControl().setWantedPosition((double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 0.5D, (double) blockpos1.getZ() + 0.5D, 0.25D);
					if (this.banshee.getTarget() == null) {
						this.banshee.getLookControl().setLookAt((double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 0.5D, (double) blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
					}
					break;
				}
			}

		}
	}
}