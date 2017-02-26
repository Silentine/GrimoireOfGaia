package gaia.items;

import gaia.init.GaiaItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class GaiaItemHandlerFuel implements IFuelHandler {

	//20 ticks = 1 second
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == GaiaItems.FoodCoalfish) {
			return 3600;
		}
		
		if (fuel.getItem() == GaiaItems.MiscFurnaceFuel) {
			return 3600;
		}
		
		if (fuel.getItem() == GaiaItems.MiscSoulFire) {
			return 11600;
		}
		
		if (fuel.getItem() == GaiaItems.MiscSoulFiery) {
			return 20000;
		}
		
		if (fuel.getItem() == GaiaItems.MiscGigaGear) {
			return 1240000;
		}
		return 0;
	}
}
