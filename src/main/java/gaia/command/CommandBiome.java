package gaia.command;

import gaia.Gaia;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Set;

public class CommandBiome extends CommandBase {

	@Override
	public String getName() {
		return "gog-biome";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "<list|biomeId>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		World world = sender.getEntityWorld();

		if (world.isRemote) {
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Not processing on Client side"));
			return;
		}

		if (args.length == 0) {
			sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "/gog-biome <list|biomeId>"));
			return;
		}

		String command = args[0].toLowerCase();

		Optional<Integer> biomeId = getBiomeIdFromArgument(command);
		if (biomeId.isPresent()) {
			biomeDebug(world, sender, biomeId.get());
		} else {
			biomeList(server);
		}
	}

	private static final Field BIOME_NAME = ReflectionHelper.findField(Biome.class, "biomeName", "field_76791_y");

	private String getBiomeName(Biome b) {
		try {
			return (String) BIOME_NAME.get(b);
		}
		catch (IllegalAccessException e) {
			Gaia.LOGGER.error(e);
		}
		return "";
	}

	/**
	 * Transforming nearby chunks for spawning debugging
	 */
	private void biomeDebug(World world, ICommandSender sender, int biomeId) {
		if (biomeId <= -1 || Biome.getBiomeForId(biomeId) == null) {
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Invalid Biome ID"));
			return;
		}

		EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
		if (player == null) {
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Non player command sender not supported"));
			return;
		}

		Biome biome = Biome.getBiomeForId(biomeId);
		String biomeName = getBiomeName(biome);
		sender.sendMessage(new TextComponentString(
				TextFormatting.GREEN + "Transforming Local Biomes to ID of :  " + biomeId + " : " + biomeName));
		sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "You may have to reload your client"));

		biomeTypes(biome);

		BlockPos posp = player.getPosition();

		int max = 32;

		for (int start = -(max / 2); start < max; ++start) {
			for (int start2 = -(max / 2); start2 < max; ++start2) {

				BlockPos pos = new BlockPos(posp.getX() + start, posp.getY(), posp.getZ() + start2);
				Chunk chunk = world.getChunk(pos);

				ChunkPos chunkPos = new ChunkPos(pos);
				int rx = chunkPos.x;
				int rz = chunkPos.z;
				byte[] biomeArray = chunk.getBiomeArray();

				biomeArray[rz << 4 | rx] = (byte) (biomeId & 255);

				chunk.setModified(true);
				world.getChunkProvider()
						.provideChunk(chunk.x, chunk.z);

				world.markBlockRangeForRenderUpdate(pos, pos);
			}
		}
	}

	/**
	 * Prints biome Dictionary Information and What Biomes are assigned to them
	 */
	private void biomeList(MinecraftServer server) {
		showDictionaries();

		for (Biome biome : Biome.REGISTRY) {
			String name = getBiomeName(biome);
			int id = Biome.getIdForBiome(biome);
			Gaia.LOGGER.info(id + ": " + name);
			biomeTypes(biome);
		}

		server.getPlayerList()
				.sendMessage(new TextComponentString(TextFormatting.GREEN + "Biome Listings Printed to Console"));
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

	/**
	 * Sloppy code but it works
	 **/
	private void showDictionaries() {
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
			Gaia.LOGGER.info(getBiomeName(biome));
		}
	}

	/**
	 * Number Check
	 */
	private Optional<Integer> getBiomeIdFromArgument(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		}
		catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
}
