package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.WitherCow;
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

public class WitherCowModel extends EntityModel<WitherCow> implements HeadedModel {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart ribs;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public WitherCowModel(ModelPart root) {
		this.root = root.getChild("wither_cow");
		this.head = this.root.getChild("body1").getChild("head");
		this.ribs = this.root.getChild("ribs");
		this.leg1 = this.root.getChild("leg1");
		this.leg2 = this.root.getChild("leg2");
		this.leg3 = this.root.getChild("leg3");
		this.leg4 = this.root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition wither_cow = partdefinition.addOrReplaceChild("wither_cow", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body1 = wither_cow.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(28, 0).addBox(-6.0F, -1.0F, 0.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(72, 10).addBox(-5.5F, -0.5F, -5.0F, 11.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -8.0F, 1.309F, 0.0F, -0.1745F));

		PartDefinition head = body1.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 8.0F, -1.5708F, 0.1745F, 0.1745F));

		PartDefinition horn2_r1 = head.addOrReplaceChild("horn2_r1", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.0F, -3.5F, 0.0F, 0.0F, 0.2618F));

		PartDefinition horn1_r1 = head.addOrReplaceChild("horn1_r1", CubeListBuilder.create().texOffs(22, 0).addBox(0.0F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.0F, -3.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition body2 = wither_cow.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(28, 44).addBox(-6.0F, -9.0F, 0.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(72, 23).addBox(-5.5F, -9.5F, -5.0F, 11.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(72, 0).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 10.0F, 1.8326F, 0.0F, -0.1745F));

		PartDefinition ribs = wither_cow.addOrReplaceChild("ribs", CubeListBuilder.create().texOffs(28, 19).addBox(-5.5F, -8.0F, -4.5F, 11.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -15.5F, 0.0F, 1.5708F, 0.0F, -0.1745F));

		PartDefinition leg1 = wither_cow.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -12.0F, 7.0F, 0.1745F, 0.0F, 0.1745F));

		PartDefinition leg2 = wither_cow.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -12.0F, 7.0F));

		PartDefinition leg3 = wither_cow.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -12.0F, -6.0F, 0.0873F, 0.0F, 0.0873F));

		PartDefinition leg4 = wither_cow.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -11.0F, -6.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(WitherCow witherCow, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;
		head.yRot -= 0.1745329F;

		if (attackTime > -9990.0F) {
			holdingMelee();
		}

		// body
		ribs.zRot = Mth.cos(((float) witherCow.tickCount * 24) * Mth.DEG_TO_RAD) * (2 * Mth.DEG_TO_RAD);
		ribs.zRot -= 0.1745329F;

		// legs
		leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		leg3.xRot = leg2.xRot - 0.0872665F;
		leg4.xRot = leg1.xRot;
		leg1.xRot += 0.1745329F;
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

		head.xRot -= (float) ((double) head.xRot - ((double) f7 * 1.2D + (double) f8));
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getHead() {
		return head;
	}
}