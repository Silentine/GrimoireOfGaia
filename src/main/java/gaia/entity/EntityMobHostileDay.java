package gaia.entity;

import gaia.init.GaiaBlocks;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

//Apply any changes to EntityMobAssistDay
public abstract class EntityMobHostileDay extends EntityMobHostileBase {

	static Set<Block> spawnBlocks = Sets.newHashSet(new Block[] {
			Blocks.GRASS, 
			Blocks.DIRT,
			Blocks.GRAVEL, 
			Blocks.SAND, 
			Blocks.SNOW_LAYER
	});

	public EntityMobHostileDay(World worldIn) {
		super(worldIn);
	}

	public boolean getCanSpawnHere() {
		if (this.worldObj.isDaytime()) {
			float f = this.getBrightness(1.0F);
			if (f > 0.5F && this.worldObj.canSeeSky(this.getPosition())) {
				if (torchCheck(this.worldObj, this.getPosition(), 8))
					return false;

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

	static Set<Block> blackList = Sets.newHashSet(new Block[] {
			GaiaBlocks.SpawnGuard
	});	

	/** The actual check
	 * 	It inputs the radius and feeds it to the sphere shape method.
	 *  After it gets the block position map it scans every block in that map.
	 *  Then returns depending if the match triggers.
	 */
	public static boolean torchCheck(World world, BlockPos pos, int radius) {
		for (BlockPos location : sphereShape(pos, radius)) {
			if (blackList.contains(world.getBlockState(location).getBlock()))
				return true;
		}
		
		return false;
	}	

	/** Basic Sphere shape to create
	 *  This is creating a map of coordinates to use.
	 *  This in particular is designed to create a sphere shape.
	 *   @param pos The starting point we feed it
	 *   @param radius the size to iterate for
	 */
	public static Set<BlockPos> sphereShape(BlockPos pos, int radius) {
		Set<BlockPos> positions = new HashSet<BlockPos>();
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
				}
			}
		}

		return positions;
	}
}
