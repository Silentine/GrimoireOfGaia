package gaia;

import com.mojang.logging.LogUtils;
import gaia.capability.CapabilityHandler;
import gaia.client.ClientHandler;
import gaia.config.GaiaConfig;
import gaia.handler.DropHandler;
import gaia.registry.GaiaDataSerializers;
import gaia.registry.GaiaModifiers;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.registry.GaiaSpawning;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GrimoireOfGaia.MOD_ID)
public class GrimoireOfGaia {
	public static final String MOD_ID = "grimoireofgaia";
	public static final Logger LOGGER = LogUtils.getLogger();

	public GrimoireOfGaia() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, GaiaConfig.clientSpec);
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GaiaConfig.commonSpec);
		eventBus.register(GaiaConfig.class);

		GaiaRegistry.BLOCKS.register(eventBus);
		GaiaRegistry.ITEMS.register(eventBus);
		GaiaRegistry.CREATIVE_MODE_TABS.register(eventBus);
		GaiaRegistry.ENTITIES.register(eventBus);
		GaiaSounds.SOUND_EVENTS.register(eventBus);
		GaiaModifiers.BIOME_MODIFIER_SERIALIZERS.register(eventBus);
		GaiaDataSerializers.DATA_SERIALIZERS.register(eventBus);

		if (ModList.get().isLoaded("curios")) {
			eventBus.addListener(gaia.compat.curios.CuriosCompat::sendImc);
		}

		eventBus.addListener(GaiaSpawning::registerEntityAttributes);
		eventBus.addListener(this::setup);

		MinecraftForge.EVENT_BUS.register(new DropHandler());

		MinecraftForge.EVENT_BUS.addListener(CapabilityHandler::register);
		MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, CapabilityHandler::attachCapability);

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.addListener(ClientHandler::onClientSetup);
			eventBus.addListener(ClientHandler::setupSpectatingShaders);
			eventBus.addListener(ClientHandler::addPackFinders);
			eventBus.addListener(ClientHandler::registerEntityRenders);
			eventBus.addListener(ClientHandler::registerLayerDefinitions);
		});
	}

	private void setup(final FMLCommonSetupEvent event) {
		GaiaSpawning.entityAttributes();
	}
}
