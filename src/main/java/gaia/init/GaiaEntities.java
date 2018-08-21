package gaia.init;

import java.util.ArrayList;
import java.util.List;

import gaia.Gaia;
import gaia.GaiaReference;
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
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
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
import gaia.entity.monster.EntityGaiaSummonButler;
import gaia.entity.monster.EntityGaiaSummonSporeling;
import gaia.entity.monster.EntityGaiaToad;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.entity.passive.EntityGaiaNPCTrader;
import gaia.entity.passive.EntityGaiaNPCWeresheep;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class GaiaEntities {

    public static List<EntityEntry> ENTITIES = new ArrayList<>();
    public static List<EntityEntry> SPAWN_ENTITIES = new ArrayList<>();
    static int ID = 0;

    private static EntityEntry createEntityEntry(String name, Class<? extends Entity> cls) {
        EntityEntry entityEntry = new EntityEntry(cls, name);
        entityEntry.setRegistryName(new ResourceLocation(GaiaReference.MOD_PREFIX + name.toLowerCase()));
        ENTITIES.add(entityEntry);
        return entityEntry;
    }

    private static EntityEntry createEntityEntry(String name, Class<? extends Entity> cls, int primaryColorIn, int secondaryColorIn) {
        EntityEntry entityEntry = new EntityEntry(cls, name);
        entityEntry.setRegistryName(new ResourceLocation(GaiaReference.MOD_PREFIX + name.toLowerCase()));
        entityEntry.setEgg(new EntityEggInfo(new ResourceLocation(GaiaReference.MOD_PREFIX + name.toLowerCase()), primaryColorIn, secondaryColorIn));
        SPAWN_ENTITIES.add(entityEntry);
        return entityEntry;
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String entityName) {
        EntityRegistry.registerModEntity(new ResourceLocation(GaiaReference.MOD_PREFIX + entityName.toLowerCase()), entityClass, GaiaReference.MOD_PREFIX + entityName.toLowerCase(), ID, Gaia.instance, 64, 3, true);
        ID++;
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int eggColor, int eggDotsColor) {
        EntityRegistry.registerModEntity(new ResourceLocation(GaiaReference.MOD_PREFIX + entityName.toLowerCase()), entityClass, GaiaReference.MOD_PREFIX + entityName.toLowerCase(), ID, Gaia.instance, 64, 3, true, eggColor, eggDotsColor);
        ID++;
    }

    public static EntityEntry ANT = createEntityEntry("Ant", EntityGaiaAnt.class, 0x303030, 0x8a7264);
    public static EntityEntry ANUBIS = createEntityEntry("Anubis", EntityGaiaAnubis.class, 0x353535, 0xb19534);
    public static EntityEntry ARACHNE = createEntityEntry("Arachne", EntityGaiaArachne.class, 3815994, 11013646);
    public static EntityEntry BANSHEE = createEntityEntry("Banshee", EntityGaiaBanshee.class, 0xeed2e8, 0xc6b0ed);
    public static EntityEntry BAPHOMET = createEntityEntry("Baphomet", EntityGaiaBaphomet.class, 3559756, 14197864);
    public static EntityEntry BONE_KNIGHT = createEntityEntry("BoneKnight", EntityGaiaBoneKnight.class, 4602533, 13619151);
    public static EntityEntry CENTAUR = createEntityEntry("Centaur", EntityGaiaCentaur.class, 0x8d4f41, 0x353535);
    public static EntityEntry PROP_CHEST_MIMIC = createEntityEntry("Chest", EntityGaiaPropChestMimic.class, 11237677, 4274991);
    public static EntityEntry COBBLE_GOLEM = createEntityEntry("CobbleGolem", EntityGaiaCobbleGolem.class, 11513775, 11513775);
    public static EntityEntry COBBLESTONE_GOLEM = createEntityEntry("CobblestoneGolem", EntityGaiaCobblestoneGolem.class, 11513775, 11513775);
    public static EntityEntry CREEP = createEntityEntry("Creep", EntityGaiaCreep.class, 7917159, 2053400);
    public static EntityEntry CYCLOPS = createEntityEntry("Cyclops", EntityGaiaCyclops.class, 4936602, 3487029);
    public static EntityEntry PROP_FLOWER_CYAN = createEntityEntry("CyanFlower", EntityGaiaPropFlowerCyan.class, 1073920, 4045287);
    public static EntityEntry DHAMPIR = createEntityEntry("Dhampir", EntityGaiaDhampir.class, 0x9c1c2b, 0xc9b161);
    public static EntityEntry DRYAD = createEntityEntry("Dryad", EntityGaiaDryad.class, 10255437, 5681460);
    public static EntityEntry DULLAHAN = createEntityEntry("Dullahan", EntityGaiaDullahan.class, 0x824fab, 0xa4452d);
    public static EntityEntry DWARF = createEntityEntry("Dwarf", EntityGaiaDwarf.class, 0x969696, 0xf09942);
    public static EntityEntry ENDER_DRAGON_GIRL = createEntityEntry("EnderDragonGirl", EntityGaiaEnderDragonGirl.class, 3158064, 14711290);
    public static EntityEntry ENDER_EYE = createEntityEntry("EnderEye", EntityGaiaEnderEye.class, 2039583, 3158064);
    public static EntityEntry FLESHLICH = createEntityEntry("FleshLich", EntityGaiaFleshLich.class, 0x00cccc, 0x799c65);
    public static EntityEntry FUTAKUCHI_ONNA = createEntityEntry("FutakuchiOnna", EntityGaiaFutakuchiOnna.class, 0x4e3738, 0xb43434);
    public static EntityEntry GRYPHON = createEntityEntry("Gryphon", EntityGaiaGryphon.class, 0xf09942, 0xe2e2e2);
    public static EntityEntry HARPY = createEntityEntry("Harpy", EntityGaiaHarpy.class, 0xc9b161, 0xa5884e);
    public static EntityEntry HUNTER = createEntityEntry("Hunter", EntityGaiaHunter.class, 0xae6b3c, 0x353535);
    public static EntityEntry KOBOLD = createEntityEntry("Kobold", EntityGaiaKobold.class, 0x938dab, 0xafa7c1);
    public static EntityEntry MATANGO = createEntityEntry("Matango", EntityGaiaMatango.class, 0xab1311, 0xd8d8d8);
    public static EntityEntry MERMAID = createEntityEntry("Mermaid", EntityGaiaMermaid.class, 0x5c70b1, 0xa4452d);
    public static EntityEntry MINOTAUR = createEntityEntry("Minotaur", EntityGaiaMinotaur.class, 0x8d4f41, 0xd54242);
    public static EntityEntry MINOTAURUS = createEntityEntry("Minotaurus", EntityGaiaMinotaurus.class, 0x8d4f41, 0xa9a9a9);
    public static EntityEntry MUMMY = createEntityEntry("Mummy", EntityGaiaMummy.class, 0xdcd7c1, 0xc9b161);
    public static EntityEntry NAGA = createEntityEntry("Naga", EntityGaiaNaga.class, 0x29bc55, 0xccb63f);
    public static EntityEntry NINE_TAILS = createEntityEntry("NineTails", EntityGaiaNineTails.class, 11809844, 13218145);
    public static EntityEntry SAHUAGIN = createEntityEntry("Sahuagin", EntityGaiaSahuagin.class, 0x5c70b1, 0x84a498);
    public static EntityEntry SATYRESS = createEntityEntry("Satyress", EntityGaiaSatyress.class, 0x707b4f, 0xa4452d);
    public static EntityEntry SELKIE = createEntityEntry("Selkie", EntityGaiaSelkie.class, 9082818, 13488612);
    public static EntityEntry SHAMAN = createEntityEntry("Shaman", EntityGaiaShaman.class, 0xae6b3c, 0x56b134);
    public static EntityEntry SHARKO = createEntityEntry("Sharko", EntityGaiaSharko.class, 0x84a498, 0x5c70b1);
    public static EntityEntry SIREN = createEntityEntry("Siren", EntityGaiaSiren.class, 0x29bc55, 0x48a0de);
    public static EntityEntry SLUDGE_GIRL = createEntityEntry("SludgeGirl", EntityGaiaSludgeGirl.class, 6595667, 7715172);
    public static EntityEntry SPHINX = createEntityEntry("Sphinx", EntityGaiaSphinx.class, 0xf09942, 0x353535);
    public static EntityEntry SPRIGGAN = createEntityEntry("Spriggan", EntityGaiaSpriggan.class, 0x7c623e, 0xc2dda5);
    public static EntityEntry SUCCUBUS = createEntityEntry("Succubus", EntityGaiaSuccubus.class, 4079166, 13218145);
    public static EntityEntry TOAD = createEntityEntry("Toad", EntityGaiaToad.class, 0x355d2b, 0x779f5a);
    public static EntityEntry VALKYRIE = createEntityEntry("Valkyrie", EntityGaiaValkyrie.class, 0xc9b161, 0xd54242);
    public static EntityEntry VAMPIRE = createEntityEntry("Vampire", EntityGaiaVampire.class, 0xc23021, 0xc9b161);
    public static EntityEntry WERECAT = createEntityEntry("Werecat", EntityGaiaWerecat.class, 0x7a7e8a, 0xdddadb);
    public static EntityEntry WITCH = createEntityEntry("Witch", EntityGaiaWitch.class, 0x303030, 0x943dbb);
    public static EntityEntry WITHER_COW = createEntityEntry("WitherCow", EntityGaiaWitherCow.class, 5791069, 16777215);
    public static EntityEntry YETI = createEntityEntry("Yeti", EntityGaiaYeti.class, 16448250, 7895160);
    public static EntityEntry YUKI_ONNA = createEntityEntry("Yuki-Onna", EntityGaiaYukiOnna.class, 6781114, 13817330);

    // NPC
    public static EntityEntry CREEPER_GIRL = createEntityEntry("CreeperGirl", EntityGaiaNPCCreeperGirl.class);
    public static EntityEntry SLIME_GIRL = createEntityEntry("SlimeGirl", EntityGaiaNPCSlimeGirl.class);
    public static EntityEntry ENDER_GIRL = createEntityEntry("EnderGirl", EntityGaiaNPCEnderGirl.class);
    public static EntityEntry TRADER = createEntityEntry("Trader", EntityGaiaNPCTrader.class);
    public static EntityEntry HOLSTAURUS = createEntityEntry("Holstaurus", EntityGaiaNPCHolstaurus.class);
    public static EntityEntry WERESHEEP = createEntityEntry("Weresheep", EntityGaiaNPCWeresheep.class);

    // Spawn
    public static EntityEntry MANDRAGORA = createEntityEntry("Mandragora", EntityGaiaMandragora.class);
    public static EntityEntry MIMIC = createEntityEntry("Mimic", EntityGaiaMimic.class);
    public static EntityEntry SUMMON_BUTLER = createEntityEntry("Butler", EntityGaiaSummonButler.class);
    public static EntityEntry SUMMON_SPORELING = createEntityEntry("Sporeling", EntityGaiaSummonSporeling.class);

    // Projectiles
    public static EntityEntry PROJECTILE_SMALL_FIREBALL = createEntityEntry("SmallFireball", EntityGaiaProjectileSmallFireball.class);
    public static EntityEntry PROJECTILE_MAGIC = createEntityEntry("Magic", EntityGaiaProjectileMagic.class);

    @Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
            Gaia.LOGGER.info("Registering entities...");
            final IForgeRegistry<EntityEntry> registry = event.getRegistry();
            for (EntityEntry entry : ENTITIES) {
                // TODO: Re-enable when registry works properly
                //registry.register(entry);
                registerEntity(entry.getEntityClass(), entry.getName());
            }
            for (EntityEntry entry : SPAWN_ENTITIES) {
                // TODO: Re-enable when registry works properly
                //registry.register(entry);
                registerEntity(entry.getEntityClass(), entry.getName(), entry.getEgg().primaryColor, entry.getEgg().secondaryColor);
            }
            Gaia.LOGGER.info("Entity registration complete.");
        }
    }
}
