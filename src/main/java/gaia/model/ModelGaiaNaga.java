package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNaga extends ModelBase {
	ModelRenderer head;
	ModelRenderer headnose1;
	ModelRenderer headnose2;
	ModelRenderer headjaw;
	ModelRenderer headtendrils;
	ModelRenderer rightfin;
	ModelRenderer leftfin;
	ModelRenderer pauldron;
	ModelRenderer body;
	ModelRenderer body2;
	ModelRenderer fin1;
	ModelRenderer fin2;
	public static ModelRenderer rightarm;
	ModelRenderer rightarmlower;
	ModelRenderer leftarm;
	ModelRenderer leftarmlower;
	ModelRenderer waist;
    ModelRenderer shieldbracelet;
    ModelRenderer shield;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer tail4;
	ModelRenderer tail5;
	ModelRenderer tail6;
	ModelRenderer tail7;

	public ModelGaiaNaga() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -5F, -3F, 6, 5, 7);
		this.head.setRotationPoint(0F, -6F, -3F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0F, 0F, 0F);
		this.headnose1 = new ModelRenderer(this, 0, 12);
		this.headnose1.addBox(-1F, -4F, -5F, 2, 1, 2);
		this.headnose1.setRotationPoint(0F, -6F, -3F);
		this.headnose1.setTextureSize(128, 64);
		this.setRotation(headnose1, 0F, 0F, 0F);
		this.headnose2 = new ModelRenderer(this, 0, 15);
		this.headnose2.addBox(-2F, -3F, -6F, 4, 2, 3);
		this.headnose2.setRotationPoint(0F, -6F, -3F);
		this.headnose2.setTextureSize(128, 64);
		this.setRotation(headnose2, 0F, 0F, 0F);
		this.headjaw = new ModelRenderer(this, 0, 20);
		this.headjaw.addBox(-2.5F, -2F, -6.5F, 5, 3, 6);
		this.headjaw.setRotationPoint(0F, -6F, -3F);
		this.headjaw.setTextureSize(128, 64);
		this.setRotation(headjaw, 0F, 0F, 0F);
		this.headtendrils = new ModelRenderer(this, 0, 29);
		this.headtendrils.addBox(-3F, -1F, -6.5F, 6, 6, 6);
		this.headtendrils.setRotationPoint(0F, -6F, -3F);
		this.headtendrils.setTextureSize(128, 64);
		this.setRotation(headtendrils, 0F, 0F, 0F);
		this.rightfin = new ModelRenderer(this, 19, -3);
		this.rightfin.addBox(-3F, -5F, 0F, 0, 5, 3);
		this.rightfin.setRotationPoint(0F, -6F, -3F);
		this.rightfin.setTextureSize(128, 64);
		this.setRotation(rightfin, 0F, -0.5235988F, 0F);
		this.leftfin = new ModelRenderer(this, 19, -3);
		this.leftfin.addBox(3F, -5F, 0F, 0, 5, 3);
		this.leftfin.setRotationPoint(0F, -6F, -3F);
		this.leftfin.setTextureSize(128, 64);
		this.setRotation(leftfin, 0F, 0.5235988F, 0F);
		this.pauldron = new ModelRenderer(this, 34, 0);
		this.pauldron.addBox(-9F, -0.5F, -3F, 18, 7, 7);
		this.pauldron.setRotationPoint(0F, -7F, 0F);
		this.pauldron.setTextureSize(128, 64);
		this.setRotation(pauldron, -0.1745329F, 0F, 0F);
		this.body = new ModelRenderer(this, 34, 14);
		this.body.addBox(-4.5F, -2F, -1.5F, 9, 4, 4);
		this.body.setRotationPoint(0F, -7F, 0F);
		this.body.setTextureSize(128, 64);
		this.setRotation(body, 0.2617994F, 0F, 0F);
		this.body2 = new ModelRenderer(this, 34, 44);
		this.body2.addBox(-5.5F, 0F, -2.5F, 11, 9, 6);
		this.body2.setRotationPoint(0F, -7F, 0F);
		this.body2.setTextureSize(128, 64);
		this.setRotation(body2, -0.1745329F, 0F, 0F);
		this.fin1 = new ModelRenderer(this, 0, 34);
		this.fin1.addBox(0F, -5F, -2.5F, 0, 13, 12);
		this.fin1.setRotationPoint(0F, -7F, 0F);
		this.fin1.setTextureSize(128, 64);
		this.setRotation(fin1, -0.1745329F, 0F, 0F);
		this.fin2 = new ModelRenderer(this, 0, 35);
		this.fin2.addBox(0F, -9F, -3F, 0, 5, 6);
		this.fin2.setRotationPoint(0F, -6F, -3F);
		this.fin2.setTextureSize(128, 64);
		this.setRotation(fin2, 0F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 34, 22);
		this.rightarm.addBox(-3F, -1.5F, -1.5F, 3, 8, 3);
		this.rightarm.setRotationPoint(-5.5F, -4F, 0F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, 0F, 0F, 0.0872665F);
		this.rightarmlower = new ModelRenderer(this, 34, 33);
		this.rightarmlower.addBox(-3F, 6.5F, -0.5F, 3, 8, 3);
		this.rightarmlower.setRotationPoint(-5.5F, -4F, 0F);
		this.rightarmlower.setTextureSize(128, 64);
		this.setRotation(rightarmlower, -0.1745329F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 46, 22);
		this.leftarm.addBox(0F, -1.5F, -1.5F, 3, 8, 3);
		this.leftarm.setRotationPoint(5.5F, -4F, 0F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, 0F, 0F, -0.0872665F);
		this.leftarmlower = new ModelRenderer(this, 46, 33);
		this.leftarmlower.addBox(0F, 6.5F, -0.5F, 3, 8, 3);
		this.leftarmlower.setRotationPoint(5.5F, -4F, 0F);
		this.leftarmlower.setTextureSize(128, 64);
		this.setRotation(leftarmlower, -0.1745329F, 0F, -0.0872665F);
		this.waist = new ModelRenderer(this, 84, 0);
		this.waist.addBox(-4.5F, 9F, -2.5F, 9, 5, 5);
		this.waist.setRotationPoint(0F, -7F, 0F);
		this.waist.setTextureSize(128, 64);
		this.setRotation(waist, -0.1308997F, 0F, 0F);
		this.shieldbracelet = new ModelRenderer(this, 84, 24);
		this.shieldbracelet.addBox(1F, 12.5F, -0.5F, 3, 1, 3);
		this.shieldbracelet.setRotationPoint(5.5F, -4F, 0F);
		this.shieldbracelet.setTextureSize(128, 64);
		this.setRotation(shieldbracelet, -0.1745329F, 0F, -0.0872665F);
		this.shield = new ModelRenderer(this, 84, 24);
		this.shield.addBox(3.5F, 2.5F, -5F, 1, 22, 12);
		this.shield.setRotationPoint(5.5F, -4F, 0F);
		this.shield.setTextureSize(128, 64);
		this.setRotation(shield, -0.1745329F, 0F, -0.0872665F);
		this.tail1 = new ModelRenderer(this, 84, 10);
		this.tail1.addBox(-4F, 14F, -2.5F, 8, 3, 4);
		this.tail1.setRotationPoint(0F, -7F, 0F);
		this.tail1.setTextureSize(128, 64);
		this.setRotation(tail1, -0.0436332F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 84, 17);
		this.tail2.addBox(-3.5F, 17F, -2.5F, 7, 3, 4);
		this.tail2.setRotationPoint(0F, -7F, 0F);
		this.tail2.setTextureSize(128, 64);
		this.setRotation(tail2, 0F, 0F, 0F);
		this.tail3 = new ModelRenderer(this, 108, 10);
		this.tail3.addBox(-3F, 20F, -2.5F, 6, 3, 4);
		this.tail3.setRotationPoint(0F, -7F, 0F);
		this.tail3.setTextureSize(128, 64);
		this.setRotation(tail3, 0.0436332F, 0F, 0F);
		this.tail4 = new ModelRenderer(this, 108, 10);
		this.tail4.addBox(-3F, 23F, -3.5F, 6, 3, 4);
		this.tail4.setRotationPoint(0F, -7F, 0F);
		this.tail4.setTextureSize(128, 64);
		this.setRotation(tail4, 0.1308997F, 0F, 0F);
		this.tail5 = new ModelRenderer(this, 108, 10);
		this.tail5.addBox(-3F, 26F, -3.5F, 6, 3, 4);
		this.tail5.setRotationPoint(0F, -7F, 0F);
		this.tail5.setTextureSize(128, 64);
		this.setRotation(tail5, 0.1745329F, 0F, 0F);
		this.tail6 = new ModelRenderer(this, 108, 17);
		this.tail6.addBox(-2.5F, 28F, -1.5F, 5, 3, 4);
		this.tail6.setRotationPoint(0F, -7F, 0F);
		this.tail6.setTextureSize(128, 64);
		this.setRotation(tail6, 0.1745329F, 0F, 0F);
		this.tail7 = new ModelRenderer(this, 108, 17);
		this.tail7.addBox(-2.5F, 29F, 1.5F, 5, 3, 4);
		this.tail7.setRotationPoint(0F, -7F, 0F);
		this.tail7.setTextureSize(128, 64);
		this.setRotation(tail7, 0.1745329F, 0F, 0F);
		
		this.convertToChild(head, headnose1);
		this.convertToChild(head, headnose2);
		this.convertToChild(head, headjaw);
		this.convertToChild(head, headtendrils);
		this.convertToChild(head, rightfin);
		this.convertToChild(head, leftfin);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(leftarm, shieldbracelet);
		this.convertToChild(leftarm, shield);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
