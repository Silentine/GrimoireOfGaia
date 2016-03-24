package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNPCSlimeGirl extends ModelBase {
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
	ModelRenderer headslime;
	ModelRenderer righthairpin1;
	ModelRenderer lefthairpin1;
	ModelRenderer righthairpin2;
	ModelRenderer lefthairpin2;
	ModelRenderer righthair;
	ModelRenderer lefthair;
	ModelRenderer waist;

	public ModelGaiaNPCSlimeGirl() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, 0F);
		this.headeyes.setTextureSize(128, 64);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(128, 64);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, 0F);
		this.neck.setTextureSize(128, 64);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(128, 64);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(128, 64);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(128, 64);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(128, 64);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		this.rightchest.setTextureSize(128, 64);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.leftchest.setTextureSize(128, 64);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, 0F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, 0F, 0F, -0.0872665F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(128, 64);
		this.setRotation(rightleg, 0F, -0.0872665F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(128, 64);
		this.setRotation(leftleg, 0F, 0.0872665F, 0.0349066F);
		this.headslime = new ModelRenderer(this, 36, 14);
		this.headslime.addBox(-4F, -7F, -4F, 8, 8, 8);
		this.headslime.setRotationPoint(0F, 1F, 0F);
		this.headslime.setTextureSize(128, 64);
		this.setRotation(headslime, 0F, 0F, 0F);
		this.righthairpin1 = new ModelRenderer(this, 36, 30);
		this.righthairpin1.addBox(-7F, -7F, 2F, 4, 4, 4);
		this.righthairpin1.setRotationPoint(0F, 1F, 0F);
		this.righthairpin1.setTextureSize(128, 64);
		this.setRotation(righthairpin1, 0.0872665F, -0.1745329F, 0.1745329F);
		this.lefthairpin1 = new ModelRenderer(this, 52, 30);
		this.lefthairpin1.addBox(3F, -7F, 2F, 4, 4, 4);
		this.lefthairpin1.setRotationPoint(0F, 1F, 0F);
		this.lefthairpin1.setTextureSize(128, 64);
		this.setRotation(lefthairpin1, 0.0872665F, 0.1745329F, -0.1745329F);
		this.righthairpin2 = new ModelRenderer(this, 36, 38);
		this.righthairpin2.addBox(-8F, -8F, 1F, 6, 6, 6);
		this.righthairpin2.setRotationPoint(0F, 1F, 0F);
		this.righthairpin2.setTextureSize(128, 64);
		this.setRotation(righthairpin2, 0.0872665F, -0.1745329F, 0.1745329F);
		this.lefthairpin2 = new ModelRenderer(this, 36, 38);
		this.lefthairpin2.addBox(2F, -8F, 1F, 6, 6, 6);
		this.lefthairpin2.setRotationPoint(0F, 1F, 0F);
		this.lefthairpin2.setTextureSize(128, 64);
		this.setRotation(lefthairpin2, 0.0872665F, 0.1745329F, -0.1745329F);
		this.righthair = new ModelRenderer(this, 36, 50);
		this.righthair.addBox(-6.5F, -4F, 2.5F, 3, 8, 3);
		this.righthair.setRotationPoint(0F, 1F, 0F);
		this.righthair.setTextureSize(128, 64);
		this.setRotation(righthair, 0.0872665F, -0.1745329F, 0.1745329F);
		this.lefthair = new ModelRenderer(this, 36, 50);
		this.lefthair.addBox(3.5F, -4F, 2.5F, 3, 8, 3);
		this.lefthair.setRotationPoint(0F, 1F, 0F);
		this.lefthair.setTextureSize(128, 64);
		this.setRotation(lefthair, 0.0872665F, 0.1745329F, -0.1745329F);
		this.waist = new ModelRenderer(this, 68, 0);
		this.waist.addBox(-4F, 7.5F, -3F, 8, 8, 4);
		this.waist.setRotationPoint(0F, 2F, 0F);
		this.waist.setTextureSize(128, 64);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		
		this.convertToChild(head, headslime);
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
//		this.headslime.render(par7);
		this.righthairpin1.render(par7);
		this.lefthairpin1.render(par7);
		this.righthairpin2.render(par7);
		this.lefthairpin2.render(par7);
		this.righthair.render(par7);
		this.lefthair.render(par7);
		this.waist.render(par7);

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
		this.righthair.rotateAngleY = this.head.rotateAngleY - 0.1745329F;
		this.righthairpin1.rotateAngleY = this.head.rotateAngleY - 0.1745329F;
		this.righthairpin2.rotateAngleY = this.head.rotateAngleY - 0.1745329F;
		this.lefthair.rotateAngleY = this.head.rotateAngleY + 0.1745329F;
		this.lefthairpin1.rotateAngleY = this.head.rotateAngleY + 0.1745329F;
		this.lefthairpin2.rotateAngleY = this.head.rotateAngleY + 0.1745329F;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;

        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
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
