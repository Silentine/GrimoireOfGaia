package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.trader.Trader;
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

public class TraderModel extends EntityModel<Trader> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart leftear;
	private final ModelPart rightear;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftarmlower;
	private final ModelPart rightarmlower;
	private final ModelPart tail;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public TraderModel(ModelPart root) {
		this.root = root.getChild("trader");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		ModelPart bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.leftear = this.head.getChild("leftear");
		this.rightear = this.head.getChild("rightear");
		this.chest = bodytop.getChild("chest");
		this.leftarm = bodytop.getChild("leftarm");
		this.leftarmlower = this.leftarm.getChild("leftarmlower");
		this.rightarm = bodytop.getChild("rightarm");
		this.rightarmlower = this.rightarm.getChild("rightarmlower");
		this.tail = bodybottom.getChild("tail");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition trader = partdefinition.addOrReplaceChild("trader", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

		PartDefinition bodybottom = trader.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, 8.0F, -2.5F, 6.0F, 3.0F, 3.0F)
				.texOffs(68, 16).addBox(-3.5F, 8.5F, -3.5F, 7.0F, 2.0F, 7.0F), PartPose.offset(0.0F, -23.0F, 1.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(36, 34).addBox(-1.0F, -0.5F, -4.0F, 2.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-1.5F, -6.0F, 0.0F, -1.3963F, 0.3491F, 0.0F));

		PartDefinition righteartip = rightear.addOrReplaceChild("righteartip", CubeListBuilder.create().texOffs(36, 39).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -0.5F, -4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(36, 34).mirror().addBox(-1.0F, -0.5F, -4.0F, 2.0F, 1.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(1.5F, -6.0F, 0.0F, -1.3963F, -0.3491F, 0.0F));

		PartDefinition lefteartip = leftear.addOrReplaceChild("lefteartip", CubeListBuilder.create().texOffs(36, 39).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -0.5F, -4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition righthairpin = head.addOrReplaceChild("righthairpin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righthairpin_r1 = righthairpin.addOrReplaceChild("righthairpin_r1", CubeListBuilder.create().texOffs(52, 26).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-4.0F, -6.0F, 3.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition righthair = righthairpin.addOrReplaceChild("righthair", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.0F, 0.0F));

		PartDefinition righthair_r1 = righthair.addOrReplaceChild("righthair_r1", CubeListBuilder.create().texOffs(36, 14).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-3.5F, -0.5F, 3.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition lefthairpin = head.addOrReplaceChild("lefthairpin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefthairpin_r1 = lefthairpin.addOrReplaceChild("lefthairpin_r1", CubeListBuilder.create().texOffs(36, 26).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(4.0F, -6.0F, 3.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition lefthair = lefthairpin.addOrReplaceChild("lefthair", CubeListBuilder.create(), PartPose.offset(0.5F, 0.0F, 0.0F));

		PartDefinition lefthair_r1 = lefthair.addOrReplaceChild("lefthair_r1", CubeListBuilder.create().texOffs(36, 14).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(3.5F, -0.5F, 3.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(96, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.25F))
				.texOffs(36, 42).addBox(-2.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0F, 0.1745F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-1.0F, 5.0F, 1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(96, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.25F))
				.texOffs(36, 42).addBox(-0.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0F, -0.1745F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(1.0F, 5.0F, 1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition tail = bodybottom.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(68, 10).addBox(-1.5F, -2.5F, -0.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition watch = bodybottom.addOrReplaceChild("watch", CubeListBuilder.create().texOffs(68, 0).addBox(-1.0F, 0.0F, -2.5F, 1.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.0F, 8.0F, -1.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition rightleg = trader.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -13.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition rightskirt01 = rightleg.addOrReplaceChild("rightskirt01", CubeListBuilder.create().texOffs(68, 25).addBox(-2.0F, 0.5F, -4.0F, 5.0F, 3.0F, 8.0F)
				.texOffs(68, 36).addBox(-2.5F, 3.5F, -4.5F, 6.0F, 5.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(68, 50).addBox(-1.505F, -2.5F, -2.0F, 3.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition rightfootlower = rightleglower.addOrReplaceChild("rightfootlower", CubeListBuilder.create().texOffs(68, 60).addBox(-1.505F, 0.0F, -1.0F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.5F, -2.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition leftleg = trader.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition leftskirt01 = leftleg.addOrReplaceChild("leftskirt01", CubeListBuilder.create().texOffs(68, 25).mirror().addBox(-3.0F, 0.495F, -4.0F, 5.0F, 3.0F, 8.0F).mirror(false)
				.texOffs(68, 36).mirror().addBox(-3.5F, 3.495F, -4.5F, 6.0F, 5.0F, 9.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(68, 50).mirror().addBox(-1.495F, -2.5F, -2.0F, 3.0F, 8.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, 1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition leftfootlower = leftleglower.addOrReplaceChild("leftfootlower", CubeListBuilder.create().texOffs(68, 60).mirror().addBox(-1.495F, 0.0F, -1.0F, 3.0F, 1.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 5.5F, -2.0F, 0.5236F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Trader trader, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(trader, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !trader.isBaby();
	}

	@Override
	public void setupAnim(Trader trader, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = ageInTicks % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		float earDefaultAngleZ = 0.2617994F;

		rightear.yRot = Mth.cos(Mth.DEG_TO_RAD * ((float) ageInTicks * 7)) * (Mth.DEG_TO_RAD * 4);
		rightear.yRot += earDefaultAngleZ;
		leftear.yRot = Mth.cos((Mth.DEG_TO_RAD * (float) ageInTicks * 7)) * -(Mth.DEG_TO_RAD * 4);
		leftear.yRot += -earDefaultAngleZ;

		// arms
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		float armDefaultAngleY = 0.349066F;
		float armDefaultAngleZ = 0.174533F;

		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		rightarm.yRot = +armDefaultAngleY;
		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;

		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.yRot = -armDefaultAngleY;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;

		rightarmlower.xRot = -armDefaultAngleY;
		leftarmlower.xRot = -armDefaultAngleY;

		// body
		tail.yRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		// legs
		rightleg.xRot = (Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount) * 0.5F;
		leftleg.xRot = (Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount) * 0.5F;
		rightleg.xRot += 0.3490659F;
		leftleg.xRot += 0.3490659F;
		rightleg.yRot = -0.0872665F;
		leftleg.yRot = 0.0872665F;
		rightleg.zRot = -0.0349066F;
		leftleg.zRot = 0.0349066F;

		if (riding) {
			rightarm.xRot += -((float) Math.PI / 5F);
			leftarm.xRot += -((float) Math.PI / 5F);
			rightleg.xRot = -1.4137167F;
			rightleg.yRot = ((float) Math.PI / 10F);
			rightleg.zRot = 0.07853982F;
			leftleg.xRot = -1.4137167F;
			leftleg.yRot = -((float) Math.PI / 10F);
			leftleg.zRot = -0.07853982F;
		}
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