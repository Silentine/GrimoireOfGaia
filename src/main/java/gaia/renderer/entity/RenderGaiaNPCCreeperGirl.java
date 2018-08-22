package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCCreeperGirl;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaNPCCreeperGirl extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/creeper_girl.png");

	public RenderGaiaNPCCreeperGirl(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaNPCCreeperGirl(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaNPCCreeperGirl getModel() {
		return (ModelGaiaNPCCreeperGirl) getMainModel();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
