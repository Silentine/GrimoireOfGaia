package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.CobbleGolem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class CobbleGolemModel extends EntityModel<CobbleGolem> {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart rightleg;
	private final ModelPart leftleg;

	public CobbleGolemModel(ModelPart root) {
		this.root = root.getChild("cobble_golem");
		ModelPart body = this.root.getChild("bodylower").getChild("body");
		this.head = body.getChild("head");
		this.rightarm = body.getChild("rightarm");
		this.leftarm = body.getChild("leftarm");
		this.rightleg = this.root.getChild("rightleg");
		this.leftleg = this.root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cobble_golem = partdefinition.addOrReplaceChild("cobble_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodylower = cobble_golem.addOrReplaceChild("bodylower", CubeListBuilder.create().texOffs(0, 28).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition body = bodylower.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 8).addBox(-7.0F, -12.0F, -7.0F, 14.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -7.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(44, 0).addBox(-6.0F, -4.0F, -3.0F, 6.0F, 12.0F, 6.0F)
				.texOffs(44, 18).addBox(-5.0F, 8.0F, -2.0F, 4.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(-7.0F, -8.0F, -3.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(0.0F, -4.0F, -3.0F, 6.0F, 12.0F, 6.0F).mirror(false)
				.texOffs(44, 18).addBox(1.0F, 8.0F, -2.0F, 4.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(7.0F, -8.0F, -3.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightleg = cobble_golem.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(44, 36).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, -8.5F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(44, 45).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -0.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition leftleg = cobble_golem.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(44, 36).mirror().addBox(-1.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(3.0F, -8.5F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(44, 45).mirror().addBox(-2.0F, -2.0F, 0.0F, 4.0F, 6.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 4.5F, -0.5F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(CobbleGolem cobbleGolem, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(cobbleGolem, limbSwing, limbSwingAmount, partialTick);

		int i = cobbleGolem.getAttackAnimationTick();
		float rotation = -(Mth.DEG_TO_RAD * 15);
		if (i > 0) {
			rightarm.xRot = rotation - 2.0F + 1.5F * Mth.triangleWave((float) i - partialTick, 10.0F);
			leftarm.xRot = rotation - 2.0F + 1.5F * Mth.triangleWave((float) i - partialTick, 10.0F);
		} else {
			rightarm.xRot = rotation + (-0.2F + 1.5F * Mth.triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
			leftarm.xRot = rotation + (-0.2F - 1.5F * Mth.triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
		}
	}

	@Override
	public void setupAnim(CobbleGolem cobbleGolem, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// legs
		rightleg.xRot = -1.5F * Mth.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		rightleg.xRot -= 0.1745329F;
		leftleg.xRot = 1.5F * Mth.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		leftleg.xRot -= 0.1745329F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}