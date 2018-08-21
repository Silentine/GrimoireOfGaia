package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.model.ModelGaiaHarpy;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaHarpy extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/harpy01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/Harpy02.png");

    public RenderGaiaHarpy(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaHarpy(), GaiaReference.SMALL_SHADOW);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return this.getTexture((EntityGaiaHarpy) entity);
    }

    protected ResourceLocation getTexture(EntityGaiaHarpy entity) {
        switch (entity.getTextureType()) {
            case 0:
                return texture01;
            case 1:
                return texture02;
            default:
                return texture01;
        }
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaHarpy(manager);
	    }
    }
}
