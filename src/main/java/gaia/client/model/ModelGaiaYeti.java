package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaYeti<T extends MobEntity> extends ModelGaia<T> {
	private RendererModel head;
	private RendererModel mantle;
	private RendererModel bodyfront;
	private RendererModel bodyback;
	private RendererModel rightarm;
	private RendererModel leftarm;
	private RendererModel body1;
	private RendererModel body2;
	private RendererModel rightleg;
	private RendererModel leftleg;

	public ModelGaiaYeti() {
		textureWidth = 256;
		textureHeight = 128;

		head = new RendererModel(this, 0, 0);
		head.addBox(-4F, -4F, -9F, 8, 8, 8);
		head.setRotationPoint(0F, -7F, -4F);
		head.setTextureSize(256, 128);
		setRotation(head, 0F, 0F, 0F);
		RendererModel headaccessory = new RendererModel(this, 0, 40);
		headaccessory.addBox(-6F, -5F, -6F, 12, 8, 6);
		headaccessory.setRotationPoint(0F, -7F, 0F);
		headaccessory.setTextureSize(256, 128);
		setRotation(headaccessory, -0.2617994F, 0F, 0F);
		RendererModel horns = new RendererModel(this, 0, 16);
		horns.addBox(-4.5F, -6F, -9.5F, 9, 3, 9);
		horns.setRotationPoint(0F, -7F, -4F);
		horns.setTextureSize(256, 128);
		setRotation(horns, 0F, 0F, 0F);
		RendererModel headjaw = new RendererModel(this, 0, 28);
		headjaw.addBox(-6F, 0F, -8F, 12, 6, 6);
		headjaw.setRotationPoint(0F, -7F, 0F);
		headjaw.setTextureSize(256, 128);
		setRotation(headjaw, 0F, 0F, 0F);
		mantle = new RendererModel(this, 0, 54);
		mantle.addBox(-9F, -5.5F, -3.5F, 18, 7, 9);
		mantle.setRotationPoint(0F, -7F, 0F);
		mantle.setTextureSize(256, 128);
		setRotation(mantle, -0.7853982F, 0F, 0F);
		bodyfront = new RendererModel(this, 54, 0);
		bodyfront.addBox(-7.5F, -2F, -8F, 15, 10, 5);
		bodyfront.setRotationPoint(0F, -7F, 0F);
		bodyfront.setTextureSize(256, 128);
		setRotation(bodyfront, 0.7853982F, 0F, 0F);
		bodyback = new RendererModel(this, 54, 15);
		bodyback.addBox(-8.5F, -3F, -3F, 17, 10, 8);
		bodyback.setRotationPoint(0F, -7F, 0F);
		bodyback.setTextureSize(256, 128);
		setRotation(bodyback, 0.7853982F, 0F, 0F);
		rightarm = new RendererModel(this, 122, 0);
		rightarm.addBox(-5F, -1F, -3F, 5, 14, 5);
		rightarm.setRotationPoint(-8F, -6F, 1F);
		rightarm.setTextureSize(256, 128);
		setRotation(rightarm, -0.2617994F, 0.1745329F, 0F);
		RendererModel rightarmlower = new RendererModel(this, 122, 19);
		rightarmlower.addBox(-6F, 12F, -5.5F, 7, 12, 5);
		rightarmlower.setRotationPoint(-8F, -6F, 1F);
		rightarmlower.setTextureSize(256, 128);
		setRotation(rightarmlower, -0.0872665F, 0.1745329F, 0F);
		RendererModel rightarmhand = new RendererModel(this, 122, 36);
		rightarmhand.addBox(-5.5F, 8F, 19F, 6, 4, 5);
		rightarmhand.setRotationPoint(-8F, -6F, 1F);
		rightarmhand.setTextureSize(256, 128);
		setRotation(rightarmhand, -1.308997F, 0.1745329F, 0F);
		leftarm = new RendererModel(this, 122, 0);
		leftarm.addBox(0F, -1F, -3F, 5, 14, 5);
		leftarm.setRotationPoint(8F, -6F, 1F);
		leftarm.setTextureSize(256, 128);
		setRotation(leftarm, -0.2617994F, -0.1745329F, 0F);
		RendererModel leftarmlower = new RendererModel(this, 122, 19);
		leftarmlower.addBox(-1F, 12F, -5.5F, 7, 12, 5);
		leftarmlower.setRotationPoint(8F, -6F, 1F);
		leftarmlower.setTextureSize(256, 128);
		setRotation(leftarmlower, -0.0872665F, -0.1745329F, 0F);
		RendererModel leftarmhand = new RendererModel(this, 122, 36);
		leftarmhand.addBox(-0.5F, 8F, 19F, 6, 4, 5);
		leftarmhand.setRotationPoint(8F, -6F, 1F);
		leftarmhand.setTextureSize(256, 128);
		setRotation(leftarmhand, -1.308997F, -0.1745329F, 0F);
		body1 = new RendererModel(this, 54, 33);
		body1.addBox(-5.5F, 4F, -2F, 11, 11, 9);
		body1.setRotationPoint(0F, -7F, 0F);
		body1.setTextureSize(256, 128);
		setRotation(body1, 0.2617994F, 0F, 0F);
		body2 = new RendererModel(this, 54, 53);
		body2.addBox(-3.5F, 12F, 2.5F, 7, 7, 7);
		body2.setRotationPoint(0F, -7F, 0F);
		body2.setTextureSize(256, 128);
		setRotation(body2, 0F, 0F, 0F);
		rightleg = new RendererModel(this, 104, 0);
		rightleg.addBox(-2F, 0F, -2F, 4, 9, 4);
		rightleg.setRotationPoint(-3.5F, 9F, 6F);
		rightleg.setTextureSize(256, 128);
		setRotation(rightleg, -0.2617994F, 0F, 0.0349066F);
		RendererModel rightleglower = new RendererModel(this, 104, 13);
		rightleglower.addBox(-2.5F, 5F, -3F, 5, 10, 4);
		rightleglower.setRotationPoint(-3.5F, 9F, 6F);
		rightleglower.setTextureSize(256, 128);
		setRotation(rightleglower, 0F, 0F, 0.0349066F);
		leftleg = new RendererModel(this, 104, 0);
		leftleg.addBox(-2F, 0F, -2F, 4, 9, 4);
		leftleg.setRotationPoint(3.5F, 9F, 6F);
		leftleg.setTextureSize(256, 128);
		setRotation(leftleg, -0.2617994F, 0F, -0.0349066F);
		RendererModel leftleglower = new RendererModel(this, 104, 13);
		leftleglower.addBox(-2.5F, 5F, -3F, 5, 10, 4);
		leftleglower.setRotationPoint(3.5F, 9F, 6F);
		leftleglower.setTextureSize(256, 128);
		setRotation(leftleglower, 0F, 0F, -0.0349066F);

		convertToChild(head, headaccessory);
		convertToChild(head, horns);
		convertToChild(head, headjaw);
		convertToChild(rightarm, rightarmlower);
		convertToChild(rightarm, rightarmhand);
		convertToChild(leftarm, leftarmlower);
		convertToChild(leftarm, leftarmhand);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		mantle.render(scale);
		bodyfront.render(scale);
		bodyback.render(scale);
		body1.render(scale);
		body2.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		rightarm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F) - 0.2617994F;
		leftarm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F) - 0.2617994F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.2617994F;
		leftleg.rotateAngleX -= 0.2617994F;
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

		// right arm
		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleY += (bodyfront.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.rotateAngleX = (float) ((double) leftarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		leftarm.rotateAngleY += (bodyfront.rotateAngleY * 2.0F);
		leftarm.rotateAngleZ -= (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}
}
