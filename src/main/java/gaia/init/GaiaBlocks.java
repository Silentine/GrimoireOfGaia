package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import gaia.block.BlockBust;
import gaia.block.BlockDecoration;
import gaia.block.BlockSpawnGuard;
import gaia.block.BlockWebTemp;
import gaia.tileentity.TileEntityBust;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(GaiaReference.MOD_ID)
public class GaiaBlocks {
	private GaiaBlocks() {
	}

	public static final Block BUST_SPHINX = Blocks.AIR;
	public static final Block BUST_VALKYRIE = Blocks.AIR;
	public static final Block BUST_VAMPIRE = Blocks.AIR;
	public static final Block DOLL_CREEPER_GIRL = Blocks.AIR;
	public static final Block DOLL_ENDER_GIRL = Blocks.AIR;
	public static final Block DOLL_SLIME_GIRL = Blocks.AIR;
	public static final Block DOLL_MAID = Blocks.AIR;
	public static final Block DECO_GARDEN_GNOME = Blocks.AIR;
	public static final Block DECO_MANDRAGORA_POT = Blocks.AIR;
	public static final Block SPAWN_GUARD = Blocks.AIR;
	public static final Block WEB_TEMP = Blocks.AIR;

	@SuppressWarnings("unused")
	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class RegistrationHandler {
		private RegistrationHandler() {
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			Gaia.LOGGER.info("Registering blocks...");
			IForgeRegistry<Block> registry = event.getRegistry();

			registry.register(new BlockBust(Material.ROCK, "bust_sphinx"));
			registry.register(new BlockBust(Material.ROCK, "bust_valkyrie"));
			registry.register(new BlockBust(Material.ROCK, "bust_vampire"));
			registry.register(new BlockBust(Material.ROCK, "doll_creeper_girl"));
			registry.register(new BlockBust(Material.ROCK, "doll_ender_girl"));
			registry.register(new BlockBust(Material.ROCK, "doll_slime_girl"));
			registry.register(new BlockBust(Material.ROCK, "doll_maid"));
			registry.register(new BlockDecoration(Material.CLOTH, "deco_garden_gnome"));
			registry.register(new BlockDecoration(Material.CLOTH, "deco_mandragora_pot"));
			registry.register(new BlockSpawnGuard());
			registry.register(new BlockWebTemp());

			GameRegistry.registerTileEntity(TileEntityBust.class, new ResourceLocation(GaiaReference.MOD_ID, "tile_bust"));
			Gaia.LOGGER.info("Block registration complete.");
		}

		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			Gaia.LOGGER.info("Registering item blocks...");

			IForgeRegistry<Item> registry = event.getRegistry();
			registerItemBlock(registry, BUST_SPHINX);
			registerItemBlock(registry, BUST_VALKYRIE);
			registerItemBlock(registry, BUST_VAMPIRE);
			registerItemBlock(registry, DOLL_CREEPER_GIRL);
			registerItemBlock(registry, DOLL_ENDER_GIRL);
			registerItemBlock(registry, DOLL_SLIME_GIRL);
			registerItemBlock(registry, DOLL_MAID);
			registerItemBlock(registry, DECO_GARDEN_GNOME);
			registerItemBlock(registry, DECO_MANDRAGORA_POT);
			registerItemBlock(registry, SPAWN_GUARD);
			registerItemBlock(registry, WEB_TEMP);

			Gaia.LOGGER.info("Item block registration complete.");
		}

		private static void registerItemBlock(IForgeRegistry<Item> registry, Block block) {
			Item item = new ItemBlock(block);
			ResourceLocation registryName = block.getRegistryName();
			// noinspection ConstantConditions
			registry.register(item.setRegistryName(registryName));
		}
	}
}
