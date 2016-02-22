package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.model.ModelGaiaWerecat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaWerecat extends RenderLiving {

	private static final ResourceLocation werecatEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/eyes/Eyes_Werecat.png");
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Werecat01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/Werecat02.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaWerecat( float shadowSize) {
        super(rend, new ModelGaiaWerecat(), shadowSize);
        this.addLayer(new Glowing_layer(this, werecatEyesTexture));
        
        //Not sure why this is here - but okay
        this.addLayer(new held_rightarm(this, ModelGaiaWerecat.righthand));        
		//this.setRenderPassModel(new ModelGaiaWerecat());
	}
	/*
	protected int shouldRenderPass(EntityGaiaWerecat par1EntityGaiaWerecat, int par2, float par3) {
		if (par1EntityGaiaWerecat.isInvisible()) {
			return 0;
		} else if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(werecatEyesTexture);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			
            if (par1EntityGaiaWerecat.isInvisible())
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

	protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaWerecat)par1EntityLiving, par2, par3);
	}
	*/
	
	//Well thats weird
	/*protected void renderEquippedItems(EntityLivingBase par1EntityLiving, float par2) {
		float var3 = 1.0F;
		GL11.glColor3f(var3, var3, var3);
		super.renderEquippedItems(par1EntityLiving, par2);
		ItemStack var4 = par1EntityLiving.getHeldItem();
		if(var4 != null) {
			GL11.glPushMatrix();
			ModelGaiaWerecat.righthand.postRender(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			IItemRenderer var5 = MinecraftForgeClient.getItemRenderer(var4, ItemRenderType.EQUIPPED);
			boolean customRenderer = var5 != null && var5.shouldUseRenderHelper(ItemRenderType.EQUIPPED, var4, ItemRendererHelper.BLOCK_3D);
			float is3D;
			if(var4.getItem() instanceof ItemBlock && (customRenderer || (Block.getBlockFromItem(var4.getItem()) != null && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(var4.getItem()).getRenderType())))) {
				is3D = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				is3D *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(is3D, -is3D, is3D);
			} else if(var4.getItem() == Items.bow) {
				is3D = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(is3D, -is3D, is3D);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else if(var4.getItem().isFull3D()) {
				is3D = 0.625F;
				if(var4.getItem().shouldRotateAroundWhenRendering()) {
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}

				this.func_82422_c();
				GL11.glScalef(is3D, -is3D, is3D);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else {
				is3D = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(is3D, is3D, is3D);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			this.renderManager.itemRenderer.renderItem(par1EntityLiving, var4, 0);
			if(var4.getItem().requiresMultipleRenderPasses()) {
				for(int var11 = 1; var11 < var4.getItem().getRenderPasses(var4.getItemDamage()); ++var11) {
					this.renderManager.itemRenderer.renderItem(par1EntityLiving, var4, var11);
				}
			}

			GL11.glPopMatrix();
		}

		ItemStack var9 = par1EntityLiving.getHeldItem();
		if(var9 != null) {
			GL11.glPushMatrix();
			ModelGaiaWerecat.lefthand.postRender(0.0625F);
			GL11.glTranslatef(0.0625F, 0.4375F, 0.0625F);
			IItemRenderer var10 = MinecraftForgeClient.getItemRenderer(var9, ItemRenderType.EQUIPPED);
			boolean var12 = var10 != null && var10.shouldUseRenderHelper(ItemRenderType.EQUIPPED, var9, ItemRendererHelper.BLOCK_3D);
			float x;
			if(var9.getItem() instanceof ItemBlock && (var12 || (Block.getBlockFromItem(var9.getItem()) != null && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(var9.getItem()).getRenderType())))) {
				x = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				x *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(x, -x, x);
			} else if(var9.getItem() == Items.bow) {
				x = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(x, -x, x);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else if(var9.getItem().isFull3D()) {
				x = 0.625F;
				if(var9.getItem().shouldRotateAroundWhenRendering()) {
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}

				this.func_82422_c();
				GL11.glScalef(x, -x, x);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else {
				x = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(x, x, x);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			this.renderManager.itemRenderer.renderItem(par1EntityLiving, var9, 0);
			if(var9.getItem().requiresMultipleRenderPasses()) {
				for(int var13 = 1; var13 < var9.getItem().getRenderPasses(var9.getItemDamage()); ++var13) {
					this.renderManager.itemRenderer.renderItem(par1EntityLiving, var9, var13);
				}
			}

			GL11.glPopMatrix();
		}
	}*/

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getTexture((EntityGaiaWerecat) entity);
	}

	protected ResourceLocation getTexture(EntityGaiaWerecat par1EntityGaiaWerecat) {
		switch(par1EntityGaiaWerecat.getTextureType()) {
		case 0: return texture01;
		case 1: return texture02;
		default: return texture01;
		}
	}
}
