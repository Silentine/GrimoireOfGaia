package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.item.ItemFood;

public class ItemFoodMeat extends ItemFood {

    public ItemFoodMeat(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }
}
