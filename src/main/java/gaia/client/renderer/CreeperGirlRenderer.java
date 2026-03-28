package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CreeperGirlModel;
import gaia.client.state.CreeperGirlRenderState;
import gaia.entity.trader.CreeperGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class CreeperGirlRenderer extends MobRenderer<CreeperGirl, CreeperGirlRenderState, CreeperGirlModel> {
	public static final Identifier CREEPER_GIRL_LOCATION = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/creeper_girl/creeper_girl.png");

	public CreeperGirlRenderer(Context context) {
		super(context, new CreeperGirlModel(context.bakeLayer(ClientHandler.CREEPER_GIRL)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public CreeperGirlRenderState createRenderState() {
		return new CreeperGirlRenderState();
	}

	@Override
	public void extractRenderState(CreeperGirl entity, CreeperGirlRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(CreeperGirlRenderState renderState) {
		return CREEPER_GIRL_LOCATION;
	}
}
