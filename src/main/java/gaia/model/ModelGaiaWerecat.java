package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaWerecat extends ModelBase {
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
	public static ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer leash;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer righthand;
	ModelRenderer lefthand;
	ModelRenderer waist;
    ModelRenderer tail1;
    ModelRenderer tail2;
	ModelRenderer chain;
	ModelRenderer rightfoot;
	ModelRenderer leftfoot;
	ModelRenderer rightfootlower;
	ModelRenderer leftfootlower;

	public ModelGaiaWerecat() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, -2.5F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, -2.5F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, -2.5F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, -2.5F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, -3F);
		this.bodytop.setTextureSize(64, 32);
		this.setRotation(bodytop, 0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, -3F);
		this.bodymiddle.setTextureSize(64, 32);
		this.setRotation(bodymiddle, 0.2617994F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 5.8F, -2.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, -2F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.setRotation(bodymiddlebutton, 0.2617994F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, -3F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.3490659F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -4F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.9599311F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -4F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.9599311F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 8, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, -2.5F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, -0.1745329F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 36);
		this.leftarm.addBox(0F, -1F, -1F, 2, 8, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, -2.5F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, -0.1745329F, 0F, -0.1745329F);
		this.rightleg = new ModelRenderer(this, 88, 0);
		this.rightleg.addBox(-1.5F, -2F, -2F, 3, 8, 3);
		this.rightleg.setRotationPoint(-2.5F, 12F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, -0.4363323F, -0.0872665F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 88, 0);
		this.leftleg.addBox(-1.5F, -2F, -2F, 3, 8, 3);
		this.leftleg.setRotationPoint(2.5F, 12F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, -0.4363323F, 0.0872665F, 0.0349066F);
		this.rightear = new ModelRenderer(this, 36, 14);
		this.rightear.addBox(-4.5F, -10F, -1.5F, 4, 4, 3);
		this.rightear.setRotationPoint(0F, 1F, -2.5F);
		this.rightear.setTextureSize(64, 32);
		this.setRotation(rightear, 0F, 0F, 0F);
		this.leftear = new ModelRenderer(this, 50, 14);
		this.leftear.addBox(0.5F, -10F, -1.5F, 4, 4, 3);
		this.leftear.setRotationPoint(0F, 1F, -2.5F);
		this.leftear.setTextureSize(64, 32);
		this.setRotation(leftear, 0F, 0F, 0F);
		this.leash = new ModelRenderer(this, 36, 21);
		this.leash.addBox(-2F, -0.5F, -2F, 4, 1, 4);
		this.leash.setRotationPoint(0F, 1F, -2.5F);
		this.leash.setTextureSize(64, 32);
		this.setRotation(leash, 0.2617994F, 0F, 0F);
		this.rightarmlower = new ModelRenderer(this, 64, 0);
		this.rightarmlower.addBox(-2.5F, 2F, -1.5F, 2, 8, 3);
		this.rightarmlower.setRotationPoint(-2.5F, 2.5F, -2.5F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(rightarmlower, -0.1745329F, 0F, 0.1745329F);
		this.leftarmlower = new ModelRenderer(this, 74, 0);
		this.leftarmlower.addBox(0.5F, 2F, -1.5F, 2, 8, 3);
		this.leftarmlower.setRotationPoint(2.5F, 2.5F, -2.5F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(leftarmlower, -0.1745329F, 0F, -0.1745329F);
		this.righthand = new ModelRenderer(this, 64, 11);
		this.righthand.addBox(-2.5F, 8F, -2F, 2, 4, 4);
		this.righthand.setRotationPoint(-2.5F, 2.5F, -2.5F);
		this.righthand.setTextureSize(64, 32);
		this.setRotation(righthand, -0.1745329F, 0F, 0.0872665F);
		this.lefthand = new ModelRenderer(this, 76, 11);
		this.lefthand.addBox(0.5F, 8F, -2F, 2, 4, 4);
		this.lefthand.setRotationPoint(2.5F, 2.5F, -2.5F);
		this.lefthand.setTextureSize(64, 32);
		this.setRotation(lefthand, -0.1745329F, 0F, -0.0872665F);
		this.waist = new ModelRenderer(this, 64, 19);
		this.waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		this.waist.setRotationPoint(0F, 1F, -3F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0.3490659F, 0F, 0F);
		this.tail1 = new ModelRenderer(this, 64, 27);
		this.tail1.addBox(-1F, 7F, -3.5F, 2, 5, 2);
		this.tail1.setRotationPoint(0F, 1F, -2F);
		this.tail1.setTextureSize(64, 32);
		this.setRotation(tail1, 0.6108652F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 64, 34);
		this.tail2.addBox(-1.5F, 11F, -5F, 3, 8, 3);
		this.tail2.setRotationPoint(0F, 1F, -2F);
		this.tail2.setTextureSize(64, 32);
		this.setRotation(tail2, 0.6981317F, 0F, 0F);
		this.chain = new ModelRenderer(this, 36, 21);
		this.chain.addBox(-1.5F, 2.5F, -2.5F, 4, 1, 4);
		this.chain.setRotationPoint(2F, 12F, 0F);
		this.chain.setTextureSize(64, 32);
		this.setRotation(chain, -0.4363323F, 0.0872665F, 0.0349066F);
		this.rightfoot = new ModelRenderer(this, 88, 11);
		this.rightfoot.addBox(-1.5F, 3.5F, 1F, 3, 8, 2);
		this.rightfoot.setRotationPoint(-2.5F, 12F, 0F);
		this.rightfoot.setTextureSize(64, 32);
		this.setRotation(rightfoot, -0.4363323F, -0.0872665F, -0.0349066F);
		this.leftfoot = new ModelRenderer(this, 88, 11);
		this.leftfoot.addBox(-1.5F, 3.5F, 1F, 3, 8, 2);
		this.leftfoot.setRotationPoint(2.5F, 12F, 0F);
		this.leftfoot.setTextureSize(64, 32);
		this.setRotation(leftfoot, -0.4363323F, 0.0872665F, 0.0349066F);
		this.rightfootlower = new ModelRenderer(this, 88, 21);
		this.rightfootlower.addBox(-1.5F, 10F, -7F, 3, 1, 3);
		this.rightfootlower.setRotationPoint(-2.5F, 12F, 0F);
		this.rightfootlower.setTextureSize(64, 32);
		this.setRotation(rightfootlower, 0.1745329F, -0.0872665F, -0.0349066F);
		this.leftfootlower = new ModelRenderer(this, 88, 21);
		this.leftfootlower.addBox(-1.5F, 10F, -7F, 3, 1, 3);
		this.leftfootlower.setRotationPoint(2.5F, 12F, 0F);
		this.leftfootlower.setTextureSize(64, 32);
		this.setRotation(leftfootlower, 0.1745329F, 0.0872665F, 0.0349066F);
		
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(rightarm, righthand);
		this.convertToChild(leftarm, lefthand);
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
		this.rightleg.render(par7);
		this.leftleg.render(par7);
//		this.rightear.render(par7);
//		this.leftear.render(par7);
		this.leash.render(par7);
//		this.rightarmlower.render(par7);
//		this.leftarmlower.render(par7);
//		this.righthand.render(par7);
//		this.lefthand.render(par7);
		this.waist.render(par7);
		this.tail1.render(par7);
		this.tail2.render(par7);
		this.chain.render(par7);
		this.rightfoot.render(par7);
		this.leftfoot.render(par7);
		this.rightfootlower.render(par7);
		this.leftfootlower.render(par7);

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
            
            //right arm
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
            
            //left arm
            this.leftarm.rotateAngleX = (float)((double)this.leftarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
            this.leftarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.leftarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
		
		//body
		this.tail1.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.tail2.rotateAngleY = this.tail1.rotateAngleY;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.chain.rotateAngleX = this.leftleg.rotateAngleX - 0.4363323F;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX - 0.4363323F;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX - 0.4363323F;
		this.rightfootlower.rotateAngleX = this.rightleg.rotateAngleX + 0.1745329F;
		this.leftfootlower.rotateAngleX = this.leftleg.rotateAngleX + 0.1745329F;
		
		this.rightleg.rotateAngleX -= 0.4363323F;
		this.leftleg.rotateAngleX -= 0.4363323F;
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
