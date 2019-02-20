package gaia.renderer.entity;

import gaia.GaiaReference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.model.ModelBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaSummonSporeling extends RenderBiped<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/biped/summon_sporeling.png");

	public RenderGaiaSummonSporeling(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelBiped(), shadowSize);
	}

	@Override
	protected void preRenderCallback(EntityLiving living, float par2) {
		GlStateManager.scalef(0.25F, 0.25F, 0.25F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
