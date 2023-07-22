package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.EnderGirlModel;
import gaia.client.renderer.layer.EnderGirlEyeLayer;
import gaia.entity.trader.EnderGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class EnderGirlRenderer extends MobRenderer<EnderGirl, EnderGirlModel> {
	public static final ResourceLocation ENDER_GIRL_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/ender_girl/ender_girl.png");

	public EnderGirlRenderer(Context context) {
		super(context, new EnderGirlModel(context.bakeLayer(ClientHandler.ENDER_GIRL)), ClientHandler.medShadow);
		this.addLayer(new EnderGirlEyeLayer(this));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(EnderGirl enderGirl) {
		return ENDER_GIRL_LOCATION;
	}
}
