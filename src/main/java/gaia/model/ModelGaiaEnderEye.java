package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaEnderEye extends ModelBase {
	ModelRenderer body;
	ModelRenderer eyelid1;
	ModelRenderer eyelid2;
	ModelRenderer rightwing;
	ModelRenderer leftwing;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer tail3;

	public ModelGaiaEnderEye() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.body = new ModelRenderer(this, 0, 0);
		this.body.addBox(-4F, -5F, -2F, 8, 8, 6);
		this.body.setRotationPoint(0F, -7F, 0F);
		this.body.setTextureSize(128, 64);
		this.body.mirror = true;
		this.setRotation(body, 0.1745329F, 0F, 0F);
		this.eyelid1 = new ModelRenderer(this, 0, 14);
		this.eyelid1.addBox(-5F, -5F, -9F, 10, 5, 10);
		this.eyelid1.setRotationPoint(0F, -9F, 4.5F);
		this.eyelid1.setTextureSize(128, 64);
		this.eyelid1.mirror = true;
		this.setRotation(eyelid1, 0.0349066F, 0F, 0F);
		this.eyelid2 = new ModelRenderer(this, 0, 29);
		this.eyelid2.addBox(-5F, 0F, -9F, 10, 5, 10);
		this.eyelid2.setRotationPoint(0F, -9F, 4.5F);
		this.eyelid2.setTextureSize(128, 64);
		this.eyelid2.mirror = true;
		this.setRotation(eyelid2, 0.3490659F, 0F, 0F);
		this.rightwing = new ModelRenderer(this, 98, 38);
		this.rightwing.addBox(0F, 0F, -5F, 0, 16, 10);
		this.rightwing.setRotationPoint(-4F, -8F, 0F);
		this.rightwing.setTextureSize(128, 64);
		this.rightwing.mirror = true;
		this.setRotation(rightwing, 0F, 0F, 1.570796F);
		this.leftwing = new ModelRenderer(this, 108, 38);
		this.leftwing.addBox(0F, 0F, -6F, 0, 16, 10);
		this.leftwing.setRotationPoint(4F, -8F, 0F);
		this.leftwing.setTextureSize(128, 64);
		this.leftwing.mirror = true;
		this.setRotation(leftwing, 0F, 0F, -1.570796F);
		this.tail1 = new ModelRenderer(this, 0, 44);
		this.tail1.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
		this.tail1.setRotationPoint(0F, -6F, 4F);
		this.tail1.setTextureSize(128, 64);
		this.tail1.mirror = true;
		this.setRotation(tail1, 0.7853982F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 0, 50);
		this.tail2.addBox(-1F, 3F, -0.5F, 2, 4, 2);
		this.tail2.setRotationPoint(0F, -6F, 4F);
		this.tail2.setTextureSize(128, 64);
		this.tail2.mirror = true;
		this.setRotation(tail2, 0.6108652F, 0F, 0F);
		this.tail3 = new ModelRenderer(this, 0, 56);
		this.tail3.addBox(-0.5F, 6F, 1F, 1, 4, 1);
		this.tail3.setRotationPoint(0F, -6F, 4F);
		this.tail3.setTextureSize(128, 64);
		this.tail3.mirror = true;
		this.setRotation(tail3, 0.4363323F, 0F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.body.render(par7);
		this.eyelid1.render(par7);
		this.eyelid2.render(par7);
		this.rightwing.render(par7);
		this.leftwing.render(par7);
		this.tail1.render(par7);
		this.tail2.render(par7);
		this.tail3.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.body.rotateAngleY = par4 / 57.295776F;
		this.eyelid1.rotateAngleX = MathHelper.cos(par3 * 0.4F + (float)Math.PI) * 0.2F * 0.5F;
		this.eyelid1.rotateAngleX += 0.0349066F;
		this.eyelid2.rotateAngleX = MathHelper.cos(par3 * 0.4F) * 0.08F * 0.5F;
		this.eyelid2.rotateAngleX += 0.3490659F;
		this.rightwing.rotateAngleZ = MathHelper.cos(par3 * 0.6F + (float)Math.PI) * 1.6F * 0.5F;
		this.rightwing.rotateAngleZ = this.rightwing.rotateAngleZ + 1.570796F;
		this.leftwing.rotateAngleZ = MathHelper.cos(par3 * 0.6F) * 1.6F * 0.5F;
		this.leftwing.rotateAngleZ = this.leftwing.rotateAngleZ - 1.570796F;
		this.tail1.rotateAngleX = MathHelper.cos(par3 * 1.2F + (float)Math.PI) * 0.2F * 0.5F;
		this.tail1.rotateAngleX += 0.7853982F;
		this.tail2.rotateAngleX = MathHelper.cos(par3 * 1.2F + (float)Math.PI) * 0.2F * 0.5F;
		this.tail2.rotateAngleX += 0.6108652F;
		this.tail3.rotateAngleX = MathHelper.cos(par3 * 1.2F + (float)Math.PI) * 0.2F * 0.5F;
		this.tail3.rotateAngleX += 0.4363323F;
	}
}
