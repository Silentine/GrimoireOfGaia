package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.model.ModelGaiaEnderDragonGirl;
import gaia.renderer.entity.layers.LayerGlowing;
import gaia.renderer.entity.layers.LayerGaiaHeldBlock;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaEnderDragonGirl extends RenderLiving<EntityGaiaEnderDragonGirl> {

	private static final ResourceLocation enderdragongirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Ender_Dragon_Girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Ender_Dragon_Girl.png");
	private static ModelGaiaEnderDragonGirl EnderDragonGirlModel = new ModelGaiaEnderDragonGirl();
	private Random rnd = new Random();
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaEnderDragonGirl(float shadowSize) {
        super(rend, EnderDragonGirlModel, shadowSize);
        this.addLayer(new LayerGlowing(this, enderdragongirlEyesTexture));        
        this.addLayer(new LayerGaiaHeldBlock(this));
	}

	public void renderEnderDragonGirl(EntityGaiaEnderDragonGirl entity, double x, double y, double z, float entityYaw, float partialTicks) {
		IBlockState iblockstate = entity.getHeldBlockState();
        this.EnderDragonGirlModel.isCarrying = iblockstate != null;
        this.EnderDragonGirlModel.isAttacking = entity.isScreaming();

        if (entity.isScreaming()) {
            double d0 = 0.02D;
            x += this.rnd.nextGaussian() * 0.02D;
            z += this.rnd.nextGaussian() * 0.02D;
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	protected int shouldRenderPass(EntityLivingBase entityInLiving, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaEnderDragonGirl)entityInLiving, par2, par3);
	}

	public void doRender(EntityGaiaEnderDragonGirl entityIn, double par2, double par4, double par6, float par8, float par9) {
		this.renderEnderDragonGirl((EntityGaiaEnderDragonGirl)entityIn, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getEntityTexture(EntityGaiaEnderDragonGirl entity) {
		return texture;
	}
}
