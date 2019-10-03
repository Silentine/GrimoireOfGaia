package gaia.init;

import com.google.common.base.Preconditions;
import gaia.Gaia;
import gaia.GaiaReference;
import gaia.item.GaiaTier;
import gaia.item.ItemAccessoryCursed;
import gaia.item.ItemAccessoryHeadgear;
import gaia.item.ItemAccessoryRingHaste;
import gaia.item.ItemAccessoryRingJump;
import gaia.item.ItemAccessoryRingNight;
import gaia.item.ItemAccessoryRingSpeed;
import gaia.item.ItemAccessoryTrinketLevitation;
import gaia.item.ItemAccessoryTrinketPoison;
import gaia.item.ItemAccessoryTrinketWither;
import gaia.item.ItemGaiaSpawnEgg;
import gaia.item.ItemMiscBook;
import gaia.item.ItemMiscCurrency;
import gaia.item.ItemMiscExperience;
import gaia.item.ItemMiscFurnaceFuel;
import gaia.item.ItemMiscGigaGear;
import gaia.item.ItemMiscRing;
import gaia.item.ItemMiscSoulFiery;
import gaia.item.ItemMiscSoulFire;
import gaia.item.ItemPickupHeart;
import gaia.item.ItemShard;
import gaia.item.ItemShardMisc;
import gaia.item.ItemShieldProp;
import gaia.item.food.ItemFoodBase;
import gaia.item.food.ItemFoodCoalfish;
import gaia.item.food.ItemFoodHoney;
import gaia.item.food.ItemFoodMandrake;
import gaia.item.food.ItemFoodMonsterFeed;
import gaia.item.food.ItemFoodMonsterFeedPremium;
import gaia.item.food.ItemFoodNetherWart;
import gaia.item.food.ItemFoodPieAppleGold;
import gaia.item.food.ItemFoodPieMandrake;
import gaia.item.food.ItemFoodPieMeat;
import gaia.item.food.ItemFoodRoot;
import gaia.item.food.ItemFoodRottenHeart;
import gaia.item.food.ItemFoodSmallAppleGold;
import gaia.item.food.ItemFoodWither;
import gaia.item.loot.ItemBagArrow;
import gaia.item.loot.ItemBagBook;
import gaia.item.loot.ItemBagRecord;
import gaia.item.loot.ItemBoxDiamond;
import gaia.item.loot.ItemBoxEnd;
import gaia.item.loot.ItemBoxGold;
import gaia.item.loot.ItemBoxHat;
import gaia.item.loot.ItemBoxIron;
import gaia.item.loot.ItemBoxNether;
import gaia.item.loot.ItemBoxOld;
import gaia.item.loot.ItemBoxOverworld;
import gaia.item.loot.ItemChestDesert;
import gaia.item.loot.ItemChestDungeon;
import gaia.item.loot.ItemChestJungle;
import gaia.item.loot.ItemSpawn;
import gaia.item.weapons.ItemWeaponBook;
import gaia.item.weapons.ItemWeaponBookBattle;
import gaia.item.weapons.ItemWeaponBookBuff;
import gaia.item.weapons.ItemWeaponBookEnder;
import gaia.item.weapons.ItemWeaponBookFreezing;
import gaia.item.weapons.ItemWeaponBookHunger;
import gaia.item.weapons.ItemWeaponBookMetal;
import gaia.item.weapons.ItemWeaponBookNature;
import gaia.item.weapons.ItemWeaponBookNightmare;
import gaia.item.weapons.ItemWeaponBookWither;
import gaia.item.weapons.ItemWeaponFan;
import gaia.item.weapons.ItemWeaponFanFire;
import gaia.item.weapons.ItemWeaponFanIce;
import gaia.item.weapons.ItemWeaponProjectileBomb;
import gaia.item.weapons.prop.ItemWeaponProp;
import gaia.item.weapons.prop.ItemWeaponPropEnchanted;
import gaia.item.weapons.prop.ItemWeaponPropItemSword;
import gaia.item.weapons.prop.ItemWeaponPropProjectile;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GaiaReference.MOD_ID)
public class GaiaItems {
    // A
    public static Item ACCESSORY_CURSED;
    public static Item ACCESSORY_HEADGEAR_MOB;
    public static Item ACCESSORY_HEADGEAR_BOLT;
    public static Item ACCESSORY_HEADGEAR_ARROW;
    public static Item ACCESSORY_HEADGEAR_DOLL;
    public static Item ACCESSORY_HEADGEAR_EARS_ELF;
    public static Item ACCESSORY_RING_HASTE;
    public static Item ACCESSORY_RING_JUMP;
    public static Item ACCESSORY_RING_NIGHT;
    public static Item ACCESSORY_RING_SPEED;
    public static Item ACCESSORY_TRINKET_LEVITATION;
    public static Item ACCESSORY_TRINKET_POISON;
    public static Item ACCESSORY_TRINKET_WITHER;
    // B
    public static Item BOX_ORE;
    public static Item BOX_NETHER;
    public static Item BOX_END;
    public static Item BAG_ARROW;
    public static Item BAG_BOOK;
    public static Item BAG_RECORD;
    public static Item BOX_DIAMOND;
    public static Item BOX_HAT;
    public static Item BOX_GOLD;
    public static Item BOX_IRON;
    public static Item BOX_OLD;
    public static Item BOOK_BUFF;

