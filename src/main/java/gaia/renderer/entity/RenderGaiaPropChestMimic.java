package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.model.ModelGaiaPropChestMimic;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaPropChestMimic extends RenderLiving<EntityLiving> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/prop_chest_mimic.png");

    public RenderGaiaPropChestMimic(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaPropChestMimic(), 0.0F);
    }

    protected void preRenderChestMimic(EntityGaiaPropChestMimic entity, float par2) {
        this.shadowSize = 0.0F;
    }

    protected void preRenderCallback(EntityLiving living, float par2) {
        this.preRenderChestMimic((EntityGaiaPropChestMimic) living, par2);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
    
    public static class Factory implements IRenderFactory<EntityLiving> {
	    @Override
	    public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
	      return new RenderGaiaPropChestMimic(manager);
	    }
    }
}
