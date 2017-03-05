package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.model.ModelGaiaEnderDragonGirl;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaEnderDragonGirl extends RenderLiving<EntityGaiaEnderDragonGirl> {

	private static final ResourceLocation enderdragongirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_Ender_Dragon_Girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Ender_Dragon_Girl.png");
	private static ModelGaiaEnderDragonGirl EnderDragonGirlModel = new ModelGaiaEnderDragonGirl();
	private Random rnd = new Random();
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	
	public RenderGaiaEnderDragonGirl(float shadowSize) {
        super(rend, EnderDragonGirlModel, shadowSize);
        this.addLayer(new Glowing_layer(this, enderdragongirlEyesTexture));        
        this.addLayer(new Held_block_layer(this));
	}

	public void renderEnderDragonGirl(EntityGaiaEnderDragonGirl entity, double par2, double par4, double par6, float par8, float par9) {
		this.EnderDragonGirlModel.isCarrying = entity.getHeldBlockState().getBlock().getMaterial() != Material.air;
        this.EnderDragonGirlModel.isAttacking = entity.isScreaming();
        
		if(entity.isScreaming()) {
			double var10 = 0.02D;
			par2 += this.rnd.nextGaussian() * var10;
			par6 += this.rnd.nextGaussian() * var10;
		}

		super.doRender(entity, par2, par4, par6, par8, par9);
	}

	protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaEnderDragonGirl)par1EntityLiving, par2, par3);
	}

	public void doRender(EntityGaiaEnderDragonGirl par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderEnderDragonGirl((EntityGaiaEnderDragonGirl)par1Entity, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getEntityTexture(EntityGaiaEnderDragonGirl entity) {
		return texture;
	}
}
