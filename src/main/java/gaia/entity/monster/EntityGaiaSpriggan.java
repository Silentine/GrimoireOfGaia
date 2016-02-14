package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityGaiaSpriggan extends EntityMobBase {

	public EntityGaiaSpriggan(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 2.0F, 1.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
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

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		Entity entity = par1DamageSource.getEntity();
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getCurrentEquippedItem();
			if (itemstack != null) {
				if (itemstack.getItem() == Items.wooden_axe) {
					par2 = 7;
				}

				if (itemstack.getItem() == Items.stone_axe) {
					par2 = 8;
				}

				if (itemstack.getItem() == Items.iron_axe) {
					par2 = 9;
				}

				if (itemstack.getItem() == Items.golden_axe) {
					par2 = 7;
				}

				if (itemstack.getItem() == Items.diamond_axe) {
					par2 = 10;
				}
			}
		}

		return super.attackEntityFrom(par1DamageSource, (float) par2);
	}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		if(this.isBurning()) {
			this.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 0));
			this.addPotionEffect(new PotionEffect(Potion.weakness.id, 100, 0));
		}

		super.onLivingUpdate();
	}

	protected String getHurtSound() {
		return "step.wood";
	}

	protected String getDeathSound() {
		return "mob.zombie.woodbreak";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("step.wood", 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(GaiaItem.FoodBerryCure,1);
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
			this.dropItem(GaiaItem.BookNature,1);
		}
	}
	
	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {
    }
	
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData eld) {
		IEntityLivingData res = super.onSpawnWithEgg(eld);
		this.setCurrentItemOrArmor(0, new ItemStack(GaiaItem.PropWeaponInvisible));
		return res;
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
