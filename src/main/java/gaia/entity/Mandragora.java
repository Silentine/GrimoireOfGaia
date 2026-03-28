package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public class Mandragora extends AbstractGaiaEntity implements IDayMob {
	private static final EntityDataAccessor<Boolean> DATA_BABY_ID = SynchedEntityData.defineId(Mandragora.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_SCREAMING = SynchedEntityData.defineId(Mandragora.class, EntityDataSerializers.BOOLEAN);

	private byte inWaterTimer;

	public Mandragora(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		inWaterTimer = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_0, true));
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_0)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_1)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_BABY_ID, false);
		builder.define(IS_SCREAMING, false);
	}

	public boolean isScreaming() {
		return this.entityData.get(IS_SCREAMING);
	}

	public void setIsScreaming(boolean screaming) {
		this.entityData.set(IS_SCREAMING, screaming);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		if (source.getEntity() instanceof Player player) {
			ItemStack itemstack = player.getItemInHand(player.getUsedItemHand());

			if (itemstack.is(ItemTags.SHOVELS)) {
				damage = damage * 1.5F;
			}
		}

		return super.hurtServer(level, source, damage);
	}

	@Override
	public boolean doHurtTarget(ServerLevel level, Entity target) {
		if (super.doHurtTarget(level, target)) {
			if (target instanceof LivingEntity livingEntity) {
				int effectTime = 0;
				int effectTime2 = 0;

				if (this.level().getDifficulty() == Difficulty.NORMAL) {
					effectTime = 20;
					effectTime2 = 10;
				} else if (this.level().getDifficulty() == Difficulty.HARD) {
					effectTime = 30;
					effectTime2 = 20;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, effectTime * 20, 0));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, effectTime * 20, 0));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, effectTime2 * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		if (isScreaming()) {
			beaconMonster(2, (entity) -> {
				if (entity instanceof Player) {
					entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 100, 0, true, true));
				}
			});
		}

		if (!this.level().isClientSide()) {
			if (isInWater()) {
				if (inWaterTimer <= 100) {
					++inWaterTimer;
				} else {
					this.level().broadcastEntityEvent(this, (byte) 8);
					heal(getMaxHealth() * 0.10F);
					addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 5 * 20, 0));
					inWaterTimer = 0;
				}
			}
		}

		if (this.getDeltaMovement().horizontalDistanceSqr() > (double) 2.5000003E-7F && this.random.nextInt(5) == 0) {
			int i = Mth.floor(this.getX());
			int j = Mth.floor(this.getY() - (double) 0.2F);
			int k = Mth.floor(this.getZ());
			BlockPos pos = new BlockPos(i, j, k);
			BlockState blockstate = this.level().getBlockState(pos);
			if (!blockstate.isAir()) {
				this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate, pos),
						this.getX() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(),
						this.getY() + 0.1D,
						this.getZ() + ((double) this.random.nextFloat() - 0.5D) * (double) this.getBbWidth(),
						4.0D * ((double) this.random.nextFloat() - 0.5D), 0.5D,
						((double) this.random.nextFloat() - 0.5D) * 4.0D
				);
			}
		}

		if (isOnFire()) {
			addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 100, 0));
			addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
		}

		super.aiStep();
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
	                                    EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		setBaby(true);
		setIsScreaming(true);

		return data;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return effectInstance.getEffect() != MobEffects.NAUSEA && super.canBeAffected(effectInstance);
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putBoolean("IsBaby", this.isBaby());
		output.putBoolean("IsScreaming", this.isScreaming());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		this.setBaby(input.getBooleanOr("IsBaby", false));
		this.setIsScreaming(input.getBooleanOr("IsScreaming", false));
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.MANDRAGORA.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.MANDRAGORA.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.MANDRAGORA.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (isBaby() && itemstack.is(Items.BONE_MEAL)) {
			for (int i = 0; i < 16; ++i) {
				this.level().addParticle(ParticleTypes.HAPPY_VILLAGER,
						getX() + (random.nextDouble() - 0.5D) * getBbWidth(),
						getY() + random.nextDouble() * getBbHeight(),
						getZ() + (random.nextDouble() - 0.5D) * getBbWidth(),
						random.nextGaussian() * 0.02D,
						random.nextGaussian() * 0.02D,
						random.nextGaussian() * 0.02D);
			}
			if ((double) random.nextFloat() < 0.45D) {
				if (!this.level().isClientSide()) {
					setBaby(false);

					if (!player.getAbilities().instabuild)
						itemstack.shrink(1);
				}
			}

			return InteractionResult.SUCCESS;
		} else {
			return super.mobInteract(player, hand);
		}
	}

	@Override
	protected void setupFriendGoals(boolean friendly) {
		super.setupFriendGoals(friendly);
		setIsScreaming(false);
	}

	/*
	 * Baby stuff
	 */
	public boolean isBaby() {
		return this.getEntityData().get(DATA_BABY_ID);
	}

	public void setBaby(boolean value) {
		this.getEntityData().set(DATA_BABY_ID, value);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
		if (DATA_BABY_ID.equals(dataAccessor)) {
			this.refreshDimensions();
		}

		super.onSyncedDataUpdated(dataAccessor);
	}

	public static boolean checkMandragoraSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}