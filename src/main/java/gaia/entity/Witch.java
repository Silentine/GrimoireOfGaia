package gaia.entity;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownSplashPotion;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class Witch extends AbstractGaiaEntity implements RangedAttackMob {

	private static final EntityDataAccessor<Boolean> IS_DRINKING = SynchedEntityData.defineId(Witch.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_RIDING = SynchedEntityData.defineId(Witch.class, EntityDataSerializers.BOOLEAN);

	private static final Identifier DRINKING_ID = GrimoireOfGaia.modLoc("drinking");
	private static final AttributeModifier SPEED_MODIFIER_DRINKING = new AttributeModifier(DRINKING_ID, -0.25D, AttributeModifier.Operation.ADD_VALUE);

	protected final FlyingMoveControl flyingControl;
	protected final MoveControl normalControl;
	private int spawn;
	private int usingTime;

	public Witch(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		this.xpReward = SharedEntityData.EXPERIENCE_VALUE_2;
		this.flyingControl = new FlyingMoveControl(this, 20, true);
		this.normalControl = new MoveControl(this);
		spawn = 0;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, SharedEntityData.ATTACK_SPEED_2, 60, 10F));
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 80.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_RANGED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_2)
				.add(Attributes.ATTACK_DAMAGE, 8.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_2)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_2)
				.add(Attributes.FLYING_SPEED, (double) 0.6F)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}

	@Override
	public int getGaiaLevel() {
		return 2;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(IS_DRINKING, false);
		builder.define(IS_RIDING, false);
	}

	public void setUsingItem(boolean value) {
		this.getEntityData().set(IS_DRINKING, value);
	}

	public boolean isDrinkingPotion() {
		return this.getEntityData().get(IS_DRINKING);
	}

	public void setRidingBroom(boolean value) {
		this.getEntityData().set(IS_RIDING, value);
	}

	public boolean isRidingBroom() {
		return this.getEntityData().get(IS_RIDING);
	}

	@Override
	public int maxVariants() {
		return 1;
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

	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (!this.isDrinkingPotion()) {
			Vec3 vec3 = target.getDeltaMovement();
			double d0 = target.getX() + vec3.x - this.getX();
			double d1 = target.getEyeY() - (double) 1.1F - this.getY();
			double d2 = target.getZ() + vec3.z - this.getZ();
			double d3 = Math.sqrt(d0 * d0 + d2 * d2);
			Holder<Potion> potion = Potions.HARMING;
			if (target instanceof Raider) {
				if (target.getHealth() <= 4.0F) {
					potion = Potions.HEALING;
				} else {
					potion = Potions.REGENERATION;
				}

				this.setTarget((LivingEntity) null);
			} else if (d3 >= 8.0D && !target.hasEffect(MobEffects.SLOWNESS)) {
				potion = Potions.SLOWNESS;
			} else if (target.getHealth() >= 8.0F && !target.hasEffect(MobEffects.POISON)) {
				potion = Potions.POISON;
			} else if (d3 <= 3.0D && !target.hasEffect(MobEffects.WEAKNESS) && this.random.nextFloat() < 0.25F) {
				potion = Potions.WEAKNESS;
			}

			ItemStack potionStack = new ItemStack(Items.SPLASH_POTION);
			potionStack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
			ThrownSplashPotion splashPotion = new ThrownSplashPotion(this.level(), this, potionStack);
			splashPotion.setXRot(splashPotion.getXRot() + 20.0F);
			splashPotion.shoot(d0, d1 + d3 * 0.2D, d2, 0.75F, 8.0F);
			if (!this.isSilent()) {
				this.level().playSound((Player) null, this.getX(), this.getY(), this.getZ(), SoundEvents.WITCH_THROW, this.getSoundSource(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
			}

			this.level().addFreshEntity(splashPotion);
		}
	}

	@Override
	public void aiStep() {
		Vec3 motion = this.getDeltaMovement();
		if (!this.onGround() && motion.y < 0.0D) {
			this.setDeltaMovement(motion.multiply(1.0D, 0.6D, 1.0D));
		}

		this.beaconMonster(6, (entity) -> {
			if (entity instanceof Zombie || entity instanceof Skeleton) {
				entity.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 300, 1, true, true));
			}
		});

		if (!this.level().isClientSide() && isPassenger() && isRidingBroom()) {
			stopRiding();
		}

		motion = this.getDeltaMovement();
		if (motion.x > 0 || motion.y > 0 || motion.z > 0) {
			for (int i = 0; i < 2; ++i) {
				this.level().addParticle(ParticleTypes.WITCH,
						getX() + (random.nextDouble() - 0.5D) * getBbWidth(),
						getY() + random.nextDouble() * getBbHeight(),
						getZ() + (random.nextDouble() - 0.5D) * getBbWidth(),
						0.0D, 0.0D, 0.0D);
			}
		}

		if (getHealth() < getMaxHealth() * 0.75F && getHealth() > 0.0F && spawn == 0) {
			this.level().broadcastEntityEvent(this, (byte) 9);

			if (!this.level().isClientSide()) {
				setSpawn(0);
			}
			spawn = 1;
		}

		if (getHealth() < getMaxHealth() * 0.25F && getHealth() > 0.0F && spawn == 1) {
			this.level().broadcastEntityEvent(this, (byte) 9);

			if (!this.level().isClientSide()) {
				setSpawn(1);
			}
			spawn = 2;
		}

		/* WITCH CODE */
		if (this.isDrinkingPotion()) {
			if (this.usingTime-- <= 0) {
				this.setUsingItem(false);
				ItemStack itemstack = this.getMainHandItem();
				this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
				if (itemstack.is(Items.POTION)) {
					List<MobEffectInstance> list = itemstack.get(DataComponents.POTION_CONTENTS).customEffects();
					if (list != null) {
						for (MobEffectInstance mobeffectinstance : list) {
							this.addEffect(new MobEffectInstance(mobeffectinstance));
						}
					}
				}

				this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(DRINKING_ID);
			}
		} else {
			Holder<Potion> potion = null;
			if (this.random.nextFloat() < 0.15F && this.isEyeInFluid(FluidTags.WATER) && !this.hasEffect(MobEffects.WATER_BREATHING)) {
				potion = Potions.WATER_BREATHING;
			} else if (this.random.nextFloat() < 0.15F && (this.isOnFire() || this.getLastDamageSource() != null && this.getLastDamageSource().is(DamageTypeTags.IS_FIRE)) && !this.hasEffect(MobEffects.FIRE_RESISTANCE)) {
				potion = Potions.FIRE_RESISTANCE;
			} else if (this.random.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
				potion = Potions.HEALING;
			} else if (this.random.nextFloat() < 0.5F && this.getTarget() != null && !this.hasEffect(MobEffects.SPEED) && this.getTarget().distanceToSqr(this) > 121.0D) {
				potion = Potions.SWIFTNESS;
			}

			if (potion != null) {
				ItemStack potionStack = new ItemStack(Items.POTION);
				potionStack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
				this.setItemSlot(EquipmentSlot.MAINHAND, potionStack);
				this.usingTime = this.getMainHandItem().getUseDuration(this);
				this.setUsingItem(true);
				if (!this.isSilent()) {
					this.level().playSound((Player) null, this.getX(), this.getY(), this.getZ(), SoundEvents.WITCH_DRINK, this.getSoundSource(), 1.0F, 0.8F + this.random.nextFloat() * 0.4F);
				}

				AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
				attributeinstance.removeModifier(DRINKING_ID);
				attributeinstance.addTransientModifier(SPEED_MODIFIER_DRINKING);
			}
		}
		/* WITCH CODE */

		super.aiStep();
	}

	@Override
	public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack stack) {
		if (equipmentSlot == EquipmentSlot.OFFHAND) {
			if (stack.is(GaiaRegistry.BROOM.get())) {
				this.moveControl = this.flyingControl;
				setRidingBroom(true);
			} else {
				this.moveControl = this.normalControl;
				setRidingBroom(false);
			}
		}
		super.setItemSlot(equipmentSlot, stack);
	}

	private void setSpawn(int id) {
		if (this.level() instanceof ServerLevel serverLevel) {
			BlockPos blockpos = (blockPosition()).offset(-1 + random.nextInt(3), 1, -1 + random.nextInt(3));

			Monster monster = id == 0 ?
					EntityTypes.ZOMBIE.create(serverLevel, EntitySpawnReason.MOB_SUMMONED) :
					EntityTypes.SKELETON.create(serverLevel, EntitySpawnReason.MOB_SUMMONED);
			if (monster != null) {
				monster.snapTo(blockpos, 0.0F, 0.0F);
				EventHooks.finalizeMobSpawn(monster, serverLevel, serverLevel.getCurrentDifficultyAt(blockpos), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
				monster.setItemSlot(EquipmentSlot.HEAD, new ItemStack(GaiaRegistry.HEADGEAR_MOB.get()));
				monster.setDropChance(EquipmentSlot.MAINHAND, 0);
				monster.setDropChance(EquipmentSlot.OFFHAND, 0);
				monster.setDropChance(EquipmentSlot.FEET, 0);
				monster.setDropChance(EquipmentSlot.LEGS, 0);
				monster.setDropChance(EquipmentSlot.CHEST, 0);
				monster.setDropChance(EquipmentSlot.HEAD, 0);
				this.level().addFreshEntity(monster);
			}
		}
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
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(random.nextInt(2) == 0 ? GaiaRegistry.ZOMBIE_STAFF.get() : GaiaRegistry.SKELETON_STAFF.get()));

		if (random.nextInt(2) == 0) {
			setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(GaiaRegistry.BROOM.get()));
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
	                                    EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		if (random.nextInt(4) == 0) {
			setVariant(1);
		}

		this.populateDefaultEquipmentSlots(random, difficultyInstance);

		if (random.nextInt(2) != 0) {
			this.lootTable = EntityTypes.WITCH.getDefaultLootTable();
		}

		return data;
	}

	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return effectInstance.getEffect() != MobEffects.POISON &&
				effectInstance.getEffect() != MobEffects.INSTANT_DAMAGE && super.canBeAffected(effectInstance);
	}

	@Override
	public boolean causeFallDamage(double fallDistance, float damageModifier, DamageSource damageSource) {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.WITCH.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.WITCH.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.WITCH.getDeath();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_2;
	}

	public static boolean checkWitchSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}