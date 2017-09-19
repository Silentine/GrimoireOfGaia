package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.model.ModelGaiaCobblestoneGolem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
public class RenderGaiaCobblestoneGolem extends RenderLiving<EntityGaiaCobblestoneGolem> {

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/cobblestone_golem.png");
    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaCobblestoneGolem(float shadowSize) {
        super(rend, new ModelGaiaCobblestoneGolem(), shadowSize);
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
}
