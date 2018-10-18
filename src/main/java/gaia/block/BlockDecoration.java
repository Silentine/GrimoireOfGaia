package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDecoration extends BlockBase {

	private static final PropertyEnum<BlockDecoration.EnumType> TYPE = PropertyEnum.create("type", BlockDecoration.EnumType.class);

	public BlockDecoration(Material material, String blockName) {
		super(material, blockName);
		this.setLightOpacity(0);
		this.setHardness(0.0F);
		this.setResistance(6.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.NORTH));
	}

	private static final AxisAlignedBB DOWN_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
	private static final AxisAlignedBB UP_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
	private static final AxisAlignedBB NORTH_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
	private static final AxisAlignedBB WEST_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
	private static final AxisAlignedBB EAST_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
	private static final AxisAlignedBB SOUTH_BOX = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);

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

	/**
	 * Checks if this block can be placed exactly at the given position.
	 * 
	 * @see BlockFlowerPot
	 */
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState downState = worldIn.getBlockState(pos.down());
		return super.canPlaceBlockAt(worldIn, pos) && (downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID);
	}

	/**
	 * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid block, etc.
	 * 
	 * @see BlockFlowerPot
	 */
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		IBlockState downState = worldIn.getBlockState(pos.down());
		if (!downState.isTopSolid() && downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) != BlockFaceShape.SOLID) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
	}
}
