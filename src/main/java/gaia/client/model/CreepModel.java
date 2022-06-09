package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Creep;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class CreepModel extends EntityModel<Creep> {
	private final ModelPart root;
	private final ModelPart body1;
	private final ModelPart head1;
	private final ModelPart head2;
	private final ModelPart head3;
	private final ModelPart smallhead1;
	private final ModelPart smallhead2;
	private final ModelPart smallhead3;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;

	public CreepModel(ModelPart root) {
		this.root = root.getChild("creep");
		this.body1 = this.root.getChild("body1");
		ModelPart body2 = this.body1.getChild("body2");

		this.head1 = body2.getChild("head1");
		this.head2 = body2.getChild("head2");
		this.head3 = body2.getChild("head3");
		this.smallhead1 = body2.getChild("smallhead1");
		this.smallhead2 = body2.getChild("smallhead2");
		this.smallhead3 = body2.getChild("smallhead3");
		this.leg1 = this.root.getChild("leg1");
		this.leg2 = this.root.getChild("leg2");
		this.leg3 = this.root.getChild("leg3");
		this.leg4 = this.root.getChild("leg4");
		this.leg5 = this.root.getChild("leg5");
		this.leg6 = this.root.getChild("leg6");
	}

	public static LayerDefinition createBodyLayer(CubeDeformation deformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition creep = partdefinition.addOrReplaceChild("creep", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body1 = creep.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, deformation), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition body2 = body1.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition body2_r1 = body2.addOrReplaceChild("body2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, deformation), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 1.5708F, -0.3491F, 0.0F));

		PartDefinition head1 = body2.addOrReplaceChild("head1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 8.0F, 8.0F, deformation), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.6109F, -0.7854F, -0.0873F));

		PartDefinition head2 = body2.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 8.0F, 8.0F, deformation), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.2618F, 0.7854F, 0.0873F));

		PartDefinition head3 = body2.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 8.0F, 8.0F, deformation), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.4363F, 3.1416F, 0.0F));

		PartDefinition smallhead1 = body2.addOrReplaceChild("smallhead1", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 6.0F, deformation), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.2618F, -2.0944F, 0.0873F));

		PartDefinition smallhead2 = body2.addOrReplaceChild("smallhead2", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 6.0F, deformation), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.1745F, 2.0944F, -0.0873F));

		PartDefinition smallhead3 = body2.addOrReplaceChild("smallhead3", CubeListBuilder.create().texOffs(0, 16).addBox(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 6.0F, deformation), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0873F, 0.0F, 0.0873F));

		PartDefinition leg1 = creep.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, deformation), PartPose.offsetAndRotation(2.5F, -6.0F, -4.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition leg2 = creep.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, deformation), PartPose.offsetAndRotation(-2.5F, -6.0F, -4.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition leg3 = creep.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, deformation), PartPose.offsetAndRotation(-5.0F, -6.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition leg4 = creep.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(48, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, deformation), PartPose.offsetAndRotation(-2.5F, -6.0F, 4.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition leg5 = creep.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(48, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, deformation), PartPose.offsetAndRotation(2.5F, -6.0F, 4.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition leg6 = creep.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, deformation), PartPose.offsetAndRotation(5.0F, -6.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Creep entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head1.xRot = Mth.cos(ageInTicks * 0.8F + (float) Math.PI) * 0.4F * limbSwingAmount * 0.5F;
		head2.xRot = head1.xRot - 0.2617994F;
		head3.xRot = head1.xRot - 0.4363323F;
		head1.xRot -= 0.6108652F;
		smallhead1.xRot = Mth.cos(ageInTicks * 1.2F + (float) Math.PI) * 0.6F * limbSwingAmount * 0.5F;
		smallhead2.xRot = smallhead1.xRot - 0.1745329F;
		smallhead3.xRot = smallhead1.xRot + 0.0872665F;
		smallhead1.xRot -= 0.2617994F;

		// body
		body1.yRot = netHeadYaw / 57.295776F;
		body1.xRot = headPitch / 57.295776F;
		// legs
		leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		leg3.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		leg4.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		leg5.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		leg6.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}