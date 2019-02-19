package gaia.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class RenderGaiaProjectile extends Render<Entity> {
	private final float scale;
	protected final Item item;

	public RenderGaiaProjectile(RenderManager renderManager, Item item) {
		super(renderManager);
		this.item = item;
		this.scale = 2.0F;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translatef((float) x, (float) y, (float) z);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scalef(scale, scale, scale);
		GlStateManager.rotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

		bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

		Minecraft.getInstance().getItemRenderer().renderItem(new ItemStack(item),
				ItemCameraTransforms.TransformType.GROUND);

		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}
}