    // C
    public static Item CHEST_DUNGEON;
    public static Item CHEST_JUNGLE;
    public static Item CHEST_TEMPLE;
    // D
    public static Item DEBUG_ITEM;
    public static Item DEBUG_WEAPON;
    // F
    public static Item FOOD_COALFISH;
    public static Item FOOD_HONEY;
    public static Item FOOD_MANDRAKE;
    public static Item FOOD_MEAT;
    public static Item FOOD_MONSTER_FEED;
    public static Item FOOD_MONSTER_FEED_PREMIUM;
    public static Item FOOD_NETHER_WART;
    public static Item FOOD_PIE_APPLE_GOLD;
    public static Item FOOD_PIE_MANDRAKE;
    public static Item FOOD_PIE_MEAT;
    public static Item FOOD_ROOT;
    public static Item FOOD_ROTTEN_HEART;
    public static Item FOOD_SMALL_APPLE_GOLD;
    public static Item FOOD_WITHER;
    // M
    public static Item MISC_BOOK;
    public static Item MISC_CURRENCY_SELL;
    public static Item MISC_CURRENCY_TRADER;
    public static Item MISC_CURRENCY_HOLSTAURUS;
    public static Item MISC_CURRENCY_WERESHEEP;
    public static Item MISC_EXPERIENCE_IRON;
    public static Item MISC_EXPERIENCE_GOLD;
    public static Item MISC_EXPERIENCE_DIAMOND;
    public static Item MISC_FUR;
    public static Item MISC_FURNACE_FUEL;
    public static Item MISC_GIGA_GEAR;
    public static Item MISC_QUILL;
    public static Item MISC_RING_SPEED;
    public static Item MISC_RING_HASTE;
    public static Item MISC_RING_JUMP;
    public static Item MISC_RING_NIGHT;
    public static Item MISC_SOUL_FIRE;
    public static Item MISC_SOUL_FIERY;

    // P
    public static Item PICKUP_HEART;

    // S
    public static Item SHARD_IRON;
    public static Item SHARD_GOLD;
    public static Item SHARD_DIAMOND;
    public static Item SHARD_EMERALD;
    public static Item SHARD_COPPER;
    public static Item SHARD_SILVER;
    public static Item SHARD_MISC;
    public static Item SHIELD_PROP_STONE;
    public static Item SHIELD_PROP_IRON;
    public static Item SHIELD_PROP_GOLD;
    public static Item SPAWN;
    public static Item SPAWN_WERESHEEP;
    public static Item SPAWN_CREEPER_GIRL;
    public static Item SPAWN_ENDER_GIRL;
    public static Item SPAWN_HOLSTAURUS;
    public static Item SPAWN_SLIME_GIRL;
    public static Item SPAWN_TAME;
    public static Item SPAWN_TRADER;

