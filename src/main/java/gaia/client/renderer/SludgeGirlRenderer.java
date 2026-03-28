package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SludgeGirlModel;
import gaia.client.renderer.layer.SludgeHairLayer;
import gaia.client.state.SludgeGirlRenderState;
import gaia.entity.SludgeGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.Identifier;

public class SludgeGirlRenderer extends MobRenderer<SludgeGirl, SludgeGirlRenderState, SludgeGirlModel> {
	public static final Identifier[] SLUDGE_GIRL_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/sludge_girl01.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/sludge_girl02.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/sludge_girl03.png")};

	public SludgeGirlRenderer(Context context) {
		super(context, new SludgeGirlModel(context.bakeLayer(ClientHandler.SLUDGE_GIRL)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new SludgeHairLayer(this, context.getModelSet()));
	}

	@Override
	public SludgeGirlRenderState createRenderState() {
		return new SludgeGirlRenderState();
	}

	@Override
	public void extractRenderState(SludgeGirl entity, SludgeGirlRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(SludgeGirlRenderState renderState) {
		return SLUDGE_GIRL_LOCATIONS[renderState.variant];
	}
}
