package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SuccubusModel;
import gaia.client.state.SuccubusRenderState;
import gaia.entity.Succubus;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class SuccubusRenderer extends MobRenderer<Succubus, SuccubusRenderState, SuccubusModel> {
	public static final Identifier[] SUCCUBUS_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/succubus/succubus.png")};
	public static final Identifier[] SUCCUBUS_MALE_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/succubus/succubus_male.png")};

	public SuccubusRenderer(Context context) {
		super(context, new SuccubusModel(context.bakeLayer(ClientHandler.SUCCUBUS)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public SuccubusRenderState createRenderState() {
		return new SuccubusRenderState();
	}

	@Override
	public void extractRenderState(Succubus entity, SuccubusRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isMale = entity.isMale();
	}

	@Override
	public Identifier getTextureLocation(SuccubusRenderState succubus) {
		return succubus.isMale ? SUCCUBUS_MALE_LOCATIONS[succubus.variant] : SUCCUBUS_LOCATIONS[succubus.variant];
	}
}
