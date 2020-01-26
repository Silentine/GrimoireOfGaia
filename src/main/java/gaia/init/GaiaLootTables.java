package gaia.init;

import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

/**
 * For a full list of entities to register, check;
 * @see GaiaEntities
 */
public class GaiaLootTables {
	private GaiaLootTables() {
	}

	public static final ResourceLocation BAG_ARROW = register("loot_table_bagarrow");
	public static final ResourceLocation BOXES_IRON = register("loot_table_boxiron");
	public static final ResourceLocation BOXES_GOLD = register("loot_table_boxgold");
	public static final ResourceLocation BOXES_DIAMOND = register("loot_table_boxdiamond");
	public static final ResourceLocation BOXES_OVERWORLD = register("loot_table_box");
	public static final ResourceLocation BOXES_NETHER = register("loot_table_boxnether");
	public static final ResourceLocation BOXES_END = register("loot_table_boxend");

	/* MOBS */
	public static final ResourceLocation ENTITIES_GAIA_ANT = register("entities/ant");
	public static final ResourceLocation ENTITIES_GAIA_ANT_RANGER = register("entities/ant_ranger");
	public static final ResourceLocation ENTITIES_GAIA_ANUBIS = register("entities/anubis");
	public static final ResourceLocation ENTITIES_GAIA_ARACHNE = register("entities/arachne");
	public static final ResourceLocation ENTITIES_GAIA_BANSHEE = register("entities/banshee");
	public static final ResourceLocation ENTITIES_GAIA_BAPHOMET = register("entities/baphomet");
	public static final ResourceLocation ENTITIES_GAIA_BEE = register("entities/bee");
	public static final ResourceLocation ENTITIES_GAIA_BEHOLDER = register("entities/beholder");
	public static final ResourceLocation ENTITIES_GAIA_BONE_KNIGHT = register("entities/bone_knight");
	public static final ResourceLocation ENTITIES_GAIA_CAMPFIRE = register("entities/prop/campfire");
	public static final ResourceLocation ENTITIES_GAIA_CECAELIA = register("entities/cecaelia");
	public static final ResourceLocation ENTITIES_GAIA_CENTAUR = register("entities/centaur");
	public static final ResourceLocation ENTITIES_GAIA_COBBLE_GOLEM = register("entities/cobble_golem");
	public static final ResourceLocation ENTITIES_GAIA_COBBLESTONE_GOLEM = register("entities/cobblestone_golem");
	public static final ResourceLocation ENTITIES_GAIA_CREEP = register("entities/creep");
	public static final ResourceLocation ENTITIES_GAIA_DEATHWORD = register("entities/deathword");
	public static final ResourceLocation ENTITIES_GAIA_DHAMPIR = register("entities/dhampir");
	public static final ResourceLocation ENTITIES_GAIA_DRYAD = register("entities/dryad");
	public static final ResourceLocation ENTITIES_GAIA_DULLAHAN = register("entities/dullahan");
	public static final ResourceLocation ENTITIES_GAIA_DWARF_MELEE = register("entities/dwarf_melee");
	public static final ResourceLocation ENTITIES_GAIA_DWARF_RANGED = register("entities/dwarf_ranged");
	public static final ResourceLocation ENTITIES_GAIA_DWARF_MINER = register("entities/dwarf_miner");
	public static final ResourceLocation ENTITIES_GAIA_ENDER_DRAGON_GIRL = register("entities/ender_dragon_girl");
	public static final ResourceLocation ENTITIES_GAIA_ENDER_EYE = register("entities/ender_eye");
	public static final ResourceLocation ENTITIES_GAIA_FLESH_LICH = register("entities/flesh_lich");
	public static final ResourceLocation ENTITIES_GAIA_GELATINOUS_SLIME = register("entities/gelatinous_slime");
	public static final ResourceLocation ENTITIES_GAIA_GOBLIN_MELEE = register("entities/goblin_melee");
	public static final ResourceLocation ENTITIES_GAIA_GOBLIN_RANGED = register("entities/goblin_ranged");
	public static final ResourceLocation ENTITIES_GAIA_GOBLIN_FERAL_MELEE = register("entities/goblin_feral_melee");
	public static final ResourceLocation ENTITIES_GAIA_GOBLIN_FERAL_RANGED = register("entities/goblin_feral_ranged");
	public static final ResourceLocation ENTITIES_GAIA_GOBLIN_FERAL_BOMBER = register("entities/goblin_feral_bomber");
	public static final ResourceLocation ENTITIES_GAIA_GORGON = register("entities/gorgon");
	public static final ResourceLocation ENTITIES_GAIA_GRYPHON = register("entities/gryphon");
	public static final ResourceLocation ENTITIES_GAIA_HARPY = register("entities/harpy");
	public static final ResourceLocation ENTITIES_GAIA_HARPY_WIZARD = register("entities/harpy_wizard");
	public static final ResourceLocation ENTITIES_GAIA_HUNTER = register("entities/hunter");
	public static final ResourceLocation ENTITIES_GAIA_ILLAGER_FIRE = register("entities/illager_fire");
	public static final ResourceLocation ENTITIES_GAIA_ILLAGER_INQUISITOR = register("entities/illager_inquisitor");
	public static final ResourceLocation ENTITIES_GAIA_KIKIMORA = register("entities/kikimora");
	public static final ResourceLocation ENTITIES_GAIA_KOBOLD = register("entities/kobold");
	public static final ResourceLocation ENTITIES_GAIA_MATANGO = register("entities/matango");
	public static final ResourceLocation ENTITIES_GAIA_MERMAID = register("entities/mermaid");
	public static final ResourceLocation ENTITIES_GAIA_MINOTAUR = register("entities/minotaur");
	public static final ResourceLocation ENTITIES_GAIA_MINOTAURUS = register("entities/minotaurus");
	public static final ResourceLocation ENTITIES_GAIA_MONOEYE = register("entities/monoeye");
	public static final ResourceLocation ENTITIES_GAIA_MUMMY = register("entities/mummy");
	public static final ResourceLocation ENTITIES_GAIA_NAGA = register("entities/naga");
	public static final ResourceLocation ENTITIES_GAIA_NINETAILS = register("entities/nine_tails");
	public static final ResourceLocation ENTITIES_GAIA_ONI = register("entities/oni");
	public static final ResourceLocation ENTITIES_GAIA_ORC_MELEE = register("entities/orc_melee");
	public static final ResourceLocation ENTITIES_GAIA_ORC_RANGED = register("entities/orc_ranged");
	public static final ResourceLocation ENTITIES_GAIA_VASE = register("entities/prop/vase");
	public static final ResourceLocation ENTITIES_GAIA_VASE_NETHER = register("entities/prop/vase_nether");
	public static final ResourceLocation ENTITIES_GAIA_SATYRESS = register("entities/satyress");
	public static final ResourceLocation ENTITIES_GAIA_SELKIE = register("entities/selkie");
	public static final ResourceLocation ENTITIES_GAIA_SHAMAN = register("entities/shaman");
	public static final ResourceLocation ENTITIES_GAIA_SHARKO = register("entities/sharko");
	public static final ResourceLocation ENTITIES_GAIA_SIREN = register("entities/siren");
	public static final ResourceLocation ENTITIES_GAIA_SLUDGE_GIRL = register("entities/sludge_girl");
	public static final ResourceLocation ENTITIES_GAIA_SPHINX = register("entities/sphinx");
	public static final ResourceLocation ENTITIES_GAIA_SPRIGGAN = register("entities/spriggan");
	public static final ResourceLocation ENTITIES_GAIA_SUCCUBUS = register("entities/succubus");
	public static final ResourceLocation ENTITIES_GAIA_TOAD = register("entities/toad");
	public static final ResourceLocation ENTITIES_GAIA_VALKYRIE = register("entities/valkyrie");
	public static final ResourceLocation ENTITIES_GAIA_VAMPIRE = register("entities/vampire");
	public static final ResourceLocation ENTITIES_GAIA_WERECAT = register("entities/werecat");
	public static final ResourceLocation ENTITIES_GAIA_WITCH = register("entities/witch");
	public static final ResourceLocation ENTITIES_GAIA_WITHER_COW = register("entities/wither_cow");
	public static final ResourceLocation ENTITIES_GAIA_YETI = register("entities/yeti");
	public static final ResourceLocation ENTITIES_GAIA_YUKI_ONNA = register("entities/yuki_onna");
	/* MOBS */

	/* SPAWN */
	public static final ResourceLocation ENTITIES_GAIA_MANDRAGORA = register("entities/mandragora");
	public static final ResourceLocation ENTITIES_GAIA_MIMIC = register("entities/mimic");
	/* SPAWN */

	/* SUMMON */
	public static final ResourceLocation ENTITIES_GAIA_BUTLER = register("entities/butler");
	public static final ResourceLocation ENTITIES_GAIA_MITE = register("entities/mite");
	public static final ResourceLocation ENTITIES_GAIA_SPORELING = register("entities/sporeling");
	/* SUMMON */

	private static ResourceLocation register(String id) {
		return LootTableList.register(new ResourceLocation(GaiaReference.MOD_ID, id));
	}
}
