package gaia.client.renderer.monster;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import gaia.GaiaReference;
import gaia.client.model.ModelGaiaCobblestoneGolem;
import gaia.entity.assist.GaiaCobbleGolemEntity;
import gaia.entity.hostile.GaiaCobblestoneGolemEntity;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaCobblestoneGolemRenderer extends MobRenderer<GaiaCobblestoneGolemEntity, ModelGaiaCobblestoneGolem<GaiaCobblestoneGolemEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/cobblestone_golem.png");

    public GaiaCobblestoneGolemRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaCobblestoneGolem(), shadowSize);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaCobblestoneGolemEntity entity) {
        return texture;
    }

    @Override
    protected void applyRotations(GaiaCobblestoneGolemEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);

        if ((double) entityLiving.limbSwingAmount >= 0.01D) {
            float f = 13.0F;
            float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
            float f2 = (Math.abs(f1 % f - f * 0.5F) - f * 0.25F) / (f * 0.25F);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(6.5F * f2));
        }
    }
}
