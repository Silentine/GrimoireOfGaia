package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Naga;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;

public class NagaModel extends EntityModel<Naga> implements HeadedModel, ArmedModel {
	private static final double CYCLES_PER_BLOCK = 0.1D;
	private final float[][] undulationCycle = new float[][]
			{
					{5F, 0F, -11.25F, -45F, -22.5F, 0F, 22.5F, 45F},
					{10F, 10F, 0F, -22.5F, -45F, -22.5F, 0F, 22.5F},
					{5F, 20F, 11.25F, 0F, -22.5F, -45F, -22.5F, 0F},
					{0F, 10F, 22.5F, 22.5F, 0F, -22.5F, -45F, -22.5F},
					{-5F, 0F, 11.25F, 45F, 22.5F, 0F, -22.5F, -45F},
					{-10F, -10F, 0F, 22.5F, 45F, 22.5F, 0F, -22.5F},
					{-5F, -20F, -11.25F, 0F, 22.5F, 45F, 22.5F, 0F},
					{0F, -10F, -22.5F, -22.5F, 0F, 22.5F, 45F, 22.5F},
			};

	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightarm;
	private final ModelPart rightarmlower;
	private final ModelPart leftarm;
	private final ModelPart leftarmlower;
	private final ModelPart[] tails = new ModelPart[8];

