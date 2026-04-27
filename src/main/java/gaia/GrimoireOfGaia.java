package gaia;

import com.mojang.logging.LogUtils;
import gaia.attachment.AttachmentHandler;
import gaia.client.ClientHandler;
import gaia.compat.curios.CuriosCompat;
import gaia.config.GaiaConfig;
import gaia.handler.CureHandler;
import gaia.handler.DropHandler;
import gaia.registry.GaiaDataSerializers;
import gaia.registry.GaiaModifiers;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(GrimoireOfGaia.MOD_ID)
public class GrimoireOfGaia {
	public static final String MOD_ID = "grimoireofgaia";
	public static final Logger LOGGER = LogUtils.getLogger();

	public GrimoireOfGaia(IEventBus eventBus, ModContainer container, Dist dist) {
		container.registerConfig(ModConfig.Type.COMMON, GaiaConfig.commonSpec);
		eventBus.register(GaiaConfig.class);

		GaiaRegistry.BLOCKS.register(eventBus);
		GaiaRegistry.ITEMS.register(eventBus);
		GaiaRegistry.CREATIVE_MODE_TABS.register(eventBus);
		GaiaRegistry.ENTITIES.register(eventBus);
		GaiaSounds.SOUND_EVENTS.register(eventBus);
		GaiaModifiers.BIOME_MODIFIER_SERIALIZERS.register(eventBus);
		GaiaDataSerializers.DATA_SERIALIZERS.register(eventBus);
		AttachmentHandler.ATTACHMENT_TYPES.register(eventBus);

		NeoForge.EVENT_BUS.register(new DropHandler());
		NeoForge.EVENT_BUS.register(new CureHandler());

		if (ModList.get().isLoaded("curios")) {
			eventBus.addListener(CuriosCompat::registerCapabilities);
		}

		if (dist.isClient()) {
			container.registerConfig(ModConfig.Type.CLIENT, GaiaConfig.clientSpec);
			container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
			eventBus.addListener(ClientHandler::onClientSetup);
			eventBus.addListener(ClientHandler::registerSpecialModelRenderers);
			eventBus.addListener(ClientHandler::setupSpectatingShaders);
			eventBus.addListener(ClientHandler::addPackFinders);
			eventBus.addListener(ClientHandler::registerEntityRenders);
			eventBus.addListener(ClientHandler::registerLayerDefinitions);
		}
	}

	public static Identifier modLoc(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
