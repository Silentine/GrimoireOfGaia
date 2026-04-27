package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CobbleGolemModel;
import gaia.client.state.CobbleGolemRenderState;
import gaia.entity.CobbleGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class CobbleGolemRenderer extends MobRenderer<CobbleGolem, CobbleGolemRenderState, CobbleGolemModel> {
	public static final Identifier[] COBBLE_GOLEM_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/cobble_golem/cobble_golem.png")};

	public CobbleGolemRenderer(Context context) {
		super(context, new CobbleGolemModel(context.bakeLayer(ClientHandler.COBBLE_GOLEM)), ClientHandler.smallShadow);
	}

	@Override
	public CobbleGolemRenderState createRenderState() {
		return new CobbleGolemRenderState();
	}

	@Override
	public void extractRenderState(CobbleGolem entity, CobbleGolemRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.attackAnimationTick = entity.getAttackAnimationTick();
	}

	@Override
	protected void setupRotations(CobbleGolemRenderState state, PoseStack poseStack, float bodyRot, float entityScale) {
		super.setupRotations(state, poseStack, bodyRot, entityScale);
		if (!((double) state.walkAnimationSpeed < 0.01D)) {
			float f = 13.0F;
			float f1 = state.walkAnimationPos - state.walkAnimationSpeed * (1.0F - state.partialTick) + 6.0F;
			float f2 = (Math.abs(f1 % f - 6.5F) - 3.25F) / 3.25F;
			poseStack.mulPose(Axis.ZP.rotationDegrees(6.5F * f2));
		}
	}

	@Override
	public Identifier getTextureLocation(CobbleGolemRenderState renderState) {
		return COBBLE_GOLEM_LOCATIONS[renderState.variant];
	}
}
