package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMiscGigaGear extends Item {
	String texture;

	public ItemMiscGigaGear(String texture) {
		this.texture = texture;
		this.setMaxStackSize(1);
		this.setUnlocalizedName(texture);
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocalFormatted("text.GrimoireOfGaia.FuelForSeconds", new Object[]{Integer.valueOf(62000)}));
		par3List.add(EnumChatFormatting.ITALIC + (StatCollector.translateToLocal("item.GrimoireOfGaia.MiscGigaGear.desc")));
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}
}
