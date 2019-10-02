package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import gaia.block.BlockBust;
import gaia.block.BlockDecoration;
import gaia.block.BlockFireCamp;
import gaia.block.BlockSpawnGuard;
import gaia.block.BlockWebTemp;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GaiaReference.MOD_ID)
public class GaiaBlocks {
    public static Block BUST_SPHINX;
    public static Block BUST_VALKYRIE;
    public static Block BUST_VAMPIRE;
    public static Block BUST_MINOTAUR;
    public static Block DOLL_CREEPER_GIRL;
    public static Block DOLL_ENDER_GIRL;
    public static Block DOLL_SLIME_GIRL;
    public static Block DOLL_MAID;
    public static Block DECO_GARDEN_GNOME;
    public static Block DECO_MANDRAGORA_POT;
    public static Block DECO_NEST_HARPY;
    public static Block SPAWN_GUARD;
    public static Block WEB_TEMP;
    public static Block FIRE_CAMP;

    public static ArrayList<Block> BLOCKS = new ArrayList<>();

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        Gaia.LOGGER.info("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();

        BUST_SPHINX = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "bust_sphinx");
        BUST_VALKYRIE = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "bust_valkyrie");
        BUST_VAMPIRE = registerBlock(new BlockBust(Block.Properties.create(Material.ROCK)), "bust_vampire");
        BUST_MINOTAUR = registerBlock(new BlockDecoration(Block.Properties.create(Material.ROCK)), "bust_minotaur");
        DOLL_CREEPER_GIRL = registerBlock(new BlockBust(Block.Properties.create(Material.WOOL)), "doll_creeper_girl");
        DOLL_ENDER_GIRL = registerBlock(new BlockBust(Block.Properties.create(Material.WOOL)), "doll_ender_girl");
        DOLL_SLIME_GIRL = registerBlock(new BlockBust(Block.Properties.create(Material.WOOL)), "doll_slime_girl");
        DOLL_MAID = registerBlock(new BlockBust(Block.Properties.create(Material.WOOL)), "doll_maid");
        DECO_GARDEN_GNOME =  registerBlock(new BlockDecoration(Block.Properties.create(Material.WOOL)), "deco_garden_gnome");
        DECO_MANDRAGORA_POT =  registerBlock(new BlockDecoration(Block.Properties.create(Material.WOOL)), "deco_pot_mandragora");
        DECO_NEST_HARPY = registerBlock(new BlockDecoration(Block.Properties.create(Material.LEAVES)), "deco_nest_harpy");
        SPAWN_GUARD =  registerBlock(new BlockSpawnGuard(Block.Properties.create(Material.WOOL)), "spawn_guard");
        WEB_TEMP =  registerHiddenBlock(new BlockWebTemp(Block.Properties.create(Material.WEB)), "web_temp");
        FIRE_CAMP = registerHiddenBlock(new BlockFireCamp(Block.Properties.create(Material.FIRE)), "fire_camp");

        registry.registerAll(BLOCKS.toArray(new Block[0]));
        Gaia.LOGGER.info("Block registration complete.");
    }

    public static <T extends Block> T registerBlock(T block, String registry)
    {
        block.setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, registry));
        return registerBlock(block, new BlockItem(block, itemBuilder().group(GaiaItemGroups.BLOCKS)));
    }

    public static <T extends Block> T registerHiddenBlock(T block, String registry)
    {
        block.setRegistryName(new ResourceLocation(GaiaReference.MOD_ID, registry));
        return registerBlock(block, new BlockItem(block, itemBuilder()));
    }

    private static Item.Properties itemBuilder()
    {
        return new Item.Properties();
    }

    public static <T extends Block> T registerBlock(T block, BlockItem item)
    {
        item.setRegistryName(((BlockItem) item).getBlock().getRegistryName());
        GaiaItems.ITEMS.add(item);
        BLOCKS.add(block);
        return block;
    }
}
