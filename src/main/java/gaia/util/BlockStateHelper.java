package gaia.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/** 
 * A library for simplifying blockstate interactions 
 **/
public class BlockStateHelper {

	/**
	 * Extract an State ID from a blockstate
	 **/
	public static int returnID(World world, BlockPos pos1 ) {
		int GET = 0;		
		GET =(world.getBlockState(pos1).getBlock()).getStateId(world.getBlockState(pos1));		
		return GET;
	}

	/**
	 * Extract a Blockstate from an State ID
	 **/
	public static IBlockState returnState(int id) {
		int j = id & 4095;
		int k = id >> 12 & 15;
		return Block.getBlockById(j).getStateFromMeta(k);
	}

	/**
	 * Extracts a Block from an State ID
	 **/
	public static Block returnBlock(int id) {
		int j = id & 4095;
		int k = id >> 12 & 15;
		return Block.getBlockById(j);
	}

	/**
	 * Extracts a Meta value from a State ID
	 **/
	public static int returnMeta(int id) {
		int j = id & 4095;
		int k = id >> 12 & 15;
		return k;
	}

	/**
	 * Extracts a Block from a State
	 **/
	public static Block getBlockfromState (World world, BlockPos pos1) {
		Block blocky = Blocks.AIR;

		int ID = BlockStateHelper.returnID(world, pos1);
		blocky = BlockStateHelper.returnBlock(ID);

		return blocky;
	}

	/**
	 * Extract a Meta value from a state
	 **/
	public static int getMetafromState (World world, BlockPos pos1) {
		int meta = 0;

		int ID = BlockStateHelper.returnID(world, pos1);
		meta = BlockStateHelper.returnMeta(ID);

		return meta;
	}

	/**
	 * Extracts a block ID from an State ID
	 **/
	public static int returnBlock_ID(int id) {
		int j = id & 4095;
		int k = id >> 12 & 15;
		return j;
	}

	/**
	 * Extract a Block ID 
	 **/
	public static int getblock_ID(World world, BlockPos pos1) {
		int id;
		id = BlockStateHelper.returnBlock_ID(BlockStateHelper.returnID(world, pos1));
		return id;
	}	

	/**
	 * Updates a blockstate in the world using meta values
	 **/
	public static void setStatefromMeta(World world, BlockPos pos, int meta, int flags) {
		Block block = getBlockfromState(world, pos);
		int ID = returnID(world, pos);

		IBlockState state = returnState(meta);

		IBlockState state2 =  block.getStateFromMeta(meta);
		world.setBlockState(pos, state2, flags);
		return; 
	}
}
