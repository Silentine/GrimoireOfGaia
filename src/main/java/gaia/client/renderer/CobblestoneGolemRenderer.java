package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CobblestoneGolemModel;
import gaia.client.state.CobblestoneGolemRenderState;
import gaia.entity.CobblestoneGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class CobblestoneGolemRenderer extends MobRenderer<CobblestoneGolem, CobblestoneGolemRenderState, CobblestoneGolemModel> {
	public static final Identifier[] COBBLESTONE_GOLEM_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/cobblestone_golem/cobblestone_golem.png")};

	public CobblestoneGolemRenderer(Context context) {
		super(context, new CobblestoneGolemModel(context.bakeLayer(ClientHandler.COBBLESTONE_GOLEM)), ClientHandler.smallShadow);
	}

	@Override
	public CobblestoneGolemRenderState createRenderState() {
		return new CobblestoneGolemRenderState();
	}

	@Override
	public void extractRenderState(CobblestoneGolem entity, CobblestoneGolemRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.attackAnimationTick = entity.getAttackAnimationTick();
	}

	@Override
	protected void setupRotations(CobblestoneGolemRenderState state, PoseStack poseStack, float bodyRot, float entityScale) {
		super.setupRotations(state, poseStack, bodyRot, entityScale);
		if (!((double) state.walkAnimationSpeed < 0.01D)) {
			float f = 13.0F;
			float f1 = state.walkAnimationPos - state.walkAnimationSpeed * (1.0F - state.partialTick) + 6.0F;
			float f2 = (Math.abs(f1 % f - 6.5F) - 3.25F) / 3.25F;
			poseStack.mulPose(Axis.ZP.rotationDegrees(6.5F * f2));
		}
	}

	@Override
	public Identifier getTextureLocation(CobblestoneGolemRenderState renderState) {
		return COBBLESTONE_GOLEM_LOCATIONS[renderState.variant];
	}
}
