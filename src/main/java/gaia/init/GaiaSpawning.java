package gaia.init;

import gaia.Gaia;
import gaia.GaiaConfig;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaArachne;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaMummy;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyress;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaToad;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Streamlined Spawning Registry, Tried to keep structure as similar, but
 * cleaned up methods and repetitive code to save time and fingers.
 */
public class GaiaSpawning extends GaiaConfig {

    /**
     * Bridge Method for simpler spawning registry
     */
    public static void add(int weight, Class<? extends EntityLiving> entityclassIn, int groupCountMin, int groupCountMax, Biome biome) {
        if (weight > 0) {
            biome.getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(entityclassIn, weight, groupCountMin, groupCountMax));
        }
    }

    /**
     * Underground Creature Roster
     */
    public static void underground(Biome biome) {
        add(SpawnCreep, EntityGaiaCreep.class, 2, 4, biome);
        add(SpawnEnderEye, EntityGaiaEnderEye.class, 2, 4, biome);
        add(SpawnArachne, EntityGaiaArachne.class, 1, 2, biome);
        add(SpawnMimic, EntityGaiaPropChestMimic.class, 1, 2, biome);
        add(SpawnBoneKnight, EntityGaiaBoneKnight.class, 1, 2, biome);
        add(SpawnFleshLich, EntityGaiaFleshLich.class, 1, 2, biome);
    }

    // Water based mobs
    public static void aquatic(Biome biome) {
        add(SpawnSahuagin, EntityGaiaSahuagin.class, 4, 6, biome);
        add(SpawnMermaid, EntityGaiaMermaid.class, 2, 4, biome);
        add(SpawnSharko, EntityGaiaSharko.class, 2, 4, biome);
    }

    /**
     * Register Mobs based on Biome sub Types
     */
    public static void register() {
        Map<Type, Set<Biome>> biomeMap = buildBiomeListByType();

        Set<Biome> forest = biomeMap.get(Type.FOREST);
        Set<Biome> sandy = biomeMap.get(Type.SANDY);
        Set<Biome> plains = biomeMap.get(Type.PLAINS);
        Set<Biome> swamp = biomeMap.get(Type.SWAMP);
        Set<Biome> spooky = biomeMap.get(Type.SPOOKY);
        Set<Biome> jungle = biomeMap.get(Type.JUNGLE);
        Set<Biome> snowy = biomeMap.get(Type.SNOWY);
        Set<Biome> mountain = biomeMap.get(Type.MOUNTAIN);
        Set<Biome> hills = biomeMap.get(Type.HILLS);

        Set<Biome> ocean = biomeMap.get(Type.OCEAN);
        Set<Biome> river = biomeMap.get(Type.RIVER);

        Set<Biome> water = new HashSet<>(ocean);
        water.addAll(river);

        Set<Biome> beach = biomeMap.get(Type.BEACH);

        Set<Biome> hell = biomeMap.get(Type.NETHER);
        Set<Biome> sky = biomeMap.get(Type.END);

        for (Biome biome : forest) {
            // forest, forestHills, birchForest, birchForestHills
            if (!BiomeDictionary.hasType(biome, Type.CONIFEROUS) && !BiomeDictionary.hasType(biome, Type.SNOWY) &&
                    !BiomeDictionary.hasType(biome, Type.MOUNTAIN) && !BiomeDictionary.hasType(biome, Type.SPOOKY) &&
                    !BiomeDictionary.hasType(biome, Type.MAGICAL)) {
                add(SpawnMandragora, EntityGaiaPropFlowerCyan.class, 1, 2, biome);
                add(SpawnDryad, EntityGaiaDryad.class, 4, 6, biome);
                add(SpawnWerecat, EntityGaiaWerecat.class, 4, 6, biome);
                add(SpawnSpriggan, EntityGaiaSpriggan.class, 2, 4, biome);

                underground(biome);
            }

            // taiga, taigaHills, megaTaiga, megaTaigaHills
            if (BiomeDictionary.hasType(biome, Type.CONIFEROUS) && (!BiomeDictionary.hasType(biome, Type.SNOWY))) {
                add(SpawnMandragora, EntityGaiaPropFlowerCyan.class, 1, 2, biome);
                add(SpawnCyclops, EntityGaiaCyclops.class, 4, 6, biome);
                add(SpawnYukiOnna, EntityGaiaYukiOnna.class, 2, 4, biome);
                add(SpawnFutakuchiOnna, EntityGaiaFutakuchiOnna.class, 4, 6, biome);
                add(SpawnNineTails, EntityGaiaNineTails.class, 2, 4, biome);

                underground(biome);
            }

            // coldTaiga, coldTaigaHills
            if (BiomeDictionary.hasType(biome, Type.CONIFEROUS) && (BiomeDictionary.hasType(biome, Type.SNOWY))) {
                add(SpawnDhampir, EntityGaiaDhampir.class, 2, 4, biome);

                if (!GaiaConfig.SpawnLevel3) {
                    add(SpawnVampire, EntityGaiaVampire.class, 1, 2, biome);
                }

                underground(biome);
            }

            // roofedForest
            if (BiomeDictionary.hasType(biome, Type.SPOOKY)) {
                add(SpawnMatango, EntityGaiaMatango.class, 2, 4, biome);
                add(SpawnToad, EntityGaiaToad.class, 2, 4, biome);
                add(SpawnWitch, EntityGaiaWitch.class, 2, 4, biome);

                underground(biome);
            }
        }

        // desert, desertHills, mesa, mesaPlateau, mesaPlateau_F
        for (Biome biome : sandy) {
            add(SpawnAnt, EntityGaiaAnt.class, 2, 4, biome);
            add(SpawnMummy, EntityGaiaMummy.class, 2, 4, biome);
            add(SpawnAnubis, EntityGaiaAnubis.class, 2, 4, biome);

            if (!GaiaConfig.SpawnLevel3) {
                add(SpawnSphinx, EntityGaiaSphinx.class, 1, 2, biome);
            }

            underground(biome);
        }

        // plains, savanna, savannaPlateau
        for (Biome biome : plains) {
            add(SpawnSatyress, EntityGaiaSatyress.class, 2, 4, biome);
            add(SpawnCentaur, EntityGaiaCentaur.class, 4, 6, biome);
            add(SpawnHarpy, EntityGaiaHarpy.class, 2, 4, biome);
            add(SpawnMinotaurus, EntityGaiaMinotaurus.class, 2, 4, biome);

            if (!GaiaConfig.SpawnLevel3) {
                add(SpawnMinotaur, EntityGaiaMinotaur.class, 1, 2, biome);
            }

            underground(biome);
        }

        // swamp
        for (Biome biome : swamp) {
            add(SpawnSiren, EntityGaiaSiren.class, 4, 6, biome);
            add(SpawnSludgeGirl, EntityGaiaSludgeGirl.class, 2, 4, biome);
            add(SpawnNaga, EntityGaiaNaga.class, 1, 2, biome);

            underground(biome);
        }

        // jungle
        for (Biome biome : jungle) {
            add(SpawnCobbleGolem, EntityGaiaCobbleGolem.class, 2, 4, biome);
            add(SpawnHunter, EntityGaiaHunter.class, 2, 4, biome);
            add(SpawnShaman, EntityGaiaShaman.class, 2, 4, biome);
            add(SpawnCobblestoneGolem, EntityGaiaCobblestoneGolem.class, 2, 4, biome);

            underground(biome);
        }

        // icePlains, iceMountains
        for (Biome biome : snowy) {
            if (!BiomeDictionary.hasType(biome, Type.CONIFEROUS) && !BiomeDictionary.hasType(biome, Type.FOREST) &&
                    !BiomeDictionary.hasType(biome, Type.OCEAN) && !BiomeDictionary.hasType(biome, Type.RIVER) &&
                    !BiomeDictionary.hasType(biome, Type.BEACH)) {
                add(SpawnSelkie, EntityGaiaSelkie.class, 2, 4, biome);
                add(SpawnKobold, EntityGaiaKobold.class, 4, 6, biome);
                add(SpawnYeti, EntityGaiaYeti.class, 2, 4, biome);

                underground(biome);
            }
        }

        // extremeHills, extremeHillsPlus
        for (Biome biome : mountain) {
            if (!BiomeDictionary.hasType(biome, Type.SNOWY)) {
                add(SpawnGryphon, EntityGaiaGryphon.class, 1, 2, biome);
                add(SpawnDwarf, EntityGaiaDwarf.class, 4, 6, biome);

                if (!GaiaConfig.SpawnLevel3) {
                    add(SpawnValkyrie, EntityGaiaValkyrie.class, 1, 2, biome);
                }

                add(SpawnDullahan, EntityGaiaDullahan.class, 4, 6, biome);
                add(SpawnBanshee, EntityGaiaBanshee.class, 2, 4, biome);

                underground(biome);
            }
        }

        // frozenRiver, coldBeach, stoneBeach, river, beach, ocean, deepOcean
        for (Biome biome : water) {
            aquatic(biome);
        }

        for (Biome biome : beach) {
            aquatic(biome);
        }

        // hell
        for (Biome biome : hell) {
            add(SpawnSuccubus, EntityGaiaSuccubus.class, 2, 4, biome);
            add(SpawnWitherCow, EntityGaiaWitherCow.class, 1, 2, biome);
            add(SpawnBaphomet, EntityGaiaBaphomet.class, 1, 2, biome);
        }

        // sky
        for (Biome biome : sky) {
            if (BiomeDictionary.hasType(biome, Type.COLD) && (BiomeDictionary.hasType(biome, Type.DRY))) {
                add(SpawnEnderDragonGirl, EntityGaiaEnderDragonGirl.class, 1, 2, biome);
            }
        }
    }

    /**
     * "Mutated" biomes don't have type dictionaries by default. This addition
     * compensates for specific sub biomes having gaps in creature spawning.
     */
    public static void Biome_Tweaks() {
        Gaia.LOGGER.info("Sub Biome Tweaks Enabled");

        BiomeDictionary.addTypes(Biomes.MUTATED_ROOFED_FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DENSE,
                BiomeDictionary.Type.FOREST);
        BiomeDictionary.addTypes(Biomes.MUTATED_EXTREME_HILLS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
        BiomeDictionary.addTypes(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
    }

    private static Map<Type, Set<Biome>> buildBiomeListByType() {
        Map<Type, Set<Biome>> biomesAndTypes = new HashMap<>();

        for (Biome biome : Biome.REGISTRY) {
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
            for (BiomeDictionary.Type type : types) {
                if (!biomesAndTypes.containsKey(type)) {
                    biomesAndTypes.put(type, new HashSet<>());
                }

                biomesAndTypes.get(type).add(biome);
            }
        }

        return biomesAndTypes;
    }
}
