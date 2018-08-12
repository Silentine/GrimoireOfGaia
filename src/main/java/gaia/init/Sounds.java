package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(GaiaReference.MOD_ID)
public class Sounds {
	private Sounds() {}

	public static final SoundEvent PASSIVE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent PASSIVE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent PASSIVE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent ASSIST_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ASSIST_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ASSIST_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent AGGRESSIVE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent AGGRESSIVE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent AGGRESSIVE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent MINOTAUR_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MINOTAUR_HURT = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent BOX_OPEN_1 = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BOX_OPEN_2 = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BAG_OPEN = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BOOK_HIT = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent NONE = SoundEvents.BLOCK_GRASS_STEP;

	@SuppressWarnings({"unused", "squid:S1118"}) //used in registration reflection
	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
			Gaia.LOGGER.info("Registering Sounds");
			event.getRegistry().registerAll(
					createSoundEvent("passive_say"),
					createSoundEvent("passive_hurt"),
					createSoundEvent("passive_death"),

					createSoundEvent("assist_say"),
					createSoundEvent("assist_hurt"),
					createSoundEvent("assist_death"),

					createSoundEvent("aggressive_say"),
					createSoundEvent("aggressive_hurt"),
					createSoundEvent("aggressive_death"),

					createSoundEvent("minotaur_say"),
					createSoundEvent("minotaur_hurt"),

					createSoundEvent("box_open1"),
					createSoundEvent("box_open2"),
					createSoundEvent("bag_open"),
					createSoundEvent("book_hit"),

					createSoundEvent("none")
			);
			Gaia.LOGGER.info("Sounds Finished");
		}

		private static SoundEvent createSoundEvent(final String soundName) {
			ResourceLocation soundID = new ResourceLocation(GaiaReference.MOD_ID, soundName);
			return new SoundEvent(soundID).setRegistryName(soundID);
		}
	}
}
