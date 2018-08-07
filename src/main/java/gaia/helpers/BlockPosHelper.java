package gaia.helpers;

import net.minecraft.util.math.BlockPos;

import java.util.HashSet;
import java.util.Set;

public class BlockPosHelper {
	private BlockPosHelper() {}

	/**
	 * Basic Sphere shape to create This is creating a map of coordinates to
	 * use. This in particular is designed to create a sphere shape.
	 *
	 * @param pos    The starting point we feed it
	 * @param radius the size to iterate for
	 */
	public static Set<BlockPos> sphereShape(BlockPos pos, int radius) {
		Set<BlockPos> positions = new HashSet<>();
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos newPos = pos.add(x, y, z);
					if (pos.distanceSq(newPos) <= radius) {
						positions.add(newPos);
					}
				}
			}
		}

		return positions;
	}
}
