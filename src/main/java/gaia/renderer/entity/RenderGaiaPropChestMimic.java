package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.model.ModelGaiaPropChestMimic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaPropChestMimic extends RenderLiving<EntityLiving> {

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/prop_chest_mimic.png");
    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaPropChestMimic(float shadowSize) {
        super(rend, new ModelGaiaPropChestMimic(), 0.0F);
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
}
