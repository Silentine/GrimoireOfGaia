package gaia.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

import java.util.List;
import java.util.Locale;

public class SpawningInfo {
	public final IntValue weight;
	public final IntValue minGroup;
	public final IntValue maxGroup;
	public final ConfigValue<List<? extends String>> spawnBiomes;
	public final BooleanValue invertList;

	public SpawningInfo(ForgeConfigSpec.Builder builder, String mobName, int weight, int minGroup, int maxGroup, List<? extends String> biomeList, boolean invertList) {
		String lowerCaseName = mobName.toLowerCase(Locale.ROOT);

		builder.comment(mobName + " settings")
				.push(mobName);
		this.weight = builder
				.comment("The spawning weight of " + mobName + "'s (0 = disabled) [default: " + weight + "]")
				.defineInRange(lowerCaseName + "Weight", weight, 0, Integer.MAX_VALUE);
		this.minGroup = builder
				.comment("The minimum number of " + mobName + "'s in a group [default: " + minGroup + "]")
				.defineInRange(lowerCaseName + "MinGroup", minGroup, 1, Integer.MAX_VALUE);
		this.maxGroup = builder
				.comment("The maximum number of " + mobName + "'s in a group [default: " + maxGroup + "]")
				.defineInRange(lowerCaseName + "MaxGroup", maxGroup, 1, Integer.MAX_VALUE);
		this.spawnBiomes = builder
				.comment("The biomes where " + mobName + "'s can spawn")
				.defineListAllowEmpty(List.of(lowerCaseName + "Biomes"), () -> biomeList, o -> (o instanceof String));
		this.invertList = builder
				.comment("Inverts the " + mobName + " biome list to become a blacklist instead [default: " + invertList + "]")
				.define(lowerCaseName + "InvertList", invertList);
		builder.pop();
	}

	public SpawningInfo(ForgeConfigSpec.Builder builder, String mobName, int weight, int minGroup, int maxGroup, List<? extends String> biomeList) {
		this(builder, mobName, weight, minGroup, maxGroup, biomeList, false);
	}

	public boolean isDisabled() {
		return weight.get() == 0;
	}
}