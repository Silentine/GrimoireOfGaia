package gaia.client.model;

import gaia.entity.AbstractMobPropEntity;
import gaia.entity.prop.GaiaPropChestMimicEntity;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaPropChestMimic<T extends AbstractMobPropEntity> extends ModelGaia<T> {

	RendererModel body01;
	RendererModel body02;
	RendererModel lock;

	public ModelGaiaPropChestMimic() {
		textureWidth = 64;
		textureHeight = 64;

		body01 = new RendererModel(this, 0, 0);
		body01.addBox(-7F, -14F, -7F, 14, 5, 14);
		body01.setRotationPoint(0F, 24F, 0F);
		setRotation(body01, 0F, 0F, 0F);
		body02 = new RendererModel(this, 0, 19);
		body02.addBox(-7F, -10F, -7F, 14, 10, 14);
		body02.setRotationPoint(0F, 24F, 0F);
		setRotation(body02, 0F, 0F, 0F);
		lock = new RendererModel(this, 0, 0);
		lock.addBox(-1F, -11F, -8F, 2, 4, 1);
		lock.setRotationPoint(0F, 24F, 0F);
		setRotation(lock, 0F, 0F, 0F);

		convertToChild(body01, body02);
		convertToChild(body01, lock);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		body01.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		GaiaPropChestMimicEntity entityGaiaPropChestMimic = (GaiaPropChestMimicEntity) entityIn;

		switch (entityGaiaPropChestMimic.getRotation()) {
		case 0:
			body01.rotateAngleY = 0;
			break;
		case 1:
			body01.rotateAngleY = degToRad(90);
			break;
		case 2:
			body01.rotateAngleY = degToRad(180);
			break;
		case 3:
			body01.rotateAngleY = degToRad(270);
			break;
		}
	}
}
