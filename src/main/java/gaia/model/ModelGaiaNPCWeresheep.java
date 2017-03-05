package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNPCWeresheep extends ModelBase {
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
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer bell;
	ModelRenderer rightarmupper;
	ModelRenderer leftarmupper;
	ModelRenderer rightarmbutton;
	ModelRenderer leftarmbutton;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer waist1;
	ModelRenderer waist2;
	ModelRenderer tail;
	ModelRenderer rightlegbutton;
	ModelRenderer leftlegbutton;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;

	public ModelGaiaNPCWeresheep() {
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
		this.headeyes.setTextureSize(64, 32);
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
		this.setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.leftchest.setTextureSize(128, 64);
		this.setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, 0F, 0F, -0.1745329F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(128, 64);
		this.setRotation(rightleg, 0F, -0.0872665F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(128, 64);
		this.setRotation(leftleg, 0F, 0.0872665F, -0.0349066F);
		this.hair1 = new ModelRenderer(this, 36, 14);
		this.hair1.addBox(-4F, -6F, 1F, 8, 4, 3);
		this.hair1.setRotationPoint(0F, 1F, 0F);
		this.hair1.setTextureSize(128, 64);
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 21);
		this.hair2.addBox(-4.5F, -3F, 1.5F, 9, 4, 3);
		this.hair2.setRotationPoint(0F, 1F, 0F);
		this.hair2.setTextureSize(128, 64);
		this.setRotation(hair2, 0F, 0F, 0F);
		this.horn1 = new ModelRenderer(this, 36, 28);
		this.horn1.addBox(-4F, -9F, -5F, 8, 5, 5);
		this.horn1.setRotationPoint(0F, 1F, 0F);
		this.horn1.setTextureSize(128, 64);
		this.setRotation(horn1, 0F, 0F, 0F);
		this.horn2 = new ModelRenderer(this, 36, 38);
		this.horn2.addBox(-5F, -8F, -4F, 10, 3, 3);
		this.horn2.setRotationPoint(0F, 1F, 0F);
		this.horn2.setTextureSize(128, 64);
		this.setRotation(horn2, 0F, 0F, 0F);
		this.rightear = new ModelRenderer(this, 36, 44);
		this.rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		this.rightear.setRotationPoint(0F, 1F, 0F);
		this.rightear.setTextureSize(128, 64);
		this.setRotation(rightear, 0F, -0.5235988F, 0F);
		this.leftear = new ModelRenderer(this, 36, 44);
		this.leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		this.leftear.setRotationPoint(0F, 1F, 0F);
		this.leftear.setTextureSize(128, 64);
		this.setRotation(leftear, 0F, 0.5235988F, 0F);
		this.bell = new ModelRenderer(this, 36, 44);
		this.bell.addBox(-1F, 0F, -1.5F, 2, 2, 2);
		this.bell.setRotationPoint(0F, 3F, -1.5F);
		this.bell.setTextureSize(128, 64);
		this.setRotation(bell, -2.356194F, 0F, 0F);
		this.rightarmupper = new ModelRenderer(this, 64, 4);
		this.rightarmupper.addBox(-2.5F, 0.1333333F, -1.5F, 3, 2, 3);
		this.rightarmupper.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmupper.setTextureSize(128, 64);
		this.setRotation(rightarmupper, 0F, 0F, 0.1745329F);
		this.leftarmupper = new ModelRenderer(this, 64, 4);
		this.leftarmupper.addBox(-0.5F, 0F, -1.5F, 3, 2, 3);
		this.leftarmupper.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmupper.setTextureSize(128, 64);
		this.setRotation(leftarmupper, 0F, 0F, -0.1745329F);
		this.rightarmbutton = new ModelRenderer(this, 64, 0);
		this.rightarmbutton.addBox(-3F, 7.5F, -1F, 2, 2, 2);
		this.rightarmbutton.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmbutton.setTextureSize(128, 64);
		this.setRotation(rightarmbutton, 0F, 0F, 0.1745329F);
		this.leftarmbutton = new ModelRenderer(this, 64, 0);
		this.leftarmbutton.addBox(1F, 7.5F, -1F, 2, 2, 2);
		this.leftarmbutton.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmbutton.setTextureSize(128, 64);
		this.setRotation(leftarmbutton, 0F, 0F, -0.1745329F);
		this.rightarmlower = new ModelRenderer(this, 64, 9);
		this.rightarmlower.addBox(-2.5F, 5F, -1.5F, 3, 5, 3);
		this.rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmlower.setTextureSize(128, 64);
		this.setRotation(rightarmlower, 0F, 0F, 0.1745329F);
		this.leftarmlower = new ModelRenderer(this, 64, 9);
		this.leftarmlower.addBox(-0.5F, 5F, -1.5F, 3, 5, 3);
		this.leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmlower.setTextureSize(128, 64);
		this.setRotation(leftarmlower, 0F, 0F, -0.1745329F);
		this.waist1 = new ModelRenderer(this, 64, 17);
		this.waist1.addBox(-3.5F, 7.5F, -3F, 7, 2, 6);
		this.waist1.setRotationPoint(0F, 1F, 0F);
		this.waist1.setTextureSize(128, 64);
		this.setRotation(waist1, 0F, 0F, 0F);
		this.waist2 = new ModelRenderer(this, 64, 25);
		this.waist2.addBox(-4F, 9F, -3.5F, 8, 4, 7);
		this.waist2.setRotationPoint(0F, 1F, 0F);
		this.waist2.setTextureSize(128, 64);
		this.setRotation(waist2, 0F, 0F, 0F);
		this.tail = new ModelRenderer(this, 64, 36);
		this.tail.addBox(-1.5F, 10.5F, 3.5F, 3, 3, 3);
		this.tail.setRotationPoint(0F, 1F, 0F);
		this.tail.setTextureSize(128, 64);
		this.setRotation(tail, 0F, 0F, 0F);
		this.rightlegbutton = new ModelRenderer(this, 64, 0);
		this.rightlegbutton.addBox(-1F, 5.5F, -2.5F, 2, 2, 2);
		this.rightlegbutton.setRotationPoint(-2F, 11F, 0F);
		this.rightlegbutton.setTextureSize(128, 64);
		this.setRotation(rightlegbutton, 0F, -0.0872665F, 0F);
		this.leftlegbutton = new ModelRenderer(this, 64, 0);
		this.leftlegbutton.addBox(-1F, 5.5F, -2.5F, 2, 2, 2);
		this.leftlegbutton.setRotationPoint(2F, 11F, 0F);
		this.leftlegbutton.setTextureSize(128, 64);
		this.setRotation(leftlegbutton, 0F, 0.0872665F, 0F);
		this.rightleglower = new ModelRenderer(this, 94, 0);
		this.rightleglower.addBox(-2F, 5F, -2F, 4, 7, 4);
		this.rightleglower.setRotationPoint(-2F, 11F, 0F);
		this.rightleglower.setTextureSize(128, 64);
		this.setRotation(rightleglower, 0F, -0.0872665F, 0F);
		this.leftleglower = new ModelRenderer(this, 94, 0);
		this.leftleglower.addBox(-2F, 5F, -2F, 4, 7, 4);
		this.leftleglower.setRotationPoint(2F, 11F, 0F);
		this.leftleglower.setTextureSize(128, 64);
		this.setRotation(leftleglower, 0F, 0.0872665F, 0F);
		
		
		this.convertToChild(head, hair1);
		this.convertToChild(head, hair2);
		this.convertToChild(head, horn1);
		this.convertToChild(head, horn2);
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(rightarm, rightarmupper);
		this.convertToChild(leftarm, leftarmupper);
		this.convertToChild(rightarm, rightarmbutton);
		this.convertToChild(leftarm, leftarmbutton);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftarmlower);
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
//		this.hair1.render(par7);
//		this.hair2.render(par7);
//		this.horn1.render(par7);
//		this.horn2.render(par7);
//		this.rightear.render(par7);
//		this.leftear.render(par7);
		this.bell.render(par7);
//		this.rightarmupper.render(par7);
//		this.leftarmupper.render(par7);
//		this.rightarmbutton.render(par7);
//		this.leftarmbutton.render(par7);
//		this.rightarmlower.render(par7);
//		this.leftarmlower.render(par7);
		this.waist1.render(par7);
		this.waist2.render(par7);
		this.tail.render(par7);
		this.rightlegbutton.render(par7);
		this.leftlegbutton.render(par7);
		this.rightleglower.render(par7);
		this.leftleglower.render(par7);

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

        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
		
		//body
		this.tail.rotateAngleY = ((MathHelper.cos(par1 * 0.6662F) * 0.5F)/4) * par2;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.rightlegbutton.rotateAngleX = this.rightleg.rotateAngleX;
		this.rightleglower.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.leftlegbutton.rotateAngleX = this.leftleg.rotateAngleX;
		this.leftleglower.rotateAngleX = this.leftleg.rotateAngleX;
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
