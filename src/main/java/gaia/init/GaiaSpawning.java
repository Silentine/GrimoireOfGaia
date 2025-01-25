package gaia.init;

import gaia.ConfigGaia;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCockatrice;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaJorogumo;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyr;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaSwamper;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class GaiaSpawning {

	public static void add(Class<? extends EntityLiving> entityClass, int weight, int min, int max, BiomeGenBase biome) {
		if (weight > 0) {
			biome.getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(entityClass, weight, min, max));
			//EntityRegistry.addSpawn(entityClass, weight, min, max, EnumCreatureType.MONSTER, biome);
			EntitySpawnPlacementRegistry.setPlacementType(entityClass, EntityLiving.SpawnPlacementType.ON_GROUND);
		}
	}

	public static void register(){

		BiomeGenBase[] forest = BiomeDictionary.getBiomesForType(Type.FOREST);
		BiomeGenBase[] sandy = BiomeDictionary.getBiomesForType(Type.SANDY);
		BiomeGenBase[] plains = BiomeDictionary.getBiomesForType(Type.PLAINS);
		BiomeGenBase[] swamp = BiomeDictionary.getBiomesForType(Type.SWAMP);
		BiomeGenBase[] spooky = BiomeDictionary.getBiomesForType(Type.SPOOKY);
		BiomeGenBase[] jungle = BiomeDictionary.getBiomesForType(Type.JUNGLE);
		BiomeGenBase[] snowy = BiomeDictionary.getBiomesForType(Type.SNOWY);
		BiomeGenBase[] mountain = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		BiomeGenBase[] water = BiomeDictionary.getBiomesForType(Type.WATER);
		BiomeGenBase[] beach = BiomeDictionary.getBiomesForType(Type.BEACH);

		BiomeGenBase[] hell = BiomeDictionary.getBiomesForType(Type.NETHER);
		BiomeGenBase[] sky = BiomeDictionary.getBiomesForType(Type.END);

		for (BiomeGenBase biome : forest)
		{
			// forest, forestHills, birchForest, birchForestHills
			if (!BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS)
					&& !BiomeDictionary.isBiomeOfType(biome, Type.SNOWY)
					&& !BiomeDictionary.isBiomeOfType(biome, Type.MOUNTAIN)
					&& !BiomeDictionary.isBiomeOfType(biome, Type.SPOOKY)
					&& !BiomeDictionary.isBiomeOfType(biome, Type.MAGICAL))
			{
				add(EntityGaiaPropFlowerCyan.class, ConfigGaia.SpawnMandragora, 1, 2, biome);

				add(EntityGaiaDryad.class, ConfigGaia.SpawnDryad, 4, 6, biome);

				add(EntityGaiaWerecat.class, ConfigGaia.SpawnWerecat, 4, 6, biome);

				add(EntityGaiaSpriggan.class, ConfigGaia.SpawnSpriggan, 2, 4, biome);

				// underground
				add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

				add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

				add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

				add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

				add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

				add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
			}

			//taiga, taigaHills, megaTaiga, megaTaigaHills
			if (BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS)
					&& (!BiomeDictionary.isBiomeOfType(biome, Type.SNOWY)))
			{
				add(EntityGaiaCyclops.class, ConfigGaia.SpawnCyclops, 4, 6, biome);

				add(EntityGaiaYukiOnna.class, ConfigGaia.SpawnYukiOnna, 2, 4, biome);

				add(EntityGaiaFutakuchiOnna.class, ConfigGaia.SpawnFutakuchiOnna, 4, 6, biome);

				add(EntityGaiaNineTails.class, ConfigGaia.SpawnNineTails, 2, 4, biome);

				// underground
				add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

				add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

				add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

				add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

				add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

				add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
			}

			// coldTaiga, coldTaigaHills
			if (BiomeDictionary.isBiomeOfType(biome, Type.CONIFEROUS)
					&& (BiomeDictionary.isBiomeOfType(biome, Type.SNOWY)))
			{
				add(EntityGaiaDhampir.class, ConfigGaia.SpawnDhampir, 2, 4, biome);

				add(EntityGaiaVampire.class, ConfigGaia.SpawnVampire, 1, 2, biome);

				// underground
				add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

				add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

				add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

				add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

				add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

				add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
			}

			// roofedForest
			if (BiomeDictionary.isBiomeOfType(biome, Type.SPOOKY))
			{
				add(EntityGaiaMatango.class, ConfigGaia.SpawnMatango, 2, 4, biome);

				add(EntityGaiaWitch.class, ConfigGaia.SpawnWitch, 2, 4, biome);

				// underground
				add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

				add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

				add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

				add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

				add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

				add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
			}
		}

		// desert, desertHills, mesa, mesaPlateau, mesaPlateau_F
		for (BiomeGenBase biome : sandy)
		{
			add(EntityGaiaCockatrice.class, ConfigGaia.SpawnCockatrice, 2, 4, biome);

			add(EntityGaiaHarpy.class, ConfigGaia.SpawnHarpy, 2, 4, biome);

			add(EntityGaiaAnubis.class, ConfigGaia.SpawnAnubis, 2, 4, biome);

			add(EntityGaiaSphinx.class, ConfigGaia.SpawnSphinx, 1, 2, biome);

			// underground
			add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

			add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

			add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

			add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

			add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

			add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
		}

		// plains, savanna, savannaPlateau
		for (BiomeGenBase biome : plains)
		{
			add(EntityGaiaSatyr.class, ConfigGaia.SpawnSatyr, 2, 4, biome);

			add(EntityGaiaCentaur.class, ConfigGaia.SpawnCentaur, 4, 6, biome);

			add(EntityGaiaMinotaurus.class, ConfigGaia.SpawnMinotaurus, 2, 4, biome);

			add(EntityGaiaMinotaur.class, ConfigGaia.SpawnMinotaur, 1, 2, biome);

			// underground
			add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

			add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

			add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

			add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

			add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

			add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
		}

		// swamp
		for (BiomeGenBase biome : swamp)
		{
			add(EntityGaiaSiren.class, ConfigGaia.SpawnSiren, 4, 6, biome);

			add(EntityGaiaNaga.class, ConfigGaia.SpawnNaga, 1, 2, biome);

			add(EntityGaiaSludgeGirl.class, ConfigGaia.SpawnSludgeGirl, 2, 4, biome);

			add(EntityGaiaSwamper.class, ConfigGaia.SpawnSwamper, 1, 2, biome);

			// underground
			add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

			add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

			add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

			add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

			add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

			add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
		}

		// jungle
		for (BiomeGenBase biome : jungle)
		{
			add(EntityGaiaCobbleGolem.class, ConfigGaia.SpawnCobbleGolem, 2, 4, biome);

			add(EntityGaiaHunter.class, ConfigGaia.SpawnHunter, 2, 4, biome);

			add(EntityGaiaShaman.class, ConfigGaia.SpawnShaman, 2, 4, biome);

			add(EntityGaiaCobblestoneGolem.class, ConfigGaia.SpawnCobblestoneGolem, 2, 4, biome);

			// underground
			add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

			add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

			add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

			add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

			add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

			add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
		}

		// icePlains, iceMountains
		for (BiomeGenBase biome : snowy)
		{
			if (!BiomeDictionary.isBiomeOfType(biome, Type.FOREST)
					|| !BiomeDictionary.isBiomeOfType(biome, Type.OCEAN)
					|| !BiomeDictionary.isBiomeOfType(biome, Type.RIVER))
			{
				add(EntityGaiaYeti.class, ConfigGaia.SpawnYeti, 4, 6, biome);

				add(EntityGaiaSelkie.class, ConfigGaia.SpawnSelkie, 2, 4, biome);

				// underground
				add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

				add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

				add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

				add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

				add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

				add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
			}
		}

		// extremeHills, extremeHillsPlus
		for (BiomeGenBase biome : mountain)
		{
			if (!BiomeDictionary.isBiomeOfType(biome, Type.SNOWY))
			{
				add(EntityGaiaGryphon.class, ConfigGaia.SpawnGryphon, 4, 6, biome);

				add(EntityGaiaValkyrie.class, ConfigGaia.SpawnValkyrie, 1, 2, biome);

				add(EntityGaiaDullahan.class, ConfigGaia.SpawnDullahan, 4, 6, biome);

				add(EntityGaiaBanshee.class, ConfigGaia.SpawnBanshee, 2, 4, biome);

				// underground
				add(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4, biome);

				add(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4, biome);

				add(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2, biome);

				add(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2, biome);

				add(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2, biome);

				add(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2, biome);
			}
		}

		// frozenRiver, coldBeach, stoneBeach, river, beach, ocean, deepOcean
		for (BiomeGenBase biome : water)
		{
			add(EntityGaiaSahuagin.class, ConfigGaia.SpawnSahuagin, 4, 6, biome);

			add(EntityGaiaMermaid.class, ConfigGaia.SpawnMermaid, 2, 4, biome);

			add(EntityGaiaSharko.class, ConfigGaia.SpawnSharko, 2, 4, biome);
		}

		for (BiomeGenBase biome : beach)
		{
			add(EntityGaiaSahuagin.class, ConfigGaia.SpawnSahuagin, 4, 6, biome);

			add(EntityGaiaMermaid.class, ConfigGaia.SpawnMermaid, 2, 4, biome);

			add(EntityGaiaSharko.class, ConfigGaia.SpawnSharko, 2, 4, biome);
		}

		//hell
		for (BiomeGenBase biome : hell)
		{
			add(EntityGaiaSuccubus.class, ConfigGaia.SpawnSuccubus, 2, 4, biome);

			add(EntityGaiaWitherCow.class, ConfigGaia.SpawnWitherCow, 1, 2, biome);

			add(EntityGaiaBaphomet.class, ConfigGaia.SpawnBaphomet, 1, 2, biome);
		}

		//sky
		for (BiomeGenBase biome : sky)
		{
			if (BiomeDictionary.isBiomeOfType(biome, Type.COLD)
					&& (BiomeDictionary.isBiomeOfType(biome, Type.DRY)))
			{
				add(EntityGaiaEnderDragonGirl.class, ConfigGaia.SpawnEnderDragonGirl, 1, 2, biome);
			}
		}
	}
}
