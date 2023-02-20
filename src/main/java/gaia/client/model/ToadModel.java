package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Toad;
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

public class ToadModel extends EntityModel<Toad> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodybottom;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart necktie;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart leftarmlower;
	private final ModelPart rightarm;
	private final ModelPart rightarmlower;
	private final ModelPart leftleg;
	private final ModelPart leftleglower;
	private final ModelPart rightleg;
	private final ModelPart rightleglower;

	public ToadModel(ModelPart root) {
		this.root = root.getChild("toad");
		this.bodybottom = this.root.getChild("bodybottom");
		this.bodytop = this.bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.necktie = this.bodytop.getChild("necktie");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.leftarmlower = this.leftarm.getChild("leftarmlower");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.rightarmlower = this.rightarm.getChild("rightarmlower");
		this.leftleg = this.bodybottom.getChild("leftleg");
		this.leftleglower = this.leftleg.getChild("leftleglower");
		this.rightleg = this.bodybottom.getChild("rightleg");
		this.rightleglower = this.rightleg.getChild("rightleglower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition toad = partdefinition.addOrReplaceChild("toad", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = toad.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -6.5F, 3.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition tail_r1 = bodybottom.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(36, 25).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headrighteye = head.addOrReplaceChild("headrighteye", CubeListBuilder.create().texOffs(36, 14).addBox(-4.5F, -7.5F, -4.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headlefteye = head.addOrReplaceChild("headlefteye", CubeListBuilder.create().texOffs(36, 14).addBox(1.5F, -7.5F, -4.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition necktie = bodytop.addOrReplaceChild("necktie", CubeListBuilder.create().texOffs(36, 20).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F)
				.texOffs(36, 22).addBox(-1.0F, 2.0F, -0.5F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -2.5F, -1.0472F, 0.0F, 0.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, -1.0472F, -0.5236F, 1.5708F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-1.0F, 5.0F, 1.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, -1.0472F, 0.5236F, -1.5708F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(1.0F, 5.0F, 1.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition rightleg = bodybottom.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-2.5F, 0.0F, 0.5F, -2.7925F, 0.0F, -0.6981F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.505F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 6.0F, -1.5F, 1.4835F, 0.0F, 0.0F));

		PartDefinition leftleg = bodybottom.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(2.5F, 0.0F, 0.5F, -2.7925F, 0.0F, 0.6981F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.495F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 6.0F, -1.5F, 1.4835F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Toad toad, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(toad, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !toad.isBaby();
	}

	@Override
	public void setupAnim(Toad toad, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = toad.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		if (attackTime > 0.0F) {
			holdingMelee();
		}

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		rightarm.xRot = -1.0472F + Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount * 0.5F;
		leftarm.xRot = -1.0472F + Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

		// body
		for (int k = 1; k < 2; ++k) {
			necktie.zRot = Mth.cos(((float) k * 1.5F + ageInTicks) * 0.1F) / 16;
		}

//		// legs
		rightleg.xRot = -2.7925F + Mth.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
		leftleg.xRot = -2.7925F + Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.2F * limbSwingAmount;
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

		head.xRot -= (float) ((double) head.xRot - ((double) f7 * 1.2D + (double) f8));
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
		poseStack.translate(-0.0625, 0.5, 0);
		getArm(arm).translateAndRotate(poseStack);
	}
}