package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class BlockDecoration extends BlockBase {
	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;

	public BlockDecoration(Block.Properties builder) {
		super(builder.lightValue(0).hardnessAndResistance(0, 6.0F));
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH));
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(FACING);
	}

	private static final VoxelShape DOWN_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);
	private static final VoxelShape NORTH_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);
	private static final VoxelShape WEST_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);
	private static final VoxelShape EAST_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);
	private static final VoxelShape SOUTH_BOX = Block.makeCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 20.0F, 13.0F);

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

//	@Override
//	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
//		return true;
//	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		EnumFacing type = state.get(FACING);
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
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@SuppressWarnings("deprecation")
	@Override
	public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return facing == EnumFacing.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
}
