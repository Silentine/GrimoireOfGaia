package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.model.ModelGaiaDwarf;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaDwarf extends RenderLiving<EntityLiving> {
	private static final ResourceLocation eyeTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_dwarf03.png");
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/dwarf01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/Dwarf02.png");
	private static final ResourceLocation texture03 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/Dwarf03.png");

	public RenderGaiaDwarf(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaDwarf(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
		addLayer(new LayerGlowing(this, eyeTexture));
	}

	private ModelGaiaDwarf getModel() {
		return (ModelGaiaDwarf) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaDwarf) entity);
	}

	private ResourceLocation getTexture(EntityGaiaDwarf entity) {
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
