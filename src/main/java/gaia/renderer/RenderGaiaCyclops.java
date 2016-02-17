package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.monster.EntityGaiaCyclops;
import gaia.model.ModelGaiaCyclops;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;


public class RenderGaiaCyclops extends RenderLiving<EntityGaiaCyclops> {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Cyclops.png");

	public RenderGaiaCyclops(RenderManager renderManager, ModelGaiaCyclops model, float shadowSize) {
        super(renderManager, model, shadowSize);
    }
	
	/*protected void renderEquippedItems(EntityLivingBase par1EntityLiving, float par2) {
		float var3 = 1.0F;
		GL11.glColor3f(var3, var3, var3);
		super.renderEquippedItems(par1EntityLiving, par2);
		ItemStack var4 = par1EntityLiving.getHeldItem();
		if(var4 != null) {
			GL11.glPushMatrix();
			ModelGaiaCyclops.rightarm.postRender(0.0625F);
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
			ModelGaiaCyclops.leftarm.postRender(0.0625F);
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

	protected ResourceLocation getEntityTexture(EntityGaiaCyclops entity) {
		return texture;
	}
}
