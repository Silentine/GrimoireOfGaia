package gaia.entity;

import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.RangedUtil;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

public class GoblinFeral extends AbstractGaiaEntity implements RangedAttackMob {
	private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(GoblinFeral.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_IS_IGNITED = SynchedEntityData.defineId(GoblinFeral.class, EntityDataSerializers.BOOLEAN);

	private final RangedBowAttackGoal<GoblinFeral> rangedAttackGoal = new RangedBowAttackGoal<>(this, SharedEntityData.ATTACK_SPEED_1, 20, 15.0F);
	private final MobAttackGoal collideAttackGoal = new MobAttackGoal(this, SharedEntityData.ATTACK_SPEED_1, true);

	private int oldSwell;
	private int swell;
	private int maxSwell = 30;
	private int explosionRadius = 3;

	public GoblinFeral(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
		setCanPickUpLoot(true);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));

		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(new Class[0]));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 20)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE_MIXED)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, 2)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.ATTACK_KNOCKBACK, SharedEntityData.KNOCKBACK_1)
				.add(ForgeMod.STEP_HEIGHT_ADDITION.get(), 1.0F);
	}

	@Override
	public void finalizeAttributes() {
		getAttribute(Attributes.MAX_HEALTH).setBaseValue(SharedEntityData.getMaxHealth1() * 0.5F);
		getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(SharedEntityData.getAttackDamage1() * 0.5F);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_SWELL_DIR, -1);
		this.entityData.define(DATA_IS_IGNITED, false);
	}

	public float getSwelling(float swell) {
		return Mth.lerp(swell, (float) this.oldSwell, (float) this.swell) / (float) (this.maxSwell - 2);
	}

	public int getSwellDir() {
		return this.entityData.get(DATA_SWELL_DIR);
	}

	public void setSwellDir(int direction) {
		this.entityData.set(DATA_SWELL_DIR, direction);
	}

	public boolean isIgnited() {
		return this.entityData.get(DATA_IS_IGNITED);
	}

	public void ignite() {
		this.entityData.set(DATA_IS_IGNITED, true);
	}

	@Override
	public int maxVariants() {
		return 2;
	}

	@Override
	public float getBaseDefense() {
		return SharedEntityData.getBaseDefense1();
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = getBaseDamage(source, damage);
		if (!getOffhandItem().isEmpty() && getOffhandItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
			return !(source.getDirectEntity() instanceof AbstractArrow) && super.hurt(source, input);
		}
		return super.hurt(source, input);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		boolean flag = super.doHurtTarget(entityIn);
		if (getVariant() == 2 && entityIn instanceof LivingEntity) {
			ignite();
		}

		return flag;
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		if (target.isAlive()) {
			RangedUtil.rangedAttack(target, this, distanceFactor);
		}
	}

	@Override
	public void tick() {
		if (this.isAlive()) {
			this.oldSwell = this.swell;
			if (this.isIgnited()) {
				this.goalSelector.removeGoal(collideAttackGoal);
				this.setSwellDir(1);
			}

			int i = this.getSwellDir();
			if (i > 0 && this.swell == 0) {
				this.playSound(GaiaSounds.GOBLIN_FERAL_PRIMED.get(), 1.0F, 0.5F);
				this.gameEvent(GameEvent.PRIME_FUSE);
			}

			this.swell += i;
			if (this.swell < 0) {
				this.swell = 0;
			}

			if (this.swell >= this.maxSwell) {
				this.swell = this.maxSwell;
				this.explode();
			}
		}

		super.tick();
	}

	private void explode() {
		if (!this.level.isClientSide) {
			Explosion.BlockInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
			this.dead = true;
			this.level.explode(this, this.getX(), this.getY(), this.getZ(), (float) this.explosionRadius, explosion$blockinteraction);
			this.discard();
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
		if (getMainHandItem().getItem() instanceof ProjectileWeaponItem) {
			int i = 20;

			if (this.level.getDifficulty() != Difficulty.HARD) {
				i = 40;
			}
			rangedAttackGoal.setMinAttackInterval(i);
			this.goalSelector.addGoal(1, rangedAttackGoal);
		} else {
			this.goalSelector.addGoal(1, collideAttackGoal);
		}
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance instance) {
		if (random.nextInt(4) == 0) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
			this.setVariant(1);
		} else {
			if (random.nextInt(4) == 0) {
				this.setVariant(2);
			} else {
				if (random.nextInt(4) == 0) {
					this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
					this.populateDefaultEquipmentEnchantments(random, instance);
				} else {
					this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
					this.populateDefaultEquipmentEnchantments(random, instance);
				}
				this.setVariant(0);
			}
		}
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

		this.populateDefaultEquipmentSlots(random, difficultyInstance);

		setCombatTask();

		return data;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putShort("Fuse", (short) this.maxSwell);
		tag.putByte("ExplosionRadius", (byte) this.explosionRadius);
		tag.putBoolean("ignited", this.isIgnited());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("Fuse", 99)) {
			this.maxSwell = tag.getShort("Fuse");
		}

		if (tag.contains("ExplosionRadius", 99)) {
			this.explosionRadius = tag.getByte("ExplosionRadius");
		}

		if (tag.getBoolean("ignited")) {
			this.ignite();
		}

		setCombatTask();
	}

	@Override
	public boolean canAttackType(EntityType<?> type) {
		return super.canAttackType(type) && type != GaiaRegistry.GOBLIN_FERAL.getEntityType();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.GOBLIN_FERAL.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.GOBLIN_FERAL.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.GOBLIN_FERAL.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_1;
	}

	public static boolean checkGoblinFeralSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkAboveSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}