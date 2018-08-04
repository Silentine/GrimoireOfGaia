package gaia.block;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

class BlockBase extends Block {
	BlockBase(Material materialIn, String blockName) {
		super(materialIn);
		setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, blockName));
		setUnlocalizedName(GaiaReference.MOD_ID + "." + blockName);
		setCreativeTab(CreativeTabGaia.INSTANCE);
	}
}
