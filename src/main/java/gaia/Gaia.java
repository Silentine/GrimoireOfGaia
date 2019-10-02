package gaia;

import gaia.client.GaiaClientHandler;
import gaia.config.GaiaConfig;
import gaia.handlers.SpawnHandler;
import gaia.init.GaiaRecipes;
import gaia.init.GaiaSpawning;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GaiaReference.MOD_ID)
public class Gaia {

    public static final Logger LOGGER = LogManager.getLogger();

	public Gaia() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GaiaConfig.commonSpec, "grimoireofgaia.toml");
        FMLJavaModLoadingContext.get().getModEventBus().register(GaiaConfig.class);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        // Register ourselves for server, registry and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(new SpawnHandler());
	}
	
    private void setup(final FMLCommonSetupEvent event)
    {
		Gaia.LOGGER.info("Registering brewing recipe");
        GaiaRecipes.addBrews();

		if (GaiaConfig.COMMON.enableSpawn.get()) {
            GaiaSpawning.register();
		}
    }
    
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
    	//InterModComms.sendTo("forge", "helloworld", () -> { LOGGER.info("Hello world"); return "Hello world";});

//		GaiaItems.RegistrationHandler.registerOres(); // Not implemented

//		if (ModList.get().isLoaded("thaumcraft")) {
//			MinecraftForge.EVENT_BUS.register(AspectsItems.class);
//			MinecraftForge.EVENT_BUS.register(AspectsEntities.class);
//		}
    }

    private void processIMC(final InterModProcessEvent event)
    {
    	//some example code to receive and process InterModComms from other mods
    	//LOGGER.info("Got IMC", event.getIMCStream().
    	//         map(m->m.getMessageSupplier().get()).
    	//         collect(Collectors.toList()));
    }

    public void setupClient(final FMLClientSetupEvent event) {
        GaiaClientHandler.registerRenders();
    }
}
