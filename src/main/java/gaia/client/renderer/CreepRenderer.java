package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CreepModel;
import gaia.client.renderer.layer.CreepPowerLayer;
import gaia.entity.Creep;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CreepRenderer extends MobRenderer<Creep, CreepModel> {
	public static final ResourceLocation[] CREEP_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/creep/creep.png")};

	public CreepRenderer(Context context) {
		super(context, new CreepModel(context.bakeLayer(ClientHandler.CREEP)), ClientHandler.smallShadow);
		this.addLayer(new CreepPowerLayer(this, context.getModelSet()));
	}

	protected void scale(Creep creep, PoseStack poseStack, float partialTicks) {
		float f = creep.getSwelling(partialTicks);
		float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
		f = Mth.clamp(f, 0.0F, 1.0F);
		f *= f;
		f *= f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		poseStack.scale(f2, f3, f2);
	}

	protected float getWhiteOverlayProgress(Creep creep, float partialTicks) {
		float f = creep.getSwelling(partialTicks);
		return (int)(f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(Creep creep) {
		return CREEP_LOCATIONS[creep.getVariant()];
	}
}
