package gaia.init;

import gaia.GaiaReference;
import gaia.items.GaiaDispenserBehaviorMobEgg;
import gaia.items.ItemAccessoryCursed;
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
import gaia.items.ItemFoodCoalfish;
import gaia.items.ItemFoodIce;
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
import gaia.items.ItemMiscFurnaceFuel;
import gaia.items.ItemMiscGigaGear;
import gaia.items.ItemMiscRing;
import gaia.items.ItemMiscSoulFiery;
import gaia.items.ItemMiscSoulFire;
import gaia.items.ItemMiscWeaponEnchanted;
import gaia.items.ItemShard;
import gaia.items.ItemShardMisc;
import gaia.items.ItemSpawn;
import gaia.items.ItemSpawnCreeperGirl;
import gaia.items.ItemSpawnEnderGirl;
import gaia.items.ItemSpawnHolstaurus;
import gaia.items.ItemSpawnSlimeGirl;
import gaia.items.ItemSpawnTrader;
import gaia.items.ItemSpawnWeresheep;
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

import java.util.List;
import java.util.Locale;

import net.minecraft.block.BlockDispenser;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class GaiaItem {
	public static Item Shard;
	//TODO public static Item ShardMisc;
	public static Item FoodMeat;
	public static Item FoodRottenHeart;
	public static Item FoodRoot;
	public static Item FoodIce;
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
	public static Item MiscBook;
	public static Item MiscRing;
	public static Item MiscFurnaceFuel;
	public static Item MiscCurrency;
	public static Item MiscWeaponEnchanted;
	public static Item Spawn;
	public static Item SpawnCreeperGirl;
	public static Item SpawnSlimeGirl;
	public static Item SpawnEnderGirl;
	public static Item SpawnTrader;
	public static Item SpawnHolstaurus;
	public static Item SpawnWeresheep;
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
	public static Item AccessoryCursed;
	public static Item SpawnEgg;

	public static void init() {
		Shard = new ItemShard("Shard");		
		//TODO ShardMisc = new ItemShardMisc("ShardMisc");
		FoodMeat = new ItemFoodMeat(6, 0.6F, true, "FoodMeat");		
		FoodRottenHeart = new ItemFoodRottenHeart(4, 0.0F, true, "FoodRottenHeart").setAlwaysEdible();
		FoodRoot = (new ItemFoodRoot(4, 0.0F, false, "FoodRoot")).setAlwaysEdible();
		FoodIce = (new ItemFoodIce(4, 0.0F, true, "FoodIce")).setAlwaysEdible();
		FoodCoalfish = new ItemFoodCoalfish(4, 0.4F, true, "FoodCoalfish");
		FoodNetherWart = (new ItemFoodNetherWart(4, 0.4F, false, "FoodNetherWart"));
		FoodSmallAppleGold = (new ItemFoodSmallAppleGold(1, 0.4F, false, "FoodSmallAppleGold")).setAlwaysEdible();
		FoodMandrake = (new ItemFoodMandrake(0, 0.0F, false, "FoodMandrake")).setAlwaysEdible();
		FoodWither = new ItemFoodWither(8, 0.8F, true, "FoodWitherMeat");
		FoodPieMandrake = (new ItemFoodPieMandrake(8, 0.8F, false, "FoodPieMandrake"));
		FoodPieMeat = (new ItemFoodPieMeat(12, 0.8F, true, "FoodPieMeat"));
		FoodPieAppleGold = (new ItemFoodPieAppleGold(12, 0.8F, true, "FoodPieAppleGold"));
		MiscSoulFire = new ItemMiscSoulFire("MiscSoulFire");
		MiscSoulFiery = new ItemMiscSoulFiery("MiscSoulFiery");
		MiscGigaGear = new ItemMiscGigaGear("MiscGigaGear");		
		MiscBook = new ItemMiscBook("MiscBook");		
		MiscRing = new ItemMiscRing("MiscRing");
		MiscFurnaceFuel = new ItemMiscFurnaceFuel("MiscFurnaceFuel");
		MiscCurrency = new ItemMiscCurrency("MiscCurrency");
		MiscWeaponEnchanted = new ItemMiscWeaponEnchanted("MiscWeaponEnchanted");
		Spawn = new ItemSpawn("Spawn");
		SpawnCreeperGirl = new ItemSpawnCreeperGirl("SpawnCreeperGirl");
		SpawnSlimeGirl = new ItemSpawnSlimeGirl("SpawnSlimeGirl");
		SpawnEnderGirl = new ItemSpawnEnderGirl("SpawnEnderGirl");
		SpawnTrader = new ItemSpawnTrader("SpawnTrader");
		SpawnHolstaurus = new ItemSpawnHolstaurus("SpawnHolstaurus");
		SpawnWeresheep = new ItemSpawnWeresheep("SpawnWeresheep");
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
		AccessoryCursed = new ItemAccessoryCursed("AccessoryCursed");
		
		SpawnEgg = new ItemGaiaSpawnEgg();
	}
	
	public static void register() {
		Item[] items = new Item[] { 
				Shard,
				//TODO ShardMisc, 
				FoodMeat, 				
				FoodRottenHeart, 
				FoodRoot, 
				FoodIce, 
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
				MiscBook, 
				MiscRing, 
				MiscFurnaceFuel,
				MiscCurrency,
				MiscWeaponEnchanted,
				Spawn, 
				SpawnCreeperGirl,
				SpawnEnderGirl, 
				SpawnSlimeGirl,
				SpawnTrader, 
				SpawnHolstaurus,
				SpawnWeresheep,
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
				AccessoryCursed,
				SpawnEgg
				
		};
		for (int i = 0; i < items.length; i++) {
			GameRegistry.registerItem(items[i], items[i].getUnlocalizedName());
		}
		
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(SpawnEgg, new GaiaDispenserBehaviorMobEgg());
	}
	/** Register Crafting Recipes **/
	public static void addRecipes() {
//		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 1), new Object[]{new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0), new ItemStack(Shard, 1, 0)});
//		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 1), new Object[]{new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1), new ItemStack(Shard, 1, 1)});
//		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), new Object[]{new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2), new ItemStack(Shard, 1, 2)});
//		GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 1), new Object[]{new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3), new ItemStack(Shard, 1, 3)});
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.IRON_INGOT, "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron", "nuggetIron"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.GOLD_INGOT, "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.DIAMOND, "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(Items.EMERALD, "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald", "nuggetEmerald"));

		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMandrake, 1), new Object[]{FoodMandrake, Items.SUGAR, Items.EGG});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieMeat, 1), new Object[]{FoodRottenHeart, Items.ROTTEN_FLESH, Items.ROTTEN_FLESH, Items.ROTTEN_FLESH, Items.SUGAR, Items.EGG});
		GameRegistry.addShapelessRecipe(new ItemStack(FoodPieAppleGold, 1), new Object[]{FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold, FoodSmallAppleGold});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COAL_BLOCK, 1), new Object[]{MiscFurnaceFuel, MiscFurnaceFuel, MiscFurnaceFuel, MiscFurnaceFuel});
		GameRegistry.addShapelessRecipe(new ItemStack(FanIce, 1), new Object[]{new ItemStack(MiscWeaponEnchanted, 1, 0), Items.SNOWBALL});
		GameRegistry.addShapelessRecipe(new ItemStack(FanFire, 1), new Object[]{new ItemStack(MiscWeaponEnchanted, 1, 1), Items.COAL});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingSpeed, 1), new Object[]{new ItemStack(MiscRing, 1, 0), Blocks.BEACON});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingHaste, 1), new Object[]{new ItemStack(MiscRing, 1, 1), Blocks.BEACON});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingJump, 1), new Object[]{new ItemStack(MiscRing, 1, 2), Blocks.BEACON});
		GameRegistry.addShapelessRecipe(new ItemStack(AccessoryRingNight, 1), new Object[]{new ItemStack(MiscRing, 1, 3), Blocks.BEACON});
		
	}
	/** Registers Brewing ingredient recipes **/
	public static void addBrews(){
		BrewingRecipeRegistry.addRecipe(get_Type(PotionTypes.WATER), new ItemStack(FoodNetherWart,1,0), get_Type(PotionTypes.AWKWARD ));
	
	}
	public static ItemStack get_Type(PotionType type){
		return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM,1,0), type);
	}
	

	public static void oreRegistration() {
		OreDictionary.registerOre("nuggetIron", new ItemStack(Shard, 1, 0));
		OreDictionary.registerOre("nuggetGold", new ItemStack(Shard, 1, 1));
		OreDictionary.registerOre("nuggetDiamond", new ItemStack(Shard, 1, 2));
		OreDictionary.registerOre("nuggetEmerald", new ItemStack(Shard, 1, 3));		
		OreDictionary.registerOre("nuggetCopper", new ItemStack(Shard, 1, 4));
		OreDictionary.registerOre("nuggetSilver", new ItemStack(Shard, 1, 5));
		//TODO
		//OreDictionary.registerOre("nuggetCopper", new ItemStack(ShardMisc, 1, 0));
		//OreDictionary.registerOre("nuggetSilver", new ItemStack(ShardMisc, 1, 1));
		OreDictionary.registerOre("cropNetherWart", FoodNetherWart);
		
		
	}
	
	public static void registerRenders() {
		registerRender(Shard);		
		//TODO registerRender(ShardMisc);
		registerRender(FoodMeat);
		registerRender(FoodRottenHeart);
		registerRender(FoodRoot);
		registerRender(FoodIce);
		registerRender(FoodCoalfish);
		registerRender(FoodNetherWart);
		registerRender(FoodSmallAppleGold);
		registerRender(FoodMandrake);
		registerRender(FoodWither);
		registerRender(FoodPieMandrake);
		registerRender(FoodPieMeat);
		registerRender(FoodPieAppleGold);
		registerRender(MiscSoulFire);
		registerRender(MiscSoulFiery);
		registerRender(MiscGigaGear);
		registerRender(MiscBook);
		registerRender(MiscRing);
		registerRender(MiscFurnaceFuel);
		registerRender(MiscCurrency);
		registerRender(MiscWeaponEnchanted);
		registerRender(Spawn);
		registerRender(SpawnCreeperGirl);
		registerRender(SpawnSlimeGirl);
		registerRender(SpawnEnderGirl);
		registerRender(SpawnTrader);
		registerRender(SpawnHolstaurus);
		registerRender(SpawnWeresheep);
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
		registerRender(AccessoryCursed);
 		registerRender(SpawnEgg);
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GaiaReference.MOD_ID + ":" + item.getUnlocalizedName().substring(20).toLowerCase(Locale.US), "inventory"));
	}
}
