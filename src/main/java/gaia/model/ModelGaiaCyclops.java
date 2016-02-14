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
	ModelRenderer headaccessory;
	ModelRenderer hair;
	ModelRenderer righthorn;
	ModelRenderer lefthorn;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarmpauldron;
	public static ModelRenderer rightarm;
	ModelRenderer rightarmgauntlet;
	public static ModelRenderer leftarm;
	ModelRenderer leftarmcloth;
	ModelRenderer rightlegpauldron;
	ModelRenderer rightlegupper;
	ModelRenderer rightleg;
	ModelRenderer leftlegpauldron;
	ModelRenderer leftlegupper;
	ModelRenderer leftleg;
	ModelRenderer frontlegpauldron;

	public ModelGaiaCyclops() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(head, 0.0349066F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.headaccessory.mirror = true;
		this.setRotation(headaccessory, 0.0349066F, 0F, 0F);
		this.hair = new ModelRenderer(this, 36, 18);
		this.hair.addBox(-1.5F, -5F, 2.5F, 3, 12, 3);
		this.hair.setRotationPoint(0F, 1F, 0F);
		this.hair.setTextureSize(64, 32);
		this.hair.mirror = true;
		this.setRotation(hair, 0.0349066F, 0F, 0F);
		this.righthorn = new ModelRenderer(this, 36, 14);
		this.righthorn.addBox(-2.5F, -2.5F, -7.5F, 1, 1, 3);
		this.righthorn.setRotationPoint(0F, 1F, 0F);
		this.righthorn.setTextureSize(64, 32);
		this.righthorn.mirror = true;
		this.setRotation(righthorn, -0.7504916F, 0F, 0F);
		this.lefthorn = new ModelRenderer(this, 36, 14);
		this.lefthorn.addBox(1.5F, -2.5F, -7.5F, 1, 1, 3);
		this.lefthorn.setRotationPoint(0F, 1F, 0F);
		this.lefthorn.setTextureSize(64, 32);
		this.lefthorn.mirror = true;
		this.setRotation(lefthorn, -0.7504916F, 0F, 0F);
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
		this.rightarmpauldron = new ModelRenderer(this, 36, 33);
		this.rightarmpauldron.addBox(-3F, -2F, -2F, 2, 5, 4);
		this.rightarmpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmpauldron.setTextureSize(64, 32);
		this.rightarmpauldron.mirror = true;
		this.setRotation(rightarmpauldron, 0.1745329F, 0F, 0.1745329F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0.1745329F, 0F, 0.1745329F);
		this.rightarmgauntlet = new ModelRenderer(this, 36, 42);
		this.rightarmgauntlet.addBox(-2.5F, 4.5F, -1.5F, 2, 5, 3);
		this.rightarmgauntlet.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmgauntlet.setTextureSize(64, 32);
		this.rightarmgauntlet.mirror = true;
		this.setRotation(rightarmgauntlet, 0.1745329F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0.1745329F, 0F, -0.1745329F);
		this.leftarmcloth = new ModelRenderer(this, 36, 50);
		this.leftarmcloth.addBox(-0.5F, 0F, -1.5F, 3, 8, 3);
		this.leftarmcloth.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmcloth.setTextureSize(64, 32);
		this.leftarmcloth.mirror = true;
		this.setRotation(leftarmcloth, 0.1745329F, 0F, -0.1745329F);
		this.rightlegpauldron = new ModelRenderer(this, 64, 0);
		this.rightlegpauldron.addBox(-2F, -1F, -2F, 3, 6, 4);
		this.rightlegpauldron.setRotationPoint(-1.5F, 11F, 0F);
		this.rightlegpauldron.setTextureSize(64, 32);
		this.rightlegpauldron.mirror = true;
		this.setRotation(rightlegpauldron, 0F, 0F, 0.2617994F);
		this.rightlegupper = new ModelRenderer(this, 64, 19);
		this.rightlegupper.addBox(-1.5F, 0F, -1.5F, 3, 7, 3);
		this.rightlegupper.setRotationPoint(-1.5F, 11F, 0F);
		this.rightlegupper.setTextureSize(64, 32);
		this.rightlegupper.mirror = true;
		this.setRotation(rightlegupper, 0F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1F, 0F, -1F, 2, 13, 2);
		this.rightleg.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, 0F, 0F, 0F);
		this.leftlegpauldron = new ModelRenderer(this, 78, 0);
		this.leftlegpauldron.addBox(-1F, -1F, -2F, 3, 6, 4);
		this.leftlegpauldron.setRotationPoint(1.5F, 11F, 0F);
		this.leftlegpauldron.setTextureSize(64, 32);
		this.leftlegpauldron.mirror = true;
		this.setRotation(leftlegpauldron, 0F, 0F, -0.2617994F);
		this.leftlegupper = new ModelRenderer(this, 64, 19);
		this.leftlegupper.addBox(-1.5F, 0F, -1.5F, 3, 7, 3);
		this.leftlegupper.setRotationPoint(1.5F, 11F, 0F);
		this.leftlegupper.setTextureSize(64, 32);
		this.leftlegupper.mirror = true;
		this.setRotation(leftlegupper, 0F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1F, 0F, -1F, 2, 13, 2);
		this.leftleg.setRotationPoint(1.5F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, 0F, 0F, 0F);
		this.frontlegpauldron = new ModelRenderer(this, 64, 10);
		this.frontlegpauldron.addBox(-2F, -1F, -1.5F, 4, 6, 3);
		this.frontlegpauldron.setRotationPoint(0F, 11F, -1F);
		this.frontlegpauldron.setTextureSize(64, 32);
		this.frontlegpauldron.mirror = true;
		this.setRotation(frontlegpauldron, -0.0872665F, 0F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.hair.render(par7);
		this.righthorn.render(par7);
		this.lefthorn.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.rightarmpauldron.render(par7);
		this.rightarm.render(par7);
		this.rightarmgauntlet.render(par7);
		this.leftarm.render(par7);
		this.leftarmcloth.render(par7);
		this.rightlegpauldron.render(par7);
		this.rightlegupper.render(par7);
		this.rightleg.render(par7);
		this.leftlegpauldron.render(par7);
		this.leftlegupper.render(par7);
		this.leftleg.render(par7);
		this.frontlegpauldron.render(par7);
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
		this.headaccessory.rotateAngleX = this.head.rotateAngleX + 0.0349066F;
		this.hair.rotateAngleY = this.head.rotateAngleY;
		this.righthorn.rotateAngleY = this.head.rotateAngleY;
		this.righthorn.rotateAngleX = this.head.rotateAngleX - 0.7504916F;
		this.lefthorn.rotateAngleY = this.head.rotateAngleY;
		this.lefthorn.rotateAngleX = this.head.rotateAngleX - 0.7504916F;
		this.head.rotateAngleX += 0.0349066F;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.rightarmpauldron.rotateAngleX = this.rightarm.rotateAngleX + 0.1745329F;
		this.rightarmgauntlet.rotateAngleX = this.rightarm.rotateAngleX + 0.1745329F;
		this.rightarm.rotateAngleX += 0.1745329F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.leftarmcloth.rotateAngleX = this.leftarm.rotateAngleX + 0.1745329F;
		this.leftarm.rotateAngleX += 0.1745329F;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.rightlegpauldron.rotateAngleX = this.rightleg.rotateAngleX;
		this.rightlegupper.rotateAngleX = this.rightleg.rotateAngleX;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.leftlegpauldron.rotateAngleX = this.leftleg.rotateAngleX;
		this.leftlegupper.rotateAngleX = this.leftleg.rotateAngleX;
		
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
            
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8)) + 0.1745329F;
            this.rightarmpauldron.rotateAngleX = this.rightarm.rotateAngleX;
            this.rightarmgauntlet.rotateAngleX = this.rightarm.rotateAngleX;
            
            this.leftarm.rotateAngleX = (float)((double)this.leftarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8)) + 0.1745329F;
            this.leftarmcloth.rotateAngleX = this.leftarm.rotateAngleX;
            
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.rightarmpauldron.rotateAngleY = this.rightarm.rotateAngleY;
            this.rightarmgauntlet.rotateAngleY = this.rightarm.rotateAngleY;
            
            this.leftarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.leftarmcloth.rotateAngleY = this.leftarm.rotateAngleY;
            
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F) + 0.1745329F;
            this.rightarmpauldron.rotateAngleZ = this.rightarm.rotateAngleZ;
            this.rightarmgauntlet.rotateAngleZ = this.rightarm.rotateAngleZ;
            
            this.leftarm.rotateAngleZ = (MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F) - 0.1745329F;
            this.leftarmcloth.rotateAngleZ = this.leftarm.rotateAngleZ;
        }
	}
}
