package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaCreep extends ModelGaia {
	ModelRenderer head1;
	ModelRenderer head2;
	ModelRenderer head3;
	ModelRenderer smallhead1;
	ModelRenderer smallhead2;
	ModelRenderer smallhead3;
    ModelRenderer body1;
    ModelRenderer body2;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer leg5;
	ModelRenderer leg6;

	public ModelGaiaCreep() {
		this(0.0F);
	}

	public ModelGaiaCreep(float limbSwing) {
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.head1 = new ModelRenderer(this, 0, 0);
		this.head1.addBox(-4.0F, -4.0F, -10.0F, 8, 8, 8);
		this.head1.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.head1.setTextureSize(64, 32);
		this.setRotation(this.head1, -0.6108652F, 0.7853982F, -0.0872665F);
		this.head2 = new ModelRenderer(this, 0, 0);
		this.head2.addBox(-4.0F, -4.0F, -10.0F, 8, 8, 8);
		this.head2.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.head2.setTextureSize(64, 32);
		this.setRotation(this.head2, -0.2617994F, -0.7853982F, 0.0872665F);
		this.head3 = new ModelRenderer(this, 0, 0);
		this.head3.addBox(-4.0F, -4.0F, -10.0F, 8, 8, 8);
		this.head3.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.head3.setTextureSize(64, 32);
		this.setRotation(this.head3, -0.4363323F, -3.141593F, 0.0F);
		this.smallhead1 = new ModelRenderer(this, 0, 16);
		this.smallhead1.addBox(-3.0F, -3.0F, -9.0F, 6, 6, 6);
		this.smallhead1.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.smallhead1.setTextureSize(64, 32);
		this.setRotation(this.smallhead1, -0.2617994F, 2.094395F, 0.0872665F);
		this.smallhead2 = new ModelRenderer(this, 0, 16);
		this.smallhead2.addBox(-3.0F, -3.0F, -9.0F, 6, 6, 6);
		this.smallhead2.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.smallhead2.setTextureSize(64, 32);
		this.setRotation(this.smallhead2, -0.1745329F, -2.094395F, -0.0872665F);
		this.smallhead3 = new ModelRenderer(this, 0, 16);
		this.smallhead3.addBox(-3.0F, -3.0F, -9.0F, 6, 6, 6);
		this.smallhead3.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.smallhead3.setTextureSize(64, 32);
		this.setRotation(this.smallhead3, 0.0872665F, 0.0F, 0.0872665F);
		this.body1 = new ModelRenderer(this, 0, 0);
		this.body1.addBox(-4F, -4F, 2F, 8, 8, 8);
		this.body1.setRotationPoint(0F, 15F, 0F);
		this.body1.setTextureSize(64, 32);
		this.setRotation(body1, 1.570796F, 0.3490659F, 0F);
		this.body2 = new ModelRenderer(this, 32, 0);
		this.body2.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.body2.setRotationPoint(0F, 18F, 0F);
		this.body2.setTextureSize(64, 32);
		this.setRotation(body2, 0F, 0F, 0F);
		this.leg1 = new ModelRenderer(this, 32, 12);
		this.leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		this.leg1.setRotationPoint(-2.5F, 18.0F, -4.0F);
		this.leg1.setTextureSize(64, 32);
		this.setRotation(this.leg1, 0.0F, 0.2617994F, 0.0F);
		this.leg2 = new ModelRenderer(this, 32, 12);
		this.leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		this.leg2.setRotationPoint(2.5F, 18.0F, -4.0F);
		this.leg2.setTextureSize(64, 32);
		this.setRotation(this.leg2, 0.0F, -0.2617994F, 0.0F);
		this.leg3 = new ModelRenderer(this, 32, 12);
		this.leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		this.leg3.setRotationPoint(5.0F, 18.0F, 0.0F);
		this.leg3.setTextureSize(64, 32);
		this.setRotation(this.leg3, 0.0F, -1.570796F, 0.0F);
		this.leg4 = new ModelRenderer(this, 48, 12);
		this.leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		this.leg4.setRotationPoint(2.5F, 18.0F, 4.0F);
		this.leg4.setTextureSize(64, 32);
		this.setRotation(this.leg4, 0.0F, 0.2617994F, 0.0F);
		this.leg5 = new ModelRenderer(this, 48, 12);
		this.leg5.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		this.leg5.setRotationPoint(-2.5F, 18.0F, 4.0F);
		this.leg5.setTextureSize(64, 32);
		this.setRotation(this.leg5, 0.0F, -0.2617994F, 0.0F);
		this.leg6 = new ModelRenderer(this, 32, 12);
		this.leg6.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		this.leg6.setRotationPoint(-5.0F, 18.0F, 0.0F);
		this.leg6.setTextureSize(64, 32);
		this.setRotation(this.leg6, 0.0F, 1.570796F, 0.0F);
		
		this.convertToChild(leg1, leg3);
		this.convertToChild(leg1, leg5);
		this.convertToChild(leg2, leg4);
		this.convertToChild(leg2, leg6);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head1.render(scale);
		this.head2.render(scale);
		this.head3.render(scale);
		this.smallhead1.render(scale);
		this.smallhead2.render(scale);
		this.smallhead3.render(scale);
		this.body1.render(scale);
		this.body2.render(scale);
		this.leg1.render(scale);
		this.leg2.render(scale);
//		this.leg3.render(scale);
//		this.leg4.render(scale);
//		this.leg5.render(scale);
//		this.leg6.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head1.rotateAngleX = MathHelper.cos(ageInTicks * 0.8F + (float)Math.PI) * 0.4F * limbSwingAmount * 0.5F;
		this.head2.rotateAngleX = this.head1.rotateAngleX - 0.2617994F;
		this.head3.rotateAngleX = this.head1.rotateAngleX - 0.4363323F;
		this.head1.rotateAngleX -= 0.6108652F;
		this.smallhead1.rotateAngleX = MathHelper.cos(ageInTicks * 1.2F + (float)Math.PI) * 0.6F * limbSwingAmount * 0.5F;
		this.smallhead2.rotateAngleX = this.smallhead1.rotateAngleX - 0.1745329F;
		this.smallhead3.rotateAngleX = this.smallhead1.rotateAngleX + 0.0872665F;
		this.smallhead1.rotateAngleX -= 0.2617994F;
		
		//body
		this.body1.rotateAngleY = netHeadYaw / 57.295776F;
		this.body1.rotateAngleX = headPitch / 57.295776F;
		this.body2.rotateAngleY = this.body1.rotateAngleY;
		this.body2.rotateAngleX = this.body1.rotateAngleX;
		this.body1.rotateAngleY = this.body1.rotateAngleY + 0.3490659F;
		this.body1.rotateAngleX = this.body1.rotateAngleX + 1.570796F;
		
		//legs
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	public void renderAll() {}
}
