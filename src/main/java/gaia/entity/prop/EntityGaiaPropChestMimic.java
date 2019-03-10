package gaia.entity.prop;

import gaia.entity.EntityMobProp;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.helpers.LootHelper;
import gaia.init.GaiaEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumLightType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

//TODO Missing model
public class EntityGaiaPropChestMimic extends EntityMobProp {
	private static final String ROTATION_TAG = "Rotation";
	private static final String DROP_TAG = "Drop";

	private static final DataParameter<Integer> ROTATION = EntityDataManager.createKey(EntityGaiaPropChestMimic.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> DROP = EntityDataManager.createKey(EntityGaiaPropChestMimic.class, DataSerializers.VARINT);

	private boolean spawned;

	public EntityGaiaPropChestMimic(World worldIn) {
		super(GaiaEntities.CHEST, worldIn);
		setSize(0.8F, 0.8F);
		experienceValue = 0;
		prevRenderYawOffset = 180.0F;
		renderYawOffset = 180.0F;
		spawned = false;
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
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

		return super.onInitialSpawn(difficulty, entityLivingData, itemNbt);
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
		if (playerDetection() && getDrop() == 2) {
			attackEntityFrom(DamageSource.GENERIC, 2.0F);
			world.setEntityState(this, (byte) 7);
			setSpawn((byte) 0);
		}

		super.livingTick();
	}

	private void setSpawn(byte id) {
		EntityGaiaMimic mimic;

		if ((id == 0) && !spawned) {
			mimic = new EntityGaiaMimic(world);
			mimic.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			mimic.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(mimic)), null, null);
			world.spawnEntity(mimic);
			spawned = true;
		}
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection() {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(4);
		List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		return !list.isEmpty();
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
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
	public void writeAdditional(NBTTagCompound compound) {
		super.writeAdditional(compound);
		compound.setByte(ROTATION_TAG, (byte) getRotation());
		compound.setByte(DROP_TAG, (byte) getDrop());
	}

	@Override
	public void readAdditional(NBTTagCompound compound) {
		super.readAdditional(compound);
		if (compound.hasKey(ROTATION_TAG)) {
			byte b0 = compound.getByte(ROTATION_TAG);
			setRotation(b0);
		}

		if (compound.hasKey(DROP_TAG)) {
			byte b1 = compound.getByte(DROP_TAG);
			setDrop(b1);
		}
	}

	protected void playParticleEffect(boolean play) {
		IParticleData enumparticletypes = Particles.LARGE_SMOKE;

		if (!play) {
			enumparticletypes = Particles.EXPLOSION;
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.spawnParticle(enumparticletypes, posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, d0, d1, d2);
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
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		if (getDrop() == 1) {
			world.setEntityState(this, (byte) 7);
			setSpawn((byte) 0);
		} else if (getDrop() == 0) {
			world.setEntityState(this, (byte) 6);
			LootHelper.dropRandomLootAtEntityPos(world, attackingPlayer, this, wasRecentlyHit, LootTableList.CHESTS_SIMPLE_DUNGEON, 2);
		}
	}

	@Override
	protected void onDeathUpdate() {
		remove();
	}

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
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

	/**
	 * @see EntityMob
	 */
	private boolean isValidLightLevel() {
		BlockPos blockpos = new BlockPos(this.posX, this.getBoundingBox().minY, this.posZ);
		if (this.world.getLightFor(EnumLightType.SKY, blockpos) > this.rand.nextInt(32)) {
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
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		return posY < 32.0D && world.getDifficulty() != EnumDifficulty.PEACEFUL && isValidLightLevel() && super.canSpawn(world, p_205020_2_);
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
