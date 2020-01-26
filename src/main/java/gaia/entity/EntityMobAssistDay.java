package gaia.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import gaia.GaiaConfig;
import gaia.init.GaiaBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
 * Apply all changes made here to EntityMobHostileDay (except for AI).
 *
 * @see EntityMobHostileDay
 */
public abstract class EntityMobAssistDay extends EntityMobAssistBase {

	private static Set<Block> spawnBlocks = Sets.newHashSet(Blocks.GRASS, Blocks.DIRT, Blocks.GRAVEL, Blocks.SAND, Blocks.SNOW_LAYER, Blocks.SNOW);

	public EntityMobAssistDay(World worldIn) {
		super(worldIn);
	}

	@Override
	public boolean getCanSpawnHere() {
		super.getCanSpawnHere();
		
		if (GaiaConfig.SPAWN.spawnDaysPassed) {
			return daysPassed() && spawnConditions();
		} else {
			return spawnConditions();
		}
	}

	public boolean spawnConditions() {
		if (this.world.isDaytime()) {
			float f = this.getBrightness();
			if (f > 0.5F && this.world.canSeeSky(this.getPosition())) {
				if (torchCheck(this.world, this.getPosition())) {
					return false;
				} else {
					int i = MathHelper.floor(this.posX);
					int j = MathHelper.floor(this.getEntityBoundingBox().minY);
					int k = MathHelper.floor(this.posZ);
					BlockPos blockpos = new BlockPos(i, j, k);
					Block var1 = this.world.getBlockState(blockpos.down()).getBlock();
					Set<String> additionalBlocks = new HashSet<String>(Arrays.asList(GaiaConfig.SPAWN.additionalSpawnBlocks));

					boolean defaultFlag = spawnBlocks.contains(var1);
					boolean additionalFlag = !additionalBlocks.isEmpty() && additionalBlocks.contains(var1.getRegistryName().toString());

					return (defaultFlag || additionalFlag) && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
				}
			}
		}

		return false;
	}

	private static Set<Block> blackList = Sets.newHashSet(GaiaBlocks.SPAWN_GUARD);

	/**
	 * The actual check. It inputs the radius and feeds it to the sphere shape method. After it gets the block position map it scans every block in that map. Then returns depending if the match triggers.
	 */
	private static boolean torchCheck(World world, BlockPos pos) {
		for (BlockPos location : BlockPos.getAllInBox(pos.add(-8, -8, -8), pos.add(8, 8, 8))) {
			if (blackList.contains(world.getBlockState(location).getBlock())) {
				return true;
			}
		}

		return false;
	}
}
