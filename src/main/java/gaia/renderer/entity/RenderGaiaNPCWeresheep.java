package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCWeresheep;
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
public class RenderGaiaNPCWeresheep extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/weresheep.png");

    public RenderGaiaNPCWeresheep(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaNPCWeresheep(), GaiaReference.SMALL_SHADOW);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaNPCWeresheep.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaNPCWeresheep.leftarm));
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaNPCWeresheep(manager);
	    }
    }
}
