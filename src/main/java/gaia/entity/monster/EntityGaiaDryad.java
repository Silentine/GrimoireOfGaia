package gaia.entity.monster;

import gaia.GaiaItem;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobDay;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaDryad extends EntityMobDay {
	private float field_70926_e;
	private float field_70924_f;

	public EntityGaiaDryad(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth1);
		//		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage1);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor1;
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
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, float damage) {
		Entity entity = par1DamageSource.getEntity();
		if(entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			ItemStack itemstack = player.getCurrentEquippedItem();
			if (itemstack != null) {
				Item item = itemstack.getItem();
				if (item != null) {
					if (item == Items.wooden_axe) {
						damage = 7.0F;
					}

					if (item == Items.stone_axe) {
						damage = 8.0F;
					}

					if (item == Items.iron_axe) {
						damage = 9.0F;
					}

					if (item == Items.golden_axe) {
						damage = 7.0F;
					}

					if (item == Items.diamond_axe) {
						damage = 10.0F;
					}
				}
			}
		}

		return super.attackEntityFrom(par1DamageSource, damage);
	}

	public boolean isAIEnabled() {
		return true;
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
		}

		super.setTarget(par1Entity);
	}

	public void onLivingUpdate() {
        super.onLivingUpdate();
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);
        
		if(this.isBurning()) {
			this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
			this.addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
		}
		
        for (int l = 0; l < 4; ++l)
        {
            i = MathHelper.floor_double(this.posX + (double)((float)(l % 2 * 2 - 1) * 0.25F));
            j = MathHelper.floor_double(this.posY);
            k = MathHelper.floor_double(this.posZ + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));

            if (this.worldObj.getBlock(i, j, k).getMaterial() == Material.air && Blocks.tallgrass.canPlaceBlockAt(this.worldObj, i, j, k) && (this.rand.nextFloat() < 0.8F))
            {
                this.worldObj.setBlock(i, j, k, Blocks.tallgrass, 1, 3);
            }
        }
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

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 0), 0.0F);
		}
		
		if(par1 && (this.rand.nextInt(10) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.FoodBerryCure,1);
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
		this.setCurrentItemOrArmor(0, new ItemStack(GaiaItem.PropWeaponInvisible));
		if(this.worldObj.rand.nextInt(4) == 0) {
			this.setTextureType(1);
		}

		return par1IEntityLivingData;
	}
	
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(19, new Byte((byte)0));
		this.dataWatcher.addObject(13, new Byte((byte)0));
	}
	
	public int getTextureType() {
		return this.dataWatcher.getWatchableObjectByte(13);
	}

	public void setTextureType(int par1) {
		this.dataWatcher.updateObject(13, Byte.valueOf((byte)par1));
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		if(par1NBTTagCompound.hasKey("MobType")) {
			byte b0 = par1NBTTagCompound.getByte("MobType");
			this.setTextureType(b0);
		}
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("MobType", (byte)this.getTextureType());
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
			if(this.motionY > EntityAttributes.knockback1) {
				this.motionY = EntityAttributes.knockback1;
			}
		}
	}
	
	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
