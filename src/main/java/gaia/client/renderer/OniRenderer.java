package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.OniModel;
import gaia.client.state.OniRenderState;
import gaia.entity.Oni;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class OniRenderer extends MobRenderer<Oni, OniRenderState, OniModel> {
	public static final Identifier[] ONI_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/oni/oni01.png"),
			GrimoireOfGaia.modLoc("textures/entity/oni/oni02.png")};

	public OniRenderer(Context context) {
		super(context, new OniModel(context.bakeLayer(ClientHandler.ONI)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public OniRenderState createRenderState() {
		return new OniRenderState();
	}

	@Override
	public void extractRenderState(Oni entity, OniRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.buffed = entity.isBuffed();
	}

	@Override
	public Identifier getTextureLocation(OniRenderState renderState) {
		return ONI_LOCATIONS[renderState.variant];
	}
}
