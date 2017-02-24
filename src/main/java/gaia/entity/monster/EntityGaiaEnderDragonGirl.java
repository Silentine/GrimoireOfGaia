package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveBase;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

/** 
 * @see EntityEnderman
 */
public class EntityGaiaEnderDragonGirl extends EntityMobPassiveBase {
	private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier ATTACKING_SPEED_BOOST = (new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", 0.15000000596046448D, 0)).setSaved(false);
	private static final Set<Block> CARRIABLE_BLOCKS = Sets.<Block>newIdentityHashSet();
	private static final DataParameter<Optional<IBlockState>> CARRIED_BLOCK = EntityDataManager.<Optional<IBlockState>>createKey(EntityGaiaEnderDragonGirl.class, DataSerializers.OPTIONAL_BLOCK_STATE);
	private static final DataParameter<Boolean> SCREAMING = EntityDataManager.<Boolean>createKey(EntityGaiaEnderDragonGirl.class, DataSerializers.BOOLEAN);

	private int lastCreepySound;
	private int targetChangeTime;

	public EntityGaiaEnderDragonGirl(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 2.2F);
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, false));
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
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage2);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor2);
	}

	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > EntityAttributes.baseDefense2) {
			damage = EntityAttributes.baseDefense2;
		}
		
		if (this.isEntityInvulnerable(source)) {
			return false;
		} else if (source instanceof EntityDamageSourceIndirect) {
			for (int i = 0; i < 64; ++i) {
				if (this.teleportRandomly()) {
					return true;
				}
			}

			return false;
		} else {
			boolean flag = super.attackEntityFrom(source, damage);

			if (source.isUnblockable() && this.rand.nextInt(10) != 0) {
				this.teleportRandomly();
			}

			return flag;
		}
	}

    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(CARRIED_BLOCK, Optional.<IBlockState>absent());
		this.dataManager.register(SCREAMING, Boolean.valueOf(false));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		IBlockState iblockstate = this.getHeldBlockState();

		if (iblockstate != null) {
			tag.setShort("carried", (short)Block.getIdFromBlock(iblockstate.getBlock()));
			tag.setShort("carriedData", (short)iblockstate.getBlock().getMetaFromState(iblockstate));
		}
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

		if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN)) {
			return false;
		} else {
			Vec3d vec3d = player.getLook(1.0F).normalize();
			Vec3d vec3d1 = new Vec3d(this.posX - player.posX, this.getEntityBoundingBox().minY + (double)this.getEyeHeight() - (player.posY + (double)player.getEyeHeight()), this.posZ - player.posZ);
			double d0 = vec3d1.lengthVector();
			vec3d1 = vec3d1.normalize();
			double d1 = vec3d.dotProduct(vec3d1);
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

		if (this.worldObj.isDaytime() && this.ticksExisted >= this.targetChangeTime + 600) {
			float f = this.getBrightness(1.0F);

			if (f > 0.5F && this.worldObj.canSeeSky(new BlockPos(this)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
				this.setAttackTarget((EntityLivingBase)null);
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
		Vec3d vec3d = new Vec3d(this.posX - p_70816_1_.posX, this.getEntityBoundingBox().minY + (double)(this.height / 2.0F) - p_70816_1_.posY + (double)p_70816_1_.getEyeHeight(), this.posZ - p_70816_1_.posZ);
		vec3d = vec3d.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.xCoord * 16.0D;
		double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3d.yCoord * 16.0D;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3d.zCoord * 16.0D;
		return this.teleportTo(d1, d2, d3);
	}

	/**
	 * Teleport the enderman
	 */
	private boolean teleportTo(double x, double y, double z) {
		net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return false;
		boolean flag = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

		if (flag) {
			this.worldObj.playSound((EntityPlayer)null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
			this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
		}

		return flag;
	}

	protected SoundEvent getAmbientSound() {
		return this.isScreaming() ? SoundEvents.ENTITY_ENDERMEN_SCREAM : SoundEvents.ENTITY_ENDERMEN_AMBIENT;
	}

	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_ENDERMEN_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_ENDERMEN_DEATH;
	}

	protected void dropFewItems(boolean par1, int par2) {
		
		int var3 = this.rand.nextInt(3 + par2);
		
		if (par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1) > 0)) {
			for (int var4 = 0; var4 < var3; ++var4) {
				this.dropItem(Items.ENDER_PEARL, 1);
			}
		} else {
			for (int var4 = 0; var4 < var3; ++var4) {
				this.dropItem(Items.CHORUS_FRUIT, 1);
			}
		}

		//Nuggets/Fragments
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
			ItemShard.Drop_Nugget(this,1);
		}
		
		if (GaiaConfig.AdditionalOre == true) {
			int var13 = this.rand.nextInt(3) + 1;

			for (int var14 = 0; var14 < var13; ++var14) {
				ItemShard.Drop_Nugget(this,5);
			}
		}

		//Very Rare
		if (par1 && (this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1) > 0)) {
			this.dropItem(GaiaItems.SpawnEnderGirl,1);
		}
	}

	//Rare
	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItems.BagOre, 1);
			break;
		case 1:
			this.dropItem(GaiaItems.BagBook, 1);
			break;
		case 2:
			this.dropItem(GaiaItems.BookEnder, 1);
		}
	}

	public void setHeldBlockState(@Nullable IBlockState state) {
		this.dataManager.set(CARRIED_BLOCK, Optional.fromNullable(state));
	}


	@Nullable
	public IBlockState getHeldBlockState() {
		return (IBlockState)((Optional)this.dataManager.get(CARRIED_BLOCK)).orNull();
	}

	/*===================================== Forge Start ==============================*/
	public static void setCarriable(Block block, boolean canCarry) {
		if (canCarry) CARRIABLE_BLOCKS.add(block);
		else          CARRIABLE_BLOCKS.remove(block);
	}
	public static boolean getCarriable(Block block) {
		return CARRIABLE_BLOCKS.contains(block);
	}
	/*===================================== Forge End ==============================*/

	public boolean isScreaming() {
		return ((Boolean)this.dataManager.get(SCREAMING)).booleanValue();
	}

	static {
		CARRIABLE_BLOCKS.add(Blocks.GRASS);
		CARRIABLE_BLOCKS.add(Blocks.DIRT);
		CARRIABLE_BLOCKS.add(Blocks.SAND);
		CARRIABLE_BLOCKS.add(Blocks.GRAVEL);
		CARRIABLE_BLOCKS.add(Blocks.YELLOW_FLOWER);
		CARRIABLE_BLOCKS.add(Blocks.RED_FLOWER);
		CARRIABLE_BLOCKS.add(Blocks.BROWN_MUSHROOM);
		CARRIABLE_BLOCKS.add(Blocks.RED_MUSHROOM);
		CARRIABLE_BLOCKS.add(Blocks.TNT);
		CARRIABLE_BLOCKS.add(Blocks.CACTUS);
		CARRIABLE_BLOCKS.add(Blocks.CLAY);
		CARRIABLE_BLOCKS.add(Blocks.PUMPKIN);
		CARRIABLE_BLOCKS.add(Blocks.MELON_BLOCK);
		CARRIABLE_BLOCKS.add(Blocks.MYCELIUM);
		CARRIABLE_BLOCKS.add(Blocks.NETHERRACK);
	}

	static class AIFindPlayer extends EntityAINearestAttackableTarget {
		/** The player */
		private EntityGaiaEnderDragonGirl enderman;
		private EntityPlayer player;
		private int aggroTime;
		private int teleportTime;

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
			this.aggroTime = 5;
			this.teleportTime = 0;
		}

		/**
		 * Resets the task
		 */
		public void resetTask() {
			this.player = null;
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
					this.enderman.faceEntity(this.player, 10.0F, 10.0F);
					return true;
				}
			} else {
				return this.targetEntity != null && ((EntityPlayer)this.targetEntity).isEntityAlive() ? true : super.continueExecuting();
			}
		}

		/**
		 * Updates the task
		 */
		public void updateTask() {
			if (this.player != null) {
				if (--this.aggroTime <= 0) {
					this.targetEntity = this.player;
					this.player = null;
					super.startExecuting();
				}
			} else {
				if (this.targetEntity != null) {
					if (this.enderman.shouldAttackPlayer((EntityPlayer)this.targetEntity)) {
						if (((EntityPlayer)this.targetEntity).getDistanceSqToEntity(this.enderman) < 16.0D) {
							this.enderman.teleportRandomly();
						}

						this.teleportTime = 0;
					} else if (((EntityPlayer)this.targetEntity).getDistanceSqToEntity(this.enderman) > 256.0D && this.teleportTime++ >= 30 && this.enderman.teleportToEntity(this.targetEntity)) {
						this.teleportTime = 0;
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
			return this.enderman.getHeldBlockState() == null ? false : (!this.enderman.worldObj.getGameRules().getBoolean("mobGriefing") ? false : this.enderman.getRNG().nextInt(2000) == 0);
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
			IBlockState iblockstate = world.getBlockState(blockpos);
			IBlockState iblockstate1 = world.getBlockState(blockpos.down());
			IBlockState iblockstate2 = this.enderman.getHeldBlockState();

			if (iblockstate2 != null && this.canPlaceBlock(world, blockpos, iblockstate2.getBlock(), iblockstate, iblockstate1)) {
				world.setBlockState(blockpos, iblockstate2, 3);
				this.enderman.setHeldBlockState((IBlockState)null);
			}
		}

		private boolean canPlaceBlock(World p_188518_1_, BlockPos p_188518_2_, Block p_188518_3_, IBlockState p_188518_4_, IBlockState p_188518_5_) {
			return !p_188518_3_.canPlaceBlockAt(p_188518_1_, p_188518_2_) ? false : (p_188518_4_.getMaterial() != Material.AIR ? false : (p_188518_5_.getMaterial() == Material.AIR ? false : p_188518_5_.isFullCube()));
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
			return this.enderman.getHeldBlockState() != null ? false : (!this.enderman.worldObj.getGameRules().getBoolean("mobGriefing") ? false : this.enderman.getRNG().nextInt(200) == 0);
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
			RayTraceResult raytraceresult = world.rayTraceBlocks(new Vec3d((double)((float)MathHelper.floor_double(this.enderman.posX) + 0.5F), (double)((float)j + 0.5F), (double)((float)MathHelper.floor_double(this.enderman.posZ) + 0.5F)), new Vec3d((double)((float)i + 0.5F), (double)((float)j + 0.5F), (double)((float)k + 0.5F)), false, true, false);
			boolean flag = raytraceresult != null && raytraceresult.getBlockPos().equals(blockpos);

			if (EntityGaiaEnderDragonGirl.CARRIABLE_BLOCKS.contains(block) && flag) {
				this.enderman.setHeldBlockState(iblockstate);
				world.setBlockToAir(blockpos);
			}
		}

		public int getMaxSpawnedInChunk() {
			return 1;
		}
	}
}