package gaia.renderer.entity;

import javax.annotation.Nonnull;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.model.ModelGaiaCobblestoneGolem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaCobblestoneGolem extends RenderLiving<EntityGaiaCobblestoneGolem> {
	public static final Factory FACTORY = new Factory();

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/cobblestone_golem.png");

    public RenderGaiaCobblestoneGolem(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelGaiaCobblestoneGolem(), GaiaReference.LARGE_SHADOW);
    }

    @Override
    protected ResourceLocation getEntityTexture(@Nonnull EntityGaiaCobblestoneGolem entity) {
        return texture;
    }

    @Override
    protected void applyRotations(EntityGaiaCobblestoneGolem entityLiving, float p_77043_2_, float p_77043_3_, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, p_77043_3_, partialTicks);

        if ((double) entityLiving.limbSwingAmount >= 0.01D) {
            float f = 13.0F;
            float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
            float f2 = (Math.abs(f1 % f - f * 0.5F) - f * 0.25F) / (f * 0.25F);
            GlStateManager.rotate(6.5F * f2, 0.0F, 0.0F, 1.0F);
        }
    }
    
    public static class Factory implements IRenderFactory<EntityGaiaCobblestoneGolem> {
	    @Override
	    public Render<? super EntityGaiaCobblestoneGolem> createRenderFor(RenderManager manager) {
	      return new RenderGaiaCobblestoneGolem(manager);
	    }
    }
}
