package gaia.init;

import gaia.items.GaiaBehaviorDefaultDispenseItem;
import gaia.items.ItemAccessoryBauble;
import gaia.items.ItemAccessoryCursed;
import gaia.items.ItemAccessoryRingHaste;
import gaia.items.ItemAccessoryRingJump;
import gaia.items.ItemAccessoryRingNight;
import gaia.items.ItemAccessoryRingSpeed;
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
import gaia.items.ItemGaiaSpawnEgg;
import gaia.items.ItemMiscBook;
import gaia.items.ItemMiscCurrency;
import gaia.items.ItemMiscExperience;
import gaia.items.ItemMiscFur;
import gaia.items.ItemMiscFurnaceFuel;
import gaia.items.ItemMiscGigaGear;
import gaia.items.ItemMiscQuill;
import gaia.items.ItemMiscRing;
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
import net.minecraft.block.BlockDispenser;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

//Modify ClientProxy when adding metadata items
public class GaiaItems {
	public static Item
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
	SpawnSlimeGirl,
	SpawnEnderGirl,
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
	AccessoryBauble,
	Card,
	SpawnEgg;

	public static void init() {
		Shard = new ItemShard("Shard");		
		FoodMeat = new ItemFoodMeat(6, 0.6F, true, "FoodMeat");
		FoodRottenHeart = new ItemFoodRottenHeart(4, 0.0F, true, "FoodRottenHeart").setAlwaysEdible();
		FoodRoot = (new ItemFoodRoot(4, 0.0F, false, "FoodRoot")).setAlwaysEdible();
		FoodCoalfish = new ItemFoodCoalfish(4, 0.4F, true, "FoodCoalfish");
		FoodNetherWart = (new ItemFoodNetherWart(4, 0.4F, false, "FoodNetherWart"));
		FoodSmallAppleGold = (new ItemFoodSmallAppleGold(1, 0.4F, false, "FoodSmallAppleGold")).setAlwaysEdible();
		FoodMandrake = (new ItemFoodMandrake(0, 0.0F, false, "FoodMandrake")).setAlwaysEdible();
		FoodWither = new ItemFoodWither(8, 0.8F, true, "FoodWither");
		FoodPieMandrake = (new ItemFoodPieMandrake(8, 0.8F, false, "FoodPieMandrake"));
		FoodPieMeat = (new ItemFoodPieMeat(8, 0.8F, true, "FoodPieMeat"));
		FoodPieAppleGold = (new ItemFoodPieAppleGold(12, 0.8F, true, "FoodPieAppleGold"));
		MiscSoulFire = new ItemMiscSoulFire("MiscSoulFire");
		MiscSoulFiery = new ItemMiscSoulFiery("MiscSoulFiery");
		MiscGigaGear = new ItemMiscGigaGear("MiscGigaGear");
		MiscFur = new ItemMiscFur("MiscFur");
		MiscExperience = new ItemMiscExperience("MiscExperience");
		MiscBook = new ItemMiscBook("MiscBook");
		MiscQuill = new ItemMiscQuill("MiscQuill");
		MiscRing = new ItemMiscRing("MiscRing");
		MiscFurnaceFuel = new ItemMiscFurnaceFuel("MiscFurnaceFuel");
		MiscCurrency = new ItemMiscCurrency("MiscCurrency");
		Spawn = new ItemSpawn("Spawn");
		SpawnCreeperGirl = new ItemSpawnCreeperGirl("SpawnCreeperGirl");
		SpawnSlimeGirl = new ItemSpawnSlimeGirl("SpawnSlimeGirl");
		SpawnEnderGirl = new ItemSpawnEnderGirl("SpawnEnderGirl");
		SpawnTrader = new ItemSpawnTrader("SpawnTrader");
		SpawnHolstaurus = new ItemSpawnHolstaurus("SpawnHolstaurus");
		SpawnWeresheep = new ItemSpawnWeresheep("SpawnWeresheep");
		SpawnTame = new ItemSpawnTame("SpawnTame");
		BoxIron = new ItemBoxIron("BoxIron");
		BoxGold = new ItemBoxGold("BoxGold");
		BoxDiamond = new ItemBoxDiamond("BoxDiamond");
		Box = new ItemBox("Box");
		BagOre = new ItemBagOre("BagOre");
		BagBook = new ItemBagBook("BagBook");
		BagRecord = new ItemBagRecord("BagRecord");
		BagArrow = new ItemBagArrow("BagArrow");
		BoxOld = new ItemBoxOld("BoxOld");
		Chest = new ItemChest("Chest");
		PropWeapon = new ItemWeaponProp("WeaponProp");
		PropWeaponProjectile = new ItemWeaponPropProjectile("WeaponPropProjectile");
		PropWeaponEnchanted = new ItemWeaponPropEnchanted("WeaponPropEnchanted");
		PropShield = new ItemShieldProp("ShieldProp");
		FanIce = new ItemWeaponFanIce("WeaponFanIce");
		FanFire = new ItemWeaponFanFire("WeaponFanFire");
		BookBase = new ItemWeaponBook("WeaponBook");
		BookFreezing = new ItemWeaponBookFreezing("WeaponBookFreezing");
		BookNightmare = new ItemWeaponBookNightmare("WeaponBookNightmare");
		BookMetal = new ItemWeaponBookMetal("WeaponBookMetal");
		BookEnder = new ItemWeaponBookEnder("WeaponBookEnder");
		BookHunger = new ItemWeaponBookHunger("WeaponBookHunger");
		BookBattle = new ItemWeaponBookBattle("WeaponBookBattle");
		BookNature = new ItemWeaponBookNature("WeaponBookNature");
		BookWither = new ItemWeaponBookWither("WeaponBookWither");
		BookBuff = new ItemWeaponBookBuff("WeaponBookBuff");
		Debug = new ItemWeaponDebug("WeaponDebug");
		AccessoryRingSpeed = new ItemAccessoryRingSpeed("AccessoryRingSpeed");
		AccessoryRingHaste = new ItemAccessoryRingHaste("AccessoryRingHaste");
		AccessoryRingJump = new ItemAccessoryRingJump("AccessoryRingJump");
		AccessoryRingNight = new ItemAccessoryRingNight("AccessoryRingNight");
		AccessoryTrinketPoison = new ItemAccessoryTrinketPoison("AccessoryTrinketPoison");
		AccessoryTrinketWither = new ItemAccessoryTrinketWither("AccessoryTrinketWither");
		AccessoryTrinketLevitation = new ItemAccessoryTrinketLevitation("AccessoryTrinketLevitation");
		AccessoryCursed = new ItemAccessoryCursed("AccessoryCursed");
		AccessoryBauble = new ItemAccessoryBauble("AccessoryBauble");
		Card = new ItemCard("Card");

		SpawnEgg = new ItemGaiaSpawnEgg("SpawnEgg");
	}

