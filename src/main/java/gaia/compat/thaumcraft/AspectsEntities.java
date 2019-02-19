package gaia.compat.thaumcraft;

@SuppressWarnings("unused")
public class AspectsEntities {
	private AspectsEntities() {
	}
//
//	@SubscribeEvent
//	public static void registerAspects(AspectRegistryEvent event) {
//		Gaia.LOGGER.info("Registering Entity Aspects");
//
//		String ref = GaiaReference.MOD_ID + ".";
//
//		/**
//		 * Level x - recommended value range
//		 * Level 1 - 1-2<4
//		 * Level 2 - 2-3<6
//		 * Level 3 - 2-4<8
//		 */
//
//		// A
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "ant", (new AspectList())
//				.add(Aspect.FIRE, 2)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "ant_ranger", (new AspectList())
//				.add(Aspect.FIRE, 2)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "anubis", (new AspectList())
//				.add(Aspect.BEAST, 3)
//				.add(Aspect.DARKNESS, 3)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "arachne", (new AspectList())
//				.add(Aspect.ENTROPY, 2)));
//		// B
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "banshee", (new AspectList())
//				.add(Aspect.SOUL, 2)
//				.add(Aspect.ENTROPY, 2)
//				.add(Aspect.FIRE, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "baphomet", (new AspectList())
//				.add(Aspect.BEAST, 2)
//				.add(Aspect.ENTROPY, 2)
//				.add(Aspect.FIRE, 2)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "bee", (new AspectList())
//				.add(Aspect.FLIGHT, 1)
//				.add(Aspect.PLANT, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "bone_knight", (new AspectList())
//				.add(Aspect.UNDEAD, 2)
//				.add(Aspect.MAN, 2)
//				.add(Aspect.PROTECT, 2)));
//		// C
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cecaelia", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.WATER, 2)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "centaur", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.EARTH, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cobble_golem", (new AspectList())
//				.add(Aspect.MECHANISM, 1)
//				.add(Aspect.EARTH, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cobblestone_golem", (new AspectList())
//				.add(Aspect.MECHANISM, 2)
//				.add(Aspect.EARTH, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "creep", (new AspectList())
//				.add(Aspect.FIRE, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cyclops", (new AspectList())
//				.add(Aspect.ENTROPY, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cyan_flower", (new AspectList())
//				.add(Aspect.PLANT, 2)));
//		// D
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "deathword", (new AspectList())
//				.add(Aspect.MIND, 2)
//				.add(Aspect.MAGIC, 2)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "dhampir", (new AspectList())
//				.add(Aspect.UNDEAD, 2)
//				.add(Aspect.MAN, 2)
//				.add(Aspect.ENTROPY, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "dryad", (new AspectList())
//				.add(Aspect.PLANT, 1)
//				.add(Aspect.EARTH, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "dullahan", (new AspectList())
//				.add(Aspect.SOUL, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "dwarf", (new AspectList())
//				.add(Aspect.MAN, 1)
//				.add(Aspect.EARTH, 1)));
//		// E
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "ender_dragon_girl", (new AspectList())
//				.add(Aspect.ELDRITCH, 4)
//				.add(Aspect.DARKNESS, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "ender_eye", (new AspectList())
//				.add(Aspect.ELDRITCH, 1)
//				.add(Aspect.DARKNESS, 1)));
//		// F
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "flesh_lich", (new AspectList())
//				.add(Aspect.UNDEAD, 2)
//				.add(Aspect.MAN, 2)
//				.add(Aspect.FIRE, 2)));
//		// G
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "gelatinous_slime", (new AspectList())
//				.add(Aspect.UNDEAD, 2)
//				.add(Aspect.ELDRITCH, 2)
//				.add(Aspect.WATER, 2)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "goblin", (new AspectList())
//				.add(Aspect.MAN, 1)
//				.add(Aspect.EARTH, 1)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "goblin_feral", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.EARTH, 1)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "gryphon", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.FLIGHT, 1)));
//		// H
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "harpy", (new AspectList())
//				.add(Aspect.AIR, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "hunter", (new AspectList())
//				.add(Aspect.MAN, 1)
//				.add(Aspect.EARTH, 1)));
//		// K
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "kikimora", (new AspectList())
//				.add(Aspect.FLIGHT, 1)
//				.add(Aspect.AIR, 1)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "kobold", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.COLD, 1)));
//		// M
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "matango", (new AspectList())
//				.add(Aspect.PLANT, 1)
//				.add(Aspect.DARKNESS, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "mermaid", (new AspectList())
//				.add(Aspect.PROTECT, 2)
//				.add(Aspect.WATER, 4)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "mimic", (new AspectList())
//				.add(Aspect.PLANT, 1)
//				.add(Aspect.VOID, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "minotaur", (new AspectList())
//				.add(Aspect.BEAST, 4)
//				.add(Aspect.AVERSION, 4)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "minotaurus", (new AspectList())
//				.add(Aspect.BEAST, 3)
//				.add(Aspect.AVERSION, 3)));
//		
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "mummy", (new AspectList())
//				.add(Aspect.UNDEAD, 1)
//				.add(Aspect.ENTROPY, 1)));
//		// N
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "naga", (new AspectList())
//				.add(Aspect.PROTECT, 2)
//				.add(Aspect.WATER, 2)
//				.add(Aspect.EARTH, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "nine_tails", (new AspectList())
//				.add(Aspect.BEAST, 3)
//				.add(Aspect.FIRE, 3)));
//		// O
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "oni", (new AspectList())
//				.add(Aspect.DARKNESS, 1)
//				.add(Aspect.FIRE, 1)));
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "orc", (new AspectList())
//				.add(Aspect.MAN, 1)
//				.add(Aspect.EARTH, 1)));
//		// S
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "satyress", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.EARTH, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "selkie", (new AspectList())
//				.add(Aspect.BEAST, 2)
//				.add(Aspect.COLD, 4)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "shaman", (new AspectList())
//				.add(Aspect.MAN, 3)
//				.add(Aspect.SOUL, 3)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "sharko", (new AspectList())
//				.add(Aspect.WATER, 6)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "siren", (new AspectList())
//				.add(Aspect.WATER, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "sludge_girl", (new AspectList())
//				.add(Aspect.LIFE, 1)
//				.add(Aspect.WATER, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "sphinx", (new AspectList())
//				.add(Aspect.BEAST, 2)
//				.add(Aspect.LIFE, 2)
//				.add(Aspect.MIND, 2)
//				.add(Aspect.ORDER, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "spriggan", (new AspectList())
//				.add(Aspect.PLANT, 3)
//				.add(Aspect.EARTH, 3)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "succubus", (new AspectList())
//				.add(Aspect.FIRE, 2)));
//		// T
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "toad", (new AspectList())
//				.add(Aspect.LIFE, 3)
//				.add(Aspect.WATER, 3)));
//		// V
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "valkyrie", (new AspectList())
//				.add(Aspect.MAN, 2)
//				.add(Aspect.MOTION, 2)
//				.add(Aspect.FLIGHT, 2)
//				.add(Aspect.ORDER, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "vampire", (new AspectList())
//				.add(Aspect.UNDEAD, 2)
//				.add(Aspect.MAN, 2)
//				.add(Aspect.SENSES, 2)
//				.add(Aspect.ENTROPY, 2)));
//		// W
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "werecat", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.EARTH, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "witch", (new AspectList())
//				.add(Aspect.MAN, 2)
//				.add(Aspect.AURA, 2)
//				.add(Aspect.FIRE, 2)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "wither_cow", (new AspectList())
//				.add(Aspect.UNDEAD, 1)
//				.add(Aspect.BEAST, 1)));
//		// Y
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "yeti", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.COLD, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "yuki-onna", (new AspectList())
//				.add(Aspect.SOUL, 2)
//				.add(Aspect.COLD, 2)
//				.add(Aspect.ORDER, 2)));
//
//		// NPC
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "creeper_girl", (new AspectList())
//				.add(Aspect.FIRE, 1)
//				.add(Aspect.MAN, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "slime_girl", (new AspectList())
//				.add(Aspect.LIFE, 1)
//				.add(Aspect.WATER, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "ender_girl", (new AspectList())
//				.add(Aspect.ELDRITCH, 1)
//				.add(Aspect.MAN, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "trader", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.DESIRE, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "holstaurus", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.LIFE, 1)));
//
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "weresheep", (new AspectList())
//				.add(Aspect.BEAST, 1)
//				.add(Aspect.CRAFT, 1)));
//
//		// Spawn
//		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "mandragora", (new AspectList())
//				.add(Aspect.PLANT, 1)
//				.add(Aspect.EARTH, 1)));
//	}
}
