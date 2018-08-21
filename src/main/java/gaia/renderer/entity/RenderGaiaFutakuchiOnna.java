package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaFutakuchiOnna;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaFutakuchiOnna extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/futakuchi_onna.png");

    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaFutakuchiOnna(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaFutakuchiOnna(), GaiaReference.SMALL_SHADOW);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaFutakuchiOnna(manager);
	    }
    }
}
