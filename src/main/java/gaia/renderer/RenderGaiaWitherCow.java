package gaia.renderer;

import gaia.model.ModelGaiaWitherCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaWitherCow extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Wither_Cow.png");

	public RenderGaiaWitherCow() {
		super(new ModelGaiaWitherCow(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
