package gaia.client.renderer.prop;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaPropFlowerCyan;
import gaia.entity.prop.GaiaPropFlowerCyanEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class GaiaPropFlowerCyanRenderer extends MobRenderer<GaiaPropFlowerCyanEntity, ModelGaiaPropFlowerCyan<GaiaPropFlowerCyanEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/prop_flower_cyan.png");

    public GaiaPropFlowerCyanRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new ModelGaiaPropFlowerCyan(), 0.0F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaPropFlowerCyanEntity entity) {
        return texture;
    }
}
