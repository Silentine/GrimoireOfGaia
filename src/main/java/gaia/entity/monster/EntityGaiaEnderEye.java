package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;

import java.util.UUID;

import javax.annotation.Nullable;

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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/** 
 * @see EntityEnderman
 */
public class EntityGaiaEnderEye extends EntityMobPassiveBase {
	private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier ATTACKING_SPEED_BOOST = (new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", EntityAttributes.attackSpeedBoost, 0)).setSaved(false);    
	private static final DataParameter<Boolean> SCREAMING = EntityDataManager.<Boolean>createKey(EntityGaiaEnderEye.class, DataSerializers.BOOLEAN);

	private int lastCreepySound;
	private int targetChangeTime;

	public EntityGaiaEnderEye(World worldIn) {
		super(worldIn);
		this.setSize(1.0F, 2.4F);
		this.stepHeight = 1.0F;
	}
	
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed1, false));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(2, new EntityGaiaEnderEye.AIFindPlayer(this));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityEndermite.class, 10, true, false, new Predicate<EntityEndermite>() {
			public boolean apply(EntityEndermite p_apply_1_) {
				return p_apply_1_.isSpawnedByPlayer();
			}
		}));
	}

	public float getEyeHeight() {
		return 2.05F;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth1);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage1);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor1);
	}
	
    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn)
    {
        super.setAttackTarget(entitylivingbaseIn);
        IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

        if (entitylivingbaseIn == null)
        {
            this.targetChangeTime = 0;
            this.dataManager.set(SCREAMING, Boolean.valueOf(false));
            iattributeinstance.removeModifier(ATTACKING_SPEED_BOOST);
        }
        else
        {
            this.targetChangeTime = this.ticksExisted;
            this.dataManager.set(SCREAMING, Boolean.valueOf(true));

            if (!iattributeinstance.hasModifier(ATTACKING_SPEED_BOOST))
            {
                iattributeinstance.applyModifier(ATTACKING_SPEED_BOOST);
            }
        }
    }
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > EntityAttributes.baseDefense1) {
			damage = EntityAttributes.baseDefense1;
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
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback1);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SCREAMING, Boolean.valueOf(false));
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
	}

	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
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

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(Sounds.none, 1.0F, 1.0F);
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
				this.dropItem(Items.ENDER_PEARL, 1);
			}

			//Nuggets/Fragments
			int var11 = this.rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this,0);
			}

			if (GaiaConfig.AdditionalOre == true) {
				int var13 = this.rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this,4);
				}
			}
			
    		//Rare
    		if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
    			switch(this.rand.nextInt(2)) {
    			case 0:
    				this.entityDropItem(new ItemStack(GaiaItems.Box, 1, 0), 0.0F);
    				break;
    			case 1:
    				this.dropItem(Item.getItemFromBlock(GaiaBlocks.DollEnderGirl), 1);
    			}
    		}
		}
	}

	//================= Immunities =================//
	public void fall(float distance, float damageMultiplier) {}

	public void setInWeb() {}
	//==============================================//
	
	public boolean isScreaming() {
		return ((Boolean)this.dataManager.get(SCREAMING)).booleanValue();
	}

	static class AIFindPlayer extends EntityAINearestAttackableTarget<EntityPlayer> {
		private final EntityGaiaEnderEye enderman;
		/** The player */
		private EntityPlayer player;
		private int aggroTime;
		private int teleportTime;

		public AIFindPlayer(EntityGaiaEnderEye p_i45842_1_) {
			super(p_i45842_1_, EntityPlayer.class, false);
			this.enderman = p_i45842_1_;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			double d0 = this.getTargetDistance();
			this.player = this.enderman.worldObj.getNearestAttackablePlayer(this.enderman.posX, this.enderman.posY, this.enderman.posZ, d0, d0, (Function<EntityPlayer, Double>)null, new Predicate<EntityPlayer>() {
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
	
	public boolean getCanSpawnHere() {
		return this.posY < 60.0D && this.posY > 32.0D && super.getCanSpawnHere();
	}
	
	public int getMaxSpawnedInChunk() {
		return 2;
	}
}