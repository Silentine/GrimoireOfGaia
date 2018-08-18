package gaia.compat.thaumcraft;

import gaia.Gaia;
import gaia.GaiaReference;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;
import thaumcraft.api.internal.CommonInternals;

@SuppressWarnings("unused")
public class AspectsEntities {
	private AspectsEntities() {}

	@SubscribeEvent
	public static void registerAspects(AspectRegistryEvent event) {
		Gaia.LOGGER.info("Registering Entity Aspects");

		String ref = GaiaReference.MOD_ID + ".";

		//Entity - Format is based on GaiaEntity
		//Tier 1 - 1-2<4
		//Tier 2 - 2-3<6
		//Tier 3 - 2-4<8
		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "anubis",
				(new AspectList()).add(Aspect.BEAST, 3).add(Aspect.DARKNESS, 3)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "arachne",
				(new AspectList()).add(Aspect.ENTROPY, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "banshee",
				(new AspectList()).add(Aspect.SOUL, 2).add(Aspect.ENTROPY, 2).add(Aspect.FIRE, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "baphomet",
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.ENTROPY, 2).add(Aspect.FIRE, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "bone_knight",
				(new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 2).add(Aspect.PROTECT, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "centaur",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.EARTH, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cobble_golem",
				(new AspectList()).add(Aspect.MECHANISM, 1).add(Aspect.EARTH, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cobblestone_golem",
				(new AspectList()).add(Aspect.MECHANISM, 2).add(Aspect.EARTH, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cockatrice",
				(new AspectList()).add(Aspect.AIR, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "creep",
				(new AspectList()).add(Aspect.FIRE, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cyclops",
				(new AspectList()).add(Aspect.ENTROPY, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "cyan_flower",
				(new AspectList()).add(Aspect.PLANT, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "dhampir",
				(new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 2).add(Aspect.ENTROPY, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "dryad",
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.EARTH, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "dullahan",
				(new AspectList()).add(Aspect.SOUL, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "dwarf",
				(new AspectList()).add(Aspect.MAN, 1).add(Aspect.EARTH, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "ender_dragon_girl",
				(new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.DARKNESS, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "ender_eye",
				(new AspectList()).add(Aspect.ELDRITCH, 1).add(Aspect.DARKNESS, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "flesh_lich",
				(new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 2).add(Aspect.FIRE, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "futakuchi_onna",
				(new AspectList()).add(Aspect.MAN, 1).add(Aspect.ENTROPY, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "harpy",
				(new AspectList()).add(Aspect.AIR, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "hunter",
				(new AspectList()).add(Aspect.MAN, 1).add(Aspect.EARTH, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "matango",
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.DARKNESS, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "mermaid",
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.WATER, 4)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "mimic",
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.VOID, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "minotaur",
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.AVERSION, 4)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "minotaurus",
				(new AspectList()).add(Aspect.BEAST, 3).add(Aspect.AVERSION, 3)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "naga",
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.WATER, 2).add(Aspect.EARTH, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "nine_tails",
				(new AspectList()).add(Aspect.BEAST, 3).add(Aspect.FIRE, 3)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "sahuagin",
				(new AspectList()).add(Aspect.WATER, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "satyr",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.EARTH, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "selkie",
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.COLD, 4)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "shaman",
				(new AspectList()).add(Aspect.MAN, 3).add(Aspect.SOUL, 3)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "sharko",
				(new AspectList()).add(Aspect.WATER, 6)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "siren",
				(new AspectList()).add(Aspect.WATER, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "sludge_girl",
				(new AspectList()).add(Aspect.LIFE, 1).add(Aspect.WATER, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "sphinx",
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.LIFE, 2).add(Aspect.MIND, 2).add(Aspect.ORDER, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "spriggan",
				(new AspectList()).add(Aspect.PLANT, 3).add(Aspect.EARTH, 3)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "succubus",
				(new AspectList()).add(Aspect.FIRE, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "toad",
				(new AspectList()).add(Aspect.LIFE, 3).add(Aspect.WATER, 3)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "valkyrie",
				(new AspectList()).add(Aspect.MAN, 2).add(Aspect.MOTION, 2).add(Aspect.FLIGHT, 2).add(Aspect.ORDER, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "vampire",
				(new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 2).add(Aspect.SENSES, 2).add(Aspect.ENTROPY, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "werecat",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.EARTH, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "witch",
				(new AspectList()).add(Aspect.MAN, 2).add(Aspect.AURA, 2).add(Aspect.FIRE, 2)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "wither_cow",
				(new AspectList()).add(Aspect.UNDEAD, 1).add(Aspect.BEAST, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "yeti",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.COLD, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "yuki-onna",
				(new AspectList()).add(Aspect.SOUL, 2).add(Aspect.COLD, 2).add(Aspect.ORDER, 2)));

		//NPC
		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "creeper_girl",
				(new AspectList()).add(Aspect.FIRE, 1).add(Aspect.MAN, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "slime_girl",
				(new AspectList()).add(Aspect.LIFE, 1).add(Aspect.WATER, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "ender_girl",
				(new AspectList()).add(Aspect.ELDRITCH, 1).add(Aspect.MAN, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "trader",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.DESIRE, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "holstaurus",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.LIFE, 1)));

		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "weresheep",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.CRAFT, 1)));

		//Spawn
		CommonInternals.scanEntities.add(new ThaumcraftApi.EntityTags(ref + "mandragora",
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.EARTH, 1)));

	}
}
