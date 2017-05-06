package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWeaponProp extends Item {

	public ItemWeaponProp(String name) {
		this.maxStackSize = 1;
		this.setHasSubtypes(true);
		this.setCreativeTab(Gaia.tabGaia);
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.Prop.tag")));
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase host) {
		EntityPlayer player = host instanceof EntityPlayer ? (EntityPlayer)host : null;
		
		if (!player.capabilities.isCreativeMode) {
			--stack.stackSize;
		}
		
		return true;
	}

	public boolean isFull3D() {
		return true;
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 6; i ++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
}
