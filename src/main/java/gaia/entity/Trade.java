package gaia.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.village.MerchantRecipe;

public class Trade extends MerchantRecipe {
	
	public Trade(NBTTagCompound tag) {
		super(tag);
	}
	
	public Trade(ItemStack buy, ItemStack sell) {
		super(buy, sell);
	}
	
	public Trade(ItemStack buy, ItemStack buy2, ItemStack sell) {
		super(buy, buy2, sell);
	}
	
	@Override
	public boolean isRecipeDisabled() {
		return false;
	}
}