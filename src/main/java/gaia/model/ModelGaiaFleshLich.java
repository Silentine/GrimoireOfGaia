package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaFleshLich extends ModelBase {
    ModelRenderer head;
    ModelRenderer headlower;
    ModelRenderer neck;
    ModelRenderer body;
    ModelRenderer rightshoulder;
    ModelRenderer rightshoulderlower;
	public static ModelRenderer rightarm;
    ModelRenderer leftshoulder;
    ModelRenderer leftarm;
    ModelRenderer banner;
    ModelRenderer waist1;
    ModelRenderer waist2;
    ModelRenderer waist3;
    ModelRenderer rightleg;
    ModelRenderer leftleg;

    public ModelGaiaFleshLich() {
    	this.textureWidth = 128;
    	this.textureHeight = 64;

    	this.head = new ModelRenderer(this, 0, 0);
    	this.head.addBox(-4F, -8F, -4F, 8, 6, 8);
    	this.head.setRotationPoint(0F, 0F, 0F);
    	this.head.setTextureSize(64, 32);
    	this.setRotation(head, 0F, 0F, 0F);
    	this.headlower = new ModelRenderer(this, 56, 0);
    	this.headlower.addBox(-4F, -2F, -4F, 8, 4, 8);
    	this.headlower.setRotationPoint(0F, 0F, 0F);
    	this.headlower.setTextureSize(64, 32);
    	this.setRotation(headlower, 0F, 0F, 0F);
    	this.neck = new ModelRenderer(this, 56, 12);
    	this.neck.addBox(-2F, -2F, -2F, 4, 4, 4);
    	this.neck.setRotationPoint(0F, 0F, 0F);
    	this.neck.setTextureSize(64, 32);
    	this.setRotation(neck, 0F, 0F, 0F);
    	this.body = new ModelRenderer(this, 0, 14);
    	this.body.addBox(-4F, 0F, -2F, 8, 12, 4);
    	this.body.setRotationPoint(0F, 0F, 0F);
    	this.body.setTextureSize(64, 32);
    	this.setRotation(body, 0F, 0F, 0F);
    	this.rightarm = new ModelRenderer(this, 24, 14);
    	this.rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
    	this.rightarm.setRotationPoint(-5F, 2F, 0F);
    	this.rightarm.setTextureSize(64, 32);
    	this.setRotation(rightarm, 0F, 0F, 0F);
    	this.leftarm = new ModelRenderer(this, 24, 14);
    	this.leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
    	this.leftarm.setRotationPoint(5F, 2F, 0F);
    	this.leftarm.setTextureSize(64, 32);
    	this.setRotation(leftarm, 0F, 0F, 0F);
    	this.rightshoulder = new ModelRenderer(this, 56, 20);
    	this.rightshoulder.addBox(-4F, -3F, -3F, 6, 6, 6);
    	this.rightshoulder.setRotationPoint(-5F, 2F, 0F);
    	this.rightshoulder.setTextureSize(64, 32);
    	this.setRotation(rightshoulder, 0F, 0F, 0.0872665F);
    	this.rightshoulderlower = new ModelRenderer(this, 56, 32);
    	this.rightshoulderlower.addBox(-3.5F, -0.5F, -2.5F, 5, 7, 5);
    	this.rightshoulderlower.setRotationPoint(-5F, 2F, 0F);
    	this.rightshoulderlower.setTextureSize(64, 32);
    	this.setRotation(rightshoulderlower, 0F, 0F, 0F);
    	this.leftshoulder = new ModelRenderer(this, 56, 44);
    	this.leftshoulder.addBox(-1.5F, -3F, -2.5F, 5, 5, 5);
    	this.leftshoulder.setRotationPoint(5F, 2F, 0F);
    	this.leftshoulder.setTextureSize(64, 32);
    	this.setRotation(leftshoulder, 0F, 0F, -0.0872665F);
    	this.banner = new ModelRenderer(this, 88, 27);
    	this.banner.addBox(-3F, 11F, -3F, 6, 12, 4);
    	this.banner.setRotationPoint(0F, 0F, 0F);
    	this.banner.setTextureSize(64, 32);
    	this.setRotation(banner, 0F, 0F, 0F);
    	this.waist1 = new ModelRenderer(this, 88, 0);
    	this.waist1.addBox(-4.5F, 10F, -2.5F, 9, 4, 5);
    	this.waist1.setRotationPoint(0F, 0F, 0F);
    	this.waist1.setTextureSize(64, 32);
    	this.setRotation(waist1, 0F, 0F, 0F);
    	this.waist2 = new ModelRenderer(this, 88, 9);
    	this.waist2.addBox(-5F, 14F, -2F, 10, 4, 5);
    	this.waist2.setRotationPoint(0F, 0F, 0F);
    	this.waist2.setTextureSize(64, 32);
    	this.setRotation(waist2, 0F, 0F, 0F);
    	this.waist3 = new ModelRenderer(this, 88, 18);
    	this.waist3.addBox(-5.5F, 18F, -1.5F, 11, 4, 5);
    	this.waist3.setRotationPoint(0F, 0F, 0F);
    	this.waist3.setTextureSize(64, 32);
    	this.setRotation(waist3, 0F, 0F, 0F);
    	this.rightleg = new ModelRenderer(this, 40, 14);
    	this.rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
    	this.rightleg.setRotationPoint(-2F, 12F, 0F);
    	this.rightleg.setTextureSize(64, 32);
    	this.setRotation(rightleg, 0F, 0F, 0F);
    	this.leftleg = new ModelRenderer(this, 40, 14);
    	this.leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
    	this.leftleg.setRotationPoint(2F, 12F, 0F);
    	this.leftleg.setTextureSize(64, 32);
    	this.setRotation(leftleg, 0F, 0F, 0F);
    	
		this.convertToChild(head, headlower);
		this.convertToChild(rightarm, rightshoulder);
		this.convertToChild(rightarm, rightshoulderlower);
		this.convertToChild(leftarm, leftshoulder);
    }

    public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
//		this.headlower.render(par7);
		this.neck.render(par7);
		this.body.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
//		this.rightshoulder.render(par7);
//		this.rightshoulderlower.render(par7);
//		this.leftshoulder.render(par7);
		this.banner.render(par7);
		this.waist1.render(par7);
		this.waist2.render(par7);
		this.waist3.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
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
        
        this.rightarm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
        
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
