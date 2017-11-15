package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaSludgeGirl extends EntityMobHostileBase {

	public EntityGaiaSludgeGirl(World worldIn) {
		super(worldIn);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.fireResistance = 10;
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed1, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth1);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage1);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor1);
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > EntityAttributes.baseDefense1) {
			damage = EntityAttributes.baseDefense1;
		}
		
		return super.attackEntityFrom(source, damage);
	}
	
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback1);
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                	byte0 = 5;
                } else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                	byte0 = 10;
                }

				if (byte0 > 0) {
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 20, 0));
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
		super.onLivingUpdate();
	}

	protected SoundEvent getAmbientSound() {
		return Sounds.aggressive_say;
	}

	protected SoundEvent getHurtSound() {
		return SoundEvents.ENTITY_SLIME_JUMP;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SLIME_JUMP;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0F, 1.0F);	
	}

	public void onDeath(DamageSource cause) {
		this.lingeringEffect(this, MobEffects.POISON, PotionTypes.EMPTY, 200, 0, this.getPosition());
		super.onDeath(cause);
	}
	
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
				this.dropItem(Items.SLIME_BALL, 1);
			}

			//Nuggets/Fragments
			int var11 = this.rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this,0);
			}

			if (GaiaConfig.AdditionalOre == true) {
				int var13 = this.rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this,4);
				}
			}
			
    		//Rare
    		if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
    			switch(this.rand.nextInt(2)) {
    			case 0:
    				this.dropItem(GaiaItems.BoxIron, 1);
    				break;
    			case 1:
    				this.dropItem(Item.getItemFromBlock(GaiaBlocks.DollSlimeGirl), 1);
    			}
    		}
		}
	}

	//================= Immunities =================//
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potioneffectIn);
	}
	//==============================================//
	
	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
