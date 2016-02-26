package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.init.GaiaItem;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import net.minecraft.block.material.Material;
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
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaWitch extends EntityMobBase implements IRangedAttackMob {
	private static final Item[] witchDrops = new Item[] { 
		Items.book, 
		Items.sugar, 
		Items.paper, 
		Items.spider_eye, 
		Items.glass_bottle, 
		Items.gunpowder };
	private int spawn;
	
	private static final UUID field_110184_bp = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
	private static final AttributeModifier field_110185_bq = (new AttributeModifier(field_110184_bp, "Drinking speed penalty", -0.25D, 0)).setSaved(false);
	private int witchAttackTimer;
//	private static final String __OBFID = "CL_00001701";
	private final float moveSpeed;

	public EntityGaiaWitch(World par1World) {
		super(par1World);
		this.moveSpeed = EntityAttributes.moveSpeed2;
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIArrowAttack(this, (double)this.moveSpeed, 60, 10.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
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

	protected void entityInit() {
		super.entityInit();
		this.getDataWatcher().addObject(21, Byte.valueOf((byte)0));
	}

	public void setAggressive(boolean par1) {
		this.getDataWatcher().updateObject(21, Byte.valueOf((byte)(par1?1:0)));
	}

	public boolean getAggressive() {
		return this.getDataWatcher().getWatchableObjectByte(21) == 1;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		if(!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.8D;
		}

		for(int var5 = 0; var5 < 2; ++var5) {
			//"witchMagic"
			this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}

		EntitySpider mob;
		if(this.getHealth() < EntityAttributes.maxHealth2 * 0.75F && this.getHealth() > 0.0F && this.spawn == 0 && !this.worldObj.isRemote) {
			mob = new EntitySpider(this.worldObj);
			mob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			//mob.onSpawnWithEgg((IEntityLivingData)null);
			mob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(mob)), (IEntityLivingData)null);
			this.worldObj.spawnEntityInWorld(mob);
			this.spawn = 1;
		}

		if(this.getHealth() < EntityAttributes.maxHealth2 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1 && !this.worldObj.isRemote) {
			mob = new EntitySpider(this.worldObj);
			mob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			//mob.onSpawnWithEgg((IEntityLivingData)null);
			mob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(mob)), (IEntityLivingData)null);
			this.worldObj.spawnEntityInWorld(mob);
			this.spawn = 2;
		}

		if(!this.worldObj.isRemote) {
			if(this.getAggressive()) {
				if(this.witchAttackTimer-- <= 0) {
					this.setAggressive(false);
					ItemStack var6 = this.getHeldItem();
					this.setCurrentItemOrArmor(0, (ItemStack)null);
					if(var6 != null && var6.getItem() == Items.potionitem) {
						List var2 = Items.potionitem.getEffects(var6);
						if(var2 != null) {
							Iterator var3 = var2.iterator();

							while(var3.hasNext()) {
								PotionEffect var4 = (PotionEffect)var3.next();
								this.addPotionEffect(new PotionEffect(var4));
							}
						}
					}
					
					this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeModifier(field_110185_bq);
				}
			} else {
				short var7 = -1;
                if (this.rand.nextFloat() < 0.15F && this.isInsideOfMaterial(Material.water) && !this.isPotionActive(Potion.waterBreathing)) {
                	var7 = 8237;
                }
                else if(this.rand.nextFloat() < 0.15F && this.isBurning() && !this.isPotionActive(Potion.fireResistance)) {
					var7 = 16307;
				} 
                else if(this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
					var7 = 16341;
				} 
                else if(this.rand.nextFloat() < 0.25F && this.getAttackTarget() != null && !this.isPotionActive(Potion.moveSpeed) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D) {
					var7 = 16274;
				} 
                else if(this.rand.nextFloat() < 0.25F && this.getAttackTarget() != null && !this.isPotionActive(Potion.moveSpeed) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D) {
					var7 = 16274;
				}

				if(var7 > -1) {
                    this.setCurrentItemOrArmor(0, new ItemStack(Items.potionitem, 1, var7));
                    this.witchAttackTimer = this.getHeldItem().getMaxItemUseDuration();
                    this.setAggressive(true);
                    IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    iattributeinstance.removeModifier(field_110185_bq);
                    iattributeinstance.applyModifier(field_110185_bq);
				}
			}

			if(this.rand.nextFloat() < 7.5E-4F) {
				this.worldObj.setEntityState(this, (byte)15);
			}
		}

		super.onLivingUpdate();
	}

	protected float applyPotionDamageCalculations(DamageSource par1DamageSource, float par2) {
		par2 = super.applyPotionDamageCalculations(par1DamageSource, par2);
		if(par1DamageSource.getEntity() == this) {
			par2 = 0.0F;
		}

		if(par1DamageSource.isMagicDamage()) {
			par2 = (float)((double)par2 * 0.15D);
		}

		return par2;
	}

	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte par1) {
		if(par1 == 15) {
			for(int var2 = 0; var2 < this.rand.nextInt(35) + 10; ++var2) {
				//"witchMagic"
				this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX + this.rand.nextGaussian() * 0.12999999523162842D, this.getEntityBoundingBox().maxY + 0.5D + this.rand.nextGaussian() * 0.12999999523162842D, this.posZ + this.rand.nextGaussian() * 0.12999999523162842D, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.handleStatusUpdate(par1);
		}
	}

	public float getAIMoveSpeed() {
		float speed = super.getAIMoveSpeed();
		if(this.getAggressive()) {
			speed *= 0.75F;
		}

		return speed;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving, float par2) {
		if(!this.getAggressive()) {
			EntityPotion var2 = new EntityPotion(this.worldObj, this, 32732);
			var2.rotationPitch -= -20.0F;
			double var3 = par1EntityLiving.posX + par1EntityLiving.motionX - this.posX;
			double var5 = par1EntityLiving.posY + (double)par1EntityLiving.getEyeHeight() - 1.100000023841858D - this.posY;
			double var7 = par1EntityLiving.posZ + par1EntityLiving.motionZ - this.posZ;
			float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7);
			if(var9 >= 8.0F && !par1EntityLiving.isPotionActive(Potion.moveSlowdown)) {
				var2.setPotionDamage(32698);
			} else if(par1EntityLiving.getHealth() >= 8.0F && !par1EntityLiving.isPotionActive(Potion.poison)) {
				var2.setPotionDamage(32660);
			} else if(var9 <= 3.0F && !par1EntityLiving.isPotionActive(Potion.weakness) && this.rand.nextFloat() < 0.25F) {
				var2.setPotionDamage(32696);
			}

			var2.setThrowableHeading(var3, var5 + (double)(var9 * 0.2F), var7, 0.75F, 8.0F);
			this.worldObj.spawnEntityInWorld(var2);
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
		//TODO fix this no sound thingy
		//this.worldObj.playSoundAtEntity(this, "none", 1.0F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3) + 1;

		for(int var4 = 0; var4 < var3; ++var4) {
			int var5 = this.rand.nextInt(3);
			Item var6 = witchDrops[this.rand.nextInt(witchDrops.length)];
			if(par2 > 0) {
				var5 += this.rand.nextInt(par2 + 1);
			}

			for(int var7 = 0; var7 < var5; ++var7) {
				this.dropItem(var6, 1);
			}
		}
		
		if(par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 5), 0.0F);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}
		
		if(par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.FoodDriedNetherWart, 1, 3), 0.0F);
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

	protected void fall(float f) {}
	
	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
    }
	/*
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1IEntityLivingData) {
		par1IEntityLivingData = super.onSpawnWithEgg(par1IEntityLivingData);
		this.setCurrentItemOrArmor(0, new ItemStack(GaiaItem.PropWeapon, 1, 0));
		this.enchantEquipment();
		return par1IEntityLivingData;
	}
	*/
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setCurrentItemOrArmor(0, new ItemStack(GaiaItem.PropWeapon, 1, 0));		
		this.setEnchantmentBasedOnDifficulty(difficulty);
		return livingdata;		
		
    }

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id?false:super.isPotionApplicable(par1PotionEffect);
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
