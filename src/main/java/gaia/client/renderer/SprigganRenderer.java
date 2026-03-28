package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SprigganModel;
import gaia.client.renderer.layer.SprigganEyesLayer;
import gaia.client.state.SprigganRenderState;
import gaia.entity.Spriggan;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class SprigganRenderer extends MobRenderer<Spriggan, SprigganRenderState, SprigganModel> {
	public static final Identifier[] SPRIGGAN_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/spriggan/spriggan.png")};

	public SprigganRenderer(Context context) {
		super(context, new SprigganModel(context.bakeLayer(ClientHandler.SPRIGGAN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new SprigganEyesLayer(this));
	}

	@Override
	public SprigganRenderState createRenderState() {
		return new SprigganRenderState();
	}

	@Override
	public void extractRenderState(Spriggan entity, SprigganRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
	}

	@Override
	public Identifier getTextureLocation(SprigganRenderState state) {
		return SPRIGGAN_LOCATIONS[state.variant];
	}
}
