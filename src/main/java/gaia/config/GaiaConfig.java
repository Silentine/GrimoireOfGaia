package gaia.config;

import gaia.Gaia;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;

import java.util.Arrays;
import java.util.List;

public class GaiaConfig {
    public static class Common {
        //spawn rates
        public final IntValue spawnEnderDragonGirl;
        public final IntValue spawnVaseNether;
        public final IntValue spawnSuccubus;
        public final IntValue spawnWitherCow;
        public final IntValue spawnBaphomet;

        public final IntValue spawnCecaelia;
        public final IntValue spawnMermaid;
        public final IntValue spawnSharko;

        public final IntValue spawnDwarf;
        public final IntValue spawnGryphon;
        public final IntValue spawnValkyrie;
        public final IntValue spawnDullahan;
        public final IntValue spawnBanshee;
        public final IntValue spawnCampsite;

        public final IntValue spawnSelkie;
        public final IntValue spawnKobold;
        public final IntValue spawnYeti;

        public final IntValue spawnHunter;
        public final IntValue spawnCobbleGolem;
        public final IntValue spawnShaman;
        public final IntValue spawnCobblestoneGolem;

        public final IntValue spawnSiren;
        public final IntValue spawnNaga;
        public final IntValue spawnSludgeGirl;
        public final IntValue spawnGelatinousSlime;

        public final IntValue spawnSatyress;
        public final IntValue spawnCentaur;
        public final IntValue spawnHarpy;
        public final IntValue spawnMinotaurus;
        public final IntValue spawnMinotaur;

        public final IntValue spawnGoblin;
        public final IntValue spawnOrc;

        public final IntValue spawnAnt;
        public final IntValue spawnAntRanger;
        public final IntValue spawnMummy;
        public final IntValue spawnAnubis;
        public final IntValue spawnSphinx;

        public final IntValue spawnDryad;
        public final IntValue spawnBee;
        public final IntValue spawnMandragora;
        public final IntValue spawnWerecat;
        public final IntValue spawnSpriggan;

        public final IntValue spawnCyclops;
        public final IntValue spawnYukiOnna;
        public final IntValue spawnOni;
        public final IntValue spawnNineTails;

        public final IntValue spawnKikimora;
        public final IntValue spawnDhampir;
        public final IntValue spawnVampire;

        public final IntValue spawnMatango;
        public final IntValue spawnToad;
        public final IntValue spawnWitch;

        public final IntValue spawnVase;
        public final IntValue spawnCreep;
        public final IntValue spawnEnderEye;
        public final IntValue spawnArachne;
        public final IntValue spawnMimic;
        public final IntValue spawnDeathword;
        public final IntValue spawnBoneKnight;
        public final IntValue spawnFleshLich;

        //spawn options
        public final BooleanValue spawnDaysPassed;
        public final IntValue spawnDaysSet;
        public final BooleanValue spawnLevel3Rain;
        public final BooleanValue spawnLevel3;
        public final IntValue spawnLevel3Chance;
        public final ConfigValue <List<String>> additionalSpawnBlocks;
        public final ConfigValue <List<String>> additionalFlowerSpawnBlocks;

        //attributes
        public final IntValue tier1maxHealth;
        public final IntValue tier1attackDamage;
        public final IntValue tier2maxHealth;
        public final IntValue tier2attackDamage;
        public final IntValue tier3maxHealth;
        public final IntValue tier3attackDamage;

        //Base Damage
        public final BooleanValue baseDamage;
        public final BooleanValue shieldsBlockPiercing;
        public final BooleanValue baseDamageArchers;

        //Base Damage Cap
        public final IntValue tier1baseDefense;
        public final IntValue tier2baseDefense;
        public final IntValue tier3baseDefense;

        //Options
        public final BooleanValue enableSpawn;
        public final BooleanValue passiveHostileMobs;
        public final BooleanValue passiveHostileAllMobs;
        public final BooleanValue additionalOre;
        public final BooleanValue strafingArchers;

        //Dimension
        public final ConfigValue <List<String>> dimensionBlacklist;

        //Debug
        public final BooleanValue oreUnity;
        public final BooleanValue debugCommands;
        public final BooleanValue debugSpawn;

