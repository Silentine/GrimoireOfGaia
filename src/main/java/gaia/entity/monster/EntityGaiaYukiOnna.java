package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveDay;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaYukiOnna extends EntityMobPassiveDay {
	
	private EntityAIAttackMelee aiMeleeAttack = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true);
	private EntityAIAvoidEntity aiAvoid = new EntityAIAvoidEntity(this, EntityPlayer.class, 20.0F, EntityAttributes.attackSpeed2, EntityAttributes.attackSpeed3);
	
	private int switchHealth;

	public EntityGaiaYukiOnna(World worldIn) {
		super(worldIn);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.fireResistance = 20;

		this.switchHealth = 0;
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
//		this.tasks.addTask(1, new RESERVED);
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
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
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 3));
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
		if ((this.getHealth() < EntityAttributes.maxHealth2 * 0.25F) && (this.switchHealth == 0)) {
			if (this.rand.nextInt(1) == 0) {
				this.tasks.removeTask(this.aiMeleeAttack);
				this.tasks.addTask(1, this.aiAvoid);
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
		
		if ((this.getHealth() > EntityAttributes.maxHealth2 * 0.25F) && (this.switchHealth == 1)) {
			this.tasks.addTask(1, this.aiMeleeAttack);
			this.tasks.removeTask(this.aiAvoid);
			this.switchHealth = 0;
		}
		
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posZ);
		int k = MathHelper.floor_double(this.posY);
		BlockPos pos = new BlockPos(i,j,k);	
		if (this.worldObj.getBiome(new BlockPos(i,j,k)).getFloatTemperature(pos) > 1.0F) {
			this.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
			this.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
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
		this.playSound(Sounds.none, 1.0F, 1.0F);
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int var3 = this.rand.nextInt(3 + lootingModifier);

			for (int var4 = 0; var4 < var3; ++var4) {
				this.dropItem(GaiaItems.MiscFur, 1);
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
    		ItemStack FanIce = new ItemStack(GaiaItems.FanIce);
    		FanIce.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 4);
    		this.entityDropItem(FanIce, 1);	
		}
	}
	
	@Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {}
	
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		this.tasks.addTask(1, this.aiMeleeAttack);

		if (this.rand.nextInt(4) == 0) {
			ItemStack WEAPON_CUSTOM = new ItemStack(GaiaItems.PropWeapon, 1, 4);
			WEAPON_CUSTOM.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 3);
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, WEAPON_CUSTOM);
		} else {
			ItemStack WEAPON_CUSTOM = new ItemStack(GaiaItems.PropWeaponEnchanted, 1);
			WEAPON_CUSTOM.addEnchantment(Enchantment.getEnchantmentByLocation("knockback"), 2);
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, WEAPON_CUSTOM);
		}

		return livingdata;	
    }

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	//================= Immunities =================//
	public void fall(float distance, float damageMultiplier) {}

	public void setInWeb() {}
	//==============================================//

	private boolean isSnowing() {
		return this.worldObj.isRaining();
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && this.isSnowing() && super.getCanSpawnHere();
	}
}
