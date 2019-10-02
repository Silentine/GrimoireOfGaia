package gaia.client.model;

import gaia.entity.AbstractMobPropEntity;
import gaia.entity.prop.GaiaPropCampfireEntity;
import net.minecraft.client.renderer.entity.model.RendererModel;

public class ModelGaiaPropCampfire<T extends AbstractMobPropEntity> extends ModelGaia<T> {
	RendererModel potbody;
	RendererModel pothandle;
	RendererModel midwood01;
	RendererModel midwood02;
	RendererModel midwood03;
	RendererModel midwood04;
	RendererModel bottomwood01;
	RendererModel bottomwood02;
	RendererModel ironrod01;
	RendererModel ironrod02;
	RendererModel ironrod03;

	public ModelGaiaPropCampfire() {
		textureWidth = 128;
		textureHeight = 64;

		potbody = new RendererModel(this, 40, 4);
		potbody.addBox(-3F, 2F, -3F, 6, 6, 6);
		potbody.setRotationPoint(0F, 8F, 0F);
		setRotation(potbody, 0F, 0.0F, 0F);
		pothandle = new RendererModel(this, 40, 0);
		pothandle.addBox(-3F, 0F, -0.5F, 6, 3, 1);
		pothandle.setRotationPoint(0F, 8F, 0F);
		setRotation(pothandle, 0F, 0.7853982F, 0F);
		midwood01 = new RendererModel(this, 0, 8);
		midwood01.addBox(-2F, -4F, -8F, 4, 4, 8);
		midwood01.setRotationPoint(0F, 24F, 6F);
		setRotation(midwood01, -0.3926991F, 0F, 0F);
		midwood02 = new RendererModel(this, 0, 0);
		midwood02.addBox(-8F, -4F, -2F, 8, 4, 4);
		midwood02.setRotationPoint(6F, 24F, 0F);
		setRotation(midwood02, 0F, 0F, 0.3926991F);
		midwood03 = new RendererModel(this, 0, 8);
		midwood03.addBox(-2F, -4F, 0F, 4, 4, 8);
		midwood03.setRotationPoint(0F, 24F, -6F);
		setRotation(midwood03, 0.3926991F, 0F, 0F);
		midwood04 = new RendererModel(this, 0, 0);
		midwood04.mirror = true;
		midwood04.addBox(0F, -4F, -2F, 8, 4, 4);
		midwood04.setRotationPoint(-6F, 24F, 0F);
		setRotation(midwood04, 0F, 0F, -0.3926991F);
		bottomwood01 = new RendererModel(this, 0, 20);
		bottomwood01.addBox(-8F, -4F, -2F, 16, 4, 4);
		bottomwood01.setRotationPoint(0F, 24F, 0F);
		setRotation(bottomwood01, 0F, 0.7853982F, 0F);
		bottomwood02 = new RendererModel(this, 0, 20);
		bottomwood02.addBox(-8F, -4F, -2F, 16, 4, 4);
		bottomwood02.setRotationPoint(0F, 24F, 0F);
		setRotation(bottomwood02, 0F, 2.356194F, 0F);
		ironrod01 = new RendererModel(this, 0, 30);
		ironrod01.addBox(-1F, -16F, 8F, 2, 16, 2);
		ironrod01.setRotationPoint(0F, 24F, 0F);
		setRotation(ironrod01, 0F, 0.7853982F, 0F);
		ironrod02 = new RendererModel(this, 0, 28);
		ironrod02.addBox(-8F, -15.5F, -0.5F, 16, 1, 1);
		ironrod02.setRotationPoint(0F, 24F, 0F);
		setRotation(ironrod02, 0F, -0.7853982F, 0F);
		ironrod03 = new RendererModel(this, 0, 30);
		ironrod03.addBox(-10F, 0F, -1F, 2, 16, 2);
		ironrod03.setRotationPoint(0F, 8F, 0F);
		setRotation(ironrod03, 0F, -0.7853982F, 0F);
		
		convertToChild(potbody, pothandle);
		convertToChild(bottomwood01, bottomwood02);
		convertToChild(ironrod02, ironrod03);
		convertToChild(ironrod01, ironrod02);
		convertToChild(potbody, midwood04);
		convertToChild(potbody, midwood03);
		convertToChild(potbody, midwood02);
		convertToChild(potbody, midwood01);
		convertToChild(potbody, bottomwood01);
		convertToChild(potbody, ironrod01);
	}

	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		potbody.render(scale);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		GaiaPropCampfireEntity entityGaiaPropCampfire = (GaiaPropCampfireEntity) entityIn;

		switch (entityGaiaPropCampfire.getRotation()) {
		case 0:
			potbody.rotateAngleY = degToRad(0);
			break;
		case 1:
			potbody.rotateAngleY = degToRad(90);
			break;
		}
	}
}