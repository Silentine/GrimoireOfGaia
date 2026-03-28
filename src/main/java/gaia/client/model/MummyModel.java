package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.client.state.MummyRenderState;
import gaia.config.GaiaConfig;
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
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwingAnimationType;

public class MummyModel extends EntityModel<MummyRenderState> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public MummyModel(ModelPart root) {
		super(root);
		this.root = root.getChild("mummy");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition mummy = partdefinition.addOrReplaceChild("mummy", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = mummy.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F)
				.texOffs(68, 0).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F)
				.texOffs(104, 0).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F)
				.texOffs(36, 14).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F)
				.texOffs(92, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition rightarmbandage = rightarm.addOrReplaceChild("rightarmbandage", CubeListBuilder.create().texOffs(36, 30).addBox(-2.0F, -1.0F, 1.0F, 2.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F).mirror(false)
				.texOffs(92, 0).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition leftarmbandage = leftarm.addOrReplaceChild("leftarmbandage", CubeListBuilder.create().texOffs(36, 30).addBox(0.0F, -1.0F, 1.0F, 2.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightleg = mummy.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F)
				.texOffs(92, 13).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.0349F));

		PartDefinition leftleg = mummy.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F).mirror(false)
				.texOffs(92, 13).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, 0.0F, 0.0F, -0.0349F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(MummyRenderState state) {
		super.setupAnim(state);

		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !state.isBaby;

		headeyes.visible = state.ageInTicks % 60 == 0 && state.walkAnimationSpeed <= 0.1F;

		// head
		head.yRot = state.yRot / 57.295776F;
		head.xRot = state.xRot / 57.295776F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (state.attackTime > 0.0F) {
			holdingMelee(state);
		}

		if (!state.isRiding) {
			animateZombieArms(this.leftarm, this.rightarm, state.isAggressive, state);
		} else {
			rightarm.zRot = (Mth.cos(state.ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
			rightarm.xRot = (Mth.sin(state.ageInTicks * 0.067F) * 0.025F);
			leftarm.zRot = (Mth.cos(state.ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
			leftarm.xRot = (Mth.sin(state.ageInTicks * 0.067F) * 0.025F);
		}

		// legs
		rightleg.xRot = (Mth.cos(state.walkAnimationPos * 0.6662F) * 0.8F * state.walkAnimationSpeed) * 0.5F;
		leftleg.xRot = (Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.8F * state.walkAnimationSpeed) * 0.5F;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
		rightleg.zRot = -0.0349066F;
		leftleg.zRot = 0.0349066F;

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

	public static void animateZombieArms(ModelPart leftArm, ModelPart rightArm, boolean aggressive, MummyRenderState state) {
		if (!state.isBaby || state.getMainHandItemStack() == ItemStack.EMPTY) {
			boolean animateAttack = state.swingAnimationType != SwingAnimationType.STAB;
			if (animateAttack) {
				float attackTime = state.attackTime;
				float armDrop = (float) -Math.PI / (aggressive ? 1.5F : 2.25F);
				float attackYRotModifier = Mth.sin(attackTime * (float) Math.PI);
				float attackXRotModifier = Mth.sin((1.0F - (1.0F - attackTime) * (1.0F - attackTime)) * (float) Math.PI);
				rightArm.zRot = 0.0F;
				rightArm.yRot = -(0.1F - attackYRotModifier * 0.6F);
				rightArm.xRot = armDrop;
				rightArm.xRot += attackYRotModifier * 1.2F - attackXRotModifier * 0.4F;
				leftArm.zRot = 0.0F;
				leftArm.yRot = 0.1F - attackYRotModifier * 0.6F;
				leftArm.xRot = armDrop;
				leftArm.xRot += attackYRotModifier * 1.2F - attackXRotModifier * 0.4F;
			}

			bobArms(rightArm, leftArm, state.ageInTicks);
		}
	}

	public static void bobArms(ModelPart rightArm, ModelPart leftArm, float ageInTicks) {
		bobModelPart(rightArm, ageInTicks, 1.0F);
		bobModelPart(leftArm, ageInTicks, -1.0F);
	}

	public static void bobModelPart(ModelPart modelPart, float ageInTicks, float scale) {
		modelPart.zRot = modelPart.zRot + scale * (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F);
		modelPart.xRot = modelPart.xRot + scale * (Mth.sin(ageInTicks * 0.067F) * 0.05F);
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


	@Override
	public ModelPart getHead() {
		return head;
	}

	private ModelPart getArm(HumanoidArm arm) {
		return arm == HumanoidArm.LEFT ? this.leftarm : this.rightarm;
	}

	@Override
	public void translateToHand(EntityRenderState state, HumanoidArm arm, PoseStack poseStack) {
		poseStack.translate(-0.0625, 0.5, 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}