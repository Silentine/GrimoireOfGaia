package gaia.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Sets;

import gaia.GaiaConfig;
import gaia.init.GaiaBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumLightType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

/**
 * Apply all changes made here to EntityMobPassiveDay (except for AI).
 *
 * @see EntityMobPassiveDay
 */
public abstract class EntityMobHostileDay extends EntityMobHostileBase {

	private static Set<Block> spawnBlocks = Sets.newHashSet(Blocks.GRASS, Blocks.DIRT, Blocks.GRAVEL, Blocks.SAND, Blocks.SNOW, Blocks.SNOW);

	public EntityMobHostileDay(EntityType<?> type, World worldIn) {
		super(type, worldIn);

		if (GaiaConfig.COMMON.passiveHostileMobs.get()) {
			targetTasks.removeTask(aiNearestAttackableTarget);
		}
	}

	@Override
	protected boolean isValidLightLevel() {
		BlockPos blockpos = new BlockPos(this.posX, this.getBoundingBox().minY, this.posZ);
		if (this.getBrightness() > 0.5F && this.world.canSeeSky(blockpos)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean canSpawn(IWorld worldIn, boolean value) {
		BlockPos pos = this.getPosition();
		boolean flag = worldIn.getDifficulty() != EnumDifficulty.PEACEFUL && world.isDaytime();
		boolean flag2 = this.isValidLightLevel() && !torchCheck(world, pos);

		Block spawnBlock = world.getBlockState(pos.down()).getBlock();
		Set<String> additionalBlocks = new HashSet<String>(GaiaConfig.COMMON.additionalSpawnBlocks.get());
		boolean defaultFlag = spawnBlocks.contains(spawnBlock);
		boolean additionalFlag = !additionalBlocks.isEmpty() && additionalBlocks.contains(spawnBlock.getRegistryName().toString());

		return !isDimensionBlacklisted() && (defaultFlag || additionalFlag) && flag && flag2 && !world.containsAnyLiquid(this.getBoundingBox());
	}

	public boolean isDimensionBlacklisted() {
		if(!GaiaConfig.COMMON.dimensionBlacklist.get().isEmpty()) {
			if(GaiaConfig.COMMON.dimensionBlacklist.get().contains(String.valueOf(this.world.getDimension().getType().getId()))) {
				return true;
			} else {
				return false;
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
