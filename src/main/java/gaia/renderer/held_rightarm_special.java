package gaia.renderer;

import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaSharko;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
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
public class held_rightarm_special implements LayerRenderer<EntityLivingBase> {
	ModelRenderer rightarm;
	private final RendererLivingEntity<?> livingEntityRenderer;

	/**Tried to setup another constructor to pass variables to a second set of GL rotations and translations
	 * For dynamic assigning - without having to have said dozens of extra classes that do the same thing really
	 * But values didn't want to read and right for whatever reason so here we go static assignments -for now- 
	 * Leaving this here as a reminder to come back and figure out what went wrong    
	 */
	public held_rightarm_special(RendererLivingEntity<?> livingEntityRendererIn, ModelRenderer limb){
		this.livingEntityRenderer = livingEntityRendererIn;
		this.rightarm = limb;
	}

	public void doRenderLayer(EntityLivingBase entity, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
		ItemStack itemstack = entity.getHeldItem();

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
				itemstack = new ItemStack(Items.fishing_rod, 0);
			}

			Item item = itemstack.getItem();
			Minecraft minecraft = Minecraft.getMinecraft();

			if (item instanceof ItemBlock && Block.getBlockFromItem(item).getRenderType() == 2) {
				GlStateManager.translate(0.0F, 0.1875F, -0.3125F);
				GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
				float f1 = 0.375F;
				GlStateManager.scale(-f1, -f1, f1);
			}

			if(item == Items.bow) {
				GlStateManager.translate(0.0F, 0F, -0.05F);
			}

			if (entity.isSneaking()) {
				GlStateManager.translate(0.0F, 0.203125F, 0.0F);
			}  
			
			if(entity instanceof EntityGaiaSharko) {
				GlStateManager.rotate(12.0F, -1.0F, 0.0F, 0.0F);
				GlStateManager.translate(0F, -0.05F, 0.35F);
			}
			
			if(entity instanceof EntityGaiaNaga) {
				GlStateManager.rotate(12.0F, -1.0F, 0.0F, 0.0F);
				GlStateManager.translate(0F, 0.25F, 0.1F);
			}


			minecraft.getItemRenderer().renderItem(entity, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON);
			GlStateManager.popMatrix();
		}
	}

	/** Required field for layers **/
	public boolean shouldCombineTextures() {
		return false;
	}
}