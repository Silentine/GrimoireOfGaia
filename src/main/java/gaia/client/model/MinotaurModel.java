package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Minotaur;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class MinotaurModel extends EntityModel<Minotaur> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftarmlower;
	private final ModelPart rightarmlower;
	private final ModelPart leftleg;
	private final ModelPart rightleg;
	private final ModelPart[] righthorn = new ModelPart[5];
	private final ModelPart[] lefthorn = new ModelPart[5];

	public MinotaurModel(ModelPart root) {
		this.root = root.getChild("minotaur");
		ModelPart body3 = this.root.getChild("body3");
		ModelPart body2 = body3.getChild("body2");
		this.body = body2.getChild("body");

		this.head = this.body.getChild("head");
		this.leftarm = this.body.getChild("leftarm");
		this.rightarm = this.body.getChild("rightarm");
		this.leftarmlower = this.leftarm.getChild("leftarmlower");
		this.rightarmlower = this.rightarm.getChild("rightarmlower");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");

		for (int i = 0; i < 5; i++) {
			int index = i + 1;
			if (index == 1) {
				this.righthorn[i] = this.head.getChild("righthorn" + index);
				this.lefthorn[i] = this.head.getChild("lefthorn" + index);
			} else {
				this.righthorn[i] = this.righthorn[i - 1].getChild("righthorn" + index);
				this.lefthorn[i] = this.lefthorn[i - 1].getChild("lefthorn" + index);
			}
		}
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition minotaur = partdefinition.addOrReplaceChild("minotaur", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body3 = minotaur.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(0, 54).addBox(-4.0F, 16.0F, -1.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(66, 0).addBox(-4.5F, 16.0F, -1.5F, 9.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -36.0F, 0.0F));

		PartDefinition body2 = body3.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 43).addBox(-5.0F, -5.0F, -6.0F, 10.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 4.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition body = body2.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 26).addBox(-6.0F, -9.0F, -8.0F, 12.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(88, 34).addBox(-6.0F, -9.0F, -8.0F, 12.0F, 9.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 15).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -7.0F, -4.0F, 7.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(30, 0).addBox(-3.0F, -6.0F, -6.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(30, 4).addBox(-2.5F, -4.0F, -9.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -8.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition neck_back_r1 = head.addOrReplaceChild("neck_back_r1", CubeListBuilder.create().texOffs(96, 22).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 4.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition righthorn1 = head.addOrReplaceChild("righthorn1", CubeListBuilder.create().texOffs(50, 0).addBox(-3.0F, 0.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -8.5F, -2.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition righthorn2 = righthorn1.addOrReplaceChild("righthorn2", CubeListBuilder.create().texOffs(50, 6).addBox(-2.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 0.0F, 0.0F, -0.3491F, 0.3491F));

		PartDefinition righthorn3 = righthorn2.addOrReplaceChild("righthorn3", CubeListBuilder.create().texOffs(50, 12).addBox(-2.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.3491F));

		PartDefinition righthorn4 = righthorn3.addOrReplaceChild("righthorn4", CubeListBuilder.create().texOffs(50, 18).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.3491F));

		PartDefinition righthorn5 = righthorn4.addOrReplaceChild("righthorn5", CubeListBuilder.create().texOffs(58, 18).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.3491F));

		PartDefinition lefthorn1 = head.addOrReplaceChild("lefthorn1", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-1.0F, 0.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, -8.5F, -2.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition lefthorn2 = lefthorn1.addOrReplaceChild("lefthorn2", CubeListBuilder.create().texOffs(50, 6).addBox(0.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 0.0F, 0.0F, 0.3491F, -0.3491F));

		PartDefinition lefthorn3 = lefthorn2.addOrReplaceChild("lefthorn3", CubeListBuilder.create().texOffs(50, 12).addBox(0.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.3491F, -0.3491F));

		PartDefinition lefthorn4 = lefthorn3.addOrReplaceChild("lefthorn4", CubeListBuilder.create().texOffs(50, 18).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.3491F, -0.3491F));

		PartDefinition lefthorn5 = lefthorn4.addOrReplaceChild("lefthorn5", CubeListBuilder.create().texOffs(58, 18).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.1745F, -0.3491F));

		PartDefinition nosering = head.addOrReplaceChild("nosering", CubeListBuilder.create().texOffs(30, 13).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -9.5F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(50, 23).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -6.0F, -4.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(50, 37).addBox(-2.005F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(50, 49).addBox(-2.005F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-1.0F, 8.0F, 2.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition rightarmlowerchain_r1 = rightarmlower.addOrReplaceChild("rightarmlowerchain_r1", CubeListBuilder.create().texOffs(30, 18).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 4.0F, -2.0F, 0.3491F, 0.0F, 0.2618F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(50, 23).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(96, 0).addBox(-2.0F, -2.5F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(96, 12).mirror().addBox(-1.5F, 3.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -6.0F, -4.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(50, 37).mirror().addBox(-1.995F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(50, 49).mirror().addBox(-1.995F, 0.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, 2.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition leftarmlowerchain_r1 = leftarmlower.addOrReplaceChild("leftarmlowerchain_r1", CubeListBuilder.create().texOffs(30, 18).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 4.0F, -2.0F, 0.3491F, 0.0F, -0.2618F));

		PartDefinition rightleg = minotaur.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(66, 14).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -17.0F, 2.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(66, 27).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightleglowerfoot = rightleglower.addOrReplaceChild("rightleglowerfoot", CubeListBuilder.create().texOffs(66, 36).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -3.0F, 6.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition rightfoot = rightleglowerfoot.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(66, 51).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition rightfoothoof = rightfoot.addOrReplaceChild("rightfoothoof", CubeListBuilder.create().texOffs(66, 47).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition leftleg = minotaur.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(66, 14).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -17.0F, 2.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(66, 27).mirror().addBox(-1.5F, -3.0F, 0.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, -2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition leftleglowerfoot = leftleglower.addOrReplaceChild("leftleglowerfoot", CubeListBuilder.create().texOffs(66, 36).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 6.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition leftfoot = leftleglowerfoot.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(66, 51).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.0F, -3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition leftfoothoof = leftfoot.addOrReplaceChild("leftfoothoof", CubeListBuilder.create().texOffs(66, 47).addBox(-1.0F, 15.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Minotaur minotaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		righthorn[1].yRot = (Mth.DEG_TO_RAD * -30);
		righthorn[1].zRot = (Mth.DEG_TO_RAD * 30);
		righthorn[2].yRot = (Mth.DEG_TO_RAD * -30);
		righthorn[2].zRot = (Mth.DEG_TO_RAD * 30);
		righthorn[3].yRot = (Mth.DEG_TO_RAD * -30);
		righthorn[3].zRot = (Mth.DEG_TO_RAD * 15);
		righthorn[4].yRot = (Mth.DEG_TO_RAD * -30);
		righthorn[4].zRot = (Mth.DEG_TO_RAD * 15);

		lefthorn[1].yRot = (Mth.DEG_TO_RAD * 30);
		lefthorn[1].zRot = (Mth.DEG_TO_RAD * -30);
		lefthorn[2].yRot = (Mth.DEG_TO_RAD * 30);
		lefthorn[2].zRot = (Mth.DEG_TO_RAD * -30);
		lefthorn[3].yRot = (Mth.DEG_TO_RAD * 30);
		lefthorn[3].zRot = (Mth.DEG_TO_RAD * -15);
		lefthorn[4].yRot = (Mth.DEG_TO_RAD * 30);
		lefthorn[4].zRot = (Mth.DEG_TO_RAD * -15);

		// arms
		float armDefaultAngleX = 0.261799F;

		if (minotaur.getAnimationState() == 0) {
			rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > 0.0F) {
				holdingMelee();
			}

			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
			rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
			leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;

			rightarm.xRot = +armDefaultAngleX;
			leftarm.xRot = +armDefaultAngleX;

			rightarmlower.xRot = -armDefaultAngleX;
			leftarmlower.xRot = -armDefaultAngleX;
		} else if (minotaur.getAnimationState() == 1) {
			animationBuff();
		}

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightleg.xRot -= 0.4363323F;
		leftleg.xRot -= 0.4363323F;
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
		rightarm.xRot += (body.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
	}

	private void animationBuff() {
		float armDefaultAngleX = 0.785398F;

		rightarm.xRot = 0.0F;
		leftarm.xRot = 0.0F;
		rightarm.zRot = +armDefaultAngleX;
		leftarm.zRot = -armDefaultAngleX;

		rightarm.xRot = +armDefaultAngleX;
		leftarm.xRot = +armDefaultAngleX;
		rightarmlower.xRot = -armDefaultAngleX;
		leftarmlower.xRot = -armDefaultAngleX;
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
		poseStack.translate(0, 0.3125, 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}