package gaia.command;

import static net.minecraft.item.ItemMonsterPlacer.spawnCreature;

import javax.annotation.Nonnull;

import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.entity.passive.EntityGaiaNPCTrader;
import gaia.entity.passive.EntityGaiaNPCWeresheep;
import gaia.init.GaiaEntities;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class CommandSpawn extends CommandBase {

    @Override
    public @Nonnull
            String getName() {
        return "gog-spawn";
    }

    @Override
    public @Nonnull
            String getUsage(@Nonnull ICommandSender sender) {
        return "<npc|mob>";
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
                    .sendMessage(new TextComponentTranslation(TextFormatting.GRAY + "/gog-spawn <npc|mob>"));
            return;
        }

        final String command = args[0].toLowerCase();
        switch (command) {
            case "npc": {
                spawnNpcs(world, player);
                server.getPlayerList()
                        .sendMessage(new TextComponentTranslation(TextFormatting.GREEN + "Summoning: npcs"));
                break;
            }
            case "mob": {
                final int count = spawnMobs(world, player);

                server.getPlayerList()
                        .sendMessage(new TextComponentTranslation(
                                TextFormatting.GREEN + "Summoning: " + TextFormatting.ITALIC + "" + TextFormatting.GRAY + count
                                        + TextFormatting.RESET +
                                        TextFormatting.GREEN + " mobs"));
                break;
            }
        }
    }

    /**
     * Statically Spawns all NPCs
     */
    private void spawnNpcs(World world, EntityPlayer player) {
        spawnIt(new EntityGaiaNPCCreeperGirl(world), player);
        spawnIt(new EntityGaiaNPCEnderGirl(world), player);
        spawnIt(new EntityGaiaNPCHolstaurus(world), player);
        spawnIt(new EntityGaiaNPCSlimeGirl(world), player);
        spawnIt(new EntityGaiaNPCTrader(world), player);
        spawnIt(new EntityGaiaNPCWeresheep(world), player);
    }

    private void spawnIt(Entity entity, EntityPlayer player) {
        entity.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
        player.world.spawnEntity(entity);
    }

    /**
     * Dynamically spawns mobs based on egg mappings
     */
    private int spawnMobs(World worldIn, EntityPlayer playerIn) {
        int count = 0;
        for (EntityEntry entry : GaiaEntities.ENTITIES) {
            if (entry.getEgg() != null) {
                count++;
                spawnCreature(worldIn, entry.getRegistryName(), playerIn.posX, playerIn.posY, playerIn.posZ);
            }
        }

        return count;
    }
}
