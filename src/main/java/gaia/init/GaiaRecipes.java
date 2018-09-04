package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@SuppressWarnings("unused") // used through reflection code
@ObjectHolder(GaiaReference.MOD_ID)
public class GaiaRecipes {
	private GaiaRecipes() {
	}

	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class RegistrationHandler {
		private RegistrationHandler() {
		}

		@SubscribeEvent
		public static void registerRecipes(final RegistryEvent.Register<IRecipe> event) {
			Gaia.LOGGER.info("Registering recipes...");
			addFurnaceRecipes();
			addBrews();
			Gaia.LOGGER.info("Recipe registration complete.");
		}

		/**
		 * Registers crafting recipes
		 *
		 * @see FurnaceRecipes
		 */
		private static void addFurnaceRecipes() {
			GameRegistry.addSmelting(GaiaItems.BOX_IRON, new ItemStack(GaiaItems.MISC_EXPERIENCE, 1, 0), 0.1F);
			GameRegistry.addSmelting(GaiaItems.BOX_GOLD, new ItemStack(GaiaItems.MISC_EXPERIENCE, 1, 1), 0.1F);
			GameRegistry.addSmelting(GaiaItems.BOX_DIAMOND, new ItemStack(GaiaItems.MISC_EXPERIENCE, 1, 2), 0.1F);
			GameRegistry.addSmelting(GaiaItems.MISC_FUR, new ItemStack(Items.LEATHER), 0.35F);
		}

		private static ItemStack getType(PotionType type) {
			return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), type);
		}

		/**
		 * Registers Brewing ingredient recipes
		 *
		 * @see PotionHelper
		 */
		private static void addBrews() {
			BrewingRecipeRegistry.addRecipe(getType(PotionTypes.WATER), new ItemStack(GaiaItems.FOOD_NETHER_WART, 1, 0), getType(PotionTypes.AWKWARD));
		}
	}
}
