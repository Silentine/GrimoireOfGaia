package gaia.entity;

import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

/**
 * https://github.com/Choonster/TestMod3/blob/7d877920df256a11d7797178addd8d9d32cf92c7/src/main/java/choonster/testmod3/init/ModLootTables.java
 **/

/**
 * Tutorial Source
 * <li>http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/2782328-forge-1-10-tutorial-how-to-add-and-manipulate
 * <br> <br>Registration and reference for new loot tables
 */
public class GaiaLootTableList {

    public static final ResourceLocation BAG_ARROW = register("loot_table_bagarrow");
    public static final ResourceLocation BOXES_IRON = register("loot_table_boxiron");
    public static final ResourceLocation BOXES_GOLD = register("loot_table_boxgold");
    public static final ResourceLocation BOXES_DIAMOND = register("loot_table_boxdiamond");
    public static final ResourceLocation BOXES_OVERWORLD = register("loot_table_box");
    public static final ResourceLocation BOXES_NETHER = register("loot_table_boxnether");
    public static final ResourceLocation BOXES_END = register("loot_table_boxend");

    private static ResourceLocation register(String id) {
        return LootTableList.register(new ResourceLocation(GaiaReference.MOD_ID, id));
    }
}
