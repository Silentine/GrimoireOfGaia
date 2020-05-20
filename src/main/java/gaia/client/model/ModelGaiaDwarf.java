package gaia.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import gaia.entity.assist.GaiaDwarfEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.item.BowItem;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaDwarf<T extends GaiaDwarfEntity> extends ModelGaia<T> {

	private ModelRenderer head;
	private ModelRenderer headlight;
	private ModelRenderer neck;
	private ModelRenderer body;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;

	public ModelGaiaDwarf() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 4F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		ModelRenderer headaccessory = new ModelRenderer(this, 64, 0);
		headaccessory.addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9);
		headaccessory.setRotationPoint(0F, 4F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		headlight = new ModelRenderer(this, 64, 44);
		headlight.addBox(-1.5F, -9F, -5F, 3, 3, 3);
		headlight.setRotationPoint(0F, 4F, 0F);
		setRotation(headlight, 0F, 0F, 0F);
		ModelRenderer headbeard = new ModelRenderer(this, 64, 18);
		headbeard.addBox(-4.5F, -2F, -4.5F, 9, 9, 9);
		headbeard.setRotationPoint(0F, 4F, 0F);
		headbeard.setTextureSize(64, 32);
		setRotation(headbeard, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 64, 36);
		neck.addBox(-2F, -4F, -2F, 4, 4, 4);
		neck.setRotationPoint(0F, 4F, 0F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 16);
		body.addBox(-4F, -2F, -2F, 8, 10, 4);
		body.setRotationPoint(0F, 6F, 0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0F, 0F, 0F);
		ModelRenderer rightarmpauldron = new ModelRenderer(this, 100, 0);
		rightarmpauldron.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5);
		rightarmpauldron.setRotationPoint(-5F, 6F, 0F);
		rightarmpauldron.setTextureSize(64, 32);
		setRotation(rightarmpauldron, 0F, 0F, 0F);
		ModelRenderer leftarmpauldron = new ModelRenderer(this, 100, 0);
		leftarmpauldron.mirror = true;
		leftarmpauldron.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5);
		leftarmpauldron.setRotationPoint(5F, 6F, 0F);
		leftarmpauldron.setTextureSize(64, 32);
		setRotation(leftarmpauldron, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 24, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 10, 4);
		rightarm.setRotationPoint(-5F, 6F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 24, 16);
		leftarm.mirror = true;
		leftarm.addBox(-1F, -2F, -2F, 4, 10, 4);
		leftarm.setRotationPoint(5F, 6F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, 0F);
		ModelRenderer rightarmgauntlet = new ModelRenderer(this, 100, 10);
		rightarmgauntlet.addBox(-3.5F, 3.5F, -2.5F, 5, 5, 5);
		rightarmgauntlet.setRotationPoint(-5F, 6F, 0F);
		rightarmgauntlet.setTextureSize(64, 32);
		setRotation(rightarmgauntlet, 0F, 0F, 0F);
		ModelRenderer leftarmgauntlet = new ModelRenderer(this, 100, 10);
		leftarmgauntlet.mirror = true;
		leftarmgauntlet.addBox(-1.5F, 3.5F, -2.5F, 5, 5, 5);
		leftarmgauntlet.setRotationPoint(5F, 6F, 0F);
		leftarmgauntlet.setTextureSize(64, 32);
		setRotation(leftarmgauntlet, 0F, 0F, 0F);
		ModelRenderer rightlegupper = new ModelRenderer(this, 100, 20);
		rightlegupper.addBox(-2.5F, 0F, -2.5F, 5, 5, 5);
		rightlegupper.setRotationPoint(-2F, 14F, 0F);
		rightlegupper.setTextureSize(64, 32);
		setRotation(rightlegupper, 0F, 0F, 0F);
		ModelRenderer leftlegupper = new ModelRenderer(this, 100, 20);
		leftlegupper.mirror = true;
		leftlegupper.addBox(-2.5F, 0F, -2.5F, 5, 5, 5);
		leftlegupper.setRotationPoint(2F, 14F, 0F);
		leftlegupper.setTextureSize(64, 32);
		setRotation(leftlegupper, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 40, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 10, 4);
		rightleg.setRotationPoint(-2F, 14F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 40, 16);
		leftleg.mirror = true;
		leftleg.addBox(-2F, 0F, -2F, 4, 10, 4);
		leftleg.setRotationPoint(2F, 14F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		ModelRenderer rightlegboot = new ModelRenderer(this, 100, 30);
		rightlegboot.addBox(-2.5F, 5F, -2.5F, 5, 5, 5);
		rightlegboot.setRotationPoint(-2F, 14F, 0F);
		rightlegboot.setTextureSize(64, 32);
		setRotation(rightlegboot, 0F, 0F, 0F);
		ModelRenderer leftlegboot = new ModelRenderer(this, 100, 30);
		leftlegboot.mirror = true;
		leftlegboot.addBox(-2.5F, 5F, -2.5F, 5, 5, 5);
		leftlegboot.setRotationPoint(2F, 14F, 0F);
		leftlegboot.setTextureSize(64, 32);
		setRotation(leftlegboot, 0F, 0F, 0F);

		convertToChild(head, headaccessory);
		convertToChild(head, headlight);
		convertToChild(head, headbeard);
		convertToChild(rightarm, rightarmpauldron);
		convertToChild(leftarm, leftarmpauldron);
		convertToChild(rightarm, rightarmgauntlet);
		convertToChild(leftarm, leftarmgauntlet);
		convertToChild(rightleg, rightlegupper);
		convertToChild(leftleg, leftlegupper);
		convertToChild(rightleg, rightlegboot);
		convertToChild(leftleg, leftlegboot);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		neck.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightarm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftarm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightleg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftleg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		if (entityIn.getMobType() == 2) {
			headlight.showModel = true;
		} else {
			headlight.showModel = false;
		}

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (entityIn.isAggressive() && (entityIn.getHeldItemMainhand().getItem() instanceof BowItem)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// legs (walk_normal)
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2F);
		rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
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
