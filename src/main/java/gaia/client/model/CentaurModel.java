package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Centaur;
import net.minecraft.client.model.AnimationUtils;
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
import net.minecraft.world.item.BowItem;
import net.minecraft.world.phys.Vec3;

public class CentaurModel extends EntityModel<Centaur> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart tail;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart body1;
	private final ModelPart body2;
	private final ModelPart leftlegupper;
	private final ModelPart rightlegupper;
	private final ModelPart leftlegback1;
	private final ModelPart rightlegback1;
	private final ModelPart leftlegback2;
	private final ModelPart rightlegback2;
	private final ModelPart leftlegback3;
	private final ModelPart rightlegback3;

	public CentaurModel(ModelPart root) {
		this.root = root.getChild("centaur");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.body1 = this.root.getChild("body1");
		this.leftlegupper = this.body1.getChild("leftlegupper");
		this.rightlegupper = this.body1.getChild("rightlegupper");

		this.body2 = this.body1.getChild("body2");
		this.tail = this.body2.getChild("tail");
		this.leftlegback1 = this.body2.getChild("leftlegback1");
		this.rightlegback1 = this.body2.getChild("rightlegback1");
		this.leftlegback2 = this.leftlegback1.getChild("leftlegback2");
		this.rightlegback2 = this.rightlegback1.getChild("rightlegback2");
		this.leftlegback3 = this.leftlegback2.getChild("leftlegback3");
		this.rightlegback3 = this.rightlegback2.getChild("rightlegback3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition centaur = partdefinition.addOrReplaceChild("centaur", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = centaur.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.5F, -6.0F));

		PartDefinition waist = bodybottom.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(64, 0).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, -1.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition bonemiddleFemale = bodymiddle.addOrReplaceChild("bonemiddleFemale", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -0.5F, -2.5F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(-0.5F, 0.0F, -2.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 1.0F));

		PartDefinition bodymidMale = bodymiddle.addOrReplaceChild("bodymidMale", CubeListBuilder.create().texOffs(0, 59).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(36, 33).addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -3.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(36, 33).addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, -3.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition hair1 = neck.addOrReplaceChild("hair1", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -6.0F, 1.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hair2 = hair1.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(36, 25).addBox(-4.5F, 0.0F, -2.5F, 9.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 4.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bonetopFemale = bodytop.addOrReplaceChild("bonetopFemale", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -3.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition bodytopmale = bodytop.addOrReplaceChild("bodytopmale", CubeListBuilder.create().texOffs(0, 50).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(24, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -5.0F, -1.0F, 0.1745F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(24, 18).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition rightpauldron = rightarm.addOrReplaceChild("rightpauldron", CubeListBuilder.create().texOffs(36, 41).addBox(-2.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -5.0F, -1.0F, 0.1745F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 18).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition leftpauldron = leftarm.addOrReplaceChild("leftpauldron", CubeListBuilder.create().texOffs(36, 41).addBox(-0.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body1 = centaur.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(64, 11).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.5F, -8.5F));

		PartDefinition body2 = body1.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(64, 29).addBox(-3.5F, -0.5F, -2.0F, 7.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 8.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition tail = body2.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(106, 51).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 9.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition rightlegback1 = body2.addOrReplaceChild("rightlegback1", CubeListBuilder.create().texOffs(106, 26).addBox(-1.0F, -2.5F, -2.5F, 3.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 3.5F, 7.5F, -0.4363F, 0.0F, 0.0F));

		PartDefinition rightlegback2 = rightlegback1.addOrReplaceChild("rightlegback2", CubeListBuilder.create().texOffs(106, 40).addBox(-1.505F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.5F, -2.5F, 0.6981F, 0.0F, 0.0F));

		PartDefinition rightlegback3 = rightlegback2.addOrReplaceChild("rightlegback3", CubeListBuilder.create().texOffs(106, 49).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 3.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition leftlegback1 = body2.addOrReplaceChild("leftlegback1", CubeListBuilder.create().texOffs(106, 26).addBox(-2.0F, -2.5F, -2.5F, 3.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 3.5F, 7.5F, -0.4363F, 0.0F, 0.0F));

		PartDefinition leftlegback2 = leftlegback1.addOrReplaceChild("leftlegback2", CubeListBuilder.create().texOffs(106, 40).addBox(-1.395F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 5.5F, -2.5F, 0.6981F, 0.0F, 0.0F));

		PartDefinition leftlegback3 = leftlegback2.addOrReplaceChild("leftlegback3", CubeListBuilder.create().texOffs(106, 49).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 6.0F, 3.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightlegupper = body1.addOrReplaceChild("rightlegupper", CubeListBuilder.create().texOffs(106, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 4.0F, 1.5F, 0.0F, 0.0F, -0.0873F));

		PartDefinition rightleglower = rightlegupper.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(106, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, -1.5F));

		PartDefinition rightlegbracelet = rightleglower.addOrReplaceChild("rightlegbracelet", CubeListBuilder.create().texOffs(106, 11).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 2.5F));

		PartDefinition leftlegupper = body1.addOrReplaceChild("leftlegupper", CubeListBuilder.create().texOffs(106, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, 1.5F, 0.0F, 0.0F, 0.0873F));

		PartDefinition leftleglower = leftlegupper.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(106, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, -1.5F));

		PartDefinition leftlegbracelet = leftleglower.addOrReplaceChild("leftlegbracelet", CubeListBuilder.create().texOffs(106, 11).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 2.6F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Centaur centaur, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(centaur, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !centaur.isBaby();
	}

	@Override
	public void setupAnim(Centaur centaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = centaur.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		if (centaur.isMale()) {
			rightarm.x = -3F;
			leftarm.x = 3F;
		}

		// arms
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (centaur.isAggressive() && (centaur.getMainHandItem().getItem() instanceof BowItem)) {
			holdingBow(ageInTicks);
		} else if (attackTime > -9990.0F) {
			holdingMelee();
		}

		if (centaur.isFleeing()) {
			Vec3 movement = centaur.getDeltaMovement();
			if (movement.x * movement.x + movement.z * movement.z > 2.500000277905201E-7D) {
				animationFlee();
			}
		}

		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		body1.xRot = -(5 * Mth.DEG_TO_RAD);
		body2.xRot = (10 * Mth.DEG_TO_RAD);
		tail.yRot = Mth.cos((((float) centaur.tickCount * 7) * Mth.DEG_TO_RAD)) * (10 * Mth.DEG_TO_RAD);
		tail.xRot = -(45 * Mth.DEG_TO_RAD);

		// legs
		rightlegupper.zRot = -(5 * Mth.DEG_TO_RAD);
		rightlegupper.xRot = Mth.cos(limbSwing * 0.7862F) * 0.8F * limbSwingAmount;
		leftlegupper.zRot = (5 * Mth.DEG_TO_RAD);
		leftlegupper.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;

		rightlegback1.zRot = -(5 * Mth.DEG_TO_RAD);
		rightlegback1.xRot = Mth.cos(limbSwing * 0.7662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightlegback1.xRot -= 0.296706F;
		leftlegback1.zRot = (5 * Mth.DEG_TO_RAD);
		leftlegback1.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftlegback1.xRot -= 0.296706F;
		rightlegback2.xRot = (30 * Mth.DEG_TO_RAD);
		leftlegback2.xRot = rightlegback2.xRot;
		rightlegback3.xRot = -(18 * Mth.DEG_TO_RAD);
		leftlegback3.xRot = rightlegback3.xRot;

		if (riding) {
			body1.xRot = -(20 * Mth.DEG_TO_RAD);
			body2.xRot = -(45 * Mth.DEG_TO_RAD);
			tail.xRot = (65 * Mth.DEG_TO_RAD);
			rightlegback1.zRot = (25 * Mth.DEG_TO_RAD);
			leftlegback1.zRot = -rightlegback1.zRot;
			rightlegupper.xRot = -(25 * Mth.DEG_TO_RAD);
			leftlegupper.xRot = rightlegupper.xRot;
			rightlegback1.xRot = -(20 * Mth.DEG_TO_RAD);
			leftlegback1.xRot = rightlegback1.xRot;
		}
	}

	private void holdingBow(float ageInTicks) {
		float f = Mth.sin(this.attackTime * (float) Math.PI);
		float f1 = Mth.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float) Math.PI);
		this.rightarm.zRot = 0.0F;
		this.leftarm.zRot = 0.0F;
		this.rightarm.yRot = -(0.1F - f * 0.6F);
		this.leftarm.yRot = 0.1F - f * 0.6F;
		this.rightarm.xRot = (-(float) Math.PI / 2F);
		this.leftarm.xRot = (-(float) Math.PI / 2F);
		this.rightarm.xRot -= f * 1.2F - f1 * 0.4F;
		this.leftarm.xRot -= f * 1.2F - f1 * 0.4F;
		AnimationUtils.bobArms(this.rightarm, this.leftarm, ageInTicks);
	}

	public void holdingMelee() {
		float f6 = 1.0F - attackTime;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		float f7 = Mth.sin(f6 * (float) Math.PI);
		float f8 = Mth.sin(attackTime * (float) Math.PI) * -(head.xRot - 0.7F) * 0.75F;

		rightarm.xRot = (float) ((double) rightarm.xRot - ((double) f7 * 1.2D + (double) f8));
		rightarm.xRot += (bodytop.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
	}

	private void animationFlee() {
		leftarm.xRot += 1.0472F;
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
		poseStack.translate(-0.0625, 0, -0.375);
		getArm(arm).translateAndRotate(poseStack);
	}
}