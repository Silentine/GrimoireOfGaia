package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.entity.Gryphon;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GryphonRenderer extends MobRenderer<Gryphon, GryphonModel> {
	public static final ResourceLocation[] GRYPHON_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/gryphon/gryphon.png")};

	public GryphonRenderer(Context context) {
		super(context, new GryphonModel(context.bakeLayer(ClientHandler.GRYPHON)), ClientHandler.largeShadow);
	}

	@Override
	protected void scale(Gryphon gryphon, PoseStack poseStack, float partialTicks) {
		poseStack.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	public ResourceLocation getTextureLocation(Gryphon gryphon) {
		return GRYPHON_LOCATIONS[gryphon.getVariant()];
	}
}
