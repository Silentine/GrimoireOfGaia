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
	ModelRenderer headaccessory;
	ModelRenderer righthair;
	ModelRenderer lefthair;
	ModelRenderer horns;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer waist;
	ModelRenderer tail;
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightpauldron;
	ModelRenderer leftpauldron;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer rightfoot;
	ModelRenderer leftfoot;

	public ModelGaiaSatyr() {
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
		this.righthair = new ModelRenderer(this, 36, 14);
		this.righthair.addBox(-5.5F, -4.5F, 1.5F, 4, 12, 4);
		this.righthair.setRotationPoint(0F, 1F, 0F);
		this.righthair.setTextureSize(64, 32);
		this.righthair.mirror = true;
		this.setRotation(righthair, 0.0872665F, 0F, 0.0872665F);
		this.lefthair = new ModelRenderer(this, 36, 14);
		this.lefthair.addBox(1.5F, -4.5F, 1.5F, 4, 12, 4);
		this.lefthair.setRotationPoint(0F, 1F, 0F);
		this.lefthair.setTextureSize(64, 32);
		this.lefthair.mirror = true;
		this.setRotation(lefthair, 0.0872665F, 0F, -0.0872665F);
		this.horns = new ModelRenderer(this, 36, 30);
		this.horns.addBox(-4.5F, -10.5F, -5.5F, 9, 7, 4);
		this.horns.setRotationPoint(0F, 1F, 0F);
		this.horns.setTextureSize(64, 32);
		this.horns.mirror = true;
		this.setRotation(horns, -0.4363323F, 0F, 0F);
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
		this.rightchest.setRotationPoint(1.25F, 3F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.rightchest.mirror = true;
		this.setRotation(rightchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.leftchest = new ModelRenderer(this, 8, 31);
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(-1.25F, 3F, -1.5F);
		this.leftchest.setTextureSize(64, 32);
		this.leftchest.mirror = true;
		this.setRotation(leftchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.waist = new ModelRenderer(this, 64, 9);
		this.waist.addBox(-3F, 8F, -2F, 6, 6, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.waist.mirror = true;
		this.setRotation(waist, 0F, 0F, 0F);
		this.tail = new ModelRenderer(this, 64, 19);
		this.tail.addBox(-1.5F, 9F, -0.5F, 3, 5, 1);
		this.tail.setRotationPoint(0F, 1F, 0F);
		this.tail.setTextureSize(64, 32);
		this.tail.mirror = true;
		this.setRotation(tail, 0.1745329F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0F, 0F, 0.0698132F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0F, 0F, -0.0698132F);
		this.rightpauldron = new ModelRenderer(this, 64, 0);
		this.rightpauldron.addBox(-2.5F, -1.5F, -1.5F, 3, 6, 3);
		this.rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightpauldron.setTextureSize(64, 32);
		this.rightpauldron.mirror = true;
		this.setRotation(rightpauldron, 0F, 0F, 0.0698132F);
		this.leftpauldron = new ModelRenderer(this, 76, 0);
		this.leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 6, 3);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftpauldron.setTextureSize(64, 32);
		this.leftpauldron.mirror = true;
		this.setRotation(leftpauldron, 0F, 0F, -0.0698132F);
		this.rightleg = new ModelRenderer(this, 64, 25);
		this.rightleg.addBox(-1.5F, -1F, -1F, 3, 8, 3);
		this.rightleg.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, -0.2617994F, 0F, 0.0349066F);
		this.leftleg = new ModelRenderer(this, 64, 25);
		this.leftleg.addBox(-1F, -1F, -1F, 3, 8, 3);
		this.leftleg.setRotationPoint(1F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, -0.2617994F, 0F, -0.0349066F);
		this.rightfoot = new ModelRenderer(this, 64, 36);
		this.rightfoot.addBox(-1F, 5F, 1F, 2, 8, 2);
		this.rightfoot.setRotationPoint(-1.5F, 11F, 0F);
		this.rightfoot.setTextureSize(64, 32);
		this.rightfoot.mirror = true;
		this.setRotation(rightfoot, -0.2617994F, 0F, 0.0349066F);
		this.leftfoot = new ModelRenderer(this, 64, 36);
		this.leftfoot.addBox(-1F, 5F, 1F, 2, 8, 2);
		this.leftfoot.setRotationPoint(1.5F, 11F, 0F);
		this.leftfoot.setTextureSize(64, 32);
		this.leftfoot.mirror = true;
		this.setRotation(leftfoot, -0.2617994F, 0F, -0.0349066F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.righthair.render(par7);
		this.lefthair.render(par7);
		this.horns.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.waist.render(par7);
		this.tail.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightpauldron.render(par7);
		this.leftpauldron.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
		this.rightfoot.render(par7);
		this.leftfoot.render(par7);
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
		this.righthair.rotateAngleY = this.head.rotateAngleY;
		this.lefthair.rotateAngleY = this.head.rotateAngleY;
		this.horns.rotateAngleY = this.head.rotateAngleY;
		this.horns.rotateAngleX = this.head.rotateAngleX - 0.4363323F;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + 3.1415927F) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.rightpauldron.rotateAngleX = this.rightarm.rotateAngleX;
		this.leftpauldron.rotateAngleX = this.leftarm.rotateAngleX;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + 3.1415927F) * 0.8F * par2;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX - 0.2617994F;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX - 0.2617994F;
		this.rightleg.rotateAngleX -= 0.2617994F;
		this.leftleg.rotateAngleX -= 0.2617994F;
		
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
            this.rightpauldron.rotateAngleX = this.rightarm.rotateAngleX;
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.rightpauldron.rotateAngleY = this.rightarm.rotateAngleY;
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F) + 0.0698132F;
            this.rightpauldron.rotateAngleZ = this.rightarm.rotateAngleZ;
        }
	}
}
