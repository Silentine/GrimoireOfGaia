package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import gaia.items.ItemAccessoryRing;
import gaia.items.ItemAccessoryRingHaste;
import gaia.items.ItemAccessoryRingJump;
import gaia.items.ItemAccessoryTrinketLevitation;
import gaia.items.ItemAccessoryTrinketPoison;
import gaia.items.ItemAccessoryTrinketWither;
import gaia.items.ItemBagArrow;
import gaia.items.ItemBagBook;
import gaia.items.ItemBagOre;
import gaia.items.ItemBagRecord;
import gaia.items.ItemBox;
import gaia.items.ItemBoxDiamond;
import gaia.items.ItemBoxGold;
import gaia.items.ItemBoxIron;
import gaia.items.ItemBoxOld;
import gaia.items.ItemCard;
import gaia.items.ItemChest;
import gaia.items.ItemFoodCoalfish;
import gaia.items.ItemFoodMandrake;
import gaia.items.ItemFoodMeat;
import gaia.items.ItemFoodNetherWart;
import gaia.items.ItemFoodPieAppleGold;
import gaia.items.ItemFoodPieMandrake;
import gaia.items.ItemFoodPieMeat;
import gaia.items.ItemFoodRoot;
import gaia.items.ItemFoodRottenHeart;
import gaia.items.ItemFoodSmallAppleGold;
import gaia.items.ItemFoodWither;
import gaia.items.ItemAccessoryCursed;
import gaia.items.ItemMiscBook;
import gaia.items.ItemMiscCurrency;
import gaia.items.ItemMiscExperience;
import gaia.items.ItemMiscFur;
import gaia.items.ItemMiscFurnaceFuel;
import gaia.items.ItemMiscGigaGear;
import gaia.items.ItemMiscQuill;
import gaia.items.ItemMiscSoulFiery;
import gaia.items.ItemMiscSoulFire;
import gaia.items.ItemShard;
import gaia.items.ItemShieldProp;
import gaia.items.ItemSpawn;
import gaia.items.ItemSpawnCreeperGirl;
import gaia.items.ItemSpawnEnderGirl;
import gaia.items.ItemSpawnHolstaurus;
import gaia.items.ItemSpawnSlimeGirl;
import gaia.items.ItemSpawnTame;
import gaia.items.ItemSpawnTrader;
import gaia.items.ItemSpawnWeresheep;
import gaia.items.ItemWeaponBook;
import gaia.items.ItemWeaponBookBattle;
import gaia.items.ItemWeaponBookBuff;
import gaia.items.ItemWeaponBookEnder;
import gaia.items.ItemWeaponBookFreezing;
import gaia.items.ItemWeaponBookHunger;
import gaia.items.ItemWeaponBookMetal;
import gaia.items.ItemWeaponBookNature;
import gaia.items.ItemWeaponBookNightmare;
import gaia.items.ItemWeaponBookWither;
import gaia.items.ItemWeaponDebug;
import gaia.items.ItemWeaponFanFire;
import gaia.items.ItemWeaponFanIce;
import gaia.items.ItemWeaponProp;
import gaia.items.ItemWeaponPropEnchanted;
import gaia.items.ItemWeaponPropProjectile;
import gaia.items.ItemAccessoryRingNight;
import gaia.items.ItemAccessoryRingSpeed;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

//Modify ClientProxy when adding metadata items
public class GaiaItems {

