package gaia.init;

import com.google.common.base.Preconditions;
import gaia.GaiaReference;
import gaia.entity.monster.EntityDebugMob;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.entity.monster.EntityGaiaAntRanger;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaArachne;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBee;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCecaelia;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDeathword;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaGelatinousSlime;
import gaia.entity.monster.EntityGaiaGoblin;
import gaia.entity.monster.EntityGaiaGoblinFeral;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaKikimora;
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
import gaia.entity.monster.EntityGaiaOni;
import gaia.entity.monster.EntityGaiaOrc;
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
import gaia.entity.projectile.EntityGaiaProjectileBubble;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.entity.projectile.EntityGaiaProjectilePoison;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import gaia.entity.projectile.EntityGaiaProjectileWeb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GaiaReference.MOD_ID)
public class GaiaEntities {

	public static final EntityType<EntityDebugMob> DEBUG_MOB = register("debug_mob", EntityType.Builder.create(EntityDebugMob.class, EntityDebugMob::new));
	public static final EntityType<EntityGaiaAnt> ANT = register("ant", EntityType.Builder.create(EntityGaiaAnt.class, EntityGaiaAnt::new));
	public static final EntityType<EntityGaiaAntRanger> ANT_RANGER = register("ant_ranger", EntityType.Builder.create(EntityGaiaAntRanger.class, EntityGaiaAntRanger::new));
	public static final EntityType<EntityGaiaAnubis> ANUBIS = register("anubis", EntityType.Builder.create(EntityGaiaAnubis.class, EntityGaiaAnubis::new));
	public static final EntityType<EntityGaiaArachne> ARACHNE = register("arachne", EntityType.Builder.create(EntityGaiaArachne.class, EntityGaiaArachne::new));
	public static final EntityType<EntityGaiaBanshee> BANSHEE = register("banshee", EntityType.Builder.create(EntityGaiaBanshee.class, EntityGaiaBanshee::new));
	public static final EntityType<EntityGaiaBaphomet> BAPHOMET = register("baphomet", EntityType.Builder.create(EntityGaiaBaphomet.class, EntityGaiaBaphomet::new));
	public static final EntityType<EntityGaiaBee> BEE = register("bee", EntityType.Builder.create(EntityGaiaBee.class, EntityGaiaBee::new));
	public static final EntityType<EntityGaiaBoneKnight> BONE_KNIGHT = register("bone_knight", EntityType.Builder.create(EntityGaiaBoneKnight.class, EntityGaiaBoneKnight::new));
	public static final EntityType<EntityGaiaCecaelia> CECEALIA = register("cecaelia", EntityType.Builder.create(EntityGaiaCecaelia.class, EntityGaiaCecaelia::new));
	public static final EntityType<EntityGaiaCentaur> CENTAUR = register("centaur", EntityType.Builder.create(EntityGaiaCentaur.class, EntityGaiaCentaur::new));
	public static final EntityType<EntityGaiaPropChestMimic> CHEST = register("chest", EntityType.Builder.create(EntityGaiaPropChestMimic.class, EntityGaiaPropChestMimic::new), false);
	public static final EntityType<EntityGaiaCobbleGolem> COBBLE_GOLEM = register("cobble_golem", EntityType.Builder.create(EntityGaiaCobbleGolem.class, EntityGaiaCobbleGolem::new));
	public static final EntityType<EntityGaiaCobblestoneGolem> COBBLESTONE_GOLEM = register("cobblestone_golem", EntityType.Builder.create(EntityGaiaCobblestoneGolem.class, EntityGaiaCobblestoneGolem::new));
	public static final EntityType<EntityGaiaCreep> CREEP = register("creep", EntityType.Builder.create(EntityGaiaCreep.class, EntityGaiaCreep::new));
	public static final EntityType<EntityGaiaCyclops> CYCLOPS = register("cyclops", EntityType.Builder.create(EntityGaiaCyclops.class, EntityGaiaCyclops::new));
	public static final EntityType<EntityGaiaPropFlowerCyan> CYAN_FLOWER = register("cyan_flower", EntityType.Builder.create(EntityGaiaPropFlowerCyan.class, EntityGaiaPropFlowerCyan::new), false);
	public static final EntityType<EntityGaiaDeathword> DEATHWORD = register("deathword", EntityType.Builder.create(EntityGaiaDeathword.class, EntityGaiaDeathword::new));
	public static final EntityType<EntityGaiaDhampir> DHAMPIR = register("dhampir", EntityType.Builder.create(EntityGaiaDhampir.class, EntityGaiaDhampir::new));
	public static final EntityType<EntityGaiaDryad> DRYAD = register("dryad", EntityType.Builder.create(EntityGaiaDryad.class, EntityGaiaDryad::new));
	public static final EntityType<EntityGaiaDullahan> DULLAHAN = register("dullahan", EntityType.Builder.create(EntityGaiaDullahan.class, EntityGaiaDullahan::new));
	public static final EntityType<EntityGaiaDwarf> DWARF = register("dwarf", EntityType.Builder.create(EntityGaiaDwarf.class, EntityGaiaDwarf::new));
	public static final EntityType<EntityGaiaEnderDragonGirl> ENDER_DRAGON_GIRL = register("ender_dragon_girl", EntityType.Builder.create(EntityGaiaEnderDragonGirl.class, EntityGaiaEnderDragonGirl::new));
	public static final EntityType<EntityGaiaEnderEye> ENDER_EYE = register("ender_eye", EntityType.Builder.create(EntityGaiaEnderEye.class, EntityGaiaEnderEye::new));
	public static final EntityType<EntityGaiaFleshLich> FLESH_LICH = register("flesh_lich", EntityType.Builder.create(EntityGaiaFleshLich.class, EntityGaiaFleshLich::new));
	public static final EntityType<EntityGaiaGelatinousSlime> GELATINOUS_SLIME = register("gelatinous_slime", EntityType.Builder.create(EntityGaiaGelatinousSlime.class, EntityGaiaGelatinousSlime::new));
	public static final EntityType<EntityGaiaGoblin> GOBLIN = register("goblin", EntityType.Builder.create(EntityGaiaGoblin.class, EntityGaiaGoblin::new));
	public static final EntityType<EntityGaiaGoblinFeral> GOBLIN_FERAL = register("goblin_feral", EntityType.Builder.create(EntityGaiaGoblinFeral.class, EntityGaiaGoblinFeral::new));
	public static final EntityType<EntityGaiaGryphon> GRYPHON = register("gryphon", EntityType.Builder.create(EntityGaiaGryphon.class, EntityGaiaGryphon::new));
	public static final EntityType<EntityGaiaHarpy> HARPY = register("harpy", EntityType.Builder.create(EntityGaiaHarpy.class, EntityGaiaHarpy::new));
	public static final EntityType<EntityGaiaHunter> HUNTER = register("hunter", EntityType.Builder.create(EntityGaiaHunter.class, EntityGaiaHunter::new));
	public static final EntityType<EntityGaiaKikimora> KIKIMORA = register("kikimora", EntityType.Builder.create(EntityGaiaKikimora.class, EntityGaiaKikimora::new));
	public static final EntityType<EntityGaiaKobold> KOBOLD = register("kobold", EntityType.Builder.create(EntityGaiaKobold.class, EntityGaiaKobold::new));
	public static final EntityType<EntityGaiaMatango> MATANGO = register("matango", EntityType.Builder.create(EntityGaiaMatango.class, EntityGaiaMatango::new));
	public static final EntityType<EntityGaiaMermaid> MERMAID = register("mermaid", EntityType.Builder.create(EntityGaiaMermaid.class, EntityGaiaMermaid::new));
	public static final EntityType<EntityGaiaMinotaur> MINOTAUR = register("minotaur", EntityType.Builder.create(EntityGaiaMinotaur.class, EntityGaiaMinotaur::new));
	public static final EntityType<EntityGaiaMinotaurus> MINOTAURUS = register("minotaurus", EntityType.Builder.create(EntityGaiaMinotaurus.class, EntityGaiaMinotaurus::new));
	public static final EntityType<EntityGaiaMummy> MUMMY = register("mummy", EntityType.Builder.create(EntityGaiaMummy.class, EntityGaiaMummy::new));
	public static final EntityType<EntityGaiaNaga> NAGA = register("naga", EntityType.Builder.create(EntityGaiaNaga.class, EntityGaiaNaga::new));
	public static final EntityType<EntityGaiaNineTails> NINE_TAILS = register("nine_tails", EntityType.Builder.create(EntityGaiaNineTails.class, EntityGaiaNineTails::new));
	public static final EntityType<EntityGaiaOni> ONI = register("oni", EntityType.Builder.create(EntityGaiaOni.class, EntityGaiaOni::new));
	public static final EntityType<EntityGaiaOrc> ORC = register("orc", EntityType.Builder.create(EntityGaiaOrc.class, EntityGaiaOrc::new));
	public static final EntityType<EntityGaiaSatyress> SATYRESS = register("satyress", EntityType.Builder.create(EntityGaiaSatyress.class, EntityGaiaSatyress::new));
	public static final EntityType<EntityGaiaSelkie> SELKIE = register("selkie", EntityType.Builder.create(EntityGaiaSelkie.class, EntityGaiaSelkie::new));
	public static final EntityType<EntityGaiaShaman> SHAMAN = register("shaman", EntityType.Builder.create(EntityGaiaShaman.class, EntityGaiaShaman::new));
	public static final EntityType<EntityGaiaSharko> SHARKO = register("sharko", EntityType.Builder.create(EntityGaiaSharko.class, EntityGaiaSharko::new));
	public static final EntityType<EntityGaiaSiren> SIREN = register("siren", EntityType.Builder.create(EntityGaiaSiren.class, EntityGaiaSiren::new));
	public static final EntityType<EntityGaiaSludgeGirl> SLUDGE_GIRL = register("sludge_girl", EntityType.Builder.create(EntityGaiaSludgeGirl.class, EntityGaiaSludgeGirl::new));
	public static final EntityType<EntityGaiaSphinx> SPHINX = register("sphinx", EntityType.Builder.create(EntityGaiaSphinx.class, EntityGaiaSphinx::new));
	public static final EntityType<EntityGaiaSpriggan> SPRIGGAN = register("spriggan", EntityType.Builder.create(EntityGaiaSpriggan.class, EntityGaiaSpriggan::new));
	public static final EntityType<EntityGaiaSuccubus> SUCCUBUS = register("succubus", EntityType.Builder.create(EntityGaiaSuccubus.class, EntityGaiaSuccubus::new));
	public static final EntityType<EntityGaiaToad> TOAD = register("toad", EntityType.Builder.create(EntityGaiaToad.class, EntityGaiaToad::new));
	public static final EntityType<EntityGaiaValkyrie> VALKYRIE = register("valkyrie", EntityType.Builder.create(EntityGaiaValkyrie.class, EntityGaiaValkyrie::new));
	public static final EntityType<EntityGaiaVampire> VAMPIRE = register("vampire", EntityType.Builder.create(EntityGaiaVampire.class, EntityGaiaVampire::new));
	public static final EntityType<EntityGaiaWerecat> WERECAT = register("werecat", EntityType.Builder.create(EntityGaiaWerecat.class, EntityGaiaWerecat::new));
	public static final EntityType<EntityGaiaWitch> WITCH = register("witch", EntityType.Builder.create(EntityGaiaWitch.class, EntityGaiaWitch::new));
	public static final EntityType<EntityGaiaWitherCow> WITHER_COW = register("wither_cow", EntityType.Builder.create(EntityGaiaWitherCow.class, EntityGaiaWitherCow::new));
	public static final EntityType<EntityGaiaYeti> YETI = register("yeti", EntityType.Builder.create(EntityGaiaYeti.class, EntityGaiaYeti::new));
	public static final EntityType<EntityGaiaYukiOnna> YUKI_ONNA = register("yuki_onna", EntityType.Builder.create(EntityGaiaYukiOnna.class, EntityGaiaYukiOnna::new));
	