        Common(ForgeConfigSpec.Builder builder) {
            //SPAWN RATES
            builder.comment("Spawn Rates")
                    .push("spawnrates");

            spawnEnderDragonGirl = builder
                    .comment("Ender Dragon Girl")
                    .translation("entity.grimoireofgaia.ender_dragon_girl.name")
                    .defineInRange("spawnEnderDragonGirl", 4, 0, 200);

            spawnVaseNether = builder
                    .comment("Ancient Vase (Nether)")
                    .translation("entity.grimoireofgaia.vase_nether.name")
                    .defineInRange("spawnVaseNether", 12, 0, 200);

            spawnSuccubus = builder
                    .comment("Succubus")
                    .translation("entity.grimoireofgaia.succubus.name")
                    .defineInRange("spawnSuccubus", 16, 0, 200);

            spawnWitherCow = builder
                    .comment("Wither Cow")
                    .translation("entity.grimoireofgaia.baphomet.name")
                    .defineInRange("spawnWitherCow", 12, 0, 200);

            spawnBaphomet = builder
                    .comment("Baphomet")
                    .translation("entity.grimoireofgaia.baphomet.name")
                    .defineInRange("spawnBaphomet", 12, 0, 200);

            spawnCecaelia = builder
                    .comment("Cecaelia")
                    .translation("entity.grimoireofgaia.cecaelia.name")
                    .defineInRange("spawnCecaelia", 80, 0, 200);

            spawnMermaid = builder
                    .comment("Mermaid")
                    .translation("entity.grimoireofgaia.mermaid.name")
                    .defineInRange("spawnMermaid", 40, 0, 200);

            spawnSharko = builder
                    .comment("Sharko")
                    .translation("entity.grimoireofgaia.sharko.name")
                    .defineInRange("spawnSharko", 40, 0, 200);

            spawnDwarf = builder
                    .comment("Dwarf")
                    .translation("entity.grimoireofgaia.dwarf.name")
                    .defineInRange("spawnDwarf", 30, 0, 200);

            spawnGryphon = builder
                    .comment("Gryphon")
                    .translation("entity.grimoireofgaia.gryphon.name")
                    .defineInRange("spawnGryphon", 60, 0, 200);

            spawnValkyrie = builder
                    .comment("Valkyrie")
                    .translation("entity.grimoireofgaia.valkyrie.name")
                    .defineInRange("spawnValkyrie", 40, 0, 200);

            spawnDullahan = builder
                    .comment("Dullahan")
                    .translation("entity.grimoireofgaia.dullahan.name")
                    .defineInRange("spawnSspawnDullahanharko", 100, 0, 200);

            spawnBanshee = builder
                    .comment("Banshee")
                    .translation("entity.grimoireofgaia.campfire.name")
                    .defineInRange("spawnBanshee", 80, 0, 200);

            spawnCampsite = builder
                    .comment("Campsite")
                    .translation("entity.grimoireofgaia.banshee.name")
                    .defineInRange("spawnCampsite", 80, 0, 200);

            spawnSelkie = builder
                    .comment("Selkie")
                    .translation("entity.grimoireofgaia.selkie.name")
                    .defineInRange("spawnSelkie", 60, 0, 200);

            spawnKobold = builder
                    .comment("Kobold")
                    .translation("entity.grimoireofgaia.kobold.name")
                    .defineInRange("spawnKobold", 60, 0, 200);

            spawnYeti = builder
                    .comment("Yeti")
                    .translation("entity.grimoireofgaia.yeti.name")
                    .defineInRange("spawnYeti", 80, 0, 200);

            spawnHunter = builder
                    .comment("Hunter")
                    .translation("entity.grimoireofgaia.hunter.name")
                    .defineInRange("spawnHunter", 60, 0, 200);

            spawnCobbleGolem = builder
                    .comment("Cobble Golem")
                    .translation("entity.grimoireofgaia.cobble_golem.name")
                    .defineInRange("spawnCobbleGolem", 60, 0, 200);

            spawnShaman = builder
                    .comment("Shaman")
                    .translation("entity.grimoireofgaia.shaman.name")
                    .defineInRange("spawnShaman", 60, 0, 200);

            spawnCobblestoneGolem = builder
                    .comment("Cobblestone Golem")
                    .translation("entity.grimoireofgaia.cobblestone_golem.name")
                    .defineInRange("spawnCobblestoneGolem", 60, 0, 200);

            spawnSiren = builder
                    .comment("Siren")
                    .translation("entity.grimoireofgaia.siren.name")
                    .defineInRange("spawnSiren", 60, 0, 200);

            spawnNaga = builder
                    .comment("Naga")
                    .translation("entity.grimoireofgaia.naga.name")
                    .defineInRange("spawnNaga", 30, 0, 200);

            spawnSludgeGirl = builder
                    .comment("Sludge Girl")
                    .translation("entity.grimoireofgaia.sludge_girl.name")
                    .defineInRange("spawnSludgeGirl", 100, 0, 200);

            spawnGelatinousSlime = builder
                    .comment("Gelatinous Slime")
                    .translation("entity.grimoireofgaia.gelatinous_slime.name")
                    .defineInRange("spawnGelatinousSlime", 80, 0, 200);

            spawnSatyress = builder
                    .comment("Satyress")
                    .translation("entity.grimoireofgaia.satyress.name")
                    .defineInRange("spawnSatyress", 20, 0, 200);

            spawnCentaur = builder
                    .comment("Centaur")
                    .translation("entity.grimoireofgaia.centaur.name")
                    .defineInRange("spawnCentaur", 20, 0, 200);

            spawnHarpy = builder
                    .comment("Harpy")
                    .translation("entity.grimoireofgaia.harpy.name")
                    .defineInRange("spawnHarpy", 100, 0, 200);

            spawnMinotaurus = builder
                    .comment("Minotaurus")
                    .translation("entity.grimoireofgaia.minotaurus.name")
                    .defineInRange("spawnMinotaurus", 80, 0, 200);

            spawnMinotaur = builder
                    .comment("Minotaur")
                    .translation("entity.grimoireofgaia.minotaur.name")
                    .defineInRange("spawnMinotaur", 40, 0, 200);

            spawnGoblin = builder
                    .comment("Goblin")
                    .translation("entity.grimoireofgaia.goblin.name")
                    .defineInRange("spawnGoblin", 30, 0, 200);

            spawnOrc = builder
                    .comment("Orc")
                    .translation("entity.grimoireofgaia.orc.name")
                    .defineInRange("spawnOrc", 80, 0, 200);

            spawnAnt = builder
                    .comment("Ant Worker")
                    .translation("entity.grimoireofgaia.ant.name")
                    .defineInRange("spawnAnt", 20, 0, 200);

            spawnAntRanger = builder
                    .comment("Ant Salvager")
                    .translation("entity.grimoireofgaia.ant_ranger.name")
                    .defineInRange("spawnAntRanger", 20, 0, 200);

            spawnMummy = builder
                    .comment("Mummy")
                    .translation("entity.grimoireofgaia.mummy.name")
                    .defineInRange("spawnMummy", 100, 0, 200);

            spawnAnubis = builder
                    .comment("Anubis")
                    .translation("entity.grimoireofgaia.anubis.name")
                    .defineInRange("spawnAnubis", 80, 0, 200);

            spawnSphinx = builder
                    .comment("Sphinx")
                    .translation("entity.grimoireofgaia.sphinx.name")
                    .defineInRange("spawnSphinx", 40, 0, 200);


            spawnDryad = builder
                    .comment("Dryad")
                    .translation("entity.grimoireofgaia.dryad.name")
                    .defineInRange("spawnDryad", 60, 0, 200);


            spawnBee = builder
                    .comment("Bee")
                    .translation("entity.grimoireofgaia.bee.name")
                    .defineInRange("spawnBee", 40, 0, 200);


            spawnMandragora = builder
                    .comment("Mandragora")
                    .translation("entity.grimoireofgaia.mandragora.name")
                    .defineInRange("spawnMandragora", 60, 0, 200);


            spawnWerecat = builder
                    .comment("Werecat")
                    .translation("entity.grimoireofgaia.werecat.name")
                    .defineInRange("spawnWerecat", 80, 0, 200);


            spawnSpriggan = builder
                    .comment("Spriggan")
                    .translation("entity.grimoireofgaia.spriggan.name")
                    .defineInRange("spawnSpriggan", 40, 0, 200);

            spawnCyclops = builder
                    .comment("Cyclops")
                    .translation("entity.grimoireofgaia.cyclops.name")
                    .defineInRange("spawnCyclops", 40, 0, 200);

            spawnYukiOnna = builder
                    .comment("Yuki-Onna")
                    .translation("entity.grimoireofgaia.yuki-onna.name")
                    .defineInRange("spawnYukiOnna", 60, 0, 200);

            spawnOni = builder
                    .comment("Oni")
                    .translation("entity.grimoireofgaia.oni.name")
                    .defineInRange("spawnOni", 80, 0, 200);

            spawnNineTails = builder
                    .comment("Nine Tails")
                    .translation("entity.grimoireofgaia.nine_tails.name")
                    .defineInRange("spawnNineTails", 40, 0, 200);

            spawnKikimora = builder
                    .comment("Kikimora")
                    .translation("entity.grimoireofgaia.kikimora.name")
                    .defineInRange("spawnKikimora", 40, 0, 200);

            spawnDhampir = builder
                    .comment("Dhampir")
                    .translation("entity.grimoireofgaia.dhampir.name")
                    .defineInRange("spawnDhampir", 80, 0, 200);

            spawnVampire = builder
                    .comment("Vampire")
                    .translation("entity.grimoireofgaia.vampire.name")
                    .defineInRange("spawnVampire", 40, 0, 200);

            spawnMatango = builder
                    .comment("Matango")
                    .translation("entity.grimoireofgaia.matango.name")
                    .defineInRange("spawnMatango", 60, 0, 200);

            spawnToad = builder
                    .comment("Toad")
                    .translation("entity.grimoireofgaia.toad.name")
                    .defineInRange("spawnToad", 80, 0, 200);

            spawnWitch = builder
                    .comment("Witch")
                    .translation("entity.grimoireofgaia.witch.name")
                    .defineInRange("spawnWitch", 60, 0, 200);

            spawnVase = builder
                    .comment("Ancient Vase")
                    .translation("entity.grimoireofgaia.vase.name")
                    .defineInRange("spawnVase", 40, 0, 200);

            spawnCreep = builder
                    .comment("Creep")
                    .translation("entity.grimoireofgaia.creep.name")
                    .defineInRange("spawnCreep", 80, 0, 200);

            spawnEnderEye = builder
                    .comment("Ender Eye")
                    .translation("entity.grimoireofgaia.ender_eye.name")
                    .defineInRange("spawnEnderEye", 40, 0, 200);

            spawnArachne = builder
                    .comment("Arachne")
                    .translation("entity.grimoireofgaia.arachne.name")
                    .defineInRange("spawnArachne", 80, 0, 200);

            spawnMimic = builder
                    .comment("Mimic")
                    .translation("entity.grimoireofgaia.mimic.name")
                    .defineInRange("spawnMimic", 40, 0, 200);

            spawnDeathword = builder
                    .comment("Deathword")
                    .translation("entity.grimoireofgaia.deathword.name")
                    .defineInRange("spawnDeathword", 40, 0, 200);

            spawnBoneKnight = builder
                    .comment("Bone Knight")
                    .translation("entity.grimoireofgaia.bone_knight.name")
                    .defineInRange("spawnBoneKnight", 40, 0, 200);

            spawnFleshLich = builder
                    .comment("Flesh Lich")
                    .translation("entity.grimoireofgaia.flesh_lich.name")
                    .defineInRange("spawnFleshLich", 40, 0, 200);

            builder.pop();
            //SPAWN OPTIONS
            builder.comment("Spawn Options")
                    .push("spawnoptions");

            spawnDaysPassed = builder
                    .comment("Mobs only spawn after a certain amount of days have passed")
                    .translation("configgui.grimoireofgaia.category.spawn.Menu0.SpawnDaysPassed")
                    .define("spawnDaysPassed", false);

            spawnDaysSet = builder
                    .comment("Amount of days required to have passed before they can start spawning")
                    .translation("configgui.grimoireofgaia.category.spawn.Menu1.SpawnDaysSet")
                    .defineInRange("spawnDaysSet", 3, 0, Integer.MAX_VALUE);

            spawnLevel3Rain = builder
                    .comment("Level 3 mobs only spawn when it is raining/snowing.")
                    .translation("configgui.grimoireofgaia.category.spawn.Menu2.SpawnLevel3Rain")
                    .define("spawnLevel3Rain",  false);

            spawnLevel3 = builder
                    .comment("Level 3 mobs do not spawn naturally but instead spawn from specific mobs.")
                    .translation("configgui.grimoireofgaia.category.spawn.Menu3.SpawnLevel3")
                    .define("spawnLevel3",  false);

            spawnLevel3Chance = builder
                    .comment("Chance that Level 3 mobs spawn from specific mobs. ((1/value)*100)")
                    .translation("configgui.grimoireofgaia.category.spawn.Menu4.SpawnLevel3Chance")
                    .defineInRange("spawnLevel3Chance", 20, 0, Integer.MAX_VALUE);

            String[] additionalSpawnList = new String[]
                    {
                            ""
                    };

            additionalSpawnBlocks = builder
                    .comment("Additional Blocks Gaia mobs can spawn on")
                    .translation("configgui.grimoireofgaia.category.spawn.Menu5.AdditionalSpawnBlocks")
                    .define("additionalSpawnBlocks", Arrays.asList(additionalSpawnList), o -> o instanceof String);

            String[] additionalFlowerSpawnList = new String[]
                    {
                            ""
                    };

            additionalFlowerSpawnBlocks = builder
                    .comment("Additional Blocks Gaia flower can spawn on")
                    .translation("configgui.grimoireofgaia.category.spawn.Menu6.AdditionalFlowerSpawnBlocks")
                    .define("additionalFlowerSpawnBlocks", Arrays.asList(additionalFlowerSpawnList), o -> o instanceof String);

            builder.pop();
            //ATTRIBUTES
            builder.comment("Attributes")
                    .push("attributes");

            tier1maxHealth = builder
                    .comment("Health: 40 (20 Hearts). (50 = half, 200 = double)")
                    .translation("configgui.grimoireofgaia.category.attributes.Tier1maxHealth")
                    .defineInRange("tier1maxHealth", 100, 0, Integer.MAX_VALUE);

            tier1attackDamage = builder
                    .comment("Damage: 4 (2 Hearts). (50 = half, 200 = double)")
                    .translation("configgui.grimoireofgaia.category.attributes.Tier1attackDamage")
                    .defineInRange("tier1attackDamage", 100, 0, Integer.MAX_VALUE);

            tier2maxHealth = builder
                    .comment("Health: 80 (40 Hearts). (50 = half, 200 = double)")
                    .translation("configgui.grimoireofgaia.category.attributes.Tier2maxHealth")
                    .defineInRange("tier2maxHealth", 100, 0, Integer.MAX_VALUE);

            tier2attackDamage = builder
                    .comment("Damage: 6 (3 Hearts). (50 = half, 200 = double)")
                    .translation("configgui.grimoireofgaia.category.attributes.Tier2attackDamage")
                    .defineInRange("tier2attackDamage", 100, 0, Integer.MAX_VALUE);

            tier3maxHealth = builder
                    .comment("Health: 160 (80 Hearts). (50 = half, 200 = double)")
                    .translation("configgui.grimoireofgaia.category.attributes.Tier3maxHealth")
                    .defineInRange("tier3maxHealth", 100, 0, Integer.MAX_VALUE);

            tier3attackDamage = builder
                    .comment("Damage: 8 (4 Hearts). (50 = half, 200 = double)")
                    .translation("configgui.grimoireofgaia.category.attributes.Tier3attackDamage")
                    .defineInRange("tier3attackDamage", 100, 0, Integer.MAX_VALUE);

            builder.pop();
            //BASE DAMAGE

            builder.comment("Base Damage")
                    .push("basedamage");

            baseDamage = builder
                    .comment("Melee attacks deal an additional 2.0 (1 heart) of damage")
                    .translation("configgui.grimoireofgaia.category.damage.Menu0.BaseDamage")
                    .define("baseDamage", true);

            shieldsBlockPiercing = builder
                    .comment("Shields Block Piercing Damage")
                    .translation("configgui.grimoireofgaia.category.damage.Menu2.ShieldsBlockPiercing")
                    .define("shieldsBlockPiercing", true);

            baseDamageArchers = builder
                    .comment("Base Damage (Archers)")
                    .translation("configgui.grimoireofgaia.category.damage.Menu1.BaseDamageArchers")
                    .define("baseDamageArchers", true);

            builder.pop();
            //BASE DAMAGE CAP
            builder.comment("Base Damage Cap")
                    .push("basedamagecap");

            tier1baseDefense = builder
                    .comment("Maximum amount of hits required. (0 = disable)")
                    .translation("configgui.grimoireofgaia.category.defense.Tier1baseDefense")
                    .defineInRange("tier1baseDefense", 2, 0, Integer.MAX_VALUE);

            tier2baseDefense = builder
                    .comment("Maximum amount of hits required. (0 = disable)")
                    .translation("configgui.grimoireofgaia.category.defense.Tier2baseDefense")
                    .defineInRange("tier2baseDefense", 4, 0, Integer.MAX_VALUE);

            tier3baseDefense = builder
                    .comment("Maximum amount of hits required. (0 = disable)")
                    .translation("configgui.grimoireofgaia.category.defense.Tier3baseDefense")
                    .defineInRange("tier3baseDefense", 8, 0, Integer.MAX_VALUE);

            builder.pop();
            //OPTIONS
            builder.comment("Options")
                    .push("options");

            enableSpawn = builder
                    .comment("Enable Gaia mobs to spawn")
                    .translation("configgui.grimoireofgaia.category.options.Menu0.Enable_Spawn")
                    .define("enableSpawn", true);

            passiveHostileMobs = builder
                    .comment("Hostile day mobs will no longer attack players on sight")
                    .translation("configgui.grimoireofgaia.category.options.Menu1.Passive_Hostile_Mobs")
                    .define("passiveHostileMobs", false);

            passiveHostileAllMobs = builder
                    .comment("All mobs are now hostile")
                    .translation("configgui.grimoireofgaia.category.options.Menu2.Passive_Hostile_All_Mobs")
                    .define("passiveHostileAllMobs", false);

            additionalOre = builder
                    .comment("Gaia mobs can now drop Copper and Silver Nuggets")
                    .translation("configgui.grimoireofgaia.category.options.Menu3.AdditionalOre")
                    .define("additionalOre", false);

            strafingArchers = builder
                    .comment("Archers will strafe and avoid attacks (like Skeletons)")
                    .translation("configgui.grimoireofgaia.category.options.Menu4.StrafingArchers")
                    .define("strafingArchers", true);

            builder.pop();
            //DIMENSION
            builder.comment("Dimensional Settings")
                    .push("dimensionalsettings");

            String[] dimensionBlacklistList = new String[]
                    {
                            ""
                    };

            dimensionBlacklist = builder
                    .comment("Disables Gaia mobs from spawning in the specified dimension ids")
                    .translation("configgui.grimoireofgaia.category.dimensions.Menu0.Dimension_Blacklist")
                    .define("dimensionBlacklist", Arrays.asList(dimensionBlacklistList), o -> o instanceof String);

            builder.pop();
            //Debug
            builder.comment("Debug")
                    .push("debug");

            oreUnity = builder
                    .comment("Mobs can drop nuggets/shards from other mods. (Disable if you encounter issues)")
                    .translation("configgui.grimoireofgaia.category.debug.Menu0.Ore_Unity")
                    .define("oreUnity", false);

            debugCommands = builder
                    .comment("Disables all non-Gaia mobs from spawning")
                    .translation("configgui.grimoireofgaia.category.debug.Menu1.Debug_Spawn")
                    .define("debugCommands", false);

            debugSpawn = builder
                    .comment("Enables developer commands")
                    .translation("configgui.grimoireofgaia.category.debug.Menu2.Debug_Commands")
                    .define("debugSpawn", false);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {
        Gaia.LOGGER.debug("Loaded forge config file {}", configEvent.getConfig().getFileName());
    }

    @SubscribeEvent
    public static void onFileChange(final ModConfig.ConfigReloading configEvent) {
        Gaia.LOGGER.fatal("Forge config just got changed on the file system!");
    }
}
