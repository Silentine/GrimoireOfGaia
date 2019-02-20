package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockDecoration extends BlockBase {
	private static final EnumProperty<BlockDecoration.EnumType> TYPE = EnumProperty.create("type", BlockDecoration.EnumType.class);

	public BlockDecoration(Block.Properties builder) {
		super(builder.lightValue(0).hardnessAndResistance(0, 6.0F));
//		this.setLightOpacity(0);
//		this.setHardness(0.0F);
//		this.setResistance(6.0F);
	    this.setDefaultState((IBlockState)((IBlockState)(this.stateContainer.getBaseState()).with(TYPE, EnumType.NORTH)));

	}

	private static final VoxelShape DOWN_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 20.0F, 16.0F);
//	private static final VoxelShape UP_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 20.0F, 16.0F);
	private static final VoxelShape NORTH_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 20.0F, 16.0F);
	private static final VoxelShape WEST_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 20.0F, 16.0F);
	private static final VoxelShape EAST_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 20.0F, 16.0F);
	private static final VoxelShape SOUTH_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 20.0F, 16.0F);

	@OnlyIn(Dist.CLIENT)
	public BlockRenderLayer getBlockLayer() {
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
		EnumType type = state.get(TYPE);
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
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
	    builder.add(TYPE);
	}

	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		EnumFacing facing = context.getFace();
		EnumFacing horizontalFacing = context.getPlacementHorizontalFacing();
		return getDefaultState().with(TYPE, EnumType.getFromFacings(facing.getAxis() != EnumFacing.Axis.Y ? facing.getOpposite() : horizontalFacing, facing.getOpposite()));
	}

	public enum EnumType implements IStringSerializable {
		NORTH(2, "north"), SOUTH(0, "south"), WEST(1, "west"), EAST(3, "east");

		private int id;
		private String name;

		EnumType(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

		public static EnumType getFromFacings(EnumFacing horizontalFacing, EnumFacing verticalFacing) {
			int index = horizontalFacing.getHorizontalIndex() + getVerticalIncrement(verticalFacing);
			return getConstant(index);
		}

		private static int getVerticalIncrement(EnumFacing verticalFacing) {
			if (verticalFacing == EnumFacing.DOWN) {
				return 0;
			}
			return verticalFacing == EnumFacing.UP ? 4 : 8;
		}

		public int getId() {
			return id;
		}

		public static EnumType getConstant(int meta) {
			if (0 > meta || meta > 3) {
				return NORTH;
			}
			return EnumType.values()[meta];
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return facing == EnumFacing.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
}
