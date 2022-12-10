package gaia.client.model.prop;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.prop.Chest;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class ChestModel extends EntityModel<Chest> {
	private final ModelPart root;

	public ChestModel(ModelPart root) {
		this.root = root.getChild("mimic_chest");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mimic_chest = partdefinition.addOrReplaceChild("mimic_chest", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition top = mimic_chest.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, 1.0F, -7.0F, 14.0F, 5.0F, 14.0F)
				.texOffs(0, 0).addBox(-1.0F, -1.0F, 7.0F, 2.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bottom = mimic_chest.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 19).addBox(-7.0F, -8.0F, -7.0F, 14.0F, 10.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Chest entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		switch (entity.getRotation()) {
			case 0:
				root.yRot = 0;
				break;
			case 1:
				root.yRot = (90 * Mth.DEG_TO_RAD);
				break;
			case 2:
				root.yRot = (180 * Mth.DEG_TO_RAD);
				break;
			case 3:
				root.yRot = (270 * Mth.DEG_TO_RAD);
				break;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}