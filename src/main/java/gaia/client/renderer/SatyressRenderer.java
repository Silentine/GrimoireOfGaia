package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SatyressModel;
import gaia.client.state.SatyressRenderState;
import gaia.entity.Satyress;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;

public class SatyressRenderer extends MobRenderer<Satyress, SatyressRenderState, SatyressModel> {
	public static final Identifier[] DRYAD_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/satyress/satyress01.png"),
			GrimoireOfGaia.modLoc("textures/entity/satyress/satyress02.png")};

	public SatyressRenderer(Context context) {
		super(context, new SatyressModel(context.bakeLayer(ClientHandler.SATYRESS)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public SatyressRenderState createRenderState() {
		return new SatyressRenderState();
	}

	@Override
	public void extractRenderState(Satyress entity, SatyressRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.isFleeing = entity.isFleeing();
		Vec3 movement = entity.getDeltaMovement();
		state.moving = movement.x * movement.x + movement.z * movement.z > 2.500000277905201E-7D;
	}

	@Override
	public Identifier getTextureLocation(SatyressRenderState state) {
		return DRYAD_LOCATIONS[state.variant];
	}
}
