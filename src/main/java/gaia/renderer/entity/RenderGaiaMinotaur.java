package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.model.ModelGaiaDwarf;
import gaia.model.ModelGaiaMinotaur;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGaiaMinotaur extends RenderLiving {

	private static final ResourceLocation minotaurEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Minotaur.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Minotaur.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaMinotaur(float shadowSize) {
        super(rend, new ModelGaiaMinotaur(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaMinotaur.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaMinotaur.leftarm));
        this.addLayer(new LayerGlowing(this, minotaurEyesTexture));
	}
	
	public void transformHeldFull3DItemLayer() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected void scaleMinotaur(EntityGaiaMinotaur entity, float par2) {
		float f1 = entity.MinotaurScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase living, float par2) {
		this.scaleMinotaur((EntityGaiaMinotaur)living, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
