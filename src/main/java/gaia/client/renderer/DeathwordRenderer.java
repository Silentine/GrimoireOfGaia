package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.DeathwordModel;
import gaia.client.state.DeathwordRenderState;
import gaia.entity.Deathword;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class DeathwordRenderer extends MobRenderer<Deathword, DeathwordRenderState, DeathwordModel> {
	public static final Identifier[] DEATHWORD_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/deathword/deathword.png")};

	public DeathwordRenderer(Context context) {
		super(context, new DeathwordModel(context.bakeLayer(ClientHandler.DEATHWORD)), ClientHandler.smallShadow);
	}

	@Override
	public DeathwordRenderState createRenderState() {
		return new DeathwordRenderState();
	}

	@Override
	public void extractRenderState(Deathword entity, DeathwordRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
	}

	@Override
	public Identifier getTextureLocation(DeathwordRenderState state) {
		return DEATHWORD_LOCATIONS[state.variant];
	}
}
