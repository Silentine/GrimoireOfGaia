package gaia.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TileModelSpawnGuard extends ModelBase {
	ModelRenderer body;

	public TileModelSpawnGuard() {
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-3F, -6F, 7.5F, 6, 12, 1);
		this.body.setRotationPoint(0F, 16F, 0F);
		this.body.setTextureSize(64, 32);
		this.setRotation(body, -1.570796F, 0F, 0F);
	}

	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.body.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void renderModel(float scale) {
		this.body.render(scale);
	}
}
