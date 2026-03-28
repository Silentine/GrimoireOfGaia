package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.client.state.GoblinRenderState;
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

public class GoblinModel extends EntityModel<GoblinRenderState> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public GoblinModel(ModelPart root) {
		super(root);
		this.root = root.getChild("goblin");
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

		PartDefinition goblin = partdefinition.addOrReplaceChild("goblin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = goblin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F)
				.texOffs(64, 30).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F)
				.texOffs(64, 0).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headnose = head.addOrReplaceChild("headnose", CubeListBuilder.create().texOffs(64, 24).addBox(-1.0F, -3.0F, -7.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(64, 10).addBox(-5.5F, -7.0F, 0.0F, 0.0F, 6.0F, 8.0F)
				.texOffs(80, 10).addBox(-5.4F, -7.0F, 0.0F, 0.0F, 6.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(64, 10).addBox(5.5F, -7.0F, 0.0F, 0.0F, 6.0F, 8.0F)
				.texOffs(80, 10).addBox(5.4F, -7.0F, 0.0F, 0.0F, 6.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F)
				.texOffs(100, 0).addBox(-3.5F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F)
				.texOffs(100, 8).addBox(-3.5F, 3.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(-4.0F, 2.0F, 0.0F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(24, 16).mirror().addBox(0.0F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F).mirror(false)
				.texOffs(100, 0).mirror().addBox(-0.5F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F).mirror(false)
				.texOffs(100, 8).mirror().addBox(-0.5F, 3.0F, -2.0F, 4.0F, 4.0F, 4.0F).mirror(false), PartPose.offset(4.0F, 2.0F, 0.0F));

		PartDefinition rightleg = goblin.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(36, 16).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F)
				.texOffs(100, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F)
				.texOffs(100, 24).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(-2.0F, -8.0F, 0.0F));

		PartDefinition leftleg = goblin.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(36, 16).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F).mirror(false)
				.texOffs(100, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F).mirror(false)
				.texOffs(100, 24).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(2.0F, -8.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(GoblinRenderState state) {
		super.setupAnim(state);
		// head
		head.yRot = state.yRot / 57.295776F;
		head.xRot = state.xRot / 57.295776F;

		// arms
		rightarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.8F * state.walkAnimationSpeed * 0.5F;
		leftarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 0.8F * state.walkAnimationSpeed * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (state.isAggresive && (state.getMainHandItemStack().getItem() instanceof BowItem)) {
			holdingBow(state);
		} else if (state.attackTime > 0.0F) {
			holdingMelee(state);
		}

		rightarm.zRot += (Mth.cos(state.ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
		rightarm.xRot += Mth.sin(state.ageInTicks * 0.067F) * 0.05F;
		leftarm.zRot -= (Mth.cos(state.ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
		leftarm.xRot -= Mth.sin(state.ageInTicks * 0.067F) * 0.05F;

		// legs
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
		rightarm.xRot += (body.yRot * 2.0F);
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
		poseStack.translate(0, 0.3125D, 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}