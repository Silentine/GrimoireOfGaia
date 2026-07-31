package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.util.EnchantUtil;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.spider.CaveSpider;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class Arachne extends AbstractGaiaEntity implements RangedAttackMob {
	private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(Arachne.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Integer> ATTACK_TYPE = SynchedEntityData.defineId(Arachne.class, EntityDataSerializers.INT);

	private final RangedAttackGoal rangedAttackGoal = new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, 20, 60, 15.0F);
	private final MobAttackGoal collideAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, true);


	private int switchHealth;
	private int spawn;
	private int spawnTimer;

	private boolean animationPlay;
	private int animationTimer;

	public Arachne(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);

		switchHealth = 0;
		spawn = 0;
		spawnTimer = 0;

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

	protected PathNavigation createNavigation(Level level) {
		return new WallClimberNavigation(this, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_RANGED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_1)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_FLAGS_ID, (byte) 0);
		builder.define(ATTACK_TYPE, 0);
	}

	public int getAttackType() {
		return this.entityData.get(ATTACK_TYPE);
	}

	public void setAttackType(int type) {
		this.entityData.set(ATTACK_TYPE, type);
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.web(target, this, distanceFactor);

			setAttackType(1);
			animationPlay = true;
			animationTimer = 0;
		}
	}

	@Override
	public boolean canAttack(LivingEntity target) {
		return super.canAttack(target) && !target.is(GaiaRegistry.ARACHNE.getEntityType());
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
					livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, effectTime * 20, 1));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		this.beaconMonster(6, (entity) -> {
			if (entity instanceof Spider) {
				entity.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 300, 1, true, true));
			}
		});

		if ((getHealth() < getMaxHealth() * 0.5F) && (switchHealth == 0)) {
			setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaiaRegistry.METAL_DAGGER.get()));
			setGoals(1);
			switchHealth = 1;
		}

		if ((getHealth() > getMaxHealth() * 0.5F) && (switchHealth == 1)) {
			setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaiaRegistry.CAVE_SPIDER_STAFF.get()));
			setGoals(0);
			switchHealth = 0;
		}

		if (getHealth() < getMaxHealth() * 0.75F && getHealth() > 0.0F && spawn == 0) {
			setAttackType(2);

			if (spawnTimer != 30) {
				spawnTimer += 1;
			}

			if (spawnTimer == 30) {
				this.level().broadcastEntityEvent(this, (byte) 9);
				setAttackType(0);

				if (!this.level().isClientSide()) {
					setSpawn(0);
				}

				spawnTimer = 0;
				spawn = 1;
			}
		}

		if (getHealth() < getMaxHealth() * 0.25F && getHealth() > 0.0F && spawn == 1) {
			setAttackType(2);

			if (spawnTimer != 30) {
				spawnTimer += 1;
			}

			if (spawnTimer == 30) {
				this.level().broadcastEntityEvent(this, (byte) 9);
				setAttackType(0);

				if (!this.level().isClientSide()) {
					setSpawn(0);
				}

				spawnTimer = 0;
				spawn = 2;
			}
		}

		if (animationPlay) {
			if (animationTimer != 20) {
				animationTimer += 1;
			} else {
				setAttackType(0);
				animationPlay = false;
			}
		}

		if (!this.level().isClientSide()) {
			this.setClimbing(this.horizontalCollision);
		}

		super.aiStep();
	}

	private void setSpawn(int id) {
		if (this.level().getDifficulty() != Difficulty.PEACEFUL && this.level() instanceof ServerLevel serverLevel) {
			if (id == 0) {
				CaveSpider caveSpider = EntityTypes.CAVE_SPIDER.create(serverLevel, EntitySpawnReason.MOB_SUMMONED);
				if (caveSpider != null) {
					caveSpider.snapTo(blockPosition(), 0.0F, 0.0F);
					caveSpider.finalizeSpawn((ServerLevel) serverLevel, serverLevel.getCurrentDifficultyAt(blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
					serverLevel.addFreshEntity(caveSpider);
				}
			}
		}

		this.level().broadcastEntityEvent(this, (byte) 6);
	}

	private void setCombatTask() {
		ItemStack itemstack = getMainHandItem();
		if (itemstack.is(GaiaRegistry.CAVE_SPIDER_STAFF.get())) {
			setGoals(0);
		} else {
			setGoals(1);
		}
	}

	private void setGoals(int id) {
		if (id == 1) {
			this.goalSelector.removeGoal(rangedAttackGoal);
			this.goalSelector.addGoal(1, collideAttackGoal);
		} else {
			this.goalSelector.removeGoal(collideAttackGoal);
			this.goalSelector.addGoal(1, rangedAttackGoal);

			setAttackType(0);
			animationPlay = false;
			animationTimer = 0;
		}
	}

	public boolean isClimbing() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}

	public void setClimbing(boolean value) {
		byte b0 = this.entityData.get(DATA_FLAGS_ID);
		if (value) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}

		this.entityData.set(DATA_FLAGS_ID, b0);
	}

	@Override
	protected void dropFromLootTable(ServerLevel level, DamageSource source, boolean playerKilled) {
		super.dropFromLootTable(level, source, playerKilled);
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		ItemStack staffStack = new ItemStack(GaiaRegistry.CAVE_SPIDER_STAFF.get());
		staffStack.enchant(EnchantUtil.getEnchantmentHolder(this, Enchantments.KNOCKBACK), 2);
		setItemSlot(EquipmentSlot.MAINHAND, staffStack);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
	                                    EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		this.populateDefaultEquipmentSlots(random, difficultyInstance);

		setCombatTask();

		if (random.nextInt(2) == 0) {
			this.lootTable = Optional.of(EntityTypes.WITCH.getDefaultLootTable().get());
		}

		return data;
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putInt("WeaponType", getAttackType());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		setAttackType(input.getIntOr("WeaponType", 0));
		setCombatTask();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.ARACHNE.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.ARACHNE.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.ARACHNE.getDeath();
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
	}

	public boolean onClimbable() {
		return this.isClimbing();
	}

	public void makeStuckInBlock(BlockState state, Vec3 speedMultiplier) {
		if (!state.is(Blocks.COBWEB)) {
			super.makeStuckInBlock(state, speedMultiplier);
		}

	}

	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return effectInstance.getEffect() != MobEffects.POISON && super.canBeAffected(effectInstance);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_UNDERGROUND;
	}

	public static boolean checkArachneSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkBelowSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}