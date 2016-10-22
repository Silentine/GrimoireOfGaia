package gaia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;


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

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		World world = sender.getEntityWorld(); 
		EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
		if (world.isRemote) { 
            System.out.println("Not processing on Client side"); 
            	}
		else{
			 //sender.addChatMessage(new TextComponentTranslation(args[0]));
			if(args.length == 0){ failed(sender); return;}
			if((args[0].equalsIgnoreCase("spawn")||(args[0].equalsIgnoreCase("summon")))){
				if((args[1].equalsIgnoreCase("npcs"))||
						(args[1].equalsIgnoreCase("npc")))
				{
					spawn_npc(world, player);
					sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Summoning: npcs"));
					return;
				}
				if((args[1].equalsIgnoreCase("mobs"))||
						(args[1].equalsIgnoreCase("mob")))
				{
					sender.addChatMessage(new TextComponentTranslation(TextFormatting.GREEN +"Summoning: "
							+ TextFormatting.ITALIC +""+ TextFormatting.GRAY + spawn_mobs(world, player)
							+ TextFormatting.RESET+ TextFormatting.GREEN + " mobs"));
				}
				else{failed(sender); return;}
			}	
			else{failed(sender); return;}
			}		
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
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.RED +"Invalid argument")); 
		sender.addChatMessage(new TextComponentTranslation(TextFormatting.GRAY +"Try /gaia spawn <npc, mob>")); 
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
