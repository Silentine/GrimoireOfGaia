package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Succubus;
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

public class SuccubusModel extends EntityModel<Succubus> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftwing;
	private final ModelPart rightwing;
	private final ModelPart tail;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public SuccubusModel(ModelPart root) {
		this.root = root.getChild("succubus");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("bodytop_female").getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftwing = this.bodytop.getChild("leftwing");
		this.rightwing = this.bodytop.getChild("rightwing");
		this.tail = bodybottom.getChild("tail");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition succubus = partdefinition.addOrReplaceChild("succubus", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = succubus.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F)
				.texOffs(64, 24).addBox(-3.5F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -13.5F, -0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition tail = bodybottom.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(64, 15).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 1.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-0.5F, -2.0F, -1.6F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bonemiddle_female = bodymiddle.addOrReplaceChild("bonemiddle_female", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bodymiddle_male = bodymiddle.addOrReplaceChild("bodymiddle_male", CubeListBuilder.create().texOffs(0, 59).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.0F, 0.4F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -0.9F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hornbase = head.addOrReplaceChild("hornbase", CubeListBuilder.create().texOffs(36, 37).addBox(2.0F, -7.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 37).addBox(-4.0F, -7.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition horn_female = hornbase.addOrReplaceChild("horn_female", CubeListBuilder.create().texOffs(36, 41).addBox(3.0F, -6.0F, -4.0F, 2.0F, 2.0F, 3.0F)
				.texOffs(36, 41).addBox(-5.0F, -6.0F, -4.0F, 2.0F, 2.0F, 3.0F)
				.texOffs(36, 46).addBox(2.0F, -7.0F, -5.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 46).addBox(-4.0F, -7.0F, -5.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 50).addBox(1.5F, -7.5F, -4.5F, 1.0F, 1.0F, 1.0F)
				.texOffs(36, 50).addBox(-2.5F, -7.5F, -4.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition horn_male = hornbase.addOrReplaceChild("horn_male", CubeListBuilder.create().texOffs(36, 57).addBox(3.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 57).addBox(-5.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 62).addBox(2.5F, -8.5F, -1.5F, 1.0F, 1.0F, 1.0F)
				.texOffs(36, 62).addBox(-3.5F, -8.5F, -1.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hair1 = neck.addOrReplaceChild("hair1", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -6.0F, 1.0F, 8.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition hair2 = hair1.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(36, 25).addBox(-4.5F, -1.0F, 1.5F, 9.0F, 9.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bodytop_female = bodytop.addOrReplaceChild("bodytop_female", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -3.0F, 5.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.6F));

		PartDefinition chest = bodytop_female.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, -0.45F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, -0.45F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.3F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bodytop_male = bodytop.addOrReplaceChild("bodytop_male", CubeListBuilder.create().texOffs(0, 50).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.6F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -0.9F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 18).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(64, 6).addBox(-2.0F, 0.5F, -2.5F, 2.0F, 6.0F, 3.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition rightpauldron = rightarm.addOrReplaceChild("rightpauldron", CubeListBuilder.create().texOffs(64, 0).addBox(-2.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, -0.9F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F).mirror(false)
				.texOffs(64, 6).mirror().addBox(0.0F, 0.5F, -2.5F, 2.0F, 6.0F, 3.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition leftpauldron = leftarm.addOrReplaceChild("leftpauldron", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-0.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightwing = bodytop.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(104, 42).addBox(0.0F, -1.0F, 0.0F, 0.0F, 14.0F, 8.0F), PartPose.offsetAndRotation(1.5F, -5.0F, 1.6F, 0.5236F, 0.7854F, 0.0F));

		PartDefinition leftwing = bodytop.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(112, 42).addBox(0.0F, -1.0F, 0.0F, 0.0F, 14.0F, 8.0F), PartPose.offsetAndRotation(-1.5F, -5.0F, 1.6F, 0.5236F, -0.7854F, 0.0F));

		PartDefinition leftleg = succubus.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(2.0F, -13.0F, -0.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(86, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 4.0F, 2.0F));

		PartDefinition leftfoot = leftleglower.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(86, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition leftfootback = leftleglower.addOrReplaceChild("leftfootback", CubeListBuilder.create().texOffs(86, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition rightleg = succubus.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -13.0F, -0.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(86, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 4.0F, 2.0F));

		PartDefinition rightfoot = rightleglower.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(86, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition rightfootback = rightleglower.addOrReplaceChild("rightfootback", CubeListBuilder.create().texOffs(86, 18).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Succubus succubus, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(succubus, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !succubus.isBaby();
	}

	@Override
	public void setupAnim(Succubus succubus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = ageInTicks % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		if (succubus.isMale()) {
			rightarm.x = -3F;
			leftarm.x = 3F;
		}

		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (attackTime > 0.0F) {
			holdingMelee();
		}

		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		rightwing.yRot = Mth.cos(ageInTicks * 0.3F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.yRot = Mth.cos(ageInTicks * 0.3F) * 1.0F * limbSwingAmount * 0.5F;
		--rightwing.yRot;
		++leftwing.yRot;

		float chestDefaultRotateAngleX = 0.7853982F;
		chest.xRot = (Mth.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount) + chestDefaultRotateAngleX;

		tail.yRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightleg.xRot -= 0.1745329F;
		leftleg.xRot -= 0.1745329F;
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
		getArm(arm).translateAndRotate(poseStack);
	}
}