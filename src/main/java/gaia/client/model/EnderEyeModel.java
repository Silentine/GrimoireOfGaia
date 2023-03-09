package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.EnderEye;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class EnderEyeModel extends EntityModel<EnderEye> {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart eyelid1;
	private final ModelPart eyelid2;
	private final ModelPart tail1;
	private final ModelPart leftwing;
	private final ModelPart rightwing;

	public EnderEyeModel(ModelPart root) {
		this.root = root.getChild("ender_eye");
		this.body = this.root.getChild("body");
		this.eyelid1 = this.body.getChild("eyelid1");
		this.eyelid2 = this.body.getChild("eyelid2");
		this.tail1 = this.eyelid2.getChild("tail1");
		this.leftwing = this.body.getChild("leftwing");
		this.rightwing = this.body.getChild("rightwing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ender_eye = partdefinition.addOrReplaceChild("ender_eye", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition body = ender_eye.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition eyelid1 = body.addOrReplaceChild("eyelid1", CubeListBuilder.create().texOffs(0, 14).addBox(-5.0F, -5.0F, -9.0F, 10.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 3.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition eyelid2 = body.addOrReplaceChild("eyelid2", CubeListBuilder.create().texOffs(0, 29).addBox(-5.0F, 0.0F, -10.0F, 10.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 4.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition tail1 = eyelid2.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 44).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.0F, -3.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 50).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 1.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 56).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition rightwing = body.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(98, 38).addBox(0.0F, 0.0F, -3.0F, 0.0F, 16.0F, 10.0F), PartPose.offsetAndRotation(-2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition leftwing = body.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(98, 38).mirror().addBox(0.0F, 0.0F, -3.0F, 0.0F, 16.0F, 10.0F).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, 2.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(EnderEye enderEye, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float floatSpeed = 0.5F;
		float floatRange = 3.0F;

		// anchor
		root.y = 15.0F - Mth.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;

		// body
		body.yRot = netHeadYaw / 57.295776F;

		float swingSpeed = 0.5F;
		float angleRange = 0.2F;

		eyelid1.xRot = Mth.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		eyelid2.xRot = Mth.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		eyelid2.xRot = (20 * Mth.DEG_TO_RAD);

		float swingSpeed2 = 0.5F;
		float angleRange2 = 1.0F;
		float wingDefaultAngleZ = 1.570796F;

		leftwing.zRot = Mth.cos(ageInTicks * swingSpeed2 + (float) Math.PI) * angleRange2 * 0.5F;
		leftwing.zRot += wingDefaultAngleZ;
		rightwing.zRot = Mth.cos(ageInTicks * swingSpeed2) * angleRange2 * 0.5F;
		rightwing.zRot -= wingDefaultAngleZ;

		float tailDefaultAngleX = 0.7853982F;

		tail1.xRot = Mth.cos((ageInTicks * 7) * Mth.DEG_TO_RAD) * (5 * Mth.DEG_TO_RAD);
		tail1.xRot += tailDefaultAngleX;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}