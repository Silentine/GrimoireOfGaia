package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.entity.goal.MobAttackGoal;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaLootTables;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.EnchantUtil;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.common.Tags;
import org.jspecify.annotations.Nullable;

import java.util.Optional;
import java.util.function.Predicate;

public class Dwarf extends AbstractAssistGaiaEntity implements RangedAttackMob, IDayMob {
	private static final EntityDataAccessor<Boolean> RANDOM_CLASS = SynchedEntityData.defineId(Dwarf.class, EntityDataSerializers.BOOLEAN);

	private final RangedBowAttackGoal<Dwarf> rangedBowAttackGoal = new RangedBowAttackGoal<>(this, SharedEntityData.ATTACK_SPEED_2, 20, 15.0F);
	private final MobAttackGoal collideAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, true);
	private static final Predicate<Difficulty> DOOR_BREAKING_PREDICATE = (difficulty) -> {
		return difficulty == Difficulty.HARD;
	};
	private final BreakDoorGoal breakDoorGoal = new BreakDoorGoal(this, DOOR_BREAKING_PREDICATE);
	private boolean canBreakDoors;

	public Dwarf(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));

		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Orc.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 80.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_MIXED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_2)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 2;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(RANDOM_CLASS, true);
	}

	public boolean applyRandomClass() {
		return this.entityData.get(RANDOM_CLASS);
	}

	public void setRandomClass(boolean value) {
		this.entityData.set(RANDOM_CLASS, value);
	}

	@Override
	public int maxVariants() {
		return 2;
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		if (!getOffhandItem().isEmpty() && getOffhandItem().is(Tags.Items.TOOLS_SHIELD)) {
			return !(source.getDirectEntity() instanceof AbstractArrow) && super.hurtServer(level, source, damage);
		}
		return super.hurtServer(level, source, damage);
	}

	@Override
	public boolean doHurtTarget(ServerLevel level, Entity target) {
		if (super.doHurtTarget(level, target)) {
			if (target instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (this.level().getDifficulty() == Difficulty.NORMAL) {
					effectTime = 10;
				} else if (this.level().getDifficulty() == Difficulty.HARD) {
					effectTime = 20;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, effectTime * 20, 0));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, effectTime * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.rangedAttack(target, this, distanceFactor);
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
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
		this.goalSelector.removeGoal(rangedBowAttackGoal);
		if (getMainHandItem().getItem() instanceof BowItem) {
			this.goalSelector.addGoal(1, rangedBowAttackGoal);
		} else {
			this.goalSelector.addGoal(1, collideAttackGoal);
		}
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		if (applyRandomClass()) {
			if (random.nextInt(4) == 0) {
				ItemStack bowStack = new ItemStack(Items.BOW);
				bowStack.enchant(EnchantUtil.getEnchantmentHolder(this, Enchantments.PUNCH), 1);
				this.setItemSlot(EquipmentSlot.MAINHAND, bowStack);

				if (random.nextBoolean()) {
					if (random.nextBoolean()) {
						ItemStack tippedArrow = new ItemStack(Items.TIPPED_ARROW);
						if (random.nextInt(2) == 0) {
							tippedArrow.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.SLOWNESS));
							setItemSlot(EquipmentSlot.OFFHAND, tippedArrow);
						} else {
							tippedArrow.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WEAKNESS));
							setItemSlot(EquipmentSlot.OFFHAND, tippedArrow);
						}
					}
				}

				setVariant(1);
			} else {
				if (random.nextInt(4) == 0) {
					this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_PICKAXE));
					setVariant(2);
				} else {
					this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
					if (random.nextBoolean()) {
						this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.IRON_SHIELD.get()));
						getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D);
					}

					setVariant(0);
				}
			}
		} else {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_PICKAXE));
			this.setVariant(0);
		}
	}

	public boolean canBreakDoors() {
		return this.canBreakDoors;
	}

	public void setCanBreakDoors(boolean p_34337_) {
		if (GoalUtils.hasGroundPathNavigation(this)) {
			if (this.canBreakDoors != p_34337_) {
				this.canBreakDoors = p_34337_;
				((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(p_34337_);
				if (p_34337_) {
					this.goalSelector.addGoal(1, this.breakDoorGoal);
				} else {
					this.goalSelector.removeGoal(this.breakDoorGoal);
				}
			}
		} else if (this.canBreakDoors) {
			this.goalSelector.removeGoal(this.breakDoorGoal);
			this.canBreakDoors = false;
		}

	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		this.populateDefaultEquipmentSlots(random, difficultyInstance);
		this.populateDefaultEquipmentSlots(random, difficultyInstance);

		setCombatTask();

		ResourceKey<LootTable> table = switch (getVariant()) {
			case 1 -> GaiaLootTables.DWARF_RANGED;
			case 2 -> GaiaLootTables.DWARF_MINER;
			default -> getType().getDefaultLootTable().get();
		};
		this.lootTable = Optional.of(table);

		return data;
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putBoolean("RandomClass", applyRandomClass());
		output.putBoolean("CanBreakDoors", this.canBreakDoors());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		setRandomClass(input.getBooleanOr("RandomClass", false));
		this.setCanBreakDoors(input.getBooleanOr("CanBreakDoors", false));
		setCombatTask();
	}

	@Override
	public boolean canAttack(LivingEntity target) {
		return super.canAttack(target) && !target.is(GaiaRegistry.DWARF.getEntityType());
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.DWARF.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.DWARF.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.DWARF.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkDwarfSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}