package gaia.datafixes;

import com.google.common.collect.ImmutableMap;
import gaia.init.GaiaBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Tuple;
import net.minecraft.util.datafix.IFixableData;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;

public class BlockIdFixer implements IFixableData {
	private final Map<String, Tuple<String, Block>> mapping = new ImmutableMap.Builder<String, Tuple<String, Block>>()
			.put("grimoireofgaia:bustsphinx", new Tuple<>("grimoireofgaia:bust_sphinx", GaiaBlocks.BUST_SPHINX))
			.put("grimoireofgaia:bustvalkyrie", new Tuple<>("grimoireofgaia:bust_valkyrie", GaiaBlocks.BUST_VALKYRIE))
			.put("grimoireofgaia:bustvampire", new Tuple<>("grimoireofgaia:bust_vampire", GaiaBlocks.BUST_VAMPIRE))
			.put("grimoireofgaia:dollcreepergirl", new Tuple<>("grimoireofgaia:doll_creeper_girl", GaiaBlocks.DOLL_CREEPER_GIRL))
			.put("grimoireofgaia:dollendergirl", new Tuple<>("grimoireofgaia:doll_ender_girl", GaiaBlocks.DOLL_ENDER_GIRL))
			.put("grimoireofgaia:dollslimegirl", new Tuple<>("grimoireofgaia:doll_slime_girl", GaiaBlocks.DOLL_SLIME_GIRL))
			.put("grimoireofgaia:dollmaid", new Tuple<>("grimoireofgaia:doll_maid", GaiaBlocks.DOLL_MAID))
			.build();

	public BlockIdFixer() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void missingMapping(RegistryEvent.MissingMappings<Block> event) {
		for (RegistryEvent.MissingMappings.Mapping<Block> entry : event.getAllMappings()) {
			if (mapping.keySet().contains(entry.key.toString())) {
				entry.remap(mapping.get(entry.key.toString()).getSecond());
			}
		}
	}

	@SubscribeEvent
	public void missingItemMapping(RegistryEvent.MissingMappings<Item> event) {
		for (RegistryEvent.MissingMappings.Mapping<Item> entry : event.getAllMappings()) {
			if (mapping.keySet().contains(entry.key.toString())) {
				entry.ignore();
			}
		}
	}

	@Override
	public int getFixVersion() {
		return 3;
	}

	@Override
	public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
		String oldId = compound.getString("id");
		if (mapping.containsKey(oldId)) {
			compound.setString("id", mapping.get(oldId).getFirst());
		}
		return compound;
	}
}
