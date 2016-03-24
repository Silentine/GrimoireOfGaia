package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaBlock;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaVampire extends EntityMobBase {
	private final float moveSpeed;
	private int spawnTime;
	private int spawnTime2;

	public EntityGaiaVampire(World par1World) {
		super(par1World);
		this.moveSpeed = EntityAttributes.moveSpeed3;
		this.setSize(1.0F, 2.2F);
		this.experienceValue = EntityAttributes.experienceValue3;
		this.stepHeight = 6.0F;
		this.isImmuneToFire = true;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIRestrictSun(this));
		this.tasks.addTask(2, new EntityAIFleeSun(this, (double)this.moveSpeed));
		this.tasks.addTask(3, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.spawnTime = 0;
		this.spawnTime2 = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth3);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed3);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage3);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(EntityAttributes.followrange);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor3;
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if (super.attackEntityAsMob(par1Entity)) {
			if (par1Entity instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                	byte0 = 7;
                } else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                	byte0 = 15;
                }

				if (byte0 > 0 && this.getHealth() < EntityAttributes.maxHealth3 * 0.75F) {
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.confusion.id, byte0 * 60, 0));
					this.heal(EntityAttributes.maxHealth1 * 0.10F);
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
				this.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
			}
		}

		EntityGaiaSummonButler spawnMob = new EntityGaiaSummonButler(this.worldObj);
		if (this.getHealth() < EntityAttributes.maxHealth3 * 0.75F && this.getHealth() > EntityAttributes.maxHealth3 * 0.25F) {
			if ((this.spawnTime > 0) && (this.spawnTime <= 200)) {
				++this.spawnTime;
			} else {
				if (!this.worldObj.isRemote) {
					spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
					spawnMob.onSpawnWithEgg((IEntityLivingData)null);
					this.worldObj.spawnEntityInWorld(spawnMob);
				}
				this.heal(10.0F);
				this.spawnTime = 1;
			}
		}

		if (this.getHealth() <= EntityAttributes.maxHealth3 * 0.25F && this.getHealth() > 0.0F) {
			for (int i = 0; i < 2; ++i) {
				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
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
				spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
				this.worldObj.spawnEntityInWorld(spawnMob2);
				this.spawnTime2 = 2;
			}
		} else {
			super.onLivingUpdate();
		}
	}

	protected String getLivingSound() {
		return "grimoireofgaia:aggressive_say";
	}

	protected String getHurtSound() {
		return "grimoireofgaia:aggressive_hurt";
	}

	protected String getDeathSound() {
		return "grimoireofgaia:aggressive_death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.worldObj.playSoundAtEntity(this, "grimoireofgaia:none", 1.0F, 1.0F);
	}
	
	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.FoodSmallAppleGold, 1);
		}
		
		//Shards
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 2), 0.0F);
		}
		
		int var13 = this.rand.nextInt(3) + 1;

		for (int var14 = 0; var14 < var13; ++var14) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 3), 0.0F);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItem.BoxDiamond, 1);
			break;
		case 1:
			this.dropItem(Item.getItemFromBlock(GaiaBlock.BustVampire), 1);
			break;
		case 2:
            this.entityDropItem(new ItemStack(GaiaItem.MiscRing, 1, 3), 0.0F);
		}
	}

	public void fall(float distance, float damageMultiplier) {}

	public void setInWeb() {}

	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (source instanceof EntityDamageSourceIndirect) {
			return false;
		}
		
		return super.attackEntityFrom(source, damage);
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
		super.knockBack(par1Entity, par2, par3, par5, EntityAttributes.knockback3);
	}

	public int getMaxSpawnedInChunk() {
		return 1;
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
