package gaia.block;

import java.util.Random;

import javax.annotation.Nullable;

import gaia.CreativeTabGaia;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see BlockFire
 * @see BlockWeb
 */
public class BlockFireCamp extends BlockBase {

	public BlockFireCamp() {
		super(Material.FIRE, "fire_camp");
		setHardness(0.0F);
		setLightLevel(0.875F);
		setSoundType(SoundType.CLOTH);
		disableStats();
		setTickRandomly(true);
		setCreativeTab(null);
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public int tickRate(World worldIn) {
		return 30;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	protected boolean canDie(World worldIn, BlockPos pos) {
		return worldIn.isRainingAt(pos) || worldIn.isRainingAt(pos.west()) || worldIn.isRainingAt(pos.east()) || worldIn.isRainingAt(pos.north()) || worldIn.isRainingAt(pos.south());
	}

	public boolean requiresUpdates() {
		return false;
	}

	public boolean isCollidable() {
		return false;
	}

	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.getBlockState(pos.down()).isTopSolid()) {
			worldIn.setBlockToAir(pos);
		}
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(24) == 0) {
			worldIn.playSound((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
		}

		if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP) && !Blocks.FIRE.canCatchFire(worldIn, pos.down(), EnumFacing.UP)) {
			if (Blocks.FIRE.canCatchFire(worldIn, pos.west(), EnumFacing.EAST)) {
				for (int j = 0; j < 2; ++j) {
					double d3 = (double) pos.getX() + rand.nextDouble() * 0.10000000149011612D;
					double d8 = (double) pos.getY() + rand.nextDouble();
					double d13 = (double) pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Blocks.FIRE.canCatchFire(worldIn, pos.east(), EnumFacing.WEST)) {
				for (int k = 0; k < 2; ++k) {
					double d4 = (double) (pos.getX() + 1) - rand.nextDouble() * 0.10000000149011612D;
					double d9 = (double) pos.getY() + rand.nextDouble();
					double d14 = (double) pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d4, d9, d14, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Blocks.FIRE.canCatchFire(worldIn, pos.north(), EnumFacing.SOUTH)) {
				for (int l = 0; l < 2; ++l) {
					double d5 = (double) pos.getX() + rand.nextDouble();
					double d10 = (double) pos.getY() + rand.nextDouble();
					double d15 = (double) pos.getZ() + rand.nextDouble() * 0.10000000149011612D;
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d5, d10, d15, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Blocks.FIRE.canCatchFire(worldIn, pos.south(), EnumFacing.NORTH)) {
				for (int i1 = 0; i1 < 2; ++i1) {
					double d6 = (double) pos.getX() + rand.nextDouble();
					double d11 = (double) pos.getY() + rand.nextDouble();
					double d16 = (double) (pos.getZ() + 1) - rand.nextDouble() * 0.10000000149011612D;
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d6, d11, d16, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Blocks.FIRE.canCatchFire(worldIn, pos.up(), EnumFacing.DOWN)) {
				for (int j1 = 0; j1 < 2; ++j1) {
					double d7 = (double) pos.getX() + rand.nextDouble();
					double d12 = (double) (pos.getY() + 1) - rand.nextDouble() * 0.10000000149011612D;
					double d17 = (double) pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d7, d12, d17, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for (int i = 0; i < 3; ++i) {
				double d0 = (double) pos.getX() + rand.nextDouble();
				double d1 = (double) pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
				double d2 = (double) pos.getZ() + rand.nextDouble();
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
	}

    /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that
     * does not fit the other descriptions and will generally cause other things not to connect to the face.
     * 
     * @return an approximation of the form of the given face
     */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
