package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Mimic;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class MimicModel extends EntityModel<Mimic> {
	private final ModelPart root;
	private final ModelPart top;
	private final ModelPart bottom;

	public MimicModel(ModelPart root) {
		this.root = root.getChild("mimic");
		this.top = this.root.getChild("top");
		this.bottom = this.root.getChild("bottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mimic = partdefinition.addOrReplaceChild("mimic", CubeListBuilder.create().texOffs(56, 40).addBox(-5.0F, -26.0F, -4.0F, 10.0F, 14.0F, 10.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition top = mimic.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -19.0F, 7.0F, -0.6981F, 0.0F, 0.0F));

		top.addOrReplaceChild("lid1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -24.0F, -7.0F, 14.0F, 5.0F, 14.0F), PartPose.offset(0.0F, 19.0F, -7.0F));

		top.addOrReplaceChild("teeth1", CubeListBuilder.create().texOffs(56, 0).addBox(-6.0F, -22.0F, -6.0F, 12.0F, 8.0F, 12.0F), PartPose.offset(0.0F, 19.0F, -7.0F));

		top.addOrReplaceChild("lock", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -21.0F, -8.0F, 2.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 19.0F, -7.0F));

		PartDefinition bottom = mimic.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -19.0F, 7.0F, 0.3491F, 0.0F, 0.0F));

		bottom.addOrReplaceChild("lid2", CubeListBuilder.create().texOffs(0, 19).addBox(-7.0F, -19.0F, -7.0F, 14.0F, 10.0F, 14.0F), PartPose.offset(0.0F, 19.0F, -7.0F));

		bottom.addOrReplaceChild("teeth2", CubeListBuilder.create().texOffs(56, 20).addBox(-6.0F, -23.0F, -6.0F, 12.0F, 8.0F, 12.0F), PartPose.offset(0.0F, 19.0F, -7.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(Mimic entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// body
		top.xRot = Mth.cos(ageInTicks * 1.8F + (float) Math.PI) * 0.8F * 0.5F;
		bottom.xRot = Mth.cos(ageInTicks * 1.8F) * 0.8F * 0.5F;
		top.xRot -= 0.69813174F;
		bottom.xRot += 0.3490659F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}