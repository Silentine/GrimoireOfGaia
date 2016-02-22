package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.model.ModelGaiaCobblestoneGolem;
import net.minecraft.client.Minecraft;
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
}
