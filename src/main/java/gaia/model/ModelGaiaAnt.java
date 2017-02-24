package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaAnt extends ModelGaia {
	//fields
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
	public static ModelRenderer rightarm;
	public static ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hairahoge;
    ModelRenderer headrighthair1;
    ModelRenderer headlefthair1;
    ModelRenderer headrighthair2;
    ModelRenderer headlefthair2;
    ModelRenderer headrighthair3;
    ModelRenderer headlefthair3;
	ModelRenderer rightarmhand;
	ModelRenderer leftarmhand;
	ModelRenderer rightarm2;
	ModelRenderer leftarm2;
	ModelRenderer rightarm2lower;
	ModelRenderer leftarm2lower;
	ModelRenderer thorax1;
	ModelRenderer thorax2;
	ModelRenderer thorax3;
	ModelRenderer rightlegknee;
	ModelRenderer leftlegknee;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer rightlegfoot;
	ModelRenderer leftlegfoot;

	public ModelGaiaAnt() {
		textureWidth = 128;
		textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, -2.5F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, -2.5F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, -2.466667F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, -2.5F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, -2.5F);
		this.bodytop.setTextureSize(64, 32);
		this.setRotation(bodytop, 0.1745329F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -2.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, -4F);
		this.bodymiddle.setTextureSize(64, 32);
		this.setRotation(bodymiddle, 0.6108652F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -2.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, -4F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.setRotation(bodymiddlebutton, 0.6108652F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 6.5F, -6F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, -4F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 1.047198F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -3.6F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.9599311F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -3.6F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.9599311F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, -2.5F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0.2617994F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.mirror = true;
		this.leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, -2.5F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, -0.2617994F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1F, -1F, -1F, 2, 7, 2);
		this.rightleg.setRotationPoint(-3F, 10F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, -0.2617994F, 0F, -0.1745329F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.mirror = true;
		this.leftleg.addBox(-1F, -1F, -1F, 2, 7, 2);
		this.leftleg.setRotationPoint(3F, 10F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, -0.2617994F, 0F, 0.1745329F);
		this.hairahoge = new ModelRenderer(this, 36, 14);
		this.hairahoge.addBox(0.7F, -10F, -4.7F, 4, 4, 4);
		this.hairahoge.setRotationPoint(0F, 1F, -2.5F);
		this.hairahoge.setTextureSize(64, 32);
		this.setRotation(hairahoge, 0F, 0.7853982F, 0F);
		this.headrighthair1 = new ModelRenderer(this, 36, 22);
		this.headrighthair1.addBox(-4F, -7F, 2F, 2, 2, 2);
		this.headrighthair1.setRotationPoint(0F, 1F, -2.5F);
		this.headrighthair1.setTextureSize(64, 32);
		this.setRotation(headrighthair1, 0F, 0F, 0F);
		this.headlefthair1 = new ModelRenderer(this, 36, 22);
		this.headlefthair1.mirror = true;
		this.headlefthair1.addBox(2F, -7F, 2F, 2, 2, 2);
		this.headlefthair1.setRotationPoint(0F, 1F, -2.466667F);
		this.headlefthair1.setTextureSize(64, 32);
		this.setRotation(headlefthair1, 0F, 0F, 0F);
		this.headrighthair2 = new ModelRenderer(this, 36, 26);
		this.headrighthair2.addBox(-5F, -6F, 3F, 2, 4, 2);
		this.headrighthair2.setRotationPoint(0F, 1F, -2.5F);
		this.headrighthair2.setTextureSize(64, 32);
		this.setRotation(headrighthair2, 0F, 0F, 0F);
		this.headlefthair2 = new ModelRenderer(this, 36, 26);
		this.headlefthair2.mirror = true;
		this.headlefthair2.addBox(3F, -6F, 3F, 2, 4, 2);
		this.headlefthair2.setRotationPoint(0F, 1F, -2.466667F);
		this.headlefthair2.setTextureSize(64, 32);
		this.setRotation(headlefthair2, 0F, 0F, 0F);
		this.headrighthair3 = new ModelRenderer(this, 36, 32);
		this.headrighthair3.addBox(-4F, -3F, 2F, 2, 2, 2);
		this.headrighthair3.setRotationPoint(0F, 1F, -2.5F);
		this.headrighthair3.setTextureSize(64, 32);
		this.setRotation(headrighthair3, 0F, 0F, 0F);
		this.headlefthair3 = new ModelRenderer(this, 36, 32);
		this.headlefthair3.mirror = true;
		this.headlefthair3.addBox(2F, -3F, 2F, 2, 2, 2);
		this.headlefthair3.setRotationPoint(0F, 1F, -2.466667F);
		this.headlefthair3.setTextureSize(64, 32);
		this.setRotation(headlefthair3, 0F, 0F, 0F);
		this.rightarmhand = new ModelRenderer(this, 64, 0);
		this.rightarmhand.addBox(-1F, 8F, -2F, 2, 2, 2);
		this.rightarmhand.setRotationPoint(-2.5F, 2.5F, -2.5F);
		this.rightarmhand.setTextureSize(64, 32);
		this.setRotation(rightarmhand, 0F, 0F, 0.2617994F);
		this.leftarmhand = new ModelRenderer(this, 64, 0);
		this.leftarmhand.mirror = true;
		this.leftarmhand.addBox(-1F, 8F, -2F, 2, 2, 2);
		this.leftarmhand.setRotationPoint(2.5F, 2.5F, -2.5F);
		this.leftarmhand.setTextureSize(64, 32);
		this.setRotation(leftarmhand, 0F, 0F, -0.2617994F);
		this.rightarm2 = new ModelRenderer(this, 64, 4);
		this.rightarm2.addBox(-0.5F, -1F, -0.5F, 1, 3, 1);
		this.rightarm2.setRotationPoint(-2.5F, 6F, -2F);
		this.rightarm2.setTextureSize(64, 32);
		this.setRotation(rightarm2, 0.1745329F, -0.2617994F, 0.2617994F);
		this.leftarm2 = new ModelRenderer(this, 64, 4);
		this.leftarm2.mirror = true;
		this.leftarm2.addBox(-0.5F, -1F, -0.5F, 1, 3, 1);
		this.leftarm2.setRotationPoint(2.5F, 6F, -2F);
		this.leftarm2.setTextureSize(64, 32);
		this.setRotation(leftarm2, 0.1745329F, 0.2617994F, -0.2617994F);
		this.rightarm2lower = new ModelRenderer(this, 64, 8);
		this.rightarm2lower.addBox(-0.5F, 0F, 1.5F, 1, 3, 1);
		this.rightarm2lower.setRotationPoint(-2.5F, 6F, -2F);
		this.rightarm2lower.setTextureSize(64, 32);
		this.setRotation(rightarm2lower, -1.396263F, -0.2617994F, 0.2617994F);
		this.leftarm2lower = new ModelRenderer(this, 64, 8);
		this.leftarm2lower.mirror = true;
		this.leftarm2lower.addBox(-0.5F, 0F, 1.5F, 1, 3, 1);
		this.leftarm2lower.setRotationPoint(2.5F, 6F, -2F);
		this.leftarm2lower.setTextureSize(64, 32);
		this.setRotation(leftarm2lower, -1.396263F, 0.2617994F, -0.2617994F);
		this.thorax1 = new ModelRenderer(this, 64, 12);
		this.thorax1.addBox(-1.5F, 8.5F, -5F, 3, 1, 3);
		this.thorax1.setRotationPoint(0F, 1F, -4F);
		this.thorax1.setTextureSize(64, 32);
		this.setRotation(thorax1, 1.047198F, 0F, 0F);
		this.thorax2 = new ModelRenderer(this, 64, 16);
		this.thorax2.addBox(-2F, 9.5F, -5.5F, 4, 5, 4);
		this.thorax2.setRotationPoint(0F, 1F, -4F);
		this.thorax2.setTextureSize(64, 32);
		this.setRotation(thorax2, 1.047198F, 0F, 0F);
		this.thorax3 = new ModelRenderer(this, 64, 25);
		this.thorax3.addBox(-1F, 13.5F, -6.5F, 2, 2, 2);
		this.thorax3.setRotationPoint(0F, 1F, -4F);
		this.thorax3.setTextureSize(64, 32);
		this.setRotation(thorax3, 1.047198F, 0F, 0F);
		this.rightlegknee = new ModelRenderer(this, 80, 0);
		this.rightlegknee.addBox(-0.5F, 0F, -7F, 2, 3, 2);
		this.rightlegknee.setRotationPoint(-3F, 10F, 0F);
		this.rightlegknee.setTextureSize(64, 32);
		this.setRotation(rightlegknee, 1.308997F, 0F, -0.0872665F);
		this.leftlegknee = new ModelRenderer(this, 80, 0);
		this.leftlegknee.mirror = true;
		this.leftlegknee.addBox(-1.5F, 0F, -7F, 2, 3, 2);
		this.leftlegknee.setRotationPoint(3F, 10F, 0F);
		this.leftlegknee.setTextureSize(64, 32);
		this.setRotation(leftlegknee, 1.308997F, 0F, 0.0872665F);
		this.rightleglower = new ModelRenderer(this, 80, 5);
		this.rightleglower.addBox(1F, 5.5F, 2F, 2, 7, 2);
		this.rightleglower.setRotationPoint(-3F, 10F, 0F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(rightleglower, -0.2617994F, 0F, 0.1745329F);
		this.leftleglower = new ModelRenderer(this, 80, 5);
		this.leftleglower.mirror = true;
		this.leftleglower.addBox(-3F, 5.5F, 2F, 2, 7, 2);
		this.leftleglower.setRotationPoint(3F, 10F, 0F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(leftleglower, -0.2617994F, 0F, -0.1745329F);
		this.rightlegfoot = new ModelRenderer(this, 80, 14);
		this.rightlegfoot.addBox(-0.5F, 12F, -2F, 2, 2, 2);
		this.rightlegfoot.setRotationPoint(-3F, 10F, 0F);
		this.rightlegfoot.setTextureSize(64, 32);
		this.setRotation(rightlegfoot, 0F, 0F, 0F);
		this.leftlegfoot = new ModelRenderer(this, 80, 14);
		this.leftlegfoot.mirror = true;
		this.leftlegfoot.addBox(-1.5F, 12F, -2F, 2, 2, 2);
		this.leftlegfoot.setRotationPoint(3F, 10F, 0F);
		this.leftlegfoot.setTextureSize(64, 32);
		this.setRotation(leftlegfoot, 0F, 0F, 0F);


		this.convertToChild(head, hairahoge);
		this.convertToChild(head, headrighthair1);
		this.convertToChild(head, headlefthair1);
		this.convertToChild(head, headrighthair2);
		this.convertToChild(head, headlefthair2);
		this.convertToChild(head, headrighthair3);
		this.convertToChild(head, headlefthair3);
		this.convertToChild(rightarm, rightarmhand);
		this.convertToChild(leftarm, leftarmhand);
		this.convertToChild(rightarm2, rightarm2lower);
		this.convertToChild(leftarm2, leftarm2lower);
		this.convertToChild(thorax1, thorax2);
		this.convertToChild(thorax1, thorax3);
		this.convertToChild(rightleg, rightlegknee);
		this.convertToChild(rightleg, rightleglower);
		this.convertToChild(rightleg, rightlegfoot);
		this.convertToChild(leftleg, leftlegknee);
		this.convertToChild(leftleg, leftleglower);
		this.convertToChild(leftleg, leftlegfoot);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
		this.headeyes.render(scale);
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
//		this.hairahoge.render(scale);
//		this.headrighthair1.render(scale);
//		this.headlefthair1.render(scale);
//		this.headrighthair2.render(scale);
//		this.headlefthair2.render(scale);
//		this.headrighthair3.render(scale);
//		this.headlefthair3.render(scale);
//		this.rightarmhand.render(scale);
//		this.leftarmhand.render(scale);
		this.rightarm2.render(scale);
//		this.rightarm2lower.render(scale);
		this.leftarm2.render(scale);
//		this.leftarm2lower.render(scale);
		this.thorax1.render(scale);
//		this.thorax2.render(scale);
//		this.thorax3.render(scale);
//		this.rightlegknee.render(scale);
//		this.leftlegknee.render(scale);
//		this.rightleglower.render(scale);
//		this.leftleglower.render(scale);
//		this.rightlegfoot.render(scale);
//		this.leftlegfoot.render(scale);
		
		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			this.headeyes.render(scale);
		}
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;

        if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        
        //body
		this.thorax1.rotateAngleX = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(2);
		this.thorax1.rotateAngleX +=  1.047198F;
				
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;
		
		this.rightleg.rotateAngleX -= 0.1745329F;
		this.leftleg.rotateAngleX -= 0.1745329F;
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
        
        this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
        this.rightarm.rotateAngleX += (this.bodytop.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
	}
}
