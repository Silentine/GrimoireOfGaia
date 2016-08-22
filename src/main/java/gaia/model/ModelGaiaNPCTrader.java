package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNPCTrader extends ModelBase {
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
	ModelRenderer righthair;
	ModelRenderer lefthair;
	ModelRenderer righthairpin;
	ModelRenderer leftthairpin;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer rightpauldron;
	ModelRenderer leftpauldron;
	ModelRenderer watch;
	ModelRenderer tail;
	ModelRenderer waist1;
	ModelRenderer waist2;
	ModelRenderer waist3;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer rightfootlower;
	ModelRenderer leftfootlower;

	public ModelGaiaNPCTrader() {
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
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 8, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, -0.3490659F, -0.0872665F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 8, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, -0.3490659F, 0.0872665F, 0.0349066F);
		this.righthair = new ModelRenderer(this, 36, 14);
		this.righthair.addBox(-5F, -5F, 1.5F, 3, 9, 3);
		this.righthair.setRotationPoint(0F, 1F, 0F);
		this.righthair.setTextureSize(64, 32);
		this.setRotation(righthair, 0F, 0.0872665F, 0.1745329F);
		this.lefthair = new ModelRenderer(this, 36, 14);
		this.lefthair.addBox(2F, -5F, 1.5F, 3, 9, 3);
		this.lefthair.setRotationPoint(0F, 1F, 0F);
		this.lefthair.setTextureSize(64, 32);
		this.setRotation(lefthair, 0F, -0.0872665F, -0.1745329F);
		this.righthairpin = new ModelRenderer(this, 36, 26);
		this.righthairpin.addBox(-6F, -8F, 1F, 4, 4, 4);
		this.righthairpin.setRotationPoint(0F, 1F, 0F);
		this.righthairpin.setTextureSize(64, 32);
		this.setRotation(righthairpin, 0F, 0F, 0.1745329F);
		this.leftthairpin = new ModelRenderer(this, 52, 26);
		this.leftthairpin.addBox(2F, -8F, 1F, 4, 4, 4);
		this.leftthairpin.setRotationPoint(0F, 1F, 0F);
		this.leftthairpin.setTextureSize(64, 32);
		this.setRotation(leftthairpin, 0F, 0F, -0.1745329F);
		this.rightear = new ModelRenderer(this, 36, 34);
		this.rightear.addBox(-3F, -8.5F, -6F, 2, 8, 6);
		this.rightear.setRotationPoint(0F, 1F, 0F);
		this.rightear.setTextureSize(64, 32);
		this.setRotation(rightear, 0F, 0.2617994F, 0F);
		this.leftear = new ModelRenderer(this, 36, 34);
		this.leftear.addBox(1F, -8.5F, -6F, 2, 8, 6);
		this.leftear.setRotationPoint(0F, 1F, 0F);
		this.leftear.setTextureSize(64, 32);
		this.setRotation(leftear, 0F, -0.2617994F, 0F);
		this.rightpauldron = new ModelRenderer(this, 36, 48);
		this.rightpauldron.addBox(-2.5F, -1.5F, -1.5F, 3, 3, 3);
		this.rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightpauldron.setTextureSize(64, 32);
		this.setRotation(rightpauldron, 0F, 0F, 0.1745329F);
		convertToChild(rightarm, rightpauldron);
		this.leftpauldron = new ModelRenderer(this, 48, 48);
		this.leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 3, 3);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftpauldron.setTextureSize(64, 32);
		this.setRotation(leftpauldron, 0F, 0F, -0.1745329F);
		convertToChild(leftarm, leftpauldron);
		this.watch = new ModelRenderer(this, 68, 0);
		this.watch.addBox(-3F, 8F, -2.5F, 1, 5, 5);
		this.watch.setRotationPoint(0F, 1F, 0F);
		this.watch.setTextureSize(64, 32);
		this.setRotation(watch, 0F, 0F, 0.1745329F);
		this.tail = new ModelRenderer(this, 68, 10);
		this.tail.addBox(-1.5F, 6F, -5F, 3, 3, 3);
		this.tail.setRotationPoint(0F, 1F, 0F);
		this.tail.setTextureSize(64, 32);
		this.setRotation(tail, 0.7853982F, 0F, 0F);
		this.waist1 = new ModelRenderer(this, 68, 16);
		this.waist1.addBox(-3.5F, 7.5F, -3F, 7, 3, 6);
		this.waist1.setRotationPoint(0F, 1F, 0F);
		this.waist1.setTextureSize(64, 32);
		this.setRotation(waist1, 0F, 0F, 0F);
		this.waist2 = new ModelRenderer(this, 68, 25);
		this.waist2.addBox(-4F, 9.5F, -3.5F, 8, 4, 7);
		this.waist2.setRotationPoint(0F, 1F, 0F);
		this.waist2.setTextureSize(64, 32);
		this.setRotation(waist2, 0F, 0F, 0F);
		this.waist3 = new ModelRenderer(this, 68, 36);
		this.waist3.addBox(-4.5F, 13.5F, -4F, 9, 5, 8);
		this.waist3.setRotationPoint(0F, 1F, 0F);
		this.waist3.setTextureSize(64, 32);
		this.setRotation(waist3, 0F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 68, 49);
		this.rightleglower.addBox(-1.5F, 4.5F, 1.5F, 3, 8, 2);
		this.rightleglower.setRotationPoint(-2F, 11F, 0F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(rightleglower, -0.3490659F, -0.0872665F, -0.0349066F);
		this.leftleglower = new ModelRenderer(this, 68, 49);
		this.leftleglower.addBox(-1.5F, 4.5F, 1.5F, 3, 8, 2);
		this.leftleglower.setRotationPoint(2F, 11F, 0F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(leftleglower, -0.3490659F, 0.0872665F, 0.0349066F);
		this.rightfootlower = new ModelRenderer(this, 68, 59);
		this.rightfootlower.addBox(-1.5F, 11.5F, -5F, 3, 1, 3);
		this.rightfootlower.setRotationPoint(-2F, 11F, 0F);
		this.rightfootlower.setTextureSize(64, 32);
		this.setRotation(rightfootlower, 0.0872665F, -0.0872665F, -0.0349066F);
		this.leftfootlower = new ModelRenderer(this, 68, 59);
		this.leftfootlower.addBox(-1.5F, 11.5F, -5F, 3, 1, 3);
		this.leftfootlower.setRotationPoint(2F, 11F, 0F);
		this.leftfootlower.setTextureSize(64, 32);
		this.setRotation(leftfootlower, 0.0872665F, 0.0872665F, 0.0349066F);
		
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
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
		this.righthairpin.render(par7);
		this.leftthairpin.render(par7);
//		this.rightear.render(par7);
//		this.leftear.render(par7);
//		this.rightpauldron.render(par7);
//		this.leftpauldron.render(par7);
		this.watch.render(par7);
		this.tail.render(par7);
		this.waist1.render(par7);
		this.waist2.render(par7);
		this.waist3.render(par7);
		this.rightleglower.render(par7);
		this.leftleglower.render(par7);
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
		this.righthair.rotateAngleY = this.head.rotateAngleY + 0.0872665F;
		this.lefthair.rotateAngleY = this.head.rotateAngleY - 0.0872665F;
		this.righthairpin.rotateAngleY = this.head.rotateAngleY;
		this.leftthairpin.rotateAngleY = this.head.rotateAngleY;
		
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
		this.tail.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		
		//legs
		this.rightleg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 0.5F * par2) * 0.5F;
		this.rightleglower.rotateAngleX = this.rightleg.rotateAngleX - 0.3490659F;
		this.rightfootlower.rotateAngleX = this.rightleg.rotateAngleX + 0.0872665F;
		this.rightleg.rotateAngleX = this.rightleg.rotateAngleX - 0.3490659F;
		this.leftleg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2) * 0.5F;
		this.leftleglower.rotateAngleX = this.leftleg.rotateAngleX - 0.3490659F;
		this.leftfootlower.rotateAngleX = this.leftleg.rotateAngleX + 0.0872665F;
		this.leftleg.rotateAngleX = this.leftleg.rotateAngleX - 0.3490659F;
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
