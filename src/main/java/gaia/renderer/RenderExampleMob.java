package gaia.renderer;

import gaia.GaiaReference;
import gaia.model.ModelExampleMob;
import gaia.model.ModelGaiaAnubis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderExampleMob extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/ExampleMob.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderExampleMob(float shadow) {
        super(rend, new ModelExampleMob(), shadow);
        this.addLayer(GaiaHeldItem.Right(this, ModelExampleMob.rightarm));
    }
		
	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
