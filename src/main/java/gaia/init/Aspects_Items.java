package gaia.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import gaia.Gaia;
import gaia.GaiaReference;

@InterfaceList({
	@Interface(iface="thaumcraft.api.ThaumcraftApi", modid="Thaumcraft", striprefs=true),
	@Interface(iface="thaumcraft.api.aspects.Aspect", modid="Thaumcraft", striprefs=true),
	@Interface(iface="thaumcraft.api.aspects.AspectList", modid="Thaumcraft", striprefs=true)})
public class Aspects_Items extends GaiaItem{
	
	/**Primary method to register aspects**/
	public static void Item_Aspects() {
			
		Gaia.logger.info("Registering Item Aspects");

		//Items
		ThaumcraftApi.registerObjectTag(new ItemStack(Shard, 1, 0),
				(new AspectList()).add(Aspect.METAL, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(Shard, 1, 1),
				(new AspectList()).add(Aspect.METAL, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(Shard, 1, 2),
				(new AspectList()).add(Aspect.CRYSTAL, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(Shard, 1, 3),
				(new AspectList()).add(Aspect.CRYSTAL, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ShardMisc, 1, 0),
				(new AspectList()).add(Aspect.ELDRITCH, 2).add(Aspect.MOTION, 2).add(Aspect.ORDER, 2).add(Aspect.LIGHT, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ShardMisc, 1, 1),
				(new AspectList()).add(Aspect.ELDRITCH, 1).add(Aspect.MOTION, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ShardMisc, 1, 2),
				(new AspectList()).add(Aspect.FIRE, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodMeat),
				(new AspectList()).add(Aspect.LIFE, 2).add(Aspect.CRAFT, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodRottenHeart),
				(new AspectList()).add(Aspect.LIFE, 3).add(Aspect.MAN, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodRoot),
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.LIFE, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodIce),
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.LIFE, 1).add(Aspect.COLD, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodCoalfish),
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.LIFE, 1).add(Aspect.FIRE, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodNetherWart),
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.FIRE, 1).add(Aspect.MOTION, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodSmallAppleGold),
				(new AspectList()).add(Aspect.FIRE, 2).add(Aspect.AVERSION, 1).add(Aspect.ELDRITCH, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodMandrake),
				(new AspectList()).add(Aspect.PLANT, 1).add(Aspect.LIFE, 2).add(Aspect.SOUL, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodWither),
				(new AspectList()).add(Aspect.MIND, 2).add(Aspect.LIFE, 2).add(Aspect.UNDEAD, 2).add(Aspect.DARKNESS, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodPieMandrake),
				(new AspectList()).add(Aspect.LIFE, 2).add(Aspect.DESIRE, 1).add(Aspect.PLANT, 1).add(Aspect.SENSES, 1).add(Aspect.WATER, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FoodPieMeat),
				(new AspectList()).add(Aspect.LIFE, 2).add(Aspect.DESIRE, 1).add(Aspect.MAN, 1));

