package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.model.ModelGaiaWitch;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderGaiaWitch extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Witch.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaWitch( float shadowSize) {
        super(rend, new ModelGaiaWitch(), shadowSize);
        //this.addLayer(GaiaHeldItem.Right(this, ModelGaiaWitch.rightarm));    
        this.addLayer(Gaia_Witch_Held.Right(this, ModelGaiaWitch.anchor));  
	}

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
	

@SideOnly(Side.CLIENT)
public static class Gaia_Witch_Held implements LayerRenderer<EntityLivingBase>
{	
	ModelRenderer limb;
	EntityEquipmentSlot slot;
	
	private final RenderLiving livingEntityRenderer;
	
	/** Could probably had done another if( instanceof )check instead of another class but I'm naive about performance so, here's another class. **/
    public Gaia_Witch_Held(RenderLiving livingEntityRendererIn, ModelRenderer limb, EntityEquipmentSlot slot) 
    {
		this.livingEntityRenderer = livingEntityRendererIn;
		this.limb = limb;
		this.slot = slot;
    }
    
    public Gaia_Witch_Held Left(RenderLiving livingEntityRendererIn, ModelRenderer limb) 
    {
    	return new Gaia_Witch_Held(livingEntityRendererIn, limb, EntityEquipmentSlot.OFFHAND);
    }
    
    public static Gaia_Witch_Held Right(RenderLiving livingEntityRendererIn, ModelRenderer limb) 
    {
    	return new Gaia_Witch_Held(livingEntityRendererIn, limb, EntityEquipmentSlot.MAINHAND);
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
        	GlStateManager.rotate(-40.0F, 1.0F, 0.0F, 0.0F);
        	GlStateManager.translate(0F,0.1F,0.15F);
        	
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
}
