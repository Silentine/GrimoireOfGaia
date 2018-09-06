package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSummonSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSummonSpider extends RenderSpider<EntityGaiaSummonSpider> {
//	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/spider/summon_spider.png");
    private static final ResourceLocation texture = new ResourceLocation("textures/entity/spider/spider.png");

	public RenderGaiaSummonSpider(RenderManager renderManagerIn, float shadowSize) {
		super(renderManagerIn);
		this.shadowSize *= shadowSize;
	}

	protected void preRenderCallback(EntityGaiaSummonSpider entitylivingbaseIn, float partialTickTime) {
		GlStateManager.scale(0.25F, 0.25F, 0.25F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaSummonSpider entity) {
		return texture;
	}
}