    public static Item Shard;
    public static Item FoodMeat;
    public static Item FoodRottenHeart;
    public static Item FoodRoot;
    public static Item FoodCoalfish;
    public static Item FoodNetherWart;
    public static Item FoodSmallAppleGold;
    public static Item FoodMandrake;
    public static Item FoodWither;
    public static Item FoodPieMandrake;
    public static Item FoodPieMeat;
    public static Item FoodPieAppleGold;
    public static Item MiscSoulFire;
    public static Item MiscSoulFiery;
    public static Item MiscGigaGear;
    public static Item MiscFur;
    public static Item MiscExperience;
    public static Item MiscBook;
    public static Item MiscQuill;
    public static Item MiscRing;
    public static Item MiscFurnaceFuel;
    public static Item MiscCurrency;
    public static Item Spawn;
    public static Item SpawnCreeperGirl;
    public static Item SpawnSlimeGirl;
    public static Item SpawnEnderGirl;
    public static Item SpawnTrader;
    public static Item SpawnHolstaurus;
    public static Item SpawnWeresheep;
    public static Item SpawnTame;
    public static Item BoxIron;
    public static Item BoxGold;
    public static Item BoxDiamond;
    public static Item Box;
    public static Item BagOre;
    public static Item BagBook;
    public static Item BagRecord;
    public static Item BagArrow;
    public static Item BoxOld;
    public static Item Chest;
    public static Item PropWeapon;
    public static Item PropWeaponProjectile;
    public static Item PropWeaponEnchanted;
    public static Item PropShield;
    public static Item FanIce;
    public static Item FanFire;
    public static Item BookBase;
    public static Item BookFreezing;
    public static Item BookNightmare;
    public static Item BookMetal;
    public static Item BookEnder;
    public static Item BookHunger;
    public static Item BookBattle;
    public static Item BookNature;
    public static Item BookWither;
    public static Item BookBuff;
    public static Item Debug;
    public static Item AccessoryRingSpeed;
    public static Item AccessoryRingHaste;
    public static Item AccessoryRingJump;
    public static Item AccessoryRingNight;
    public static Item AccessoryTrinketPoison;
    public static Item AccessoryTrinketWither;
    public static Item AccessoryTrinketLevitation;
    public static Item AccessoryCursed;
    public static Item Card;

    public static void init() {
        Shard = new ItemShard("shard");
        FoodMeat = new ItemFoodMeat(6, 0.6F, true, "foodmeat");
        FoodRottenHeart = new ItemFoodRottenHeart(4, 0.0F, true, "foodrottenheart").setAlwaysEdible();
        FoodRoot = (new ItemFoodRoot(4, 0.0F, false, "foodroot")).setAlwaysEdible();
        FoodCoalfish = new ItemFoodCoalfish(4, 0.4F, true, "foodcoalfish");
        FoodNetherWart = (new ItemFoodNetherWart(4, 0.4F, false, "foodnetherwart"));
        FoodSmallAppleGold = (new ItemFoodSmallAppleGold(1, 0.4F, false, "foodsmallapplegold")).setAlwaysEdible();
        FoodMandrake = (new ItemFoodMandrake(0, 0.0F, false, "foodmandrake")).setAlwaysEdible();
        FoodWither = new ItemFoodWither(8, 0.8F, true, "foodwither");
        FoodPieMandrake = (new ItemFoodPieMandrake(8, 0.8F, false, "foodpiemandrake"));
        FoodPieMeat = (new ItemFoodPieMeat(8, 0.8F, true, "foodpiemeat"));
        FoodPieAppleGold = (new ItemFoodPieAppleGold(12, 0.8F, true, "foodpieapplegold"));
        MiscSoulFire = new ItemMiscSoulFire("miscsoulfire");
        MiscSoulFiery = new ItemMiscSoulFiery("miscsoulfiery");
        MiscGigaGear = new ItemMiscGigaGear("miscgigagear");
        MiscFur = new ItemMiscFur("miscfur");
        MiscExperience = new ItemMiscExperience("miscexperience");
        MiscBook = new ItemMiscBook("miscbook");
        MiscQuill = new ItemMiscQuill("miscquill");
        MiscRing = new ItemAccessoryRing("miscring");
        MiscFurnaceFuel = new ItemMiscFurnaceFuel("miscfurnacefuel");
        MiscCurrency = new ItemMiscCurrency("misccurrency");
        Spawn = new ItemSpawn("spawn");
        SpawnCreeperGirl = new ItemSpawnCreeperGirl("spawncreepergirl");
        SpawnSlimeGirl = new ItemSpawnSlimeGirl("spawnslimegirl");
        SpawnEnderGirl = new ItemSpawnEnderGirl("spawnendergirl");
        SpawnTrader = new ItemSpawnTrader("spawntrader");
        SpawnHolstaurus = new ItemSpawnHolstaurus("spawnholstaurus");
        SpawnWeresheep = new ItemSpawnWeresheep("spawnweresheep");
        SpawnTame = new ItemSpawnTame("spawntame");
        BoxIron = new ItemBoxIron("boxiron");
        BoxGold = new ItemBoxGold("boxgold");
        BoxDiamond = new ItemBoxDiamond("boxdiamond");
        Box = new ItemBox("box");
        BagOre = new ItemBagOre("bagore");
        BagBook = new ItemBagBook("bagbook");
        BagRecord = new ItemBagRecord("bagrecord");
        BagArrow = new ItemBagArrow("bagarrow");
        BoxOld = new ItemBoxOld("boxold");
        Chest = new ItemChest("chest");
        PropWeapon = new ItemWeaponProp("weaponprop");
        PropWeaponProjectile = new ItemWeaponPropProjectile("weaponpropprojectile");
        PropWeaponEnchanted = new ItemWeaponPropEnchanted("weaponpropenchanted");
        PropShield = new ItemShieldProp("shieldprop");
        FanIce = new ItemWeaponFanIce("weaponfanice");
        FanFire = new ItemWeaponFanFire("weaponfanfire");
        BookBase = new ItemWeaponBook("weaponbook");
        BookFreezing = new ItemWeaponBookFreezing("weaponbookfreezing");
        BookNightmare = new ItemWeaponBookNightmare("weaponbooknightmare");
        BookMetal = new ItemWeaponBookMetal("weaponbookmetal");
        BookEnder = new ItemWeaponBookEnder("weaponbookender");
        BookHunger = new ItemWeaponBookHunger("weaponbookhunger");
        BookBattle = new ItemWeaponBookBattle("weaponbookbattle");
        BookNature = new ItemWeaponBookNature("weaponbooknature");
        BookWither = new ItemWeaponBookWither("weaponbookwither");
        BookBuff = new ItemWeaponBookBuff("weaponbookbuff");
        Debug = new ItemWeaponDebug("weapondebug");

        AccessoryRingSpeed = new ItemAccessoryRingSpeed("accessoryringspeed");
        AccessoryRingHaste = new ItemAccessoryRingHaste("accessoryringhaste");
        AccessoryRingJump = new ItemAccessoryRingJump("accessoryringjump");
        AccessoryRingNight = new ItemAccessoryRingNight("accessoryringnight");
        AccessoryTrinketPoison = new ItemAccessoryTrinketPoison("accessorytrinketpoison");
        AccessoryTrinketWither = new ItemAccessoryTrinketWither("accessorytrinketwither");
        AccessoryTrinketLevitation = new ItemAccessoryTrinketLevitation("accessorytrinketlevitation");
        AccessoryCursed = new ItemAccessoryCursed("accessorycursed");

        Card = new ItemCard("card");
    }

