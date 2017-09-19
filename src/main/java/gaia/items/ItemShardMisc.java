package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShardMisc extends Item {

    public ItemShardMisc(String name) {
        this.setHasSubtypes(true);
        this.setRegistryName(GaiaReference.MOD_ID, name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabGaia.INSTANCE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!this.isInCreativeTab(tab)) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + stack.getItemDamage();
    }
}
