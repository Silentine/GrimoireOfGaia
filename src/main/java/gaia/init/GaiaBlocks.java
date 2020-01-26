package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import gaia.block.BlockDecoration;
import gaia.block.BlockFireCamp;
import gaia.block.BlockSpawnGuard;
import gaia.block.BlockVanilla;
import gaia.block.BlockWebTemp;
import gaia.tileentity.TileEntityBust;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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

	public static final Block BLOCK_PEARL = Blocks.AIR;
	public static final Block BUST_GORGON = Blocks.AIR;
	public static final Block BUST_SPHINX = Blocks.AIR;
	public static final Block BUST_VALKYRIE = Blocks.AIR;
	public static final Block BUST_VAMPIRE = Blocks.AIR;
	public static final Block DOLL_CREEPER_GIRL = Blocks.AIR;
	public static final Block DOLL_ENDER_GIRL = Blocks.AIR;
	public static final Block DOLL_SLIME_GIRL = Blocks.AIR;
	public static final Block DOLL_MAID = Blocks.AIR;
	public static final Block DOLL_DULLAHAN = Blocks.AIR;
	public static final Block DOLL_MERMAID = Blocks.AIR;
	public static final Block DOLL_NINE_TAILS = Blocks.AIR;
	public static final Block DECO_GARDEN_GNOME = Blocks.AIR;
	public static final Block DECO_MANDRAGORA_POT = Blocks.AIR;
	public static final Block DECO_BUST_MINOTAUR = Blocks.AIR;
	public static final Block DECO_NEST_HARPY = Blocks.AIR;
	public static final Block SPAWN_GUARD = Blocks.AIR;
	public static final Block WEB_TEMP = Blocks.AIR;
	public static final Block FIRE_CAMP = Blocks.AIR;

	@SuppressWarnings("unused")
	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	public static class RegistrationHandler {
		private RegistrationHandler() {
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			Gaia.LOGGER.info("Registering blocks...");
			IForgeRegistry<Block> registry = event.getRegistry();

			registry.register(new BlockVanilla(Material.ROCK, "block_pearl", 1.5F, 10F, SoundType.STONE));
			registry.register(new BlockDecoration(Material.ROCK, "bust_gorgon", 1.5F, 6F, SoundType.STONE));
			registry.register(new BlockDecoration(Material.ROCK, "bust_sphinx", 1.5F, 6F, SoundType.STONE));
			registry.register(new BlockDecoration(Material.ROCK, "bust_valkyrie", 1.5F, 6F, SoundType.STONE));
			registry.register(new BlockDecoration(Material.ROCK, "bust_vampire", 1.5F, 6F, SoundType.STONE));
			registry.register(new BlockDecoration(Material.CLOTH, "doll_creeper_girl", 0.8F, 6F, SoundType.CLOTH));
			registry.register(new BlockDecoration(Material.CLOTH, "doll_ender_girl", 0.8F, 6F, SoundType.CLOTH));
			registry.register(new BlockDecoration(Material.CLOTH, "doll_slime_girl", 0.8F, 6F, SoundType.CLOTH));
			registry.register(new BlockDecoration(Material.CLOTH, "doll_maid", 0.8F, 6F, SoundType.CLOTH));
			registry.register(new BlockDecoration(Material.CLOTH, "doll_dullahan", 0.8F, 6F, SoundType.CLOTH));
			registry.register(new BlockDecoration(Material.CLOTH, "doll_mermaid", 0.8F, 6F, SoundType.CLOTH));
			registry.register(new BlockDecoration(Material.CLOTH, "doll_nine_tails", 0.8F, 6F, SoundType.CLOTH));
			registry.register(new BlockDecoration(Material.CLOTH, "deco_garden_gnome", 0.8F, 6F, SoundType.STONE));
			registry.register(new BlockDecoration(Material.CLOTH, "deco_mandragora_pot", 0.8F, 6F, SoundType.STONE));
			registry.register(new BlockDecoration(Material.ROCK, "deco_bust_minotaur", 1.5F, 6F, SoundType.STONE));
			registry.register(new BlockDecoration(Material.LEAVES, "deco_nest_harpy", 0.8F, 6F, SoundType.PLANT));
			registry.register(new BlockSpawnGuard());
			registry.register(new BlockWebTemp());
			registry.register(new BlockFireCamp());

			GameRegistry.registerTileEntity(TileEntityBust.class, new ResourceLocation(GaiaReference.MOD_ID, "tile_bust"));
			Gaia.LOGGER.info("Block registration complete.");
		}

		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			Gaia.LOGGER.info("Registering item blocks...");

			IForgeRegistry<Item> registry = event.getRegistry();
			registerItemBlock(registry, BLOCK_PEARL);
			registerItemBlock(registry, BUST_GORGON);
			registerItemBlock(registry, BUST_SPHINX);
			registerItemBlock(registry, BUST_VALKYRIE);
			registerItemBlock(registry, BUST_VAMPIRE);
			registerItemBlock(registry, DOLL_CREEPER_GIRL);
			registerItemBlock(registry, DOLL_ENDER_GIRL);
			registerItemBlock(registry, DOLL_SLIME_GIRL);
			registerItemBlock(registry, DOLL_MAID);
			registerItemBlock(registry, DOLL_DULLAHAN);
			registerItemBlock(registry, DOLL_MERMAID);
			registerItemBlock(registry, DOLL_NINE_TAILS);
			registerItemBlock(registry, DECO_GARDEN_GNOME);
			registerItemBlock(registry, DECO_MANDRAGORA_POT);
			registerItemBlock(registry, DECO_BUST_MINOTAUR);
			registerItemBlock(registry, DECO_NEST_HARPY);
			registerItemBlock(registry, SPAWN_GUARD);
			registerItemBlock(registry, WEB_TEMP);
			registerItemBlock(registry, FIRE_CAMP);

			Gaia.LOGGER.info("Item block registration complete.");
		}

		private static void registerItemBlock(IForgeRegistry<Item> registry, Block block) {
			Item item = new ItemBlock(block);
			ResourceLocation registryName = block.getRegistryName();
			registry.register(item.setRegistryName(registryName));
		}
	}
}
