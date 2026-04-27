package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WitherCowModel;
import gaia.client.state.WitherCowRenderState;
import gaia.entity.WitherCow;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class WitherCowRenderer extends MobRenderer<WitherCow, WitherCowRenderState, WitherCowModel> {
	public static final Identifier[] WITHER_COW_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/wither_cow/wither_cow.png")};

	public WitherCowRenderer(Context context) {
		super(context, new WitherCowModel(context.bakeLayer(ClientHandler.WITHER_COW)), ClientHandler.smallShadow);
	}

	@Override
	public WitherCowRenderState createRenderState() {
		return new WitherCowRenderState();
	}

	@Override
	public void extractRenderState(WitherCow entity, WitherCowRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
	}

	@Override
	public Identifier getTextureLocation(WitherCowRenderState state) {
		return WITHER_COW_LOCATIONS[state.variant];
	}
}
