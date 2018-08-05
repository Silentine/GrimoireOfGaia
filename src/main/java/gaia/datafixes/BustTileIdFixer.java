package gaia.datafixes;

import com.google.common.collect.ImmutableList;
import gaia.GaiaReference;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.datafix.IFixableData;

import java.util.List;

public class BustTileIdFixer implements IFixableData {
	private final List<String> tileIds = ImmutableList.of(
			"grimoireofgaia:bustSphinx",
			"grimoireofgaia:bustValkyrie",
			"grimoireofgaia:bustVampire",
			"grimoireofgaia:dollCreeperGirl",
			"grimoireofgaia:dollEnderGirl",
			"grimoireofgaia:dollSlimeGirl",
			"grimoireofgaia:dollMaid"
	);


	@Override
	public int getFixVersion() {
		return 1;
	}

	@Override
	public NBTTagCompound fixTagCompound(NBTTagCompound compound) {
		String oldId = compound.getString("id");
		if (tileIds.contains(oldId)) {
			compound.setString("id", GaiaReference.MOD_ID + ":" + "tile_bust");
		}
		return compound;	}
}
