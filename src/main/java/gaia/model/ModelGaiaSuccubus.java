package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSuccubus extends ModelBase {
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
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer horn3;
	ModelRenderer rightpauldron;
	ModelRenderer leftpauldron;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer tail;
	ModelRenderer waist;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer rightfoot;
	ModelRenderer leftfoot;
	ModelRenderer rightwing;
	ModelRenderer leftwing;

	public ModelGaiaSuccubus() {
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
		this.bodybottom.addBox(-3F, 7F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 2F, 0F);
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
		this.setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0.0872665F, 0F, -0.1745329F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		this.rightleg.setRotationPoint(-2F, 11F, -0.5F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, -0.1745329F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		this.leftleg.setRotationPoint(2F, 11F, -0.5F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, -0.1745329F, 0F, 0F);
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
		this.horn1 = new ModelRenderer(this, 36, 37);
		this.horn1.addBox(-3F, -7F, -4F, 6, 2, 2);
		this.horn1.setRotationPoint(0F, 1F, 0F);
		this.horn1.setTextureSize(64, 32);
		this.setRotation(horn1, 0F, 0F, 0F);
		this.horn2 = new ModelRenderer(this, 36, 41);
		this.horn2.addBox(-3.5F, -7.5F, -3F, 7, 2, 6);
		this.horn2.setRotationPoint(0F, 1F, 0F);
		this.horn2.setTextureSize(64, 32);
		this.setRotation(horn2, 0F, 0F, 0F);
		this.horn3 = new ModelRenderer(this, 36, 49);
		this.horn3.addBox(-4F, -8F, -2F, 8, 2, 4);
		this.horn3.setRotationPoint(0F, 1F, 0F);
		this.horn3.setTextureSize(64, 32);
		this.setRotation(horn3, 0F, 0F, 0F);
		this.rightpauldron = new ModelRenderer(this, 64, 0);
		this.rightpauldron.addBox(-2.5F, -2F, -1.5F, 3, 3, 3);
		this.rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightpauldron.setTextureSize(64, 32);
		this.setRotation(rightpauldron, 0.0872665F, 0F, 0.1745329F);
		convertToChild(rightarm, rightpauldron);
		this.leftpauldron = new ModelRenderer(this, 76, 0);
		this.leftpauldron.addBox(-0.5F, -2F, -1.5F, 3, 3, 3);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftpauldron.setTextureSize(64, 32);
		this.setRotation(leftpauldron, 0.0872665F, 0F, -0.1745329F);
		convertToChild(leftarm, leftpauldron);
		this.rightarmlower = new ModelRenderer(this, 64, 6);
		this.rightarmlower.addBox(-4F, 5F, -1.5F, 2, 6, 3);
		this.rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(rightarmlower, 0.0872665F, 0F, 0F);
		convertToChild(rightarm, rightarmlower);
		this.leftarmlower = new ModelRenderer(this, 74, 6);
		this.leftarmlower.addBox(2F, 5F, -1.5F, 2, 6, 3);
		this.leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(leftarmlower, 0.0872665F, 0F, 0F);
		convertToChild(leftarm, leftarmlower);
		this.tail = new ModelRenderer(this, 64, 15);
		this.tail.addBox(-1F, 0F, 0F, 2, 9, 0);
		this.tail.setRotationPoint(0F, 9F, 1.5F);
		this.tail.setTextureSize(64, 32);
		this.setRotation(tail, 0.3490659F, 0F, 0F);
		this.waist = new ModelRenderer(this, 64, 24);
		this.waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 88, 0);
		this.rightleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		this.rightleglower.setRotationPoint(-2F, 11F, -0.5F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(rightleglower, -0.1745329F, 0F, 0F);
		this.leftleglower = new ModelRenderer(this, 88, 0);
		this.leftleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		this.leftleglower.setRotationPoint(2F, 11F, -0.5F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(leftleglower, -0.1745329F, 0F, 0F);
		this.rightfoot = new ModelRenderer(this, 88, 12);
		this.rightfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		this.rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		this.rightfoot.setTextureSize(64, 32);
		this.setRotation(rightfoot, 0F, 0F, 0F);
		this.leftfoot = new ModelRenderer(this, 88, 12);
		this.leftfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		this.leftfoot.setRotationPoint(2F, 11F, -0.5F);
		this.leftfoot.setTextureSize(64, 32);
		this.setRotation(leftfoot, 0F, 0F, 0F);
		this.rightwing = new ModelRenderer(this, 104, 42);
		this.rightwing.addBox(0F, -1F, 0F, 0, 14, 8);
		this.rightwing.setRotationPoint(-1.5F, 2F, 2F);
		this.rightwing.setTextureSize(64, 32);
		this.setRotation(rightwing, 0.5235988F, -0.7853982F, 0F);
		this.leftwing = new ModelRenderer(this, 112, 42);
		this.leftwing.addBox(0F, -1F, 0F, 0, 14, 8);
		this.leftwing.setRotationPoint(1.5F, 2F, 2F);
		this.leftwing.setTextureSize(64, 32);
		this.setRotation(leftwing, 0.5235988F, 0.7853982F, 0F);
		
		this.convertToChild(head, horn1);
		this.convertToChild(head, horn2);
		this.convertToChild(head, horn3);
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
		this.hair1.render(par7);
		this.hair2.render(par7);
//		this.horn1.render(par7);
//		this.horn2.render(par7);
//		this.horn3.render(par7);
//		this.rightpauldron.render(par7);
//		this.leftpauldron.render(par7);
//		this.rightarmlower.render(par7);
//		this.leftarmlower.render(par7);
		this.tail.render(par7);
		this.waist.render(par7);
		this.rightleglower.render(par7);
		this.leftleglower.render(par7);
		this.rightfoot.render(par7);
		this.leftfoot.render(par7);
		this.rightwing.render(par7);
		this.leftwing.render(par7);

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
            this.rightarm.rotateAngleY = (this.bodytop.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
        
		//body
		this.rightwing.rotateAngleY = MathHelper.cos(par3 * 0.3F + (float)Math.PI) * 1.0F * par2 * 0.5F;
		this.leftwing.rotateAngleY = MathHelper.cos(par3 * 0.3F) * 1.0F * par2 * 0.5F;
		--this.rightwing.rotateAngleY;
		++this.leftwing.rotateAngleY;
		this.tail.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		
		this.rightchest.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 0.8F * par2) + 0.7853982F;
		this.leftchest.rotateAngleX = this.rightchest.rotateAngleX;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
		this.rightleglower.rotateAngleX = this.rightleg.rotateAngleX - 0.1745329F;
		this.leftleglower.rotateAngleX = this.leftleg.rotateAngleX - 0.1745329F;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX;
		this.rightleg.rotateAngleX -= 0.1745329F;
		this.leftleg.rotateAngleX -= 0.1745329F;
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
