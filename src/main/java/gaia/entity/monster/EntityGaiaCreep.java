package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.entity.ai.EntityAIGaiaCreepSwell;
import gaia.init.GaiaBlock;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaCreep extends EntityMobBase {
	private int lastActiveTime;
	private int timeSinceIgnited;
	private int fuseTime = 30;
	private int explosionRadius = 3;
	
	private static final DataParameter<Integer> STATE = EntityDataManager.<Integer>createKey(EntityGaiaCreep.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> POWERED = EntityDataManager.<Boolean>createKey(EntityGaiaCreep.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> IGNITED = EntityDataManager.<Boolean>createKey(EntityGaiaCreep.class, DataSerializers.BOOLEAN);

	public EntityGaiaCreep(World par1World) {
		super(par1World);
		this.setSize(0.7F, 0.7F);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaCreepSwell(this));
		this.tasks.addTask(2, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth1);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage1);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor1;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public int getMaxSafePointTries() {
		return this.getAttackTarget() == null?3:3 + (int)(this.getHealth() - 1.0F);
	}

	public void fall(float distance, float damageMultiplier){
		super.fall(distance, damageMultiplier);
		this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + distance * 1.5F);
		if (this.timeSinceIgnited > this.fuseTime - 5) {
			this.timeSinceIgnited = this.fuseTime - 5;
		}
	}
	
	protected void entityInit() {
		super.entityInit();
        this.dataManager.register(STATE, Integer.valueOf(-1));
        this.dataManager.register(POWERED, Boolean.valueOf(false));
        this.dataManager.register(IGNITED, Boolean.valueOf(false));
	}

	public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);

        if (((Boolean)this.dataManager.get(POWERED)).booleanValue())
        {
            compound.setBoolean("powered", true);
        }

        compound.setShort("Fuse", (short)this.fuseTime);
        compound.setByte("ExplosionRadius", (byte)this.explosionRadius);
        compound.setBoolean("ignited", this.hasIgnited());
    }

	public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.dataManager.set(POWERED, Boolean.valueOf(compound.getBoolean("powered")));

        if (compound.hasKey("Fuse", 99))
        {
            this.fuseTime = compound.getShort("Fuse");
        }

        if (compound.hasKey("ExplosionRadius", 99))
        {
            this.explosionRadius = compound.getByte("ExplosionRadius");
        }

        if (compound.getBoolean("ignited"))
        {
            this.ignite();
        }
    }
	
	
	public void onUpdate()
    {
        if (this.isEntityAlive())
        {
            this.lastActiveTime = this.timeSinceIgnited;

            if (this.hasIgnited())
            {
                this.setCreeperState(1);
            }

            int i = this.getCreeperState();

            if (i > 0 && this.timeSinceIgnited == 0)
            {
                this.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
            }

            this.timeSinceIgnited += i;

            if (this.timeSinceIgnited < 0)
            {
                this.timeSinceIgnited = 0;
            }

            if (this.timeSinceIgnited >= this.fuseTime)
            {
                this.timeSinceIgnited = this.fuseTime;
                this.explode();
            }
        }

        super.onUpdate();
    }
	
	public boolean hasIgnited()
    {
        return ((Boolean)this.dataManager.get(IGNITED)).booleanValue();
    }

    public void ignite()
    {
        this.dataManager.set(IGNITED, Boolean.valueOf(true));
    }
    
    private void explode()
    {
        if (!this.worldObj.isRemote)
        {
            boolean flag = this.worldObj.getGameRules().getBoolean("mobGriefing");
            float f = this.getPowered() ? 2.0F : 1.0F;
            this.dead = true;
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius * f, flag);
            this.setDead();
        }
    }
    
    public int getCreeperState()
    {
        return ((Integer)this.dataManager.get(STATE)).intValue();
    }

    
    public void setCreeperState(int state)
    {
        this.dataManager.set(STATE, Integer.valueOf(state));
    }

	public void onLivingUpdate() {
		if (this.getHealth() <= EntityAttributes.maxHealth1 * 0.10F) {
			this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 100, 0));
		}
		super.onLivingUpdate();
	}
	protected SoundEvent getHurtSound()
    {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }

	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(Items.GUNPOWDER, 1);
		}

		//Shards
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}
		
		//Very Rare
		if (par1 && (this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1) > 0)) {
			this.dropItem(GaiaItem.SpawnCreeperGirl, 1);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItem.BagOre, 1);
			break;
		case 1:
			this.dropItem(Item.getItemFromBlock(GaiaBlock.DollCreeperGirl), 1);
			break;
		case 3:	
			this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		return true;
	}

	public boolean getPowered()
    {
        return ((Boolean)this.dataManager.get(POWERED)).booleanValue();
    }
	
	@SideOnly(Side.CLIENT)
	public float getCreeperFlashIntensity(float par1) {
		return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * par1) / (float)(this.fuseTime - 2);
	}
	
	public void onStruckByLightning(EntityLightningBolt lightningBolt)
    {
        super.onStruckByLightning(lightningBolt);
        this.dataManager.set(POWERED, Boolean.valueOf(true));
    }

	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
		super.knockBack(par1Entity, par2, par3, par5, EntityAttributes.knockback1);
	}

	public boolean getCanSpawnHere() {
		return this.posY < 60.0D && this.posY > 32.0D && super.getCanSpawnHere();
	}
}
