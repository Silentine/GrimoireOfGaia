package gaia.renderer.entity;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.model.ModelGaiaWerecat;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaWerecat extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation werecatEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_werecat.png");
    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/werecat01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/werecat02.png");

    public RenderGaiaWerecat(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaWerecat(), GaiaReference.SMALL_SHADOW);
        this.addLayer(new LayerGlowing(this, werecatEyesTexture));
    }

    public void transformHeldFull3DItemLayer() {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return this.getTexture((EntityGaiaWerecat) entity);
    }

    protected ResourceLocation getTexture(EntityGaiaWerecat entity) {
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
	      return new RenderGaiaWerecat(manager);
	    }
    }
}
