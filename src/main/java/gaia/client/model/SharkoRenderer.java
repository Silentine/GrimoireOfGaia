package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.entity.Sharko;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SharkoRenderer extends MobRenderer<Sharko, SharkoModel> {
	public static final ResourceLocation[] SHARKO_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sharko/sharko.png")};

	public SharkoRenderer(Context context) {
		super(context, new SharkoModel(context.bakeLayer(ClientHandler.SHARKO)), ClientHandler.medShadow);
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	protected void scale(Sharko sharko, PoseStack poseStack, float partialTicks) {
		poseStack.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	public ResourceLocation getTextureLocation(Sharko sharko) {
		return SHARKO_LOCATIONS[sharko.getVariant()];
	}
}
