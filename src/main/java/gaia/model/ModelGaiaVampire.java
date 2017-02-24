package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaVampire extends ModelGaia {
    ModelRenderer anchor;
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
	ModelRenderer mantle;
	ModelRenderer cloak1;
	ModelRenderer cloak2;
	ModelRenderer cloak3;
	ModelRenderer cloak4;
	ModelRenderer rightshoulder;
	ModelRenderer leftshoulder;
	ModelRenderer waist;
	ModelRenderer waist1;
	ModelRenderer waist2;
	ModelRenderer waist3;
	ModelRenderer waist4;

	public ModelGaiaVampire() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.anchor = new ModelRenderer(this, 0, 0);
		this.anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		this.anchor.setRotationPoint(0F, -5F, 0F);
		this.anchor.setTextureSize(64, 32);
		this.setRotation(anchor, 0F, 0F, 0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, -8F, 0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, -8F, 0F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, -8F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, -8F, 0F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, -8F, 0F);
		this.bodytop.setTextureSize(64, 32);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, -8F, 0F);
		this.bodymiddle.setTextureSize(64, 32);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, -8F, 0F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, -8F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, -6F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, -6F, -1.5F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, -6.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, -6.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0.0872665F, 0F, -0.1745329F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 2F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0.0872665F, 0F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 2F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, -0.0872665F, 0F, 0.0349066F);
		this.mantle = new ModelRenderer(this, 36, 14);
		this.mantle.addBox(-5F, -6F, -2F, 10, 7, 6);
		this.mantle.setRotationPoint(0F, -8F, 0F);
		this.mantle.setTextureSize(64, 32);
		this.setRotation(mantle, 0F, 0F, 0F);
		this.cloak1 = new ModelRenderer(this, 36, 27);
		this.cloak1.addBox(-6.5F, 1F, 0.5F, 13, 4, 3);
		this.cloak1.setRotationPoint(0F, -8F, 0F);
		this.cloak1.setTextureSize(64, 32);
		this.setRotation(cloak1, 0.2443461F, 0F, 0F);
		this.cloak2 = new ModelRenderer(this, 36, 34);
		this.cloak2.addBox(-7F, 4F, 0F, 14, 5, 4);
		this.cloak2.setRotationPoint(0F, -8F, 0F);
		this.cloak2.setTextureSize(64, 32);
		this.setRotation(cloak2, 0.122173F, 0F, 0F);
		this.cloak3 = new ModelRenderer(this, 36, 43);
		this.cloak3.addBox(-7.5F, 8F, 0F, 15, 5, 5);
		this.cloak3.setRotationPoint(0F, -8F, 0F);
		this.cloak3.setTextureSize(64, 32);
		this.setRotation(cloak3, 0F, 0F, 0F);
		this.cloak4 = new ModelRenderer(this, 36, 53);
		this.cloak4.addBox(-8F, 12.5F, -0.5F, 16, 6, 6);
		this.cloak4.setRotationPoint(0F, -8F, 0F);
		this.cloak4.setTextureSize(64, 32);
		this.setRotation(cloak4, -0.0523599F, 0F, 0F);
		this.rightshoulder = new ModelRenderer(this, 80, 0);
		this.rightshoulder.addBox(-2.5F, -1F, -1.5F, 3, 4, 3);
		this.rightshoulder.setRotationPoint(-2.5F, -6.5F, 0F);
		this.rightshoulder.setTextureSize(64, 32);
		this.setRotation(rightshoulder, 0.0872665F, 0F, 0.0872665F);
		this.leftshoulder = new ModelRenderer(this, 80, 0);
		this.leftshoulder.addBox(-0.5F, -1F, -1.5F, 3, 4, 3);
		this.leftshoulder.setRotationPoint(2.5F, -6.5F, 0F);
		this.leftshoulder.setTextureSize(64, 32);
		this.setRotation(leftshoulder, 0.0872665F, 0F, -0.0872665F);
		this.waist = new ModelRenderer(this, 80, 7);
		this.waist.addBox(-3F, 5F, -2.5F, 6, 2, 5);
		this.waist.setRotationPoint(0F, -8F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0F, 0F, 0F);
		this.waist1 = new ModelRenderer(this, 80, 14);
		this.waist1.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		this.waist1.setRotationPoint(0F, -8F, 0F);
		this.waist1.setTextureSize(64, 32);
		this.setRotation(waist1, 0.0872665F, 0F, 0F);
		this.waist2 = new ModelRenderer(this, 80, 22);
		this.waist2.addBox(-3.5F, 7F, -3F, 7, 4, 6);
		this.waist2.setRotationPoint(0F, -8F, 0F);
		this.waist2.setTextureSize(64, 32);
		this.setRotation(waist2, 0F, 0F, 0F);
		this.waist3 = new ModelRenderer(this, 80, 32);
		this.waist3.addBox(-4F, 11F, -3.5F, 8, 4, 7);
		this.waist3.setRotationPoint(0F, -8F, 0F);
		this.waist3.setTextureSize(64, 32);
		this.setRotation(waist3, 0F, 0F, 0F);
		this.waist4 = new ModelRenderer(this, 80, 43);
		this.waist4.addBox(-4.5F, 15F, -4F, 9, 6, 8);
		this.waist4.setRotationPoint(0F, -8F, 0F);
		this.waist4.setTextureSize(64, 32);
		this.setRotation(waist4, 0F, 0F, 0F);
		
		this.anchor.addChild(head);
		this.anchor.addChild(headeyes);
		this.anchor.addChild(headaccessory);
		this.anchor.addChild(neck);
		this.anchor.addChild(bodytop);
		this.anchor.addChild(bodymiddle);
		this.anchor.addChild(bodymiddlebutton);
		this.anchor.addChild(bodybottom);
		this.anchor.addChild(rightchest);
		this.anchor.addChild(leftchest);
		this.anchor.addChild(rightarm);
		this.anchor.addChild(leftarm);
		this.anchor.addChild(rightleg);
		this.anchor.addChild(leftleg);
		this.anchor.addChild(mantle);
		this.anchor.addChild(cloak1);
		this.anchor.addChild(cloak2);
		this.anchor.addChild(cloak3);
		this.anchor.addChild(cloak4);
		this.convertToChild(rightarm, rightshoulder);
		this.convertToChild(leftarm, leftshoulder);
		this.anchor.addChild(waist);
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
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightarm.rotateAngleX = 0.0F;
        this.leftarm.rotateAngleX = 0.0F;
        
        if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		
		//body
		this.cloak1.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(1);
		this.cloak2.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(2);
		this.cloak3.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(3);
		this.cloak4.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(4);
		
		this.waist1.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(1);
		this.waist2.rotateAngleZ = this.waist1.rotateAngleZ;
		this.waist3.rotateAngleZ = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(2);
		this.waist4.rotateAngleZ = this.waist3.rotateAngleZ;
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
