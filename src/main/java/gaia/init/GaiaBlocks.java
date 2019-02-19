package gaia.init;

import java.util.ArrayList;

import gaia.Gaia;
import gaia.GaiaReference;
import gaia.ItemGroupGaia;
import gaia.block.BlockBust;
import gaia.block.BlockDecoration;
import gaia.block.BlockSpawnGuard;
import gaia.block.BlockWebTemp;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GaiaReference.MOD_ID)
public class GaiaBlocks {
	public static Block BUST_SPHINX;
	public static Block BUST_VALKYRIE;
	public static Block BUST_VAMPIRE;
	public static Block DOLL_CREEPER_GIRL;
	public static Block DOLL_ENDER_GIRL;
	public static Block DOLL_SLIME_GIRL;
	public static Block DOLL_MAID;
	public static Block DECO_GARDEN_GNOME;
	public static Block DECO_MANDRAGORA_POT;
	public static Block SPAWN_GUARD;
	public static Block WEB_TEMP;
	
	public static ArrayList<Block> BLOCKS = new ArrayList<>();

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		Gaia.LOGGER.info("Registering blocks...");
		IForgeRegistry<Block> registry = event.getRegistry();
		
		BUST_SPHINX = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "bust_sphinx");
		BUST_VALKYRIE = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "bust_valkyrie");
		BUST_VAMPIRE = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "bust_vampire");
		DOLL_CREEPER_GIRL = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "doll_creeper_girl");
		DOLL_ENDER_GIRL = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "doll_ender_girl");
		DOLL_SLIME_GIRL = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "doll_slime_girl");
		DOLL_MAID = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "doll_maid");
		DECO_GARDEN_GNOME =  registerBlock(new BlockDecoration(Block.Properties.create(Material.ROCK)), "deco_garden_gnome");
		DECO_MANDRAGORA_POT =  registerBlock(new BlockDecoration(Block.Properties.create(Material.ROCK)), "deco_mandragora_pot");
		SPAWN_GUARD =  registerBlock(new BlockSpawnGuard(Block.Properties.create(Material.CLOTH)), "spawn_guard");
		WEB_TEMP =  registerBlock(new BlockWebTemp(Block.Properties.create(Material.WEB)), "web_temp");

		registry.registerAll(BLOCKS.toArray(new Block[0]));

		Gaia.LOGGER.info("Block registration complete.");
	}

	public static <T extends Block> T registerBlock(T block, String registry)
    {
    	block.setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, registry));
        return registerBlock(block, new ItemBlock(block, itemBuilder()));
    }
	
	private static Item.Properties itemBuilder()
	{
		return new Item.Properties().group(ItemGroupGaia.INSTANCE);
	}
	
	public static <T extends Block> T registerBlock(T block, ItemBlock item)
    {
        item.setRegistryName(((ItemBlock) item).getBlock().getRegistryName());
    	GaiaItems.ITEMS.add(item);
        BLOCKS.add(block);
        return block;
    }
}
