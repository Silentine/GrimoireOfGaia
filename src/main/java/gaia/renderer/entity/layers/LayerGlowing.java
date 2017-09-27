package gaia.renderer.entity.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class LayerGlowing implements LayerRenderer<EntityLiving> {

    private final ResourceLocation glowing_texture;
    private final RenderLiving<EntityLiving> livingEntityRenderer;

    public LayerGlowing(RenderLiving<EntityLiving> livingEntityRendererIn, ResourceLocation textureIn) {
        this.livingEntityRenderer = livingEntityRendererIn;
        this.glowing_texture = textureIn;
    }

    @Override
    public void doRenderLayer(@Nonnull EntityLiving entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
            float netHeadYaw, float headPitch, float scale) {
        livingEntityRenderer.bindTexture(glowing_texture);

        GlStateManager.enableBlend();
        // GlStateManager.disableAlpha();
        GlStateManager.blendFunc(1, 1);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(!entitylivingbaseIn.isInvisible());

        int i = 61680;
        int j = i % 65536;
        int k = i / 65536;

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        livingEntityRenderer.getMainModel()
                .render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        livingEntityRenderer.setLightmap(entitylivingbaseIn);

        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
