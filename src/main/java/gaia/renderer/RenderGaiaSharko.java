package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.model.ModelGaiaSharko;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSharko extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Sharko.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaSharko(float shadow) {
        super(rend, new ModelGaiaSharko(), shadow);
        this.addLayer(new held_rightarm(this, ModelGaiaSharko.rightarmlower));
	}

	/*protected void renderEquippedItems(EntityLivingBase par1EntityLiving, float par2) {
		float var3 = 1.0F;
		GL11.glColor3f(var3, var3, var3);
		super.renderEquippedItems(par1EntityLiving, par2);
		ItemStack var4 = par1EntityLiving.getHeldItem();
		if(var4 != null) {
			GL11.glPushMatrix();
			ModelGaiaSharko.rightarmlower.postRender(0.0625F);
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

	protected void scaleSharko(EntityGaiaSharko par1EntityGaiaSharko, float par2) {
		float f1 = par1EntityGaiaSharko.SharkoScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleSharko((EntityGaiaSharko)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
