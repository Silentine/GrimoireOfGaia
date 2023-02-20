package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Witch;
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

public class WitchModel extends EntityModel<Witch> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart broom;
	private final ModelPart bodybottom;
	private final ModelPart bodymiddle;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart hat1;
	private final ModelPart hat3;
	private final ModelPart hat4;
	private final ModelPart hat5;
	private final ModelPart hat6;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;
	private final ModelPart leftleglower;
	private final ModelPart rightleglower;
	private float offset = 0.0F;

	public WitchModel(ModelPart root) {
		this.root = root.getChild("witch");
		this.broom = this.root.getChild("broom");
		this.bodybottom = this.root.getChild("bodybottom");
		this.bodymiddle = this.bodybottom.getChild("bodymiddle");
		this.bodytop = this.bodymiddle.getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.hat1 = this.head.getChild("hat1");
		this.hat3 = this.hat1.getChild("hat2").getChild("hat3");
		this.hat4 = this.hat3.getChild("hat4");
		this.hat5 = this.hat4.getChild("hat5");
		this.hat6 = this.hat5.getChild("hat6");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
		this.leftleglower = this.leftleg.getChild("leftleglower");
		this.rightleglower = this.rightleg.getChild("rightleglower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition witch = partdefinition.addOrReplaceChild("witch", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = witch.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offset(0.0F, -13.5F, 0.5F));

		PartDefinition skirt1 = bodybottom.addOrReplaceChild("skirt1", CubeListBuilder.create().texOffs(92, 21).addBox(-3.5F, 0.5F, -3.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -1.5F, 0.0F));

		PartDefinition skirt2 = skirt1.addOrReplaceChild("skirt2", CubeListBuilder.create().texOffs(92, 29).addBox(-4.0F, -1.0F, -3.5F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offset(0.0F, -1.5F, 1.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition amulet = bodytop.addOrReplaceChild("amulet", CubeListBuilder.create().texOffs(36, 55).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition mantle = bodytop.addOrReplaceChild("mantle", CubeListBuilder.create().texOffs(92, 8).addBox(-4.5F, 0.5F, 0.0F, 9.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -7.0F, -1.5F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 1.0F, 0.5F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hat1 = head.addOrReplaceChild("hat1", CubeListBuilder.create().texOffs(36, 14).addBox(-7.0F, -1.0F, -7.0F, 14.0F, 2.0F, 14.0F), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition hat2 = hat1.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(36, 30).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 5.0F, 8.0F), PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition hat3 = hat2.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(68, 30).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(3.0F, -5.0F, 1.0F));

		PartDefinition hat4 = hat3.addOrReplaceChild("hat4", CubeListBuilder.create().texOffs(36, 43).addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(-1.0F, -6.0F, 1.0F));

		PartDefinition hat5 = hat4.addOrReplaceChild("hat5", CubeListBuilder.create().texOffs(52, 43).addBox(-3.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.offset(-0.5F, -4.0F, 0.5F));

		PartDefinition hat6 = hat5.addOrReplaceChild("hat6", CubeListBuilder.create().texOffs(36, 51).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-0.5F, -3.0F, 0.5F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -4.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create()
				.texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(92, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(-2.5F, -4.5F, -1.5F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create()
				.texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).mirror(false)
				.texOffs(92, 0).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F).mirror(false), PartPose.offset(2.5F, -4.5F, -1.5F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition rightleg = witch.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 22).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(-2.0F, -13.0F, 0.5F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 32).addBox(-1.505F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F)
				.texOffs(92, 40).addBox(-2.005F, 3.0F, -0.5F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition leftleg = witch.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F).mirror(false), PartPose.offset(2.0F, -13.0F, 0.5F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 32).mirror().addBox(-1.495F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F).mirror(false)
				.texOffs(92, 40).mirror().addBox(-1.995F, 3.0F, -0.5F, 4.0F, 4.0F, 4.0F).mirror(false), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition broom = witch.addOrReplaceChild("broom", CubeListBuilder.create().texOffs(112, 43).addBox(-0.5F, -11.0F, -0.5F, 1.0F, 20.0F, 1.0F)
				.texOffs(116, 43).addBox(-1.5F, 8.0F, -1.5F, 3.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 0.5F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Witch witch, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(witch, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !witch.isBaby();

		hat1.zRot = -(30 * Mth.DEG_TO_RAD);
		hat3.xRot = -(20 * Mth.DEG_TO_RAD);
		hat3.zRot = (20 * Mth.DEG_TO_RAD);
		hat4.xRot = -(20 * Mth.DEG_TO_RAD);
		hat4.zRot = (20 * Mth.DEG_TO_RAD);
		hat5.xRot = -(20 * Mth.DEG_TO_RAD);
		hat5.zRot = (20 * Mth.DEG_TO_RAD);
		hat6.xRot = (10 * Mth.DEG_TO_RAD);
		hat6.zRot = -(10 * Mth.DEG_TO_RAD);
	}

	@Override
	public void setupAnim(Witch witch, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = witch.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		root.y = 24.0F;

		boolean moveExtremities;
		float rightArmAngleMoving;
		float leftArmAngleMoving;
		float defaultAngle = 0;

		if (witch.isRidingBroom()) {
			moveExtremities = false;
			rightArmAngleMoving = (30 * Mth.DEG_TO_RAD);
			leftArmAngleMoving = (45 * Mth.DEG_TO_RAD);

			// arms
			rightarm.xRot = -rightArmAngleMoving;
			rightarm.yRot = -rightArmAngleMoving;
			rightarm.zRot = 0;
			leftarm.xRot = -leftArmAngleMoving;
			leftarm.yRot = leftArmAngleMoving;
			leftarm.zRot = 0;
			// body
			bodytop.xRot = (25 * Mth.DEG_TO_RAD);
			bodymiddle.xRot = (10 * Mth.DEG_TO_RAD);
			bodybottom.xRot = (15 * Mth.DEG_TO_RAD);
			// legs
			rightleg.xRot = -(80 * Mth.DEG_TO_RAD);
			rightleg.yRot = -(5 * Mth.DEG_TO_RAD);
			leftleg.xRot = -(60 * Mth.DEG_TO_RAD);
			leftleg.yRot = (5 * Mth.DEG_TO_RAD);
			rightleglower.xRot = (45 * Mth.DEG_TO_RAD);
			leftleglower.xRot = (75 * Mth.DEG_TO_RAD);
			// broom
			broom.visible = true;

			root.xRot = (Mth.cos((6.0F * Mth.DEG_TO_RAD * ageInTicks)) * 0.1F) - 0.3F;
			this.offset = Mth.cos(ageInTicks * 0.18F) * 0.9F;
			root.y = 24.0F - offset;
		} else {
			moveExtremities = true;
			rightArmAngleMoving = defaultAngle;
			leftArmAngleMoving = defaultAngle;

			// arms
			rightarm.xRot = defaultAngle;
			rightarm.yRot = defaultAngle;
			leftarm.xRot = defaultAngle;
			leftarm.yRot = defaultAngle;
			// body
			bodytop.xRot = defaultAngle;
			bodymiddle.xRot = defaultAngle;
			bodybottom.xRot = defaultAngle;
			// legs
			rightleg.xRot = defaultAngle;
			rightleg.yRot = defaultAngle;
			rightleg.zRot = defaultAngle;
			leftleg.xRot = defaultAngle;
			leftleg.yRot = defaultAngle;
			leftleg.zRot = defaultAngle;
			rightleglower.xRot = defaultAngle;
			leftleglower.xRot = defaultAngle;
			// broom
			broom.visible = false;

			root.xRot = 0;
		}

		// arms
		if (moveExtremities) {
			rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
			leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > 0.0F) {
				holdingMelee();
			}

			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		}

		if (!moveExtremities) {
			rightarm.xRot = -rightArmAngleMoving;
			leftarm.xRot = -leftArmAngleMoving;
		}

		// legs
		if (moveExtremities) {
			rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
			leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		}

		if (riding && !witch.isRidingBroom()) {
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