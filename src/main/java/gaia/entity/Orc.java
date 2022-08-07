package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.item.weapon.MagicStaffItem;
import gaia.registry.GaiaRegistry;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Orc extends AbstractGaiaEntity implements RangedAttackMob {
	private static final EntityDataAccessor<Integer> ANIMATION_STATE = SynchedEntityData.defineId(Orc.class, EntityDataSerializers.INT);

	private final RangedAttackGoal rangedAttackGoal = new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, 20, 60, 15.0F);
	private final MobAttackGoal collideAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true);
	private static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (difficulty) -> {
		return difficulty == Difficulty.HARD;
	};
	private final BreakDoorGoal breakDoorGoal = new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE);

	// Variant 0
	private int buffEffect;
	private boolean animationPlay;
	private int animationTimer;
	// Variant 1
	private int switchHealth;

	public Orc(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		// Variant 0
		buffEffect = 0;
		animationPlay = false;
		animationTimer = 0;
		// Variant 1
		switchHealth = 0;
	}


	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));

		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(Orc.class));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
//		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Dwarf.class, true)); TODO: Target Dwarf
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth1())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_NETHER)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage1())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_1)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ANIMATION_STATE, 0);
	}

	public int getAnimationState() {
		return this.entityData.get(ANIMATION_STATE);
	}

	public void setAnimationState(int state) {
		this.entityData.set(ANIMATION_STATE, state);
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
		if (!getOffhandItem().isEmpty() && getOffhandItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
			return !(source.getDirectEntity() instanceof Projectile) && super.hurt(source, damage);
		}
		return super.hurt(source, damage);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.magic(target, this, distanceFactor);

			setAnimationState(1);
			animationPlay = true;
			animationTimer = 0;
		}
	}

	@Override
	public void aiStep() {
		if (getVariant() == 0) {
			/* BUFF */
			if (getHealth() <= getMaxHealth() * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
				setGoals(2);
				setAnimationState(2);
				buffEffect = 1;
				animationPlay = true;
			}

			if (getHealth() > getMaxHealth() * 0.25F && buffEffect == 1) {
				buffEffect = 0;
				animationPlay = false;
				animationTimer = 0;
			}

			if (animationPlay) {
				if (animationTimer != 15) {
					animationTimer += 1;
				} else {
					setBuff();
					setGoals(1);
					setAnimationState(0);
					animationPlay = false;
				}
			}
			/* BUFF */
		} else if (getVariant() == 1) {
			beaconMonster();

			if ((getHealth() < getMaxHealth() * 0.5F) && (switchHealth == 0)) {
				setGoals(1);
				switchHealth = 1;
			}

			if ((getHealth() > getMaxHealth() * 0.5F) && (switchHealth == 1)) {
				setGoals(0);
				switchHealth = 0;
			}

			if (animationPlay) {
				if (animationTimer != 30) {
					animationTimer += 1;
				} else {
					setAnimationState(0);
					animationPlay = false;
				}
			}
		}

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(rangedAttackGoal);
			this.goalSelector.addGoal(1, breakDoorGoal);
			this.goalSelector.addGoal(2, collideAttackGoal);
		} else if (id == 2) {
			this.goalSelector.removeGoal(breakDoorGoal);
			this.goalSelector.removeGoal(collideAttackGoal);
		} else {
			this.goalSelector.removeGoal(breakDoorGoal);
			this.goalSelector.removeGoal(collideAttackGoal);
			this.goalSelector.addGoal(2, rangedAttackGoal);

			setAnimationState(0);
			animationPlay = false;
			animationTimer = 0;
		}
	}

	private void setBuff() {
		level.broadcastEntityEvent(this, (byte) 7);
		addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 60, 0));
	}

	private void beaconMonster() {
		if (!level.isClientSide) {
			AABB aabb = (new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1))
					.inflate(6D);
			List<Orc> orcs = level.getEntitiesOfClass(Orc.class, aabb);
			for (Orc orc : orcs) {
				orc.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1, true, true));
			}
		}
	}

	@Override
	public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack stack) {
		super.setItemSlot(equipmentSlot, stack);
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			setCombatTask();
		}
	}

	private void setCombatTask() {
		this.goalSelector.removeGoal(collideAttackGoal);
		this.goalSelector.removeGoal(rangedAttackGoal);

		if (getMainHandItem().getItem() instanceof MagicStaffItem) {
			setGoals(0);
		} else {
			setGoals(1);
		}
	}

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		switch (getVariant()) {
			case 0:
				switch (random.nextInt(2)) {
					case 0 -> {
						setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
						populateDefaultEquipmentEnchantments(instance);
					}
					case 1 -> {
						setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
						populateDefaultEquipmentEnchantments(instance);
					}
				}
				break;
			case 1:
				switch (random.nextInt(2)) {
					case 0 -> {
						setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
						populateDefaultEquipmentEnchantments(instance);
					}
					case 1 -> {
						setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
						populateDefaultEquipmentEnchantments(instance);
					}
				}
				break;
		}

		ItemStack itemstack = getMainHandItem();

		ItemStack shield = ItemStack.EMPTY;
		ItemStack armor_leggings = ItemStack.EMPTY;
		ItemStack armor_chestplate = ItemStack.EMPTY;

		switch (getVariant()) {
			case 0 -> {
				if (itemstack.getItem() == Items.STONE_AXE) {
					armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
				}
				if (itemstack.getItem() == Items.IRON_AXE) {
					armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
					armor_chestplate = new ItemStack(Items.LEATHER_CHESTPLATE);
				}
			}
			case 1 -> {
				if (itemstack.getItem() == Items.WOODEN_AXE) {
					shield = new ItemStack(GaiaRegistry.STONE_SHIELD.get());
					armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
					armor_chestplate = new ItemStack(Items.LEATHER_CHESTPLATE);
				}
				if (itemstack.getItem() == Items.STONE_AXE) {
					shield = new ItemStack(GaiaRegistry.IRON_SHIELD.get());
					armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
					armor_chestplate = new ItemStack(Items.IRON_CHESTPLATE);
				}
			}
		}

		setItemSlot(EquipmentSlot.OFFHAND, shield);
		setItemSlot(EquipmentSlot.LEGS, armor_leggings);
		setItemSlot(EquipmentSlot.CHEST, armor_chestplate);

		setCanBreakDoors(true);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		if (random.nextInt(4) == 0) {
			setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaiaRegistry.MAGIC_STAFF.get()));

			setVariant(2);
		} else {
			switch (random.nextInt(2)) {
				case 0 -> setVariant(0);
				case 1 -> setVariant(1);
			}
		}

		this.populateDefaultEquipmentSlots(difficultyInstance);

		setCombatTask();

		return data;
	}

	public void setCanBreakDoors(boolean enabled) {
		((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(enabled);
		if (enabled) {
			this.goalSelector.addGoal(1, this.breakDoorGoal);
		} else {
			this.goalSelector.removeGoal(this.breakDoorGoal);
		}
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
	public boolean canAttackType(EntityType<?> type) {
		return super.canAttackType(type) && type != GaiaRegistry.ORC.getEntityType();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.ORC.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.ORC.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.ORC.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkOrcSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}