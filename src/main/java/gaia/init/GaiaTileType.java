package gaia.init;

import com.google.common.base.Preconditions;

import gaia.GaiaReference;
import gaia.tileentity.TileEntityBust;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GaiaReference.MOD_ID)
public class GaiaTileType {
	public static final TileEntityType<TileEntityBust> GAIA_BUST = register("gaia_bust_tile", TileEntityType.Builder.create(TileEntityBust::new));

	public static <T extends TileEntity> TileEntityType<T> register(String id, TileEntityType.Builder<T> builder) {
		TileEntityType<T> entitytype = builder.build(null);
		ResourceLocation name = new ResourceLocation(GaiaReference.MOD_ID, id);
		entitytype.setRegistryName(name);

		return entitytype;
	}
	   
	public static void register(TileEntityType<?> tile, String name, RegistryEvent.Register<TileEntityType<?>> event) {
		Preconditions.checkNotNull(tile, "registryName");
		event.getRegistry().register(tile);
	}
	
	@SubscribeEvent
	public static void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> event)
	{
		register(GAIA_BUST, "gaia_bust_tile", event);
	}
}
