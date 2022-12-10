package gaia.client.model.prop;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.prop.AntHill;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class AntHillModel extends EntityModel<AntHill> {
	private final ModelPart root;
	private final ModelPart body01;

	public AntHillModel(ModelPart root) {
		this.root = root.getChild("ant_hill");
		ModelPart body = this.root.getChild("body");
		this.body01 = body.getChild("body01");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ant_hill = partdefinition.addOrReplaceChild("ant_hill", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = ant_hill.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body01 = body.addOrReplaceChild("body01", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body02 = body.addOrReplaceChild("body02", CubeListBuilder.create().texOffs(0, 7).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body03 = body.addOrReplaceChild("body03", CubeListBuilder.create().texOffs(0, 18).addBox(-6.0F, -2.0F, -6.0F, 12.0F, 2.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(AntHill antHill, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		body01.visible = antHill.getSpawnAmount() <= 2;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}