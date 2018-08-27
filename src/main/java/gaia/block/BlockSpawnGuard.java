package gaia.block;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpawnGuard extends BlockBase {

	private static final PropertyEnum<BlockSpawnGuard.EnumType> TYPE = PropertyEnum.create("type", BlockSpawnGuard.EnumType.class);

	public BlockSpawnGuard() {
		super(Material.CLOTH, "spawn_guard");
		this.setLightOpacity(0);
		this.setHardness(0.0F);
		this.setResistance(6.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.NORTH));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.grimoireofgaia.desc")));
		tooltip.add(I18n.format("block.grimoireofgaia.spawn_guard.desc", 8));
	}

	private static final AxisAlignedBB DOWN_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.06F, 1.0F);
	private static final AxisAlignedBB UP_BOX = new AxisAlignedBB(0.0F, 0.94F, 0.0F, 1.0F, 1.0F, 1.0F);
	private static final AxisAlignedBB NORTH_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.94F, 1.0F, 1.0F, 1.0F);
	private static final AxisAlignedBB WEST_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.06F);
	private static final AxisAlignedBB EAST_BOX = new AxisAlignedBB(0.94F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	private static final AxisAlignedBB SOUTH_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 0.06F, 1.0F, 1.0F);

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumType type = state.getValue(TYPE);
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
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPE, EnumType.getConstant(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(TYPE).getId();
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return getDefaultState().withProperty(TYPE, EnumType.getFromFacings(facing.getAxis() != EnumFacing.Axis.Y ? facing.getOpposite() : placer.getHorizontalFacing(), facing.getOpposite()));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, TYPE);
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
