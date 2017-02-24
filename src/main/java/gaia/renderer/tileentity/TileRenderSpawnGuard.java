package gaia.renderer.tileentity;

import gaia.GaiaReference;
import gaia.model.tileentity.TileModelSpawnGuard;
import gaia.tileentity.TileEntitySpawnGuard;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class TileRenderSpawnGuard extends TileEntitySpecialRenderer {
	public ResourceLocation texture;
	private TileModelSpawnGuard model = new TileModelSpawnGuard();

	public void renderModel(TileEntitySpawnGuard te, double x, double y, double z, float f) {
		this.texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/blocks/SpawnGuard.png");
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		
		if (te.direction == 0) {
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		}

		if (te.direction == 1) {
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
		}

		if (te.direction == 2) {
			GL11.glRotatef(360.0F, 0.0F, 1.0F, 0.0F);
		}

		if (te.direction == 3) {
			GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
		}

		GL11.glScalef(1.0F, -1.0F, -1.0F);
		this.bindTexture(this.texture);
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f, int destroyStage) {
		this.renderModel((TileEntitySpawnGuard)tileentity, x, y, z, f);
	}
}
