package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaArachne extends ModelGaia {

	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymiddlebutton;
	private ModelRenderer bodymiddle;
	private ModelRenderer bodybottom;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer waist;
	private ModelRenderer skull1;
	private ModelRenderer skull2;
	private ModelRenderer skull3;
	private ModelRenderer body1;
	private ModelRenderer body2;
	private ModelRenderer body3;
	private ModelRenderer body4;
	private ModelRenderer body5;
	private ModelRenderer leg7;
	private ModelRenderer leg5;
	private ModelRenderer leg3;
	private ModelRenderer leg1;
	private ModelRenderer leg2;
	private ModelRenderer leg4;
	private ModelRenderer leg6;
	private ModelRenderer leg8;

	public ModelGaiaArachne() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 5F, -10F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 5F, -10F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -5.5F, -3.5F, 7, 9, 7);
		headaccessory.setRotationPoint(0F, 4F, -10F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 4F, -10F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 5F, -10F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, 0.0872665F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 5F, -10F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0.1745329F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 5F, -10F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0.1745329F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 5F, -10F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.2617994F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 7F, -11.2F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 7F, -11.2F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		rightarm.setRotationPoint(-2.5F, 6.5F, -9.5F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.2617994F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
		leftarm.setRotationPoint(2.5F, 6.5F, -9.5F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.2617994F);
		ModelRenderer righteye = new ModelRenderer(this, 36, 16);
		righteye.addBox(-4F, -6F, -2.5F, 2, 2, 2);
		righteye.setRotationPoint(0F, 4F, -10F);
		righteye.setTextureSize(64, 32);
		setRotation(righteye, 0F, 0F, 0F);
		ModelRenderer lefteye = new ModelRenderer(this, 36, 16);
		lefteye.mirror = true;
		lefteye.addBox(2F, -8F, -2.5F, 2, 2, 2);
		lefteye.setRotationPoint(0F, 6F, -10F);
		lefteye.setTextureSize(64, 32);
		setRotation(lefteye, 0F, 0F, 0F);
		ModelRenderer hair = new ModelRenderer(this, 36, 20);
		hair.addBox(-2F, -7F, 1F, 4, 4, 4);
		hair.setRotationPoint(0F, 4F, -10F);
		hair.setTextureSize(64, 32);
		setRotation(hair, 0F, 0F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 36, 28);
		rightarmlower.addBox(-2.5F, 3.5F, -1.5F, 2, 6, 3);
		rightarmlower.setRotationPoint(-2.5F, 6.5F, -9.5F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0F, 0F, 0.2617994F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 36, 28);
		leftarmlower.mirror = true;
		leftarmlower.addBox(0.5F, 3.5F, -1.5F, 2, 6, 3);
		leftarmlower.setRotationPoint(2.5F, 6.5F, -9.5F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0F, 0F, -0.2617994F);
		waist = new ModelRenderer(this, 36, 37);
		waist.addBox(-3.5F, 9F, -3F, 7, 5, 4);
		waist.setRotationPoint(0F, 5F, -10F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.2617994F, 0F, 0F);
		skull1 = new ModelRenderer(this, 36, 56);
		skull1.addBox(-0.8F, -1.5F, -9.5F, 4, 4, 4);
		skull1.setRotationPoint(0F, 16F, -5F);
		skull1.setTextureSize(64, 32);
		setRotation(skull1, 0.1745329F, 0.7853982F, 0.1745329F);
		skull2 = new ModelRenderer(this, 36, 46);
		skull2.addBox(-2.5F, -1.8F, -13F, 5, 5, 5);
		skull2.setRotationPoint(0F, 16F, -1F);
		skull2.setTextureSize(64, 32);
		setRotation(skull2, 0.2443461F, 0F, 0F);
		skull3 = new ModelRenderer(this, 36, 56);
		skull3.addBox(-3.2F, -1.5F, -9.5F, 4, 4, 4);
		skull3.setRotationPoint(0F, 16F, -5F);
		skull3.setTextureSize(64, 32);
		setRotation(skull3, 0.1745329F, -0.7853982F, -0.1745329F);
		body1 = new ModelRenderer(this, 64, 0);
		body1.addBox(-3F, -4F, -8F, 6, 8, 8);
		body1.setRotationPoint(0F, 16F, -1F);
		body1.setTextureSize(64, 32);
		setRotation(body1, -0.4363323F, 0F, 0F);
		body2 = new ModelRenderer(this, 64, 16);
		body2.addBox(-3.5F, -3.5F, -6F, 7, 6, 8);
		body2.setRotationPoint(0F, 16F, 2F);
		body2.setTextureSize(64, 32);
		setRotation(body2, 0.2617994F, 0F, 0F);
		body3 = new ModelRenderer(this, 64, 30);
		body3.addBox(-2.5F, -6F, -2F, 5, 8, 8);
		body3.setRotationPoint(0F, 16F, -1F);
		body3.setTextureSize(64, 32);
		setRotation(body3, 0.2617994F, 0F, 0F);
		body4 = new ModelRenderer(this, 78, 34);
		body4.addBox(-5F, -4F, -6F, 10, 10, 12);
		body4.setRotationPoint(0F, 13F, 7F);
		body4.setTextureSize(64, 32);
		setRotation(body4, -0.4363323F, 0F, 0F);
		body5 = new ModelRenderer(this, 64, 56);
		body5.addBox(-2F, 5F, 5F, 4, 3, 3);
		body5.setRotationPoint(0F, 13F, 7F);
		body5.setTextureSize(64, 32);
		setRotation(body5, -0.4363323F, 0F, 0F);
		leg1 = new ModelRenderer(this, 92, 0);
		leg1.addBox(-15F, -1F, -1F, 16, 2, 2);
		leg1.setRotationPoint(-4F, 15F, 2F);
		leg1.setTextureSize(64, 32);
		setRotation(leg1, 0F, 0.5759587F, -0.4886922F);
		leg2 = new ModelRenderer(this, 92, 0);
		leg2.addBox(-1F, -1F, -1F, 16, 2, 2);
		leg2.setRotationPoint(4F, 15F, 2F);
		leg2.setTextureSize(64, 32);
		setRotation(leg2, 0F, -0.5759587F, 0.4886922F);
		leg3 = new ModelRenderer(this, 92, 0);
		leg3.addBox(-15F, -1F, -1F, 16, 2, 2);
		leg3.setRotationPoint(-4F, 15F, 1F);
		leg3.setTextureSize(64, 32);
		setRotation(leg3, 0F, 0.2792527F, -0.5585054F);
		leg4 = new ModelRenderer(this, 92, 0);
		leg4.addBox(-1F, -1F, -1F, 16, 2, 2);
		leg4.setRotationPoint(4F, 15F, 1F);
		leg4.setTextureSize(64, 32);
		setRotation(leg4, 0F, -0.2792527F, 0.5585054F);
		leg5 = new ModelRenderer(this, 92, 0);
		leg5.addBox(-15F, -1F, -1F, 16, 2, 2);
		leg5.setRotationPoint(-4F, 15F, 0F);
		leg5.setTextureSize(64, 32);
		leg5.mirror = true;
		setRotation(leg5, 0F, -0.2792527F, -0.5585054F);
		leg6 = new ModelRenderer(this, 92, 0);
		leg6.addBox(-1F, -1F, -1F, 16, 2, 2);
		leg6.setRotationPoint(4F, 15F, 0F);
		leg6.setTextureSize(64, 32);
		setRotation(leg6, 0F, 0.2792527F, 0.5585054F);
		leg7 = new ModelRenderer(this, 92, 0);
		leg7.addBox(-15F, -1F, -1F, 16, 2, 2);
		leg7.setRotationPoint(-4F, 15F, -1F);
		leg7.setTextureSize(64, 32);
		leg7.mirror = true;
		setRotation(leg7, 0F, -0.5759587F, -0.5585054F);
		leg8 = new ModelRenderer(this, 92, 0);
		leg8.addBox(-1F, -1F, -1F, 16, 2, 2);
		leg8.setRotationPoint(4F, 15F, -1F);
		leg8.setTextureSize(64, 32);
		setRotation(leg8, 0F, 0.5759587F, 0.5585054F);

		convertToChild(head, righteye);
		convertToChild(head, lefteye);
		convertToChild(head, hair);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(body4, body5);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymiddlebutton.render(scale);
		bodymiddle.render(scale);
		bodybottom.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		waist.render(scale);
		skull1.render(scale);
		skull2.render(scale);
		skull3.render(scale);
		body1.render(scale);
		body2.render(scale);
		body3.render(scale);
		body4.render(scale);
		leg1.render(scale);
		leg2.render(scale);
		leg3.render(scale);
		leg4.render(scale);
		leg5.render(scale);
		leg6.render(scale);
		leg7.render(scale);
		leg8.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
			Entity entityIn) {
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

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		rightarm.rotateAngleZ += 0.3490659F;
		leftarm.rotateAngleZ -= 0.3490659F;

		// body
		rightchest.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount + 0.8726646F;
		leftchest.rotateAngleX = rightchest.rotateAngleX;

		skull1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount + 0.1745329F;
		skull2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount + 0.2443461F;
		skull3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount + 0.1745329F;

		body4.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount);
		body5.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.05F * limbSwingAmount);

		body4.rotateAngleX -= 0.4363323F;

		// legs
		float f6 = 0.7853982F;
		leg1.rotateAngleZ = -f6;
		leg2.rotateAngleZ = f6;
		leg3.rotateAngleZ = -f6 * 0.74F;
		leg4.rotateAngleZ = f6 * 0.74F;
		leg5.rotateAngleZ = -f6 * 0.74F;
		leg6.rotateAngleZ = f6 * 0.74F;
		leg7.rotateAngleZ = -f6;
		leg8.rotateAngleZ = f6;
		float f7 = -0.0F;
		float f8 = 0.3926991F;
		leg1.rotateAngleY = f8 * 2.0F + f7;
		leg2.rotateAngleY = -f8 * 2.0F - f7;
		leg3.rotateAngleY = f8 * 1.0F + f7;
		leg4.rotateAngleY = -f8 * 1.0F - f7;
		leg5.rotateAngleY = -f8 * 1.0F + f7;
		leg6.rotateAngleY = f8 * 1.0F - f7;
		leg7.rotateAngleY = -f8 * 2.0F + f7;
		leg8.rotateAngleY = f8 * 2.0F - f7;
		float f9 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float f10 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f11 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 1.5707964F) * 0.4F) * limbSwingAmount;
		float f12 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 4.712389F) * 0.4F) * limbSwingAmount;
		float f13 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float f14 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f15 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 1.5707964F) * 0.4F) * limbSwingAmount;
		float f16 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 4.712389F) * 0.4F) * limbSwingAmount;
		leg1.rotateAngleY += f9;
		leg2.rotateAngleY += -f9;
		leg3.rotateAngleY += f10;
		leg4.rotateAngleY += -f10;
		leg5.rotateAngleY += f11;
		leg6.rotateAngleY += -f11;
		leg7.rotateAngleY += f12;
		leg8.rotateAngleY += -f12;
		leg1.rotateAngleZ += f13;
		leg2.rotateAngleZ += -f13;
		leg3.rotateAngleZ += f14;
		leg4.rotateAngleZ += -f14;
		leg5.rotateAngleZ += f15;
		leg6.rotateAngleZ += -f15;
		leg7.rotateAngleZ += f16;
		leg8.rotateAngleZ += -f16;
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

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
