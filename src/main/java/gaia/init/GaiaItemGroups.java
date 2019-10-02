package gaia.init;

import gaia.GaiaReference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GaiaItemGroups {
    public static final ItemGroup ITEMS = (new ItemGroup( GaiaReference.MOD_ID + ".items") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(GaiaItems.MISC_BOOK);
        }
    }).setTabPath("grimoireofgaia_items");

    public static final ItemGroup BLOCKS = (new ItemGroup( GaiaReference.MOD_ID + ".blocks") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(GaiaBlocks.DOLL_MAID);
        }
    }).setTabPath("grimoireofgaia_blocks");

    public static final ItemGroup SPAWN_EGGS = (new ItemGroup( GaiaReference.MOD_ID + ".spawn_eggs") {
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Items.BAT_SPAWN_EGG);
        }
    }).setTabPath("grimoireofgaia_spawn_eggs");
}
