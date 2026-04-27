package gaia;

import net.minecraft.resources.Identifier;

public class Reference {
	public static final String SUMMONED_TAG = GrimoireOfGaia.MOD_ID + "_staff_summoned";
	public static final String SUMMONER_TAG = GrimoireOfGaia.MOD_ID + "_staff_summoner";

	public static Identifier modLoc(String path) {
		return GrimoireOfGaia.modLoc(path);
	}
}
