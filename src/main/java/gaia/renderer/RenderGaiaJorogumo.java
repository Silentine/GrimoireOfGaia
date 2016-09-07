package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaJorogumo;
import gaia.model.ModelGaiaJorogumo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaJorogumo extends RenderLiving {

	private static final ResourceLocation jorogumoEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Jorogumo.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Jorogumo.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaJorogumo( float shadowSize) {
        super(rend, new ModelGaiaJorogumo(), shadowSize);
        this.addLayer(GaiaHeldItem.Right(this, ModelGaiaJorogumo.rightarm));
        this.addLayer(new Glowing_layer(this, jorogumoEyesTexture));
	}

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
