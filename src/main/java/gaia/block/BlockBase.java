package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

class BlockBase extends Block {
	BlockBase(Block.Properties builder) {
		super(builder);
	}

	@Override
	public boolean propagatesSkylightDown(IBlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}
}
