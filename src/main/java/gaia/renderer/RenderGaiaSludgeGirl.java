package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.model.ModelGaiaSludgeGirl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSludgeGirl extends RenderLiving {

	private static final ResourceLocation hairSludgeGirl = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/hair_Sludge_Girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Sludge_Girl.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaSludgeGirl(float shadowSize) {
        super(rend, new ModelGaiaSludgeGirl(), shadowSize);
        this.addLayer(new Alpha_layer(this, hairSludgeGirl));
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
