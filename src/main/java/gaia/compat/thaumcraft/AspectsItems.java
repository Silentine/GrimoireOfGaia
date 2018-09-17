package gaia.compat.thaumcraft;

import static gaia.init.GaiaBlocks.BUST_SPHINX;
import static gaia.init.GaiaBlocks.BUST_VALKYRIE;
import static gaia.init.GaiaBlocks.BUST_VAMPIRE;
import static gaia.init.GaiaBlocks.DOLL_CREEPER_GIRL;
import static gaia.init.GaiaBlocks.DOLL_ENDER_GIRL;
import static gaia.init.GaiaBlocks.DOLL_MAID;
import static gaia.init.GaiaBlocks.DOLL_SLIME_GIRL;
import static gaia.init.GaiaItems.ACCESSORY_CURSED;
import static gaia.init.GaiaItems.ACCESSORY_RING_HASTE;
import static gaia.init.GaiaItems.ACCESSORY_RING_JUMP;
import static gaia.init.GaiaItems.ACCESSORY_RING_NIGHT;
import static gaia.init.GaiaItems.ACCESSORY_RING_SPEED;
import static gaia.init.GaiaItems.ACCESSORY_TRINKET_LEVITATION;
import static gaia.init.GaiaItems.ACCESSORY_TRINKET_POISON;
import static gaia.init.GaiaItems.ACCESSORY_TRINKET_WITHER;
import static gaia.init.GaiaItems.BAG_ARROW;
import static gaia.init.GaiaItems.BAG_BOOK;
import static gaia.init.GaiaItems.BAG_RECORD;
import static gaia.init.GaiaItems.BOX;
import static gaia.init.GaiaItems.BOX_DIAMOND;
import static gaia.init.GaiaItems.BOX_GOLD;
import static gaia.init.GaiaItems.BOX_IRON;
import static gaia.init.GaiaItems.BOX_OLD;
import static gaia.init.GaiaItems.CHEST;
import static gaia.init.GaiaItems.FOOD_COALFISH;
import static gaia.init.GaiaItems.FOOD_HONEY;
import static gaia.init.GaiaItems.FOOD_MANDRAKE;
import static gaia.init.GaiaItems.FOOD_MEAT;
import static gaia.init.GaiaItems.FOOD_NETHER_WART;
import static gaia.init.GaiaItems.FOOD_PIE_APPLE_GOLD;
import static gaia.init.GaiaItems.FOOD_PIE_MANDRAKE;
import static gaia.init.GaiaItems.FOOD_PIE_MEAT;
import static gaia.init.GaiaItems.FOOD_ROOT;
import static gaia.init.GaiaItems.FOOD_ROTTEN_HEART;
import static gaia.init.GaiaItems.FOOD_SMALL_APPLE_GOLD;
import static gaia.init.GaiaItems.FOOD_WITHER;
import static gaia.init.GaiaItems.MISC_BOOK;
import static gaia.init.GaiaItems.MISC_FUR;
import static gaia.init.GaiaItems.MISC_FURNACE_FUEL;
import static gaia.init.GaiaItems.MISC_GIGA_GEAR;
import static gaia.init.GaiaItems.MISC_RING;
import static gaia.init.GaiaItems.MISC_SOUL_FIERY;
import static gaia.init.GaiaItems.MISC_SOUL_FIRE;
import static gaia.init.GaiaItems.SHARD;
import static gaia.init.GaiaItems.SHARD_MISC;
import static gaia.init.GaiaItems.SPAWN;
import static gaia.init.GaiaItems.SPAWN_CREEPER_GIRL;
import static gaia.init.GaiaItems.SPAWN_ENDER_GIRL;
import static gaia.init.GaiaItems.SPAWN_HOLSTAURUS;
import static gaia.init.GaiaItems.SPAWN_SLIME_GIRL;
import static gaia.init.GaiaItems.SPAWN_TAME;
import static gaia.init.GaiaItems.SPAWN_TRADER;
import static gaia.init.GaiaItems.SPAWN_WERESHEEP;
import static gaia.init.GaiaItems.WEAPON_BOOK_BATTLE;
import static gaia.init.GaiaItems.WEAPON_BOOK_BUFF;
import static gaia.init.GaiaItems.WEAPON_BOOK_ENDER;
import static gaia.init.GaiaItems.WEAPON_BOOK_FREEZING;
import static gaia.init.GaiaItems.WEAPON_BOOK_HUNGER;
import static gaia.init.GaiaItems.WEAPON_BOOK_METAL;
import static gaia.init.GaiaItems.WEAPON_BOOK_NATURE;
import static gaia.init.GaiaItems.WEAPON_BOOK_NIGHTMARE;
import static gaia.init.GaiaItems.WEAPON_BOOK_WITHER;
import static gaia.init.GaiaItems.WEAPON_FAN_FIRE;
import static gaia.init.GaiaItems.WEAPON_FAN_ICE;

