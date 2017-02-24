package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMinotaur extends ModelGaia {
	ModelRenderer head;
	ModelRenderer horn;
	ModelRenderer hornright;
	ModelRenderer hornleft;
	ModelRenderer brow;
	ModelRenderer nose;
    ModelRenderer nosering;
	ModelRenderer neckmuscle;
	ModelRenderer body;
	ModelRenderer body2;
	ModelRenderer body3;
	ModelRenderer waist;
	ModelRenderer rightarm;
	public static ModelRenderer rightarmlower;
	ModelRenderer righthandle;
	ModelRenderer righthammerhead;
	ModelRenderer leftarm;
	public static ModelRenderer leftarmlower;
	ModelRenderer rightleg;
	ModelRenderer rightleglower;
	ModelRenderer rightfoot;
	ModelRenderer leftleg;
	ModelRenderer leftleglower;
	ModelRenderer leftfoot;

	public ModelGaiaMinotaur() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3.5F, -7F, -4F, 7, 7, 8);
		this.head.setRotationPoint(0F, -9F, -4F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0F, 0F, 0F);
		this.horn = new ModelRenderer(this, 50, 0);
		this.horn.addBox(-7.5F, -6F, -3F, 15, 2, 2);
		this.horn.setRotationPoint(0F, -9F, -4F);
		this.horn.setTextureSize(128, 64);
		this.setRotation(horn, 0F, 0F, 0F);
		this.hornright = new ModelRenderer(this, 76, 4);
		this.hornright.addBox(-7.5F, -10F, 1F, 2, 5, 2);
		this.hornright.setRotationPoint(0F, -9F, -4F);
		this.hornright.setTextureSize(128, 64);
		this.setRotation(hornright, 0.7853982F, 0F, 0F);
		this.hornleft = new ModelRenderer(this, 76, 4);
		this.hornleft.addBox(5.5F, -10F, 1F, 2, 5, 2);
		this.hornleft.setRotationPoint(0F, -9F, -4F);
		this.hornleft.setTextureSize(128, 64);
		this.setRotation(hornleft, 0.8028515F, 0F, 0F);
		this.brow = new ModelRenderer(this, 30, 0);
		this.brow.addBox(-3F, -6F, -6F, 6, 2, 2);
		this.brow.setRotationPoint(0F, -9F, -4F);
		this.brow.setTextureSize(128, 64);
		this.setRotation(brow, 0F, 0F, 0F);
		this.nose = new ModelRenderer(this, 30, 4);
		this.nose.addBox(-2.5F, -4F, -9F, 5, 4, 5);
		this.nose.setRotationPoint(0F, -9F, -4F);
		this.nose.setTextureSize(128, 64);
		this.setRotation(nose, 0F, 0F, 0F);
		this.nosering = new ModelRenderer(this, 30, 13);
		this.nosering.addBox(-2F, -1F, -10F, 4, 4, 1);
		this.nosering.setRotationPoint(0F, -9F, -4F);
		this.nosering.setTextureSize(128, 64);
		this.setRotation(nosering, 0F, 0F, 0F);
		this.neckmuscle = new ModelRenderer(this, 0, 15);
		this.neckmuscle.addBox(-5F, -2F, 1.5F, 10, 6, 5);
		this.neckmuscle.setRotationPoint(0F, -9F, -4F);
		this.neckmuscle.setTextureSize(128, 64);
		this.setRotation(neckmuscle, 0.6108652F, 0F, 0F);
		this.body = new ModelRenderer(this, 0, 26);
		this.body.addBox(-6F, 0F, -4F, 12, 9, 8);
		this.body.setRotationPoint(0F, -10F, 0F);
		this.body.setTextureSize(128, 64);
		this.setRotation(body, 0.1745329F, 0F, 0F);
		this.body2 = new ModelRenderer(this, 0, 43);
		this.body2.addBox(-5F, 11F, -2F, 10, 5, 6);
		this.body2.setRotationPoint(0F, -12F, 0F);
		this.body2.setTextureSize(128, 64);
		this.setRotation(body2, 0.0872665F, 0F, 0F);
		this.body3 = new ModelRenderer(this, 0, 54);
		this.body3.addBox(-4F, 16F, -1F, 8, 5, 5);
		this.body3.setRotationPoint(0F, -12F, 0F);
		this.body3.setTextureSize(128, 64);
		this.setRotation(body3, 0F, 0F, 0F);
		this.waist = new ModelRenderer(this, 72, 15);
		this.waist.addBox(-4.5F, 16F, -1.5F, 9, 8, 6);
		this.waist.setRotationPoint(0F, -12F, 0F);
		this.waist.setTextureSize(128, 64);
		this.setRotation(waist, 0F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 40, 17);
		this.rightarm.addBox(-3F, -2F, -2F, 4, 10, 4);
		this.rightarm.setRotationPoint(-7F, -7F, 0F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 56, 17);
		this.leftarm.addBox(-1F, -2F, -2F, 4, 10, 4);
		this.leftarm.setRotationPoint(7F, -7F, 0F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, 0F, 0F, -0.1745329F);
		this.rightarmlower = new ModelRenderer(this, 40, 31);
		this.rightarmlower.addBox(-4.5F, 8F, -2F, 4, 8, 4);
		this.rightarmlower.setRotationPoint(-7F, -7F, 0F);
		this.rightarmlower.setTextureSize(128, 64);
		this.setRotation(rightarmlower, 0F, 0F, 0F);
		this.righthandle = new ModelRenderer(this, 120, 16);
		this.righthandle.addBox(-3.5F, -9F, -15F, 2, 18, 2);
		this.righthandle.setRotationPoint(-7F, -7F, 0F);
		this.righthandle.setTextureSize(128, 64);
		this.setRotation(righthandle, 1.570796F, 0F, 0F);
		this.righthammerhead = new ModelRenderer(this, 96, 0);
		this.righthammerhead.addBox(-5.5F, -15F, -19F, 6, 6, 10);
		this.righthammerhead.setRotationPoint(-7F, -7F, 0F);
		this.righthammerhead.setTextureSize(128, 64);
		this.setRotation(righthammerhead, 1.570796F, 0F, 0F);
		this.leftarmlower = new ModelRenderer(this, 56, 31);
		this.leftarmlower.addBox(0.5F, 8F, -2F, 4, 8, 4);
		this.leftarmlower.setRotationPoint(7F, -7F, 0F);
		this.leftarmlower.setTextureSize(128, 64);
		this.setRotation(leftarmlower, 0F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 72, 29);
		this.rightleg.addBox(-2F, -1F, -2F, 4, 9, 4);
		this.rightleg.setRotationPoint(-4F, 7F, 2F);
		this.rightleg.setTextureSize(128, 64);
		this.setRotation(rightleg, -0.4363323F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 72, 42);
		this.rightleglower.addBox(-1.5F, 5F, 2F, 3, 10, 3);
		this.rightleglower.setRotationPoint(-4F, 7F, 2F);
		this.rightleglower.setTextureSize(128, 64);
		this.setRotation(rightleglower, -0.4363323F, 0F, 0F);
		this.rightfoot = new ModelRenderer(this, 72, 55);
		this.rightfoot.addBox(-2F, 14F, -5F, 4, 3, 4);
		this.rightfoot.setRotationPoint(-4F, 7F, 2F);
		this.rightfoot.setTextureSize(128, 64);
		this.setRotation(rightfoot, 0F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 88, 29);
		this.leftleg.addBox(-2F, -1F, -2F, 4, 9, 4);
		this.leftleg.setRotationPoint(4F, 7F, 2F);
		this.leftleg.setTextureSize(128, 64);
		this.setRotation(leftleg, -0.3490659F, 0F, 0F);
		this.leftleglower = new ModelRenderer(this, 72, 42);
		this.leftleglower.addBox(-1.5F, 5F, 2F, 3, 10, 3);
		this.leftleglower.setRotationPoint(4F, 7F, 2F);
		this.leftleglower.setTextureSize(128, 64);
		this.setRotation(leftleglower, -0.4363323F, 0F, 0F);
		this.leftfoot = new ModelRenderer(this, 72, 55);
		this.leftfoot.addBox(-2F, 14F, -5F, 4, 3, 4);
		this.leftfoot.setRotationPoint(4F, 7F, 2F);
		this.leftfoot.setTextureSize(128, 64);
		this.setRotation(leftfoot, 0F, 0F, 0F);
		
		this.convertToChild(head, horn);
		this.convertToChild(head, hornright);
		this.convertToChild(head, hornleft);
		this.convertToChild(head, brow);
		this.convertToChild(head, nose);
		this.convertToChild(head, nosering);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(rightarm, righthandle);
		this.convertToChild(rightarm, righthammerhead);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(rightleg, rightleglower);
		this.convertToChild(rightleg, rightfoot);
		this.convertToChild(leftleg, leftleglower);
		this.convertToChild(leftleg, leftfoot);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
//		this.horn.render(scale);
//		this.hornright.render(scale);
//		this.hornleft.render(scale);
//		this.brow.render(scale);
//		this.nose.render(scale);
//		this.nosering.render(scale);
		this.neckmuscle.render(scale);
		this.body.render(scale);
		this.body2.render(scale);
		this.body3.render(scale);
		this.waist.render(scale);
		this.rightarm.render(scale);
		this.leftarm.render(scale);
//		this.rightarmlower.render(scale);
//		this.righthandle.render(scale);
//		this.righthammerhead.render(scale);
//		this.leftarmlower.render(scale);
		this.rightleg.render(scale);
//		this.rightleglower.render(scale);
//		this.rightfoot.render(scale);
		this.leftleg.render(scale);
//		this.leftleglower.render(scale);
//		this.leftfoot.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount;
		this.rightleg.rotateAngleX -= 0.4363323F;
		this.leftleg.rotateAngleX -= 0.4363323F;
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
        this.rightarm.rotateAngleX += (this.body.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
	}
}
