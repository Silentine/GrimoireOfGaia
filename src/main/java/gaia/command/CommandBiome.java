package gaia.command;

import gaia.Gaia;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Set;

import javax.annotation.Nonnull;

public class CommandBiome extends CommandBase {

    private static final int CHUNK_SIZE = 16;

    @Override
    public @Nonnull
            String getName() {
        return "gog-biome";
    }

    @Override
    public @Nonnull
            String getUsage(@Nonnull ICommandSender sender) {
        return "<list|biomeId>";
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args) throws CommandException {
        final World world = sender.getEntityWorld();
        final EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();

        if (world.isRemote) {
            player.sendMessage(new TextComponentTranslation(TextFormatting.RED + "Not processing on Client side"));
            return;
        }

        if (args.length == 0) {
            server.getPlayerList()
                    .sendMessage(new TextComponentTranslation(TextFormatting.GRAY + "/gog-spawn <list|biomeId>"));
            return;
        }

        final String command = args[0].toLowerCase();

        if (isInteger(command)) {
            biomeDebug(server, sender, world, player, Integer.parseInt(command));
        } else {
            biomeList(server, sender, world, player, args);
        }
    }

    /**
     * Transforming nearby chunks for spawning debugging
     */
    private void biomeDebug(MinecraftServer server, ICommandSender sender, World world, EntityPlayer player, int biomeId) throws CommandException {
        if (biomeId <= -1 || Biome.getBiomeForId(biomeId) == null) {
            server.getPlayerList()
                    .sendMessage(new TextComponentTranslation(TextFormatting.RED + "Invalid Biome ID"));
            return;
        }

        Biome biome = Biome.getBiomeForId(biomeId);
        String biomeName = biome.getBiomeName();
        server.getPlayerList()
                .sendMessage(new TextComponentTranslation(
                        TextFormatting.GREEN + "Transforming Local Biomes to ID of :  " + biomeId + " : " + biomeName));
        server.getPlayerList()
                .sendMessage(new TextComponentTranslation(TextFormatting.GRAY + "You may have to reload your client"));

        biomeTypes(biome);

        BlockPos posp = player.getPosition();

        BlockPos pos = new BlockPos(posp.getX(), posp.getY(), posp.getZ());
        int max = 32;

        int start = -(max / 2);
        int start2 = -(max / 2);

        for (start = -(max / 2); start < max; ++start) {
            for (start2 = -(max / 2); start2 < max; ++start2) {

                pos = new BlockPos(posp.getX() + start, posp.getY(), posp.getZ() + start2);
                Chunk chunk = world.getChunkFromBlockCoords(pos);
                if (chunk != null) {

                    BlockPos c = getChunkLocationFromWorldLocation(pos.getX(), 0, pos.getZ());
                    int rx = c.getX();
                    int rz = c.getZ();
                    byte[] biomeArray = chunk.getBiomeArray();

                    biomeArray[rz << 4 | rx] = (byte) (biomeId & 255);

                    chunk.setModified(true);
                    world.getChunkProvider()
                            .provideChunk(chunk.x, chunk.z);

                    world.markBlockRangeForRenderUpdate(pos, pos);
                }
            }
        }
    }

    /**
     * Prints biome Dictionary Information and What Biomes are assigned to them
     */
    private void biomeList(MinecraftServer server, ICommandSender sender, World world, EntityPlayer player, String[] args) throws CommandException {
        showDictionaries();

        for (Biome biome : Biome.REGISTRY) {
            String name = biome.getBiomeName();
            int id = Biome.getIdForBiome(biome);
            Gaia.LOGGER.info(id + ": " + name);
            biomeTypes(biome);
        }

        server.getPlayerList()
                .sendMessage(new TextComponentTranslation(TextFormatting.GREEN + "Biome Listings Printed to Console"));
    }

    private void biomeTypes(Biome biome) {
        Set<BiomeDictionary.Type> map = BiomeDictionary.getTypes(biome);

        StringBuilder builder = new StringBuilder("Types: ");

        for (BiomeDictionary.Type type : map) {
            builder.append(type.toString())
                    .append(", ");
        }

        Gaia.LOGGER.info(builder.toString());
        Gaia.LOGGER.info(" ");
    }

    public static BlockPos getChunkLocationFromWorldLocation(int x, int y, int z) {
        return new BlockPos(x & (CHUNK_SIZE - 1), y, z & (CHUNK_SIZE - 1));
    }

    /**
     * Sloppy code but it works
     **/
    public void showDictionaries() {
        Set<Biome> forest = BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST);
        Set<Biome> sandy = BiomeDictionary.getBiomes(BiomeDictionary.Type.SANDY);
        Set<Biome> mesa = BiomeDictionary.getBiomes(BiomeDictionary.Type.MESA);
        Set<Biome> plains = BiomeDictionary.getBiomes(BiomeDictionary.Type.PLAINS);
        Set<Biome> swamp = BiomeDictionary.getBiomes(BiomeDictionary.Type.SWAMP);
        Set<Biome> spooky = BiomeDictionary.getBiomes(BiomeDictionary.Type.SPOOKY);
        Set<Biome> jungle = BiomeDictionary.getBiomes(BiomeDictionary.Type.JUNGLE);
        Set<Biome> snowy = BiomeDictionary.getBiomes(BiomeDictionary.Type.SNOWY);
        Set<Biome> mountain = BiomeDictionary.getBiomes(BiomeDictionary.Type.MOUNTAIN);
        Set<Biome> hill = BiomeDictionary.getBiomes(BiomeDictionary.Type.HILLS);

        Set<Biome> water = BiomeDictionary.getBiomes(BiomeDictionary.Type.WATER);

        Set<Biome> ocean = BiomeDictionary.getBiomes(BiomeDictionary.Type.OCEAN);
        Set<Biome> river = BiomeDictionary.getBiomes(BiomeDictionary.Type.RIVER);

        Set<Biome> beach = BiomeDictionary.getBiomes(BiomeDictionary.Type.BEACH);

        Set<Biome> hell = BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER);
        Set<Biome> sky = BiomeDictionary.getBiomes(BiomeDictionary.Type.END);

        String s = " type biomes include:";
        Gaia.LOGGER.info("Forest" + s);
        getTypes(forest);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Sandy" + s);
        getTypes(sandy);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Mesa" + s);
        getTypes(mesa);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Plains" + s);
        getTypes(plains);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Swamp" + s);
        getTypes(swamp);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Spooky" + s);
        getTypes(spooky);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Jungle" + s);
        getTypes(jungle);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Snowy" + s);
        getTypes(snowy);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Mountain" + s);
        getTypes(mountain);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Hills" + s);
        getTypes(hill);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Waters" + s);
        getTypes(water);
        Gaia.LOGGER.info("");

        Gaia.LOGGER.info("Ocean" + s);
        getTypes(ocean);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("River" + s);
        getTypes(river);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Beach" + s);
        getTypes(beach);
        Gaia.LOGGER.info("");

        Gaia.LOGGER.info("Hell" + s);
        getTypes(hell);
        Gaia.LOGGER.info("");
        Gaia.LOGGER.info("Sky" + s);
        getTypes(sky);
        Gaia.LOGGER.info("");
    }

    private void getTypes(Set<Biome> biomes) {
        for (Biome biome : biomes) {
            Gaia.LOGGER.info(biome.getBiomeName());
        }
    }

    /**
     * Number Check
     */
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
