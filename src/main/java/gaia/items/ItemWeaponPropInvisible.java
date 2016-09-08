package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponPropInvisible extends Item {
	String texture;

	public ItemWeaponPropInvisible(String texture) {
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.WeaponPropInvisible");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.WeaponProp.desc"));
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.WeaponPropInvisible.desc"));
	}

	public boolean isFull3D() {
		return true;
	}
}
