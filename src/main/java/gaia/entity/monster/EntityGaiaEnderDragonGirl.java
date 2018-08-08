package gaia.entity.monster;

import com.google.common.base.Optional;
import com.google.common.collect.Sets;
import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveBase;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
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
import net.minecraft.entity.ai.attributes.IAttributeInstance;
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

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public class EntityGaiaEnderDragonGirl extends EntityMobPassiveBase {

	private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier ATTACKING_SPEED_BOOST =
			(new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", EntityAttributes.ATTACK_SPEED_BOOST, 0)).setSaved(false);
	private static final Set<Block> CARRIABLE_BLOCKS = Sets.newIdentityHashSet();
	private static final DataParameter<Optional<IBlockState>> CARRIED_BLOCK =
			EntityDataManager.createKey(EntityGaiaEnderDragonGirl.class, DataSerializers.OPTIONAL_BLOCK_STATE);
	private static final DataParameter<Boolean> SCREAMING =
			EntityDataManager.createKey(EntityGaiaEnderDragonGirl.class, DataSerializers.BOOLEAN);
	private static final String CARRIED_TAG = "carried";
	private static final String CARRIED_DATA_TAG = "carriedData";

	private int targetChangeTime;

	public EntityGaiaEnderDragonGirl(World worldIn) {
		super(worldIn);

		setSize(0.6F, 2.2F);
		stepHeight = 1.0F;
		isImmuneToFire = true;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, false));
		tasks.addTask(7, new EntityAIWander(this, 1.0D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		tasks.addTask(10, new EntityGaiaEnderDragonGirl.AIPlaceBlock(this));
		tasks.addTask(11, new EntityGaiaEnderDragonGirl.AITakeBlock(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(2, new EntityGaiaEnderDragonGirl.AIFindPlayer(this));
		targetTasks.addTask(3,
				new EntityAINearestAttackableTarget<>(this, EntityEndermite.class, 10, true, false, EntityEndermite::isSpawnedByPlayer));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_2);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_2);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_2);
	}

	@Override
	public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
		super.setAttackTarget(entitylivingbaseIn);
		IAttributeInstance iattributeinstance = getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

		if (entitylivingbaseIn == null) {
			targetChangeTime = 0;
			dataManager.set(SCREAMING, false);
			iattributeinstance.removeModifier(ATTACKING_SPEED_BOOST);
		} else {
			targetChangeTime = ticksExisted;
			dataManager.set(SCREAMING, true);

			if (!iattributeinstance.hasModifier(ATTACKING_SPEED_BOOST)) {
				iattributeinstance.applyModifier(ATTACKING_SPEED_BOOST);
			}
		}
	}

	@Override
	public float getEyeHeight() {
		return 1.90F;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (isEntityInvulnerable(source)) {
			return false;
		} else if (source instanceof EntityDamageSourceIndirect) {
			for (int i = 0; i < 64; ++i) {
				if (teleportRandomly()) {
					return true;
				}
			}

			return false;
		} else {
			boolean flag = super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_2));

			if (source.isUnblockable() && rand.nextInt(10) != 0) {
				teleportRandomly();
			}

			return flag;
		}
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(CARRIED_BLOCK, Optional.absent());
		dataManager.register(SCREAMING, false);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		IBlockState iblockstate = getHeldBlockState();

		if (iblockstate != null) {
			tag.setShort(CARRIED_TAG, (short) Block.getIdFromBlock(iblockstate.getBlock()));
			tag.setShort(CARRIED_DATA_TAG, (short) iblockstate.getBlock()
					.getMetaFromState(iblockstate));
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		IBlockState iblockstate;

		if (tagCompund.hasKey(CARRIED_TAG, 8)) {
			iblockstate = Block.getBlockFromName(tagCompund.getString(CARRIED_TAG))
					.getStateFromMeta(tagCompund.getShort(CARRIED_DATA_TAG) & 65535);
		} else {
			iblockstate = Block.getBlockById(tagCompund.getShort(CARRIED_TAG))
					.getStateFromMeta(tagCompund.getShort(CARRIED_DATA_TAG) & 65535);
		}

		setHeldBlockState(iblockstate);
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate() {
		if (world.isRemote) {
			for (int i = 0; i < 2; ++i) {
				world.spawnParticle(EnumParticleTypes.PORTAL,
						posX + (rand.nextDouble() - 0.5D) * width,
						posY + rand.nextDouble() * height - 0.25D,
						posZ + (rand.nextDouble() - 0.5D) * width,
						(rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
			}
		}

		isJumping = false;
		super.onLivingUpdate();
	}

	@Override
	protected void updateAITasks() {
		if (isWet()) {
			attackEntityFrom(DamageSource.DROWN, 1.0F);
		}

		if (world.isDaytime() && ticksExisted >= targetChangeTime + 600) {
			float f = getBrightness();

			if (f > 0.5F && world.canSeeSky(new BlockPos(this)) && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
				setAttackTarget(null);
				teleportRandomly();
			}
		}

		super.updateAITasks();
	}

	/**
	 * Teleport the enderman to a random nearby position
	 */
	boolean teleportRandomly() {
		double d0 = posX + (rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = posY + (rand.nextInt(64) - 32);
		double d2 = posZ + (rand.nextDouble() - 0.5D) * 64.0D;
		return teleportTo(d0, d1, d2);
	}

	/**
	 * Teleport the enderman to another entity
	 */
	boolean teleportToEntity(Entity entity) {
		Vec3d vec3d = new Vec3d(
				posX - entity.posX,
				getEntityBoundingBox().minY + height / 2.0D - entity.posY + entity.getEyeHeight(),
				posZ - entity.posZ);
		vec3d = vec3d.normalize();
		double d1 = posX + (rand.nextDouble() - 0.5D) * 8.0D - vec3d.x * 16.0D;
		double d2 = posY + (rand.nextInt(16) - 8) - vec3d.y * 16.0D;
		double d3 = posZ + (rand.nextDouble() - 0.5D) * 8.0D - vec3d.z * 16.0D;
		return teleportTo(d1, d2, d3);
	}

	/**
	 * Teleport the enderman
	 */
	private boolean teleportTo(double x, double y, double z) {
		net.minecraftforge.event.entity.living.EnderTeleportEvent event =
				new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) {
			return false;
		}
		boolean flag = attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

		if (flag) {
			world.playSound(null, prevPosX, prevPosY, prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT,
					getSoundCategory(), 1.0F, 1.0F);
			playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
		}

		return flag;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return isScreaming()
				? SoundEvents.ENTITY_ENDERMEN_SCREAM
				: SoundEvents.ENTITY_ENDERMEN_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_ENDERMEN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_ENDERMEN_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int var3 = rand.nextInt(3 + lootingModifier);

			for (int var4 = 0; var4 < var3; ++var4) {
				dropItem(Items.ENDER_PEARL, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(3);
				if (i == 0) {
					entityDropItem(new ItemStack(GaiaItems.Box, 1, 2), 0.0F);
				} else if (i == 1) {
					dropItem(GaiaItems.BagBook, 1);
				} else if (i == 2) {
					dropItem(GaiaItems.BookEnder, 1);
				}
			}

			// Very Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1) > 0)) {
				dropItem(GaiaItems.SpawnEnderGirl, 1);
			}

			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1) > 0)) {
				dropItem(Items.ELYTRA, 1);
			}
		}
	}

	// ================= Immunities =================//
	@Override
	public void fall(float distance, float damageMultiplier) {
		//noop
	}

	@Override
	public void setInWeb() {
		//noop
	}
	// ==============================================//

	void setHeldBlockState(@Nullable IBlockState state) {
		dataManager.set(CARRIED_BLOCK, Optional.fromNullable(state));
	}

	@Nullable
	public IBlockState getHeldBlockState() {
		return dataManager.get(CARRIED_BLOCK).orNull();
	}

	/*===================================== Forge End ==============================*/

	public boolean isScreaming() {
		return dataManager.get(SCREAMING);
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

	static class AIFindPlayer extends EntityAINearestAttackableTarget<EntityPlayer> {

		/**
		 * The player
		 */
		private EntityGaiaEnderDragonGirl enderman;
		private EntityPlayer player;
		private int aggroTime;
		private int teleportTime;

		AIFindPlayer(EntityGaiaEnderDragonGirl enderDragonGirl) {
			super(enderDragonGirl, EntityPlayer.class, true);
			enderman = enderDragonGirl;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			double d0 = getTargetDistance();
			List<EntityPlayer> list =
					taskOwner.world.getEntitiesWithinAABB(EntityPlayer.class, taskOwner.getEntityBoundingBox()
							.expand(d0, 4.0D, d0), targetEntitySelector);
			list.sort(sorter);

			if (list.isEmpty()) {
				return false;
			} else {
				player = list.get(0);
				return true;
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void startExecuting() {
			aggroTime = 5;
			teleportTime = 0;
		}

		/**
		 * Resets the task
		 */
		@Override
		public void resetTask() {
			player = null;
			super.resetTask();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		@Override
		public boolean shouldContinueExecuting() {
			if (player != null) {
				if (!shouldAttackPlayer(player)) {
					return false;
				} else {
					enderman.faceEntity(player, 10.0F, 10.0F);
					return true;
				}
			} else {
				return targetEntity != null && targetEntity.isEntityAlive() || super.shouldContinueExecuting();
			}
		}

		/**
		 * Updates the task
		 */
		@Override
		public void updateTask() {
			if (player != null) {
				if (--aggroTime <= 0) {
					targetEntity = player;
					player = null;
					super.startExecuting();
				}
			} else {
				if (targetEntity != null) {
					if (shouldAttackPlayer(targetEntity)) {
						if (targetEntity.getDistanceSq(enderman) < 16.0D) {
							enderman.teleportRandomly();
						}

						teleportTime = 0;
					} else if (targetEntity.getDistanceSq(enderman) > 256.0D && teleportTime++ >= 30 &&
							enderman.teleportToEntity(targetEntity)) {
						teleportTime = 0;
					}
				}

				super.updateTask();
			}
		}

		/**
		 * Checks to see if this enderman should be attacking this player
		 */
		private boolean shouldAttackPlayer(EntityPlayer player) {
			ItemStack itemstack = player.inventory.armorInventory.get(3);

			if (itemstack.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN)) {
				return false;
			} else {
				Vec3d vec3d = player.getLook(1.0F)
						.normalize();
				Vec3d vec3d1 = new Vec3d(
						enderman.posX - player.posX,
						enderman.getEntityBoundingBox().minY + enderman.getEyeHeight() - (player.posY + player.getEyeHeight()),
						enderman.posZ - player.posZ);
				double d0 = vec3d1.lengthVector();
				vec3d1 = vec3d1.normalize();
				double d1 = vec3d.dotProduct(vec3d1);
				return d1 > 1.0D - 0.025D / d0 && player.canEntityBeSeen(enderman);
			}
		}
	}

	static class AIPlaceBlock extends EntityAIBase {

		private EntityGaiaEnderDragonGirl enderman;

		AIPlaceBlock(EntityGaiaEnderDragonGirl enderDragonGirl) {
			enderman = enderDragonGirl;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return enderman.getHeldBlockState() != null && (enderman.world.getGameRules().getBoolean("mobGriefing")
					&& enderman.getRNG().nextInt(2000) == 0);
		}

		/**
		 * Updates the task
		 */
		public void updateTask() {
			Random random = enderman.getRNG();
			World world = enderman.world;
			int i = MathHelper.floor(enderman.posX - 1.0D + random.nextDouble() * 2.0D);
			int j = MathHelper.floor(enderman.posY + random.nextDouble() * 2.0D);
			int k = MathHelper.floor(enderman.posZ - 1.0D + random.nextDouble() * 2.0D);
			BlockPos blockpos = new BlockPos(i, j, k);
			IBlockState iblockstate = world.getBlockState(blockpos);
			IBlockState iblockstate1 = world.getBlockState(blockpos.down());
			IBlockState iblockstate2 = enderman.getHeldBlockState();

			if (iblockstate2 != null && canPlaceBlock(world, blockpos, iblockstate2.getBlock(), iblockstate, iblockstate1)) {
				world.setBlockState(blockpos, iblockstate2, 3);
				enderman.setHeldBlockState(null);
			}
		}

		private boolean canPlaceBlock(World world, BlockPos pos, Block block, IBlockState state, IBlockState stateBelow) {
			return block.canPlaceBlockAt(world, pos) && (state.getMaterial() == Material.AIR && (stateBelow.getMaterial() != Material.AIR && stateBelow.isFullCube()));
		}
	}

	static class AITakeBlock extends EntityAIBase {

		private EntityGaiaEnderDragonGirl enderman;

		AITakeBlock(EntityGaiaEnderDragonGirl enderDragonGirl) {
			enderman = enderDragonGirl;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return enderman.getHeldBlockState() == null && (enderman.world.getGameRules().getBoolean("mobGriefing") && enderman.getRNG().nextInt(200) == 0);
		}

		/**
		 * Updates the task
		 */
		@Override
		public void updateTask() {
			Random random = enderman.getRNG();
			World world = enderman.world;
			int i = MathHelper.floor(enderman.posX - 2.0D + random.nextDouble() * 4.0D);
			int j = MathHelper.floor(enderman.posY + random.nextDouble() * 3.0D);
			int k = MathHelper.floor(enderman.posZ - 2.0D + random.nextDouble() * 4.0D);
			BlockPos blockpos = new BlockPos(i, j, k);
			IBlockState iblockstate = world.getBlockState(blockpos);
			Block block = iblockstate.getBlock();
			RayTraceResult raytraceresult = world.rayTraceBlocks(
					new Vec3d(MathHelper.floor(enderman.posX) + 0.5D, j + 0.5D, MathHelper.floor(enderman.posZ) + 0.5D),
					new Vec3d(i + 0.5D, j + 0.5D, k + 0.5D), false, true, false);
			boolean flag = raytraceresult != null && raytraceresult.getBlockPos().equals(blockpos);

			if (EntityGaiaEnderDragonGirl.CARRIABLE_BLOCKS.contains(block) && flag) {
				enderman.setHeldBlockState(iblockstate);
				world.setBlockToAir(blockpos);
			}
		}
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}
}
