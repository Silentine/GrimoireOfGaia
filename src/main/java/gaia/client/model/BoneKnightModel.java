package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.BoneKnight;
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
import net.minecraftforge.common.ToolActions;

public class BoneKnightModel extends EntityModel<BoneKnight> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightarm;
	private final ModelPart shield;
	private final ModelPart leftarm;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	public boolean shielded;

	public BoneKnightModel(ModelPart root) {
		this.root = root.getChild("bone_knight");
		this.head = this.root.getChild("head");
		this.body = this.root.getChild("body");
		this.rightarm = this.root.getChild("rightarm");
		this.shield = this.rightarm.getChild("shield");
		this.leftarm = this.root.getChild("leftarm");
		this.rightleg = this.root.getChild("rightleg");
		this.leftleg = this.root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone_knight = partdefinition.addOrReplaceChild("bone_knight", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = bone_knight.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition body = bone_knight.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(40, 12).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition chestlower_r1 = chest.addOrReplaceChild("chestlower_r1", CubeListBuilder.create().texOffs(40, 20).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition waist = body.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(0, 32).addBox(-4.5F, 10.0F, -2.5F, 9.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 45).addBox(-5.0F, 12.0F, -2.0F, 10.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightarm = bone_knight.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(24, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 28).addBox(-1.5F, 4.5F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(40, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-1.0F)), PartPose.offset(-5.0F, -22.0F, 0.0F));

		PartDefinition shield = rightarm.addOrReplaceChild("shield", CubeListBuilder.create().texOffs(88, 0).mirror().addBox(-3.0F, -1.5F, -6.0F, 1.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(88, 0).mirror().addBox(-2.5F, 8.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftarm = bone_knight.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(24, 16).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(40, 28).mirror().addBox(-1.5F, 4.5F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(40, 0).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-1.0F)).mirror(false), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition rightleg = bone_knight.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(32, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 37).addBox(-1.5F, 6.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leftleg = bone_knight.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(32, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 37).mirror().addBox(-1.5F, 6.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(BoneKnight boneKnight, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(boneKnight, limbSwing, limbSwingAmount, partialTick);
		this.shielded = boneKnight.getMainHandItem().canPerformAction(ToolActions.SHIELD_BLOCK);
	}

	@Override
	public void setupAnim(BoneKnight boneKnight, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.shield.visible = false;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		leftarm.zRot = 0.0F;
		rightarm.zRot = 0.0F;

		if (attackTime > -9990.0F) {
			holdingMelee();
		}

		if (shielded) {
			this.rightarm.xRot = this.rightarm.xRot * 0.5F - 0.9424779F;
			this.rightarm.yRot = (-(float) Math.PI / 6F);
		} else {
			this.rightarm.yRot = 0.0F;
		}

		leftarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
		leftarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		rightarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
		rightarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
		rightleg.zRot = 0.0F;
		leftleg.zRot = 0.0F;

		if (riding) {
			leftarm.xRot += -((float) Math.PI / 5F);
			rightarm.xRot += -((float) Math.PI / 5F);
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

		leftarm.xRot = (float) ((double) leftarm.xRot - ((double) f7 * 1.2D + (double) f8));
		leftarm.xRot += (body.yRot * 2.0F);
		leftarm.zRot = (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
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
		poseStack.translate(0, 1.5, 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}