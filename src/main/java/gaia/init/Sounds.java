package gaia.init;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	
	//Mob Sounds
	public static final SoundEvent PASSIVE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent PASSIVE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent PASSIVE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent ASSIST_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ASSIST_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ASSIST_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent AGGRESSIVE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent AGGRESSIVE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent AGGRESSIVE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent VAMPIRE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent VAMPIRE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent VAMPIRE_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	
	public static final SoundEvent SPHINX_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SPHINX_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SPHINX_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	
	public static final SoundEvent MINOTAUR_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MINOTAUR_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MINOTAUR_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	//Other Sounds
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
		
			//Register mob sounds
			String[] mobs = new String[]{
					"passive", "assist", "aggressive", "vampire", "sphinx",
					"minotaur"
			};
			for (int i=0; i < mobs.length; i++) {
				event.getRegistry().registerAll(
					createSoundEvent(mobs[i] + "_say"),
					createSoundEvent(mobs[i] + "_hurt"),
					createSoundEvent(mobs[i] + "_death")
				);
			}
			
			//Register misc sounds
			event.getRegistry().registerAll(
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
