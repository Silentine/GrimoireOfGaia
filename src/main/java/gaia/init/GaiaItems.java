package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import gaia.delete.ItemFoodCoalfish;
import gaia.delete.ItemSpawnTame;
import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.entity.passive.EntityGaiaNPCTrader;
import gaia.entity.passive.EntityGaiaNPCWeresheep;
import gaia.items.ItemAccessoryCursed;
import gaia.items.ItemAccessoryHeadgear;
import gaia.items.ItemAccessoryCharmDamageIron;
import gaia.items.ItemAccessoryRingHaste;
import gaia.items.ItemAccessoryRingJump;
import gaia.items.ItemAccessoryRingNight;
import gaia.items.ItemAccessoryRingSpeed;
import gaia.items.ItemAccessoryTrinketLevitation;
import gaia.items.ItemAccessoryTrinketPoison;
import gaia.items.ItemAccessoryTrinketWaterBreathing;
import gaia.items.ItemAccessoryTrinketWither;
import gaia.items.ItemBagArrow;
import gaia.items.ItemBagBook;
import gaia.items.ItemBagRecord;
import gaia.items.ItemBase;
import gaia.items.ItemBox;
import gaia.items.ItemBoxDiamond;
import gaia.items.ItemBoxGold;
import gaia.items.ItemBoxHat;
import gaia.items.ItemBoxIron;
import gaia.items.ItemBoxOld;
import gaia.items.ItemChest;
import gaia.items.ItemFoodBase;
import gaia.items.ItemFoodHoney;
import gaia.items.ItemFoodMandrake;
import gaia.items.ItemFoodMonsterFeed;
import gaia.items.ItemFoodMonsterFeedPremium;
import gaia.items.ItemFoodNetherWart;
import gaia.items.ItemFoodPieAppleGold;
import gaia.items.ItemFoodPieMandrake;
import gaia.items.ItemFoodPieMeat;
import gaia.items.ItemFoodRoot;
import gaia.items.ItemFoodRottenHeart;
import gaia.items.ItemFoodSmallAppleGold;
import gaia.items.ItemFoodWither;
import gaia.items.ItemMiscBook;
import gaia.items.ItemMiscCurrency;
import gaia.items.ItemMiscExperience;
import gaia.items.ItemMiscFurnaceFuel;
import gaia.items.ItemMiscGigaGear;
import gaia.items.ItemMiscRing;
import gaia.items.ItemMiscSoulFiery;
import gaia.items.ItemMiscSoulFire;
import gaia.items.ItemPickupHeart;
import gaia.items.ItemShard;
import gaia.items.ItemShardMisc;
import gaia.items.ItemShieldProp;
import gaia.items.ItemSpawn;
import gaia.items.ItemSpawnNPC;
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
import gaia.items.ItemWeaponFan;
import gaia.items.ItemWeaponFanFire;
import gaia.items.ItemWeaponFanIce;
import gaia.items.ItemWeaponProjectileBomb;
import gaia.items.ItemWeaponProp;
import gaia.items.ItemWeaponPropEnchanted;
import gaia.items.ItemWeaponPropItemSword;
import gaia.items.ItemWeaponPropProjectile;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(GaiaReference.MOD_ID)
public class GaiaItems {
	// A
	public static final Item ACCESSORY_CURSED = Items.AIR;
	public static final Item ACCESSORY_HEADGEAR = Items.AIR;
	public static final Item ACCESSORY_HEADGEAR_MOB = Items.AIR;
	public static final Item ACCESSORY_HEADGEAR_ARROW = Items.AIR;
	public static final Item ACCESSORY_HEADGEAR_BOLT = Items.AIR;
	public static final Item ACCESSORY_HEADGEAR_DOLL = Items.AIR;
	public static final Item ACCESSORY_HEADGEAR_EARS_ELF = Items.AIR;
	public static final Item ACCESSORY_CHARM_DAMAGE_IRON = Items.AIR;
	public static final Item ACCESSORY_RING_HASTE = Items.AIR;
	public static final Item ACCESSORY_RING_JUMP = Items.AIR;
	public static final Item ACCESSORY_RING_NIGHT = Items.AIR;
	public static final Item ACCESSORY_RING_SPEED = Items.AIR;
	public static final Item ACCESSORY_TRINKET_LEVITATION = Items.AIR;
	public static final Item ACCESSORY_TRINKET_POISON = Items.AIR;
	public static final Item ACCESSORY_TRINKET_WATER_BREATHING = Items.AIR;
	public static final Item ACCESSORY_TRINKET_WITHER = Items.AIR;
	// B
	public static final Item BOX = Items.AIR;
	public static final Item BAG_ARROW = Items.AIR;
	public static final Item BAG_BOOK = Items.AIR;
	public static final Item BAG_RECORD = Items.AIR;
	public static final Item BOOK_BUFF = Items.AIR;
	public static final Item BOX_DIAMOND = Items.AIR;
	public static final Item BOX_GOLD = Items.AIR;
	public static final Item BOX_HAT = Items.AIR;
	public static final Item BOX_IRON = Items.AIR;
	public static final Item BOX_OLD = Items.AIR;
	// C
	public static final Item CHEST = Items.AIR;
	// D
	public static final Item DEBUG_ITEM = Items.AIR;
	public static final Item DEBUG_WEAPON = Items.AIR;
	// F
	public static final Item FOOD_COALFISH = Items.AIR;
	public static final Item FOOD_HONEY = Items.AIR;
	public static final Item FOOD_MANDRAKE = Items.AIR;
	public static final Item FOOD_MEAT = Items.AIR;
	public static final Item FOOD_MONSTER_FEED = Items.AIR;
	public static final Item FOOD_MONSTER_FEED_PREMIUM = Items.AIR;
	public static final Item FOOD_NETHER_WART = Items.AIR;
	public static final Item FOOD_PIE_APPLE_GOLD = Items.AIR;
	public static final Item FOOD_PIE_MANDRAKE = Items.AIR;
	public static final Item FOOD_PIE_MEAT = Items.AIR;
	public static final Item FOOD_ROOT = Items.AIR;
	public static final Item FOOD_ROTTEN_HEART = Items.AIR;
	public static final Item FOOD_SMALL_APPLE_GOLD = Items.AIR;
	public static final Item FOOD_WITHER = Items.AIR;
	// M
	public static final Item MISC_BOOK = Items.AIR;
	public static final Item MISC_CURRENCY = Items.AIR;
	public static final Item MISC_ELYTRA  = Items.AIR;
	public static final Item MISC_EXPERIENCE = Items.AIR;
	public static final Item MISC_FUR = Items.AIR;
	public static final Item MISC_FURNACE_FUEL = Items.AIR;
	public static final Item MISC_GIGA_GEAR = Items.AIR;
	public static final Item MISC_QUILL = Items.AIR;
	public static final Item MISC_PEARL = Items.AIR;
	public static final Item MISC_RING = Items.AIR;
	public static final Item MISC_SOUL_FIRE = Items.AIR;
	public static final Item MISC_SOUL_FIERY = Items.AIR;
	// P
	public static final Item PICKUP_HEART = Items.AIR;
	// S
	public static final Item SHARD = Items.AIR;
	public static final Item SHARD_MISC = Items.AIR;
	public static final Item SHIELD_PROP = Items.AIR;
	public static final Item SPAWN = Items.AIR;
	public static final Item SPAWN_WERESHEEP = Items.AIR;
	public static final Item SPAWN_CREEPER_GIRL = Items.AIR;
	public static final Item SPAWN_ENDER_GIRL = Items.AIR;
	public static final Item SPAWN_HOLSTAURUS = Items.AIR;
	public static final Item SPAWN_SLIME_GIRL = Items.AIR;
	public static final Item SPAWN_TAME = Items.AIR;
	public static final Item SPAWN_TRADER = Items.AIR;
	// W
	public static final Item WEAPON_BOOK = Items.AIR;
	public static final Item WEAPON_BOOK_BATTLE = Items.AIR;
	public static final Item WEAPON_BOOK_BUFF = Items.AIR;
	public static final Item WEAPON_BOOK_ENDER = Items.AIR;
	public static final Item WEAPON_BOOK_FREEZING = Items.AIR;
	public static final Item WEAPON_BOOK_HUNGER = Items.AIR;
	public static final Item WEAPON_BOOK_METAL = Items.AIR;
	public static final Item WEAPON_BOOK_NATURE = Items.AIR;
	public static final Item WEAPON_BOOK_NIGHTMARE = Items.AIR;
	public static final Item WEAPON_BOOK_WITHER = Items.AIR;
	public static final Item WEAPON_FAN = Items.AIR;
	public static final Item WEAPON_FAN_FIRE = Items.AIR;
	public static final Item WEAPON_FAN_ICE = Items.AIR;
	public static final Item WEAPON_PROJECTILE_BOMB = Items.AIR;
	public static final Item WEAPON_PROP = Items.AIR;
	public static final Item WEAPON_PROP_ENCHANTED = Items.AIR;
	public static final Item WEAPON_PROP_PROJECTILE_BUBBLE = Items.AIR;
	public static final Item WEAPON_PROP_PROJECTILE_MAGIC = Items.AIR;
	public static final Item WEAPON_PROP_PROJECTILE_MAGIC_RANDOM = Items.AIR;
	public static final Item WEAPON_PROP_PROJECTILE_POISON = Items.AIR;
	public static final Item WEAPON_PROP_PROJECTILE_WEB = Items.AIR;
	public static final Item WEAPON_PROP_SWORD_WOOD = Items.AIR;
	public static final Item WEAPON_PROP_SWORD_STONE = Items.AIR;
	public static final Item WEAPON_PROP_SWORD_IRON = Items.AIR;
	public static final Item WEAPON_PROP_SWORD_GOLD = Items.AIR;
	public static final Item WEAPON_PROP_AXE_WOOD = Items.AIR;
	public static final Item WEAPON_PROP_AXE_STONE = Items.AIR;
	public static final Item WEAPON_PROP_AXE_IRON = Items.AIR;
	public static final Item WEAPON_PROP_AXE_GOLD = Items.AIR;
	public static final Item WEAPON_PROP_DAGGER_METAL = Items.AIR;
	public static final Item WEAPON_PROP_BROOM = Items.AIR;
	public static final Item WEAPON_PROP_HAMMER_MINOTAUR = Items.AIR;

