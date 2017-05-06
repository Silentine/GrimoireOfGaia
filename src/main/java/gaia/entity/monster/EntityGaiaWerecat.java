package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.EntityAIGaiaLeapAtTarget;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
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
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaWerecat extends EntityMobHostileBase {

	private EntityAIGaiaLeapAtTarget aiGaiaLeapAtTarget = new EntityAIGaiaLeapAtTarget(this, 0.4F);
	private EntityAIAttackMelee aiMeleeAttack = new EntityGaiaWerecat.AILeapAttack(this);
	private EntityAIAvoidEntity aiAvoid = new EntityAIAvoidEntity(this, EntityPlayer.class, 20.0F, EntityAttributes.attackSpeed1, EntityAttributes.attackSpeed3);
	
	private int switchHealth;
	
	public EntityGaiaWerecat(World worldIn) {
		super(worldIn);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;

		this.switchHealth = 0;
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
//		this.tasks.addTask(1, new RESERVED);
//		this.tasks.addTask(2, new RESERVED);
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
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
		if ((this.getHealth() < EntityAttributes.maxHealth1 * 0.25F) && (this.switchHealth == 0)) {
			if (this.rand.nextInt(4) == 0) {
				this.tasks.removeTask(this.aiGaiaLeapAtTarget);
				this.tasks.removeTask(this.aiMeleeAttack);
				this.tasks.addTask(2, this.aiAvoid);
				this.switchHealth = 1;
			} else {
				this.switchHealth = 1;
			}
		}
		
		if (this.switchHealth == 1) {
			if (this.ticksExisted % 10 == 0) {
				this.worldObj.setEntityState(this, (byte)8);
			}
		}
		
		if ((this.getHealth() > EntityAttributes.maxHealth1 * 0.25F) && (this.switchHealth == 1)) {
			this.tasks.addTask(1, this.aiGaiaLeapAtTarget);
			this.tasks.addTask(2, this.aiMeleeAttack);
			this.tasks.removeTask(this.aiAvoid);
			this.switchHealth = 0;
		}

		super.onLivingUpdate();
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
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
				this.dropItem(GaiaItems.FoodMeat, 1);
			}

			//Nuggets/Fragments
			int var11 = this.rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this, 0);
			}

			if (GaiaConfig.AdditionalOre == true) {
				int var13 = this.rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this, 4);
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
		this.tasks.addTask(1, this.aiGaiaLeapAtTarget);
		this.tasks.addTask(2, this.aiMeleeAttack);
		
		if (this.worldObj.rand.nextInt(4) == 0) {
			this.setTextureType(1);
		}
		
		ItemStack WEAPON_CUSTOM = new ItemStack(GaiaItems.PropWeaponEnchanted, 1);
		WEAPON_CUSTOM.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 1);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, WEAPON_CUSTOM);
		return livingdata;		
    }
	
	static class AILeapAttack extends EntityAIAttackMelee {
		public AILeapAttack(EntityGaiaWerecat entity) {
			super(entity, EntityAttributes.attackSpeed1, true);
		}

		protected double getAttackReachSqr(EntityLivingBase attackTarget) {
			return (double)(4.0F + attackTarget.width);
		}
	}

	private static final DataParameter<Integer> SKIN = EntityDataManager.<Integer>createKey(EntityGaiaWerecat.class, DataSerializers.VARINT);
			
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SKIN, Integer.valueOf(0));
	}

	public int getTextureType() {
		return ((Integer)this.dataManager.get(SKIN)).intValue();
	}

	public void setTextureType(int par1) {
		this.dataManager.set(SKIN, Integer.valueOf(par1));
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		if (par1NBTTagCompound.hasKey("MobType")) {
			byte b0 = par1NBTTagCompound.getByte("MobType");
			this.setTextureType(b0);
		}
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("MobType", (byte)this.getTextureType());
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
