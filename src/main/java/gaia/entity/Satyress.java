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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Satyress extends AbstractAssistGaiaEntity implements IDayMob {
	private static final EntityDataAccessor<Boolean> FLEEING = SynchedEntityData.defineId(Satyress.class, EntityDataSerializers.BOOLEAN);

	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true);
	private final AvoidEntityGoal<Player> avoidPlayerGoal = new AvoidEntityGoal<>(this, Player.class, 4.0F, SharedEntityData.ATTACK_SPEED_1, SharedEntityData.ATTACK_SPEED_3);
	private final AvoidEntityGoal<Mob> avoidMobGoal = new AvoidEntityGoal<>(this, Mob.class, 4.0F, SharedEntityData.ATTACK_SPEED_1, SharedEntityData.ATTACK_SPEED_3);

	private int fullHealth;
	private int regenerateHealth;

	public Satyress(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		fullHealth = 0;
		regenerateHealth = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth1())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage1())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_1)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
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
		return super.hurt(source, input);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		if (super.doHurtTarget(entityIn)) {
			if (entityIn instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (level.getDifficulty() == Difficulty.NORMAL) {
					effectTime = 5;
				} else if (level.getDifficulty() == Difficulty.HARD) {
					effectTime = 10;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		/* REGENERATE DATA */
		if ((getHealth() < getMaxHealth() * 0.25F) && (fullHealth == 0)) {
			ItemStack stacky = PotionUtils.setPotion(new ItemStack(Items.POTION, 1), Potions.REGENERATION);
			setItemSlot(EquipmentSlot.MAINHAND, stacky);
			setGoals(1);
			setFleeing(true);

			fullHealth = 1;
		}

		if ((getHealth() < getMaxHealth()) && (fullHealth == 1)) {
			if (regenerateHealth <= 100) {
				++regenerateHealth;
			} else {
				playSound(SoundEvents.GENERIC_DRINK, 0.15F, 1.0F);
				addEffect(new MobEffectInstance(MobEffects.REGENERATION, 360, 3));
				regenerateHealth = 0;
			}
		} else if ((getHealth() >= getMaxHealth()) && (fullHealth == 1)) {
			setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
			removeEffect(MobEffects.REGENERATION);
			setGoals(0);
			setFleeing(false);

			fullHealth = 0;
			regenerateHealth = 0;
		}
		/* REGENERATE DATA */

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(mobAttackGoal);
			this.goalSelector.addGoal(3, avoidMobGoal);
			this.goalSelector.addGoal(3, avoidPlayerGoal);
		} else {
			this.goalSelector.removeGoal(avoidMobGoal);
			this.goalSelector.removeGoal(avoidPlayerGoal);
			this.goalSelector.addGoal(1, mobAttackGoal);
		}
	}

	private void setBuff() {
		level.broadcastEntityEvent(this, (byte) 7);
		addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 60, 0));
	}

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		if (levelAccessor.getBiome(blockPosition()).value().getTemperature(blockPosition()) > 1.0F) {
			setVariant(1);
		}

		this.populateDefaultEquipmentSlots(difficultyInstance);
		this.populateDefaultEquipmentEnchantments(difficultyInstance);

		setGoals(0);

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);

		setGoals(0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.SATYRESS.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.SATYRESS.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.SATYRESS.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		playSound(SoundEvents.PIG_STEP, 0.15F, 1.0F); //Add custom step sound
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkSatyressSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}