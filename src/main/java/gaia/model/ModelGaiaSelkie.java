package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSelkie extends ModelBase {
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
	ModelRenderer leftarm;
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer hat1;
	ModelRenderer hat2;
	ModelRenderer righthatear;
	ModelRenderer lefthatear;
	ModelRenderer chestpiece;
	ModelRenderer rightarmguard;
	ModelRenderer waist;
	ModelRenderer zip;
	ModelRenderer fin1;
	ModelRenderer fin2;
	ModelRenderer fin3;
	ModelRenderer fin4;
	ModelRenderer fintail;

	public ModelGaiaSelkie() {
		this.textureWidth = 128;
		this.textureHeight = 64;
	    
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, 0F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, 0F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(64, 32);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(64, 32);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, -0.1745329F);
		this.hair1 = new ModelRenderer(this, 36, 14);
		this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		this.hair1.setRotationPoint(0F, 1F, 0F);
		this.hair1.setTextureSize(64, 32);
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 25);
		this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		this.hair2.setRotationPoint(0F, 1F, 0F);
		this.hair2.setTextureSize(64, 32);
		this.setRotation(hair2, 0F, 0F, 0F);
		this.hat1 = new ModelRenderer(this, 64, 0);
		this.hat1.addBox(-4F, -7.5F, -5F, 8, 3, 8);
		this.hat1.setRotationPoint(0F, 1F, 0F);
		this.hat1.setTextureSize(64, 32);
		this.setRotation(hat1, -0.1745329F, 0F, 0F);
		this.hat2 = new ModelRenderer(this, 64, 11);
		this.hat2.addBox(-3F, -8.5F, -4F, 6, 1, 6);
		this.hat2.setRotationPoint(0F, 1F, 0F);
		this.hat2.setTextureSize(64, 32);
		this.setRotation(hat2, -0.1745329F, 0F, 0F);
		this.righthatear = new ModelRenderer(this, 64, 10);
		this.righthatear.addBox(-5F, -6F, -4F, 0, 18, 8);
		this.righthatear.setRotationPoint(0F, 1F, 0F);
		this.righthatear.setTextureSize(64, 32);
		this.setRotation(righthatear, 0F, 0F, 0.1745329F);
		this.lefthatear = new ModelRenderer(this, 64, 10);
		this.lefthatear.addBox(5F, -6F, -4F, 0, 18, 8);
		this.lefthatear.setRotationPoint(0F, 1F, 0F);
		this.lefthatear.setTextureSize(64, 32);
		this.setRotation(lefthatear, 0F, 0F, -0.1745329F);
		this.chestpiece = new ModelRenderer(this, 64, 36);
		this.chestpiece.addBox(-4F, -2F, -1F, 8, 6, 2);
		this.chestpiece.setRotationPoint(0F, 1F, 0F);
		this.chestpiece.setTextureSize(64, 32);
		this.setRotation(chestpiece, -0.7853982F, 0F, 0F);
		this.rightarmguard = new ModelRenderer(this, 64, 44);
		this.rightarmguard.addBox(-2.5F, 5F, -1.5F, 3, 4, 3);
		this.rightarmguard.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmguard.setTextureSize(64, 32);
		this.setRotation(rightarmguard, 0F, 0F, 0.1745329F);

		this.waist = new ModelRenderer(this, 96, 0);
		this.waist.addBox(-4F, 7.5F, -3F, 8, 3, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		this.zip = new ModelRenderer(this, 96, 7);
		this.zip.addBox(-1F, 0F, -3.5F, 2, 3, 1);
		this.zip.setRotationPoint(0F, 11F, 0F);
		this.zip.setTextureSize(64, 32);
		this.setRotation(zip, -0.6108652F, 0F, 0F);
		this.fin1 = new ModelRenderer(this, 96, 11);
		this.fin1.addBox(-3.5F, -1F, -3F, 7, 6, 6);
		this.fin1.setRotationPoint(0F, 11F, 0F);
		this.fin1.setTextureSize(64, 32);
		this.setRotation(fin1, -0.2617994F, 0F, 0F);
		this.fin2 = new ModelRenderer(this, 96, 23);
		this.fin2.addBox(-3F, 4F, -3.5F, 6, 5, 5);
		this.fin2.setRotationPoint(0F, 11F, 0F);
		this.fin2.setTextureSize(64, 32);
		this.setRotation(fin2, -0.0872665F, 0F, 0F);
		this.fin3 = new ModelRenderer(this, 96, 33);
		this.fin3.addBox(-2.5F, 7F, -6F, 5, 4, 4);
		this.fin3.setRotationPoint(0F, 11F, 0F);
		this.fin3.setTextureSize(64, 32);
		this.setRotation(fin3, 0.2617994F, 0F, 0F);
		this.fin4 = new ModelRenderer(this, 96, 41);
		this.fin4.addBox(-2F, 8F, -9F, 4, 3, 3);
		this.fin4.setRotationPoint(0F, 11F, 0F);
		this.fin4.setTextureSize(64, 32);
		this.setRotation(fin4, 0.6108652F, 0F, 0F);
		this.fintail = new ModelRenderer(this, 96, 47);
		this.fintail.addBox(-4F, 12F, 1F, 8, 1, 4);
		this.fintail.setRotationPoint(0F, 11F, 0F);
		this.fintail.setTextureSize(64, 32);
		this.setRotation(fintail, -0.0872665F, 0F, 0F);
		
		this.convertToChild(head, hat1);
		this.convertToChild(head, hat2);
		this.convertToChild(rightarm, rightarmguard);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.neck.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.hair1.render(par7);
		this.hair2.render(par7);
//		this.hat1.render(par7);
//		this.hat2.render(par7);
		this.righthatear.render(par7);
		this.lefthatear.render(par7);
		this.chestpiece.render(par7);
//		this.rightarmguard.render(par7);
		this.waist.render(par7);
		this.zip.render(par7);
		this.fin1.render(par7);
		this.fin2.render(par7);
		this.fin3.render(par7);
		this.fin4.render(par7);
		this.fintail.render(par7);

		if (entity.ticksExisted % 60 == 0 && par3 <= 0.1F) {
			this.headeyes.render(par7);
		} 
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
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.righthatear.rotateAngleY = this.head.rotateAngleY;
		this.lefthatear.rotateAngleY = this.head.rotateAngleY;
		this.hair1.rotateAngleY = this.head.rotateAngleY;
		this.hair2.rotateAngleY = (this.head.rotateAngleY) * 0.75F;
		
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
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
        
		//legs
		this.waist.rotateAngleZ = MathHelper.cos(par1 * 0.6162F) * 0.05F * par2;
		this.zip.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.fin1.rotateAngleZ = MathHelper.cos(par1 * 0.6162F) * 0.05F * par2;
		this.fin2.rotateAngleZ = MathHelper.cos(par1 * 0.6262F) * 0.05F * par2;
		this.fin3.rotateAngleZ = MathHelper.cos(par1 * 0.6362F) * 0.05F * par2;
		this.fin4.rotateAngleZ = MathHelper.cos(par1 * 0.6462F) * 0.05F * par2;
		this.fintail.rotateAngleZ = MathHelper.cos(par1 * 0.6562F) * 0.05F * par2;
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
