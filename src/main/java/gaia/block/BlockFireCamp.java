package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

import java.util.Random;

public class BlockFireCamp extends BlockBase {

	public BlockFireCamp(Properties builder) {
		super(builder.lightValue(14).hardnessAndResistance(0.0f).sound(SoundType.CLOTH).needsRandomTick());
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return VoxelShapes.empty();
	}

	@Override
	public int quantityDropped(IBlockState state, Random random) {
		return 0;
	}

	@Override
	public int tickRate(IWorldReaderBase worldIn) {
		return 30;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	protected boolean canDie(World worldIn, BlockPos pos) {
		return worldIn.isRainingAt(pos) || worldIn.isRainingAt(pos.west()) || worldIn.isRainingAt(pos.east()) || worldIn.isRainingAt(pos.north()) || worldIn.isRainingAt(pos.south());
	}

	public boolean requiresUpdates() {
		return false;
	}

	@Override
	public boolean isCollidable() {
		return false;
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.getBlockState(pos.down()).isTopSolid()) {
			worldIn.removeBlock(pos);
		}
	}

	public boolean canCatchFire(IBlockReader world, BlockPos pos, EnumFacing face) {
		return world.getBlockState(pos).isFlammable(world, pos, face);
	}

	@Override
	public void animateTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(24) == 0) {
			worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
		}

		if (worldIn.getBlockState(pos.down()).getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) != BlockFaceShape.SOLID && !this.canCatchFire(worldIn, pos.down(), EnumFacing.UP)) {
			if (this.canCatchFire(worldIn, pos.west(), EnumFacing.EAST)) {
				for(int j = 0; j < 2; ++j) {
					double d3 = (double)pos.getX() + rand.nextDouble() * (double)0.1F;
					double d8 = (double)pos.getY() + rand.nextDouble();
					double d13 = (double)pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(Particles.LARGE_SMOKE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canCatchFire(worldIn, pos.east(), EnumFacing.WEST)) {
				for(int k = 0; k < 2; ++k) {
					double d4 = (double)(pos.getX() + 1) - rand.nextDouble() * (double)0.1F;
					double d9 = (double)pos.getY() + rand.nextDouble();
					double d14 = (double)pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(Particles.LARGE_SMOKE, d4, d9, d14, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canCatchFire(worldIn, pos.north(), EnumFacing.SOUTH)) {
				for(int l = 0; l < 2; ++l) {
					double d5 = (double)pos.getX() + rand.nextDouble();
					double d10 = (double)pos.getY() + rand.nextDouble();
					double d15 = (double)pos.getZ() + rand.nextDouble() * (double)0.1F;
					worldIn.spawnParticle(Particles.LARGE_SMOKE, d5, d10, d15, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canCatchFire(worldIn, pos.south(), EnumFacing.NORTH)) {
				for(int i1 = 0; i1 < 2; ++i1) {
					double d6 = (double)pos.getX() + rand.nextDouble();
					double d11 = (double)pos.getY() + rand.nextDouble();
					double d16 = (double)(pos.getZ() + 1) - rand.nextDouble() * (double)0.1F;
					worldIn.spawnParticle(Particles.LARGE_SMOKE, d6, d11, d16, 0.0D, 0.0D, 0.0D);
				}
			}

			if (this.canCatchFire(worldIn, pos.up(), EnumFacing.DOWN)) {
				for(int j1 = 0; j1 < 2; ++j1) {
					double d7 = (double)pos.getX() + rand.nextDouble();
					double d12 = (double)(pos.getY() + 1) - rand.nextDouble() * (double)0.1F;
					double d17 = (double)pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(Particles.LARGE_SMOKE, d7, d12, d17, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for(int i = 0; i < 3; ++i) {
				double d0 = (double)pos.getX() + rand.nextDouble();
				double d1 = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
				double d2 = (double)pos.getZ() + rand.nextDouble();
				worldIn.spawnParticle(Particles.LARGE_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
