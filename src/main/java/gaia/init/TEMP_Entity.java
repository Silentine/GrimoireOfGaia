package gaia.init;

import gaia.Gaia;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCockatrice;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSummonButler;
import gaia.entity.monster.EntityGaiaWitherCow;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/** Temporary loading work around **/
/** Remove no longer testing **/
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
	}
}
