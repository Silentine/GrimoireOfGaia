package gaia.entity;

import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PowerableMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class Behender extends AbstractGaiaEntity implements RangedAttackMob, PowerableMob {
	private int teleportTimer;

	public Behender(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;

		teleportTimer = 0;

		this.moveControl = new FlyingMoveControl(this, 20, true);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, 20, 60, 15.0F));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(Behender.class));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth2())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_RANGED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.FLYING_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage2())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.5D)

				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 2;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	protected PathNavigation createNavigation(Level level) {
		FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, level) {
			public boolean isStableDestination(BlockPos pos) {
				return !this.level.getBlockState(pos.below()).isAir();
			}

			public void tick() {
				super.tick();
			}
		};
		flyingpathnavigation.setCanOpenDoors(false);
		flyingpathnavigation.setCanFloat(false);
		flyingpathnavigation.setCanPassDoors(true);
		return flyingpathnavigation;
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
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			List<MobEffect> effects = List.of(MobEffects.MOVEMENT_SPEED, MobEffects.MOVEMENT_SLOWDOWN,
					MobEffects.DIG_SPEED, MobEffects.DIG_SLOWDOWN, MobEffects.DAMAGE_BOOST, MobEffects.HEAL,
					MobEffects.HARM, MobEffects.JUMP, MobEffects.CONFUSION);
			RangedUtil.magicRandom(target, this, distanceFactor, 0.5D, effects.get(random.nextInt(effects.size())));
		}
	}

	@Override
	public boolean canAttackType(EntityType<?> type) {
		return super.canAttackType(type) && type != GaiaRegistry.BEHENDER.getEntityType();
	}

	@Override
	public void aiStep() {
		if (!level.isClientSide && isPassenger()) {
			stopRiding();
		}

		if (level.isClientSide) {
			for (int i = 0; i < 2; ++i) {
				level.addParticle(ParticleTypes.PORTAL,
						getX() + (random.nextDouble() - 0.5D) * getBbWidth(),
						getY() + random.nextDouble() * getBbHeight(),
						getZ() + (random.nextDouble() - 0.5D) * getBbWidth(), 0.0D, 0.0D, 0.0D);
			}
		}

		if (!level.isClientSide && playerDetection(4, TargetingConditions.forNonCombat())) {
			if (teleportTimer < 60) {
				teleportTimer++;
			} else {
				teleportRandomly();
				teleportTimer = 0;
			}
		}

		super.aiStep();
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
				this.level.playSound((Player) null, this.xo, this.yo, this.zo, GaiaSounds.BEHENDER_TELEPORT.get(), this.getSoundSource(), 1.0F, 1.0F);
				this.playSound(GaiaSounds.BEHENDER_TELEPORT.get(), 1.0F, 1.0F);
			}

			return flag2;
		} else {
			return false;
		}
	}

	public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
		return false;
	}

	protected void checkFallDamage(double p_27754_, boolean p_27755_, BlockState state, BlockPos pos) {
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

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
		return GaiaRegistry.BEHENDER.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.BEHENDER.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.BEHENDER.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkBehenderSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}