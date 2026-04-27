package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.BansheeModel;
import gaia.client.renderer.layer.BansheeGlowLayer;
import gaia.client.state.BansheeRenderState;
import gaia.entity.Banshee;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class BansheeRenderer extends MobRenderer<Banshee, BansheeRenderState, BansheeModel> {
	public static final Identifier[] BANSHEE_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/banshee/banshee.png")};

	public BansheeRenderer(Context context) {
		super(context, new BansheeModel(context.bakeLayer(ClientHandler.BANSHEE)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new BansheeGlowLayer(this));
	}

	@Override
	public BansheeRenderState createRenderState() {
		return new BansheeRenderState();
	}

	@Override
	public void extractRenderState(Banshee entity, BansheeRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
	}

	@Override
	public Identifier getTextureLocation(BansheeRenderState renderState) {
		return BANSHEE_LOCATIONS[renderState.variant];
	}
}
