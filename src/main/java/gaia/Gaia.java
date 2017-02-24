package gaia;

import gaia.init.Aspects_Entity;
import gaia.init.Aspects_Items;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaConfigGeneration;
import gaia.init.GaiaEntity;
import gaia.init.GaiaItems;
import gaia.init.GaiaSpawning;
import gaia.init.Sounds;
import gaia.items.GaiaItemHandlerFuel;
import gaia.proxy.CommonProxy;
import gaia.util.Gaia_Commands;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod 	(
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
			return GaiaItems.MiscBook;			
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
		GaiaBlocks.init();
		GaiaBlocks.register();
		GaiaItems.init();
		GaiaItems.register();
		logger.info("Items Registered");
		GaiaItems.oreRegistration();

		Sounds.Sounds_Init();
		proxy.registerItemsRender();
		proxy.registerBlocksRender();
		proxy.registerHandlers();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		GameRegistry.registerFuelHandler(new GaiaItemHandlerFuel());
		GaiaBlocks.addRecipes();

		GaiaItems.addRecipes();
		GaiaItems.addFurnaceRecipes();
		GaiaItems.addBrews();

		logger.info("Registering Entities");
		GaiaEntity.register();
		logger.info("Entities Registered");

		if(isThaumcraftEnabled){
			logger.info("Registering Aspects");	
			Aspects_Entity.Entity_Aspects();
			Aspects_Items.Item_Aspects();
			logger.info("Aspects Successfully Loaded");	
		}

		proxy.registerRenders();    	

		MinecraftForge.EVENT_BUS.register(this);

		if(GaiaConfig.Biome_Tweaks)
			GaiaSpawning.Biome_Tweaks();
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new Gaia_Commands());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//Moved Spawning registry to last since forge doesn't auto-generate sub "M' biomes until late
		if(GaiaConfig.Enable_Spawn)
			GaiaSpawning.register();
	}
}
