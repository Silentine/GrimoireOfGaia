package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaBeholder extends ModelGaia {

	ModelRenderer headtopmid;
	ModelRenderer headtop01;
	ModelRenderer headtop02;
	ModelRenderer headbottommid;
	ModelRenderer headbottom01;
	ModelRenderer headbottom02;
	ModelRenderer headfangright;
	ModelRenderer headfangleft;
	ModelRenderer eye01a;
	ModelRenderer eye01b;
	ModelRenderer eye02a;
	ModelRenderer eye02b;
	ModelRenderer eye03a;
	ModelRenderer eye03b;
	ModelRenderer eye04a;
	ModelRenderer eye04b;
	ModelRenderer eye05a;
	ModelRenderer eye05b;
	ModelRenderer eye06a;
	ModelRenderer eye06b;
	ModelRenderer eye07a;
	ModelRenderer eye07b;
	ModelRenderer eye08a;
	ModelRenderer eye08b;
	ModelRenderer eye09a;
	ModelRenderer eye09b;
	ModelRenderer teethtop;
	ModelRenderer teethbottom;
	ModelRenderer mouthback;

	public ModelGaiaBeholder(float scaleFactor) {
		textureWidth = 256;
		textureHeight = 128;

		headtopmid = new ModelRenderer(this, 0, 0);
		headtopmid.addBox(-8F, -10F, -8F, 16, 12, 16, scaleFactor);
		headtopmid.setRotationPoint(0F, 0F, 0F);
		setRotation(headtopmid, 0F, 0F, 0F);
		headtop01 = new ModelRenderer(this, 0, 28);
		headtop01.addBox(-8F, -8F, -10F, 16, 10, 20, scaleFactor);
		headtop01.setRotationPoint(0F, 0F, 0F);
		setRotation(headtop01, 0F, 0F, 0F);
		headtop02 = new ModelRenderer(this, 0, 58);
		headtop02.addBox(-10F, -8F, -8F, 20, 10, 16, scaleFactor);
		headtop02.setRotationPoint(0F, 0F, 0F);
		setRotation(headtop02, 0F, 0F, 0F);
		headbottommid = new ModelRenderer(this, 72, 0);
		headbottommid.addBox(-6F, 0F, -12F, 12, 6, 12, scaleFactor);
		headbottommid.setRotationPoint(0F, 2F, 6F);
		setRotation(headbottommid, 0.5235988F, 0F, 0F);
		headbottom01 = new ModelRenderer(this, 72, 18);
		headbottom01.addBox(-6F, 0F, -14F, 12, 4, 16, scaleFactor);
		headbottom01.setRotationPoint(0F, 2F, 6F);
		setRotation(headbottom01, 0.5235988F, 0F, 0F);
		headbottom02 = new ModelRenderer(this, 72, 38);
		headbottom02.addBox(-8F, 0F, -12F, 16, 4, 12, scaleFactor);
		headbottom02.setRotationPoint(0F, 2F, 6F);
		setRotation(headbottom02, 0.5235988F, 0F, 0F);
		headfangright = new ModelRenderer(this, 0, 92);
		headfangright.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		headfangright.setRotationPoint(-5F, 2F, -9F);
		setRotation(headfangright, 0F, 0.7853982F, 0F);
		headfangleft = new ModelRenderer(this, 0, 84);
		headfangleft.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		headfangleft.setRotationPoint(5F, 2F, -9F);
		setRotation(headfangleft, 0F, 0.7853982F, 0F);
		eye01a = new ModelRenderer(this, 176, 0);
		eye01a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye01a.setRotationPoint(0F, -12F, -1F);
		setRotation(eye01a, 0F, 0F, 0F);
		eye01b = new ModelRenderer(this, 192, 0);
		eye01b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye01b.setRotationPoint(0F, -15F, -1F);
		setRotation(eye01b, 0F, 0F, 0F);
		eye02a = new ModelRenderer(this, 176, 0);
		eye02a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye02a.setRotationPoint(-4F, -11F, 5F);
		setRotation(eye02a, 0F, 0F, 0F);
		eye02b = new ModelRenderer(this, 192, 0);
		eye02b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye02b.setRotationPoint(-7F, -14F, 5F);
		setRotation(eye02b, 0F, 0F, 0F);
		eye03a = new ModelRenderer(this, 176, 0);
		eye03a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye03a.setRotationPoint(-10F, -7F, 1F);
		setRotation(eye03a, 0F, 0F, 0F);
		eye03b = new ModelRenderer(this, 192, 0);
		eye03b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye03b.setRotationPoint(-13F, -10F, 1F);
		setRotation(eye03b, 0F, 0F, 0F);
		eye04a = new ModelRenderer(this, 176, 0);
		eye04a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye04a.setRotationPoint(-12F, -2.5F, 3F);
		setRotation(eye04a, 0F, 0F, 0F);
		eye04b = new ModelRenderer(this, 192, 0);
		eye04b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye04b.setRotationPoint(-15F, -2.5F, 3F);
		setRotation(eye04b, 0F, 0F, 0F);
		eye05a = new ModelRenderer(this, 176, 0);
		eye05a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye05a.setRotationPoint(-10F, 2F, -1F);
		setRotation(eye05a, 0F, 0F, 0F);
		eye05b = new ModelRenderer(this, 192, 12);
		eye05b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye05b.setRotationPoint(-13F, 5F, -1F);
		setRotation(eye05b, 0F, 0F, 0F);
		eye06a = new ModelRenderer(this, 176, 0);
		eye06a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye06a.setRotationPoint(10F, 2F, -1F);
		setRotation(eye06a, 0F, 0F, 0F);
		eye06b = new ModelRenderer(this, 192, 12);
		eye06b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye06b.setRotationPoint(13F, 5F, -1F);
		setRotation(eye06b, 0F, 0F, 0F);
		eye07a = new ModelRenderer(this, 176, 0);
		eye07a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye07a.setRotationPoint(12F, -2.5F, 3F);
		setRotation(eye07a, 0F, 0F, 0F);
		eye07b = new ModelRenderer(this, 192, 0);
		eye07b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye07b.setRotationPoint(15F, -2.5F, 3F);
		setRotation(eye07b, 0F, 0F, 0F);
		eye08a = new ModelRenderer(this, 176, 0);
		eye08a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye08a.setRotationPoint(10F, -7F, 1F);
		setRotation(eye08a, 0F, 0F, 0F);
		eye08b = new ModelRenderer(this, 192, 0);
		eye08b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye08b.setRotationPoint(13F, -10F, 1F);
		setRotation(eye08b, 0F, 0F, 0F);
		eye09a = new ModelRenderer(this, 176, 0);
		eye09a.addBox(-2F, -2F, -2F, 4, 4, 4, scaleFactor);
		eye09a.setRotationPoint(4F, -11F, 5F);
		setRotation(eye09a, 0F, 0F, 0F);
		eye09b = new ModelRenderer(this, 192, 0);
		eye09b.addBox(-3F, -3F, -6F, 6, 6, 6, scaleFactor);
		eye09b.setRotationPoint(7F, -14F, 5F);
		setRotation(eye09b, 0F, 0F, 0F);
		teethtop = new ModelRenderer(this, 128, 12);
		teethtop.addBox(-6F, 2F, -6F, 12, 4, 12, scaleFactor);
		teethtop.setRotationPoint(0F, 0F, 0F);
		setRotation(teethtop, 0F, 0F, 0F);
		teethbottom = new ModelRenderer(this, 128, 28);
		teethbottom.addBox(-6F, -4F, -12F, 12, 4, 12, scaleFactor);
		teethbottom.setRotationPoint(0F, 2F, 6F);
		setRotation(teethbottom, 0.5235988F, 0F, 0F);
		mouthback = new ModelRenderer(this, 128, 0);
		mouthback.addBox(-7F, -6F, -6F, 14, 6, 6, scaleFactor);
		mouthback.setRotationPoint(0F, 2F, 6F);
		setRotation(mouthback, 0.5235988F, 0F, 0F);

		// joints
		// head
		convertToChild(headtopmid, headtop01);
		convertToChild(headtopmid, headtop02);
		// eyes
		convertToChild(eye01a, eye01b);
		convertToChild(eye02a, eye02b);
		convertToChild(eye03a, eye03b);
		convertToChild(eye04a, eye04b);
		convertToChild(eye05a, eye05b);
		convertToChild(eye06a, eye06b);
		convertToChild(eye07a, eye07b);
		convertToChild(eye08a, eye08b);
		convertToChild(eye09a, eye09b);
		convertToChild(headtopmid, eye01a);
		convertToChild(headtopmid, eye02a);
		convertToChild(headtopmid, eye03a);
		convertToChild(headtopmid, eye04a);
		convertToChild(headtopmid, eye05a);
		convertToChild(headtopmid, eye06a);
		convertToChild(headtopmid, eye07a);
		convertToChild(headtopmid, eye08a);
		convertToChild(headtopmid, eye09a);
		// jaw
		convertToChild(headtopmid, headfangright);
		convertToChild(headtopmid, headfangleft);
		convertToChild(headtopmid, teethtop);
		convertToChild(headbottommid, headbottom01);
		convertToChild(headbottommid, headbottom02);
		convertToChild(headbottommid, teethbottom);
		convertToChild(headbottommid, mouthback);
		// everything
		convertToChild(headtopmid, headbottommid);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		headtopmid.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float floatSpeed = 0.25F;
		float floatRange = 3.0F;

		// anchor
		headtopmid.rotationPointY = -2.0F + MathHelper.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;

		// head
		headtopmid.rotateAngleY = netHeadYaw / 57.295776F;
		headtopmid.rotateAngleX = headPitch / 57.295776F;

		float angleRange = 0.15F;
		float angleRange2 = 0.25F;

		eye01b.rotateAngleX = MathHelper.cos(ageInTicks * floatSpeed) * angleRange * 0.5F;
		eye02b.rotateAngleX = eye01b.rotateAngleX;
		eye03b.rotateAngleX = eye01b.rotateAngleX;
		eye04b.rotateAngleX = MathHelper.cos(ageInTicks * floatSpeed) * angleRange2 * 0.5F;
		eye05b.rotateAngleX = eye04b.rotateAngleX;
		eye06b.rotateAngleX = eye04b.rotateAngleX;
		eye07b.rotateAngleX = eye04b.rotateAngleX;
		eye08b.rotateAngleX = eye01b.rotateAngleX;
		eye09b.rotateAngleX = eye01b.rotateAngleX;

		headbottommid.rotateAngleX = MathHelper.cos(ageInTicks * floatSpeed) * angleRange2 * 0.5F;
		headbottommid.rotateAngleX += 0.5235988F;
	}
}