    // Spawn eggs
    public static Item ANT_SPAWN_EGG;
    public static Item ANT_RANGER_SPAWN_EGG;
    public static Item ANUBIS_SPAWN_EGG;
    public static Item ARACHNE_SPAWN_EGG;
    public static Item BANSHEE_SPAWN_EGG;
    public static Item BAPHOMET_SPAWN_EGG;
    public static Item BEE_SPAWN_EGG;
    public static Item BONE_KNIGHT_SPAWN_EGG;
    public static Item CAMPFIRE_SPAWN_EGG;
    public static Item CECEALIA_SPAWN_EGG;
    public static Item CENTAUR_SPAWN_EGG;
    public static Item CHEST_SPAWN_EGG;
    public static Item COBBLE_GOLEM_SPAWN_EGG;
    public static Item COBBLESTONE_GOLEM_SPAWN_EGG;
    public static Item CREEP_SPAWN_EGG;
    public static Item CYCLOPS_SPAWN_EGG;
    public static Item CYAN_FLOWER_SPAWN_EGG;
    public static Item DEATHWORD_SPAWN_EGG;
    public static Item DHAMPIR_SPAWN_EGG;
    public static Item DRYAD_SPAWN_EGG;
    public static Item DULLAHAN_SPAWN_EGG;
    public static Item DWARF_SPAWN_EGG;
    public static Item ENDER_DRAGON_GIRL_SPAWN_EGG;
    public static Item ENDER_EYE_SPAWN_EGG;
    public static Item FLESH_LICH_SPAWN_EGG;
    public static Item GELATINOUS_SLIME_SPAWN_EGG;
    public static Item GOBLIN_SPAWN_EGG;
    public static Item GOBLIN_FERAL_SPAWN_EGG;
    public static Item GRYPHON_SPAWN_EGG;
    public static Item HARPY_SPAWN_EGG;
    public static Item HUNTER_SPAWN_EGG;
    public static Item KIKIMORA_SPAWN_EGG;
    public static Item KOBOLD_SPAWN_EGG;
    public static Item MATANGO_SPAWN_EGG;
    public static Item MERMAID_SPAWN_EGG;
    public static Item MINOTAUR_SPAWN_EGG;
    public static Item MINOTAURUS_SPAWN_EGG;
    public static Item MUMMY_SPAWN_EGG;
    public static Item NAGA_SPAWN_EGG;
    public static Item NINE_TAILS_SPAWN_EGG;
    public static Item ONI_SPAWN_EGG;
    public static Item ORC_SPAWN_EGG;
    public static Item SATYRESS_SPAWN_EGG;
    public static Item SELKIE_SPAWN_EGG;
    public static Item SHAMAN_SPAWN_EGG;
    public static Item SHARKO_SPAWN_EGG;
    public static Item SIREN_SPAWN_EGG;
    public static Item SLUDGE_GIRL_SPAWN_EGG;
    public static Item SPHINX_SPAWN_EGG;
    public static Item SPRIGGAN_SPAWN_EGG;
    public static Item SUCCUBUS_SPAWN_EGG;
    public static Item TOAD_SPAWN_EGG;
    public static Item VALKYRIE_SPAWN_EGG;
    public static Item VASE_SPAWN_EGG;
    public static Item VASE_NETHER_SPAWN_EGG;
    public static Item VAMPIRE_SPAWN_EGG;
    public static Item WERECAT_SPAWN_EGG;
    public static Item WITCH_SPAWN_EGG;
    public static Item WITHER_COW_SPAWN_EGG;
    public static Item YETI_SPAWN_EGG;
    public static Item YUKI_ONNA_SPAWN_EGG;

    // W
    public static Item WEAPON_BOOK;
    public static Item WEAPON_BOOK_BATTLE;
    public static Item WEAPON_BOOK_ENDER;
    public static Item WEAPON_BOOK_FREEZING;
    public static Item WEAPON_BOOK_HUNGER;
    public static Item WEAPON_BOOK_METAL;
    public static Item WEAPON_BOOK_NATURE;
    public static Item WEAPON_BOOK_NIGHTMARE;
    public static Item WEAPON_BOOK_WITHER;
    public static Item WEAPON_FAN;
    public static Item WEAPON_FAN_FIRE;
    public static Item WEAPON_FAN_ICE;
    public static Item WEAPON_PROJECTILE_BOMB;
    public static Item WEAPON_PROP_ENDER;
    public static Item WEAPON_PROP_BLAZE;
    public static Item WEAPON_PROP_CLUB;
    public static Item WEAPON_PROP_ENCHANTED;
    public static Item WEAPON_PROP_PROJECTILE_BUBBLE;
    public static Item WEAPON_PROP_PROJECTILE_MAGIC;
    public static Item WEAPON_PROP_PROJECTILE_POISON;
    public static Item WEAPON_PROP_PROJECTILE_WEB;
    public static Item WEAPON_PROP_SWORD_WOOD;
    public static Item WEAPON_PROP_SWORD_STONE;
    public static Item WEAPON_PROP_SWORD_IRON;
    public static Item WEAPON_PROP_SWORD_GOLD;
    public static Item WEAPON_PROP_AXE_WOOD;
    public static Item WEAPON_PROP_AXE_STONE;
    public static Item WEAPON_PROP_AXE_IRON;
    public static Item WEAPON_PROP_AXE_GOLD;
    public static Item WEAPON_PROP_DAGGER_METAL;
    public static Item WEAPON_PROP_BROOM;
    public static Item WEAPON_PROP_HAMMER_MINOTAUR;

    public static ArrayList<Item> ITEMS = new ArrayList<>();

