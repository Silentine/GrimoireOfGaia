package gaia.renderer;

import java.util.Random;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.model.ModelGaiaEnderDragonGirl;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldBlock;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaEnderDragonGirl extends RenderLiving<EntityGaiaEnderDragonGirl> {

	private static final ResourceLocation enderdragongirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/eyes/Eyes_Ender_Dragon_Girl.png");
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
		
		//this.EnderDragonGirlModel.isCarrying = entity.getCarried() > 0;
		//this.EnderDragonGirlModel.isAttacking = entity.isScreaming();		
		this.EnderDragonGirlModel.isCarrying = entity.getHeldBlockState().getBlock().getMaterial() != Material.air;
        this.EnderDragonGirlModel.isAttacking = entity.isScreaming();
        
		if(entity.isScreaming()) {
			double var10 = 0.02D;
			par2 += this.rnd.nextGaussian() * var10;
			par6 += this.rnd.nextGaussian() * var10;
		}

		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	/*protected void renderCarrying(EntityGaiaEnderDragonGirl entity, float par2) {
		super.renderEquippedItems(entity, par2);
		int id = entity.getCarried();
		Block b = Block.getBlockById(id);
		if (b != null) {
			GL11.glEnable('\u803a');
			GL11.glPushMatrix();
			float f1 = 0.5F;
			GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
			f1 *= 1.0F;
			GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScalef(-f1, -f1, f1);
			int i = entity.getBrightnessForRender(par2);
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.bindTexture(TextureMap.locationBlocksTexture);
			RenderBlocks.getInstance().renderBlockAsItem(b, entity.getCarryingData(), 1.0F);
			GL11.glPopMatrix();
			GL11.glDisable('\u803a');
		}
	}*/
	/*
	protected int shouldRenderPass(EntityGaiaEnderDragonGirl entity, int par2, float par3) {
		if (entity.isInvisible()) {
			return 0;
		} else if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(enderdragongirlEyesTexture);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			
            if (entity.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
		}
	}
	*/
	protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaEnderDragonGirl)par1EntityLiving, par2, par3);
	}

	/*protected void renderEquippedItems(EntityLivingBase par1EntityLiving, float par2) {
		this.renderCarrying((EntityGaiaEnderDragonGirl)par1EntityLiving, par2);
	}*/
	
	public void doRender(EntityGaiaEnderDragonGirl par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderEnderDragonGirl((EntityGaiaEnderDragonGirl)par1Entity, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getEntityTexture(EntityGaiaEnderDragonGirl entity) {
		return texture;
	}
}
