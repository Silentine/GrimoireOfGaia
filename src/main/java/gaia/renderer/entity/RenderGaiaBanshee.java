package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaBanshee;
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
public class RenderGaiaBanshee extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation bansheeEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/banshee.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/banshee.png");

    public RenderGaiaBanshee(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaBanshee(), GaiaReference.MEDIUM_SHADOW);

        addLayer(new LayerGlowing(this, bansheeEyesTexture));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaBanshee(manager);
	    }
    }
}
