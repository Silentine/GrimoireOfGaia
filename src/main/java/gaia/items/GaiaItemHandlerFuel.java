package gaia.items;

import gaia.init.GaiaItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class GaiaItemHandlerFuel implements IFuelHandler {

	//20 = 1 second
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == GaiaItem.FoodCoalfish) {
			return 3600;
		}
		
		if (fuel.getItem() == GaiaItem.MiscFurnaceFuel) {
			return 3600;
		}
		
		if (fuel.getItem() == GaiaItem.MiscSoulFire) {
			return 11600;
		}
		
		if (fuel.getItem() == GaiaItem.MiscSoulFiery) {
			return 20000;
		}
		
		if (fuel.getItem() == GaiaItem.MiscGigaGear) {
			return 1240000;
		}
		return 0;
	}
}
