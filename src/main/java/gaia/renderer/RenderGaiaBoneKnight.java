package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.model.ModelGaiaBoneKnight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaBoneKnight extends RenderLiving<EntityGaiaBoneKnight> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Bone_Knight.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaBoneKnight(float shadowSize) {
        super(rend, new ModelGaiaBoneKnight(), shadowSize);
        this.addLayer(new held_rightarm(this, ModelGaiaBoneKnight.rightarm));
    }

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaBoneKnight entity) {
		return texture;
	}
}
