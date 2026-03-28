package gaia.modifier;

import com.mojang.serialization.MapCodec;
import gaia.registry.GaiaModifiers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.util.random.Weighted;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.MobSpawnSettingsBuilder;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;

import java.util.List;

public record AddGaiaSpawnModifier(List<HolderSet<Biome>> biomes,
								   List<HolderSet<Biome>> biomeBlacklist,
								   List<Weighted<SpawnerData>> spawners) implements BiomeModifier {


	public static AddGaiaSpawnModifier singleSpawn(List<HolderSet<Biome>> biomes, List<HolderSet<Biome>> blacklistBiomes, Weighted<SpawnerData> spawner) {
		return new AddGaiaSpawnModifier(biomes, blacklistBiomes, List.of(spawner));
	}

	@Override
	public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
		if (phase == Phase.ADD) {
			MobSpawnSettingsBuilder spawns = builder.getMobSpawnSettings();
			if (biomes.stream().allMatch(biomeSet -> biomeSet.contains(biome)) &&
					(biomeBlacklist.isEmpty() || !biomeBlacklist.isEmpty() && biomeBlacklist.stream().noneMatch(biomeSet -> biomeSet.contains(biome)))) {
				for (Weighted<SpawnerData> spawner : this.spawners) {
//					GrimoireOfGaia.LOGGER.error("Adding {} to {}", ForgeRegistries.ENTITY_TYPES.getKey(spawner.type), biome.unwrapKey().get().location());
					spawns.addSpawn(MobCategory.MONSTER, spawner.weight(), spawner.value());
				}
			}
		}
	}

	@Override
	public MapCodec<? extends BiomeModifier> codec() {
		return GaiaModifiers.ADD_GAIA_SPAWN.get();
	}
}
