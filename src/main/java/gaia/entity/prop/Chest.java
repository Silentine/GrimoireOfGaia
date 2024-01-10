package gaia.entity.prop;

import gaia.entity.Mimic;
import gaia.registry.GaiaLootTables;
import gaia.registry.GaiaRegistry;
import gaia.util.LootHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Chest extends AbstractPropEntity {
	private static final EntityDataAccessor<Integer> ROTATION = SynchedEntityData.defineId(Chest.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DROP = SynchedEntityData.defineId(Chest.class, EntityDataSerializers.INT);

	public Chest(EntityType<? extends AgeableMob> type, Level level) {
		super(type, level);

		this.xpReward = 0;
		this.yBodyRotO = 180.0F;
		this.yBodyRot = 180.0F;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 1.0F);
	}

	@Override
	public void knockback(double strength, double xRatio, double zRatio) {
	}

	@Override
	public void aiStep() {
		if (playerDetection() && getDrop() == 2) {
			if (!this.level().isClientSide) {
				spawnMimic();
			}
			discard();
		}

		super.aiStep();
	}

	private void spawnMimic() {
		if (this.level().getDifficulty() != Difficulty.PEACEFUL) {
			Mimic mimic = GaiaRegistry.MIMIC.getEntityType().create(this.level());
			if (mimic != null) {
				mimic.moveTo(blockPosition(), 0.0F, 0.0F);
				mimic.finalizeSpawn((ServerLevel) this.level(), this.level().getCurrentDifficultyAt(blockPosition()), MobSpawnType.MOB_SUMMONED, (SpawnGroupData) null, (CompoundTag) null);
				this.level().addFreshEntity(mimic);
			}
		}

		this.level().broadcastEntityEvent(this, (byte) 6);
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection() {
		AABB aabb = (new AABB(getX(), getY(), getZ(), getX() + 1, getY() + 1, getZ() + 1)).inflate(4);
		List<Player> list = this.level().getEntitiesOfClass(Player.class, aabb);

		return !list.isEmpty();
	}

	@Override
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		hurt(damageSources().generic(), 2.0F);
		return super.mobInteract(player, hand);
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

		RandomSource random = levelAccessor.getRandom();
		switch (random.nextInt(4)) {
			case 0 -> setRotation(0);
			case 1 -> setRotation(1);
			case 2 -> setRotation(2);
			case 3 -> setRotation(3);
		}

		if (random.nextInt(2) == 0) {
			if (random.nextInt(2) == 0) {
				setDrop(2);
			} else {
				setDrop(1);
			}
		} else {
			setDrop(0);
		}

		return data;
	}

	protected MovementEmission getMovementEmission() {
		return MovementEmission.NONE;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ROTATION, 0);
		this.entityData.define(DROP, 0);
	}

	public int getRotation() {
		return this.entityData.get(ROTATION);
	}

	public void setRotation(int rotation) {
		this.entityData.set(ROTATION, rotation);
	}

	public int getDrop() {
		return this.entityData.get(DROP);
	}

	public void setDrop(int drop) {
		this.entityData.set(DROP, drop);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putByte("rotation", (byte) getRotation());
		tag.putByte("drop", (byte) getDrop());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.contains("rotation"))
			this.setRotation(tag.getByte("rotation"));
		if (tag.contains("drop"))
			this.setDrop(tag.getByte("drop"));
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
		return SoundEvents.CHEST_CLOSE;
	}

	@Override
	protected ResourceLocation getDefaultLootTable() {
		if (getDrop() == 2) {
			return null;
		} else if (getDrop() == 1) {
			this.level().broadcastEntityEvent(this, (byte) 7);
			spawnMimic();
			return null;
		} else {
			return super.getDefaultLootTable();
		}
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource damageSource, int looting, boolean killedByPlayer) {
		if (!this.level().isClientSide) {
			LootTable loottable = this.level().getServer().getLootData().getLootTable(GaiaLootTables.CHEST_TABLES);

			LootParams.Builder lootcontext$builder = (new LootParams.Builder((ServerLevel) this.level()))
					.withParameter(LootContextParams.THIS_ENTITY, this).withParameter(LootContextParams.ORIGIN, this.position())
					.withParameter(LootContextParams.DAMAGE_SOURCE, damageSource).withOptionalParameter(LootContextParams.KILLER_ENTITY, damageSource.getEntity())
					.withOptionalParameter(LootContextParams.DIRECT_KILLER_ENTITY, damageSource.getDirectEntity());
			if (killedByPlayer && this.lastHurtByPlayer != null) {
				lootcontext$builder = lootcontext$builder.withParameter(LootContextParams.LAST_DAMAGE_PLAYER, this.lastHurtByPlayer).withLuck(this.lastHurtByPlayer.getLuck());
			}

			List<ItemStack> stacks = LootHelper.getStacksFromTable((ServerLevel) this.level(),
					lootcontext$builder, LootContextParamSets.ENTITY, GaiaLootTables.CHEST_TABLES, 2 + Mth.clamp(looting, 0, 2));
			stacks.forEach(this::spawnAtLocation);
		}
		super.dropCustomDeathLoot(damageSource, looting, killedByPlayer);
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

	public static boolean checkChestSpawnRules(EntityType<? extends AgeableMob> entityType, ServerLevelAccessor levelAccessor, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkDaysPassed(levelAccessor) && checkBelowSeaLevel(levelAccessor, pos) && checkPropSpawnRules(entityType, levelAccessor, spawnType, pos, random);
	}
}
