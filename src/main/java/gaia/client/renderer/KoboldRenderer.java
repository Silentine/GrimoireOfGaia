package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.KoboldModel;
import gaia.client.state.KoboldRenderState;
import gaia.entity.Kobold;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class KoboldRenderer extends MobRenderer<Kobold, KoboldRenderState, KoboldModel> {
	public static final Identifier[] KOBOLD_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/kobold/kobold01.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/kobold/kobold02.png")};

	public KoboldRenderer(Context context) {
		super(context, new KoboldModel(context.bakeLayer(ClientHandler.KOBOLD)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public KoboldRenderState createRenderState() {
		return new KoboldRenderState();
	}

	@Override
	public void extractRenderState(Kobold entity, KoboldRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isAggressive = entity.isAggressive();
	}

	@Override
	public Identifier getTextureLocation(KoboldRenderState renderState) {
		return KOBOLD_LOCATIONS[renderState.variant];
	}
}
