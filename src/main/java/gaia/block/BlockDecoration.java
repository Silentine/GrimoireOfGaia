package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class BlockDecoration extends BlockBase {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public BlockDecoration(Block.Properties builder) {
		super(builder.lightValue(0).hardnessAndResistance(0, 6.0F).doesNotBlockMovement());
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	private static final VoxelShape DOWN_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);
	private static final VoxelShape NORTH_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);
	private static final VoxelShape WEST_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);
	private static final VoxelShape EAST_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);
	private static final VoxelShape SOUTH_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction type = state.get(FACING);
		switch (type) {
		case EAST:
			return EAST_BOX;
		case NORTH:
			return NORTH_BOX;
		case SOUTH:
			return SOUTH_BOX;
		case WEST:
			return WEST_BOX;
		default:
			return DOWN_BOX;
		}
	}
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
}
