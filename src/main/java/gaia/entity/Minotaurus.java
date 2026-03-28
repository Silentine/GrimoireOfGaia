package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaLootTables;
import gaia.registry.GaiaRegistry;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.cow.CowSoundVariants;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class Minotaurus extends AbstractGaiaEntity implements RangedAttackMob {

	private final RangedBowAttackGoal<Minotaurus> rangedAttackGoal = new RangedBowAttackGoal<>(this, SharedEntityData.ATTACK_SPEED_2, 20, 15.0F);
	private final MobAttackGoal collideAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, true);

	public Minotaurus(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));

		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
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
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		if (isPowered()) {
			return source.isDirect() && super.hurtServer(level, source, damage);
		}
		return super.hurtServer(level, source, damage);
	}

	public boolean isPowered() {
		return getHealth() < getMaxHealth() / 2.0F;
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
					livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, effectTime * 20, 1));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, effectTime * 20, 1));
				}
			}

			return true;
		} else {
			return false;
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
		ItemStack itemstack = getMainHandItem();

		if (itemstack.getItem() instanceof BowItem) {
			int i = 20;

			if (this.level().getDifficulty() != Difficulty.HARD) {
				i = 40;
			}

			rangedAttackGoal.setMinAttackInterval(i);
			this.goalSelector.addGoal(1, rangedAttackGoal);
		} else {
			this.goalSelector.addGoal(1, collideAttackGoal);
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
	                                    EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		if (random.nextInt(4) == 0) {
			mobClass(difficultyInstance, 1);
		} else {
			mobClass(difficultyInstance, 0);
		}

		if (getVariant() != 0) {
			this.lootTable = Optional.of(GaiaLootTables.MINOTAURUS_RANGED);
		}
		setCombatTask();

		return data;
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		if (random.nextInt(4) == 0) {
			setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
		} else {
			setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
		}
	}

	private void mobClass(DifficultyInstance difficultyInstance, int id) {
		switch (id) {
			default -> {
				this.populateDefaultEquipmentSlots(random, difficultyInstance);
				this.populateDefaultEquipmentSlots(random, difficultyInstance);
			}
			case 1 -> {
				setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
				this.populateDefaultEquipmentSlots(random, difficultyInstance);

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
		}

		setVariant(id);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.rangedAttack(target, this, distanceFactor);
		}
	}

	@Override
	public boolean canAttack(LivingEntity target) {
		return super.canAttack(target) && !target.is(GaiaRegistry.MINOTAURUS.getEntityType());
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
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.MINOTAURUS.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.MINOTAURUS.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.MINOTAURUS.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.COW_SOUNDS.get(CowSoundVariants.SoundSet.CLASSIC)
				.stepSound().value(), 0.15F, 1.0F);
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkMinotaurusSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}