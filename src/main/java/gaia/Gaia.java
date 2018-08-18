package gaia;

import gaia.command.CommandBiome;
import gaia.command.CommandSpawn;
import gaia.compat.thaumcraft.AspectsEntities;
import gaia.compat.thaumcraft.AspectsItems;
import gaia.datafixes.BlockIdFixer;
import gaia.datafixes.BustTileIdFixer;
import gaia.datafixes.EntityIdFixer;
import gaia.datafixes.ItemIdFixer;
import gaia.init.GaiaItems;
import gaia.init.GaiaSpawning;
import gaia.proxy.CommonProxy;
import net.minecraft.util.datafix.FixTypes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ModFixs;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static gaia.GaiaReference.MOD_ID;

@Mod(modid = MOD_ID, name = GaiaReference.MOD_NAME, version = GaiaReference.VERSION, dependencies = GaiaReference.DEPENDENCIES)
public class Gaia {

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@SidedProxy(clientSide = GaiaReference.CLIENT_PROXY_CLASS, serverSide = GaiaReference.SERVER_PROXY_CLASS)
	@SuppressWarnings("squid:S1444")
	public static CommonProxy proxy;

	private static final int DATA_FIXER_VERSION = 3;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerHandlers();

		proxy.registerRenders();

		if (Loader.isModLoaded("thaumcraft")) {
			MinecraftForge.EVENT_BUS.register(AspectsItems.class);
			MinecraftForge.EVENT_BUS.register(AspectsEntities.class);
		}
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		GaiaItems.RegistrationHandler.registerOres();

		MinecraftForge.EVENT_BUS.register(this);

		if (GaiaConfig.DEBUG.biomeTweaks) {
			GaiaSpawning.biomeTweaks();
		}

		proxy.registerTileRenders();
		proxy.registerLayerRenders();

		ModFixs fixes = FMLCommonHandler.instance().getDataFixer().init(MOD_ID, DATA_FIXER_VERSION);
		fixes.registerFix(FixTypes.BLOCK_ENTITY, new BustTileIdFixer());
		fixes.registerFix(FixTypes.ITEM_INSTANCE, new ItemIdFixer());
		fixes.registerFix(FixTypes.ENTITY, new EntityIdFixer());
		fixes.registerFix(FixTypes.ITEM_INSTANCE, new BlockIdFixer());
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		if (GaiaConfig.DEBUG.debugCommands) {
			event.registerServerCommand(new CommandBiome());
			event.registerServerCommand(new CommandSpawn());
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Moved Spawning registry to last since forge doesn't auto-generate sub
		// "M' biomes until late
		if (GaiaConfig.OPTIONS.enableSpawn) {
			GaiaSpawning.register();
		}
	}
}
