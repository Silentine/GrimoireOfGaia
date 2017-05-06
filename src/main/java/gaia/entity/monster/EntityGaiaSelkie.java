package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.entity.ai.EntityAIGaiaAttackRangedBow;
import gaia.entity.ai.GaiaIRangedAttackMob;
import gaia.entity.ai.Ranged;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;

import java.util.List;

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
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaSelkie extends EntityMobHostileDay implements GaiaIRangedAttackMob {
	
	private EntityAIGaiaAttackRangedBow aiArrowAttack = new EntityAIGaiaAttackRangedBow(this, EntityAttributes.attackSpeed1, 20, 15.0F);
	private EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, EntityAttributes.attackSpeed1, true);

	private static final DataParameter<Boolean> HOLDING_BOW = EntityDataManager.<Boolean>createKey(EntityGaiaSelkie.class, DataSerializers.BOOLEAN);
	private static final ItemStack TIPPED_ARROW_CUSTOM = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS);
	private static final ItemStack TIPPED_ARROW_CUSTOM_2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS);

	private int timer;
	private int switchDetect;
	private int switchEquip;
	
	public EntityGaiaSelkie(World worldIn) {
		super(worldIn);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.fireResistance = 10;
		
		this.timer = 0;
		this.switchDetect = 0;
		this.switchEquip = 0;
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
					((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 30, 1));
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
		if (playerDetection(3)) {
			if (this.switchDetect == 0)
				this.switchDetect = 1;
		} else {
			if (this.switchDetect == 1)
				this.switchDetect = 0;
		}

		if (this.switchDetect == 1 && this.switchEquip == 0) {
			if (timer <= 20) {
				++timer;
			} else {
				if (!this.isPotionActive(MobEffects.SPEED))
					this.addPotionEffect(new PotionEffect(MobEffects.SPEED, 10 * 20, 0));
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.PropWeapon, 1, 3));
				this.tasks.removeTask(this.aiArrowAttack);
				this.tasks.addTask(1, this.aiAttackOnCollide);
				this.timer = 0;
				this.switchEquip = 1;
			}
		}

		if (this.switchDetect == 0 && this.switchEquip == 1) {
			if (timer <= 20) {
				++timer;
			} else {
				if (this.isPotionActive(MobEffects.SPEED))
					this.removePotionEffect(MobEffects.SPEED);
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
				this.tasks.removeTask(this.aiAttackOnCollide);
				this.tasks.addTask(1, this.aiArrowAttack);
				this.timer = 0;
				this.switchEquip = 0;
			}
		}
		
		//Detects biome and inflicts buff/debuff
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

	//================= Archer data =================//
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		Ranged.RangedAttack(target, this, distanceFactor);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(HOLDING_BOW, Boolean.valueOf(false));
	}

	@Override
    public boolean canAttackClass(Class par1Class) {
        return super.canAttackClass(par1Class) && par1Class != EntityGaiaSelkie.class;
    }

	@SideOnly(Side.CLIENT)
	public boolean isHoldingBow() {
		return ((Boolean)this.dataManager.get(HOLDING_BOW)).booleanValue();
	}

	public void setHoldingBow(boolean swingingArms) {
		this.dataManager.set(HOLDING_BOW, Boolean.valueOf(swingingArms));
	}
	//==================================//

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
			if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
				this.dropItem(GaiaItems.MiscFur, 1);
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
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(GaiaItems.BoxIron, 1);
			break;
		case 1:
			this.dropItem(GaiaItems.BagArrow, 1);
		}
	}
	
	@Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {}

	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.addTask(1, this.aiArrowAttack);
		
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
		this.setEnchantmentBasedOnDifficulty(difficulty);
		
		ItemStack BOOTS_SWIMMING = new ItemStack(Items.LEATHER_BOOTS);
		this.setItemStackToSlot(EntityEquipmentSlot.FEET, BOOTS_SWIMMING);
		BOOTS_SWIMMING.addEnchantment(Enchantment.getEnchantmentByLocation("depth_strider"), 2);
		
		if (this.worldObj.rand.nextInt(2) == 0) {
			if (this.worldObj.rand.nextInt(2) == 0) {
				this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM);
			} else {
				this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, TIPPED_ARROW_CUSTOM_2);
			}
		}

		return livingdata;		
	}
	
	//================= Immunities =================//
    public boolean isPushedByWater() {
        return false;
    }
	//==================================//

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
