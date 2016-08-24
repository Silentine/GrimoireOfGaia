package gaia.entity.passive;

import gaia.entity.monster.EntityGaiaMandragora;
import gaia.init.GaiaItem;
import gaia.init.Sounds;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected SoundEvent getDeathSound(){
		return SoundEvents.BLOCK_GRASS_BREAK;		
	}

	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			if (par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
				this.dropItem(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), 1);
			} else {
				this.dropItem(Item.getItemFromBlock(Blocks.RED_FLOWER), 1);
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

	
	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotion() == MobEffects.POISON?false:super.isPotionApplicable(par1PotionEffect);
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
				
				return spawnBlocks.contains(var1)&& !this.worldObj.containsAnyLiquid(this.getEntityBoundingBox());
			}}
		
		return false;
		}

	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
