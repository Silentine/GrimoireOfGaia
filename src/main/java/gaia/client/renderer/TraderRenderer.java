package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.TraderModel;
import gaia.client.state.TraderRenderState;
import gaia.entity.trader.Trader;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class TraderRenderer extends MobRenderer<Trader, TraderRenderState, TraderModel> {
	public static final Identifier TRADER_LOCATION = GrimoireOfGaia.modLoc("textures/entity/trader/trader.png");

	public TraderRenderer(Context context) {
		super(context, new TraderModel(context.bakeLayer(ClientHandler.TRADER)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public TraderRenderState createRenderState() {
		return new TraderRenderState();
	}

	@Override
	public void extractRenderState(Trader entity, TraderRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(TraderRenderState state) {
		return TRADER_LOCATION;
	}
}
