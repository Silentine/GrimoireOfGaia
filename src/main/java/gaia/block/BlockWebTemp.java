package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.Particles;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * @see BlockFire
 * @see BlockWeb
 */
public class BlockWebTemp extends BlockBase {

	public BlockWebTemp(Block.Properties builder) {
		super(builder.lightValue(1).hardnessAndResistance(0.2F).needsRandomTick().doesNotBlockMovement());
	}

	/**
	 * Called When an Entity Collided with the Block
	 */
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		entityIn.setInWeb();
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
	    return VoxelShapes.fullCube();
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/**
	 * Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via Block.removedByPlayer
	 */
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			player.addStat(StatList.BLOCK_MINED.get(this));
			spawnAsEntity(worldIn, pos, new ItemStack(this));
		} else {
			super.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}

	/**
	 * Get the geometry of the queried face at the given position and state. This is used to decide whether things like buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
	 * <p>
	 * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that does not fit the other descriptions and will generally cause other things not to connect to the face.
	 * 
	 * @return an approximation of the form of the given face
	 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
	
	public void tick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		worldIn.destroyBlock(pos, false);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		super.randomTick(state, worldIn, pos, rand);
		
		if (rand.nextInt(10) == 0) {
			worldIn.spawnParticle(Particles.MYCELIUM, (double) ((float) pos.getX() + rand.nextFloat()), (double) ((float) pos.getY() + 1.1F), (double) ((float) pos.getZ() + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
		}
	}
}
