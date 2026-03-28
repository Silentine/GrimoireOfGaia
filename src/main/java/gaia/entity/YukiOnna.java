package gaia.entity;

import gaia.GrimoireOfGaia;
import gaia.config.GaiaConfig;
import gaia.entity.goal.MobAttackGoal;
import gaia.entity.type.IDayMob;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import gaia.util.EnchantUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
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
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public class YukiOnna extends AbstractAssistGaiaEntity implements IDayMob {
	private static final EntityDataAccessor<Boolean> FLEEING = SynchedEntityData.defineId(YukiOnna.class, EntityDataSerializers.BOOLEAN);

	private static final Identifier KNOCKBACK_ID = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "yuki_onna_knockback_modifier");
	private static final AttributeModifier KNOCKBACK_MODIFIER = new AttributeModifier(KNOCKBACK_ID, 2.0D, Operation.ADD_VALUE);

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
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true);
		if (GaiaConfig.COMMON.allPassiveMobsHostile.get()) {
			this.targetSelector.addGoal(2, this.targetPlayerGoal);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 80.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
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
		builder.define(FLEEING, false);
	}

	public boolean isFleeing() {
		return this.entityData.get(FLEEING);
	}

	public void setFleeing(boolean flag) {
		this.entityData.set(FLEEING, flag);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense2();
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = getBaseDamage(source, damage);
		return super.hurtServer(level, source, damage);
	}

	@Override
	public boolean doHurtTarget(ServerLevel level, Entity target) {
		if (super.doHurtTarget(level, target)) {
			if (target instanceof LivingEntity livingEntity) {
				int effectTime = 0;

				if (this.level().getDifficulty() == Difficulty.NORMAL) {
					effectTime = 5;
				} else if (this.level().getDifficulty() == Difficulty.HARD) {
					effectTime = 10;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, effectTime * 20, 3));
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

		if (!this.level().isClientSide() && this.level().getBiome(blockPosition()).value().getTemperature(blockPosition(), level().getSeaLevel()) > 1.0F) {
			addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 100, 0));
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
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		if (!isBaby()) {
			if (random.nextInt(4) == 0) {
				//Remove it if it's there
				AttributeInstance attributeinstance = this.getAttribute(Attributes.ATTACK_KNOCKBACK);
				attributeinstance.removeModifier(KNOCKBACK_ID);

				ItemStack weapon = new ItemStack(GaiaRegistry.FAN.get(), 1);
				weapon.enchant(EnchantUtil.getEnchantmentHolder(this, Enchantments.KNOCKBACK), 3);
				setHandOrKnockback(weapon);
			} else {
				setHandOrKnockback(ItemStack.EMPTY);
			}
		}
	}

	protected void setHandOrKnockback(ItemStack stack) {
		AttributeInstance attributeinstance = this.getAttribute(Attributes.ATTACK_KNOCKBACK);
		attributeinstance.removeModifier(KNOCKBACK_ID);
		if (stack.isEmpty()) {
			attributeinstance.addTransientModifier(KNOCKBACK_MODIFIER);
		} else {
			setItemSlot(EquipmentSlot.MAINHAND, stack);
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		this.populateDefaultEquipmentSlots(random, difficultyInstance);

		setGoals(0);

		return data;
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);

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
	protected int getFireImmuneTicks() {
		return 20;
	}

	@Override
	public boolean causeFallDamage(double fallDistance, float damageModifier, DamageSource damageSource) {
		return false;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkYukiOnnaSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkDaytime(levelAccessor) && checkTagBlocks(levelAccessor, pos, GaiaTags.GAIA_SPAWABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) && checkGaiaDaySpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}