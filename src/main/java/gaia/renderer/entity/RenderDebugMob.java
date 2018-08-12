package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelDebugMob;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderDebugMob extends RenderLiving<EntityLiving> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/debugmob/debugmob.png");
	static RenderManager rend = Minecraft.getMinecraft()
			.getRenderManager();

	public RenderDebugMob(float shadowSize) {
		super(rend, new ModelDebugMob(), shadowSize);
		// Held Item rendering simplified to a single class
		//May need more parameters in the future to accommodate or tweak per mob
		this.addLayer(LayerGaiaHeldItem.Right(this, ModelDebugMob.rightarm));
		this.addLayer(LayerGaiaHeldItem.Left(this, ModelDebugMob.leftarm));
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
