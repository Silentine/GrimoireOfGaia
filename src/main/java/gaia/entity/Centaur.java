package gaia.entity;

import gaia.capability.CapabilityHandler;
import gaia.config.GaiaConfig;
import gaia.entity.goal.MobAttackGoal;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

public class Centaur extends AbstractAssistGaiaEntity implements RangedAttackMob, IDayMob {
	private static final EntityDataAccessor<Boolean> MALE = SynchedEntityData.defineId(Centaur.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FLEEING = SynchedEntityData.defineId(Centaur.class, EntityDataSerializers.BOOLEAN);

	private final RangedBowAttackGoal<Centaur> bowAttackGoal = new RangedBowAttackGoal<>(this, SharedEntityData.ATTACK_SPEED_2, 20, 15.0F);
	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true);
	private final AvoidEntityGoal<Player> avoidPlayerGoal = new AvoidEntityGoal<>(this, Player.class, 4.0F, SharedEntityData.ATTACK_SPEED_1, SharedEntityData.ATTACK_SPEED_3);
	private final AvoidEntityGoal<PathfinderMob> avoidMobGoal = new AvoidEntityGoal<>(this, PathfinderMob.class, 4.0F, SharedEntityData.ATTACK_SPEED_1, SharedEntityData.ATTACK_SPEED_3);

	private int fullHealth;
	private byte regenerateHealth;

	public Centaur(EntityType<? extends Monster> entityType, Level level) {
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
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_MIXED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_1)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(MALE, false);
		this.entityData.define(FLEEING, false);
	}

	public boolean isMale() {
		return this.entityData.get(MALE);
	}

	public void setMale(boolean flag) {
		this.entityData.set(MALE, flag);
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
	public void aiStep() {
		/* REGENERATE DATA */
		if ((getHealth() < getMaxHealth() * 0.25F) && (fullHealth == 0)) {
			ItemStack stacky = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.REGENERATION);
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
			getCapability(CapabilityHandler.CAPABILITY_FRIENDED).ifPresent(cap -> {
				if (!cap.isFriendly()) {
					setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
					setGoals(0);
				} else {
					setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
					setGoals(2);
				}
			});

			removeEffect(MobEffects.REGENERATION);
			setFleeing(false);

			fullHealth = 0;
			regenerateHealth = 0;
		}
		/* REGENERATE DATA */

		super.aiStep();
	}

	private void setGoals(int id) {
		switch (id) {
			default -> {
				this.goalSelector.removeGoal(avoidPlayerGoal);
				this.goalSelector.removeGoal(avoidMobGoal);
				this.goalSelector.addGoal(1, bowAttackGoal);
			}
			case 1 -> {
				this.goalSelector.removeGoal(bowAttackGoal);
				this.goalSelector.removeGoal(mobAttackGoal);
				this.goalSelector.addGoal(3, avoidPlayerGoal);
				this.goalSelector.addGoal(3, avoidMobGoal);
			}
			case 2 -> {
				this.goalSelector.removeGoal(avoidPlayerGoal);
				this.goalSelector.removeGoal(avoidMobGoal);
				this.goalSelector.addGoal(1, mobAttackGoal);
			}
		}
	}

	private void setCombatTask() {
		this.goalSelector.removeGoal(bowAttackGoal);
		this.goalSelector.removeGoal(mobAttackGoal);
		ItemStack itemstack = getMainHandItem();

		if (itemstack.getItem() instanceof BowItem) {
			int i = 20;

			if (this.level.getDifficulty() != Difficulty.HARD) {
				i = 40;
			}

			bowAttackGoal.setMinAttackInterval(i);
			setGoals(0);
		} else {
			setGoals(2);
		}
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.rangedAttack(target, this, distanceFactor);
		}
	}

	@Override
	public ItemStack getProjectile(ItemStack stack) {
		return super.getProjectile(stack);
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));

		if (random.nextBoolean()) {
			if (random.nextInt(2) == 0) {
				setItemSlot(EquipmentSlot.OFFHAND, PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), Potions.SLOWNESS));
			} else {
				setItemSlot(EquipmentSlot.OFFHAND, PotionUtils.setPotion(new ItemStack(Items.TIPPED_ARROW), Potions.WEAKNESS));
			}
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		if (random.nextInt(2) == 0) {
			setMale(true);
		}

		if (levelAccessor.getBiome(blockPosition()).value().getTemperature(blockPosition()) > 1.0F) {
			setVariant(1);
		}

		this.populateDefaultEquipmentSlots(random, difficultyInstance);
		this.populateDefaultEquipmentSlots(random, difficultyInstance);

		setCombatTask();

		if (random.nextInt(10000) == 0 && difficultyInstance.getDifficulty() != Difficulty.PEACEFUL) {
			GaiaHorse gaiaHorse = createHorse(difficultyInstance);
			if (gaiaHorse != null) {
				startRiding(gaiaHorse);
			}
		}

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Male", isMale());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("Male")) {
			boolean male = tag.getBoolean("Male");
			setMale(male);
		}

		setGoals(0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return !isMale() ? GaiaRegistry.CENTAUR.getSay() : GaiaRegistry.CENTAUR.getMaleSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return !isMale() ? GaiaRegistry.CENTAUR.getHurt() : GaiaRegistry.CENTAUR.getMaleHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return !isMale() ? GaiaRegistry.CENTAUR.getDeath() : GaiaRegistry.CENTAUR.getMaleDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkCentaurSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}