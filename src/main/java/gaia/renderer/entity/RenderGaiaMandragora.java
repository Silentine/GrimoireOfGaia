package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.model.ModelGaiaMandragora;
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
public class RenderGaiaMandragora extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Mandragora.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaMandragora(float shadowSize) {
        super(rend, new ModelGaiaMandragora(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaMandragora.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaMandragora.leftarm));
	}

	protected void scaleMandragora(EntityGaiaMandragora entity, float par2) {
		float f1 = entity.MandragoraScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase entity, float par2) {
		this.scaleMandragora((EntityGaiaMandragora)entity, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
