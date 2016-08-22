package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaEnderDragonGirl extends ModelBase {
    ModelRenderer head;
    ModelRenderer headeyes;
    ModelRenderer headaccessory;
    ModelRenderer neck;
    ModelRenderer bodytop;
    ModelRenderer bodymiddle;
    ModelRenderer bodymiddlebutton;
    ModelRenderer bodybottom;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightchest;
    ModelRenderer leftchest;
    ModelRenderer righthorn;
    ModelRenderer lefthorn;
    ModelRenderer rightarmlower;
    ModelRenderer leftarmlower;
    ModelRenderer rightclaw;
    ModelRenderer leftclaw;
    ModelRenderer waist;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer rightleg1;
    ModelRenderer leftleg1;
    ModelRenderer rightleg2;
    ModelRenderer leftleg2;
    ModelRenderer rightleg3;
    ModelRenderer leftleg3;
    ModelRenderer rightleg4;
    ModelRenderer leftleg4;
    ModelRenderer rightleg5;
    ModelRenderer leftleg5;
    ModelRenderer rightwing;
    ModelRenderer leftwing;
	public boolean isCarrying;
	public boolean isAttacking;

	public ModelGaiaEnderDragonGirl() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.isCarrying = false;
		this.isAttacking = false;
		float f = -14.0F;
		float f1 = 0.0F;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, -4F, -2F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0.1745329F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, -4F, -2F);
		this.headeyes.setTextureSize(128, 64);
		this.setRotation(headeyes, 0.1745329F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -7F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, -4F, -2F);
		this.headaccessory.setTextureSize(128, 64);
		this.setRotation(headaccessory, 0.1745329F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, -4F, -2F);
		this.neck.setTextureSize(128, 64);
		this.setRotation(neck, 0.1745329F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, -4F, -2F);
		this.bodytop.setTextureSize(128, 64);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, -4F, -2F);
		this.bodymiddle.setTextureSize(128, 64);
		this.setRotation(bodymiddle, 0.0872665F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, -4F, -2F);
		this.bodymiddlebutton.setTextureSize(128, 64);
		this.setRotation(bodymiddlebutton, 0.0872665F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, -4F, -2F);
		this.bodybottom.setTextureSize(128, 64);
		this.setRotation(bodybottom, 0.1745329F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		this.rightarm.setRotationPoint(-2.5F, -2.5F, -1.5F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, -0.2617994F, 0F, 0.4363323F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		this.leftarm.setRotationPoint(2.5F, -2.5F, -1.5F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, -0.2617994F, 0F, -0.4363323F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, -2F, -3F);
		this.rightchest.setTextureSize(128, 64);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, -2F, -3F);
		this.leftchest.setTextureSize(128, 64);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.righthorn = new ModelRenderer(this, 36, 14);
		this.righthorn.addBox(-4F, -7.5F, 0.5F, 2, 2, 7);
		this.righthorn.setRotationPoint(0F, -4F, -2F);
		this.righthorn.setTextureSize(128, 64);
		this.setRotation(righthorn, 0.5235988F, 0F, 0F);
		this.lefthorn = new ModelRenderer(this, 36, 14);
		this.lefthorn.addBox(2F, -7.5F, 0.5F, 2, 2, 7);
		this.lefthorn.setRotationPoint(0F, -4F, -2F);
		this.lefthorn.setTextureSize(128, 64);
		this.setRotation(lefthorn, 0.5235988F, 0F, 0F);
		this.rightarmlower = new ModelRenderer(this, 16, 20);
		this.rightarmlower.addBox(-2F, 5F, 0F, 2, 6, 2);
		this.rightarmlower.setRotationPoint(-2.5F, -2.5F, -1.5F);
		this.rightarmlower.setTextureSize(128, 64);
		this.setRotation(rightarmlower, -0.4537856F, 0F, 0.4363323F);
		this.leftarmlower = new ModelRenderer(this, 16, 20);
		this.leftarmlower.addBox(0F, 5F, 0F, 2, 6, 2);
		this.leftarmlower.setRotationPoint(2.5F, -2.5F, -1.5F);
		this.leftarmlower.setTextureSize(128, 64);
		this.setRotation(leftarmlower, -0.4537856F, 0F, -0.4363323F);
		this.rightclaw = new ModelRenderer(this, 64, 0);
		this.rightclaw.addBox(-2F, 11F, -0.5F, 2, 3, 3);
		this.rightclaw.setRotationPoint(-2.5F, -2.5F, -1.5F);
		this.rightclaw.setTextureSize(128, 64);
		this.setRotation(rightclaw, -0.4537856F, 0F, 0.4363323F);
		this.leftclaw = new ModelRenderer(this, 74, 0);
		this.leftclaw.addBox(0F, 11F, -0.5F, 2, 3, 3);
		this.leftclaw.setRotationPoint(2.5F, -2.5F, -1.5F);
		this.leftclaw.setTextureSize(128, 64);
		this.setRotation(leftclaw, -0.4537856F, 0F, -0.4363323F);
		this.waist = new ModelRenderer(this, 64, 6);
		this.waist.addBox(-3.5F, 9F, -3F, 7, 3, 4);
		this.waist.setRotationPoint(0F, -4F, -2F);
		this.waist.setTextureSize(128, 64);
		this.setRotation(waist, 0.1745329F, 0F, 0F);
		this.tail1 = new ModelRenderer(this, 64, 13);
		this.tail1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		this.tail1.setRotationPoint(0F, 6F, 0F);
		this.tail1.setTextureSize(128, 64);
		this.setRotation(tail1, 0.5235988F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 64, 24);
		this.tail2.addBox(-1F, 8F, -2.5F, 2, 6, 2);
		this.tail2.setRotationPoint(0F, 6F, 0F);
		this.tail2.setTextureSize(128, 64);
		this.setRotation(tail2, 0.6981317F, 0F, 0F);
		this.tail3 = new ModelRenderer(this, 64, 32);
		this.tail3.addBox(-0.5F, 13.5F, -4.5F, 1, 6, 1);
		this.tail3.setRotationPoint(0F, 6F, 0F);
		this.tail3.setTextureSize(128, 64);
		this.setRotation(tail3, 0.8726646F, 0F, 0F);
		this.rightleg1 = new ModelRenderer(this, 86, 0);
		this.rightleg1.addBox(-1.5F, 0.5F, -1.5F, 3, 11, 3);
		this.rightleg1.setRotationPoint(-2F, 6F, 0F);
		this.rightleg1.setTextureSize(128, 64);
		this.setRotation(rightleg1, -0.3490659F, 0.1745329F, 0F);
		this.leftleg1 = new ModelRenderer(this, 86, 0);
		this.leftleg1.addBox(-1.5F, 0.5F, -1.5F, 3, 11, 3);
		this.leftleg1.setRotationPoint(2F, 6F, 0F);
		this.leftleg1.setTextureSize(128, 64);
		this.setRotation(leftleg1, -0.3490659F, -0.1745329F, 0F);
		this.rightleg2 = new ModelRenderer(this, 86, 14);
		this.rightleg2.addBox(-2F, 1.5F, -2F, 4, 8, 4);
		this.rightleg2.setRotationPoint(-2F, 6F, 0F);
		this.rightleg2.setTextureSize(128, 64);
		this.setRotation(rightleg2, -0.3490659F, 0.1745329F, 0F);
		this.leftleg2 = new ModelRenderer(this, 86, 14);
		this.leftleg2.addBox(-2F, 1.5F, -2F, 4, 8, 4);
		this.leftleg2.setRotationPoint(2F, 6F, 0F);
		this.leftleg2.setTextureSize(128, 64);
		this.setRotation(leftleg2, -0.3490659F, -0.1745329F, 0F);
		this.rightleg3 = new ModelRenderer(this, 86, 26);
		this.rightleg3.addBox(-1F, 10.5F, -1F, 2, 2, 5);
		this.rightleg3.setRotationPoint(-2F, 6F, 0F);
		this.rightleg3.setTextureSize(128, 64);
		this.setRotation(rightleg3, -0.3490659F, 0.1745329F, 0F);
		this.leftleg3 = new ModelRenderer(this, 86, 26);
		this.leftleg3.addBox(-1F, 10.5F, -1F, 2, 2, 5);
		this.leftleg3.setRotationPoint(2F, 6F, 0F);
		this.leftleg3.setTextureSize(128, 64);
		this.setRotation(leftleg3, -0.3490659F, -0.1745329F, 0F);
		this.rightleg4 = new ModelRenderer(this, 86, 33);
		this.rightleg4.addBox(-1.5F, 3.5F, -16.5F, 3, 2, 6);
		this.rightleg4.setRotationPoint(-2F, 6F, 0F);
		this.rightleg4.setTextureSize(128, 64);
		this.setRotation(rightleg4, 1.22173F, 0.1745329F, 0F);
		this.leftleg4 = new ModelRenderer(this, 86, 33);
		this.leftleg4.addBox(-1.5F, 3.5F, -16.5F, 3, 2, 6);
		this.leftleg4.setRotationPoint(2F, 6F, 0F);
		this.leftleg4.setTextureSize(128, 64);
		this.setRotation(leftleg4, 1.22173F, -0.1745329F, 0F);
		this.rightleg5 = new ModelRenderer(this, 86, 41);
		this.rightleg5.addBox(-1.5F, -4.5F, -18F, 3, 4, 1);
		this.rightleg5.setRotationPoint(-2F, 6F, 0F);
		this.rightleg5.setTextureSize(128, 64);
		this.setRotation(rightleg5, 1.570796F, 0.1745329F, 0F);
		this.leftleg5 = new ModelRenderer(this, 86, 41);
		this.leftleg5.addBox(-1.5F, -4.5F, -18F, 3, 4, 1);
		this.leftleg5.setRotationPoint(2F, 6F, 0F);
		this.leftleg5.setTextureSize(128, 64);
		setRotation(leftleg5, 1.570796F, -0.1745329F, 0F);
		this.rightwing = new ModelRenderer(this, 92, 34);
		this.rightwing.addBox(0F, -4F, 0F, 0, 18, 12);
		this.rightwing.setRotationPoint(-2F, -2F, 0F);
		this.rightwing.setTextureSize(128, 64);
		this.setRotation(rightwing, 0.5235988F, -0.5235988F, 0F);
		this.leftwing = new ModelRenderer(this, 104, 34);
		this.leftwing.addBox(0F, -4F, 0F, 0, 18, 12);
		this.leftwing.setRotationPoint(2F, -2F, 0F);
		this.leftwing.setTextureSize(128, 64);
		this.setRotation(leftwing, 0.5235988F, 0.5235988F, 0F);
		
		this.convertToChild(head, righthorn);
		this.convertToChild(head, lefthorn);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(rightarm, rightclaw);
		this.convertToChild(leftarm, leftclaw);
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
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
//		this.righthorn.render(par7);
//		this.lefthorn.render(par7);
//		this.rightarmlower.render(par7);
//		this.leftarmlower.render(par7);
//		this.rightclaw.render(par7);
//		this.leftclaw.render(par7);
		this.waist.render(par7);
		this.tail1.render(par7);
		this.tail2.render(par7);
		this.tail3.render(par7);
		this.rightleg1.render(par7);
		this.leftleg1.render(par7);
		this.rightleg2.render(par7);
		this.leftleg2.render(par7);
		this.rightleg3.render(par7);
		this.leftleg3.render(par7);
		this.rightleg4.render(par7);
		this.leftleg4.render(par7);
		this.rightleg5.render(par7);
		this.leftleg5.render(par7);
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
		this.head.rotateAngleX = (par5 / 57.295776F) + 0.1745329F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
		if(this.isCarrying) {
			this.rightclaw.rotateAngleX = -0.5F;
			this.leftclaw.rotateAngleX = -0.5F;
			this.rightclaw.rotateAngleZ = 0.05F;
			this.leftclaw.rotateAngleZ = -0.05F;
		}
		
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
		
		//body
		this.rightwing.rotateAngleY = MathHelper.cos(par3 * 0.6662F + (float)Math.PI) * 1.0F * par2 * 0.5F;
		this.leftwing.rotateAngleY = MathHelper.cos(par3 * 0.6662F) * 1.0F * par2 * 0.5F;
		this.rightwing.rotateAngleY -= 0.5235988F;
		this.leftwing.rotateAngleY += 0.5235988F;
		this.tail1.rotateAngleZ = MathHelper.cos(par1 * 0.6162F) * 0.1F * par2;
		this.tail2.rotateAngleZ = MathHelper.cos(par1 * 0.6262F) * 0.1F * par2;
		this.tail3.rotateAngleZ = MathHelper.cos(par1 * 0.6362F) * 0.1F * par2;
		
		//legs
		this.rightleg1.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 0.5F * par2) * 1.5F;
		this.rightleg2.rotateAngleX = this.rightleg1.rotateAngleX - 0.3490659F;
		this.rightleg3.rotateAngleX = this.rightleg1.rotateAngleX - 0.3490659F;
		this.rightleg4.rotateAngleX = this.rightleg1.rotateAngleX + 1.22173F;
		this.rightleg5.rotateAngleX = this.rightleg1.rotateAngleX + 1.5707964F;
		this.rightleg1.rotateAngleX -= 0.3490659F;
		this.leftleg1.rotateAngleX = (MathHelper.cos(par1 * 0.6665F + (float)Math.PI) * 0.2F * par2) * 1.5F;
		this.leftleg2.rotateAngleX = this.leftleg1.rotateAngleX - 0.3490659F;
		this.leftleg3.rotateAngleX = this.leftleg1.rotateAngleX - 0.3490659F;
		this.leftleg4.rotateAngleX = this.leftleg1.rotateAngleX + 1.22173F;
		this.leftleg5.rotateAngleX = this.leftleg1.rotateAngleX + 1.5707964F;
		this.leftleg1.rotateAngleX -= 0.3490659F;
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
