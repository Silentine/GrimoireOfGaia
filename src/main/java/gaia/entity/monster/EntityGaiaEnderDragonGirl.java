package gaia.entity.monster;

import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistBase;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.items.ItemShard;
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
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * @see EntityEnderman
 */
public class EntityGaiaEnderDragonGirl extends EntityMobAssistBase {

	private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier ATTACKING_SPEED_BOOST = (new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", EntityAttributes.ATTACK_SPEED_BOOST, 0)).setSaved(false);
	private static final DataParameter<Boolean> SCREAMING = EntityDataManager.<Boolean>createKey(EntityGaiaEnderDragonGirl.class, DataSerializers.BOOLEAN);

	private int targetChangeTime;

	public EntityGaiaEnderDragonGirl(World worldIn) {
		super(worldIn);

		setSize(0.6F, 2.2F);
		stepHeight = 1.0F;
		isImmuneToFire = true;
		setPathPriority(PathNodeType.WATER, -1.0F);
	}

	@Override
	public float getEyeHeight() {
		return 1.90F;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, false));
		tasks.addTask(7, new EntityAIWander(this, 1.0D));
		tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(2, new EntityGaiaEnderDragonGirl.AIFindPlayer(this));
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
			this.dataManager.set(SCREAMING, Boolean.valueOf(false));
			iattributeinstance.removeModifier(ATTACKING_SPEED_BOOST);
		} else {
			targetChangeTime = ticksExisted;
			this.dataManager.set(SCREAMING, Boolean.valueOf(true));

			if (!iattributeinstance.hasModifier(ATTACKING_SPEED_BOOST)) {
				iattributeinstance.applyModifier(ATTACKING_SPEED_BOOST);
			}
		}
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SCREAMING, Boolean.valueOf(false));
	}

	public boolean isScreaming() {
		return ((Boolean) this.dataManager.get(SCREAMING)).booleanValue();
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

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		if (world.isRemote) {
			for (int i = 0; i < 2; ++i) {
				world.spawnParticle(EnumParticleTypes.PORTAL, posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height - 0.25D, posZ + (rand.nextDouble() - 0.5D) * width, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D);
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
	 * Checks to see if this enderman should be attacking this player
	 */
	private boolean shouldAttackPlayer(EntityPlayer player) {
		ItemStack itemstack = player.inventory.armorInventory.get(3);

		if (itemstack.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN)) {
			return false;
		} else {
			Vec3d vec3d = player.getLook(1.0F).normalize();
			Vec3d vec3d1 = new Vec3d(this.posX - player.posX, this.getEntityBoundingBox().minY + (double) this.getEyeHeight() - (player.posY + (double) player.getEyeHeight()), this.posZ - player.posZ);
			double d0 = vec3d1.length();
			vec3d1 = vec3d1.normalize();
			double d1 = vec3d.dotProduct(vec3d1);
			return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
		}
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
		Vec3d vec3d = new Vec3d(posX - entity.posX, getEntityBoundingBox().minY + height / 2.0D - entity.posY + entity.getEyeHeight(), posZ - entity.posZ);
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
		net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(this, x, y, z, 0);
		if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) {
			return false;
		}
		boolean flag = attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ());

		if (flag) {
			world.playSound(null, prevPosX, prevPosY, prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, getSoundCategory(), 1.0F, 1.0F);
			playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
		}

		return flag;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return isScreaming() ? SoundEvents.ENTITY_ENDERMEN_SCREAM : SoundEvents.ENTITY_ENDERMEN_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_ENDERMEN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_ENDERMEN_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_ENDER_DRAGON_GIRL;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			for (int i = 0; i < drop; ++i) {
				dropItem(Items.ENDER_PEARL, 1);
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				dropItem(Items.GOLD_NUGGET, 1);
			}

			if (GaiaConfig.DROPS.additionalOre) {
				int dropNuggetAlt = rand.nextInt(GaiaConfig.DROPS.maxNuggetCount) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				switch (rand.nextInt(2)) {
				case 0:
					entityDropItem(new ItemStack(GaiaItems.BOX, 1, 2), 0.0F);
				case 1:
					dropItem(GaiaItems.BAG_BOOK, 1);
				}
			}

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.SPAWN_ENDER_GIRL, 1);
			}

			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.MISC_ELYTRA, 1);
			}
		}
	}

	static class AIFindPlayer extends EntityAINearestAttackableTarget<EntityPlayer> {

		private EntityGaiaEnderDragonGirl enderman;
		/** The player */
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
		public boolean shouldExecute() {
			double d0 = this.getTargetDistance();
			this.player = this.enderman.world.getNearestAttackablePlayer(this.enderman.posX, this.enderman.posY, this.enderman.posZ, d0, d0, (Function) null, new Predicate<EntityPlayer>() {
				public boolean apply(@Nullable EntityPlayer p_apply_1_) {
					return p_apply_1_ != null && AIFindPlayer.this.enderman.shouldAttackPlayer(p_apply_1_);
				}
			});
			return this.player != null;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.aggroTime = 5;
			this.teleportTime = 0;
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by another one
		 */
		public void resetTask() {
			this.player = null;
			super.resetTask();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			if (this.player != null) {
				if (!this.enderman.shouldAttackPlayer(this.player)) {
					return false;
				} else {
					this.enderman.faceEntity(this.player, 10.0F, 10.0F);
					return true;
				}
			} else {
				return this.targetEntity != null && ((EntityPlayer) this.targetEntity).isEntityAlive() ? true : super.shouldContinueExecuting();
			}
		}

		/**
		 * Keep ticking a continuous task that has already been started
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
					if (this.enderman.shouldAttackPlayer((EntityPlayer) this.targetEntity)) {
						if (((EntityPlayer) this.targetEntity).getDistanceSq(this.enderman) < 16.0D) {
							this.enderman.teleportRandomly();
						}

						this.teleportTime = 0;
					} else if (((EntityPlayer) this.targetEntity).getDistanceSq(this.enderman) > 256.0D && this.teleportTime++ >= 30 && this.enderman.teleportToEntity(this.targetEntity)) {
						this.teleportTime = 0;
					}
				}

				super.updateTask();
			}
		}
	}

	/* IMMUNITIES */
	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	@Override
	public void setInWeb() {
	}
	/* IMMUNITIES */

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_2;
	}
	/* SPAWN CONDITIONS */
}
