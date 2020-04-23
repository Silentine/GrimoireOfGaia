package gaia.client.model;

import gaia.entity.assist.GaiaCobbleGolemEntity;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @see net.minecraft.client.renderer.entity.model.IronGolemModel
 */
@OnlyIn(Dist.CLIENT)
public class ModelGaiaCobbleGolem<T extends GaiaCobbleGolemEntity> extends ModelGaia<T> {

	private RendererModel head;
	private RendererModel body;
	private RendererModel rightarmupper;
	private RendererModel leftarmupper;
	private RendererModel bodylower;
	private RendererModel rightlegupper;
	private RendererModel leftlegupper;

	public ModelGaiaCobbleGolem() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3.0F, -2.0F, -1.0F, 6, 4, 4);
		head.setRotationPoint(0.0F, 3.0F, -4.0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0.0872665F, 0.0F, 0.0F);
		body = new RendererModel(this, 0, 8);
		body.addBox(-7.0F, -6.0F, -4.0F, 14, 12, 8);
		body.setRotationPoint(0.0F, 4.0F, 2.0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0.2617994F, 0.0F, 0.0F);
		rightarmupper = new RendererModel(this, 44, 0);
		rightarmupper.addBox(-6.0F, -4.0F, -3.0F, 6, 12, 6);
		rightarmupper.setRotationPoint(-7.0F, 2.0F, 3.0F);
		rightarmupper.setTextureSize(64, 32);
		setRotation(rightarmupper, 0.0F, 0.0F, 0.0F);
		RendererModel rightarmlower = new RendererModel(this, 44, 18);
		rightarmlower.addBox(-5.0F, 8.0F, -2.0F, 4, 14, 4);
		rightarmlower.setRotationPoint(-7.0F, 2.0F, 3.0F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0.0F, 0.0F, 0.0F);
		leftarmupper = new RendererModel(this, 44, 0);
		leftarmupper.addBox(0.0F, -4.0F, -3.0F, 6, 12, 6);
		leftarmupper.setRotationPoint(7.0F, 2.0F, 3.0F);
		leftarmupper.setTextureSize(64, 32);
		setRotation(leftarmupper, 0.0F, 0.0F, 0.0F);
		RendererModel leftarmlower = new RendererModel(this, 44, 18);
		leftarmlower.addBox(1.0F, 8.0F, -2.0F, 4, 14, 4);
		leftarmlower.setRotationPoint(7.0F, 2.0F, 3.0F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0.0F, 0.0F, 0.0F);
		bodylower = new RendererModel(this, 0, 28);
		bodylower.addBox(-1.0F, 11.0F, -3.0F, 8, 4, 6);
		bodylower.setRotationPoint(-3.0F, -1.0F, 3.0F);
		bodylower.setTextureSize(64, 32);
		setRotation(bodylower, 0.0872665F, 0.0F, 0.0F);
		rightlegupper = new RendererModel(this, 44, 36);
		rightlegupper.addBox(-1.5F, 1.0F, -1.5F, 3, 6, 3);
		rightlegupper.setRotationPoint(-3.0F, 13.0F, 4.0F);
		rightlegupper.setTextureSize(64, 32);
		setRotation(rightlegupper, -0.1745329F, 0.0F, 0.0F);
		RendererModel rightleglower = new RendererModel(this, 44, 45);
		rightleglower.addBox(-2.0F, 5.0F, 0.0F, 4, 6, 4);
		rightleglower.setRotationPoint(-3.0F, 13.0F, 4.0F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, -0.1745329F, 0.0F, 0.0F);
		leftlegupper = new RendererModel(this, 44, 36);
		leftlegupper.addBox(-1.5F, 1.0F, -1.5F, 3, 6, 3);
		leftlegupper.setRotationPoint(3.0F, 13.0F, 4.0F);
		leftlegupper.setTextureSize(64, 32);
		setRotation(leftlegupper, -0.1745329F, 0.0F, 0.0F);
		RendererModel leftleglower = new RendererModel(this, 44, 45);
		leftleglower.addBox(-2.0F, 5.0F, 0.0F, 4, 6, 4);
		leftleglower.setRotationPoint(3.0F, 13.0F, 4.0F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, -0.1745329F, 0.0F, 0.0F);

		convertToChild(rightarmupper, rightarmlower);
		convertToChild(leftarmupper, leftarmlower);
		convertToChild(rightlegupper, rightleglower);
		convertToChild(leftlegupper, leftleglower);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		body.render(scale);
		rightarmupper.render(scale);
		leftarmupper.render(scale);
		bodylower.render(scale);
		rightlegupper.render(scale);
		leftlegupper.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms

		// legs
		rightlegupper.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		rightlegupper.rotateAngleX -= 0.1745329F;
		leftlegupper.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		leftlegupper.rotateAngleX -= 0.1745329F;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		int i = entityIn.getAttackTimer();

		if (i > 0) {
			rightarmupper.rotateAngleX = -2.0F + 1.5F * triangleWave((float) i - partialTickTime, 10.0F);
			leftarmupper.rotateAngleX = -2.0F + 1.5F * triangleWave((float) i - partialTickTime, 10.0F);
		} else {
			rightarmupper.rotateAngleX = 0F;
			leftarmupper.rotateAngleX = 0F;
		}
	}

	private float triangleWave(float p_78172_1_, float p_78172_2_) {
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
	}
}
