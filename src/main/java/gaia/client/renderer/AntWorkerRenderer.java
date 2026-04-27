package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.AntWorkerModel;
import gaia.client.state.AntWorkerRenderState;
import gaia.entity.AntWorker;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class AntWorkerRenderer extends GaiaBabyMobRenderer<AntWorker, AntWorkerRenderState, AntWorkerModel> {
	public static final Identifier[] ANUBIS_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/ant/ant01.png"),
			GrimoireOfGaia.modLoc("textures/entity/ant/ant02.png")
	};

	public AntWorkerRenderer(Context context) {
		super(context, new AntWorkerModel(context.bakeLayer(ClientHandler.ANT_WORKER)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public AntWorkerRenderState createRenderState() {
		return new AntWorkerRenderState();
	}

	@Override
	public void extractRenderState(AntWorker entity, AntWorkerRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(AntWorkerRenderState renderState) {
		return ANUBIS_LOCATIONS[renderState.variant];
	}
}
