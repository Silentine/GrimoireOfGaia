package gaia.entity.prop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobProp;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaPropAntHill extends EntityMobProp {

	private static final String DETECTION_TAG = "Detection_Range";
	private static final String SPAWN_AMOUNT_TAG = "Spawn_Amount";

	private static final DataParameter<Integer> DETECTION = EntityDataManager.createKey(EntityGaiaPropAntHill.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> SPAWN_AMOUNT = EntityDataManager.createKey(EntityGaiaPropAntHill.class, DataSerializers.VARINT);

	private int spawnTime;

	public EntityGaiaPropAntHill(World worldIn) {
		super(worldIn);
		setSize(1.0F, 0.5F);
		experienceValue = 0;
		prevRenderYawOffset = 180.0F;
		renderYawOffset = 180.0F;
		spawnTime = 0;
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

		if (world.rand.nextInt(2) == 0) {
			setDetection(8);
			setSpawnAmount(4);
		} else {
			setDetection(6);
			setSpawnAmount(2);
		}

		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		float input = damage;
		Entity entity = source.getTrueSource();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());

			if (itemstack.getItem() instanceof ItemSpade) {
				input = input * 8;
			} else {
				input = 0F;
			}
		}

		return super.attackEntityFrom(source, input);
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
		if (playerDetection()) {
			if (getSpawnAmount() > 0) {
				if ((spawnTime >= 0) && (spawnTime <= 60)) {
					++spawnTime;
				} else {
					if (!world.isRemote) {
						setSpawn((byte) 0);
					}

					attackEntityFrom(DamageSource.GENERIC, EntityAttributes.MAX_HEALTH_1 / getSpawnAmount());

					setSpawnAmount(getSpawnAmount() - 1);

					spawnTime = 0;
				}
			} else {
				setDead();
			}
		}

		if (world.getDifficulty() == EnumDifficulty.PEACEFUL) {
			setDead();
		}

		super.onLivingUpdate();
	}

	private void setSpawn(byte id) {
		EntityGaiaAnt ant;

		if (world.getDifficulty() != EnumDifficulty.PEACEFUL) {
			ant = new EntityGaiaAnt(world);
			ant.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			ant.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(ant)), null);
			ant.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.EGG));
			world.spawnEntity(ant);
		}

		world.setEntityState(this, (byte) 6);
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection() {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(getDetection());
		List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		return !list.isEmpty();
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(DETECTION, 0);
		dataManager.register(SPAWN_AMOUNT, 0);
	}

	public int getDetection() {
		return dataManager.get(DETECTION);
	}

	private void setDetection(int par1) {
		dataManager.set(DETECTION, par1);
	}

	public int getSpawnAmount() {
		return dataManager.get(SPAWN_AMOUNT);
	}

	private void setSpawnAmount(int par1) {
		dataManager.set(SPAWN_AMOUNT, par1);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setByte(DETECTION_TAG, (byte) getDetection());
		compound.setByte(SPAWN_AMOUNT_TAG, (byte) getSpawnAmount());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey(DETECTION_TAG)) {
			byte b0 = compound.getByte(DETECTION_TAG);
			setDetection(b0);
		}

		if (compound.hasKey(SPAWN_AMOUNT_TAG)) {
			byte b1 = compound.getByte(SPAWN_AMOUNT_TAG);
			setDetection(b1);
		}
	}

	protected void playParticleEffect(boolean play) {
		EnumParticleTypes enumparticletypes = EnumParticleTypes.SMOKE_LARGE;

		if (!play) {
			enumparticletypes = EnumParticleTypes.EXPLOSION_NORMAL;
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.spawnParticle(enumparticletypes, posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
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
		return GaiaSounds.ANT_SAY;
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

	/* SPAWN CONDITIONS */
	private static Set<Block> spawnBlocks = Sets.newHashSet(Blocks.SAND);

	public boolean spawnConditions() {
		if (world.isDaytime()) {
			float f = getBrightness();
			if (f > 0.5F && world.canSeeSky(getPosition())) {
				if (torchCheck(this.world, this.getPosition())) {
					return false;
				} else {
					int i = MathHelper.floor(posX);
					int j = MathHelper.floor(getEntityBoundingBox().minY);
					int k = MathHelper.floor(posZ);
					BlockPos blockpos = new BlockPos(i, j, k);
					Block var1 = world.getBlockState(blockpos.down()).getBlock();

					Set<String> additionalBlocks = new HashSet<String>(Arrays.asList(GaiaConfig.SPAWN.additionalFlowerSpawnBlocks));

					boolean defaultFlag = spawnBlocks.contains(var1);
					boolean additionalFlag = !additionalBlocks.isEmpty() && additionalBlocks.contains(var1.getRegistryName().toString());

					return world.getDifficulty() != EnumDifficulty.PEACEFUL && (defaultFlag || additionalFlag) && !world.containsAnyLiquid(getEntityBoundingBox());
				}
			}
		}
		return false;
	}

	private static Set<Block> blackList = Sets.newHashSet(GaiaBlocks.SPAWN_GUARD);

	/**
	 * The actual check. It inputs the radius and feeds it to the sphere shape method. After it gets the block position map it scans every block in that map. Then returns depending if the match triggers.
	 */
	private static boolean torchCheck(World world, BlockPos pos) {
		for (BlockPos location : BlockPos.getAllInBox(pos.add(-8, -8, -8), pos.add(8, 8, 8))) {
			if (blackList.contains(world.getBlockState(location).getBlock())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > ((!GaiaConfig.SPAWN.disableYRestriction) ? 60D : 0D) && world.getDifficulty() != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
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
