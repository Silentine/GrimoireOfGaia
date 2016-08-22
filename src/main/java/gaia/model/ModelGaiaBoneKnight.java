package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaBoneKnight extends ModelBase {
	ModelRenderer head;
	ModelRenderer body;
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer chestlower;
	ModelRenderer rightshoulder;
	ModelRenderer leftshoulder;
	ModelRenderer rightgauntlet;
	ModelRenderer leftgauntlet;
	ModelRenderer chest;
	ModelRenderer waist;
	ModelRenderer waistlower;
	ModelRenderer shieldbracelet;
	ModelRenderer shield;
	ModelRenderer rightboot;
	ModelRenderer leftboot;

	public ModelGaiaBoneKnight() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4F, -8F, -4F, 8, 8, 8);
		this.head.setRotationPoint(0F, 0F, 0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.body = new ModelRenderer(this, 0, 16);
		this.body.addBox(-4F, 0F, -2F, 8, 12, 4);
		this.body.setRotationPoint(0F, 0F, 0F);
		this.body.setTextureSize(64, 32);
		this.setRotation(body, 0F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 24, 16);
		this.rightarm.addBox(-1F, -2F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-5F, 2F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 24, 16);
		this.leftarm.addBox(-1F, -2F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(5F, 2F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, -0.0872665F);
		this.rightleg = new ModelRenderer(this, 32, 16);
		this.rightleg.addBox(-1F, 0F, -1F, 2, 12, 2);
		this.rightleg.setRotationPoint(-2F, 12F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 32, 16);
		this.leftleg.addBox(-1F, 0F, -1F, 2, 12, 2);
		this.leftleg.setRotationPoint(2F, 12F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0F, 0F, 0F);
		this.chestlower = new ModelRenderer(this, 40, 20);
		this.chestlower.addBox(-3F, 3F, -4F, 6, 4, 4);
		this.chestlower.setRotationPoint(0F, 0F, 0F);
		this.chestlower.setTextureSize(64, 32);
		this.setRotation(chestlower, 0.1745329F, 0F, 0F);
		this.rightshoulder = new ModelRenderer(this, 40, 0);
		this.rightshoulder.addBox(-3F, -3F, -3F, 6, 6, 6);
		this.rightshoulder.setRotationPoint(-5F, 2F, 0F);
		this.rightshoulder.setTextureSize(64, 32);
		this.setRotation(rightshoulder, 0F, 0F, -0.1745329F);
		this.leftshoulder = new ModelRenderer(this, 64, 0);
		this.leftshoulder.addBox(-3F, -3F, -3F, 6, 6, 6);
		this.leftshoulder.setRotationPoint(5F, 2F, 0F);
		this.leftshoulder.setTextureSize(64, 32);
		this.setRotation(leftshoulder, 0F, 0F, 0.1745329F);
		this.rightgauntlet = new ModelRenderer(this, 40, 28);
		this.rightgauntlet.addBox(-2.5F, 4.5F, -1.5F, 3, 6, 3);
		this.rightgauntlet.setRotationPoint(-5F, 2F, 0F);
		this.rightgauntlet.setTextureSize(64, 32);
		this.setRotation(rightgauntlet, 0F, 0F, 0.0872665F);
		this.leftgauntlet = new ModelRenderer(this, 52, 28);
		this.leftgauntlet.addBox(-0.5F, 4.5F, -1.5F, 3, 6, 3);
		this.leftgauntlet.setRotationPoint(5F, 2F, 0F);
		this.leftgauntlet.setTextureSize(64, 32);
		this.setRotation(leftgauntlet, 0F, 0F, -0.0872665F);
		this.chest = new ModelRenderer(this, 40, 12);
		this.chest.addBox(-4F, 1F, -3F, 8, 4, 4);
		this.chest.setRotationPoint(0F, 0F, 0F);
		this.chest.setTextureSize(64, 32);
		this.setRotation(chest, -0.2617994F, 0F, 0F);
		this.waist = new ModelRenderer(this, 0, 32);
		this.waist.addBox(-4.5F, 10F, -2.5F, 9, 8, 5);
		this.waist.setRotationPoint(0F, 0F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0F, 0F, 0F);
		this.waistlower = new ModelRenderer(this, 0, 45);
		this.waistlower.addBox(-5F, 13F, -2F, 10, 6, 5);
		this.waistlower.setRotationPoint(0F, 0F, 0F);
		this.waistlower.setTextureSize(64, 32);
		this.setRotation(waistlower, 0F, 0F, 0F);
		this.shieldbracelet = new ModelRenderer(this, 88, 0);
		this.shieldbracelet.addBox(0.5F, 8.5F, -1.5F, 3, 1, 3);
		this.shieldbracelet.setRotationPoint(5F, 2F, 0F);
		this.shieldbracelet.setTextureSize(64, 32);
		this.setRotation(shieldbracelet, 0F, 0F, -0.0872665F);
		this.shield = new ModelRenderer(this, 88, 0);
		this.shield.addBox(3F, -1.5F, -6F, 1, 22, 12);
		this.shield.setRotationPoint(5F, 2F, 0F);
		this.shield.setTextureSize(64, 32);
		this.setRotation(shield, 0F, 0F, -0.0872665F);
		this.rightboot = new ModelRenderer(this, 40, 37);
		this.rightboot.addBox(-1.5F, 6F, -1.5F, 3, 6, 3);
		this.rightboot.setRotationPoint(-2F, 12F, 0F);
		this.rightboot.setTextureSize(64, 32);
		this.setRotation(rightboot, 0F, 0F, 0F);
		this.leftboot = new ModelRenderer(this, 40, 37);
		this.leftboot.addBox(-1.5F, 6F, -1.5F, 3, 6, 3);
		this.leftboot.setRotationPoint(2F, 12F, 0F);
		this.leftboot.setTextureSize(64, 32);
		this.setRotation(leftboot, 0F, 0F, 0F);
		
		this.convertToChild(rightarm, rightshoulder);
		this.convertToChild(leftarm, leftshoulder);
		this.convertToChild(rightarm, rightgauntlet);
		this.convertToChild(leftarm, leftgauntlet);
		this.convertToChild(leftarm, shieldbracelet);
		this.convertToChild(leftarm, shield);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.body.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
		this.chestlower.render(par7);
//		this.rightshoulder.render(par7);
//		this.leftshoulder.render(par7);
//		this.rightgauntlet.render(par7);
//		this.leftgauntlet.render(par7);
		this.chest.render(par7);
		this.waist.render(par7);
		this.waistlower.render(par7);
//		this.shieldbracelet.render(par7);
//		this.shield.render(par7);
		this.rightboot.render(par7);
		this.leftboot.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        float f6;
        float f7;

        if (this.swingProgress > -9990.0F) {
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
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.rightboot.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftboot.rotateAngleX = this.leftleg.rotateAngleX;
	}
	
	protected void convertToChild(ModelRenderer parParent, ModelRenderer parChild) {
		parChild.rotationPointX -= parParent.rotationPointX;
		parChild.rotationPointY -= parParent.rotationPointY;
		parChild.rotationPointZ -= parParent.rotationPointZ;
		parChild.rotateAngleX -= parParent.rotateAngleX;
		parChild.rotateAngleY -= parParent.rotateAngleY;
		parChild.rotateAngleZ -= parParent.rotateAngleZ;
		parParent.addChild(parChild);
	}
}
