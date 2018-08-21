package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaSludgeGirl;
import gaia.renderer.entity.layers.LayerAlpha;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSludgeGirl extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation hairSludgeGirl = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/hair_sludge_girl.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/sludge_girl.png");

    public RenderGaiaSludgeGirl(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaSludgeGirl(), GaiaReference.SMALL_SHADOW);
        this.addLayer(new LayerAlpha(this, hairSludgeGirl));
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaSludgeGirl(manager);
	    }
    }
}