	public NagaModel(ModelPart root) {
		this.root = root.getChild("naga");
		this.body = this.root.getChild("waist").getChild("body");
		this.head = this.body.getChild("head");
		this.rightarm = this.body.getChild("rightarm");
		this.rightarmlower = this.rightarm.getChild("rightarmlower");
		this.leftarm = this.body.getChild("leftarm");
		this.leftarmlower = this.leftarm.getChild("leftarmlower");

		for (int i = 0; i < this.tails.length; i++) {
			int index = i + 1;
			if (index == 1) {
				this.tails[i] = this.root.getChild("tail" + index);
			} else {
				this.tails[i] = this.tails[i - 1].getChild("tail" + index);
			}
		}
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition naga = partdefinition.addOrReplaceChild("naga", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition waist = naga.addOrReplaceChild("waist", CubeListBuilder.create()
				.texOffs(68, 0).addBox(-4.5F, -5.0F, 0.0F, 9.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -17.0F, -2.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition body = waist.addOrReplaceChild("body", CubeListBuilder.create()
				.texOffs(34, 44).addBox(-5.5F, -9.0F, -3.0F, 11.0F, 9.0F, 6.0F)
				.texOffs(104, 39).addBox(0.0F, -14.0F, -3.0F, 0.0F, 13.0F, 12.0F), PartPose.offset(0.0F, -5.0F, 2.5F));

		body.addOrReplaceChild("body_r1", CubeListBuilder.create()
				.texOffs(34, 14).addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 5.0F, 7.0F)
				.texOffs(0, 46).addBox(0.0F, -8.0F, -5.0F, 0.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -10.0F, -1.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition headnose = head.addOrReplaceChild("headnose", CubeListBuilder.create()
				.texOffs(0, 17).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -3.0F, -5.0F, 0.5236F, 0.0F, 0.0F));

		headnose.addOrReplaceChild("headbrowleft_r1", CubeListBuilder.create()
				.texOffs(0, 12).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(1.5F, 0.0F, -1.5F, 0.0F, 0.5236F, 0.0F));

		headnose.addOrReplaceChild("headbrowright_r1", CubeListBuilder.create()
				.texOffs(0, 12).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-1.5F, 0.0F, -1.5F, 0.0F, -0.5236F, 0.0F));

		head.addOrReplaceChild("headjaw", CubeListBuilder.create()
				.texOffs(0, 25).addBox(-2.5F, -2.0F, -6.5F, 5.0F, 3.0F, 6.0F)
				.texOffs(0, 34).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 2.0F, -2.0F));

		head.addOrReplaceChild("rightfin", CubeListBuilder.create()
				.texOffs(19, -5).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.0F, -1.0F, -4.0F, 0.0F, -0.7854F, 0.0F));

		head.addOrReplaceChild("leftfin", CubeListBuilder.create()
				.texOffs(19, -5).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.0F, -1.0F, -4.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create()
				.texOffs(34, 22).addBox(-3.0F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-5.5F, -6.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		rightarm.addOrReplaceChild("rightpauldron_r1", CubeListBuilder.create()
				.texOffs(34, 0).addBox(-5.0F, -2.5F, -3.0F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create()
				.texOffs(34, 33).addBox(-1.501F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(-1.5F, 6.5F, 1.5F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create()
				.texOffs(34, 22).addBox(0.0F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(5.5F, -6.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		leftarm.addOrReplaceChild("leftpauldron_r1", CubeListBuilder.create()
				.texOffs(34, 0).mirror().addBox(-2.0F, -2.5F, -3.0F, 7.0F, 7.0F, 7.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create()
				.texOffs(34, 33).addBox(-1.499F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F), PartPose.offset(1.5F, 6.5F, 1.5F));

		PartDefinition tail1 = naga.addOrReplaceChild("tail1", CubeListBuilder.create()
				.texOffs(68, 10).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 6.0F), PartPose.offset(0.0F, -17.0F, -2.5F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create()
				.texOffs(68, 24).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 6.0F), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create()
				.texOffs(68, 37).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create()
				.texOffs(68, 49).addBox(-2.5F, 0.0F, 0.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create()
				.texOffs(68, 49).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 5.0F, 0.5F));

		PartDefinition tail6 = tail5.addOrReplaceChild("tail6", CubeListBuilder.create()
				.texOffs(96, 0).addBox(-2.0F, 0.0F, 0.5F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition tail7 = tail6.addOrReplaceChild("tail7", CubeListBuilder.create()
				.texOffs(96, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 4.0F, 0.5F));

		tail7.addOrReplaceChild("tail8", CubeListBuilder.create()
				.texOffs(96, 8).addBox(-1.5F, 0.0F, 0.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Naga naga, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		float armDefaultAngleX = 0.261799F;

		if (naga.getAnimationState() == 0) {
			rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > 0.0F) {
				holdingMelee();
			}

			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
			rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
			leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;

			rightarm.xRot = armDefaultAngleX;
			leftarm.xRot = armDefaultAngleX;

			rightarmlower.xRot = -armDefaultAngleX;
			leftarmlower.xRot = -armDefaultAngleX;
		} else {
			animationBuff();
		}

		// legs
		tails[0].xRot = -0.1308997F;
		tails[1].xRot = 0.3926991F;
		tails[2].xRot = 0.3926991F;
		tails[3].xRot = 0.785398F;
		tails[4].xRot = 0.1309F;
		tails[7].xRot = 0.3926991F;

		int cycleIndex = (int) ((limbSwing * CYCLES_PER_BLOCK) % undulationCycle.length);

		tails[4].zRot = 0.15F * Mth.cos(limbSwing * (Mth.DEG_TO_RAD * undulationCycle[cycleIndex][4]));
		tails[5].zRot = 0.15F * Mth.cos(limbSwing * (Mth.DEG_TO_RAD * undulationCycle[cycleIndex][5]));
		tails[6].zRot = 0.15F * Mth.cos(limbSwing * (Mth.DEG_TO_RAD * undulationCycle[cycleIndex][6]));
		tails[7].zRot = 0.15F * Mth.cos(limbSwing * (Mth.DEG_TO_RAD * undulationCycle[cycleIndex][7]));
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
		rightarm.zRot = armDefaultAngleX;
		leftarm.zRot = -armDefaultAngleX;

		rightarm.xRot = armDefaultAngleX;
		leftarm.xRot = armDefaultAngleX;
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
		poseStack.translate(-0.125D, 0.5D, 0);
		if (arm == HumanoidArm.LEFT) {
			poseStack.translate(0.125F, 0, 0.0625D);
		}
		getArm(arm).translateAndRotate(poseStack);
	}
}