package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaEnderDragonGirl extends ModelGaia {
    ModelRenderer head;
    ModelRenderer headeyes;
    ModelRenderer headaccessory;
    ModelRenderer neck;
    ModelRenderer bodytop;
    ModelRenderer bodymiddle;
    ModelRenderer bodymiddlebutton;
    ModelRenderer bodybottom;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightchest;
    ModelRenderer leftchest;
    ModelRenderer righthorn;
    ModelRenderer lefthorn;
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer rightarmlower;
    ModelRenderer leftarmlower;
    ModelRenderer rightclaw;
    ModelRenderer leftclaw;
    ModelRenderer waist;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer rightleg1;
    ModelRenderer leftleg1;
    ModelRenderer rightleg2;
    ModelRenderer leftleg2;
    ModelRenderer rightleg3;
    ModelRenderer leftleg3;
    ModelRenderer rightleg4;
    ModelRenderer leftleg4;
    ModelRenderer rightleg5;
    ModelRenderer leftleg5;
    ModelRenderer rightwing;
    ModelRenderer leftwing;
    
	public boolean isCarrying;
	public boolean isAttacking;

	public ModelGaiaEnderDragonGirl() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.isCarrying = false;
		this.isAttacking = false;
		float f = -14.0F;
		float f1 = 0.0F;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, -4F, -2F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, -4F, -2F);
		this.headeyes.setTextureSize(128, 64);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -7F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, -4F, -2F);
		this.headaccessory.setTextureSize(128, 64);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, -4F, -2F);
		this.neck.setTextureSize(128, 64);
		this.setRotation(neck, 0.1745329F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, -4F, -2F);
		this.bodytop.setTextureSize(128, 64);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, -4F, -2F);
		this.bodymiddle.setTextureSize(128, 64);
		this.setRotation(bodymiddle, 0.0872665F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, -4F, -2F);
		this.bodymiddlebutton.setTextureSize(128, 64);
		this.setRotation(bodymiddlebutton, 0.0872665F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, -4F, -2F);
		this.bodybottom.setTextureSize(128, 64);
		this.setRotation(bodybottom, 0.1745329F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		this.rightarm.setRotationPoint(-2.5F, -2.5F, -1.5F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, -0.2617994F, 0F, 0.4363323F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		this.leftarm.setRotationPoint(2.5F, -2.5F, -1.5F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, -0.2617994F, 0F, -0.4363323F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, -2F, -3F);
		this.rightchest.setTextureSize(128, 64);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, -2F, -3F);
		this.leftchest.setTextureSize(128, 64);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.righthorn = new ModelRenderer(this, 36, 14);
		this.righthorn.addBox(-4F, -7.5F, 0.5F, 2, 2, 7);
		this.righthorn.setRotationPoint(0F, -4F, -2F);
		this.righthorn.setTextureSize(128, 64);
		this.setRotation(righthorn, 0.3490659F, 0F, 0F);
		this.lefthorn = new ModelRenderer(this, 36, 14);
		this.lefthorn.addBox(2F, -7.5F, 0.5F, 2, 2, 7);
		this.lefthorn.setRotationPoint(0F, -4F, -2F);
		this.lefthorn.setTextureSize(128, 64);
		this.setRotation(lefthorn, 0.3490659F, 0F, 0F);
		this.rightear = new ModelRenderer(this, 36, 19);
		this.rightear.addBox(-4F, -4F, -1F, 0, 2, 4);
		this.rightear.setRotationPoint(0F, -4F, -2F);
		this.rightear.setTextureSize(128, 64);
		this.setRotation(rightear, 0F, -0.5235988F, 0F);
		this.leftear = new ModelRenderer(this, 36, 19);
		this.leftear.mirror = true;
		this.leftear.addBox(4F, -4F, -1F, 0, 2, 4);
		this.leftear.setRotationPoint(0F, -4F, -2F);
		this.leftear.setTextureSize(128, 64);
		this.setRotation(leftear, 0F, 0.5235988F, 0F);
		this.rightarmlower = new ModelRenderer(this, 16, 20);
		this.rightarmlower.addBox(-2F, 5F, 0F, 2, 6, 2);
		this.rightarmlower.setRotationPoint(-2.5F, -2.5F, -1.5F);
		this.rightarmlower.setTextureSize(128, 64);
		this.setRotation(rightarmlower, -0.4537856F, 0F, 0.4363323F);
		this.leftarmlower = new ModelRenderer(this, 16, 20);
		this.leftarmlower.addBox(0F, 5F, 0F, 2, 6, 2);
		this.leftarmlower.setRotationPoint(2.5F, -2.5F, -1.5F);
		this.leftarmlower.setTextureSize(128, 64);
		this.setRotation(leftarmlower, -0.4537856F, 0F, -0.4363323F);
		this.rightclaw = new ModelRenderer(this, 64, 0);
		this.rightclaw.addBox(-2F, 11F, -0.5F, 2, 3, 3);
		this.rightclaw.setRotationPoint(-2.5F, -2.5F, -1.5F);
		this.rightclaw.setTextureSize(128, 64);
		this.setRotation(rightclaw, -0.4537856F, 0F, 0.4363323F);
		this.leftclaw = new ModelRenderer(this, 74, 0);
		this.leftclaw.addBox(0F, 11F, -0.5F, 2, 3, 3);
		this.leftclaw.setRotationPoint(2.5F, -2.5F, -1.5F);
		this.leftclaw.setTextureSize(128, 64);
		this.setRotation(leftclaw, -0.4537856F, 0F, -0.4363323F);
		this.waist = new ModelRenderer(this, 64, 6);
		this.waist.addBox(-3.5F, 9F, -3F, 7, 3, 4);
		this.waist.setRotationPoint(0F, -4F, -2F);
		this.waist.setTextureSize(128, 64);
		this.setRotation(waist, 0.1745329F, 0F, 0F);
		this.tail1 = new ModelRenderer(this, 64, 13);
		this.tail1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		this.tail1.setRotationPoint(0F, 6F, 0F);
		this.tail1.setTextureSize(128, 64);
		this.setRotation(tail1, 0.5235988F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 64, 24);
		this.tail2.addBox(-1F, 8F, -2.5F, 2, 6, 2);
		this.tail2.setRotationPoint(0F, 6F, 0F);
		this.tail2.setTextureSize(128, 64);
		this.setRotation(tail2, 0.6981317F, 0F, 0F);
		this.tail3 = new ModelRenderer(this, 64, 32);
		this.tail3.addBox(-0.5F, 13.5F, -4.5F, 1, 6, 1);
		this.tail3.setRotationPoint(0F, 6F, 0F);
		this.tail3.setTextureSize(128, 64);
		this.setRotation(tail3, 0.8726646F, 0F, 0F);
		this.rightleg1 = new ModelRenderer(this, 86, 0);
		this.rightleg1.addBox(-1.5F, 0.5F, -1.5F, 3, 11, 3);
		this.rightleg1.setRotationPoint(-2F, 6F, 0F);
		this.rightleg1.setTextureSize(128, 64);
		this.setRotation(rightleg1, -0.3490659F, 0.1745329F, 0F);
		this.leftleg1 = new ModelRenderer(this, 86, 0);
		this.leftleg1.addBox(-1.5F, 0.5F, -1.5F, 3, 11, 3);
		this.leftleg1.setRotationPoint(2F, 6F, 0F);
		this.leftleg1.setTextureSize(128, 64);
		this.setRotation(leftleg1, -0.3490659F, -0.1745329F, 0F);
		this.rightleg2 = new ModelRenderer(this, 86, 14);
		this.rightleg2.addBox(-2F, 1.5F, -2F, 4, 8, 4);
		this.rightleg2.setRotationPoint(-2F, 6F, 0F);
		this.rightleg2.setTextureSize(128, 64);
		this.setRotation(rightleg2, -0.3490659F, 0.1745329F, 0F);
		this.leftleg2 = new ModelRenderer(this, 86, 14);
		this.leftleg2.addBox(-2F, 1.5F, -2F, 4, 8, 4);
		this.leftleg2.setRotationPoint(2F, 6F, 0F);
		this.leftleg2.setTextureSize(128, 64);
		this.setRotation(leftleg2, -0.3490659F, -0.1745329F, 0F);
		this.rightleg3 = new ModelRenderer(this, 86, 26);
		this.rightleg3.addBox(-1F, 10.5F, -1F, 2, 2, 5);
		this.rightleg3.setRotationPoint(-2F, 6F, 0F);
		this.rightleg3.setTextureSize(128, 64);
		this.setRotation(rightleg3, -0.3490659F, 0.1745329F, 0F);
		this.leftleg3 = new ModelRenderer(this, 86, 26);
		this.leftleg3.addBox(-1F, 10.5F, -1F, 2, 2, 5);
		this.leftleg3.setRotationPoint(2F, 6F, 0F);
		this.leftleg3.setTextureSize(128, 64);
		this.setRotation(leftleg3, -0.3490659F, -0.1745329F, 0F);
		this.rightleg4 = new ModelRenderer(this, 86, 33);
		this.rightleg4.addBox(-1.5F, 3.5F, -16.5F, 3, 2, 6);
		this.rightleg4.setRotationPoint(-2F, 6F, 0F);
		this.rightleg4.setTextureSize(128, 64);
		this.setRotation(rightleg4, 1.22173F, 0.1745329F, 0F);
		this.leftleg4 = new ModelRenderer(this, 86, 33);
		this.leftleg4.addBox(-1.5F, 3.5F, -16.5F, 3, 2, 6);
		this.leftleg4.setRotationPoint(2F, 6F, 0F);
		this.leftleg4.setTextureSize(128, 64);
		this.setRotation(leftleg4, 1.22173F, -0.1745329F, 0F);
		this.rightleg5 = new ModelRenderer(this, 86, 41);
		this.rightleg5.addBox(-1.5F, -4.5F, -18F, 3, 4, 1);
		this.rightleg5.setRotationPoint(-2F, 6F, 0F);
		this.rightleg5.setTextureSize(128, 64);
		this.setRotation(rightleg5, 1.570796F, 0.1745329F, 0F);
		this.leftleg5 = new ModelRenderer(this, 86, 41);
		this.leftleg5.addBox(-1.5F, -4.5F, -18F, 3, 4, 1);
		this.leftleg5.setRotationPoint(2F, 6F, 0F);
		this.leftleg5.setTextureSize(128, 64);
		setRotation(leftleg5, 1.570796F, -0.1745329F, 0F);
		this.rightwing = new ModelRenderer(this, 104, 34);
		this.rightwing.addBox(0F, -4F, 0F, 0, 18, 12);
		this.rightwing.setRotationPoint(-2F, -2F, 0F);
		this.rightwing.setTextureSize(128, 64);
		this.setRotation(rightwing, 0.5235988F, -0.5235988F, 0F);
		this.leftwing = new ModelRenderer(this, 104, 34);
		this.leftwing.mirror = true;
		this.leftwing.addBox(0F, -4F, 0F, 0, 18, 12);
		this.leftwing.setRotationPoint(2F, -2F, 0F);
		this.leftwing.setTextureSize(128, 64);
		this.setRotation(leftwing, 0.5235988F, 0.5235988F, 0F);
		
		this.convertToChild(head, righthorn);
		this.convertToChild(head, lefthorn);
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(rightarm, rightclaw);
		this.convertToChild(leftarm, leftclaw);
		this.convertToChild(rightleg1, rightleg2);
		this.convertToChild(rightleg1, rightleg3);
		this.convertToChild(rightleg1, rightleg4);
		this.convertToChild(rightleg1, rightleg5);
		this.convertToChild(leftleg1, leftleg2);
		this.convertToChild(leftleg1, leftleg3);
		this.convertToChild(leftleg1, leftleg4);
		this.convertToChild(leftleg1, leftleg5);
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
		this.rightarm.render(scale);
		this.leftarm.render(scale);
		this.rightchest.render(scale);
		this.leftchest.render(scale);
//		this.righthorn.render(scale);
//		this.lefthorn.render(scale);
//		this.rightear.render(scale);
//		this.leftear.render(scale);
//		this.rightarmlower.render(scale);
//		this.leftarmlower.render(scale);
//		this.rightclaw.render(scale);
//		this.leftclaw.render(scale);
		this.waist.render(scale);
		this.tail1.render(scale);
		this.tail2.render(scale);
		this.tail3.render(scale);
		this.rightleg1.render(scale);
		this.leftleg1.render(scale);
//		this.rightleg2.render(scale);
//		this.leftleg2.render(scale);
//		this.rightleg3.render(scale);
//		this.leftleg3.render(scale);
//		this.rightleg4.render(scale);
//		this.leftleg4.render(scale);
//		this.rightleg5.render(scale);
//		this.leftleg5.render(scale);
		this.rightwing.render(scale);
		this.leftwing.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			this.headeyes.render(scale);
		}
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = (headPitch / 57.295776F) + 0.1745329F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
		if(this.isCarrying) {
			this.rightarm.rotateAngleX -= 0.5F;
			this.leftarm.rotateAngleX -= 0.5F;
			this.rightarm.rotateAngleZ += 0.05F;
			this.leftarm.rotateAngleZ -= 0.05F;
		} else if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
		
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		
		//body
		this.rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float)Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		this.leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		this.rightwing.rotateAngleY -= 0.5235988F;
		this.leftwing.rotateAngleY += 0.5235988F;
		
		this.tail1.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(3);
		this.tail2.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(6);
		this.tail3.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(9);
		
		//legs
		this.rightleg1.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount) * 1.5F;
		this.rightleg1.rotateAngleX -= 0.3490659F;
		this.leftleg1.rotateAngleX = (MathHelper.cos(limbSwing * 0.6665F + (float)Math.PI) * 0.2F * limbSwingAmount) * 1.5F;
		this.leftleg1.rotateAngleX -= 0.3490659F;
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
