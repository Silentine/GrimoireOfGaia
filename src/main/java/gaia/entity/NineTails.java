package gaia.entity;

import gaia.GrimoireOfGaia;
import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.util.EnchantUtil;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
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
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public class NineTails extends AbstractGaiaEntity implements RangedAttackMob {
	private static final Identifier KNOCKBACK_ID = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "nine_tails_knockback_modifier");
	private static final AttributeModifier KNOCKBACK_MODIFIER = new AttributeModifier(KNOCKBACK_ID, 2.0D, Operation.ADD_VALUE);
	private static final EntityDataAccessor<Boolean> THROWING = SynchedEntityData.defineId(NineTails.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> WEAPON_TYPE = SynchedEntityData.defineId(NineTails.class, EntityDataSerializers.INT);

	private final RangedAttackGoal bowAttackGoal = new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, 20, 60, 15.0F);
	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, true);


	private int switchHealth;

	private boolean animationPlay;
	private int animationTimer;

	public NineTails(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;

		switchHealth = 0;

		animationPlay = false;
		animationTimer = 0;
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
		builder.define(THROWING, false);
		builder.define(WEAPON_TYPE, 0);
	}

	public boolean isThrowing() {
		return this.entityData.get(THROWING);
	}

	public void setThrowing(boolean flag) {
		this.entityData.set(THROWING, flag);
	}

	public int getWeaponType() {
		return this.entityData.get(WEAPON_TYPE);
	}

	public void setWeaponType(int type) {
		this.entityData.set(WEAPON_TYPE, type);
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
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.fireball(target, this, distanceFactor);

			setThrowing(true);
			animationPlay = true;
			animationTimer = 0;
		}
	}

	@Override
	public boolean doHurtTarget(ServerLevel level, Entity target) {
		if (super.doHurtTarget(level, target)) {
			target.setRemainingFireTicks(20 * 6);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		if ((getHealth() < getMaxHealth() * 0.75F) && (switchHealth == 0)) {
			if (getWeaponType() == 0) {
				if (random.nextInt(4) == 0) {
					setWeaponType(2);
				} else {
					setWeaponType(1);
				}
			}

			setEnchantedEquipment(getWeaponType());

			setGoals(1);
			switchHealth = 1;
		}

		if ((getHealth() > getMaxHealth() * 0.75F) && (switchHealth == 1)) {
			setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
			setGoals(0);
			switchHealth = 0;
		}

		if (animationPlay) {
			if (animationTimer != 20) {
				animationTimer += 1;
			} else {
				setThrowing(false);
				animationPlay = false;
			}
		}

		super.aiStep();
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(bowAttackGoal);
			this.goalSelector.addGoal(1, mobAttackGoal);
		} else {
			this.goalSelector.removeGoal(mobAttackGoal);
			this.goalSelector.addGoal(1, bowAttackGoal);

			setThrowing(false);
			animationPlay = false;
			animationTimer = 0;
		}
	}

	private void setCombatTask() {
		if (getMainHandItem().isEmpty() || getAttribute(Attributes.ATTACK_KNOCKBACK).hasModifier(KNOCKBACK_ID)) {
			setGoals(0);
		} else {
			setGoals(1);
		}
	}

	protected void setEnchantedEquipment(int id) {
		if (id == 1) {
			setHandOrKnockback(ItemStack.EMPTY);
		} else if (id == 2) {
			ItemStack weapon = new ItemStack(GaiaRegistry.FAN.get(), 1);
			weapon.enchant(EnchantUtil.getEnchantmentHolder(this, Enchantments.KNOCKBACK), 2);
			setHandOrKnockback(weapon);
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

		setCombatTask();

		return data;
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putInt("WeaponType", getWeaponType());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		int weaponType = input.getIntOr("WeaponType", 0);
		setWeaponType(weaponType);
		setCombatTask();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.NINE_TAILS.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.NINE_TAILS.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.NINE_TAILS.getDeath();
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkNineTailsSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}