//		this.headnose1.render(par7);
//		this.headnose2.render(par7);
//		this.headjaw.render(par7);
//		this.headtendrils.render(par7);
//		this.rightfin.render(par7);
//		this.leftfin.render(par7);
		this.pauldron.render(par7);
		this.body.render(par7);
		this.body2.render(par7);
		this.fin1.render(par7);
		this.fin2.render(par7);
		this.rightarm.render(par7);
//		this.rightarmlower.render(par7);
		this.leftarm.render(par7);
//		this.leftarmlower.render(par7);
		this.waist.render(par7);
//		this.shieldbracelet.render(par7);
//		this.shield.render(par7);
		this.tail1.render(par7);
		this.tail2.render(par7);
		this.tail3.render(par7);
		this.tail4.render(par7);
		this.tail5.render(par7);
		this.tail6.render(par7);
		this.tail7.render(par7);
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
            this.rightarm.rotateAngleX += (this.body.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
		
		//body
		this.fin2.rotateAngleY = this.head.rotateAngleY;
		this.fin2.rotateAngleX = this.head.rotateAngleX;
		this.tail1.rotateAngleZ = MathHelper.cos(par1 * 0.6162F) * 0.05F * par2;
		this.tail2.rotateAngleZ = MathHelper.cos(par1 * 0.6262F) * 0.05F * par2;
		this.tail3.rotateAngleZ = MathHelper.cos(par1 * 0.6362F) * 0.05F * par2;
		this.tail4.rotateAngleZ = MathHelper.cos(par1 * 0.6462F) * 0.05F * par2;
		this.tail5.rotateAngleZ = MathHelper.cos(par1 * 0.6562F) * 0.05F * par2;
		this.tail6.rotateAngleZ = MathHelper.cos(par1 * 0.6662F) * 0.05F * par2;
		this.tail7.rotateAngleZ = MathHelper.cos(par1 * 0.6762F) * 0.05F * par2;
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
