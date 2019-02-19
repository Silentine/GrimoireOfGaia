package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaBanshee;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaBanshee extends RenderLiving<EntityLiving> {
	private static final ResourceLocation bansheeEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/banshee.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/banshee.png");

	public RenderGaiaBanshee(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaBanshee(), shadowSize);

		addLayer(new LayerGlowing(this, bansheeEyesTexture));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
