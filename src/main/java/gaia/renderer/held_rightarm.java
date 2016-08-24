package gaia.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
/** Render Item being held in entity's right arm**/
/** Original Vanilla code can be found at held_layer.class **/
public class held_rightarm implements LayerRenderer<EntityLivingBase> {

	/** The Model Object to append Item on **/
	ModelRenderer rightarm;
	/** The Entity's Renderer **/
	private final RenderLiving livingEntityRenderer;

	/**
	 * [ Render Item being held in entity's right arm ]
	 * PARAMETERS - Entity's Renderer, Entity Model Object (boxes, limbs head)
	 *
	 **/    

	public held_rightarm(RenderLiving livingEntityRendererIn, ModelRenderer limb) {
		this.livingEntityRenderer = livingEntityRendererIn;
		this.rightarm = limb;
	}


	/** The Actual rendering code**/
	public void doRenderLayer(EntityLivingBase entity, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
		ItemStack itemstack = entity.getHeldItemMainhand();

		if (itemstack != null) {
			GlStateManager.pushMatrix();

			if (this.livingEntityRenderer.getMainModel().isChild) {
				float f = 0.5F;
				GlStateManager.translate(0.0F, 0.625F, 0.0F);
				GlStateManager.rotate(-20.0F, -1.0F, 0.0F, 0.0F);
				GlStateManager.scale(f, f, f);
			}

			//Original Line
			//((base_held)this.livingEntityRenderer.getMainModel()).postRenderArm(0.0625F);    
			rightarm.postRender(0.0625F);            
			GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);

			if (entity instanceof EntityPlayer && ((EntityPlayer)entity).fishEntity != null) {
				itemstack = new ItemStack(Items.FISHING_ROD, 0);
			}

			Item item = itemstack.getItem();
			Minecraft minecraft = Minecraft.getMinecraft();
			/** TODO Rewrite all of the held_item rendering code, new code looks more dynamic and stuff
			 
			if (item instanceof ItemBlock && Block.getBlockFromItem(item).getRenderType() == 2) {
				GlStateManager.translate(0.0F, 0.1875F, -0.3125F);
				GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
				float f1 = 0.375F;
				GlStateManager.scale(-f1, -f1, f1);
			}
			 **/
			//We can add more checks to tweak and fix item locations like so
			//Or add more rendering effects if we fancy it
			if(item == Items.BOW) {
				GlStateManager.translate(0.0F, 0F, -0.05F);
			}

			if (entity.isSneaking()) {
				GlStateManager.translate(0.0F, 0.203125F, 0.0F);
			}            

			//minecraft.getItemRenderer().renderItem(entity, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON);
			minecraft.getItemRenderer().renderItem(entity, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND);
			GlStateManager.popMatrix();
		}
	}

	/** Required field for layers **/
	public boolean shouldCombineTextures() {
		return false;
	}
}