package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.model.ModelGaiaNPCSlimeGirl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCSlimeGirl extends RenderLiving {

	private static final ResourceLocation hairSlimeGirl = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/hair_Slime_Girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Slime_Girl.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaNPCSlimeGirl(float shadowSize) {
        super(rend, new ModelGaiaNPCSlimeGirl(), shadowSize);
        this.addLayer(new Alpha_layer(this, hairSlimeGirl));
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
