package gaia.registry;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import gaia.GrimoireOfGaia;
import gaia.modifier.AddGaiaSpawnModifier;
import net.minecraft.util.random.Weighted;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class GaiaModifiers {
	public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, GrimoireOfGaia.MOD_ID);

	public static final Supplier<MapCodec<AddGaiaSpawnModifier>> ADD_GAIA_SPAWN = BIOME_MODIFIER_SERIALIZERS.register("add_configured_spawns", () ->
			RecordCodecBuilder.mapCodec(builder -> builder.group(
					Biome.LIST_CODEC.listOf().fieldOf("whitelist").forGetter(AddGaiaSpawnModifier::biomes),
					Biome.LIST_CODEC.listOf().fieldOf("blacklist").orElse(new ArrayList<>()).forGetter(AddGaiaSpawnModifier::biomeBlacklist),
					// Allow either a list or single spawner, attempting to decode the list format first.
					// Uses the better EitherCodec that logs both errors if both formats fail to parse.
					Codec.either(Weighted.codec(MobSpawnSettings.SpawnerData.CODEC).listOf(), Weighted.codec(MobSpawnSettings.SpawnerData.CODEC)).xmap(
							either -> either.map(Function.identity(), List::of), // convert list/singleton to list when decoding
							list -> list.size() == 1 ? Either.right(list.getFirst()) : Either.left(list) // convert list to singleton/list when encoding
					).fieldOf("spawners").forGetter(AddGaiaSpawnModifier::spawners)
			).apply(builder, AddGaiaSpawnModifier::new))
	);
}
