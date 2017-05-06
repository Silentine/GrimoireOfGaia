package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveDay;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaSatyress extends EntityMobPassiveDay {
	
	private EntityAIAttackMelee aiMeleeAttack = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed1, true);
	private EntityAIAvoidEntity aiAvoid = new EntityAIAvoidEntity(this, EntityPlayer.class, 4.0F, EntityAttributes.attackSpeed1, EntityAttributes.attackSpeed3);
	
	private int fullHealth;
	private int regenerateHealth;

	public EntityGaiaSatyress(World worldIn) {
		super(worldIn);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;

		this.fullHealth = 0;
		this.regenerateHealth = 0;
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
//		this.tasks.addTask(1, new RESERVED);
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
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
                	byte0 = 7;
                } else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                	byte0 = 15;
                }

				if (byte0 > 0) {
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 30, 0));
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
		if ((this.getHealth() < EntityAttributes.maxHealth1 * 0.25F) && (this.fullHealth == 0)) {
            ItemStack stacky = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM,1,0), PotionTypes.REGENERATION);
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, stacky);
			this.tasks.removeTask(this.aiMeleeAttack);
			this.tasks.addTask(1, this.aiAvoid);
			this.fullHealth = 1;
		}
		
		if (this.fullHealth == 1) {
			if (this.ticksExisted % 10 == 0) {
				this.worldObj.setEntityState(this, (byte)8);
			}
		}

		if ((this.getHealth() < EntityAttributes.maxHealth1) && (this.fullHealth == 1)) {
			if (this.regenerateHealth <= 100) {
				++this.regenerateHealth;
			} else {
				this.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 0.15F, 1.0F);
				this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 360, 3));
				this.regenerateHealth = 0;
			}
		} else if ((this.getHealth() >= EntityAttributes.maxHealth1) && (this.fullHealth == 1)) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
			this.removePotionEffect(MobEffects.REGENERATION);
			this.tasks.removeTask(this.aiAvoid);
			this.tasks.addTask(1, this.aiMeleeAttack);
			this.fullHealth = 0;
			this.regenerateHealth = 0;
		}
	
		super.onLivingUpdate();
	}
	
	protected SoundEvent getAmbientSound() {
		return Sounds.assist_say;
	}

	protected SoundEvent getHurtSound() {
		return Sounds.assist_hurt;
	}

	protected SoundEvent getDeathSound() {
		return Sounds.assist_death;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);	
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
				this.dropItem(GaiaItems.FoodMeat, 1);
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
		}
	}

	//Rare
	protected void addRandomDrop() {
		switch(this.rand.nextInt(1)) {
		case 0:
			this.dropItem(GaiaItems.BoxIron, 1);
		}
	}
	
	@Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {}
	
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		this.tasks.removeTask(this.aiAvoid);
		this.tasks.addTask(1, this.aiMeleeAttack);
		
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
		this.setEnchantmentBasedOnDifficulty(difficulty);
		
		return livingdata;		
    }
	
	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
