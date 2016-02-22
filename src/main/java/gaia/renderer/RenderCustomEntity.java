package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.model.ModelGaiaMimic;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class RenderCustomEntity extends RenderLiving {
	
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Mimic.png");

	private ModelBase model;

	public RenderCustomEntity(RenderManager renderManager, ModelGaiaMimic model, float shadowSize) {
        super(renderManager, model, shadowSize);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

	private ResourceLocation getCustomTexture(EntityGaiaProjectileMagic entity) {
		return texture;
	}
	
	//Normally has @Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick) {
		GL11.glPushMatrix();
		bindTexture(texture);
		GL11.glTranslated(x, y, z);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}