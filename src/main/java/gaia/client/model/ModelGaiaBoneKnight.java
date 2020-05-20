package gaia.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaBoneKnight<T extends MobEntity> extends ModelGaia<T> {

	private ModelRenderer head;
	private ModelRenderer body;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer chestlower;
	private ModelRenderer chest;
	private ModelRenderer waist;
	private ModelRenderer waistlower;

	public ModelGaiaBoneKnight() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 24, 16);
		rightarm.addBox(-1F, -2F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.0872665F);
		leftarm = new ModelRenderer(this, 24, 16);
		leftarm.addBox(-1F, -2F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.0872665F);
		rightleg = new ModelRenderer(this, 32, 16);
		rightleg.addBox(-1F, 0F, -1F, 2, 12, 2);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 32, 16);
		leftleg.addBox(-1F, 0F, -1F, 2, 12, 2);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		chestlower = new ModelRenderer(this, 40, 20);
		chestlower.addBox(-3F, 3F, -4F, 6, 4, 4);
		chestlower.setRotationPoint(0F, 0F, 0F);
		chestlower.setTextureSize(64, 32);
		setRotation(chestlower, 0.1745329F, 0F, 0F);
		ModelRenderer rightshoulder = new ModelRenderer(this, 40, 0);
		rightshoulder.addBox(-3F, -3F, -3F, 6, 6, 6);
		rightshoulder.setRotationPoint(-5F, 2F, 0F);
		rightshoulder.setTextureSize(64, 32);
		setRotation(rightshoulder, 0F, 0F, -0.1745329F);
		ModelRenderer leftshoulder = new ModelRenderer(this, 64, 0);
		leftshoulder.addBox(-3F, -3F, -3F, 6, 6, 6);
		leftshoulder.setRotationPoint(5F, 2F, 0F);
		leftshoulder.setTextureSize(64, 32);
		setRotation(leftshoulder, 0F, 0F, 0.1745329F);
		ModelRenderer rightgauntlet = new ModelRenderer(this, 40, 28);
		rightgauntlet.addBox(-2.5F, 4.5F, -1.5F, 3, 6, 3);
		rightgauntlet.setRotationPoint(-5F, 2F, 0F);
		rightgauntlet.setTextureSize(64, 32);
		setRotation(rightgauntlet, 0F, 0F, 0.0872665F);
		ModelRenderer leftgauntlet = new ModelRenderer(this, 52, 28);
		leftgauntlet.addBox(-0.5F, 4.5F, -1.5F, 3, 6, 3);
		leftgauntlet.setRotationPoint(5F, 2F, 0F);
		leftgauntlet.setTextureSize(64, 32);
		setRotation(leftgauntlet, 0F, 0F, -0.0872665F);
		chest = new ModelRenderer(this, 40, 12);
		chest.addBox(-4F, 1F, -3F, 8, 4, 4);
		chest.setRotationPoint(0F, 0F, 0F);
		chest.setTextureSize(64, 32);
		setRotation(chest, -0.2617994F, 0F, 0F);
		waist = new ModelRenderer(this, 0, 32);
		waist.addBox(-4.5F, 10F, -2.5F, 9, 8, 5);
		waist.setRotationPoint(0F, 0F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0F, 0F, 0F);
		waistlower = new ModelRenderer(this, 0, 45);
		waistlower.addBox(-5F, 13F, -2F, 10, 6, 5);
		waistlower.setRotationPoint(0F, 0F, 0F);
		waistlower.setTextureSize(64, 32);
		setRotation(waistlower, 0F, 0F, 0F);
		ModelRenderer shieldbracelet = new ModelRenderer(this, 88, 0);
		shieldbracelet.addBox(0.5F, 8.5F, -1.5F, 3, 1, 3);
		shieldbracelet.setRotationPoint(5F, 2F, 0F);
		shieldbracelet.setTextureSize(64, 32);
		setRotation(shieldbracelet, 0F, 0F, -0.0872665F);
		ModelRenderer shield = new ModelRenderer(this, 88, 0);
		shield.addBox(3F, -1.5F, -6F, 1, 22, 12);
		shield.setRotationPoint(5F, 2F, 0F);
		shield.setTextureSize(64, 32);
		setRotation(shield, 0F, 0F, -0.0872665F);
		ModelRenderer rightboot = new ModelRenderer(this, 40, 37);
		rightboot.addBox(-1.5F, 6F, -1.5F, 3, 6, 3);
		rightboot.setRotationPoint(-2F, 12F, 0F);
		rightboot.setTextureSize(64, 32);
		setRotation(rightboot, 0F, 0F, 0F);
		ModelRenderer leftboot = new ModelRenderer(this, 40, 37);
		leftboot.addBox(-1.5F, 6F, -1.5F, 3, 6, 3);
		leftboot.setRotationPoint(2F, 12F, 0F);
		leftboot.setTextureSize(64, 32);
		setRotation(leftboot, 0F, 0F, 0F);

		convertToChild(rightarm, rightshoulder);
		convertToChild(leftarm, leftshoulder);
		convertToChild(rightarm, rightgauntlet);
		convertToChild(leftarm, leftgauntlet);
		convertToChild(rightleg, rightboot);
		convertToChild(leftleg, leftboot);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightarm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftarm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightleg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftleg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		chestlower.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		chest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		waist.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		waistlower.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
	}

	public void holdingMelee() {
		float f6;
		float f7;

		f6 = 1.0F - swingProgress;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = MathHelper.sin(f6 * (float) Math.PI);
		float f8 = MathHelper.sin(swingProgress * (float) Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;

		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleX += (body.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
