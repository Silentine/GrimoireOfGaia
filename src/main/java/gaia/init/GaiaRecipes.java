package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

@ObjectHolder(GaiaReference.MOD_ID)
public class GaiaRecipes {

    private static final ResourceLocation GAIA_RESOURCE_GROUP = new ResourceLocation(GaiaReference.MOD_ID);

    @Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
    public static class RegistrationHandler {

        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void registerOreDictEntries(final RegistryEvent.Register<Item> event) {
            OreDictionary.registerOre("nuggetIron", new ItemStack(GaiaItems.Shard, 1, 0));
            OreDictionary.registerOre("nuggetGold", new ItemStack(GaiaItems.Shard, 1, 1));
            OreDictionary.registerOre("nuggetDiamond", new ItemStack(GaiaItems.Shard, 1, 2));
            OreDictionary.registerOre("nuggetEmerald", new ItemStack(GaiaItems.Shard, 1, 3));
            OreDictionary.registerOre("nuggetCopper", new ItemStack(GaiaItems.Shard, 1, 4));
            OreDictionary.registerOre("nuggetSilver", new ItemStack(GaiaItems.Shard, 1, 5));
            OreDictionary.registerOre("cropNetherWart", GaiaItems.FoodNetherWart);
        }

        @SubscribeEvent
        public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
            Gaia.LOGGER.info("Registering recipes...");
            event.getRegistry().register(new ShapelessOreRecipe(GAIA_RESOURCE_GROUP, Items.IRON_INGOT, "nuggetIron", "nuggetIron", "nuggetIron",
                    "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron").setRegistryName("nugget_iron"));
            event.getRegistry().register(new ShapelessOreRecipe(GAIA_RESOURCE_GROUP, Items.GOLD_INGOT, "nuggetGold", "nuggetGold", "nuggetGold",
                    "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold").setRegistryName("nugget_gold"));
            event.getRegistry()
                    .register(new ShapelessOreRecipe(GAIA_RESOURCE_GROUP, Items.DIAMOND, "nuggetDiamond", "nuggetDiamond", "nuggetDiamond",
                            "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond")
                                    .setRegistryName("nugget_diamond"));
            event.getRegistry()
                    .register(new ShapelessOreRecipe(GAIA_RESOURCE_GROUP, Items.EMERALD, "nuggetEmerald", "nuggetEmerald", "nuggetEmerald",
                            "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald")
                                    .setRegistryName("nugget_emerald"));
            addFurnaceRecipes();
            addBrews();
            Gaia.LOGGER.info("Recipe registration complete.");
        }
    }

    /**
     * Registers crafting recipes
     *
     * @see FurnaceRecipes
     */
    public static void addFurnaceRecipes() {
        GameRegistry.addSmelting(GaiaItems.BoxIron, new ItemStack(GaiaItems.MiscExperience, 1, 0), 0.1F);
        GameRegistry.addSmelting(GaiaItems.BoxGold, new ItemStack(GaiaItems.MiscExperience, 1, 1), 0.1F);
        GameRegistry.addSmelting(GaiaItems.BoxDiamond, new ItemStack(GaiaItems.MiscExperience, 1, 2), 0.1F);
        GameRegistry.addSmelting(GaiaItems.MiscFur, new ItemStack(Items.LEATHER), 0.35F);
    }

    public static ItemStack getType(PotionType type) {
        return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), type);
    }

    /**
     * Registers Brewing ingredient recipes
     *
     * @see PotionHelper
     */
    public static void addBrews() {
        BrewingRecipeRegistry.addRecipe(getType(PotionTypes.WATER), new ItemStack(GaiaItems.FoodNetherWart, 1, 0), getType(PotionTypes.AWKWARD));
    }
}
