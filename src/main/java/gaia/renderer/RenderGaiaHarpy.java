package gaia.renderer;

import gaia.entity.monster.EntityGaiaHarpy;
import gaia.model.ModelGaiaHarpy;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaHarpy extends RenderLiving {

	private static final ResourceLocation texture01 = new ResourceLocation("gaia", "textures/models/Harpy01.png");
	private static final ResourceLocation texture02 = new ResourceLocation("gaia", "textures/models/alternate/Harpy02.png");

	public RenderGaiaHarpy() {
		super(new ModelGaiaHarpy(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getTexture((EntityGaiaHarpy) entity);
	}

	protected ResourceLocation getTexture(EntityGaiaHarpy par1EntityGaiaHarpy) {
		switch(par1EntityGaiaHarpy.getTextureType()) {
		case 0: return texture01;
		case 1: return texture02;
		default: return texture01;
		}
	}
}
