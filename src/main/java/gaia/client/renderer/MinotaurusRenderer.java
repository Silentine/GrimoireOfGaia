package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MinotaurusModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.client.state.MinotaurusRenderState;
import gaia.entity.Minotaurus;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class MinotaurusRenderer extends MobRenderer<Minotaurus, MinotaurusRenderState, MinotaurusModel> {
	public static final Identifier[] MINOTAURUS_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/minotaurus/minotaurus01.png"),
			GrimoireOfGaia.modLoc("textures/entity/minotaurus/minotaurus02.png")};

	public MinotaurusRenderer(Context context) {
		super(context, new MinotaurusModel(context.bakeLayer(ClientHandler.MINOTAURUS)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new AuraLayer<>(this, () -> new MinotaurusModel(context.bakeLayer(ClientHandler.MINOTAURUS))));
	}

	@Override
	public MinotaurusRenderState createRenderState() {
		return new MinotaurusRenderState();
	}

	@Override
	public void extractRenderState(Minotaurus entity, MinotaurusRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isAggressive = entity.isAggressive();
		state.powered = entity.isPowered();
	}

	@Override
	public Identifier getTextureLocation(MinotaurusRenderState renderState) {
		return MINOTAURUS_LOCATIONS[renderState.variant];
	}
}
