package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaFutakuchiOnna;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaFutakuchiOnna extends RenderLiving<EntityLiving> {

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/futakuchi_onna.png");

    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaFutakuchiOnna(float shadowSize) {
        super(rend, new ModelGaiaFutakuchiOnna(), shadowSize);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
}
