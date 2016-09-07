package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.model.ModelGaiaDullahan;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaDullahan extends RenderLiving<EntityGaiaDullahan> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Dullahan.png");
	
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaDullahan( float shadowSize) {
        super(rend, new ModelGaiaDullahan(), shadowSize);
        this.addLayer(GaiaHeldItem.Right(this, ModelGaiaDullahan.rightarm));
    }

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaDullahan entity) {
		return texture;
	}
}
