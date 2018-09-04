package gaia.renderer.entity;

import gaia.GaiaReference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSummonWoodenGolem extends RenderBiped<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/biped/summon_wooden_golem.png");

	public RenderGaiaSummonWoodenGolem(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelBiped(), shadowSize);
	}

	@Override
	protected void preRenderCallback(EntityLiving living, float par2) {
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
