package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaVampire;
import gaia.renderer.entity.layers.LayerAuraVampire;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaVampire extends RenderLiving<EntityLiving> {
	private static final ResourceLocation eyeTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_vampire.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/vampire.png");

	public RenderGaiaVampire(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaVampire(0.0F), shadowSize);
		addLayer(new LayerGlowing(this, eyeTexture));
        addLayer(new LayerAuraVampire(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
