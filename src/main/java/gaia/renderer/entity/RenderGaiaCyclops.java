package gaia.renderer.entity;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.model.ModelGaiaCyclops;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaCyclops extends RenderLiving<EntityGaiaCyclops> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Cyclops.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaCyclops(float shadowSize) {
        super(rend, new ModelGaiaCyclops(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this,ModelGaiaCyclops.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaCyclops.leftarm));
    }

	public void transformHeldFull3DItemLayer() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaCyclops entity) {
		return texture;
	}
}
