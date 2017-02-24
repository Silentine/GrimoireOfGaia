package gaia.renderer.entity;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.model.ModelGaiaCentaur;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaCentaur extends RenderLiving<EntityGaiaCentaur> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Centaur.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaCentaur(float shadowSize) {
        super(rend, new ModelGaiaCentaur(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this,ModelGaiaCentaur.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this,ModelGaiaCentaur.leftarm));
    }
	
	public void transformHeldFull3DItemLayer() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaCentaur entity) {
		return texture;
	}
}
