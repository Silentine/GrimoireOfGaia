package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.NagaModel;
import gaia.client.state.NagaRenderState;
import gaia.entity.Naga;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class NagaRenderer extends MobRenderer<Naga, NagaRenderState, NagaModel> {
	public static final Identifier[] NAGA_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/naga/naga.png")};

	public NagaRenderer(Context context) {
		super(context, new NagaModel(context.bakeLayer(ClientHandler.NAGA)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public NagaRenderState createRenderState() {
		return new NagaRenderState();
	}

	@Override
	public void extractRenderState(Naga entity, NagaRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.animationState = entity.getAnimationState();
	}

	@Override
	public Identifier getTextureLocation(NagaRenderState renderState) {
		return NAGA_LOCATIONS[renderState.variant];
	}
}
