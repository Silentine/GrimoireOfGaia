package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
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
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaMinotaur extends EntityMobHostileBase {
	
	private int buffEffect;

	public EntityGaiaMinotaur(World worldIn) {
		super(worldIn);
		this.setSize(1.4F, 3.0F);
		this.experienceValue = EntityAttributes.experienceValue3;
		this.stepHeight = 1.0F;
		this.isImmuneToFire = true;

		this.buffEffect = 0;
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed3, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth3);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed3);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage3);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor3);
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > EntityAttributes.baseDefense3) {
			damage = EntityAttributes.baseDefense3;
		}
		
		if (source instanceof EntityDamageSourceIndirect) {
			return false;
		}
		
		return super.attackEntityFrom(source, damage);
	}
	
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback3);
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                	byte0 = 20;
                } else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                	byte0 = 30;
                }

				if (byte0 > 0) {
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20, 0));
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
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.8D;
		}

		if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
			int i = MathHelper.floor_double(this.posX);
			int j = MathHelper.floor_double(this.posY - 0.20000000298023224D);
			int k = MathHelper.floor_double(this.posZ);
			IBlockState iblockstate = this.worldObj.getBlockState(new BlockPos(i, j, k));

			if (iblockstate.getMaterial() != Material.AIR)
			{
				this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D, new int[] {Block.getStateId(iblockstate)});
			}
		}
		
		if (this.getHealth() > EntityAttributes.maxHealth3 * 0.25F && this.buffEffect == 1) {
			this.buffEffect = 0;
		} else if (this.getHealth() <= EntityAttributes.maxHealth3 * 0.25F && this.getHealth() > 0.0F && this.buffEffect == 0) {
	        this.worldObj.setEntityState(this, (byte)10);
			
			this.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 100, 0));
			this.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 100, 0));
			
			this.buffEffect = 1;
		}

		if (!this.worldObj.isRemote) {
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}

		if (this.getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.onLivingUpdate();
		}
	}

	//================= Climber data =================//
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
	}

	protected PathNavigate getNewNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock() {
		return (((Byte)this.dataManager.get(CLIMBING)).byteValue() & 1) != 0;
	}

	private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityDebugMob.class, DataSerializers.BYTE);

	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = ((Byte)this.dataManager.get(CLIMBING)).byteValue();

		if(climbing)
			b0 = (byte)(b0 | 1); 
		else
			b0 = (byte)(b0 & -2);

		this.dataManager.set(CLIMBING, Byte.valueOf(b0));
	}
	//================================================//

	protected SoundEvent getAmbientSound() {
		return Sounds.minotaur_say;
	}

	protected SoundEvent getHurtSound() {
		return Sounds.minotaur_hurt;
	}

	protected SoundEvent getDeathSound() {
		return Sounds.minotaur_hurt;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(SoundEvents.ENTITY_IRONGOLEM_STEP, 1.0F, 1.0F);
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
				this.dropItem(GaiaItems.FoodSmallAppleGold, 1);
			}

			//Nuggets/Shards
			int var11 = this.rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this,2);
			}

			int var13 = this.rand.nextInt(3) + 1;

			for (int var14 = 0; var14 < var13; ++var14) {
				ItemShard.Drop_Nugget(this,3);
			}
			
    		//Rare
    		if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
    			switch(this.rand.nextInt(3)) {
    			case 0:
    				this.dropItem(GaiaItems.BoxDiamond, 1);
    				break;
    			case 1:
    				this.dropItem(GaiaItems.AccessoryCursed, 1);
    				break;
    			case 2:
    	            this.entityDropItem(new ItemStack(GaiaItems.MiscRing, 1, 1), 0.0F);
    			}
    		}
		}
	}
	
	@Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {}
	
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 5));
		
		ItemStack BOOTS_SWIMMING = new ItemStack(Items.LEATHER_BOOTS);
		this.setItemStackToSlot(EntityEquipmentSlot.FEET, BOOTS_SWIMMING);
		BOOTS_SWIMMING.addEnchantment(Enchantment.getEnchantmentByLocation("depth_strider"), 2);
		
		return livingdata;		
    }

	public float MinotaurScaleAmount() {
		return 1.25F;
	}
	
	//================= Tier Immunities =================//
	public boolean canBreatheUnderwater() {
		return true;
	}
	
    public boolean isPushedByWater() {
        return false;
    }
    
	public void fall(float distance, float damageMultiplier) {}

	public void setInWeb() {}
	//===================================================//

	public int getMaxSpawnedInChunk() {
		return 1;
	}

	public boolean getCanSpawnHere() {
		return this.posY < 32.0D && super.getCanSpawnHere();
	}
}
