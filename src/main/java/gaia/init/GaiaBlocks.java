package gaia.init;

import com.google.common.base.Preconditions;
import gaia.Gaia;
import gaia.GaiaReference;
import gaia.block.BlockBust;
import gaia.tileentity.TileEntityBust;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class GaiaBlocks {
	private GaiaBlocks() {}

	public static final Block BUST_SPHINX = new BlockBust(Material.ROCK, "bustSphinx");
	public static final Block BUST_VALKYRIE = new BlockBust(Material.ROCK, "bustValkyrie");
	public static final Block BUST_VAMPIRE = new BlockBust(Material.ROCK, "bustVampire");
	public static final Block DOLL_CREEPER_GIRL = new BlockBust(Material.CLOTH, "dollCreeperGirl");
	public static final Block DOLL_ENDER_GIRL = new BlockBust(Material.CLOTH, "dollEnderGirl");
	public static final Block DOLL_SLIME_GIRL = new BlockBust(Material.CLOTH, "dollSlimeGirl");
	public static final Block DOLL_MAID = new BlockBust(Material.CLOTH, "dollMaid");
	public static Block SpawnGuard;

	@SuppressWarnings("unused")
	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class RegistrationHandler {
		private RegistrationHandler() {}

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
			GameRegistry.registerTileEntity(TileEntityBust.class, new ResourceLocation(GaiaReference.MOD_ID, "tile_bust"));
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
			}
			Gaia.LOGGER.info("Item block registration complete.");
		}
	}
}
