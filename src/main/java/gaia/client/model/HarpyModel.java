package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.client.state.HarpyRenderState;
import gaia.config.GaiaConfig;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class HarpyModel extends EntityModel<HarpyRenderState> implements HeadedModel, ArmedModel {
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

	public HarpyModel(ModelPart root) {
		super(root);
		this.root = root.getChild("harpy");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.tail = bodybottom.getChild("tail");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition harpy = partdefinition.addOrReplaceChild("harpy", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = harpy.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -13.5F, -0.5F, 1.0472F, 0.0F, 0.0F));

		PartDefinition bodymid = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -1.6F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 0.5F, -0.6109F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymid.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.1F, -0.2618F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.1F));

		PartDefinition hair = head.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(36, 14).addBox(-2.0F, -2.5F, -1.0F, 5.0F, 5.0F, 5.0F), PartPose.offset(-0.5F, -5.5F, 3.0F));

		PartDefinition hairahoge = head.addOrReplaceChild("hairahoge", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -2.0F));

		PartDefinition hairahoge_r1 = hairahoge.addOrReplaceChild("hairahoge_r1", CubeListBuilder.create().texOffs(36, 24).addBox(0.0F, -33.5F, 0.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 29.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition rightfeather = head.addOrReplaceChild("rightfeather", CubeListBuilder.create(), PartPose.offset(3.5F, -4.0F, -1.5F));

		PartDefinition rightfeather_r1 = rightfeather.addOrReplaceChild("rightfeather_r1", CubeListBuilder.create().texOffs(36, 32).addBox(0.0F, -1.0F, -1.0F, 1.0F, 6.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, -0.2618F));

		PartDefinition leftfeather = head.addOrReplaceChild("leftfeather", CubeListBuilder.create(), PartPose.offset(-3.5F, -4.0F, -1.5F));

		PartDefinition leftfeather_r1 = leftfeather.addOrReplaceChild("leftfeather_r1", CubeListBuilder.create().texOffs(36, 32).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 6.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.2618F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -29.0F, -3.6F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 23.0F, 0.5F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(0.2F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false)
				.texOffs(0, 36).addBox(-2.2F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -5.55F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-3.5F, -4.5F, -1.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition rightwing_r1 = rightarmlower.addOrReplaceChild("rightwing_r1", CubeListBuilder.create().texOffs(64, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 12.0F), PartPose.offsetAndRotation(0.5F, 6.0F, -2.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition rightwinglower = rightarmlower.addOrReplaceChild("rightwinglower", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition rightwinglower_r1 = rightwinglower.addOrReplaceChild("rightwinglower_r1", CubeListBuilder.create().texOffs(64, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(3.5F, -4.5F, -1.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -1.0036F, 0.0F, 0.0F));

		PartDefinition leftwing_r1 = leftarmlower.addOrReplaceChild("leftwing_r1", CubeListBuilder.create().texOffs(64, 16).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 12.0F), PartPose.offsetAndRotation(-0.5F, 6.0F, -2.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition leftwinglower = leftarmlower.addOrReplaceChild("leftwinglower", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition leftwinglower_r1 = leftwinglower.addOrReplaceChild("leftwinglower_r1", CubeListBuilder.create().texOffs(64, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition tail = bodybottom.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(90, 0).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 10.0F, 1.0F), PartPose.offset(0.0F, -1.5F, 1.5F));

		PartDefinition rightleg = harpy.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-2.5F, -13.0F, 0.5F, -0.5236F, -0.0873F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(90, 11).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F)
				.texOffs(90, 17).addBox(-0.5F, 4.0F, 0.5F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -1.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition righttalon = rightleglower.addOrReplaceChild("righttalon", CubeListBuilder.create().texOffs(90, 24).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition righttalonlower = righttalon.addOrReplaceChild("righttalonlower", CubeListBuilder.create().texOffs(90, 29).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition leftleg = harpy.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(2.5F, -13.0F, 0.5F, -0.5236F, 0.0873F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(90, 11).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F)
				.texOffs(90, 17).addBox(-0.5F, 4.0F, 0.55F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -1.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition lefttalon = leftleglower.addOrReplaceChild("lefttalon", CubeListBuilder.create().texOffs(90, 24).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition lefttalonlower = lefttalon.addOrReplaceChild("lefttalonlower", CubeListBuilder.create().texOffs(90, 29).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -1.0472F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(HarpyRenderState state) {
		super.setupAnim(state);

		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !state.isBaby;

		headeyes.visible = state.ageInTicks % 60 == 0 && state.walkAnimationSpeed <= 0.1F;

		// head
		head.yRot = state.yRot / 57.295776F;
		head.xRot = (state.xRot / 57.295776F) + 0.0872665F;

		// arms
		rightarm.yRot = Mth.cos(state.ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * state.walkAnimationSpeed * 0.5F - 0.1745329F;
		leftarm.yRot = Mth.cos(state.ageInTicks * 0.6662F) * 1.0F * state.walkAnimationSpeed * 0.5F + 0.1745329F;

		rightarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.8F * state.walkAnimationSpeed * 0.5F + 0.6108652F;
		leftarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 0.8F * state.walkAnimationSpeed * 0.5F + 0.6108652F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		rightarm.zRot += (Mth.cos(state.ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.3490659F;
		rightarm.xRot += Mth.sin(state.ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(state.ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.3490659F;
		leftarm.xRot -= Mth.sin(state.ageInTicks * 0.067F) * 0.025F;


		if (state.isFleeing && state.moving) {
			animationFlee();
		}

		// body
		tail.yRot = Mth.cos(((float) state.ageInTicks * 7) * Mth.DEG_TO_RAD) * (5 * Mth.DEG_TO_RAD);

		// legs
		rightleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 0.8F * state.walkAnimationSpeed;
		leftleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.8F * state.walkAnimationSpeed;
		rightleg.xRot -= 0.5235988F;
		leftleg.xRot -= 0.5235988F;
		rightleg.yRot = -0.0872665F;
		leftleg.yRot = 0.0872665F;
		rightleg.zRot = 0.0F;
		leftleg.zRot = 0.0F;

		if (state.isRiding) {
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

	public void holdingMelee(ArmedEntityRenderState state) {
		float f6;
		float f7;

		f6 = 1.0F - state.attackTime;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = Mth.sin(f6 * (float) Math.PI);
		float f8 = Mth.sin(state.attackTime * (float) Math.PI) * -(head.xRot - 0.7F) * 0.75F;

		// right arm
		rightarm.xRot -= (float) ((double) rightarm.xRot - ((double) f7 * 1.2D + (double) f8));
		rightarm.yRot += (bodytop.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(state.attackTime * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.xRot -= (float) ((double) leftarm.xRot - ((double) f7 * 1.2D + (double) f8));
		leftarm.yRot += (bodytop.yRot * 2.0F);
		leftarm.zRot -= (Mth.sin(state.attackTime * (float) Math.PI) * -0.4F);
	}

	private void animationFlee() {
		rightarm.xRot += 1.0472F;
		leftarm.xRot += 1.0472F;
	}


	@Override
	public ModelPart getHead() {
		return head;
	}

	private ModelPart getArm(HumanoidArm arm) {
		return arm == HumanoidArm.LEFT ? this.leftarm : this.rightarm;
	}

	@Override
	public void translateToHand(EntityRenderState state, HumanoidArm arm, PoseStack poseStack) {
		getArm(arm).translateAndRotate(poseStack);
	}
}