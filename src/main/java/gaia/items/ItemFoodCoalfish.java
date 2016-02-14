package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemFoodCoalfish extends ItemFood {
	String texture;

	public ItemFoodCoalfish(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.FoodCoalfish");
		this.setCreativeTab(Gaia.tabGaia);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocalFormatted("text.GrimoireOfGaia.FuelForSeconds", new Object[]{Integer.valueOf(180)}));
	}

	/*public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}*/
}
