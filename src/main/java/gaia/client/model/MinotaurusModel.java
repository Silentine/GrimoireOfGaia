package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.client.state.MinotaurusRenderState;
import gaia.config.GaiaConfig;
import gaia.entity.Minotaurus;
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
import net.minecraft.world.item.BowItem;

public class MinotaurusModel extends EntityModel<MinotaurusRenderState> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart tail;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public MinotaurusModel(ModelPart root) {
		super(root);
		this.root = root.getChild("minotaurus");
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

		PartDefinition minotaurus = partdefinition.addOrReplaceChild("minotaurus", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = minotaurus.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F)
				.texOffs(64, 0).addBox(-3.5F, -2.0F, -2.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -13.5F, -0.5F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righthorn = head.addOrReplaceChild("righthorn", CubeListBuilder.create().texOffs(36, 18).addBox(-5.0F, -7.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 22).addBox(-4.0F, -8.0F, -3.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 26).addBox(-2.5F, -8.5F, -1.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefthorn = head.addOrReplaceChild("lefthorn", CubeListBuilder.create().texOffs(36, 18).addBox(3.0F, -7.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 22).addBox(2.0F, -8.0F, -3.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(36, 26).addBox(1.5F, -8.5F, -1.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, -2.0F, -3.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(3.0F, -2.0F, -3.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition ring = bodytop.addOrReplaceChild("ring", CubeListBuilder.create().texOffs(36, 36).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 36).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F)
				.texOffs(36, 40).addBox(-3.5F, -1.5F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 45).addBox(-1.505F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F)
				.texOffs(52, 48).addBox(-2.0F, 3.0F, -3.5F, 4.0F, 1.0F, 4.0F), PartPose.offset(-1.5F, 5.0F, 1.5F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F).mirror(false)
				.texOffs(36, 40).mirror().addBox(-0.5F, -1.5F, -2.0F, 4.0F, 4.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 21).mirror().addBox(-1.495F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F).mirror(false)
				.texOffs(36, 48).mirror().addBox(-2.0F, 3.0F, -3.5F, 4.0F, 1.0F, 4.0F).mirror(false), PartPose.offset(1.5F, 5.0F, 1.5F));

		PartDefinition tail = bodybottom.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(64, 8).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition rightleg = minotaurus.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(64, 18).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, -13.0F, -0.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(64, 28).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition rightfoot = rightleglower.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(64, 40).addBox(-2.005F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition leftleg = minotaurus.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(64, 18).mirror().addBox(-1.5F, -1.0F, -1.0F, 3.0F, 7.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(2.0F, -13.0F, -0.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftlegower = leftleg.addOrReplaceChild("leftlegower", CubeListBuilder.create().texOffs(64, 28).mirror().addBox(-2.0F, -2.0F, 0.0F, 4.0F, 8.0F, 4.0F).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition leftfoot = leftlegower.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(64, 40).mirror().addBox(-1.995F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(MinotaurusRenderState state) {
		super.setupAnim(state);

		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !state.isBaby;

		headeyes.visible = state.ageInTicks % 60 == 0 && state.walkAnimationSpeed <= 0.1F;

		// head
		head.yRot = state.yRot / 57.295776F;
		head.xRot = state.xRot / 57.295776F;

		// arms
		rightarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.8F * state.walkAnimationSpeed * 0.5F;
		leftarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 0.8F * state.walkAnimationSpeed * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;


		if (state.isAggressive && (state.getMainHandItemStack().getItem() instanceof BowItem)) {
			holdingBow(state);
		} else if (state.attackTime > 0.0F) {
			holdingMelee(state);
		}

		rightarm.zRot += (Mth.cos(state.ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		rightarm.xRot += Mth.sin(state.ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(state.ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		leftarm.xRot -= Mth.sin(state.ageInTicks * 0.067F) * 0.025F;

		// body
		tail.yRot = Mth.cos(((state.ageInTicks * 7)) * Mth.DEG_TO_RAD) * (15 * Mth.DEG_TO_RAD);

		// legs
		rightleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 0.8F * state.walkAnimationSpeed;
		leftleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.8F * state.walkAnimationSpeed;
		rightleg.xRot -= 0.1745329F;
		leftleg.xRot -= 0.1745329F;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
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

	private void holdingBow(ArmedEntityRenderState state) {
		float f = Mth.sin(state.attackTime * (float) Math.PI);
		float f1 = Mth.sin((1.0F - (1.0F - state.attackTime) * (1.0F - state.attackTime)) * (float) Math.PI);

		rightarm.zRot = -0.3F;
		leftarm.zRot = 0.3F;
		rightarm.yRot = -(0.1F - f * 0.6F);
		leftarm.yRot = 0.3F - f * 0.6F;
		rightarm.xRot = -((float) Math.PI / 2F);
		leftarm.xRot = -((float) Math.PI / 2F);
		rightarm.xRot -= f * 1.2F - f1 * 0.4F;
		leftarm.xRot -= f * 1.2F - f1 * 0.4F;
		rightarm.zRot += Mth.cos(state.ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.zRot -= Mth.cos(state.ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.xRot += Mth.sin(state.ageInTicks * 0.067F) * 0.05F;
		leftarm.xRot -= Mth.sin(state.ageInTicks * 0.067F) * 0.05F;
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

		rightarm.xRot = (float) ((double) rightarm.xRot - ((double) f7 * 1.2D + (double) f8));
		rightarm.xRot += (bodytop.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(state.attackTime * (float) Math.PI) * -0.4F);
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
		poseStack.translate(0, 0.5, 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}