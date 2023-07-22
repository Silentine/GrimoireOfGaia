package gaia.modifier;

import com.mojang.serialization.Codec;
import gaia.GrimoireOfGaia;
import gaia.registry.GaiaModifiers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public record AddGaiaSpawnModifier(List<HolderSet<Biome>> biomes,
								   List<HolderSet<Biome>> biomeBlacklist,
								   List<SpawnerData> spawners) implements BiomeModifier {


	public static AddGaiaSpawnModifier singleSpawn(List<HolderSet<Biome>> biomes, List<HolderSet<Biome>> blacklistBiomes, SpawnerData spawner) {
		return new AddGaiaSpawnModifier(biomes, blacklistBiomes, List.of(spawner));
	}

	@Override
	public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
		if (phase == Phase.ADD) {
			MobSpawnSettingsBuilder spawns = builder.getMobSpawnSettings();
			if (biomes.stream().allMatch(biomeSet -> biomeSet.contains(biome)) &&
					(biomeBlacklist.isEmpty() || !biomeBlacklist.isEmpty() && biomeBlacklist.stream().noneMatch(biomeSet -> biomeSet.contains(biome)))) {
				for (SpawnerData spawner : this.spawners) {
					GrimoireOfGaia.LOGGER.error("Adding {} to {}", ForgeRegistries.ENTITY_TYPES.getKey(spawner.type), biome.unwrapKey().get().location());
					spawns.addSpawn(MobCategory.MONSTER, spawner);
				}
			}
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return GaiaModifiers.ADD_GAIA_SPAWN.get();
	}
}
