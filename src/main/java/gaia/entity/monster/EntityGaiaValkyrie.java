package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveDay;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import gaia.renderer.particle.ParticleWarning;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaValkyrie extends EntityMobPassiveDay {
	
	private EntityAINearestAttackableTarget aiNearestAttackableTarget = new EntityAINearestAttackableTarget(this, EntityPlayer.class, true);
	
	private int equipItems;
	private int buffEffect;
	private int aggression;
	private int aggressive;

	public EntityGaiaValkyrie(World worldIn) {
		super(worldIn);
		this.setSize(1.0F, 2.0F);
		this.experienceValue = EntityAttributes.experienceValue3;
		this.stepHeight = 1.0F;
		this.isImmuneToFire = true;

		this.equipItems = 0;
		this.buffEffect = 0;
		this.aggression = 0;
		this.aggressive = 0;
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed3, true));
		this.tasks.addTask(2, new EntityAIWander(this, 0.8D));
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

		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D);
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
                byte byte1 = 0;

                if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL) {
                	byte0 = 20;
                	byte1 = 10;
                } else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
                	byte0 = 30;
                	byte1 = 20;
                }

				if (byte0 > 0) {
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, byte1 * 20, 0));
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
		
        ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
		
		if ((this.equipItems == 0) && (itemstack == null)) {
			if (this.aggressive <= 5) {
				if (this.playerDetection(6)) {
					if (this.aggression <= 60) {
						this.aggression += 1;
					} else {
						this.aggression = 0;
						this.aggressive += 1;
					}

					if (this.aggression >= 50) {
						this.worldObj.setEntityState(this, (byte)13);
					}
				}
			} else {
				this.targetTasks.addTask(2, this.aiNearestAttackableTarget);

				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 2));
				ItemStack SHIELD = new ItemStack(GaiaItems.PropShield, 1, 0);
				this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, SHIELD);

				this.equipItems = 1;
			}
		}

		if (this.getHealth() < EntityAttributes.maxHealth3 * 1.00F && this.equipItems == 0) {
			this.targetTasks.addTask(2, this.aiNearestAttackableTarget);
			
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 2));
			ItemStack SHIELD = new ItemStack(GaiaItems.PropShield, 1, 0);
			this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, SHIELD);
			
			this.equipItems = 1;
		}
		
		if (this.getHealth() > EntityAttributes.maxHealth3 * 0.25F && this.buffEffect == 1) {
			this.buffEffect = 0;
		} else if (this.getHealth() <= EntityAttributes.maxHealth3 * 0.25F && this.getHealth() > 0.0F && this.buffEffect == 0) {
	        this.worldObj.setEntityState(this, (byte)10);
			
			this.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20 * 60, 0));
			this.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 * 60, 0));
			
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
	
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
    	if (id == 13)
    		for (int i = 0; i < 1; ++i) {
    			ParticleWarning particleCustom = new ParticleWarning(this.worldObj, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, 0.0D, 0.0D, 0.0D);
    			Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);			
    		}
    	else
    		super.handleStatusUpdate(id);
    }
    
	/** 
	 * Detects if there are any EntityPlayer nearby
	 */
	public boolean playerDetection(int range) {	
		double d0 = (double)(range);          

		int k = (int) this.posX;
		int l = (int) this.posY;
		int i1 = (int) this.posZ;
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).expandXyz(d0);
		List<EntityPlayer> list = this.worldObj.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		if (!list.isEmpty()) return true;            

		return false;
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
		return Sounds.aggressive_say;
	}

	protected SoundEvent getHurtSound() {
		return Sounds.aggressive_hurt;
	}

	protected SoundEvent getDeathSound() {
		return Sounds.aggressive_death;
	}
	
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
				this.dropItem(GaiaItems.FoodSmallAppleGold, 1);
			}

			//Nuggets/Fragments
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
    				this.dropItem(Item.getItemFromBlock(GaiaBlocks.BustValkyrie), 1);
    				break;
    			case 2:
    	            this.entityDropItem(new ItemStack(GaiaItems.MiscRing, 1, 0), 0.0F);
    			}
    		}
		}
	}

	@Override
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {}

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);

		ItemStack BOOTS_SWIMMING = new ItemStack(Items.LEATHER_BOOTS);
		this.setItemStackToSlot(EntityEquipmentSlot.FEET, BOOTS_SWIMMING);
		BOOTS_SWIMMING.addEnchantment(Enchantment.getEnchantmentByLocation("depth_strider"), 2);
		
		return livingdata;		
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
		return this.posY > 80.0D && super.getCanSpawnHere();
	}
}
