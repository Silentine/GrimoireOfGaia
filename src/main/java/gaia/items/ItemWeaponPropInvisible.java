package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponPropInvisible extends Item {
	String texture;

	public ItemWeaponPropInvisible(String texture) {
		this.texture = texture;
		this.setUnlocalizedName(texture);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("item.GrimoireOfGaia.WeaponProp.desc"));
		par3List.add(StatCollector.translateToLocal("item.GrimoireOfGaia.WeaponPropInvisible.desc"));
	}

	public boolean isFull3D() {
		return true;
	}
}
