package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.BehenderModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.client.renderer.layer.BehenderEyesLayer;
import gaia.client.state.BehenderRenderState;
import gaia.entity.Behender;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class BehenderRenderer extends MobRenderer<Behender, BehenderRenderState, BehenderModel> {
	public static final Identifier[] BEHENDER_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/behender/behender.png")
	};

	public BehenderRenderer(Context context) {
		super(context, new BehenderModel(context.bakeLayer(ClientHandler.BEHENDER)), ClientHandler.smallShadow);
		this.addLayer(new BehenderEyesLayer(this));
		this.addLayer(new AuraLayer<>(this, () -> new BehenderModel(context.bakeLayer(ClientHandler.BEHENDER))));
	}

	@Override
	public BehenderRenderState createRenderState() {
		return new BehenderRenderState();
	}

	@Override
	public void extractRenderState(Behender entity, BehenderRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.powered = entity.isPowered();
	}

	@Override
	public Identifier getTextureLocation(BehenderRenderState renderState) {
		return BEHENDER_LOCATIONS[renderState.variant];
	}
}
