package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.model.ModelGaiaYeti;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGaiaYeti extends RenderLiving<EntityLiving> {

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/yeti.png");
    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaYeti(float shadowSize) {
        super(rend, new ModelGaiaYeti(), shadowSize);
    }

    protected void scaleYeti(EntityGaiaYeti entity, float par2) {
        float f1 = entity.YetiScaleAmount();
        GL11.glScalef(f1, f1, f1);
    }

    protected void preRenderCallback(EntityLiving living, float par2) {
        this.scaleYeti((EntityGaiaYeti) living, par2);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
}
