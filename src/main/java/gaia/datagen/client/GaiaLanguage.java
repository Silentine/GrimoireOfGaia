package gaia.datagen.client;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaSounds;
import gaia.registry.helper.MobReg;
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

		addMobTranslation(GaiaRegistry.ANUBIS, "Anubis", "speaks");
		addMobTranslation(GaiaRegistry.CENTAUR, "Centaur", "speaks");
		addMobTranslation(GaiaRegistry.CREEP, "Creep", "hisses");
		addMobTranslation(GaiaRegistry.CYCLOPS, "Cyclops", "speaks");
		addMobTranslation(GaiaRegistry.DRYAD, "Dryad", "murmurs");
		addMobTranslation(GaiaRegistry.DULLAHAN, "Dullahan", "speaks");
		addMobTranslation(GaiaRegistry.HARPY, "Harpy", "shrieks");
		addMobTranslation(GaiaRegistry.HUNTER, "Hunter", "whispers");
		addMobTranslation(GaiaRegistry.KOBOLD, "Kobold", "barks");
		addMobTranslation(GaiaRegistry.MATANGO, "Matango", "speaks");
		addMobTranslation(GaiaRegistry.NINE_TAILS, "Nine Tails", "speaks");
		addMobTranslation(GaiaRegistry.SHAMAN, "Shaman", "chants");
		addMobTranslation(GaiaRegistry.SIREN, "Siren", "sings");
		addMobTranslation(GaiaRegistry.SLUDGE_GIRL, "Sludge Girl", "bubbles");
		addMobTranslation(GaiaRegistry.SPORELING, "Sporeling", "squeaks");
		addMobTranslation(GaiaRegistry.SUCCUBUS, "Succubus", "whispers");
		addMobTranslation(GaiaRegistry.WERECAT, "Werecat", "hisses");
		addMobTranslation(GaiaRegistry.YUKI_ONNA, "Yuki-Onna", "speaks");

		addMobTranslation(GaiaRegistry.HORSE, "Wild Horse", "neighs");
		addEntityType(GaiaRegistry.SMALL_FIREBALL, "Small Fire");

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
		addItem(GaiaRegistry.EXPERIENCE_IRON, "Crystallized Experience (Small)");
		addItem(GaiaRegistry.EXPERIENCE_GOLD, "Crystallized Experience (Medium)");
		addItem(GaiaRegistry.EXPERIENCE_DIAMOND, "Crystallized Experience (Large)");
		addItem(GaiaRegistry.FAN, "Hand Fan");
		addItem(GaiaRegistry.FAN_FIRE, "Ornate Fire Fan");
		addItem(GaiaRegistry.FAN_ICE, "Ornate Ice Fan");
		addItem(GaiaRegistry.FIRESHARD, "Fireshard");
		addItem(GaiaRegistry.SOULFIRE, "Soulfire");
		addItem(GaiaRegistry.FUR, "Fur");
		addItem(GaiaRegistry.GIGA_GEAR, "Heart of Giga Knight");
		addItem(GaiaRegistry.GOLDEN_APPLE_PIE, "Golden Apple Pie");
		addItem(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE, "Golden Apple Pie Slice");
		addItem(GaiaRegistry.HEADGEAR_BOOK, "Book on Face");
		addItem(GaiaRegistry.HEADGEAR_MOB, "Cage");
		addItem(GaiaRegistry.HEADGEAR_BOLT, "Bolts");
		addItem(GaiaRegistry.HEADGEAR_ARROW, "Arrow Through Head");
		addItem(GaiaRegistry.HEADGEAR_DOLL, "Drooping Maid");
		addItem(GaiaRegistry.HEADGEAR_EARS_ELF, "Elven Ears");
		addItem(GaiaRegistry.KNUCKLES, "Knuckles");
		addItem(GaiaRegistry.MEAT, "Meat");
		addItem(GaiaRegistry.QUILL, "Diamond Tipped Quill");
		addItem(GaiaRegistry.ROTTEN_HEART, "Rotten Heart");
		addItem(GaiaRegistry.METAL_DAGGER, "Metal Dagger");
		addItem(GaiaRegistry.TAPROOT, "Taproot");
		addItem(GaiaRegistry.ZOMBIE_STAFF, "Zombie Staff");

		addItem(GaiaRegistry.PROJECTILE_MAGIC, "Magic Projectile");

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
		addSubtitle(GaiaSounds.GAIA_SHOOT, "Creature shoots");

		add("text.grimoireofgaia.right_click_use", "Right-click to open");
		add("text.grimoireofgaia.hold_shift", "<Hold Shift>");
		add("text.grimoireofgaia.fuel_for_seconds", "Fuel for %d seconds");
		add("text.grimoireofgaia.gain_experience", "Gain experience");
		add("text.grimoireofgaia.gain_level", "Gain %d level");
		add("text.grimoireofgaia.gain_levels", "Gain %d levels");

		add("text.grimoireofgaia.giga_gear.desc", "All that remains of Giga Knight");
		add("text.grimoireofgaia.fireshard.desc", "Right-click to spawn Lava");
		add("text.grimoireofgaia.soulfire.desc", "Right-click to spawn Fire");
		add("text.grimoireofgaia.zombie_staff.desc", "Hold Right-click to spawn Zombie");

		add("text.grimoireofgaia.headgear.tag", "Headgear");
		add("text.grimoireofgaia.charm.tag", "Charm");
		add("text.grimoireofgaia.charm.damage", "+%d Attack Damage");

		add("text.grimoireofgaia.bless.main_hand", "When in main hand:");
		add("text.grimoireofgaia.bless.off_hand", "When in off-hand, main hand:");
	}

	public void addSubtitle(RegistryObject<SoundEvent> sound, String name) {
		this.addSubtitle(sound.get(), name);
	}

	public void addSubtitle(SoundEvent sound, String name) {
		String path = GrimoireOfGaia.MOD_ID + ".subtitle." + sound.getLocation().getPath();
		this.add(path, name);
	}

	private void addMobTranslation(MobReg<?> reg, String name, String say) {
		add(reg.getEntityType(), name);
		addItem(reg.getSpawnEgg(), name + " Spawn Egg");

		addSubtitle(reg.getSay(), name + " " + say);
		addSubtitle(reg.getHurt(), name + " hurts");
		addSubtitle(reg.getDeath(), name + " dies");

		if (reg.hasGender()) {
			addSubtitle(reg.getMaleSay(), name + " " + say);
			addSubtitle(reg.getMaleHurt(), name + " hurts");
			addSubtitle(reg.getMaleDeath(), name + " dies");
		}
	}
}
