package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaBoneKnight extends ModelBase {
	ModelRenderer head;
	ModelRenderer rightshoulder;
	ModelRenderer rightarm;
	public static ModelRenderer rightgauntlet;
	ModelRenderer leftshoulder;
	ModelRenderer leftarm;
	ModelRenderer leftgauntlet;
	ModelRenderer leftshield;
	ModelRenderer body;
	ModelRenderer chest;
	ModelRenderer chestlower;
	ModelRenderer waist;
	ModelRenderer waistlower;
	ModelRenderer rightleg;
	ModelRenderer rightboot;
	ModelRenderer leftleg;
	ModelRenderer leftboot;

	public ModelGaiaBoneKnight() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.rightshoulder = new ModelRenderer(this, 24, 30);
		this.rightshoulder.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
		this.rightshoulder.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.rightshoulder.setTextureSize(64, 32);
		this.rightshoulder.mirror = true;
		this.setRotation(this.rightshoulder, 0.0F, 0.0F, -0.1745329F);
		this.rightarm = new ModelRenderer(this, 24, 16);
		this.rightarm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2);
		this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0872665F);
		this.rightgauntlet = new ModelRenderer(this, 48, 30);
		this.rightgauntlet.addBox(-2.5F, 4.5F, -1.5F, 3, 6, 3);
		this.rightgauntlet.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.rightgauntlet.setTextureSize(64, 32);
		this.rightgauntlet.mirror = true;
		this.setRotation(rightgauntlet, 0.0F, 0.0F, 0.0872665F);
		this.leftshoulder = new ModelRenderer(this, 24, 42);
		this.leftshoulder.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
		this.leftshoulder.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.leftshoulder.setTextureSize(64, 32);
		this.leftshoulder.mirror = true;
		this.setRotation(this.leftshoulder, 0.0F, 0.0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 24, 16);
		this.leftarm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2);
		this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(this.leftarm, 0.0F, 0.0F, -0.0872665F);
		this.leftgauntlet = new ModelRenderer(this, 48, 42);
		this.leftgauntlet.addBox(-0.5F, 4.5F, -1.5F, 3, 6, 3);
		this.leftgauntlet.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.leftgauntlet.setTextureSize(64, 32);
		this.leftgauntlet.mirror = true;
		this.setRotation(this.leftgauntlet, 0.0F, 0.0F, -0.0872665F);
		this.leftshield = new ModelRenderer(this, 40, 0);
		this.leftshield.addBox(1.0F, -2.5F, -4.0F, 4, 16, 8);
		this.leftshield.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.leftshield.setTextureSize(64, 32);
		this.leftshield.mirror = true;
		this.setRotation(this.leftshield, 0.0F, 0.0F, 0.0872665F);
		this.body = new ModelRenderer(this, 0, 16);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.setTextureSize(64, 32);
		this.body.mirror = true;
		this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
		this.chest = new ModelRenderer(this, 0, 32);
		this.chest.addBox(-4.0F, 1.0F, -3.0F, 8, 4, 4);
		this.chest.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.chest.setTextureSize(64, 32);
		this.chest.mirror = true;
		this.setRotation(this.chest, -0.2617994F, 0.0F, 0.0F);
		this.chestlower = new ModelRenderer(this, 0, 40);
		this.chestlower.addBox(-3.0F, 3.0F, -4.0F, 6, 4, 4);
		this.chestlower.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.chestlower.setTextureSize(64, 32);
		this.chestlower.mirror = true;
		this.setRotation(this.chestlower, 0.1745329F, 0.0F, 0.0F);
		this.waist = new ModelRenderer(this, 60, 30);
		this.waist.addBox(-4.5F, 10.0F, -2.5F, 9, 8, 5);
		this.waist.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.waist.setTextureSize(64, 32);
		this.waist.mirror = true;
		this.setRotation(this.waist, 0.0F, 0.0F, 0.0F);
		this.waistlower = new ModelRenderer(this, 60, 43);
		this.waistlower.addBox(-5.0F, 13.0F, -2.0F, 10, 6, 5);
		this.waistlower.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.waistlower.setTextureSize(64, 32);
		this.waistlower.mirror = true;
		this.setRotation(this.waistlower, 0.0F, 0.0F, 0.0F);
		this.rightleg = new ModelRenderer(this, 32, 16);
		this.rightleg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
		this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
		this.rightboot = new ModelRenderer(this, 60, 54);
		this.rightboot.addBox(-1.5F, 6.0F, -1.5F, 3, 6, 3);
		this.rightboot.setRotationPoint(-2.0F, 12.0F, 0.0F);
		this.rightboot.setTextureSize(64, 32);
		this.rightboot.mirror = true;
		this.setRotation(this.rightboot, 0.0F, 0.0F, 0.0F);
		this.leftleg = new ModelRenderer(this, 32, 16);
		this.leftleg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2);
		this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
		this.leftboot = new ModelRenderer(this, 60, 54);
		this.leftboot.addBox(-1.5F, 6.0F, -1.5F, 3, 6, 3);
		this.leftboot.setRotationPoint(2.0F, 12.0F, 0.0F);
		this.leftboot.setTextureSize(64, 32);
		this.leftboot.mirror = true;
		this.setRotation(this.leftboot, 0.0F, 0.0F, 0.0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.rightshoulder.render(par7);
		this.rightarm.render(par7);
		this.rightgauntlet.render(par7);
		this.leftshoulder.render(par7);
		this.body.render(par7);
		this.chest.render(par7);
		this.chestlower.render(par7);
		this.leftarm.render(par7);
		this.leftgauntlet.render(par7);
		this.leftshield.render(par7);
		this.waist.render(par7);
		this.waistlower.render(par7);
		this.rightleg.render(par7);
		this.rightboot.render(par7);
		this.leftleg.render(par7);
		this.leftboot.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.rightshoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.rightarm.rotateAngleX = this.rightshoulder.rotateAngleX;
		this.rightgauntlet.rotateAngleX = this.rightshoulder.rotateAngleX;
		this.leftshoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = this.leftshoulder.rotateAngleX;
		this.leftgauntlet.rotateAngleX = this.leftshoulder.rotateAngleX;
		this.leftshield.rotateAngleX = this.leftshoulder.rotateAngleX;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.rightboot.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftboot.rotateAngleX = this.leftleg.rotateAngleX;
		
        float f6;
        float f7;

        if (this.swingProgress > -9990.0F)
        {
            f6 = this.swingProgress;
            f6 = 1.0F - this.swingProgress;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            f7 = MathHelper.sin(f6 * (float)Math.PI);
            float f8 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            
            this.rightshoulder.rotateAngleX = (float)((double)this.rightshoulder.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
            this.rightarm.rotateAngleX = this.rightshoulder.rotateAngleX;
            this.rightgauntlet.rotateAngleX = this.rightshoulder.rotateAngleX;
            this.rightshoulder.rotateAngleX += (this.body.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleY = this.rightshoulder.rotateAngleY;
            this.rightgauntlet.rotateAngleY = this.rightshoulder.rotateAngleY;
            this.rightshoulder.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
            this.rightarm.rotateAngleZ = this.rightshoulder.rotateAngleZ + 0.0872665F;
            this.rightgauntlet.rotateAngleZ = this.rightshoulder.rotateAngleZ + 0.0872665F;
            this.rightshoulder.rotateAngleZ = this.rightshoulder.rotateAngleZ - 0.1745329F; 
        }
	}
}
