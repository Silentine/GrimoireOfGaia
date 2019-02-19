package gaia.model;

import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaAntRanger extends ModelGaia {
	// fields
	ModelRenderer head;
	ModelRenderer rightmandable;
	ModelRenderer leftmandable;
	ModelRenderer bodyupper;
	ModelRenderer bodylower;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;

	public ModelGaiaAntRanger() {
		textureWidth = 128;
		textureHeight = 64;

		float rotationPointY = 18F;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.5F, -2F, -7F, 5, 4, 7);
		head.setRotationPoint(0F, 0F + rotationPointY, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		ModelRenderer righteye = new ModelRenderer(this, 0, 11);
		righteye.addBox(-3.5F, -3F, -5F, 2, 2, 2);
		righteye.setRotationPoint(0F, 0F + rotationPointY, 0F);
		righteye.setTextureSize(64, 32);
		setRotation(righteye, 0F, 0F, 0F);
		ModelRenderer lefteye = new ModelRenderer(this, 0, 11);
		lefteye.mirror = true;
		lefteye.addBox(1.5F, -3F, -5F, 2, 2, 2);
		lefteye.setRotationPoint(0F, 0F + rotationPointY, 0F);
		lefteye.setTextureSize(64, 32);
		setRotation(lefteye, 0F, 0F, 0F);
		ModelRenderer rightantenna = new ModelRenderer(this, 0, 15);
		rightantenna.addBox(-1.5F, -5F, -8F, 1, 4, 2);
		rightantenna.setRotationPoint(0F, 0F + rotationPointY, 0F);
		rightantenna.setTextureSize(64, 32);
		setRotation(rightantenna, 0F, 0.0872665F, 0F);
		ModelRenderer leftantenna = new ModelRenderer(this, 0, 15);
		leftantenna.mirror = true;
		leftantenna.addBox(0.5F, -5F, -8F, 1, 4, 2);
		leftantenna.setRotationPoint(0F, 0F + rotationPointY, 0F);
		leftantenna.setTextureSize(64, 32);
		setRotation(leftantenna, 0F, -0.0872665F, 0F);
		ModelRenderer rightantennatop = new ModelRenderer(this, 0, 21);
		rightantennatop.addBox(-1.5F, -6F, -11F, 1, 2, 4);
		rightantennatop.setRotationPoint(0F, 0F + rotationPointY, 0F);
		rightantennatop.setTextureSize(64, 32);
		setRotation(rightantennatop, 0F, 0.0872665F, 0F);
		ModelRenderer leftantennatop = new ModelRenderer(this, 0, 21);
		leftantennatop.mirror = true;
		leftantennatop.addBox(0.5F, -6F, -11F, 1, 2, 4);
		leftantennatop.setRotationPoint(0F, 0F + rotationPointY, 0F);
		leftantennatop.setTextureSize(64, 32);
		setRotation(leftantennatop, 0F, -0.0872665F, 0F);
		rightmandable = new ModelRenderer(this, 0, 27);
		rightmandable.addBox(-4.5F, 1F, -9F, 3, 2, 4);
		rightmandable.setRotationPoint(0F, 0F + rotationPointY, 0F);
		rightmandable.setTextureSize(64, 32);
		setRotation(rightmandable, 0F, -0.1745329F, 0F);
		leftmandable = new ModelRenderer(this, 0, 27);
		leftmandable.mirror = true;
		leftmandable.addBox(1.5F, 1F, -9F, 3, 2, 4);
		leftmandable.setRotationPoint(0F, 0F + rotationPointY, 0F);
		leftmandable.setTextureSize(64, 32);
		setRotation(leftmandable, 0F, 0.1745329F, 0F);
		bodyupper = new ModelRenderer(this, 32, 0);
		bodyupper.addBox(-2F, 1F, -2F, 4, 6, 4);
		bodyupper.setRotationPoint(0F, 0F + rotationPointY, 0F);
		bodyupper.setTextureSize(128, 64);
		setRotation(bodyupper, 0.3490659F, 0F, 0F);
		bodylower = new ModelRenderer(this, 32, 10);
		bodylower.addBox(-2.5F, 5F, -1.5F, 5, 6, 5);
		bodylower.setRotationPoint(0F, 0F + rotationPointY, 0F);
		bodylower.setTextureSize(128, 64);
		setRotation(bodylower, 0F, 0F, 0F);
		ModelRenderer thorax1 = new ModelRenderer(this, 32, 21);
		thorax1.addBox(-3F, 6F, 8F, 6, 8, 6);
		thorax1.setRotationPoint(0F, 0F + rotationPointY, 0F);
		thorax1.setTextureSize(128, 64);
		setRotation(thorax1, -0.6981317F, 0F, 0F);
		ModelRenderer thorax2 = new ModelRenderer(this, 32, 35);
		thorax2.addBox(-1F, 13F, 7F, 2, 2, 2);
		thorax2.setRotationPoint(0F, 0F + rotationPointY, 0F);
		thorax2.setTextureSize(128, 64);
		setRotation(thorax2, -0.6981317F, 0F, 0F);
		rightarm = new ModelRenderer(this, 56, 0);
		rightarm.addBox(-4F, -1F, -1F, 4, 2, 2);
		rightarm.setRotationPoint(-2F, 2F + rotationPointY, -1F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, -0.785398F, 0.3490659F);
		leftarm = new ModelRenderer(this, 56, 0);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 4, 2, 2);
		leftarm.setRotationPoint(2F, 2F + rotationPointY, -1F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0.785398F, -0.3490659F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 56, 4);
		rightarmlower.addBox(-5F, 0F, -1F, 2, 4, 2);
		rightarmlower.setRotationPoint(-2F, 2F + rotationPointY, -1F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0F, -0.785398F, 0.3490659F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 56, 4);
		leftarmlower.mirror = true;
		leftarmlower.addBox(3F, 0F, -1F, 2, 4, 2);
		leftarmlower.setRotationPoint(2F, 2F + rotationPointY, -1F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0F, 0.785398F, -0.3490659F);
		ModelRenderer rightarmhand = new ModelRenderer(this, 56, 10);
		rightarmhand.addBox(-4.5F, 4F, -0.5F, 1, 4, 1);
		rightarmhand.setRotationPoint(-2F, 2F + rotationPointY, -1F);
		rightarmhand.setTextureSize(64, 32);
		setRotation(rightarmhand, 0F, -0.785398F, 0.6108652F);
		ModelRenderer leftarmhand = new ModelRenderer(this, 56, 10);
		leftarmhand.mirror = true;
		leftarmhand.addBox(3.5F, 4F, -0.5F, 1, 4, 1);
		leftarmhand.setRotationPoint(2F, 2F + rotationPointY, -1F);
		leftarmhand.setTextureSize(64, 32);
		setRotation(leftarmhand, 0F, 0.785398F, -0.6108652F);
		rightleg = new ModelRenderer(this, 56, 15);
		rightleg.addBox(-1F, -1F, -1F, 2, 4, 2);
		rightleg.setRotationPoint(-2F, 5F + rotationPointY, -1F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -0.7853982F, 0F, 1.570796F);
		leftleg = new ModelRenderer(this, 56, 15);
		leftleg.mirror = true;
		leftleg.addBox(-1F, -1F, -1F, 2, 4, 2);
		leftleg.setRotationPoint(2F, 5F + rotationPointY, -1F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -0.7853982F, 0F, -1.570796F);
		ModelRenderer rightlegfoot = new ModelRenderer(this, 56, 21);
		rightlegfoot.addBox(-1F, 2F, -4F, 2, 2, 4);
		rightlegfoot.setRotationPoint(-2F, 5F + rotationPointY, -1F);
		rightlegfoot.setTextureSize(64, 32);
		setRotation(rightlegfoot, -0.7853982F, 0F, 1.570796F);
		ModelRenderer leftlegfoot = new ModelRenderer(this, 56, 21);
		leftlegfoot.mirror = true;
		leftlegfoot.addBox(-1F, 2F, -4F, 2, 2, 4);
		leftlegfoot.setRotationPoint(2F, 5F + rotationPointY, -1F);
		leftlegfoot.setTextureSize(64, 32);
		setRotation(leftlegfoot, -0.7853982F, 0F, -1.570796F);

		convertToChild(head, righteye);
		convertToChild(head, lefteye);
		convertToChild(head, rightantenna);
		convertToChild(head, leftantenna);
		convertToChild(head, rightantennatop);
		convertToChild(head, leftantennatop);
		convertToChild(head, rightmandable);
		convertToChild(head, leftmandable);
		convertToChild(rightarm, rightarmlower);
		convertToChild(rightarm, rightarmhand);
		convertToChild(leftarm, leftarmlower);
		convertToChild(leftarm, leftarmhand);
		convertToChild(bodylower, thorax1);
		convertToChild(bodylower, thorax2);
		convertToChild(rightleg, rightlegfoot);
		convertToChild(leftleg, leftlegfoot);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		bodyupper.render(scale);
		bodylower.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// body
		float swingSpeed = 0.1F;
		float angleRange = 0.1F;
		float mandableDefaultAngleY = 0.1745329F;

		rightmandable.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		rightmandable.rotateAngleY -= mandableDefaultAngleY;
		leftmandable.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		leftmandable.rotateAngleY += mandableDefaultAngleY;

		// body
		bodylower.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
	}
}
