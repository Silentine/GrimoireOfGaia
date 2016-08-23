package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.jcraft.jorbis.Block;

public class EntityGaiaBoneKnight extends EntityMobBase {

	public EntityGaiaBoneKnight(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIRestrictSun(this));
		this.tasks.addTask(2, new EntityAIFleeSun(this, (double)EntityAttributes.moveSpeed2));
		this.tasks.addTask(3, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
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
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
			float f = this.getBrightness(1.0F);			
			if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canSeeSky(this.getPosition())) {
			this.setFire(8);
				this.heal(-20.0F);
			}
		}

		super.onLivingUpdate();
	}
	/** TODO LIVING SOUND -> AMBIENCE
	protected String getLivingSound() {
		return SoundEvents.ENTITY_SKELETON_AMBIENT;
	}
	**/	
	protected SoundEvent getAmbientSound(){
		return SoundEvents.ENTITY_SKELETON_AMBIENT;
	}
	
	protected SoundEvent getHurtSound(){		
		return SoundEvents.ENTITY_SKELETON_HURT;
	}

	protected SoundEvent getDeathSound(){	
		return SoundEvents.ENTITY_SKELETON_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn){	
		this.playSound(SoundEvents.ENTITY_SKELETON_STEP, 0.15F, 1.0F);		
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3) + 1;

		for (int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(Items.REDSTONE, 1);
		}
		
		//Shards
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}
		
		if (par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
            this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 3), 0.0F);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItem.BagOre, 1);
			break;
		case 1:
			this.dropItem(Item.getItemFromBlock(Blocks.REDSTONE_BLOCK), 1);
			break;
		case 2:
			this.entityDropItem(new ItemStack(Items.SKULL, 1, 0), 0.0F);
		}
	}
	
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));		
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
		super.knockBack(par1Entity, par2, par3, par5, EntityAttributes.knockback2);
	}

	public boolean getCanSpawnHere() {
		return this.posY < 32.0D && super.getCanSpawnHere();
	}
}
