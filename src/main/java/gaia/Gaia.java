package gaia;

import gaia.command.CommandBiome;
import gaia.command.CommandSpawn;
import gaia.init.GaiaConfigGeneration;
import gaia.init.GaiaItems;
import gaia.init.GaiaSpawning;
import gaia.proxy.CommonProxy;
import gaia.recipe.FuelHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = GaiaReference.MOD_ID, name = GaiaReference.MOD_NAME, version = GaiaReference.VERSION, guiFactory = GaiaReference.GUI_FACTORY, dependencies = GaiaReference.DEPENDENCIES)
public class Gaia {

    public static final Logger LOGGER = LogManager.getLogger(GaiaReference.MOD_ID);

    @Instance(GaiaReference.MOD_ID) public static Gaia instance = new Gaia();

    @SidedProxy(clientSide = GaiaReference.CLIENT_PROXY_CLASS, serverSide = GaiaReference.SERVER_PROXY_CLASS) public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GaiaConfigGeneration.configOptions(event);
        FuelHandler.init();
        proxy.registerHandlers();
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenders();

        MinecraftForge.EVENT_BUS.register(this);

        if (GaiaConfig.Biome_Tweaks) {
            GaiaSpawning.Biome_Tweaks();
        }
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        if (GaiaConfig.Debug_Commands) {
            event.registerServerCommand(new CommandBiome());
            event.registerServerCommand(new CommandSpawn());
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Moved Spawning registry to last since forge doesn't auto-generate sub
        // "M' biomes until late
        if (GaiaConfig.Enable_Spawn) {
            GaiaSpawning.register();
        }
    }
}
