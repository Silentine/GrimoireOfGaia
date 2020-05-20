package gaia.client.renderer.prop;

import gaia.client.model.ModelGaiaPropChestMimic;
import gaia.entity.prop.GaiaPropChestMimicEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class GaiaPropChestMimicRenderer extends MobRenderer<GaiaPropChestMimicEntity, ModelGaiaPropChestMimic<GaiaPropChestMimicEntity>> {
    private static final ResourceLocation texture = new ResourceLocation("textures/entity/chest/normal.png");

    public GaiaPropChestMimicRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new ModelGaiaPropChestMimic(), 0.0F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaPropChestMimicEntity entity) {
        return texture;
    }
}
