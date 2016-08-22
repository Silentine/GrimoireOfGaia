package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMermaid extends ModelBase {
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
	ModelRenderer finright;
	ModelRenderer finleft;
	ModelRenderer hairclip;
	ModelRenderer rightpauldron;
	ModelRenderer headhelmet;
	ModelRenderer leftpauldron;
	ModelRenderer shieldbracelet;
	ModelRenderer shield;
	ModelRenderer waist;
	ModelRenderer fin1;
	ModelRenderer fin2;
	ModelRenderer fin3;
	ModelRenderer fin4;
	ModelRenderer fin5;
	ModelRenderer fin6;
	ModelRenderer fintail;

	public ModelGaiaMermaid() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		  
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 1F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, 1F);
		this.headeyes.setTextureSize(128, 64);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 1F);
		this.headaccessory.setTextureSize(128, 64);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, 1F);
		this.neck.setTextureSize(128, 64);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, 1F);
		this.bodytop.setTextureSize(128, 64);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 1F);
		this.bodymiddle.setTextureSize(128, 64);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 1F);
		this.bodymiddlebutton.setTextureSize(128, 64);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 1F);
		this.bodybottom.setTextureSize(128, 64);
		this.setRotation(bodybottom, 0F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -0.5F);
		this.rightchest.setTextureSize(128, 64);
		this.setRotation(rightchest, 0.6981317F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -0.5F);
		this.leftchest.setTextureSize(128, 64);
		this.setRotation(leftchest, 0.6981317F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 1F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, -0.0872665F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 1F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, -0.0872665F, 0F, -0.1745329F);
		this.hair1 = new ModelRenderer(this, 36, 14);
		this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		this.hair1.setRotationPoint(0F, 1F, 1F);
		this.hair1.setTextureSize(128, 64);
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 25);
		this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		this.hair2.setRotationPoint(0F, 1F, 1F);
		this.hair2.setTextureSize(128, 64);
		this.setRotation(hair2, 0F, 0F, 0F);
		this.finright = new ModelRenderer(this, 36, 38);
		this.finright.addBox(-4F, -6F, -1F, 0, 5, 3);
		this.finright.setRotationPoint(0F, 1F, 1F);
		this.finright.setTextureSize(128, 64);
		this.setRotation(finright, 0F, -0.5235988F, 0F);
		this.finleft = new ModelRenderer(this, 36, 38);
		this.finleft.addBox(4F, -6F, -1F, 0, 5, 3);
		this.finleft.setRotationPoint(0F, 1F, 1F);
		this.finleft.setTextureSize(128, 64);
		this.setRotation(finleft, 0F, 0.5235988F, 0F);
		this.hairclip = new ModelRenderer(this, 36, 37);
		this.hairclip.addBox(-1.5F, -6F, 3.5F, 3, 3, 1);
		this.hairclip.setRotationPoint(0F, 1F, 1F);
		this.hairclip.setTextureSize(128, 64);
		this.setRotation(hairclip, 0F, 0F, 0F);
		this.headhelmet = new ModelRenderer(this, 36, 46);
		this.headhelmet.addBox(-4F, -8.5F, -6.5F, 8, 8, 8);
		this.headhelmet.setRotationPoint(0F, 1F, 1F);
		this.headhelmet.setTextureSize(128, 64);
		this.setRotation(headhelmet, -0.5235988F, 0F, 0F);
		this.rightpauldron = new ModelRenderer(this, 68, 0);
		this.rightpauldron.addBox(-3F, -2F, -2F, 4, 3, 4);
		this.rightpauldron.setRotationPoint(-2.5F, 2.5F, 1F);
		this.rightpauldron.setTextureSize(128, 64);
		this.setRotation(rightpauldron, -0.0872665F, 0F, -0.3490659F);
		this.leftpauldron = new ModelRenderer(this, 84, 0);
		this.leftpauldron.addBox(-1F, -2F, -2F, 4, 3, 4);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, 1F);
		this.leftpauldron.setTextureSize(128, 64);
		this.setRotation(leftpauldron, -0.0872665F, 0F, 0.3490659F);
		this.shieldbracelet = new ModelRenderer(this, 68, 7);
		this.shieldbracelet.addBox(-0.5F, 8F, -1.5F, 3, 1, 3);
		this.shieldbracelet.setRotationPoint(2.5F, 2.5F, 1F);
		this.shieldbracelet.setTextureSize(128, 64);
		this.setRotation(shieldbracelet, -0.0872665F, 0F, -0.1745329F);
		this.shield = new ModelRenderer(this, 68, 7);
		this.shield.addBox(2.5F, -2F, -6F, 1, 22, 12);
		this.shield.setRotationPoint(2.5F, 2.5F, 1F);
		this.shield.setTextureSize(128, 64);
		this.setRotation(shield, -0.0872665F, 0F, -0.1745329F);
		this.waist = new ModelRenderer(this, 68, 41);
		this.waist.addBox(-4F, 8F, -3F, 8, 8, 5);
		this.waist.setRotationPoint(0F, 1F, 1F);
		this.waist.setTextureSize(128, 64);
		this.setRotation(waist, 0F, 0F, 0F);
		this.fin1 = new ModelRenderer(this, 100, 0);
		this.fin1.addBox(-3.5F, -1F, -2F, 7, 4, 4);
		this.fin1.setRotationPoint(0F, 11F, 0.5F);
		this.fin1.setTextureSize(128, 64);
		this.setRotation(fin1, 0F, 0F, 0F);
		this.fin2 = new ModelRenderer(this, 100, 8);
		this.fin2.addBox(-2.5F, 2F, -2.5F, 5, 4, 3);
		this.fin2.setRotationPoint(0F, 11F, 1F);
		this.fin2.setTextureSize(128, 64);
		this.setRotation(fin2, 0.0872665F, 0F, 0F);
		this.fin3 = new ModelRenderer(this, 100, 15);
		this.fin3.addBox(-2F, 5F, -2F, 4, 4, 3);
		this.fin3.setRotationPoint(0F, 11F, 1F);
		this.fin3.setTextureSize(128, 64);
		this.setRotation(fin3, 0.1308997F, 0F, 0F);
		this.fin4 = new ModelRenderer(this, 100, 22);
		this.fin4.addBox(-2F, 7F, -1F, 4, 4, 3);
		this.fin4.setRotationPoint(0F, 11F, 1F);
		this.fin4.setTextureSize(128, 64);
		this.setRotation(fin4, 0.1308997F, 0F, 0F);
		this.fin5 = new ModelRenderer(this, 100, 29);
		this.fin5.addBox(-1.5F, 9F, 0F, 3, 3, 3);
		this.fin5.setRotationPoint(0F, 11F, 1F);
		this.fin5.setTextureSize(128, 64);
		this.setRotation(fin5, 0.1745329F, 0F, 0F);
		this.fin6 = new ModelRenderer(this, 100, 36);
		this.fin6.addBox(-0.5F, 11F, 1F, 1, 2, 3);
		this.fin6.setRotationPoint(0F, 11F, 1F);
		this.fin6.setTextureSize(128, 64);
		this.setRotation(fin6, 0.1745329F, 0F, 0F);
		this.fintail = new ModelRenderer(this, 100, 41);
		this.fintail.addBox(-3F, 5F, -12F, 7, 7, 0);
		this.fintail.setRotationPoint(-0.5F, 11F, 1F);
		this.fintail.setTextureSize(128, 64);
		this.setRotation(fintail, 1.570796F, 0F, 0F);
		
		this.convertToChild(head, finright);
		this.convertToChild(head, finleft);
		this.convertToChild(head, hairclip);
		this.convertToChild(head, headhelmet);
		this.convertToChild(rightarm, rightpauldron);
		this.convertToChild(leftarm, leftpauldron);
		this.convertToChild(leftarm, shieldbracelet);
		this.convertToChild(leftarm, shield);
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
//		this.finright.render(par7);
//		this.finleft.render(par7);
//		this.hairclip.render(par7);
//		this.headhelmet.render(par7);
//		this.rightpauldron.render(par7);
//		this.leftpauldron.render(par7);
//		this.shieldbracelet.render(par7);
//		this.shield.render(par7);
		this.waist.render(par7);
		this.fin1.render(par7);
		this.fin2.render(par7);
		this.fin3.render(par7);
		this.fin4.render(par7);
		this.fin5.render(par7);
		this.fin6.render(par7);
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
		this.hair1.rotateAngleY = this.head.rotateAngleY;
		this.hair2.rotateAngleY = this.head.rotateAngleY;
		
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
		this.fin1.rotateAngleY = MathHelper.cos(par1 * 0.6162F) * 0.1F * par2;
		this.fin2.rotateAngleY = MathHelper.cos(par1 * 0.6262F) * 0.1F * par2;
		this.fin3.rotateAngleY = MathHelper.cos(par1 * 0.6362F) * 0.1F * par2;
		this.fin4.rotateAngleY = MathHelper.cos(par1 * 0.6362F) * 0.1F * par2;
		this.fintail.rotateAngleY = this.fin4.rotateAngleY;
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
