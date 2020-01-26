package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaBeholder;
import gaia.renderer.entity.layers.LayerAuraBeholder;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaBeholder extends RenderLiving<EntityLiving> {
	private static final ResourceLocation eyeTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_beholder.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/beholder.png");

	public RenderGaiaBeholder(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaBeholder(0.0F), shadowSize);
		addLayer(new LayerGlowing(this, eyeTexture));
        addLayer(new LayerAuraBeholder(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
