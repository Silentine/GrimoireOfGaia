package gaia.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

//This is a direct copy of EntityMobDay
public abstract class EntityMobAssistDay extends EntityMobAssistBase {

	static Set<Block> spawnBlocks = Sets.newHashSet(new Block[] {
			Blocks.GRASS, 
			Blocks.DIRT,
			Blocks.GRAVEL, 
			Blocks.SAND, 
			Blocks.SNOW_LAYER
	});
	
	public EntityMobAssistDay(World par1World) {
		super(par1World);
	}

	@Override
	public boolean getCanSpawnHere() {
		if (this.worldObj.isDaytime()) {
			float f = this.getBrightness(1.0F);
			if (f > 0.5F && this.worldObj.canSeeSky(this.getPosition())) {
				

		    	if(Torch_Check(this.worldObj, this.getPosition(), 8))return false;

				int i = MathHelper.floor_double(this.posX);
				int j = MathHelper.floor_double(this.getEntityBoundingBox().minY);
				int k = MathHelper.floor_double(this.posZ);
				BlockPos blockpos = new BlockPos(i, j, k);			
				Block var1 = this.worldObj.getBlockState(blockpos.down()).getBlock();

				return spawnBlocks.contains(var1)&& !this.worldObj.containsAnyLiquid(this.getEntityBoundingBox());
			}
		}
		
		return false;
	}
	

	//A new set of blocks to check for
	static Set<Block> Blacklist = Sets.newHashSet(new Block[] {
			Blocks.TORCH, 
			Blocks.REDSTONE_TORCH
	});	
	
	/** The actual check
	 * 	It inputs the radius and feeds it to the sphere shape method
	 *  After it gets the block position map it scans every block in that map
	 *  Then returns depending if the match triggers
	 */
	public static boolean Torch_Check(World world, BlockPos pos, int radius){
		
		for (BlockPos location : Sphere_Shape(pos, radius)) {
			if(Blacklist.contains(world.getBlockState(location).getBlock())){
				return true;}
		}
		return false;
	}	
	
	/** Basic Sphere shape to create
	 *  This is creating a map of coordinates to use
	 *  This in particular is designed to create a sphere shape
	 *   @param pos The starting point we feed it
	 *   @param radius the size to iterate for
	 *  **/
	public static Set<BlockPos> Sphere_Shape(BlockPos pos, int radius){
		Set<BlockPos> positions = new HashSet<BlockPos>();
		
		//Here we are creating an'X' array, an 'Y' array and so on
		//Notice the -radius is the starting point, creating the offest
		//Which then iterates from the side to the end
		//During this time and additions we're creating new positions
		//Which then feed to the final function which adds it to the map
		
		//Obviously this is a little complex but I had the code laying around from another
		//project and figured why not
		//You can observe similiar code elsewhere in minecraft vanilla
		//Such as the @World.containsAnyLiquid method
		//Which is used for other spawning code
	      for (int x = -radius; x <= radius; x++)
	      {
	          for (int y = -radius; y <= radius; y++)
	          {
	              for (int z = -radius; z <= radius; z++)
	              {
	            	//if you wanted it to be a block shape instead you could remove this check
	                  if (!(x * x + y * y + z * z >= (radius + 0.50f) * (radius + 0.50f)))
	                  {
	                      positions.add(pos.add(x, y, z));
	                  }}}}
		
		return positions;
	}
}
