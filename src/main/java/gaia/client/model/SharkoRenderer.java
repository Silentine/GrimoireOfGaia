package gaia.client.model;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.entity.Sharko;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SharkoRenderer extends MobRenderer<Sharko, SharkoModel> {
	public static final ResourceLocation[] SHARKO_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sharko/sharko.png")};

	public SharkoRenderer(Context context) {
		super(context, new SharkoModel(context.bakeLayer(ClientHandler.SHARKO)), ClientHandler.medShadow);
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Sharko sharko) {
		return SHARKO_LOCATIONS[sharko.getVariant()];
	}
}
