package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.model.ModelGaiaBoneKnight;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGaiaBoneKnight extends RenderLiving<EntityGaiaBoneKnight> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Bone_Knight.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaBoneKnight(float shadowSize) {
        super(rend, new ModelGaiaBoneKnight(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaBoneKnight.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaBoneKnight.leftarm));
    }

	public void transformHeldFull3DItemLayer() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaBoneKnight entity) {
		return texture;
	}
}
