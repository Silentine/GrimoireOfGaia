package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistBase;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaItem;
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
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaMermaid extends EntityMobAssistBase {
	
	public EntityGaiaMermaid(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.fireResistance = 10;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth2);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage2);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor2;
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
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 60, 0));
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 60, 2));
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

		super.onLivingUpdate();
	}

	protected SoundEvent getAmbientSound(){
		return "grimoireofgaia:assist_say";
	}

	protected SoundEvent getHurtSound(){
		return "grimoireofgaia:assist_hurt";
	}

	protected SoundEvent getDeathSound(){
		return "grimoireofgaia:assist_death";
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(GaiaItem.FoodCoalfish, 1);
		}

		//Shards
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}
		
		if (par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 3), 0.0F);
		}
		
		//Very Rare
		if (par1 && (this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1) > 0)) {
			this.dropItem(GaiaItem.BoxOld, 1);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(GaiaItem.BagOre, 1);
			break;
		case 1:
			this.dropItem(GaiaItem.BagBook, 1);
		}
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public boolean handleLavaMovement() {
		return false;
	}

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
		this.setEnchantmentBasedOnDifficulty(difficulty);
		return livingdata;		
    }
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (source instanceof EntityDamageSourceIndirect) {
			return false;
		}
		
		return super.attackEntityFrom(source, damage);
	}

	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
		super.knockBack(par1Entity, par2, par3, par5, EntityAttributes.knockback3);
	}

	public boolean getCanSpawnHere() {
		return this.posY < 60.0D && super.getCanSpawnHere();
	}
}
