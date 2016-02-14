package gaia.entity.monster;

import gaia.GaiaItem;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobDay;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityGaiaCentaur extends EntityMobDay implements IRangedAttackMob {
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private EntityAIAvoidEntity aiAvoid = new EntityAIAvoidEntity(this, EntityPlayer.class, 4.0F, 1.0D, 1.4D);
	
	private int fullHealth;
	private int regenerateHealth;
	
	private float field_70926_e;
	private float field_70924_f;

	public EntityGaiaCentaur(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
//		this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.25D, 20, 60, 15.0F));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.fullHealth = 0;
		this.regenerateHealth = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth1);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage1);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor1;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2) {
		EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 1.6F, (float)(14 - this.worldObj.difficultySetting.ordinal() * 4));
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
		int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
		entityarrow.setDamage((double)(par2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting.ordinal() * 0.11F));
		if(i > 0) {
			entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5D + 0.5D);
		}

		if(j > 0) {
			entityarrow.setKnockbackStrength(j);
		}

		if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0) {
			entityarrow.setFire(100);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entityarrow);
	}
	
	@Override
    public boolean canAttackClass(Class par1Class) {
        return super.canAttackClass(par1Class) && par1Class != EntityGaiaCentaur.class;
    }

	public boolean isAIEnabled() {
		return true;
	}
	
	public void onLivingUpdate() {
		if ((this.getHealth() < EntityAttributes.maxHealth1 * 0.25F) && (this.fullHealth == 0)){
            this.setCurrentItemOrArmor(0, new ItemStack(Items.potionitem, 1, 16341));
			this.tasks.removeTask(this.aiArrowAttack);
			this.tasks.addTask(1, this.aiAvoid);
			this.fullHealth = 1;
		}

		if ((this.getHealth() < EntityAttributes.maxHealth1) && (this.fullHealth == 1)){
			if (this.regenerateHealth <= 100) {
				++this.regenerateHealth;
			} else {
				this.playSound("random.drink", 0.15F, 1.0F);
				this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 360, 3));
				this.regenerateHealth = 0;
			}
		} else if ((this.getHealth() >= EntityAttributes.maxHealth1) && (this.fullHealth == 1)){
			this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
			this.removePotionEffect(Potion.regeneration.id);
			this.tasks.removeTask(this.aiAvoid);
			this.tasks.addTask(1, this.aiArrowAttack);
			this.fullHealth = 0;
			this.regenerateHealth = 0;
		}

		super.onLivingUpdate();
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(19, new Byte((byte)0));
	}

	public void onUpdate() {
		super.onUpdate();
		this.field_70924_f = this.field_70926_e;
		if(this.func_70922_bv()) {
			this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
		} else {
			this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
		}

		if(this.func_70922_bv()) {
			this.numTicksToChaseTarget = 10;
		}
	}

	public boolean func_70922_bv() {
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	public void func_70918_i(boolean par1) {
		if(par1) {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
		} else {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
		}
	}

	public void setTarget(Entity par1Entity) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		if(elements.length > 2) {
			StackTraceElement previousMethod = elements[2];
			if(previousMethod.getClassName().startsWith("org.millenaire.") && previousMethod.getMethodName().equals("triggerMobAttacks")) {
				return;
			}
			/*
			if(previousMethod.getClassName().startsWith("MCA.") && previousMethod.getMethodName().equals("triggerMobAttacks")) {
				return;
			}
			*/
		}
		
		super.setTarget(par1Entity);
	}

	protected String getLivingSound() {
		return "gaia:assist_say";
	}

	protected String getHurtSound() {
		return "gaia:assist_hurt";
	}

	protected String getDeathSound() {
		return "gaia:assist_death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(Items.arrow,1);
		}
		
		if(par1 && (this.rand.nextInt(10) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.FoodMeat,1);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(GaiaItem.BoxIron,1);
			break;
		case 1:
			this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}
	
	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
    }
	
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1IEntityLivingData) {
		par1IEntityLivingData = super.onSpawnWithEgg(par1IEntityLivingData);
		this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
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
		this.tasks.removeTask(this.aiAvoid);
		this.tasks.addTask(1, this.aiArrowAttack);
	}
	
	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
