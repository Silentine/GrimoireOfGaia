package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Kobold;
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
import net.minecraft.world.item.BowItem;

public class KoboldModel extends EntityModel<Kobold> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart rightear01;
	private final ModelPart leftear01;
	private final ModelPart rightear02;
	private final ModelPart leftear02;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart tail1;
	private final ModelPart tail2;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public KoboldModel(ModelPart root) {
		this.root = root.getChild("kobold");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		this.head = this.bodytop.getChild("neck").getChild("head");
		this.rightear01 = this.head.getChild("rightear01");
		this.leftear01 = this.head.getChild("leftear01");
		this.rightear02 = this.head.getChild("rightear02");
		this.leftear02 = this.head.getChild("leftear02");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.tail1 = bodybottom.getChild("tail1");
		this.tail2 = tail1.getChild("tail2");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition kobold = partdefinition.addOrReplaceChild("kobold", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = kobold.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F)
				.texOffs(76, 7).addBox(-3.5F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -1.6F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headaccessory = head.addOrReplaceChild("headaccessory", CubeListBuilder.create().texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear01 = head.addOrReplaceChild("rightear01", CubeListBuilder.create().texOffs(36, 26).addBox(0.0F, 0.0F, -4.0F, 3.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(-2.0F, -6.0F, 3.0F, -0.7854F, 0.7854F, 0.0F));

		PartDefinition leftear01 = head.addOrReplaceChild("leftear01", CubeListBuilder.create().texOffs(36, 26).mirror().addBox(-3.0F, 0.0F, -4.0F, 3.0F, 3.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(2.0F, -6.0F, 3.0F, -0.7854F, -0.7854F, 0.0F));

		PartDefinition rightear02 = head.addOrReplaceChild("rightear02", CubeListBuilder.create().texOffs(36, 33).addBox(-1.5F, -7.0F, -5.5F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition leftear02 = head.addOrReplaceChild("leftear02", CubeListBuilder.create().texOffs(36, 33).addBox(-1.5F, -7.0F, -5.5F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition headsnout = head.addOrReplaceChild("headsnout", CubeListBuilder.create().texOffs(36, 22).addBox(-1.5F, -2.0F, -2.5F, 3.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -2.5F, 0.0F, 8.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightcheek = head.addOrReplaceChild("rightcheek", CubeListBuilder.create().texOffs(46, 22).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-3.0F, -1.5F, -3.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition rightcheek03_r1 = rightcheek.addOrReplaceChild("rightcheek03_r1", CubeListBuilder.create().texOffs(47, 23).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition rightcheek01_r1 = rightcheek.addOrReplaceChild("rightcheek01_r1", CubeListBuilder.create().texOffs(47, 23).addBox(-1.0F, -1.0F, 0.25F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition leftcheek = head.addOrReplaceChild("leftcheek", CubeListBuilder.create().texOffs(46, 22).mirror().addBox(0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(3.0F, -1.5F, -3.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition leftcheek03_r1 = leftcheek.addOrReplaceChild("leftcheek03_r1", CubeListBuilder.create().texOffs(47, 23).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition leftcheek01_r1 = leftcheek.addOrReplaceChild("leftcheek01_r1", CubeListBuilder.create().texOffs(47, 23).addBox(0.0F, -1.0F, 0.25F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(0.25F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).addBox(-2.25F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(64, 0).addBox(-1.5F, -3.0F, -2.5F, 2.0F, 6.0F, 3.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition righthand = rightarmlower.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(64, 11).addBox(0.0F, 0.0F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-1.5F, 3.0F, -1.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-0.5F, -3.0F, -2.5F, 2.0F, 6.0F, 3.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition lefthand = leftarmlower.addOrReplaceChild("lefthand", CubeListBuilder.create().texOffs(64, 11).mirror().addBox(-2.0F, 0.0F, -2.0F, 2.0F, 4.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(1.5F, 3.0F, -1.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition backpack = bodybottom.addOrReplaceChild("backpack", CubeListBuilder.create().texOffs(76, 0).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -4.5F, 1.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition tail1 = bodybottom.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(76, 15).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(76, 22).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition leftleg = kobold.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(98, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(2.5F, -12.5F, 0.5F, -0.3491F, 0.0873F, 0.0436F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(98, 11).addBox(-1.495F, 0.0F, 0.0F, 3.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 3.5F, 1.5F));

		PartDefinition leftlegfoot = leftleglower.addOrReplaceChild("leftlegfoot", CubeListBuilder.create().texOffs(98, 21).addBox(-1.495F, 0.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition rightleg = kobold.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(98, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-2.5F, -12.5F, 0.5F, -0.3491F, -0.0873F, -0.0436F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(98, 11).addBox(-1.505F, 0.0F, 0.0F, 3.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 3.5F, 1.5F));

		PartDefinition rightlegfoot = rightleglower.addOrReplaceChild("rightlegfoot", CubeListBuilder.create().texOffs(98, 21).addBox(-1.505F, 0.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 2.0F, 0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Kobold kobold, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(kobold, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !kobold.isBaby();
	}

	@Override
	public void setupAnim(Kobold kobold, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = ageInTicks % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		float earDefaultAngleX = -0.7853982F;

		rightear01.xRot = Mth.cos((ageInTicks * 7) * Mth.DEG_TO_RAD) * (4 * Mth.DEG_TO_RAD);
		rightear01.xRot += earDefaultAngleX;
		leftear01.xRot = Mth.cos((ageInTicks * 7) * Mth.DEG_TO_RAD) * (4 * Mth.DEG_TO_RAD);
		leftear01.xRot += earDefaultAngleX;

		float earDefaultAngleZ = 0.7853982F;

		rightear02.yRot = Mth.cos((ageInTicks * 7) * Mth.DEG_TO_RAD) * (4 * Mth.DEG_TO_RAD);
		rightear02.yRot += earDefaultAngleZ;
		leftear02.yRot = Mth.cos((ageInTicks * 7) * Mth.DEG_TO_RAD) * -(4 * Mth.DEG_TO_RAD);
		leftear02.yRot -= earDefaultAngleZ;

		// arms
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (kobold.isAggressive() && (kobold.getMainHandItem().getItem() instanceof BowItem)) {
			holdingBow(ageInTicks);
		} else if (attackTime > 0.0F) {
			holdingMelee();
		}

		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		tail1.yRot = Mth.cos((ageInTicks * 7) * Mth.DEG_TO_RAD) * (15 * Mth.DEG_TO_RAD);
		tail2.yRot = Mth.cos((ageInTicks * 7) * Mth.DEG_TO_RAD) * (20 * Mth.DEG_TO_RAD);

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.xRot -= 0.3490659F;
		leftleg.xRot -= 0.3490659F;
		rightleg.yRot = -0.0872665F;
		leftleg.yRot = 0.0872665F;
		rightleg.zRot = -0.0349066F;
		leftleg.zRot = 0.0349066F;

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