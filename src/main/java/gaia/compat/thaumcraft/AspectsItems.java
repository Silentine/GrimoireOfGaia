package gaia.compat.thaumcraft;

import gaia.Gaia;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectRegistryEvent;

import static gaia.init.GaiaBlocks.*;
import static gaia.init.GaiaItems.*;

@SuppressWarnings("unused")
public class AspectsItems {
	private AspectsItems() {}

	@SubscribeEvent
	public static void registerAspects(AspectRegistryEvent event) {
		Gaia.LOGGER.info("Registering Item Aspects");

		//Items
		event.register.registerObjectTag(new ItemStack(SHARD, 1, 0),
				(new AspectList()).add(Aspect.METAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 1),
				(new AspectList()).add(Aspect.METAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 2),
				(new AspectList()).add(Aspect.CRYSTAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 3),
				(new AspectList()).add(Aspect.CRYSTAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 4),
				(new AspectList()).add(Aspect.METAL, 1));

		event.register.registerObjectTag(new ItemStack(SHARD, 1, 5),
				(new AspectList()).add(Aspect.METAL, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_MEAT),
				(new AspectList()).add(Aspect.LIFE, 2).add(Aspect.CRAFT, 1).add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_ROTTEN_HEART),
				(new AspectList()).add(Aspect.LIFE, 3).add(Aspect.MAN, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_ROOT),
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.LIFE, 2));

		event.register.registerObjectTag(new ItemStack(FOOD_COALFISH),
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.LIFE, 1).add(Aspect.FIRE, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_NETHER_WART),
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.FIRE, 1).add(Aspect.MOTION, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_SMALL_APPLE_GOLD),
				(new AspectList()).add(Aspect.METAL, 4).add(Aspect.DESIRE, 4).add(Aspect.LIFE, 2).add(Aspect.MOTION, 1).add(Aspect.PLANT, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_MANDRAKE),
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.LIFE, 2).add(Aspect.SOUL, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_WITHER),
				(new AspectList()).add(Aspect.MIND, 2).add(Aspect.LIFE, 2).add(Aspect.UNDEAD, 2).add(Aspect.DARKNESS, 2));

		event.register.registerObjectTag(new ItemStack(FOOD_PIE_MANDRAKE),
				(new AspectList()).add(Aspect.LIFE, 2).add(Aspect.DESIRE, 1).add(Aspect.PLANT, 1).add(Aspect.SENSES, 1).add(Aspect.WATER, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_PIE_MEAT),
				(new AspectList()).add(Aspect.LIFE, 2).add(Aspect.DESIRE, 1).add(Aspect.MAN, 1));

		event.register.registerObjectTag(new ItemStack(FOOD_PIE_APPLE_GOLD),
				(new AspectList()).add(Aspect.METAL, 32).add(Aspect.DESIRE, 32).add(Aspect.LIFE, 4).add(Aspect.MOTION, 2).add(Aspect.PLANT, 1));

		event.register.registerObjectTag(new ItemStack(MISC_SOUL_FIRE),
				(new AspectList()).add(Aspect.FIRE, 2).add(Aspect.TRAP, 1).add(Aspect.SOUL, 1));

		event.register.registerObjectTag(new ItemStack(MISC_SOUL_FIERY),
				(new AspectList()).add(Aspect.FIRE, 4).add(Aspect.TRAP, 2).add(Aspect.SOUL, 2));

		event.register.registerObjectTag(new ItemStack(MISC_GIGA_GEAR),
				(new AspectList()).add(Aspect.FIRE, 12).add(Aspect.ENERGY, 12).add(Aspect.MECHANISM, 8));

		event.register.registerObjectTag(new ItemStack(MISC_BOOK),
				(new AspectList()).add(Aspect.MIND, 12));

		event.register.registerObjectTag(new ItemStack(MISC_RING, 1, 0),
				(new AspectList()).add(Aspect.METAL, 2).add(Aspect.PROTECT, 1));

		event.register.registerObjectTag(new ItemStack(MISC_RING, 1, 1),
				(new AspectList()).add(Aspect.METAL, 2).add(Aspect.PROTECT, 1));

		event.register.registerObjectTag(new ItemStack(MISC_RING, 1, 2),
				(new AspectList()).add(Aspect.METAL, 2).add(Aspect.PROTECT, 1));

		event.register.registerObjectTag(new ItemStack(MISC_RING, 1, 3),
				(new AspectList()).add(Aspect.METAL, 2).add(Aspect.PROTECT, 1));

		event.register.registerObjectTag(new ItemStack(MISC_FURNACE_FUEL),
				(new AspectList()).add(Aspect.MOTION, 3).add(Aspect.FIRE, 3));

		event.register.registerObjectTag(new ItemStack(WEAPON_PROP_ENCHANTED, 1, 0),
				(new AspectList()).add(Aspect.PLANT, 2).add(Aspect.MOTION, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_PROP_ENCHANTED, 1, 1),
				(new AspectList()).add(Aspect.PLANT, 2).add(Aspect.MOTION, 2));

		event.register.registerObjectTag(new ItemStack(SPAWN),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(SPAWN_CREEPER_GIRL),
				(new AspectList()).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(SPAWN_SLIME_GIRL),
				(new AspectList()).add(Aspect.FIRE, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(SPAWN_ENDER_GIRL),
				(new AspectList()).add(Aspect.ELDRITCH, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(SPAWN_TRADER),
				(new AspectList()).add(Aspect.DESIRE, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(SPAWN_HOLSTAURUS),
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(SPAWN_WERESHEEP),
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.CRAFT, 1).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));

		event.register.registerObjectTag(new ItemStack(BOX_IRON),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.METAL, 4));

		event.register.registerObjectTag(new ItemStack(BOX_GOLD),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.METAL, 3).add(Aspect.DESIRE, 2));

		event.register.registerObjectTag(new ItemStack(BOX_DIAMOND),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.CRYSTAL, 4).add(Aspect.DESIRE, 4));

		event.register.registerObjectTag(new ItemStack(BAG_ORE),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.EARTH, 2));

		event.register.registerObjectTag(new ItemStack(BAG_BOOK),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.MIND, 4));

		event.register.registerObjectTag(new ItemStack(BAG_RECORD),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.SENSES, 4).add(Aspect.AIR, 4));

		event.register.registerObjectTag(new ItemStack(BOX_OLD),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.DESIRE, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_FAN_ICE),
				(new AspectList()).add(Aspect.COLD, 4).add(Aspect.AVERSION, 2).add(Aspect.MOTION, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_FAN_FIRE),
				(new AspectList()).add(Aspect.FIRE, 4).add(Aspect.AVERSION, 2).add(Aspect.MOTION, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_FREEZING),
				(new AspectList()).add(Aspect.COLD, 5).add(Aspect.MOTION, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_NIGHTMARE),
				(new AspectList()).add(Aspect.ENTROPY, 5).add(Aspect.DARKNESS, 4).add(Aspect.DEATH, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_METAL),
				(new AspectList()).add(Aspect.METAL, 5).add(Aspect.MOTION, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_ENDER),
				(new AspectList()).add(Aspect.ELDRITCH, 5).add(Aspect.DARKNESS, 4).add(Aspect.MOTION, 2));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_HUNGER),
				(new AspectList()).add(Aspect.LIFE, 5).add(Aspect.MAN, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_BATTLE),
				(new AspectList()).add(Aspect.AVERSION, 8));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_NATURE),
				(new AspectList()).add(Aspect.PLANT, 5).add(Aspect.LIFE, 4));

		event.register.registerObjectTag(new ItemStack(WEAPON_BOOK_WITHER),
				(new AspectList()).add(Aspect.DEATH, 5).add(Aspect.DARKNESS, 4).add(Aspect.ENTROPY, 2));

		event.register.registerObjectTag(new ItemStack(BOOK_BUFF),
				(new AspectList()).add(Aspect.LIFE, 5).add(Aspect.ENERGY, 4).add(Aspect.PROTECT, 2));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_RING_SPEED),
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.METAL, 2).add(Aspect.ORDER, 4).add(Aspect.ELDRITCH, 2).add(Aspect.ENERGY, 6));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_RING_HASTE),
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.METAL, 2).add(Aspect.ORDER, 4).add(Aspect.ELDRITCH, 2).add(Aspect.MOTION, 6));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_RING_JUMP),
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.METAL, 2).add(Aspect.ORDER, 4).add(Aspect.ELDRITCH, 2).add(Aspect.FLIGHT, 6));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_RING_NIGHT),
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.METAL, 2).add(Aspect.ORDER, 4).add(Aspect.ELDRITCH, 2).add(Aspect.SENSES, 6));

		event.register.registerObjectTag(new ItemStack(ACCESSORY_CURSED),
				(new AspectList()).add(Aspect.METAL, 4).add(Aspect.BEAST, 4).add(Aspect.ENTROPY, 6));

		//Blocks
		event.register.registerObjectTag(new ItemStack(BUST_SPHINX),
				(new AspectList()).add(Aspect.EARTH, 4).add(Aspect.DESIRE, 2));

		event.register.registerObjectTag(new ItemStack(BUST_VALKYRIE),
				(new AspectList()).add(Aspect.EARTH, 4).add(Aspect.DESIRE, 2));

		event.register.registerObjectTag(new ItemStack(BUST_VAMPIRE),
				(new AspectList()).add(Aspect.EARTH, 4).add(Aspect.DESIRE, 2));

		event.register.registerObjectTag(new ItemStack(DOLL_CREEPER_GIRL),
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.CRAFT, 2).add(Aspect.DESIRE, 1));

		event.register.registerObjectTag(new ItemStack(DOLL_ENDER_GIRL),
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.CRAFT, 2).add(Aspect.DESIRE, 1));

		event.register.registerObjectTag(new ItemStack(DOLL_SLIME_GIRL),
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.CRAFT, 2).add(Aspect.DESIRE, 1));

		event.register.registerObjectTag(new ItemStack(DOLL_MAID),
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.CRAFT, 2).add(Aspect.DESIRE, 1));
	}
}
