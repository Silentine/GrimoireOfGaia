package gaia.init;

import gaia.GaiaReference;
import gaia.block.BlockBustSphinx;
import gaia.block.BlockBustValkyrie;
import gaia.block.BlockBustVampire;
import gaia.block.BlockDollCreeperGirl;
import gaia.block.BlockDollEnderGirl;
import gaia.block.BlockDollMaid;
import gaia.block.BlockDollSlimeGirl;
import gaia.tileentity.TileEntityBustSphinx;
import gaia.tileentity.TileEntityBustValkyrie;
import gaia.tileentity.TileEntityBustVampire;
import gaia.tileentity.TileEntityDollCreeperGirl;
import gaia.tileentity.TileEntityDollEnderGirl;
import gaia.tileentity.TileEntityDollMaid;
import gaia.tileentity.TileEntityDollSlimeGirl;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GaiaBlock {
	public static Block BustSphinx;
	public static Block BustValkyrie;
	public static Block BustVampire;
	public static Block DollCreeperGirl;
	public static Block DollEnderGirl;
	public static Block DollSlimeGirl;
	public static Block DollMaid;

	public static void init() {
		BustSphinx = (new BlockBustSphinx(Material.rock));
		BustValkyrie = (new BlockBustValkyrie(Material.rock));
		BustVampire = (new BlockBustVampire(Material.rock));
		DollCreeperGirl = (new BlockDollCreeperGirl(Material.cloth));
		DollEnderGirl = (new BlockDollEnderGirl(Material.cloth));
		DollSlimeGirl = (new BlockDollSlimeGirl(Material.cloth));
		DollMaid = (new BlockDollMaid(Material.cloth));
		registerTileEntities();
	}

//	public static void addRecipes() {}

	public static void register() {
		GameRegistry.registerBlock(BustSphinx, "The Sphinx");
		GameRegistry.registerBlock(BustValkyrie, "The Valkyrie");
		GameRegistry.registerBlock(BustVampire, "The Vampire");
		GameRegistry.registerBlock(DollCreeperGirl, "Creeper Girl Doll");
		GameRegistry.registerBlock(DollEnderGirl, "Ender Girl Doll");
		GameRegistry.registerBlock(DollSlimeGirl, "Slime Girl Doll");
		GameRegistry.registerBlock(DollMaid, "Maid Doll");
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBustSphinx.class, "BustSphinx");
		GameRegistry.registerTileEntity(TileEntityBustValkyrie.class, "BustValkyrie");
		GameRegistry.registerTileEntity(TileEntityBustVampire.class, "BustVampire");
		GameRegistry.registerTileEntity(TileEntityDollCreeperGirl.class, "DollCreeperGirl");
		GameRegistry.registerTileEntity(TileEntityDollEnderGirl.class, "DollEnderGirl");
		GameRegistry.registerTileEntity(TileEntityDollSlimeGirl.class, "DollSlimeGirl");
		GameRegistry.registerTileEntity(TileEntityDollMaid.class, "DollMaid");
	}
	
	public static void registerRenders() {
		registerRender(BustSphinx);
		registerRender(BustValkyrie);
		registerRender(BustVampire);
		registerRender(DollCreeperGirl);
		registerRender(DollEnderGirl);
		registerRender(DollSlimeGirl);
		registerRender(DollMaid);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GaiaReference.MOD_ID + ":" + item.getUnlocalizedName().substring(20).toLowerCase(Locale.US), "inventory"));
	}
}
