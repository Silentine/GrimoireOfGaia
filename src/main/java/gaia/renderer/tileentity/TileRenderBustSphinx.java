package gaia.renderer.tileentity;

import gaia.GaiaReference;
import gaia.model.tileentity.TileModelBustSphinx;
import gaia.tileentity.TileEntityBustSphinx;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class TileRenderBustSphinx extends TileEntitySpecialRenderer<TileEntityBustSphinx> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/bustsphinx.png");
	private TileModelBustSphinx model = new TileModelBustSphinx();

	@Override
	public void render(TileEntityBustSphinx te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		this.renderModel(te, x, y, z);
	}

	public void renderModel(TileEntityBustSphinx te, double x, double y, double z) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GlStateManager.rotate(getHorizontalAngle(te.getDirection()), 0.0F, 1.0F, 0.0F);

		GlStateManager.scale(1.0F, -1.0F, -1.0F);
		this.bindTexture(TEXTURE);
		this.model.renderModel(0.0625F);
		GlStateManager.popMatrix();
	}

	private float getHorizontalAngle(EnumFacing facing) {
		//TODO fix model so that this extra logic and the -1 scale and extra translation above isn't needed
		return facing.getAxis() == EnumFacing.Axis.X ? facing.getOpposite().getHorizontalAngle() : facing.getHorizontalAngle();
	}
}
