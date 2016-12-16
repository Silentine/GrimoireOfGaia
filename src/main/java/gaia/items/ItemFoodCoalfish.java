package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemFoodCoalfish extends ItemFood {

	public ItemFoodCoalfish(int par2, float par3, boolean par4, String name) {
		super(par2, par3, par4);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.FuelForSeconds", new Object[]{Integer.valueOf(180)}));
	}
}
