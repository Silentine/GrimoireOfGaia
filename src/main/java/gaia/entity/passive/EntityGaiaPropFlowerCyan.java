package gaia.entity.passive;

import gaia.GaiaItem;
import gaia.entity.monster.EntityGaiaMandragora;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

public class EntityGaiaPropFlowerCyan extends EntityAgeable {

	public EntityGaiaPropFlowerCyan(World par1World) {
		super(par1World);
		this.setSize(0.6F, 1.8F);
		this.experienceValue = 0;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected String getDeathSound() {
		return "dig.grass";
	}

	protected void dropFewItems(boolean par1, int par2) {
		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
				this.dropItem(Item.getItemFromBlock(Blocks.yellow_flower), 1);
			} else {
				this.dropItem(Item.getItemFromBlock(Blocks.red_flower), 1);
			}
		} else {
			EntityGaiaMandragora spawnMob = new EntityGaiaMandragora(this.worldObj);
			spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			spawnMob.onSpawnWithEgg((IEntityLivingData)null);
			this.worldObj.spawnEntityInWorld(spawnMob);
		}

	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(1)) {
		case 0:
			this.dropItem(GaiaItem.FoodMandrake,1);
		default:
		}
	}

	protected void onDeathUpdate() {
		this.setDead();
	}

	private void generateRandomParticles(String par1Str) {
		for(int i = 0; i < 5; ++i) {
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle(par1Str, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
		}

	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id?false:super.isPotionApplicable(par1PotionEffect);
	}

	public void knockBack(Entity par1Entity, int par2, double par3, double par5) {}

	public void applyEntityCollision(Entity par1Entity) {}

	protected void collideWithEntity(Entity par1Entity) {}

	public boolean canBeCollidedWith() {
		return true;
	}

	public boolean canBePushed() {
		return true;
	}

	public boolean allowLeashing() {
		return false;
	}

	//BAAAD!
	//   public boolean getCanSpawnHere() {
		//      int i = MathHelper.floor_double(this.posX);
		//      int j = MathHelper.floor_double(this.boundingBox.minY);
	//      int k = MathHelper.floor_double(this.posZ);
	//      boolean[] spawnBlocks = new boolean[4096];
	//      spawnBlocks[Block.grass.blockID] = true;
	//      spawnBlocks[Block.dirt.blockID] = true;
	//      spawnBlocks[43] = true;
	//      int var1 = this.worldObj.getBlockId(i, j - 1, k);
	//      return spawnBlocks[var1] && this.posY > 60.0D && this.worldObj.getBlockLightValue(i, j, k) > 8 && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
	//   }

	static Set<Block> spawnBlocks = Sets.newHashSet(new Block[] {
			Blocks.grass, Blocks.dirt, 
			Blocks.double_stone_slab //???
	});
	
	public boolean getCanSpawnHere() {
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);
		Block var1 = this.worldObj.getBlock(i, j - 1, k);
		if (spawnBlocks.contains(var1)) {
			return this.posY > 60.0D && this.worldObj.getBlockLightValue(i, j, k) > 8 
					&& this.worldObj.checkNoEntityCollision(this.boundingBox) 
					&& this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() 
					&& !this.worldObj.isAnyLiquid(this.boundingBox);
		}
		return false;
	}

	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
