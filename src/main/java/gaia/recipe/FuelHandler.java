package gaia.recipe;

import gaia.Gaia;
import gaia.init.GaiaItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FuelHandler implements IFuelHandler {

    private static final List<Fuel> FUEL_LIST = new ArrayList<>();

    public static void init() {
        Gaia.LOGGER.info("Initializing Fuelstuffs...");

        GameRegistry.registerFuelHandler(new FuelHandler());

        addFuel(GaiaItems.FOOD_COALFISH, 180);
        addFuel(GaiaItems.MISC_SOUL_FIRE, 580);
        addFuel(GaiaItems.MISC_SOUL_FIERY, 1000);
        addFuel(GaiaItems.MISC_FURNACE_FUEL, 3600);
        addFuel(GaiaItems.MISC_GIGA_GEAR, 62000);
    }

    private static void addFuel(Item item, int value) {
        FUEL_LIST.add(new Fuel(new ItemStack(item, 1), value));
    }

    private static void addFuel(Block block, int value) {
        addFuel(Item.getItemFromBlock(block), value);
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        if (Objects.nonNull(stack)) {
            for (Fuel fuel : FUEL_LIST) {
                if (stack.isItemEqual(fuel.fuel)) {
                    return fuel.burnTime;
                }
            }
        }
        return 0;
    }

    private static class Fuel {

        public ItemStack fuel;
        public int burnTime;

        public Fuel(ItemStack fuel, int burnTime) {
            this.fuel = fuel;
            this.burnTime = burnTime;
        }
    }
}
