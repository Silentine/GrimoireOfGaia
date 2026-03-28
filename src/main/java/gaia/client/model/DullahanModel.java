package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.client.state.DullahanRenderState;
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

public class DullahanModel extends EntityModel<DullahanRenderState> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public DullahanModel(ModelPart root) {
		super(root);
		this.root = root.getChild("dullahan");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		ModelPart rightarmlower = this.rightarm.getChild("rightarmlower");
		this.head = rightarmlower.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition dullahan = partdefinition.addOrReplaceChild("dullahan", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = dullahan.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -1.6F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F)
				.texOffs(0, 12).addBox(-1.0F, -7.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(52, 14).addBox(-3.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-1.0F, 5.0F, 1.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition rightgauntlet_r1 = rightarmlower.addOrReplaceChild("rightgauntlet_r1", CubeListBuilder.create().texOffs(46, 23).addBox(-1.5F, -16.0F, 3.0F, 3.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(3.5F, 16.5F, -1.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition head = rightarmlower.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(-0.5F, 5.5F, -2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -3.0F, -3.1F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition headpiece = head.addOrReplaceChild("headpiece", CubeListBuilder.create().texOffs(36, 32).addBox(-3.5F, -1.0F, -2.0F, 7.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -3.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(36, 14).addBox(-1.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(36, 23).mirror().addBox(-0.5F, 0.5F, -2.5F, 2.0F, 6.0F, 3.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.25F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition waist1 = bodybottom.addOrReplaceChild("waist1", CubeListBuilder.create().texOffs(68, 0).addBox(-3.5F, -0.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -1.5F, 0.0F));

		PartDefinition waist2 = waist1.addOrReplaceChild("waist2", CubeListBuilder.create().texOffs(68, 10).addBox(-4.0F, -2.5F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 2.5F, 0.5F));

		PartDefinition rightleg = dullahan.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(-2.0F, -12.5F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 20).addBox(-1.505F, 1.0F, -0.1F, 3.0F, 7.0F, 3.0F)
				.texOffs(68, 22).addBox(-2.0F, 0.0F, -0.6F, 4.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 4.5F, -1.4F));

		PartDefinition leftleg = dullahan.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(2.0F, -13.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 20).addBox(-1.495F, 1.0F, 0.0F, 3.0F, 7.0F, 3.0F)
				.texOffs(68, 22).addBox(-2.0F, 0.0F, -0.5F, 4.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 5.0F, -1.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(DullahanRenderState state) {
		super.setupAnim(state);

		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !state.isBaby;

		headeyes.visible = state.ageInTicks % 60 == 0 && state.walkAnimationSpeed <= 0.1F;

		// head
		head.xRot = state.xRot * ((float) Math.PI / 180F) + 90F;

		// arms
		rightarm.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 2.0F * state.walkAnimationSpeed * 0.5F;
		leftarm.xRot = 0.0F;
		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		if (state.attackTime > 0.0F) {
			holdingMelee(state);
		}

		rightarm.zRot += (Mth.cos(state.ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.xRot += Mth.sin(state.ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(state.ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.xRot -= Mth.sin(state.ageInTicks * 0.067F) * 0.025F;

		// legs
		rightleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 0.5F * state.walkAnimationSpeed;
		leftleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.5F * state.walkAnimationSpeed;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
		rightleg.zRot = 0.0F;
		leftleg.zRot = 0.0F;

		if (state.isRiding) {
//			rightarm.xRot += -((float) Math.PI / 5F);
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
		if (arm == HumanoidArm.LEFT) {
			poseStack.translate(0.0625F, 0.5F, 0.0F);
		} else {
			poseStack.translate(-0.0625F, 0.25F, 0.0F);
		}
		getArm(arm).translateAndRotate(poseStack);
	}
}