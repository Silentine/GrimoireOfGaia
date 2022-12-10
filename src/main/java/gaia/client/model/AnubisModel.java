package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Anubis;
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

public class AnubisModel extends EntityModel<Anubis> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart hair1;
	private final ModelPart hair2;
	private final ModelPart chest;
	private final ModelPart tail;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;


	public AnubisModel(ModelPart root) {
		this.root = root.getChild("anubis");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.hair1 = neck.getChild("hair1");
		this.hair2 = this.hair1.getChild("hair2");
		this.chest = this.bodytop.getChild("bodytop_female").getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.tail = bodybottom.getChild("tail");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition anubis = partdefinition.addOrReplaceChild("anubis", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = anubis.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.0F, 6.0F, 3.0F, 3.0F)
				.texOffs(76, 12).addBox(-3.5F, -2.0F, -1.5F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -13.5F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-0.5F, -2.0F, -1.6F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle_female = bodymiddle.addOrReplaceChild("bodymiddle_female", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, 5.5F, -1.5F, 4.0F, 3.0F, 2.0F), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition bodymiddle_male = bodymiddle.addOrReplaceChild("bodymiddle_male", CubeListBuilder.create().texOffs(0, 59).addBox(-2.5F, 5.5F, -1.5F, 5.0F, 3.0F, 2.0F), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(36, 50).addBox(-5.0F, -6.0F, -3.0F, 10.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 9.0F, 7.0F)
				.texOffs(36, 39).addBox(-1.0F, -8.0F, -4.6F, 2.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(36, 43).addBox(-4.5F, -10.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(36, 43).mirror().addBox(1.5F, -10.0F, -1.5F, 3.0F, 4.0F, 3.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hair1 = neck.addOrReplaceChild("hair1", CubeListBuilder.create().texOffs(36, 16).addBox(-4.0F, -6.0F, 1.0F, 8.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hair2 = hair1.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(36, 27).addBox(-4.5F, -1.0F, 1.5F, 9.0F, 9.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bodytop_female = bodytop.addOrReplaceChild("bodytop_female", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, 0.0F, -1.5F, 5.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition chest = bodytop_female.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.5F, -1.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition bodytop_male = bodytop.addOrReplaceChild("bodytop_male", CubeListBuilder.create().texOffs(0, 50).addBox(-3.0F, 0.0F, -1.5F, 6.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(64, 0).addBox(-1.5F, -3.0F, -2.5F, 2.0F, 8.0F, 3.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition rightarmhand = rightarmlower.addOrReplaceChild("rightarmhand", CubeListBuilder.create().texOffs(64, 11).addBox(0.0F, -1.5F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(-0.5F, 4.0F, -1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(64, 0).addBox(-0.5F, -3.0F, -2.5F, 2.0F, 8.0F, 3.0F), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition leftarmhand = leftarmlower.addOrReplaceChild("leftarmhand", CubeListBuilder.create().texOffs(64, 11).mirror().addBox(-2.0F, -1.5F, -2.0F, 2.0F, 4.0F, 4.0F).mirror(false), PartPose.offset(0.5F, 4.0F, -1.0F));

		PartDefinition tail = bodybottom.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(76, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 10.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 2.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition rightleg = anubis.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(-2.0F, -13.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.505F, 1.0F, 0.0F, 3.0F, 7.0F, 3.0F)
				.texOffs(76, 20).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 6.0F, 4.0F), PartPose.offset(0.0F, 5.0F, -1.5F));

		PartDefinition rightfoot = rightleglower.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(76, 30).addBox(-2.0F, 11.0F, -3.5F, 4.0F, 2.0F, 4.0F), PartPose.offset(0.0F, -5.0F, 1.5F));

		PartDefinition leftleg = anubis.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F).mirror(false), PartPose.offset(2.0F, -13.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-1.495F, 1.0F, 0.0F, 3.0F, 7.0F, 3.0F).mirror(false)
				.texOffs(76, 20).mirror().addBox(-2.0F, 0.0F, -0.5F, 4.0F, 6.0F, 4.0F).mirror(false), PartPose.offset(0.0F, 5.0F, -1.5F));

		PartDefinition leftfoot = leftleglower.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(76, 30).addBox(-2.0F, 11.0F, -3.5F, 4.0F, 2.0F, 4.0F), PartPose.offset(0.0F, -5.0F, 1.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Anubis anubis, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(anubis, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !anubis.isBaby();
	}

	@Override
	public void setupAnim(Anubis entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = entityIn.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;
		hair1.yRot = head.yRot;
		hair1.xRot = head.xRot;
		hair2.xRot = (head.xRot) * 0.75F;

		// arms
		if (entityIn.isMale()) {
			rightarm.x = -3F;
			leftarm.x = 3F;
		}

		if (entityIn.getAnimationState() == 0) {
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
		}

		if (entityIn.getAnimationState() == 1) {
			animationThrow();
		}

		if (entityIn.getAnimationState() == 2) {
			animationCast();
		}

		// body
		tail.yRot = Mth.cos((((float) entityIn.tickCount * 7) * Mth.DEG_TO_RAD)) * (5 * Mth.DEG_TO_RAD);

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
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

	private void animationThrow() {
		rightarm.xRot = -1.0472F;
	}

	private void animationCast() {
		rightarm.xRot = -1.0472F;
		leftarm.xRot = -1.0472F;
		rightarm.zRot = -0.261799F;
		leftarm.zRot = 0.261799F;
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