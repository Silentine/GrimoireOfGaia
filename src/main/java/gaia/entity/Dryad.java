package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.entity.goal.MobAttackGoal;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

public class Dryad extends AbstractAssistGaiaEntity implements IDayMob {
	private static final EntityDataAccessor<Boolean> FLEEING = SynchedEntityData.defineId(Dryad.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_BABY_ID = SynchedEntityData.defineId(Dryad.class, EntityDataSerializers.BOOLEAN);

	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true);
	private final AvoidEntityGoal<Player> avoidPlayerGoal = new AvoidEntityGoal<>(this, Player.class, 4.0F, SharedEntityData.ATTACK_SPEED_1, SharedEntityData.ATTACK_SPEED_3);
	private final AvoidEntityGoal<Mob> avoidMobGoal = new AvoidEntityGoal<>(this, Mob.class, 4.0F, SharedEntityData.ATTACK_SPEED_1, SharedEntityData.ATTACK_SPEED_3);


	private int switchHealth;
	private byte inWaterTimer;

	public Dryad(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		switchHealth = 0;
		inWaterTimer = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_1)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.getEntityData().define(DATA_BABY_ID, false);
		this.entityData.define(FLEEING, false);
	}

	public boolean isFleeing() {
		return this.entityData.get(FLEEING);
	}

	public void setFleeing(boolean flag) {
		this.entityData.set(FLEEING, flag);
	}

	@Override
	public int maxVariants() {
		return 1;
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = getBaseDamage(source, damage);
		if (source.getEntity() instanceof Player player) {
			ItemStack itemstack = player.getItemInHand(player.getUsedItemHand());

			if (itemstack.canPerformAction(ToolActions.AXE_DIG)) {
				input = input * 1.5F;
			}
		}

		return super.hurt(source, input);
	}

	@Override
	public void aiStep() {
		if (!this.level.isClientSide) {
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

		if (isOnFire()) {
			addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
			addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
		}

		/* FLEE DATA */
		if ((getHealth() < getMaxHealth() * 0.25F) && (switchHealth == 0)) {
			switch (random.nextInt(2)) {
				case 0 -> {
					setGoals(1);
					setFleeing(true);
					switchHealth = 1;
				}
				case 1 -> switchHealth = 2;
			}
		}

		if ((getHealth() > getMaxHealth() * 0.25F) && (switchHealth == 1)) {
			setGoals(0);
			setFleeing(false);

			switchHealth = 0;
		}
		/* FLEE DATA */

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(mobAttackGoal);
			this.goalSelector.addGoal(3, avoidPlayerGoal);
			this.goalSelector.addGoal(4, avoidMobGoal);
		} else {
			this.goalSelector.removeGoal(avoidPlayerGoal);
			this.goalSelector.removeGoal(avoidMobGoal);
			this.goalSelector.addGoal(1, mobAttackGoal);
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		if (random.nextInt(4) == 0) {
			setVariant(1);
		}
		if (random.nextInt(10) == 0) {
			setBaby(true);
		}

		setGoals(0);

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("IsBaby", this.isBaby());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.setBaby(tag.getBoolean("IsBaby"));

		setGoals(0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.DRYAD.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.DRYAD.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.DRYAD.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
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

	public static boolean checkDryadSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}