package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GoblinModel;
import gaia.entity.GoblinFeral;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GoblinFeralRenderer extends MobRenderer<GoblinFeral, GoblinModel<GoblinFeral>> {
	public static final ResourceLocation[] GOBLIN_FERAL_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/goblin/goblin_feral01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/goblin/goblin_feral02.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/goblin/goblin_feral03.png")};

	public GoblinFeralRenderer(Context context) {
		super(context, new GoblinModel(context.bakeLayer(ClientHandler.GOBLIN_FERAL)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	protected void scale(GoblinFeral creep, PoseStack poseStack, float partialTicks) {
		float f = creep.getSwelling(partialTicks);
		float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
		f = Mth.clamp(f, 0.0F, 1.0F);
		f *= f;
		f *= f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		poseStack.scale(f2, f3, f2);
	}

	@Override
	protected float getWhiteOverlayProgress(GoblinFeral creep, float partialTicks) {
		float f = creep.getSwelling(partialTicks);
		return (int) (f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(GoblinFeral goblin) {
		return GOBLIN_FERAL_LOCATIONS[goblin.getVariant()];
	}
}
