package gaia.entity.prop;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobPropEntity;
import gaia.entity.hostile.GaiaMimicEntity;
import gaia.init.GaiaEntities;
import gaia.util.LootHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class GaiaPropChestMimicEntity extends AbstractMobPropEntity {
	private static final String ROTATION_TAG = "Rotation";
	private static final String DROP_TAG = "Drop";

	private static final DataParameter<Integer> ROTATION = EntityDataManager.createKey(GaiaPropChestMimicEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> DROP = EntityDataManager.createKey(GaiaPropChestMimicEntity.class, DataSerializers.VARINT);

	private boolean spawned;

	public GaiaPropChestMimicEntity(EntityType<? extends GaiaPropChestMimicEntity> type, World worldIn) {
		super(type, worldIn);
		experienceValue = 0;
		prevRenderYawOffset = 180.0F;
		renderYawOffset = 180.0F;
		spawned = false;
	}

	public GaiaPropChestMimicEntity(World worldIn) {
		super(GaiaEntities.CHEST.get(), worldIn);
	}
	
	@Override
	@Nullable
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT itemNbt) {
		renderYawOffset = 180.0F;
		prevRenderYawOffset = 180.0F;
		rotationYaw = 180.0F;
		prevRotationYaw = 180.0F;
		rotationYawHead = 180.0F;
		prevRotationYawHead = 180.0F;

		switch (rand.nextInt(4)) {
			case 0:
				setRotation(0);
				break;
			case 1:
				setRotation(1);
				break;
			case 2:
				setRotation(2);
				break;
			case 3:
				setRotation(3);
				break;
		}

		if (world.rand.nextInt(2) == 0) {
			if (world.rand.nextInt(2) == 0) {
				setDrop(2);
			} else {
				setDrop(1);
			}
		} else {
			setDrop(0);
		}

		return super.onInitialSpawn(worldIn, difficulty, reason, livingdata, itemNbt);
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0F);
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void livingTick() {
		if (playerDetection(this, 4) && getDrop() == 2) {
			attackEntityFrom(DamageSource.GENERIC, 2.0F);
			world.setEntityState(this, (byte) 7);
			setSpawn(0);
		}

		super.livingTick();
	}

	private void setSpawn(int id) {
		if ((id == 0) && !spawned) {
			GaiaMimicEntity mimic = new GaiaMimicEntity(world);
			mimic.setLocationAndAngles(getPosX(), getPosY(), getPosZ(), rotationYaw, 0.0F);
			mimic.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(mimic)), null, null, null);
			world.addEntity(mimic);
			spawned = true;
		}
	}

	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		attackEntityFrom(DamageSource.GENERIC, 2.0F);

		return super.processInteract(player, hand);
	}

	@Override
	protected void registerData() {
		super.registerData();
		getDataManager().register(ROTATION, 0);
		getDataManager().register(DROP, 0);
	}

	public int getRotation() {
		return dataManager.get(ROTATION);
	}

	private void setRotation(int par1) {
		dataManager.set(ROTATION, par1);
	}

	public int getDrop() {
		return dataManager.get(DROP);
	}

	private void setDrop(int par1) {
		dataManager.set(DROP, par1);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putByte(ROTATION_TAG, (byte) getRotation());
		compound.putByte(DROP_TAG, (byte) getDrop());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains(ROTATION_TAG)) {
			byte b0 = compound.getByte(ROTATION_TAG);
			setRotation(b0);
		}

		if (compound.contains(DROP_TAG)) {
			byte b1 = compound.getByte(DROP_TAG);
			setDrop(b1);
		}
	}

	protected void playParticleEffect(boolean play) {
		IParticleData enumparticletypes = ParticleTypes.LARGE_SMOKE;

		if (!play) {
			enumparticletypes = ParticleTypes.EXPLOSION;
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.addParticle(enumparticletypes, getPosX() + (double) (rand.nextFloat() * getWidth() * 2.0F) - (double) getWidth(), getPosY() + 0.5D + (double) (rand.nextFloat() * getHeight()), getPosZ() + (double) (rand.nextFloat() * getWidth() * 2.0F) - (double) getWidth(), d0, d1, d2);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 7) {
			playParticleEffect(true);
		} else if (id == 6) {
			playParticleEffect(false);
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_CHEST_OPEN;
	}

	@Override
	protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
		if (getDrop() == 1) {
			world.setEntityState(this, (byte) 7);
			setSpawn((byte) 0);
		} else if (getDrop() == 0) {
			world.setEntityState(this, (byte) 6);
			LootHelper.dropRandomLootAtEntityPos(world, attackingPlayer, this, wasRecentlyHit, LootTables.CHESTS_SIMPLE_DUNGEON, 2);
		}
	}

	@Override
	protected void onDeathUpdate() {
		remove();
	}

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(EffectInstance potioneffectIn) {
		return false;
	}
	/* IMMUNITIES */

	@Override
	protected void collideWithEntity(Entity entityIn) {
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	private boolean isValidLightLevel() {
		BlockPos blockpos = new BlockPos(this.getPosX(), this.getBoundingBox().minY, this.getPosZ());
		if (this.world.getLightFor(LightType.SKY, blockpos) > this.rand.nextInt(32)) {
			return false;
		} else {
			int i = this.world.isThundering() ? this.world.getNeighborAwareLightSubtracted(blockpos, 10) : this.world.getLight(blockpos);
			return i <= this.rand.nextInt(8);
		}
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}
	
	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
		return GaiaConfig.COMMON.disableYRestriction.get() ? true : getPosY() < 32.0D && worldIn.getDifficulty() != Difficulty.PEACEFUL && isValidLightLevel() && super.canSpawn(worldIn, reason);
	}
	/* SPAWN CONDITIONS */

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox() {
		return isAlive() ? getBoundingBox() : null;
	}

	@Override
	public int getVerticalFaceSpeed() {
		return 180;
	}

	@Override
	public int getHorizontalFaceSpeed() {
		return 180;
	}

	@Override
	public void applyEntityCollision(Entity entityIn) {
	}

	@Override
	public float getCollisionBorderSize() {
		return 0.0F;
	}
}
