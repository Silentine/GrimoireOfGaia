package gaia.items;

import gaia.CreativeTabGaia;
import gaia.Gaia;
import gaia.GaiaReference;
import gaia.helpers.ModelLoaderHelper;
import gaia.proxy.IClientRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item implements IClientRegister {
	public ItemBase(String name) {
		setRegistryName(GaiaReference.MOD_ID, name);
		setTranslationKey(GaiaReference.MOD_ID + "." + name);
		setCreativeTab(CreativeTabGaia.INSTANCE);
		Gaia.proxy.addClientRegister(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this);
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		return getHasSubtypes() ? getTranslationKey() + "_" + stack.getItemDamage() : getTranslationKey();
	}
}
