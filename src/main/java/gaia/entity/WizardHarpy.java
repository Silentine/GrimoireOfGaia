package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.item.weapon.book.WeaponBookItem;
import gaia.registry.GaiaRegistry;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WizardHarpy extends AbstractAssistGaiaEntity implements RangedAttackMob {
	private static final EntityDataAccessor<Integer> ANIMATION_STATE = SynchedEntityData.defineId(WizardHarpy.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<ItemStack> STORED_STACK = SynchedEntityData.defineId(WizardHarpy.class, EntityDataSerializers.ITEM_STACK);
	private final RangedAttackGoal rangedAttackGoal = new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, 20, 60, 15.0F);
	private final AvoidEntityGoal<Player> avoidPlayerGoal = new AvoidEntityGoal(this, Player.class, 20.0F, SharedEntityData.ATTACK_SPEED_1, SharedEntityData.ATTACK_SPEED_3);

	private boolean animationPlay;
	private int animationTimer;

	private int switchHealth;

	public WizardHarpy(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		animationPlay = false;
		animationTimer = 0;

		switchHealth = 0;
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

				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public float getEyeHeight(Pose pose) {
		return this.getDimensions(pose).height * 0.5F;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ANIMATION_STATE, 0);
		this.entityData.define(STORED_STACK, ItemStack.EMPTY);
	}

	public int getAnimationState() {
		return this.entityData.get(ANIMATION_STATE);
	}

	public void setAnimationState(int state) {
		this.entityData.set(ANIMATION_STATE, state);
	}

	public ItemStack getStoredStack() {
		return this.entityData.get(STORED_STACK);
	}

	public void setStoredStack(ItemStack stack) {
		this.entityData.set(STORED_STACK, stack);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			ItemStack offhandItem = getOffhandItem();

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK_FREEZING.get()))
				RangedUtil.magicRandom(target, this, distanceFactor, 0, MobEffects.MOVEMENT_SLOWDOWN);

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK_NIGHTMARE.get()))
				RangedUtil.magicRandom(target, this, distanceFactor, 0, MobEffects.DIG_SLOWDOWN);

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK_METAL.get()))
				RangedUtil.magicRandom(target, this, distanceFactor, 0, MobEffects.CONFUSION);

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK_ENDER.get()))
				RangedUtil.magicRandom(target, this, distanceFactor, 0, MobEffects.BLINDNESS);

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK_HUNGER.get()))
				RangedUtil.magicRandom(target, this, distanceFactor, 0, MobEffects.HUNGER);

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK_BATTLE.get()))
				RangedUtil.magicRandom(target, this, distanceFactor, 0, MobEffects.WEAKNESS);

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK_NATURE.get()))
				RangedUtil.magicRandom(target, this, distanceFactor, 0, MobEffects.POISON);

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK_WITHER.get()))
				RangedUtil.magicRandom(target, this, distanceFactor, 0, MobEffects.WITHER);

			if (offhandItem.is(GaiaRegistry.WEAPON_BOOK.get()))
				RangedUtil.magic(target, this, distanceFactor);

			setAnimationState(1);
			animationPlay = true;
			animationTimer = 0;
		}
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = getBaseDamage(source, damage);
		return super.hurt(source, input);
	}

	@Override
	public void aiStep() {
		Vec3 motion = this.getDeltaMovement();
		if (!this.onGround && motion.y < 0.0D) {
			this.setDeltaMovement(motion.multiply(1.0D, 0.6D, 1.0D));
		}

		/* FLEE DATA */
		if ((getHealth() < getMaxHealth() * 0.25F) && (switchHealth == 0)) {
			switch (random.nextInt(2)) {
				case 0 -> {
					setGoals(1);
					setStoredStack(getOffhandItem());
					setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
					setAnimationState(2);
					switchHealth = 1;
				}
				case 1 -> switchHealth = 2;
			}
		}

		if ((getHealth() > getMaxHealth() * 0.25F) && (switchHealth == 1)) {
			setGoals(0);
			setItemSlot(EquipmentSlot.OFFHAND, getStoredStack());
			setStoredStack(ItemStack.EMPTY);
			setAnimationState(0);

			switchHealth = 0;
		}
		/* FLEE DATA */

		if (animationPlay) {
			if (animationTimer != 20) {
				animationTimer += 1;
			} else {
				setAnimationState(0);
				animationPlay = false;
			}
		}

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(rangedAttackGoal);
			this.goalSelector.addGoal(3, avoidPlayerGoal);
		} else {
			this.goalSelector.removeGoal(avoidPlayerGoal);
			this.goalSelector.addGoal(1, rangedAttackGoal);

			setAnimationState(0);
			animationPlay = false;
			animationTimer = 0;
		}
	}

	public boolean causeFallDamage(float distance, float multiplier, DamageSource source) {
		return false;
	}

	private void setCombatTask() {
		this.goalSelector.removeGoal(avoidPlayerGoal);
		this.goalSelector.removeGoal(rangedAttackGoal);

		ItemStack itemstack = getOffhandItem();
		if (itemstack.getItem() instanceof WeaponBookItem) {
			setGoals(0);
		} else {
			setGoals(1);
		}
	}

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		switch (random.nextInt(3)) {
			case 0 -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK_FREEZING.get()));
			case 1 -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK_NIGHTMARE.get()));
			case 2 -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK_METAL.get()));
			case 3 -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK_ENDER.get()));
			case 4 -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK_HUNGER.get()));
			case 5 -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK_BATTLE.get()));
			case 6 -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK_NATURE.get()));
			case 7 -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK_WITHER.get()));
			default -> setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.WEAPON_BOOK.get()));
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		this.populateDefaultEquipmentSlots(difficultyInstance);
		this.populateDefaultEquipmentEnchantments(difficultyInstance);

		setCombatTask();

		return data;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.WIZARD_HARPY.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.WIZARD_HARPY.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.WIZARD_HARPY.getDeath();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		setCombatTask();
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkWizardHarpySpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}