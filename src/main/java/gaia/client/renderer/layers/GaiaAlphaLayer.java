package gaia.client.renderer.layers;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import gaia.client.model.ModelGaia;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class GaiaAlphaLayer<T extends MobEntity, M extends ModelGaia<T>> extends LayerRenderer<T, M> {
    private final ResourceLocation ALPHA_TEXTURE;

    public GaiaAlphaLayer(IEntityRenderer<T, M> entityRenderer, ResourceLocation texture) {
        super(entityRenderer);
        this.ALPHA_TEXTURE = texture;
    }

    public void render(T livingEntity, float limbswing, float limbswingamount, float partialticks, float ageinticks, float netheadyaw, float headpitch, float scale) {
        if (!livingEntity.isInvisible()) {
            this.bindTexture(ALPHA_TEXTURE);

            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);

            getEntityModel().render(livingEntity, limbswing, limbswingamount, ageinticks, netheadyaw, headpitch, scale);
            this.func_215334_a(livingEntity);

            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }

    public boolean shouldCombineTextures() {
        return true;
    }
}
