package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import gaia.util.BlockStateHelper;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaMatango extends EntityMobHostileDay {
	
	private static final Item[] matangoDrops = new Item[] { 
		Item.getItemFromBlock(Blocks.RED_MUSHROOM), 
		Item.getItemFromBlock(Blocks.BROWN_MUSHROOM) 
	};

	private int spawnTime;

	public EntityGaiaMatango(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed1, true));
		this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(1, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		
		this.spawnTime = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth1);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage1);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor1);
        
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > EntityAttributes.baseDefense1) {
			damage = EntityAttributes.baseDefense1;
		}
		
		float input = damage;
		Entity entity = source.getEntity();
		
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());
			if (itemstack != null) {
				
				if (itemstack.getItem() instanceof ItemAxe) {
					damage = input*1.5F;
				}
			}
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
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 60, 3));
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
		this.beaconMonster(MobEffects.SPEED, 300, 1, 2);
		
		if (this.isInWater()) {
			this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 0));
		}
		
		if (this.isWet()) {
			this.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 10 * 20, 0));
		}
		
		if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
			int var1 = MathHelper.floor_double(this.posX);
			int var2 = MathHelper.floor_double(this.posY - 0.20000000298023224D);// - (double)this.yOffset);
			int var3 = MathHelper.floor_double(this.posZ);
			World world = this.worldObj;
			BlockPos pos = new BlockPos(var1, var2, var3);
			int crackid = BlockStateHelper.getblock_ID(world, pos);
			int crackmeta = BlockStateHelper.getMetafromState(world, pos);
			
			Block b = BlockStateHelper.getBlockfromState(this.worldObj, pos);
			if (b != Blocks.AIR) {
				this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK,
						this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.getEntityBoundingBox().minY + 0.1D,
						this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D,
						((double)this.rand.nextFloat() - 0.5D) * 4.0D, crackid,crackmeta);
			}
		}

		EntityGaiaSummonSporeling spawnMob;
		if (this.getHealth() < EntityAttributes.maxHealth1 * 0.90F && this.getHealth() > EntityAttributes.maxHealth1 * 0.10F) {
			if ((this.spawnTime > 0) && (this.spawnTime <= 140)) {
				++this.spawnTime;
			} else {
				if (this.worldObj.isRemote) handleStatusUpdate((byte)12);
				if (!this.worldObj.isRemote) {
					spawnMob = new EntityGaiaSummonSporeling(this.worldObj);
					spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
					spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
					this.worldObj.spawnEntityInWorld(spawnMob);
				}

				if (this.worldObj.isRemote) handleStatusUpdate((byte)9);
				this.heal(EntityAttributes.maxHealth1 * 0.20F);

				this.spawnTime = 1;
			}
		}
		
		if (this.isBurning()) {
			this.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
			this.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
		}

		super.onLivingUpdate();
	}

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
    	if (id == 12)
    		this.spawnParticles(EnumParticleTypes.EXPLOSION_NORMAL);
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

    public void beaconMonster(Potion effect, int duration, int power, int range) {
    	if (!this.worldObj.isRemote ) {
    		double d0 = (double)(range);            

    		int k = (int) this.posX;
    		int l = (int) this.posY;
    		int i1 = (int) this.posZ;

    		AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).expandXyz(d0).addCoord(0.0D, 0.0D, 0.0D);
    		List<EntityLivingBase> moblist = this.worldObj.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

    		for (EntityLivingBase mob : moblist) {
    			if(!(mob instanceof EntityGaiaMatango)) {
    				if (mob instanceof EntityGaiaSummonSporeling)
    					mob.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
    			}
    		}
    	}
    }

	protected SoundEvent getAmbientSound() {
		return Sounds.aggressive_say;
	}

	protected SoundEvent getHurtSound() {
		return Sounds.aggressive_hurt;
	}

	protected SoundEvent getDeathSound() {
		return Sounds.aggressive_death;
	}

	protected void dropFewItems(boolean par1, int par2) {
		for (int var4 = 0; var4 < 1; ++var4) {
			Item var6 = matangoDrops[this.rand.nextInt(matangoDrops.length)];

			for (int var7 = 0; var7 < 1; ++var7) {
				this.dropItem(var6, 1);
			}
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
		ItemStack WEAPON_CUSTOM = new ItemStack(GaiaItems.PropWeaponEnchanted, 1);
		WEAPON_CUSTOM.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 1);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, WEAPON_CUSTOM);
		return livingdata;		
	}

	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON ? false:super.isPotionApplicable(potioneffectIn);
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
