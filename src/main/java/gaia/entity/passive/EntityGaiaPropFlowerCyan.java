package gaia.entity.passive;

import gaia.entity.monster.EntityGaiaMandragora;
import gaia.init.GaiaItems;

import java.util.Set;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

/** 
 * @see EntityShulker
 */
public class EntityGaiaPropFlowerCyan extends EntityAgeable {
	
	private int shovelAttack;

	public EntityGaiaPropFlowerCyan(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.8F);
		this.experienceValue = 0;
		this.prevRenderYawOffset = 180.0F;
		this.renderYawOffset = 180.0F;
		
		this.shovelAttack = 0;
	}

	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		this.renderYawOffset = 180.0F;
		this.prevRenderYawOffset = 180.0F;
		this.rotationYaw = 180.0F;
		this.prevRotationYaw = 180.0F;
		this.rotationYawHead = 180.0F;
		this.prevRotationYawHead = 180.0F;
		return super.onInitialSpawn(difficulty, livingdata);
	}
	
    protected boolean canTriggerWalking() {
        return false;
    }

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
	}
	
	public boolean attackEntityFrom(DamageSource source, float damage) {
		float input = damage;
		Entity entity = source.getEntity();
		
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());
			if (itemstack != null) {
				
				if (itemstack.getItem() instanceof ItemSpade) {
					damage = input*1.5F;
					this.shovelAttack += 1;
				}
			}
		}
		
		return super.attackEntityFrom(source, damage);
	}

	public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		if (this.getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.onLivingUpdate();
		}
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_GRASS_BREAK;		
	}

	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + lootingModifier) > 0)) {
				switch(this.rand.nextInt(10)) {
				case 0:
					this.dropItem(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), 1);
					break;
				case 1:
					this.dropItem(Item.getItemFromBlock(Blocks.RED_FLOWER), 1);
					break;
				case 2:
					this.entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 1), 0.0F);
					break;
				case 3:
					this.entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 2), 0.0F);
					break;
				case 4:
					this.entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 3), 0.0F);
					break;
				case 5:
					this.entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 4), 0.0F);
					break;
				case 6:
					this.entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 5), 0.0F);
					break;
				case 7:
					this.entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 6), 0.0F);
					break;
				case 8:
					this.entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 7), 0.0F);
					break;
				case 9:
					this.entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 8), 0.0F);
					break;
				}
			} else {
				EntityGaiaMandragora spawnMob = new EntityGaiaMandragora(this.worldObj);
				spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
				spawnMob.onSpawnWithEgg((IEntityLivingData)null);
				this.worldObj.spawnEntityInWorld(spawnMob);
			}

			if 	(this.shovelAttack >= 1) {
				if ((this.rand.nextInt(16) == 0)) {
					this.dropItem(GaiaItems.FoodMandrake, 1);
				}
			}
		}
	}

	protected void onDeathUpdate() {
		this.setDead();
	}

	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return false;
	}

	protected void collideWithEntity(Entity entityIn) {}

	public boolean canBeCollidedWith() {
		return true;
	}

	public boolean canBePushed() {
		return true;
	}

	public boolean allowLeashing() {
		return false;
	}

	//================= Spawn Conditions =================//
	static Set<Block> spawnBlocks = Sets.newHashSet(new Block[] {
			Blocks.GRASS, 
			Blocks.DIRT
	});

	public boolean getCanSpawnHere() {
		if (this.worldObj.isDaytime()) {
			float f = this.getBrightness(1.0F);
			if (f > 0.5F && this.worldObj.canSeeSky(this.getPosition())) {
				int i = MathHelper.floor_double(this.posX);
				int j = MathHelper.floor_double(this.getEntityBoundingBox().minY);
				int k = MathHelper.floor_double(this.posZ);
				BlockPos blockpos = new BlockPos(i, j, k);			
				Block var1 = this.worldObj.getBlockState(blockpos.down()).getBlock();

				return 	this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL && this.spawnBlocks.contains(var1) && !this.worldObj.containsAnyLiquid(this.getEntityBoundingBox());
			}
		}

		return false;
	}
	//==================================//
	
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	public void applyEntityCollision(Entity entityIn) {}
	
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
