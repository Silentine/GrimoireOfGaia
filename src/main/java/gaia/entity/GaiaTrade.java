package gaia.entity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.village.MerchantRecipe;

public class GaiaTrade extends MerchantRecipe {

    public GaiaTrade(NBTTagCompound tag) {
        super(tag);
    }

    public GaiaTrade(ItemStack buy, ItemStack sell) {
        super(buy, sell);
    }

    public GaiaTrade(ItemStack buy, ItemStack buy2, ItemStack sell) {
        super(buy, buy2, sell);
    }

    @Override
    public boolean isRecipeDisabled() {
        return false;
    }
}
