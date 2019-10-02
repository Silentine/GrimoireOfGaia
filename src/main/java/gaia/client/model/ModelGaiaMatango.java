package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaMatango<T extends MobEntity> extends ModelGaia<T> {
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
	private RendererModel mushroom1;
	private RendererModel mushroom2;
	private RendererModel waist1;
	private RendererModel waist2;

	public ModelGaiaMatango() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(128, 64);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(128, 64);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(128, 64);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(128, 64);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(128, 64);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(128, 64);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		rightchest.setTextureSize(128, 64);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		leftchest.setTextureSize(128, 64);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(128, 64);
		setRotation(rightleg, 0F, 0F, -0.0349066F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(128, 64);
		setRotation(leftleg, 0F, 0F, 0.0349066F);
		RendererModel hair1 = new RendererModel(this, 36, 14);
		hair1.addBox(-4F, -5.5F, -1F, 8, 5, 5);
		hair1.setRotationPoint(0F, 1F, 0F);
		hair1.setTextureSize(128, 64);
		setRotation(hair1, 0F, 0F, 0F);
		RendererModel hair2 = new RendererModel(this, 36, 24);
		hair2.addBox(-4.5F, -4.5F, -0.5F, 9, 5, 5);
		hair2.setRotationPoint(0F, 1F, 0F);
		hair2.setTextureSize(128, 64);
		setRotation(hair2, 0F, 0F, 0F);
		RendererModel headmushroom1 = new RendererModel(this, 36, 34);
		headmushroom1.addBox(-0.5F, -8.5F, -0.5F, 3, 3, 3);
		headmushroom1.setRotationPoint(0F, 1F, 0F);
		headmushroom1.setTextureSize(128, 64);
		setRotation(headmushroom1, 0F, 0F, 0F);
		RendererModel headmushroom2 = new RendererModel(this, 36, 40);
		headmushroom2.addBox(-2.5F, -7.5F, -2.5F, 2, 2, 2);
		headmushroom2.setRotationPoint(0F, 1F, 0F);
		headmushroom2.setTextureSize(128, 64);
		setRotation(headmushroom2, 0F, 0F, 0F);
		RendererModel rightarmupper = new RendererModel(this, 64, 0);
		rightarmupper.addBox(-2.5F, -1F, -1.5F, 3, 2, 3);
		rightarmupper.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmupper.setTextureSize(128, 64);
		setRotation(rightarmupper, 0F, 0F, 0.1745329F);
		RendererModel leftarmupper = new RendererModel(this, 64, 0);
		leftarmupper.addBox(-0.5F, -1F, -1.5F, 3, 2, 3);
		leftarmupper.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmupper.setTextureSize(128, 64);
		setRotation(leftarmupper, 0F, 0F, -0.1745329F);
		mushroom1 = new RendererModel(this, 36, 34);
		mushroom1.addBox(-3F, 6.5F, -1.5F, 3, 3, 3);
		mushroom1.setRotationPoint(0F, 1F, 0F);
		mushroom1.setTextureSize(128, 64);
		setRotation(mushroom1, 0.0872665F, 0F, 0F);
		mushroom2 = new RendererModel(this, 36, 40);
		mushroom2.addBox(1F, 6.5F, -3.5F, 2, 2, 2);
		mushroom2.setRotationPoint(0F, 1F, 0F);
		mushroom2.setTextureSize(128, 64);
		setRotation(mushroom2, 0.0872665F, 0F, 0F);
		waist1 = new RendererModel(this, 64, 5);
		waist1.addBox(-3.5F, 7.5F, -4F, 7, 2, 6);
		waist1.setRotationPoint(0F, 1F, 0F);
		waist1.setTextureSize(128, 64);
		setRotation(waist1, 0.0872665F, 0F, 0F);
		waist2 = new RendererModel(this, 64, 13);
		waist2.addBox(-4F, 9F, -4.5F, 8, 4, 7);
		waist2.setRotationPoint(0F, 1F, 0F);
		waist2.setTextureSize(128, 64);
		setRotation(waist2, 0.0872665F, 0F, 0F);

		convertToChild(head, hair1);
		convertToChild(head, hair2);
		convertToChild(head, headmushroom1);
		convertToChild(head, headmushroom2);
		convertToChild(rightarm, rightarmupper);
		convertToChild(leftarm, leftarmupper);
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
		mushroom1.render(scale);
		mushroom2.render(scale);
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
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		waist1.rotateAngleY = ((MathHelper.cos(limbSwing * 0.6662F) * 0.5F) / 2) * limbSwingAmount;
		waist2.rotateAngleY = waist1.rotateAngleY;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
	}

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
