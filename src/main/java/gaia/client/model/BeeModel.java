package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Bee;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class BeeModel extends EntityModel<Bee> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodybottom;
	private final ModelPart bodymiddle;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftwing;
	private final ModelPart rightwing;
	private final ModelPart thorax1;
	private final ModelPart leftleg;
	private final ModelPart rightleg;
	private final ModelPart leftleglower;
	private final ModelPart rightleglower;

	private float offset = 0.0F;

	public BeeModel(ModelPart root) {
		this.root = root.getChild("bee");
		this.bodybottom = this.root.getChild("bodybottom");
		this.bodymiddle = this.bodybottom.getChild("bodymiddle");
		this.bodytop = this.bodymiddle.getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftwing = this.bodytop.getChild("leftwing1");
		this.rightwing = this.bodytop.getChild("rightwing1");
		this.thorax1 = this.bodybottom.getChild("thorax1");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
		this.leftleglower = this.leftleg.getChild("leftleglower");
		this.rightleglower = this.rightleg.getChild("rightleglower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bee = partdefinition.addOrReplaceChild("bee", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = bee.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -1.5F, 5.0F, 6.0F, 3.0F)
				.texOffs(36, 33).addBox(-3.5F, -6.0F, -1.5F, 7.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F)
				.texOffs(36, 14).addBox(-4.0F, -6.0F, 1.0F, 8.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.5F, -6.5F, -3.25F, 7.0F, 7.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightantenna = head.addOrReplaceChild("rightantenna", CubeListBuilder.create().texOffs(36, 25).addBox(-2.0F, -8.0F, -5.0F, 1.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition leftantenna = head.addOrReplaceChild("leftantenna", CubeListBuilder.create().texOffs(36, 25).addBox(1.0F, -8.0F, -5.0F, 1.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -1.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, 0.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(36, 39).addBox(-1.505F, 3.0F, -2.5F, 3.0F, 2.0F, 3.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, 0.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F).mirror(false)
				.texOffs(36, 39).mirror().addBox(-1.495F, 3.0F, -2.5F, 3.0F, 2.0F, 3.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition rightwing1 = bodytop.addOrReplaceChild("rightwing1", CubeListBuilder.create().texOffs(64, -10).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(1.5F, -4.0F, 1.5F, 0.5236F, 0.7854F, 0.0F));

		PartDefinition rightwing2_r1 = rightwing1.addOrReplaceChild("rightwing2_r1", CubeListBuilder.create().texOffs(64, -10).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition leftwing1 = bodytop.addOrReplaceChild("leftwing1", CubeListBuilder.create().texOffs(74, -10).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(-1.5F, -4.0F, 1.5F, 0.5236F, -0.7854F, 0.0F));

		PartDefinition leftwing2_r1 = leftwing1.addOrReplaceChild("leftwing2_r1", CubeListBuilder.create().texOffs(74, -10).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition thorax1 = bodybottom.addOrReplaceChild("thorax1", CubeListBuilder.create().texOffs(64, 6).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, -1.5F, 1.5F));

		PartDefinition thorax2 = thorax1.addOrReplaceChild("thorax2", CubeListBuilder.create().texOffs(64, 12).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition thorax3 = thorax2.addOrReplaceChild("thorax3", CubeListBuilder.create().texOffs(64, 22).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightleg = bee.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(-2.0F, -13.0F, 0.5F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.49F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F)
				.texOffs(94, 0).addBox(-2.0F, 6.0F, -0.5F, 4.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition leftleg = bee.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(2.0F, -13.0F, 0.5F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.51F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F)
				.texOffs(94, 0).addBox(-2.0F, 6.0F, -0.5F, 4.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 6.0F, -1.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Bee bee, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(bee, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !bee.isBaby();
	}

	@Override
	public void setupAnim(Bee bee, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		boolean moveExtremities;
		float armsAngleMoving;
		float legsAngleMoving;
		float defaultAngle = 0;

		boolean moving = limbSwingAmount > 0.1F;
		if (moving) {
			moveExtremities = false;
			armsAngleMoving = -(90 * Mth.DEG_TO_RAD);
			legsAngleMoving = (5 * Mth.DEG_TO_RAD);

			bodytop.xRot = (30 * Mth.DEG_TO_RAD);
			rightarm.xRot = armsAngleMoving;
			leftarm.xRot = armsAngleMoving;
			bodymiddle.xRot = (25 * Mth.DEG_TO_RAD);
			thorax1.xRot = (30 * Mth.DEG_TO_RAD);
			bodybottom.xRot = (15 * Mth.DEG_TO_RAD);
			rightleg.xRot = legsAngleMoving;
			leftleg.xRot = legsAngleMoving;
			rightleglower.xRot = (75 * Mth.DEG_TO_RAD);
			leftleglower.xRot = (75 * Mth.DEG_TO_RAD);
			head.xRot = -45F + (headPitch / 57.295776F);
		} else {
			moveExtremities = true;
			armsAngleMoving = defaultAngle;
			legsAngleMoving = defaultAngle;

			bodytop.xRot = defaultAngle;
			rightarm.xRot = armsAngleMoving;
			leftarm.xRot = armsAngleMoving;
			bodymiddle.xRot = defaultAngle;
			thorax1.xRot = defaultAngle;
			bodybottom.xRot = defaultAngle;
			rightleg.xRot = legsAngleMoving;
			leftleg.xRot = legsAngleMoving;
			rightleglower.xRot = defaultAngle;
			leftleglower.xRot = defaultAngle;
		}

		this.offset = Mth.cos(ageInTicks * 0.18F) * 0.9F;
		root.y = 24.0F - offset;

		// arms
		int animationState = bee.getAnimationState();
		if (animationState == 0) {
			if (moveExtremities) {
				rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
				leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
			}

			if (!moveExtremities) {
				rightarm.xRot = armsAngleMoving;
				leftarm.xRot = armsAngleMoving;
			}

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > 0.0F) {
				holdingMelee();
			}

			rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
		}
		if (animationState == 1) {
			animationThrow();
		}

		// body
		float swingSpeed = 0.2F;
		float angleRange = 1.0F;
		float wingDefaultAngleY = 0.7853982F;

		leftwing.yRot = Mth.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		leftwing.yRot -= wingDefaultAngleY;
		rightwing.yRot = Mth.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		rightwing.yRot += wingDefaultAngleY;

		thorax1.xRot += Mth.cos(((ageInTicks * 7) * Mth.DEG_TO_RAD)) * (2 * Mth.DEG_TO_RAD);

		// legs
		if (animationState == 0) {
			if (moveExtremities) {
				rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
				leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
			}

			float swingSpeed2 = 0.2F;
			float angleRange2 = 0.1F;

			if (!moveExtremities) {
				rightleg.xRot = legsAngleMoving;
				leftleg.xRot = legsAngleMoving;
			}

			rightleg.zRot = Mth.cos(ageInTicks * swingSpeed2 + (float) Math.PI) * angleRange2 * -0.5F;
			leftleg.zRot = Mth.cos(ageInTicks * swingSpeed2) * angleRange2 * -0.5F;
			rightleg.yRot = 0.0F;
			leftleg.yRot = 0.0F;
			rightleg.zRot = 0.0F;
			leftleg.zRot = 0.0F;
		}

		if (riding) {
			rightarm.xRot -= ((float) Math.PI / 5F);
			leftarm.xRot -= ((float) Math.PI / 5F);
			rightleg.xRot = -1.4137167F;
			rightleg.yRot = ((float) Math.PI / 10F);
			rightleg.zRot = 0.07853982F;
			leftleg.xRot = -1.4137167F;
			leftleg.yRot = -((float) Math.PI / 10F);
			leftleg.zRot = -0.07853982F;
		}
	}

	public void holdingMelee() {
		float f6;
		float f7;

		f6 = 1.0F - attackTime;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = Mth.sin(f6 * (float) Math.PI);
		float f8 = Mth.sin(attackTime * (float) Math.PI) * -(head.xRot - 0.7F) * 0.75F;

		rightarm.xRot = (float) ((double) rightarm.xRot - ((double) f7 * 1.2D + (double) f8));
		rightarm.xRot += (bodytop.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
	}

	private void animationThrow() {
		float armsAngleThrow = -(60 * Mth.DEG_TO_RAD);
		float legsAngleThrow = (20 * Mth.DEG_TO_RAD);

		rightarm.xRot = armsAngleThrow;
		leftarm.xRot = armsAngleThrow;
		rightleg.xRot = legsAngleThrow;
		leftleg.xRot = legsAngleThrow;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getHead() {
		return head;
	}

	private ModelPart getArm(HumanoidArm arm) {
		return arm == HumanoidArm.LEFT ? this.leftarm : this.rightarm;
	}

	@Override
	public void translateToHand(HumanoidArm arm, PoseStack poseStack) {
		poseStack.translate(0, 0.5, 0);
		getArm(arm).translateAndRotate(poseStack);
		poseStack.translate(0, -(offset * 0.05F), 0);
	}
}