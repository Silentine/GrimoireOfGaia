package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CreeperGirlModel;
import gaia.entity.trader.CreeperGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class CreeperGirlRenderer extends MobRenderer<CreeperGirl, CreeperGirlModel> {
	public static final ResourceLocation CREEPER_GIRL_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/creeper_girl/creeper_girl.png");

	public CreeperGirlRenderer(Context context) {
		super(context, new CreeperGirlModel(context.bakeLayer(ClientHandler.CREEPER_GIRL)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(CreeperGirl creeperGirl) {
		return CREEPER_GIRL_LOCATION;
	}
}
