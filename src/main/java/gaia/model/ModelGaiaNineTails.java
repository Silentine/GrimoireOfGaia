package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNineTails extends ModelBase {
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
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer tie;
	ModelRenderer rightarmupper;
	ModelRenderer leftarmupper;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer rightlegcloth;
	ModelRenderer leftlegcloth;
	ModelRenderer rightsandal;
	ModelRenderer leftsandal;

	public ModelGaiaNineTails() {
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
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0F, -0.0872665F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0F, 0.0872665F, 0.0349066F);
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
		this.rightear = new ModelRenderer(this, 36, 37);
		this.rightear.addBox(-4.5F, -10F, -1.5F, 3, 4, 3);
		this.rightear.setRotationPoint(0F, 1F, 0F);
		this.rightear.setTextureSize(64, 32);
		this.setRotation(rightear, 0F, 0F, 0F);
		this.leftear = new ModelRenderer(this, 48, 37);
		this.leftear.addBox(1.5F, -10F, -1.5F, 3, 4, 3);
		this.leftear.setRotationPoint(0F, 1F, 0F);
		this.leftear.setTextureSize(64, 32);
		this.setRotation(leftear, 0F, 0F, 0F);
		this.tie = new ModelRenderer(this, 64, 0);
		this.tie.addBox(-1.5F, 3F, -2.5F, 3, 2, 1);
		this.tie.setRotationPoint(0F, 1F, 0F);
		this.tie.setTextureSize(64, 32);
		this.setRotation(tie, 0F, 0F, 0F);
		this.rightarmupper = new ModelRenderer(this, 64, 3);
		this.rightarmupper.addBox(-2.5F, 0.5F, -1.5F, 3, 10, 3);
		this.rightarmupper.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmupper.setTextureSize(64, 32);
		this.setRotation(rightarmupper, 0F, 0F, 0.1745329F);

		this.leftarmupper = new ModelRenderer(this, 76, 3);
		this.leftarmupper.addBox(-0.5F, 0.5F, -1.5F, 3, 10, 3);
		this.leftarmupper.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmupper.setTextureSize(64, 32);
		this.setRotation(leftarmupper, 0F, 0F, -0.1745329F);

		this.tail1 = new ModelRenderer(this, 64, 16);
		this.tail1.addBox(-3.5F, 6.5F, 2.5F, 7, 7, 4);
		this.tail1.setRotationPoint(0F, 1F, 0F);
		this.tail1.setTextureSize(64, 32);
		this.setRotation(tail1, -0.0872665F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 64, 27);
		this.tail2.addBox(-2.5F, 7F, 7F, 5, 5, 4);
		this.tail2.setRotationPoint(0F, 1F, 0F);
		this.tail2.setTextureSize(64, 32);
		this.setRotation(tail2, -0.1745329F, 0F, 0F);
		this.rightlegcloth = new ModelRenderer(this, 88, 0);
		this.rightlegcloth.addBox(-2F, -1F, -2F, 4, 4, 4);
		this.rightlegcloth.setRotationPoint(-2F, 11F, 0F);
		this.rightlegcloth.setTextureSize(64, 32);
		this.setRotation(rightlegcloth, 0F, 0F, 0F);
		this.leftlegcloth = new ModelRenderer(this, 104, 0);
		this.leftlegcloth.addBox(-2F, -1F, -2F, 4, 4, 4);
		this.leftlegcloth.setRotationPoint(2F, 11F, 0F);
		this.leftlegcloth.setTextureSize(64, 32);
		this.setRotation(leftlegcloth, 0F, 0F, 0F);
		this.rightsandal = new ModelRenderer(this, 88, 8);
		this.rightsandal.addBox(-1.5F, 11F, -2F, 3, 1, 4);
		this.rightsandal.setRotationPoint(-2F, 11F, 0F);
		this.rightsandal.setTextureSize(64, 32);
		this.setRotation(rightsandal, 0F, -0.0872665F, -0.0349066F);
		this.leftsandal = new ModelRenderer(this, 88, 8);
		this.leftsandal.addBox(-1.5F, 11F, -2F, 3, 1, 4);
		this.leftsandal.setRotationPoint(2F, 11F, 0F);
		this.leftsandal.setTextureSize(64, 32);
		this.setRotation(leftsandal, 0F, 0.0872665F, 0.0349066F);
		
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(rightarm, rightarmupper);
		this.convertToChild(leftarm, leftarmupper);
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
//		this.rightear.render(par7);
//		this.leftear.render(par7);
		this.tie.render(par7);
//		this.rightarmupper.render(par7);
//		this.leftarmupper.render(par7);
		this.tail1.render(par7);
		this.tail2.render(par7);
		this.rightlegcloth.render(par7);
		this.leftlegcloth.render(par7);
		this.rightsandal.render(par7);
		this.leftsandal.render(par7);

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
        
		//body
		this.tail1.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.tail2.rotateAngleY = this.tail1.rotateAngleY;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.1F * par2;
		this.rightlegcloth.rotateAngleX = this.rightleg.rotateAngleX;
		this.rightsandal.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + 3.1415927F) * 0.1F * par2;
		this.leftlegcloth.rotateAngleX = this.leftleg.rotateAngleX;
		this.leftsandal.rotateAngleX = this.leftleg.rotateAngleX;
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
