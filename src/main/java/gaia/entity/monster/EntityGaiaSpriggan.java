package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityGaiaSpriggan extends EntityMobHostileBase {
	
	private int axeAttack;

	public EntityGaiaSpriggan(World worldIn) {
		super(worldIn);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;

		this.axeAttack = 0;
	}
	
    protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed2, true));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 2.0F, 1.0F));
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
				
				if (itemstack.getItem() instanceof ItemAxe) {
					damage = input*1.5F;
					this.axeAttack += 1;
				}
			}
		}
		
		return super.attackEntityFrom(source, damage);
	}
	
    public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback2);
	}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		if (this.isInWater()) {
			this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 0));
		}
		
		if (this.isWet()) {
			this.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 10 * 20, 0));
		}
		
		if (this.isBurning()) {
			this.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
			this.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
		}

		super.onLivingUpdate();
	}

	protected SoundEvent getHurtSound() {
		return SoundEvents.BLOCK_WOOD_STEP;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_ZOMBIE_BREAK_DOOR_WOOD;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {	
		this.playSound(SoundEvents.BLOCK_WOOD_STEP, 0.15F, 1.0F);
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int var3 = this.rand.nextInt(3 + lootingModifier);

			for (int var4 = 0; var4 < var3; ++var4) {
				this.dropItem(GaiaItems.FoodRoot, 1);
			}

			if 	(this.axeAttack >= 4) {
				if ((this.rand.nextInt(2) == 0)) {
					this.dropItem(Item.getItemFromBlock(Blocks.LOG), this.rand.nextInt(2) + 1);
				}
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
			
    		//Rare
    		if ((this.rand.nextInt(EntityAttributes.rateraredrop) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
    			switch(this.rand.nextInt(3)) {
    			case 0:
    				this.dropItem(GaiaItems.BoxGold, 1);
    				break;
    			case 1:
    				this.dropItem(GaiaItems.BagBook, 1);
    				break;
    			case 2:
    				this.dropItem(GaiaItems.BookNature, 1);
    			}
    		}
		}
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
