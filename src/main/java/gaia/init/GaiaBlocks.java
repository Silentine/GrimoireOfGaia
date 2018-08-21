package gaia.init;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import gaia.Gaia;
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
import net.minecraft.block.Block;
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

public class GaiaBlocks {

    public static Block BustSphinx = new BlockBustSphinx();
    public static Block BustValkyrie = new BlockBustValkyrie();
    public static Block BustVampire = new BlockBustVampire();
    public static Block DollCreeperGirl = new BlockDollCreeperGirl();
    public static Block DollEnderGirl = new BlockDollEnderGirl();
    public static Block DollSlimeGirl = new BlockDollSlimeGirl();
    public static Block DollMaid = new BlockDollMaid();
    public static Block SpawnGuard;
    public static final String BUST_SPHINX_NAME = "bustSphinx";
    public static final String BUST_VALKYRIE_NAME = "bustValkyrie";
    public static final String BUST_VAMPIRE_NAME = "bustVampire";
    public static final String DOLL_CREEPER_GIRL_NAME = "dollCreeperGirl";
    public static final String DOLL_ENDER_GIRL_NAME = "dollEnderGirl";
    public static final String DOLL_SLIME_GIRL_NAME = "dollSlimeGirl";
    public static final String DOLL_MAID_NAME = "dollMaid";

    private static void registerTile() {
        registerTile(TileEntityBustSphinx.class, BUST_SPHINX_NAME);
        registerTile(TileEntityBustValkyrie.class, BUST_VALKYRIE_NAME);
        registerTile(TileEntityBustVampire.class, BUST_VAMPIRE_NAME);
        registerTile(TileEntityDollCreeperGirl.class, DOLL_CREEPER_GIRL_NAME);
        registerTile(TileEntityDollEnderGirl.class, DOLL_ENDER_GIRL_NAME);
        registerTile(TileEntityDollSlimeGirl.class, DOLL_SLIME_GIRL_NAME);
        registerTile(TileEntityDollMaid.class, DOLL_MAID_NAME);
    }

    @Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
    public static class RegistrationHandler {

        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            Gaia.LOGGER.info("Registering blocks...");
            final IForgeRegistry<Block> registry = event.getRegistry();

            final Block[] blocks = {
                    BustSphinx,
                    BustValkyrie,
                    BustVampire,
                    DollCreeperGirl,
                    DollEnderGirl,
                    DollSlimeGirl,
                    DollMaid
            };

            registry.registerAll(blocks);
            registerTile();
            Gaia.LOGGER.info("Block registration complete.");
        }

        @SubscribeEvent
        public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
            Gaia.LOGGER.info("Registering item blocks...");
            final ItemBlock[] items = {
                    new ItemBlock(BustSphinx),
                    new ItemBlock(BustValkyrie),
                    new ItemBlock(BustVampire),
                    new ItemBlock(DollCreeperGirl),
                    new ItemBlock(DollEnderGirl),
                    new ItemBlock(DollSlimeGirl),
                    new ItemBlock(DollMaid)
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
        GameRegistry.registerTileEntity(clazz, GaiaReference.MOD_PREFIX + key);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(BustSphinx);
        registerRender(BustValkyrie);
        registerRender(BustVampire);
        registerRender(DollCreeperGirl);
        registerRender(DollEnderGirl);
        registerRender(DollSlimeGirl);
        registerRender(DollMaid);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
