package gaia;

import gaia.client.GaiaClientHandler;
import gaia.config.GaiaConfig;
import gaia.handlers.SpawnHandler;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaRecipes;
import gaia.init.GaiaSpawning;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GaiaReference.MOD_ID)
public class Gaia {

    public static final Logger LOGGER = LogManager.getLogger();

	public Gaia() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GaiaConfig.commonSpec, "GrimoireOfGaia.toml");
        eventBus.register(GaiaConfig.class);

        GaiaItems.ITEMS.register(eventBus);
        GaiaBlocks.BLOCKS.register(eventBus);
        GaiaEntities.ENTITIES.register(eventBus);

		eventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(new SpawnHandler());

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            eventBus.addListener(GaiaClientHandler::registerRenders);
            eventBus.addListener(GaiaClientHandler::registerItemColors);
        });
	}
	
    private void setup(final FMLCommonSetupEvent event)
    {
		Gaia.LOGGER.info("Registering brewing recipe");
        GaiaRecipes.addBrews();

		if (GaiaConfig.COMMON.enableSpawn.get()) {
            GaiaSpawning.register();
		}
    }
}
