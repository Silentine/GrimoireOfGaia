package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.HunterModel;
import gaia.client.state.HunterRenderState;
import gaia.entity.Hunter;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class HunterRenderer extends MobRenderer<Hunter, HunterRenderState, HunterModel> {
	public static final Identifier[] HUNTER_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/hunter/hunter.png")};

	public HunterRenderer(Context context) {
		super(context, new HunterModel(context.bakeLayer(ClientHandler.HUNTER)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public HunterRenderState createRenderState() {
		return new HunterRenderState();
	}

	@Override
	public void extractRenderState(Hunter entity, HunterRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.isAggressive = entity.isAggressive();
	}

	@Override
	public Identifier getTextureLocation(HunterRenderState renderState) {
		return HUNTER_LOCATIONS[renderState.variant];
	}
}
