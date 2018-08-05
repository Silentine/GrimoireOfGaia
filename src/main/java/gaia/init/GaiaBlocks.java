package gaia.init;

import com.google.common.base.Preconditions;
import gaia.Gaia;
import gaia.GaiaReference;
import gaia.block.BlockBust;
import gaia.tileentity.TileEntityBust;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

public class GaiaBlocks {

	public static final String BUST_SPHINX_NAME = "bustSphinx";
	public static final String BUST_VALKYRIE_NAME = "bustValkyrie";
	public static final String BUST_VAMPIRE_NAME = "bustVampire";
	public static final String DOLL_CREEPER_GIRL_NAME = "dollCreeperGirl";
	public static final String DOLL_ENDER_GIRL_NAME = "dollEnderGirl";
	public static final String DOLL_SLIME_GIRL_NAME = "dollSlimeGirl";
	public static final String DOLL_MAID_NAME = "dollMaid";
	public static final Block BUST_SPHINX = new BlockBust(Material.ROCK, BUST_SPHINX_NAME);
	public static final Block BUST_VALKYRIE = new BlockBust(Material.ROCK, BUST_VALKYRIE_NAME);
	public static final Block BUST_VAMPIRE = new BlockBust(Material.ROCK, BUST_VAMPIRE_NAME);
	public static final Block DOLL_CREEPER_GIRL = new BlockBust(Material.CLOTH, DOLL_CREEPER_GIRL_NAME);
	public static final Block DOLL_ENDER_GIRL = new BlockBust(Material.CLOTH, DOLL_ENDER_GIRL_NAME);
	public static final Block DOLL_SLIME_GIRL = new BlockBust(Material.CLOTH, DOLL_SLIME_GIRL_NAME);
	public static final Block DOLL_MAID = new BlockBust(Material.CLOTH, DOLL_MAID_NAME);
	public static Block SpawnGuard;

	private static void registerTile() {
		registerTile(TileEntityBust.class, "tile_bust");
	}

	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class RegistrationHandler {

		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			Gaia.LOGGER.info("Registering blocks...");
			final IForgeRegistry<Block> registry = event.getRegistry();

			final Block[] blocks = {
					BUST_SPHINX,
					BUST_VALKYRIE,
					BUST_VAMPIRE,
					DOLL_CREEPER_GIRL,
					DOLL_ENDER_GIRL,
					DOLL_SLIME_GIRL,
					DOLL_MAID
			};

			registry.registerAll(blocks);
			registerTile();
			Gaia.LOGGER.info("Block registration complete.");
		}

		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			Gaia.LOGGER.info("Registering item blocks...");
			final ItemBlock[] items = {
					new ItemBlock(BUST_SPHINX),
					new ItemBlock(BUST_VALKYRIE),
					new ItemBlock(BUST_VAMPIRE),
					new ItemBlock(DOLL_CREEPER_GIRL),
					new ItemBlock(DOLL_ENDER_GIRL),
					new ItemBlock(DOLL_SLIME_GIRL),
					new ItemBlock(DOLL_MAID)
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
			Gaia.proxy.registerBlocksRender();
			Gaia.LOGGER.info("Item block registration complete.");
		}
	}

	private static void registerTile(Class<? extends TileEntity> clazz, String key) {
		GameRegistry.registerTileEntity(clazz, new ResourceLocation(GaiaReference.MOD_ID, key));
	}

	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		registerRender(BUST_SPHINX);
		registerRender(BUST_VALKYRIE);
		registerRender(BUST_VAMPIRE);
		registerRender(DOLL_CREEPER_GIRL);
		registerRender(DOLL_ENDER_GIRL);
		registerRender(DOLL_SLIME_GIRL);
		registerRender(DOLL_MAID);
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
