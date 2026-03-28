package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CyclopsModel;
import gaia.client.state.CyclopsRenderState;
import gaia.entity.Cyclops;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class CyclopsRenderer extends MobRenderer<Cyclops, CyclopsRenderState, CyclopsModel> {
	public static final Identifier[] CYCLOPS_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/cyclops/cyclops.png")};

	public CyclopsRenderer(Context context) {
		super(context, new CyclopsModel(context.bakeLayer(ClientHandler.CYCLOPS)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public CyclopsRenderState createRenderState() {
		return new CyclopsRenderState();
	}

	@Override
	public void extractRenderState(Cyclops entity, CyclopsRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.isFleeing = entity.isFleeing();
	}

	@Override
	public Identifier getTextureLocation(CyclopsRenderState renderState) {
		return CYCLOPS_LOCATIONS[renderState.variant];
	}
}
