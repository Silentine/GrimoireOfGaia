package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Mandragora;
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

public class MandragoraModel extends EntityModel<Mandragora> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public MandragoraModel(ModelPart root) {
		this.root = root.getChild("mandragora");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mandragora = partdefinition.addOrReplaceChild("mandragora", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = mandragora.addOrReplaceChild("bodybottom", CubeListBuilder.create()
						.texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F)
						.texOffs(64, 0).addBox(-3.5F, -2.0F, -2.0F, 7.0F, 5.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, -13.5F, -0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create()
						.texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
						.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F),
				PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
						.texOffs(86, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(1.0F))
						.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(36, 48).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(3.0F, -3.0F, -2.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(36, 48).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, -3.0F, -2.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition headleaf1 = head.addOrReplaceChild("headleaf1", CubeListBuilder.create().texOffs(36, 14).addBox(-3.0F, -10.0F, -6.0F, 6.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.309F, 0.7854F, 0.0F));

		PartDefinition headleaf2 = head.addOrReplaceChild("headleaf2", CubeListBuilder.create().texOffs(36, 14).addBox(-3.0F, -10.0F, -6.0F, 6.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.309F, -0.7854F, 0.0F));

		PartDefinition headleaf3 = head.addOrReplaceChild("headleaf3", CubeListBuilder.create().texOffs(36, 14).addBox(-3.0F, -10.0F, -6.0F, 6.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.309F, -2.3562F, 0.0F));

		PartDefinition headleaf4 = head.addOrReplaceChild("headleaf4", CubeListBuilder.create().texOffs(36, 14).addBox(-3.0F, -10.0F, -6.0F, 6.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.309F, 2.3562F, 0.0F));

		PartDefinition headleafs1 = head.addOrReplaceChild("headleafs1", CubeListBuilder.create().texOffs(36, 22).addBox(-2.0F, -9.5F, -5.5F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition headleafs2 = head.addOrReplaceChild("headleafs2", CubeListBuilder.create().texOffs(36, 22).addBox(-2.0F, -9.5F, -5.5F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, -1.5708F, 0.0F));

		PartDefinition headleafs3 = head.addOrReplaceChild("headleafs3", CubeListBuilder.create().texOffs(36, 22).addBox(-2.0F, -9.5F, -5.5F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, -3.1416F, 0.0F));

		PartDefinition headleafs4 = head.addOrReplaceChild("headleafs4", CubeListBuilder.create().texOffs(36, 22).addBox(-2.0F, -9.5F, -5.5F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, 1.5708F, 0.0F));

		PartDefinition headflower1 = head.addOrReplaceChild("headflower1", CubeListBuilder.create().texOffs(36, 28).addBox(-3.0F, -12.5F, 0.0F, 6.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition headflower2_r1 = headflower1.addOrReplaceChild("headflower2_r1", CubeListBuilder.create().texOffs(36, 28).addBox(-3.0F, -35.5F, 0.0F, 6.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition hairright = neck.addOrReplaceChild("hairright", CubeListBuilder.create().texOffs(36, 34).addBox(-4.5F, -2.0F, 0.5F, 4.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0436F));

		PartDefinition hairleft = neck.addOrReplaceChild("hairleft", CubeListBuilder.create().texOffs(36, 34).addBox(0.5F, -2.0F, 0.5F, 4.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, -0.0436F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition rightleg = mandragora.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -13.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.505F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition leftleg = mandragora.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.495F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F), PartPose.offset(0.0F, 6.0F, -1.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Mandragora entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;
		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.xRot += 0.0349066F;
		leftleg.xRot += 0.0349066F;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
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