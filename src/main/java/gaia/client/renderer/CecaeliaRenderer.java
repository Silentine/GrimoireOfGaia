package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CecaeliaModel;
import gaia.client.state.CecaeliaRenderState;
import gaia.entity.Cecaelia;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class CecaeliaRenderer extends MobRenderer<Cecaelia, CecaeliaRenderState, CecaeliaModel> {
	public static final Identifier[] CECAELIA_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/cecaelia/cecaelia.png")
	};

	public CecaeliaRenderer(Context context) {
		super(context, new CecaeliaModel(context.bakeLayer(ClientHandler.CECAELIA)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public CecaeliaRenderState createRenderState() {
		return new CecaeliaRenderState();
	}

	@Override
	public void extractRenderState(Cecaelia entity, CecaeliaRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.throwing = entity.isThrowing();
	}

	@Override
	public Identifier getTextureLocation(CecaeliaRenderState renderState) {
		return CECAELIA_LOCATIONS[renderState.variant];
	}
}
