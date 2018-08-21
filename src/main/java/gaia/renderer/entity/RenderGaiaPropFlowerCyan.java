package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.model.ModelGaiaPropFlowerCyan;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaPropFlowerCyan extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/prop_flower_cyan.png");

    public RenderGaiaPropFlowerCyan(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaPropFlowerCyan(), 0.0F);
    }

    protected void preRenderFlowerCyan(EntityGaiaPropFlowerCyan entity, float par2) {
        this.shadowSize = 0.0F;
    }

    protected void preRenderCallback(EntityLiving living, float par2) {
        this.preRenderFlowerCyan((EntityGaiaPropFlowerCyan) living, par2);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaPropFlowerCyan(manager);
	    }
    }
}