	public static ToolMaterial MATERIAL_PROP = EnumHelper.addToolMaterial("material_prop", 0, 250, 6.0F, -3.0F, 36);
	public static ToolMaterial MATERIAL_BOOK = EnumHelper.addToolMaterial("material_book", 2, 780, 6.0F, 2.0F, 22);

	private GaiaItems() {
	}

	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class RegistrationHandler {

		private RegistrationHandler() {
		}

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			Gaia.LOGGER.info("Registering items...");

			final IForgeRegistry<Item> registry = event.getRegistry();

//			registry.register(new ItemDebugItem());
//			registry.register(new ItemDebugWeapon());
			registry.register(new ItemShard());
			registry.register(new ItemShardMisc());
			registry.register(new ItemFoodBase("food_meat", 6, 1.2F, true));
			registry.register(new ItemFoodRottenHeart());
			registry.register(new ItemFoodRoot());
			registry.register(new ItemFoodCoalfish());
			registry.register(new ItemFoodNetherWart());
			registry.register(new ItemFoodHoney());
			registry.register(new ItemFoodSmallAppleGold());
			registry.register(new ItemFoodMandrake());
			registry.register(new ItemFoodWither());
			registry.register(new ItemFoodMonsterFeed());
			registry.register(new ItemFoodMonsterFeedPremium());
			registry.register(new ItemFoodPieMandrake());
			registry.register(new ItemFoodPieMeat());
			registry.register(new ItemFoodPieAppleGold());
			registry.register(new ItemMiscSoulFire());
			registry.register(new ItemMiscSoulFiery());
			registry.register(new ItemMiscGigaGear());
			registry.register(new ItemMiscExperience());
			registry.register(new ItemMiscBook());
			registry.register(new ItemBase("misc_fur"));
			registry.register(new ItemBase("misc_quill"));
			registry.register(new ItemBase("misc_pearl"));
			registry.register(new ItemBase("misc_elytra"));
			registry.register(new ItemMiscRing());
			registry.register(new ItemMiscFurnaceFuel());
			registry.register(new ItemMiscCurrency());
			registry.register(new ItemSpawn());
			registry.register(new ItemSpawnNPC("spawn_creeper_girl", EnumRarity.RARE, EntityGaiaNPCCreeperGirl::new));
			registry.register(new ItemSpawnNPC("spawn_slime_girl", EnumRarity.RARE, EntityGaiaNPCSlimeGirl::new));
			registry.register(new ItemSpawnNPC("spawn_ender_girl", EnumRarity.RARE, EntityGaiaNPCEnderGirl::new));
			registry.register(new ItemSpawnNPC("spawn_trader", EnumRarity.RARE, EntityGaiaNPCTrader::new));
			registry.register(new ItemSpawnNPC("spawn_holstaurus", EnumRarity.RARE, EntityGaiaNPCHolstaurus::new));
			registry.register(new ItemSpawnNPC("spawn_weresheep", EnumRarity.EPIC, EntityGaiaNPCWeresheep::new));
			registry.register(new ItemSpawnTame());
			registry.register(new ItemBoxIron());
			registry.register(new ItemBoxGold());
			registry.register(new ItemBoxDiamond());
			registry.register(new ItemBox());
			registry.register(new ItemBagBook());
			registry.register(new ItemBagRecord());
			registry.register(new ItemBagArrow());
			registry.register(new ItemBoxOld());
			registry.register(new ItemBoxHat());
			registry.register(new ItemChest());
			registry.register(new ItemWeaponProp());
			registry.register(new ItemWeaponPropProjectile("weapon_prop_projectile_bubble"));
			registry.register(new ItemWeaponPropProjectile("weapon_prop_projectile_magic"));
			registry.register(new ItemWeaponPropProjectile("weapon_prop_projectile_magic_random"));
			registry.register(new ItemWeaponPropProjectile("weapon_prop_projectile_poison"));
			registry.register(new ItemWeaponPropProjectile("weapon_prop_projectile_web"));
			registry.register(new ItemWeaponPropEnchanted());
			registry.register(new ItemShieldProp());
			registry.register(new ItemWeaponFan("weapon_fan"));
			registry.register(new ItemWeaponFanIce());
			registry.register(new ItemWeaponFanFire());
			registry.register(new ItemWeaponBook(MATERIAL_BOOK, "weapon_book"));
			registry.register(new ItemWeaponBookFreezing(MATERIAL_BOOK, "weapon_book_freezing"));
			registry.register(new ItemWeaponBookNightmare(MATERIAL_BOOK, "weapon_book_nightmare"));
			registry.register(new ItemWeaponBookMetal(MATERIAL_BOOK, "weapon_book_metal"));
			registry.register(new ItemWeaponBookEnder(MATERIAL_BOOK, "weapon_book_ender"));
			registry.register(new ItemWeaponBookHunger(MATERIAL_BOOK, "weapon_book_hunger"));
			registry.register(new ItemWeaponBookBattle(MATERIAL_BOOK, "weapon_book_battle"));
			registry.register(new ItemWeaponBookNature(MATERIAL_BOOK, "weapon_book_nature"));
			registry.register(new ItemWeaponBookWither(MATERIAL_BOOK, "weapon_book_wither"));
			registry.register(new ItemWeaponBookBuff("weapon_book_buff"));
			registry.register(new ItemWeaponProjectileBomb("weapon_projectile_bomb"));
			registry.register(new ItemAccessoryCursed());
			registry.register(new ItemAccessoryCharmDamageIron());
			registry.register(new ItemAccessoryRingHaste());
			registry.register(new ItemAccessoryRingJump());
			registry.register(new ItemAccessoryRingNight());
			registry.register(new ItemAccessoryRingSpeed());
			registry.register(new ItemAccessoryTrinketLevitation());
			registry.register(new ItemAccessoryTrinketPoison());
			registry.register(new ItemAccessoryTrinketWaterBreathing());
			registry.register(new ItemAccessoryTrinketWither());
			registry.register(new ItemAccessoryHeadgear("accessory_headgear"));
			registry.register(new ItemAccessoryHeadgear("accessory_headgear_mob"));
			registry.register(new ItemAccessoryHeadgear("accessory_headgear_bolt"));
			registry.register(new ItemAccessoryHeadgear("accessory_headgear_arrow"));
			registry.register(new ItemAccessoryHeadgear("accessory_headgear_doll"));
			registry.register(new ItemAccessoryHeadgear("accessory_headgear_ears_elf"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_sword_wood"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_sword_stone"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_sword_iron"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_sword_gold"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_axe_wood"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_axe_stone"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_axe_iron"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_axe_gold"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_dagger_metal"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_broom"));
			registry.register(new ItemWeaponPropItemSword(MATERIAL_PROP, "weapon_prop_hammer_minotaur"));
			registry.register(new ItemPickupHeart());
			
			Gaia.LOGGER.info("Item registration complete.");
		}

		public static void registerOres() {
			OreDictionary.registerOre("nuggetIron", new ItemStack(SHARD, 1, 0));
			OreDictionary.registerOre("nuggetGold", new ItemStack(SHARD, 1, 1));
			OreDictionary.registerOre("nuggetDiamond", new ItemStack(SHARD, 1, 2));
			OreDictionary.registerOre("nuggetEmerald", new ItemStack(SHARD, 1, 3));
			OreDictionary.registerOre("nuggetCopper", new ItemStack(SHARD, 1, 4));
			OreDictionary.registerOre("nuggetSilver", new ItemStack(SHARD, 1, 5));
			OreDictionary.registerOre("cropNetherWart", FOOD_NETHER_WART);
		}
	}
}
