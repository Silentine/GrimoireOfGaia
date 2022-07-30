package gaia.datagen;

import gaia.datagen.client.GaiaBlockstates;
import gaia.datagen.client.GaiaItemModels;
import gaia.datagen.client.GaiaLanguage;
import gaia.datagen.client.GaiaSoundProvider;
import gaia.datagen.server.GaiaBlockTags;
import gaia.datagen.server.GaiaEntityTags;
import gaia.datagen.server.GaiaItemTags;
import gaia.datagen.server.GaiaLoot;
import gaia.datagen.server.GaiaRecipes;
import gaia.datagen.server.GaiaUncheckedLoot;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GaiaDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new GaiaRecipes(generator));
			generator.addProvider(new GaiaLoot(generator));
			generator.addProvider(new GaiaUncheckedLoot(generator));
//			generator.addProvider(new Recipes(generator));
			BlockTagsProvider provider;
			generator.addProvider(provider = new GaiaBlockTags(generator, helper));
			generator.addProvider(new GaiaItemTags(generator, provider, helper));
			generator.addProvider(new GaiaEntityTags(generator, helper));
		}
		if (event.includeClient()) {
			generator.addProvider(new GaiaLanguage(generator));
			generator.addProvider(new GaiaSoundProvider(generator, helper));
//			generator.addProvider(new GaiaBlockModels(generator, helper));
			generator.addProvider(new GaiaItemModels(generator, helper));
			generator.addProvider(new GaiaBlockstates(generator, helper));
		}
	}
}
