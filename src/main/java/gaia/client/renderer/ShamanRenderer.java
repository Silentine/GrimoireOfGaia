package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.ShamanModel;
import gaia.client.state.ShamanRenderState;
import gaia.entity.Shaman;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class ShamanRenderer extends MobRenderer<Shaman, ShamanRenderState, ShamanModel> {
	public static final Identifier[] SHAMAN_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/shaman/shaman.png")};

	public ShamanRenderer(Context context) {
		super(context, new ShamanModel(context.bakeLayer(ClientHandler.SHAMAN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ShamanRenderState createRenderState() {
		return new ShamanRenderState();
	}

	@Override
	public void extractRenderState(Shaman entity, ShamanRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.animationState = entity.getAnimationState();
	}

	@Override
	public Identifier getTextureLocation(ShamanRenderState state) {
		return SHAMAN_LOCATIONS[state.variant];
	}
}
