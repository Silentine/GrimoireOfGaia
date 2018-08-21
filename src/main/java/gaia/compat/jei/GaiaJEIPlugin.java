package gaia.compat.jei;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gaia.compat.jei.bagloot.GaiaLootCategory;
import gaia.compat.jei.bagloot.GaiaLootHandler;
import gaia.compat.jei.bagloot.GaiaLootWrapper;
import gaia.init.GaiaItems;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;

@JEIPlugin
public class GaiaJEIPlugin implements IModPlugin{
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		 registry.addRecipeCategories(new GaiaLootCategory(jeiHelpers.getGuiHelper()));
	}
	
	@Override
	public void register(IModRegistry registry) {

		registry.addRecipeHandlers(new GaiaLootHandler());
		
		registry.addRecipes(getBagLoot(), GaiaLootCategory.UID);
		registry.addRecipeCatalyst(new ItemStack(GaiaItems.BagBook), GaiaLootCategory.UID);
		
		IModPlugin.super.register(registry);
	}
	
	private List<GaiaLootWrapper> getBagLoot() {
		 List<GaiaLootWrapper> result = new ArrayList<GaiaLootWrapper>();
		 
		 ArrayList<ItemStack> arrowLoot = new ArrayList<>();
		 arrowLoot.add(PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS));
		 arrowLoot.add(PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.HARMING));
		 arrowLoot.add(PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.POISON));
		 arrowLoot.add(PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BagArrow), arrowLoot));

		 ArrayList<ItemStack> bookLoot = new ArrayList<>();
	     Random rand = new Random();
		 for(int i = 0; i < 15; i++)
		 {
			 bookLoot.add(EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(Items.BOOK), 5 + i, true));
		 }
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BagBook), bookLoot));

		 ArrayList<ItemStack> oreLoot = new ArrayList<>();
		 oreLoot.add(new ItemStack(Blocks.COAL_ORE));
		 oreLoot.add(new ItemStack(Blocks.IRON_ORE));
		 oreLoot.add(new ItemStack(Blocks.GOLD_ORE));
		 oreLoot.add(new ItemStack(Blocks.DIAMOND_ORE));
		 oreLoot.add(new ItemStack(Blocks.EMERALD_ORE));
		 oreLoot.add(new ItemStack(Blocks.REDSTONE_ORE));
		 oreLoot.add(new ItemStack(Blocks.LAPIS_ORE));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BagOre), oreLoot));

		 ArrayList<ItemStack> recordLoot = new ArrayList<>();
		 recordLoot.add(new ItemStack(Items.RECORD_13));
		 recordLoot.add(new ItemStack(Items.RECORD_CAT));
		 recordLoot.add(new ItemStack(Items.RECORD_BLOCKS));
		 recordLoot.add(new ItemStack(Items.RECORD_CHIRP));
		 recordLoot.add(new ItemStack(Items.RECORD_FAR));
		 recordLoot.add(new ItemStack(Items.RECORD_MALL));
		 recordLoot.add(new ItemStack(Items.RECORD_MELLOHI));
		 recordLoot.add(new ItemStack(Items.RECORD_STAL));
		 recordLoot.add(new ItemStack(Items.RECORD_STRAD));
		 recordLoot.add(new ItemStack(Items.RECORD_WARD));
		 recordLoot.add(new ItemStack(Items.RECORD_11));
		 recordLoot.add(new ItemStack(Items.RECORD_WAIT));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BagRecord), recordLoot));

		 ArrayList<ItemStack> boxLoot = new ArrayList<>();
		 boxLoot.add(new ItemStack(Blocks.COAL_ORE));
		 boxLoot.add(new ItemStack(Blocks.IRON_ORE));
		 boxLoot.add(new ItemStack(Blocks.GOLD_ORE));
		 boxLoot.add(new ItemStack(Blocks.DIAMOND_ORE));
		 boxLoot.add(new ItemStack(Blocks.EMERALD_ORE));
		 boxLoot.add(new ItemStack(Blocks.REDSTONE_ORE));
		 boxLoot.add(new ItemStack(Blocks.LAPIS_ORE));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.Box, 0), boxLoot));
		 
		 ArrayList<ItemStack> netherBoxLoot = new ArrayList<>();
		 netherBoxLoot.add(new ItemStack(Blocks.GLOWSTONE));
		 netherBoxLoot.add(new ItemStack(Blocks.QUARTZ_ORE));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.Box, 1), netherBoxLoot));
		 
		 ArrayList<ItemStack> endBoxLoot = new ArrayList<>();
		 endBoxLoot.add(new ItemStack(Blocks.OBSIDIAN));
		 endBoxLoot.add(new ItemStack(Blocks.END_STONE));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.Box, 2), endBoxLoot));

		 ArrayList<ItemStack> ironBoxLoot = new ArrayList<>();
		 ironBoxLoot.add(new ItemStack(Items.IRON_INGOT));
		 ironBoxLoot.add(new ItemStack(Items.IRON_AXE));
		 ironBoxLoot.add(new ItemStack(Items.IRON_PICKAXE));
		 ironBoxLoot.add(new ItemStack(Items.IRON_SHOVEL));
		 ironBoxLoot.add(new ItemStack(Items.IRON_SWORD));
		 ironBoxLoot.add(new ItemStack(Items.IRON_HELMET));
		 ironBoxLoot.add(new ItemStack(Items.IRON_CHESTPLATE));
		 ironBoxLoot.add(new ItemStack(Items.IRON_LEGGINGS));
		 ironBoxLoot.add(new ItemStack(Items.IRON_BOOTS));
		 ironBoxLoot.add(new ItemStack(Items.IRON_HORSE_ARMOR));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BoxIron), ironBoxLoot));
		 
		 ArrayList<ItemStack> goldBoxLoot = new ArrayList<>();
		 goldBoxLoot.add(new ItemStack(Items.GOLD_INGOT));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_AXE));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_PICKAXE));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_SHOVEL));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_SWORD));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_HELMET));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_CHESTPLATE));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_LEGGINGS));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_BOOTS));
		 goldBoxLoot.add(new ItemStack(Items.GOLDEN_HORSE_ARMOR));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BoxGold), goldBoxLoot));
		 
		 ArrayList<ItemStack> diamondBoxLoot = new ArrayList<>();
		 diamondBoxLoot.add(new ItemStack(Items.GOLD_INGOT));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_AXE));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_PICKAXE));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_SHOVEL));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_SWORD));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_HELMET));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_CHESTPLATE));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_LEGGINGS));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_BOOTS));
		 diamondBoxLoot.add(new ItemStack(Items.DIAMOND_HORSE_ARMOR));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BoxDiamond), diamondBoxLoot));
		 
		 ArrayList<ItemStack> oldBoxLoot = new ArrayList<>();
		 oldBoxLoot.add(new ItemStack(GaiaItems.MiscGigaGear));
		 oldBoxLoot.add(new ItemStack(GaiaItems.BookWither));
		 oldBoxLoot.add(new ItemStack(GaiaItems.Spawn));
		 oldBoxLoot.add(new ItemStack(GaiaItems.BagBook));
		 result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BoxOld), oldBoxLoot));
		 
		 return result;
	}
}
