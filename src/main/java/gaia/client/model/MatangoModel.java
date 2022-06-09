package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Matango;
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

public class MatangoModel extends EntityModel<Matango> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart waist1;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public MatangoModel(ModelPart root) {
		this.root = root.getChild("matango");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		ModelPart bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		this.head = bodytop.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = bodytop.getChild("chest");
		this.leftarm = bodytop.getChild("leftarm");
		this.rightarm = bodytop.getChild("rightarm");
		this.waist1 = bodybottom.getChild("waist1");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition matango = partdefinition.addOrReplaceChild("matango", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = matango.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -1.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 12).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition head = bodytop.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(24, 6).addBox(-3.0F, -6.0F, -3.6F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headmushroom = head.addOrReplaceChild("headmushroom", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(36, 28).addBox(-7.0F, -4.5F, -2.9F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(36, 28).addBox(1.0F, -4.5F, -2.9F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 0.0F));

		PartDefinition righthair = head.addOrReplaceChild("righthair", CubeListBuilder.create().texOffs(36, 40).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(36, 57).addBox(-1.0F, 9.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(48, 40).addBox(-2.0F, 11.5F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.5F, 3.0F, 0.1745F, 0.0F, 0.2618F));

		PartDefinition lefthair = head.addOrReplaceChild("lefthair", CubeListBuilder.create().texOffs(36, 40).addBox(-1.5F, -1.6F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(36, 57).addBox(-1.0F, 9.4F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(48, 40).addBox(-2.0F, 11.4F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.4F, 3.0F, 0.1745F, 0.0F, -0.2618F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.5F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 18).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, -3.5F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 12).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).mirror().addBox(-1.5F, -1.0F, -2.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition waist1 = bodybottom.addOrReplaceChild("waist1", CubeListBuilder.create().texOffs(80, 14).addBox(-3.5F, 1.5F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(80, 23).addBox(-4.0F, 3.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(80, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(80, 7).addBox(-2.5F, 0.5F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.1F, -0.5F));

		PartDefinition rightleg = matango.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -13.0F, 0.0F, 0.0F, -0.0436F, -0.0436F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 19).addBox(-1.505F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-2.0F, 1.0F, -0.5F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition leftleg = matango.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, 0.0F, 0.0436F, 0.0436F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 19).addBox(-1.495F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(80, 35).addBox(-2.0F, 1.0F, -0.5F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -1.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Matango matango, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(matango, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get();
	}

	@Override
	public void setupAnim(Matango entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = entity.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		waist1.yRot = ((Mth.cos(limbSwing * 0.6662F) * 0.5F) / 2) * limbSwingAmount;

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
		rightleg.zRot = -0.0349066F;
		leftleg.zRot = 0.0349066F;

		if (riding) {
			rightarm.xRot -= ((float) Math.PI / 5F);
			leftarm.xRot -= ((float) Math.PI / 5F);
			rightleg.xRot = -1.4137167F;
			rightleg.yRot = ((float) Math.PI / 10F);
			rightleg.zRot = 0.07853982F;
			leftleg.xRot = -1.4137167F;
			leftleg.yRot = -((float) Math.PI / 10F);
			leftleg.zRot = -0.07853982F;
		}
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
		poseStack.translate(0, 0.5, 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}