package gaia.client.model.prop;

import gaia.client.state.CyanFlowerRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class CyanFlowerModel extends EntityModel<CyanFlowerRenderState> {
	
	public CyanFlowerModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mandragora_flower = partdefinition.addOrReplaceChild("mandragora_flower", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition headflower1 = mandragora_flower.addOrReplaceChild("headflower1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition headflower2 = mandragora_flower.addOrReplaceChild("headflower2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
}