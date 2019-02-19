package gaia.model;

import net.minecraft.client.renderer.entity.model.ModelBlaze;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
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

//	private Random rnd = new Random();

	public boolean isAttacking;

	public ModelGaiaEnderEye() {
		textureWidth = 128;
		textureHeight = 64;

		// Used to adjust height
		float rotationPointZ = 0F;

		anchor = new ModelRenderer(this, 0, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -7F, 0F + rotationPointZ);
		anchor.setTextureSize(128, 64);
		setRotation(anchor, 0F, 0F, 0F);
		
		body = new ModelRenderer(this, 0, 0);
		body.addBox(-4F, -5F, -2F, 8, 8, 6);
		body.setRotationPoint(0F, -7F, 0F + rotationPointZ);
		body.setTextureSize(128, 64);
		setRotation(body, 0.1745329F, 0F, 0F);
		eyelid1 = new ModelRenderer(this, 0, 14);
		eyelid1.addBox(-5F, -5F, -9F, 10, 5, 10);
		eyelid1.setRotationPoint(0F, -9F, 4.5F + rotationPointZ);
		eyelid1.setTextureSize(128, 64);
		setRotation(eyelid1, 0.0349066F, 0F, 0F);
		eyelid2 = new ModelRenderer(this, 0, 29);
		eyelid2.addBox(-5F, 0F, -9F, 10, 5, 10);
		eyelid2.setRotationPoint(0F, -9F, 4.5F + rotationPointZ);
		eyelid2.setTextureSize(128, 64);
		setRotation(eyelid2, 0.3490659F, 0F, 0F);
		rightwing = new ModelRenderer(this, 98, 38);
		rightwing.addBox(0F, 0F, -5F, 0, 16, 10);
		rightwing.setRotationPoint(-4F, -9F, 5F + rotationPointZ);
		rightwing.setTextureSize(128, 64);
		setRotation(rightwing, 0F, 0F, 1.570796F);
		leftwing = new ModelRenderer(this, 108, 38);
		leftwing.addBox(0F, 0F, -6F, 0, 16, 10);
		leftwing.setRotationPoint(4F, -9F, 5F + rotationPointZ);
		leftwing.setTextureSize(128, 64);
		setRotation(leftwing, 0F, 0F, -1.570796F);
		tail1 = new ModelRenderer(this, 0, 44);
		tail1.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
		tail1.setRotationPoint(0F, -6F, 4F + rotationPointZ);
		tail1.setTextureSize(128, 64);
		setRotation(tail1, 0.7853982F, 0F, 0F);
		tail2 = new ModelRenderer(this, 0, 50);
		tail2.addBox(-1F, 3F, -0.5F, 2, 4, 2);
		tail2.setRotationPoint(0F, -6F, 4F + rotationPointZ);
		tail2.setTextureSize(128, 64);
		setRotation(tail2, 0.6108652F, 0F, 0F);
		tail3 = new ModelRenderer(this, 0, 56);
		tail3.addBox(-0.5F, 6F, 1F, 1, 4, 1);
		tail3.setRotationPoint(0F, -6F, 4F + rotationPointZ);
		tail3.setTextureSize(128, 64);
		setRotation(tail3, 0.4363323F, 0F, 0F);

		anchor.addChild(body);
		anchor.addChild(eyelid1);
		anchor.addChild(eyelid2);
		anchor.addChild(rightwing);
		anchor.addChild(leftwing);
		anchor.addChild(tail1);
		convertToChild(tail1, tail2);
		convertToChild(tail1, tail3);
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
		float floatSpeed = 0.5F;
		float floatRange = 3.0F;

		// anchor
		anchor.rotationPointY = -2.0F + MathHelper.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;

		// body
		body.rotateAngleY = netHeadYaw / 57.295776F;
		
		float swingSpeed = 0.5F;
		float angleRange = 0.2F;

		eyelid1.rotateAngleX = MathHelper.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		eyelid2.rotateAngleX = MathHelper.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		eyelid2.rotateAngleX = degToRad(20);

		float swingSpeed2 = 0.5F;
		float angleRange2 = 1.0F;
		float wingDefaultAngleZ = 1.570796F;
		
		rightwing.rotateAngleZ = MathHelper.cos(ageInTicks * swingSpeed2 + (float) Math.PI) * angleRange2 * 0.5F;
		rightwing.rotateAngleZ += wingDefaultAngleZ;
		leftwing.rotateAngleZ = MathHelper.cos(ageInTicks * swingSpeed2) * angleRange2 * 0.5F;
		leftwing.rotateAngleZ -= wingDefaultAngleZ;
		
		float tailDefaultAngleX = 0.7853982F;
		
		tail1.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(5);
		tail1.rotateAngleX += tailDefaultAngleX;
	}
}
