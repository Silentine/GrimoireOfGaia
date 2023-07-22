package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.OniModel;
import gaia.entity.Oni;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class OniRenderer extends MobRenderer<Oni, OniModel> {
	public static final ResourceLocation[] ONI_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/oni/oni01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/oni/oni02.png")};

	public OniRenderer(Context context) {
		super(context, new OniModel(context.bakeLayer(ClientHandler.ONI)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Oni oni) {
		return ONI_LOCATIONS[oni.getVariant()];
	}
}
