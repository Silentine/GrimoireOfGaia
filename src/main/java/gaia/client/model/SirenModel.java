package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Siren;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.BowItem;

public class SirenModel extends EntityModel<Siren> implements HeadedModel, ArmedModel {
	private static final double CYCLES_PER_BLOCK = 0.1D;
	private final float[][] undulationCycle = new float[][]{
			{5F, 0F, -11.25F, -45F, -22.5F, 0F, 22.5F, 45F},
			{10F, 10F, 0F, -22.5F, -45F, -22.5F, 0F, 22.5F},
			{5F, 20F, 11.25F, 0F, -22.5F, -45F, -22.5F, 0F},
			{0F, 10F, 22.5F, 22.5F, 0F, -22.5F, -45F, -22.5F},
			{-5F, 0F, 11.25F, 45F, 22.5F, 0F, -22.5F, -45F},
			{-10F, -10F, 0F, 22.5F, 45F, 22.5F, 0F, -22.5F},
			{-5F, -20F, -11.25F, 0F, 22.5F, 45F, 22.5F, 0F},
			{0F, -10F, -22.5F, -22.5F, 0F, 22.5F, 45F, 22.5F},
	};
	private double distanceMovedTotal = 0.0D;


	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart hair1;
	private final ModelPart hair2;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftarmextra;
	private final ModelPart rightarmextra;
	private final ModelPart leftarmextralower;
	private final ModelPart rightarmextralower;
	private final ModelPart[] tails = new ModelPart[8];

	public SirenModel(ModelPart root) {
		this.root = root.getChild("siren");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		this.head = this.bodytop.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.hair1 = this.bodytop.getChild("hair1");
		this.hair2 = this.hair1.getChild("hair2");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftarmextra = this.bodytop.getChild("leftarmextra");
		this.rightarmextra = this.bodytop.getChild("rightarmextra");
		this.leftarmextralower = this.leftarmextra.getChild("leftarmextralower");
		this.rightarmextralower = this.rightarmextra.getChild("rightarmextralower");

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

		PartDefinition siren = partdefinition.addOrReplaceChild("siren", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = siren.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -1.45F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -1.55F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.45F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-1.0F, -7.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 42).addBox(-4.5F, -6.0F, -3.0F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.55F, -0.0873F, 0.0F, 0.0F));

