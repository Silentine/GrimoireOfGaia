package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Mermaid;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class MermaidModel extends EntityModel<Mermaid> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart hair1;
	private final ModelPart hair2;

	private final ModelPart[] fins = new ModelPart[6];
	private final ModelPart fintail;

	public MermaidModel(ModelPart root) {
		this.root = root.getChild("mermaid");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.hair1 = neck.getChild("hair1");
		this.hair2 = this.hair1.getChild("hair2");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");

		for (int i = 0; i < this.fins.length; i++) {
			int index = i + 1;
			if (index == 1) {
				this.fins[i] = this.root.getChild("fin" + index);
			} else {
				this.fins[i] = this.fins[i - 1].getChild("fin" + index);
			}
		}
		this.fintail = this.fins[5].getChild("fintail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mermaid = partdefinition.addOrReplaceChild("mermaid", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = mermaid.addOrReplaceChild("bodybottom", CubeListBuilder.create()
				.texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F)
				.texOffs(68, 7).addBox(-4.0F, -1.5F, -2.5F, 8.0F, 8.0F, 5.0F), PartPose.offset(0.0F, -13.5F, 0.5F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create()
				.texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offset(0.0F, -1.5F, 1.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create()
				.texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create()
				.texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F)
				.texOffs(36, 37).addBox(-1.5F, -6.0F, 3.6F, 3.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		head.addOrReplaceChild("finright", CubeListBuilder.create()
				.texOffs(36, 36).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.0F, -2.0F, -3.0F, 0.0F, -0.5236F, 0.0F));

		head.addOrReplaceChild("finleft", CubeListBuilder.create()
				.texOffs(36, 36).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.0F, -2.0F, -3.0F, 0.0F, 0.5236F, 0.0F));

		head.addOrReplaceChild("headeyes", CubeListBuilder.create()
				.texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		head.addOrReplaceChild("headhelmet", CubeListBuilder.create()
				.texOffs(36, 46).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -4.5F, -1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition hair1 = neck.addOrReplaceChild("hair1", CubeListBuilder.create()
				.texOffs(36, 14).addBox(-4.0F, -6.0F, 1.0F, 8.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		hair1.addOrReplaceChild("hair2", CubeListBuilder.create()
				.texOffs(36, 25).addBox(-4.5F, -1.0F, 1.5F, 9.0F, 9.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		bodytop.addOrReplaceChild("chest", CubeListBuilder.create()
				.texOffs(0, 36).addBox(-2.6F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.3F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create()
				.texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-2.5F, -4.5F, -0.5F));

		rightarm.addOrReplaceChild("rightpauldron_r1", CubeListBuilder.create()
				.texOffs(68, 0).addBox(-3.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.3491F));

		rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create()
				.texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create()
				.texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(2.5F, -4.5F, -0.5F));

		leftarm.addOrReplaceChild("leftpauldron_r1", CubeListBuilder.create()
				.texOffs(68, 0).mirror().addBox(-1.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.3491F));

		leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create()
				.texOffs(16, 20).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition fin1 = mermaid.addOrReplaceChild("fin1", CubeListBuilder.create()
				.texOffs(100, 0).addBox(-3.5F, -1.0F, -2.0F, 7.0F, 4.0F, 4.0F), PartPose.offset(0.0F, -13.0F, 0.5F));

		PartDefinition fin2 = fin1.addOrReplaceChild("fin2", CubeListBuilder.create()
				.texOffs(100, 8).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 3.0F, -2.0F));

		PartDefinition fin3 = fin2.addOrReplaceChild("fin3", CubeListBuilder.create()
				.texOffs(100, 16).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition fin4 = fin3.addOrReplaceChild("fin4", CubeListBuilder.create()
				.texOffs(100, 24).addBox(-2.0F, 0.0F, 0.5F, 4.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition fin5 = fin4.addOrReplaceChild("fin5", CubeListBuilder.create()
				.texOffs(100, 31).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.5F));

		PartDefinition fin6 = fin5.addOrReplaceChild("fin6", CubeListBuilder.create()
				.texOffs(100, 37).addBox(-1.0F, 0.0F, 0.5F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 3.0F, 0.0F));

		fin6.addOrReplaceChild("fintail", CubeListBuilder.create()
				.texOffs(100, 41).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 7.0F, 0.0F), PartPose.offset(0.0F, 2.0F, 1.5F));

		fin2.addOrReplaceChild("fin2right", CubeListBuilder.create()
				.texOffs(120, 5).addBox(0.0F, 0.0F, -1.5F, 0.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(3.0F, 2.0F, 2.0F, 0.0F, 0.0F, -0.5236F));

		fin2.addOrReplaceChild("fin2left", CubeListBuilder.create()
				.texOffs(120, 5).addBox(0.0F, 0.0F, -1.5F, 0.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.5236F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Mermaid mermaid, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(mermaid, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !mermaid.isBaby();
	}

	@Override
	public void setupAnim(Mermaid mermaid, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = mermaid.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;
		hair1.yRot = head.yRot;
		hair1.xRot = head.xRot;
		hair2.xRot = (head.xRot) * 0.75F;

		// arms
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (attackTime > 0.0F) {
			holdingMelee();
		}

		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

		// legs
		fins[0].xRot = -0.1308997F;
		fins[1].xRot = +0.3926991F;
		fins[2].xRot = +0.3926991F;
		fins[3].xRot = +0.785398F;
		fintail.xRot = +0.3926991F;

		if (mermaid.isInWater()) {
			fins[0].zRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			fins[1].zRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			fins[2].zRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			fins[3].zRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			fins[4].zRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			fins[5].zRot = -0.1F * Mth.cos(ageInTicks * 0.3F);
			fintail.zRot = -0.2F * Mth.cos(ageInTicks * 0.3F);
		} else {
			fins[0].zRot = -0.1F * Mth.cos(limbSwing * 0.3F);
			fins[1].zRot = -0.1F * Mth.cos(limbSwing * 0.3F);
			fins[2].zRot = -0.1F * Mth.cos(limbSwing * 0.3F);
			fins[3].zRot = -0.1F * Mth.cos(limbSwing * 0.3F);
			fins[4].zRot = -0.1F * Mth.cos(limbSwing * 0.3F);
			fins[5].zRot = -0.1F * Mth.cos(limbSwing * 0.3F);
			fintail.zRot = -0.2F * Mth.cos(limbSwing * 0.3F);
		}
	}

	public void holdingMelee() {
		float f6;
		float f7;

		f6 = 1.0F - attackTime;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = Mth.sin(f6 * (float) Math.PI);
		float f8 = Mth.sin(attackTime * (float) Math.PI) * -(head.xRot - 0.7F) * 0.75F;

		rightarm.xRot = (float) ((double) rightarm.xRot - ((double) f7 * 1.2D + (double) f8));
		rightarm.xRot += (bodytop.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
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
		poseStack.translate(-0.125D, 0.5D, 0);
		if (arm == HumanoidArm.LEFT) {
			poseStack.translate(0.125F, 0, 0.0625D);
		}
		getArm(arm).translateAndRotate(poseStack);
	}
}