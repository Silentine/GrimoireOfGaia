package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Sphinx;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class SphinxModel extends EntityModel<Sphinx> implements HeadedModel {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart rightwing;
	private final ModelPart leftwing;
	private final ModelPart rightleg;
	private final ModelPart leftleg;
	private final ModelPart tail;

	public SphinxModel(ModelPart root) {
		this.root = root.getChild("sphinx");
		ModelPart body3 = this.root.getChild("body3");
		this.tail = body3.getChild("tail");
		ModelPart body1 = body3.getChild("body2").getChild("body1");
		ModelPart neck = body1.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = body1.getChild("chest");
		this.rightarm = body1.getChild("rightarm");
		this.leftarm = body1.getChild("leftarm");
		this.rightwing = body1.getChild("rightwing");
		this.leftwing = body1.getChild("leftwing");
		this.rightleg = body3.getChild("rightleg");
		this.leftleg = body3.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sphinx = partdefinition.addOrReplaceChild("sphinx", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body3 = sphinx.addOrReplaceChild("body3", CubeListBuilder.create()
				.texOffs(66, 15).addBox(-3.0F, 3.0F, -8.0F, 6.0F, 10.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -16.0F, -3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition body2 = body3.addOrReplaceChild("body2", CubeListBuilder.create()
				.texOffs(66, 0).addBox(-3.5F, -7.0F, 0.0F, 7.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, -8.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition body1 = body2.addOrReplaceChild("body1", CubeListBuilder.create()
				.texOffs(0, 16).addBox(-2.5F, -6.0F, 0.0F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition neck = body1.addOrReplaceChild("neck", CubeListBuilder.create()
				.texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, 1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-3.0F, -6.5F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -7.0F, -3.5F, 7.0F, 7.0F, 7.0F)
				.texOffs(36, 21).addBox(-4.0F, -5.5F, -2.0F, 8.0F, 6.0F, 6.0F)
				.texOffs(36, 33).addBox(-1.0F, -8.0F, -4.6F, 2.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create()
				.texOffs(24, 0).addBox(-3.0F, -6.5F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create()
				.texOffs(36, 14).mirror().addBox(1.5F, -10.5F, -1.5F, 3.0F, 4.0F, 3.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create()
				.texOffs(36, 14).addBox(-4.5F, -10.5F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = body1.addOrReplaceChild("chest", CubeListBuilder.create()
				.texOffs(0, 25).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 25).mirror().addBox(1.6F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(-1.3F, -5.5F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = body1.addOrReplaceChild("rightarm", CubeListBuilder.create()
				.texOffs(18, 12).addBox(-1.5F, 0.0F, -1.5F, 2.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(-3.0F, -5.5F, 2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create()
				.texOffs(18, 22).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 7.0F, 3.0F)
				.texOffs(36, 37).addBox(-2.005F, 4.0F, -2.5F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-0.5F, 8.0F, 0.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition righthand = rightarmlower.addOrReplaceChild("righthand", CubeListBuilder.create()
				.texOffs(18, 32).addBox(-1.505F, 0.0F, -2.5F, 3.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition leftarm = body1.addOrReplaceChild("leftarm", CubeListBuilder.create()
				.texOffs(18, 12).mirror().addBox(0.0F, 0.0F, -1.5F, 2.0F, 8.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -5.5F, 2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create()
				.texOffs(18, 22).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 7.0F, 3.0F)
				.texOffs(36, 37).mirror().addBox(-1.995F, 4.0F, -2.5F, 4.0F, 2.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, 0.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition lefthand = leftarmlower.addOrReplaceChild("lefthand", CubeListBuilder.create()
				.texOffs(18, 32).mirror().addBox(-1.495F, 0.0F, -2.5F, 3.0F, 2.0F, 3.0F).mirror(false), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition rightwing = body1.addOrReplaceChild("rightwing", CubeListBuilder.create()
				.texOffs(104, 36).addBox(0.0F, -1.0F, -1.0F, 0.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(-3.5F, -5.0F, 4.0F, 0.8727F, -0.5236F, -0.2618F));

		PartDefinition leftwing = body1.addOrReplaceChild("leftwing", CubeListBuilder.create()
				.texOffs(104, 36).addBox(0.0F, -1.0F, -1.0F, 0.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(3.5F, -5.0F, 4.0F, 0.8727F, 0.5236F, 0.2618F));

		PartDefinition tail = body3.addOrReplaceChild("tail", CubeListBuilder.create()
				.texOffs(66, 32).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F), PartPose.offset(0.0F, 13.0F, -2.0F));

		PartDefinition rightleg = body3.addOrReplaceChild("rightleg", CubeListBuilder.create()
				.texOffs(96, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 6.0F), PartPose.offsetAndRotation(-3.0F, 11.0F, -1.0F, -2.0944F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create()
				.texOffs(96, 14).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 8.0F, -3.0F, 2.618F, 0.0F, 0.0F));

		PartDefinition rightleglower2 = rightleglower.addOrReplaceChild("rightleglower2", CubeListBuilder.create()
				.texOffs(96, 23).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 6.0F, 3.0F)
				.texOffs(36, 37).addBox(-2.0F, 2.0F, -3.5F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-0.1F, 3.0F, -6.0F, -2.0944F, 0.0F, 0.0F));

		PartDefinition rightfoot = rightleglower2.addOrReplaceChild("rightfoot", CubeListBuilder.create()
				.texOffs(96, 32).addBox(-1.5F, 0.0F, -2.5F, 3.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 4.0F, -2.5F));

		PartDefinition leftleg = body3.addOrReplaceChild("leftleg", CubeListBuilder.create()
				.texOffs(96, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 6.0F), PartPose.offsetAndRotation(3.0F, 11.0F, -1.0F, -2.0944F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create()
				.texOffs(96, 14).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 8.0F, -3.0F, 2.618F, 0.0F, 0.0F));

		PartDefinition leftleglower2 = leftleglower.addOrReplaceChild("leftleglower2", CubeListBuilder.create()
				.texOffs(96, 23).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 6.0F, 3.0F)
				.texOffs(36, 37).addBox(-2.0F, 2.0F, -3.5F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.1F, 3.0F, -6.0F, -2.0944F, 0.0F, 0.0F));

		PartDefinition leftfoot = leftleglower2.addOrReplaceChild("leftfoot", CubeListBuilder.create()
				.texOffs(96, 32).addBox(-1.5F, 0.0F, -2.5F, 3.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 4.0F, -2.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Sphinx sphinx, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(sphinx, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !sphinx.isBaby();
	}

	@Override
	public void setupAnim(Sphinx sphinx, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = ageInTicks % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;

		// body
		rightwing.yRot = Mth.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.yRot = Mth.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		rightwing.yRot -= 0.5235988F;
		leftwing.yRot += 0.5235988F;

		tail.yRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		rightleg.xRot -= 1.9;
		leftleg.xRot -= 1.9;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getHead() {
		return head;
	}
}