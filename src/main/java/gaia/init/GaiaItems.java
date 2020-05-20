package gaia.init;

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
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GaiaItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, GaiaReference.MOD_ID);

    /**
     * Debug items
     */
//    public static final RegistryObject<Item> DEBUG_ITEM = ITEMS.register("item_debug", () -> new ItemDebugItem(itemBuilder())); //Disable before release
//    public static final RegistryObject<Item> DEBUG_WEAPON = ITEMS.register("weapon_debug", () -> new ItemDebugWeapon(itemBuilder())); //Disable before release

    /**
     * Items
     */
    public static final RegistryObject<Item> ACCESSORY_CURSED = ITEMS.register("accessory_cursed", () -> new ItemAccessoryCursed(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_HEADGEAR_MOB = ITEMS.register("accessory_headgear_mob", () -> new ItemAccessoryHeadgear(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_HEADGEAR_BOLT = ITEMS.register("accessory_headgear_bolt", () -> new ItemAccessoryHeadgear(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_HEADGEAR_ARROW = ITEMS.register("accessory_headgear_arrow", () -> new ItemAccessoryHeadgear(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_HEADGEAR_DOLL = ITEMS.register("accessory_headgear_doll", () -> new ItemAccessoryHeadgear(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_HEADGEAR_EARS_ELF = ITEMS.register("accessory_headgear_ears_elf", () -> new ItemAccessoryHeadgear(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_RING_HASTE = ITEMS.register("accessory_ring_haste", () -> new ItemAccessoryRingHaste(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_RING_JUMP = ITEMS.register("accessory_ring_jump", () -> new ItemAccessoryRingJump(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_RING_NIGHT = ITEMS.register("accessory_ring_night", () -> new ItemAccessoryRingNight(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_RING_SPEED = ITEMS.register("accessory_ring_speed", () -> new ItemAccessoryRingSpeed(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_TRINKET_LEVITATION = ITEMS.register("accessory_trinket_levitation", () -> new ItemAccessoryTrinketLevitation(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_TRINKET_POISON = ITEMS.register("accessory_trinket_poison", () -> new ItemAccessoryTrinketPoison(itemBuilder()));
    public static final RegistryObject<Item> ACCESSORY_TRINKET_WITHER = ITEMS.register("accessory_trinket_wither", () -> new ItemAccessoryTrinketWither(itemBuilder()));
    public static final RegistryObject<Item> BOX_ORE = ITEMS.register("box_overworld", () -> new ItemBoxOverworld(itemBuilder()));
    public static final RegistryObject<Item> BOX_NETHER = ITEMS.register("box_nether", () -> new ItemBoxNether(itemBuilder()));
    public static final RegistryObject<Item> BOX_END = ITEMS.register("box_end", () -> new ItemBoxEnd(itemBuilder()));
    public static final RegistryObject<Item> BOX_IRON = ITEMS.register("box_iron", () -> new ItemBoxIron(itemBuilder()));
    public static final RegistryObject<Item> BOX_GOLD = ITEMS.register("box_gold", () -> new ItemBoxGold(itemBuilder()));
    public static final RegistryObject<Item> BOX_DIAMOND = ITEMS.register("box_diamond", () -> new ItemBoxDiamond(itemBuilder()));
    public static final RegistryObject<Item> BOX_HAT = ITEMS.register("box_hat", () -> new ItemBoxHat(itemBuilder()));
    public static final RegistryObject<Item> BOX_OLD = ITEMS.register("box_old", () -> new ItemBoxOld(itemBuilder()));
    public static final RegistryObject<Item> BOOK_BUFF = ITEMS.register("weapon_book_buff", () -> new ItemWeaponBookBuff(itemBuilder()));
    public static final RegistryObject<Item> BAG_ARROW = ITEMS.register("bag_arrow", () -> new ItemBagArrow(itemBuilder()));
    public static final RegistryObject<Item> BAG_BOOK = ITEMS.register("bag_book", () -> new ItemBagBook(itemBuilder()));
    public static final RegistryObject<Item> BAG_RECORD = ITEMS.register("bag_record", () -> new ItemBagRecord(itemBuilder()));
    public static final RegistryObject<Item> CHEST_DUNGEON = ITEMS.register("chest_dungeon", () -> new ItemChestDungeon(itemBuilder()));
    public static final RegistryObject<Item> CHEST_JUNGLE = ITEMS.register("chest_jungle", () -> new ItemChestJungle(itemBuilder()));
    public static final RegistryObject<Item> CHEST_TEMPLE = ITEMS.register("chest_desert", () -> new ItemChestDesert(itemBuilder()));
    public static final RegistryObject<Item> FOOD_COALFISH = ITEMS.register("food_coalfish", () -> new ItemFoodCoalfish(itemBuilder()));
    public static final RegistryObject<Item> FOOD_HONEY = ITEMS.register("food_honey", () -> new ItemFoodHoney(itemBuilder()));
    public static final RegistryObject<Item> FOOD_MANDRAKE = ITEMS.register("food_mandrake", () -> new ItemFoodMandrake(itemBuilder()));
    public static final RegistryObject<Item> FOOD_MEAT = ITEMS.register("food_meat", () -> new ItemFoodBase(itemBuilder().food(GaiaFoods.MEAT)));
    public static final RegistryObject<Item> FOOD_MONSTER_FEED = ITEMS.register("food_monster_feed", () -> new ItemFoodMonsterFeed(itemBuilder()));
    public static final RegistryObject<Item> FOOD_MONSTER_FEED_PREMIUM = ITEMS.register("food_monster_feed_premium", () -> new ItemFoodMonsterFeedPremium(itemBuilder()));
    public static final RegistryObject<Item> FOOD_NETHER_WART = ITEMS.register("food_nether_wart", () -> new ItemFoodNetherWart(itemBuilder()));
    public static final RegistryObject<Item> FOOD_PIE_APPLE_GOLD = ITEMS.register("food_pie_apple_gold", () -> new ItemFoodPieAppleGold(itemBuilder()));
    public static final RegistryObject<Item> FOOD_PIE_MANDRAKE = ITEMS.register("food_pie_mandrake", () -> new ItemFoodPieMandrake(itemBuilder()));
    public static final RegistryObject<Item> FOOD_PIE_MEAT = ITEMS.register("food_pie_meat", () -> new ItemFoodPieMeat(itemBuilder()));
    public static final RegistryObject<Item> FOOD_ROOT = ITEMS.register("food_root", () -> new ItemFoodRoot(itemBuilder()));
    public static final RegistryObject<Item> FOOD_ROTTEN_HEART = ITEMS.register("food_rotten_heart", () -> new ItemFoodRottenHeart(itemBuilder()));
    public static final RegistryObject<Item> FOOD_SMALL_APPLE_GOLD = ITEMS.register("food_small_apple_gold", () -> new ItemFoodSmallAppleGold(itemBuilder()));
    public static final RegistryObject<Item> FOOD_WITHER = ITEMS.register("food_wither", () -> new ItemFoodWither(itemBuilder()));
    public static final RegistryObject<Item> MISC_BOOK = ITEMS.register("misc_book", () -> new ItemMiscBook(itemBuilder()));
    public static final RegistryObject<Item> MISC_CURRENCY_SELL = ITEMS.register("misc_currency_sell", () -> new ItemMiscCurrency(itemBuilder()));
    public static final RegistryObject<Item> MISC_CURRENCY_TRADER = ITEMS.register("misc_currency_trader", () -> new ItemMiscCurrency(itemBuilder()));
    public static final RegistryObject<Item> MISC_CURRENCY_HOLSTAURUS = ITEMS.register("misc_currency_holstaurus", () -> new ItemMiscCurrency(itemBuilder()));
    public static final RegistryObject<Item> MISC_CURRENCY_WERESHEEP = ITEMS.register("misc_currency_weresheep", () -> new ItemMiscCurrency(itemBuilder()));
    public static final RegistryObject<Item> MISC_EXPERIENCE_IRON = ITEMS.register("misc_experience_small", () -> new ItemMiscExperience(itemBuilder()));
    public static final RegistryObject<Item> MISC_EXPERIENCE_GOLD = ITEMS.register("misc_experience_medium", () -> new ItemMiscExperience(itemBuilder()));
    public static final RegistryObject<Item> MISC_EXPERIENCE_DIAMOND = ITEMS.register("misc_experience_large", () -> new ItemMiscExperience(itemBuilder()));
    public static final RegistryObject<Item> MISC_FUR = ITEMS.register("misc_fur", () -> new Item(itemBuilder()));
    public static final RegistryObject<Item> MISC_FURNACE_FUEL = ITEMS.register("misc_furnace_fuel", () -> new ItemMiscFurnaceFuel(itemBuilder()));
    public static final RegistryObject<Item> MISC_GIGA_GEAR = ITEMS.register("misc_giga_gear", () -> new ItemMiscGigaGear(itemBuilder()));
    public static final RegistryObject<Item> MISC_QUILL = ITEMS.register("misc_quill", () -> new Item(itemBuilder()));
    public static final RegistryObject<Item> MISC_RING_SPEED = ITEMS.register("misc_ring_speed", () -> new ItemMiscRing(itemBuilder()));
    public static final RegistryObject<Item> MISC_RING_HASTE = ITEMS.register("misc_ring_haste", () -> new ItemMiscRing(itemBuilder()));
    public static final RegistryObject<Item> MISC_RING_JUMP = ITEMS.register("misc_ring_jump", () -> new ItemMiscRing(itemBuilder()));
    public static final RegistryObject<Item> MISC_RING_NIGHT = ITEMS.register("misc_ring_night", () -> new ItemMiscRing(itemBuilder()));
    public static final RegistryObject<Item> MISC_SOUL_FIRE = ITEMS.register("misc_soul_fire", () -> new ItemMiscSoulFire(itemBuilder()));
    public static final RegistryObject<Item> MISC_SOUL_FIERY = ITEMS.register("misc_soul_fiery", () -> new ItemMiscSoulFiery(itemBuilder()));
    public static final RegistryObject<Item> PICKUP_HEART = ITEMS.register("pickup_heart", () -> new ItemPickupHeart(itemBuilder()));
    public static final RegistryObject<Item> SHARD_IRON = ITEMS.register("shard_iron", () -> new ItemShard(itemBuilder()));
    public static final RegistryObject<Item> SHARD_GOLD = ITEMS.register("shard_gold", () -> new ItemShard(itemBuilder()));
    public static final RegistryObject<Item> SHARD_DIAMOND = ITEMS.register("shard_diamond", () -> new ItemShard(itemBuilder()));
    public static final RegistryObject<Item> SHARD_EMERALD = ITEMS.register("shard_emerald", () -> new ItemShard(itemBuilder()));
    public static final RegistryObject<Item> SHARD_COPPER = ITEMS.register("shard_copper", () -> new ItemShard(itemBuilder()));
    public static final RegistryObject<Item> SHARD_SILVER = ITEMS.register("shard_silver", () -> new ItemShard(itemBuilder()));
    public static final RegistryObject<Item> SHARD_MISC = ITEMS.register("shard_misc_totem", () -> new ItemShardMisc(itemBuilder()));
    public static final RegistryObject<Item> SHIELD_PROP_STONE = ITEMS.register("shield_prop_stone", () -> new ItemShieldProp(itemBuilder()));
    public static final RegistryObject<Item> SHIELD_PROP_IRON = ITEMS.register("shield_prop_iron", () -> new ItemShieldProp(itemBuilder()));
    public static final RegistryObject<Item> SHIELD_PROP_GOLD = ITEMS.register("shield_prop_gold", () -> new ItemShieldProp(itemBuilder()));
    public static final RegistryObject<Item> SPAWN = ITEMS.register("spawn", () -> new ItemSpawn(itemBuilder()));
//    SPAWN_WERESHEEP = ITEMS.register(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.WERESHEEP_NPC), "spawn_weresheep");
//    SPAWN_CREEPER_GIRL = ITEMS.register(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.CREEPER_GIRL_NPC), "spawn_creeper_girl");
//    SPAWN_ENDER_GIRL = ITEMS.register(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.ENDER_GIRL_NPC), "spawn_ender_girl");
//    SPAWN_HOLSTAURUS = ITEMS.register(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.HOLSTAURUS_NPC), "spawn_holstaurus");
//    SPAWN_SLIME_GIRL = ITEMS.register(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.SLUDGE_GIRL_NPC), "spawn_slime_girl");
//    SPAWN_TRADER = ITEMS.register(new ItemSpawnNPC(itemBuilder(), Rarity.RARE, GaiaEntities.TRADER_NPC), "spawn_trader");
    public static final RegistryObject<Item> WEAPON_BOOK = ITEMS.register("weapon_book", () -> new ItemWeaponBook(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_BOOK_BATTLE = ITEMS.register("weapon_book_battle", () -> new ItemWeaponBookBattle(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_BOOK_ENDER = ITEMS.register("weapon_book_ender", () -> new ItemWeaponBookEnder(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_BOOK_FREEZING = ITEMS.register("weapon_book_freezing", () -> new ItemWeaponBookFreezing(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_BOOK_HUNGER = ITEMS.register("weapon_book_hunger", () -> new ItemWeaponBookHunger(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_BOOK_METAL = ITEMS.register("weapon_book_metal", () -> new ItemWeaponBookMetal(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_BOOK_NATURE = ITEMS.register("weapon_book_nature", () -> new ItemWeaponBookNature(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_BOOK_NIGHTMARE = ITEMS.register("weapon_book_nightmare", () -> new ItemWeaponBookNightmare(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_BOOK_WITHER = ITEMS.register("weapon_book_wither", () -> new ItemWeaponBookWither(GaiaTier.BOOK, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_FAN = ITEMS.register("weapon_fan", () -> new ItemWeaponFan(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_FAN_FIRE = ITEMS.register("weapon_fan_fire", () -> new ItemWeaponFanFire(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_FAN_ICE = ITEMS.register("weapon_fan_ice", () -> new ItemWeaponFanIce(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROJECTILE_BOMB = ITEMS.register("weapon_projectile_bomb", () -> new ItemWeaponProjectileBomb(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_ENDER = ITEMS.register("weapon_prop_ender", () -> new ItemWeaponProp(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_BLAZE = ITEMS.register("weapon_prop_blaze", () -> new ItemWeaponProp(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_CLUB = ITEMS.register("weapon_prop_metal", () -> new ItemWeaponProp(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_ENCHANTED = ITEMS.register("weapon_prop_enchanted", () -> new ItemWeaponPropEnchanted(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_PROJECTILE_BUBBLE = ITEMS.register("weapon_prop_projectile_bubble", () -> new ItemWeaponPropProjectile(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_PROJECTILE_MAGIC = ITEMS.register("weapon_prop_projectile_magic", () -> new ItemWeaponPropProjectile(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_PROJECTILE_POISON = ITEMS.register("weapon_prop_projectile_poison", () -> new ItemWeaponPropProjectile(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_PROJECTILE_WEB = ITEMS.register("weapon_prop_projectile_web", () -> new ItemWeaponPropProjectile(itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_SWORD_WOOD = ITEMS.register("weapon_prop_sword_wood", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_SWORD_STONE = ITEMS.register("weapon_prop_sword_stone", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_SWORD_IRON = ITEMS.register("weapon_prop_sword_iron", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_SWORD_GOLD = ITEMS.register("weapon_prop_sword_gold", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_AXE_WOOD = ITEMS.register("weapon_prop_axe_wood", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_AXE_STONE = ITEMS.register("weapon_prop_axe_stone", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_AXE_IRON = ITEMS.register("weapon_prop_axe_iron", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_AXE_GOLD = ITEMS.register("weapon_prop_axe_gold", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_DAGGER_METAL = ITEMS.register("weapon_prop_dagger_metal", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_BROOM = ITEMS.register("weapon_prop_broom", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));
    public static final RegistryObject<Item> WEAPON_PROP_HAMMER_MINOTAUR = ITEMS.register("weapon_prop_hammer_minotaur", () -> new ItemWeaponPropItemSword(GaiaTier.PROP, 3, -2.4F, itemBuilder()));

    //Prop Spawn Eggs
    public static final RegistryObject<Item> CAMPFIRE_SPAWN_EGG = ITEMS.register("campfire_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.CAMPFIRE.get(), 0x7a5f3a, 0xffd800, itemBuilder()));
    public static final RegistryObject<Item> CYAN_FLOWER_SPAWN_EGG = ITEMS.register("cyan_flower_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.CYAN_FLOWER.get(), 1073920, 4045287, itemBuilder()));
    public static final RegistryObject<Item> CHEST_SPAWN_EGG = ITEMS.register("chest_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.CHEST.get(), 11237677, 4274991, itemBuilder()));
    public static final RegistryObject<Item> VASE_SPAWN_EGG = ITEMS.register("vase_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.VASE.get(), 0x949494, 0x545454, itemBuilder()));
    public static final RegistryObject<Item> VASE_NETHER_SPAWN_EGG = ITEMS.register("vase_nether_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.VASE_NETHER.get(), 0x462129, 0x1b080c, itemBuilder()));

    //Hostile Spawn Eggs
    public static final RegistryObject<Item> ANT_SPAWN_EGG = ITEMS.register("ant_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.ANT.get(), 0x303030, 0x8a7264, itemBuilder()));
    public static final RegistryObject<Item> ANT_RANGER_SPAWN_EGG = ITEMS.register("ant_ranger_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.ANT_RANGER.get(), 0x8a7264, 0x303030, itemBuilder()));
    public static final RegistryObject<Item> ANUBIS_SPAWN_EGG = ITEMS.register("anubis_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.ANUBIS.get(), 0x353535, 0xb19534, itemBuilder()));

    //NPC Spawn Eggs
//    public static final RegistryObject<Item> DEBUG_SPAWN_EGG = ITEMS.register("debug_mob_spawn_egg", () -> new ItemGaiaSpawnEgg(GaiaEntities.DEBUG_MOB, 0x6fa289, 0x915741, itemBuilder()));

    public static final RegistryObject<Item> ARACHNE_SPAWN_EGG = ITEMS.register("arachne_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.ARACHNE.get(), 3815994, 11013646, itemBuilder()));
    public static final RegistryObject<Item> BANSHEE_SPAWN_EGG = ITEMS.register("banshee_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.BANSHEE.get(), 0xeed2e8, 0xc6b0ed, itemBuilder()));
    public static final RegistryObject<Item> BAPHOMET_SPAWN_EGG = ITEMS.register("baphomet_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.BAPHOMET.get(), 3559756, 14197864, itemBuilder()));
    public static final RegistryObject<Item> BEE_SPAWN_EGG = ITEMS.register("bee_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.BEE.get(), 0x353535, 0x353535, itemBuilder()));
    public static final RegistryObject<Item> BONE_KNIGHT_SPAWN_EGG = ITEMS.register("bone_knight_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.BONE_KNIGHT.get(), 4602533, 13619151, itemBuilder()));
    public static final RegistryObject<Item> CECEALIA_SPAWN_EGG = ITEMS.register("cecaelia_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.CECAELIA.get(), 0xdb5760, 0xd893a9, itemBuilder()));
    public static final RegistryObject<Item> CENTAUR_SPAWN_EGG = ITEMS.register("centaur_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.CENTAUR.get(), 0x8d4f41, 0x353535, itemBuilder()));
    public static final RegistryObject<Item> COBBLE_GOLEM_SPAWN_EGG = ITEMS.register("cobble_golem_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.COBBLE_GOLEM.get(), 11513775, 11513775, itemBuilder()));
    public static final RegistryObject<Item> COBBLESTONE_GOLEM_SPAWN_EGG = ITEMS.register("cobblestone_golem_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.COBBLESTONE_GOLEM.get(), 11513775, 11513775, itemBuilder()));
    public static final RegistryObject<Item> CREEP_SPAWN_EGG = ITEMS.register("creep_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.CREEP.get(), 7917159, 2053400, itemBuilder()));
    public static final RegistryObject<Item> CYCLOPS_SPAWN_EGG = ITEMS.register("cyclops_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.CYCLOPS.get(), 4936602, 3487029, itemBuilder()));
    public static final RegistryObject<Item> DEATHWORD_SPAWN_EGG = ITEMS.register("deathword_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.DEATHWORD.get(), 0xb77a35, 0xffd800, itemBuilder()));
    public static final RegistryObject<Item> DHAMPIR_SPAWN_EGG = ITEMS.register("dhampir_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.DHAMPIR.get(), 0x9c1c2b, 0xc9b161, itemBuilder()));
    public static final RegistryObject<Item> DRYAD_SPAWN_EGG = ITEMS.register("dryad_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.DRYAD.get(), 10255437, 5681460, itemBuilder()));
    public static final RegistryObject<Item> DULLAHAN_SPAWN_EGG = ITEMS.register("dullahan_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.DULLAHAN.get(), 0x824fab, 0xa4452d, itemBuilder()));
    public static final RegistryObject<Item> DWARF_SPAWN_EGG = ITEMS.register("dwarf_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.DWARF.get(), 0x969696, 0xf09942, itemBuilder()));
    public static final RegistryObject<Item> ENDER_DRAGON_GIRL_SPAWN_EGG = ITEMS.register("ender_dragon_girl_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.ENDER_DRAGON_GIRL.get(), 3158064, 14711290, itemBuilder()));
    public static final RegistryObject<Item> ENDER_EYE_SPAWN_EGG = ITEMS.register("ender_eye_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.ENDER_EYE.get(), 2039583, 0x3158064, itemBuilder()));
    public static final RegistryObject<Item> FLESH_LICH_SPAWN_EGG = ITEMS.register("flesh_lich_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.FLESH_LICH.get(), 0x00cccc, 0x799c65, itemBuilder()));
    public static final RegistryObject<Item> GELATINOUS_SLIME_SPAWN_EGG = ITEMS.register("gelatinous_slime_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.GELATINOUS_SLIME.get(), 6595667, 13619151, itemBuilder()));
    public static final RegistryObject<Item> GOBLIN_SPAWN_EGG = ITEMS.register("goblin_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.GOBLIN.get(), 0x718a60, 0x8d4f41, itemBuilder()));
    public static final RegistryObject<Item> GOBLIN_FERAL_SPAWN_EGG = ITEMS.register("goblin_feral_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.GOBLIN_FERAL.get(), 0x718a60, 0x8a1d3e, itemBuilder()));
    public static final RegistryObject<Item> GRYPHON_SPAWN_EGG = ITEMS.register("gryphon_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.GRYPHON.get(), 0xf09942, 0xe2e2e2, itemBuilder()));
    public static final RegistryObject<Item> HARPY_SPAWN_EGG = ITEMS.register("harpy_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.HARPY.get(), 0xc9b161, 0xa5884e, itemBuilder()));
    public static final RegistryObject<Item> HUNTER_SPAWN_EGG = ITEMS.register("hunter_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.HUNTER.get(), 0xae6b3c, 0x353535, itemBuilder()));
    public static final RegistryObject<Item> KIKIMORA_SPAWN_EGG = ITEMS.register("kikimora_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.KIKIMORA.get(), 0x191919, 0xd3bdac, itemBuilder()));
    public static final RegistryObject<Item> KOBOLD_SPAWN_EGG = ITEMS.register("kobold_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.KOBOLD.get(), 0x938dab, 0xafa7c1, itemBuilder()));
//    public static final RegistryObject<Item> MATANGO_SPAWN_EGG = ITEMS.register("matango_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.MATANGO.get(), 0xab1311, 0xd8d8d8, itemBuilder()));
//    public static final RegistryObject<Item> MERMAID_SPAWN_EGG = ITEMS.register("mermaid_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.MERMAID.get(), 0x5c70b1, 0xa4452d, itemBuilder()));
//    public static final RegistryObject<Item> MINOTAUR_SPAWN_EGG = ITEMS.register("minotaur_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.MINOTAUR.get(), 0x8d4f41, 0xd54242, itemBuilder()));
//    public static final RegistryObject<Item> MINOTAURUS_SPAWN_EGG = ITEMS.register("minotaurus_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.MINOTAURUS.get(), 0x8d4f41, 0xa9a9a9, itemBuilder()));
//    public static final RegistryObject<Item> MUMMY_SPAWN_EGG = ITEMS.register("mummy_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.MUMMY.get(), 0xdcd7c1, 0xc9b161, itemBuilder()));
//    public static final RegistryObject<Item> NAGA_SPAWN_EGG = ITEMS.register("naga_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.NAGA.get(), 0x29bc55, 0xccb63f, itemBuilder()));
//    public static final RegistryObject<Item> NINE_TAILS_SPAWN_EGG = ITEMS.register("nine_tails_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.NINE_TAILS.get(), 11809844, 13218145, itemBuilder()));
//    public static final RegistryObject<Item> ONI_SPAWN_EGG = ITEMS.register("oni_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.ONI.get(), 0x8b302d, 0xc9b161, itemBuilder()));
//    public static final RegistryObject<Item> ORC_SPAWN_EGG = ITEMS.register("orc_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.ORC.get(), 0x718a60, 0xc0d696, itemBuilder()));
//    public static final RegistryObject<Item> SATYRESS_SPAWN_EGG = ITEMS.register("satyress_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SATYRESS.get(), 0x707b4f, 0xa4452d, itemBuilder()));
//    public static final RegistryObject<Item> SELKIE_SPAWN_EGG = ITEMS.register("selkie_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SELKIE.get(), 9082818, 13488612, itemBuilder()));
//    public static final RegistryObject<Item> SHAMAN_SPAWN_EGG = ITEMS.register("shaman_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SHAMAN.get(), 0xae6b3c, 0x56b134, itemBuilder()));
//    public static final RegistryObject<Item> SHARKO_SPAWN_EGG = ITEMS.register("sharko_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SHARKO.get(), 0x84a498, 0x5c70b1, itemBuilder()));
//    public static final RegistryObject<Item> SIREN_SPAWN_EGG = ITEMS.register("siren_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SIREN.get(), 0x29bc55, 0x48a0de, itemBuilder()));
//    public static final RegistryObject<Item> SLUDGE_GIRL_SPAWN_EGG = ITEMS.register("sludge_girl_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SLUDGE_GIRL.get(), 6595667, 7715172, itemBuilder()));
    public static final RegistryObject<Item> SPHINX_SPAWN_EGG = ITEMS.register("sphinx_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SPHINX.get(), 0xf09942, 0x353535, itemBuilder()));
//    public static final RegistryObject<Item> SPRIGGAN_SPAWN_EGG = ITEMS.register("spriggan_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SPRIGGAN.get(), 0x7c623e, 0xc2dda5, itemBuilder()));
//    public static final RegistryObject<Item> SUCCUBUS_SPAWN_EGG = ITEMS.register("succubus_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.SUCCUBUS.get(), 4079166, 13218145, itemBuilder()));
//    public static final RegistryObject<Item> TOAD_SPAWN_EGG = ITEMS.register("toad_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.TOAD.get(), 0x355d2b, 0x779f5a, itemBuilder()));
//    public static final RegistryObject<Item> VALKYRIE_SPAWN_EGG = ITEMS.register("valkyrie_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.VALKYRIE.get(), 0xc9b161, 0xd54242, itemBuilder()));
//    public static final RegistryObject<Item> VAMPIRE_SPAWN_EGG = ITEMS.register("vampire_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.VAMPIRE.get(), 0xc23021, 0xc9b161, itemBuilder()));
//    public static final RegistryObject<Item> WERECAT_SPAWN_EGG = ITEMS.register("werecat_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.WERECAT.get(), 0x7a7e8a, 0xdddadb, itemBuilder()));
//    public static final RegistryObject<Item> WITCH_SPAWN_EGG = ITEMS.register("witch_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.WITCH.get(), 0x303030, 0x943dbb, itemBuilder()));
//    public static final RegistryObject<Item> WITHER_COW_SPAWN_EGG = ITEMS.register("wither_cow_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.WITHER_COW.get(), 5791069, 16777215, itemBuilder()));
//    public static final RegistryObject<Item> YETI_SPAWN_EGG = ITEMS.register("yeti_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.YETI.get(), 16448250, 7895160, itemBuilder()));
//    public static final RegistryObject<Item> YUKI_ONNA_SPAWN_EGG = ITEMS.register("yuki_onna_spawn_egg", () -> new ItemGaiaSpawnEgg(() -> GaiaEntities.YUKI_ONNA.get(), 6781114, 13817330, itemBuilder()));

    private static Item.Properties itemBuilder()
    {
        return new Item.Properties().group(GaiaItemGroups.ITEMS);
    }

    /**
     * Block items
     */
    public static final RegistryObject<Item> BUST_SPHINX_ITEM = ITEMS.register("bust_sphinx", () -> new BlockItem(GaiaBlocks.BUST_SPHINX.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> BUST_VALKYRIE_ITEM = ITEMS.register("bust_valkyrie", () -> new BlockItem(GaiaBlocks.BUST_VALKYRIE.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> BUST_VAMPIRE_ITEM = ITEMS.register("bust_vampire", () -> new BlockItem(GaiaBlocks.BUST_VAMPIRE.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> BUST_MINOTAUR_ITEM = ITEMS.register("bust_minotaur", () -> new BlockItem(GaiaBlocks.BUST_MINOTAUR.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> DOLL_CREEPER_GIRL_ITEM = ITEMS.register("doll_creeper_girl", () -> new BlockItem(GaiaBlocks.DOLL_CREEPER_GIRL.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> DOLL_ENDER_GIRL_ITEM = ITEMS.register("doll_ender_girl", () -> new BlockItem(GaiaBlocks.DOLL_ENDER_GIRL.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> DOLL_SLIME_GIRL_ITEM = ITEMS.register("doll_slime_girl", () -> new BlockItem(GaiaBlocks.DOLL_SLIME_GIRL.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> DOLL_MAID_ITEM = ITEMS.register("doll_maid", () -> new BlockItem(GaiaBlocks.DOLL_MAID.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> DECO_GARDEN_GNOME_ITEM =  ITEMS.register("deco_garden_gnome", () -> new BlockItem(GaiaBlocks.DECO_GARDEN_GNOME.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> DECO_MANDRAGORA_POT_ITEM =  ITEMS.register("deco_pot_mandragora", () -> new BlockItem(GaiaBlocks.DECO_MANDRAGORA_POT.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> DECO_NEST_HARPY_ITEM = ITEMS.register("deco_nest_harpy", () -> new BlockItem(GaiaBlocks.DECO_NEST_HARPY.get(), gaiaBlockItemBuilder()));
    public static final RegistryObject<Item> SPAWN_GUARD_ITEM =  ITEMS.register("spawn_guard", () -> new BlockItem(GaiaBlocks.SPAWN_GUARD.get(), gaiaBlockItemBuilder()));

    //Hidden from Blocks Tab
    public static final RegistryObject<Item> WEB_TEMP_ITEM = ITEMS.register("web_temp", () -> new BlockItem(GaiaBlocks.WEB_TEMP.get(), blockItemBuilder()));
    public static final RegistryObject<Item> FIRE_CAMP_ITEM = ITEMS.register("fire_camp", () -> new BlockItem(GaiaBlocks.WEB_TEMP.get(), blockItemBuilder()));


    private static Item.Properties blockItemBuilder()
    {
        return new Item.Properties();
    }

    private static Item.Properties gaiaBlockItemBuilder()
    {
        return new Item.Properties().group(GaiaItemGroups.BLOCKS);
    }
}
