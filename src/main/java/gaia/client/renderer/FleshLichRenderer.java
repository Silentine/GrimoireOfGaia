package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.FleshLichModel;
import gaia.client.state.FleshLichRenderState;
import gaia.entity.FleshLich;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class FleshLichRenderer extends MobRenderer<FleshLich, FleshLichRenderState, FleshLichModel> {
	public static final Identifier[] FLESH_LICH_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/flesh_lich/flesh_lich.png")};

	public FleshLichRenderer(Context context) {
		super(context, new FleshLichModel(context.bakeLayer(ClientHandler.FLESH_LICH)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public FleshLichRenderState createRenderState() {
		return new FleshLichRenderState();
	}

	@Override
	public void extractRenderState(FleshLich entity, FleshLichRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.animationState = entity.getAnimationState();
	}

	@Override
	public Identifier getTextureLocation(FleshLichRenderState renderState) {
		return FLESH_LICH_LOCATIONS[renderState.variant];
	}
}
