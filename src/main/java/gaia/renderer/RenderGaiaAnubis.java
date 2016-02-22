package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.model.ModelGaiaAnubis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaAnubis extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Anubis.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaAnubis(float shadow) {
        super(rend, new ModelGaiaAnubis(), shadow);
        //Held Item rendering simplified to a single class
        //May need more parameters in the future to accommodate or tweak per mob
        this.addLayer(new held_rightarm(this, ModelGaiaAnubis.rightarmhand));
    }

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