	public static final EntityType<EntityGaiaNPCCreeperGirl> CREEPER_GIRL_NPC = register("creeper_girl", EntityType.Builder.create(EntityGaiaNPCCreeperGirl.class, EntityGaiaNPCCreeperGirl::new));
	public static final EntityType<EntityGaiaNPCSlimeGirl> SLUDGE_GIRL_NPC = register("slime_girl", EntityType.Builder.create(EntityGaiaNPCSlimeGirl.class, EntityGaiaNPCSlimeGirl::new));
	public static final EntityType<EntityGaiaNPCEnderGirl> ENDER_GIRL_NPC = register("ender_girl", EntityType.Builder.create(EntityGaiaNPCEnderGirl.class, EntityGaiaNPCEnderGirl::new));
	public static final EntityType<EntityGaiaNPCTrader> TRADER_NPC = register("trader", EntityType.Builder.create(EntityGaiaNPCTrader.class, EntityGaiaNPCTrader::new));
	public static final EntityType<EntityGaiaNPCHolstaurus> HOLSTAURUS_NPC = register("holstaurus", EntityType.Builder.create(EntityGaiaNPCHolstaurus.class, EntityGaiaNPCHolstaurus::new));
	public static final EntityType<EntityGaiaNPCWeresheep> WERESHEEP_NPC = register("weresheep", EntityType.Builder.create(EntityGaiaNPCWeresheep.class, EntityGaiaNPCWeresheep::new));
	
