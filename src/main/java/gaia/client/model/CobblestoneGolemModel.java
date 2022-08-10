package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.CobblestoneGolem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class CobblestoneGolemModel extends EntityModel<CobblestoneGolem> {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart rightarm;
	private final ModelPart rightshoulder;
	private final ModelPart leftarm;
	private final ModelPart leftshoulder;
	private final ModelPart rightleg;
	private final ModelPart leftleg;

	public CobblestoneGolemModel(ModelPart root) {
		this.root = root.getChild("cobblestone_golem");
		ModelPart body = this.root.getChild("bodymid").getChild("bodylower").getChild("body");
		this.head = body.getChild("head");
		this.rightarm = body.getChild("rightarm");
		this.rightshoulder = this.rightarm.getChild("rightshoulder");
		this.leftarm = body.getChild("leftarm");
		this.leftshoulder = this.leftarm.getChild("leftshoulder");
		this.rightleg = this.root.getChild("rightleg");
		this.leftleg = this.root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cobblestone_golem = partdefinition.addOrReplaceChild("cobblestone_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -2.0F));

		PartDefinition bodymid = cobblestone_golem.addOrReplaceChild("bodymid", CubeListBuilder.create().texOffs(0, 61).addBox(-6.5F, 14.0F, 1.0F, 13.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -31.0F, -2.5F));

		PartDefinition bodylower = bodymid.addOrReplaceChild("bodylower", CubeListBuilder.create().texOffs(0, 45).addBox(-6.0F, -10.0F, -6.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 7.6F, 0.1745F, 0.0F, 0.0F));

		PartDefinition body = bodylower.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 26).addBox(-7.0F, -11.0F, -7.0F, 14.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(32, 0).addBox(-2.0F, -10.0F, -9.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 5).addBox(-1.0F, -5.0F, -9.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 9).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -7.1F, -0.5236F, 0.0F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(45, 17).addBox(-4.0F, -1.0F, -2.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -8.5F, -3.5F, -0.5236F, 0.2618F, 0.0F));

		PartDefinition rightshoulder = rightarm.addOrReplaceChild("rightshoulder", CubeListBuilder.create().texOffs(81, 0).mirror().addBox(-7.0F, -4.0F, -4.5F, 9.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.5F, 0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(45, 33).addBox(-2.505F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(73, 49).mirror().addBox(-3.505F, 2.5F, -6.0F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 10.0F, 3.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(45, 17).addBox(-1.0F, -1.0F, -2.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -8.5F, -3.5F, -0.5236F, -0.2618F, 0.0F));

		PartDefinition leftshoulder = leftarm.addOrReplaceChild("leftshoulder", CubeListBuilder.create().texOffs(45, 0).mirror().addBox(-2.0F, -4.0F, -4.5F, 9.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.2618F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(45, 33).addBox(-2.495F, 0.0F, -4.9F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(45, 49).mirror().addBox(-3.495F, 2.5F, -5.9F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 10.0F, 2.9F, -0.7854F, 0.0F, 0.0F));

		PartDefinition back = body.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 16).addBox(-6.0F, -5.0F, -5.0F, 12.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightleg = cobblestone_golem.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(45, 65).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -15.0F, 2.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(45, 79).addBox(-2.5F, -5.0F, 0.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -1.0F));

		PartDefinition leftleg = cobblestone_golem.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(45, 65).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -15.0F, 2.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(45, 79).addBox(-2.5F, -5.0F, 0.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void prepareMobModel(CobblestoneGolem cobbleGolem, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(cobbleGolem, limbSwing, limbSwingAmount, partialTick);
		int i = cobbleGolem.getAttackAnimationTick();

		if (i > 0) {
			rightarm.xRot = -2.0F + 1.5F * Mth.triangleWave((float) i - partialTick, 10.0F);
			leftarm.xRot = -2.0F + 1.5F * Mth.triangleWave((float) i - partialTick, 10.0F);
		} else {
			rightarm.xRot = 0F;
			leftarm.xRot = 0F;
		}
	}

	@Override
	public void setupAnim(CobblestoneGolem cobbleGolem, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = (headPitch / 57.295776F) + 0.2617994F;

		// arms
		rightshoulder.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftshoulder.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightshoulder.xRot = 0.0F;
		leftshoulder.xRot = 0.0F;

		rightshoulder.xRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) - 0.2617994F;
		rightshoulder.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		leftshoulder.xRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) - 0.2617994F;
		leftshoulder.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;

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