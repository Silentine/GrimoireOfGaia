package gaia.renderer;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaProjectileMagic extends Render<Entity> {

    private final float scale;
    protected final Item item;

    public RenderGaiaProjectileMagic(Item item) {
        super(Minecraft.getMinecraft()
                .getRenderManager());

        this.item = item;
        this.scale = 2.0F;
    }

    @Override
    public void doRender(@Nonnull Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(scale, scale, scale);
        GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

        bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

        Minecraft.getMinecraft()
                .getRenderItem().renderItem(new ItemStack(item), ItemCameraTransforms.TransformType.GROUND);

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();

        super.doRender(entity, x, y, z, p_76986_8_, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(@Nonnull Entity entity) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