    private GaiaItems() {
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        Gaia.LOGGER.info("Registering items...");

        final IForgeRegistry<Item> registry = event.getRegistry();

//        DEBUG_ITEM = registerItem(new ItemDebugItem(itemBuilder()), "item_debug"); //Disable before release
//        DEBUG_WEAPON = registerItem(new ItemDebugWeapon(itemBuilder()), "weapon_debug"); //Disable before release

        ACCESSORY_CURSED = registerItem(new ItemAccessoryCursed(itemBuilder()), "accessory_cursed");
        ACCESSORY_HEADGEAR_MOB = registerItem(new ItemAccessoryHeadgear(itemBuilder()), "accessory_headgear_mob");
        ACCESSORY_HEADGEAR_BOLT = registerItem(new ItemAccessoryHeadgear(itemBuilder()), "accessory_headgear_bolt");
        ACCESSORY_HEADGEAR_ARROW = registerItem(new ItemAccessoryHeadgear(itemBuilder()), "accessory_headgear_arrow");
        ACCESSORY_HEADGEAR_DOLL = registerItem(new ItemAccessoryHeadgear(itemBuilder()), "accessory_headgear_doll");
        ACCESSORY_HEADGEAR_EARS_ELF = registerItem(new ItemAccessoryHeadgear(itemBuilder()), "accessory_headgear_ears_elf");
        ACCESSORY_RING_HASTE = registerItem(new ItemAccessoryRingHaste(itemBuilder()), "accessory_ring_haste");
        ACCESSORY_RING_JUMP = registerItem(new ItemAccessoryRingJump(itemBuilder()), "accessory_ring_jump");
        ACCESSORY_RING_NIGHT = registerItem(new ItemAccessoryRingNight(itemBuilder()), "accessory_ring_night");
        ACCESSORY_RING_SPEED = registerItem(new ItemAccessoryRingSpeed(itemBuilder()), "accessory_ring_speed");
        ACCESSORY_TRINKET_LEVITATION = registerItem(new ItemAccessoryTrinketLevitation(itemBuilder()), "accessory_trinket_levitation");
        ACCESSORY_TRINKET_POISON = registerItem(new ItemAccessoryTrinketPoison(itemBuilder()), "accessory_trinket_poison");
        ACCESSORY_TRINKET_WITHER = registerItem(new ItemAccessoryTrinketWither(itemBuilder()), "accessory_trinket_wither");
        BOX_ORE = registerItem(new ItemBoxOverworld(itemBuilder()), "box_overworld");
        BOX_NETHER = registerItem(new ItemBoxNether(itemBuilder()), "box_nether");
        BOX_END = registerItem(new ItemBoxEnd(itemBuilder()), "box_end");
        BOX_IRON = registerItem(new ItemBoxIron(itemBuilder()), "box_iron");
        BOX_GOLD = registerItem(new ItemBoxGold(itemBuilder()), "box_gold");
        BOX_DIAMOND = registerItem(new ItemBoxDiamond(itemBuilder()), "box_diamond");
        BOX_HAT = registerItem(new ItemBoxHat(itemBuilder()), "box_hat");
        BOX_OLD = registerItem(new ItemBoxOld(itemBuilder()), "box_old");
        BOOK_BUFF = registerItem(new ItemWeaponBookBuff(itemBuilder()), "weapon_book_buff");
        BAG_ARROW = registerItem(new ItemBagArrow(itemBuilder()), "bag_arrow");
        BAG_BOOK = registerItem(new ItemBagBook(itemBuilder()), "bag_book");
        BAG_RECORD = registerItem(new ItemBagRecord(itemBuilder()), "bag_record");
        CHEST_DUNGEON = registerItem(new ItemChestDungeon(itemBuilder()), "chest_dungeon");
        CHEST_JUNGLE = registerItem(new ItemChestJungle(itemBuilder()), "chest_jungle");
        CHEST_TEMPLE = registerItem(new ItemChestDesert(itemBuilder()), "chest_desert");
        FOOD_COALFISH = registerItem(new ItemFoodCoalfish(itemBuilder()), "food_coalfish");
        FOOD_HONEY = registerItem(new ItemFoodHoney(itemBuilder()), "food_honey");
        FOOD_MANDRAKE = registerItem(new ItemFoodMandrake(itemBuilder()), "food_mandrake");
        FOOD_MEAT = registerItem(new ItemFoodBase(itemBuilder().food(GaiaFoods.MEAT)), "food_meat");
        FOOD_MONSTER_FEED = registerItem(new ItemFoodMonsterFeed(itemBuilder()), "food_monster_feed");
        FOOD_MONSTER_FEED_PREMIUM = registerItem(new ItemFoodMonsterFeedPremium(itemBuilder()), "food_monster_feed_premium");
        FOOD_NETHER_WART = registerItem(new ItemFoodNetherWart(itemBuilder()), "food_nether_wart");
        FOOD_PIE_APPLE_GOLD = registerItem(new ItemFoodPieAppleGold(itemBuilder()), "food_pie_apple_gold");
        FOOD_PIE_MANDRAKE = registerItem(new ItemFoodPieMandrake(itemBuilder()), "food_pie_mandrake");
        FOOD_PIE_MEAT = registerItem(new ItemFoodPieMeat(itemBuilder()), "food_pie_meat");
        FOOD_ROOT = registerItem(new ItemFoodRoot(itemBuilder()), "food_root");
        FOOD_ROTTEN_HEART = registerItem(new ItemFoodRottenHeart(itemBuilder()), "food_rotten_heart");
        FOOD_SMALL_APPLE_GOLD = registerItem(new ItemFoodSmallAppleGold(itemBuilder()), "food_small_apple_gold");
        FOOD_WITHER = registerItem(new ItemFoodWither(itemBuilder()), "food_wither");
        MISC_BOOK = registerItem(new ItemMiscBook(itemBuilder()), "misc_book");
        MISC_CURRENCY_SELL = registerItem(new ItemMiscCurrency(itemBuilder()), "misc_currency_sell");
        MISC_CURRENCY_TRADER = registerItem(new ItemMiscCurrency(itemBuilder()), "misc_currency_trader");
        MISC_CURRENCY_HOLSTAURUS = registerItem(new ItemMiscCurrency(itemBuilder()), "misc_currency_holstaurus");
        MISC_CURRENCY_WERESHEEP = registerItem(new ItemMiscCurrency(itemBuilder()), "misc_currency_weresheep");
        MISC_EXPERIENCE_IRON = registerItem(new ItemMiscExperience(itemBuilder()), "misc_experience_small");
        MISC_EXPERIENCE_GOLD = registerItem(new ItemMiscExperience(itemBuilder()), "misc_experience_medium");
        MISC_EXPERIENCE_DIAMOND = registerItem(new ItemMiscExperience(itemBuilder()), "misc_experience_large");
        MISC_FUR = registerItem(new Item(itemBuilder()), "misc_fur");
        MISC_FURNACE_FUEL = registerItem(new ItemMiscFurnaceFuel(itemBuilder()), "misc_furnace_fuel");
        MISC_GIGA_GEAR = registerItem(new ItemMiscGigaGear(itemBuilder()), "misc_giga_gear");
        MISC_QUILL = registerItem(new Item(itemBuilder()), "misc_quill");
        MISC_RING_SPEED = registerItem(new ItemMiscRing(itemBuilder()), "misc_ring_speed");
        MISC_RING_HASTE = registerItem(new ItemMiscRing(itemBuilder()), "misc_ring_haste");
        MISC_RING_JUMP = registerItem(new ItemMiscRing(itemBuilder()), "misc_ring_jump");
        MISC_RING_NIGHT = registerItem(new ItemMiscRing(itemBuilder()), "misc_ring_night");
        MISC_SOUL_FIRE = registerItem(new ItemMiscSoulFire(itemBuilder()), "misc_soul_fire");
        MISC_SOUL_FIERY = registerItem(new ItemMiscSoulFiery(itemBuilder()), "misc_soul_fiery");
        PICKUP_HEART = registerItem(new ItemPickupHeart(itemBuilder()), "pickup_heart");
        SHARD_IRON = registerItem(new ItemShard(itemBuilder()), "shard_iron");
        SHARD_GOLD = registerItem(new ItemShard(itemBuilder()), "shard_gold");
        SHARD_DIAMOND = registerItem(new ItemShard(itemBuilder()), "shard_diamond");
        SHARD_EMERALD = registerItem(new ItemShard(itemBuilder()), "shard_emerald");
        SHARD_COPPER = registerItem(new ItemShard(itemBuilder()), "shard_copper");
        SHARD_SILVER = registerItem(new ItemShard(itemBuilder()), "shard_silver");
        SHARD_MISC = registerItem(new ItemShardMisc(itemBuilder()), "shard_misc_totem");
        SHIELD_PROP_STONE = registerItem(new ItemShieldProp(itemBuilder()), "shield_prop_stone");
        SHIELD_PROP_IRON = registerItem(new ItemShieldProp(itemBuilder()), "shield_prop_iron");
        SHIELD_PROP_GOLD = registerItem(new ItemShieldProp(itemBuilder()), "shield_prop_gold");
        SPAWN = registerItem(new ItemSpawn(itemBuilder()), "spawn");
//        SPAWN_WERESHEEP = registerItem(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.WERESHEEP_NPC), "spawn_weresheep");
//        SPAWN_CREEPER_GIRL = registerItem(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.CREEPER_GIRL_NPC), "spawn_creeper_girl");
//        SPAWN_ENDER_GIRL = registerItem(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.ENDER_GIRL_NPC), "spawn_ender_girl");
//        SPAWN_HOLSTAURUS = registerItem(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.HOLSTAURUS_NPC), "spawn_holstaurus");
//        SPAWN_SLIME_GIRL = registerItem(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.SLUDGE_GIRL_NPC), "spawn_slime_girl");
//        SPAWN_TRADER = registerItem(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.TRADER_NPC), "spawn_trader");
        WEAPON_BOOK = registerItem(new ItemWeaponBook(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book");
        WEAPON_BOOK_BATTLE = registerItem(new ItemWeaponBookBattle(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book_battle");
        WEAPON_BOOK_ENDER = registerItem(new ItemWeaponBookEnder(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book_ender");
        WEAPON_BOOK_FREEZING = registerItem(new ItemWeaponBookFreezing(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book_freezing");
        WEAPON_BOOK_HUNGER = registerItem(new ItemWeaponBookHunger(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book_hunger");
        WEAPON_BOOK_METAL = registerItem(new ItemWeaponBookMetal(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book_metal");
        WEAPON_BOOK_NATURE = registerItem(new ItemWeaponBookNature(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book_nature");
        WEAPON_BOOK_NIGHTMARE = registerItem(new ItemWeaponBookNightmare(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book_nightmare");
        WEAPON_BOOK_WITHER = registerItem(new ItemWeaponBookWither(GaiaTier.BOOK, 3, -2.4F, itemBuilder()), "weapon_book_wither");
        WEAPON_FAN = registerItem(new ItemWeaponFan(itemBuilder()), "weapon_fan");
        WEAPON_FAN_FIRE = registerItem(new ItemWeaponFanFire(itemBuilder()), "weapon_fan_fire");
        WEAPON_FAN_ICE = registerItem(new ItemWeaponFanIce(itemBuilder()), "weapon_fan_ice");
        WEAPON_PROJECTILE_BOMB = registerItem(new ItemWeaponProjectileBomb(itemBuilder()), "weapon_projectile_bomb");
        WEAPON_PROP_ENDER = registerItem(new ItemWeaponProp(itemBuilder()), "weapon_prop_ender");
        WEAPON_PROP_BLAZE = registerItem(new ItemWeaponProp(itemBuilder()), "weapon_prop_blaze");
        WEAPON_PROP_CLUB = registerItem(new ItemWeaponProp(itemBuilder()), "weapon_prop_metal");
        WEAPON_PROP_ENCHANTED = registerItem(new ItemWeaponPropEnchanted(itemBuilder()), "weapon_prop_enchanted");
        WEAPON_PROP_PROJECTILE_BUBBLE = registerItem(new ItemWeaponPropProjectile(itemBuilder()), "weapon_prop_projectile_bubble");
        WEAPON_PROP_PROJECTILE_MAGIC = registerItem(new ItemWeaponPropProjectile(itemBuilder()), "weapon_prop_projectile_magic");
        WEAPON_PROP_PROJECTILE_POISON = registerItem(new ItemWeaponPropProjectile(itemBuilder()), "weapon_prop_projectile_poison");
        WEAPON_PROP_PROJECTILE_WEB = registerItem(new ItemWeaponPropProjectile(itemBuilder()), "weapon_prop_projectile_web");
        WEAPON_PROP_SWORD_WOOD = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_sword_wood");
        WEAPON_PROP_SWORD_STONE = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_sword_stone");
        WEAPON_PROP_SWORD_IRON = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_sword_iron");
        WEAPON_PROP_SWORD_GOLD = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_sword_gold");
        WEAPON_PROP_AXE_WOOD = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_axe_wood");
        WEAPON_PROP_AXE_STONE = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_axe_stone");
        WEAPON_PROP_AXE_IRON = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_axe_iron");
        WEAPON_PROP_AXE_GOLD = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_axe_gold");
        WEAPON_PROP_DAGGER_METAL = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_dagger_metal");
        WEAPON_PROP_BROOM = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_broom");
        WEAPON_PROP_HAMMER_MINOTAUR = registerItem(new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()), "weapon_prop_hammer_minotaur");

        //Prop Spawn Eggs
        CAMPFIRE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.CAMPFIRE, 0x7a5f3a, 0xffd800, itemBuilder()), "campfire_spawn_egg");
        CYAN_FLOWER_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.CYAN_FLOWER, 1073920, 4045287, itemBuilder()), "cyan_flower_spawn_egg");
        CHEST_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.CHEST, 11237677, 4274991, itemBuilder()), "chest_spawn_egg");
        VASE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.VASE, 0x949494, 0x545454, itemBuilder()), "vase_spawn_egg");
        VASE_NETHER_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.VASE_NETHER, 0x462129, 0x1b080c, itemBuilder()), "vase_nether_spawn_egg");

        //Hostile Spawn Eggs
        ANT_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.ANT, 0x303030, 0x8a7264, itemBuilder()), "ant_spawn_egg");
        ANT_RANGER_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.ANT_RANGER, 0x8a7264, 0x303030, itemBuilder()), "ant_ranger_spawn_egg");
        ANUBIS_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.ANUBIS, 0x353535, 0xb19534, itemBuilder()), "anubis_spawn_egg");

