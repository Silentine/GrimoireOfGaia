package gaia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gaia.GaiaConfig;
import gaia.Gaia;
import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.entity.passive.EntityGaiaNPCTrader;
import gaia.entity.passive.EntityGaiaNPCWeresheep;
import gaia.init.GaiaEntity;
import gaia.items.ItemGaiaSpawnEgg;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/** Adds Player command events for Gaia
 * <p>Tutorial Source
 * <li>http://jabelarminecraft.blogspot.com/p/minecraft-forge-172.html
 */
public class GaiaICommand implements ICommand{

	private final List aliases;
	
	private static final int PERMISSION_LEVEL = 4;

	public GaiaICommand() 
	{ 
		aliases = new ArrayList(); 

		aliases.add("gaia"); 
		aliases.add("Gaia");        
		aliases.add("gog"); 
		aliases.add("Gog"); 
	}

	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "gaia";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "gaia <text>";
	}

	@Override
	public List<String> getCommandAliases() {

		return this.aliases;
	}

	/** Initial Text Hanlder for commands **/
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		if(!GaiaConfig.Debug_Commands) {
			sender.addChatMessage(new TextComponentTranslation(TextFormatting.RED +"Gaia Developer commands aren't enabled"));
			return;}
		World world = sender.getEntityWorld(); 
		EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
		if (world.isRemote) { 
			System.out.println("Not processing on Client side"); 
		}
		else{

			if(args.length == 0) { failed(sender); return;}
			if((args[0].equalsIgnoreCase("spawn")||(args[0].equalsIgnoreCase("summon")))) {
				if(spawn_Command(server, sender, world, player, args))return;
			}
			if((args[0].equalsIgnoreCase("biome"))) {
				if(biome_Command(server, sender, world, player, args))return;
			}
			else{failed(sender); return;}
		}		
	}

	/** 
	 * Text Handling for Spawn Commands 
	 */
	public boolean spawn_Command(MinecraftServer server, ICommandSender sender, World world, EntityPlayer player, String[] args) throws CommandException{

		if((args[1].equalsIgnoreCase("npcs"))||
				(args[1].equalsIgnoreCase("npc")))
		{
			spawn_npc(world, player);
			sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Summoning: npcs"));
			return true;
		}
		if((args[1].equalsIgnoreCase("mobs"))||
				(args[1].equalsIgnoreCase("mob")))
		{
			sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Summoning: "
					+ TextFormatting.ITALIC +""+ TextFormatting.GRAY + spawn_mobs(world, player)
					+ TextFormatting.RESET+ TextFormatting.GREEN + " mobs"));
			return true;
		}
		else{return false;}
	}

	/** 
	 * Text Handling for Biome Debugger Commands 
	 */
	private boolean biome_Command(MinecraftServer server, ICommandSender sender,
			World world, EntityPlayer player, String[] args) throws CommandException{
		if((args[1].equalsIgnoreCase("listing")) ||
				(args[1].equalsIgnoreCase("list")))
		{
			biome_List(server, sender, world, player, args);
			return true;
		}
		if(isInteger(args[1]))
		{
			biome_Debug(server, sender, world, player, args);
			return true;
		}
		else{return false;}

	}

	/** 
	 * Prints biome Dictionary Information and What Biomes are assigned to them 
	 */
	private void biome_List(MinecraftServer server, ICommandSender sender,
			World world, EntityPlayer player, String[] args) throws CommandException{

		show_dictionaries();

		for (Biome biome : getBiomes()) {
			String name = biome.getBiomeName();
			int id = biome.getIdForBiome(biome);
			Gaia.logger.info(id+ ": "+ name);
			Biome_types(biome);
		}
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Biome Listings Printed to Console"));

	}

	/** 
	 * Number Check 
	 */
	public static boolean isInteger(String s) {
		try { 
			Integer.parseInt(s); 
		} catch(NumberFormatException e) {
			return false; 
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}	

	//debug result
	//Adapted from evilcraft code
	/**
	 * Transforming nearby chunks for spawning debugging 
	 */
	public void biome_Debug(MinecraftServer server, ICommandSender sender,
			World world, EntityPlayer player, String[] args) throws CommandException{

		String commandy = args[1].toString();
		int BIOME_ID = Integer.parseInt(commandy);
		if(BIOME_ID <= -1 ||
				Biome.getBiomeForId(BIOME_ID) == null) {
			Invalid_Biome(sender); return;
		}
		Biome biome = Biome.getBiomeForId(BIOME_ID);
		String biomeName = biome.getBiomeName();
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Transforming Local Biomes to ID of :  "+BIOME_ID+" : "+biomeName));
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"You may have to reload your client"));			

		Biome_types(biome);

		BlockPos posp = player.getPosition();	

		BlockPos pos = new BlockPos (posp.getX(), posp.getY(), posp.getZ());
		int max = 32;

		int start = -(max/2);
		int start2 = -(max/2);

		for(start = -(max/2); start < max; ++start) {
			for(start2 = -(max/2); start2 < max; ++start2) {

				pos = new BlockPos (posp.getX() + start, posp.getY(), posp.getZ() +start2);
				Chunk chunk = world.getChunkFromBlockCoords(pos);
				if(chunk != null) {

					BlockPos c = getChunkLocationFromWorldLocation(pos.getX(), 0, pos.getZ());
					int rx = c.getX();
					int rz = c.getZ();
					byte[] biomeArray = chunk.getBiomeArray();  


					biomeArray[rz << 4 | rx] = (byte)(BIOME_ID & 255);

					chunk.setChunkModified();
					world.getChunkProvider().provideChunk(chunk.xPosition, chunk.zPosition);

					world.markBlockRangeForRenderUpdate(pos, pos);            
				}
			}
		}               
	}

	public void Biome_types(Biome biome) {
		Type[] map = BiomeDictionary.getTypesForBiome(biome);		
		String messege = "Types: ";

		int size = map.length;		
		int iterate = 0;
		for(iterate = 0; iterate < size; ++iterate) {	
			messege = messege + (map[iterate]).toString()+", ";

		}		
		
		Gaia.logger.info(messege);
		Gaia.logger.info(" ");
	}

	public static void get_types(Biome[] biome) {
		int i ;  
		for (i = 0; i < biome.length; ++i) 
		{
			Gaia.logger.info(biome[i].getBiomeName());
		}
	}

	/** 
	 * Sloppy code but it works 
	 **/
	public void show_dictionaries() {
		Biome[] forest = BiomeDictionary.getBiomesForType(Type.FOREST);
		Biome[] sandy = BiomeDictionary.getBiomesForType(Type.SANDY);
		Biome[] mesa = BiomeDictionary.getBiomesForType(Type.MESA);
		Biome[] plains = BiomeDictionary.getBiomesForType(Type.PLAINS);
		Biome[] swamp = BiomeDictionary.getBiomesForType(Type.SWAMP);
		Biome[] spooky = BiomeDictionary.getBiomesForType(Type.SPOOKY);
		Biome[] jungle = BiomeDictionary.getBiomesForType(Type.JUNGLE);
		Biome[] snowy = BiomeDictionary.getBiomesForType(Type.SNOWY);
		Biome[] mountain = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);
		Biome[] hill = BiomeDictionary.getBiomesForType(Type.HILLS);

		Biome[] water = BiomeDictionary.getBiomesForType(Type.WATER);

		Biome[] ocean = BiomeDictionary.getBiomesForType(Type.OCEAN);
		Biome[] river = BiomeDictionary.getBiomesForType(Type.RIVER);

		Biome[] beach = BiomeDictionary.getBiomesForType(Type.BEACH);

		Biome[] hell = BiomeDictionary.getBiomesForType(Type.NETHER);
		Biome[] sky = BiomeDictionary.getBiomesForType(Type.END);

		String s = " type biomes include:";
		Gaia.logger.info("Forest"+s);
		get_types(forest);
		Gaia.logger.info("");		 
		Gaia.logger.info("Sandy"+s);
		get_types(sandy);
		Gaia.logger.info("");
		Gaia.logger.info("Mesa"+s);
		get_types(mesa);
		Gaia.logger.info("");
		Gaia.logger.info("Plains"+s);
		get_types(plains);
		Gaia.logger.info("");
		Gaia.logger.info("Swamp"+s);
		get_types(swamp);
		Gaia.logger.info("");
		Gaia.logger.info("Spooky"+s);
		get_types(spooky);
		Gaia.logger.info("");
		Gaia.logger.info("Jungle"+s);
		get_types(jungle);
		Gaia.logger.info("");
		Gaia.logger.info("Snowy"+s);
		get_types(snowy);
		Gaia.logger.info("");
		Gaia.logger.info("Mountain"+s);
		get_types(mountain);
		Gaia.logger.info("");
		Gaia.logger.info("Hills"+s);
		get_types(hill);
		Gaia.logger.info("");

		Gaia.logger.info("Ocean"+s);
		get_types(ocean);
		Gaia.logger.info("");
		Gaia.logger.info("River"+s);
		get_types(river);
		Gaia.logger.info("");
		Gaia.logger.info("Beach"+s);
		get_types(beach);
		Gaia.logger.info("");

		Gaia.logger.info("Hell"+s);
		get_types(hell);
		Gaia.logger.info("");
		Gaia.logger.info("Sky"+s);
		get_types(sky);
		Gaia.logger.info("");
	}

	//Evilcraft shortcuts
	public Iterable<Biome> getBiomes() {
		return Biome.REGISTRY;
	}	 
	public static final int CHUNK_SIZE = 16;

	public static BlockPos getChunkLocationFromWorldLocation(int x, int y, int z) {
		return new BlockPos(x & (CHUNK_SIZE - 1), y, z & (CHUNK_SIZE - 1));
	}

	/** 
	 * Dynamically spawns mobs based on egg mappings 
	 */
	public static  int spawn_mobs(World world, EntityPlayer player) {
		int IDs;
		int Max = GaiaEntity.MaxEgg;
		int amount= 0;

		for(IDs = 0; IDs < Max+1; ++IDs) {

			if (ItemGaiaSpawnEgg.idToEgg.containsKey(IDs)) {

				ItemGaiaSpawnEgg.spawnCreature(world, IDs, player.posX, player.posY, player.posZ);
				amount++;
			}
		}			
		
		return amount;
	}

	/** 
	 * Statically Spawns all NPCs
	 */
	public void spawn_npc(World world, EntityPlayer player) {
		Entity entity;
		entity = new EntityGaiaNPCCreeperGirl(world);
		spawnit(entity, player);
		entity = new EntityGaiaNPCEnderGirl(world);
		spawnit(entity, player);
		entity = new EntityGaiaNPCHolstaurus(world);
		spawnit(entity, player);
		entity = new EntityGaiaNPCSlimeGirl(world);
		spawnit(entity, player);
		entity = new EntityGaiaNPCTrader(world);
		spawnit(entity, player);
		entity = new EntityGaiaNPCWeresheep(world);
		spawnit(entity, player);
	}

	public void spawnit(Entity entityspawning, EntityPlayer player) {
		entityspawning.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,0); 
		player.worldObj.spawnEntityInWorld(entityspawning);
	}

	public void failed(ICommandSender sender) {
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.RED +"Invalid argument try...")); 
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"/gaia spawn <npc, mob>")); 
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"/gaia biome list")); 
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"/gaia biome <Biome ID>")); 
		return;
	}
	
	public void Invalid_Biome(ICommandSender sender) {
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.RED +"Invalid Biome ID"));
		return;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~Required stuff ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
	//EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
	//return player.isCreative();
		return sender.canCommandSenderUseCommand(PERMISSION_LEVEL, this.getCommandName());
	}

	@Override
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos pos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

}
