package gaia.entity.prop;

import gaia.entity.AntWorker;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class AntHill extends AbstractPropEntity {
	private static final EntityDataAccessor<Integer> DETECTION = SynchedEntityData.defineId(AntHill.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> SPAWN_AMOUNT = SynchedEntityData.defineId(AntHill.class, EntityDataSerializers.INT);

	private int spawnTime;

	public AntHill(EntityType<? extends AgeableMob> type, Level level) {
		super(type, level);

		this.spawnTime = 0;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 40.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}

	@Override
	public void finalizeAttributes() {
		getAttribute(Attributes.MAX_HEALTH).setBaseValue(SharedEntityData.getMaxHealth1());
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		damage = source.is(DamageTypes.FELL_OUT_OF_WORLD) ? damage : Math.min(damage, SharedEntityData.getBaseDefense1());
		if (source.getEntity() instanceof Player player) {
			ItemStack itemstack = player.getItemInHand(player.getUsedItemHand());

			if (itemstack.is(ItemTags.SHOVELS)) {
				damage = damage * 8;
			} else {
				damage = 0F;
			}
		}


		return super.hurtServer(level, source, damage);
	}

	@Override
	public void knockback(double strength, double xRatio, double zRatio) {
	}

	@Override
	protected void customServerAiStep(ServerLevel level) {
		super.customServerAiStep(level);

		if (playerDetection()) {
			if (getSpawnAmount() > 0) {
				if ((spawnTime >= 0) && (spawnTime <= 60)) {
					++spawnTime;
				} else {
					if (!this.level().isClientSide()) {
						setSpawn(0);
					}

					hurt(damageSources().generic(), getMaxHealth() / getSpawnAmount());

					setSpawnAmount(getSpawnAmount() - 1);

					spawnTime = 0;
				}
			} else {
				kill(level);
			}
		}

		if (this.level().getDifficulty() == Difficulty.PEACEFUL) {
			kill(level);
		}
	}

	private void setSpawn(int id) {
		if (this.level().getDifficulty() != Difficulty.PEACEFUL && this.level() instanceof ServerLevel serverLevel) {
			if (id == 0) {
				AntWorker antWorker = GaiaRegistry.ANT_WORKER.getEntityType().create(serverLevel, EntitySpawnReason.MOB_SUMMONED);
				if (antWorker != null) {
					antWorker.snapTo(blockPosition(), 0.0F, 0.0F);
					antWorker.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
					serverLevel.addFreshEntity(antWorker);
				}
			}
		}

		this.level().broadcastEntityEvent(this, (byte) 6);
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection() {
		AABB aabb = (new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1)).inflate(getDetection());
		List<Player> list = this.level().getEntitiesOfClass(Player.class, aabb);

		return !list.isEmpty();
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										EntitySpawnReason spawnType, @Nullable SpawnGroupData data) {
		data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, data);

		yBodyRot = 180.0F;
		yBodyRotO = 180.0F;
		setYRot(180.0F);
		yRotO = 180.0F;
		yHeadRot = 180.0F;
		yHeadRotO = 180.0F;

		if (random.nextInt(2) == 0) {
			setDetection(8);
			setSpawnAmount(4);
		} else {
			setDetection(6);
			setSpawnAmount(2);
		}

		return data;
	}

	protected Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.NONE;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DETECTION, -1);
		builder.define(SPAWN_AMOUNT, -1);
	}

	public int getDetection() {
		return this.entityData.get(DETECTION);
	}

	private void setDetection(int value) {
		this.entityData.set(DETECTION, value);
	}

	public int getSpawnAmount() {
		return this.entityData.get(SPAWN_AMOUNT);
	}

	private void setSpawnAmount(int value) {
		this.entityData.set(SPAWN_AMOUNT, value);
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
		output.putInt("Detection", getDetection());
		output.putInt("SpawnAmount", getSpawnAmount());
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
		setDetection(input.getIntOr("Detection", 0));
		setSpawnAmount(input.getIntOr("SpawnAmount", 0));
	}

	protected void playParticleEffect(boolean smoke) {
		ParticleOptions particle = ParticleTypes.SMOKE;

		if (!smoke) {
			particle = ParticleTypes.POOF;
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = random.nextGaussian() * 0.02D;
			double d1 = random.nextGaussian() * 0.02D;
			double d2 = random.nextGaussian() * 0.02D;
			this.level().addParticle(particle,
					getX() + (double) (random.nextFloat() * getBbWidth() * 2.0F) - (double) getBbWidth(),
					getY() + 0.5D + (double) (random.nextFloat() * getBbHeight()),
					getZ() + (double) (random.nextFloat() * getBbWidth() * 2.0F) - (double) getBbWidth(), d0, d1, d2);
		}
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == 7) {
			playParticleEffect(true);
		} else if (id == 6) {
			playParticleEffect(false);
		} else {
			super.handleEntityEvent(id);
		}
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.ANT_HILL_DEATH.get();
	}

	//Immune to potion effects
	@Override
	public boolean canBeAffected(MobEffectInstance effectInstance) {
		return false;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return 1;
	}

	@Override
	public int getMaxHeadXRot() {
		return 180;
	}

	@Override
	public int getMaxHeadYRot() {
		return 180;
	}

	@Override
	public void push(Entity entity) {
	}

	@Override
	public float getPickRadius() {
		return 0.0F;
	}

	public static boolean checkAntHillSpawnRules(EntityType<? extends AgeableMob> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkPropSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}
