package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WitchModel;
import gaia.client.renderer.layer.GaiaItemInHandLayer;
import gaia.client.state.WitchRenderState;
import gaia.entity.Witch;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.HumanoidArm;

public class WitchRenderer extends MobRenderer<Witch, WitchRenderState, WitchModel> {
	public static final Identifier[] WITCH_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/witch/witch01.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/witch/witch02.png")};

	public WitchRenderer(Context context) {
		super(context, new WitchModel(context.bakeLayer(ClientHandler.WITCH)), ClientHandler.tinyShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new GaiaItemInHandLayer<>(this, HumanoidArm.RIGHT));
	}

	@Override
	public WitchRenderState createRenderState() {
		return new WitchRenderState();
	}

	@Override
	public void extractRenderState(Witch entity, WitchRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.ridingBroom = entity.isRidingBroom();
	}

	@Override
	public Identifier getTextureLocation(WitchRenderState state) {
		return WITCH_LOCATIONS[state.variant];
	}
}
