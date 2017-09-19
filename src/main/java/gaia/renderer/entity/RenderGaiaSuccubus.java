package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaSpriggan;
import gaia.model.ModelGaiaSuccubus;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSuccubus extends RenderLiving<EntityLiving> {

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/succubus.png");
    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaSuccubus(float shadowSize) {
        super(rend, new ModelGaiaSuccubus(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaSpriggan.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaSpriggan.leftarm));
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
}
