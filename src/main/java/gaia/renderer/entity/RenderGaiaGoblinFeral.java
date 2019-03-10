package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaGoblinFeral;
import gaia.model.ModelGaiaGoblinFeral;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaGoblinFeral extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/goblin_feral01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/goblin_feral02.png");
	private static final ResourceLocation texture03 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/goblin_feral03.png");

	public RenderGaiaGoblinFeral(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaGoblinFeral(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	@Override
	protected void preRenderCallback(EntityLiving entitylivingbaseIn, float partialTickTime) {
		preRenderCallback((EntityGaiaGoblinFeral) entitylivingbaseIn, partialTickTime);
	}

	@Override
	protected int getColorMultiplier(EntityLiving entitylivingbaseIn, float lightBrightness, float partialTickTime) {
		return getColorMultiplier((EntityGaiaGoblinFeral) entitylivingbaseIn, lightBrightness, partialTickTime);
	}

	protected void preRenderCallback(EntityGaiaGoblinFeral entitylivingbaseIn, float partialTickTime) {
		float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
		float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		f = f * f;
		f = f * f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		GlStateManager.scale(f2, f3, f2);
	}

	protected int getColorMultiplier(EntityGaiaGoblinFeral entitylivingbaseIn, float lightBrightness, float partialTickTime) {
		float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);

		if ((int) (f * 10.0F) % 2 == 0) {
			return 0;
		} else {
			int i = (int) (f * 0.2F * 255.0F);
			i = MathHelper.clamp(i, 0, 255);
			return i << 24 | 822083583;
		}
	}

	private ModelGaiaGoblinFeral getModel() {
		return (ModelGaiaGoblinFeral) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaGoblinFeral) entity);
	}

	private ResourceLocation getTexture(EntityGaiaGoblinFeral entity) {
		switch (entity.getTextureType()) {
		case 0:
			return texture01;
		case 1:
			return texture02;
		case 2:
			return texture03;
		default:
			return texture01;
		}
	}
}
