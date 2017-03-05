package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.model.ModelGaiaDhampir;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaDhampir extends RenderLiving<EntityGaiaDhampir> {
	
	private static final ResourceLocation dhampirEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Dhampir.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Dhampir.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaDhampir(float shadowSize) {
        super(rend, new ModelGaiaDhampir(), shadowSize);
        this.addLayer(new held_rightarm(this, ModelGaiaDhampir.rightarm));
        this.addLayer(new Glowing_layer(this, dhampirEyesTexture));
    }

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}	

	protected ResourceLocation getEntityTexture(EntityGaiaDhampir entity) {
		return texture;
	}
}
