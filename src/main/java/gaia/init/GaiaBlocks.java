package gaia.init;

import gaia.GaiaReference;
import gaia.block.BlockBust;
import gaia.block.BlockDecoration;
import gaia.block.BlockFireCamp;
import gaia.block.BlockSpawnGuard;
import gaia.block.BlockWebTemp;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GaiaBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, GaiaReference.MOD_ID);

    public static final RegistryObject<Block> BUST_SPHINX = BLOCKS.register("bust_sphinx", () -> new BlockBust(Block.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> BUST_VALKYRIE = BLOCKS.register("bust_valkyrie", () -> new BlockBust(Block.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> BUST_VAMPIRE = BLOCKS.register("bust_vampire", () -> new BlockBust(Block.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> BUST_MINOTAUR = BLOCKS.register("bust_minotaur", () -> new BlockDecoration(Block.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> DOLL_CREEPER_GIRL = BLOCKS.register("doll_creeper_girl", () -> new BlockBust(Block.Properties.create(Material.WOOL)));
    public static final RegistryObject<Block> DOLL_ENDER_GIRL = BLOCKS.register("doll_ender_girl", () -> new BlockBust(Block.Properties.create(Material.WOOL)));
    public static final RegistryObject<Block> DOLL_SLIME_GIRL = BLOCKS.register("doll_slime_girl", () -> new BlockBust(Block.Properties.create(Material.WOOL)));
    public static final RegistryObject<Block> DOLL_MAID = BLOCKS.register("doll_maid", () -> new BlockBust(Block.Properties.create(Material.WOOL)));
    public static final RegistryObject<Block> DECO_GARDEN_GNOME =  BLOCKS.register("deco_garden_gnome", () -> new BlockDecoration(Block.Properties.create(Material.WOOL)));
    public static final RegistryObject<Block> DECO_MANDRAGORA_POT =  BLOCKS.register("deco_pot_mandragora", () -> new BlockDecoration(Block.Properties.create(Material.WOOL)));
    public static final RegistryObject<Block> DECO_NEST_HARPY = BLOCKS.register("deco_nest_harpy", () -> new BlockDecoration(Block.Properties.create(Material.LEAVES)));
    public static final RegistryObject<Block> SPAWN_GUARD =  BLOCKS.register("spawn_guard", () -> new BlockSpawnGuard(Block.Properties.create(Material.WOOL)));

    //No ItemGroup
    public static final RegistryObject<Block> WEB_TEMP =  BLOCKS.register("web_temp", () -> new BlockWebTemp(Block.Properties.create(Material.WEB)));
    public static final RegistryObject<Block> FIRE_CAMP = BLOCKS.register("fire_camp", () -> new BlockFireCamp(Block.Properties.create(Material.FIRE)));
}
