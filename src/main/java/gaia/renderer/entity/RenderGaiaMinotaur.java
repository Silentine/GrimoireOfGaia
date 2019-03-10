package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaMinotaur;
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
public class RenderGaiaMinotaur extends RenderLiving<EntityLiving> {
	private static final ResourceLocation minotaurEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_Minotaur.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/minotaur.png");

	public RenderGaiaMinotaur(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaMinotaur(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
		addLayer(new LayerGlowing(this, minotaurEyesTexture));
	}

	private ModelGaiaMinotaur getModel() {
		return (ModelGaiaMinotaur) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected void preRenderCallback(EntityLiving living, float par2) {
		GlStateManager.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
