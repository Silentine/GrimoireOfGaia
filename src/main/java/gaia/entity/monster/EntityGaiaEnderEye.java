package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public class EntityGaiaEnderEye extends EntityMobPassiveBase {

	private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier ATTACKING_SPEED_BOOST =
			(new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", EntityAttributes.ATTACK_SPEED_BOOST, 0)).setSaved(false);
	private static final DataParameter<Boolean> SCREAMING = EntityDataManager.createKey(EntityGaiaEnderEye.class, DataSerializers.BOOLEAN);

	private int targetChangeTime;

	public EntityGaiaEnderEye(World worldIn) {
		super(worldIn);

		setSize(1.0F, 2.4F);
		stepHeight = 1.0F;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, false));
		tasks.addTask(7, new EntityAIWander(this, 1.0D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(2, new EntityGaiaEnderEye.AIFindPlayer(this));
		targetTasks.addTask(3,
				new EntityAINearestAttackableTarget<>(this, EntityEndermite.class, 10, true, false, EntityEndermite::isSpawnedByPlayer));
	}

	@Override
	public float getEyeHeight() {
		return 2.05F;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
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
			boolean flag = super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));

			if (source.isUnblockable() && rand.nextInt(10) != 0) {
				teleportRandomly();
			}

			return flag;
		}
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SCREAMING, false);
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
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(Sounds.NONE, 1.0F, 1.0F);
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(Items.ENDER_PEARL, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.dropNugget(this, 0);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.dropNugget(this, 4);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(2);
				if (i == 0) {
					entityDropItem(new ItemStack(GaiaItems.BOX, 1, 0), 0.0F);
				} else if (i == 1) {
					dropItem(Item.getItemFromBlock(GaiaBlocks.DOLL_ENDER_GIRL), 1);
				}
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

	private boolean isScreaming() {
		return dataManager.get(SCREAMING);
	}

	static class AIFindPlayer extends EntityAINearestAttackableTarget<EntityPlayer> {

		private final EntityGaiaEnderEye enderman;
		/**
		 * The player
		 */
		private EntityPlayer player;
		private int aggroTime;
		private int teleportTime;

		AIFindPlayer(EntityGaiaEnderEye enderEye) {
			super(enderEye, EntityPlayer.class, false);
			enderman = enderEye;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		@Override
		public boolean shouldExecute() {
			double d0 = getTargetDistance();
			player = enderman.world.getNearestAttackablePlayer(enderman.posX, enderman.posY, enderman.posZ, d0, d0,
					null, p -> p != null && shouldAttackPlayer(p));
			return player != null;
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
			ItemStack itemstack = player.inventory.armorInventory.get(0);

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

	@Override
	public boolean getCanSpawnHere() {
		return posY < 60.0D && posY > 32.0D && super.getCanSpawnHere();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}
}
