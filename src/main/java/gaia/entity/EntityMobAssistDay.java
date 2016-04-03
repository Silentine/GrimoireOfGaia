package gaia.entity;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

//This is a direct copy of EntityMobDay
public abstract class EntityMobAssistDay extends EntityMobAssistBase {

	static Set<Block> spawnBlocks = Sets.newHashSet(new Block[] {
			Blocks.grass, 
			Blocks.dirt,
			Blocks.gravel, 
			Blocks.sand, 
			Blocks.snow_layer
	});
	
	public EntityMobAssistDay(World par1World) {
		super(par1World);
	}

	public boolean getCanSpawnHere() {
		if (this.worldObj.isDaytime()) {
			float f = this.getBrightness(1.0F);
			if (f > 0.5F && this.worldObj.canSeeSky(this.getPosition())) {

				int i = MathHelper.floor_double(this.posX);
				int j = MathHelper.floor_double(this.getEntityBoundingBox().minY);
				int k = MathHelper.floor_double(this.posZ);
				BlockPos blockpos = new BlockPos(i, j, k);			
				Block var1 = this.worldObj.getBlockState(blockpos.down()).getBlock();

				return spawnBlocks.contains(var1)&& !this.worldObj.isAnyLiquid(this.getEntityBoundingBox());
			}
		}
		
		return false;
	}
}
