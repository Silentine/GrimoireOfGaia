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
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
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
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.UUID;

public class YukiOnna extends AbstractAssistGaiaEntity implements IDayMob {
	private static final EntityDataAccessor<Boolean> FLEEING = SynchedEntityData.defineId(YukiOnna.class, EntityDataSerializers.BOOLEAN);

	private static final UUID KNOCKBACK_MODIFIER_UUID = UUID.fromString("D2EF3144-4329-4118-860A-80D2820C2CF1");
	private static final AttributeModifier KNOCKBACK_MODIFIER = new AttributeModifier(KNOCKBACK_MODIFIER_UUID, "Knockback boost", 2.0D, Operation.ADDITION);

	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, true);
	private final AvoidEntityGoal<Player> avoidPlayerGoal = new AvoidEntityGoal<>(this, Player.class, 20.0F, SharedEntityData.ATTACK_SPEED_2, SharedEntityData.ATTACK_SPEED_3);

	private int switchHealth;

	public YukiOnna(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;

		switchHealth = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));

		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(YukiOnna.class));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth2())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage2())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_2)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 2;
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
		return 0;
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
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
					livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, effectTime * 20, 3));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
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

		if (!level.isClientSide && level.getBiome(blockPosition()).value().getTemperature(blockPosition()) > 1.0F) {
			addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0));
			addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
		}

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(mobAttackGoal);
			this.goalSelector.addGoal(1, avoidPlayerGoal);
		} else {
			this.goalSelector.removeGoal(avoidPlayerGoal);
			this.goalSelector.addGoal(1, mobAttackGoal);
		}
	}

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		if (!isBaby()) {
			if (random.nextInt(4) == 0) {
				//Remove it if it's there
				AttributeInstance attributeinstance = this.getAttribute(Attributes.ATTACK_KNOCKBACK);
				attributeinstance.removeModifier(KNOCKBACK_MODIFIER);

				ItemStack weapon = new ItemStack(GaiaRegistry.FAN.get(), 1);
				weapon.enchant(Enchantments.KNOCKBACK, 3);
				setHandOrKnockback(weapon);
			} else {
				setHandOrKnockback(ItemStack.EMPTY);
			}
		}
	}

	protected void setHandOrKnockback(ItemStack stack) {
		AttributeInstance attributeinstance = this.getAttribute(Attributes.ATTACK_KNOCKBACK);
		attributeinstance.removeModifier(KNOCKBACK_MODIFIER);
		if (stack.isEmpty()) {
			attributeinstance.addTransientModifier(KNOCKBACK_MODIFIER);
		} else {
			setItemSlot(EquipmentSlot.MAINHAND, stack);
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		this.populateDefaultEquipmentSlots(difficultyInstance);

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
		return GaiaRegistry.YUKI_ONNA.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.YUKI_ONNA.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.YUKI_ONNA.getDeath();
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	protected int getFireImmuneTicks() {
		return 20;
	}

	@Override
	public boolean causeFallDamage(float distance, float multiplier, DamageSource source) {
		return false;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkYukiOnnaSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}