        //NPC Spawn Eggs
//        DEBUG_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.DEBUG_MOB, 0x6fa289, 0x915741, itemBuilder()), "debug_mob_spawn_egg");

        ARACHNE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.ARACHNE, 3815994, 11013646, itemBuilder()), "arachne_spawn_egg");
        BANSHEE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.BANSHEE, 0xeed2e8, 0xc6b0ed, itemBuilder()), "banshee_spawn_egg");
        BAPHOMET_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.BAPHOMET, 3559756, 14197864, itemBuilder()), "baphomet_spawn_egg");
        BEE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.BEE, 0x353535, 0x353535, itemBuilder()), "bee_spawn_egg");
        BONE_KNIGHT_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.BONE_KNIGHT, 4602533, 13619151, itemBuilder()), "bone_knight_spawn_egg");
        CECEALIA_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.CECEALIA, 0xdb5760, 0xd893a9, itemBuilder()), "cecaelia_spawn_egg");
        CENTAUR_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.CENTAUR, 0x8d4f41, 0x353535, itemBuilder()), "centaur_spawn_egg");
        COBBLE_GOLEM_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.COBBLE_GOLEM, 11513775, 11513775, itemBuilder()), "cobble_golem_spawn_egg");
        COBBLESTONE_GOLEM_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.COBBLESTONE_GOLEM, 11513775, 11513775, itemBuilder()), "cobblestone_golem_spawn_egg");
        CREEP_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.CREEP, 7917159, 2053400, itemBuilder()), "creep_spawn_egg");
        CYCLOPS_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.CYCLOPS, 4936602, 3487029, itemBuilder()), "cyclops_spawn_egg");
        DEATHWORD_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.DEATHWORD, 0xb77a35, 0xffd800, itemBuilder()), "deathword_spawn_egg");
        DHAMPIR_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.DHAMPIR, 0x9c1c2b, 0xc9b161, itemBuilder()), "dhampir_spawn_egg");
        DRYAD_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.DRYAD, 10255437, 5681460, itemBuilder()), "dryad_spawn_egg");
        DULLAHAN_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.DULLAHAN, 0x824fab, 0xa4452d, itemBuilder()), "dullahan_spawn_egg");
        DWARF_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.DWARF, 0x969696, 0xf09942, itemBuilder()), "dwarf_spawn_egg");
