package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.model.ModelGaiaCyclops;
import gaia.model.ModelGaiaWerecat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaWerecat extends RenderLiving {

	private static final ResourceLocation werecatEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Werecat.png");
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Werecat01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/Werecat02.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaWerecat( float shadowSize) {
        super(rend, new ModelGaiaWerecat(), shadowSize);
        this.addLayer(new Glowing_layer(this, werecatEyesTexture));
        this.addLayer(new held_rightarm(this, ModelGaiaCyclops.rightarm));
        this.addLayer(new Held_leftarm(this, ModelGaiaCyclops.leftarm));
	}

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getTexture((EntityGaiaWerecat) entity);
	}

	protected ResourceLocation getTexture(EntityGaiaWerecat par1EntityGaiaWerecat) {
		switch(par1EntityGaiaWerecat.getTextureType()) {
		case 0: return texture01;
		case 1: return texture02;
		default: return texture01;
		}
	}
}
