package gaia.command;

public class CommandSpawn { //extends CommandBase {

//	@Override
//	public String getName() {
//		return "gog-spawn";
//	}
//
//	@Override
//	public String getUsage(ICommandSender sender) {
//		return "<npc|mob>";
//	}
//
//	@Override
//	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
//		World world = sender.getEntityWorld();
//
//		if (world.isRemote) {
//			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Not processing on Client side"));
//			return;
//		}
//
//		EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
//		if (player == null) {
//			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Non player command sender not supported"));
//			return;
//		}
//
//		if (args.length == 0) {
//			sender.sendMessage(new TextComponentString(TextFormatting.GRAY + "/gog-spawn <npc|mob>"));
//			return;
//		}
//
//		String command = args[0].toLowerCase();
//		if (command.equals("npc")) {
//			spawnNpcs(world, player);
//			sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Summoning: npcs"));
//		} else if (command.equals("mob")) {
//			int count = spawnMobs(world, player);
//			sender.sendMessage(new TextComponentString(
//					TextFormatting.GREEN + "Summoning: " + TextFormatting.ITALIC + "" + TextFormatting.GRAY + count
//							+ TextFormatting.RESET + TextFormatting.GREEN + " mobs"));
//		}
//	}
//
//	/**
//	 * Statically Spawns all NPCs
//	 */
//	private void spawnNpcs(World world, EntityPlayer player) {
//		spawnIt(new EntityGaiaNPCCreeperGirl(world), player);
//		spawnIt(new EntityGaiaNPCEnderGirl(world), player);
//		spawnIt(new EntityGaiaNPCHolstaurus(world), player);
//		spawnIt(new EntityGaiaNPCSlimeGirl(world), player);
//		spawnIt(new EntityGaiaNPCTrader(world), player);
//		spawnIt(new EntityGaiaNPCWeresheep(world), player);
//	}
//
//	private void spawnIt(Entity entity, EntityPlayer player) {
//		entity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
//		player.world.spawnEntity(entity);
//	}
//
//	/**
//	 * Dynamically spawns mobs based on egg mappings
//	 */
//	private int spawnMobs(World world, EntityPlayer player) {
//		int count = 0;
//		for (EntityEntry entry : GaiaEntities.SPAWN_EGG_ENTITIES) {
//			if (entry.getEgg() != null) {
//				count++;
//				spawnCreature(world, entry.getRegistryName(), player.posX, player.posY, player.posZ);
//			}
//		}
//
//		return count;
//	}
}
