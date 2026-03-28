package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.OrcModel;
import gaia.client.state.OrcRenderState;
import gaia.entity.Orc;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class OrcRenderer extends MobRenderer<Orc, OrcRenderState, OrcModel> {
	public static final Identifier[] ORC_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/orc/orc01.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/orc/orc02.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/orc/orc03.png")};

	public OrcRenderer(Context context) {
		super(context, new OrcModel(context.bakeLayer(ClientHandler.ORC)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public OrcRenderState createRenderState() {
		return new OrcRenderState();
	}

	@Override
	public void extractRenderState(Orc entity, OrcRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.animationState = entity.getAnimationState();
	}

	@Override
	public Identifier getTextureLocation(OrcRenderState renderState) {
		return ORC_LOCATIONS[renderState.variant];
	}
}
