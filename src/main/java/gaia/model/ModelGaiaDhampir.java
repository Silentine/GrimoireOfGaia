package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaDhampir extends ModelBase {
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
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hair;
	ModelRenderer righthair;
	ModelRenderer lefthair;
	ModelRenderer hat1;
	ModelRenderer hat2;
	ModelRenderer hat3;
	ModelRenderer hatflower;
	ModelRenderer mantle;
	ModelRenderer rightpauldron;
	ModelRenderer leftpauldron;
	ModelRenderer cape1;
	ModelRenderer cape2;
	ModelRenderer waist;
	ModelRenderer rightboot;
	ModelRenderer leftboot;

	public ModelGaiaDhampir() {
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
		this.setRotation(leftchest, 0.7853982F, -0.1570796F, -0.0872665F);
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
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0F, 0F, 0F);
		this.hair = new ModelRenderer(this, 36, 14);
		this.hair.addBox(-1F, -2.5F, 2.5F, 2, 12, 2);
		this.hair.setRotationPoint(0F, 1F, 0F);
		this.hair.setTextureSize(64, 32);
		this.setRotation(hair, 0.3490659F, 0F, 0F);
		this.righthair = new ModelRenderer(this, 36, 24);
		this.righthair.addBox(-4F, -6F, -1F, 0, 4, 4);
		this.righthair.setRotationPoint(0F, 1F, 0F);
		this.righthair.setTextureSize(64, 32);
		this.setRotation(righthair, 0F, -0.5235988F, 0F);
		this.lefthair = new ModelRenderer(this, 36, 24);
		this.lefthair.addBox(4F, -6F, -1F, 0, 4, 4);
		this.lefthair.setRotationPoint(0F, 1F, 0F);
		this.lefthair.setTextureSize(64, 32);
		this.setRotation(lefthair, 0F, 0.5235988F, 0F);
		this.hat1 = new ModelRenderer(this, 36, 20);
		this.hat1.addBox(-6F, -7F, -6F, 12, 2, 12);
		this.hat1.setRotationPoint(0F, 1F, 0F);
		this.hat1.setTextureSize(64, 32);
		this.setRotation(hat1, 0.0349066F, 0.9599311F, 0.0349066F);
		this.hat2 = new ModelRenderer(this, 36, 34);
		this.hat2.addBox(-3F, -10F, -3F, 6, 3, 6);
		this.hat2.setRotationPoint(0F, 1F, 0F);
		this.hat2.setTextureSize(64, 32);
		this.setRotation(hat2, 0.0349066F, 0.7853982F, 0.0349066F);
		this.hat3 = new ModelRenderer(this, 36, 43);
		this.hat3.addBox(-4F, -11F, 0F, 4, 3, 4);
		this.hat3.setRotationPoint(0F, 1F, 0F);
		this.hat3.setTextureSize(64, 32);
		this.setRotation(hat3, 0.0349066F, 0.9599311F, 0.0349066F);
		this.hatflower = new ModelRenderer(this, 36, 50);
		this.hatflower.addBox(-3.5F, -11F, -3.5F, 7, 4, 7);
		this.hatflower.setRotationPoint(0F, 1F, 0F);
		this.hatflower.setTextureSize(64, 32);
		this.setRotation(hatflower, 0.0349066F, 0.7853982F, 0.0349066F);
		this.mantle = new ModelRenderer(this, 84, 0);
		this.mantle.addBox(-4F, -3F, -2F, 8, 4, 4);
		this.mantle.setRotationPoint(0F, 1F, 0F);
		this.mantle.setTextureSize(64, 32);
		this.setRotation(mantle, 0F, 0F, 0F);
		this.rightpauldron = new ModelRenderer(this, 84, 8);
		this.rightpauldron.addBox(-2.5F, -1F, -1.5F, 3, 3, 3);
		this.rightpauldron.setRotationPoint(-2.5F, 2F, 0F);
		this.rightpauldron.setTextureSize(64, 32);
		this.setRotation(rightpauldron, 0F, 0F, 0F);
		this.leftpauldron = new ModelRenderer(this, 96, 8);
		this.leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 3, 3);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftpauldron.setTextureSize(64, 32);
		this.setRotation(leftpauldron, 0F, 0F, 0F);
		this.cape1 = new ModelRenderer(this, 84, 14);
		this.cape1.addBox(-5F, 1F, -1F, 10, 6, 3);
		this.cape1.setRotationPoint(0F, 1F, 0F);
		this.cape1.setTextureSize(64, 32);
		this.setRotation(cape1, 0.3490659F, 0F, 0F);
		this.cape2 = new ModelRenderer(this, 84, 23);
		this.cape2.addBox(-5.5F, 6F, 0.5F, 11, 6, 3);
		this.cape2.setRotationPoint(0F, 1F, 0F);
		this.cape2.setTextureSize(64, 32);
		this.setRotation(cape2, 0.1745329F, 0F, 0F);
		this.waist = new ModelRenderer(this, 84, 32);
		this.waist.addBox(-4F, 7.5F, -3F, 8, 6, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		this.rightboot = new ModelRenderer(this, 84, 42);
		this.rightboot.addBox(-2F, 4F, -2F, 4, 7, 4);
		this.rightboot.setRotationPoint(-2F, 11F, 0F);
		this.rightboot.setTextureSize(64, 32);
		this.setRotation(rightboot, 0F, 0F, 0F);
		this.leftboot = new ModelRenderer(this, 84, 42);
		this.leftboot.addBox(-2F, 4F, -2F, 4, 7, 4);
		this.leftboot.setRotationPoint(2F, 11F, 0F);
		this.leftboot.setTextureSize(64, 32);
		this.setRotation(leftboot, 0F, 0F, 0F);
		
		this.convertToChild(head, righthair);
		this.convertToChild(head, lefthair);
		this.convertToChild(head, hat1);
		this.convertToChild(head, hat2);
		this.convertToChild(head, hat3);
		this.convertToChild(head, hatflower);
		this.convertToChild(rightarm, rightpauldron);
		this.convertToChild(leftarm, leftpauldron);
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
		this.hair.render(par7);
//		this.righthair.render(par7);
//		this.lefthair.render(par7);
//		this.hat1.render(par7);
//		this.hat2.render(par7);
//		this.hat3.render(par7);
//		this.hatflower.render(par7);
		this.mantle.render(par7);
//		this.rightpauldron.render(par7);
//		this.leftpauldron.render(par7);
		this.cape1.render(par7);
		this.cape2.render(par7);
		this.waist.render(par7);
		this.rightboot.render(par7);
		this.leftboot.render(par7);

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
		this.hair.rotateAngleY = this.head.rotateAngleY;
		
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
		
        //body
		this.mantle.rotateAngleY = this.head.rotateAngleY;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
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
