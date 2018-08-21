package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.model.ModelGaiaEnderEye;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaEnderEye extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation endereyeEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_ender_eye.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/ender_eye.png");

    public RenderGaiaEnderEye(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaEnderEye(), GaiaReference.SMALL_SHADOW);
        this.addLayer(new LayerGlowing(this, endereyeEyesTexture));
    }

    protected int shouldRenderPass(EntityLivingBase living, int par2, float par3) {
        return this.shouldRenderPass((EntityGaiaEnderEye) living, par2, par3);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaEnderEye(manager);
	    }
    }
}