	public static void register() {
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
				AccessoryBauble,
				Card,
				SpawnEgg
		};

		for (int i = 0; i < items.length; i++) {
			GameRegistry.registerItem(items[i], items[i].getUnlocalizedName());
		}

		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(SpawnEgg, new GaiaBehaviorDefaultDispenseItem());
	}

	/** 
	 * Registers crafting recipes
	 * @see RecipesCrafting
	 */
	public static void addRecipes() {
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.IRON_INGOT, "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.GOLD_INGOT, "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.DIAMOND, "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.EMERALD, "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald"));

		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMandrake, 1), new Object[]{FoodMandrake, Items.SUGAR, Items.EGG});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMeat, 1), new Object[]{new ItemStack(Items.FISH, 1, 0), Items.SUGAR, Items.EGG});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMeat, 1), new Object[]{new ItemStack(Items.FISH, 1, 1), Items.SUGAR, Items.EGG});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMeat, 1), new Object[]{new ItemStack(Items.FISH, 1, 2), Items.SUGAR, Items.EGG});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMeat, 1), new Object[]{new ItemStack(Items.FISH, 1, 3), Items.SUGAR, Items.EGG});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieAppleGold, 1), new Object[]{FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COAL_BLOCK, 1), new Object[]{MiscFurnaceFuel, MiscFurnaceFuel, MiscFurnaceFuel, MiscFurnaceFuel});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.WOOL, 1), new Object[]{MiscFur});
		GameRegistry.addShapelessRecipe(new ItemStack(MiscQuill, 1), new Object[]{Items.DIAMOND, Items.FEATHER});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingSpeed, 1), new Object[]{new ItemStack(MiscRing, 1, 0), Blocks.BEACON});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingHaste, 1), new Object[]{new ItemStack(MiscRing, 1, 1), Blocks.BEACON});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingJump, 1), new Object[]{new ItemStack(MiscRing, 1, 2), Blocks.BEACON});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingNight, 1), new Object[]{new ItemStack(MiscRing, 1, 3), Blocks.BEACON});
		
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryTrinketLevitation, 1), new Object[]{AccessoryCursed, Items.IRON_INGOT});
	}
	
	/** 
	 * Registers crafting recipes
	 * @see FurnaceRecipes
	 */
	public static void addFurnaceRecipes() {
		GameRegistry.addSmelting(BoxIron, new ItemStack(MiscExperience, 1, 0), 0.1F);
		GameRegistry.addSmelting(BoxGold, new ItemStack(MiscExperience, 1, 1), 0.1F);
		GameRegistry.addSmelting(BoxDiamond, new ItemStack(MiscExperience, 1, 2), 0.1F);
		GameRegistry.addSmelting(MiscFur, new ItemStack(Items.LEATHER), 0.35F);
	}

	/** 
	 * Registers Brewing ingredient recipes 
	 * @see PotionHelper
	 */
	public static void addBrews() {
		BrewingRecipeRegistry.addRecipe(getType(PotionTypes.WATER), new ItemStack(FoodNetherWart,1,0), getType(PotionTypes.AWKWARD ));
	}

	public static ItemStack getType(PotionType type) {
		return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM,1,0), type);
	}

	public static void oreRegistration() {
		OreDictionary.registerOre("nuggetIron", new ItemStack(Shard, 1, 0));
		OreDictionary.registerOre("nuggetGold", new ItemStack(Shard, 1, 1));
		OreDictionary.registerOre("nuggetDiamond", new ItemStack(Shard, 1, 2));
		OreDictionary.registerOre("nuggetEmerald", new ItemStack(Shard, 1, 3));		
		OreDictionary.registerOre("nuggetCopper", new ItemStack(Shard, 1, 4));
		OreDictionary.registerOre("nuggetSilver", new ItemStack(Shard, 1, 5));
		OreDictionary.registerOre("cropNetherWart", FoodNetherWart);
	}
}