//        ENDER_DRAGON_GIRL_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.ENDER_DRAGON_GIRL, 3158064, 14711290, itemBuilder()), "ender_dragon_girl_spawn_egg");
//        ENDER_EYE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.ENDER_EYE, 2039583, 0x3158064, itemBuilder()), "ender_eye_spawn_egg");
//        FLESH_LICH_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.FLESH_LICH, 0x00cccc, 0x799c65, itemBuilder()), "flesh_lich_spawn_egg");
//        GELATINOUS_SLIME_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.GELATINOUS_SLIME, 6595667, 13619151, itemBuilder()), "gelatinous_slime_spawn_egg");
//        GOBLIN_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.GOBLIN, 0x718a60, 0x8d4f41, itemBuilder()), "goblin_spawn_egg");
//        GOBLIN_FERAL_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.GOBLIN_FERAL, 0x718a60, 0x8a1d3e, itemBuilder()), "goblin_feral_spawn_egg");
//        GRYPHON_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.GRYPHON, 0xf09942, 0xe2e2e2, itemBuilder()), "gryphon_spawn_egg");
//        HARPY_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.HARPY, 0xc9b161, 0xa5884e, itemBuilder()), "harpy_spawn_egg");
//        HUNTER_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.HUNTER, 0xae6b3c, 0x353535, itemBuilder()), "hunter_spawn_egg");
//        KIKIMORA_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.KIKIMORA, 0x191919, 0xd3bdac, itemBuilder()), "kikimora_spawn_egg");
//        KOBOLD_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.KOBOLD, 0x938dab, 0xafa7c1, itemBuilder()), "kobold_spawn_egg");
//        MATANGO_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.MATANGO, 0xab1311, 0xd8d8d8, itemBuilder()), "matango_spawn_egg");
//        MERMAID_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.MERMAID, 0x5c70b1, 0xa4452d, itemBuilder()), "mermaid_spawn_egg");
//        MINOTAUR_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.MINOTAUR, 0x8d4f41, 0xd54242, itemBuilder()), "minotaur_spawn_egg");
//        MINOTAURUS_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.MINOTAURUS, 0x8d4f41, 0xa9a9a9, itemBuilder()), "minotaurus_spawn_egg");
//        MUMMY_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.MUMMY, 0xdcd7c1, 0xc9b161, itemBuilder()), "mummy_spawn_egg");
//        NAGA_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.NAGA, 0x29bc55, 0xccb63f, itemBuilder()), "naga_spawn_egg");
//        NINE_TAILS_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.NINE_TAILS, 11809844, 13218145, itemBuilder()), "nine_tails_spawn_egg");
//        ONI_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.ONI, 0x8b302d, 0xc9b161, itemBuilder()), "oni_spawn_egg");
//        ORC_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.ORC, 0x718a60, 0xc0d696, itemBuilder()), "orc_spawn_egg");
//        SATYRESS_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SATYRESS, 0x707b4f, 0xa4452d, itemBuilder()), "satyress_spawn_egg");
//        SELKIE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SELKIE, 9082818, 13488612, itemBuilder()), "selkie_spawn_egg");
//        SHAMAN_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SHAMAN, 0xae6b3c, 0x56b134, itemBuilder()), "shaman_spawn_egg");
//        SHARKO_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SHARKO, 0x84a498, 0x5c70b1, itemBuilder()), "sharko_spawn_egg");
//        SIREN_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SIREN, 0x29bc55, 0x48a0de, itemBuilder()), "siren_spawn_egg");
//        SLUDGE_GIRL_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SLUDGE_GIRL, 6595667, 7715172, itemBuilder()), "sludge_girl_spawn_egg");
        SPHINX_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SPHINX, 0xf09942, 0x353535, itemBuilder()), "sphinx_spawn_egg");
