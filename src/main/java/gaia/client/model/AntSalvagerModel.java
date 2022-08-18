package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.AntSalvager;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class AntSalvagerModel extends EntityModel<AntSalvager> {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart thorax1;

	public AntSalvagerModel(ModelPart root) {
		this.root = root.getChild("ant_ranger");
		ModelPart bodylower = this.root.getChild("bodylower");
		ModelPart bodyupper = bodylower.getChild("bodyupper");
		this.head = bodyupper.getChild("head");
		this.rightarm = bodyupper.getChild("rightarm");
		this.leftarm = bodyupper.getChild("leftarm");

		this.thorax1 = bodylower.getChild("thorax1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ant_ranger = partdefinition.addOrReplaceChild("ant_ranger", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodylower = ant_ranger.addOrReplaceChild("bodylower", CubeListBuilder.create().texOffs(32, 10).addBox(-2.5F, 5.0F, -1.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, 0.0F));

		PartDefinition bodyupper = bodylower.addOrReplaceChild("bodyupper", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 2.5F, 0.2182F, 0.0F, 0.0F));

		PartDefinition head = bodyupper.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -7.0F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 11).addBox(-3.5F, -4.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 11).addBox(1.5F, -4.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightantenna = head.addOrReplaceChild("rightantenna", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -3.0F, -7.0F, -0.2618F, 0.5236F, 0.0F));

		PartDefinition rightantennatop = rightantenna.addOrReplaceChild("rightantennatop", CubeListBuilder.create().texOffs(0, 21).addBox(-0.5F, -1.005F, -4.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftantenna = head.addOrReplaceChild("leftantenna", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -3.0F, -7.0F, -0.2618F, -0.5236F, 0.0F));

		PartDefinition leftantennatop = leftantenna.addOrReplaceChild("leftantennatop", CubeListBuilder.create().texOffs(0, 21).addBox(-0.5F, -1.005F, -4.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightmandable = head.addOrReplaceChild("rightmandable", CubeListBuilder.create().texOffs(0, 27).addBox(-2.0F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.0F, -5.0F, 0.0F, -0.3054F, 0.0F));

		PartDefinition leftmandable = head.addOrReplaceChild("leftmandable", CubeListBuilder.create().texOffs(0, 27).mirror().addBox(-1.0F, -1.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 1.0F, -5.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition rightarm = bodyupper.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(56, 0).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.0F, -3.0F, -0.3491F, -0.7854F, 0.2618F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(56, 4).addBox(-0.005F, 0.0F, -1.005F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition rightarmhand = rightarmlower.addOrReplaceChild("rightarmhand", CubeListBuilder.create().texOffs(56, 10).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition leftarm = bodyupper.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(56, 0).addBox(0.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, -3.0F, -0.3491F, 0.7854F, -0.2618F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(56, 4).addBox(-2.0F, 0.0F, -1.005F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition leftarmhand = leftarmlower.addOrReplaceChild("leftarmhand", CubeListBuilder.create().texOffs(56, 10).addBox(0.0F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 4.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition rightleg = bodyupper.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(56, 15).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, -0.7854F, 0.2182F, 1.5708F));

		PartDefinition rightlegfoot = rightleg.addOrReplaceChild("rightlegfoot", CubeListBuilder.create().texOffs(56, 21).addBox(-1.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftleg = bodyupper.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(56, 15).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -2.0F, -0.7854F, -0.2182F, -1.5708F));

		PartDefinition leftlegfoot = leftleg.addOrReplaceChild("leftlegfoot", CubeListBuilder.create().texOffs(56, 21).addBox(-1.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition thorax1 = bodylower.addOrReplaceChild("thorax1", CubeListBuilder.create().texOffs(32, 21).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 2.5F, -0.6981F, 0.0F, 0.0F));

		PartDefinition thorax2 = thorax1.addOrReplaceChild("thorax2", CubeListBuilder.create().texOffs(32, 35).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -1.0F, -0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(AntSalvager antSalvager, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// body
		float swingSpeed = 0.1F;
		float angleRange = 0.1F;
		float mandableDefaultAngleY = 0.1745329F;

		rightarm.yRot = Mth.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		rightarm.yRot -= mandableDefaultAngleY;
		leftarm.yRot = Mth.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		leftarm.yRot += mandableDefaultAngleY;

		// body
		thorax1.xRot = Mth.cos((((float) antSalvager.tickCount * 7)) * Mth.DEG_TO_RAD) * (2 * Mth.DEG_TO_RAD);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}