package gaia.renderer.entity;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.model.ModelGaiaYeti;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaYeti extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/yeti.png");

    public RenderGaiaYeti(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaYeti(), GaiaReference.LARGE_SHADOW);
    }

    protected void scaleYeti(EntityGaiaYeti entity, float par2) {
        float f1 = entity.YetiScaleAmount();
        GL11.glScalef(f1, f1, f1);
    }

    protected void preRenderCallback(EntityLiving living, float par2) {
        this.scaleYeti((EntityGaiaYeti) living, par2);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaYeti(manager);
	    }
    }
}
