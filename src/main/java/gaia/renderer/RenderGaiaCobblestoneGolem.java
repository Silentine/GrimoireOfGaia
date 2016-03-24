package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.model.ModelGaiaCobblestoneGolem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaCobblestoneGolem extends RenderLiving<EntityGaiaCobblestoneGolem> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Cobblestone_Golem.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaCobblestoneGolem(float shadowSize) {
        super(rend, new ModelGaiaCobblestoneGolem(), shadowSize);
    }
	
	protected ResourceLocation getEntityTexture(EntityGaiaCobblestoneGolem entity) {
		return texture;
	}
	
	protected void rotateCorpse(EntityGaiaCobblestoneGolem bat, float p_77043_2_, float p_77043_3_, float partialTicks) {
		super.rotateCorpse(bat, p_77043_2_, p_77043_3_, partialTicks);

		if ((double)bat.limbSwingAmount >= 0.01D) {
			float f = 13.0F;
			float f1 = bat.limbSwing - bat.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
			float f2 = (Math.abs(f1 % f - f * 0.5F) - f * 0.25F) / (f * 0.25F);
			GlStateManager.rotate(6.5F * f2, 0.0F, 0.0F, 1.0F);
		}
	}
}
