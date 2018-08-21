package gaia.renderer.entity;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.model.ModelGaiaSharko;
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
public class RenderGaiaSharko extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/sharko.png");

    public RenderGaiaSharko(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaSharko(), GaiaReference.LARGE_SHADOW);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaSharko.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaSharko.leftarm));
    }

    public void transformHeldFull3DItemLayer() {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    protected void scaleSharko(EntityGaiaSharko entity, float par2) {
        float f1 = entity.SharkoScaleAmount();
        GL11.glScalef(f1, f1, f1);
    }

    protected void preRenderCallback(EntityLiving living, float par2) {
        this.scaleSharko((EntityGaiaSharko) living, par2);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaSharko(manager);
	    }
    }
}
