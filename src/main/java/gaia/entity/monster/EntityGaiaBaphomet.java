package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaBaphomet extends EntityMobBase implements IRangedAttackMob {
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private EntityAIGaiaAttackOnCollide aiAttackOnCollide = new EntityAIGaiaAttackOnCollide(this, 1.0D, true);
	
	private int switchHealth;

	public EntityGaiaBaphomet(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.isImmuneToFire = true;
		this.tasks.addTask(0, new EntityAISwimming(this));
//NULL	this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.switchHealth = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth2);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage2);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor2;
	}
	
	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2) {
		this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, this.getPosition(), 0);
		double d0 = par1EntityLivingBase.posX - this.posX;
		double d1 = par1EntityLivingBase.getEntityBoundingBox().minY + (double)(par1EntityLivingBase.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
		double d2 = par1EntityLivingBase.posZ - this.posZ;
		float f1 = MathHelper.sqrt_float(par2) * 0.5F;
		
		EntitySmallFireball var11 = new EntitySmallFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
		var11.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
		this.worldObj.spawnEntityInWorld(var11);
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if (super.attackEntityAsMob(par1Entity)) {
			if (par1Entity instanceof EntityLiving) {
                byte byte0 = 0;

                if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL){
                	byte0 = 7;
                } else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                	byte0 = 15;
                }

				if (byte0 > 0) {
					((EntityLiving)par1Entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 60, 0));
					((EntityLiving)par1Entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, byte0 * 60, 0));
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
		if ((this.getHealth() < EntityAttributes.maxHealth2 * 0.75F) && (this.switchHealth == 0)) {
			this.tasks.removeTask(this.aiArrowAttack);
			this.tasks.addTask(1, this.aiAttackOnCollide);
			this.switchHealth = 1;
		}

		if ((this.getHealth() > EntityAttributes.maxHealth2 * 0.75F) && (this.switchHealth == 1)) {
			this.tasks.removeTask(this.aiAttackOnCollide);
			this.tasks.addTask(1, this.aiArrowAttack);
			this.switchHealth = 0;
		}
		
		super.onLivingUpdate();
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
		this.playSound("mob.cow.step", 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {		
		int var3 = this.rand.nextInt(3 + par2);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(GaiaItem.MiscSoulFiery, 1);
		}
		
		int var5 = this.rand.nextInt(3 + par2);

		for (int var6 = 0; var6 < var5; ++var6) {
			this.dropItem(GaiaItem.FoodNetherWart, 1);
		}
		
		//Shards
		int var11 = this.rand.nextInt(3) + 1 ;

		for (int var12 = 0; var12 < var11; ++var12) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}
		
		if (par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1) > 0)) {
			this.dropItem(Items.GLOWSTONE_DUST, 1);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItem.BagOre, 1);
			break;
		case 1:
			this.dropItem(GaiaItem.BagBook, 1);
			break;
		case 2:
			this.dropItem(GaiaItem.BookWither, 1);
		}
	}

	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {}

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setCurrentItemOrArmor(0, new ItemStack(GaiaItem.PropWeapon, 1, 1));		
		this.setEnchantmentBasedOnDifficulty(difficulty);
		return livingdata;		
    }
	
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
		super.setCurrentItemOrArmor(par1, par2ItemStack);
		if (!this.worldObj.isRemote && par1 == 0) {
			this.setCombatTask();
		}
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.addTask(1, this.aiArrowAttack);
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotion() == MobEffects.WITHER?false:super.isPotionApplicable(par1PotionEffect);
	}

	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
		super.knockBack(par1Entity, par2, par3, par5, EntityAttributes.knockback2);
	}
}
