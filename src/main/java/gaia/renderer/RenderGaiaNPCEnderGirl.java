package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.model.ModelGaiaNPCEnderGirl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCEnderGirl extends RenderLiving {

	private static final ResourceLocation endergirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Ender_Girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Ender_Girl.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaNPCEnderGirl( float shadowSize) {
        super(rend, new ModelGaiaNPCEnderGirl(), shadowSize);
        this.addLayer(new Glowing_layer(this, endergirlEyesTexture));
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
