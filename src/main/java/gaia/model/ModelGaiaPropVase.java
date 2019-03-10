package gaia.model;

import gaia.entity.prop.EntityGaiaPropVase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaPropVase extends ModelGaia {
	ModelRenderer top01;
	ModelRenderer top02;
	ModelRenderer body01;
	ModelRenderer body02;

	public ModelGaiaPropVase() {
		textureWidth = 128;
		textureHeight = 64;

		top01 = new ModelRenderer(this, 0, 0);
		top01.addBox(-4F, -15F, -4F, 8, 2, 8);
		top01.setRotationPoint(0F, 24F, 0F);
		setRotation(top01, 0F, 0F, 0F);
		top02 = new ModelRenderer(this, 0, 10);
		top02.addBox(-3F, -13F, -3F, 6, 2, 6);
		top02.setRotationPoint(0F, 24F, 0F);
		setRotation(top02, 0F, 0F, 0F);
		body01 = new ModelRenderer(this, 32, 0);
		body01.addBox(-5F, -12F, -5F, 10, 12, 10);
		body01.setRotationPoint(0F, 24F, 0F);
		setRotation(body01, 0F, 0F, 0F);
		body02 = new ModelRenderer(this, 32, 22);
		body02.addBox(-6F, -3F, -6F, 12, 9, 12);
		body02.setRotationPoint(0F, 16F, 0F);
		setRotation(body02, 0F, 0F, 0F);

		convertToChild(body01, body02);
		convertToChild(top01, top02);
		convertToChild(top01, body01);
	}

	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		top01.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		EntityGaiaPropVase entityGaiaPropVase = (EntityGaiaPropVase) entityIn;

		switch (entityGaiaPropVase.getRotation()) {
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