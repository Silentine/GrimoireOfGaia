package gaia.init;

import gaia.GaiaReference;
import gaia.block.BlockBustSphinx;
import gaia.block.BlockBustValkyrie;
import gaia.block.BlockBustVampire;
import gaia.block.BlockDollCreeperGirl;
import gaia.block.BlockDollEnderGirl;
import gaia.block.BlockDollMaid;
import gaia.block.BlockDollSlimeGirl;
import gaia.block.BlockSpawnGuard;
import gaia.tileentity.TileEntityBustSphinx;
import gaia.tileentity.TileEntityBustValkyrie;
import gaia.tileentity.TileEntityBustVampire;
import gaia.tileentity.TileEntityDollCreeperGirl;
import gaia.tileentity.TileEntityDollEnderGirl;
import gaia.tileentity.TileEntityDollMaid;
import gaia.tileentity.TileEntityDollSlimeGirl;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GaiaBlocks {
	public static Block 
	BustSphinx,
	BustValkyrie,
	BustVampire,
	DollCreeperGirl,
	DollEnderGirl,
	DollSlimeGirl,
	DollMaid,
	SpawnGuard;
	
	public static void init() {
		BustSphinx = new BlockBustSphinx();
		BustValkyrie = new BlockBustValkyrie();
		BustVampire = new BlockBustVampire();
		DollCreeperGirl = new BlockDollCreeperGirl();
		DollEnderGirl = new BlockDollEnderGirl();
		DollSlimeGirl = new BlockDollSlimeGirl();
		DollMaid = new BlockDollMaid();
		SpawnGuard = new BlockSpawnGuard();
		
		registerTileEntities();
	}

	/**
	 * @param block .json
	 * @param name en.lang
	 */
	public static void register() {
		GameRegistry.registerBlock(BustSphinx, "thesphinx");
		GameRegistry.registerBlock(BustValkyrie, "thevalkyrie");
		GameRegistry.registerBlock(BustVampire, "thevampire");
		GameRegistry.registerBlock(DollCreeperGirl, "creepergirldoll");
		GameRegistry.registerBlock(DollEnderGirl, "endergirldoll");
		GameRegistry.registerBlock(DollSlimeGirl, "slimegirldoll");
		GameRegistry.registerBlock(DollMaid, "maiddoll");
		GameRegistry.registerBlock(SpawnGuard, "spawnguard");
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBustSphinx.class, "BustSphinx");
		GameRegistry.registerTileEntity(TileEntityBustValkyrie.class, "BustValkyrie");
		GameRegistry.registerTileEntity(TileEntityBustVampire.class, "BustVampire");
		GameRegistry.registerTileEntity(TileEntityDollCreeperGirl.class, "DollCreeperGirl");
		GameRegistry.registerTileEntity(TileEntityDollEnderGirl.class, "DollEnderGirl");
		GameRegistry.registerTileEntity(TileEntityDollSlimeGirl.class, "DollSlimeGirl");
		GameRegistry.registerTileEntity(TileEntityDollMaid.class, "DollMaid");
		//GameRegistry.registerTileEntity(TileEntitySpawnGuard.class, "SpawnGuard");
	}

	public static void registerRenders() {
		registerRender(BustSphinx);
		registerRender(BustValkyrie);
		registerRender(BustVampire);
		registerRender(DollCreeperGirl);
		registerRender(DollEnderGirl);
		registerRender(DollSlimeGirl);
		registerRender(DollMaid);
		registerRender(SpawnGuard);
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GaiaReference.MOD_ID + ":" + item.getUnlocalizedName().substring(20).toLowerCase(Locale.US), "inventory"));
	}

	/**
	 * Registers crafting recipes
	 * @see RecipesCrafting
	 */
	public static void addRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(SpawnGuard, 4), new Object[]{GaiaItems.MiscQuill, Items.PAPER, Items.PAPER, Items.PAPER, Items.PAPER});
	}
}
