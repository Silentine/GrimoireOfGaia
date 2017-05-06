package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaYeti extends ModelGaia {
    ModelRenderer head;
    ModelRenderer headaccessory;
    ModelRenderer horns;
    ModelRenderer headjaw;
    ModelRenderer mantle;
    ModelRenderer bodyfront;
    ModelRenderer bodyback;
	ModelRenderer rightarm;
    ModelRenderer rightarmlower;
    ModelRenderer rightarmhand;
	ModelRenderer leftarm;
    ModelRenderer leftarmlower;
    ModelRenderer leftarmhand;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer rightleg;
    ModelRenderer rightleglower;
    ModelRenderer leftleg;
    ModelRenderer leftleglower;

	public ModelGaiaYeti() {
		this.textureWidth = 256;
		this.textureHeight = 128;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4F, -4F, -9F, 8, 8, 8);
		this.head.setRotationPoint(0F, -7F, -4F);
		this.head.setTextureSize(256, 128);
		this.setRotation(head, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 0, 40);
		this.headaccessory.addBox(-6F, -5F, -6F, 12, 8, 6);
		this.headaccessory.setRotationPoint(0F, -7F, 0F);
		this.headaccessory.setTextureSize(256, 128);
		this.setRotation(headaccessory, -0.2617994F, 0F, 0F);
		this.horns = new ModelRenderer(this, 0, 16);
		this.horns.addBox(-4.5F, -6F, -9.5F, 9, 3, 9);
		this.horns.setRotationPoint(0F, -7F, -4F);
		this.horns.setTextureSize(256, 128);
		this.setRotation(horns, 0F, 0F, 0F);
		this.headjaw = new ModelRenderer(this, 0, 28);
		this.headjaw.addBox(-6F, 0F, -8F, 12, 6, 6);
		this.headjaw.setRotationPoint(0F, -7F, 0F);
		this.headjaw.setTextureSize(256, 128);
		this.setRotation(headjaw, 0F, 0F, 0F);
		this.mantle = new ModelRenderer(this, 0, 54);
		this.mantle.addBox(-9F, -5.5F, -3.5F, 18, 7, 9);
		this.mantle.setRotationPoint(0F, -7F, 0F);
		this.mantle.setTextureSize(256, 128);
		this.setRotation(mantle, -0.7853982F, 0F, 0F);
		this.bodyfront = new ModelRenderer(this, 54, 0);
		this.bodyfront.addBox(-7.5F, -2F, -8F, 15, 10, 5);
		this.bodyfront.setRotationPoint(0F, -7F, 0F);
		this.bodyfront.setTextureSize(256, 128);
		this.setRotation(bodyfront, 0.7853982F, 0F, 0F);
		this.bodyback = new ModelRenderer(this, 54, 15);
		this.bodyback.addBox(-8.5F, -3F, -3F, 17, 10, 8);
		this.bodyback.setRotationPoint(0F, -7F, 0F);
		this.bodyback.setTextureSize(256, 128);
		this.setRotation(bodyback, 0.7853982F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 122, 0);
		this.rightarm.addBox(-5F, -1F, -3F, 5, 14, 5);
		this.rightarm.setRotationPoint(-8F, -6F, 1F);
		this.rightarm.setTextureSize(256, 128);
		this.setRotation(rightarm, -0.2617994F, 0.1745329F, 0F);
		this.rightarmlower = new ModelRenderer(this, 122, 19);
		this.rightarmlower.addBox(-6F, 12F, -5.5F, 7, 12, 5);
		this.rightarmlower.setRotationPoint(-8F, -6F, 1F);
		this.rightarmlower.setTextureSize(256, 128);
		this.setRotation(rightarmlower, -0.0872665F, 0.1745329F, 0F);
		this.rightarmhand = new ModelRenderer(this, 122, 36);
		this.rightarmhand.addBox(-5.5F, 8F, 19F, 6, 4, 5);
		this.rightarmhand.setRotationPoint(-8F, -6F, 1F);
		this.rightarmhand.setTextureSize(256, 128);
		this.setRotation(rightarmhand, -1.308997F, 0.1745329F, 0F);
		this.leftarm = new ModelRenderer(this, 122, 0);
		this.leftarm.addBox(0F, -1F, -3F, 5, 14, 5);
		this.leftarm.setRotationPoint(8F, -6F, 1F);
		this.leftarm.setTextureSize(256, 128);
		this.setRotation(leftarm, -0.2617994F, -0.1745329F, 0F);
		this.leftarmlower = new ModelRenderer(this, 122, 19);
		this.leftarmlower.addBox(-1F, 12F, -5.5F, 7, 12, 5);
		this.leftarmlower.setRotationPoint(8F, -6F, 1F);
		this.leftarmlower.setTextureSize(256, 128);
		this.setRotation(leftarmlower, -0.0872665F, -0.1745329F, 0F);
		this.leftarmhand = new ModelRenderer(this, 122, 36);
		this.leftarmhand.addBox(-0.5F, 8F, 19F, 6, 4, 5);
		this.leftarmhand.setRotationPoint(8F, -6F, 1F);
		this.leftarmhand.setTextureSize(256, 128);
		this.setRotation(leftarmhand, -1.308997F, -0.1745329F, 0F);
		this.body1 = new ModelRenderer(this, 54, 33);
		this.body1.addBox(-5.5F, 4F, -2F, 11, 11, 9);
		this.body1.setRotationPoint(0F, -7F, 0F);
		this.body1.setTextureSize(256, 128);
		this.setRotation(body1, 0.2617994F, 0F, 0F);
		this.body2 = new ModelRenderer(this, 54, 53);
		this.body2.addBox(-3.5F, 12F, 2.5F, 7, 7, 7);
		this.body2.setRotationPoint(0F, -7F, 0F);
		this.body2.setTextureSize(256, 128);
		this.setRotation(body2, 0F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 104, 0);
		this.rightleg.addBox(-2F, 0F, -2F, 4, 9, 4);
		this.rightleg.setRotationPoint(-3.5F, 9F, 6F);
		this.rightleg.setTextureSize(256, 128);
		this.setRotation(rightleg, -0.2617994F, 0F, 0.0349066F);
		this.rightleglower = new ModelRenderer(this, 104, 13);
		this.rightleglower.addBox(-2.5F, 5F, -3F, 5, 10, 4);
		this.rightleglower.setRotationPoint(-3.5F, 9F, 6F);
		this.rightleglower.setTextureSize(256, 128);
		this.setRotation(rightleglower, 0F, 0F, 0.0349066F);
		this.leftleg = new ModelRenderer(this, 104, 0);
		this.leftleg.addBox(-2F, 0F, -2F, 4, 9, 4);
		this.leftleg.setRotationPoint(3.5F, 9F, 6F);
		this.leftleg.setTextureSize(256, 128);
		this.setRotation(leftleg, -0.2617994F, 0F, -0.0349066F);
		this.leftleglower = new ModelRenderer(this, 104, 13);
		this.leftleglower.addBox(-2.5F, 5F, -3F, 5, 10, 4);
		this.leftleglower.setRotationPoint(3.5F, 9F, 6F);
		this.leftleglower.setTextureSize(256, 128);
		this.setRotation(leftleglower, 0F, 0F, -0.0349066F);
		
		this.convertToChild(head, headaccessory);
		this.convertToChild(head, horns);
		this.convertToChild(head, headjaw);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(rightarm, rightarmhand);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(leftarm, leftarmhand);
		this.convertToChild(rightleg, rightleglower);
		this.convertToChild(leftleg, leftleglower);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
//		this.headaccessory.render(scale);
//		this.horns.render(scale);
//		this.headjaw.render(scale);
		this.mantle.render(scale);
		this.bodyfront.render(scale);
		this.bodyback.render(scale);
		this.body1.render(scale);
		this.body2.render(scale);
		this.rightarm.render(scale);
		this.leftarm.render(scale);
//		this.rightarmlower.render(scale);
//		this.rightarmhand.render(scale);
//		this.leftarmlower.render(scale);
//		this.leftarmhand.render(scale);
		this.rightleg.render(scale);
//		this.rightleglower.render(scale);
		this.leftleg.render(scale);
//		this.leftleglower.render(scale);
	}
    
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		
		//arms
		this.rightarm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F) - 0.2617994F;
		this.leftarm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F) - 0.2617994F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;
		this.rightleg.rotateAngleX -= 0.2617994F;
		this.leftleg.rotateAngleX -= 0.2617994F;
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
        this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
        this.rightarm.rotateAngleY += (this.bodyfront.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        
        //left arm
        this.leftarm.rotateAngleX = (float)((double)this.leftarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
        this.leftarm.rotateAngleY += (this.bodyfront.rotateAngleY * 2.0F);
        this.leftarm.rotateAngleZ -= (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
	}
}
