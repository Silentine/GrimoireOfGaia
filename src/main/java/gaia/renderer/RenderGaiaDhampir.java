package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.model.ModelGaiaCobblestoneGolem;
import gaia.model.ModelGaiaDhampir;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

public class RenderGaiaDhampir extends RenderLiving<EntityGaiaCyclops> {
	
	private static final ResourceLocation dhampirEyesTexture = new ResourceLocation("gaia", "textures/models/eyes/Eyes_Dhampir.png");
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Dhampir.png");

	public RenderGaiaDhampir(RenderManager renderManager, ModelGaiaDhampir model, float shadowSize) {
        super(renderManager, model, shadowSize);
    }

	/*protected void renderEquippedItems(EntityLivingBase par1EntityLiving, float par2) {
		float var3 = 1.0F;
		GL11.glColor3f(var3, var3, var3);
		super.renderEquippedItems(par1EntityLiving, par2);
		ItemStack var4 = par1EntityLiving.getHeldItem();
		if(var4 != null) {
			GL11.glPushMatrix();
			ModelGaiaDhampir.rightarm.postRender(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(var4, ItemRenderType.EQUIPPED);
			boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(ItemRenderType.EQUIPPED, var4, ItemRendererHelper.BLOCK_3D);
			float x;
			if(var4.getItem() instanceof ItemBlock && (is3D || (Block.getBlockFromItem(var4.getItem()) != null && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(var4.getItem()).getRenderType())))) {
				x = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				x *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(x, -x, x);
			} else if(var4.getItem() == Items.bow) {
				x = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(x, -x, x);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			} else if(var4.getItem().isFull3D()) {
				x = 0.625F;
				if(var4.getItem().shouldRotateAroundWhenRendering()) {
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

			this.renderManager.itemRenderer.renderItem(par1EntityLiving, var4, 0);
			if(var4.getItem().requiresMultipleRenderPasses()) {
				for(int var8 = 1; var8 < var4.getItem().getRenderPasses(var4.getItemDamage()); ++var8) {
					this.renderManager.itemRenderer.renderItem(par1EntityLiving, var4, var8);
				}
			}

			GL11.glPopMatrix();
		}
	}*/

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}	

	protected int shouldRenderPass(EntityGaiaDhampir par1EntityGaiaDhampir, int par2, float par3) {
		if (par1EntityGaiaDhampir.isInvisible()) {
			return 0;
		} else if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(dhampirEyesTexture);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			
            if (par1EntityGaiaDhampir.isInvisible())
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
		return this.shouldRenderPass((EntityGaiaDhampir)par1EntityLiving, par2, par3);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaCyclops entity) {
		return texture;
	}
}
