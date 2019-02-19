package gaia.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemChestJungle extends ItemBoxBase {
	public ItemChestJungle(Item.Properties builder) {
		super(builder.maxStackSize(64)); //"chest");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public ResourceLocation getBoxLoot() {
		return LootTableList.CHESTS_JUNGLE_TEMPLE;
	}
}
