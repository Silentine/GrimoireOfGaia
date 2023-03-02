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
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.HARPY, "Harpy").withSay("shrieks").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.HUNTER, "Hunter").withSay("whispers").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.KOBOLD, "Kobold").withSay("barks").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.MATANGO, "Matango").build());
		addMobTranslation(new MobLangHelper.Builder(GaiaRegistry.MERMAID, "Mermaid").withSay("sings").build());
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
		addItem(GaiaRegistry.HONEYDEW, "Honeydew");
		addItem(GaiaRegistry.HEADGEAR_BOOK, "Book on Face");
		addItem(GaiaRegistry.HEADGEAR_MOB, "Cage");
		addItem(GaiaRegistry.HEADGEAR_BOLT, "Bolts");
		addItem(GaiaRegistry.HEADGEAR_ARROW, "Arrow Through Head");
		addItem(GaiaRegistry.HEADGEAR_DOLL, "Drooping Maid");
		addItem(GaiaRegistry.HEADGEAR_EARS_ELF, "Elven Ears");
		addItem(GaiaRegistry.KNUCKLES, "Knuckles");
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
		add("text.grimoireofgaia.charm.damage", "+%d Attack Damage");

		add("text.grimoireofgaia.bless.main_hand", "When in main hand:");
		add("text.grimoireofgaia.bless.off_hand", "When in off-hand, main hand:");

		add("text.grimoireofgaia.monster_feed.desc", "Solely effects Grimoire of Gaia mobs");
		add("text.grimoireofgaia.food_monster_feed.desc", "Adds friendliness to Level 1 Assist mobs");
		add("text.grimoireofgaia.premium_food_monster_feed.desc", "Removes initial hostility");
		add("item.grimoireofgaia.food_monster_feed2.desc", "Does not affect damaged mobs");
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

	private void addPropReg(PropReg<?> reg, String name) {
		add(reg.getEntityType(), name);
		addItem(reg.getSpawnEgg(), name + " Spawn Egg");
	}
}
