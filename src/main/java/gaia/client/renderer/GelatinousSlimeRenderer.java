package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GelatinousSlimeModel;
import gaia.client.renderer.layer.GelatinousSlimeLayer;
import gaia.entity.GelatinousSlime;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GelatinousSlimeRenderer extends MobRenderer<GelatinousSlime, GelatinousSlimeModel> {
	public static final ResourceLocation[] GELATINOUS_SLIME_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/gelatinous_slime/gelatinous_slime.png")};

	public GelatinousSlimeRenderer(Context context) {
		super(context, new GelatinousSlimeModel(context.bakeLayer(ClientHandler.GELATINOUS_SLIME)), ClientHandler.smallShadow);
		this.addLayer(new GelatinousSlimeLayer(this, context.getModelSet()));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	protected void scale(GelatinousSlime gelatinousSlime, PoseStack poseStack, float partialTicks) {
		float f = 0.999F;
		poseStack.scale(0.999F, 0.999F, 0.999F);
		poseStack.translate(0.0D, (double) 0.001F, 0.0D);
		float f1 = 1.0F;
		float f2 = Mth.lerp(partialTicks, gelatinousSlime.oSquish, gelatinousSlime.squish) / (f1 * 0.5F + 1.0F);
		float f3 = 1.0F / (f2 + 1.0F);
		poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
	}

	@Override
	public ResourceLocation getTextureLocation(GelatinousSlime gelatinousSlime) {
		return GELATINOUS_SLIME_LOCATIONS[gelatinousSlime.getVariant()];
	}
}