	public static final EntityType<EntityGaiaMandragora> MANDRAGORA = register("mandragora", EntityType.Builder.create(EntityGaiaMandragora.class, EntityGaiaMandragora::new));
	public static final EntityType<EntityGaiaMimic> MIMIC = register("mimic", EntityType.Builder.create(EntityGaiaMimic.class, EntityGaiaMimic::new));
	
	public static final EntityType<EntityGaiaSummonButler> BUTLER = register("butler", EntityType.Builder.create(EntityGaiaSummonButler.class, EntityGaiaSummonButler::new));
	public static final EntityType<EntityGaiaSummonSporeling> SPORELING = register("sporeling", EntityType.Builder.create(EntityGaiaSummonSporeling.class, EntityGaiaSummonSporeling::new));
	
	public static final EntityType<EntityGaiaProjectileBubble> BUBBLE_PROJECTILE = register("bubble", EntityType.Builder.create(EntityGaiaProjectileBubble.class, EntityGaiaProjectileBubble::new));
	public static final EntityType<EntityGaiaProjectileMagic> MAGIC_PROJECTILE = register("magic", EntityType.Builder.create(EntityGaiaProjectileMagic.class, EntityGaiaProjectileMagic::new));
	public static final EntityType<EntityGaiaProjectilePoison> POISON_PROJECTILE = register("poison", EntityType.Builder.create(EntityGaiaProjectilePoison.class, EntityGaiaProjectilePoison::new));
	public static final EntityType<EntityGaiaProjectileSmallFireball> FIREBALL_PROJECTILE = register("small_fireball", EntityType.Builder.create(EntityGaiaProjectileSmallFireball.class, EntityGaiaProjectileSmallFireball::new));
	public static final EntityType<EntityGaiaProjectileWeb> WEB_PROJECTILE = register("web", EntityType.Builder.create(EntityGaiaProjectileWeb.class, EntityGaiaProjectileWeb::new));

	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder, boolean sendVelocityUpdates) {
        EntityType<T> entitytype = builder.tracker(64, 3, sendVelocityUpdates).build("");
        ResourceLocation name = new ResourceLocation(GaiaReference.MOD_ID, id);
        entitytype.setRegistryName(name);

        return entitytype;
	}
	
	public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
        return register(id, builder, true);
	}

	public static void register(EntityType<?> entity, String name, RegistryEvent.Register<EntityType<?>> event) {
        Preconditions.checkNotNull(entity, "registryName");
        event.getRegistry().register(entity);
	}
	
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event)
	{
		register(DEBUG_MOB, "debug_mob", event); //TODO: DISABLE BEFORE BUILD

		register(ANT, "ant", event);
		register(ANT_RANGER, "ant_ranger", event);
		register(ANUBIS, "anubis", event);
		register(ARACHNE, "arachne", event);
		register(BANSHEE, "banshee", event);
		register(BAPHOMET, "baphomet", event);
		register(BEE, "bee", event);
		register(BONE_KNIGHT, "bone_knight", event);
		register(CECEALIA, "cecaelia", event);
		register(CENTAUR, "centaur", event);
		register(CHEST, "chest", event);
		register(COBBLE_GOLEM, "cobble_golem", event);
		register(COBBLESTONE_GOLEM, "cobblestone_golem", event);
		register(CREEP, "creep", event);
		register(CYCLOPS, "cyclops", event);
		register(CYAN_FLOWER, "cyan_flower", event);
		register(DEATHWORD, "deathword", event);
		register(DHAMPIR, "dhampir", event);
		register(DRYAD, "dryad", event);
		register(DULLAHAN, "dullahan", event);
		register(DWARF, "dwarf", event);
		register(ENDER_DRAGON_GIRL, "ender_dragon_girl", event);
		register(ENDER_EYE, "ender_eye", event);
		register(FLESH_LICH, "flesh_lich", event);
		register(GELATINOUS_SLIME, "gelatinous_slime", event);
		register(GOBLIN, "goblin", event);
		register(GOBLIN_FERAL, "goblin_feral", event);
		register(GRYPHON, "gryphon", event);
		register(HARPY, "harpy", event);
		register(HUNTER, "hunter", event);
		register(KIKIMORA, "kikimora", event);
		register(KOBOLD, "kobold", event);
		register(MATANGO, "matango", event);
		register(MERMAID, "mermaid", event);
		register(MINOTAUR, "minotaur", event);
		register(MINOTAURUS, "minotaurus", event);
		register(MUMMY, "mummy", event);
		register(NAGA, "naga", event);
		register(NINE_TAILS, "nine_tails", event);
		register(ONI, "oni", event);
		register(ORC, "orc", event);
		register(SATYRESS, "satyress", event);
		register(SELKIE, "selkie", event);
		register(SHAMAN, "shaman", event);
		register(SHARKO, "sharko", event);
		register(SIREN, "siren", event);
		register(SLUDGE_GIRL, "sludge_girl", event);
		register(SPHINX, "sphinx", event);
		register(SPRIGGAN, "spriggan", event);
		register(SUCCUBUS, "succubus", event);
		register(TOAD, "toad", event);
		register(VALKYRIE, "valkyrie", event);
		register(VAMPIRE, "vampire", event);
		register(WERECAT, "werecat", event);
		register(WITCH, "witch", event);
		register(WITHER_COW, "wither_cow", event);
		register(YETI, "yeti", event);
		register(YUKI_ONNA, "yuki_onna", event);
		register(CREEPER_GIRL_NPC, "creeper_girl", event);
		register(SLUDGE_GIRL_NPC, "slime_girl", event);
		register(ENDER_GIRL_NPC, "ender_girl", event);
		register(TRADER_NPC, "trader", event);
		register(HOLSTAURUS_NPC, "holstaurus", event);
		register(WERESHEEP_NPC, "weresheep", event);
		register(MANDRAGORA, "mandragora", event);
		register(MIMIC, "mimic", event);
		register(BUTLER, "butler", event);
		register(SPORELING, "sporeling", event);
		register(BUBBLE_PROJECTILE, "bubble", event);
		register(MAGIC_PROJECTILE, "magic", event);
		register(POISON_PROJECTILE, "poison", event);
		register(FIREBALL_PROJECTILE, "small_fireball", event);
		register(WEB_PROJECTILE, "web", event);
	}

}