		ThaumcraftApi.registerObjectTag(new ItemStack(MiscSoulFire),
				(new AspectList()).add(Aspect.FIRE, 2).add(Aspect.TRAP, 1).add(Aspect.SOUL, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscSoulFiery),
				(new AspectList()).add(Aspect.FIRE, 4).add(Aspect.TRAP, 2).add(Aspect.SOUL, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscGigaGear),
				(new AspectList()).add(Aspect.FIRE, 12).add(Aspect.ENERGY, 12).add(Aspect.MECHANISM, 8));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscBook),
				(new AspectList()).add(Aspect.MIND, 12));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscRing, 1, 0),
				(new AspectList()).add(Aspect.METAL, 2).add(Aspect.PROTECT, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscRing, 1, 1),
				(new AspectList()).add(Aspect.METAL, 2).add(Aspect.PROTECT, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscRing, 1, 2),
				(new AspectList()).add(Aspect.METAL, 2).add(Aspect.PROTECT, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscRing, 1, 3),
				(new AspectList()).add(Aspect.METAL, 2).add(Aspect.PROTECT, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscFurnaceFuel),
				(new AspectList()).add(Aspect.MOTION, 3).add(Aspect.FIRE, 3));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscWeaponEnchanted, 1, 0),
				(new AspectList()).add(Aspect.PLANT, 2).add(Aspect.MOTION, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(MiscWeaponEnchanted, 1, 1),
				(new AspectList()).add(Aspect.PLANT, 2).add(Aspect.MOTION, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(Spawn),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(SpawnCreeperGirl),
				(new AspectList()).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(SpawnSlimeGirl),
				(new AspectList()).add(Aspect.FIRE, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(SpawnEnderGirl),
				(new AspectList()).add(Aspect.ELDRITCH, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(SpawnTrader),
				(new AspectList()).add(Aspect.DESIRE, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(SpawnHolstaurus),
				(new AspectList()).add(Aspect.BEAST, 2).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(SpawnWeresheep),
				(new AspectList()).add(Aspect.BEAST, 1).add(Aspect.CRAFT, 1).add(Aspect.LIFE, 1).add(Aspect.BEAST, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BoxIron),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.METAL, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BoxGold),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.METAL, 3).add(Aspect.DESIRE, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BoxDiamond),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.CRYSTAL, 4).add(Aspect.DESIRE, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BagOre),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.EARTH, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BagBook),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.MIND, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BagRecord),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.SENSES, 4).add(Aspect.AIR, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BoxOld),
				(new AspectList()).add(Aspect.VOID, 2).add(Aspect.DESIRE, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FanIce),
				(new AspectList()).add(Aspect.COLD, 4).add(Aspect.AVERSION, 2).add(Aspect.MOTION, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(FanFire),
				(new AspectList()).add(Aspect.FIRE, 4).add(Aspect.AVERSION, 2).add(Aspect.MOTION, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookFreezing),
				(new AspectList()).add(Aspect.COLD, 5).add(Aspect.MOTION, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookNightmare),
				(new AspectList()).add(Aspect.ENTROPY, 5).add(Aspect.DARKNESS, 4).add(Aspect.DEATH, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookMetal),
				(new AspectList()).add(Aspect.METAL, 5).add(Aspect.MOTION, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookEnder),
				(new AspectList()).add(Aspect.ELDRITCH, 5).add(Aspect.DARKNESS, 4).add(Aspect.MOTION, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookHunger),
				(new AspectList()).add(Aspect.LIFE, 5).add(Aspect.MAN, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookBattle),
				(new AspectList()).add(Aspect.AVERSION, 8));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookNature),
				(new AspectList()).add(Aspect.PLANT, 5).add(Aspect.LIFE, 4));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookWither), 
				(new AspectList()).add(Aspect.DEATH, 5).add(Aspect.DARKNESS, 4).add(Aspect.ENTROPY, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(BookBuff), 
				(new AspectList()).add(Aspect.LIFE, 5).add(Aspect.ENERGY, 4).add(Aspect.PROTECT, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(AccessoryRingSpeed), 
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.METAL, 2).add(Aspect.ORDER, 4).add(Aspect.ELDRITCH, 2).add(Aspect.ENERGY, 6));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(AccessoryRingHaste), 
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.METAL, 2).add(Aspect.ORDER, 4).add(Aspect.ELDRITCH, 2).add(Aspect.MOTION, 6));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(AccessoryRingJump), 
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.METAL, 2).add(Aspect.ORDER, 4).add(Aspect.ELDRITCH, 2).add(Aspect.FLIGHT, 6));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(AccessoryRingNight), 
				(new AspectList()).add(Aspect.PROTECT, 2).add(Aspect.METAL, 2).add(Aspect.ORDER, 4).add(Aspect.ELDRITCH, 2).add(Aspect.SENSES, 6));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(AccessoryCursed), 
				(new AspectList()).add(Aspect.METAL, 4).add(Aspect.BEAST, 4).add(Aspect.ENTROPY, 6));
				
		//Blocks
		ThaumcraftApi.registerObjectTag(new ItemStack(GaiaBlock.BustSphinx),
				(new AspectList()).add(Aspect.EARTH, 4).add(Aspect.DESIRE, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(GaiaBlock.BustValkyrie),
				(new AspectList()).add(Aspect.EARTH, 4).add(Aspect.DESIRE, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(GaiaBlock.BustVampire),
				(new AspectList()).add(Aspect.EARTH, 4).add(Aspect.DESIRE, 2));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(GaiaBlock.DollCreeperGirl),
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.CRAFT, 2).add(Aspect.DESIRE, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(GaiaBlock.DollEnderGirl),
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.CRAFT, 2).add(Aspect.DESIRE, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(GaiaBlock.DollSlimeGirl),
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.CRAFT, 2).add(Aspect.DESIRE, 1));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(GaiaBlock.DollMaid),
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.CRAFT, 2).add(Aspect.DESIRE, 1));
	}
}