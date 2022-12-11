package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SprigganModel;
import gaia.client.renderer.layer.SprigganEyesLayer;
import gaia.entity.Spriggan;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SprigganRenderer extends MobRenderer<Spriggan, SprigganModel> {
	public static final ResourceLocation[] SPRIGGAN_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/spriggan/spriggan.png")};

	public SprigganRenderer(Context context) {
		super(context, new SprigganModel(context.bakeLayer(ClientHandler.SPRIGGAN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new SprigganEyesLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Spriggan spriggan) {
		return SPRIGGAN_LOCATIONS[spriggan.getVariant()];
	}
}
