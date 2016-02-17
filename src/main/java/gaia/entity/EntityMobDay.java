package gaia.entity;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityMobDay extends EntityMobBase {

	static Set<Block> spawnBlocks = Sets.newHashSet(new Block[] {
			Blocks.grass, Blocks.dirt, Blocks.gravel, Blocks.sand, Blocks.snow_layer
	});
	public EntityMobDay(World par1World) {
		super(par1World);
	}

	/*
	//This method is really stupid, you should not allocated 4096 booleans each call,
	//This method is getting call several million times per second
	public boolean getCanSpawnHere() {
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);
		boolean[] spawnBlocks = new boolean[4096];
		spawnBlocks[Block.grass.blockID] = true;
		spawnBlocks[Block.dirt.blockID] = true;
		spawnBlocks[Block.gravel.blockID] = true;
		spawnBlocks[Block.sand.blockID] = true;
		spawnBlocks[Block.snow.blockID] = true;
		spawnBlocks[43] = true;
		int var1 = this.worldObj.getBlockId(i, j - 1, k);
		return spawnBlocks[var1] && this.posY > 60.0D && this.worldObj.getBlockLightValue(i, j, k) >= 7 && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox) && this.worldObj.getChunkFromBlockCoords(i, k).getBlockLightValue(i & 15, j, k & 15, 15) < 7;
	}
	*/
	
	@Override
	public boolean getCanSpawnHere() {
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);

		Block var1 = this.worldObj.getBlock(i, j - 1, k);
		if (spawnBlocks.contains(var1)) {
			// also reorder this part, getCollidingBoundingBoxes and checkNoEntityCollisions and isAnyLiquid are really expensive
			return this.posY > 60.0D && this.worldObj.getBlockLightValue(i, j, k) >= 7
					&& this.worldObj.getChunkFromBlockCoords(i, k).getBlockLightValue(i & 15, j, k & 15, 15) < 7 //what does this achieve, there are methods on world to get the block light level without timed daylight
					&& this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()
					&& !this.worldObj.isAnyLiquid(this.boundingBox);
		}
		return false;
	}
}
