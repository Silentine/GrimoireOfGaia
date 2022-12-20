package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.BehenderModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.client.renderer.layer.BehenderEyesLayer;
import gaia.entity.Behender;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BehenderRenderer extends MobRenderer<Behender, BehenderModel> {
	public static final ResourceLocation[] BEHENDER_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/behender/behender.png")
	};

	public BehenderRenderer(Context context) {
		super(context, new BehenderModel(context.bakeLayer(ClientHandler.BEHENDER)), ClientHandler.smallShadow);
		this.addLayer(new BehenderEyesLayer(this));
		this.addLayer(new AuraLayer<>(this, () -> new BehenderModel(context.bakeLayer(ClientHandler.BEHENDER))));
	}

	@Override
	public ResourceLocation getTextureLocation(Behender behender) {
		return BEHENDER_LOCATIONS[behender.getVariant()];
	}
}
