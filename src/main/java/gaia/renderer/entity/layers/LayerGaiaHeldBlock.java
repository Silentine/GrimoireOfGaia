package gaia.renderer.entity.layers;

import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.renderer.entity.RenderGaiaEnderDragonGirl;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class LayerGaiaHeldBlock implements LayerRenderer<EntityGaiaEnderDragonGirl> {

    private final RenderGaiaEnderDragonGirl endermanRenderer;

    public LayerGaiaHeldBlock(RenderGaiaEnderDragonGirl renderGaiaEnderDragonGirl) {
        endermanRenderer = renderGaiaEnderDragonGirl;
    }

    @Override
    public void doRenderLayer(@Nonnull EntityGaiaEnderDragonGirl entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
            float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        IBlockState iblockstate = entitylivingbaseIn.getHeldBlockState();

        if (iblockstate != null) {
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft()
                    .getBlockRendererDispatcher();
            GlStateManager.enableRescaleNormal();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 0.6875F, -0.75F);
            GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.25F, 0.1875F, 0.25F);
            GlStateManager.translate(-0.2F, -0.2F, 0.3F);
            GlStateManager.scale(-0.6F, -0.6F, 0.6F);

            int i = entitylivingbaseIn.getBrightnessForRender();

            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) i % 65536, (float) i / 65536);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

            endermanRenderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            blockrendererdispatcher.renderBlockBrightness(iblockstate, 1.0F);

            GlStateManager.popMatrix();
            GlStateManager.disableRescaleNormal();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
