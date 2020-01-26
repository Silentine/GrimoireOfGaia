package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMatango extends ModelGaia {
	ModelRenderer head;
	ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer headbrows;
	ModelRenderer headmushroom;
	ModelRenderer headrightmushroom;
	ModelRenderer headleftmushroom;
	ModelRenderer righthair;
	ModelRenderer lefthair;
	ModelRenderer righthairinside;
	ModelRenderer lefthairinside;
	ModelRenderer righthairend;
	ModelRenderer lefthairend;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer mushroom1;
	ModelRenderer mushroom2;
	ModelRenderer waist1;
	ModelRenderer waist2;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;

	public ModelGaiaMatango() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 5, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 80, 35);
		rightleg.addBox(-2F, 7F, -2F, 4, 6, 4);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightleg, 0F, 0F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		setRotation(leftleg, 0F, 0F, 0.0349066F);
		headbrows = new ModelRenderer(this, 24, 6);
		headbrows.addBox(-3F, -6F, -3.6F, 6, 6, 0);
		headbrows.setRotationPoint(0F, 1F, 0F);
		setRotation(headbrows, 0F, 0F, 0F);
		headmushroom = new ModelRenderer(this, 36, 14);
		headmushroom.addBox(-4F, -10.5F, -4F, 8, 6, 8);
		headmushroom.setRotationPoint(0F, 1F, 0F);
		setRotation(headmushroom, 0F, 0F, 0F);
		headrightmushroom = new ModelRenderer(this, 36, 28);
		headrightmushroom.addBox(-7F, -9F, -2.9F, 6, 6, 6);
		headrightmushroom.setRotationPoint(0F, 1F, 0F);
		setRotation(headrightmushroom, 0F, 0F, 0F);
		headleftmushroom = new ModelRenderer(this, 36, 28);
		headleftmushroom.mirror = true;
		headleftmushroom.addBox(1F, -9F, -2.9F, 6, 6, 6);
		headleftmushroom.setRotationPoint(0F, 1F, 0F);
		setRotation(headleftmushroom, 0F, 0F, 0F);
		righthair = new ModelRenderer(this, 36, 40);
		righthair.addBox(-1.5F, 0F, -1.5F, 3, 14, 3);
		righthair.setRotationPoint(-3F, -4F, 3F);
		setRotation(righthair, 0.1745329F, 0F, 0.1745329F);
		lefthair = new ModelRenderer(this, 36, 40);
		lefthair.mirror = true;
		lefthair.addBox(-1.5F, 0F, -1.5F, 3, 14, 3);
		lefthair.setRotationPoint(3F, -4F, 3F);
		setRotation(lefthair, 0.1745329F, 0F, -0.1745329F);
		righthairinside = new ModelRenderer(this, 36, 57);
		righthairinside.addBox(-1F, 11F, -1F, 2, 2, 2);
		righthairinside.setRotationPoint(-3F, -4F, 3F);
		setRotation(righthairinside, 0.1745329F, 0F, 0.1745329F);
		lefthairinside = new ModelRenderer(this, 36, 57);
		lefthairinside.addBox(-1F, 11F, -1F, 2, 2, 2);
		lefthairinside.setRotationPoint(3F, -4F, 3F);
		setRotation(lefthairinside, 0.1745329F, 0F, -0.1745329F);
		righthairend = new ModelRenderer(this, 48, 40);
		righthairend.addBox(-2F, 13F, -2F, 4, 2, 4);
		righthairend.setRotationPoint(-3F, -4F, 3F);
		setRotation(righthairend, 0.1745329F, 0F, 0.1745329F);
		lefthairend = new ModelRenderer(this, 48, 40);
		lefthairend.mirror = true;
		lefthairend.addBox(-2F, 13F, -2F, 4, 2, 4);
		lefthairend.setRotationPoint(3F, -4F, 3F);
		setRotation(lefthairend, 0.1745329F, 0F, -0.1745329F);
		rightarmlower = new ModelRenderer(this, 68, 0);
		rightarmlower.addBox(-2.5F, 4F, -1.5F, 3, 6, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarmlower, 0F, 0F, 0.1745329F);
		leftarmlower = new ModelRenderer(this, 68, 0);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-0.5F, 4F, -1.5F, 3, 6, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarmlower, 0F, 0F, -0.1745329F);
		mushroom1 = new ModelRenderer(this, 80, 0);
		mushroom1.addBox(-3F, 6F, -3.5F, 6, 1, 6);
		mushroom1.setRotationPoint(0F, 1F, 0F);
		setRotation(mushroom1, 0.0872665F, 0F, 0F);
		mushroom2 = new ModelRenderer(this, 80, 7);
		mushroom2.addBox(-2.5F, 6.5F, -3F, 5, 2, 5);
		mushroom2.setRotationPoint(0F, 1F, 0F);
		setRotation(mushroom2, 0.0872665F, 0F, 0F);
		waist1 = new ModelRenderer(this, 80, 14);
		waist1.addBox(-3.5F, 7.5F, -4F, 7, 2, 7);
		waist1.setRotationPoint(0F, 1F, 0F);
		setRotation(waist1, 0.0872665F, 0F, 0F);
		waist2 = new ModelRenderer(this, 80, 23);
		waist2.addBox(-4F, 9F, -4.5F, 8, 4, 8);
		waist2.setRotationPoint(0F, 1F, 0F);
		setRotation(waist2, 0.0872665F, 0F, 0F);
		rightleglower = new ModelRenderer(this, 24, 12);
		rightleglower.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleglower.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightleglower, 0F, 0F, -0.0349066F);
		leftleglower = new ModelRenderer(this, 80, 35);
		leftleglower.mirror = true;
		leftleglower.addBox(-2F, 7F, -2F, 4, 6, 4);
		leftleglower.setRotationPoint(2F, 11F, 0F);
		setRotation(leftleglower, 0F, 0F, 0.0349066F);

		convertToChild(head, headbrows);
		convertToChild(headmushroom, headrightmushroom);
		convertToChild(headmushroom, headleftmushroom);
		convertToChild(head, headmushroom);
		
		convertToChild(righthair, righthairend);
		convertToChild(lefthair, lefthairend);
		convertToChild(righthair, righthairinside);
		convertToChild(lefthair, lefthairinside);
		convertToChild(head, righthair);
		convertToChild(head, lefthair);
	
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
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
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
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
        rightleg.rotateAngleY = 0.0F;
        leftleg.rotateAngleY = 0.0F;
        rightleg.rotateAngleZ = -0.0349066F;
        leftleg.rotateAngleZ = 0.0349066F;
		
		if (isRiding) {
			rightarm.rotateAngleX += -((float) Math.PI / 5F);
			leftarm.rotateAngleX += -((float) Math.PI / 5F);
			rightleg.rotateAngleX = -1.4137167F;
			rightleg.rotateAngleY = ((float) Math.PI / 10F);
			rightleg.rotateAngleZ = 0.07853982F;
			leftleg.rotateAngleX = -1.4137167F;
			leftleg.rotateAngleY = -((float) Math.PI / 10F);
			leftleg.rotateAngleZ = -0.07853982F;
		}
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
