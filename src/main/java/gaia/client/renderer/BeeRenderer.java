package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.BeeModel;
import gaia.client.state.BeeRenderState;
import gaia.entity.Bee;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class BeeRenderer extends MobRenderer<Bee, BeeRenderState, BeeModel> {
	public static final Identifier[] BEE_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/bee/bee.png")};

	public BeeRenderer(Context context) {
		super(context, new BeeModel(context.bakeLayer(ClientHandler.BEE)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public BeeRenderState createRenderState() {
		return new BeeRenderState();
	}

	@Override
	public void extractRenderState(Bee entity, BeeRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.animationState = entity.getAnimationState();
		state.isRiding = entity.isVehicle();
	}

	@Override
	public Identifier getTextureLocation(BeeRenderState state) {
		return BEE_LOCATIONS[state.variant];
	}
}
