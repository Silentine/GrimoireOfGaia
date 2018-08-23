package gaia.datafixes;

import com.google.common.collect.ImmutableMap;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.MissingMappings;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

import java.util.Map;

public class EntityIdFixer implements IFixableData {
	private final Map<String, String> mapping = new ImmutableMap.Builder<String, String>()
			.put("grimoireofgaia:boneknight", "grimoireofgaia:bone_knight")
			.put("grimoireofgaia:cobblegolem", "grimoireofgaia:cobble_golem")
			.put("grimoireofgaia:cobblestonegolem", "grimoireofgaia:cobblestone_golem")
			.put("grimoireofgaia:cyanflower", "grimoireofgaia:cyan_flower")
			.put("grimoireofgaia:enderdragongirl", "grimoireofgaia:ender_dragon_girl")
			.put("grimoireofgaia:endereye", "grimoireofgaia:ender_eye")
			.put("grimoireofgaia:fleshlich", "grimoireofgaia:flesh_lich")
			.put("grimoireofgaia:futakuchionna", "grimoireofgaia:futakuchi_onna")
			.put("grimoireofgaia:ninetails", "grimoireofgaia:nine_tails")
			.put("grimoireofgaia:sludgegirl", "grimoireofgaia:sludge_girl")
			.put("grimoireofgaia:withercow", "grimoireofgaia:wither_cow")
			.put("grimoireofgaia:creepergirl", "grimoireofgaia:creeper_girl")
			.put("grimoireofgaia:slimegirl", "grimoireofgaia:slime_girl")
			.put("grimoireofgaia:endergirl", "grimoireofgaia:ender_girl")
			.put("grimoireofgaia:smallfireball", "grimoireofgaia:small_fireball")
			.build();

	public EntityIdFixer() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public int getFixVersion() {
		return 2;
	}

	@Override
	public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
		String oldId = compound.getString("id");
		if (mapping.containsKey(oldId)) {
			compound.setString("id", mapping.get(oldId));
		}
		return compound;
	}

	@SubscribeEvent
	public void missingMapping(MissingMappings<EntityEntry> event) {
		for (MissingMappings.Mapping<EntityEntry> entry : event.getAllMappings()) {
			if (mapping.keySet().contains(entry.key.toString())) {
				entry.ignore();
			}
		}
	}
}