import gaia.Gaia;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;

@SuppressWarnings("unused")
public class AspectsItems {
	private AspectsItems() {
	}

	@SubscribeEvent
	public static void registerAspects(AspectRegistryEvent event) {
		Gaia.LOGGER.info("Registering Item Aspects");

		// Items
		// A
		event.register.registerObjectTag(new ItemStack(ACCESSORY_CURSED), (new AspectList())
				.add(Aspect.METAL, 16)
				.add(Aspect.BEAST, 16)
				.add(Aspect.ENTROPY, 16));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_RING_HASTE), (new AspectList())
				.add(Aspect.PROTECT, 4)
				.add(Aspect.METAL, 4)
				.add(Aspect.ORDER, 16)
				.add(Aspect.ELDRITCH, 12)
				.add(Aspect.MOTION, 16));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_RING_JUMP), (new AspectList())
				.add(Aspect.PROTECT, 4)
				.add(Aspect.METAL, 4)
				.add(Aspect.ORDER, 16)
				.add(Aspect.ELDRITCH, 12)
				.add(Aspect.FLIGHT, 16));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_RING_NIGHT), (new AspectList())
				.add(Aspect.PROTECT, 4)
				.add(Aspect.METAL, 4)
				.add(Aspect.ORDER, 16)
				.add(Aspect.ELDRITCH, 12)
				.add(Aspect.SENSES, 16));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_RING_SPEED), (new AspectList())
				.add(Aspect.PROTECT, 4)
				.add(Aspect.METAL, 4)
				.add(Aspect.ORDER, 16)
				.add(Aspect.ELDRITCH, 12)
				.add(Aspect.ENERGY, 16));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_TRINKET_LEVITATION), (new AspectList())
				.add(Aspect.METAL, 12)
				.add(Aspect.EARTH, 16)
				.add(Aspect.MOTION, 4));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_TRINKET_POISON), (new AspectList())
				.add(Aspect.METAL, 2)
				.add(Aspect.DEATH, 8)
				.add(Aspect.PLANT, 8));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_TRINKET_WITHER), (new AspectList())
				.add(Aspect.METAL, 2)
				.add(Aspect.DEATH, 6)
				.add(Aspect.DARKNESS, 8)
				.add(Aspect.ENTROPY, 2));
		// B
		event.register.registerObjectTag(new ItemStack(BOX, 1, 0), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.DESIRE, 4)
				.add(Aspect.PLANT, 8));

		event.register.registerObjectTag(new ItemStack(BOX, 1, 1), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.DESIRE, 4));

		event.register.registerObjectTag(new ItemStack(BOX, 1, 2), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.DESIRE, 4));

		event.register.registerObjectTag(new ItemStack(BAG_ARROW), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.EARTH, 8)
				.add(Aspect.TOOL, 8)
				.add(Aspect.FLIGHT, 8)
				.add(Aspect.AIR, 8));

		event.register.registerObjectTag(new ItemStack(BAG_BOOK), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.MIND, 8));

		event.register.registerObjectTag(new ItemStack(BOX_DIAMOND), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.CRYSTAL, 8)
				.add(Aspect.DESIRE, 8));

		event.register.registerObjectTag(new ItemStack(BOX_GOLD), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.METAL, 6)
				.add(Aspect.DESIRE, 6));

		event.register.registerObjectTag(new ItemStack(BOX_IRON), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.METAL, 8));

		event.register.registerObjectTag(new ItemStack(BOX_OLD), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.DESIRE, 4));

		event.register.registerObjectTag(new ItemStack(BAG_RECORD), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.SENSES, 4)
				.add(Aspect.AIR, 4));
		// C
		event.register.registerObjectTag(new ItemStack(CHEST, 1, 0), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.DESIRE, 4)
				.add(Aspect.PLANT, 8));

		event.register.registerObjectTag(new ItemStack(CHEST, 1, 1), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.DESIRE, 4)
				.add(Aspect.ENTROPY, 8));

		event.register.registerObjectTag(new ItemStack(CHEST, 1, 2), (new AspectList())
				.add(Aspect.VOID, 4)
				.add(Aspect.DESIRE, 4)
				.add(Aspect.ORDER, 8));
		// F
		event.register.registerObjectTag(new ItemStack(FOOD_COALFISH), (new AspectList())
				.add(Aspect.BEAST, 2)
				.add(Aspect.LIFE, 1)
				.add(Aspect.FIRE, 1));
		
		event.register.registerObjectTag(new ItemStack(FOOD_HONEY), (new AspectList())
				.add(Aspect.PLANT, 2)
				.add(Aspect.LIFE, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_MANDRAKE), (new AspectList())
				.add(Aspect.PLANT, 1)
				.add(Aspect.LIFE, 2)
				.add(Aspect.SOUL, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_MEAT), (new AspectList())
				.add(Aspect.LIFE, 2)
				.add(Aspect.CRAFT, 1)
				.add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_NETHER_WART), (new AspectList())
				.add(Aspect.ALCHEMY, 4)
				.add(Aspect.FLUX, 4)
				.add(Aspect.PLANT, 2)
				.add(Aspect.WATER, 2));

		event.register.registerObjectTag(new ItemStack(FOOD_PIE_APPLE_GOLD), (new AspectList())
				.add(Aspect.METAL, 32)
				.add(Aspect.DESIRE, 32)
				.add(Aspect.LIFE, 16)
				.add(Aspect.MOTION, 16)
				.add(Aspect.PLANT, 4));

		event.register.registerObjectTag(new ItemStack(FOOD_PIE_MANDRAKE), (new AspectList())
				.add(Aspect.LIFE, 2)
				.add(Aspect.DESIRE, 1)
				.add(Aspect.PLANT, 1)
				.add(Aspect.SENSES, 1)
				.add(Aspect.WATER, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_PIE_MEAT), (new AspectList())
				.add(Aspect.LIFE, 2)
				.add(Aspect.DESIRE, 1)
				.add(Aspect.MAN, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_ROOT), (new AspectList())
				.add(Aspect.PLANT, 1)
				.add(Aspect.LIFE, 2));

		event.register.registerObjectTag(new ItemStack(FOOD_ROTTEN_HEART), (new AspectList())
				.add(Aspect.LIFE, 3)
				.add(Aspect.MAN, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_SMALL_APPLE_GOLD), (new AspectList())
				.add(Aspect.METAL, 4)
				.add(Aspect.DESIRE, 4)
				.add(Aspect.LIFE, 2)
				.add(Aspect.MOTION, 1)
				.add(Aspect.PLANT, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_WITHER), (new AspectList())
				.add(Aspect.MIND, 2)
				.add(Aspect.LIFE, 2)
				.add(Aspect.UNDEAD, 2)
				.add(Aspect.DARKNESS, 2));
		// M
		event.register.registerObjectTag(new ItemStack(MISC_BOOK), (new AspectList())
				.add(Aspect.MIND, 24));

		event.register.registerObjectTag(new ItemStack(MISC_FUR), (new AspectList())
				.add(Aspect.BEAST, 4)
				.add(Aspect.PROTECT, 4)
				.add(Aspect.COLD, 2));

		event.register.registerObjectTag(new ItemStack(MISC_FURNACE_FUEL), (new AspectList())
				.add(Aspect.MOTION, 8)
				.add(Aspect.FIRE, 8));

		event.register.registerObjectTag(new ItemStack(MISC_GIGA_GEAR), (new AspectList())
				.add(Aspect.FIRE, 32)
				.add(Aspect.ENERGY, 32)
				.add(Aspect.MECHANISM, 24));

		event.register.registerObjectTag(new ItemStack(MISC_RING, 1, 0), (new AspectList())
				.add(Aspect.METAL, 4)
				.add(Aspect.PROTECT, 16));

		event.register.registerObjectTag(new ItemStack(MISC_RING, 1, 1), (new AspectList())
				.add(Aspect.METAL, 4)
				.add(Aspect.PROTECT, 16));

		event.register.registerObjectTag(new ItemStack(MISC_RING, 1, 2), (new AspectList())
				.add(Aspect.METAL, 4)
				.add(Aspect.PROTECT, 16));

		event.register.registerObjectTag(new ItemStack(MISC_RING, 1, 3), (new AspectList())
				.add(Aspect.METAL, 4)
				.add(Aspect.PROTECT, 16));

		event.register.registerObjectTag(new ItemStack(MISC_SOUL_FIRE), (new AspectList())
				.add(Aspect.FIRE, 2)
				.add(Aspect.TRAP, 1)
				.add(Aspect.SOUL, 1));

		event.register.registerObjectTag(new ItemStack(MISC_SOUL_FIERY), (new AspectList())
				.add(Aspect.FIRE, 4)
				.add(Aspect.TRAP, 2)
				.add(Aspect.SOUL, 2));
		// S
		event.register.registerObjectTag(new ItemStack(SHARD, 1, 0), (new AspectList())
				.add(Aspect.METAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 1), (new AspectList())
				.add(Aspect.METAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 2), (new AspectList())
				.add(Aspect.CRYSTAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 3), (new AspectList())
				.add(Aspect.CRYSTAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 4), (new AspectList())
				.add(Aspect.METAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 5), (new AspectList())
				.add(Aspect.METAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD_MISC, 1, 0), (new AspectList())
				.add(Aspect.LIFE, 6)
				.add(Aspect.ORDER, 2)
				.add(Aspect.ENTROPY, 2)
				.add(Aspect.UNDEAD, 2));

		event.register.registerObjectTag(new ItemStack(SPAWN), (new AspectList())
				.add(Aspect.BEAST, 12)
				.add(Aspect.LIFE, 4)
				.add(Aspect.VOID, 2));

		event.register.registerObjectTag(new ItemStack(SPAWN_WERESHEEP), (new AspectList())
				.add(Aspect.BEAST, 16)
				.add(Aspect.LIFE, 4)
				.add(Aspect.CRAFT, 1));

		event.register.registerObjectTag(new ItemStack(SPAWN_CREEPER_GIRL), (new AspectList())
				.add(Aspect.BEAST, 8)
				.add(Aspect.LIFE, 4)
				.add(Aspect.ENERGY, 2));

		event.register.registerObjectTag(new ItemStack(SPAWN_ENDER_GIRL), (new AspectList())
				.add(Aspect.BEAST, 8)
				.add(Aspect.LIFE, 4)
				.add(Aspect.ELDRITCH, 2));

		event.register.registerObjectTag(new ItemStack(SPAWN_HOLSTAURUS), (new AspectList())
				.add(Aspect.BEAST, 16)
				.add(Aspect.LIFE, 4));

		event.register.registerObjectTag(new ItemStack(SPAWN_SLIME_GIRL), (new AspectList())
				.add(Aspect.BEAST, 8)
				.add(Aspect.LIFE, 4)
				.add(Aspect.FIRE, 2));

		event.register.registerObjectTag(new ItemStack(SPAWN_TAME), (new AspectList())
				.add(Aspect.BEAST, 16)
				.add(Aspect.LIFE, 16)
				.add(Aspect.DESIRE, 8));

		event.register.registerObjectTag(new ItemStack(SPAWN_TRADER), (new AspectList())
				.add(Aspect.BEAST, 1)
				.add(Aspect.LIFE, 1)
				.add(Aspect.DESIRE, 2));
		// W
		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_BATTLE), (new AspectList())
				.add(Aspect.AVERSION, 8));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_BUFF), (new AspectList())
				.add(Aspect.LIFE, 5)
				.add(Aspect.ENERGY, 4)
				.add(Aspect.PROTECT, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_ENDER), (new AspectList())
				.add(Aspect.ELDRITCH, 5)
				.add(Aspect.DARKNESS, 4)
				.add(Aspect.MOTION, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_FREEZING), (new AspectList())
				.add(Aspect.COLD, 5)
				.add(Aspect.MOTION, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_HUNGER), (new AspectList())
				.add(Aspect.LIFE, 5)
				.add(Aspect.MAN, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_NATURE), (new AspectList())
				.add(Aspect.PLANT, 5)
				.add(Aspect.LIFE, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_NIGHTMARE), (new AspectList())
				.add(Aspect.ENTROPY, 5)
				.add(Aspect.DARKNESS, 4)
				.add(Aspect.DEATH, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_METAL), (new AspectList())
				.add(Aspect.METAL, 5)
				.add(Aspect.MOTION, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_WITHER), (new AspectList())
				.add(Aspect.DEATH, 5)
				.add(Aspect.DARKNESS, 4)
				.add(Aspect.ENTROPY, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_FAN_ICE), (new AspectList())
				.add(Aspect.COLD, 4)
				.add(Aspect.AVERSION, 2)
				.add(Aspect.MOTION, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_FAN_FIRE), (new AspectList())
				.add(Aspect.FIRE, 4)
				.add(Aspect.AVERSION, 2)
				.add(Aspect.MOTION, 2));

		// Blocks
		event.register.registerObjectTag(new ItemStack(BUST_SPHINX), (new AspectList())
				.add(Aspect.ENTROPY, 16)
				.add(Aspect.DESIRE, 8));

		event.register.registerObjectTag(new ItemStack(BUST_VALKYRIE), (new AspectList())
				.add(Aspect.ENTROPY, 16)
				.add(Aspect.DESIRE, 8));

		event.register.registerObjectTag(new ItemStack(BUST_VAMPIRE), (new AspectList())
				.add(Aspect.ENTROPY, 16)
				.add(Aspect.DESIRE, 8));

		event.register.registerObjectTag(new ItemStack(DOLL_CREEPER_GIRL), (new AspectList())
				.add(Aspect.BEAST, 8)
				.add(Aspect.CRAFT, 4)
				.add(Aspect.DESIRE, 2));

		event.register.registerObjectTag(new ItemStack(DOLL_ENDER_GIRL), (new AspectList())
				.add(Aspect.BEAST, 8)
				.add(Aspect.CRAFT, 4)
				.add(Aspect.DESIRE, 2));

		event.register.registerObjectTag(new ItemStack(DOLL_SLIME_GIRL), (new AspectList())
				.add(Aspect.BEAST, 8)
				.add(Aspect.CRAFT, 4)
				.add(Aspect.DESIRE, 2));

		event.register.registerObjectTag(new ItemStack(DOLL_MAID), (new AspectList())
				.add(Aspect.BEAST, 8)
				.add(Aspect.CRAFT, 4)
				.add(Aspect.DESIRE, 2));
	}
}
