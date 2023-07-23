package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CobblestoneGolemModel;
import gaia.entity.CobblestoneGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CobblestoneGolemRenderer extends MobRenderer<CobblestoneGolem, CobblestoneGolemModel> {
	public static final ResourceLocation[] COBBLESTONE_GOLEM_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/cobblestone_golem/cobblestone_golem.png")};

	public CobblestoneGolemRenderer(Context context) {
		super(context, new CobblestoneGolemModel(context.bakeLayer(ClientHandler.COBBLESTONE_GOLEM)), ClientHandler.smallShadow);
	}

	@Override
	protected void setupRotations(CobblestoneGolem cobblestoneGolem, PoseStack poseStack, float p_115016_, float p_115017_, float p_115018_) {
		super.setupRotations(cobblestoneGolem, poseStack, p_115016_, p_115017_, p_115018_);
		if (!((double) cobblestoneGolem.walkAnimation.speed() < 0.01D)) {
			float f = 13.0F;
			float f1 = cobblestoneGolem.walkAnimation.position() - cobblestoneGolem.walkAnimation.speed() * (1.0F - p_115018_) + 6.0F;
			float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
			poseStack.mulPose(Axis.ZP.rotationDegrees(6.5F * f2));
		}
	}

	@Override
	public ResourceLocation getTextureLocation(CobblestoneGolem cobbleGolem) {
		return COBBLESTONE_GOLEM_LOCATIONS[cobbleGolem.getVariant()];
	}
}
