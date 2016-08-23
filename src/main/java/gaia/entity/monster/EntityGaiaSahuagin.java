package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaSahuagin extends EntityMobBase implements IRangedAttackMob {
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private EntityAIGaiaAttackOnCollide aiAttackOnCollide = new EntityAIGaiaAttackOnCollide(this, 1.0D, true);
	
	private int switchHealth;

	public EntityGaiaSahuagin(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.fireResistance = 10;
		this.tasks.addTask(0, new EntityAISwimming(this));
//NULL	this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.switchHealth = 0;
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

	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2) {
		EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 1.6F, (float)(14 - this.worldObj.getDifficulty().ordinal() * 4));
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, this.getHeldItem());
		int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, this.getHeldItem());
		entityarrow.setDamage((double)(par2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.getDifficulty().ordinal() * 0.11F));
		if (i > 0) {
			entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5D + 0.5D);
		}

		if (j > 0) {
			entityarrow.setKnockbackStrength(j);
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, this.getHeldItem()) > 0) {
			entityarrow.setFire(100);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entityarrow);
	}
	
	@Override
    public boolean canAttackClass(Class par1Class) {
        return super.canAttackClass(par1Class) && par1Class != EntityGaiaSahuagin.class;
    }
	
	public boolean attackEntityAsMob(Entity par1Entity) {
		if (super.attackEntityAsMob(par1Entity)) {
			if (par1Entity instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL){
                	byte0 = 7;
                } else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                	byte0 = 15;
                }

				if (byte0 > 0) {
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 30, 1));
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
		if (this.isInWater()) {
			this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 0));
		}

		if ((this.getHealth() < EntityAttributes.maxHealth1 * 0.25F) && (this.switchHealth == 0)) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItem.PropWeapon, 1, 3));
			this.tasks.removeTask(this.aiArrowAttack);
			this.tasks.addTask(1, this.aiAttackOnCollide);
			this.switchHealth = 1;
		}

		if ((this.getHealth() > EntityAttributes.maxHealth1 * 0.50F) && (this.switchHealth == 1)) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
			this.tasks.removeTask(this.aiAttackOnCollide);
			this.tasks.addTask(1, this.aiArrowAttack);
			this.switchHealth = 0;
		}

		super.onLivingUpdate();
	}

	protected SoundEvent getAmbientSound(){
		return "grimoireofgaia:aggressive_say";
	}

	protected SoundEvent getHurtSound(){
		return "grimoireofgaia:aggressive_hurt";
	}

	protected SoundEvent getDeathSound(){
		return "grimoireofgaia:aggressive_death";
	}

	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.FoodCoalfish, 1);
		}

		//Shards
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(GaiaItem.BagOre, 1);
			break;
		case 1:
			this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public boolean handleLavaMovement() {
		return false;
	}
	
	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {}

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata){
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));	
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
	
	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
		super.knockBack(par1Entity, par2, par3, par5, EntityAttributes.knockbackbase);
	}

	public boolean getCanSpawnHere() {
		return this.posY < 60.0D && super.getCanSpawnHere();
	}
}
