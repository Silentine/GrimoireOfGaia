package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnTame extends Item {

	public ItemSpawnTame(String name) {
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.grimoireofgaia.desc")));
		tooltip.add(I18n.translateToLocal("item.GrimoireOfGaia.SpawnTame.desc"));
		tooltip.add(TextFormatting.ITALIC + I18n.translateToLocal("item.GrimoireOfGaia.SpawnTame2.desc"));
	}
}
