package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaWitherCow extends ModelBase {
	ModelRenderer head;
	ModelRenderer body1;
	ModelRenderer body2;
	ModelRenderer ribs;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer udders;
	ModelRenderer extra;

	public ModelGaiaWitherCow() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6);
		this.head.setRotationPoint(0.0F, 4.0F, -8.0F);
		this.head.setTextureSize(128, 64);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0F, -0.1745329F, 0.1745329F);
		this.body1 = new ModelRenderer(this, 28, 0);
		this.body1.addBox(-6.0F, -1.0F, 0.0F, 12, 9, 10);
		this.body1.setRotationPoint(0.0F, 12.0F, -8.0F);
		this.body1.setTextureSize(128, 64);
		this.body1.mirror = true;
		this.setRotation(this.body1, 1.308997F, 0.0F, -0.1745329F);
		this.body2 = new ModelRenderer(this, 28, 44);
		this.body2.addBox(-6.0F, -9.0F, 0.0F, 12, 9, 10);
		this.body2.setRotationPoint(0.0F, 12.0F, 10.0F);
		this.body2.setTextureSize(128, 64);
		this.body2.mirror = true;
		this.setRotation(this.body2, 1.832596F, 0.0F, -0.1745329F);
		this.ribs = new ModelRenderer(this, 28, 19);
		this.ribs.addBox(-5.5F, -17.5F, -0.5F, 11, 16, 9);
		this.ribs.setRotationPoint(0.0F, 12.0F, 10.0F);
		this.ribs.setTextureSize(128, 64);
		this.ribs.mirror = true;
		this.setRotation(this.ribs, 1.5707964F, 0.0F, -0.1745329F);
		this.leg1 = new ModelRenderer(this, 0, 14);
		this.leg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4);
		this.leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
		this.leg1.setTextureSize(128, 64);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0.1745329F, 0.0F, 0.1745329F);
		this.leg2 = new ModelRenderer(this, 0, 14);
		this.leg2.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4);
		this.leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
		this.leg2.setTextureSize(128, 64);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
		this.leg3 = new ModelRenderer(this, 0, 14);
		this.leg3.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 4);
		this.leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
		this.leg3.setTextureSize(128, 64);
		this.leg3.mirror = true;
		this.setRotation(this.leg3, -0.0872665F, 0.0F, 0.0872665F);
		this.leg4 = new ModelRenderer(this, 0, 14);
		this.leg4.addBox(-1.0F, 0.0F, -3.0F, 4, 12, 4);
		this.leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
		this.leg4.setTextureSize(128, 64);
		this.leg4.mirror = true;
		this.setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
		this.horn1 = new ModelRenderer(this, 22, 0);
		this.horn1.addBox(-4.0F, -5.0F, -4.0F, 1, 3, 1);
		this.horn1.setRotationPoint(0.0F, 3.0F, -7.0F);
		this.horn1.setTextureSize(128, 64);
		this.horn1.mirror = true;
		this.setRotation(this.horn1, 0.0F, -0.1745329F, 0.1745329F);
		this.horn2 = new ModelRenderer(this, 22, 0);
		this.horn2.addBox(3.0F, -5.0F, -4.0F, 1, 3, 1);
		this.horn2.setRotationPoint(0.0F, 3.0F, -7.0F);
		this.horn2.setTextureSize(128, 64);
		this.horn2.mirror = true;
		this.setRotation(this.horn2, 0.0F, -0.1745329F, 0.1745329F);
		this.udders = new ModelRenderer(this, 72, 0);
		this.udders.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4);
		this.udders.setRotationPoint(0.0F, 14.0F, 6.0F);
		this.udders.setTextureSize(128, 64);
		this.udders.mirror = true;
		this.setRotation(this.udders, 1.5707964F, 0.0F, 0.0F);
		this.extra = new ModelRenderer(this, 72, 10);
		this.extra.addBox(-5.5F, -18.5F, -5.0F, 11, 18, 5);
		this.extra.setRotationPoint(0.0F, 12.0F, 10.0F);
		this.extra.setTextureSize(128, 64);
		this.extra.mirror = true;
		this.setRotation(this.extra, 1.5707964F, 0.0F, -0.1745329F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.body1.render(par7);
		this.body2.render(par7);
		this.ribs.render(par7);
		this.leg1.render(par7);
		this.leg2.render(par7);
		this.leg3.render(par7);
		this.leg4.render(par7);
		this.horn1.render(par7);
		this.horn2.render(par7);
		this.udders.render(par7);
		this.extra.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.horn1.rotateAngleY = this.head.rotateAngleY - 0.1745329F;
		this.horn1.rotateAngleX = this.head.rotateAngleX;
		this.horn2.rotateAngleY = this.head.rotateAngleY - 0.1745329F;
		this.horn2.rotateAngleX = this.head.rotateAngleX;
		this.head.rotateAngleY -= 0.1745329F;
		this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
		this.leg3.rotateAngleX = this.leg2.rotateAngleX - 0.0872665F;
		this.leg4.rotateAngleX = this.leg1.rotateAngleX;
		this.leg1.rotateAngleX += 0.1745329F;
	}
}
