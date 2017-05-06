package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** 
 * @see EntityWitch
 */
public class EntityGaiaWitch extends EntityMobHostileBase implements IRangedAttackMob {

	private int spawn;
	
	private static final UUID MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
	private static final AttributeModifier MODIFIER = (new AttributeModifier(MODIFIER_UUID, "Drinking speed penalty", -0.25D, 0)).setSaved(false);
	private static final DataParameter<Boolean> IS_AGGRESSIVE = EntityDataManager.<Boolean>createKey(EntityWitch.class, DataSerializers.BOOLEAN);

	private int witchAttackTimer;

	public EntityGaiaWitch(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;

		this.spawn = 0;
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackRanged(this, EntityAttributes.attackSpeed2, 60, 10.0F));
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
		}
		
		return super.attackEntityFrom(source, damage);
	}
	
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
	}

	public void setAggressive(boolean aggressive) {
		this.getDataManager().set(IS_AGGRESSIVE, Boolean.valueOf(aggressive));
    }

    public boolean isDrinkingPotion() {
        return ((Boolean)this.getDataManager().get(IS_AGGRESSIVE)).booleanValue();
    }
	
	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		this.beaconMonster(MobEffects.RESISTANCE, 300, 1, 6);
		
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.8D;
		}

		if (this.motionX > 0 ||
				this.motionY > 0 ||
				this.motionZ > 0) {
			for (int var5 = 0; var5 < 2; ++var5) {
				this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		}

		EntitySpider spawnMob;
		if (this.getHealth() < EntityAttributes.maxHealth2 * 0.75F && this.getHealth() > 0.0F && this.spawn == 0) {
	        this.worldObj.setEntityState(this, (byte)12);
			
			if (!this.worldObj.isRemote) {
				spawnMob = new EntitySpider(this.worldObj);
				spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
				this.worldObj.spawnEntityInWorld(spawnMob);
			}
			this.spawn = 1;
		}

		if (this.getHealth() < EntityAttributes.maxHealth2 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1) {
	        this.worldObj.setEntityState(this, (byte)12);
			
			if (!this.worldObj.isRemote) {
				spawnMob = new EntitySpider(this.worldObj);
				spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
				this.worldObj.spawnEntityInWorld(spawnMob);
			}
			this.spawn = 2;
		}

        if (!this.worldObj.isRemote) {
            if (this.isDrinkingPotion()) {
                if (this.witchAttackTimer-- <= 0) {
                    this.setAggressive(false);
                    ItemStack itemstack = this.getHeldItemMainhand();
                    this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, (ItemStack)null);

                    if (itemstack != null && itemstack.getItem() == Items.POTIONITEM) {
                        List<PotionEffect> list = PotionUtils.getEffectsFromStack(itemstack);

                        if (list != null) {
                            for (PotionEffect potioneffect : list) {
                                this.addPotionEffect(new PotionEffect(potioneffect));
                            }
                        }
                    }

                    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(MODIFIER);
                }
            } else {
            	this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 0));
                PotionType potiontype = null;

                if (this.rand.nextFloat() < 0.15F && this.isInsideOfMaterial(Material.WATER) && !this.isPotionActive(MobEffects.WATER_BREATHING)) {
                    potiontype = PotionTypes.WATER_BREATHING;
                } else if (this.rand.nextFloat() < 0.15F && (this.isBurning() || this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage()) && !this.isPotionActive(MobEffects.FIRE_RESISTANCE)) {
                    potiontype = PotionTypes.FIRE_RESISTANCE;
                } else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
                    potiontype = PotionTypes.HEALING;
                } else if (this.rand.nextFloat() < 0.5F && this.getAttackTarget() != null && !this.isPotionActive(MobEffects.SPEED) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D) {
                    potiontype = PotionTypes.SWIFTNESS;
                }

                if (potiontype != null) {
                    this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), potiontype));
                    this.witchAttackTimer = this.getHeldItemMainhand().getMaxItemUseDuration();
                    this.setAggressive(true);
                    this.worldObj.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_WITCH_DRINK, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
                    IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
                    iattributeinstance.removeModifier(MODIFIER);
                    iattributeinstance.applyModifier(MODIFIER);
                }
            }

            if (this.rand.nextFloat() < 7.5E-4F) {
                this.worldObj.setEntityState(this, (byte)15);
            }
        }

        super.onLivingUpdate();
    }

	protected void entityInit() {
		super.entityInit();
		this.getDataManager().register(IS_AGGRESSIVE, Boolean.valueOf(false));
	}

	@SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 12)
            this.spawnParticles(EnumParticleTypes.EXPLOSION_NORMAL);
        else if (id == 15) {
            for (int i = 0; i < this.rand.nextInt(35) + 10; ++i) {
                this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX + this.rand.nextGaussian() * 0.12999999523162842D, this.getEntityBoundingBox().maxY + 0.5D + this.rand.nextGaussian() * 0.12999999523162842D, this.posZ + this.rand.nextGaussian() * 0.12999999523162842D, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        } else {
            super.handleStatusUpdate(id);
        }
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

    /**
     * Reduces damage, depending on potions
     */
    protected float applyPotionDamageCalculations(DamageSource source, float damage) {
        damage = super.applyPotionDamageCalculations(source, damage);

        if (source.getEntity() == this) {
            damage = 0.0F;
        }

        if (source.isMagicDamage()) {
            damage = (float)((double)damage * 0.15D);
        }

        return damage;
    }

	public float getAIMoveSpeed() {
		float speed = super.getAIMoveSpeed();
		if (this.isDrinkingPotion()) {
			speed *= 0.75F;
		}

		return speed;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase target, float p_82196_2_) {
        if (!this.isDrinkingPotion()) {
            double d0 = target.posY + (double)target.getEyeHeight() - 1.100000023841858D;
            double d1 = target.posX + target.motionX - this.posX;
            double d2 = d0 - this.posY;
            double d3 = target.posZ + target.motionZ - this.posZ;
            float f = MathHelper.sqrt_double(d1 * d1 + d3 * d3);
            PotionType potiontype = PotionTypes.HARMING;

            if (f >= 8.0F && !target.isPotionActive(MobEffects.SLOWNESS)) {
                potiontype = PotionTypes.SLOWNESS;
            } else if (target.getHealth() >= 8.0F && !target.isPotionActive(MobEffects.POISON)) {
                potiontype = PotionTypes.POISON;
            } else if (f <= 3.0F && !target.isPotionActive(MobEffects.WEAKNESS) && this.rand.nextFloat() < 0.25F) {
                potiontype = PotionTypes.WEAKNESS;
            }

            EntityPotion entitypotion = new EntityPotion(this.worldObj, this, PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potiontype));
            entitypotion.rotationPitch -= -20.0F;
            entitypotion.setThrowableHeading(d1, d2 + (double)(f * 0.2F), d3, 0.75F, 8.0F);
            this.worldObj.playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_WITCH_THROW, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
            this.worldObj.spawnEntityInWorld(entitypotion);
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
				if (!(mob instanceof EntityGaiaArachne)) {
					if (mob instanceof EntitySpider)
						mob.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
					else if (mob instanceof EntityCaveSpider)
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

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(Sounds.none, 1.0F, 1.0F);
	}
	
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		super.dropLoot(wasRecentlyHit, lootingModifier, source);
		this.dropFewItems(wasRecentlyHit, lootingModifier);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_WITCH;
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int var3 = this.rand.nextInt(3 + lootingModifier);

			for (int var4 = 0; var4 < var3; ++var4) {
				this.dropItem(GaiaItems.FoodNetherWart, 1);
			}

			//Nuggets/Fragments
			int var11 = this.rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this, 1);
			}

			if (GaiaConfig.AdditionalOre == true) {
				int var13 = this.rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this, 5);
				}
			}
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
			this.dropItem(GaiaItems.MiscBook, 1);
		}
	}

	@Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {}

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 0));
		
		return livingdata;		
    }
	
	//================= Immunities =================//
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potioneffectIn);
	}

	public void fall(float distance, float damageMultiplier) {}
	//==============================================//

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
