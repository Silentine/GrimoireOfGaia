package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.AntWorker;
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

public class AntWorkerModel extends EntityModel<AntWorker> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart thorax1;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public AntWorkerModel(ModelPart root) {
		this.root = root.getChild("ant");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.thorax1 = bodybottom.getChild("thorax1");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ant = partdefinition.addOrReplaceChild("ant", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = ant.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -13.0F, -0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.5F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.4667F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		head.addOrReplaceChild("hairahoge", CubeListBuilder.create().texOffs(36, 14).addBox(0.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		head.addOrReplaceChild("headrighthair", CubeListBuilder.create().texOffs(36, 22).addBox(-4.0F, -7.0F, 2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 26).addBox(-5.0F, -6.0F, 3.0F, 2.0F, 4.0F, 2.0F)
				.texOffs(36, 32).addBox(-4.0F, -3.0F, 2.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0333F));

		head.addOrReplaceChild("headlefthair", CubeListBuilder.create().texOffs(36, 22).addBox(2.0F, -7.0F, 2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 26).addBox(3.0F, -6.0F, 3.0F, 2.0F, 4.0F, 2.0F)
				.texOffs(36, 32).addBox(2.0F, -3.0F, 2.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 17).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F)
				.texOffs(64, 9).addBox(-0.505F, 4.0F, -2.5F, 2.0F, 2.0F, 2.0F), PartPose.offset(-1.0F, 4.0F, 1.0F));

		rightarmlower.addOrReplaceChild("rightgauntlet_r1", CubeListBuilder.create().texOffs(64, 0).addBox(-1.0F, -6.0F, -1.5F, 2.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-1.005F, 5.0F, -1.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 17).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F).mirror(false)
				.texOffs(64, 9).mirror().addBox(-1.495F, 3.5F, -3.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(1.0F, 4.0F, 1.0F));

		leftarmlower.addOrReplaceChild("leftgauntlet_r1", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-1.0F, -6.0F, -1.5F, 2.0F, 6.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(1.005F, 5.0F, -1.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition rightarm2 = bodytop.addOrReplaceChild("rightarm2", CubeListBuilder.create().texOffs(64, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-2.5F, -1.0F, -2.5F, 0.0F, -0.5236F, 0.0F));

		rightarm2.addOrReplaceChild("rightarm2lower", CubeListBuilder.create().texOffs(64, 17).addBox(-0.505F, 0.0F, -1.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 0.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition leftarm2 = bodytop.addOrReplaceChild("leftarm2", CubeListBuilder.create().texOffs(64, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(2.5F, -1.0F, -2.5F, 0.0F, 0.5236F, 0.0F));

		leftarm2.addOrReplaceChild("leftarm2lower", CubeListBuilder.create().texOffs(64, 17).mirror().addBox(-0.495F, 0.0F, -1.0F, 1.0F, 3.0F, 1.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 2.5F, 0.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition thorax1 = bodybottom.addOrReplaceChild("thorax1", CubeListBuilder.create().texOffs(64, 21).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.5F, 1.8326F, 0.0F, 0.0F));

		PartDefinition thorax2 = thorax1.addOrReplaceChild("thorax2", CubeListBuilder.create().texOffs(64, 25).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		thorax2.addOrReplaceChild("thorax3", CubeListBuilder.create().texOffs(64, 34).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 4.0F, -1.0F));

		PartDefinition rightleg = ant.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F), PartPose.offsetAndRotation(-3.0F, -13.0F, -0.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition rightlegknee = rightleg.addOrReplaceChild("rightlegknee", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		rightlegknee.addOrReplaceChild("rightlegknee_r1", CubeListBuilder.create().texOffs(80, 0).addBox(-4.005F, 0.0F, 7.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(3.0F, 8.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightlegknee.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(80, 5).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, -0.2618F, 0.0F, 0.3491F));

		rightleglower.addOrReplaceChild("rightlegfoot", CubeListBuilder.create().texOffs(80, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(1.0F, 6.0F, -1.0F, 0.2618F, 0.0F, -0.1745F));

		PartDefinition leftleg = ant.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F), PartPose.offsetAndRotation(3.0F, -13.0F, -0.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition leftlegknee = leftleg.addOrReplaceChild("leftlegknee", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		leftlegknee.addOrReplaceChild("leftlegknee_r1", CubeListBuilder.create().texOffs(80, 0).addBox(1.995F, 0.0F, 7.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-3.0F, 8.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftlegknee.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(80, 5).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, -0.2618F, 0.0F, -0.3491F));

		leftleglower.addOrReplaceChild("leftlegfoot", CubeListBuilder.create().texOffs(80, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-1.0F, 6.0F, -1.0F, 0.2618F, 0.0F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(AntWorker ant, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(ant, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !ant.isBaby();
	}


	@Override
	public void setupAnim(AntWorker ant, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = ageInTicks % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (attackTime > 0.0F) {
			holdingMelee();
		}

		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		float thoraxDefaultAngleX = 1.047198F;
		thorax1.yRot = Mth.cos(((ageInTicks * 7) * Mth.DEG_TO_RAD)) * (2 * Mth.DEG_TO_RAD);
		thorax1.xRot = thoraxDefaultAngleX;

		// legs (walk_normal)
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		rightleg.xRot -= 0.1745329F;
		leftleg.xRot -= 0.1745329F;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
		rightleg.zRot = -0.1745329F;
		leftleg.zRot = 0.1745329F;

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
		poseStack.translate(0.0625F, ((1 / 16F) * 6), 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}