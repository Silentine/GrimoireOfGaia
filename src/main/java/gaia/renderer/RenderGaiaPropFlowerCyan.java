package gaia.renderer;

import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.model.ModelGaiaPropFlowerCyan;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaPropFlowerCyan extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Flower_Cyan.png");

	public RenderGaiaPropFlowerCyan() {
		super(new ModelGaiaPropFlowerCyan(), 0.5F);
	}

	protected void preRenderFlowerCyan(EntityGaiaPropFlowerCyan par1EntityFlowerCyan, float par2) {
		this.shadowSize = 0.0F;
	}

	protected void preRenderCallback(EntityLiving par1EntityLiving, float par2) {
		this.preRenderFlowerCyan((EntityGaiaPropFlowerCyan)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
