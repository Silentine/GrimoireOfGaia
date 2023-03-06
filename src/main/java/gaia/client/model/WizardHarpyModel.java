package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.WizardHarpy;
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

public class WizardHarpyModel extends EntityModel<WizardHarpy> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public WizardHarpyModel(ModelPart root) {
		this.root = root.getChild("harpy_wizard");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition harpy_wizard = partdefinition.addOrReplaceChild("harpy_wizard", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = harpy_wizard.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 25).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodybottom.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, 0.0F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -1.5F, -1.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 20).addBox(-4.0F, -0.5F, -4.0F, 8.0F, 2.0F, 8.0F)
				.texOffs(36, 30).addBox(-3.0F, 0.5F, -3.0F, 6.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -6.0F, 1.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F)
				.texOffs(24, 6).addBox(-3.0F, -6.0F, -3.6F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(36, 14).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, -6.0F, -1.0F, 0.5236F, 0.5236F, 0.5236F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(36, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(3.0F, -6.0F, -1.0F, 0.5236F, -0.5236F, -0.5236F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(68, 0).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-2.5F, -5.5F, 1.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(68, 10).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 4.0F, 5.0F), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(68, 0).mirror().addBox(0.0F, 0.0F, -3.0F, 1.0F, 4.0F, 6.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -5.5F, 1.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(68, 10).mirror().addBox(0.0F, 0.0F, -2.5F, 1.0F, 4.0F, 5.0F).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition tail = bodybottom.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(68, 19).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightleg = harpy_wizard.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F)
				.texOffs(82, 0).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, -4.0F, 0.0F));

		PartDefinition leftleg = harpy_wizard.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F)
				.texOffs(82, 0).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(2.0F, -4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(WizardHarpy wizardHarpy, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = ageInTicks % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		if (wizardHarpy.getAnimationState() == 0) {
			rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > 0.0F) {
				holdingMelee();
			}

			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.523599F;
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.523599F;

			rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
			leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;
		} else if (wizardHarpy.getAnimationState() == 1) {
			animationCast();
		} else if (wizardHarpy.getAnimationState() == 2) {
			rightarm.xRot = 0.0F;
			leftarm.xRot = 0.0F;

			rightarm.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.zRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
			rightarm.zRot = rightarm.zRot + 0.785398F;
			leftarm.zRot = leftarm.zRot - 0.785398F;
		}

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
		rightleg.zRot = 0.0F;
		leftleg.zRot = 0.0F;

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

	private void animationCast() {
		rightarm.xRot = -2.35619F;
		rightarm.zRot = -0.261799F;
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
		poseStack.translate(-0.0625D, 1D, -0.125D);
		getArm(arm).translateAndRotate(poseStack);
	}
}