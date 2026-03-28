package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.HarpyModel;
import gaia.client.state.HarpyRenderState;
import gaia.entity.Harpy;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;

public class HarpyRenderer extends GaiaBabyMobRenderer<Harpy, HarpyRenderState, HarpyModel> {
	public static final Identifier[] HARPY_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/harpy/harpy01.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/harpy/harpy02.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/harpy/harpy03.png")};

	public HarpyRenderer(Context context) {
		super(context, new HarpyModel(context.bakeLayer(ClientHandler.HARPY)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
	}

	@Override
	public HarpyRenderState createRenderState() {
		return new HarpyRenderState();
	}

	@Override
	public void extractRenderState(Harpy entity, HarpyRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isFleeing = entity.isFleeing();
		Vec3 movement = entity.getDeltaMovement();
		state.moving = movement.x * movement.x + movement.z * movement.z > 2.500000277905201E-7D;
	}

	@Override
	public Identifier getTextureLocation(HarpyRenderState renderState) {
		return HARPY_LOCATIONS[renderState.variant];
	}
}
