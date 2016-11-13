package gaia;

import gaia.entity.EntityMobAssist;
import gaia.entity.EntityMobBase;
import gaia.init.Aspects_Entity;
import gaia.init.Aspects_Items;
import gaia.init.GaiaBlock;
import gaia.init.GaiaConfigGeneration;
import gaia.init.GaiaEntity;
import gaia.init.GaiaItem;
import gaia.init.GaiaSpawning;
import gaia.init.Sounds;
import gaia.items.GaiaItemHandlerFuel;
import gaia.proxy.CommonProxy;
import gaia.util.Gaia_Commands;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
		modid = GaiaReference.MOD_ID, 
		name = GaiaReference.MOD_NAME, 
		version = GaiaReference.VERSION,
		guiFactory = GaiaReference.guiFactory,
		dependencies = GaiaReference.DEPENDENCIES
		)

public class Gaia {

	@Instance(GaiaReference.MOD_ID)
	public static Gaia instance = new Gaia();

	@SidedProxy
	(clientSide = GaiaReference.CLIENT_PROXY_CLASS, 
	serverSide = GaiaReference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static final Logger logger = LogManager.getLogger(GaiaReference.MOD_ID);
	public static boolean isBaublesEnabled = false;
	public static boolean isThaumcraftEnabled = false;

	public static CreativeTabs tabGaia = new CreativeTabs("tabGaia") {
		@Override
		public Item getTabIconItem() {
			return GaiaItem.MiscBook;			
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		isBaublesEnabled = Loader.isModLoaded("Baubles");
		if(isBaublesEnabled)logger.info("Loading With Baubles");
		else{logger.info("Loading Without Baubles");}

		isThaumcraftEnabled = Loader.isModLoaded("Thaumcraft");
		if(isThaumcraftEnabled)logger.info("Loading With Thaumcraft");
		else{logger.info("Loading Without Thaumcraft");}

		GaiaConfigGeneration.configOptions(event);	
		logger.info("Registering Items");
		GaiaBlock.init();
		GaiaBlock.register();
		GaiaItem.init();
		GaiaItem.register();
		logger.info("Items Registered");
		GaiaItem.oreRegistration();
		
		
		Sounds.Sounds_Init();
		proxy.registerItemsRender();
		proxy.registerBlocksRender();
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		GameRegistry.registerFuelHandler(new GaiaItemHandlerFuel());
		GaiaItem.addRecipes();
		GaiaItem.addBrews();
		
		logger.info("Registering Entities");
		GaiaEntity.register();
		
		if(isThaumcraftEnabled){
			logger.info("Registering Aspects");	
			Aspects_Entity.Entity_Aspects();
			Aspects_Items.Item_Aspects();
			logger.info("Aspects Successfully Loaded");	
		}

		proxy.registerRenders();    	
		
		MinecraftForge.EVENT_BUS.register(this);
		
		if(ConfigGaia.Biome_Tweaks)GaiaSpawning.Biome_Tweaks();
		
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new Gaia_Commands());
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.getModID().equals(GaiaReference.MOD_ID))
			GaiaConfigGeneration.syncConfig();
	}
	/** Prevents vanilla mobs from spawning for testing **/
	@SubscribeEvent
	public void Gaia_Spawn_Debug(CheckSpawn e){
		if(ConfigGaia.Spawn_Debug_Mode){
			if(e.getEntity() instanceof EntityMobAssist ||
					e.getEntity() instanceof EntityMobBase){
				e.setResult(Event.Result.ALLOW);
			}
			else{
				e.setResult(Event.Result.DENY);
			}
		}
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//Moved Spawning registry to last since forge doesn't auto-generate sub "M' biomes until late
		GaiaSpawning.register();
	}
}
