package gaia.entity;

import gaia.attachment.AttachmentHandler;
import gaia.attachment.friended.Friended;
import gaia.config.GaiaConfig;
import gaia.entity.goal.MobAttackGoal;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
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
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

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
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_1)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(MALE, false);
		builder.define(FLEEING, false);
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
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		return super.hurtServer(level, source, damage);
	}

	@Override
	public void aiStep() {
		/* REGENERATE DATA */
		if ((getHealth() < getMaxHealth() * 0.25F) && (fullHealth == 0)) {
			ItemStack stacky = Items.POTION.getDefaultInstance();
			stacky.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.REGENERATION));
			setItemSlot(EquipmentSlot.MAINHAND, stacky);
			setGoals(1);
			setFleeing(true);

			fullHealth = 1;
		}

		if ((getHealth() < getMaxHealth()) && (fullHealth == 1)) {
			if (regenerateHealth <= 100) {
				++regenerateHealth;
			} else {
				playSound(SoundEvents.GENERIC_DRINK.value(), 0.15F, 1.0F);
				addEffect(new MobEffectInstance(MobEffects.REGENERATION, 360, 3));
				regenerateHealth = 0;
			}
		} else if ((getHealth() >= getMaxHealth()) && (fullHealth == 1)) {
			Friended friended = AttachmentHandler.getFriended(this);
			if (!friended.isFriendly()) {
				setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
				setGoals(0);
			} else {
				setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
				setGoals(2);
			}

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

			if (this.level().getDifficulty() != Difficulty.HARD) {
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

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
	                                    EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		if (random.nextInt(2) == 0) {
			setMale(true);
		}

		if (levelAccessor.getBiome(blockPosition()).value().getTemperature(blockPosition(), level().getSeaLevel()) > 1.0F) {
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
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putBoolean("Male", isMale());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		setMale(input.getBooleanOr("Male", false));

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

	public static boolean checkCentaurSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}