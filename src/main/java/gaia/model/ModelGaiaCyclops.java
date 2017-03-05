package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaCyclops extends ModelBase {
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
	ModelRenderer hair;
	ModelRenderer hairribbon;
	ModelRenderer righthorn;
	ModelRenderer lefthorn;
	ModelRenderer rightarmpauldron;
	ModelRenderer leftarmpauldron;
	ModelRenderer rightarmgauntlet;
	ModelRenderer leftarmgauntlet;
	ModelRenderer skirt1;
	ModelRenderer skirt2;

	public ModelGaiaCyclops() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0.0349066F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, 0F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0.0349066F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0.0349066F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, 0F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0.0349066F, 0F, 0F);
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
		this.setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0.0872665F, 0F, -0.1745329F);
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
		this.hair.addBox(-1.5F, -5F, 2.5F, 3, 12, 3);
		this.hair.setRotationPoint(0F, 1F, 0F);
		this.hair.setTextureSize(64, 32);
		this.setRotation(hair, 0.0349066F, 0F, 0F);
		this.hairribbon = new ModelRenderer(this, 36, 29);
		this.hairribbon.addBox(-2.5F, -4F, 2.5F, 5, 3, 7);
		this.hairribbon.setRotationPoint(0F, 1F, 0F);
		this.hairribbon.setTextureSize(64, 32);
		this.setRotation(hairribbon, 0.7853982F, 0F, 0F);
		this.righthorn = new ModelRenderer(this, 36, 39);
		this.righthorn.addBox(-2.5F, -2.5F, -7.5F, 1, 1, 3);
		this.righthorn.setRotationPoint(0F, 1F, 0F);
		this.righthorn.setTextureSize(64, 32);
		this.setRotation(righthorn, -0.7504916F, 0F, 0F);
		this.lefthorn = new ModelRenderer(this, 36, 39);
		this.lefthorn.addBox(1.5F, -2.5F, -7.5F, 1, 1, 3);
		this.lefthorn.setRotationPoint(0F, 1F, 0F);
		this.lefthorn.setTextureSize(64, 32);
		this.setRotation(lefthorn, -0.7504916F, 0F, 0F);
		this.rightarmpauldron = new ModelRenderer(this, 36, 43);
		this.rightarmpauldron.addBox(-3F, -2F, -2F, 3, 5, 4);
		this.rightarmpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmpauldron.setTextureSize(64, 32);
		this.setRotation(rightarmpauldron, 0.0872665F, 0F, 0.4363323F);
		this.leftarmpauldron = new ModelRenderer(this, 50, 43);
		this.leftarmpauldron.addBox(0F, -2F, -2F, 3, 5, 4);
		this.leftarmpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmpauldron.setTextureSize(64, 32);
		this.setRotation(leftarmpauldron, 0.0872665F, 0F, -0.4363323F);
		this.rightarmgauntlet = new ModelRenderer(this, 36, 52);
		this.rightarmgauntlet.addBox(-2.5F, 5F, -1.5F, 2, 5, 3);
		this.rightarmgauntlet.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmgauntlet.setTextureSize(64, 32);
		this.setRotation(rightarmgauntlet, 0.0872665F, 0F, 0.1745329F);
		this.leftarmgauntlet = new ModelRenderer(this, 46, 52);
		this.leftarmgauntlet.addBox(0.5F, 5F, -1.5F, 2, 5, 3);
		this.leftarmgauntlet.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmgauntlet.setTextureSize(64, 32);
		this.setRotation(leftarmgauntlet, 0.0872665F, 0F, -0.1745329F);
		this.skirt1 = new ModelRenderer(this, 64, 0);
		this.skirt1.addBox(-3.5F, 7.466667F, -3F, 7, 6, 4);
		this.skirt1.setRotationPoint(0F, 1F, 0F);
		this.skirt1.setTextureSize(64, 32);
		this.setRotation(skirt1, 0.0872665F, 0F, 0F);
		this.skirt2 = new ModelRenderer(this, 64, 10);
		this.skirt2.addBox(-4F, 8.466666F, -3.5F, 8, 7, 4);
		this.skirt2.setRotationPoint(0F, 1F, 0F);
		this.skirt2.setTextureSize(64, 32);
		this.setRotation(skirt2, 0.1745329F, 0F, 0F);
		
		this.convertToChild(head, hairribbon);
		this.convertToChild(head, righthorn);
		this.convertToChild(head, lefthorn);
		this.convertToChild(rightarm, rightarmpauldron);
		this.convertToChild(leftarm, leftarmpauldron);
		this.convertToChild(rightarm, rightarmgauntlet);
		this.convertToChild(leftarm, leftarmgauntlet);
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
//		this.hairribbon.render(par7);
//		this.righthorn.render(par7);
//		this.lefthorn.render(par7);
//		this.rightarmpauldron.render(par7);
//		this.leftarmpauldron.render(par7);
//		this.rightarmgauntlet.render(par7);
//		this.leftarmgauntlet.render(par7);
		this.skirt1.render(par7);
		this.skirt2.render(par7);

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
		this.head.rotateAngleX = (par5 / 57.295776F) + 0.0349066F;
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
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
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
