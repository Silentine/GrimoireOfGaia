package gaia.renderer.entity;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.model.ModelGaiaDwarf;
import gaia.model.ModelGaiaNPCEnderGirl;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaNPCEnderGirl extends RenderLiving {

	private static final ResourceLocation endergirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Ender_Girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Ender_Girl.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaNPCEnderGirl(float shadowSize) {
        super(rend, new ModelGaiaNPCEnderGirl(), shadowSize);
        this.addLayer(new LayerGlowing(this, endergirlEyesTexture));
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaNPCEnderGirl.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaNPCEnderGirl.leftarm));
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
