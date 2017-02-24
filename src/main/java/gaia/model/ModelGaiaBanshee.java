package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaBanshee extends ModelGaia {
    ModelRenderer anchor;
	ModelRenderer head;
	ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymid;
	ModelRenderer bodymidbutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer hair3;
	ModelRenderer hair4;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer waist1;
	ModelRenderer waist2;
	ModelRenderer waist3;
	ModelRenderer waist4;

	public ModelGaiaBanshee() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.anchor = new ModelRenderer(this, 0, 0);
		this.anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		this.anchor.setRotationPoint(0F, -6F, -1F);
		this.anchor.setTextureSize(64, 32);
		this.setRotation(anchor, 0F, 0F, 0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, -6F, -1F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, -6F, -1F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, -6F, -1F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, -6F, -1F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, -6F, -1F);
		this.bodytop.setTextureSize(64, 32);
		this.setRotation(bodytop, 0F, 0F, 0F);
		this.bodymid = new ModelRenderer(this, 0, 25);
		this.bodymid.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymid.setRotationPoint(0F, -6F, -1F);
		this.bodymid.setTextureSize(64, 32);
		this.setRotation(bodymid, 0.0872665F, 0F, 0F);
		this.bodymidbutton = new ModelRenderer(this, 0, 25);
		this.bodymidbutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymidbutton.setRotationPoint(0F, -6F, -1F);
		this.bodymidbutton.setTextureSize(64, 32);
		this.setRotation(bodymidbutton, 0.0872665F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -3F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, -6F, -1F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.2617994F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, -4F, -2.5F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, -4F, -2.5F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, -4.5F, -1F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0.3490659F, 0F, 0.2617994F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, -4.5F, -1F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0.3490659F, 0F, -0.2617994F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 4F, 0.5F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0.2617994F, 0F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 4F, 0.5F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0.1745329F, 0F, 0.0349066F);
		this.hair1 = new ModelRenderer(this, 36, 14);
		this.hair1.addBox(-4F, -7.5F, -0.5F, 8, 7, 2);
		this.hair1.setRotationPoint(0F, -6F, -1F);
		this.hair1.setTextureSize(64, 32);
		this.setRotation(hair1, 0.0872665F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 23);
		this.hair2.addBox(-5F, -8.5F, 1.5F, 10, 10, 4);
		this.hair2.setRotationPoint(0F, -6F, -1F);
		this.hair2.setTextureSize(64, 32);
		this.setRotation(hair2, 0.1745329F, 0F, 0F);
		this.hair3 = new ModelRenderer(this, 36, 37);
		this.hair3.addBox(-6F, -9.5F, 5.5F, 12, 12, 6);
		this.hair3.setRotationPoint(0F, -6F, -1F);
		this.hair3.setTextureSize(64, 32);
		this.setRotation(hair3, 0.1745329F, 0F, 0F);
		this.hair4 = new ModelRenderer(this, 6, 41);
		this.hair4.addBox(-4F, -7.5F, 5.5F, 8, 8, 14);
		this.hair4.setRotationPoint(0F, -6F, -1F);
		this.hair4.setTextureSize(64, 32);
		this.setRotation(hair4, 0.1745329F, 0F, 0F);
		this.rightarmlower = new ModelRenderer(this, 72, 0);
		this.rightarmlower.addBox(-2.5F, 1F, -1.5F, 3, 10, 3);
		this.rightarmlower.setRotationPoint(-2.5F, -4.5F, -1F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(rightarmlower, 0.3490659F, 0F, 0.2617994F);
		this.leftarmlower = new ModelRenderer(this, 72, 0);
		this.leftarmlower.addBox(-0.5F, 1F, -1.5F, 3, 10, 3);
		this.leftarmlower.setRotationPoint(2.5F, -4.5F, -1F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(leftarmlower, 0.3490659F, 0F, -0.2617994F);
		this.waist1 = new ModelRenderer(this, 72, 13);
		this.waist1.addBox(-3.5F, 7.5F, -4F, 7, 2, 6);
		this.waist1.setRotationPoint(0F, -6F, -1F);
		this.waist1.setTextureSize(64, 32);
		this.setRotation(waist1, 0.2617994F, 0F, 0F);
		this.waist2 = new ModelRenderer(this, 72, 21);
		this.waist2.addBox(-4F, 9F, -4.5F, 8, 4, 7);
		this.waist2.setRotationPoint(0F, -6F, -1F);
		this.waist2.setTextureSize(64, 32);
		this.setRotation(waist2, 0.2792527F, 0F, 0F);
		this.waist3 = new ModelRenderer(this, 72, 32);
		this.waist3.addBox(-4.5F, 12F, -5F, 9, 5, 8);
		this.waist3.setRotationPoint(0F, -6F, -1F);
		this.waist3.setTextureSize(64, 32);
		this.setRotation(waist3, 0.296706F, 0F, 0F);
		this.waist4 = new ModelRenderer(this, 72, 45);
		this.waist4.addBox(-5F, 16F, -6F, 10, 6, 9);
		this.waist4.setRotationPoint(0F, -6F, -1F);
		this.waist4.setTextureSize(64, 32);
		this.setRotation(waist4, 0.3403392F, 0F, 0F);
		
		this.anchor.addChild(head);
		this.anchor.addChild(headeyes);
		this.anchor.addChild(headaccessory);
		this.anchor.addChild(neck);
		this.anchor.addChild(bodytop);
		this.anchor.addChild(bodymid);
		this.anchor.addChild(bodymidbutton);
		this.anchor.addChild(bodybottom);
		this.anchor.addChild(rightchest);
		this.anchor.addChild(leftchest);
		this.anchor.addChild(rightarm);
		this.anchor.addChild(leftarm);
		this.anchor.addChild(rightleg);
		this.anchor.addChild(leftleg);
		this.convertToChild(head, hair1);
		this.convertToChild(head, hair2);
		this.convertToChild(head, hair3);
		this.convertToChild(head, hair4);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftarmlower);
		this.anchor.addChild(waist1);
		this.anchor.addChild(waist2);
		this.anchor.addChild(waist3);
		this.anchor.addChild(waist4);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.anchor.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//anchor
        this.anchor.rotationPointY = (MathHelper.cos(((float)1.5F + ageInTicks) * 0.5F)) * 0.5F;
        
		if (entityIn.ticksExisted % 45 == 0 && limbSwingAmount <= 0.1F) {
			this.anchor.showModel = false;
		} else {
			this.anchor.showModel = true;
		}
        
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;	
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		
		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			this.headeyes.showModel = true;
		} else {
			this.headeyes.showModel = false;
		}
		
		//arms
		this.rightarm.rotateAngleZ = 0.0F;
		this.rightarm.rotateAngleX = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleX = 0.0F;
		
        if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.2617994F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.2617994F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        
		//body
		this.waist1.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(1);
		this.waist2.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(2);
		this.waist3.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(3);
		this.waist4.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(4);
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
