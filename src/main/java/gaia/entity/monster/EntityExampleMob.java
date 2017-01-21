package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobDay;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaItem;
import gaia.renderer.particle.ExampleParticle;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityExampleMob extends EntityMobDay{
	
	public EntityExampleMob(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.timer = 20; //timer 
	}
		
	
	//==================== Example Implementations ===================//
	
	/** Aura and lingering effects **/
	public void onLivingUpdate() {
		super.onLivingUpdate();
						
		//Example of a positive aura effect for players
		this.beaconEffect(MobEffects.LUCK, 100, 1, 2);
		
		//Example of a hostile aura buffing monsters
		this.Monster_Aura(MobEffects.STRENGTH, 200, 2, 16);
		
		//Example of monster creating lingering effects		
		if (this.clock()) this.lingeringEffect(this, MobEffects.JUMP_BOOST, PotionTypes.LEAPING, 50, 0, this.getPosition());
	
		//Example of generating a custom particle
		if(this.worldObj.isRemote && rand.nextInt(200) == 0){
			BlockPos pos = this.getPosition();
			ExampleParticle newEffect = new ExampleParticle(this.worldObj, pos.getX()+0.5, pos.getY()+2.2, pos.getZ()+0.5, 0, 0.001, 0);
			Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
	      }
		
		//Player detection
		if(Player_Detection(8)){this.setCustomNameTag("I found you");}
		else{this.setCustomNameTag("I didn't notice");}		
		
		/**Climber activation **/
		if (!this.worldObj.isRemote)
        {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
		
	}
	
	protected void dropFewItems(boolean flag, int par) {
		
		ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
		//Ids found at @Enchantment.registerEnchantments();
		//Special method that gives books a unique nbt they need
		Items.ENCHANTED_BOOK.addEnchantment(book, new EnchantmentData(Enchantment.getEnchantmentByID(35), 2));
		Items.ENCHANTED_BOOK.addEnchantment(book, new EnchantmentData(Enchantment.getEnchantmentByID(70), 1));		
		book.setStackDisplayName("Mysterious Tome");
		
		this.entityDropItem(book, 2);
		
		ItemStack shirt = new ItemStack(Items.LEATHER_CHESTPLATE);
		//Stack version is usable for other things
		shirt.addEnchantment(Enchantment.getEnchantmentByID(0), 2);
		ItemArmor itemarmor = (ItemArmor)shirt.getItem();
		itemarmor.setColor(shirt, 5681460);
		shirt.setStackDisplayName("Dusty Shirt");
		
		this.entityDropItem(shirt, 1);		
	}
	
	//=================== Example Methods ============================//
	
	/** Adapted from @EntityPotion.class
	 * 
	 * @param SourceMob The mob creating the cloud
	 * @param effect Potion Effect to Implement (@MobEffects.class)
	 * @param type Type of potion (I think for rendering)(@PotionTypes.class)
	 * @param duration Duration of potion effect in ticks
	 * @param power Level of the potion 
	 * @param pos Position to spawn effect**/
	public void lingeringEffect(EntityLivingBase SoureMob, Potion effect, PotionType type, int duration, int power, BlockPos pos){
		
        EntityAreaEffectCloud entityareaeffectcloud = new EntityAreaEffectCloud(SoureMob.worldObj, pos.getX(), pos.getY(), pos.getZ());
        entityareaeffectcloud.setOwner(SoureMob);
        entityareaeffectcloud.setRadius(3.0F);
        entityareaeffectcloud.setRadiusOnUse(-0.5F);
        entityareaeffectcloud.setWaitTime(10);
        entityareaeffectcloud.setRadiusPerTick(-entityareaeffectcloud.getRadius() / (float)entityareaeffectcloud.getDuration());
        entityareaeffectcloud.setPotion(type);

        entityareaeffectcloud.addEffect(new PotionEffect(effect, duration, power));
       
        SoureMob.worldObj.spawnEntityInWorld(entityareaeffectcloud);
	}
	
	
	/** Adapted from @TileEntityBeacon.class
	 * 
	 * @param effect Potion Effect to Implement
	 * @param duration Duration of potion effect in ticks
	 * @param power Level of the potion 
	 * @param range The size of the Aura in meters**/
	public void beaconEffect(Potion effect, int duration, int power, int range){
		
		if (!this.worldObj.isRemote )
        {
            double d0 = (double)(range);            
            
            int k = (int) this.posX;
            int l = (int) this.posY;
            int i1 = (int) this.posZ;
            //Size and location of square to draw
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).expandXyz(d0).addCoord(0.0D, (double)this.worldObj.getHeight(), 0.0D);
            //Targets to collect in square
            List<EntityPlayer> list = this.worldObj.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

            for (EntityPlayer entityplayer : list)
            {
                entityplayer.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
            }
            
        }
	}
	/** Same thing as @beaconEffect
	 * but setup with an example for buffing other mobs**/
	public void Monster_Aura(Potion effect, int duration, int power, int range){
		
		if (!this.worldObj.isRemote )
        {
            double d0 = (double)(range);            
            
            int k = (int) this.posX;
            int l = (int) this.posY;
            int i1 = (int) this.posZ;
            //Size and location of square to draw
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).expandXyz(d0).addCoord(0.0D, (double)this.worldObj.getHeight(), 0.0D);
            //Targets to collect in square
            List<EntityLivingBase> moblist = this.worldObj.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

            for (EntityLivingBase mob : moblist)
            {
            	if(!(mob instanceof EntityExampleMob)){ //Prevent source mob from being effected
            	if(mob instanceof IMob || mob instanceof EntityMob){
            		mob.addPotionEffect(new PotionEffect(effect, duration, power, true, true));
            		//mob.addVelocity(0, 0.04, 0);
            		}
            	}
            }
        }
	}
	
	
	/** Basically we're launching our Bounding Boxs again to scan for local entities 
	 * What this does is if the bounding box contains any entries that would mean it detected a player
	 */
	public boolean Player_Detection(int range){	
		
            double d0 = (double)(range);          
            
            int k = (int) this.posX;
            int l = (int) this.posY;
            int i1 = (int) this.posZ;
            //Size and location of square to draw
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).expandXyz(d0).addCoord(0.0D, (double)this.worldObj.getHeight(), 0.0D);
            //Targets to collect in square
            List<EntityPlayer> list = this.worldObj.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
            
            if(!list.isEmpty())return true;            
        
		return false;
	}
	//================= Climber data =============================//
	protected void entityInit()
    {
        super.entityInit();
        this.setAlwaysRenderNameTag(true);
        this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
    }	
	protected PathNavigate getNewNavigator(World worldIn)
    {
        return new PathNavigateClimber(this, worldIn);
    }
	
	/**This is one of the more important parts
	 * So normally an entity will only act if it's climbing if it's touching a ladder block
	 * with all this extra data mumbo-jumbo we're actually telling it -
	 * - when it collides with any block it's allowed to climb it
	 * our update method starts this whole chain
	 */	
	public boolean isOnLadder()
    {
        return this.isBesideClimbableBlock();
    }
	
	public boolean isBesideClimbableBlock()
    {
        return (((Byte)this.dataManager.get(CLIMBING)).byteValue() & 1) != 0;
    }
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityExampleMob.class, DataSerializers.BYTE);
	
	public void setBesideClimbableBlock(boolean climbing)
    {
        byte b0 = ((Byte)this.dataManager.get(CLIMBING)).byteValue();

        if(climbing){ b0 = (byte)(b0 | 1); }
        else{ b0 = (byte)(b0 & -2); }

        this.dataManager.set(CLIMBING, Byte.valueOf(b0));
    }
	
	//================ Clock to prevent effect being spammed ===============//
	
	public boolean clock(){
		this.timer++;
		if (this.timer >600){
			this.timer = 0;
			return true;
		}
		return false;
	};
		
	short timer;
	
	/** Data for Clock **/
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		if (tag.hasKey("Timer")) {
			short b0 = tag.getShort("Timer");
		}
	}
	
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setShort("Timer", this.timer);
	}	
	
	

	//================== Bunch of mundane things below ========================//
	
	protected SoundEvent getAmbientSound(){return SoundEvents.ENTITY_CHICKEN_AMBIENT;}

	protected SoundEvent getHurtSound(){return SoundEvents.ENTITY_CHICKEN_HURT;	}

	protected SoundEvent getDeathSound(){return SoundEvents.ENTITY_CHICKEN_DEATH;}

	protected void playStepSound(BlockPos pos, Block blockIn){
		this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);}
	
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SHOVEL));
		return livingdata;		
    }
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)10);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
	}
	

}
