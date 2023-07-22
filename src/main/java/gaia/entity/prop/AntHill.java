package gaia.entity.prop;

import gaia.entity.AntWorker;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.util.SharedEntityData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

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
	public boolean hurt(DamageSource source, float damage) {
		float input = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, SharedEntityData.getBaseDefense1());
		if (source.getEntity() instanceof Player player) {
			ItemStack itemstack = player.getItemInHand(player.getUsedItemHand());

			if (itemstack.canPerformAction(ToolActions.SHOVEL_DIG)) {
				input = input * 8;
			} else {
				input = 0F;
			}
		}

		return super.hurt(source, input);
	}

	@Override
	public void knockback(double strength, double xRatio, double zRatio) {
	}

	@Override
	public void aiStep() {
		if (playerDetection()) {
			if (getSpawnAmount() > 0) {
				if ((spawnTime >= 0) && (spawnTime <= 60)) {
					++spawnTime;
				} else {
					if (!this.level.isClientSide) {
						setSpawn(0);
					}

					hurt(DamageSource.GENERIC, getMaxHealth() / getSpawnAmount());

					setSpawnAmount(getSpawnAmount() - 1);

					spawnTime = 0;
				}
			} else {
				kill();
			}
		}

		if (this.level.getDifficulty() == Difficulty.PEACEFUL) {
			kill();
		}

		super.aiStep();
	}

	private void setSpawn(int id) {
		if (this.level.getDifficulty() != Difficulty.PEACEFUL) {
			if (id == 0) {
				AntWorker antWorker = GaiaRegistry.ANT_WORKER.getEntityType().create(this.level);
				if (antWorker != null) {
					antWorker.moveTo(blockPosition(), 0.0F, 0.0F);
					antWorker.finalizeSpawn((ServerLevel) this.level, this.level.getCurrentDifficultyAt(blockPosition()), null, (SpawnGroupData) null, (CompoundTag) null);
					level.addFreshEntity(antWorker);
				}
			}
		}

		level.broadcastEntityEvent(this, (byte) 6);
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection() {
		AABB aabb = (new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1)).inflate(getDetection());
		List<Player> list = level.getEntitiesOfClass(Player.class, aabb);

		return !list.isEmpty();
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance,
										MobSpawnType spawnType, @Nullable SpawnGroupData groupData, @Nullable CompoundTag tag) {
		SpawnGroupData data = super.finalizeSpawn(levelAccessor, difficultyInstance, spawnType, groupData, tag);

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
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DETECTION, -1);
		this.entityData.define(SPAWN_AMOUNT, -1);
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
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putInt("Detection", getDetection());
		tag.putInt("SpawnAmount", getSpawnAmount());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("Detection")) {
			setDetection(tag.getInt("Detection"));
		}

		if (tag.contains("SpawnAmount")) {
			setSpawnAmount(tag.getInt("SpawnAmount"));
		}
	}

	protected void playParticleEffect(boolean smoke) {
		ParticleOptions particle = ParticleTypes.LARGE_SMOKE;

		if (!smoke) {
			particle = ParticleTypes.EXPLOSION;
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = random.nextGaussian() * 0.02D;
			double d1 = random.nextGaussian() * 0.02D;
			double d2 = random.nextGaussian() * 0.02D;
			level.addParticle(particle,
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

	public static boolean checkAntHillSpawnRules(EntityType<? extends AgeableMob> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkPropSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}
