package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.model.ModelGaiaMinotaur;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaMinotaur extends RenderLiving {

	private static final ResourceLocation minotaurEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Minotaur.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Minotaur.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaMinotaur(float shadowSize) {
        super(rend, new ModelGaiaMinotaur(), shadowSize);
        this.addLayer(GaiaHeldItem.Right(this, ModelGaiaMinotaur.rightarmlower));
        this.addLayer(new Glowing_layer(this, minotaurEyesTexture));
	}

	protected void scaleMinotaur(EntityGaiaMinotaur par1EntityGaiaMinotaur, float par2) {
		float f1 = par1EntityGaiaMinotaur.MinotaurScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleMinotaur((EntityGaiaMinotaur)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
