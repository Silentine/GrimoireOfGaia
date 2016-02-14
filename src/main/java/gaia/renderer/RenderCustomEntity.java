package gaia.renderer;

import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.model.ModelGaiaMimic;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCustomEntity extends Render {
	
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Mimic.png");

	private ModelBase model;

	public RenderCustomEntity() {
		model = new ModelGaiaMimic();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

	private ResourceLocation getCustomTexture(EntityGaiaProjectileMagic entity) {
		return texture;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick) {
		GL11.glPushMatrix();
		bindTexture(texture);
		GL11.glTranslated(x, y, z);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}