package gaia.helpers;

import java.util.Optional;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class WorldHelper {
	private WorldHelper() {}

	public static <T extends TileEntity> Optional<T> getTile(IBlockReader blockReader, BlockPos pos, Class<T> teClass) {
		TileEntity te = blockReader.getTileEntity(pos);
		return teClass.isInstance(te) ? Optional.of(teClass.cast(te)) : Optional.empty();
	}
}
