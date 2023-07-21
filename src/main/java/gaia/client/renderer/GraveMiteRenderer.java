package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GraveMiteModel;
import gaia.entity.GraveMite;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GraveMiteRenderer extends MobRenderer<GraveMite, GraveMiteModel> {
	private static final ResourceLocation LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mummy/mummy_mite.png");

	public GraveMiteRenderer(EntityRendererProvider.Context context) {
		super(context, new GraveMiteModel(context.bakeLayer(ClientHandler.GRAVEMITE)), 0.3F);
	}

	@Override
	protected void scale(GraveMite graveMite, PoseStack poseStack, float scale) {
		poseStack.scale(1.0F, 1.0F, 1.0F);
		super.scale(graveMite, poseStack, scale);
	}

	public ResourceLocation getTextureLocation(GraveMite graveMite) {
		return LOCATION;
	}
}
