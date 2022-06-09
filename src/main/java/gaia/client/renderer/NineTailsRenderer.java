package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.NineTailsModel;
import gaia.entity.NineTails;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class NineTailsRenderer extends MobRenderer<NineTails, NineTailsModel> {
	public static final ResourceLocation[] NINE_TAILS_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/nine_tails/nine_tails.png")};

	public NineTailsRenderer(Context context) {
		super(context, new NineTailsModel(context.bakeLayer(ClientHandler.NINE_TAILS)), ClientHandler.smallShadow);
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(NineTails kobold) {
		return NINE_TAILS_LOCATIONS[kobold.getVariant()];
	}
}
