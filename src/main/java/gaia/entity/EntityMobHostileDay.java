package gaia.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import gaia.GaiaConfig;
import gaia.helpers.BlockPosHelper;
import gaia.init.GaiaBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
 * Apply all changes made here to EntityMobPassiveDay (except for AI and processInteract).
 *
 * @see EntityMobPassiveDay
 */
@SuppressWarnings("squid:MaximumInheritanceDepth")
public abstract class EntityMobHostileDay extends EntityMobHostileBase {
	
	private static final int SPAWN_GUARD_RADIUS = 16;
	
	private static Set<Block> spawnBlocks = 
			Sets.newHashSet
			(
					Blocks.GRASS, 
					Blocks.DIRT, 
					Blocks.GRAVEL, 
					Blocks.SAND, 
					Blocks.SNOW_LAYER,
					Blocks.SNOW
			);

	public EntityMobHostileDay(World worldIn) {
		super(worldIn);
		
		if (GaiaConfig.OPTIONS.passiveHostileMobs) {
			targetTasks.removeTask(aiNearestAttackableTarget);
		}
	}

	@Override
	public boolean getCanSpawnHere() {
		if (this.world.isDaytime()) {
			float f = this.getBrightness();
			if (f > 0.5F && this.world.canSeeSky(this.getPosition())) {
				if (torchCheck(this.world, this.getPosition())) {
					return false;
				}

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

		return false;
	}

	private static Set<Block> blackList = Sets.newHashSet(GaiaBlocks.SPAWN_GUARD);

	/**
	 * The actual check. It inputs the radius and feeds it to the sphere shape method. After it gets the block position map it scans every block in that map. Then returns depending if the match triggers.
	 * TODO Needs fixing.
	 */
	private static boolean torchCheck(World world, BlockPos pos) {
		for (BlockPos location : BlockPosHelper.sphereShape(pos, SPAWN_GUARD_RADIUS)) {
			if (blackList.contains(world.getBlockState(location).getBlock())) {
				return true;
			}
		}

		return false;
	}
}
