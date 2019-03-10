package gaia.items;

import gaia.entity.GaiaLootTableList;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBoxHat extends ItemBoxBase {
	public ItemBoxHat(Properties builder) {
		super(builder); //"box_gold");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public ResourceLocation getBoxLoot() {
		return GaiaLootTableList.BOXES_GOLD; //TODO: Generate loot table for hat box
//		int i = random.nextInt(5);
//		switch (i) {
//			case 0:
//				return loot(GaiaItems.ACCESSORY_HEADGEAR);
//			case 1:
//				return loot(GaiaItems.ACCESSORY_HEADGEAR_MOB);
//			case 2:
//				return loot(GaiaItems.ACCESSORY_HEADGEAR_BOLT);
//			case 3:
//				return loot(GaiaItems.ACCESSORY_HEADGEAR_ARROW);
//			case 4:
//				return loot(GaiaItems.ACCESSORY_HEADGEAR_DOLL);
//			case 5:
//				return loot(GaiaItems.ACCESSORY_HEADGEAR_EARS_ELF);
	}
}
