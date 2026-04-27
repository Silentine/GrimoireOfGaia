package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MinotaurModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.client.renderer.layer.MinotaurEyesLayer;
import gaia.client.state.MinotaurRenderState;
import gaia.entity.Minotaur;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class MinotaurRenderer extends MobRenderer<Minotaur, MinotaurRenderState, MinotaurModel> {
	public static final Identifier[] MINOTAURUS_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/minotaur/minotaur.png")
	};

	public MinotaurRenderer(Context context) {
		super(context, new MinotaurModel(context.bakeLayer(ClientHandler.MINOTAUR)), ClientHandler.medShadow);
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new MinotaurEyesLayer(this));
		this.addLayer(new AuraLayer<>(this, () -> new MinotaurModel(context.bakeLayer(ClientHandler.MINOTAUR))));
	}

	@Override
	public MinotaurRenderState createRenderState() {
		return new MinotaurRenderState();
	}

	@Override
	public void extractRenderState(Minotaur entity, MinotaurRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.animationState = entity.getAnimationState();
		state.powered = entity.isPowered();
	}

	@Override
	protected void scale(MinotaurRenderState state, PoseStack poseStack) {
		poseStack.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	public Identifier getTextureLocation(MinotaurRenderState state) {
		return MINOTAURUS_LOCATIONS[state.variant];
	}
}
