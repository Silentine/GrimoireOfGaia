package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BlockWebTemp extends BlockBase {

	public BlockWebTemp(Block.Properties builder) {
		super(builder.lightValue(1).hardnessAndResistance(0.2F).tickRandomly().doesNotBlockMovement());
	}

	/**
	 * Called When an Entity Collided with the Block
	 */
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setMotionMultiplier(state, new Vec3d(0.25D, (double)0.05F, 0.25D));
	}

	public void tick(World worldIn, BlockPos pos, BlockState state, Random rand) {
		worldIn.destroyBlock(pos, false);
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.randomTick(state, worldIn, pos, rand);

		if (rand.nextInt(10) == 0) {
			worldIn.addParticle(ParticleTypes.MYCELIUM, (double) ((float) pos.getX() + rand.nextFloat()), (double) ((float) pos.getY() + 1.1F), (double) ((float) pos.getZ() + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
		}
	}
}
