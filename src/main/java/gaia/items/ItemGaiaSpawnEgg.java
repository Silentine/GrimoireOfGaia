package gaia.items;

import gaia.ItemGroupGaia;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpawnEgg;

public class ItemGaiaSpawnEgg extends ItemSpawnEgg {
    public ItemGaiaSpawnEgg(EntityType<?> typeIn, int primaryColorIn, int secondaryColorIn, Item.Properties builder) {
        super(typeIn, primaryColorIn, secondaryColorIn, builder.group(ItemGroupGaia.INSTANCE));
    }
}
