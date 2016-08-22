package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSatyr extends ModelBase {
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
	ModelRenderer righthair;
	ModelRenderer lefthair;
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer rightpauldron;
	ModelRenderer leftpauldron;
	ModelRenderer waist;
	ModelRenderer tail;
	ModelRenderer rightfoot;
	ModelRenderer leftfoot;

	public ModelGaiaSatyr() {
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
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.25F, 3F, -1.5F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.25F, 3F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, -0.0872665F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1F, 3, 8, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, -0.1745329F, 0F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1F, 3, 8, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, -0.1745329F, 0F, 0.0349066F);
		this.righthair = new ModelRenderer(this, 36, 14);
		this.righthair.addBox(-5.5F, -4.5F, 1.5F, 4, 12, 4);
		this.righthair.setRotationPoint(0F, 1F, 0F);
		this.righthair.setTextureSize(64, 32);
		this.setRotation(righthair, 0.0872665F, 0F, 0.0872665F);
		this.lefthair = new ModelRenderer(this, 36, 14);
		this.lefthair.addBox(1.5F, -4.5F, 1.5F, 4, 12, 4);
		this.lefthair.setRotationPoint(0F, 1F, 0F);
		this.lefthair.setTextureSize(64, 32);
		this.setRotation(lefthair, 0.0872665F, 0F, -0.0872665F);
		this.horn1 = new ModelRenderer(this, 36, 30);
		this.horn1.addBox(-5F, -9F, -2.5F, 10, 5, 5);
		this.horn1.setRotationPoint(0F, 1F, 0F);
		this.horn1.setTextureSize(64, 32);
		this.setRotation(horn1, 0F, 0F, 0F);
		this.horn2 = new ModelRenderer(this, 36, 40);
		this.horn2.addBox(-6F, -8F, -1.5F, 12, 3, 3);
		this.horn2.setRotationPoint(0F, 1F, 0F);
		this.horn2.setTextureSize(64, 32);
		this.setRotation(horn2, 0F, 0F, 0F);
		this.rightpauldron = new ModelRenderer(this, 66, 0);
		this.rightpauldron.addBox(-2.5F, -1.5F, -1.5F, 3, 6, 3);
		this.rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightpauldron.setTextureSize(64, 32);
		this.setRotation(rightpauldron, 0F, 0F, 0.0872665F);
		this.leftpauldron = new ModelRenderer(this, 78, 0);
		this.leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 6, 3);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftpauldron.setTextureSize(64, 32);
		this.setRotation(leftpauldron, 0F, 0F, -0.0872665F);
		this.waist = new ModelRenderer(this, 66, 9);
		this.waist.addBox(-3.5F, 7.5F, -3F, 7, 6, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		this.tail = new ModelRenderer(this, 66, 19);
		this.tail.addBox(-1.5F, 9F, -3F, 3, 5, 1);
		this.tail.setRotationPoint(0F, 1F, 0F);
		this.tail.setTextureSize(64, 32);
		this.setRotation(tail, 0.4363323F, 0F, 0F);
		this.rightfoot = new ModelRenderer(this, 66, 25);
		this.rightfoot.addBox(-1F, 5F, 1F, 2, 8, 2);
		this.rightfoot.setRotationPoint(-2F, 11F, 0F);
		this.rightfoot.setTextureSize(64, 32);
		this.setRotation(rightfoot, -0.1745329F, 0F, -0.0349066F);
		this.leftfoot = new ModelRenderer(this, 66, 25);
		this.leftfoot.addBox(-1F, 5F, 1F, 2, 8, 2);
		this.leftfoot.setRotationPoint(2F, 11F, 0F);
		this.leftfoot.setTextureSize(64, 32);
		this.setRotation(leftfoot, -0.1745329F, 0F, 0.0349066F);
		
		this.convertToChild(head, horn1);
		this.convertToChild(head, horn2);
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
		this.righthair.render(par7);
		this.lefthair.render(par7);
//		this.horn1.render(par7);
//		this.horn2.render(par7);
//		this.rightpauldron.render(par7);
//		this.leftpauldron.render(par7);
		this.waist.render(par7);
		this.tail.render(par7);
		this.rightfoot.render(par7);
		this.leftfoot.render(par7);

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
		this.righthair.rotateAngleY = this.head.rotateAngleY;
		this.lefthair.rotateAngleY = this.head.rotateAngleY;
		
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
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + 3.1415927F) * 0.8F * par2;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX - 0.1745329F;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX - 0.1745329F;
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
