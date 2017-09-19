package gaia;

//Level 3 mobs have a default rate of 40 due to them being summoned instead of spawning
public class GaiaConfig {

    public static boolean SpawnLevel3 = true;
    public static int SpawnLevel3Chance = 20;

    /*
     * 1.11.2 update feels like it messed around the way entities spawn The
     * following numbers are used for the biomes tagged (except for underground,
     * hell and sky) open; 60, 60 100,80 closed; 60, 60 80, 40
     */
    // closed; taiga, taigaHills, megaTaiga, megaTaigaHills
    public static int SpawnCyclops = 60;
    public static int SpawnYukiOnna = 60;
    public static int SpawnFutakuchiOnna = 80;
    public static int SpawnNineTails = 40;
    // closed; forest, forestHills, birchForest, birchForestHills
    public static int SpawnMandragora = 60;
    public static int SpawnDryad = 60;
    public static int SpawnWerecat = 80;
    public static int SpawnSpriggan = 40;
    // open; desert, desertHills, mesa, mesaPlateau, mesaPlateau_F
    public static int SpawnAnt = 30;
    public static int SpawnMummy = 100;
    public static int SpawnAnubis = 80;
    public static int SpawnSphinx = 40;
    // open; plains, savanna, savannaPlateau
    public static int SpawnSatyress = 30;
    public static int SpawnCentaur = 30;
    public static int SpawnHarpy = 100;
    public static int SpawnMinotaurus = 80;
    public static int SpawnMinotaur = 40;
    // closed; swamp
    public static int SpawnSiren = 60;
    public static int SpawnSludgeGirl = 100;
    public static int SpawnNaga = 80;
    // closed; roofedForest
    public static int SpawnMatango = 60;
    public static int SpawnToad = 80;
    public static int SpawnWitch = 60;
    // closed; jungle
    public static int SpawnHunter = 60;
    public static int SpawnCobbleGolem = 60;
    public static int SpawnShaman = 60;
    public static int SpawnCobblestoneGolem = 60;
    // open; icePlains, iceMountains
    public static int SpawnSelkie = 60;
    public static int SpawnKobold = 100;
    public static int SpawnYeti = 80;
    // closed; coldTaiga, coldTaigaHills
    public static int SpawnDhampir = 80;
    public static int SpawnVampire = 40;
    // open; extremeHills, extremeHillsPlus
    public static int SpawnDwarf = 30;
    public static int SpawnGryphon = 60;
    public static int SpawnValkyrie = 40;
    public static int SpawnDullahan = 100;
    public static int SpawnBanshee = 80;
    // closed; frozenRiver, coldBeach, stoneBeach, river, beach, ocean,
    // deepOcean
    public static int SpawnSahuagin = 80;
    public static int SpawnMermaid = 40;
    public static int SpawnSharko = 40;
    // closed; underground
    public static int SpawnCreep = 80;
    public static int SpawnEnderEye = 40;
    public static int SpawnArachne = 80;
    public static int SpawnMimic = 80;
    public static int SpawnBoneKnight = 40;
    public static int SpawnFleshLich = 40;
    // closed; hell
    public static int SpawnSuccubus = 16;
    public static int SpawnWitherCow = 8;
    public static int SpawnBaphomet = 8;
    // open; sky
    public static int SpawnEnderDragonGirl = 4;

    // Base Damage
    public static boolean BaseDamage = true;
    public static boolean ShieldsBlockPiercing = true;
    public static boolean BaseDamageArchers = true;

    // Base Defense
    public static int Tier1baseDefense = 2;
    public static int Tier2baseDefense = 4;
    public static int Tier3baseDefense = 8;

    // Attributes
    public static int Tier1maxHealth = 100;
    public static int Tier1attackDamage = 100;
    public static int Tier2maxHealth = 100;
    public static int Tier2attackDamage = 100;
    public static int Tier3maxHealth = 100;
    public static int Tier3attackDamage = 100;

    // Options
    public static boolean Enable_Spawn = true;
    public static boolean AdditionalOre = false;
    public static boolean StrafingArchers = true;

    // Debug
    public static boolean Biome_Tweaks = true;
    public static boolean OreUnity = false;
    public static boolean Debug_Commands = true;
    public static boolean Debug_Spawn = false;
}
