package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import gaia.renderer.particle.ParticleWarning;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
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
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaMinotaurus extends EntityMobHostileBase implements GaiaIRangedAttackMob {
	
	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.attackSpeed2, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true);

	private static final DataParameter<Integer> SKIN = EntityDataManager.<Integer>createKey(EntityGaiaMinotaurus.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> HOLDING_BOW = EntityDataManager.<Boolean>createKey(EntityGaiaMinotaurus.class, DataSerializers.BOOLEAN);
	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);
	private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS);
	
	private int mobClass;
	private int spawn;
	private int spawnLevel3;
	private int spawnLevel3Chance;
	
	public EntityGaiaMinotaurus(World worldIn) {
		super(worldIn);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;

		this.mobClass = 0;
		this.spawn = 1;
		this.spawnLevel3 = 0;
		this.spawnLevel3Chance = 0;
		
		if (worldIn != null && !worldIn.isRemote) {
			this.setCombatTask();
		}
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
//		this.tasks.addTask(1, new RESERVED);
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth2);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage2);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor2);
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > EntityAttributes.baseDefense2) {
			damage = EntityAttributes.baseDefense2;
			
			if (GaiaConfig.SpawnLevel3 == true) {
				this.spawnLevel3Chance += (int) (GaiaConfig.SpawnLevel3Chance * 0.05);
			}
		}
		
		if (source instanceof EntityDamageSourceIndirect) {
			return false;
		}
		
		return super.attackEntityFrom(source, damage);
	}
	
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
	}
    
	public boolean attackEntityAsMob(Entity entity) {
		if (super.attackEntityAsMob(entity)) {
			if (this.getMobType() == 1 && entity instanceof EntityLivingBase) {
                byte byte0 = 0;

                if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                	byte0 = 10;
                } else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                	byte0 = 20;
                }

				if (byte0 > 0) {
					((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
					((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20, 0));
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
		if (this.getHealth() < EntityAttributes.maxHealth2 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1) {
			if (GaiaConfig.SpawnLevel3 == true) {
				if (spawnLevel3Chance > (int) (GaiaConfig.SpawnLevel3Chance * 0.5)) {
					this.spawnLevel3Chance = (int) (GaiaConfig.SpawnLevel3Chance * 0.5);
				}
				
				if ((this.rand.nextInt(GaiaConfig.SpawnLevel3Chance - this.spawnLevel3Chance) == 0 || this.rand.nextInt(1) > 0)) {
					this.spawnLevel3 = 1;
				}
			}
			
			this.spawn = 2;
		}
		
		if (spawnLevel3 == 1) {
	        this.worldObj.setEntityState(this, (byte)13);
			
			this.attackEntityFrom(DamageSource.generic, EntityAttributes.maxHealth2 * 0.01F);
		}

		super.onLivingUpdate();
	}
	
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
    	if (id == 13)
    		for (int i = 0; i < 1; ++i) {
                ParticleWarning particleCustom = new ParticleWarning(this.worldObj, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, 0.0D, 0.0D, 0.0D);
    			Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
    		}
        else
            super.handleStatusUpdate(id);
    }

    @SideOnly(Side.CLIENT)
    private void spawnParticles(EnumParticleTypes particleType) {
        for (int i = 0; i < 5; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(particleType, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2, new int[0]);
        }
    }
	
	public void setItemStackToSlot(EntityEquipmentSlot par1, ItemStack par2ItemStack) {
		super.setItemStackToSlot(par1, par2ItemStack);
		if (!this.worldObj.isRemote && par1.getIndex() == 0) {
			this.setCombatTask();
		}
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItemMainhand();
		if (itemstack != null && itemstack.getItem() == Items.BOW) {
			this.tasks.addTask(1, this.aiArrowAttack);
		} else {
			this.tasks.addTask(1, this.aiAttackOnCollide);
		}
	}
	
	public int getTextureType() {
		return ((Integer)this.dataManager.get(SKIN)).intValue();
	}

	public void setTextureType(int par1) {
		this.dataManager.set(SKIN, Integer.valueOf(par1));
	}

	public int getMobType() {
		return ((Integer)this.dataManager.get(SKIN)).intValue();
	}

	public void setMobType(int par1) {
		this.dataManager.set(SKIN, Integer.valueOf(par1));
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		if (par1NBTTagCompound.hasKey("MobType")) {
			byte b0 = par1NBTTagCompound.getByte("MobType");
			this.setMobType(b0);
		}

		this.setCombatTask();
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("MobType", (byte)this.getMobType());
	}
	
	//================= Archer data =================//
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		Ranged.RangedAttack(target, this, distanceFactor);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SKIN, Integer.valueOf(0));
		this.dataManager.register(HOLDING_BOW, Boolean.valueOf(false));
	}
	
	@Override
	public boolean canAttackClass(Class par1Class) {
		return super.canAttackClass(par1Class) && par1Class != EntityGaiaMinotaurus.class;
	}

	@SideOnly(Side.CLIENT)
	public boolean isHoldingBow() {
		return ((Boolean)this.dataManager.get(HOLDING_BOW)).booleanValue();
	}

	public void setHoldingBow(boolean swingingArms) {
		this.dataManager.set(HOLDING_BOW, Boolean.valueOf(swingingArms));
	}
	//===============================================//
	
	protected SoundEvent getAmbientSound() {
		return Sounds.aggressive_say;
	}

	protected SoundEvent getHurtSound() {
		return Sounds.aggressive_hurt;
	}

	protected SoundEvent getDeathSound() {
		return Sounds.aggressive_death;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int var3 = this.rand.nextInt(3 + lootingModifier);

			if (this.mobClass == 1) {
				for (int var4 = 0; var4 < var3; ++var4) {
					this.dropItem(Items.ARROW, 1);
				}
			} else {
				for (int var4 = 0; var4 < var3; ++var4) {
					this.dropItem(Items.LEATHER, 1);
				}
			}

			//Nuggets/Fragments
			int var11 = this.rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this,1);
			}

			if (GaiaConfig.AdditionalOre == true) {
				int var13 = this.rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this,5);
				}
			}

			//Very Rare
			if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1) > 0)) {
				this.dropItem(GaiaItems.SpawnHolstaurus, 1);
			}
		}

		//Boss
		if (spawnLevel3 == 1) {
			spawnLevel3();
		}
	}

	//Rare
	protected void addRandomDrop() {
		if (mobClass == 1) {
			switch(this.rand.nextInt(3)) {
			case 0:
				this.dropItem(GaiaItems.BoxGold, 1);
				break;
			case 1:
				this.dropItem(GaiaItems.BagBook, 1);
				break;
			case 2:
				this.dropItem(GaiaItems.BagArrow, 1);
			}
		} else {
			switch(this.rand.nextInt(3)) {
			case 0:
				this.dropItem(GaiaItems.BoxGold, 1);
				break;
			case 1:
				this.dropItem(GaiaItems.BagBook, 1);
				break;
			case 2:
				this.dropItem(GaiaItems.BookBattle, 1);
			}
		}
	}
	
	protected void spawnLevel3() {
		EntityGaiaMinotaur spawnLevel3;
		spawnLevel3 = new EntityGaiaMinotaur(this.worldObj);
		spawnLevel3.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		spawnLevel3.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnLevel3)), (IEntityLivingData)null);
		this.worldObj.spawnEntityInWorld(spawnLevel3);
	}
	
	@Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {}

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		if (this.worldObj.rand.nextInt(4) == 0) {
			this.tasks.addTask(1, this.aiArrowAttack);
			
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
			this.setEnchantmentBasedOnDifficulty(difficulty);
			
			if (this.worldObj.rand.nextInt(2) == 0) {
				if (this.worldObj.rand.nextInt(2) == 0) {
					this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM);
				} else {
					this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM_2);
				}
			}
			
			this.setTextureType(1);
			this.mobClass = 1;
		} else {
			this.tasks.addTask(1, this.aiAttackOnCollide);
			
	        this.setEquipmentBasedOnDifficulty(difficulty);
	        this.setEnchantmentBasedOnDifficulty(difficulty);
			this.setMobType(1);
			this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage2);
			this.setTextureType(0);
			this.mobClass = 0;
		}
		
		return livingdata;
	}
	
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		if (this.rand.nextInt(4) == 0) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        } else {
        	this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
        }
    }

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
