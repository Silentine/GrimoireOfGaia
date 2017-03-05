package gaia.init;

import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import gaia.Gaia;
import gaia.GaiaReference;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.ThaumcraftApi;

@InterfaceList({
	@Interface(iface="thaumcraft.api.ThaumcraftApi", modid="Thaumcraft", striprefs=true),
	@Interface(iface="thaumcraft.api.aspects.Aspect", modid="Thaumcraft", striprefs=true),
	@Interface(iface="thaumcraft.api.aspects.AspectList", modid="Thaumcraft", striprefs=true)})
public class Aspects_Entity extends GaiaEntity{
	
	/**Mod location to look for entity**/
	static String ref = GaiaReference.MOD_ID + ".";
	
	/**Primary method to register aspects**/
	public static void Entity_Aspects(){
		
		Gaia.logger.info("Registering Entity Aspects");
		
		//Entity - Format is based on GaiaEntity
		//Tier 1 - 1-2<4
		//Tier 2 - 2-3<6
		//Tier 3 - 2-4<8
		
		ThaumcraftApi.registerEntityTag(ref+"Anubis",
				(new AspectList()).add(Aspect.BEAST, 3).add(Aspect.DARKNESS, 3));
		
		ThaumcraftApi.registerEntityTag(ref+"Banshee",
				(new AspectList()).add(Aspect.SOUL, 2).add(Aspect.ENTROPY, 2).add(Aspect.FIRE, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Baphomet",
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.ENTROPY, 2).add(Aspect.FIRE, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Bone Knight",
				(new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 2).add(Aspect.PROTECT, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Centaur",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.EARTH, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Cobble Golem",
				(new AspectList()).add(Aspect.MECHANISM, 1).add(Aspect.EARTH, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Cobblestone Golem",
				(new AspectList()).add(Aspect.MECHANISM, 2).add(Aspect.EARTH, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Cockatrice",
				(new AspectList()).add(Aspect.AIR, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Creep",
				(new AspectList()).add(Aspect.FIRE, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Cyclops",
				(new AspectList()).add(Aspect.ENTROPY, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Cyan Flower",
				(new AspectList()).add(Aspect.PLANT, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Dhampir",
				(new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 2).add(Aspect.ENTROPY, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Dryad",
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.EARTH, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Dullahan",
				(new AspectList()).add(Aspect.SOUL, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Ender Dragon Girl",
				(new AspectList()).add(Aspect.ELDRITCH, 4).add(Aspect.DARKNESS, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Ender Eye",
				(new AspectList()).add(Aspect.ELDRITCH, 1).add(Aspect.DARKNESS, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Flesh Lich",
				(new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 2).add(Aspect.FIRE, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"FutakuchiOnna",
				(new AspectList()).add(Aspect.MAN, 1).add(Aspect.ENTROPY, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Gryphon",
				(new AspectList()).add(Aspect.AIR, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Harpy",
				(new AspectList()).add(Aspect.AIR, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Hunter",
				(new AspectList()).add(Aspect.MAN, 1).add(Aspect.EARTH, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Jorogumo",
				(new AspectList()).add(Aspect.ENTROPY, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Matango",
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.DARKNESS, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Mermaid",
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.WATER, 4));
		
		ThaumcraftApi.registerEntityTag(ref+"Mimic",
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.VOID, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Minotaur",
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.AVERSION, 4));
		
		ThaumcraftApi.registerEntityTag(ref+"Minotaurus",
				(new AspectList()).add(Aspect.BEAST, 3).add(Aspect.AVERSION, 3));
		
		ThaumcraftApi.registerEntityTag(ref+"Naga",
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.WATER, 2).add(Aspect.EARTH, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"NineTails",
				(new AspectList()).add(Aspect.BEAST, 3).add(Aspect.FIRE, 3));
		
		ThaumcraftApi.registerEntityTag(ref+"Sahuagin",
				(new AspectList()).add(Aspect.WATER, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Satyr",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.EARTH, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Selkie",
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.COLD, 4));
		
		ThaumcraftApi.registerEntityTag(ref+"Shaman",
				(new AspectList()).add(Aspect.MAN, 3).add(Aspect.SOUL, 3));
		
		ThaumcraftApi.registerEntityTag(ref+"Sharko",
				(new AspectList()).add(Aspect.WATER, 6));
		
		ThaumcraftApi.registerEntityTag(ref+"Siren",
				(new AspectList()).add(Aspect.WATER, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Sludge Girl",
				(new AspectList()).add(Aspect.LIFE, 1).add(Aspect.WATER, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Sphinx",
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.LIFE, 2).add(Aspect.MIND, 2).add(Aspect.ORDER, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Spriggan",
				(new AspectList()).add(Aspect.PLANT, 3).add(Aspect.EARTH, 3));
		
		ThaumcraftApi.registerEntityTag(ref+"Succubus",
				(new AspectList()).add(Aspect.FIRE, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Swamper",
				(new AspectList()).add(Aspect.LIFE, 3).add(Aspect.WATER, 3));
		
		ThaumcraftApi.registerEntityTag(ref+"Valkyrie",
				(new AspectList()).add(Aspect.MAN, 2).add(Aspect.MOTION, 2).add(Aspect.FLIGHT, 2).add(Aspect.ORDER, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Vampire",
				(new AspectList()).add(Aspect.UNDEAD, 2).add(Aspect.MAN, 2).add(Aspect.SENSES, 2).add(Aspect.ENTROPY, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Werecat",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.EARTH, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Witch",
				(new AspectList()).add(Aspect.MAN, 2).add(Aspect.AURA, 2).add(Aspect.FIRE, 2));
		
		ThaumcraftApi.registerEntityTag(ref+"Wither Cow",
				(new AspectList()).add(Aspect.UNDEAD, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Yeti",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.COLD, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Yuki-Onna",
				(new AspectList()).add(Aspect.SOUL, 2).add(Aspect.COLD, 2).add(Aspect.ORDER, 2));
		
		//NPC
		ThaumcraftApi.registerEntityTag(ref+"Creeper Girl",
				(new AspectList()).add(Aspect.FIRE, 1).add(Aspect.MAN, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Slime Girl",
				(new AspectList()).add(Aspect.LIFE, 1).add(Aspect.WATER, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Ender Girl",
				(new AspectList()).add(Aspect.ELDRITCH, 1).add(Aspect.MAN, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Trader",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.DESIRE, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Holstaurus",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.LIFE, 1));
		
		ThaumcraftApi.registerEntityTag(ref+"Weresheep",
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.CRAFT, 1));
		
		//Spawn
		ThaumcraftApi.registerEntityTag(ref+"Mandragora",
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.EARTH, 1));
	}
}