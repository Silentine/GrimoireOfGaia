package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Gryphon;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class GryphonModel extends EntityModel<Gryphon> implements HeadedModel {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart backleftleg1;
	private final ModelPart backrightleg1;
	private final ModelPart leftwing;
	private final ModelPart rightwing;
	private final ModelPart frontleftleg1;
	private final ModelPart frontrightleg1;
	private final ModelPart tail1, tail2, tail3;

	public GryphonModel(ModelPart root) {
		this.root = root.getChild("gryphon");
		ModelPart body2 = this.root.getChild("body2");
		ModelPart body1 = body2.getChild("body1");

		ModelPart neck1 = body1.getChild("neck2").getChild("neck1");
		this.head = neck1.getChild("head");
		this.leftwing = body1.getChild("leftwing");
		this.rightwing = body1.getChild("rightwing");
		this.frontleftleg1 = body1.getChild("frontleftleg1");
		this.frontrightleg1 = body1.getChild("frontrightleg1");

		this.backleftleg1 = body2.getChild("backleftleg1");
		this.backrightleg1 = body2.getChild("backrightleg1");
		this.tail1 = body2.getChild("tail1");
		this.tail2 = this.tail1.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition gryphon = partdefinition.addOrReplaceChild("gryphon", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body2 = gryphon.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(56, 19).addBox(-3.0F, 1.0F, -8.0F, 6.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -16.0F, -4.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition body1 = body2.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(56, 0).addBox(-4.0F, -9.0F, 0.0F, 8.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 1.0F, -9.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition neck2 = body1.addOrReplaceChild("neck2", CubeListBuilder.create().texOffs(28, 12).addBox(-3.5F, -8.0F, 0.0F, 7.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -9.0F, 1.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition neck1 = neck2.addOrReplaceChild("neck1", CubeListBuilder.create().texOffs(28, 0).addBox(-3.0F, -6.0F, 0.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition head = neck1.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 5.0F, 6.0F)
				.texOffs(0, 13).addBox(-1.5F, -1.0F, -8.0F, 3.0F, 3.0F, 4.0F)
				.texOffs(0, 20).addBox(-1.0F, -0.5F, -8.5F, 2.0F, 3.0F, 1.0F)
				.texOffs(0, 11).addBox(-2.5F, -2.0F, -5.0F, 5.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -6.0F, 3.0F));

		PartDefinition rightheadear = head.addOrReplaceChild("rightheadear", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, -2.5F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftheadear = head.addOrReplaceChild("leftheadear", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 6.0F).mirror(false), PartPose.offsetAndRotation(2.0F, -2.5F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightwing = body1.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(108, 38).addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 10.0F), PartPose.offsetAndRotation(-4.0F, -8.0F, 9.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition leftwing = body1.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(108, 38).addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 10.0F), PartPose.offsetAndRotation(4.0F, -8.0F, 9.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition frontrightleg1 = body1.addOrReplaceChild("frontrightleg1", CubeListBuilder.create().texOffs(92, 0).addBox(-3.0F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, -6.5F, 4.5F, -1.0472F, 0.0F, 0.0F));

		PartDefinition frontrightleg2 = frontrightleg1.addOrReplaceChild("frontrightleg2", CubeListBuilder.create().texOffs(92, 11).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-1.5F, 5.5F, 0.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition frontrightclaw = frontrightleg2.addOrReplaceChild("frontrightclaw", CubeListBuilder.create().texOffs(92, 22).addBox(-2.0F, 0.0F, -3.5F, 4.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition frontleftleg1 = body1.addOrReplaceChild("frontleftleg1", CubeListBuilder.create().texOffs(92, 0).mirror().addBox(0.0F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(3.0F, -6.5F, 4.6F, -1.0472F, 0.0F, 0.0F));

		PartDefinition frontleftleg2 = frontleftleg1.addOrReplaceChild("frontleftleg2", CubeListBuilder.create().texOffs(92, 11).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(1.5F, 5.5F, 0.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition frontleftclaw = frontleftleg2.addOrReplaceChild("frontleftclaw", CubeListBuilder.create().texOffs(92, 22).mirror().addBox(-2.0F, 0.0F, -3.5F, 4.0F, 1.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, 0.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition backleftleg1 = body2.addOrReplaceChild("backleftleg1", CubeListBuilder.create().texOffs(108, 0).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 6.0F).mirror(false), PartPose.offsetAndRotation(3.0F, 11.0F, 0.0F, -2.0944F, 0.0F, 0.0F));

		PartDefinition backleftleg2 = backleftleg1.addOrReplaceChild("backleftleg2", CubeListBuilder.create().texOffs(108, 14).mirror().addBox(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 6.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, -3.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition backleftleg3 = backleftleg2.addOrReplaceChild("backleftleg3", CubeListBuilder.create().texOffs(108, 23).mirror().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 6.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 6.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition backleftfoot = backleftleg3.addOrReplaceChild("backleftfoot", CubeListBuilder.create().texOffs(108, 32).mirror().addBox(-1.5F, -0.5F, -2.5F, 3.0F, 2.0F, 3.0F).mirror(false), PartPose.offset(0.0F, 5.5F, -2.5F));

		PartDefinition backrightleg1 = body2.addOrReplaceChild("backrightleg1", CubeListBuilder.create().texOffs(108, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 6.0F), PartPose.offsetAndRotation(-3.0F, 11.0F, 0.0F, -2.0944F, 0.0F, 0.0F));

		PartDefinition backrightleg2 = backrightleg1.addOrReplaceChild("backrightleg2", CubeListBuilder.create().texOffs(108, 14).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 8.0F, -3.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition backrightleg3 = backrightleg2.addOrReplaceChild("backrightleg3", CubeListBuilder.create().texOffs(108, 23).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 6.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition backrightfoot = backrightleg3.addOrReplaceChild("backrightfoot", CubeListBuilder.create().texOffs(108, 32).addBox(-1.5F, -0.5F, -2.5F, 3.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 5.5F, -2.5F));

		PartDefinition tail1 = body2.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(56, 39).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(56, 47).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 1.0F, 6.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(56, 54).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 6.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Gryphon entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;

		if (attackTime > 0.0F) {
			holdingMelee();
		}

		// arms
		float baseFrontRot = -(Mth.DEG_TO_RAD * 60);
		frontrightleg1.xRot = baseFrontRot + Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		frontleftleg1.xRot = baseFrontRot + Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;

		// body
		rightwing.yRot = Mth.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.yRot = Mth.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		rightwing.yRot = rightwing.yRot - 0.1745329F;
		leftwing.yRot = leftwing.yRot + 0.1745329F;

		tail1.yRot = Mth.cos(((float) ageInTicks * 7) * Mth.DEG_TO_RAD) * (5 * Mth.DEG_TO_RAD);
		tail2.yRot = Mth.cos(((float) ageInTicks * 7) * Mth.DEG_TO_RAD) * (7 * Mth.DEG_TO_RAD);

		tail1.xRot = -(60 * Mth.DEG_TO_RAD);
		tail2.xRot = (30 * Mth.DEG_TO_RAD);
		tail3.xRot = (30 * Mth.DEG_TO_RAD);

		// legs
		float baseBackRot = -(Mth.DEG_TO_RAD * 110);
		backrightleg1.xRot = baseBackRot - Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		backleftleg1.xRot = baseBackRot - Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
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