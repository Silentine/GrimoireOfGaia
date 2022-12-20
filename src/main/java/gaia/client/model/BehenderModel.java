package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Behender;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class BehenderModel extends EntityModel<Behender> {
	private final ModelPart root;
	private final ModelPart headTop;
	private final ModelPart headBottom;
	private final ModelPart eye01b;
	private final ModelPart eye02b;
	private final ModelPart eye03b;
	private final ModelPart eye04b;
	private final ModelPart eye05b;
	private final ModelPart eye06b;
	private final ModelPart eye07b;
	private final ModelPart eye08b;
	private final ModelPart eye09b;

	public BehenderModel(ModelPart root) {
		this.root = root.getChild("behender");
		this.headTop = this.root.getChild("headtop01");
		this.eye01b = this.headTop.getChild("eye01b");
		this.eye02b = this.headTop.getChild("eye02b");
		this.eye03b = this.headTop.getChild("eye03b");
		this.eye04b = this.headTop.getChild("eye04b");
		this.eye05b = this.headTop.getChild("eye05b");
		this.eye06b = this.headTop.getChild("eye06b");
		this.eye07b = this.headTop.getChild("eye07b");
		this.eye08b = this.headTop.getChild("eye08b");
		this.eye09b = this.headTop.getChild("eye09b");
		this.headBottom = this.root.getChild("headbottom01");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition behender = partdefinition.addOrReplaceChild("behender", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition headtop01 = behender.addOrReplaceChild("headtop01", CubeListBuilder.create()
						.texOffs(0, 28).addBox(-8.0F, -8.0F, -10.0F, 16.0F, 10.0F, 20.0F)
						.texOffs(0, 0).addBox(-8.0F, -10.0F, -8.0F, 16.0F, 12.0F, 16.0F)
						.texOffs(0, 58).addBox(-10.0F, -8.0F, -8.0F, 20.0F, 10.0F, 16.0F)
						.texOffs(128, 12).addBox(-6.0F, 2.0F, -6.0F, 12.0F, 4.0F, 12.0F),
				PartPose.offset(0.0F, -13.0F, 0.0F));

		headtop01.addOrReplaceChild("headfangright", CubeListBuilder.create()
						.texOffs(0, 84).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offsetAndRotation(-5.0F, 2.0F, -9.0F, 0.0F, -0.7854F, 0.0F));

		headtop01.addOrReplaceChild("headfangleft", CubeListBuilder.create()
						.texOffs(0, 92).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offsetAndRotation(5.0F, 2.0F, -9.0F, 0.0F, -0.7854F, 0.0F));

		headtop01.addOrReplaceChild("eye01a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(0.0F, -12.0F, -1.0F));

		headtop01.addOrReplaceChild("eye01b", CubeListBuilder.create()
						.texOffs(192, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(0.0F, -15.0F, -1.0F));

		headtop01.addOrReplaceChild("eye02a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(4.0F, -11.0F, 5.0F));

		headtop01.addOrReplaceChild("eye02b", CubeListBuilder.create()
						.texOffs(192, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(7.0F, -14.0F, 5.0F));

		headtop01.addOrReplaceChild("eye03a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(10.0F, -7.0F, 1.0F));

		headtop01.addOrReplaceChild("eye03b", CubeListBuilder.create()
						.texOffs(192, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(13.0F, -10.0F, 1.0F));

		headtop01.addOrReplaceChild("eye04b", CubeListBuilder.create()
						.texOffs(192, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(15.0F, -2.5F, 3.0F));

		headtop01.addOrReplaceChild("eye04a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(12.0F, -2.5F, 3.0F));

		headtop01.addOrReplaceChild("eye05a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(10.0F, 2.0F, -1.0F));

		headtop01.addOrReplaceChild("eye05b", CubeListBuilder.create()
						.texOffs(192, 12).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(13.0F, 5.0F, -1.0F));

		headtop01.addOrReplaceChild("eye06a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(-10.0F, 2.0F, -1.0F));

		headtop01.addOrReplaceChild("eye06b", CubeListBuilder.create()
						.texOffs(192, 12).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(-13.0F, 5.0F, -1.0F));

		headtop01.addOrReplaceChild("eye07a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(-12.0F, -2.5F, 3.0F));

		headtop01.addOrReplaceChild("eye07b", CubeListBuilder.create()
						.texOffs(192, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(-15.0F, -2.5F, 3.0F));

		headtop01.addOrReplaceChild("eye08a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(-10.0F, -7.0F, 1.0F));

		headtop01.addOrReplaceChild("eye08b", CubeListBuilder.create()
						.texOffs(192, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(-13.0F, -10.0F, 1.0F));

		headtop01.addOrReplaceChild("eye09a", CubeListBuilder.create()
						.texOffs(176, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(-4.0F, -11.0F, 5.0F));

		headtop01.addOrReplaceChild("eye09b", CubeListBuilder.create()
						.texOffs(192, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 6.0F),
				PartPose.offset(-7.0F, -14.0F, 5.0F));

		behender.addOrReplaceChild("headbottom01", CubeListBuilder.create()
						.texOffs(72, 18).addBox(-6.0F, 0.0F, -14.0F, 12.0F, 4.0F, 16.0F)
						.texOffs(72, 38).addBox(-8.0F, 0.0F, -12.0F, 16.0F, 4.0F, 12.0F)
						.texOffs(128, 28).addBox(-6.0F, -4.0F, -12.0F, 12.0F, 4.0F, 12.0F)
						.texOffs(128, 0).addBox(-7.0F, -6.0F, -6.0F, 14.0F, 6.0F, 6.0F)
						.texOffs(72, 0).addBox(-6.0F, 0.0F, -12.0F, 12.0F, 6.0F, 12.0F),
				PartPose.offsetAndRotation(0.0F, -11.0F, 6.0F, 0.5236F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(Behender entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float floatSpeed = 0.25F;
		float floatRange = 3.0F;

		// anchor
		root.y = 24.0F - Mth.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;


		// head
		headTop.yRot = netHeadYaw / 57.295776F;
		headTop.xRot = headPitch / 57.295776F;

		float angleRange = 0.15F;
		float angleRange2 = 0.25F;

		eye01b.xRot = Mth.cos(ageInTicks * floatSpeed) * angleRange * 0.5F;
		eye02b.xRot = eye01b.xRot;
		eye03b.xRot = eye01b.xRot;
		eye04b.xRot = Mth.cos(ageInTicks * floatSpeed) * angleRange2 * 0.5F;
		eye05b.xRot = eye04b.xRot;
		eye06b.xRot = eye04b.xRot;
		eye07b.xRot = eye04b.xRot;
		eye08b.xRot = eye01b.xRot;
		eye09b.xRot = eye01b.xRot;

		headBottom.xRot = Mth.cos(ageInTicks * floatSpeed) * angleRange2 * 0.5F;
		headBottom.xRot += 0.5235988F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}