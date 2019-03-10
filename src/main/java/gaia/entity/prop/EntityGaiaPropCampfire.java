package gaia.entity.prop;

import javax.annotation.Nullable;

import gaia.entity.EntityMobProp;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaLootTables;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaPropCampfire extends EntityMobProp {

	private static final String ROTATION_TAG = "Rotation";

	private static final DataParameter<Integer> ROTATION = EntityDataManager.createKey(EntityGaiaPropCampfire.class, DataSerializers.VARINT);

	public EntityGaiaPropCampfire(World worldIn) {
		super(worldIn);
		setSize(0.8F, 0.8F);
		experienceValue = 0;
		prevRenderYawOffset = 180.0F;
		renderYawOffset = 180.0F;
	}

	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		renderYawOffset = 180.0F;
		prevRenderYawOffset = 180.0F;
		rotationYaw = 180.0F;
		prevRotationYaw = 180.0F;
		rotationYawHead = 180.0F;
		prevRotationYawHead = 180.0F;

		if (canSpawn()) {
			for (int i = 0; i < 2; i++) {
				EntityGaiaDwarf dwarf;

				if (i == 0) {
					dwarf = new EntityGaiaDwarf(world);
					dwarf.classID = 2;
					dwarf.randomClass = false;
					dwarf.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
					dwarf.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(dwarf)), null);
					world.spawnEntity(dwarf);
				} else {
					dwarf = new EntityGaiaDwarf(world);
					dwarf.classID = rand.nextInt(2);
					dwarf.randomClass = false;
					dwarf.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
					dwarf.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(dwarf)), null);
					world.spawnEntity(dwarf);
				}
			}
		}

		switch (rand.nextInt(2)) {
		case 0:
			setRotation(0);
			break;
		case 1:
			setRotation(1);
			break;
		}

		if (!world.isRemote) {
			int i_block = MathHelper.floor(posX);
			int j_block = MathHelper.floor(posY);
			int k_block = MathHelper.floor(posZ);

			for (int l = 0; l < 4; ++l) {
				i_block = MathHelper.floor(posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
				j_block = MathHelper.floor(posY);
				k_block = MathHelper.floor(posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
				BlockPos blockpos = new BlockPos(i_block, j_block, k_block);

				if (world.getBlockState(blockpos).getMaterial() == Material.AIR) {
					world.setBlockState(blockpos, GaiaBlocks.FIRE_CAMP.getDefaultState());
				}
			}
		}

		return super.onInitialSpawn(difficulty, livingdata);
	}
	
	public boolean canSpawn() {
		int i = MathHelper.floor(posX);
		int j = MathHelper.floor(posY + 2.0D);
		int k = MathHelper.floor(posZ);
		IBlockState iblockstate = world.getBlockState(new BlockPos(i, j, k));

		int i1 = MathHelper.floor(posX);
		int j1 = MathHelper.floor(posY + 3.0D);
		int k1 = MathHelper.floor(posZ);
		IBlockState iblockstate_j = world.getBlockState(new BlockPos(i1, j1, k1));

		if (iblockstate.getMaterial() == Material.AIR && iblockstate_j.getMaterial() == Material.AIR) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0F);
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		if (getHealth() <= 0.0F) {
			if (!world.isRemote) {
				int i = MathHelper.floor(posX);
				int j = MathHelper.floor(posY);
				int k = MathHelper.floor(posZ);

				for (int l = 0; l < 4; ++l) {
					i = MathHelper.floor(posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
					j = MathHelper.floor(posY);
					k = MathHelper.floor(posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
					BlockPos blockpos = new BlockPos(i, j, k);

					world.setBlockState(blockpos, Blocks.AIR.getDefaultState());
				}
			}
		} else {
			super.onLivingUpdate();
		}
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(ROTATION, 0);
	}

	public int getRotation() {
		return dataManager.get(ROTATION);
	}

	private void setRotation(int par1) {
		dataManager.set(ROTATION, par1);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setByte(ROTATION_TAG, (byte) getRotation());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey(ROTATION_TAG)) {
			byte b0 = compound.getByte(ROTATION_TAG);
			setRotation(b0);
		}
	}

	protected void playParticleEffect() {
		EnumParticleTypes enumparticletypes = EnumParticleTypes.SMOKE_LARGE;

		for (int i = 0; i < 7; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.spawnParticle(enumparticletypes, posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 6) {
			playParticleEffect();
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_WOOD_BREAK;
	}
	
	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_CAMPFIRE;
	}

	@Override
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			switch (rand.nextInt(2)) {
			case 0:
				world.setEntityState(this, (byte) 6);
				for (int i = 0; i < drop; ++i) {
					dropItem(Items.COOKED_PORKCHOP, 1);
				}
				break;
			case 1:
				world.setEntityState(this, (byte) 6);
				for (int i = 0; i < drop; ++i) {
					entityDropItem(new ItemStack(Items.COAL, 1, 1), 0.0F);
				}
				break;
			}
		}
	}

	@Override
	protected void onDeathUpdate() {
		setDead();
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
		BlockPos blockpos = new BlockPos(posX, getEntityBoundingBox().minY, posZ);

		if (world.getLightFor(EnumSkyBlock.SKY, blockpos) > rand.nextInt(32)) {
			return false;
		} else {
			int i = world.getLightFromNeighbors(blockpos);

			if (world.isThundering()) {
				int j = world.getSkylightSubtracted();
				world.setSkylightSubtracted(10);
				i = world.getLightFromNeighbors(blockpos);
				world.setSkylightSubtracted(j);
			}

			return i <= rand.nextInt(8);
		}
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY < 60.0D && posY > 32.0D && world.getDifficulty() != EnumDifficulty.PEACEFUL && isValidLightLevel() && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox() {
		return isEntityAlive() ? getEntityBoundingBox() : null;
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
