package gaia.init;

import java.util.Locale;

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
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GaiaBlock {
	//public static final String modid = "GrimoireOfGaia";
	public static Block BustSphinx;
	public static Block BustValkyrie;
	public static Block BustVampire;
	public static Block DollCreeperGirl;
	public static Block DollEnderGirl;
	public static Block DollSlimeGirl;
	public static Block DollMaid;

	public static void init() {
		BustSphinx = (new BlockBustSphinx(Material.rock));//.setBlockTextureName("Gaia:Icon_Bust");
		BustValkyrie = (new BlockBustValkyrie(Material.rock));//.setBlockTextureName("Gaia:Icon_Bust");
		BustVampire = (new BlockBustVampire(Material.rock));//.setBlockTextureName("Gaia:Icon_Bust");
		DollCreeperGirl = (new BlockDollCreeperGirl(Material.cloth));//.setBlockTextureName("Gaia:Icon_Doll");
		DollEnderGirl = (new BlockDollEnderGirl(Material.cloth));//.setBlockTextureName("Gaia:Icon_Doll");
		DollSlimeGirl = (new BlockDollSlimeGirl(Material.cloth));//.setBlockTextureName("Gaia:Icon_Doll");
		DollMaid = (new BlockDollMaid(Material.cloth));//.setBlockTextureName("Gaia:Icon_Doll");
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
	
	public static void registerRenders()
	{
		registerRender(BustSphinx);
		registerRender(BustValkyrie);
		registerRender(BustVampire);
		registerRender(DollCreeperGirl);
		registerRender(DollEnderGirl);
		registerRender(DollSlimeGirl);
		registerRender(DollMaid);
	}
	
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation("gaia:" + item.getUnlocalizedName().substring(20).toLowerCase(Locale.US), "inventory"));
	}
}
