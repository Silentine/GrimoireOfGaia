package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.init.GaiaItem;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

public class EntityGaiaEnderDragonGirl extends EntityMobBase {
	private static final UUID attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier(attackingSpeedBoostModifierUUID, "Attacking speed boost", 6.0D, 0)).setSaved(false);
	private static final Set<Block> carriableBlocks = Sets.<Block>newIdentityHashSet();
	private boolean isAggressive;

	public EntityGaiaEnderDragonGirl(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 2.2F);
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.tasks.addTask(10, new EntityGaiaEnderDragonGirl.AIPlaceBlock(this));
		this.tasks.addTask(11, new EntityGaiaEnderDragonGirl.AITakeBlock(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(2, new EntityGaiaEnderDragonGirl.AIFindPlayer(this));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityEndermite.class, 10, true, false, new Predicate<EntityEndermite>() {
			public boolean apply(EntityEndermite p_apply_1_) {
				return p_apply_1_.isSpawnedByPlayer();
			}
		}));
	}

	public float getEyeHeight() {
		return 1.90F;
		//return 2.55F;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth2);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage2);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor2;
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Short((short)0));
		this.dataWatcher.addObject(17, new Byte((byte)0));
		this.dataWatcher.addObject(18, new Byte((byte)0));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		IBlockState iblockstate = this.getHeldBlockState();
		tagCompound.setShort("carried", (short)Block.getIdFromBlock(iblockstate.getBlock()));
		tagCompound.setShort("carriedData", (short)iblockstate.getBlock().getMetaFromState(iblockstate));
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		IBlockState iblockstate;

		if (tagCompund.hasKey("carried", 8)) {
			iblockstate = Block.getBlockFromName(tagCompund.getString("carried")).getStateFromMeta(tagCompund.getShort("carriedData") & 65535);
		}
		else {
			iblockstate = Block.getBlockById(tagCompund.getShort("carried")).getStateFromMeta(tagCompund.getShort("carriedData") & 65535);
		}

		this.setHeldBlockState(iblockstate);
	}

	/**
	 * Checks to see if this enderman should be attacking this player
	 */
	private boolean shouldAttackPlayer(EntityPlayer player) {
		ItemStack itemstack = player.inventory.armorInventory[3];

		if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
			return false;
		} else {
			Vec3 vec3 = player.getLook(1.0F).normalize();
			Vec3 vec31 = new Vec3(this.posX - player.posX, this.getEntityBoundingBox().minY + (double)(this.height / 2.0F) - (player.posY + (double)player.getEyeHeight()), this.posZ - player.posZ);
			double d0 = vec31.lengthVector();
			vec31 = vec31.normalize();
			double d1 = vec3.dotProduct(vec31);
			return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
		}
	}



	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		if (this.worldObj.isRemote) {
			for (int i = 0; i < 2; ++i) {
				this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
			}
		}

		this.isJumping = false;
		super.onLivingUpdate();
	}

	protected void updateAITasks() {
		if (this.isWet()) {
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		}

		if (this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0) {
			this.setScreaming(false);
		}

		if (this.worldObj.isDaytime()) {
			float f = this.getBrightness(1.0F);

			if (f > 0.5F && this.worldObj.canSeeSky(new BlockPos(this)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
				this.setAttackTarget((EntityLivingBase)null);
				this.setScreaming(false);
				this.isAggressive = false;
				this.teleportRandomly();
			}
		}

		super.updateAITasks();
	}

	/**
	 * Teleport the enderman to a random nearby position
	 */
	protected boolean teleportRandomly() {
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}

	/**
	 * Teleport the enderman to another entity
	 */
	protected boolean teleportToEntity(Entity p_70816_1_) {
		Vec3 vec3 = new Vec3(this.posX - p_70816_1_.posX, this.getEntityBoundingBox().minY + (double)(this.height / 2.0F) - p_70816_1_.posY + (double)p_70816_1_.getEyeHeight(), this.posZ - p_70816_1_.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
		double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
	}

	/**
	 * Teleport the enderman
	 */
	protected boolean teleportTo(double x, double y, double z) {
		net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
		double d0 = this.posX;
		double d1 = this.posY;
		double d2 = this.posZ;
		this.posX = event.targetX;
		this.posY = event.targetY;
		this.posZ = event.targetZ;
		boolean flag = false;
		BlockPos blockpos = new BlockPos(this.posX, this.posY, this.posZ);

		if (this.worldObj.isBlockLoaded(blockpos)) {
			boolean flag1 = false;

			while (!flag1 && blockpos.getY() > 0) {
				BlockPos blockpos1 = blockpos.down();
				Block block = this.worldObj.getBlockState(blockpos1).getBlock();

				if (block.getMaterial().blocksMovement()) {
					flag1 = true;
				}
				else {
					--this.posY;
					blockpos = blockpos1;
				}
			}

			if (flag1) {
				super.setPositionAndUpdate(this.posX, this.posY, this.posZ);

				if (this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox())) {
					flag = true;
				}
			}
		}

		if (!flag) {
			this.setPosition(d0, d1, d2);
			return false;
		} else {
			int i = 128;

			for (int j = 0; j < i; ++j) {
				double d6 = (double)j / ((double)i - 1.0D);
				float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				double d3 = d0 + (this.posX - d0) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
				double d4 = d1 + (this.posY - d1) * d6 + this.rand.nextDouble() * (double)this.height;
				double d5 = d2 + (this.posZ - d2) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
				this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, d3, d4, d5, (double)f, (double)f1, (double)f2, new int[0]);
			}

			this.worldObj.playSoundEffect(d0, d1, d2, "mob.endermen.portal", 1.0F, 1.0F);
			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	protected String getLivingSound() {
		return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
	}

	protected String getHurtSound() {
		return "mob.endermen.hit";
	}

	protected String getDeathSound() {
		return "mob.endermen.death";
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(Items.ender_pearl, 1);
		}
		
		int var5 = this.rand.nextInt(3 + par2) + 1;

		for (int var6 = 0; var6 < var5; ++var6) {
			this.dropItem(Item.getItemFromBlock(Blocks.end_stone), 1);
		}

		//Shards
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
			this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}

		if (par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1) > 0)) {
			this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 3), 0.0F);
		}

		//Very Rare
		if (par1 && (this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1) > 0)) {
			this.dropItem(GaiaItem.SpawnEnderGirl,1);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItem.BagOre, 1);
			break;
		case 1:
			this.dropItem(GaiaItem.BagBook, 1);
			break;
		case 2:
			this.dropItem(GaiaItem.BookEnder, 1);
		}
	}

	public void setCarried(int par1) {
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)(par1 & 255)));
	}


	/**
	 * Sets this enderman's held block state
	 */
	public void setHeldBlockState(IBlockState state) {
		this.dataWatcher.updateObject(16, Short.valueOf((short)(Block.getStateId(state) & 65535)));
	}

	/**
	 * Gets this enderman's held block state
	 */
	public IBlockState getHeldBlockState() {
		return Block.getStateById(this.dataWatcher.getWatchableObjectShort(16) & 65535);
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else {
			if (source.getEntity() == null || !(source.getEntity() instanceof EntityEndermite)) {
				if (!this.worldObj.isRemote) {
					this.setScreaming(true);
				}

				if (source instanceof EntityDamageSource && source.getEntity() instanceof EntityPlayer) {
					if (source.getEntity() instanceof EntityPlayerMP && ((EntityPlayerMP)source.getEntity()).theItemInWorldManager.isCreative()) {
						this.setScreaming(false);
					} else {
						this.isAggressive = true;
					}
				}

				if (source instanceof EntityDamageSourceIndirect) {
					this.isAggressive = false;

					for (int i = 0; i < 64; ++i) {
						if (this.teleportRandomly()) {
							return true;
						}
					}

					return false;
				}
			}

			boolean flag = super.attackEntityFrom(source, amount);

			if (source.isUnblockable() && this.rand.nextInt(10) != 0) {
				this.teleportRandomly();
			}

			return flag;
		}
	}

	/*===================================== Forge Start ==============================*/
	public static void setCarriable(Block block, boolean canCarry) {
		if (canCarry) carriableBlocks.add(block);
		else          carriableBlocks.remove(block);
	}
	public static boolean getCarriable(Block block) {
		return carriableBlocks.contains(block);
	}
	/*===================================== Forge End ==============================*/

	public boolean isScreaming() {
		return this.dataWatcher.getWatchableObjectByte(18) > 0;
	}

	public void setScreaming(boolean screaming) {
		this.dataWatcher.updateObject(18, Byte.valueOf((byte)(screaming ? 1 : 0)));
	}

	static {
		carriableBlocks.add(Blocks.grass);
		carriableBlocks.add(Blocks.dirt);
		carriableBlocks.add(Blocks.sand);
		carriableBlocks.add(Blocks.gravel);
		carriableBlocks.add(Blocks.yellow_flower);
		carriableBlocks.add(Blocks.red_flower);
		carriableBlocks.add(Blocks.brown_mushroom);
		carriableBlocks.add(Blocks.red_mushroom);
		carriableBlocks.add(Blocks.tnt);
		carriableBlocks.add(Blocks.cactus);
		carriableBlocks.add(Blocks.clay);
		carriableBlocks.add(Blocks.pumpkin);
		carriableBlocks.add(Blocks.melon_block);
		carriableBlocks.add(Blocks.mycelium);
	}

	static class AIFindPlayer extends EntityAINearestAttackableTarget {
		/** The player */
		private EntityPlayer player;
		private int field_179450_h;
		private int field_179451_i;
		private EntityGaiaEnderDragonGirl enderman;

		public AIFindPlayer(EntityGaiaEnderDragonGirl p_i45842_1_) {
			super(p_i45842_1_, EntityPlayer.class, true);
			this.enderman = p_i45842_1_;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			double d0 = this.getTargetDistance();
			List<EntityPlayer> list = this.taskOwner.worldObj.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, this.taskOwner.getEntityBoundingBox().expand(d0, 4.0D, d0), this.targetEntitySelector);
			Collections.sort(list, this.theNearestAttackableTargetSorter);

			if (list.isEmpty()) {
				return false;
			} else {
				this.player = (EntityPlayer)list.get(0);
				return true;
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_179450_h = 5;
			this.field_179451_i = 0;
		}

		/**
		 * Resets the task
		 */
		public void resetTask() {
			this.player = null;
			this.enderman.setScreaming(false);
			IAttributeInstance iattributeinstance = this.enderman.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			iattributeinstance.removeModifier(EntityGaiaEnderDragonGirl.attackingSpeedBoostModifier);
			super.resetTask();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean continueExecuting() {
			if (this.player != null) {
				if (!this.enderman.shouldAttackPlayer(this.player)) {
					return false;
				} else {
					this.enderman.isAggressive = true;
					this.enderman.faceEntity(this.player, 10.0F, 10.0F);
					return true;
				}
			} else {
				return super.continueExecuting();
			}
		}

		/**
		 * Updates the task
		 */
		public void updateTask() {
			if (this.player != null) {
				if (--this.field_179450_h <= 0) {
					this.targetEntity = this.player;
					this.player = null;
					super.startExecuting();
					this.enderman.playSound("mob.endermen.stare", 1.0F, 1.0F);
					this.enderman.setScreaming(true);
					IAttributeInstance iattributeinstance = this.enderman.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
					iattributeinstance.applyModifier(EntityGaiaEnderDragonGirl.attackingSpeedBoostModifier);
				}
			} else {
				if (this.targetEntity != null) {
					if (this.targetEntity instanceof EntityPlayer && this.enderman.shouldAttackPlayer((EntityPlayer)this.targetEntity)) {
						if (this.targetEntity.getDistanceSqToEntity(this.enderman) < 16.0D) {
							this.enderman.teleportRandomly();
						}

						this.field_179451_i = 0;
					}
					else if (this.targetEntity.getDistanceSqToEntity(this.enderman) > 256.0D && this.field_179451_i++ >= 30 && this.enderman.teleportToEntity(this.targetEntity)) {
						this.field_179451_i = 0;
					}
				}

				super.updateTask();
			}
		}
	}

	static class AIPlaceBlock extends EntityAIBase {
		private EntityGaiaEnderDragonGirl enderman;

		public AIPlaceBlock(EntityGaiaEnderDragonGirl p_i45843_1_) {
			this.enderman = p_i45843_1_;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return !this.enderman.worldObj.getGameRules().getBoolean("mobGriefing") ? false : (this.enderman.getHeldBlockState().getBlock().getMaterial() == Material.air ? false : this.enderman.getRNG().nextInt(4000) == 0);
		}

		/**
		 * Updates the task
		 */
		public void updateTask() {
			Random random = this.enderman.getRNG();
			World world = this.enderman.worldObj;
			int i = MathHelper.floor_double(this.enderman.posX - 1.0D + random.nextDouble() * 2.0D);
			int j = MathHelper.floor_double(this.enderman.posY + random.nextDouble() * 2.0D);
			int k = MathHelper.floor_double(this.enderman.posZ - 1.0D + random.nextDouble() * 2.0D);
			BlockPos blockpos = new BlockPos(i, j, k);
			Block block = world.getBlockState(blockpos).getBlock();
			Block block1 = world.getBlockState(blockpos.down()).getBlock();

			if (this.func_179474_a(world, blockpos, this.enderman.getHeldBlockState().getBlock(), block, block1)) {
				world.setBlockState(blockpos, this.enderman.getHeldBlockState(), 3);
				this.enderman.setHeldBlockState(Blocks.AIR.getDefaultState());
			}
		}

		private boolean func_179474_a(World worldIn, BlockPos p_179474_2_, Block p_179474_3_, Block p_179474_4_, Block p_179474_5_) {
			return !p_179474_3_.canPlaceBlockAt(worldIn, p_179474_2_) ? false : (p_179474_4_.getMaterial() != Material.air ? false : (p_179474_5_.getMaterial() == Material.air ? false : p_179474_5_.isFullCube()));
		}
	}

	static class AITakeBlock extends EntityAIBase {
		private EntityGaiaEnderDragonGirl enderman;

		public AITakeBlock(EntityGaiaEnderDragonGirl p_i45841_1_) {
			this.enderman = p_i45841_1_;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return !this.enderman.worldObj.getGameRules().getBoolean("mobGriefing") ? false : (this.enderman.getHeldBlockState().getBlock().getMaterial() != Material.air ? false : this.enderman.getRNG().nextInt(8000) == 0);
		}

		/**
		 * Updates the task
		 */
		public void updateTask() {
			Random random = this.enderman.getRNG();
			World world = this.enderman.worldObj;
			int i = MathHelper.floor_double(this.enderman.posX - 2.0D + random.nextDouble() * 4.0D);
			int j = MathHelper.floor_double(this.enderman.posY + random.nextDouble() * 3.0D);
			int k = MathHelper.floor_double(this.enderman.posZ - 2.0D + random.nextDouble() * 4.0D);
			BlockPos blockpos = new BlockPos(i, j, k);
			IBlockState iblockstate = world.getBlockState(blockpos);
			Block block = iblockstate.getBlock();

			if (EntityGaiaEnderDragonGirl.carriableBlocks.contains(block)) {
				this.enderman.setHeldBlockState(iblockstate);
				world.setBlockState(blockpos, Blocks.AIR.getDefaultState());
			}
		}
		
		public int getMaxSpawnedInChunk() {
			return 1;
		}
	}
}