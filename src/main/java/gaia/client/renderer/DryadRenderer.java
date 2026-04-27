package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.DryadModel;
import gaia.client.state.DryadRenderState;
import gaia.entity.Dryad;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;

public class DryadRenderer extends GaiaBabyMobRenderer<Dryad, DryadRenderState, DryadModel> {
	public static final Identifier[] DRYAD_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/dryad/dryad01.png"),
			GrimoireOfGaia.modLoc("textures/entity/dryad/dryad02.png")};

	public DryadRenderer(Context context) {
		super(context, new DryadModel(context.bakeLayer(ClientHandler.DRYAD)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public DryadRenderState createRenderState() {
		return new DryadRenderState();
	}

	@Override
	public void extractRenderState(Dryad entity, DryadRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isFleeing = entity.isFleeing();
		Vec3 movement = entity.getDeltaMovement();
		state.moving = movement.x * movement.x + movement.z * movement.z > 2.500000277905201E-7D;
	}

	@Override
	public Identifier getTextureLocation(DryadRenderState renderState) {
		return DRYAD_LOCATIONS[renderState.variant];
	}
}