//        SPRIGGAN_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SPRIGGAN, 0x7c623e, 0xc2dda5, itemBuilder()), "spriggan_spawn_egg");
//        SUCCUBUS_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.SUCCUBUS, 4079166, 13218145, itemBuilder()), "succubus_spawn_egg");
//        TOAD_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.TOAD, 0x355d2b, 0x779f5a, itemBuilder()), "toad_spawn_egg");
//        VALKYRIE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.VALKYRIE, 0xc9b161, 0xd54242, itemBuilder()), "valkyrie_spawn_egg");
//        VAMPIRE_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.VAMPIRE, 0xc23021, 0xc9b161, itemBuilder()), "vampire_spawn_egg");
//        WERECAT_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.WERECAT, 0x7a7e8a, 0xdddadb, itemBuilder()), "werecat_spawn_egg");
//        WITCH_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.WITCH, 0x303030, 0x943dbb, itemBuilder()), "witch_spawn_egg");
//        WITHER_COW_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.WITHER_COW, 5791069, 16777215, itemBuilder()), "wither_cow_spawn_egg");
//        YETI_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.YETI, 16448250, 7895160, itemBuilder()), "yeti_spawn_egg");
//        YUKI_ONNA_SPAWN_EGG = registerItem(new ItemGaiaSpawnEgg(GaiaEntities.YUKI_ONNA, 6781114, 13817330, itemBuilder()), "yuki_onna_spawn_egg");

        registry.registerAll(ITEMS.toArray(new Item[0]));
        Gaia.LOGGER.info("Item registration complete.");
    }

    public static <T extends Item> T registerItem(T item, String name)
    {
        item.setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, name));
        Preconditions.checkNotNull(item, "registryName");
        Gaia.LOGGER.debug(item + " " + name);
        ITEMS.add(item);
        return item;
    }

    private static Item.Properties itemBuilder()
    {
        return new Item.Properties().group(GaiaItemGroups.ITEMS);
    }
}
