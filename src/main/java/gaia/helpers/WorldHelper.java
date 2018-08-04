package gaia.helpers;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Optional;

public class WorldHelper {
	private WorldHelper() {}

	public static <T extends TileEntity> Optional<T> getTile(IBlockAccess blockAccess, BlockPos pos, Class<T> teClass) {
		TileEntity te = blockAccess.getTileEntity(pos);
		return teClass.isInstance(te) ? Optional.of(teClass.cast(te)) : Optional.empty();
	}
}
