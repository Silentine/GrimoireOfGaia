package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCEnderGirl;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
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
public class RenderGaiaNPCEnderGirl extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation endergirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_ender_girl.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/ender_girl.png");

    public RenderGaiaNPCEnderGirl(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaNPCEnderGirl(), GaiaReference.SMALL_SHADOW);
        this.addLayer(new LayerGlowing(this, endergirlEyesTexture));
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaNPCEnderGirl.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaNPCEnderGirl.leftarm));
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaNPCEnderGirl(manager);
	    }
    }
}
