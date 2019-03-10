package gaia.compat.jei;

//@JEIPlugin
public class GaiaJEIPlugin //implements IModPlugin 
{
//	@Override
//	public void registerCategories(IRecipeCategoryRegistration registry) {
//		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
//		registry.addRecipeCategories(new GaiaSatchelLootCategory(jeiHelpers.getGuiHelper()));
//		registry.addRecipeCategories(new GaiaBoxLootCategory(jeiHelpers.getGuiHelper()));
//	}
//
//	@Override
//	public void register(IModRegistry registry) {
//		registry.addRecipeHandlers(new GaiaLootHandler());
//
//		registry.addRecipes(getBagLoot(), GaiaSatchelLootCategory.UID);
//		registry.addRecipes(getBoxLoot(), GaiaBoxLootCategory.UID);
//	}
//
//	private List<GaiaLootWrapper> getBagLoot() {
//		List<GaiaLootWrapper> result = new ArrayList<GaiaLootWrapper>();
//
//		ArrayList<ItemStack> arrowLoot = new ArrayList<>();
//		arrowLoot.add(PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.SLOWNESS));
//		arrowLoot.add(PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.HARMING));
//		arrowLoot.add(PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.POISON));
//		arrowLoot.add(PotionUtils.addPotionToItemStack(new ItemStack(Items.TIPPED_ARROW), PotionTypes.WEAKNESS));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BAG_ARROW), arrowLoot));
//
//		ArrayList<ItemStack> bookLoot = new ArrayList<>();
//		Random rand = new Random();
//		for (int i = 0; i < 15; i++) {
//			bookLoot.add(EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(Items.BOOK), 5 + i, true));
//		}
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BAG_BOOK), bookLoot));
//
//		ArrayList<ItemStack> recordLoot = new ArrayList<>();
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_13));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_CAT));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_BLOCKS));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_CHIRP));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_FAR));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_MALL));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_MELLOHI));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_STAL));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_STRAD));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_WARD));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_11));
//		recordLoot.add(new ItemStack(Items.MUSIC_DISC_WAIT));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BAG_RECORD), recordLoot));
//
//		ArrayList<ItemStack> spawnLoot = new ArrayList<>();
//		spawnLoot.add(new ItemStack(GaiaItems.SPAWN_CREEPER_GIRL));
//		spawnLoot.add(new ItemStack(GaiaItems.SPAWN_ENDER_GIRL));
//		spawnLoot.add(new ItemStack(GaiaItems.SPAWN_HOLSTAURUS));
//		spawnLoot.add(new ItemStack(GaiaItems.SPAWN_SLIME_GIRL));
//		spawnLoot.add(new ItemStack(GaiaItems.SPAWN_TRADER));
//		spawnLoot.add(new ItemStack(GaiaItems.SPAWN_WERESHEEP));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.SPAWN), spawnLoot));
//
//		return result;
//	}
//
//	private List<GaiaLootWrapper> getBoxLoot() {
//		List<GaiaLootWrapper> result = new ArrayList<GaiaLootWrapper>();
//		ArrayList<ItemStack> boxLoot = new ArrayList<>();
//		boxLoot.add(new ItemStack(Blocks.COAL_ORE));
//		boxLoot.add(new ItemStack(Blocks.IRON_ORE));
//		boxLoot.add(new ItemStack(Blocks.GOLD_ORE));
//		boxLoot.add(new ItemStack(Blocks.DIAMOND_ORE));
//		boxLoot.add(new ItemStack(Blocks.EMERALD_ORE));
//		boxLoot.add(new ItemStack(Blocks.REDSTONE_ORE));
//		boxLoot.add(new ItemStack(Blocks.LAPIS_ORE));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BOX_ORE, 1), boxLoot));
//
//		ArrayList<ItemStack> netherBoxLoot = new ArrayList<>();
//		netherBoxLoot.add(new ItemStack(Blocks.GLOWSTONE));
//		netherBoxLoot.add(new ItemStack(Blocks.QUARTZ_ORE));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BOX, 1, 1), netherBoxLoot));
//
//		ArrayList<ItemStack> endBoxLoot = new ArrayList<>();
//		endBoxLoot.add(new ItemStack(Blocks.OBSIDIAN));
//		endBoxLoot.add(new ItemStack(Blocks.END_STONE));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BOX, 1, 2), endBoxLoot));
//
//		ArrayList<ItemStack> ironBoxLoot = new ArrayList<>();
//		ironBoxLoot.add(new ItemStack(Items.IRON_INGOT));
//		ironBoxLoot.add(new ItemStack(Items.IRON_AXE));
//		ironBoxLoot.add(new ItemStack(Items.IRON_PICKAXE));
//		ironBoxLoot.add(new ItemStack(Items.IRON_SHOVEL));
//		ironBoxLoot.add(new ItemStack(Items.IRON_SWORD));
//		ironBoxLoot.add(new ItemStack(Items.IRON_HELMET));
//		ironBoxLoot.add(new ItemStack(Items.IRON_CHESTPLATE));
//		ironBoxLoot.add(new ItemStack(Items.IRON_LEGGINGS));
//		ironBoxLoot.add(new ItemStack(Items.IRON_BOOTS));
//		ironBoxLoot.add(new ItemStack(Items.IRON_HORSE_ARMOR));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BOX_IRON), ironBoxLoot));
//
//		ArrayList<ItemStack> goldBoxLoot = new ArrayList<>();
//		goldBoxLoot.add(new ItemStack(Items.GOLD_INGOT));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_AXE));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_PICKAXE));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_SHOVEL));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_SWORD));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_HELMET));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_CHESTPLATE));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_LEGGINGS));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_BOOTS));
//		goldBoxLoot.add(new ItemStack(Items.GOLDEN_HORSE_ARMOR));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BOX_GOLD), goldBoxLoot));
//
//		ArrayList<ItemStack> diamondBoxLoot = new ArrayList<>();
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_AXE));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_PICKAXE));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_SHOVEL));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_SWORD));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_HELMET));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_CHESTPLATE));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_LEGGINGS));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_BOOTS));
//		diamondBoxLoot.add(new ItemStack(Items.DIAMOND_HORSE_ARMOR));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BOX_DIAMOND), diamondBoxLoot));
//
//		ArrayList<ItemStack> oldBoxLoot = new ArrayList<>();
//		oldBoxLoot.add(new ItemStack(GaiaItems.MISC_GIGA_GEAR));
//		oldBoxLoot.add(new ItemStack(GaiaItems.WEAPON_BOOK_WITHER));
//		oldBoxLoot.add(new ItemStack(GaiaItems.SPAWN));
//		oldBoxLoot.add(new ItemStack(GaiaItems.BAG_BOOK));
//		result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BOX_OLD), oldBoxLoot));
//
//      ArrayList<ItemStack> hatBoxLoot = new ArrayList<>();
//		hatBoxLoot.add(new ItemStack(GaiaItems.ACCESSORY_HEADGEAR));
//		hatBoxLoot.add(new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_MOB));
//		hatBoxLoot.add(new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_BOLT));
//		hatBoxLoot.add(new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_ARROW));
//		hatBoxLoot.add(new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_DOLL));
//		hatBoxLoot.add(new ItemStack(GaiaItems.ACCESSORY_HEADGEAR_EARS_ELF));
//      result.add(new GaiaLootWrapper(new ItemStack(GaiaItems.BOX_HAT), hatBoxLoot));

//		return result;
//	}
}
