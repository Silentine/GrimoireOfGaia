package gaia.block;

import gaia.CreativeTabGaia;
import gaia.Gaia;
import gaia.GaiaReference;
import gaia.helpers.ModelLoaderHelper;
import gaia.proxy.IClientRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

class BlockBase extends Block implements IClientRegister {
	public BlockBase(Material materialIn, String blockName) {
		super(materialIn);
		setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, blockName));
		setTranslationKey(GaiaReference.MOD_ID + "." + blockName);
		setCreativeTab(CreativeTabGaia.INSTANCE);
		Gaia.proxy.addClientRegister(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this);
	}
}
