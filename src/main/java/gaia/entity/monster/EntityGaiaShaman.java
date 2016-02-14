package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaShaman extends EntityMobBase implements IRangedAttackMob {
	private static final Item[] shamanDrops = new Item[] { 
		Items.book,
		Items.sugar, 
		Items.paper, 
		Items.rotten_flesh, 
		Items.glass_bottle,
		Items.gunpowder };
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private EntityAIGaiaAttackOnCollide aiAttackOnCollide = new EntityAIGaiaAttackOnCollide(this, 1.0D, true);

	private int switchHealth;
	private int spawn;

	public EntityGaiaShaman(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
//		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.switchHealth = 0;
		this.spawn = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth2);
//		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage2);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor2;
	}
	
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2) {
		this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
		double d0 = par1EntityLivingBase.posX - this.posX;
		double d1 = par1EntityLivingBase.boundingBox.minY + (double)(par1EntityLivingBase.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
		double d2 = par1EntityLivingBase.posZ - this.posZ;
		float f1 = MathHelper.sqrt_float(par2) * 0.5F;
		
		EntityGaiaProjectileMagic var11 = new EntityGaiaProjectileMagic(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
		var11.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
		this.worldObj.spawnEntityInWorld(var11);
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if(super.attackEntityAsMob(par1Entity)) {
			if(par1Entity instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL){
                	byte0 = 7;
                } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                	byte0 = 15;
                }

				if(byte0 > 0) {
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, byte0 * 20, 0));
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.weakness.id, byte0 * 60, 0));
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
	
	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id?false:super.isPotionApplicable(par1PotionEffect);
	}

	public void onLivingUpdate() {
		if ((this.getHealth() < EntityAttributes.maxHealth2 * 0.75F) && (this.switchHealth == 0)){
			this.tasks.removeTask(this.aiArrowAttack);
			this.tasks.addTask(1, this.aiAttackOnCollide);
			this.switchHealth = 1;
		}

		if ((this.getHealth() > EntityAttributes.maxHealth2 * 0.75F) && (this.switchHealth == 1)){
			this.tasks.removeTask(this.aiAttackOnCollide);
			this.tasks.addTask(1, this.aiArrowAttack);
			this.switchHealth = 0;
		}
		
		EntityZombie spawnMob;
		if(this.getHealth() < EntityAttributes.maxHealth2 * 0.75F && this.getHealth() > 0.0F && this.spawn == 0 && !this.worldObj.isRemote) {
			spawnMob = new EntityZombie(this.worldObj);
			spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			spawnMob.onSpawnWithEgg((IEntityLivingData)null);
			this.worldObj.spawnEntityInWorld(spawnMob);
			this.spawn = 1;
		}

		if(this.getHealth() < EntityAttributes.maxHealth2 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1 && !this.worldObj.isRemote) {
			spawnMob = new EntityZombie(this.worldObj);
			spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			spawnMob.onSpawnWithEgg((IEntityLivingData)null);
			this.worldObj.spawnEntityInWorld(spawnMob);
			this.spawn = 2;
		}

		super.onLivingUpdate();
	}

	protected String getLivingSound() {
		return "gaia:aggressive_say";
	}

	protected String getHurtSound() {
		return "gaia:aggressive_hurt";
	}

	protected String getDeathSound() {
		return "gaia:aggressive_death";
	}

	protected void dropFewItems(boolean par1, int par2) {		
		int var3 = this.rand.nextInt(3) + 1;

		for(int var4 = 0; var4 < var3; ++var4) {
			int var5 = this.rand.nextInt(3);
			Item var6 = shamanDrops[this.rand.nextInt(shamanDrops.length)];
			if(par2 > 0) {
				var5 += this.rand.nextInt(par2 + 1);
			}

			for(int var7 = 0; var7 < var5; ++var7) {
				this.dropItem(var6, 1);
			}
		}
		
		var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(GaiaItem.FoodBerryHealth,1);
		}
			
		if(par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 5), 0.0F);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}

		if(par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.Fragment, 1);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItem.BoxGold,1);
			break;
		case 1:
			this.dropItem(GaiaItem.BagBook,1);
			break;
		case 2:
			this.dropItem(GaiaItem.MiscBook,1);
		}
	}
	
	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
    }

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1IEntityLivingData) {
		par1IEntityLivingData = super.onSpawnWithEgg(par1IEntityLivingData);
		this.setCurrentItemOrArmor(0, new ItemStack(GaiaItem.PropWeapon, 1, 0));
		this.enchantEquipment();
		return par1IEntityLivingData;
	}
	
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
		super.setCurrentItemOrArmor(par1, par2ItemStack);
		if(!this.worldObj.isRemote && par1 == 0) {
			this.setCombatTask();
		}
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.addTask(1, this.aiArrowAttack);
	}

	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
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
			if(this.motionY > EntityAttributes.knockback2) {
				this.motionY = EntityAttributes.knockback2;
			}
		}
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
