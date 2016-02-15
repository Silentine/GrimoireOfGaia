package gaia.init;

import gaia.Gaia;
import gaia.entity.monster.EntityGaiaAnubis;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class GaiaEntity {

	public static void register(){
		byte trackingRange = 64;
		byte updateFrequency = 3;

		EntityRegistry.registerModEntity(EntityGaiaAnubis.class, "Anubis", 1, Gaia.instance, trackingRange, updateFrequency, true);
		/*EntityRegistry.registerModEntity(EntityGaiaBanshee.class, "Banshee", 2, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaBaphomet.class, "Baphomet", 3, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaBoneKnight.class, "Bone Knight", 4, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCentaur.class, "Centaur", 5, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCobbleGolem.class, "Cobble Golem", 6, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCobblestoneGolem.class, "Cobblestone Golem", 7, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCockatrice.class, "Cockatrice", 8, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCreep.class, "Creep", 9, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCyclops.class, "Cyclops", 10, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaPropFlowerCyan.class, "Cyan Flower", 11, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDhampir.class, "Dhampir", 12, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDryad.class, "Dryad", 13, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDullahan.class, "Dullahan", 14, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaEnderDragonGirl.class, "Ender Dragon Girl", 15, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaEnderEye.class, "Ender Eye", 16, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaFleshLich.class, "Flesh Lich", 17, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaFutakuchiOnna.class, "FutakuchiOnna", 18, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaGryphon.class, "Gryphon", 19, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaHarpy.class, "Harpy", 20, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaHunter.class, "Hunter", 21, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaJorogumo.class, "Jorogumo", 22, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaKobold.class, "Kobold", 47, Gaia.instance, trackingRange, updateFrequency, true); //ID
		EntityRegistry.registerModEntity(EntityGaiaMermaid.class, "Mermaid", 23, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMimic.class, "Mimic", 24, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMinotaur.class, "Minotaur", 25, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMinotaurus.class, "Minotaurus", 26, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNaga.class, "Naga", 27, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNineTails.class, "NineTails", 28, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSahuagin.class, "Sahuagin", 29, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSatyr.class, "Satyr", 30, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSelkie.class, "Selkie", 31, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaShaman.class, "Shaman", 32, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSharko.class, "Sharko", 33, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSiren.class, "Siren", 34, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSludgeGirl.class, "Sludge Girl", 35, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSphinx.class, "Sphinx", 36, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSpriggan.class, "Spriggan", 37, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSuccubus.class, "Succubus", 38, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSwamper.class, "Swamper", 39, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaValkyrie.class, "Valkyrie", 40, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaVampire.class, "Vampire", 41, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWerecat.class, "Werecat", 42, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWitch.class, "Witch", 43, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWitherCow.class, "Wither Cow", 44, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaYeti.class, "Yeti", 45, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaYukiOnna.class, "Yuki-Onna", 46, Gaia.instance, trackingRange, updateFrequency, true);

		EntityRegistry.registerModEntity(EntityGaiaNPCCreeperGirl.class, "Creeper Girl", 60, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCEnderGirl.class, "Ender Girl", 63, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCHolstaurus.class, "Holstaurus", 64, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCSlimeGirl.class, "Slime Girl", 62, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCTrader.class, "Trader", 61, Gaia.instance, trackingRange, updateFrequency, true);
	
		EntityRegistry.registerModEntity(EntityGaiaProjectileSmallFireball.class, "Small Fireball", 100, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaProjectileMagic.class, "Magic", 101, Gaia.instance, trackingRange, updateFrequency, true);

		EntityRegistry.registerModEntity(EntityGaiaMandragora.class, "Mandragora", 80, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSummonButler.class, "Butler", 81, Gaia.instance, trackingRange, updateFrequency, true); */
	}
}
