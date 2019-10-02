package gaia.client.model;

import gaia.entity.AbstractMobPropEntity;
import gaia.entity.prop.GaiaPropVaseEntity;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaPropVase<T extends AbstractMobPropEntity> extends ModelGaia<T> {
	RendererModel top01;
	RendererModel top02;
	RendererModel body01;
	RendererModel body02;

	public ModelGaiaPropVase() {
		textureWidth = 128;
		textureHeight = 64;

		top01 = new RendererModel(this, 0, 0);
		top01.addBox(-4F, -15F, -4F, 8, 2, 8);
		top01.setRotationPoint(0F, 24F, 0F);
		setRotation(top01, 0F, 0F, 0F);
		top02 = new RendererModel(this, 0, 10);
		top02.addBox(-3F, -13F, -3F, 6, 2, 6);
		top02.setRotationPoint(0F, 24F, 0F);
		setRotation(top02, 0F, 0F, 0F);
		body01 = new RendererModel(this, 32, 0);
		body01.addBox(-5F, -12F, -5F, 10, 12, 10);
		body01.setRotationPoint(0F, 24F, 0F);
		setRotation(body01, 0F, 0F, 0F);
		body02 = new RendererModel(this, 32, 22);
		body02.addBox(-6F, -3F, -6F, 12, 9, 12);
		body02.setRotationPoint(0F, 16F, 0F);
		setRotation(body02, 0F, 0F, 0F);

		convertToChild(body01, body02);
		convertToChild(top01, top02);
		convertToChild(top01, body01);
	}

	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		top01.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		GaiaPropVaseEntity gaiaPropVaseEntity = (GaiaPropVaseEntity) entityIn;

		switch (gaiaPropVaseEntity.getRotation()) {
		case 0:
			top01.rotateAngleX = 0;
			top01.rotateAngleZ = 0;
			break;
		case 1:
			top01.rotateAngleX = -degToRad(15);
			top01.rotateAngleZ = 0;
			break;
		case 2:
			top01.rotateAngleX = 0;
			top01.rotateAngleZ = degToRad(15);
			break;
		case 3:
			top01.rotateAngleX = degToRad(15);
			top01.rotateAngleZ = 0;
			break;
		case 4:
			top01.rotateAngleX = 0;
			top01.rotateAngleZ = -degToRad(15);
			break;
		}
	}
}