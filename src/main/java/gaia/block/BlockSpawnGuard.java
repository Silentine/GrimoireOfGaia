package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class BlockSpawnGuard extends BlockBase {

	private static final EnumProperty<BlockSpawnGuard.EnumType> TYPE = EnumProperty.create("type", BlockSpawnGuard.EnumType.class);

	public BlockSpawnGuard(Block.Properties builder) {
		super(builder.lightValue(0).hardnessAndResistance(0.0F,6.0F).doesNotBlockMovement());
	    this.setDefaultState((BlockState)((BlockState)(this.stateContainer.getBaseState()).with(TYPE, EnumType.NORTH)));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, net.minecraft.world.IBlockReader worldIn, List<ITextComponent> tooltip,
			net.minecraft.client.util.ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.grimoireofgaia.desc").applyTextStyle(TextFormatting.YELLOW));
		tooltip.add(new TranslationTextComponent("block.grimoireofgaia.spawn_guard.desc", 8));
	}
	
	private static final VoxelShape DOWN_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F);
	private static final VoxelShape UP_BOX = Block.makeCuboidShape(0.0F, 15.0F, 0.0F, 16.0F, 16.0F, 16.0F);
	private static final VoxelShape NORTH_BOX = Block.makeCuboidShape(0.0F, 0.0F, 15.0F, 16.0F, 16.0F, 16.0F);
	private static final VoxelShape WEST_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 1.0F);
	private static final VoxelShape EAST_BOX = Block.makeCuboidShape(15.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F);
	private static final VoxelShape SOUTH_BOX = Block.makeCuboidShape(0.0F, 0.0F, 0.0F, 1.0F, 16.0F, 16.0F);

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, net.minecraft.world.IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Direction facing = context.getFace();
		Direction horizontalFacing = context.getPlacementHorizontalFacing();
		return getDefaultState().with(TYPE, EnumType.getFromFacings(facing.getAxis() != Direction.Axis.Y ? facing.getOpposite() : horizontalFacing, facing.getOpposite()));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
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

		public static EnumType getFromFacings(Direction horizontalFacing, Direction verticalFacing) {
			int index = horizontalFacing.getHorizontalIndex() + getVerticalIncrement(verticalFacing);
			return getConstant(index);
		}

		private static int getVerticalIncrement(Direction verticalFacing) {
			if (verticalFacing == Direction.DOWN) {
				return 0;
			}
			return verticalFacing == Direction.UP ? 4 : 8;
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
