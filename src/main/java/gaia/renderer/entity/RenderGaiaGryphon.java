package gaia.renderer.entity;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.model.ModelGaiaGryphon;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGaiaGryphon extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/gryphon.png");

    public RenderGaiaGryphon(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaGryphon(), GaiaReference.MEDIUM_SHADOW);
    }

    protected void scaleGryphon(EntityGaiaGryphon par1EntityGaiaGryphon, float par2) {
        float f1 = par1EntityGaiaGryphon.GryphonScaleAmount();
        GL11.glScalef(f1, f1, f1);
    }

    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2) {
        this.scaleGryphon((EntityGaiaGryphon) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaGryphon(manager);
	    }
    }
}
