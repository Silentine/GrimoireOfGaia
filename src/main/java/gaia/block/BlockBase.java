package gaia.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

class BlockBase extends Block {
	BlockBase(Block.Properties builder) {
		super(builder);
//		setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, blockName));
//		setUnlocalizedName(GaiaReference.MOD_ID + "." + blockName);
//		setCreativeTab(CreativeTabGaia.INSTANCE);
	}

	//
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public void registerClient() {
//		ModelLoaderHelper.registerItem(this);
//	}
}
