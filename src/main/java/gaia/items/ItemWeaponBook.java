package gaia.items;

import gaia.CreativeTabGaia;
import gaia.Gaia;
import gaia.GaiaReference;
import gaia.helpers.ModelLoaderHelper;
import gaia.init.GaiaItems;
import gaia.proxy.IClientRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponBook extends ItemSword implements IClientRegister {

	public ItemWeaponBook(ToolMaterial material, String name) {
		super(material);

		setCreativeTab(CreativeTabGaia.INSTANCE);
		setRegistryName(GaiaReference.MOD_ID, name);
		setTranslationKey(GaiaReference.MOD_ID + "." + name);
		Gaia.proxy.addClientRegister(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == GaiaItems.MISC_QUILL;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this);
	}
}
