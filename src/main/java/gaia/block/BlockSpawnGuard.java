package gaia.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockSpawnGuard extends BlockBase {

	private static final EnumProperty<BlockSpawnGuard.EnumType> TYPE = EnumProperty.create("type", BlockSpawnGuard.EnumType.class);

	public BlockSpawnGuard(Block.Properties builder) {
		super(builder.lightValue(0).hardnessAndResistance(0.0F,6.0F).doesNotBlockMovement());
//		super(Material.CLOTH, "spawn_guard");
	    this.setDefaultState((IBlockState)((IBlockState)(this.stateContainer.getBaseState()).with(TYPE, EnumType.NORTH)));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, net.minecraft.world.IBlockReader worldIn, List<ITextComponent> tooltip,
			net.minecraft.client.util.ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.grimoireofgaia.desc").applyTextStyle(TextFormatting.YELLOW));
		tooltip.add(new TextComponentTranslation("block.grimoireofgaia.spawn_guard.desc", 8));
	}
	
	private static final VoxelShape DOWN_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 0.06F, 16.0F);
	private static final VoxelShape UP_BOX = Block.makeCuboidShape(0.0F, 15.04F, 0.0F, 16.0F, 16.0F, 16.0F);
	private static final VoxelShape NORTH_BOX = Block.makeCuboidShape(0.0F, 0.0F, 15.04F, 16.0F, 16.0F, 16.0F);
	private static final VoxelShape WEST_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 0.96F);
	private static final VoxelShape EAST_BOX = Block.makeCuboidShape(15.04F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F);
	private static final VoxelShape SOUTH_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 0.96F, 16.0F, 16.0F);

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean propagatesSkylightDown(IBlockState state, IBlockReader reader, BlockPos pos) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public VoxelShape getShape(IBlockState state, net.minecraft.world.IBlockReader worldIn, BlockPos pos) {
		EnumType type = state.get(TYPE);
		switch (type) {
			case UP_NORTH:
			case UP_SOUTH:
			case UP_WEST:
			case UP_EAST:
				return UP_BOX;
			case VERTICAL_NORTH:
				return NORTH_BOX;
			case VERTICAL_SOUTH:
				return SOUTH_BOX;
			case VERTICAL_WEST:
				return WEST_BOX;
			case VERTICAL_EAST:
				return EAST_BOX;
			default:
				return DOWN_BOX;
		}
	}

	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		EnumFacing facing = context.getFace();
		EnumFacing horizontalFacing = context.getPlacementHorizontalFacing();
		return getDefaultState().with(TYPE, EnumType.getFromFacings(facing.getAxis() != EnumFacing.Axis.Y ? facing.getOpposite() : horizontalFacing, facing.getOpposite()));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
	    builder.add(TYPE);
	}

	public enum EnumType implements IStringSerializable {
		NORTH(2, "north"),
		SOUTH(0, "south"),
		WEST(1, "west"),
		EAST(3, "east"),

		UP_NORTH(6, "u_north"),
		UP_SOUTH(4, "u_south"),
		UP_WEST(5, "u_west"),
		UP_EAST(7, "u_east"),

		VERTICAL_NORTH(10, "v_north"),
		VERTICAL_SOUTH(8, "v_south"),
		VERTICAL_WEST(9, "v_west"),
		VERTICAL_EAST(11, "v_east");

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
			if (0 > meta || meta > 11) {
				return NORTH;
			}
			return EnumType.values()[meta];
		}
	}
}
