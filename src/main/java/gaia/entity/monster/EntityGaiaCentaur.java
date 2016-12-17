package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistDay;
import gaia.entity.ai.Archers;
import gaia.entity.ai.EntityAIGaiaArcher;
import gaia.entity.ai.IGaiaArcher;
import gaia.init.GaiaItem;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaCentaur extends EntityMobAssistDay implements IGaiaArcher {
	//private EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, 1.0D, 20, 60, 15.0F);	
	private EntityAIGaiaArcher aiArrowAttack = new EntityAIGaiaArcher(this, 1.0D, 20, 15.0F);
	private EntityAIAvoidEntity aiAvoid = new EntityAIAvoidEntity(this, EntityPlayer.class, 4.0F, 1.0D, 1.4D);
	private static final DataParameter<Boolean> HOLDING_BOW = EntityDataManager.<Boolean>createKey(EntityGaiaCentaur.class, DataSerializers.BOOLEAN);
	
	private int fullHealth;
	private int regenerateHealth;

	public EntityGaiaCentaur(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
//NULL	this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.fullHealth = 0;
		this.regenerateHealth = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth1);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage1);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor1;
	}
	/**TODO Arrow attacks may need to be completely redone **/
	public void attackEntityWithRangedAttack(EntityLivingBase target, float par2) {
		Archers.RangedAttack(target, this, par2);
	}
	
	protected void entityInit() {
		super.entityInit();
		 this.dataManager.register(HOLDING_BOW, Boolean.valueOf(false));
	}
	
	@Override
    public boolean canAttackClass(Class par1Class) {
        return super.canAttackClass(par1Class) && par1Class != EntityGaiaCentaur.class;
    }

	public boolean isAIEnabled() {
		return true;
	}
		
	public void onLivingUpdate() {
		if ((this.getHealth() < EntityAttributes.maxHealth1 * 0.25F) && (this.fullHealth == 0)) {
            //this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.POTIONITEM, 1, 16341));
            ItemStack stacky = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM,1,0), PotionTypes.REGENERATION);
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, stacky);
			this.tasks.removeTask(this.aiArrowAttack);
			this.tasks.addTask(1, this.aiAvoid);
			this.fullHealth = 1;
		}

		if ((this.getHealth() < EntityAttributes.maxHealth1) && (this.fullHealth == 1)) {
			if (this.regenerateHealth <= 100) {
				++this.regenerateHealth;
			} else {
				this.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 0.15F, 1.0F);
				this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 360, 3));
				this.regenerateHealth = 0;
			}
		} else if ((this.getHealth() >= EntityAttributes.maxHealth1) && (this.fullHealth == 1)) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
			this.removePotionEffect(MobEffects.REGENERATION);
			this.tasks.removeTask(this.aiAvoid);
			this.tasks.addTask(1, this.aiArrowAttack);
			this.fullHealth = 0;
			this.regenerateHealth = 0;
		}

		super.onLivingUpdate();
	}
	
	 @SideOnly(Side.CLIENT)
	public boolean isHoldingBow(){
		 return ((Boolean)this.dataManager.get(HOLDING_BOW)).booleanValue();}

	public void setHoldingBow(boolean swingingArms){
		this.dataManager.set(HOLDING_BOW, Boolean.valueOf(swingingArms));}


	protected SoundEvent getAmbientSound(){
		return Sounds.assist_say;
	}

	protected SoundEvent getHurtSound(){
		return Sounds.assist_hurt;
	}

	protected SoundEvent getDeathSound(){
		return Sounds.assist_death;
	}
	/**
	protected void playStepSound(BlockPos pos, Block blockIn){	
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}
	**/
	protected void playStepSound(BlockPos pos, Block blockIn){		
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }
	
	protected void dropFewItems(boolean par1, int par2) {		
		if (par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(Items.LEATHER, 1);
		}
		
		//Shards
		int var11 = this.rand.nextInt(3) + 1;

		for (int var12 = 0; var12 < var11; ++var12) {
            //ItemShard.Drop_Nugget(this,0);
            ItemShard.Drop_Nugget(this,0);
		}
	}

	protected void addRandomDrop() {
		switch(this.rand.nextInt(2)) {
		case 0:
			this.dropItem(GaiaItem.BoxIron, 1);
			break;
		case 1:
			this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}
	
	@Override
    protected void dropEquipment(boolean p_82160_1_, int p_82160_2_) {}
	
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
		this.setEnchantmentBasedOnDifficulty(difficulty);
		return livingdata;		
    }
	
	public void setItemStackToSlot(EntityEquipmentSlot par1, ItemStack par2ItemStack) {
		super.setItemStackToSlot(par1, par2ItemStack);
		if (!this.worldObj.isRemote && par1.getIndex() == 0) {
			this.setCombatTask();
		}
	}
	
	public void setCombatTask() {
		this.tasks.removeTask(this.aiAvoid);
		this.tasks.addTask(1, this.aiArrowAttack);
	}
	
	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
		super.knockBack(par1Entity, par2, par3, par5, EntityAttributes.knockbackbase);
	}
	
	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
