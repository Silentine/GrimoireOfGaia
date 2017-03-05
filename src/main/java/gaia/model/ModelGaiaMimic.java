package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMimic extends ModelBase {
	ModelRenderer anchor;
	ModelRenderer lid1;
	ModelRenderer lid2;
	ModelRenderer lock;
	ModelRenderer teeth1;
	ModelRenderer teeth2;
	ModelRenderer rot;

	public ModelGaiaMimic() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.anchor = new ModelRenderer(this, 0, 19);
		this.anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		this.anchor.setRotationPoint(0.0F, 5.0F, 7.0F);
		this.anchor.setTextureSize(128, 64);
		this.setRotation(anchor, 0F, 0F, 0F);
		this.lid1 = new ModelRenderer(this, 0, 0);
		this.lid1.addBox(-7.0F, -5.0F, -14.0F, 14, 5, 14);
		this.lid1.setRotationPoint(0.0F, 5.0F, 7.0F);
		this.lid1.setTextureSize(128, 64);
		this.setRotation(this.lid1, -0.69813174F, 0.0F, 0.0F);
		this.lid2 = new ModelRenderer(this, 0, 19);
		this.lid2.addBox(-7.0F, 0.0F, -14.0F, 14, 10, 14);
		this.lid2.setRotationPoint(0.0F, 5.0F, 7.0F);
		this.lid2.setTextureSize(128, 64);
		this.setRotation(this.lid2, 0.3490659F, 0.0F, 0.0F);
		this.lock = new ModelRenderer(this, 0, 0);
		this.lock.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1);
		this.lock.setRotationPoint(0.0F, 5.0F, 7.0F);
		this.lock.setTextureSize(128, 64);
		this.setRotation(this.lock, -0.69813174F, 0.0F, 0.0F);
		this.teeth1 = new ModelRenderer(this, 56, 20);
		this.teeth1.addBox(-6.0F, -4.0F, -13.0F, 12, 8, 12);
		this.teeth1.setRotationPoint(0.0F, 5.0F, 7.0F);
		this.teeth1.setTextureSize(128, 64);
		this.setRotation(this.teeth1, 0.3490659F, 0.0F, 0.0F);
		this.teeth2 = new ModelRenderer(this, 56, 0);
		this.teeth2.addBox(-6.0F, -3.0F, -13.0F, 12, 8, 12);
		this.teeth2.setRotationPoint(0.0F, 5.0F, 7.0F);
		this.teeth2.setTextureSize(128, 64);
		this.setRotation(this.teeth2, -0.69813174F, 0.0F, 0.0F);
		this.rot = new ModelRenderer(this, 56, 40);
		this.rot.addBox(-5.0F, -7.0F, -11.0F, 10, 14, 10);
		this.rot.setRotationPoint(0.0F, 5.0F, 7.0F);
		this.rot.setTextureSize(128, 64);
		this.setRotation(this.rot, -0.1745329F, 0.0F, 0.0F);
		
		this.anchor.addChild(lid1);
		this.anchor.addChild(lid2);
		this.anchor.addChild(lock);
		this.anchor.addChild(teeth1);
		this.anchor.addChild(teeth2);
		this.anchor.addChild(rot);
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
        
		//body
		this.lid1.rotateAngleX = MathHelper.cos(par3 * 1.8F + (float)Math.PI) * 0.8F * 0.5F;
		this.lid2.rotateAngleX = MathHelper.cos(par3 * 1.8F) * 0.8F * 0.5F;
		this.lock.rotateAngleX = this.lid1.rotateAngleX - 0.69813174F;
		this.lid1.rotateAngleX -= 0.69813174F;
		this.lid2.rotateAngleX += 0.3490659F;
		this.teeth1.rotateAngleX = MathHelper.cos(par3 * 1.8F) * 0.4F * 0.5F;
		this.teeth2.rotateAngleX = MathHelper.cos(par3 * 1.8F + (float)Math.PI) * 0.4F * 0.5F;
		this.teeth1.rotateAngleX += 0.3490659F;
		this.teeth2.rotateAngleX -= 0.69813174F;
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
