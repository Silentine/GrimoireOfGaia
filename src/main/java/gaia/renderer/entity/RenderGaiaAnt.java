package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.model.ModelGaiaAnt;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGaiaAnt extends RenderLiving<EntityLiving> {

    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/ant01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/ant02.png");

    public RenderGaiaAnt(float shadowSize) {
        super(Minecraft.getMinecraft()
                .getRenderManager(), new ModelGaiaAnt(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaAnt.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaAnt.leftarm));
    }

    @Override
    public void transformHeldFull3DItemLayer() {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    @Override
    protected boolean canRenderName(EntityLiving entity) {
        return false;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        if (((EntityGaiaAnt) entity).getTextureType() == 1) {
            return texture02;
        }

        return texture01;
    }
}
