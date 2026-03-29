package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.client.state.OrcRenderState;
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

public class OrcModel extends EntityModel<OrcRenderState> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public OrcModel(ModelPart root) {
		super(root);
		this.root = root.getChild("orc");
		this.body = this.root.getChild("body");
		this.head = body.getChild("head");
		this.leftarm = this.body.getChild("leftarm");
		this.rightarm = this.body.getChild("rightarm");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition orc = partdefinition.addOrReplaceChild("orc", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = orc.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 14.0F, 4.0F)
				.texOffs(0, 34).addBox(-5.0F, 0.0F, -2.0F, 10.0F, 14.0F, 4.0F, new CubeDeformation(0.5F))
				.texOffs(64, 39).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, -26.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F)
				.texOffs(64, 0).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftear_r1 = head.addOrReplaceChild("leftear_r1", CubeListBuilder.create().texOffs(64, -5).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(4.0F, -3.0F, -3.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition rightear_r1 = head.addOrReplaceChild("rightear_r1", CubeListBuilder.create().texOffs(64, -5).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(-4.0F, -3.0F, -3.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition headjaw = head.addOrReplaceChild("headjaw", CubeListBuilder.create().texOffs(64, 18).addBox(-4.5F, -0.5F, -4.0F, 9.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 0.0F, -0.5F));

		PartDefinition righthorn = head.addOrReplaceChild("righthorn", CubeListBuilder.create().texOffs(64, 25).addBox(-5.5F, -8.5F, -2.5F, 2.0F, 2.0F, 2.0F)
				.texOffs(64, 29).addBox(-6.5F, -10.5F, -1.5F, 3.0F, 3.0F, 3.0F)
				.texOffs(64, 35).addBox(-4.5F, -11.5F, -2.5F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefthorn = head.addOrReplaceChild("lefthorn", CubeListBuilder.create().texOffs(64, 25).addBox(3.5F, -8.5F, -2.5F, 2.0F, 2.0F, 2.0F)
				.texOffs(64, 29).addBox(3.5F, -10.5F, -1.5F, 3.0F, 3.0F, 3.0F)
				.texOffs(64, 35).addBox(2.5F, -11.5F, -2.5F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(28, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F)
				.texOffs(100, 26).addBox(-4.5F, -3.5F, -1.5F, 3.0F, 3.0F, 3.0F)
				.texOffs(100, 10).addBox(-3.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F)
				.texOffs(100, 32).addBox(-3.5F, 7.5F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(-6.0F, 2.0F, 0.0F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(28, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F).mirror(false)
				.texOffs(100, 0).mirror().addBox(-1.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F).mirror(false)
				.texOffs(100, 20).mirror().addBox(1.5F, -3.5F, -1.5F, 3.0F, 3.0F, 3.0F).mirror(false)
				.texOffs(100, 32).mirror().addBox(-1.5F, 7.5F, -2.5F, 5.0F, 5.0F, 5.0F).mirror(false), PartPose.offset(6.0F, 2.0F, 0.0F));

		PartDefinition rightleg = orc.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(44, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F)
				.texOffs(100, 42).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F)
				.texOffs(100, 52).addBox(-2.5F, 7.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition leftleg = orc.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(44, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).mirror(false)
				.texOffs(100, 42).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F).mirror(false)
				.texOffs(100, 52).mirror().addBox(-2.5F, 7.0F, -2.5F, 5.0F, 5.0F, 5.0F).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(OrcRenderState state) {
		super.setupAnim(state);

		// head
		head.yRot = state.yRot / 57.295776F;
		head.xRot = state.xRot / 57.295776F;

		// arms
		int animationState = state.animationState;
		if (animationState == 0) {
			rightarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.8F * state.walkAnimationSpeed * 0.5F;
			leftarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 0.8F * state.walkAnimationSpeed * 0.5F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (state.attackTime > 0.0F) {
				holdingMelee(state);
			}

			rightarm.zRot += (Mth.cos(state.ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
			rightarm.xRot += Mth.sin(state.ageInTicks * 0.067F) * 0.05F;
			leftarm.zRot -= (Mth.cos(state.ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
			leftarm.xRot -= Mth.sin(state.ageInTicks * 0.067F) * 0.05F;
		} else if (animationState == 1) {
			animationThrow();
		} else if (animationState == 2) {
			animationBuff();
		}

		// legs (walk_normal)
		rightleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 1.4F * state.walkAnimationSpeed * 0.5F;
		leftleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 1.4F * state.walkAnimationSpeed * 0.5F;
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
		rightarm.xRot += (body.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(state.attackTime * (float) Math.PI) * -0.4F);
	}

	private void animationThrow() {
		rightarm.xRot = -1.0472F;
	}

	private void animationBuff() {
		rightarm.xRot = 0.0F;
		leftarm.xRot = 0.0F;
		rightarm.zRot = 0.785398F;
		leftarm.zRot = -0.785398F;
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