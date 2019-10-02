package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaDullahan<T extends MobEntity> extends ModelGaia<T> {

	private RendererModel head;
	private RendererModel headeyes;
	private RendererModel headaccessory;
	private RendererModel neck;
	private RendererModel bodytop;
	private RendererModel bodymiddle;
	private RendererModel bodymiddlebutton;
	private RendererModel bodybottom;
	private RendererModel rightchest;
	private RendererModel leftchest;
	private RendererModel rightarm;
	private RendererModel leftarm;
	private RendererModel rightleg;
	private RendererModel leftleg;
	private RendererModel waist1;
	private RendererModel waist2;

	public ModelGaiaDullahan() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -3F, -3F, 6, 6, 6);
		head.setRotationPoint(4F, 3F, -6F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -3F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(4F, 3F, -6F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -3.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(4F, 3F, -6F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(64, 32);
		setRotation(neck, -0.0872665F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.25F, 3F, -1.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, 0F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		RendererModel rightshoulder = new RendererModel(this, 36, 14);
		rightshoulder.addBox(-3.5F, -3F, -2F, 4, 5, 4);
		rightshoulder.setRotationPoint(-2.5F, 2.5F, 0F);
		rightshoulder.setTextureSize(64, 32);
		setRotation(rightshoulder, 0F, 0F, -0.1745329F);
		RendererModel leftshoulder = new RendererModel(this, 52, 14);
		leftshoulder.addBox(-0.5F, -3F, -2F, 4, 5, 4);
		leftshoulder.setRotationPoint(2.5F, 2.5F, 0F);
		leftshoulder.setTextureSize(64, 32);
		setRotation(leftshoulder, 0F, 0F, 0.1745329F);
		RendererModel leftarmlower = new RendererModel(this, 16, 20);
		leftarmlower.addBox(0F, 0F, 4F, 2, 6, 2);
		leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, -1.570796F, 0F, -0.1745329F);
		RendererModel rightgauntlet = new RendererModel(this, 36, 23);
		rightgauntlet.addBox(-2.5F, 5.5F, -1.5F, 2, 6, 3);
		rightgauntlet.setRotationPoint(-2.5F, 2.5F, 0F);
		rightgauntlet.setTextureSize(64, 32);
		setRotation(rightgauntlet, 0F, 0F, 0.1745329F);
		RendererModel leftgauntlet = new RendererModel(this, 46, 23);
		leftgauntlet.addBox(-0.5F, 0.5F, 4.5F, 3, 6, 2);
		leftgauntlet.setRotationPoint(2.5F, 2.5F, 0F);
		leftgauntlet.setTextureSize(64, 32);
		setRotation(leftgauntlet, -1.570796F, 0F, -0.1745329F);
		waist1 = new RendererModel(this, 68, 0);
		waist1.addBox(-3.5F, 7.5F, -3F, 7, 6, 4);
		waist1.setRotationPoint(0F, 1F, 0F);
		waist1.setTextureSize(64, 32);
		setRotation(waist1, 0.0872665F, 0F, 0F);
		waist2 = new RendererModel(this, 68, 10);
		waist2.addBox(-4F, 8.5F, -3.5F, 8, 8, 4);
		waist2.setRotationPoint(0F, 1F, 0F);
		waist2.setTextureSize(64, 32);
		setRotation(waist2, 0.1745329F, 0F, 0F);
		RendererModel rightfoot = new RendererModel(this, 68, 22);
		rightfoot.addBox(-2.5F, 5F, -2F, 4, 8, 4);
		rightfoot.setRotationPoint(-1.5F, 11F, 0F);
		rightfoot.setTextureSize(64, 32);
		setRotation(rightfoot, 0F, 0F, 0F);
		RendererModel leftfoot = new RendererModel(this, 68, 22);
		leftfoot.addBox(-1.5F, 5F, -2F, 4, 8, 4);
		leftfoot.setRotationPoint(1.5F, 11F, 0F);
		leftfoot.setTextureSize(64, 32);
		setRotation(leftfoot, 0F, 0F, 0F);

		convertToChild(rightarm, rightshoulder);
		convertToChild(rightarm, rightgauntlet);
		convertToChild(leftarm, leftshoulder);
		convertToChild(leftarm, leftarmlower);
		convertToChild(leftarm, leftgauntlet);
		convertToChild(rightleg, rightfoot);
		convertToChild(leftleg, leftfoot);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymiddle.render(scale);
		bodymiddlebutton.render(scale);
		bodybottom.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		waist1.render(scale);
		waist2.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = 0.0F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
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

		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleX += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	public RendererModel getRightArm() {
		return rightarm;
	}
}
