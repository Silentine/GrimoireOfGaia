package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaBaphomet;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGaiaBaphomet extends RenderLiving<EntityLiving> {

    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/baphomet.png");
    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaBaphomet(float shadowSize) {
        super(rend, new ModelGaiaBaphomet(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaBaphomet.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaBaphomet.leftarm));
    }

    public void transformHeldFull3DItemLayer() {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return texture;
    }
}
