package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.EntityAIGaiaLeapAtTarget;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaArachne extends EntityMobHostileBase {
	
	private static final Item[] ArachneDrops = new Item[] { 
		Items.SUGAR, 
		Items.FERMENTED_SPIDER_EYE, 
		Items.GLASS_BOTTLE,
		Items.GUNPOWDER,
		Items.STICK,
		Items.STICK
		};

	private int spawn;

	public EntityGaiaArachne(World par1World) {
		super(par1World);
		this.setSize(1.4F, 1.6F);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaLeapAtTarget(this, 0.4F));
		this.tasks.addTask(2, new EntityGaiaArachne.AILeapAttack(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		
		this.spawn = 0;
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
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 60, 0));
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, byte0 * 20, 0));
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
		this.beaconMonster(MobEffects.RESISTANCE, 300, 1, 6);
		
		EntityCaveSpider spawnMob;
		if (this.getHealth() < EntityAttributes.maxHealth1 * 0.75F && this.getHealth() > 0.0F && this.spawn == 0) {
			if (this.worldObj.isRemote)handleStatusUpdate((byte)12);
			
			if (!this.worldObj.isRemote) {
				spawnMob = new EntityCaveSpider(this.worldObj);
				spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), null);
				this.worldObj.spawnEntityInWorld(spawnMob);
			}
			this.spawn = 1;
		}

		if (this.getHealth() < EntityAttributes.maxHealth1 * 0.25F && this.getHealth() > 0.0F && this.spawn == 1) {
			if (this.worldObj.isRemote)handleStatusUpdate((byte)12);
			
			if (!this.worldObj.isRemote) {
				spawnMob = new EntityCaveSpider(this.worldObj);
				spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), null);
				this.worldObj.spawnEntityInWorld(spawnMob);
			}
			this.spawn = 2;
		}
		
		if (!this.worldObj.isRemote) {
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
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
	//==================================//

    /*
     Legacy code
	 Projectile deal double damage

	 public boolean attackEntityFrom(DamageSource ds, float amount) {
	 return super.attackEntityFrom(ds, amount * (float)(ds.isProjectile()?2:1));
	 }
     */

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
		this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3) + 1;

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = this.rand.nextInt(3);
			Item var6 = ArachneDrops[this.rand.nextInt(ArachneDrops.length)];
			if (par2 > 0) {
				var5 += this.rand.nextInt(par2 + 1);
			}

			for (int var7 = 0; var7 < var5; ++var7) {
				this.dropItem(var6, 1);
			}
		}

		if (par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItems.MiscFurnaceFuel, 1);
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
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(GaiaItems.BagOre, 1);
			break;
		case 1:
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
	
	static class AILeapAttack extends EntityAIAttackMelee {
		public AILeapAttack(EntityGaiaArachne entity) {
			super(entity, EntityAttributes.attackSpeed1, true);
		}

		protected double getAttackReachSqr(EntityLivingBase attackTarget) {
			return (double)(4.0F + attackTarget.width);
		}
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON ? false:super.isPotionApplicable(potioneffectIn);
	}

	public void setInWeb() {}

	public boolean getCanSpawnHere() {
		return this.posY < 32.0D && super.getCanSpawnHere();
	}
}
