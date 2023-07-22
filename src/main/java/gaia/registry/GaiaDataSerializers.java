package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.RegistryObject;

public class GaiaDataSerializers {
	public static final DeferredRegister<EntityDataSerializer<?>> DATA_SERIALIZERS = DeferredRegister.create(Keys.ENTITY_DATA_SERIALIZERS, GrimoireOfGaia.MOD_ID);

	public static final RegistryObject<EntityDataSerializer<ResourceLocation>> RESOURCE_LOCATION = DATA_SERIALIZERS.register("resource_location", () ->
			new EntityDataSerializer<ResourceLocation>() {
				@Override
				public void write(FriendlyByteBuf buf, ResourceLocation value) {
					buf.writeResourceLocation(value);
				}

				@Override
				public ResourceLocation read(FriendlyByteBuf buf) {
					return buf.readResourceLocation();
				}

				@Override
				public ResourceLocation copy(ResourceLocation value) {
					return new ResourceLocation(value.getNamespace(), value.getPath());
				}
			}
	);
}
