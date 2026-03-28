package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class GaiaDataSerializers {
	public static final DeferredRegister<EntityDataSerializer<?>> DATA_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, GrimoireOfGaia.MOD_ID);

	public static final Supplier<EntityDataSerializer<Identifier>> RESOURCE_LOCATION = DATA_SERIALIZERS.register("resource_location", () ->
			EntityDataSerializer.forValueType(Identifier.STREAM_CODEC));

	public static final Supplier<EntityDataSerializer<Holder<MobEffect>>> MOB_EFFECT = DATA_SERIALIZERS.register("mob_effect_instance", () ->
			EntityDataSerializer.forValueType(ByteBufCodecs.holderRegistry(Registries.MOB_EFFECT)));
}
