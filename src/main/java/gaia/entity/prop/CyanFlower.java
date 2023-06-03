package gaia.entity.prop;

import gaia.entity.Mandragora;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.registry.GaiaTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

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
	public void knockback(double strength, double xRatio, double zRatio) {
	}

	@Override
	public boolean hurt(DamageSource source, float damage) {
		float input = damage;
		Entity entity = source.getEntity();
		if (entity instanceof Player player) {
			ItemStack heldStack = player.getItemInHand(player.getUsedItemHand());
			if (heldStack.canPerformAction(ToolActions.SHOVEL_DIG)) {
				input = input * 1.5F;
			}
		}

		return super.hurt(source, input);
	}

	@Override
	public void aiStep() {
		if (getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				level.addParticle(ParticleTypes.EXPLOSION,
						getX() + (random.nextDouble() - 0.5D) * getBbWidth(),
						getY() + random.nextDouble() * getBbHeight(),
						getZ() + (random.nextDouble() - 0.5D) * getBbWidth(),
						0.0D, 0.0D, 0.0D);
			}
		} else {
			super.aiStep();
		}
	}

	private void spawnMandragora() {
		if (level.getDifficulty() != Difficulty.PEACEFUL) {
			Mandragora mandragora = GaiaRegistry.MANDRAGORA.getEntityType().create(level);
			if (mandragora != null) {
				mandragora.moveTo(blockPosition(), 0.0F, 0.0F);
				mandragora.finalizeSpawn((ServerLevel) level, level.getCurrentDifficultyAt(blockPosition()), null, (SpawnGroupData) null, (CompoundTag) null);
				level.addFreshEntity(mandragora);
			}
		}

		level.broadcastEntityEvent(this, (byte) 6);
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

		return data;
	}

	protected MovementEmission getMovementEmission() {
		return MovementEmission.NONE;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
	}

	protected void playParticleEffect(boolean smoke) {
		ParticleOptions particle = ParticleTypes.SMOKE;

		if (!smoke) {
			particle = ParticleTypes.EXPLOSION;
		}

		for (int i = 0; i < 4; ++i) {
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

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.GLASS_BREAK;
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource damageSource, int looting, boolean killedByPlayer) {
		if (killedByPlayer) {
			if (random.nextInt(4) == 0) {
				if (!level.isClientSide) {
					spawnMandragora();
					playSound(GaiaSounds.MANDRAGORA_SCREAM.get(), 2.0F, 2.0F);
				}
			} else {
				level.broadcastEntityEvent(this, (byte) 6);
				super.dropCustomDeathLoot(damageSource, looting, killedByPlayer);
			}
		} else {
			super.dropCustomDeathLoot(damageSource, looting, killedByPlayer);
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
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public float getPickRadius() {
		return 0.0F;
	}

	public static boolean checkCyanFlowerSpawnRules(EntityType<? extends AgeableMob> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, Random random) {
		return checkDaysPassed(levelAccessor) &&
				checkTagBlocks(levelAccessor, pos, GaiaTags.FLOWER_SPAWNABLE_ON) &&
				checkAboveSeaLevel(levelAccessor, pos) &&
				checkAnyLightMonsterSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}
