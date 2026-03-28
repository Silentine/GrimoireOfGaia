package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MatangoModel;
import gaia.client.state.MatangoRenderState;
import gaia.entity.Matango;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class MatangoRenderer extends MobRenderer<Matango, MatangoRenderState, MatangoModel> {
	public static final Identifier[] MATANGO_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/matango/matango.png")};

	public MatangoRenderer(Context context) {
		super(context, new MatangoModel(context.bakeLayer(ClientHandler.MATANGO)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public MatangoRenderState createRenderState() {
		return new MatangoRenderState();
	}

	@Override
	public void extractRenderState(Matango entity, MatangoRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(MatangoRenderState renderState) {
		return MATANGO_LOCATIONS[renderState.variant];
	}
}
