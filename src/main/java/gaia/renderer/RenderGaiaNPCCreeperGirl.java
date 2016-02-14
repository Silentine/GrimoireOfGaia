package gaia.renderer;

import gaia.model.ModelGaiaNPCCreeperGirl;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaNPCCreeperGirl extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Creeper_Girl.png");

	public RenderGaiaNPCCreeperGirl() {
		super(new ModelGaiaNPCCreeperGirl(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
