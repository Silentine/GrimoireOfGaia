package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import gaia.renderer.particle.ParticleWarning;
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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaDhampir extends EntityMobHostileBase {

	private int spawn;
	private int spawnLevel3;
	private int spawnLevel3Chance;

	public EntityGaiaDhampir(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

		this.spawn = 1;
		this.spawnLevel3 = 0;
		this.spawnLevel3Chance = 0;
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
		
		return super.attackEntityFrom(source, damage);
	}
	
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
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
			if (this.worldObj.isRemote)handleStatusUpdate((byte)13);
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
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(GaiaItems.MiscSoulFire, 1);
		}

		//Nuggets/Fragments
		int var11 = this.rand.nextInt(3) + 1;

		for(int var12 = 0; var12 < var11; ++var12) {
            ItemShard.Drop_Nugget(this,1);
		}
		
		if (GaiaConfig.AdditionalOre == true) {
			int var13 = this.rand.nextInt(3) + 1;

			for (int var14 = 0; var14 < var13; ++var14) {
				ItemShard.Drop_Nugget(this,5);
			}
		}
		
		//Boss
		if (spawnLevel3 == 1) {
			spawnLevel3();
		}
	}

	//Rare
	protected void addRandomDrop() {
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(GaiaItems.BoxGold, 1);
			break;
		case 1:
			this.dropItem(GaiaItems.BagBook, 1);
			break;
		case 2:
			this.dropItem(Item.getItemFromBlock(GaiaBlocks.DollMaid), 1);
		}
	}
	
	protected void spawnLevel3() {
		EntityGaiaVampire spawnLevel3;
		spawnLevel3 = new EntityGaiaVampire(this.worldObj);
		spawnLevel3.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		spawnLevel3.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnLevel3)), (IEntityLivingData)null);
		this.worldObj.spawnEntityInWorld(spawnLevel3);
	}
	
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));	
		this.setEnchantmentBasedOnDifficulty(difficulty);
		return livingdata;		
    }

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
