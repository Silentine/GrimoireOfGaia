package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCSlimeGirl;
import gaia.renderer.entity.layers.LayerAlpha;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaNPCSlimeGirl extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation hairSlimeGirl = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/hair_slime_girl.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/slime_girl.png");

    public RenderGaiaNPCSlimeGirl(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaNPCSlimeGirl(), GaiaReference.SMALL_SHADOW);
        this.addLayer(new LayerAlpha(this, hairSlimeGirl));
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaNPCSlimeGirl.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaNPCSlimeGirl.leftarm));
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaNPCSlimeGirl(manager);
	    }
    }
}
