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
	
	//Generic Mob Sounds
	public static final SoundEvent PASSIVE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent PASSIVE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent PASSIVE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent ASSIST_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ASSIST_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ASSIST_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent AGGRESSIVE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent AGGRESSIVE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent AGGRESSIVE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	// A
	public static final SoundEvent ANT_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ANT_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ANT_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent ANUBIS_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ANUBIS_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ANUBIS_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent ARACHNE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ARACHNE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ARACHNE_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// B
	public static final SoundEvent BANSHEE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BANSHEE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BANSHEE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent BAPHOMET_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BAPHOMET_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BAPHOMET_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent BEE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BEE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent BEE_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// C
	public static final SoundEvent CECAELIA_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent CECAELIA_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent CECAELIA_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent CENTAUR_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent CENTAUR_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent CENTAUR_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent COBBLEGOLEM_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent COBBLEGOLEM_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent COBBLEGOLEM_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent COBBLESTONEGOLEM_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent COBBLESTONEGOLEM_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent COBBLESTONEGOLEM_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent CYCLOPS_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent CYCLOPS_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent CYCLOPS_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// D
	public static final SoundEvent DHAMPIR_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent DHAMPIR_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent DHAMPIR_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent DRYAD_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent DRYAD_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent DRYAD_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent DULLAHAN_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent DULLAHAN_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent DULLAHAN_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent DWARF_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent DWARF_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent DWARF_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// G
	public static final SoundEvent GOBLIN_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent GOBLIN_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent GOBLIN_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent GRYPHON_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent GRYPHON_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent GRYPHON_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// H
	public static final SoundEvent HARPY_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent HARPY_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent HARPY_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent HUNTER_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent HUNTER_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent HUNTER_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// K
	public static final SoundEvent KOBOLD_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent KOBOLD_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent KOBOLD_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// M
	public static final SoundEvent MANDRAGORA_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MANDRAGORA_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MANDRAGORA_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent MATANGO_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MATANGO_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MATANGO_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent MERMAID_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MERMAID_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MERMAID_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent MINOTAUR_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MINOTAUR_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MINOTAUR_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent MINOTAURUS_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MINOTAURUS_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MINOTAURUS_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent MUMMY_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MUMMY_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent MUMMY_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// N
	public static final SoundEvent NAGA_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent NAGA_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent NAGA_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent NINETAILS_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent NINETAILS_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent NINETAILS_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// O
	public static final SoundEvent ONI_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ONI_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ONI_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent ORC_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ORC_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ORC_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// S
	public static final SoundEvent SATYRESS_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SATYRESS_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SATYRESS_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SELKIE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SELKIE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SELKIE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SHAMAN_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SHAMAN_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SHAMAN_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SHARKO_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SHARKO_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SHARKO_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SIREN_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SIREN_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SIREN_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SLUDGEGIRL_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SLUDGEGIRL_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SLUDGEGIRL_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SPHINX_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SPHINX_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SPHINX_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SPRIGGAN_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SPRIGGAN_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SPRIGGAN_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SUCCUBUS_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SUCCUBUS_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SUCCUBUS_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// T
	public static final SoundEvent TOAD_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent TOAD_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent TOAD_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// V
	public static final SoundEvent VALKYRIE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent VALKYRIE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent VALKYRIE_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent VAMPIRE_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent VAMPIRE_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent VAMPIRE_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// W
	public static final SoundEvent WERECAT_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent WERECAT_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent WERECAT_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent WITCH_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent WITCH_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent WITCH_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// Y
	public static final SoundEvent YETI_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent YETI_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent YETI_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent YUKIONNA_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent YUKIONNA_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent YUKIONNA_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// 	SUMMON
	public static final SoundEvent SUMMONBUTLER_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SUMMONBUTLER_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SUMMONBUTLER_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SUMMONSPORELING_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SUMMONSPORELING_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SUMMONSPORELING_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	// 	PASSIVE
	public static final SoundEvent HOLSTAURUS_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent HOLSTAURUS_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent HOLSTAURUS_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent TRADER_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent TRADER_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent TRADER_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent WERESHEEP_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent WERESHEEP_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent WERESHEEP_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent CREEPERGIRL_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent CREEPERGIRL_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent CREEPERGIRL_DEATH = SoundEvents.BLOCK_GRASS_STEP;
	
	public static final SoundEvent ENDERGIRL_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ENDERGIRL_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent ENDERGIRL_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	public static final SoundEvent SLIMEGIRL_SAY = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SLIMEGIRL_HURT = SoundEvents.BLOCK_GRASS_STEP;
	public static final SoundEvent SLIMEGIRL_DEATH = SoundEvents.BLOCK_GRASS_STEP;

	//	OTHER
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
					"passive", "assist", "aggressive",
					"ant", "anubis", "arachne", 
					"banshee", "baphomet", "bee", 
					"cecaelia", "centaur", "cobblegolem", "cobblestonegolem", "cyclops", 
					"dhampir", "dryad", "dullahan", "dwarf",
					"goblin", "gryphon", 
					"harpy", "hunter", 
					"kobold", 
					"mandragora", "matango", "mermaid", "minotaur", "minotaurus", "mummy", 
					"naga", "ninetails", 
					"oni", "orc", 
					"satyress", "selkie",  "shaman", "sharko", "siren", "sludgegirl", "sphinx", "spriggan", "succubus",
					"toad", 
					"valkyrie", "vampire", 
					"werecat", "witch", 
					"yeti", "yukionna", 
					"summonbutler", "summonsporeling", 
					"holstaurus", "trader", "weresheep",
					"creepergirl", "endergirl", "slimegirl"
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
