package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.YukiOnnaModel;
import gaia.entity.YukiOnna;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class YukiOnnaRenderer extends GaiaBabyMobRenderer<YukiOnna, YukiOnnaModel> {
	public static final ResourceLocation[] YUKI_ONNA_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/yuki_onna/yuki_onna.png")};

	public YukiOnnaRenderer(Context context) {
		super(context, new YukiOnnaModel(context.bakeLayer(ClientHandler.YUKI_ONNA)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(YukiOnna yukiOnna) {
		return YUKI_ONNA_LOCATIONS[yukiOnna.getVariant()];
	}
}
