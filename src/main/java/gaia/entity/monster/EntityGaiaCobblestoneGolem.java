package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import gaia.util.BlockStateHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** 
 * @see EntityIronGolem
 */
public class EntityGaiaCobblestoneGolem extends EntityMobHostileBase {

	private int attackTimer;
	private int holdRoseTick;

	public EntityGaiaCobblestoneGolem(World par1World) {
		super(par1World);
		this.setSize(1.4F, 2.2F);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.isImmuneToFire = true;
		this.tasks.addTask(0, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true));
		this.tasks.addTask(1, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EntityAttributes.maxHealth2);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((double)EntityAttributes.attackDamage2);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor2);
        
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (damage > EntityAttributes.baseDefense2) {
			damage = EntityAttributes.baseDefense2;
		}
		
		float input = damage;
		Entity entity = source.getEntity();
		
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());
			if (itemstack != null) {
				
				if (itemstack.getItem() instanceof ItemPickaxe) {
					damage = input+5;
				}
			}
		}
		
		return super.attackEntityFrom(source, damage);
	}
	
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		this.attackTimer = 10;
		this.worldObj.setEntityState(this, (byte)4);
		boolean var2 = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));
		if (var2) {
			entityIn.motionY += 0.6000000059604645D;
		}

		this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
		return var2;
	}

	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte par1) {
		if (par1 == 4) {
			this.attackTimer = 10;
			this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
		} else if (par1 == 11) {
			this.holdRoseTick = 400;
		} else {
			super.handleStatusUpdate(par1);
		}
	}

	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}
	
	public int getHoldRoseTick() {
		return this.holdRoseTick;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		
		if (this.attackTimer > 0) {
			--this.attackTimer;
		}

		if (this.holdRoseTick > 0) {
			--this.holdRoseTick;
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
						((double)this.rand.nextFloat() - 0.5D) * 4.0D,
						crackid,crackmeta);
			}
		}
	}


	protected SoundEvent getAmbientSound() {
		return Sounds.none;	
	}

	protected SoundEvent getHurtSound() {
		return SoundEvents.BLOCK_STONE_BREAK;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_IRONGOLEM_DEATH;		
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(SoundEvents.ENTITY_IRONGOLEM_STEP, 1.0F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for (int var4 = 0; var4 < var3; ++var4) {
            ItemShard.Drop_Nugget(this,0);
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
			this.dropItem(Item.getItemFromBlock(GaiaBlocks.SpawnGuard), 1);
		}
	}
	
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON ? false:super.isPotionApplicable(potioneffectIn);
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
