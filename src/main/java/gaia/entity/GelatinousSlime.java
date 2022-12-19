package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class GelatinousSlime extends AbstractGaiaEntity {

	private boolean animationPlay;
	private int animationTimer;

	public float targetSquish;
	public float squish;
	public float oSquish;

	public GelatinousSlime(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;

		this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);

		animationPlay = false;
		animationTimer = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_0, true));
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(GelatinousSlime.class, Sporeling.class));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, SharedEntityData.getMaxHealth2())
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1 * 0.5)
				.add(Attributes.ATTACK_DAMAGE, SharedEntityData.getAttackDamage2())
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)

				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 2;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
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

		if (source.getDirectEntity() instanceof AbstractArrow) {
			level.broadcastEntityEvent(this, (byte) 8);
			heal(getMaxHealth() * 0.10F);
		}

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
					livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, effectTime * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void tick() {
		this.squish += (this.targetSquish - this.squish) * 0.5F;
		this.oSquish = this.squish;
		super.tick();

		if (tickCount % 60 == 0) {
			animationPlay = true;
			animationTimer = 0;
		}

		if (animationPlay) {
			this.targetSquish = -0.10F;

			if (animationTimer != 10) {
				animationTimer += 1;
			} else {
				this.targetSquish = 1.0F;
				animationPlay = false;
			}
		}

		this.decreaseSquish();
	}

	protected void decreaseSquish() {
		this.targetSquish *= 0.6F;
	}

	@Override
	public void aiStep() {
		if (!level.isClientSide && isPassenger()) {
			stopRiding();
		}

		this.beaconMonster(4, (entity) -> {
			if (!(entity instanceof Player)) {
				entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1, true, true));
			}
		});

		if (getHealth() < getMaxHealth()) {
			if (!getMainHandItem().isEmpty()) {
				setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);

				level.broadcastEntityEvent(this, (byte) 8);
				heal(getMaxHealth() * 0.20F);
			}
		}

		super.aiStep();
	}

	@Override
	protected void tickDeath() {
		if (!this.level.isClientSide) {
			spawnLingeringCloud(List.of(new MobEffectInstance(MobEffects.POISON, 40, 0)));
		}
		super.tickDeath();
	}

	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance instance) {
		ItemStack spawnItem = switch (random.nextInt(3)) {
			case 0 -> new ItemStack(Items.BOW);
			case 1 -> new ItemStack(Items.ARROW);
			case 2 -> new ItemStack(Items.STONE_SWORD);
			default -> ItemStack.EMPTY;
		};

		setItemSlot(EquipmentSlot.MAINHAND, spawnItem);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		this.populateDefaultEquipmentSlots(difficultyInstance);

		this.setCanPickUpLoot(true);

		return data;
	}

	@Override
	protected ResourceLocation getDefaultLootTable() {
		if (random.nextBoolean()) {
			return EntityType.SKELETON.getDefaultLootTable();
		}
		return super.getDefaultLootTable();
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
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.GELATINOUS_SLIME.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.GELATINOUS_SLIME.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.GELATINOUS_SLIME.getDeath();
	}

	@Override
	public boolean fireImmune() {
		return false;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return effectInstance.getEffect() == MobEffects.POISON ? false : super.canBeAffected(effectInstance);
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkGelatinousSlimeSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}