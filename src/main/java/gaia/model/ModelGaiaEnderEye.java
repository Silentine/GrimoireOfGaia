package gaia.model;

import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaEnderEye extends ModelGaia {

	private ModelRenderer anchor;
	private ModelRenderer body;
	private ModelRenderer eyelid1;
	private ModelRenderer eyelid2;
	private ModelRenderer rightwing;
	private ModelRenderer leftwing;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;

	public ModelGaiaEnderEye() {
		textureWidth = 128;
		textureHeight = 64;

		anchor = new ModelRenderer(this, 0, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -7F, 0F);
		anchor.setTextureSize(128, 64);
		setRotation(anchor, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 0);
		body.addBox(-4F, -5F, -2F, 8, 8, 6);
		body.setRotationPoint(0F, -7F, 0F);
		body.setTextureSize(128, 64);
		setRotation(body, 0.1745329F, 0F, 0F);
		eyelid1 = new ModelRenderer(this, 0, 14);
		eyelid1.addBox(-5F, -5F, -9F, 10, 5, 10);
		eyelid1.setRotationPoint(0F, -9F, 4.5F);
		eyelid1.setTextureSize(128, 64);
		setRotation(eyelid1, 0.0349066F, 0F, 0F);
		eyelid2 = new ModelRenderer(this, 0, 29);
		eyelid2.addBox(-5F, 0F, -9F, 10, 5, 10);
		eyelid2.setRotationPoint(0F, -9F, 4.5F);
		eyelid2.setTextureSize(128, 64);
		setRotation(eyelid2, 0.3490659F, 0F, 0F);
		rightwing = new ModelRenderer(this, 98, 38);
		rightwing.addBox(0F, 0F, -5F, 0, 16, 10);
		rightwing.setRotationPoint(-4F, -9F, 5F);
		rightwing.setTextureSize(128, 64);
		setRotation(rightwing, 0F, 0F, 1.570796F);
		leftwing = new ModelRenderer(this, 108, 38);
		leftwing.addBox(0F, 0F, -6F, 0, 16, 10);
		leftwing.setRotationPoint(4F, -9F, 5F);
		leftwing.setTextureSize(128, 64);
		setRotation(leftwing, 0F, 0F, -1.570796F);
		tail1 = new ModelRenderer(this, 0, 44);
		tail1.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
		tail1.setRotationPoint(0F, -6F, 4F);
		tail1.setTextureSize(128, 64);
		setRotation(tail1, 0.7853982F, 0F, 0F);
		tail2 = new ModelRenderer(this, 0, 50);
		tail2.addBox(-1F, 3F, -0.5F, 2, 4, 2);
		tail2.setRotationPoint(0F, -6F, 4F);
		tail2.setTextureSize(128, 64);
		setRotation(tail2, 0.6108652F, 0F, 0F);
		tail3 = new ModelRenderer(this, 0, 56);
		tail3.addBox(-0.5F, 6F, 1F, 1, 4, 1);
		tail3.setRotationPoint(0F, -6F, 4F);
		tail3.setTextureSize(128, 64);
		setRotation(tail3, 0.4363323F, 0F, 0F);

		anchor.addChild(body);
		anchor.addChild(eyelid1);
		anchor.addChild(eyelid2);
		anchor.addChild(rightwing);
		anchor.addChild(leftwing);
		anchor.addChild(tail1);
		anchor.addChild(tail2);
		anchor.addChild(tail3);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);
	}

	/**
	 * @see ModelBlaze
	 */
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// anchor
		anchor.rotationPointY = -2.0F + MathHelper.cos((1.5F + ageInTicks) * 0.5F) * 0.5F;

		// body
		body.rotateAngleY = netHeadYaw / 57.295776F;
		eyelid1.rotateAngleX = MathHelper.cos(ageInTicks * 0.4F + (float) Math.PI) * 0.2F * 0.5F;
		eyelid1.rotateAngleX += 0.0349066F;
		eyelid2.rotateAngleX = MathHelper.cos(ageInTicks * 0.4F) * 0.08F * 0.5F;
		eyelid2.rotateAngleX += 0.3490659F;
		rightwing.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F + (float) Math.PI) * 1.6F * 0.5F;
		rightwing.rotateAngleZ = rightwing.rotateAngleZ + 1.570796F;
		leftwing.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F) * 1.6F * 0.5F;
		leftwing.rotateAngleZ = leftwing.rotateAngleZ - 1.570796F;
		tail1.rotateAngleX = MathHelper.cos(ageInTicks * 1.2F + (float) Math.PI) * 0.2F * 0.5F;
		tail1.rotateAngleX += 0.7853982F;
		tail2.rotateAngleX = MathHelper.cos(ageInTicks * 1.2F + (float) Math.PI) * 0.2F * 0.5F;
		tail2.rotateAngleX += 0.6108652F;
		tail3.rotateAngleX = MathHelper.cos(ageInTicks * 1.2F + (float) Math.PI) * 0.2F * 0.5F;
		tail3.rotateAngleX += 0.4363323F;
	}
}
