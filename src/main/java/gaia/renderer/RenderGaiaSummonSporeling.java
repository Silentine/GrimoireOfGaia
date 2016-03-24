package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSummonSporeling;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaSummonSporeling extends RenderBiped {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/biped/Summon_Sporeling.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();

	public RenderGaiaSummonSporeling( float shadowSize) {
        super(rend, new ModelBiped(), shadowSize);
	}

	protected void scaleSporeling(EntityGaiaSummonSporeling Sporeling, float par2) {
		float f1 = Sporeling.SporelingScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleSporeling((EntityGaiaSummonSporeling)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
