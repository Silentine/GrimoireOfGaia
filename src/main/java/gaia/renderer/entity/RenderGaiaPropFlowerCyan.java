package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.model.ModelGaiaPropFlowerCyan;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaPropFlowerCyan extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Prop_Flower_Cyan.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();

	public RenderGaiaPropFlowerCyan(float shadowSize) {
		super(rend, new ModelGaiaPropFlowerCyan(), 0.0F);
	}

	protected void preRenderFlowerCyan(EntityGaiaPropFlowerCyan entity, float par2) {
		this.shadowSize = 0.0F;
	}

	protected void preRenderCallback(EntityLiving living, float par2) {
		this.preRenderFlowerCyan((EntityGaiaPropFlowerCyan)living, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
