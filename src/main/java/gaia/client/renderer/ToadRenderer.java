package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.ToadModel;
import gaia.entity.Toad;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class ToadRenderer extends MobRenderer<Toad, ToadModel> {
	public static final ResourceLocation[] TOAD_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/toad/toad.png")};

	public ToadRenderer(Context context) {
		super(context, new ToadModel(context.bakeLayer(ClientHandler.TOAD)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Toad toad) {
		return TOAD_LOCATIONS[toad.getVariant()];
	}
}
