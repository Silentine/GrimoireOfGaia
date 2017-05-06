package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaHarpy extends ModelGaia {
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
	ModelRenderer hair;
    ModelRenderer hairahoge;
	ModelRenderer rightfeather;
	ModelRenderer leftfeather;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer rightwing;
	ModelRenderer leftwing;
	ModelRenderer rightwinglower;
	ModelRenderer leftwinglower;
	ModelRenderer tail;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer righttalonupper;
	ModelRenderer lefttalonupper;
	ModelRenderer righttalon;
	ModelRenderer lefttalon;
	ModelRenderer righttalonlower;
	ModelRenderer lefttalonlower;

	//x and y coordinate of hairahoge must be manually adjusted by a 0.5 difference
	public ModelGaiaHarpy() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 2F, -4F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0.0872665F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, -2F);
		this.headeyes.setTextureSize(128, 64);
		this.setRotation(headeyes, 0.0872665F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 2F, -4F);
		this.headaccessory.setTextureSize(128, 64);
		this.setRotation(headaccessory, 0.0872665F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 2F, -4F);
		this.neck.setTextureSize(128, 64);
		this.setRotation(neck, 0.0872665F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 2F, -4F);
		this.bodytop.setTextureSize(128, 64);
		this.setRotation(bodytop, 0.1745329F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5F, -3.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 2F, -4F);
		this.bodymiddle.setTextureSize(128, 64);
		this.setRotation(bodymiddle, 0.6108652F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 5.5F, -3.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 2F, -4F);
		this.bodymiddlebutton.setTextureSize(128, 64);
		this.setRotation(bodymiddlebutton, 0.6108652F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 6F, -7F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 2F, -4F);
		this.bodybottom.setTextureSize(128, 64);
		this.setRotation(bodybottom, 1.047198F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 4F, -5F);
		this.rightchest.setTextureSize(128, 64);
		this.setRotation(rightchest, 0.9599311F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 4F, -5F);
		this.leftchest.setTextureSize(128, 64);
		this.setRotation(leftchest, 0.9599311F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		this.rightarm.setRotationPoint(-2.5F, 3.5F, -3.5F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, 0.6108652F, -0.1745329F, 0.3490659F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		this.leftarm.setRotationPoint(2.5F, 3.5F, -3.5F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, 0.6108652F, 0.1745329F, -0.3490659F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-2F, -1F, -1.5F, 3, 6, 3);
		this.rightleg.setRotationPoint(-2F, 10.5F, 0.8F);
		this.rightleg.setTextureSize(128, 64);
		this.setRotation(rightleg, -0.5235988F, -0.0872665F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1F, -1F, -1.5F, 3, 6, 3);
		this.leftleg.setRotationPoint(2F, 10.5F, 0.8F);
		this.leftleg.setTextureSize(128, 64);
		this.setRotation(leftleg, -0.5235988F, 0.0872665F, 0F);
		this.hair = new ModelRenderer(this, 36, 14);
		this.hair.addBox(-2.5F, -8F, 2F, 5, 5, 5);
		this.hair.setRotationPoint(0F, 2F, -4F);
		this.hair.setTextureSize(128, 64);
		this.setRotation(hair, 0.0872665F, 0F, 0F);
		this.hairahoge = new ModelRenderer(this, 36, 24);
		this.hairahoge.addBox(-1.3F, -9F, -1.8F, 4, 4, 4);
		this.hairahoge.setRotationPoint(0F, 1F, -4F);
		this.hairahoge.setTextureSize(128, 64);
		this.setRotation(hairahoge, 0F, -0.7853982F, 0F);
		this.rightfeather = new ModelRenderer(this, 36, 32);
		this.rightfeather.addBox(-4.5F, -5F, 0F, 1, 6, 8);
		this.rightfeather.setRotationPoint(0F, 2F, -4F);
		this.rightfeather.setTextureSize(128, 64);
		this.setRotation(rightfeather, 0.3490659F, -0.2617994F, 0F);
		this.leftfeather = new ModelRenderer(this, 36, 32);
		this.leftfeather.mirror = true;
		this.leftfeather.addBox(3.5F, -5F, 0F, 1, 6, 8);
		this.leftfeather.setRotationPoint(0F, 2F, -4F);
		this.leftfeather.setTextureSize(128, 64);
		this.setRotation(leftfeather, 0.3490659F, 0.2617994F, 0F);
		this.rightarmlower = new ModelRenderer(this, 16, 20);
		this.rightarmlower.addBox(-2F, 0F, 4F, 2, 6, 2);
		this.rightarmlower.setRotationPoint(-2.5F, 3.5F, -3.5F);
		this.rightarmlower.setTextureSize(128, 64);
		this.setRotation(rightarmlower, -0.9599311F, -0.1745329F, 0.3490659F);
		this.leftarmlower = new ModelRenderer(this, 16, 20);
		this.leftarmlower.addBox(0F, 0F, 4F, 2, 6, 2);
		this.leftarmlower.setRotationPoint(2.5F, 3.5F, -3.5F);
		this.leftarmlower.setTextureSize(128, 64);
		this.setRotation(leftarmlower, -0.9599311F, 0.1745329F, -0.3490659F);
		this.rightwing = new ModelRenderer(this, 64, 16);
		this.rightwing.addBox(-1.5F, 4.5F, -5F, 1, 8, 12);
		this.rightwing.setRotationPoint(-2.5F, 3.5F, -3.5F);
		this.rightwing.setTextureSize(128, 64);
		this.setRotation(rightwing, 0.6108652F, -0.1745329F, 0.3490659F);
		this.leftwing = new ModelRenderer(this, 64, 16);
		this.leftwing.mirror = true;
		this.leftwing.addBox(0.5F, 5F, -5F, 1, 8, 12);
		this.leftwing.setRotationPoint(2.5F, 3.5F, -3.5F);
		this.leftwing.setTextureSize(128, 64);
		this.setRotation(leftwing, 0.6108652F, 0.1745329F, -0.3490659F);
		this.rightwinglower = new ModelRenderer(this, 64, 0);
		this.rightwinglower.addBox(-1F, 7F, -2F, 1, 6, 10);
		this.rightwinglower.setRotationPoint(-2.5F, 3.5F, -3.5F);
		this.rightwinglower.setTextureSize(128, 64);
		this.setRotation(rightwinglower, -0.0872665F, -0.1745329F, 0.3490659F);
		this.leftwinglower = new ModelRenderer(this, 64, 0);
		this.leftwinglower.mirror = true;
		this.leftwinglower.addBox(0F, 7F, -2F, 1, 6, 10);
		this.leftwinglower.setRotationPoint(2.5F, 3.5F, -3.5F);
		this.leftwinglower.setTextureSize(128, 64);
		this.setRotation(leftwinglower, -0.0872665F, 0.1745329F, -0.3490659F);
		this.tail = new ModelRenderer(this, 90, 0);
		this.tail.addBox(-1.5F, 7F, -4F, 3, 10, 1);
		this.tail.setRotationPoint(0F, 2F, -4F);
		this.tail.setTextureSize(128, 64);
		this.setRotation(tail, 1.047198F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 90, 11);
		this.rightleglower.addBox(-1.5F, 4F, 2F, 2, 2, 4);
		this.rightleglower.setRotationPoint(-2F, 10.5F, 0.8F);
		this.rightleglower.setTextureSize(128, 64);
		this.setRotation(rightleglower, -1.047198F, -0.0872665F, 0F);
		this.leftleglower = new ModelRenderer(this, 90, 11);
		this.leftleglower.addBox(-0.5F, 4F, 2F, 2, 2, 4);
		this.leftleglower.setRotationPoint(2F, 10.5F, 0.8F);
		this.leftleglower.setTextureSize(128, 64);
		this.setRotation(leftleglower, -1.047198F, 0.0872665F, 0F);
		this.righttalonupper = new ModelRenderer(this, 90, 17);
		this.righttalonupper.addBox(-1F, 3F, -5.5F, 1, 6, 1);
		this.righttalonupper.setRotationPoint(-2F, 10.5F, 0.8F);
		this.righttalonupper.setTextureSize(128, 64);
		this.setRotation(righttalonupper, 0.5235988F, -0.0872665F, 0F);
		this.lefttalonupper = new ModelRenderer(this, 90, 17);
		this.lefttalonupper.addBox(0F, 3F, -5.5F, 1, 6, 1);
		this.lefttalonupper.setRotationPoint(2F, 10.5F, 0.8F);
		this.lefttalonupper.setTextureSize(128, 64);
		this.setRotation(lefttalonupper, 0.5235988F, 0.0872665F, 0F);
		this.righttalon = new ModelRenderer(this, 90, 24);
		this.righttalon.addBox(-1.5F, 5F, -12F, 2, 1, 4);
		this.righttalon.setRotationPoint(-2F, 10.5F, 0.8F);
		this.righttalon.setTextureSize(128, 64);
		this.setRotation(righttalon, 1.047198F, -0.0872665F, 0F);
		this.lefttalon = new ModelRenderer(this, 90, 24);
		this.lefttalon.addBox(-0.5F, 5F, -12F, 2, 1, 4);
		this.lefttalon.setRotationPoint(2F, 10.5F, 0.8F);
		this.lefttalon.setTextureSize(128, 64);
		this.setRotation(lefttalon, 1.047198F, 0.0872665F, 0F);
		this.righttalonlower = new ModelRenderer(this, 90, 29);
		this.righttalonlower.addBox(-2F, 13F, -4F, 3, 1, 5);
		this.righttalonlower.setRotationPoint(-2F, 10.5F, 0.8F);
		this.righttalonlower.setTextureSize(128, 64);
		this.setRotation(righttalonlower, 0F, -0.0872665F, 0F);
		this.lefttalonlower = new ModelRenderer(this, 90, 29);
		this.lefttalonlower.addBox(-1F, 13F, -4F, 3, 1, 5);
		this.lefttalonlower.setRotationPoint(2F, 10.5F, 0.8F);
		this.lefttalonlower.setTextureSize(128, 64);
		this.setRotation(lefttalonlower, 0F, 0.0872665F, 0F);
		
		this.convertToChild(head, hair);
		this.convertToChild(head, hairahoge);
		this.convertToChild(head, rightfeather);
		this.convertToChild(head, leftfeather);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(rightarm, rightwing);
		this.convertToChild(rightarm, rightwinglower);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(leftarm, leftwing);
		this.convertToChild(leftarm, leftwinglower);
		this.convertToChild(rightleg, rightleglower);
		this.convertToChild(rightleg, righttalonupper);
		this.convertToChild(rightleg, righttalon);
		this.convertToChild(rightleg, righttalonlower);
		this.convertToChild(leftleg, leftleglower);
		this.convertToChild(leftleg, lefttalonupper);
		this.convertToChild(leftleg, lefttalon);
		this.convertToChild(leftleg, lefttalonlower);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
		this.headaccessory.render(scale);
		this.neck.render(scale);
		this.bodytop.render(scale);
		this.bodymiddle.render(scale);
		this.bodymiddlebutton.render(scale);
		this.bodybottom.render(scale);
		this.rightchest.render(scale);
		this.leftchest.render(scale);
		this.rightarm.render(scale);
		this.leftarm.render(scale);
		this.rightleg.render(scale);
		this.leftleg.render(scale);
//		this.hair.render(scale);
//		this.hairahoge.render(scale);
//		this.rightfeather.render(scale);
//		this.leftfeather.render(scale);
//		this.rightarmlower.render(scale);
//		this.leftarmlower.render(scale);
//		this.rightwing.render(scale);
//		this.leftwing.render(scale);
//		this.rightwinglower.render(scale);
//		this.leftwinglower.render(scale);
		this.tail.render(scale);
//		this.rightleglower.render(scale);
//		this.leftleglower.render(scale);
//		this.righttalonupper.render(scale);
//		this.lefttalonupper.render(scale);
//		this.righttalon.render(scale);
//		this.lefttalon.render(scale);
//		this.righttalonlower.render(scale);
//		this.lefttalonlower.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			this.headeyes.render(scale);
		}
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = (headPitch / 57.295776F) + 0.0872665F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		
		//arms
		this.rightarm.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount * 0.5F - 0.1745329F;
		this.leftarm.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F + 0.1745329F;
		
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F + 0.6108652F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F + 0.6108652F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.3490659F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.3490659F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		//body
		this.tail.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(5);
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount;
		this.rightleg.rotateAngleX -= 0.5235988F;
		this.leftleg.rotateAngleX -= 0.5235988F;
	}
	
	public void holdingMelee(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float f6;
		float f7;
		
		f6 = this.swingProgress;
        f6 = 1.0F - this.swingProgress;
        f6 *= f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        f7 = MathHelper.sin(f6 * (float)Math.PI);
        float f8 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
        
        //right arm
        this.rightarm.rotateAngleX -= (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
        this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        
        //left arm
        this.leftarm.rotateAngleX -= (float)((double)this.leftarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
        this.leftarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
        this.leftarm.rotateAngleZ -= (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
	}
}
