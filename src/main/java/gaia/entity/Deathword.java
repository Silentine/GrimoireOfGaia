package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.entity.goal.StrafeGoal;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;

public class Deathword extends AbstractGaiaEntity {

	private static final int DETECTION_RANGE = 6;

	private final MobAttackGoal mobAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true);
	private final StrafeGoal strafeGoal = new StrafeGoal(this, SharedEntityData.ATTACK_SPEED_1, 20, 15.0F);

	private boolean canSpawn;
	private int spawnTimer;
	private int spawnLimit;

	public Deathword(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;

		canSpawn = true;
		spawnTimer = 0;
		spawnLimit = 0;
		this.moveControl = new FlyingMoveControl(this, 20, true);
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

	public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
		return reader.getBlockState(pos).isAir() ? 10.0F : 0.0F;
	}

	@Override
	protected PathNavigation createNavigation(Level level) {
		FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, level) {
			public boolean isStableDestination(BlockPos pos) {
				return !level().getBlockState(pos.below()).isAir();
			}

			public void tick() {
				super.tick();
			}
		};
		flyingpathnavigation.setCanOpenDoors(false);
		flyingpathnavigation.setCanFloat(false);
		flyingpathnavigation.setCanPassDoors(true);
		return flyingpathnavigation;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_RANGED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.FLYING_SPEED, 0.25D)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_1)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
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

				if (this.level().getDifficulty() == Difficulty.NORMAL) {
					effectTime = 5;
				} else if (this.level().getDifficulty() == Difficulty.HARD) {
					effectTime = 10;
				}

				if (effectTime > 0) {
					livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, effectTime * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aiStep() {
		if (!this.level().isClientSide && isPassenger()) {
			stopRiding();
		}

		this.beaconMonster(6, (entity) -> {
			if (!(entity instanceof Player)) {
				entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60 * 20, 1, true, true));
			}
		});

		if (playerDetection(DETECTION_RANGE, TargetingConditions.forNonCombat())) {
			if (spawnLimit <= 3 && canSpawn) {
				if (spawnTimer != 60) {
					spawnTimer += 1;
				}

				if (spawnTimer == 60) {
					this.level().broadcastEntityEvent(this, (byte) 9);

					if (!this.level().isClientSide) {
						switch (random.nextInt(4)) {
							case 0 -> {
								boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this);
								if (!flag) {
									setSpawn(0);
								} else {
									setSpawn(1);
								}
							}
							case 1 -> setSpawn(1);
							case 2 -> setSpawn(2);
							case 3 -> setSpawn(3);
							default -> {
							}
						}
					}

					spawnTimer = 0;
					spawnLimit += 1;
				}
			}

			if (spawnLimit >= 4 && canSpawn) {
				setGoals(1);

				canSpawn = false;
			}
		}

		Vec3 motion = this.getDeltaMovement();
		if (!this.onGround() && motion.y < 0.0D) {
			this.setDeltaMovement(motion.multiply(1.0D, 0.6D, 1.0D));
		}

		motion = this.getDeltaMovement();
		if (motion.x > 0 || motion.y > 0 || motion.z > 0) {
			for (int i = 0; i < 2; ++i) {
				this.level().addParticle(ParticleTypes.ENCHANT,
						getX() + (random.nextDouble() - 0.5D) * getBbWidth(),
						getY() + random.nextDouble() * getBbHeight(),
						getZ() + (random.nextDouble() - 0.5D) * getBbWidth(), 0.0D, 0.0D, 0.0D);
			}
		}

		if (isOnFire()) {
			addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
			addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
		}

		super.aiStep();
	}

	private void setSpawn(int id) {
		if (!this.level().isClientSide) {
			BlockPos blockpos = blockPosition().offset(-1 + random.nextInt(3), 1, -1 + random.nextInt(3));

			if (id == 0) {
				Creeper summon = EntityType.CREEPER.create(this.level());
				if (summon != null) {
					summon.moveTo(blockpos, 0.0F, 0.0F);
					summon.finalizeSpawn((ServerLevel) this.level(), this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
					this.level().addFreshEntity(summon);
				}
			}

			if (id == 1) {
				Skeleton summon = EntityType.SKELETON.create(this.level());
				if (summon != null) {
					summon.moveTo(blockpos, 0.0F, 0.0F);
					summon.finalizeSpawn((ServerLevel) this.level(), this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
					summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GaiaRegistry.HEADGEAR_MOB.get()));
					summon.setDropChance(EquipmentSlot.MAINHAND, 0);
					summon.setDropChance(EquipmentSlot.OFFHAND, 0);
					summon.setDropChance(EquipmentSlot.FEET, 0);
					summon.setDropChance(EquipmentSlot.LEGS, 0);
					summon.setDropChance(EquipmentSlot.CHEST, 0);
					summon.setDropChance(EquipmentSlot.HEAD, 0);
					this.level().addFreshEntity(summon);
				}
			}

			if (id == 2) {
				Spider summon = EntityType.SPIDER.create(this.level());
				if (summon != null) {
					summon.moveTo(blockpos, 0.0F, 0.0F);
					summon.finalizeSpawn((ServerLevel) this.level(), this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
					this.level().addFreshEntity(summon);
				}
			}

			if (id == 3) {
				Zombie summon = EntityType.ZOMBIE.create(this.level());
				if (summon != null) {
					summon.moveTo(blockpos, 0.0F, 0.0F);
					summon.finalizeSpawn((ServerLevel) this.level(), this.level().getCurrentDifficultyAt(blockpos), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
					summon.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GaiaRegistry.HEADGEAR_MOB.get()));
					summon.setDropChance(EquipmentSlot.MAINHAND, 0);
					summon.setDropChance(EquipmentSlot.OFFHAND, 0);
					summon.setDropChance(EquipmentSlot.FEET, 0);
					summon.setDropChance(EquipmentSlot.LEGS, 0);
					summon.setDropChance(EquipmentSlot.CHEST, 0);
					summon.setDropChance(EquipmentSlot.HEAD, 0);
					this.level().addFreshEntity(summon);
				}
			}
		}

		this.level().broadcastEntityEvent(this, (byte) 6);
	}

	private void setGoals(int id) {
		if (id == 0) {
			this.goalSelector.removeGoal(mobAttackGoal);
			this.goalSelector.addGoal(1, strafeGoal);
		} else {
			this.goalSelector.removeGoal(strafeGoal);
			this.goalSelector.addGoal(1, mobAttackGoal);
		}
	}

	private void setCombatTask() {
		this.goalSelector.removeGoal(mobAttackGoal);
		this.goalSelector.removeGoal(strafeGoal);

		setGoals(1);
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(GaiaRegistry.ZOMBIE_STAFF.get()));
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		this.populateDefaultEquipmentSlots(random, difficultyInstance);
		this.populateDefaultEquipmentSlots(random, difficultyInstance);

		this.setCombatTask();

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		setCombatTask();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.BOOK_HIT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.BOOK_HIT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.BOOK_HIT.get();
	}

	@Override
	protected MovementEmission getMovementEmission() {
		return MovementEmission.NONE;
	}

	public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
		return false;
	}

	protected void checkFallDamage(double p_27754_, boolean p_27755_, BlockState state, BlockPos pos) {
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_UNDERGROUND;
	}

	public static boolean checkDeathwordSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkBelowSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}