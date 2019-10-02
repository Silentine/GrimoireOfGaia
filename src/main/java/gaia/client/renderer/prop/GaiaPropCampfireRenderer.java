package gaia.client.renderer.prop;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaPropCampfire;
import gaia.entity.prop.GaiaPropCampfireEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class GaiaPropCampfireRenderer extends MobRenderer<GaiaPropCampfireEntity, ModelGaiaPropCampfire<GaiaPropCampfireEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/prop_campfire.png");

    public GaiaPropCampfireRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new ModelGaiaPropCampfire(), 0.0F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaPropCampfireEntity entity) {
        return texture;
    }
}