		PartDefinition head = bodytop.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition finright = head.addOrReplaceChild("finright", CubeListBuilder.create().texOffs(36, 32).addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, -2.5F, 0.0F, -0.5236F, 0.0F));

		PartDefinition finleft = head.addOrReplaceChild("finleft", CubeListBuilder.create().texOffs(36, 32).addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.0F, -2.5F, 0.0F, 0.5236F, 0.0F));

		PartDefinition hair1 = bodytop.addOrReplaceChild("hair1", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -6.0F, 1.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition hair2 = hair1.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(36, 25).addBox(-4.5F, -1.0F, -1.5F, 9.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 3.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 36).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -4.5F, -0.5F, 0.0873F, 0.0F, 0.3491F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 44).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -4.5F, -0.5F, 0.0873F, 0.0F, -0.3491F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.005F, 5.0F, 1.0F));

		PartDefinition rightarmextra = bodytop.addOrReplaceChild("rightarmextra", CubeListBuilder.create().texOffs(24, 36).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.5F, 0.5F, 0.2618F, 0.0F, 0.1745F));

		PartDefinition rightarmextralower = rightarmextra.addOrReplaceChild("rightarmextralower", CubeListBuilder.create().texOffs(24, 44).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 1.0F));

		PartDefinition leftarmextra = bodytop.addOrReplaceChild("leftarmextra", CubeListBuilder.create().texOffs(24, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.5F, 0.5F, 0.2618F, 0.0F, -0.1745F));

		PartDefinition leftarmextralower = leftarmextra.addOrReplaceChild("leftarmextralower", CubeListBuilder.create().texOffs(24, 20).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 1.0F));

		PartDefinition tail1 = siren.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(64, 0).addBox(-3.5F, -1.0F, -2.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.5F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(64, 8).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -2.5F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(64, 16).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(64, 16).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(64, 24).addBox(-2.0F, 0.0F, 0.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition tail6 = tail5.addOrReplaceChild("tail6", CubeListBuilder.create().texOffs(64, 24).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.5F));

		PartDefinition tail7 = tail6.addOrReplaceChild("tail7", CubeListBuilder.create().texOffs(64, 31).addBox(-1.5F, 0.0F, 0.5F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition tail8 = tail7.addOrReplaceChild("tail8", CubeListBuilder.create().texOffs(64, 36).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Siren siren, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(siren, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get();
	}

	@Override
	public void setupAnim(Siren siren, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = false;
		if (siren.tickCount % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.visible = true;
		}

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;
		hair1.yRot = head.yRot;
		hair1.xRot = head.xRot;
		hair2.xRot = (head.xRot) * 0.75F;

		// arms
		float armextraDefaultAngleX = 0.261799F;

		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (siren.isAggressive() && (siren.getMainHandItem().getItem() instanceof BowItem)) {
			holdingBow(ageInTicks);
		} else if (attackTime > -9990.0F) {
			holdingMelee();
		}

		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

		rightarmextra.zRot = armextraDefaultAngleX;
		leftarmextra.zRot = -armextraDefaultAngleX;

		rightarmextra.xRot = armextraDefaultAngleX;
		leftarmextra.xRot = armextraDefaultAngleX;

		rightarmextralower.xRot = -armextraDefaultAngleX;
		leftarmextralower.xRot = -armextraDefaultAngleX;

		// legs
		tails[0].xRot = -0.1308997F;
		tails[1].xRot = 0.3926991F;
		tails[2].xRot = 0.3926991F;
		tails[3].xRot = 0.785398F;
		tails[7].xRot = 0.3926991F;

		updateDistanceMovedTotal(siren);
		int cycleIndex = (int) ((getDistanceMovedTotal() * CYCLES_PER_BLOCK) % undulationCycle.length);

		tails[4].zRot = ((undulationCycle[cycleIndex][4] * Mth.DEG_TO_RAD) * Mth.cos(ageInTicks * 0.02F));
		tails[5].zRot = ((undulationCycle[cycleIndex][5] * Mth.DEG_TO_RAD) * Mth.cos(ageInTicks * 0.02F));
		tails[6].zRot = ((undulationCycle[cycleIndex][6] * Mth.DEG_TO_RAD) * Mth.cos(ageInTicks * 0.02F));
		tails[7].zRot = ((undulationCycle[cycleIndex][7] * Mth.DEG_TO_RAD) * Mth.cos(ageInTicks * 0.02F));
	}

	private void holdingBow(float ageInTicks) {
		float f = Mth.sin(attackTime * (float) Math.PI);
		float f1 = Mth.sin((1.0F - (1.0F - attackTime) * (1.0F - attackTime)) * (float) Math.PI);

		rightarm.zRot = -0.3F;
		leftarm.zRot = 0.3F;
		rightarm.yRot = -(0.1F - f * 0.6F);
		leftarm.yRot = 0.3F - f * 0.6F;
		rightarm.xRot = -((float) Math.PI / 2F);
		leftarm.xRot = -((float) Math.PI / 2F);
		rightarm.xRot -= f * 1.2F - f1 * 0.4F;
		leftarm.xRot -= f * 1.2F - f1 * 0.4F;
		rightarm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
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

	private void updateDistanceMovedTotal(Entity parEntity) {
		this.distanceMovedTotal += (double) Mth.sqrt((float) parEntity.distanceToSqr(parEntity.xOld, parEntity.yOld, parEntity.zOld));
	}

	private double getDistanceMovedTotal() {
		return distanceMovedTotal;
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