package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.state.SharkoRenderState;
import gaia.entity.Sharko;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class SharkoRenderer extends MobRenderer<Sharko, SharkoRenderState, SharkoModel> {
	public static final Identifier[] SHARKO_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/sharko/sharko.png")};

	public SharkoRenderer(Context context) {
		super(context, new SharkoModel(context.bakeLayer(ClientHandler.SHARKO)), ClientHandler.medShadow);
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public SharkoRenderState createRenderState() {
		return new SharkoRenderState();
	}

	@Override
	public void extractRenderState(Sharko entity, SharkoRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.animationState = entity.getAnimationState();
	}

	@Override
	protected void scale(SharkoRenderState state, PoseStack poseStack) {
		poseStack.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	public Identifier getTextureLocation(SharkoRenderState state) {
		return SHARKO_LOCATIONS[state.variant];
	}
}
