package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaMandragora;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
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

	public void transformHeldFull3DItemLayer() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
