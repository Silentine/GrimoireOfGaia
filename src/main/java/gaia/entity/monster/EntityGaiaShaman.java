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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaShaman extends EntityMobBase implements IRangedAttackMob {
	private static final Item[] shamanDrops = new Item[] { 
		Items.SUGAR, 
		Items.ROTTEN_FLESH, 
		Items.GLASS_BOTTLE,
		Items.GUNPOWDER,
		Items.STICK,
		Items.STICK
		};
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private EntityAIGaiaAttackOnCollide aiAttackOnCollide = new EntityAIGaiaAttackOnCollide(this, 1.0D, true);

	private int switchHealth;
	private int spawn;

	public EntityGaiaShaman(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
//NULL	this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.switchHealth = 0;
		this.spawn = 0;
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
		
		EntityGaiaProjectileMagic var11 = new EntityGaiaProjectileMagic(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
		var11.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
		this.worldObj.spawnEntityInWorld(var11);
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

				if (byte0 > 0) {
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 20, 0));
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, byte0 * 60, 0));
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
		return par1PotionEffect.getPotion() == MobEffects.POISON?false:super.isPotionApplicable(par1PotionEffect);
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
		if (this.getHealth() < EntityAttributes.maxHealth2 * 0.75F && this.getHealth() > 0.0F && this.spawn == 0 && !this.worldObj.isRemote) {
			spawnMob = new EntityZombie(this.worldObj);
			spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
			spawnMob.setCurrentItemOrArmor(4, new ItemStack(Blocks.PUMPKIN));	
			this.worldObj.spawnEntityInWorld(spawnMob);
			this.spawn = 1;
		}

		if (this.getHealth() < EntityAttributes.maxHealth2 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1 && !this.worldObj.isRemote) {
			spawnMob = new EntityZombie(this.worldObj);
			spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
			spawnMob.setCurrentItemOrArmor(4, new ItemStack(Blocks.PUMPKIN));	
			this.worldObj.spawnEntityInWorld(spawnMob);
			this.spawn = 2;
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
		int var3 = this.rand.nextInt(3) + 1;

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = this.rand.nextInt(3);
			Item var6 = shamanDrops[this.rand.nextInt(shamanDrops.length)];
			if (par2 > 0) {
				var5 += this.rand.nextInt(par2 + 1);
			}

			for (int var7 = 0; var7 < var5; ++var7) {
				this.dropItem(var6, 1);
			}
		}
		
		var3 = this.rand.nextInt(3 + par2);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(GaiaItem.FoodRottenHeart, 1);
		}

		//Shards
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}
		
		if (par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 3), 0.0F);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItem.BoxGold, 1);
			break;
		case 1:
			this.dropItem(GaiaItem.BagBook, 1);
			break;
		case 2:
			this.dropItem(GaiaItem.MiscBook, 1);
		}
	}
	
	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {}

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItem.PropWeapon, 1, 0));	
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
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
