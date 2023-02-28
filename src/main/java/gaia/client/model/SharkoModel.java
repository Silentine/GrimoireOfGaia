package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Sharko;
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

public class SharkoModel extends EntityModel<Sharko> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart bodyfront;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart tail1, tail2, tail3, tailend;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public SharkoModel(ModelPart root) {
		this.root = root.getChild("sharko");
		ModelPart waist = this.root.getChild("waist");
		ModelPart bodyback = waist.getChild("bodymid").getChild("bodyback");
		this.head = bodyback.getChild("head");
		this.bodyfront = bodyback.getChild("bodyfront");
		this.leftarm = bodyback.getChild("leftarm");
		this.rightarm = bodyback.getChild("rightarm");
		this.tail1 = waist.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tailend = this.tail3.getChild("tailend");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sharko = partdefinition.addOrReplaceChild("sharko", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition waist = sharko.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(32, 35).addBox(-5.0F, 10.0F, 3.0F, 6.0F, 4.0F, 5.0F), PartPose.offset(2.0F, -25.0F, -3.5F));

		PartDefinition bodymid = waist.addOrReplaceChild("bodymid", CubeListBuilder.create().texOffs(32, 24).addBox(-4.0F, -5.0F, -5.5F, 8.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, 10.0F, 8.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition bodyback = bodymid.addOrReplaceChild("bodyback", CubeListBuilder.create().texOffs(32, 12).addBox(-7.0F, -8.0F, -4.0F, 14.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -5.0F, 0.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition bodyfront = bodyback.addOrReplaceChild("bodyfront", CubeListBuilder.create().texOffs(32, 0).addBox(-6.0F, -28.0F, -2.0F, 12.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 21.0F, -5.0F));

		PartDefinition rightarm = bodyback.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(68, 10).addBox(-3.0F, -2.0F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offset(-7.0F, -2.0F, -3.5F));

		PartDefinition rightpauldron_r1 = rightarm.addOrReplaceChild("rightpauldron_r1", CubeListBuilder.create().texOffs(68, 0).addBox(-6.0F, -1.0F, -2.5F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(1.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(68, 33).addBox(-2.0F, 0.0F, -3.5F, 4.0F, 10.0F, 4.0F)
				.texOffs(68, 21).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-1.5F, 6.0F, 1.5F, -0.6981F, 0.0F, 0.0F));

		PartDefinition leftarm = bodyback.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(68, 10).mirror().addBox(0.0F, -2.0F, -1.5F, 3.0F, 8.0F, 3.0F).mirror(false), PartPose.offset(7.0F, -2.0F, -3.5F));

		PartDefinition leftpauldron_r1 = leftarm.addOrReplaceChild("leftpauldron_r1", CubeListBuilder.create().texOffs(68, 0).mirror().addBox(-1.0F, -1.0F, -2.5F, 7.0F, 5.0F, 5.0F).mirror(false), PartPose.offsetAndRotation(-1.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(68, 33).mirror().addBox(-2.0F, 0.0F, -3.5F, 4.0F, 10.0F, 4.0F).mirror(false)
				.texOffs(68, 21).addBox(-0.5F, -4.0F, -1.5F, 1.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(1.5F, 6.0F, 1.5F, -0.6981F, 0.0F, 0.0F));

		PartDefinition head = bodyback.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 7.0F, 8.0F)
				.texOffs(0, 43).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 4.0F, 5.0F)
				.texOffs(0, 15).addBox(0.0F, -9.5F, -3.0F, 0.0F, 8.0F, 10.0F), PartPose.offset(0.0F, -4.5F, -7.0F));

		PartDefinition headsnout_r1 = head.addOrReplaceChild("headsnout_r1", CubeListBuilder.create().texOffs(0, 33).addBox(-3.5F, 0.0F, -6.0F, 7.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.0F, -3.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition tail1 = waist.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(32, 44).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, 11.0F, 8.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(48, 44).addBox(-1.5F, 0.5F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(32, 52).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition tailend = tail3.addOrReplaceChild("tailend", CubeListBuilder.create().texOffs(40, 52).addBox(-7.0F, 22.0F, -4.5F, 10.0F, 6.0F, 1.0F), PartPose.offset(2.0F, -20.0F, 3.0F));

		PartDefinition rightleg = sharko.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(100, 10).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, -13.0F, 2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(100, 21).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightfoot = rightleglower.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(100, 27).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 1.5F, 3.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leftleg = sharko.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(100, 10).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(3.0F, -13.0F, 2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(100, 21).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftfoot = leftleglower.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(100, 27).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 1.5F, 3.0F, -0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Sharko sharko, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(sharko, limbSwing, limbSwingAmount, partialTick);
	}

	@Override
	public void setupAnim(Sharko sharko, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;

		// arms
		if (sharko.getAnimationState() == 0) {
			rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > 0.0F) {
				holdingMelee();
			}

			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + (Mth.DEG_TO_RAD * 15);
			rightarm.xRot += (Mth.sin(ageInTicks * 0.067F) * 0.05F) + (Mth.DEG_TO_RAD * 10);
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + (Mth.DEG_TO_RAD * 15);
			leftarm.xRot -= (Mth.sin(ageInTicks * 0.067F) * 0.05F) - (Mth.DEG_TO_RAD * 10);
		} else {
			animationBuff();
		}

		// body
		tail1.yRot = Mth.cos((Mth.DEG_TO_RAD * ((float) ageInTicks * 7))) * (2 * Mth.DEG_TO_RAD);
		tail2.yRot = Mth.cos((Mth.DEG_TO_RAD * ((float) ageInTicks * 7))) * (4 * Mth.DEG_TO_RAD);
		tail3.yRot = Mth.cos((Mth.DEG_TO_RAD * ((float) ageInTicks * 7))) * (6 * Mth.DEG_TO_RAD);
		tailend.yRot = tail3.yRot;

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.xRot -= 0.5585054F;
		leftleg.xRot -= 0.5585054F;
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

		// right arm
		rightarm.xRot = (float) ((double) rightarm.xRot - ((double) f7 * 1.2D + (double) f8));
		rightarm.yRot += (bodyfront.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(attackTime * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.xRot = (float) ((double) leftarm.xRot - ((double) f7 * 1.2D + (double) f8));
		leftarm.yRot += (bodyfront.yRot * 2.0F);
		leftarm.zRot -= (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
	}

	private void animationBuff() {
		rightarm.xRot = 0.0F;
		leftarm.xRot = 0.0F;
		rightarm.zRot = +0.785398F;
		leftarm.zRot = -0.785398F;
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
		poseStack.translate(-0.0625, 0.5, 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}