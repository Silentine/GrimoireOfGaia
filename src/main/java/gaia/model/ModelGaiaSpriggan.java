package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSpriggan extends ModelBase {
	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer headhorns;
	ModelRenderer headhornslong01;
	ModelRenderer headhornslong02;
	ModelRenderer mantle;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarm;
	public static ModelRenderer rightarmlower;
	ModelRenderer leftarm;
	ModelRenderer leftarmlower;
	ModelRenderer spine;
	ModelRenderer rightleg;
	ModelRenderer rightleglower;
	ModelRenderer leftleg;
	ModelRenderer leftleglower;

	public ModelGaiaSpriggan() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(head, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.headaccessory.mirror = true;
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.headhorns = new ModelRenderer(this, 36, 14);
		this.headhorns.addBox(-4F, -7F, -4F, 8, 8, 8);
		this.headhorns.setRotationPoint(0F, 1F, 0F);
		this.headhorns.setTextureSize(64, 32);
		this.headhorns.mirror = true;
		this.setRotation(headhorns, 0F, 0F, 0F);
		this.headhornslong01 = new ModelRenderer(this, 36, 30);
		this.headhornslong01.addBox(-6F, -10F, -3F, 12, 5, 5);
		this.headhornslong01.setRotationPoint(0F, 1F, 0F);
		this.headhornslong01.setTextureSize(64, 32);
		this.headhornslong01.mirror = true;
		this.setRotation(headhornslong01, 0F, 0F, 0F);
		this.headhornslong02 = new ModelRenderer(this, 36, 40);
		this.headhornslong02.addBox(-9F, -7F, -1F, 18, 5, 5);
		this.headhornslong02.setRotationPoint(0F, 1F, 0F);
		this.headhornslong02.setTextureSize(64, 32);
		this.headhornslong02.mirror = true;
		this.setRotation(headhornslong02, 0F, 0F, 0F);
		this.mantle = new ModelRenderer(this, 82, 0);
		this.mantle.addBox(-5F, -1.5F, -2F, 10, 4, 4);
		this.mantle.setRotationPoint(0F, 1F, 0F);
		this.mantle.setTextureSize(64, 32);
		this.mantle.mirror = true;
		this.setRotation(mantle, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 12);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 5, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(64, 32);
		this.bodytop.mirror = true;
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 20);
		this.bodymiddle.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(64, 32);
		this.bodymiddle.mirror = true;
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 20);
		this.bodymiddlebutton.addBox(-0.5F, 5F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.bodymiddlebutton.mirror = true;
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 25);
		this.bodybottom.addBox(-2.5F, 7F, -2.5F, 5, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.bodybottom.mirror = true;
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 31);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.rightchest.mirror = true;
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 8, 31);
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.leftchest.setTextureSize(64, 32);
		this.leftchest.mirror = true;
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 7, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0F, 0F, 0.2617994F);
		this.rightarmlower = new ModelRenderer(this, 82, 8);
		this.rightarmlower.addBox(-5F, 3F, -1.5F, 2, 7, 3);
		this.rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmlower.setTextureSize(64, 32);
		this.rightarmlower.mirror = true;
		this.setRotation(rightarmlower, 0F, 0F, -0.2617994F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 7, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0F, 0F, -0.2617994F);
		this.leftarmlower = new ModelRenderer(this, 92, 8);
		this.leftarmlower.addBox(3F, 3F, -1.5F, 2, 7, 3);
		this.leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmlower.setTextureSize(64, 32);
		this.leftarmlower.mirror = true;
		this.setRotation(leftarmlower, 0F, 0F, 0.2617994F);
		this.spine = new ModelRenderer(this, 82, 18);
		this.spine.addBox(-0.5F, 0F, 1F, 1, 10, 4);
		this.spine.setRotationPoint(0F, 1F, 0F);
		this.spine.setTextureSize(64, 32);
		this.spine.mirror = true;
		this.setRotation(spine, 0F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1.5F, -1F, 2, 8, 2);
		this.rightleg.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, -0.2617994F, 0F, -0.0872665F);
		this.rightleglower = new ModelRenderer(this, 24, 22);
		this.rightleglower.addBox(-0.5F, 4.5F, 2.5F, 2, 8, 2);
		this.rightleglower.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleglower.setTextureSize(64, 32);
		this.rightleglower.mirror = true;
		this.setRotation(rightleglower, -0.4363323F, 0F, 0.0872665F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-0.5F, -1.5F, -1F, 2, 8, 2);
		this.leftleg.setRotationPoint(1.5F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, -0.2617994F, 0F, 0.0872665F);
		this.leftleglower = new ModelRenderer(this, 24, 22);
		this.leftleglower.addBox(-1.5F, 4.5F, 3F, 2, 8, 2);
		this.leftleglower.setRotationPoint(1.5F, 11F, 0F);
		this.leftleglower.setTextureSize(64, 32);
		this.leftleglower.mirror = true;
		this.setRotation(leftleglower, -0.4363323F, 0F, -0.0872665F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.headhorns.render(par7);
		this.headhornslong01.render(par7);
		this.headhornslong02.render(par7);
		this.mantle.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.rightarm.render(par7);
		this.rightarmlower.render(par7);
		this.leftarm.render(par7);
		this.leftarmlower.render(par7);
		this.spine.render(par7);
		this.rightleg.render(par7);
		this.rightleglower.render(par7);
		this.leftleg.render(par7);
		this.leftleglower.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.headhorns.rotateAngleY = this.head.rotateAngleY;
		this.headhorns.rotateAngleX = this.head.rotateAngleX;
		this.headhornslong01.rotateAngleY = this.head.rotateAngleY;
		this.headhornslong01.rotateAngleX = this.head.rotateAngleX;
		this.headhornslong02.rotateAngleY = this.head.rotateAngleY;
		this.headhornslong02.rotateAngleX = this.head.rotateAngleX;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.rightarmlower.rotateAngleX = this.rightarm.rotateAngleX;
		this.leftarmlower.rotateAngleX = this.leftarm.rotateAngleX;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.rightleglower.rotateAngleX = this.rightleg.rotateAngleX - 0.4363323F;
		this.leftleglower.rotateAngleX = this.leftleg.rotateAngleX - 0.4363323F;
		this.rightleg.rotateAngleX = this.rightleg.rotateAngleX - 0.2617994F;
		this.leftleg.rotateAngleX = this.leftleg.rotateAngleX - 0.2617994F;
		
        float f6;
        float f7;

        if (this.onGround > -9990.0F)
        {
            f6 = this.onGround;
            f6 = 1.0F - this.onGround;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            f7 = MathHelper.sin(f6 * (float)Math.PI);
            float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
            this.rightarmlower.rotateAngleX = this.rightarm.rotateAngleX;
            this.rightarm.rotateAngleY = (this.bodytop.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F);
            this.rightarmlower.rotateAngleY = this.rightarm.rotateAngleY - 0.2617994F;
            this.rightarm.rotateAngleY = this.rightarm.rotateAngleY + 0.2617994F;
        }
	}
}
