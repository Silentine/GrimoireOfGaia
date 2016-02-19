package gaia.init;

import gaia.Gaia;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCockatrice;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaJorogumo;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyr;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaSummonButler;
import gaia.entity.monster.EntityGaiaSwamper;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCTrader;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/** Temporary loading work around **/
/** Remove when no longer testing **/
public class TEMP_Entity {

	public static void register(){
		byte trackingRange = 64;
		byte updateFrequency = 3;
		//vanilla spawn eggs && coloring
		//random colors
		int dog = 0x353535;
		int cat = 0xb19534;
		int fox =0x303030;
		int rat =0x943dbb;
		int box =3815994;
		int ice =7895160;
		int log =0x4e3738;
		int hat =0xc9b161;
		int mat =11013646;

	EntityRegistry.registerModEntity(EntityGaiaAnubis.class, "Anubis", 1, Gaia.instance, trackingRange, updateFrequency, true, cat, dog);
	EntityRegistry.registerModEntity(EntityGaiaBaphomet.class, "Baphomet", 3, Gaia.instance, trackingRange, updateFrequency, true, dog, fox);
	EntityRegistry.registerModEntity(EntityGaiaBoneKnight.class, "Bone Knight", 4, Gaia.instance, trackingRange, updateFrequency, true,fox, rat);
	EntityRegistry.registerModEntity(EntityGaiaDullahan.class, "Dullahan", 14, Gaia.instance, trackingRange, updateFrequency, true, fox, box);
	EntityRegistry.registerModEntity(EntityGaiaKobold.class, "Kobold", 47, Gaia.instance, trackingRange, updateFrequency, true, log, fox);
	EntityRegistry.registerModEntity(EntityGaiaShaman.class, "Shaman", 32, Gaia.instance, trackingRange, updateFrequency, true, rat, dog);
	EntityRegistry.registerModEntity(EntityGaiaSharko.class, "Sharko", 33, Gaia.instance, trackingRange, updateFrequency, true, dog, cat);
	EntityRegistry.registerModEntity(EntityGaiaWitherCow.class, "Wither Cow", 44, Gaia.instance, trackingRange, updateFrequency, true, ice ,cat);
	EntityRegistry.registerModEntity(EntityGaiaCockatrice.class, "Cockatrice", 8, Gaia.instance, trackingRange, updateFrequency, true, hat, cat);
	EntityRegistry.registerModEntity(EntityGaiaFutakuchiOnna.class, "FutakuchiOnna", 18, Gaia.instance, trackingRange, updateFrequency, true, mat, ice);
	EntityRegistry.registerModEntity(EntityGaiaNaga.class, "Naga", 27, Gaia.instance, trackingRange, updateFrequency, true, fox, mat);
	EntityRegistry.registerModEntity(EntityGaiaSahuagin.class, "Sahuagin", 29, Gaia.instance, trackingRange, updateFrequency, true, dog,ice);
	EntityRegistry.registerModEntity(EntityGaiaSiren.class, "Siren", 34, Gaia.instance, trackingRange, updateFrequency, true, ice, rat);
	EntityRegistry.registerModEntity(EntityGaiaSpriggan.class, "Spriggan", 37, Gaia.instance, trackingRange, updateFrequency, true,dog, mat);
	EntityRegistry.registerModEntity(EntityGaiaSummonButler.class, "Butler", 81, Gaia.instance, trackingRange, updateFrequency, true, mat, fox);
	
	EntityRegistry.registerModEntity(EntityGaiaCreep.class, "Creep", 9, Gaia.instance, trackingRange, updateFrequency, true, log, dog);
	EntityRegistry.registerModEntity(EntityGaiaDhampir.class, "Dhampir", 12, Gaia.instance, trackingRange, updateFrequency, true, ice, mat); //Has an obvious rendering issue - Might be assets related
	EntityRegistry.registerModEntity(EntityGaiaMimic.class, "Mimic", 24, Gaia.instance, trackingRange, updateFrequency, true, dog, cat);
	EntityRegistry.registerModEntity(EntityGaiaJorogumo.class, "Jorogumo", 22, Gaia.instance, trackingRange, updateFrequency, true, mat, cat);
	EntityRegistry.registerModEntity(EntityGaiaMinotaur.class, "Minotaur", 25, Gaia.instance, trackingRange, updateFrequency, true, ice, hat);
	EntityRegistry.registerModEntity(EntityGaiaVampire.class, "Vampire", 41, Gaia.instance, trackingRange, updateFrequency, true, mat, fox);
	EntityRegistry.registerModEntity(EntityGaiaWerecat.class, "Werecat", 42, Gaia.instance, trackingRange, updateFrequency, true, dog, hat);
	EntityRegistry.registerModEntity(EntityGaiaBanshee.class, "Banshee", 2, Gaia.instance, trackingRange, updateFrequency, true, rat, hat);
	EntityRegistry.registerModEntity(EntityGaiaCentaur.class, "Centaur", 5, Gaia.instance, trackingRange, updateFrequency, true, fox, ice);
	EntityRegistry.registerModEntity(EntityGaiaSphinx.class, "Sphinx", 36, Gaia.instance, trackingRange, updateFrequency, true, ice, cat);
	
	EntityRegistry.registerModEntity(EntityGaiaYeti.class, "Yeti", 45, Gaia.instance, trackingRange, updateFrequency, true, hat, rat);
	EntityRegistry.registerModEntity(EntityGaiaYukiOnna.class, "Yuki-Onna", 46, Gaia.instance, trackingRange, updateFrequency, true, cat, rat);
	EntityRegistry.registerModEntity(EntityGaiaHarpy.class, "Harpy", 20, Gaia.instance, trackingRange, updateFrequency, true,hat, fox);
	EntityRegistry.registerModEntity(EntityGaiaHunter.class, "Hunter", 21, Gaia.instance, trackingRange, updateFrequency, true, mat, fox);
	EntityRegistry.registerModEntity(EntityGaiaNineTails.class, "NineTails", 28, Gaia.instance, trackingRange, updateFrequency, true, cat, ice);
	EntityRegistry.registerModEntity(EntityGaiaFleshLich.class, "Flesh Lich", 17, Gaia.instance, trackingRange, updateFrequency, true, cat, rat);
	EntityRegistry.registerModEntity(EntityGaiaSuccubus.class, "Succubus", 38, Gaia.instance, trackingRange, updateFrequency, true,dog, fox);
	EntityRegistry.registerModEntity(EntityGaiaSwamper.class, "Swamper", 39, Gaia.instance, trackingRange, updateFrequency, true, mat, dog);
	EntityRegistry.registerModEntity(EntityGaiaSatyr.class, "Satyr", 30, Gaia.instance, trackingRange, updateFrequency, true, dog, rat);
	EntityRegistry.registerModEntity(EntityGaiaGryphon.class, "Gryphon", 19, Gaia.instance, trackingRange, updateFrequency, true, cat, mat);
	
	//Questionables - code will need to be revised and fixed up - mostly working however
	//Villagers interactions changed a bit in 1.8
	EntityRegistry.registerModEntity(EntityGaiaNPCCreeperGirl.class, "Creeper Girl", 60, Gaia.instance, trackingRange, updateFrequency, true, cat, ice);	
	EntityRegistry.registerModEntity(EntityGaiaNPCHolstaurus.class, "Holstaurus", 64, Gaia.instance, trackingRange, updateFrequency, true, dog, ice);	
	EntityRegistry.registerModEntity(EntityGaiaNPCTrader.class, "Trader", 61, Gaia.instance, trackingRange, updateFrequency, true, hat, fox);	
	EntityRegistry.registerModEntity(EntityGaiaNPCEnderGirl.class, "Ender Girl", 63, Gaia.instance, trackingRange, updateFrequency, true, dog, log);
	}
}
