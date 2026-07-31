package gaia.entity.prop;

import gaia.entity.Mandragora;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.registry.GaiaTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
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
import org.jspecify.annotations.Nullable;

public class CyanFlower extends AbstractPropEntity {

	public CyanFlower(EntityType<? extends AgeableMob> type, Level level) {
		super(type, level);

		this.xpReward = 0;
		this.yBodyRotO = 180.0F;
		this.yBodyRot = 180.0F;
	}

	@Override
	public float getWalkTargetValue(BlockPos pos) {
		return 0.0F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 1.0F);
	}

	@Override
	public void knockback(double power, double xd, double zd, DamageSource source, float damage) {
	}

	@Override
	public void knockback(double power, double xd, double zd, DamageSource source, float damage, boolean comesFromEffect) {
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
		Entity entity = source.getEntity();
		if (entity instanceof Player player) {
			ItemStack heldStack = player.getItemInHand(player.getUsedItemHand());
			if (heldStack.is(ItemTags.SHOVELS)) {
				damage = damage * 1.5F;
			}
		}

		return super.hurtServer(level, source, damage);
	}

	@Override
	public void aiStep() {
		super.aiStep();
	}

	private void spawnMandragora() {
		if (this.level().getDifficulty() != Difficulty.PEACEFUL && this.level() instanceof ServerLevel serverLevel) {
			Mandragora mandragora = GaiaRegistry.MANDRAGORA.getEntityType().create(serverLevel, EntitySpawnReason.MOB_SUMMONED);
			if (mandragora != null) {
				mandragora.snapTo(blockPosition(), 0.0F, 0.0F);
				mandragora.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
				serverLevel.addFreshEntity(mandragora);
			}
		}

		this.level().broadcastEntityEvent(this, (byte) 6);
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

		return data;
	}

	protected MovementEmission getMovementEmission() {
		return MovementEmission.NONE;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
		super.addAdditionalSaveData(output);
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
		super.readAdditionalSaveData(input);
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

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.GLASS_BREAK;
	}

	@Override
	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource damageSource, boolean killedByPlayer) {
		if (killedByPlayer) {
			if (random.nextInt(4) == 0) {
				if (!this.level().isClientSide()) {
					spawnMandragora();
					playSound(GaiaSounds.MANDRAGORA_SCREAM.get(), 2.0F, 2.0F);
				}
			} else {
				this.level().broadcastEntityEvent(this, (byte) 6);
				super.dropCustomDeathLoot(serverLevel, damageSource, killedByPlayer);
			}
		} else {
			super.dropCustomDeathLoot(serverLevel, damageSource, killedByPlayer);
		}
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
	public boolean canBeCollidedWith(@Nullable Entity other) {
		return false;
	}

	@Override
	public float getPickRadius() {
		return 0.0F;
	}

	public static boolean checkCyanFlowerSpawnRules(EntityType<? extends AgeableMob> entityType, ServerLevelAccessor levelAccessor, EntitySpawnReason spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) &&
				checkTagBlocks(levelAccessor, pos, GaiaTags.FLOWER_SPAWNABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) &&
				checkAnyLightMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}
