package gaia.entity;

import gaia.config.GaiaConfig;
import gaia.entity.goal.CreepSwellGoal;
import gaia.entity.goal.MobAttackGoal;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.feline.Ocelot;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.event.EventHooks;
import org.jspecify.annotations.Nullable;

public class Creep extends AbstractGaiaEntity {
	private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(Creep.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_IS_POWERED = SynchedEntityData.defineId(Creep.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_IS_IGNITED = SynchedEntityData.defineId(Creep.class, EntityDataSerializers.BOOLEAN);

	private int oldSwell;
	private int swell;
	private int maxSwell = 30;
	private int explosionRadius = 3;

	public Creep(EntityType<? extends Monster> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new CreepSwellGoal(this));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Ocelot.class, 8.0F, 0.6D, 0.6D));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Cat.class, 8.0F, 0.6D, 0.6D));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Werecat.class, 8.0F, 0.6D, 0.6D));
		this.goalSelector.addGoal(4, new MobAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
		this.targetSelector.addGoal(2, this.targetPlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.FOLLOW_RANGE, SharedEntityData.FOLLOW_RANGE)
				.add(Attributes.MOVEMENT_SPEED, SharedEntityData.MOVE_SPEED_1)
				.add(Attributes.ATTACK_DAMAGE, 4.0D)
				.add(Attributes.ARMOR, SharedEntityData.RATE_ARMOR_1)
				.add(Attributes.KNOCKBACK_RESISTANCE, SharedEntityData.KNOCKBACK_1)
				.add(Attributes.STEP_HEIGHT, 1.0F);
	}

	@Override
	public boolean isInvisibleTo(Player player) {
		if (!GaiaConfig.COMMON.disableInvisibility.get()) {
			boolean invisible = !player.getAbilities().instabuild && player.distanceTo(this) > 8;
			if (isInvisible() != invisible) {
				setInvisible(invisible);
			}
			return invisible;
		}
		return super.isInvisibleTo(player);
	}

	@Override
	public void tick() {
		if (this.isAlive() && !isInvisible()) {
			this.oldSwell = this.swell;
			if (this.isIgnited()) {
				this.setSwellDir(1);
			}

			int i = this.getSwellDir();
			if (i > 0 && this.swell == 0) {
				this.playSound(GaiaSounds.CREEP_PRIMED.get(), 1.0F, 0.5F);
				this.gameEvent(GameEvent.PRIME_FUSE);
			}

			this.swell += i;
			if (this.swell < 0) {
				this.swell = 0;
			}

			if (this.swell >= this.maxSwell) {
				this.swell = this.maxSwell;
				this.explodeCreep();
			}
		}

		super.tick();
	}

	@Override
	public void setTarget(@Nullable LivingEntity livingEntity) {
		if (!(livingEntity instanceof Goat)) {
			super.setTarget(livingEntity);
		}
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_SWELL_DIR, -1);
		builder.define(DATA_IS_POWERED, false);
		builder.define(DATA_IS_IGNITED, false);
	}

	public boolean doHurtTarget(Entity entity) {
		return true;
	}

	public boolean isPowered() {
		return this.entityData.get(DATA_IS_POWERED);
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

	@Override
	public void thunderHit(ServerLevel level, LightningBolt bolt) {
		super.thunderHit(level, bolt);
		this.entityData.set(DATA_IS_POWERED, true);
	}

	@Override
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.is(Items.FLINT_AND_STEEL)) {
			this.level().playSound(player, this.getX(), this.getY(), this.getZ(), SoundEvents.FLINTANDSTEEL_USE, this.getSoundSource(), 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
			if (!this.level().isClientSide()) {
				this.ignite();
				itemstack.hurtAndBreak(1, player, hand.asEquipmentSlot());
			}

			return InteractionResult.SUCCESS;
		} else {
			return super.mobInteract(player, hand);
		}
	}

	private void explodeCreep() {
		if (this.level() instanceof ServerLevel serverLevel) {
			Level.ExplosionInteraction explosion$blockinteraction = EventHooks.canEntityGrief(serverLevel, this) ? Level.ExplosionInteraction.MOB : Level.ExplosionInteraction.NONE;
			float f = this.isPowered() ? 2.0F : 1.0F;
			this.dead = true;
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), (float) this.explosionRadius * f, explosion$blockinteraction);
			this.discard();
			this.spawnLingeringCloud(this.getActiveEffects().stream().toList());
		}
	}

	public boolean isIgnited() {
		return this.entityData.get(DATA_IS_IGNITED);
	}

	public void ignite() {
		this.entityData.set(DATA_IS_IGNITED, true);
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
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		if (this.entityData.get(DATA_IS_POWERED)) {
			output.putBoolean("powered", true);
		}

		output.putShort("Fuse", (short) this.maxSwell);
		output.putByte("ExplosionRadius", (byte) this.explosionRadius);
		output.putBoolean("ignited", this.isIgnited());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		this.entityData.set(DATA_IS_POWERED, input.getBooleanOr("powered", false));
		this.maxSwell = input.getShortOr("Fuse", (short) 0);
		this.explosionRadius = input.getByteOr("ExplosionRadius", (byte)0);

		if (input.getBooleanOr("ignited", false)) {
			this.ignite();
		}
	}

	/* Falling related */
	public int getMaxFallDistance() {
		return this.getTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
	}

	@Override
	public boolean causeFallDamage(double fallDistance, float damageModifier, DamageSource damageSource) {
		boolean flag = super.causeFallDamage(fallDistance, damageModifier, damageSource);
		this.swell += (int) (fallDistance * 1.5F);
		if (this.swell > this.maxSwell - 5) {
			this.swell = this.maxSwell - 5;
		}

		return flag;
	}
	/* Falling related */

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaRegistry.CREEP.getSay();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaRegistry.CREEP.getHurt();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaRegistry.CREEP.getDeath();
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return SharedEntityData.CHUNK_LIMIT_UNDERGROUND;
	}

	public static boolean checkCreepSpawnRules(EntityType<? extends Monster> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkBelowSeaLevel(levelAccessor, pos) && checkMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}