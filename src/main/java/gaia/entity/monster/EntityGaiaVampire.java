package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaVampire extends EntityMobHostileBase {
	
	private int spawnTime;
	private int spawnTime2;

	public EntityGaiaVampire(World par1World) {
		super(par1World);
		this.setSize(1.0F, 2.2F);
		this.experienceValue = EntityAttributes.experienceValue3;
		this.stepHeight = 1.0F;
		this.isImmuneToFire = true;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIRestrictSun(this));
		this.tasks.addTask(2, new EntityAIFleeSun(this, EntityAttributes.attackSpeed3));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed3, true));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

		this.spawnTime = 0;
		this.spawnTime2 = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth3);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed3);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage3);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor3);
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > EntityAttributes.baseDefense3) {
			damage = EntityAttributes.baseDefense3;
		}
		
		if (source instanceof EntityDamageSourceIndirect) {
			return false;
		}
		
		return super.attackEntityFrom(source, damage);
	}
	
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback3);
	}

    public boolean attackEntityAsMob(Entity entityIn) {
    	if (super.attackEntityAsMob(entityIn)) {
    		if (entityIn instanceof EntityLivingBase) {
    			byte byte0 = 0;

    			if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
    				byte0 = 7;
    			} else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
    				byte0 = 15;
    			}

    			if (byte0 > 0 && this.getHealth() < EntityAttributes.maxHealth3 * 0.75F) {
    				((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, byte0 * 60, 0));

    				if (this.worldObj.isRemote)handleStatusUpdate((byte)9);
    				this.heal(EntityAttributes.maxHealth3 * 0.10F);
    			}
    		}

			return true;
		} else {
			return false;
		}
	}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.8D;
		}

		if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
			float f = this.getBrightness(1.0F);			
			if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canSeeSky(this.getPosition())) {				
				this.attackEntityFrom(DamageSource.generic, EntityAttributes.maxHealth3 * 0.25F);
				this.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 100, 0));
			}
		}

		EntityGaiaSummonButler spawnMob = new EntityGaiaSummonButler(this.worldObj);
		if (this.getHealth() < EntityAttributes.maxHealth3 * 0.75F && this.getHealth() > EntityAttributes.maxHealth3 * 0.25F) {
			if ((this.spawnTime > 0) && (this.spawnTime <= 200)) {
				++this.spawnTime;
			} else {
				if (this.worldObj.isRemote)handleStatusUpdate((byte)12);
				if (!this.worldObj.isRemote) {
					spawnMob = new EntityGaiaSummonButler(this.worldObj);
					spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
					spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
					this.worldObj.spawnEntityInWorld(spawnMob);
				}

				if (this.worldObj.isRemote)handleStatusUpdate((byte)9);
				this.heal(EntityAttributes.maxHealth3 * 0.10F);
				
				this.spawnTime = 1;
			}
		}
		
		if (!this.worldObj.isRemote) {
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}

		if (this.getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
			
			EntityBat spawnMob2 = new EntityBat(this.worldObj);
			if (this.spawnTime2 == 0 && !this.worldObj.isRemote) {
				this.spawnTime2 = 1;
			} else if (this.spawnTime2 == 1 && !this.worldObj.isRemote) {
				spawnMob2.setLocationAndAngles(this.posX, this.posY + 1.0D, this.posZ, this.rotationYaw, 0.0F);
				spawnMob2.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob2)), (IEntityLivingData)null);
				this.worldObj.spawnEntityInWorld(spawnMob2);
				this.spawnTime2 = 2;
			}
		} else {
			super.onLivingUpdate();
		}
	}

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
    	if (id == 12)
    		this.spawnParticles(EnumParticleTypes.EXPLOSION_NORMAL);
    	else if (id == 13)
    		this.spawnParticles(EnumParticleTypes.SMOKE_LARGE);
    	else
    		super.handleStatusUpdate(id);
    }

    @SideOnly(Side.CLIENT)
    private void spawnParticles(EnumParticleTypes particleType) {
        for (int i = 0; i < 5; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(particleType, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2, new int[0]);
        }
    }
    
	//================= Climber data =================//
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
	}

	protected PathNavigate getNewNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock() {
		return (((Byte)this.dataManager.get(CLIMBING)).byteValue() & 1) != 0;
	}

	private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityDebugMob.class, DataSerializers.BYTE);

	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = ((Byte)this.dataManager.get(CLIMBING)).byteValue();

		if(climbing)
			b0 = (byte)(b0 | 1); 
		else
			b0 = (byte)(b0 & -2);

		this.dataManager.set(CLIMBING, Byte.valueOf(b0));
	}
	//==================================//
	
	protected SoundEvent getAmbientSound() {
		return Sounds.aggressive_say;
	}

	protected SoundEvent getHurtSound() {
		return Sounds.aggressive_hurt;
	}

	protected SoundEvent getDeathSound() {
		return Sounds.aggressive_death;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(Sounds.none, 1.0F, 1.0F);
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItems.FoodSmallAppleGold, 1);
		}
		
		//Nuggets/Fragments
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
            ItemShard.Drop_Nugget(this,2);
		}
		
		int var13 = this.rand.nextInt(3) + 1;

		for (int var14 = 0; var14 < var13; ++var14) {
            ItemShard.Drop_Nugget(this,3);
		}
	}

	//Rare
	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItems.BoxDiamond, 1);
			break;
		case 1:
			this.dropItem(Item.getItemFromBlock(GaiaBlocks.BustVampire), 1);
			break;
		case 2:
            this.entityDropItem(new ItemStack(GaiaItems.MiscRing, 1, 3), 0.0F);
		}
	}
	
	public boolean allowLeashing() {
		return false;
	}

	public void fall(float distance, float damageMultiplier) {}

	public void setInWeb() {}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	public int getMaxSpawnedInChunk() {
		return 1;
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
