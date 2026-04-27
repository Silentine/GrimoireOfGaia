package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.ValkyrieModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.client.state.ValkyrieRenderState;
import gaia.entity.Valkyrie;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class ValkyrieRenderer extends MobRenderer<Valkyrie, ValkyrieRenderState, ValkyrieModel> {
	public static final Identifier[] VALKYRIE_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/valkyrie/valkyrie.png")
	};

	public ValkyrieRenderer(Context context) {
		super(context, new ValkyrieModel(context.bakeLayer(ClientHandler.VALKYRIE)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new AuraLayer<>(this, () -> new ValkyrieModel(context.bakeLayer(ClientHandler.VALKYRIE))));
	}

	@Override
	public ValkyrieRenderState createRenderState() {
		return new ValkyrieRenderState();
	}

	@Override
	public void extractRenderState(Valkyrie entity, ValkyrieRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.animationState = entity.getAnimationState();
		state.powered = entity.isPowered();
	}

	@Override
	public Identifier getTextureLocation(ValkyrieRenderState state) {
		return VALKYRIE_LOCATIONS[state.variant];
	}
}
