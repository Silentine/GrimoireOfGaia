package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries.Keys;

public class GaiaDataSerializers {
	public static final DeferredRegister<DataSerializerEntry> DATA_SERIALIZERS = DeferredRegister.create(Keys.DATA_SERIALIZERS, GrimoireOfGaia.MOD_ID);

	public static final EntityDataSerializer<ResourceLocation> RESOURCE_LOCATION = new EntityDataSerializer<>() {
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
	};

	static {
		DATA_SERIALIZERS.register("resource_location", () -> new DataSerializerEntry(RESOURCE_LOCATION));
	}
}