    @Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
    public static class RegistrationHandler {

        public static final Set<Item> ITEMS = new HashSet<>();

        /**
         * Register this mod's {@link Item}s.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            Gaia.LOGGER.info("Registering items...");
            init();
            Item[] items = new Item[] {
                    Shard,
                    FoodMeat,
                    FoodRottenHeart,
                    FoodRoot,
                    FoodCoalfish,
                    FoodNetherWart,
                    FoodSmallAppleGold,
                    FoodMandrake,
                    FoodWither,
                    FoodPieMandrake,
                    FoodPieMeat,
                    FoodPieAppleGold,
                    MiscSoulFire,
                    MiscSoulFiery,
                    MiscGigaGear,
                    MiscFur,
                    MiscExperience,
                    MiscBook,
                    MiscQuill,
                    MiscRing,
                    MiscFurnaceFuel,
                    MiscCurrency,
                    Spawn,
                    SpawnCreeperGirl,
                    SpawnEnderGirl,
                    SpawnSlimeGirl,
                    SpawnTrader,
                    SpawnHolstaurus,
                    SpawnWeresheep,
                    SpawnTame,
                    BoxIron,
                    BoxGold,
                    BoxDiamond,
                    Box,
                    BagOre,
                    BagBook,
                    BagRecord,
                    BagArrow,
                    BoxOld,
                    Chest,
                    PropWeapon,
                    PropWeaponProjectile,
                    PropWeaponEnchanted,
                    PropShield,
                    FanIce,
                    FanFire,
                    BookBase,
                    BookFreezing,
                    BookNightmare,
                    BookMetal,
                    BookEnder,
                    BookHunger,
                    BookBattle,
                    BookNature,
                    BookWither,
                    BookBuff,
                    Debug,
                    AccessoryRingSpeed,
                    AccessoryRingHaste,
                    AccessoryRingJump,
                    AccessoryRingNight,
                    AccessoryTrinketPoison,
                    AccessoryTrinketWither,
                    AccessoryTrinketLevitation,
                    AccessoryCursed,
                    Card
            };

            final IForgeRegistry<Item> registry = event.getRegistry();

            for (final Item item : items) {
                registry.register(item);
                ITEMS.add(item);
            }
            Gaia.proxy.registerItemsRender();
            Gaia.LOGGER.info("Item registration complete.");
        }
    }
}
