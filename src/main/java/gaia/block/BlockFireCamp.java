package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockFireCamp extends BlockBase {

	public BlockFireCamp(Properties builder) {
		super(builder.lightValue(14).hardnessAndResistance(0.0f).sound(SoundType.CLOTH).tickRandomly().noDrops());
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.empty();
	}

	@Override
	public int tickRate(IWorldReader worldIn) {
		return 30;
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if(rand.nextInt(100) < 10) {
			if(!worldIn.getBlockState(pos.down()).isSolid()){
				worldIn.removeBlock(pos.down(), false);
			}
		}
	}

	protected boolean canDie(World worldIn, BlockPos pos) {
		return worldIn.isRainingAt(pos) || worldIn.isRainingAt(pos.west()) || worldIn.isRainingAt(pos.east()) || worldIn.isRainingAt(pos.north()) || worldIn.isRainingAt(pos.south());
	}

	public boolean requiresUpdates() {
		return false;
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean p_220069_6_) {
		if (!worldIn.getBlockState(pos.down()).isSolid()) {
			worldIn.removeBlock(pos, false);
		}
	}

	public boolean canCatchFire(IBlockReader world, BlockPos pos, Direction face) {
		return world.getBlockState(pos).isFlammable(world, pos, face);
	}

	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(24) == 0) {
			worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
		}

		if (worldIn.getBlockState(pos.down()).isSolidSide(worldIn, pos.down(), Direction.UP) && !this.canCatchFire(worldIn, pos.down(), Direction.UP)) {
			if (this.canCatchFire(worldIn, pos.west(), Direction.EAST)) {
				for(int j = 0; j < 2; ++j) {
					double x = (double)pos.getX() + rand.nextDouble() * (double)0.1F;
					double y = (double)pos.getY() + rand.nextDouble();
					double z = (double)pos.getZ() + rand.nextDouble();
					campfireSmoke(worldIn, new BlockPos(x, y+0.5, z), false);
				}
			}

			if (this.canCatchFire(worldIn, pos.east(), Direction.WEST)) {
				for(int k = 0; k < 2; ++k) {
					double x = (double)(pos.getX() + 1) - rand.nextDouble() * (double)0.1F;
					double y = (double)pos.getY() + rand.nextDouble();
					double z = (double)pos.getZ() + rand.nextDouble();
					campfireSmoke(worldIn, new BlockPos(x, y+0.5, z), false);
				}
			}

			if (this.canCatchFire(worldIn, pos.north(), Direction.SOUTH)) {
				for(int l = 0; l < 2; ++l) {
					double x = (double)pos.getX() + rand.nextDouble();
					double y = (double)pos.getY() + rand.nextDouble();
					double z = (double)pos.getZ() + rand.nextDouble() * (double)0.1F;
					campfireSmoke(worldIn, new BlockPos(x, y+0.5, z), false);
				}
			}

			if (this.canCatchFire(worldIn, pos.south(), Direction.NORTH)) {
				for(int i1 = 0; i1 < 2; ++i1) {
					double x = (double)pos.getX() + rand.nextDouble();
					double y = (double)pos.getY() + 1 + rand.nextDouble();
					double z = (double)(pos.getZ() + 1) - rand.nextDouble() * (double)0.1F;
					campfireSmoke(worldIn, new BlockPos(x, y+0.5, z), false);
				}
			}

			if (this.canCatchFire(worldIn, pos.up(), Direction.DOWN)) {
				for(int j1 = 0; j1 < 2; ++j1) {
					double x = (double)pos.getX() + rand.nextDouble();
					double y = (double)(pos.getY() + 1) - rand.nextDouble() * (double)0.1F;
					double z = (double)pos.getZ() + rand.nextDouble();
					campfireSmoke(worldIn, new BlockPos(x, y+0.5, z), false);
				}
			}
		} else {
			for(int i = 0; i < 3; ++i) {
				double x = (double)pos.getX() + rand.nextDouble();
				double y = (double)pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
				double z = (double)pos.getZ() + rand.nextDouble();
				campfireSmoke(worldIn, new BlockPos(x, y+0.5, z), false);
			}
		}
	}

	public static void campfireSmoke(World worldIn, BlockPos pos, boolean isSignal) {
		Random rand = worldIn.getRandom();
		BasicParticleType particle = isSignal ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.CAMPFIRE_COSY_SMOKE;
		worldIn.addParticle(particle, true, (double)pos.getX() + 0.5D + rand.nextDouble() / 3.0D * (double)(rand.nextBoolean() ? 1 : -1), (double)pos.getY() + rand.nextDouble() + rand.nextDouble(), (double)pos.getZ() + 0.5D + rand.nextDouble() / 3.0D * (double)(rand.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
	}
}
