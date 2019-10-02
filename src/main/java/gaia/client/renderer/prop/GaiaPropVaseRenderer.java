package gaia.client.renderer.prop;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaPropVase;
import gaia.entity.prop.GaiaPropVaseEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class GaiaPropVaseRenderer extends MobRenderer<GaiaPropVaseEntity, ModelGaiaPropVase<GaiaPropVaseEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/prop_vase.png");

    public GaiaPropVaseRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new ModelGaiaPropVase(), 0.0F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaPropVaseEntity entity) {
        return texture;
    }
}
