package gaia;

import gaia.entity.EntityMobHostileBase;
import gaia.entity.EntityMobPassive;
import gaia.handlers.DimensionHandler;
import gaia.init.GaiaRecipes;
import gaia.init.GaiaSpawning;
import gaia.proxy.ClientHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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

		 // Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server, registry and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(new DimensionHandler());
        
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
			MinecraftForge.EVENT_BUS.addListener(ClientHandler::registerRenders);
		});
	}
	
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
		Gaia.LOGGER.info("Registering brewing recipe");
        GaiaRecipes.addBrews();
        
		if (GaiaConfig.COMMON.enableSpawn.get()) {
            DeferredWorkQueue.runLater(GaiaSpawning::register);
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

    @SubscribeEvent
    public void onSpawn(final LivingSpawnEvent.CheckSpawn event)
    {
        if (event.getEntity() instanceof EntityMobPassive || event.getEntity() instanceof EntityMobHostileBase) {
            Gaia.LOGGER.debug(event.getEntity().getName().getString() + " is trying to spawn.");
            Gaia.LOGGER.debug(GaiaConfig.COMMON.dimensionBlacklist.get());
            if(!GaiaConfig.COMMON.dimensionBlacklist.get().isEmpty())
            {
                event.setResult(Event.Result.DEFAULT);
                for (String id : GaiaConfig.COMMON.dimensionBlacklist.get()) {
                    if(!id.isEmpty())
                    {
                        int i = Integer.valueOf(id);
                        if (i == event.getWorld().getDimension().getType().getId()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                }
            }
        }
    }
}
