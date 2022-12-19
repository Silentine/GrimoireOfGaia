package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.GelatinousSlime;
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

public class GelatinousSlimeModel extends EntityModel<GelatinousSlime> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodyupper;
	private final ModelPart head;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart bodylower;
	private final ModelPart leftleg;

	public GelatinousSlimeModel(ModelPart root) {
		this.root = root.getChild("gelatinous_slime");
		this.bodyupper = this.root.getChild("bodyupper");
		this.head = this.bodyupper.getChild("head");
		this.rightarm = this.bodyupper.getChild("rightarm");
		this.leftarm = this.root.getChild("invisiblearm");
		this.bodylower = this.bodyupper.getChild("bodylower");
		this.leftleg = this.root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition gelatinous_slime = partdefinition.addOrReplaceChild("gelatinous_slime", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodyupper = gelatinous_slime.addOrReplaceChild("bodyupper", CubeListBuilder.create()
						.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F),
				PartPose.offsetAndRotation(-6.0F, -21.0F, -4.0F, 0.6109F, -0.3491F, 0.0F));

		bodyupper.addOrReplaceChild("head", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.4363F, 0.4363F, 0.0F));

		bodyupper.addOrReplaceChild("rightarm", CubeListBuilder.create()
						.texOffs(40, 16).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F),
				PartPose.offsetAndRotation(-4.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition leftarm = bodyupper.addOrReplaceChild("leftarm", CubeListBuilder.create()
						.texOffs(40, 16).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F),
				PartPose.offsetAndRotation(4.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create()
						.texOffs(40, 22).addBox(-2.0F, 0.0F, -1.005F, 2.0F, 6.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 3.1416F, 0.0F, 2.3562F));

		PartDefinition bodylower = bodyupper.addOrReplaceChild("bodylower", CubeListBuilder.create()
						.texOffs(16, 28).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 4.0F),
				PartPose.offsetAndRotation(0.0F, 8.0F, 2.0F, 0.7854F, 0.0F, 0.0F));

		bodylower.addOrReplaceChild("rightleg", CubeListBuilder.create()
						.texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F),
				PartPose.offsetAndRotation(-2.0F, 4.0F, -2.0F, 0.4363F, 0.0F, -0.5236F));

		gelatinous_slime.addOrReplaceChild("invisiblearm", CubeListBuilder.create()
						.texOffs(0, 114).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F),
				PartPose.offsetAndRotation(2.0F, -20.0F, 8.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition leftleg = gelatinous_slime.addOrReplaceChild("leftleg", CubeListBuilder.create()
						.texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F),
				PartPose.offsetAndRotation(4.0F, -12.0F, 0.0F, -0.7854F, -0.4363F, 0.5236F));

		leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create()
						.texOffs(0, 22).addBox(-1.095F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F),
				PartPose.offsetAndRotation(0.1F, 6.0F, -1.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition mainbody1 = gelatinous_slime.addOrReplaceChild("mainbody1", CubeListBuilder.create()
						.texOffs(64, 0).addBox(-16.0F, -16.0F, -16.0F, 32.0F, 32.0F, 32.0F)
						.texOffs(64, 0).addBox(-18.0F, -11.0F, 4.0F, 2.0F, 2.0F, 2.0F)
						.texOffs(64, 4).addBox(16.0F, -3.0F, -6.0F, 3.0F, 3.0F, 3.0F)
						.texOffs(64, 4).addBox(-19.0F, -8.0F, -2.0F, 3.0F, 3.0F, 3.0F),
				PartPose.offset(0.0F, -16.0F, 0.0F));

		mainbody1.addOrReplaceChild("mainbody2", CubeListBuilder.create()
						.texOffs(64, 64).addBox(-12.0F, -12.0F, -12.0F, 24.0F, 24.0F, 24.0F)
						.texOffs(160, 64).addBox(-12.0F, -12.0F, -12.0F, 24.0F, 24.0F, 24.0F),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		mainbody1.addOrReplaceChild("slimesoutheast", CubeListBuilder.create()
						.texOffs(76, 0).addBox(14.0F, 12.0F, -18.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		mainbody1.addOrReplaceChild("slimenortheast", CubeListBuilder.create()
						.texOffs(76, 0).addBox(14.0F, 12.0F, 14.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		mainbody1.addOrReplaceChild("slimenorthwest", CubeListBuilder.create()
						.texOffs(76, 0).addBox(-18.0F, 12.0F, 14.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		mainbody1.addOrReplaceChild("slimesouthwest", CubeListBuilder.create()
						.texOffs(76, 0).addBox(-18.0F, 12.0F, -18.0F, 4.0F, 4.0F, 4.0F),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(GelatinousSlime entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float floatSpeed = 0.2F;
		float floatRange = 0.2F;
		// anchor
		root.y = -2.0F + Mth.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		float rightarmDefaultAngleZ = 1.047198F;

		rightarm.zRot = Mth.cos(((float) entityIn.tickCount * 7) * Mth.DEG_TO_RAD) * (2 * Mth.DEG_TO_RAD);
		rightarm.zRot += rightarmDefaultAngleZ;

		// body
		float bodyupperDefaultAngleX = 0.6108652F;

		bodyupper.xRot = Mth.cos(((float) entityIn.tickCount * 7) * Mth.DEG_TO_RAD) * (2 * Mth.DEG_TO_RAD);
		bodyupper.xRot += bodyupperDefaultAngleX;

		float bodylowerDefaultAngleX = 1.047198F;

		bodylower.xRot = Mth.cos(((float) entityIn.tickCount * 7) * Mth.DEG_TO_RAD) * (2 * Mth.DEG_TO_RAD);
		bodylower.xRot += bodylowerDefaultAngleX;

		// legs
		float leftlegDefaultAngleX = 0.7853982F;

		leftleg.xRot = Mth.cos(((float) entityIn.tickCount * 7) * Mth.DEG_TO_RAD) * (2 * Mth.DEG_TO_RAD);
		leftleg.xRot -= leftlegDefaultAngleX;
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
		getArm(arm).translateAndRotate(poseStack);
	}
}