package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaDullahan extends ModelBase {
	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodybottom;
	ModelRenderer bodymiddlebutton;
	ModelRenderer rightshoulder;
	ModelRenderer rightarm;
	public static ModelRenderer rightgauntlet;
	ModelRenderer leftshoulder;
	ModelRenderer leftarm;
	ModelRenderer leftarmlower;
	ModelRenderer leftgauntlet;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer waist;
	ModelRenderer waistlower;
	ModelRenderer rightleg;
	ModelRenderer rightboot;
	ModelRenderer leftleg;
	ModelRenderer leftboot;

	public ModelGaiaDullahan() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -3F, -3F, 6, 6, 6);
		this.head.setRotationPoint(4F, 3F, -6F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(head, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -3.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(4F, 3F, -6F);
		this.headaccessory.setTextureSize(64, 32);
		this.headaccessory.mirror = true;
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 12);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 5, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(64, 32);
		this.bodytop.mirror = true;
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 20);
		this.bodymiddle.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(64, 32);
		this.bodymiddle.mirror = true;
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 25);
		this.bodybottom.addBox(-2.5F, 7F, -2.5F, 5, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.bodybottom.mirror = true;
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 20);
		this.bodymiddlebutton.addBox(-0.5F, 5F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.bodymiddlebutton.mirror = true;
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.rightshoulder = new ModelRenderer(this, 36, 14);
		this.rightshoulder.addBox(-3.5F, -3F, -2F, 4, 5, 4);
		this.rightshoulder.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightshoulder.setTextureSize(64, 32);
		this.rightshoulder.mirror = true;
		this.setRotation(rightshoulder, 0F, 0F, -0.1745329F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0F, 0F, 0.0872665F);
		this.rightgauntlet = new ModelRenderer(this, 36, 30);
		this.rightgauntlet.addBox(-2.5F, 5.5F, -1.5F, 2, 5, 3);
		this.rightgauntlet.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightgauntlet.setTextureSize(64, 32);
		this.rightgauntlet.mirror = true;
		this.setRotation(rightgauntlet, 0F, 0F, 0.0872665F);
		this.leftshoulder = new ModelRenderer(this, 52, 14);
		this.leftshoulder.addBox(-0.5F, -3F, -2F, 4, 5, 4);
		this.leftshoulder.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftshoulder.setTextureSize(64, 32);
		this.leftshoulder.mirror = true;
		this.setRotation(leftshoulder, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 5, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0F, 0F, -0.0872665F);
		this.leftarmlower = new ModelRenderer(this, 36, 23);
		this.leftarmlower.addBox(0F, 0F, 3F, 2, 5, 2);
		this.leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmlower.setTextureSize(64, 32);
		this.leftarmlower.mirror = true;
		this.setRotation(leftarmlower, -1.570796F, 0F, -0.0872665F);
		this.leftgauntlet = new ModelRenderer(this, 46, 30);
		this.leftgauntlet.addBox(-0.5F, 1.5F, 3.5F, 3, 5, 2);
		this.leftgauntlet.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftgauntlet.setTextureSize(64, 32);
		this.leftgauntlet.mirror = true;
		this.setRotation(leftgauntlet, -1.570796F, 0F, -0.0872665F);
		this.rightchest = new ModelRenderer(this, 0, 31);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.25F, 3F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.rightchest.mirror = true;
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0F);
		this.leftchest = new ModelRenderer(this, 8, 31);
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.leftchest.setTextureSize(64, 32);
		this.leftchest.mirror = true;
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, 0F);
		this.waist = new ModelRenderer(this, 68, 0);
		this.waist.addBox(-3F, 9F, -2F, 6, 6, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.waist.mirror = true;
		this.setRotation(waist, 0F, 0F, 0F);
		this.waistlower = new ModelRenderer(this, 68, 10);
		this.waistlower.addBox(-3.5F, 9.5F, -1.5F, 7, 7, 4);
		this.waistlower.setRotationPoint(0F, 1F, 0F);
		this.waistlower.setTextureSize(64, 32);
		this.waistlower.mirror = true;
		this.setRotation(waistlower, 0F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1F, 0F, -1F, 2, 13, 2);
		this.rightleg.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, 0F, 0F, 0F);
		this.rightboot = new ModelRenderer(this, 68, 21);
		this.rightboot.addBox(-1.5F, 6F, -1.5F, 3, 7, 3);
		this.rightboot.setRotationPoint(-1.5F, 11F, 0F);
		this.rightboot.setTextureSize(64, 32);
		this.rightboot.mirror = true;
		this.setRotation(rightboot, 0F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1F, 0F, -1F, 2, 13, 2);
		this.leftleg.setRotationPoint(1.5F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, 0F, 0F, 0F);
		this.leftboot = new ModelRenderer(this, 68, 21);
		this.leftboot.addBox(-1.5F, 6F, -1.5F, 3, 7, 3);
		this.leftboot.setRotationPoint(1.5F, 11F, 0F);
		this.leftboot.setTextureSize(64, 32);
		this.leftboot.mirror = true;
		this.setRotation(leftboot, 0F, 0F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodybottom.render(par7);
		this.bodymiddlebutton.render(par7);
		this.rightshoulder.render(par7);
		this.rightarm.render(par7);
		this.rightgauntlet.render(par7);
		this.leftshoulder.render(par7);
		this.leftarm.render(par7);
		this.leftarmlower.render(par7);
		this.leftgauntlet.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
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
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.rightshoulder.rotateAngleX = this.rightarm.rotateAngleX;
		this.rightgauntlet.rotateAngleX = this.rightarm.rotateAngleX;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.rightboot.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.leftboot.rotateAngleX = this.leftleg.rotateAngleX;
		
        float f6;
        float f7;

        if (this.onGround > -9990.0F)
        {
            f6 = this.onGround;
            f6 = 1.0F - this.onGround;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            f7 = MathHelper.sin(f6 * (float)Math.PI);
            float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
    		this.rightshoulder.rotateAngleX = this.rightarm.rotateAngleX;
    		this.rightgauntlet.rotateAngleX = this.rightarm.rotateAngleX;
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
    		this.rightshoulder.rotateAngleY = this.rightarm.rotateAngleY;
    		this.rightgauntlet.rotateAngleY = this.rightarm.rotateAngleY;
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F);
    		this.rightshoulder.rotateAngleZ = this.rightarm.rotateAngleZ;
    		this.rightgauntlet.rotateAngleZ = this.rightarm.rotateAngleZ;
    		this.rightarm.rotateAngleZ = this.rightarm.rotateAngleZ - 0.1745329F;
        }
	}
}
