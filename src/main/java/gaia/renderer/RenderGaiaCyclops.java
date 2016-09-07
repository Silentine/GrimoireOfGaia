package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.model.ModelGaiaCyclops;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaCyclops extends RenderLiving<EntityGaiaCyclops> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Cyclops.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaCyclops( float shadowSize) {
        super(rend, new ModelGaiaCyclops(), shadowSize);
        this.addLayer(GaiaHeldItem.Right(this,ModelGaiaCyclops.rightarm));
        this.addLayer(GaiaHeldItem.Left(this, ModelGaiaCyclops.leftarm));
    }

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaCyclops entity) {
		return texture;
	}
}
