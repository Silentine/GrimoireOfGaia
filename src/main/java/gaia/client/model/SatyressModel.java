package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Satyress;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.phys.Vec3;

public class SatyressModel extends EntityModel<Satyress> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart tail;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public SatyressModel(ModelPart root) {
		this.root = root.getChild("satyress");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.tail = bodybottom.getChild("tail");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition satyress = partdefinition.addOrReplaceChild("satyress", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = satyress.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F)
				.texOffs(64, 9).addBox(-3.5F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -13.5F, -0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.5F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righthorn = head.addOrReplaceChild("righthorn", CubeListBuilder.create().texOffs(36, 30).addBox(-5.0F, -5.5F, -2.5F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 34).addBox(-6.0F, -6.5F, -1.5F, 2.0F, 2.0F, 3.0F)
				.texOffs(36, 39).addBox(-7.0F, -5.5F, 0.5F, 2.0F, 3.0F, 2.0F)
				.texOffs(36, 44).addBox(-7.5F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefthorn = head.addOrReplaceChild("lefthorn", CubeListBuilder.create().texOffs(36, 30).addBox(3.0F, -5.5F, -2.5F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 34).addBox(4.0F, -6.5F, -1.5F, 2.0F, 2.0F, 3.0F)
				.texOffs(36, 39).addBox(5.0F, -5.5F, 0.5F, 2.0F, 3.0F, 2.0F)
				.texOffs(36, 44).addBox(6.5F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righthair = head.addOrReplaceChild("righthair", CubeListBuilder.create().texOffs(36, 14).addBox(-5.5F, -4.5F, 1.5F, 4.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0873F));

		PartDefinition lefthair = head.addOrReplaceChild("lefthair", CubeListBuilder.create().texOffs(36, 14).addBox(1.5F, -4.5F, 1.5F, 4.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, -0.0873F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.25F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.25F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(64, 0).addBox(-2.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).mirror(false)
				.texOffs(64, 0).mirror().addBox(-0.5F, -1.5F, -1.5F, 3.0F, 5.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition tail = bodybottom.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(64, 17).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 5.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightleg = satyress.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -13.0F, -0.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(64, 23).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 5.0F, -0.5F));

		PartDefinition rightlegfoot = rightleglower.addOrReplaceChild("rightlegfoot", CubeListBuilder.create().texOffs(64, 29).addBox(-1.005F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition rightfoothoof_r1 = rightlegfoot.addOrReplaceChild("rightfoothoof_r1", CubeListBuilder.create().texOffs(64, 39).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition leftleg = satyress.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(2.0F, -13.0F, -0.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(64, 23).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 5.0F, -0.5F));

		PartDefinition leftfoot = leftleglower.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(64, 29).mirror().addBox(-0.995F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition leftfoothoof_r1 = leftfoot.addOrReplaceChild("leftfoothoof_r1", CubeListBuilder.create().texOffs(64, 39).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, -1.0297F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Satyress satyress, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(satyress, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !satyress.isBaby();
	}

	@Override
	public void setupAnim(Satyress satyress, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = ageInTicks % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

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

		if (satyress.isFleeing()) {
			Vec3 movement = satyress.getDeltaMovement();
			if (movement.x * movement.x + movement.z * movement.z > 2.500000277905201E-7D) {
				animationFlee();
			}
		}
		// body
		tail.yRot = Mth.cos(((ageInTicks * 7) * Mth.DEG_TO_RAD)) * (10 * Mth.DEG_TO_RAD);

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + 3.1415927F) * 0.8F * limbSwingAmount;
		rightleg.xRot -= 0.3490659F;
		leftleg.xRot -= 0.3490659F;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
		rightleg.zRot = 0.0F;
		leftleg.zRot = 0.0F;

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

	private void animationFlee() {
		leftarm.xRot += 1.0472F;
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