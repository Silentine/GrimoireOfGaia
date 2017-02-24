package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.model.ModelGaiaEnderEye;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaEnderEye extends RenderLiving<EntityGaiaEnderEye> {

	private static final ResourceLocation endereyeEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Ender_Eye.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Ender_Eye.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();

	public RenderGaiaEnderEye(float shadowSize) {
		super(rend, new ModelGaiaEnderEye(), shadowSize);
        this.addLayer(new LayerGlowing(this, endereyeEyesTexture));
	}

	protected int shouldRenderPass(EntityLivingBase living, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaEnderEye)living, par2, par3);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaEnderEye entity) {
		return texture;
	}
}
