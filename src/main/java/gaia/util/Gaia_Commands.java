package gaia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gaia.ConfigGaia;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;


/**http://jabelarminecraft.blogspot.com/p/minecraft-forge-172.html
 * 
 * Adds Player command events for gaia
 * **/
public class Gaia_Commands implements ICommand{

	
	private final List aliases;
	  
    public Gaia_Commands() 
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
	//Master Command Delegator 
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		if(!ConfigGaia.Debug_Commands){
			sender.addChatMessage(new TextComponentTranslation(TextFormatting.RED +"Gaia Developer commands aren't enabled"));
			return;}
		World world = sender.getEntityWorld(); 
		EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
		if (world.isRemote) { 
            System.out.println("Not processing on Client side"); 
            	}
		else{
			 //sender.addChatMessage(new TextComponentTranslation(args[0]));
			if(args.length == 0){ failed(sender); return;}
			if((args[0].equalsIgnoreCase("spawn")||(args[0].equalsIgnoreCase("summon")))){
				if(spawn_Command(server, sender, world, player, args))return;
			}
			if((args[0].equalsIgnoreCase("biome"))){
				if(biome_Command(server, sender, world, player, args))return;
			}
			else{failed(sender); return;}
			}		
	}
	
	//Spawn commmand delegator
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
	//Biome command delegator
	private boolean biome_Command(MinecraftServer server, ICommandSender sender,
			World world, EntityPlayer player, String[] args) throws CommandException{
		if((args[1].equalsIgnoreCase("listing")) ||
				(args[1].equalsIgnoreCase("list")))
		{
			biome_List(server, sender, world, player, args);
			//sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Debugging"));
			return true;
		}
		
		if((args[1].equalsIgnoreCase("debug")))
		{
			biome_Debug(server, sender, world, player, args);
			//sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Debugging"));
			return true;
		}
		else{return false;}
		
	}
	//Prints registered Biomes
	private void biome_List(MinecraftServer server, ICommandSender sender,
			World world, EntityPlayer player, String[] args) throws CommandException{
		
        for (Biome biome : getBiomes()) {
        	String name = biome.getBiomeName();
        	int id = biome.getIdForBiome(biome);
            Gaia.logger.info(id+ ": "+ name);
        }
        sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Biome Listings Printed to Console"));
		
	}
	//Command check
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
	public void biome_Debug(MinecraftServer server, ICommandSender sender,
			World world, EntityPlayer player, String[] args) throws CommandException{
		
		String commandy = args[2].toString();
		if(isInteger(commandy)){
			
		int BIOME_ID = Integer.parseInt(commandy);
			if(BIOME_ID <= -1 ||
					Biome.getBiomeForId(BIOME_ID) == null){
				Invalid_Biome(sender); return;
			}
			Biome biome = Biome.getBiomeForId(BIOME_ID);
			String biomeName = biome.getBiomeName();
			sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Transforming Local Biomes to ID of :  "+BIOME_ID+" : "+biomeName));
			sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"You may have to reload your client"));
		
		
		BlockPos posp = player.getPosition();	
		
		BlockPos pos = new BlockPos (posp.getX(), posp.getY(), posp.getZ());
		int max = 64;
		
		
		int start = -(max/2);
		int start2 = -(max/2);
		
		for(start = -(max/2); start < max; ++start){
			for(start2 = -(max/2); start2 < max; ++start2){
			
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
		else{failed(sender);}return;
        
	}
	
	
	 public Iterable<Biome> getBiomes() {
	        return Biome.REGISTRY;
	    }
	 
	 //TODO clean up here
	 /**
	 public Biome getBiome(int id) {
		 		Biome biome = Biome.getBiomeForId(id);
		 		System.out.println(biome);
	            String biomeName = biome.getBiomeName();
	            System.out.println(biomeName);
	            if(Biome.REGISTRY.containsKey(new ResourceLocation(biomeName))) {
	                return Biome.REGISTRY.getObject(new ResourceLocation(biomeName));
	            }
	            System.out.println("FAILED");
	            return null;
	    }
	**/
	public static final int CHUNK_SIZE = 16;
	
	public static BlockPos getChunkLocationFromWorldLocation(int x, int y, int z) {
		return new BlockPos(x & (CHUNK_SIZE - 1), y, z & (CHUNK_SIZE - 1));
	}
	
	
	
	/** Dynamically spawns mobs based on egg mappings **/
	public static  int spawn_mobs(World world, EntityPlayer player) {
		int IDs;
		int Max = GaiaEntity.MaxEgg;
		int amount= 0;
		
		for(IDs = 0; IDs < Max+1; ++IDs){
			
			if (ItemGaiaSpawnEgg.idToEgg.containsKey(IDs)) {
				
				ItemGaiaSpawnEgg.spawnCreature(world, IDs, player.posX, player.posY, player.posZ);
				amount++;
				}
			
		}				
		return amount;
	}
	/** Statically Spawns all Npcs**/
	public void spawn_npc(World world, EntityPlayer player){
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
	
	public void spawnit(Entity entityspawning, EntityPlayer player){
		entityspawning.setLocationAndAngles(player.posX, player.posY, player.posZ, 0,0); 
		player.worldObj.spawnEntityInWorld(entityspawning);
	}
		
	public void failed(ICommandSender sender){
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.RED +"Invalid argument try...")); 
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"/gaia spawn <npc, mob>")); 
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"/gaia biome list")); 
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"/gaia biome debug <Biome ID>")); 
		return;
	}
	public void Invalid_Biome(ICommandSender sender){
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.RED +"Invalid Biome ID"));
		return;
	}
	
	//Required stuff
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
		
		return player.isCreative();
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
