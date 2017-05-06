package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.model.ModelGaiaSharko;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGaiaSharko extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Sharko.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaSharko(float shadowSize) {
        super(rend, new ModelGaiaSharko(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaSharko.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaSharko.leftarm));
	}

	public void transformHeldFull3DItemLayer() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected void scaleSharko(EntityGaiaSharko entity, float par2) {
		float f1 = entity.SharkoScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase living, float par2) {
		this.scaleSharko((EntityGaiaSharko)living, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
