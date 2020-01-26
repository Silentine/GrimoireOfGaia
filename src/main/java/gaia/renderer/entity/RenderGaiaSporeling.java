package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSporeling;
import gaia.model.ModelGaiaSporeling;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSporeling extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/sporeling01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/sporeling02.png");
	
	private static final float SCALE_AMOUNT = 0.5F;

	public RenderGaiaSporeling(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaSporeling(), shadowSize);
	}

	private ModelGaiaSporeling getModel() {
		return (ModelGaiaSporeling) getMainModel();
	}

	@Override
	protected void preRenderCallback(EntityLiving living, float par2) {
		GlStateManager.scale(SCALE_AMOUNT, SCALE_AMOUNT, SCALE_AMOUNT);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaSporeling) entity);
	}

	private ResourceLocation getTexture(EntityGaiaSporeling entity) {
		switch (entity.getTextureType()) {
		case 0:
			return texture01;
		case 1:
			return texture02;
		default:
			return texture01;
		}
	}
}
