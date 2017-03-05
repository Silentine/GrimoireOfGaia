package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaWitch extends ModelBase {
    ModelRenderer anchor;
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
	ModelRenderer hat1;
	ModelRenderer hat2;
	ModelRenderer hat3;
	ModelRenderer hat4;
	ModelRenderer hat5;
	ModelRenderer hat6;
	ModelRenderer mantle1;
	ModelRenderer mantle2;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer skirt1;
	ModelRenderer skirt2;
	ModelRenderer broomstick;
	ModelRenderer broom;
	ModelRenderer broompumpkin;

	public ModelGaiaWitch() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.anchor = new ModelRenderer(this, 0, 0);
		this.anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		this.anchor.setRotationPoint(-1.5F, 10F, 4F);
		this.anchor.setTextureSize(64, 32);
		this.setRotation(anchor, 0F, 0F, 0F);
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
		this.headaccessory.addBox(-3.5F, -7F, -3.5F, 7, 7, 7);
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
		this.setRotation(bodytop, 0.4363323F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -0.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(64, 32);
		this.setRotation(bodymiddle, 0.3490659F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -0.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.setRotation(bodymiddlebutton, 0.3490659F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -1F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.3490659F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -0.5F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 1.22173F, -0.1745329F, 0F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -0.5F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 1.22173F, 0.1745329F, 0F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, -0.6981317F, -0.3490659F, 0F);
		this.leftarm = new ModelRenderer(this, 16, 36);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, -0.6981317F, 0.3490659F, 0F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, 0F, -1.5F, 3, 6, 3);
		this.rightleg.setRotationPoint(-2F, 10F, 4F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, -0.9599311F, 0F, -0.0872665F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, 0F, -1F, 3, 6, 3);
		this.leftleg.setRotationPoint(2F, 10F, 4F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, -0.6981317F, 0F, 0.0872665F);
		this.hat1 = new ModelRenderer(this, 36, 14);
		this.hat1.addBox(-7F, -7F, -7F, 14, 2, 14);
		this.hat1.setRotationPoint(0F, 1F, 0F);
		this.hat1.setTextureSize(64, 32);
		this.setRotation(hat1, 0F, 0.6108652F, 0F);
		this.hat2 = new ModelRenderer(this, 36, 30);
		this.hat2.addBox(-4F, -9F, -4F, 8, 2, 8);
		this.hat2.setRotationPoint(0F, 1F, 0F);
		this.hat2.setTextureSize(64, 32);
		this.setRotation(hat2, 0F, 0.7853982F, 0F);
		this.hat3 = new ModelRenderer(this, 36, 40);
		this.hat3.addBox(-3F, -10F, -3F, 6, 1, 6);
		this.hat3.setRotationPoint(0F, 1F, 0F);
		this.hat3.setTextureSize(64, 32);
		this.setRotation(hat3, 0F, 0.9599311F, 0F);
		this.hat4 = new ModelRenderer(this, 36, 47);
		this.hat4.addBox(-2F, -11F, -2F, 4, 1, 4);
		this.hat4.setRotationPoint(0F, 1F, 0F);
		this.hat4.setTextureSize(64, 32);
		this.setRotation(hat4, 0F, 1.134464F, 0F);
		this.hat5 = new ModelRenderer(this, 36, 52);
		this.hat5.addBox(-1.5F, -12F, -1.5F, 3, 1, 3);
		this.hat5.setRotationPoint(0F, 1F, 0F);
		this.hat5.setTextureSize(64, 32);
		this.setRotation(hat5, 0F, 1.308997F, 0F);
		this.hat6 = new ModelRenderer(this, 36, 56);
		this.hat6.addBox(-1F, -14F, -1F, 2, 2, 2);
		this.hat6.setRotationPoint(0F, 1F, 0F);
		this.hat6.setTextureSize(64, 32);
		this.setRotation(hat6, 0F, 1.48353F, 0F);
		this.mantle1 = new ModelRenderer(this, 92, 0);
		this.mantle1.addBox(-5F, -1F, -1.5F, 10, 6, 3);
		this.mantle1.setRotationPoint(0F, 1F, 0F);
		this.mantle1.setTextureSize(64, 32);
		this.setRotation(mantle1, 0.8726646F, 0F, 0F);
		this.mantle2 = new ModelRenderer(this, 92, 9);
		this.mantle2.addBox(-4.5F, 2F, -1F, 9, 10, 3);
		this.mantle2.setRotationPoint(0F, 1F, 0F);
		this.mantle2.setTextureSize(64, 32);
		this.setRotation(mantle2, 0.6108652F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 24, 21);
		this.rightleglower.addBox(-1.5F, -0.5F, -7F, 3, 6, 3);
		this.rightleglower.setRotationPoint(-2F, 10F, 4F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(rightleglower, 0.6108652F, 0F, -0.0872665F);
		this.leftleglower = new ModelRenderer(this, 24, 21);
		this.leftleglower.addBox(-1.5F, 0F, -7F, 3, 6, 3);
		this.leftleglower.setRotationPoint(2F, 10F, 4F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(leftleglower, 0.8726646F, 0F, 0.0872665F);
		this.skirt1 = new ModelRenderer(this, 92, 22);
		this.skirt1.addBox(-3.5F, 7.5F, -2.5F, 7, 2, 6);
		this.skirt1.setRotationPoint(0F, 1F, 0F);
		this.skirt1.setTextureSize(64, 32);
		this.setRotation(skirt1, 0.3490659F, 0F, 0F);
		this.skirt2 = new ModelRenderer(this, 92, 30);
		this.skirt2.addBox(-4F, 8.5F, -3F, 8, 4, 7);
		this.skirt2.setRotationPoint(0F, 1F, 0F);
		this.skirt2.setTextureSize(64, 32);
		this.setRotation(skirt2, 0.3316126F, 0F, 0F);
		this.broomstick = new ModelRenderer(this, 92, 41);
		this.broomstick.addBox(1F, -12.5F, -1.5F, 1, 20, 1);
		this.broomstick.setRotationPoint(-1.5F, 10F, 4F);
		this.broomstick.setTextureSize(64, 32);
		this.setRotation(broomstick, 1.570796F, 0F, 0F);
		this.broom = new ModelRenderer(this, 96, 41);
		this.broom.addBox(0F, 6.5F, -2.5F, 3, 10, 3);
		this.broom.setRotationPoint(-1.5F, 10F, 4F);
		this.broom.setTextureSize(64, 32);
		this.setRotation(broom, 1.570796F, 0F, 0F);
		this.broompumpkin = new ModelRenderer(this, 108, 41);
		this.broompumpkin.addBox(0F, 2.5F, 6.5F, 3, 3, 3);
		this.broompumpkin.setRotationPoint(-1.5F, 10F, 4F);
		this.broompumpkin.setTextureSize(64, 32);
		this.setRotation(broompumpkin, 0F, 0F, 0F);
		
		this.anchor.addChild(head);	
		this.anchor.addChild(headeyes);	
		this.anchor.addChild(headaccessory);	
		this.anchor.addChild(neck);
		this.anchor.addChild(bodytop);
		this.anchor.addChild(bodymiddle);
		this.anchor.addChild(bodymiddlebutton);
		this.anchor.addChild(bodybottom);
		this.anchor.addChild(rightchest);
		this.anchor.addChild(leftchest);
		this.anchor.addChild(rightarm);
		this.anchor.addChild(leftarm);
		this.anchor.addChild(rightleg);
		this.anchor.addChild(leftleg);
		this.convertToChild(head, hat1);
		this.convertToChild(head, hat2);
		this.convertToChild(head, hat3);
		this.convertToChild(head, hat4);
		this.convertToChild(head, hat5);
		this.convertToChild(head, hat6);
		this.anchor.addChild(mantle1);
		this.anchor.addChild(mantle2);
		this.anchor.addChild(rightleglower);
		this.anchor.addChild(leftleglower);
		this.anchor.addChild(skirt1);
		this.anchor.addChild(skirt2);
		this.anchor.addChild(broomstick);
		this.anchor.addChild(broom);
		this.anchor.addChild(broompumpkin);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.anchor.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		//anchor
        this.anchor.rotationPointY = MathHelper.cos(((float)1.5F + par3) * 0.5F);
		this.anchor.rotateAngleZ = (MathHelper.cos(par1 * 0.6662F) * 0.5F * par2) * 0.25F;
		
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		
		//body
		this.broompumpkin.rotateAngleZ = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
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
