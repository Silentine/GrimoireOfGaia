package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaCreep<T extends MobEntity> extends ModelGaia<T> {
	private RendererModel head1;
	private RendererModel head2;
	private RendererModel head3;
	private RendererModel smallhead1;
	private RendererModel smallhead2;
	private RendererModel smallhead3;
	private RendererModel body1;
	private RendererModel body2;
	private RendererModel leg1;
	private RendererModel leg2;
	private RendererModel leg3;
	private RendererModel leg4;
	private RendererModel leg5;
	private RendererModel leg6;

	public ModelGaiaCreep() {
		textureWidth = 64;
		textureHeight = 32;

		head1 = new RendererModel(this, 0, 0);
		head1.addBox(-4.0F, -4.0F, -10.0F, 8, 8, 8);
		head1.setRotationPoint(0.0F, 15.0F, 0.0F);
		head1.setTextureSize(64, 32);
		setRotation(head1, -0.6108652F, 0.7853982F, -0.0872665F);
		head2 = new RendererModel(this, 0, 0);
		head2.addBox(-4.0F, -4.0F, -10.0F, 8, 8, 8);
		head2.setRotationPoint(0.0F, 15.0F, 0.0F);
		head2.setTextureSize(64, 32);
		setRotation(head2, -0.2617994F, -0.7853982F, 0.0872665F);
		head3 = new RendererModel(this, 0, 0);
		head3.addBox(-4.0F, -4.0F, -10.0F, 8, 8, 8);
		head3.setRotationPoint(0.0F, 15.0F, 0.0F);
		head3.setTextureSize(64, 32);
		setRotation(head3, -0.4363323F, -3.141593F, 0.0F);
		smallhead1 = new RendererModel(this, 0, 16);
		smallhead1.addBox(-3.0F, -3.0F, -9.0F, 6, 6, 6);
		smallhead1.setRotationPoint(0.0F, 15.0F, 0.0F);
		smallhead1.setTextureSize(64, 32);
		setRotation(smallhead1, -0.2617994F, 2.094395F, 0.0872665F);
		smallhead2 = new RendererModel(this, 0, 16);
		smallhead2.addBox(-3.0F, -3.0F, -9.0F, 6, 6, 6);
		smallhead2.setRotationPoint(0.0F, 15.0F, 0.0F);
		smallhead2.setTextureSize(64, 32);
		setRotation(smallhead2, -0.1745329F, -2.094395F, -0.0872665F);
		smallhead3 = new RendererModel(this, 0, 16);
		smallhead3.addBox(-3.0F, -3.0F, -9.0F, 6, 6, 6);
		smallhead3.setRotationPoint(0.0F, 15.0F, 0.0F);
		smallhead3.setTextureSize(64, 32);
		setRotation(smallhead3, 0.0872665F, 0.0F, 0.0872665F);
		body1 = new RendererModel(this, 0, 0);
		body1.addBox(-4F, -4F, 2F, 8, 8, 8);
		body1.setRotationPoint(0F, 15F, 0F);
		body1.setTextureSize(64, 32);
		setRotation(body1, 1.570796F, 0.3490659F, 0F);
		body2 = new RendererModel(this, 32, 0);
		body2.addBox(-3F, -6F, -3F, 6, 6, 6);
		body2.setRotationPoint(0F, 18F, 0F);
		body2.setTextureSize(64, 32);
		setRotation(body2, 0F, 0F, 0F);
		leg1 = new RendererModel(this, 32, 12);
		leg1.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		leg1.setRotationPoint(-2.5F, 18.0F, -4.0F);
		leg1.setTextureSize(64, 32);
		setRotation(leg1, 0.0F, 0.2617994F, 0.0F);
		leg2 = new RendererModel(this, 32, 12);
		leg2.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		leg2.setRotationPoint(2.5F, 18.0F, -4.0F);
		leg2.setTextureSize(64, 32);
		setRotation(leg2, 0.0F, -0.2617994F, 0.0F);
		leg3 = new RendererModel(this, 32, 12);
		leg3.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		leg3.setRotationPoint(5.0F, 18.0F, 0.0F);
		leg3.setTextureSize(64, 32);
		setRotation(leg3, 0.0F, -1.570796F, 0.0F);
		leg4 = new RendererModel(this, 48, 12);
		leg4.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		leg4.setRotationPoint(2.5F, 18.0F, 4.0F);
		leg4.setTextureSize(64, 32);
		setRotation(leg4, 0.0F, 0.2617994F, 0.0F);
		leg5 = new RendererModel(this, 48, 12);
		leg5.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		leg5.setRotationPoint(-2.5F, 18.0F, 4.0F);
		leg5.setTextureSize(64, 32);
		setRotation(leg5, 0.0F, -0.2617994F, 0.0F);
		leg6 = new RendererModel(this, 32, 12);
		leg6.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4);
		leg6.setRotationPoint(-5.0F, 18.0F, 0.0F);
		leg6.setTextureSize(64, 32);
		setRotation(leg6, 0.0F, 1.570796F, 0.0F);

		convertToChild(leg1, leg3);
		convertToChild(leg1, leg5);
		convertToChild(leg2, leg4);
		convertToChild(leg2, leg6);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head1.render(scale);
		head2.render(scale);
		head3.render(scale);
		smallhead1.render(scale);
		smallhead2.render(scale);
		smallhead3.render(scale);
		body1.render(scale);
		body2.render(scale);
		leg1.render(scale);
		leg2.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		// head
		head1.rotateAngleX = MathHelper.cos(ageInTicks * 0.8F + (float) Math.PI) * 0.4F * limbSwingAmount * 0.5F;
		head2.rotateAngleX = head1.rotateAngleX - 0.2617994F;
		head3.rotateAngleX = head1.rotateAngleX - 0.4363323F;
		head1.rotateAngleX -= 0.6108652F;
		smallhead1.rotateAngleX = MathHelper.cos(ageInTicks * 1.2F + (float) Math.PI) * 0.6F * limbSwingAmount * 0.5F;
		smallhead2.rotateAngleX = smallhead1.rotateAngleX - 0.1745329F;
		smallhead3.rotateAngleX = smallhead1.rotateAngleX + 0.0872665F;
		smallhead1.rotateAngleX -= 0.2617994F;

		// body
		body1.rotateAngleY = netHeadYaw / 57.295776F;
		body1.rotateAngleX = headPitch / 57.295776F;
		body2.rotateAngleY = body1.rotateAngleY;
		body2.rotateAngleX = body1.rotateAngleX;
		body1.rotateAngleY = body1.rotateAngleY + 0.3490659F;
		body1.rotateAngleX = body1.rotateAngleX + 1.570796F;

		// legs
		leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		leg5.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		leg6.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}
}
