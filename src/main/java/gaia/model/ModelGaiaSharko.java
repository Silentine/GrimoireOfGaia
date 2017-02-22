package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSharko extends ModelGaia {
	ModelRenderer head;
	ModelRenderer headsnout;
	ModelRenderer headjaw;
	ModelRenderer finback;
	ModelRenderer bodyback;
	ModelRenderer bodyfront;
	ModelRenderer bodymid;
	public static ModelRenderer rightarm;
	public static ModelRenderer leftarm;
	ModelRenderer rightpauldron;
	ModelRenderer rightarmfin;
	ModelRenderer rightarmlower;
	ModelRenderer leftpauldron;
	ModelRenderer leftarmfin;
	ModelRenderer leftarmlower;
	ModelRenderer waist;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer tailend;
	ModelRenderer rightleg;
	ModelRenderer rightleglower;
	ModelRenderer rightfoot;
	ModelRenderer leftleg;
	ModelRenderer leftleglower;
	ModelRenderer leftfoot;

	public ModelGaiaSharko() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -7.0F, -4.0F, 8, 7, 8);
		this.head.setRotationPoint(0.0F, 4.0F, -4.0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(this.head, 0.1745329F, 0.0F, 0.0F);
		this.headsnout = new ModelRenderer(this, 0, 33);
		this.headsnout.addBox(-3.5F, -7.5F, -5.0F, 7, 4, 6);
		this.headsnout.setRotationPoint(0.0F, 4.0F, -4.0F);
		this.headsnout.setTextureSize(64, 32);
		this.setRotation(this.headsnout, 0.6981317F, 0.0F, 0.0F);
		this.headjaw = new ModelRenderer(this, 0, 43);
		this.headjaw.addBox(-3.0F, -3.0F, -5.0F, 6, 4, 5);
		this.headjaw.setRotationPoint(0.0F, 4.0F, -4.0F);
		this.headjaw.setTextureSize(64, 32);
		this.setRotation(this.headjaw, 0.1745329F, 0.0F, 0.0F);
		this.finback = new ModelRenderer(this, 0, 15);
		this.finback.addBox(-0.5F, -14.0F, -4.0F, 1, 8, 10);
		this.finback.setRotationPoint(0.0F, 4.0F, -4.0F);
		this.finback.setTextureSize(64, 32);
		this.setRotation(this.finback, -0.0872665F, 0.0F, 0.0F);
		this.bodyback = new ModelRenderer(this, 32, 12);
		this.bodyback.addBox(-7.0F, -1.0F, 1.0F, 14, 8, 4);
		this.bodyback.setRotationPoint(0.0F, -1.0F, -3.0F);
		this.bodyback.setTextureSize(64, 32);
		this.setRotation(this.bodyback, 0.3490659F, 0.0F, 0.0F);
		this.bodyfront = new ModelRenderer(this, 32, 0);
		this.bodyfront.addBox(-6.0F, 0.0F, -3.0F, 12, 8, 4);
		this.bodyfront.setRotationPoint(0.0F, -1.0F, -3.0F);
		this.bodyfront.setTextureSize(64, 32);
		this.setRotation(this.bodyfront, 0.3490659F, 0.0F, 0.0F);
		this.bodymid = new ModelRenderer(this, 32, 24);
		this.bodymid.addBox(-2.0F, 5.0F, 0.0F, 8, 5, 6);
		this.bodymid.setRotationPoint(-2.0F, 0.0F, -3.0F);
		this.bodymid.setTextureSize(64, 32);
		this.setRotation(this.bodymid, 0.1745329F, 0.0F, 0.0F);
		this.rightarm = new ModelRenderer(this, 68, 10);
		this.rightarm.addBox(-3F, -2F, -1.5F, 3, 8, 3);
		this.rightarm.setRotationPoint(-7F, 2F, -1F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0.5235988F, -0.2617994F, 0.2617994F);
		this.leftarm = new ModelRenderer(this, 68, 10);
		this.leftarm.addBox(0F, -2F, -1.5F, 3, 8, 3);
		this.leftarm.setRotationPoint(7F, 2F, -1F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0.5235988F, 0.2617994F, -0.2617994F);
		this.rightpauldron = new ModelRenderer(this, 68, 0);
		this.rightpauldron.addBox(-4F, -5F, -2.5F, 7, 5, 5);
		this.rightpauldron.setRotationPoint(-7F, 2F, -1F);
		this.rightpauldron.setTextureSize(64, 32);
		this.setRotation(rightpauldron, 0.3490659F, 0F, -0.0872665F);
		this.rightarmfin = new ModelRenderer(this, 68, 21);
		this.rightarmfin.addBox(-2F, -1F, 3.5F, 1, 8, 4);
		this.rightarmfin.setRotationPoint(-7F, 2F, -1F);
		this.rightarmfin.setTextureSize(64, 32);
		this.setRotation(rightarmfin, 0F, -0.2617994F, 0.2617994F);
		this.rightarmlower = new ModelRenderer(this, 68, 33);
		this.rightarmlower.addBox(-3.5F, 3F, 1.5F, 4, 10, 4);
		this.rightarmlower.setRotationPoint(-7F, 2F, -1F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(rightarmlower, 0F, -0.2617994F, 0.2617994F);
		this.leftpauldron = new ModelRenderer(this, 92, 0);
		this.leftpauldron.addBox(-3F, -5F, -2.5F, 7, 5, 5);
		this.leftpauldron.setRotationPoint(7F, 2F, -1F);
		this.leftpauldron.setTextureSize(64, 32);
		this.setRotation(leftpauldron, 0.3490659F, 0F, 0.0872665F);
		this.leftarmfin = new ModelRenderer(this, 68, 21);
		this.leftarmfin.addBox(1F, -1F, 3.5F, 1, 8, 4);
		this.leftarmfin.setRotationPoint(7F, 2F, -1F);
		this.leftarmfin.setTextureSize(64, 32);
		this.setRotation(leftarmfin, 0F, 0.2617994F, -0.2617994F);
		this.leftarmlower = new ModelRenderer(this, 84, 33);
		this.leftarmlower.addBox(-0.5F, 3F, 1.5F, 4, 10, 4);
		this.leftarmlower.setRotationPoint(7F, 2F, -1F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(leftarmlower, 0F, 0.2617994F, -0.2617994F);
		this.waist = new ModelRenderer(this, 32, 35);
		this.waist.addBox(-1F, 10F, 3F, 6, 4, 5);
		this.waist.setRotationPoint(-2F, -1F, -3.5F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0F, 0F, 0F);
		this.tail1 = new ModelRenderer(this, 32, 44);
		this.tail1.addBox(0F, 14F, -3F, 4, 4, 4);
		this.tail1.setRotationPoint(-2F, -1F, -3.5F);
		this.tail1.setTextureSize(64, 32);
		this.setRotation(tail1, 0.5235988F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 48, 44);
		this.tail2.addBox(0.5F, 17.5F, -4F, 3, 3, 3);
		this.tail2.setRotationPoint(-2F, -1F, -3.5F);
		this.tail2.setTextureSize(64, 32);
		this.setRotation(tail2, 0.6108652F, 0F, 0F);
		this.tail3 = new ModelRenderer(this, 32, 52);
		this.tail3.addBox(1F, 20F, -5F, 2, 6, 2);
		this.tail3.setRotationPoint(-2F, -1F, -3.5F);
		this.tail3.setTextureSize(64, 32);
		this.setRotation(tail3, 0.6981317F, 0F, 0F);
		this.tailend = new ModelRenderer(this, 40, 52);
		this.tailend.addBox(-3F, 22F, -4.5F, 10, 6, 1);
		this.tailend.setRotationPoint(-2F, -1F, -3.5F);
		this.tailend.setTextureSize(64, 32);
		this.setRotation(tailend, 0.6981317F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 100, 10);
		this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
		this.rightleg.setRotationPoint(-3.0F, 11.0F, 2.0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(this.rightleg, -0.5585054F, 0.0F, 0.0349066F);
		this.rightleglower = new ModelRenderer(this, 100, 21);
		this.rightleglower.addBox(-1.5F, 1.0F, -6.0F, 3, 3, 3);
		this.rightleglower.setRotationPoint(-3.0F, 13.0F, 2.0F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(this.rightleglower, 0.3490659F, 0.0F, 0.0349066F);
		this.rightfoot = new ModelRenderer(this, 100, 27);
		this.rightfoot.addBox(-2.0F, 4.0F, -3.0F, 4, 8, 4);
		this.rightfoot.setRotationPoint(-3.0F, 13.0F, 2.0F);
		this.rightfoot.setTextureSize(64, 32);
		this.setRotation(this.rightfoot, -0.1745329F, 0.0F, 0.0349066F);
		this.leftleg = new ModelRenderer(this, 100, 10);
		this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
		this.leftleg.setRotationPoint(3.0F, 11.0F, 2.0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(this.leftleg, -0.5759587F, 0.0F, -0.0349066F);
		this.leftleglower = new ModelRenderer(this, 100, 21);
		this.leftleglower.addBox(-1.5F, 1.0F, -6.0F, 3, 3, 3);
		this.leftleglower.setRotationPoint(3.0F, 13.0F, 2.0F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(this.leftleglower, 0.3490659F, 0.0F, -0.0349066F);
		this.leftfoot = new ModelRenderer(this, 100, 27);
		this.leftfoot.addBox(-2.0F, 4.0F, -3.0F, 4, 8, 4);
		this.leftfoot.setRotationPoint(3.0F, 13.0F, 2.0F);
		this.leftfoot.setTextureSize(64, 32);
		this.setRotation(this.leftfoot, -0.1745329F, 0.0F, -0.0349066F);
		
		this.convertToChild(head, headsnout);
		this.convertToChild(head, headjaw);
		this.convertToChild(rightarm, rightpauldron);
		this.convertToChild(rightarm, rightarmfin);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftpauldron);
		this.convertToChild(leftarm, leftarmfin);
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
//		this.headsnout.render(scale);
//		this.headjaw.render(scale);
		this.finback.render(scale);
		this.bodyback.render(scale);
		this.bodyfront.render(scale);
		this.bodymid.render(scale);
		this.rightarm.render(scale);
		this.leftarm.render(scale);
//		this.rightpauldron.render(scale);
//		this.rightarmfin.render(scale);
//		this.rightarmlower.render(scale);
//		this.leftpauldron.render(scale);
//		this.leftarmfin.render(scale);
//		this.leftarmlower.render(scale);
		this.waist.render(scale);
		this.tail1.render(scale);
		this.tail2.render(scale);
		this.tail3.render(scale);
		this.tailend.render(scale);
		this.rightleg.render(scale);
		this.rightleglower.render(scale);
		this.rightfoot.render(scale);
		this.leftleg.render(scale);
		this.leftleglower.render(scale);
		this.leftfoot.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.finback.rotateAngleY = this.head.rotateAngleY;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.2617994F;
        this.rightarm.rotateAngleX += (MathHelper.sin(ageInTicks * 0.067F) * 0.05F) + 0.5235988F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.2617994F;
        this.leftarm.rotateAngleX -= (MathHelper.sin(ageInTicks * 0.067F) * 0.05F) - 0.5235988F;
        
		//body
		this.tail1.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(2);
		this.tail2.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(4);
		this.tail3.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(6);
		this.tailend.rotateAngleY = this.tail3.rotateAngleY;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;
		this.rightleg.rotateAngleX -= 0.5585054F;
		this.leftleg.rotateAngleX -= 0.5585054F;
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
