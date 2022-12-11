package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Deathword;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class DeathwordModel extends EntityModel<Deathword> {
	private final ModelPart root;
	private final ModelPart rightcover;
	private final ModelPart leftcover;
	private final ModelPart rightpage;
	private final ModelPart leftpage;
	private final ModelPart rightpagemiddle;
	private final ModelPart leftpagemiddle;

	public DeathwordModel(ModelPart root) {
		this.root = root.getChild("deathword");
		ModelPart binder = this.root.getChild("binder");
		this.rightcover = binder.getChild("rightcover");
		this.leftcover = binder.getChild("leftcover");
		ModelPart binderinside = binder.getChild("binderinside");
		this.rightpage = binderinside.getChild("rightpage");
		this.rightpagemiddle = this.rightpage.getChild("rightpagemiddle");
		this.leftpage = binderinside.getChild("leftpage");
		this.leftpagemiddle = this.leftpage.getChild("leftpagemiddle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition deathword = partdefinition.addOrReplaceChild("deathword", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition binder = deathword.addOrReplaceChild("binder", CubeListBuilder.create()
				.texOffs(34, 0).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 10.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightcover = binder.addOrReplaceChild("rightcover", CubeListBuilder.create()
				.texOffs(0, 10).addBox(-6.0F, -5.0F, 0.0F, 6.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition leftcover = binder.addOrReplaceChild("leftcover", CubeListBuilder.create()
				.texOffs(0, 0).addBox(0.0F, -5.0F, 0.0F, 6.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition binderinside = binder.addOrReplaceChild("binderinside", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightpage = binderinside.addOrReplaceChild("rightpage", CubeListBuilder.create()
				.texOffs(12, 9).addBox(-5.0F, -4.0F, 0.0F, 5.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition rightpagemiddle = rightpage.addOrReplaceChild("rightpagemiddle", CubeListBuilder.create()
				.texOffs(24, 8).addBox(0.0F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.7453F, 0.0F));

		PartDefinition leftpage = binderinside.addOrReplaceChild("leftpage", CubeListBuilder.create()
				.texOffs(12, 0).addBox(0.0F, -4.0F, 0.0F, 5.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition leftpagemiddle = leftpage.addOrReplaceChild("leftpagemiddle", CubeListBuilder.create()
				.texOffs(24, 0).addBox(0.0F, -4.0F, 0.0F, 5.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.3963F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Deathword entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float floatSpeed = 0.4F;
		float floatRange = 3.0F;

		// anchor
		root.y = 18.0F - Mth.cos(ageInTicks * 0.18F) * 0.9F;
		root.x = ((4 * Mth.DEG_TO_RAD));

		float swingSpeed = 0.4F;
		float angleRange = 0.8F;

		// body
		rightcover.yRot = Mth.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		rightcover.yRot -= (30 * Mth.DEG_TO_RAD);
		leftcover.yRot = Mth.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		leftcover.yRot += (30 * Mth.DEG_TO_RAD);

		rightpage.yRot = rightcover.yRot;
		leftpage.yRot = leftcover.yRot;

		float swingSpeed2 = 0.4F;
		float angleRange2 = 0.4F;

		rightpagemiddle.yRot = Mth.cos(ageInTicks * swingSpeed2 + (float) Math.PI) * angleRange2 * 0.5F;
		rightpagemiddle.yRot -= (210 * Mth.DEG_TO_RAD);
		leftpagemiddle.yRot = Mth.cos(ageInTicks * swingSpeed2) * angleRange2 * 0.5F;
		leftpagemiddle.yRot -= (-30 * Mth.DEG_TO_RAD);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}