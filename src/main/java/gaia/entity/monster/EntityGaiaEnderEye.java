package gaia.entity.monster;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Predicate;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.init.GaiaBlock;
import gaia.init.GaiaItem;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityGaiaEnderEye extends EntityMobBase {

    private static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier("Attacking speed boost", 6.0D, 0)).setSaved(false);
	//private int teleportDelay;
    //private int stareTimer;
    //private Entity lastEntityToAttack;
    private boolean isAggressive;

	public EntityGaiaEnderEye(World par1World) {
		super(par1World);
		this.setSize(1.0F, 2.0F);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        //this.tasks.addTask(10, new EntityEnderman.AIPlaceBlock(this));
        //this.tasks.addTask(11, new EntityEnderman.AITakeBlock(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityGaiaEnderEye.AIFindPlayer(this));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityEndermite.class, 10, true, false, new Predicate<EntityEndermite>()
        {
            public boolean apply(EntityEndermite p_apply_1_)
            {
                return p_apply_1_.isSpawnedByPlayer();
            }
        }));
	}
	
	public float getEyeHeight()
    {	//TODO Double check enderman stare-aggro
        return 2.55F;
    }

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth1);
		//		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage1);
		//
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(64.0D);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor1;
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
		this.dataWatcher.addObject(17, new Byte((byte)0));
		this.dataWatcher.addObject(18, new Byte((byte)0));
	}

    private boolean shouldAttackPlayer(EntityPlayer entityplayer) {
        ItemStack itemstack = entityplayer.inventory.armorInventory[3];

        if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
            return false;
        } else {
            Vec3 vec3 = entityplayer.getLook(1.0F).normalize();
            //Vec3 vec31 = Vec3.createVectorHelper(this.posX - entityplayer.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (entityplayer.posY + (double)entityplayer.getEyeHeight()), this.posZ - entityplayer.posZ);
            Vec3 vec31 = new Vec3(this.posX - entityplayer.posX, this.getEntityBoundingBox().minY + (double)(this.height / 2.0F) - (entityplayer.posY + (double)entityplayer.getEyeHeight()), this.posZ - entityplayer.posZ);
            double d0 = vec31.lengthVector();
            vec31 = vec31.normalize();
            double d1 = vec3.dotProduct(vec31);
            return d1 > 1.0D - 0.025D / d0 ? entityplayer.canEntityBeSeen(this) : false;
            //return d1 > 1.0D - 0.025D / d0 && entityplayer.canEntityBeSeen(this);
        }
    }
    
    public void onLivingUpdate()
    {
        if (this.worldObj.isRemote)
        {
            for (int i = 0; i < 2; ++i)
            {
                this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D, new int[0]);
            }
        }

        this.isJumping = false;
        super.onLivingUpdate();
    }
    
    protected void updateAITasks()
    {
        if (this.isWet())
        {
            this.attackEntityFrom(DamageSource.drown, 1.0F);
        }

        if (this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0)
        {
            this.setScreaming(false);
        }

        if (this.worldObj.isDaytime())
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.worldObj.canSeeSky(new BlockPos(this)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F)
            {
                this.setAttackTarget((EntityLivingBase)null);
                this.setScreaming(false);
                this.isAggressive = false;
                this.teleportRandomly();
            }
        }

        super.updateAITasks();
    }


	protected boolean teleportRandomly() {		
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}

	protected boolean teleportToEntity(Entity entity) {
		//Vec3 vec3 = Vec3.createVectorHelper(this.posX - entity.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - entity.posY + (double)entity.getEyeHeight(), this.posZ - entity.posZ);
		Vec3 vec3 = new Vec3(this.posX - entity.posX, this.getEntityBoundingBox().minY + (double)(this.height / 2.0F) - entity.posY + (double)entity.getEyeHeight(), this.posZ - entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
		double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
	}
	
	protected boolean teleportTo(double x, double y, double z)
    {
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

        if (this.worldObj.isBlockLoaded(blockpos))
        {
            boolean flag1 = false;

            while (!flag1 && blockpos.getY() > 0)
            {
                BlockPos blockpos1 = blockpos.down();
                Block block = this.worldObj.getBlockState(blockpos1).getBlock();

                if (block.getMaterial().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.posY;
                    blockpos = blockpos1;
                }
            }

            if (flag1)
            {
                super.setPositionAndUpdate(this.posX, this.posY, this.posZ);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox()))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            this.setPosition(d0, d1, d2);
            return false;
        }
        else
        {
            int i = 128;

            for (int j = 0; j < i; ++j)
            {
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
		//TODO no sound things
		//return this.isScreaming()?"mob.endermen.scream":"mob.endermen.none";
		return this.isScreaming()?"mob.endermen.scream":null;
	}

	protected String getHurtSound() {
		return "mob.endermen.hit";
	}

	protected String getDeathSound() {
		return "mob.endermen.death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		//TODO Fix no sound thing
		//this.worldObj.playSoundAtEntity(this, "none", 1.0F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(Items.ender_pearl,1);
		}
		
		var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(GaiaItem.Shard,1);
		}
		
		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItem.BagOre,1);
			break;
		case 1:
			this.dropItem(Item.getItemFromBlock(GaiaBlock.DollEnderGirl), 1);
			break;
		case 2:
			this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}

	protected void fall(float f) {}

	public void setInWeb() {}

	/*
    public boolean attackEntityFrom(DamageSource source, float par2) {
        if (this.isEntityInvulnerable(source)) {
            return false;
        } else {
            this.setScreaming(true);

            if (source instanceof EntityDamageSource && source.getEntity() instanceof EntityPlayer) {
                this.isAggressive = true;
            }

            if (source instanceof EntityDamageSourceIndirect) {
            	this.isAggressive = false;

            	for (int i = 0; i < 64; ++i) {
            		if (this.teleportRandomly()) {
            			return true;
            		}
            	}

            	return super.attackEntityFrom(source, par2);
            } else {
            	return super.attackEntityFrom(source, par2);
            }
        }
    }
	*/
	 public boolean attackEntityFrom(DamageSource source, float amount)
	    {
	        if (this.isEntityInvulnerable(source))
	        {
	            return false;
	        }
	        else
	        {
	            if (source.getEntity() == null || !(source.getEntity() instanceof EntityEndermite))
	            {
	                if (!this.worldObj.isRemote)
	                {
	                    this.setScreaming(true);
	                }

	                if (source instanceof EntityDamageSource && source.getEntity() instanceof EntityPlayer)
	                {
	                    if (source.getEntity() instanceof EntityPlayerMP && ((EntityPlayerMP)source.getEntity()).theItemInWorldManager.isCreative())
	                    {
	                        this.setScreaming(false);
	                    }
	                    else
	                    {
	                        this.isAggressive = true;
	                    }
	                }

	                if (source instanceof EntityDamageSourceIndirect)
	                {
	                    this.isAggressive = false;

	                    for (int i = 0; i < 64; ++i)
	                    {
	                        if (this.teleportRandomly())
	                        {
	                            return true;
	                        }
	                    }

	                    return false;
	                }
	            }

	            boolean flag = super.attackEntityFrom(source, amount);

	            if (source.isUnblockable() && this.rand.nextInt(10) != 0)
	            {
	                this.teleportRandomly();
	            }

	            return flag;
	        }
	    }
	 
	public boolean isScreaming() {
		return this.dataWatcher.getWatchableObjectByte(18) > 0;
	}

	public void setScreaming(boolean par1) {
		this.dataWatcher.updateObject(18, Byte.valueOf((byte)(par1?1:0)));
	}
	
	public void knockBack(Entity entity, float par2, double par3, double par5) {
		if(this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue()) {
			this.isAirBorne = true;
			float f1 = MathHelper.sqrt_double(par3 * par3 + par5 * par5);
			float f2 = 0.4F;
			this.motionX /= 2.0D;
			this.motionY /= 2.0D;
			this.motionZ /= 2.0D;
			this.motionX -= par3 / (double)f1 * (double)f2;
			this.motionY += (double)f2;
			this.motionZ -= par5 / (double)f1 * (double)f2;
			if(this.motionY > EntityAttributes.knockback1) {
				this.motionY = EntityAttributes.knockback1;
			}
		}
	}

	public boolean getCanSpawnHere() {
		return this.posY < 60.0D && this.posY > 32.0D && super.getCanSpawnHere();
	}
	
	
	
	
	static class AIFindPlayer extends EntityAINearestAttackableTarget
    {
        /** The player */
        private EntityPlayer player;
        private int field_179450_h;
        private int field_179451_i;
        private EntityGaiaEnderEye enderman;

        public AIFindPlayer(EntityGaiaEnderEye p_i45842_1_)
        {
            super(p_i45842_1_, EntityPlayer.class, true);
            this.enderman = p_i45842_1_;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            double d0 = this.getTargetDistance();
            List<EntityPlayer> list = this.taskOwner.worldObj.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, this.taskOwner.getEntityBoundingBox().expand(d0, 4.0D, d0), this.targetEntitySelector);
            Collections.sort(list, this.theNearestAttackableTargetSorter);

            if (list.isEmpty())
            {
                return false;
            }
            else
            {
                this.player = (EntityPlayer)list.get(0);
                return true;
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.field_179450_h = 5;
            this.field_179451_i = 0;
        }

        /**
         * Resets the task
         */
        public void resetTask()
        {
            this.player = null;
            this.enderman.setScreaming(false);
            IAttributeInstance iattributeinstance = this.enderman.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            iattributeinstance.removeModifier(EntityGaiaEnderEye.attackingSpeedBoostModifier);
            super.resetTask();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean continueExecuting()
        {
            if (this.player != null)
            {
                if (!this.enderman.shouldAttackPlayer(this.player))
                {
                    return false;
                }
                else
                {
                    this.enderman.isAggressive = true;
                    this.enderman.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            }
            else
            {
                return super.continueExecuting();
            }
        }

        /**
         * Updates the task
         */
        public void updateTask()
        {
            if (this.player != null)
            {
                if (--this.field_179450_h <= 0)
                {
                    this.targetEntity = this.player;
                    this.player = null;
                    super.startExecuting();
                    this.enderman.playSound("mob.endermen.stare", 1.0F, 1.0F);
                    this.enderman.setScreaming(true);
                    IAttributeInstance iattributeinstance = this.enderman.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    iattributeinstance.applyModifier(EntityGaiaEnderEye.attackingSpeedBoostModifier);
                }
            }
            else
            {
                if (this.targetEntity != null)
                {
                    if (this.targetEntity instanceof EntityPlayer && this.enderman.shouldAttackPlayer((EntityPlayer)this.targetEntity))
                    {
                        if (this.targetEntity.getDistanceSqToEntity(this.enderman) < 16.0D)
                        {
                            this.enderman.teleportRandomly();
                        }

                        this.field_179451_i = 0;
                    }
                    else if (this.targetEntity.getDistanceSqToEntity(this.enderman) > 256.0D && this.field_179451_i++ >= 30 && this.enderman.teleportToEntity(this.targetEntity))
                    {
                        this.field_179451_i = 0;
                    }
                }

                super.updateTask();
            }
        }
    }

	
}
