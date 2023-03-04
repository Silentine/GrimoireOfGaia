package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Valkyrie;
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

public class ValkyrieModel extends EntityModel<Valkyrie> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart hair1;
	private final ModelPart hair2;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftwing;
	private final ModelPart rightwing;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public ValkyrieModel(ModelPart root) {
		this.root = root.getChild("valkyrie");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.hair1 = neck.getChild("hair1");
		this.hair2 = this.hair1.getChild("hair2");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftwing = this.bodytop.getChild("leftwing");
		this.rightwing = this.bodytop.getChild("rightwing");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition valkyrie = partdefinition.addOrReplaceChild("valkyrie", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = valkyrie.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F)
				.texOffs(96, 0).addBox(-3.5F, -1.0F, -2.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -13.5F, -0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightfeather = head.addOrReplaceChild("rightfeather", CubeListBuilder.create().texOffs(36, 37).addBox(-4.5F, -7.0F, 0.0F, 1.0F, 6.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, -0.2618F, 0.0F));

		PartDefinition leftfeather = head.addOrReplaceChild("leftfeather", CubeListBuilder.create().texOffs(36, 37).addBox(3.5F, -7.0F, 0.0F, 1.0F, 6.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.2618F, 0.0F));

		PartDefinition headhelmet = head.addOrReplaceChild("headhelmet", CubeListBuilder.create().texOffs(36, 51).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 3.0F, 4.0F), PartPose.offset(0.0F, -5.5F, -1.0F));

		PartDefinition hair1 = neck.addOrReplaceChild("hair1", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -4.0F, 1.5F, 8.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition hair2 = hair1.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(36, 25).addBox(-4.5F, -0.5F, -2.5F, 9.0F, 9.0F, 3.0F), PartPose.offset(0.0F, 1.5F, 4.5F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(64, 23).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(-2.5F, -4.0F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-2.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(64, 30).addBox(-2.5F, 0.5F, -2.5F, 2.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).mirror(false)
				.texOffs(64, 23).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 3.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -4.0F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition cape1 = bodytop.addOrReplaceChild("cape1", CubeListBuilder.create().texOffs(64, 0).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.5F, 1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cape2 = cape1.addOrReplaceChild("cape2", CubeListBuilder.create().texOffs(64, 6).addBox(-4.0F, 0.0F, -2.5F, 8.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 3.5F, 0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cape3 = cape2.addOrReplaceChild("cape3", CubeListBuilder.create().texOffs(64, 14).addBox(-4.5F, 0.0F, -2.5F, 9.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.5F, 0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition rightwing = bodytop.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(92, 34).addBox(1.0F, 0.0F, 0.5F, 0.0F, 12.0F, 18.0F), PartPose.offsetAndRotation(-2.0F, -5.0F, 0.5F, 0.6981F, -0.5236F, 0.0F));

		PartDefinition leftwing = bodytop.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(92, 34).mirror().addBox(0.0F, 0.0F, 0.5F, 0.0F, 12.0F, 18.0F).mirror(false), PartPose.offsetAndRotation(2.0F, -5.0F, 0.5F, 0.6981F, 0.5236F, 0.0F));

		PartDefinition skirt1 = bodybottom.addOrReplaceChild("skirt1", CubeListBuilder.create().texOffs(96, 8).addBox(-4.0F, 0.0F, -3.5F, 8.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -0.5F, 2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition skirt2 = skirt1.addOrReplaceChild("skirt2", CubeListBuilder.create().texOffs(96, 16).addBox(-4.5F, 0.0F, -3.0F, 9.0F, 5.0F, 4.0F), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition skirt3 = skirt2.addOrReplaceChild("skirt3", CubeListBuilder.create().texOffs(96, 25).addBox(-5.0F, 0.0F, -3.0F, 10.0F, 5.0F, 4.0F), PartPose.offset(0.0F, 4.0F, 0.5F));

		PartDefinition rightleg = valkyrie.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(-2.0F, -13.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.505F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F)
				.texOffs(96, 34).addBox(-2.005F, -1.0F, -0.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition leftleg = valkyrie.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F).mirror(false), PartPose.offset(2.0F, -13.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-1.495F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F).mirror(false)
				.texOffs(96, 34).mirror().addBox(-1.995F, -1.0F, -0.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offset(0.0F, 6.0F, -1.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Valkyrie valkyrie, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(valkyrie, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !valkyrie.isBaby();
	}

	@Override
	public void setupAnim(Valkyrie entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = entityIn.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;
		hair1.yRot = head.yRot;
		hair1.xRot = head.xRot;
		hair2.xRot = (head.xRot) * 0.75F;

		// arms
		if (entityIn.getAnimationState() == 0) {
			rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > -9990.0F) {
				holdingMelee();
			}

			float armDefaultAngleZ = 0.1745329F;

			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
			rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
			leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		} else if (entityIn.getAnimationState() == 1) {
			animationBuff();
		}

		// body
		float wingDefaultAngleY = 0.5235988F;

		rightwing.yRot = Mth.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.yRot = Mth.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		rightwing.yRot -= wingDefaultAngleY;
		leftwing.yRot += wingDefaultAngleY;

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.35F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.35F * limbSwingAmount;
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

	private void animationBuff() {
		rightarm.xRot = 0.0F;
		leftarm.xRot = 0.0F;
		rightarm.zRot = 0.785398F;
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