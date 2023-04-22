package gaia.datagen.client;

import gaia.GrimoireOfGaia;
import gaia.datagen.client.helper.MobLangHelper;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.registry.helper.MobReg;
import gaia.registry.helper.PropReg;
import net.minecraft.data.DataGenerator;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class GaiaLanguage extends LanguageProvider {
	public GaiaLanguage(DataGenerator gen) {
		super(gen, GrimoireOfGaia.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("itemGroup.grimoireofgaia", "Grimoire of Gaia 4");

		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.ANT_WORKER, "Ant Worker").withSay("communicates").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.ANT_SALVAGER, "Ant Salvager").withSay("communicates").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.ANUBIS, "Anubis").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.ARACHNE, "Arachne").withSay("communicates").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.BANSHEE, "Banshee").withSay("shrieks").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.BEE, "Honey Bee").withSay("buzzes").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.BEHENDER, "Behender").withSay("vwoops").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.BONE_KNIGHT, "Bone Knight").withSay("rattles").withDeath("crumbles").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.CECAELIA, "Cecaelia").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.CENTAUR, "Centaur").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.COBBLE_GOLEM, "Cobble Golem").withDeath("crumbles").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.COBBLESTONE_GOLEM, "Cobblestone Golem").withDeath("crumbles").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.CREEP, "Creep").withSay("hisses").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.CYCLOPS, "Cyclops").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.DEATHWORD, "Deathword").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.DRYAD, "Dryad").withSay("murmurs").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.DULLAHAN, "Dullahan").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.DWARF, "Dwarf").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.ENDER_EYE, "Ender Eye").withSay("vwoops").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.ENDER_DRAGON_GIRL, "Ender Dragon Girl").withSay("vwoops").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.FLESH_LICH, "Flesh Lich").withSay("groans").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.GELATINOUS_SLIME, "Gelatinous Slime").withSay("squishes").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.GOBLIN, "Goblin").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.GOBLIN_FERAL, "Feral Goblin").withSay("murmurs").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.GRYPHON, "Gryphon").withSay("shrieks").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.HARPY, "Harpy").withSay("shrieks").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.HUNTER, "Hunter").withSay("whispers").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.KOBOLD, "Kobold").withSay("barks").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.MATANGO, "Matango").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.MERMAID, "Mermaid").withSay("sings").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.MINOTAUR, "Minotaur").withSay("growls").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.MINOTAURUS, "Minotaurus").withSay("growls").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.MIMIC, "Mimic").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.NAGA, "Naga").withSay("hisses").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.NINE_TAILS, "Nine Tails").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.ONI, "Oni").withSay("snorts").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.ORC, "Orc").withSay("growls").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SATYRESS, "Satyress").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SHAMAN, "Shaman").withSay("chants").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SHARKO, "Sharko").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SIREN, "Siren").withSay("sings").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SPHINX, "Sphinx").withSay("roars").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SLUDGE_GIRL, "Sludge Girl").withSay("bubbles").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SPORELING, "Sporeling").withSay("squeaks").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SPRIGGAN, "Spriggan").withSay("crackles").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.SUCCUBUS, "Succubus").withSay("whispers").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.TOAD, "Toad").withSay("ribbits").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.VALKYRIE, "Valkyrie").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.WERECAT, "Werecat").withSay("hisses").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.WITCH, "Witch").withSay("laughs").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.WITHER_COW, "Wither Cow").withSay("moos").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.WIZARD_HARPY, "Wizard Harpy").withSay("shrieks").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.YUKI_ONNA, "Yuki-Onna").build());

		addPropReg(GaiaRegistry.ANT_HILL, "Ant Hill");
		addPropReg(GaiaRegistry.CHEST, "Chest");

		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.HORSE, "Wild Horse").withSay("neighs").build());
		addEntityType(GaiaRegistry.SMALL_FIREBALL, "Small Fire");
		addEntityType(GaiaRegistry.MAGIC, "Magic Projectile");
		addEntityType(GaiaRegistry.RANDOM_MAGIC, "Random Magic Projectile");
		addEntityType(GaiaRegistry.POISON, "Poison Projectile");
		addEntityType(GaiaRegistry.BOMB, "Bomb Projectile");
		addEntityType(GaiaRegistry.BUBBLE, "Bubble Projectile");

		addBlock(GaiaRegistry.BUST_GORGON, "The Gorgon");
		addBlock(GaiaRegistry.BUST_MINOTAUR, "Minotaur Bust");
		addBlock(GaiaRegistry.BUST_SPHINX, "The Sphinx");
		addBlock(GaiaRegistry.BUST_VALKYRIE, "The Valkyrie");
		addBlock(GaiaRegistry.BUST_VAMPIRE, "The Vampire");
		addBlock(GaiaRegistry.DECO_GARDEN_GNOME, "Garden Gnome");
		addBlock(GaiaRegistry.DECO_MANDRAGORA_POT, "Mandragora Pot");
		addBlock(GaiaRegistry.DECO_NEST_HARPY, "Harpy Nest");
		addBlock(GaiaRegistry.DOLL_CREEPER_GIRL, "Creeper Girl Doll");
		addBlock(GaiaRegistry.DOLL_DRYAD, "Dryad Doll");
		addBlock(GaiaRegistry.DOLL_DULLAHAN, "Dullahan Doll");
		addBlock(GaiaRegistry.DOLL_ENDER_GIRL, "Ender Girl Doll");
		addBlock(GaiaRegistry.DOLL_MAID, "Maid Doll");
		addBlock(GaiaRegistry.DOLL_MERMAID, "Mermaid Doll");
		addBlock(GaiaRegistry.DOLL_NINE_TAILS, "Nine Tails Doll");
		addBlock(GaiaRegistry.DOLL_SLIME_GIRL, "Slime Girl Doll");
		addBlock(GaiaRegistry.PEARL_BLOCK, "Pearl Block");

		addItem(GaiaRegistry.BOOK_OF_MEMORY, "Book of Memory");
		addItem(GaiaRegistry.BROOM, "Broom");
		addItem(GaiaRegistry.WEAPON_BOOK, "Book");
		addItem(GaiaRegistry.WEAPON_BOOK_FREEZING, "Freezing Book");
		addItem(GaiaRegistry.WEAPON_BOOK_NIGHTMARE, "Nightmare Book");
		addItem(GaiaRegistry.WEAPON_BOOK_METAL, "Metal Book");
		addItem(GaiaRegistry.WEAPON_BOOK_ENDER, "Ender Book");
		addItem(GaiaRegistry.WEAPON_BOOK_HUNGER, "Book of Hunger");
		addItem(GaiaRegistry.WEAPON_BOOK_BATTLE, "Book of Combat");
		addItem(GaiaRegistry.WEAPON_BOOK_NATURE, "Book of Nature");
		addItem(GaiaRegistry.WEAPON_BOOK_WITHER, "Book of Withering");
		addItem(GaiaRegistry.WEAPON_BOOK_BUFF, "Combat Manual");
		addItem(GaiaRegistry.CURSED_METAL_SWORD, "Cursed Metal Sword");
		addItem(GaiaRegistry.METAL_CLUB, "Metal Club");
		addItem(GaiaRegistry.EXPERIENCE_IRON, "Crystallized Experience (Small)");
		addItem(GaiaRegistry.EXPERIENCE_GOLD, "Crystallized Experience (Medium)");
		addItem(GaiaRegistry.EXPERIENCE_DIAMOND, "Crystallized Experience (Large)");
		addItem(GaiaRegistry.ELYTRA_FRAGMENT, "Elytra Fragment");
		addItem(GaiaRegistry.TOTEM_FRAGMENT, "Totem of Undying Fragment");
		addItem(GaiaRegistry.DIAMOND_SHARD, "Diamond Shard");
		addItem(GaiaRegistry.EMERALD_SHARD, "Emerald Shard");
		addItem(GaiaRegistry.SHINY_PEARL, "Shiny Pearl");
		addItem(GaiaRegistry.FAN, "Hand Fan");
		addItem(GaiaRegistry.FAN_FIRE, "Ornate Fire Fan");
		addItem(GaiaRegistry.FAN_ICE, "Ornate Ice Fan");
		addItem(GaiaRegistry.FIRESHARD, "Fireshard");
		addItem(GaiaRegistry.SOULFIRE, "Soulfire");
		addItem(GaiaRegistry.STONE_COAL, "Stone Coal");
		addItem(GaiaRegistry.FUR, "Fur");
		addItem(GaiaRegistry.GIGA_GEAR, "Heart of Giga Knight");
		addItem(GaiaRegistry.GOLDEN_APPLE_PIE, "Golden Apple Pie");
		addItem(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE, "Golden Apple Pie Slice");
		addItem(GaiaRegistry.MINOTAUR_HAMMER, "Minotaur Hammer");
		addItem(GaiaRegistry.HONEYDEW, "Honeydew");
		addItem(GaiaRegistry.HEADGEAR_BOOK, "Book on Face");
		addItem(GaiaRegistry.HEADGEAR_MOB, "Cage");
		addItem(GaiaRegistry.HEADGEAR_BOLT, "Bolts");
		addItem(GaiaRegistry.HEADGEAR_ARROW, "Arrow Through Head");
		addItem(GaiaRegistry.HEADGEAR_DOLL, "Drooping Maid");
		addItem(GaiaRegistry.HEADGEAR_EARS_ELF, "Elven Ears");
		addItem(GaiaRegistry.KNUCKLES, "Knuckles");
		addItem(GaiaRegistry.RING_OF_SPEED, "Ring of Speed");
		addItem(GaiaRegistry.RING_OF_HASTE, "Ring of Haste");
		addItem(GaiaRegistry.RING_OF_JUMP, "Ring of Jump");
		addItem(GaiaRegistry.RING_OF_NIGHT, "Ring of Night Vision");
		addItem(GaiaRegistry.HEAVY_BARBELL, "Heavy Barbell");
		addItem(GaiaRegistry.SEASHELL_HAIRPIN, "Seashell Hairpin");
		addItem(GaiaRegistry.MEAT, "Meat");
		addItem(GaiaRegistry.MONSTER_FEED, "Monster Feed");
		addItem(GaiaRegistry.PREMIUM_MONSTER_FEED, "Premium Monster Feed");
		addItem(GaiaRegistry.QUILL, "Diamond Tipped Quill");
		addItem(GaiaRegistry.ROTTEN_HEART, "Rotten Heart");
		addItem(GaiaRegistry.METAL_DAGGER, "Metal Dagger");
		addItem(GaiaRegistry.TAPROOT, "Taproot");
		addItem(GaiaRegistry.ZOMBIE_STAFF, "Zombie Staff");
		addItem(GaiaRegistry.SKELETON_STAFF, "Skeleton Staff");
		addItem(GaiaRegistry.CAVE_SPIDER_STAFF, "Cave Spider Staff");
		addItem(GaiaRegistry.MAGIC_STAFF, "Magic Staff");
		addItem(GaiaRegistry.STONE_SHIELD, "Stone Shield");
		addItem(GaiaRegistry.IRON_SHIELD, "Iron Shield");
		addItem(GaiaRegistry.GOLD_SHIELD, "Gold Shield");
		addItem(GaiaRegistry.BONE_SHIELD, "Bone Shield");
		addItem(GaiaRegistry.NETHER_WART_JAM, "Nether Wart Jam");
		addItem(GaiaRegistry.WITHERED_BRAIN, "Withered Brain");

		addItem(GaiaRegistry.PROJECTILE_BOMB, "Bomb Projectile");
		addItem(GaiaRegistry.PROJECTILE_MAGIC, "Magic Projectile");
		addItem(GaiaRegistry.PROJECTILE_RANDOM_MAGIC, "Random Magic Projectile");
		addItem(GaiaRegistry.PROJECTILE_WEB, "Web Projectile");
		addItem(GaiaRegistry.PROJECTILE_POISON, "Poison Projectile");
		addItem(GaiaRegistry.PROJECTILE_BUBBLE, "Bubble Projectile");

		addItem(GaiaRegistry.BAG_ARROWS, "Sealed Quiver");
		addItem(GaiaRegistry.BAG_BOOK, "Book Satchel");
		addItem(GaiaRegistry.BAG_RECORD, "Record Box");
		addItem(GaiaRegistry.BOX_DIAMOND, "Diamond Box");
		addItem(GaiaRegistry.BOX_END, "End Box");
		addItem(GaiaRegistry.BOX_GOLD, "Gold Box");
		addItem(GaiaRegistry.BOX_HAT, "Hat Box");
		addItem(GaiaRegistry.BOX_IRON, "Iron Box");
		addItem(GaiaRegistry.BOX_NETHER, "Nether Box");
		addItem(GaiaRegistry.BOX_OLD, "Old Luggage");
		addItem(GaiaRegistry.BOX_OVERWORLD, "Overworld Box");
		addItem(GaiaRegistry.CHEST_DESERT, "Pyramid Chest");
		addItem(GaiaRegistry.CHEST_DUNGEON, "Dungeon Chest");
		addItem(GaiaRegistry.CHEST_JUNGLE, "Jungle Chest");

		addSubtitle(GaiaSounds.BAG_OPEN, "Bag Opened");
		addSubtitle(GaiaSounds.BOOK_HIT, "Book Slapped");
		addSubtitle(GaiaSounds.METAL_BOOK_HIT, "Metal Book Clunks");
		addSubtitle(GaiaSounds.BOX_OPEN, "Box Opened");
		addSubtitle(GaiaSounds.CREEP_PRIMED, "Creep Hisses");
		addSubtitle(GaiaSounds.GOBLIN_FERAL_PRIMED, "Feral Goblin Primed");
		addSubtitle(GaiaSounds.GAIA_SHOOT, "Creature shoots");
		addSubtitle(GaiaSounds.ANT_HILL_DEATH, "Ant Hill is destroyed");
		addSubtitle(GaiaSounds.BOMB_THROW, "Bomb thrown");
		addSubtitle(GaiaSounds.ENDER_EYE_SCREAM, "Ender Eye Screams");
		addSubtitle(GaiaSounds.ENDER_EYE_TELEPORT, "Ender Eye Vwoops");
		addSubtitle(GaiaSounds.ENDER_DRAGON_GIRL_SCREAM, "Ender Dragon Girl Screams");
		addSubtitle(GaiaSounds.ENDER_DRAGON_GIRL_TELEPORT, "Ender Dragon Girl Vwoops");

		add("text.grimoireofgaia.right_click_use", "Right-click to open");
		add("text.grimoireofgaia.hold_shift", "<Hold Shift>");
		add("text.grimoireofgaia.fuel_for_seconds", "Fuel for %d seconds");
		add("text.grimoireofgaia.gain_experience", "Gain experience");
		add("text.grimoireofgaia.gain_level", "Gain %d level");
		add("text.grimoireofgaia.gain_levels", "Gain %d levels");


		add("text.grimoireofgaia.giga_gear.desc", "All that remains of Giga Knight");
		add("text.grimoireofgaia.fireshard.desc", "Right-click to spawn Lava");
		add("text.grimoireofgaia.soulfire.desc", "Right-click to spawn Fire");
		add("text.grimoireofgaia.summoning_staff.desc", "Hold Right-click to spawn %s");
		add("text.grimoireofgaia.magic_staff.desc", "Hold Right-click to fire a magic projectile");

		add("text.grimoireofgaia.headgear.tag", "Headgear");
		add("text.grimoireofgaia.charm.tag", "Charm");
		add("text.grimoireofgaia.trinket.tag", "Trinket");
		add("text.grimoireofgaia.ring.tag", "Ring");
		add("text.grimoireofgaia.charm.damage", "+%d Attack Damage");

		add("text.grimoireofgaia.bless.main_hand", "When in main hand:");
		add("text.grimoireofgaia.bless.off_hand", "When in off-hand, main hand:");

		add("text.grimoireofgaia.monster_feed.desc", "Solely effects Grimoire of Gaia mobs");
		add("text.grimoireofgaia.food_monster_feed.desc", "Adds friendliness to Level 1 Assist mobs");
		add("text.grimoireofgaia.premium_food_monster_feed.desc", "Removes initial hostility");
		add("item.grimoireofgaia.food_monster_feed2.desc", "Does not affect damaged mobs");

		//Advancements
		addAdvancement("root", "Grimoire of Gaia", "Advancements? What are those?");
		addKillAdvancement(GaiaRegistry.ANT_SALVAGER, "Ant Salvager", "Kill an Ant Salvager");
		addKillAdvancement(GaiaRegistry.ANT_WORKER, "Ant Worker", "Kill an Ant Worker");
		addKillAdvancement(GaiaRegistry.ANUBIS, "Anubis", "Kill an Anubis");
		addKillAdvancement(GaiaRegistry.ARACHNE, "Arachne", "Kill an Arachne");
		addKillAdvancement(GaiaRegistry.BANSHEE, "Banshee", "Kill a Banshee");
		addKillAdvancement(GaiaRegistry.BEHENDER, "Behender", "Kill a Behender");
		addKillAdvancement(GaiaRegistry.BONE_KNIGHT, "Bone Knight", "Kill a Bone Knight");
		addKillAdvancement(GaiaRegistry.CECAELIA, "Cecaelia", "Kill a Cecaelia");
		addKillAdvancement(GaiaRegistry.COBBLESTONE_GOLEM, "Cobblestone Golem", "Kill a Cobblestone Golem");
		addKillAdvancement(GaiaRegistry.CREEP, "Creep", "Kill a Creep");
		addKillAdvancement(GaiaRegistry.DEATHWORD, "Deathword", "Kill a Deathword");
		addKillAdvancement(GaiaRegistry.DULLAHAN, "Dullahan", "Kill a Dullahan");
		addKillAdvancement(GaiaRegistry.ENDER_EYE, "Ender Eye", "Kill anEnder Eye");
		addKillAdvancement(GaiaRegistry.FLESH_LICH, "Flesh Lich", "Kill a Flesh Lich");
		addKillAdvancement(GaiaRegistry.GELATINOUS_SLIME, "Gelatinous Slime", "Kill a Gelatinous Slime");
		addKillAdvancement(GaiaRegistry.GOBLIN_FERAL, "Goblin Feral", "Kill a Goblin Feral");
		addKillAdvancement(GaiaRegistry.HARPY, "Harpy", "Kill a Harpy");
		addKillAdvancement(GaiaRegistry.KOBOLD, "Kobold", "Kill a Kobold");
		addKillAdvancement(GaiaRegistry.MATANGO, "Matango", "Kill a Matango");
		addKillAdvancement(GaiaRegistry.MIMIC, "Mimic", "Kill a Mimic");
		addKillAdvancement(GaiaRegistry.MINOTAUR, "Minotaur", "Kill a Minotaur");
		addKillAdvancement(GaiaRegistry.MINOTAURUS, "Minotaurus", "Kill a Minotaurus");
		addKillAdvancement(GaiaRegistry.NAGA, "Naga", "Kill a Naga");
		addKillAdvancement(GaiaRegistry.NINE_TAILS, "Nine Tails", "Kill a Nine Tails");
		addKillAdvancement(GaiaRegistry.ONI, "Oni", "Kill an Oni");
		addKillAdvancement(GaiaRegistry.ORC, "Orc", "Kill an Orc");
		addKillAdvancement(GaiaRegistry.SHAMAN, "Shaman", "Kill a Shaman");
		addKillAdvancement(GaiaRegistry.SHARKO, "Sharko", "Kill a Sharko");
		addKillAdvancement(GaiaRegistry.SIREN, "Siren", "Kill a Siren");
		addKillAdvancement(GaiaRegistry.SLUDGE_GIRL, "Sludge Girl", "Kill a Sludge Girl");
		addKillAdvancement(GaiaRegistry.SPHINX, "Sphinx", "Kill a Sphinx");
		addKillAdvancement(GaiaRegistry.SPORELING, "Sporeling", "Kill a Sporeling");
		addKillAdvancement(GaiaRegistry.SPRIGGAN, "Spriggan", "Kill a Spriggan");
		addKillAdvancement(GaiaRegistry.SUCCUBUS, "Succubus", "Kill a Succubus");
		addKillAdvancement(GaiaRegistry.TOAD, "Toad", "Kill a Toad");
		addKillAdvancement(GaiaRegistry.VALKYRIE, "Valkyrie", "Kill a Valkyrie");
		addKillAdvancement(GaiaRegistry.WERECAT, "Werecat", "Kill a Werecat");
		addKillAdvancement(GaiaRegistry.WITCH, "Witch", "Kill a Witch");
		addKillAdvancement(GaiaRegistry.WITHER_COW, "Wither Cow", "Kill a Wither Cow");

		//Patchouli
		addPatchouliEntry("name", "Grimoire of Gaia");
		addPatchouliEntry("subtitle", "Gaiapedia");
		addPatchouliEntry("landing", "This book will teach you all about the mobs added by the $(thing)Grimoire of Gaia$() mod, and is packed with information on each creature's abilities, behaviors.");

		addPatchouliEntry("category.assist.name", "Assist");
		addPatchouliEntry("category.assist.desc", "Assist mobs are usually passive unless provoked. So as long as you don't attack them they shouldn't attack you.");

		//Assist mobs
		addPatchouliEntry("entry.centaur.name", "Centaur");
		addPatchouliEntry("entry.centaur.info", "The $(mob)Centaur$() spawns in the $(thing)Overworld$(). If provoked the $(mob)Centaur$() will retaliate with ranged $(thing)Poison$() and $(thing)Weakness$() arrow attacks. Attacking a $(mob)Centaur$() angers all others in the area, similar to the $(mob)Zombie Pigman$(). When the $(mob)Centaur$() reaches 25%%, they will run away and recover health, then resume attacking.");
		addPatchouliEntry("entry.centaur.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.cobble_golem.name", "Cobble Golem");
		addPatchouliEntry("entry.cobble_golem.info", "The $(mob)Cobble Golem$() spawns in the Jungle in the $(thing)Overworld$(). It has immunity to $(thing)Poison$(), Fire, and knockback but it is vulnerable to pickaxe attacks and drowning. $(mob)Cobble Golems$() will attack hostile mobs with melee attacks and occasionally throw its targets away from it.");
		addPatchouliEntry("entry.cobble_golem.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)7-21 Damage$()");

		addPatchouliEntry("entry.cyclops.name", "Cyclops");
		addPatchouliEntry("entry.cyclops.info", "The $(mob)Cyclops$() spawns on the surface of Taiga biomes in the $(thing)Overworld$(). If provoked the $(mob)Cyclops$() it uses melee attacks which apply a $(thing)Slowness$() effect. While below 25%% health in combat, she receives a $(thing)Speed$() effect.");
		addPatchouliEntry("entry.cyclops.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.dryad.name", "Dryad");
		addPatchouliEntry("entry.dryad.info", "The $(mob)Dryad$() spawns in Forest biomes during the day on $(thing)Overworld$(). It is vulnerable to axes and Fire. If provoked the $(mob)Dryad$() will retaliate with weak melee attacks. Attacking a $(mob)Dryad$() angers all others nearby, similar to the $(mob)Zombie Pigman$(). When the $(mob)Dryad$() reaches 25%%, it will flee to heal. While in water, it recovers 10%% of its health every 10 seconds and gains $(thing)Resistance$().");
		addPatchouliEntry("entry.dryad.info2", "$(li)80 Health$()$(li)6 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.dwarf.name", "Dwarf");
		addPatchouliEntry("entry.dwarf.info", "The $(mob)Dwarf$() spawns at high elevations in mountainous biomes in the $(thing)Overworld$(). $(mob)Dwarves$() attack $(l:orc)$(mob)Orcs$() on sight, either in melee, applying $(thing)Slowness$() and $(thing)Mining Fatigue$() on hit, or at ranged with a bow which may apply $(thing)Slowness$() or $(thing)Weakness$() potion arrows.");
		addPatchouliEntry("entry.dwarf.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.ender_dragon_girl.name", "Ender Dragon Girl");
		addPatchouliEntry("entry.ender_dragon_girl.info", "The $(mob)Ender Dragon Girl$() spawns in $(thing)The End$(). Like the $(mob)Enderman$(), she is vulnerable to water, has an immunity to falling damage and web effects, and will teleport in combat. Although usually passive, she will retaliate if attacked or if a nearby $(mob)Enderman$() is provoked.");
		addPatchouliEntry("entry.ender_dragon_girl.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.goblin.name", "Goblin");
		addPatchouliEntry("entry.goblin.info", "The $(mob)Goblin$() spawns on the surface in Savannas in the $(thing)Overworld$(). If provoked the $(mob)Goblin$() will engage in melee. $(mob)Goblins$() may spawn with wooden weapons and occasionally a $(mob)Goblin$() may spawn as a $(mob)Goblin Bomber$(), equipped with powder keg and $(item)Bombs$(), which they throw at medium range in combat to attack.");
		addPatchouliEntry("entry.goblin.info2", "$(li)40 Health$()$(li)3-6 Damage$()");

		addPatchouliEntry("entry.gryphon.name", "Gryphon");
		addPatchouliEntry("entry.gryphon.info", "The $(mob)Gryphon$() is flying animal that spawns in mountainous biomes during the day in the $(thing)Overworld$(). It is immune to falling damage. If provoked the $(mob)Gryphon$() will strike with leaping melee attacks with strong knockback that inflict $(thing)Slowness$() on contact.");
		addPatchouliEntry("entry.gryphon.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.bee.name", "Honey Bee");
		addPatchouliEntry("entry.bee.info", "The $(mob)Honey Bee$() is a flying creature that spawns in the $(thing)Overworld$(). It is immune to $(thing)Poison$() and falling damage. If provoked the $(thing)Honey Bee$() will retaliate with ranged attacks before leaping into melee with attacks that have strong knockback. Attacking a $(mob)Honey Bee$() angers all others in the area, similar to the $(mob)Zombie Pigman$().");
		addPatchouliEntry("entry.bee.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.hunter.name", "Hunter");
		addPatchouliEntry("entry.hunter.info", "The $(mob)Hunter$() spawns in the $(thing)Overworld$(). If provoked the $(mob)Hunter$() will retaliate with ranged $(thing)Poison$() arrows. The $(mob)Hunter$() switches to melee attacks when in close proximity to its attacker and will gain a $(thing)Speed$() effect.");
		addPatchouliEntry("entry.hunter.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.mermaid.name", "Mermaid");
		addPatchouliEntry("entry.mermaid.info", "The $(mob)Mermaid$() is a swimming creature that spawns in the oceans of the $(thing)Overworld$(). It is immune to drowning, and ranged attacks, can move through water unimpeded, and is resistant to Fire. While in water, it gains a $(thing)Resistance$() effect and restores 10%% of its health every 5 seconds. If provoked the $(mob)Mermaid$() attacks with melee strikes which apply $(thing)Mining Fatigue$() and $(thing)Slowness$() effects.");
		addPatchouliEntry("entry.mermaid.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.satyress.name", "Satyress");
		addPatchouliEntry("entry.satyress.info", "The $(mob)Satyress$() spawns in Plains and Mesa of the $(thing)Overworld$(). If provoked the $(mob)Satyress$() will engage in melee, inflicting $(thing)Slowness$() on hit. When reduced below 25%% health, a $(mob)Satyress$() will flee from combat to recover health before resuming the attack.");
		addPatchouliEntry("entry.satyress.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.valkyrie.name", "Valkyrie");
		addPatchouliEntry("entry.valkyrie.info", "The $(mob)Valkyrie$() spawns in mountainous biomes in the $(thing)Overworld$(). When provoked by being attacked or by remaining too close to it for too long it attacks, inflicting $(thing)Slowness$() and $(thing)Weakness$(). It is immune to falling damage, drowning, and Fire, and is resistant to knockback. When a $(mob)Valkyrie$() is reduced to 25%% health or lower, it gains a $(thing)Strength$() and $(thing)Speed$() effect.");
		addPatchouliEntry("entry.valkyrie.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.wizard_harpy.name", "Wizard Harpy");
		addPatchouliEntry("entry.wizard_harpy.info", "The $(mob)Wizard Harpy$() is a flying creature that spawns in Roofed Forests in the $(thing)Overworld$(). All $(mob)Wizard Harpies$() spawn with a $(item)Magic Book$(), and attack players using magic projectiles which inflict a random effect based upon the $(item)Magic Book$() they are spawned with. $(mob)Wizard Harpies$() are immune to falling damage. When a $(mob)Wizard Harpy$() is reduced to 25%% health or lower, it may flee combat entirely.");
		addPatchouliEntry("entry.wizard_harpy.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.yuki_onna.name", "Yuki-Onna");
		addPatchouliEntry("entry.yuki_onna.info", "The $(mob)Yuki-Onna$() spawns in Taigas of the $(thing)Overworld$() during rainy or snowy weather. It provoked it attacks in melee, inflicting $(thing)Slowness IV$() on hit. $(mob)Yuki-Onna's$() can spawn equipped with a $(item)Hand Fan$() which increases the knockback of their attacks. $(mob)Yuki-Onna's$() are immune to Fire and falling damage, and can move through cobwebs unimpeded. When reduced to 50%% health or lower, a $(mob)Yuki-Onna$() may flee combat entirely.");
		addPatchouliEntry("entry.yuki_onna.info2", "$(li)20 Health$()$(li)4 Armor$()$(li)4 Damage$()");
		addPatchouliEntry("entry.yuki_onna.info3", "$(mob)Yuki-Onna's$() are vulnerable to warm climates and are inflicted with $(thing)Slowness$() and $(thing)Weakness$() if they enter warm or hot biomes.");

		//hostile patchouli entries
		addPatchouliEntry("category.hostile.name", "Hostile");
		addPatchouliEntry("category.hostile.desc", "Hostile mobs are usually aggressive and will attack you on sight. They are dangerous but usually drop useful components if killed.");

		//Hostile Gaia Mobs
		addPatchouliEntry("entry.ant_salvager.name", "Ant Salvager");
		addPatchouliEntry("entry.ant_salvager.info", "The $(mob)Ant Salvager$() is monster that spawns inside the sand in deserts in the $(thing)Overworld$(). It is resistant to Fire and immune to Poison and Knockback. The $(mob)Ant Ranger$() is completely immobile. It attacks the player at range with a lobbed projectile. It may apply a $(thing)Poison$() effect on its target and will turn invisible when the player gets too close. Breaking the block underneath it eliminates it.");
		addPatchouliEntry("entry.ant_salvager.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.ant.name", "Ant Worker");
		addPatchouliEntry("entry.ant.info", "The $(mob)Ant Worker$() is monster that spawns underground in deserts in the $(thing)Overworld$(). It is resistant to Fire and Poison damage. As an arthropod, it is vulnerable to $(thing)Bane of Arthropods$(). It may spawn with a variety of wooden weapons in its hand and will attack players on sight. While in combat, it may apply a $(thing)Slowness$() or $(thing)Mining Fatigue$() effect to the player and may run away to regenerate health.");
		addPatchouliEntry("entry.ant.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.anubis.name", "Anubis");
		addPatchouliEntry("entry.anubis.info", "The $(mob)Anubis$() is a humanoid monster that spawns in deserts on the surface in the $(thing)Overworld$(). It is resistant to Fire. The $(mob)Anubis$() will attack players on sight with a mix of melee and ranged attacks, and can apply a $(thing)Slowness$() or $(thing)Blindness$() effect to its target. In combat, it can spawn up to 2 $(mob)Skeletons$() with headgear, also granting summoned $(mob)Skeletons$() a $(thing)Resistance$() effect.");
		addPatchouliEntry("entry.anubis.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.arachne.name", "Arachne");
		addPatchouliEntry("entry.arachne.info", "The $(mob)Arachne$() is a monster that spawns in dark places in the $(thing)Overworld$(). It is immune to $(thing)Poison$(), can pass through Cobwebs unimpeded, and can climb walls. It attacks players with ranged attacks and switches to melee when below 50%% health. Its attacks can apply a $(thing)Poison$() effect and it will attempt to web its target. $(mob)Arachne$() can spawn up to 2 $(mob)Cave Spiders$() with a $(thing)Resistance$() effect.");
		addPatchouliEntry("entry.arachne.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.banshee.name", "Banshee");
		addPatchouliEntry("entry.banshee.info", "The $(mob)Banshee$() is a flying monster that spawns on the surface of Mountains and Taiga in the $(thing)Overworld$(). It is immune to Fire and falling damage, and can pass through blocks unimpeded. The $(mob)Banshee$() is undead and thus burns in sunlight. $(mob)Banshees$() attack players on sight with swooping melee attacks.");
		addPatchouliEntry("entry.banshee.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.behender.name", "Behender");
		addPatchouliEntry("entry.behender.info", "The $(mob)Behender$() is a flying monster that spawns in $(thing)The End$(). It attacks players on sight, inflicting them with random negative potion effects. It is resistant to knockback and can teleport when a player comes close to it to attack in melee, similar to an $(mob)Enderman$(). It is immune to falling damage. When reduced to 50%% health or lower, a $(mob)Behender$() will shield itself, protecting it from ranged attacks.");
		addPatchouliEntry("entry.behender.info2", "$(li)80 Health$()$(li)6 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.bone_knight.name", "Bone Knight");
		addPatchouliEntry("entry.bone_knight.info", "The $(mob)Bone Knight$() is a monster that spawns in the $(thing)Overworld$(). As an undead, it is vulnerable to sunlight and the $(thing)Smite$() enchantment. $(mob)Bone Knights$() are immune to ranged attacks, and can sometimes resist knockback from attacks. A $(mob)Bone Knight$() attacks players on sight and its attacks apply a $(thing)Slowness$() and $(thing)Mining Fatigue$(thing) on its target.");
		addPatchouliEntry("entry.bone_knight.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.cecaelia.name", "Cecaelia");
		addPatchouliEntry("entry.cecaelia.info", "The $(mob)Cecaelia$() is an monster that spawns underground in the Ocean of the $(thing)Overworld$(). It is immune to Fire and drowning, and moves freely in water. $(mob)Cecaelias$() attack players on sight, and are able to swap between ranged and melee attacks which apply a $(thing)Mining Fatigue$() effect on their target. $(mob)Cecaelias$() receives a $(thing)Resistance$() and $(thing)Regeneration$() effect when under water.");
		addPatchouliEntry("entry.cecaelia.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.cobblestone_golem.name", "Cobblestone Golem");
		addPatchouliEntry("entry.cobblestone_golem.info", "The $(mob)Cobblestone Golem$() spawns in the Jungle in the $(thing)Overworld$(). Similar to and slightly stronger than the $(mob)Cobble Golem$(), it has immunity to $(thing)Poison$(), $(thing)Fire$(), and $(thing)knockback$() but is vulnerable to pickaxe attacks and drowning. $(mob)Cobblestone Golems$() will attack hostile mobs with melee attacks and occasionally throw targets away from itself. It will not attack unless provoked.");
		addPatchouliEntry("entry.cobblestone_golem.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)7-21 Damage$()");

		addPatchouliEntry("entry.creep.name", "Creep");
		addPatchouliEntry("entry.creep.info", "The $(mob)Creep$() is a monster that spawns in the $(thing)Overworld$(). It attacks players on sight by sneakily approaching them before exploding, similar to a $(mob)Creeper$(). Additionally, the $(mob)Creep$() is invisible unless within 8 blocks of a player.");
		addPatchouliEntry("entry.creep.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.deathword.name", "Deathword");
		addPatchouliEntry("entry.deathword.info", "The $(mob)Deathword$() is a flying monster that spawns underground in the $(thing)Overworld$() at night. It is vulnerable to Fire, but immune to falling damage. It attacks players on sight by summoning up to 4 $(mob)Skeletons$() or $(mob)Zombies$() as minions. When it is no longer able to spawn minions, it will engage its target at close range, throwing sheets of paper.");
		addPatchouliEntry("entry.deathword.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.dullahan.name", "Dullahan");
		addPatchouliEntry("entry.dullahan.info", "The $(mob)Dullahan$() is a monster that spawns on the surface in mountainous biomes in the $(thing)Overworld$() at night. She is vulnerable to gold equipment, weapons, and tools. $(mob)Dullahan$() attack players on sight with melee attacks that apply a $(thing)Slowness$() effect.");
		addPatchouliEntry("entry.dullahan.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.ender_eye.name", "Ender Eye");
		addPatchouliEntry("entry.ender_eye.info", "The $(mob)Ender Eye$() is neutral flying monster that spawns in dark places and on the surface at night in the $(thing)Overworld$(). It is immune to falling damage and web effects. Similar to the $(mob)Enderman$(), an $(mob)Ender Eye$() is passive unless a player makes eye-contact with it, then it will immediately attack the player. As an End creature, it is vulnerable to water and teleports in combat.");
		addPatchouliEntry("entry.ender_eye.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.flesh_lich.name", "Flesh Lich");
		addPatchouliEntry("entry.flesh_lich.info", "The $(mob)Flesh Lich$() is a monster that spawns deep underground in the $(thing)Overworld$() at night. It attacks players on sight with ranged fireball attacks. Although it is undead and subsequently vulnerable to $(thing)Smite$() enchantments and sunlight, the $(mob)Flesh Lich$() is resistant to Fire.");
		addPatchouliEntry("entry.flesh_lich.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.gelatinous_slime.name", "Gelatinous Slime");
		addPatchouliEntry("entry.gelatinous_slime.info", "The $(mob)Gelatinous Slime$() is a monster that does not spawn naturally. It attacks players on sight with $(thing)Poison$()-inflicting attacks. It is immune to $(thing)Poison$(), Fire, and knockback. It cannot swim, and will avoid water. It possesses the ability to steal items from players and absorb arrows fired at it, consuming them to heal itself for 10%% of its health with each item. Additionally, $(mob)Gelatinous Slimes$() inflict $(thing)Slowness II$() on all nearby creatures.");
		addPatchouliEntry("entry.gelatinous_slime.info2", "$(li)80 Health$()$(li)6 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.goblin_feral.name", "Feral Goblin");
		addPatchouliEntry("entry.goblin_feral.info", "The $(mob)Feral Goblin$() is a monster that does not spawn naturally. It attacks players on sight with $(thing)Poison$()-inflicting attacks. It is immune to $(thing)Poison$(), Fire, and knockback. It cannot swim, and will avoid water. It possesses the ability to steal items from players and absorb arrows fired at it, consuming them to heal itself for 10%% of its health with each item. Additionally, $(mob)Gelatinous Slimes$() inflict $(thing)Slowness II$() on all nearby creatures.");
		addPatchouliEntry("entry.goblin_feral.info2", "$(li)20 Health$()$(li)4 Armor$()$(li)4 Damage$()");

		addPatchouliEntry("entry.harpy.name", "Harpy");
		addPatchouliEntry("entry.harpy.info", "The $(mob)Harpy$() is a monster that spawns in Plains and Mesa biomes in the $(thing)Overworld$(). It is immune to falling damage and may flee when below 25%% health. It attacks players on sight, with leaping melee attacks with strong knockback and inflicting $(thing)Slowness$() on its target.");
		addPatchouliEntry("entry.harpy.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.kobold.name", "Kobold");
		addPatchouliEntry("entry.kobold.info", "The $(mob)Kobold$() is a monster that spawns in the Ice Plains of the $(thing)Overworld$(). It attacks players on sight with ranged $(thing)Slowness$() or $(thing)Weakness$() arrows. A $(mob)Kobold$() will switch to melee attacks when in close proximity to its target and will gain a $(thing)Speed$() effect.");
		addPatchouliEntry("entry.kobold.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.matango.name", "Matango");
		addPatchouliEntry("entry.matango.info", "The $(mob)Matango$() is a humanoid monster that spawns in roofed forests on the surface in the $(thing)Overworld$(). It is immune to poison and knockback and has a weakness to fire and axes. The $(mob)Matango$() will attack players on sight with a mix of melee and ranged attacks, and can apply a $(thing)Nausea$() effect to its target. In combat, it can spawn up to 5 $(mob)Sporelings$().");
		addPatchouliEntry("entry.matango.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.mimic.name", "Mimic");
		addPatchouliEntry("entry.mimic.info", "The $(mob)Mimic$() is a monster that disguises itself as a chest and spawns underground in the $(thing)Overworld$(). It is immune to fall damage and knockback, but vulnerable to fire. When idle, it may steal nearby items and consume them to restore 20%% of its health, but stolen items cannot be recovered. When provoked, it attacks with melee strikes that apply a $(thing)hunger$() debuff for 30 seconds.");
		addPatchouliEntry("entry.mimic.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");
		addPatchouliEntry("entry.mimic.info3", "The $(mob)Mimics$() may drop any item which a basic $(thing)Minecraft$() creature could drop on death.");

		addPatchouliEntry("entry.minotaur.name", "Minotaur");
		addPatchouliEntry("entry.minotaur.info", "The $(mob)Minotaur$() is a monster that spawns in Plains and Mesa biomes in the $(thing)Overworld$(). It attacks players on sight with melee strikes which apply $(thing)Mining Fatigue$() and $(thing)Slowness$() effects. It is immune to falling damage, Fire, and ranged attacks. It is also unimpeded by cobwebs or water. When a $(mob)Minotaur's$() health drops below 25%, it gains a $(thing)Strength$() and $(thing)Resistance$() effect.");
		addPatchouliEntry("entry.minotaur.info2", "$(li)160 Health$()$(li)16 Armor$()$(li)16 Damage$()");

		addPatchouliEntry("entry.minotaurus.name", "Minotaurus");
		addPatchouliEntry("entry.minotaurus.info", "The $(mob)Minotaurus$() is a monster that spawns in Plains and Mesa biomes in the $(thing)Overworld$(). It attacks players on sight, either by charging their target and striking them in melee, inflicting $(thing)Slowness$() and $(thing)Mining Fatigue$(), or by keeping distance and attacking with a bow, if it spawned with one. $(mob)Minotaurus$() with bows may also use $(thing)Slowness$() or $(thing)Weakness$() potion arrows.");
		addPatchouliEntry("entry.minotaurus.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.naga.name", "Naga");
		addPatchouliEntry("entry.naga.info", "The $(mob)Naga$() is a monster that spawns in Swamps in the $(thing)Overworld$(). It attacks players on sight with melee attacks inflicting $(thing)Slowness$() and $(thing)Mining Fatigue$() on hit. $(mob)Nagas$() are immune to $(thing)Poison$(), and ranged attacks, and can move through water unimpeded. When below 25%% health, a $(mob)Naga$() gains a $(thing)Speed$() effect and will retreat to water where it will heal for 10%% of their health every 5 seconds and gain $(thing)Resistance$().");
		addPatchouliEntry("entry.naga.info2", "$(li)80 Health$()$(li)6 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.nine_tails.name", "Nine Tails");
		addPatchouliEntry("entry.nine_tails.info", "The $(mob)Nine-Tails$() is a monster that spawns in Taigas of the $(thing)Overworld$(). It attacks players on sight by throwing fireballs at them from range, which set targets on fire. When reduced below 75%% health, a $(mob)Nine-Tails$() engages its target in melee. $(mob)Nine-Tails$() can spawn equipped with a $(item)Hand Fan$() which increases the knockback of their attacks. $(mob)Nine-Tails$() are immune to Fire.");
		addPatchouliEntry("entry.nine_tails.info2", "$(li)80 Health$()$(li)6 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.oni.name", "Oni");
		addPatchouliEntry("entry.oni.info", "The $(mob)Oni$() is a monster that spawns in Taigas of the $(thing)Overworld$() at night. It attacks players on sight by attempting to get into melee, inflicting $(thing)Slowness$() on hit. When reduced below 25%%, $(mob)Oni$() gain a $(thing)Strength$() potion effect.");
		addPatchouliEntry("entry.oni.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.orc.name", "Orc");
		addPatchouliEntry("entry.orc.info", "The $(mob)Orc$() is a monster that spawns in Savanna biomes of the $(thing)Overworld$(). $(mob)Orcs$() may spawn as a Melee or Ranged variant and attack players and $(l:dwarf)$(mob)Dwarves$(). The melee variant can break doors, and may spawn with a shield, providing protection from ranged attacks. The ranged variant grant nearby $(mob)Orcs$() a $(thing)Haste II$() effect. When an $(mob)Orc$() is reduced to 25%% health, it gains a $(thing)Strength$() potion effect.");
		addPatchouliEntry("entry.orc.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.shaman.name", "Shaman");
		addPatchouliEntry("entry.shaman.info", "The $(mob)Shaman$() is a monster that spawns in Jungles in the $(thing)Overworld$() at night. It attacks players on sight with a lobbed $(thing)Poison$() potion attack, similar to an $(mob)Witch$(). The $(mob)Shaman$() will summon up to 2 $(mob)Zombies$() to engage the player in melee while providing them with a $(thing)Resistance$() effect. It is immune to $(thing)Poison$(). When reduced to 75%% health or less, a $(mob)Shaman$() switches from ranged attacks to melee, inflicting $(thing)Poison$() and $(thing)Weakness$() on hit.");
		addPatchouliEntry("entry.shaman.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.sharko.name", "Sharko");
		addPatchouliEntry("entry.sharko.info", "The $(mob)Sharko$() is a monster that spawns in Oceans in the $(thing)Overworld$() at night. It attacks players on sight with powerful melee attacks which inflict $(thing)Slowness$() and $(thing)Mining Fatigue III$(). It is immune to drowning and can move through water unimpeded. While in water, a $(mob)Sharko$() gains a $(thing)Resistance$() effect and regenerates 10%% of its health every 5 seconds.");
		addPatchouliEntry("entry.sharko.info2", "$(li)80 Health$()$(li)6 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.siren.name", "Siren");
		addPatchouliEntry("entry.siren.info", "The $(mob)Siren$() is a monster that spawns in Swamps in the $(thing)Overworld$(). It attacks players at ranged and which may inflict $(thing)Slowness$() and $(thing)Weakness$() effects. The $(mob)Siren$() switches to melee and gains a $(thing)Speed$() effect, inflicting $(thing)Mining Fatigue II$() on hit. $(mob)Sirens$() are immune to $(thing)Poison$() and can move through water unimpeded. While in water, $(mob)Sirens$() heal for 10%% of their health every 5 seconds and gain $(thing)Resistance$().");
		addPatchouliEntry("entry.siren.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.sludge_girl.name", "Sludge Girl");
		addPatchouliEntry("entry.sludge_girl.info", "The $(mob)Sludge Girl$() is a monster that spawns in Swamps in the $(thing)Overworld$() at night. It attacks players on sight by closing the distance with a leaping attack with strong knockback followed by melee attacks which inflict $(thing)Poison$(). It is resistant to Fire and immune to $(thing)Poison$(). When a $(mob)Sludge Girl$() dies, it leaves behind a lingering $(thing)Poison$() potion effect.");
		addPatchouliEntry("entry.sludge_girl.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.sphinx.name", "Sphinx");
		addPatchouliEntry("entry.sphinx.info", "The $(mob)Sphinx$() is a monster that spawns in the Deserts of the $(thing)Overworld$() at night. It attacks players on sight, inflicting $(thing)Slowness$() and $(thing)Mining Fatigue$() with its melee strikes. It is immune to falling damage, Fire, drowning, and ranged attacks. It can move through cobwebs and water unimpeded. When a $(mob)Sphinx's$() health drops below 75%% it will regenerate 10%% of its total health.");
		addPatchouliEntry("entry.sphinx.info2", "$(li)160 Health$()$(li)16 Armor$()$(li)18 Damage$()");

		addPatchouliEntry("entry.sporeling.name", "Sporeling");
		addPatchouliEntry("entry.sporeling.info", "The $(mob)Sporeling$() is a monster that is summoned by $(l:matango)$(mob)Matango$() in combat. it attacks players on sight by attacking in melee and inflicting them with a $(thing)Harming$() potion effect on hit, allowing their attacks to bypass armor.");
		addPatchouliEntry("entry.sporeling.info2", "$(li)20 Health$()$(li)4 Armor$()$(li)4 Damage$()");

		addPatchouliEntry("entry.spriggan.name", "Spriggan");
		addPatchouliEntry("entry.spriggan.info", "The $(mob)Spriggan$() is a monster that spawns in the Forests of the $(thing)Overworld$() at night. It stealthily waits for players to approach it before attacking, benefiting from an $(thing)Invisibility$() effect until a player comes within 6 blocks of it. It is vulnerable to Fire and axes. While in water, $(mob)Spriggans$() gain $(thing)Resistance$() and regenerate 10%% of their health every 5 seconds.");
		addPatchouliEntry("entry.spriggan.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.succubus.name", "Succubus");
		addPatchouliEntry("entry.succubus.info", "The $(mob)Succubus$() is a monster that spawns in the $(thing)Nether$(). It attacks players on sight with life-draining melee attacks, which inflict $(thing)Mining Fatigue$() on contact. A $(mob)Succubus$() heals itself for 10%% of their health per hit. It is immune to falling damage and Fire.");
		addPatchouliEntry("entry.succubus.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.toad.name", "Toad");
		addPatchouliEntry("entry.toad.info", "The $(mob)Toad$() is a monster that spawns in Roofed Forests of the $(thing)Overworld$(). It attacks players on sight by closing the distance with a leaping attack with strong knockback before engaging with melee attacks inflicting $(thing)Poison$(). It is resistant to Fire and immune to $(thing)Poison$(). While in water, a $(mob)Toad$() gains a $(thing)Resistance$() effect and regenerates 10%% of its health every 5 seconds. It is vulnerable to warm climates and is inflicted with $(thing)Slowness$() and $(thing)Weakness$() if it enters warm or hot biomes.");
		addPatchouliEntry("entry.toad.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.werecat.name", "Werecat");
		addPatchouliEntry("entry.werecat.info", "The $(mob)Werecat$() is a monster that spawns in Forests in the $(thing)Overworld$() at night. It attacks players on sight by closing the distance with a leaping attack with strong knockback before following up with rapid melee attacks which inflict $(thing)Slowness$() and $(thing)Mining Fatigue$() on hit. When reduced to 25%% health or lower, a $(mob)Werecat$() may flee combat entirely.");
		addPatchouliEntry("entry.werecat.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");

		addPatchouliEntry("entry.witch.name", "Witch");
		addPatchouliEntry("entry.witch.info", "The $(mob)Witch$() is a monster that spawns in Roofed Forests in the surface in the $(thing)Overworld$() at night. It is immune to $(thing)Poison$() and $(thing)Harming$() potion effects. $(mob)Witches$() attack players on sight with a ranged potion effect attack similar to the $(mob)Witch$(). In combat, it can spawn up to 1 $(mob)Skeleton$() and 1 $(mob)Zombie$(), also granting summoned $(mob)Skeletons$() a $(thing)Resistance$() effect.");
		addPatchouliEntry("entry.witch.info2", "$(li)80 Health$()$(li)8 Armor$()$(li)12 Damage$()");

		addPatchouliEntry("entry.wither_cow.name", "Wither Cow");
		addPatchouliEntry("entry.wither_cow.info", "The $(mob)Wither Cow$() is a monster that spawns in the $(thing)Nether$(). It attacks players on sight, inflicting $(thing)Wither$() with its attacks, and projecting an aura that afflicts all creatures within 4 blocks with $(thing)Slowness$(). It is immune to $(thing)Wither$(), Fire, and knockback. When a $(mob)Wither Cow$() dies, it leaves behind a lingering $(thing)Wither$() potion effect.");
		addPatchouliEntry("entry.wither_cow.info2", "$(li)40 Health$()$(li)4 Armor$()$(li)8 Damage$()");


		//Drops
		addPatchouliEntry("drop.bag_arrows.info", "They can drop a $(item)Sealed Quiver$() on death, which can be right-clicked while held to open and receive a small stack of potion arrows randomly chosen from among $(thing)Slowness$(), $(thing)Harming$(), $(thing)Poison$(), or $(thing)Weakness$() effects.");
		addPatchouliEntry("drop.bag_book.info", "They can drop a $(item)Book Bag$() on death. Right-click to open the bag and receive a random enchantment book.");
		addPatchouliEntry("drop.bag_record.info", "They can drop a $(item)Record Box$() on death. Right-click to open the bag and receive a random record.");
		addPatchouliEntry("drop.book.info", "They can drop a $(item)Book$() on death.");
		addPatchouliEntry("drop.book_of_memory.info", "They can rarely drop $(item)Book of Memory$() which can be used to gain 10 experience levels.");
		addPatchouliEntry("drop.box_diamond.info", "They can drop a $(item)Diamond Box$() on death, which can be right-clicked while held to open and receive a random tool, weapon, or armor piece made of diamond. Alternatively, it can be smelted in a furnace to create $(item)Crystallized Experience (Large)$().");
		addPatchouliEntry("drop.box_end.info", "They can drop a $(item)Ender Box$() on death, which can be right-clicked while held to open and receive random blocks from $(item)The End$().");
		addPatchouliEntry("drop.box_gold.info", "They can drop a $(item)Gold Box$() on death, which can be right-clicked while held to open and receive a random tool, weapon, or armor piece made of gold. Alternatively, it can be smelted in a furnace to create $(item)Crystallized Experience (Medium)$().");
		addPatchouliEntry("drop.box_iron.info", "They can drop a $(item)Iron Box$() on death, which can be right-clicked while in hand to open and receive a random tool, weapon, or armor piece made of iron. Alternatively, it can be smelted in a furnace to create $(item)Crystallized Experience (Small)$().");
		addPatchouliEntry("drop.box_overworld.info", "They can drop an $(item)Overworld Box$() on death, which can be right-clicked while held to open and receive a random ore found in the $(thing)Overworld$().");
		addPatchouliEntry("drop.box_nether.info", "They can drop an $(item)Nether Box$() on death, which can be right-clicked while held to open and receive loot usually found in the $(thing)Nether$().");
		addPatchouliEntry("drop.brown_mushroom.info", "They can drop $(item)Brown Mushroom$() on death.");
		addPatchouliEntry("drop.bust_sphinx.info", "They can drop $(item)The Sphinx$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.bust_valkyrie.info", "They can drop $(item)The Valkyrie$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.bust_minotaur.info", "They can drop $(item)Minotaur Bust$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.chest_desert.info", "They can drop a $(item)Desert Chest$() on death, which can be right-clicked while held to open and receive random loot that are normally found in $(thing)Desert Pyramid$() chests.");
		addPatchouliEntry("drop.chest_jungle.info", "They can drop a $(item)Jungle Chest$() on death, which can be right-clicked while held to open and receive random loot that are normally found in $(thing)Jungle Temple$() chests.");
		addPatchouliEntry("drop.cod.info", "They can drop $(item)Fish$() on death, which are a good source of food when cooked, and can be used to tame $(mob)Ocelots$()");
		addPatchouliEntry("drop.dark_oak_log.info", "They can drop a random burnable log on death.");
		addPatchouliEntry("drop.deco_mandragora_pot.info", "They can drop a$(item)Mandragora Pot$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.deco_nest_harpy.info", "They can drop a$(item)Harpy Nest$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.diamond_shard.info", "They can drop $(item)Diamond Shards$() on death, which can be combined to make $(item)Diamonds$().");
		addPatchouliEntry("drop.doll_creeper_girl.info", "They can drop a$(item)Creeper Girl Doll$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.doll_dryad.info", "They can drop a$(item)Dryad Doll$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.doll_dullahan.info", "They can drop a$(item)Dullahan Doll$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.doll_ender_girl.info", "They can drop an $(item)Ender Girl Doll$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.doll_nine_tails.info", "They can drop a $(item)Nine Tails Doll$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.doll_slime_girl.info", "They can drop a $(item)Slime Girl Doll$() on death, which can be placed as a decoration block.");
		addPatchouliEntry("drop.elytra_fragment.info", "They can drop a $(item)Elytra Fragment$() on death, which can be combined to make an $(item)Elytra$().");
		addPatchouliEntry("drop.emerald_shard.info", "They can drop $(item)Emerald Shards$() on death, which can be combined to make $(item)Emeralds$().");
		addPatchouliEntry("drop.enchanted_book.info", "They can drop an $(item)Enchanted Book$() on death.");
		addPatchouliEntry("drop.ender_pearl.info", "They can drop $(item)Ender Pearls$() on death.");
		addPatchouliEntry("drop.fan_fire.info", "They can rarely drop an $(item)Ornate Fire Fan$() on death, which is a magical melee weapon bearing the $(thing)Fire Aspect II$() enchantment and can inflict $(thing)Knockback I$() on hit.");
		addPatchouliEntry("drop.fan_ice.info", "They can rarely drop an $(item)Ornate Ice Fan$() on death, which is a magical melee weapon bearing the $(thing)Knockback II$() enchantment and can inflict $(thing)Slowness IV$() on hit.");
		addPatchouliEntry("drop.feather.info", "They can drop $(item)feathers() on death.");
		addPatchouliEntry("drop.fireshard.info", "They can drop $(item)Fireshards$() on death, which can be right-clicked to place lava");
		addPatchouliEntry("drop.rotten_heart.info", "They can drop $(item)Rotten Hearts$() on death, which can be eaten as a decent food source and also to gain a $(thing)Regeneration$() potion effect. However, when consumed, it may afflict players with $(thing)Hunger$().");
		addPatchouliEntry("drop.fur.info", "They can drop $(item)Fur$() on death, which can be smelted in a furnace to create $(item)Leather$().");
		addPatchouliEntry("drop.glowstone_dust.info", "They can drop $(item)Glowstone Dust$() on death, which can be combined to make a $(item)Glowstone$().");
		addPatchouliEntry("drop.gold_nugget.info", "They can drop $(item)Gold Nuggets$() on death, which can be combined to make $(item)Gold Ingots$().");
		addPatchouliEntry("drop.golden_apple_pie_slice.info", "They can drop $(item)Golden Apple Pie Slices$() on death, which can be eaten to grant players the same benefits as gained from eating a $(item)Golden Apple$().");
		addPatchouliEntry("drop.green_dye.info", "They can drop $(item)Green Dye$() on death.");
		addPatchouliEntry("drop.honeydew.info", "They can drop $(item)Honeydew$() on death. These are a decent source of food and provide a 20%% speed and haste buff for 10 seconds.");
		addPatchouliEntry("drop.iron_nugget.info", "They can drop $(item)Iron Nuggets$() on death, which can be combined to make $(item)Iron Ingots$().");
		addPatchouliEntry("drop.knuckles.info", "They can drop $(item)Knuckles$() on death, which is an accessory that boosts your damage.");
		addPatchouliEntry("drop.ring_of_speed.info", "They can drop a $(item)Ring of Speed$() on death, which is an accessory that applies Speed when worn.");
		addPatchouliEntry("drop.ring_of_haste.info", "They can drop a $(item)Ring of Haste$() on death, which is an accessory that applies Haste when worn.");
		addPatchouliEntry("drop.ring_of_jump.info", "They can drop a $(item)Ring of Jump$() on death, which is an accessory that applies Jump Boost when worn.");
		addPatchouliEntry("drop.ring_of_night.info", "They can drop a $(item)Ring of Night Vision$() on death, which is an accessory that applies Night Vision when worn.");
		addPatchouliEntry("drop.heavy_barbell.info", "They can drop a $(item)Heavy Barbell$() on death, which is an accessory that makes you slow when worn.");
		addPatchouliEntry("drop.minotaur_hammer.info", "They can drop a $(item)Minotaur Hammer$() on death, which is a weapon similar to an axe but slower as it's heavier.");
		addPatchouliEntry("drop.lapis_block.info", "They can drop a $(item)Block of Lapis Lazuli$() on death.");
		addPatchouliEntry("drop.lapis_lazuli.info", "They can drop $(item)Lapis Lazuli$() on death.");
		addPatchouliEntry("drop.leather.info", "They can drop $(item)Leather$() on death.");
		addPatchouliEntry("drop.meat.info", "They can drop $(item)Meat$() on death, which serves as a decent source of food.");
		addPatchouliEntry("drop.nether_wart_jam.info", "They can drop a $(item)Nether Wart Jam$() on death. These are a moderate source of food and provide a 40%% $(thing)Speed$() and $(thing)Haste$() effect for 30 seconds.");
		addPatchouliEntry("drop.oak_log.info", "They can drop an $(item)Oak Log$() on death.");
		addPatchouliEntry("drop.paper.info", "They can drop $(item)Paper$() on death.");
		addPatchouliEntry("drop.premium_monster_feed.info", "They can drop $(item)Premium Monster Feed$() on death. This item can be used to tame any helper mobs from $(thing)Grimoire of Gaia$(). When tamed, they will behave like a vanilla $(mob)Golem$().");
		addPatchouliEntry("drop.prismarine_shard.info", "They can drop $(item)Prismarine Shards$() on death, which are primarily used for making $(item)Prismarine Blocks$().");
		addPatchouliEntry("drop.quartz.info", "They can drop $(item)Quartz$() on death, which can be combined to make a $(item)Block of Quartz$().");
		addPatchouliEntry("drop.red_mushroom.info", "They can drop $(item)Brown Mushroom$() on death.");
		addPatchouliEntry("drop.redstone.info", "They can drop $(item)Redstone$() on death.");
		addPatchouliEntry("drop.redstone_block.info", "They can drop a $(item)Redstone Block$() on death.");
		addPatchouliEntry("drop.shiny_pearl.info", "They can drop $(item)Shiny pearls$() on death, which can be combined to make a $(item)Pearl Block$().");
		addPatchouliEntry("drop.skeleton_skull.info", "They can drop a $(item)Skeleton Skull$() on death.");
		addPatchouliEntry("drop.slime_ball.info", "They can drop $(item)Slime balls$() on death, which are used for crafting a variety of items such as $(item)Sticky Pistons$(), $(item)Leads$(), and many others.");
		addPatchouliEntry("drop.soulfire.info", "They can drop $(item)Soul Fire$() on death. These are an excellent source of fuel and burn for 580 seconds. Can also be used like $(item)Flint and Steel$() to start fires.");
		addPatchouliEntry("drop.stone_coal.info", "They can drop $(item)Stone Coal$() on death. This can be used in a furnace as a moderate source of fuel.");
		addPatchouliEntry("drop.taproot.info", "They can drop $(item)Tap Root$() on death. These are an insignificant source of food, but remove negative status effects when consumed.");
		addPatchouliEntry("drop.totem_of_undying_fragment.info", "They can drop $(item)Totem Fragments$() on death, which can be combined to make $(item)Totem of Undying$().");
		addPatchouliEntry("drop.weapon_book.info", "They can rarely drop a $(item)Book$() which is a weaponized book.");
		addPatchouliEntry("drop.weapon_book_battle.info", "They can rarely drop a $(item)Book Of Combat$() which inflicts $(thing)Weakness$() on foes upon a melee strike.");
		addPatchouliEntry("drop.weapon_book_buff.info", "They can rarely drop a $(item)Combat Manual$() which is a magical item that can be used to grant a player $(thing)Strength$() and $(thing)Resistance$() potion effects for one minute and a short-duration $(thing)Regeneration$() effect.");
		addPatchouliEntry("drop.weapon_book_ender.info", "They can rarely drop an $(item)Ender Book$() which when right-clicked shoots an $(thing)Ender Pearl$().");
		addPatchouliEntry("drop.weapon_book_hunger.info", "They can rarely drop a $(item)Book Of Hunger$() which inflicts $(thing)Hunger$() on foes upon a melee strike.");
		addPatchouliEntry("drop.weapon_book_metal.info", "They can rarely drop a $(item)Metal Book$() which inflicts $(thing)Nausea$() on foes upon a melee strike.");
		addPatchouliEntry("drop.weapon_book_nature.info", "They can rarely drop a $(item)Book of Nature$() which is a magical ranged weapon that fires projectiles which inflict $(thing)Poison$() on hit.");
		addPatchouliEntry("drop.weapon_book_nightmare.info", "They can rarely drop a $(item)Nightmare Book$() which inflicts $(thing)Mining Fatigue$() on foes upon a melee strike.");
		addPatchouliEntry("drop.zombie_head.info", "They can drop a $(item)Zombie Skull$() on death.");
		addPatchouliEntry("drop.withered_brain.info", "They can drop $(item)Withered Brain$() on death, which can be eaten as a decent food source. However, when consumed, it afflicts players with $(thing)Wither$().");

	}

	public void addSubtitle(RegistryObject<SoundEvent> sound, String name) {
		this.addSubtitle(sound.get(), name);
	}

	public void addSubtitle(SoundEvent sound, String name) {
		String path = GrimoireOfGaia.MOD_ID + ".subtitle." + sound.getLocation().getPath();
		this.add(path, name);
	}

	private void addMobTranslation(MobLangHelper mobHelper) {
		MobReg<?> reg = mobHelper.getMobReg();
		String name = mobHelper.getName();

		add(reg.getEntityType(), name);
		addItem(reg.getSpawnEgg(), name + " Spawn Egg");

		if (reg.getSay() != null)
			addSubtitle(reg.getSay(), name + mobHelper.getSay());
		if (reg.getHurt() != null)
			addSubtitle(reg.getHurt(), name + mobHelper.getHurt());
		if (reg.getDeath() != null)
			addSubtitle(reg.getDeath(), name + mobHelper.getDeath());
		if (reg.getStep() != null)
			addSubtitle(reg.getStep(), name + mobHelper.getStep());
		if (reg.getAttack() != null)
			addSubtitle(reg.getAttack(), name + mobHelper.getAttack());

		if (reg.hasGender()) {
			if (reg.getMaleSay() != null)
				addSubtitle(reg.getMaleSay(), name + mobHelper.getSay());
			if (reg.getMaleHurt() != null)
				addSubtitle(reg.getMaleHurt(), name + mobHelper.getHurt());
			if (reg.getMaleDeath() != null)
				addSubtitle(reg.getMaleDeath(), name + mobHelper.getDeath());
			if (reg.getMaleStep() != null)
				addSubtitle(reg.getMaleStep(), name + mobHelper.getStep());
			if (reg.getMaleAttack() != null)
				addSubtitle(reg.getMaleAttack(), name + mobHelper.getAttack());
		}
	}

	private void addKillAdvancement(MobReg<?> reg, String name, String description) {
		String mobName = reg.getName();
		addAdvancement(mobName, name, description);
	}

	private void addAdvancement(String id, String name, String description) {
		String prefix = "advancement.grimoireofgaia.";
		add(prefix + id + ".title", name);
		add(prefix + id + ".desc", description);
	}

	private void addPropReg(PropReg<?> reg, String name) {
		add(reg.getEntityType(), name);
		addItem(reg.getSpawnEgg(), name + " Spawn Egg");
	}

	private void addPatchouliEntry(String entry, String translation) {
		add("info.grimoireofgaia.book." + entry, translation);
	}
}
