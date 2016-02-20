package gaia.init;

import java.util.Locale;

import gaia.items.ItemAccessoryDollCursed;
import gaia.items.ItemAccessoryRingHaste;
import gaia.items.ItemAccessoryRingJump;
import gaia.items.ItemAccessoryRingNight;
import gaia.items.ItemAccessoryRingSpeed;
import gaia.items.ItemBagBook;
import gaia.items.ItemBagOre;
import gaia.items.ItemBagRecord;
import gaia.items.ItemBoxDiamond;
import gaia.items.ItemBoxGold;
import gaia.items.ItemBoxIron;
import gaia.items.ItemBoxOld;
import gaia.items.ItemFoodBerryCure;
import gaia.items.ItemFoodBerryFire;
import gaia.items.ItemFoodBerryHealth;
import gaia.items.ItemFoodBerryIce;
import gaia.items.ItemFoodCoalfish;
import gaia.items.ItemFoodDriedNetherWart;
import gaia.items.ItemFoodMandrake;
import gaia.items.ItemFoodMeat;
import gaia.items.ItemFoodMeatMorsel;
import gaia.items.ItemFoodPieBerry;
import gaia.items.ItemFoodPieMandrake;
import gaia.items.ItemFoodPieMeat;
import gaia.items.ItemFoodSmallAppleGold;
import gaia.items.ItemFoodWitherMeat;
import gaia.items.ItemFragment;
import gaia.items.ItemMiscBook;
import gaia.items.ItemMiscCurrency;
import gaia.items.ItemMiscFurnaceFuel;
import gaia.items.ItemMiscGigaGear;
import gaia.items.ItemMiscPage;
import gaia.items.ItemMiscRing;
import gaia.items.ItemMiscSoulFiery;
import gaia.items.ItemMiscSoulFire;
import gaia.items.ItemMiscWeaponEnchanted;
import gaia.items.ItemShard;
import gaia.items.ItemSpawnCard;
import gaia.items.ItemSpawnCardCreeperGirl;
import gaia.items.ItemSpawnCardEnderGirl;
import gaia.items.ItemSpawnCardHolstaurus;
import gaia.items.ItemSpawnCardSlimeGirl;
import gaia.items.ItemSpawnCardTrader;
import gaia.items.ItemWeaponBookBattle;
import gaia.items.ItemWeaponBookBuff;
import gaia.items.ItemWeaponBookEnder;
import gaia.items.ItemWeaponBookFreezing;
import gaia.items.ItemWeaponBookHunger;
import gaia.items.ItemWeaponBookMetal;
import gaia.items.ItemWeaponBookNature;
import gaia.items.ItemWeaponBookNightmare;
import gaia.items.ItemWeaponBookWither;
import gaia.items.ItemWeaponFanFire;
import gaia.items.ItemWeaponFanIce;
import gaia.items.ItemWeaponProp;
import gaia.items.ItemWeaponPropInvisible;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class GaiaItem {
	public static Item Shard;
	public static Item Fragment;
	public static Item FoodMeatMorsel;
	public static Item FoodMeat;
	public static Item FoodCoalfish;
	public static Item FoodWitherMeat;
	public static Item FoodSmallAppleGold;
	public static Item FoodBerryHealth;
	public static Item FoodBerryCure;
	public static Item FoodBerryIce;
	public static Item FoodBerryFire;
	public static Item FoodDriedNetherWart;
	public static Item FoodMandrake;
	public static Item FoodPieMandrake;
	public static Item FoodPieMeat;
	public static Item FoodPieBerry;
	public static Item MiscSoulFire;
	public static Item MiscSoulFiery;
	public static Item MiscGigaGear;
	public static Item MiscPage;
	public static Item MiscBook;
	public static Item MiscRing;
	public static Item MiscFurnaceFuel;
	public static Item MiscCurrency;
	public static Item MiscWeaponEnchanted;
	public static Item SpawnCard;
	public static Item SpawnCardCreeperGirl;
	public static Item SpawnCardEnderGirl;
	public static Item SpawnCardHolstaurus;
	public static Item SpawnCardSlimeGirl;
	public static Item SpawnCardTrader;
	public static Item BoxIron;
	public static Item BoxGold;
	public static Item BoxDiamond;
	public static Item BagOre;
	public static Item BagBook;
	public static Item BagRecord;
	public static Item BoxOld;
	public static Item PropWeapon;
	public static Item PropWeaponInvisible;
	public static Item FanIce;
	public static Item FanFire;
	public static Item BookFreezing;
	public static Item BookNightmare;
	public static Item BookMetal;
	public static Item BookEnder;
	public static Item BookHunger;
	public static Item BookBattle;
	public static Item BookNature;
	public static Item BookWither;
	public static Item BookBuff;
	public static Item AccessoryRingSpeed;
	public static Item AccessoryRingHaste;
	public static Item AccessoryRingJump;
	public static Item AccessoryRingNight;
	public static Item AccessoryDollCursed;
	//public static Item SpawnEgg;

	public static void init() {
		Shard = new ItemShard("Shard");
		Fragment = new ItemFragment("FragmentEmerald");
		FoodMeatMorsel = new ItemFoodMeatMorsel(4, 0.8F, true, "FoodMeatMorsel");
		FoodMeat = new ItemFoodMeat(8, 0.8F, true, "FoodMeat");
		FoodCoalfish = new ItemFoodCoalfish(4, 0.4F, true, "FoodCoalfish");
		FoodWitherMeat = new ItemFoodWitherMeat(8, 0.8F, true, "FoodWitherMeat");
		FoodSmallAppleGold = (new ItemFoodSmallAppleGold(1, 0.4F, false, "FoodSmallAppleGold")).setAlwaysEdible();
		FoodBerryHealth = (new ItemFoodBerryHealth(4, 0.0F, false, "FoodBerryHealth")).setAlwaysEdible();
		FoodBerryCure = (new ItemFoodBerryCure(4, 0.0F, true, "FoodBerryCure")).setAlwaysEdible();
		FoodBerryIce = (new ItemFoodBerryIce(4, 0.0F, true, "FoodBerryIce")).setAlwaysEdible();
		FoodBerryFire = (new ItemFoodBerryFire(4, 0.0F, true, "FoodBerryFire")).setAlwaysEdible();
		FoodDriedNetherWart = (new ItemFoodDriedNetherWart(4, 0.4F, true, "FoodDriedNetherWart")).setPotionEffect("+4");
		FoodMandrake = (new ItemFoodMandrake(0, 0.0F, true, "FoodMandrake")).setAlwaysEdible();
		FoodPieMandrake = (new ItemFoodPieMandrake(12, 0.8F, true, "FoodPieMandrake")).setAlwaysEdible();
		FoodPieMeat = (new ItemFoodPieMeat(16, 0.8F, true, "FoodPieMeat"));
		FoodPieBerry = (new ItemFoodPieBerry(12, 0.2F, true, "FoodPieBerry"));
		MiscSoulFire = new ItemMiscSoulFire("MiscSoulFire");
		MiscSoulFiery = new ItemMiscSoulFiery("MiscSoulFiery");
		MiscGigaGear = new ItemMiscGigaGear("MiscGigaGear");
		MiscPage = new ItemMiscPage("MiscPage");
		MiscBook = new ItemMiscBook("MiscBook");
		MiscRing = new ItemMiscRing("MiscRing");
		MiscFurnaceFuel = new ItemMiscFurnaceFuel("MiscFurnaceFuel");
		MiscCurrency = new ItemMiscCurrency("MiscCurrency");
		MiscWeaponEnchanted = new ItemMiscWeaponEnchanted("MiscWeaponEnchanted");
		SpawnCard = new ItemSpawnCard("SpawnCard");
		SpawnCardCreeperGirl = new ItemSpawnCardCreeperGirl("SpawnCardCreeperGirl");
		SpawnCardEnderGirl = new ItemSpawnCardEnderGirl("SpawnCardEnderGirl");
		SpawnCardHolstaurus = new ItemSpawnCardHolstaurus("SpawnCardHolstaurus");
		SpawnCardSlimeGirl = new ItemSpawnCardSlimeGirl("SpawnCardSlimeGirl");
		SpawnCardTrader = new ItemSpawnCardTrader("SpawnCardTrader");
		BoxIron = new ItemBoxIron("BoxIron");
		BoxGold = new ItemBoxGold("BoxGold");
		BoxDiamond = new ItemBoxDiamond("BoxDiamond");
		BagOre = new ItemBagOre("BagOre");
		BagBook = new ItemBagBook("BagBook");
		BagRecord = new ItemBagRecord("BagRecord");
		BoxOld = new ItemBoxOld("BoxOld");
		PropWeapon = new ItemWeaponProp("WeaponProp");
		PropWeaponInvisible = new ItemWeaponPropInvisible("WeaponPropInvisible");
		FanIce = new ItemWeaponFanIce("WeaponFanIce");
		FanFire = new ItemWeaponFanFire("WeaponFanFire");
		BookFreezing = new ItemWeaponBookFreezing("WeaponBookFreezing");
		BookNightmare = new ItemWeaponBookNightmare("WeaponBookNightmare");
		BookMetal = new ItemWeaponBookMetal("WeaponBookMetal");
		BookEnder = new ItemWeaponBookEnder("WeaponBookEnder");
		BookHunger = new ItemWeaponBookHunger("WeaponBookHunger");
		BookBattle = new ItemWeaponBookBattle("WeaponBookBattle");
		BookNature = new ItemWeaponBookNature("WeaponBookNature");
		BookWither = new ItemWeaponBookWither("WeaponBookWither");
		BookBuff = new ItemWeaponBookBuff("WeaponBookBuff");
		AccessoryRingSpeed = new ItemAccessoryRingSpeed("AccessoryRingSpeed");
		AccessoryRingHaste = new ItemAccessoryRingHaste("AccessoryRingHaste");
		AccessoryRingJump = new ItemAccessoryRingJump("AccessoryRingJump");
		AccessoryRingNight = new ItemAccessoryRingNight("AccessoryRingNight");
		AccessoryDollCursed = new ItemAccessoryDollCursed("AccessoryDollCursed");
		//SpawnEgg = new ItemGaiaSpawnEgg();
	}
	
	public static void register()
	{
		Item[] items = new Item[] { 
				Shard, 
				Fragment,
				FoodMeatMorsel, 
				FoodMeat, 
				FoodCoalfish, 
				FoodWitherMeat,
				FoodSmallAppleGold, 
				FoodBerryHealth, 
				FoodBerryCure, 
				FoodBerryIce, 
				FoodBerryFire,
				FoodDriedNetherWart, 
				FoodMandrake, 
				FoodPieMandrake, 
				FoodPieMeat,
				FoodPieBerry,
				MiscSoulFire, 
				MiscSoulFiery, 
				MiscGigaGear, 
				MiscPage,
				MiscBook, 
				MiscRing, 
				MiscFurnaceFuel,
				MiscCurrency,
				MiscWeaponEnchanted,
				SpawnCard, 
				SpawnCardCreeperGirl, 
				SpawnCardEnderGirl, 
				SpawnCardHolstaurus,
				SpawnCardSlimeGirl,
				SpawnCardTrader, 
				BoxIron, 
				BoxGold, 
				BoxDiamond, 
				BagOre, 
				BagBook, 
				BagRecord, 
				BoxOld, 
				PropWeapon, 
				PropWeaponInvisible,
				FanIce, 
				FanFire, 
				BookFreezing, 
				BookNightmare, 
				BookMetal, 
				BookEnder, 
				BookHunger,
				BookBattle, 
				BookNature,
				BookWither, 
				BookBuff,
				AccessoryRingSpeed, 
				AccessoryRingHaste, 
				AccessoryRingJump, 
				AccessoryRingNight,
				AccessoryDollCursed,
				//SpawnEgg 
		};
		for (int i = 0; i < items.length; i++) {
			GameRegistry.registerItem(items[i], items[i].getUnlocalizedName());
		}
		
		//BlockDispenser.dispenseBehaviorRegistry.putObject(SpawnEgg, new GaiaDispenserBehaviorMobEgg());
	}

	public static void addRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 1), new Object[]{new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 1), new Object[]{new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), new Object[]{new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 1), new Object[]{new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(Shard, 1, 3), new Object[]{Fragment, Fragment});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 1), new Object[]{Fragment, Fragment, Fragment, Fragment, Fragment, Fragment, Fragment, Fragment});
		GameRegistry.addRecipe(new ItemStack(Items.nether_star, 2), new Object[]{"Y Y", " X ", "Y Y", Character.valueOf('X'), Items.nether_star, Character.valueOf('Y'), new ItemStack(Shard, 1, 4)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 1), new Object[]{new ItemStack(Shard, 1, 5), new ItemStack(Shard, 1, 5), new ItemStack(Shard, 1, 5), new ItemStack(Shard, 1, 5)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.blaze_rod, 1), new Object[]{new ItemStack(Shard, 1, 6), new ItemStack(Shard, 1, 6), new ItemStack(Shard, 1, 6), new ItemStack(Shard, 1, 6)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.golden_apple, 1, 1), new Object[]{FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMandrake, 1), new Object[]{FoodMandrake, Items.sugar, Items.egg});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMeat, 1), new Object[]{FoodMeatMorsel, FoodMeatMorsel, FoodMeatMorsel, FoodMeatMorsel, Items.sugar, Items.egg});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMeat, 1), new Object[]{FoodMeat, FoodMeat, Items.sugar, Items.egg});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMeat, 1), new Object[]{FoodWitherMeat, Items.sugar, Items.egg});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieBerry, 1), new Object[]{FoodBerryHealth, Items.sugar, Items.egg});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieBerry, 1), new Object[]{FoodBerryCure, Items.sugar, Items.egg});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieBerry, 1), new Object[]{FoodBerryIce, Items.sugar, Items.egg});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieBerry, 1), new Object[]{FoodBerryFire, Items.sugar, Items.egg});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.coal_block, 1), new Object[]{MiscFurnaceFuel, MiscFurnaceFuel, MiscFurnaceFuel, MiscFurnaceFuel});
		GameRegistry.addShapelessRecipe(new ItemStack(FanIce, 1), new Object[]{new ItemStack(MiscWeaponEnchanted, 1, 0), Items.snowball});
		GameRegistry.addShapelessRecipe(new ItemStack(FanFire, 1), new Object[]{new ItemStack(MiscWeaponEnchanted, 1, 1), Items.coal});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingSpeed, 1), new Object[]{new ItemStack(MiscRing, 1, 0), Blocks.beacon});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingHaste, 1), new Object[]{new ItemStack(MiscRing, 1, 1), Blocks.beacon});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingJump, 1), new Object[]{new ItemStack(MiscRing, 1, 2), Blocks.beacon});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingNight, 1), new Object[]{new ItemStack(MiscRing, 1, 3), Blocks.beacon});
	}
	
    public static void oreRegistration() {
            OreDictionary.registerOre("shardIronIngot", new ItemStack(Shard, 1, 0));
            OreDictionary.registerOre("shardGoldIngot", new ItemStack(Shard, 1, 1));
            OreDictionary.registerOre("shardDiamond", new ItemStack(Shard, 1, 2));
            OreDictionary.registerOre("shardEmerald", new ItemStack(Shard, 1, 3));
            OreDictionary.registerOre("shardEnderPearl", new ItemStack(Shard, 1, 5));
            OreDictionary.registerOre("shardBlazeRod", new ItemStack(Shard, 1, 6));
            OreDictionary.registerOre("fragmentEmerald", Fragment);
    }
	public static void registerRenders()
	{
		registerRender(Shard);
		registerRender(Fragment);
		registerRender(FoodMeatMorsel);
		registerRender(FoodMeat);
		registerRender(FoodCoalfish);
		registerRender(FoodWitherMeat);
		registerRender(FoodSmallAppleGold);
		registerRender(FoodBerryHealth);
		registerRender(FoodBerryCure);
		registerRender(FoodBerryIce);
		registerRender(FoodBerryFire);
		registerRender(FoodDriedNetherWart);
		registerRender(FoodMandrake);
		registerRender(FoodPieMandrake);
		registerRender(FoodPieMeat);
		registerRender(FoodPieBerry);
		registerRender(MiscSoulFire);
		registerRender(MiscSoulFiery);
		registerRender(MiscGigaGear);
		registerRender(MiscPage);
		registerRender(MiscBook);
		registerRender(MiscRing);
		registerRender(MiscFurnaceFuel);
		registerRender(MiscCurrency);
		registerRender(MiscWeaponEnchanted);
		registerRender(SpawnCard);
		registerRender(SpawnCardCreeperGirl);
		registerRender(SpawnCardEnderGirl);
		registerRender(SpawnCardHolstaurus);
		registerRender(SpawnCardSlimeGirl);
		registerRender(SpawnCardTrader);
		registerRender(BoxIron);
		registerRender(BoxGold);
		registerRender(BoxDiamond);
		registerRender(BagOre);
		registerRender(BagBook);
		registerRender(BagRecord);
		registerRender(BoxOld);
		registerRender(PropWeapon);
		registerRender(PropWeaponInvisible);
		registerRender(FanIce);
		registerRender(FanFire);
		registerRender(BookFreezing);
		registerRender(BookNightmare);
		registerRender(BookMetal);
		registerRender(BookEnder);
		registerRender(BookHunger);
		registerRender(BookBattle);
		registerRender(BookNature);
		registerRender(BookWither);
		registerRender(BookBuff);
		registerRender(AccessoryRingSpeed);
		registerRender(AccessoryRingHaste);
		registerRender(AccessoryRingJump);
		registerRender(AccessoryRingNight);
		registerRender(AccessoryDollCursed);
		//registerRender(SpawnEgg);
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("gaia:" + item.getUnlocalizedName().substring(20).toLowerCase(Locale.US), "inventory"));
	}
	
}
