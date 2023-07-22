package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.TraderModel;
import gaia.entity.trader.Trader;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class TraderRenderer extends MobRenderer<Trader, TraderModel> {
	public static final ResourceLocation TRADER_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/trader/trader.png");

	public TraderRenderer(Context context) {
		super(context, new TraderModel(context.bakeLayer(ClientHandler.TRADER)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Trader trader) {
		return TRADER_LOCATION;
	}
}
