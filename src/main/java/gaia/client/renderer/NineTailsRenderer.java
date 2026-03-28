package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.NineTailsModel;
import gaia.client.state.NineTailsRenderState;
import gaia.entity.NineTails;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class NineTailsRenderer extends MobRenderer<NineTails, NineTailsRenderState, NineTailsModel> {
	public static final Identifier[] NINE_TAILS_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/nine_tails/nine_tails.png")};

	public NineTailsRenderer(Context context) {
		super(context, new NineTailsModel(context.bakeLayer(ClientHandler.NINE_TAILS)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public NineTailsRenderState createRenderState() {
		return new NineTailsRenderState();
	}

	@Override
	public void extractRenderState(NineTails entity, NineTailsRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(NineTailsRenderState state) {
		return NINE_TAILS_LOCATIONS[state.variant];
	}
}
