package gaia.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaProjectileMagic extends Render
{
    

	protected final Item T_item;
    //private final RenderItem render;
    private final RenderItem render= Minecraft.getMinecraft().getRenderItem();
    
    //Oh boy the main client proxy has some big issue with passing down the renderer managers
    //Finally figured it out/gave up and statically assigned it like the rest of the renderers :^)
    public RenderGaiaProjectileMagic(RenderManager rend, Item itemin, RenderItem rendin)
    {
        super(Minecraft.getMinecraft().getRenderManager());
        this.T_item = itemin;
        //this.render = rendin;
    }

    
    public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        this.bindTexture(TextureMap.locationBlocksTexture);
        this.render.renderItem(this.get_itemStack(entity), ItemCameraTransforms.TransformType.GROUND);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
    }

    public ItemStack get_itemStack(Entity entity)
    {
        //return new ItemStack(this.T_item, 1, 0);
        return new ItemStack(this.T_item, 1, 5);
        
    }

    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return TextureMap.locationBlocksTexture;
    }
}

	//Old stuff

	/*
	@SideOnly(Side.CLIENT)
	public class RenderGaiaProjectileMagic extends Render
	{
	private float field_77002_a;

	public RenderGaiaProjectileMagic(float par2) {
		this.field_77002_a = par2;
	}

	public void doRender(EntityGaiaProjectileMagic par1EntityGaiaProjectileMagic, double x, double y, double z, float yaw, float partialTick) {
		GL11.glPushMatrix();
		this.bindEntityTexture(par1EntityGaiaProjectileMagic);
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		float f2 = this.field_77002_a;
		GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
		IIcon iicon = GaiaItem.Shard.getIconFromDamage(5);
		Tessellator tessellator = Tessellator.instance;
		float f3 = iicon.getMinU();
		float f4 = iicon.getMaxU();
		float f5 = iicon.getMinV();
		float f6 = iicon.getMaxV();
		float f7 = 1.0F;
		float f8 = 0.5F;
		float f9 = 0.25F;
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		tessellator.addVertexWithUV((double)(0.0F - f8), (double)(0.0F - f9), 0.0D, (double)f3, (double)f6);
		tessellator.addVertexWithUV((double)(f7 - f8), (double)(0.0F - f9), 0.0D, (double)f4, (double)f6);
		tessellator.addVertexWithUV((double)(f7 - f8), (double)(1.0F - f9), 0.0D, (double)f4, (double)f5);
		tessellator.addVertexWithUV((double)(0.0F - f8), (double)(1.0F - f9), 0.0D, (double)f3, (double)f5);
		tessellator.draw();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	protected ResourceLocation getEntityTexture(EntityGaiaProjectileMagic par1EntityGaiaProjectileMagic) {
		return TextureMap.locationItemsTexture;
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityGaiaProjectileMagic)entity);
	}

	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		this.doRender((EntityGaiaProjectileMagic)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	}
}
*/