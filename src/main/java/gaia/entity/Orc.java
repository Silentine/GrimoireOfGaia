package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.item.weapon.MagicStaffItem;
import gaia.registry.GaiaRegistry;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.common.Tags;
import org.jspecify.annotations.Nullable;

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
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Dwarf.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_MIXED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_1)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(ANIMATION_STATE, 0);
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
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		if (getOffhandItem().is(Tags.Items.TOOLS_SHIELD)) {
			return !(source.getDirectEntity() instanceof AbstractArrow) && super.hurtServer(level, source, damage);
		}
		return super.hurtServer(level, source, damage);
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
			this.beaconMonster(6, (entity) -> {
				if (entity instanceof Orc) {
					entity.addEffect(new MobEffectInstance(MobEffects.HASTE, 300, 1, true, true));
				}
			});

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
		this.level().broadcastEntityEvent(this, (byte) 7);
		addEffect(new MobEffectInstance(MobEffects.STRENGTH, 20 * 60, 0));
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
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		switch (getVariant()) {
			case 0 -> {
				switch (random.nextInt(2)) {
					case 0 -> setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
					case 1 -> setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
				}
			}
			case 1 -> {
				switch (random.nextInt(2)) {
					case 0 -> setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
					case 1 -> setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
				}
			}
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
										EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		if (random.nextInt(4) == 0) {
			setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaiaRegistry.MAGIC_STAFF.get()));

			setVariant(2);
		} else {
			switch (random.nextInt(2)) {
				case 0 -> setVariant(0);
				case 1 -> setVariant(1);
			}
		}

		this.populateDefaultEquipmentSlots(random, difficultyInstance);
		this.populateDefaultEquipmentSlots(random, difficultyInstance);

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
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
	}

	@Override
	public boolean canAttack(LivingEntity target) {
		return super.canAttack(target) && !target.is(GaiaRegistry.ORC.getEntityType());
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

	public static boolean checkOrcSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}