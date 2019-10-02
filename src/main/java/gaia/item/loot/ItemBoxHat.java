package gaia.item.loot;

import gaia.init.GaiaLootTables;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBoxHat extends ItemBoxBase {
	public ItemBoxHat(Properties builder) {
		super(builder);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	public ResourceLocation getBoxLoot() {
		return GaiaLootTables.BOXES_GOLD; //TODO: Generate loot table for hat box
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
