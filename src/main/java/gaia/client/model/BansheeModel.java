package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Banshee;
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

public class BansheeModel extends EntityModel<Banshee> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart hair1;
	private final ModelPart hair2;
	private final ModelPart hair3;
	private final ModelPart hair4;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftarmlower;
	private final ModelPart rightarmlower;
	private final ModelPart skirt1;
	private final ModelPart skirt2;
	private final ModelPart skirt3;
	private final ModelPart skirt4;

	public BansheeModel(ModelPart root) {
		this.root = root.getChild("banshee");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.hair1 = this.head.getChild("hair1");
		this.hair2 = this.hair1.getChild("hair2");
		this.hair3 = this.hair2.getChild("hair3");
		this.hair4 = this.hair3.getChild("hair4");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		this.skirt1 = bodybottom.getChild("skirt1");
		this.skirt2 = this.skirt1.getChild("skirt2");
		this.skirt3 = this.skirt2.getChild("skirt3");
		this.skirt4 = this.skirt3.getChild("skirt4");
		this.leftarmlower = this.leftarm.getChild("leftarmlower");
		this.rightarmlower = this.rightarm.getChild("rightarmlower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition banshee = partdefinition.addOrReplaceChild("banshee", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = banshee.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offset(0.0F, -13.5F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.1F, 1.0F, 2.0F, 0.0F), PartPose.offset(0.0F, -1.5F, 1.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-2.9F, -6.0F, -2.905F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, -0.1F));

		PartDefinition hair1 = head.addOrReplaceChild("hair1", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 2.0F), PartPose.offset(0.0F, -3.0F, 2.0F));

		PartDefinition hair2 = hair1.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(36, 23).addBox(-5.0F, -5.0F, -0.4F, 10.0F, 10.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition hair3 = hair2.addOrReplaceChild("hair3", CubeListBuilder.create().texOffs(36, 37).addBox(-6.0F, -6.0F, -1.0F, 12.0F, 12.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition hair4 = hair3.addOrReplaceChild("hair4", CubeListBuilder.create().texOffs(6, 41).addBox(-4.0F, -4.0F, -0.5F, 8.0F, 8.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).mirror().addBox(0.3F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(0.0F, -4.25F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F)
				.texOffs(72, 0).addBox(-2.5F, 1.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(-2.5F, -4.5F, -1.0F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.5F, 2.0F, 6.0F, 2.0F)
				.texOffs(72, 7).addBox(-1.505F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(-1.0F, 5.0F, 1.5F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).mirror(false)
				.texOffs(72, 0).mirror().addBox(-0.5F, 1.0F, -1.5F, 3.0F, 4.0F, 3.0F).mirror(false), PartPose.offset(2.5F, -4.5F, -1.0F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-0.995F, 0.0F, -2.5F, 2.0F, 6.0F, 2.0F).mirror(false)
				.texOffs(72, 7).mirror().addBox(-1.495F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.5F));

		PartDefinition skirt1 = bodybottom.addOrReplaceChild("skirt1", CubeListBuilder.create().texOffs(84, 0).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 2.0F, 6.0F), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition skirt2 = skirt1.addOrReplaceChild("skirt2", CubeListBuilder.create().texOffs(84, 8).addBox(-4.0F, 0.0F, -0.5F, 8.0F, 4.0F, 7.0F), PartPose.offset(0.0F, 2.0F, -3.0F));

		PartDefinition skirt3 = skirt2.addOrReplaceChild("skirt3", CubeListBuilder.create().texOffs(84, 19).addBox(-4.5F, 0.0F, -0.5F, 9.0F, 5.0F, 8.0F), PartPose.offset(0.0F, 4.0F, -0.5F));

		PartDefinition skirt4 = skirt3.addOrReplaceChild("skirt4", CubeListBuilder.create().texOffs(84, 32).addBox(-5.0F, 0.0F, -0.5F, 10.0F, 6.0F, 9.0F), PartPose.offset(0.0F, 5.0F, -0.5F));

		PartDefinition rightleg = banshee.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F), PartPose.offset(-2.0F, -13.0F, 0.0F));

		PartDefinition leftleg = banshee.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).mirror().addBox(-1.5F, -1.0F, -1.5F, 3.0F, 14.0F, 3.0F).mirror(false), PartPose.offset(2.0F, -13.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Banshee banshee, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(banshee, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !banshee.isBaby();
	}

	@Override
	public void setupAnim(Banshee banshee, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = banshee.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// anchor
		root.y = 24.0F - Mth.cos(ageInTicks * 0.18F) * 0.9F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;


		hair1.zRot = (15 * Mth.DEG_TO_RAD);
		hair2.zRot = (15 * Mth.DEG_TO_RAD);
		hair3.zRot = (15 * Mth.DEG_TO_RAD);
		hair4.zRot += (2 * Mth.DEG_TO_RAD) * 0.1F;

		// arms
		rightarm.zRot = 0.0F;
		rightarm.xRot = 0.0F;
		leftarm.zRot = 0.0F;
		leftarm.xRot = 0.0F;
		if (attackTime > 0.0F) {
			holdingMelee();
		}

		rightarm.zRot = Mth.cos((((float) banshee.tickCount * 7)) * Mth.DEG_TO_RAD) * (10 * Mth.DEG_TO_RAD);
		leftarm.zRot = Mth.cos((((float) banshee.tickCount * 7)) * Mth.DEG_TO_RAD) * (-10 * Mth.DEG_TO_RAD);
		rightarm.zRot += 0.2617994F;
		leftarm.zRot -= 0.2617994F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;

		rightarmlower.xRot = -(15 * Mth.DEG_TO_RAD);
		leftarmlower.xRot = -(15 * Mth.DEG_TO_RAD);

		// body
		skirt1.xRot = (5 * Mth.DEG_TO_RAD);
		skirt2.xRot = (10 * Mth.DEG_TO_RAD);
		skirt3.xRot = (15 * Mth.DEG_TO_RAD);
		skirt4.xRot = (20 * Mth.DEG_TO_RAD);

		skirt1.zRot = Mth.cos((((float) banshee.tickCount * 7)) * Mth.DEG_TO_RAD) * (1 * Mth.DEG_TO_RAD);
		skirt2.zRot = Mth.cos((((float) banshee.tickCount * 7)) * Mth.DEG_TO_RAD) * (2 * Mth.DEG_TO_RAD);
		skirt3.zRot = Mth.cos((((float) banshee.tickCount * 7)) * Mth.DEG_TO_RAD) * (3 * Mth.DEG_TO_RAD);
		skirt4.zRot = Mth.cos((((float) banshee.tickCount * 7)) * Mth.DEG_TO_RAD) * (4 * Mth.DEG_TO_RAD);
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
		// right arm
		rightarm.xRot -= (float) ((double) rightarm.xRot - ((double) f7 * 1.2D + (double) f8));
		rightarm.yRot += (bodytop.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
		// left arm
		leftarm.xRot -= (float) ((double) leftarm.xRot - ((double) f7 * 1.2D + (double) f8));
		leftarm.yRot += (bodytop.yRot * 2.0F);
		leftarm.zRot -= (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
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