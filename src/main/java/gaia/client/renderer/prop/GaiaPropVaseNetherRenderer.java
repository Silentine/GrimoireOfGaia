package gaia.client.renderer.prop;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaPropVaseNether;
import gaia.entity.prop.GaiaPropVaseNetherEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class GaiaPropVaseNetherRenderer extends MobRenderer<GaiaPropVaseNetherEntity, ModelGaiaPropVaseNether<GaiaPropVaseNetherEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/prop_vase_nether.png");

    public GaiaPropVaseNetherRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new ModelGaiaPropVaseNether(), 0.0F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaPropVaseNetherEntity entity) {
        return texture;
    }
}
