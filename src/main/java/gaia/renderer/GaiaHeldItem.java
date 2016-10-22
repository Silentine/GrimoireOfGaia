package gaia.renderer;

import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.model.ModelGaiaWitch;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GaiaHeldItem implements LayerRenderer<EntityLivingBase>
{	
	ModelRenderer limb;
	EntityEquipmentSlot slot;
	
	private final RenderLiving livingEntityRenderer;
	
	
	/**Render an Item model in an entities hand
	 * 
	 * @param livingEntityRendererIn The entity holding the item
	 * @param limb The limb to render the item at
	 * @param slot The item to render, based on the equipmentslot
	 */
    public GaiaHeldItem(RenderLiving livingEntityRendererIn, ModelRenderer limb, EntityEquipmentSlot slot) 
    {
		this.livingEntityRenderer = livingEntityRendererIn;
		this.limb = limb;
		this.slot = slot;
    }
    
    /**Shortcut for rendering items in a left arm,
     * 
     * See parent for more options
     */
    public static GaiaHeldItem Left(RenderLiving livingEntityRendererIn, ModelRenderer limb) 
    {
    	return new GaiaHeldItem(livingEntityRendererIn, limb, EntityEquipmentSlot.OFFHAND);
    }
    
    /**Shortcut for rendering items in a Right arm,
     * 
     * See parent for more options
     */
    public static GaiaHeldItem Right(RenderLiving livingEntityRendererIn, ModelRenderer limb) 
    {
    	return new GaiaHeldItem(livingEntityRendererIn, limb, EntityEquipmentSlot.MAINHAND);
    }

    public void doRenderLayer(EntityLivingBase living, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        ItemStack stack = living.getItemStackFromSlot(slot);

        if (stack != null)
        {
            GlStateManager.pushMatrix();

            if (this.livingEntityRenderer.getMainModel().isChild)
            {
                float f = 0.5F;
                GlStateManager.translate(0.0F, 0.625F, 0.0F);
                GlStateManager.rotate(-20.0F, -1.0F, 0.0F, 0.0F);
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
            }
            if(living instanceof EntityGaiaNaga) {
				GlStateManager.rotate(12.0F, -1.0F, 0.0F, 0.0F);
				GlStateManager.translate(0F, 0.25F, 0.1F);
			}
            
            
            if (slot == EntityEquipmentSlot.MAINHAND) this.renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
            if (slot == EntityEquipmentSlot.OFFHAND) this.renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
            else this.renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);          
            GlStateManager.popMatrix();
        }
    }

    public void renderHeldItem(EntityLivingBase living, ItemStack stack, ItemCameraTransforms.TransformType camera, EnumHandSide handSide)
    {
        if (stack != null)
        {
            GlStateManager.pushMatrix();

            if (living.isSneaking())
            {
                GlStateManager.translate(0.0F, 0.2F, 0.0F);
            }
            limb.postRender(0.0625F);
            GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            boolean flag = handSide == EnumHandSide.LEFT;
            GlStateManager.translate((float)(flag ? -1 : 1) / 16.0F, 0.125F, -0.625F);
            Minecraft.getMinecraft().getItemRenderer().renderItemSide(living, stack, camera, flag);
            GlStateManager.popMatrix();
        }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}