package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MatangoModel;
import gaia.entity.Matango;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class MatangoRenderer extends MobRenderer<Matango, MatangoModel> {
	public static final ResourceLocation[] MATANGO_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/matango/matango.png")};

	public MatangoRenderer(Context context) {
		super(context, new MatangoModel(context.bakeLayer(ClientHandler.MATANGO)), ClientHandler.smallShadow);
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Matango matango) {
		return MATANGO_LOCATIONS[matango.getVariant()];
	}
}
