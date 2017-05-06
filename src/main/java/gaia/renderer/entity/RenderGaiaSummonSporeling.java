package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSummonSporeling;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGaiaSummonSporeling extends RenderBiped {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/biped/Summon_Sporeling.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();

	public RenderGaiaSummonSporeling(float shadowSize) {
        super(rend, new ModelBiped(), shadowSize);
	}

	protected void scaleSporeling(EntityGaiaSummonSporeling entity, float par2) {
		float f1 = entity.SporelingScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase living, float par2) {
		this.scaleSporeling((EntityGaiaSummonSporeling)living, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
