package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.model.ModelGaiaFleshLich;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaFleshLich extends RenderLiving<EntityGaiaFleshLich> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Flesh_Lich.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaFleshLich( float shadowSize) {
        super(rend, new ModelGaiaFleshLich(), shadowSize);
        this.addLayer(GaiaHeldItem.Right(this, ModelGaiaFleshLich.rightarm));
    }

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaFleshLich entity) {
		return texture;
	}
}
