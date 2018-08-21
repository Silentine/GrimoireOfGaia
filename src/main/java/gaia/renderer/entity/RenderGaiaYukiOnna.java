package gaia.renderer.entity;

import javax.annotation.Nonnull;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.model.ModelGaiaYukiOnna;
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
public class RenderGaiaYukiOnna extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/yuki_onna.png");

    public RenderGaiaYukiOnna(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaYukiOnna(), GaiaReference.SMALL_SHADOW);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaYukiOnna.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaYukiOnna.leftarm));
    }

    public void transformHeldFull3DItemLayer() {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    protected ResourceLocation getEntityTexture(@Nonnull EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaYukiOnna(manager);
	    }
    }
}
