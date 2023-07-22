package gaia.registry;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import gaia.GrimoireOfGaia;
import gaia.modifier.AddGaiaSpawnModifier;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GaiaModifiers {
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, GrimoireOfGaia.MOD_ID);

	public static final RegistryObject<Codec<AddGaiaSpawnModifier>> ADD_GAIA_SPAWN = BIOME_MODIFIER_SERIALIZERS.register("add_configured_spawns", () ->
			RecordCodecBuilder.create(builder -> builder.group(
					Biome.LIST_CODEC.listOf().fieldOf("whitelist").forGetter(AddGaiaSpawnModifier::biomes),
					Biome.LIST_CODEC.listOf().fieldOf("blacklist").orElse(new ArrayList<>()).forGetter(AddGaiaSpawnModifier::biomeBlacklist),
					// Allow either a list or single spawner, attempting to decode the list format first.
					// Uses the better EitherCodec that logs both errors if both formats fail to parse.
					new ExtraCodecs.EitherCodec<>(MobSpawnSettings.SpawnerData.CODEC.listOf(), MobSpawnSettings.SpawnerData.CODEC).xmap(
							either -> either.map(Function.identity(), List::of), // convert list/singleton to list when decoding
							list -> list.size() == 1 ? Either.right(list.get(0)) : Either.left(list) // convert list to singleton/list when encoding
					).fieldOf("spawners").forGetter(AddGaiaSpawnModifier::spawners)
			).apply(builder, AddGaiaSpawnModifier::new))
	);
}
