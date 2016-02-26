package gaia.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class Alpha_layer implements LayerRenderer<EntityLiving>
	{
		ResourceLocation alpha_texture;
		RendererLivingEntity<?> livingEntityRenderer;

	    public Alpha_layer(RendererLivingEntity<?> livingEntityRendererIn, ResourceLocation textureIn)
	    {
	        this.livingEntityRenderer = livingEntityRendererIn;
	        this.alpha_texture = textureIn;
	    }
	    
	    public void doRenderLayer(EntityLiving entity, float f1, float f2, float partialTicks, float f4, float f5, float f6, float scale)
	    {
	        this.livingEntityRenderer.bindTexture(alpha_texture);
	        
	        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            this.livingEntityRenderer.getMainModel().render(entity, f1, f2, f4, f5, f6, scale);
	        ((RenderLiving) this.livingEntityRenderer).func_177105_a(entity, partialTicks);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
	    }
	    
	    
	    public boolean shouldCombineTextures()
	    {
	        return true;
	    }


	}