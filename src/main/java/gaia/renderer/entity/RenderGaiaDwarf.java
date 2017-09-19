package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.model.ModelGaiaDwarf;
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
public class RenderGaiaDwarf extends RenderLiving<EntityLiving> {

    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/dwarf01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/Dwarf02.png");
    static RenderManager rend = Minecraft.getMinecraft()
            .getRenderManager();

    public RenderGaiaDwarf(float shadowSize) {
        super(rend, new ModelGaiaDwarf(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaDwarf.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaDwarf.leftarm));
    }

    public void transformHeldFull3DItemLayer() {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    protected ResourceLocation getEntityTexture(EntityLiving entity) {
        return this.getTexture((EntityGaiaDwarf) entity);
    }

    protected ResourceLocation getTexture(EntityGaiaDwarf entity) {
        switch (entity.getTextureType()) {
            case 0:
                return texture01;
            case 1:
                return texture02;
            default:
                return texture01;
        }
    }
}
