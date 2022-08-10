package gaia.entity;

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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FleshLich extends AbstractGaiaEntity implements RangedAttackMob {
	private static final EntityDataAccessor<Integer> ANIMATION_STATE = SynchedEntityData.defineId(FleshLich.class, EntityDataSerializers.INT);
	private boolean animationPlay;
	private int animationTimer;

	public FleshLich(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;

		animationPlay = false;
		animationTimer = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, 20, 60, 15.0F));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(FleshLich.class));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
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
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.fireball(target, this, distanceFactor);

			setAnimationState(1);
			animationPlay = true;
			animationTimer = 0;
		}
	}

	@Override
	public void aiStep() {
		if (this.isAlive()) {
			boolean flag = this.isSunSensitive() && this.isSunBurnTick();
			if (flag) {
				ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);
				if (!itemstack.isEmpty()) {
					if (itemstack.isDamageableItem()) {
						itemstack.setDamageValue(itemstack.getDamageValue() + this.random.nextInt(2));
						if (itemstack.getDamageValue() >= itemstack.getMaxDamage()) {
							this.broadcastBreakEvent(EquipmentSlot.HEAD);
							this.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
						}
					}

					flag = false;
				}

				if (flag) {
					this.setSecondsOnFire(8);
					hurt(DamageSource.OUT_OF_WORLD, getMaxHealth() * 0.25F);
				}
			}
		}

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

	protected boolean isSunSensitive() {
		return true;
	}

	@Override
	public boolean canAttackType(EntityType<?> type) {
		return super.canAttackType(type) && type != GaiaRegistry.FLESH_LICH.getEntityType();
	}

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaiaRegistry.ZOMBIE_STAFF.get()));
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		this.populateDefaultEquipmentSlots(difficultyInstance);
		this.populateDefaultEquipmentEnchantments(difficultyInstance);

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("AnimationState", getAnimationState());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("AnimationState")) {
			setAnimationState(tag.getInt("AnimationState"));
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.FLESH_LICH.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.FLESH_LICH.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.FLESH_LICH.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(GaiaRegistry.FLESH_LICH.getStep(), 0.15F, 1.0F);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_UNDERGROUND;
	}

	public static boolean checkFleshLichSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkBelowSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}