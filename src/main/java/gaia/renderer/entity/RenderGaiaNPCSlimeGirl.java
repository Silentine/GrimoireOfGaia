package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCSlimeGirl;
import gaia.renderer.entity.layers.LayerAlpha;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaNPCSlimeGirl extends RenderLiving<EntityLiving> {

    private static final ResourceLocation hairSlimeGirl = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/hair_slime_girl.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/slime_girl.png");
    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaNPCSlimeGirl(float shadowSize) {
        super(rend, new ModelGaiaNPCSlimeGirl(), shadowSize);
        this.addLayer(new LayerAlpha(this, hairSlimeGirl));
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaNPCSlimeGirl.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaNPCSlimeGirl.leftarm));
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
}
