package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaKikimora<T extends MobEntity> extends ModelGaia<T> {
	
	RendererModel head;
	RendererModel headeyes;
	RendererModel headaccessory;
	RendererModel neck;
	RendererModel bodytop;
	RendererModel bodymiddle;
	RendererModel bodymiddlebutton;
	RendererModel bodybottom;
	RendererModel rightchest;
	RendererModel leftchest;
	RendererModel rightarm;
	RendererModel leftarm;
	RendererModel rightarmlower;
	RendererModel leftarmlower;
	RendererModel rightleg;
	RendererModel leftleg;
	RendererModel rightear;
	RendererModel leftear;
	RendererModel skirtribbon;
	RendererModel rightskirt01;
	RendererModel leftskirt01;
	RendererModel rightskirt02;
	RendererModel leftskirt02;
	RendererModel rightskirt03;
	RendererModel leftskirt03;
	RendererModel tail01;
	RendererModel tail02;
	RendererModel tail03;
	RendererModel tail04;
	RendererModel tail05;

	public ModelGaiaKikimora() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightarmlower = new RendererModel(this, 16, 20);
		rightarmlower.addBox(-1F, 0F, -2F, 2, 6, 2);
		rightarmlower.setRotationPoint(-3.5F, 7.5F, 1F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new RendererModel(this, 16, 20);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-1F, 0F, -2F, 2, 6, 2);
		leftarmlower.setRotationPoint(3.5F, 7.5F, 1F);
		setRotation(leftarmlower, 0F, 0F, 0F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightleg, 0F, -0.0872665F, 0F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		setRotation(leftleg, 0F, 0.0872665F, 0F);
		RendererModel hat = new RendererModel(this, 36, 14);
		hat.addBox(-4F, -5F, -4F, 8, 4, 8);
		hat.setRotationPoint(0F, -2F, 0F);
		setRotation(hat, -0.7853982F, 0F, 0F);
		rightear = new RendererModel(this, 36, 26);
		rightear.addBox(0F, 0F, -1.5F, 3, 4, 3);
		rightear.setRotationPoint(-3.5F, -4F, 0F);
		setRotation(rightear, 0F, 0F, 0.5235988F);
		leftear = new RendererModel(this, 36, 26);
		leftear.mirror = true;
		leftear.addBox(-3F, 0F, -1.5F, 3, 4, 3);
		leftear.setRotationPoint(3.5F, -4F, 0F);
		setRotation(leftear, 0F, 0F, -0.5235988F);
		RendererModel rightpauldronoverlay = new RendererModel(this, 36, 33);
		rightpauldronoverlay.addBox(-2.5F, -1.5F, -2F, 4, 4, 4);
		rightpauldronoverlay.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightpauldronoverlay, 0F, 0F, 0.2617994F);
		RendererModel leftpauldronoverlay = new RendererModel(this, 36, 33);
		leftpauldronoverlay.mirror = true;
		leftpauldronoverlay.addBox(-1.5F, -1.5F, -2F, 4, 4, 4);
		leftpauldronoverlay.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftpauldronoverlay, 0F, 0F, -0.2617994F);
		RendererModel rightpauldron = new RendererModel(this, 36, 41);
		rightpauldron.addBox(-2.5F, -1F, -1.5F, 3, 3, 3);
		rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightpauldron, 0F, 0F, 0F);
		RendererModel leftpauldron = new RendererModel(this, 36, 41);
		leftpauldron.mirror = true;
		leftpauldron.addBox(-0.5F, -1F, -1.5F, 3, 3, 3);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftpauldron, 0F, 0F, 0F);
		RendererModel rightcufflink = new RendererModel(this, 36, 47);
		rightcufflink.addBox(-1F, -5F, -1F, 2, 4, 2);
		rightcufflink.setRotationPoint(-3.5F, 13.5F, 0F);
		setRotation(rightcufflink, -0.1745329F, 0F, -0.1745329F);
		RendererModel leftcufflink = new RendererModel(this, 36, 47);
		leftcufflink.mirror = true;
		leftcufflink.addBox(-1F, -5F, -1F, 2, 4, 2);
		leftcufflink.setRotationPoint(3.5F, 13.5F, 0F);
		setRotation(leftcufflink, -0.1745329F, 0F, 0.1745329F);
		skirtribbon = new RendererModel(this, 84, 0);
		skirtribbon.addBox(-3.5F, 1F, 7.5F, 7, 2, 5);
		skirtribbon.setRotationPoint(0F, 1F, 0F);
		setRotation(skirtribbon, -1.047198F, 0F, 0F);
		rightskirt01 = new RendererModel(this, 84, 7);
		rightskirt01.addBox(-4F, -1.5F, -3.5F, 4, 3, 7);
		rightskirt01.setRotationPoint(0F, 11F, 0F);
		setRotation(rightskirt01, 0F, 0F, 0F);
		leftskirt01 = new RendererModel(this, 84, 7);
		leftskirt01.mirror = true;
		leftskirt01.addBox(0F, -1.5F, -3.5F, 4, 3, 7);
		leftskirt01.setRotationPoint(0F, 11F, 0F);
		setRotation(leftskirt01, 0F, 0F, 0F);
		rightskirt02 = new RendererModel(this, 84, 17);
		rightskirt02.addBox(-4.5F, 1.5F, -4F, 5, 4, 8);
		rightskirt02.setRotationPoint(0F, 11F, 0F);
		setRotation(rightskirt02, 0F, 0F, 0F);
		leftskirt02 = new RendererModel(this, 84, 17);
		leftskirt02.mirror = true;
		leftskirt02.addBox(-0.5F, 1.5F, -4F, 5, 4, 8);
		leftskirt02.setRotationPoint(0F, 11F, 0F);
		setRotation(leftskirt02, 0F, 0F, 0F);
		rightskirt03 = new RendererModel(this, 84, 29);
		rightskirt03.addBox(-5F, 5.5F, -4.5F, 6, 5, 9);
		rightskirt03.setRotationPoint(0F, 11F, 0F);
		setRotation(rightskirt03, 0F, 0F, 0F);
		leftskirt03 = new RendererModel(this, 84, 29);
		leftskirt03.mirror = true;
		leftskirt03.addBox(-1F, 5.5F, -4.5F, 6, 5, 9);
		leftskirt03.setRotationPoint(0F, 11F, 0F);
		setRotation(leftskirt03, 0F, 0F, 0F);
		tail01 = new RendererModel(this, 68, 0);
		tail01.addBox(-1.5F, -1.5F, 0F, 3, 3, 3);
		tail01.setRotationPoint(0F, 9F, 1F);
		setRotation(tail01, 0F, 0F, 0F);
		tail02 = new RendererModel(this, 68, 6);
		tail02.addBox(-2F, -2F, 0F, 4, 4, 4);
		tail02.setRotationPoint(0F, 9F, 4F);
		setRotation(tail02, 0F, 0F, 0F);
		tail03 = new RendererModel(this, 68, 14);
		tail03.addBox(-2F, -2F, 0F, 4, 4, 4);
		tail03.setRotationPoint(0F, 9F, 8F);
		setRotation(tail03, 0F, 0F, 0F);
		tail04 = new RendererModel(this, 68, 22);
		tail04.addBox(-1.5F, -1.5F, 0F, 3, 3, 3);
		tail04.setRotationPoint(0F, 9F, 12F);
		setRotation(tail04, 0F, 0F, 0F);
		tail05 = new RendererModel(this, 68, 28);
		tail05.addBox(-1.5F, -1.5F, 0F, 3, 3, 3);
		tail05.setRotationPoint(0F, 9F, 15F);
		setRotation(tail05, 0F, 0F, 0F);

		convertToChild(head, hat);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightpauldron, rightpauldronoverlay);
		convertToChild(rightarm, rightpauldron);
		convertToChild(leftpauldron, leftpauldronoverlay);
		convertToChild(leftarm, leftpauldron);
		convertToChild(rightarmlower, rightcufflink);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarmlower, leftcufflink);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightskirt02, rightskirt03);
		convertToChild(rightleg, rightskirt02);
		convertToChild(leftskirt02, leftskirt03);
		convertToChild(leftleg, leftskirt02);
		convertToChild(tail04, tail05);
		convertToChild(tail03, tail04);
		convertToChild(tail02, tail03);
		convertToChild(tail01, tail02);
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
		rightskirt01.render(scale);
		leftskirt01.render(scale);
		skirtribbon.render(scale);
		tail01.render(scale);

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
		
		float earDefaultAngleZ = 0.5235988F;

		rightear.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
		rightear.rotateAngleZ += earDefaultAngleZ;
		leftear.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * -degToRad(4);
		leftear.rotateAngleZ += -earDefaultAngleZ;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		float armDefaultAngleY = 0.349066F;
		float armDefaultAngleZ = 0.174533F;

		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		rightarm.rotateAngleY = +armDefaultAngleY;
		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
		
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleY = -armDefaultAngleY;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
		
		rightarmlower.rotateAngleX = -armDefaultAngleY;
		leftarmlower.rotateAngleX = -armDefaultAngleY;

		// body
		tail02.rotateAngleX = -0.3926991F;
		tail03.rotateAngleX = -0.785398F;
		tail04.rotateAngleX = +0.3926991F;
		tail05.rotateAngleX = +0.785398F;
		
		tail02.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(1);
		tail03.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(5);
		tail04.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(10);
		tail05.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(15);

		// legs
		rightleg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount) * 0.5F;
		leftleg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount) * 0.5F;
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

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
