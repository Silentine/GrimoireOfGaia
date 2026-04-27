package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.AnubisModel;
import gaia.client.state.AnubisRenderState;
import gaia.entity.Anubis;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class AnubisRenderer extends MobRenderer<Anubis, AnubisRenderState, AnubisModel> {
	public static final Identifier[] ANUBIS_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/anubis/anubis.png")
	};
	public static final Identifier[] ANUBIS_MALE_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/anubis/anubis_male.png")
	};

	public AnubisRenderer(Context context) {
		super(context, new AnubisModel(context.bakeLayer(ClientHandler.ANUBIS)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public AnubisRenderState createRenderState() {
		return new AnubisRenderState();
	}

	@Override
	public void extractRenderState(Anubis entity, AnubisRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.animationState = entity.getAnimationState();
		state.isMale = entity.isMale();
	}

	@Override
	public Identifier getTextureLocation(AnubisRenderState renderState) {
		return renderState.isMale ? ANUBIS_MALE_LOCATIONS[renderState.variant] : ANUBIS_LOCATIONS[renderState.variant];
	}
}
