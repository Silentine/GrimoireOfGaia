package gaia.datagen;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import gaia.GrimoireOfGaia;
import gaia.datagen.client.GaiaBlockModels;
import gaia.datagen.client.GaiaBlockstates;
import gaia.datagen.client.GaiaItemModels;
import gaia.datagen.client.GaiaLanguage;
import gaia.datagen.client.GaiaSoundProvider;
import gaia.datagen.client.compat.GaiaPatchouliProvider;
import gaia.datagen.server.GaiaAdvancementProvider;
import gaia.datagen.server.GaiaBiomeModifiers;
import gaia.datagen.server.GaiaBlockTags;
import gaia.datagen.server.GaiaEntityTags;
import gaia.datagen.server.GaiaItemTags;
import gaia.datagen.server.GaiaLoot;
import gaia.datagen.server.GaiaRecipes;
import gaia.datagen.server.GaiaUncheckedLoot;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GaiaDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		final RegistryOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy());
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(true, new GaiaAdvancementProvider(generator, helper));
			generator.addProvider(true, new GaiaRecipes(generator));
			generator.addProvider(true, new GaiaLoot(generator));
			generator.addProvider(true, new GaiaUncheckedLoot(generator));
			BlockTagsProvider provider;
			generator.addProvider(true, provider = new GaiaBlockTags(generator, helper));
			generator.addProvider(true, new GaiaItemTags(generator, provider, helper));
			generator.addProvider(true, new GaiaEntityTags(generator, helper));

			generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(
					generator, helper, GrimoireOfGaia.MOD_ID, ops, ForgeRegistries.Keys.BIOME_MODIFIERS,
					GaiaBiomeModifiers.getBiomeModifiers(ops)
			));
		}
		if (event.includeClient()) {
			generator.addProvider(true, new GaiaLanguage(generator));
			generator.addProvider(true, new GaiaSoundProvider(generator, helper));
			generator.addProvider(true, new GaiaBlockModels(generator, helper));
			generator.addProvider(true, new GaiaItemModels(generator, helper));
			generator.addProvider(true, new GaiaBlockstates(generator, helper));
			if (ModList.get().isLoaded("patchouli"))
				generator.addProvider(true, new GaiaPatchouliProvider(generator));
		}
	}
}
