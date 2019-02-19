package gaia.model;

import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaWitherCow extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer body1;
	private ModelRenderer body2;
	private ModelRenderer ribs;
	private ModelRenderer leg1;
	private ModelRenderer leg2;
	private ModelRenderer leg3;
	private ModelRenderer leg4;
	private ModelRenderer udders;
	private ModelRenderer extra;

	public ModelGaiaWitherCow() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6);
		head.setRotationPoint(0.0F, 4.0F, -8.0F);
		head.setTextureSize(128, 64);
		setRotation(head, 0.0F, -0.1745329F, 0.1745329F);
		body1 = new ModelRenderer(this, 28, 0);
		body1.addBox(-6.0F, -1.0F, 0.0F, 12, 9, 10);
		body1.setRotationPoint(0.0F, 12.0F, -8.0F);
		body1.setTextureSize(128, 64);
		setRotation(body1, 1.308997F, 0.0F, -0.1745329F);
		body2 = new ModelRenderer(this, 28, 44);
		body2.addBox(-6.0F, -9.0F, 0.0F, 12, 9, 10);
		body2.setRotationPoint(0.0F, 12.0F, 10.0F);
		body2.setTextureSize(128, 64);
		setRotation(body2, 1.832596F, 0.0F, -0.1745329F);
		ribs = new ModelRenderer(this, 28, 19);
		ribs.addBox(-5.5F, -17.5F, -0.5F, 11, 16, 9);
		ribs.setRotationPoint(0.0F, 12.0F, 10.0F);
		ribs.setTextureSize(128, 64);
		setRotation(ribs, 1.5707964F, 0.0F, -0.1745329F);
		leg1 = new ModelRenderer(this, 0, 14);
		leg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4);
		leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);
		leg1.setTextureSize(128, 64);
		setRotation(leg1, 0.1745329F, 0.0F, 0.1745329F);
		leg2 = new ModelRenderer(this, 0, 14);
		leg2.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4);
		leg2.setRotationPoint(3.0F, 12.0F, 7.0F);
		leg2.setTextureSize(128, 64);
		setRotation(leg2, 0.0F, 0.0F, 0.0F);
		leg3 = new ModelRenderer(this, 0, 14);
		leg3.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 4);
		leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);
		leg3.setTextureSize(128, 64);
		setRotation(leg3, -0.0872665F, 0.0F, 0.0872665F);
		leg4 = new ModelRenderer(this, 0, 14);
		leg4.addBox(-1.0F, 0.0F, -3.0F, 4, 12, 4);
		leg4.setRotationPoint(3.0F, 12.0F, -5.0F);
		leg4.setTextureSize(128, 64);
		setRotation(leg4, 0.0F, 0.0F, 0.0F);
		ModelRenderer horn1 = new ModelRenderer(this, 22, 0);
		horn1.addBox(-5.0F, -5.0F, -4.0F, 1, 3, 1);
		horn1.setRotationPoint(0.0F, 3.0F, -7.0F);
		horn1.setTextureSize(128, 64);
		setRotation(horn1, 0.0F, -0.1745329F, 0.1745329F);
		ModelRenderer horn2 = new ModelRenderer(this, 22, 0);
		horn2.addBox(4.0F, -5.0F, -4.0F, 1, 3, 1);
		horn2.setRotationPoint(0.0F, 3.0F, -7.0F);
		horn2.setTextureSize(128, 64);
		setRotation(horn2, 0.0F, -0.1745329F, 0.1745329F);
		udders = new ModelRenderer(this, 72, 0);
		udders.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4);
		udders.setRotationPoint(0.0F, 14.0F, 6.0F);
		udders.setTextureSize(128, 64);
		setRotation(udders, 1.5707964F, 0.0F, 0.0F);
		extra = new ModelRenderer(this, 72, 10);
		extra.addBox(-5.5F, -18.5F, -5.0F, 11, 18, 5);
		extra.setRotationPoint(0.0F, 12.0F, 10.0F);
		extra.setTextureSize(128, 64);
		setRotation(extra, 1.5707964F, 0.0F, -0.1745329F);

		convertToChild(head, horn1);
		convertToChild(head, horn2);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		body1.render(scale);
		body2.render(scale);
		ribs.render(scale);
		leg1.render(scale);
		leg2.render(scale);
		leg3.render(scale);
		leg4.render(scale);
		udders.render(scale);
		extra.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		head.rotateAngleY -= 0.1745329F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		// body
		ribs.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 24)) * degToRad(2);
		ribs.rotateAngleZ -= 0.1745329F;

		// legs
		leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		leg3.rotateAngleX = leg2.rotateAngleX - 0.0872665F;
		leg4.rotateAngleX = leg1.rotateAngleX;
		leg1.rotateAngleX += 0.1745329F;
	}

	public void holdingMelee() {
		float f6;
		float f7;

		f6 = 1.0F - swingProgress;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = MathHelper.sin(f6 * (float) Math.PI);
		float f8 = MathHelper.sin(swingProgress * (float) Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;

		head.rotateAngleX -= (float) ((double) head.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
	}
}
