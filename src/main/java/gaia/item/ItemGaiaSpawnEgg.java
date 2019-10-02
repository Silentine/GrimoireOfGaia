package gaia.item;

import gaia.init.GaiaItemGroups;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;

import java.util.ArrayList;
import java.util.Collection;

public class ItemGaiaSpawnEgg extends SpawnEggItem {
    public ItemGaiaSpawnEgg(EntityType<?> typeIn, int primaryColorIn, int secondaryColorIn, Item.Properties builder) {
        super(typeIn, primaryColorIn, secondaryColorIn, builder);
    }

    @Override
    public Collection<ItemGroup> getCreativeTabs() {
        ArrayList<ItemGroup> tabs = new ArrayList<>();
        tabs.add(GaiaItemGroups.ITEMS);
        tabs.add(GaiaItemGroups.SPAWN_EGGS);
        return tabs;
    }
}
