package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.NineTails;
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

public class NineTailsModel extends EntityModel<NineTails> implements HeadedModel, ArmedModel {
	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart toprighttail1;
	private final ModelPart toprighttail2;
	private final ModelPart toptail1;
	private final ModelPart toptail2;
	private final ModelPart toplefttail1;
	private final ModelPart toplefttail2;
	private final ModelPart midrighttail1;
	private final ModelPart midrighttail2;
	private final ModelPart midtail1;
	private final ModelPart midtail2;
	private final ModelPart midlefttail1;
	private final ModelPart midlefttail2;
	private final ModelPart bottomrighttail1;
	private final ModelPart bottomrighttail2;
	private final ModelPart bottomtail1;
	private final ModelPart bottomtail2;
	private final ModelPart bottomlefttail1;
	private final ModelPart bottomlefttail2;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public NineTailsModel(ModelPart root) {
		this.root = root.getChild("nine_tails");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		this.head = this.bodytop.getChild("neck").getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");
		ModelPart tail = bodybottom.getChild("tail");
		this.toprighttail1 = tail.getChild("toprighttail1");
		this.toprighttail2 = toprighttail1.getChild("toprighttail2");
		this.toptail1 = tail.getChild("toptail1");
		this.toptail2 = toptail1.getChild("toptail2");
		this.toplefttail1 = tail.getChild("toplefttail1");
		this.toplefttail2 = toplefttail1.getChild("toplefttail2");
		this.midrighttail1 = tail.getChild("midrighttail1");
		this.midrighttail2 = midrighttail1.getChild("midrighttail2");
		this.midtail1 = tail.getChild("midtail1");
		this.midtail2 = midtail1.getChild("midtail2");
		this.midlefttail1 = tail.getChild("midlefttail1");
		this.midlefttail2 = midlefttail1.getChild("midlefttail2");
		this.bottomrighttail1 = tail.getChild("bottomrighttail1");
		this.bottomrighttail2 = bottomrighttail1.getChild("bottomrighttail2");
		this.bottomtail1 = tail.getChild("bottomtail1");
		this.bottomtail2 = bottomtail1.getChild("bottomtail2");
		this.bottomlefttail1 = tail.getChild("bottomlefttail1");
		this.bottomlefttail2 = bottomlefttail1.getChild("bottomlefttail2");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition nine_tails = partdefinition.addOrReplaceChild("nine_tails", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = nine_tails.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -1.6F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 0).addBox(-1.5F, -3.0F, -3.6F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.1F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightear = head.addOrReplaceChild("rightear", CubeListBuilder.create().texOffs(36, 37).mirror().addBox(-3.0F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, -6.5F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition leftear = head.addOrReplaceChild("leftear", CubeListBuilder.create().texOffs(36, 37).addBox(0.0F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -6.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition hair1 = neck.addOrReplaceChild("hair1", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -6.0F, 1.0F, 8.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hair2 = hair1.addOrReplaceChild("hair2", CubeListBuilder.create().texOffs(36, 25).addBox(-4.5F, -0.5F, -1.5F, 9.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 3.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.2F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 36).addBox(0.2F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, -2.6F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 3).addBox(-3.0F, 0.5F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(64, 9).addBox(-2.5F, 2.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.1745F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 15).addBox(-1.505F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 5.0F, 1.5F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 3).mirror().addBox(-1.0F, 0.5F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 9).mirror().addBox(-0.5F, 2.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, -0.1745F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-0.995F, 0.0F, -2.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(64, 15).mirror().addBox(-1.495F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 5.0F, 1.5F));

		PartDefinition tail = bodybottom.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, 1.6F));

		PartDefinition toprighttail1 = tail.addOrReplaceChild("toprighttail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, 0.5236F, 0.0F, 0.5236F));

		PartDefinition toprighttail2 = toprighttail1.addOrReplaceChild("toprighttail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition toptail1 = tail.addOrReplaceChild("toptail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition toptail2 = toptail1.addOrReplaceChild("toptail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition toplefttail1 = tail.addOrReplaceChild("toplefttail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, 0.5236F, 0.0F, -0.5236F));

		PartDefinition toplefttail2 = toplefttail1.addOrReplaceChild("toplefttail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition midrighttail1 = tail.addOrReplaceChild("midrighttail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.7854F, -0.2618F));

		PartDefinition midrighttail2 = midrighttail1.addOrReplaceChild("midrighttail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition midtail1 = tail.addOrReplaceChild("midtail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition midtail2 = midtail1.addOrReplaceChild("midtail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition midlefttail1 = tail.addOrReplaceChild("midlefttail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.2618F));

		PartDefinition midlefttail2 = midlefttail1.addOrReplaceChild("midlefttail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition bottomrighttail1 = tail.addOrReplaceChild("bottomrighttail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 0.0F, -0.5236F, 1.0472F, 0.0F));

		PartDefinition bottomrighttail2 = bottomrighttail1.addOrReplaceChild("bottomrighttail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition bottomtail1 = tail.addOrReplaceChild("bottomtail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition bottomtail2 = bottomtail1.addOrReplaceChild("bottomtail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition bottomlefttail1 = tail.addOrReplaceChild("bottomlefttail1", CubeListBuilder.create().texOffs(64, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 0.0F, -0.5236F, -1.0472F, 0.0F));

		PartDefinition bottomlefttail2 = bottomlefttail1.addOrReplaceChild("bottomlefttail2", CubeListBuilder.create().texOffs(64, 32).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition rightleg = nine_tails.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(86, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -13.0F, 0.0F, 0.0F, -0.0436F, -0.0436F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.505F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(86, 8).addBox(-1.5F, 5.0F, -0.5F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -1.5F));

		PartDefinition leftleg = nine_tails.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(24, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(86, 0).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, 0.0F, 0.0436F, 0.0436F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(24, 22).addBox(-1.495F, 0.0F, 0.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(86, 8).addBox(-1.5F, 5.0F, -0.5F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -1.5F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(NineTails nineTails, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(nineTails, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get();
	}

	@Override
	public void setupAnim(NineTails nineTails, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = nineTails.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		if (nineTails.isThrowing()) {
			animationThrow();
		} else {
			rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > -9990.0F) {
				holdingMelee();
			}

			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
			rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
			leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;
		}

		// body
		float chestDefaultRotateAngleX = 0.7853982F;
		chest.xRot = (Mth.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount) + chestDefaultRotateAngleX;

		float topAngleX = 30;
		float topAngleY = 20;
		toprighttail1.xRot = (topAngleX * Mth.DEG_TO_RAD);
		toprighttail2.xRot = (topAngleX * Mth.DEG_TO_RAD);
		toprighttail1.yRot = Mth.cos(((float) nineTails.tickCount * 7) * Mth.DEG_TO_RAD) * (1 * Mth.DEG_TO_RAD);
		toprighttail2.yRot = Mth.cos(((float) nineTails.tickCount * 7) * Mth.DEG_TO_RAD) * (2 * Mth.DEG_TO_RAD);
		toptail1.xRot = (topAngleX + 15 * Mth.DEG_TO_RAD);
		toptail2.xRot = (topAngleX * Mth.DEG_TO_RAD);
		toptail1.yRot = toprighttail1.yRot;
		toptail2.yRot = toprighttail2.yRot;
		toplefttail1.xRot = (topAngleX * Mth.DEG_TO_RAD);
		toplefttail2.xRot = (topAngleX * Mth.DEG_TO_RAD);
		toplefttail1.yRot = toprighttail1.yRot;
		toplefttail2.yRot = toprighttail2.yRot;

		float midAngleX = 15;
		float midAngleY = 40;
		midrighttail1.xRot = (midAngleX * Mth.DEG_TO_RAD);
		midrighttail2.xRot = (midAngleX * Mth.DEG_TO_RAD);
		midrighttail1.yRot = toprighttail1.yRot + (midAngleY * Mth.DEG_TO_RAD);
		midrighttail2.yRot = toprighttail2.yRot;
		midtail1.xRot = ((midAngleX + 10) * Mth.DEG_TO_RAD);
		midtail2.xRot = (midAngleX * Mth.DEG_TO_RAD);
		midtail1.yRot = toprighttail1.yRot;
		midtail2.yRot = toprighttail2.yRot;
		midlefttail1.xRot = (midAngleX * Mth.DEG_TO_RAD);
		midlefttail2.xRot = (midAngleX * Mth.DEG_TO_RAD);
		midlefttail1.yRot = toprighttail1.yRot - (midAngleY * Mth.DEG_TO_RAD);
		midlefttail2.yRot = toprighttail2.yRot;

		float bottomAngleX = 5;
		float bottomAngleY = 60;
		bottomrighttail1.xRot = (bottomAngleX * Mth.DEG_TO_RAD);
		bottomrighttail2.xRot = (bottomAngleX * Mth.DEG_TO_RAD);
		bottomrighttail1.yRot = toprighttail1.yRot + (bottomAngleY * Mth.DEG_TO_RAD);
		bottomrighttail2.yRot = toprighttail2.yRot;
		bottomtail1.xRot = ((bottomAngleX + 5) * Mth.DEG_TO_RAD);
		bottomtail2.xRot = (bottomAngleX * Mth.DEG_TO_RAD);
		bottomtail1.yRot = toprighttail1.yRot;
		bottomtail2.yRot = toprighttail2.yRot;
		bottomlefttail1.xRot = (bottomAngleX * Mth.DEG_TO_RAD);
		bottomlefttail2.xRot = (bottomAngleX * Mth.DEG_TO_RAD);
		bottomlefttail1.yRot = toprighttail1.yRot - (bottomAngleY * Mth.DEG_TO_RAD);
		bottomlefttail2.yRot = toprighttail2.yRot;

		toprighttail1.yRot = -(topAngleY * Mth.DEG_TO_RAD);
		toplefttail1.yRot = (topAngleY * Mth.DEG_TO_RAD);

		// legs
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.1F * limbSwingAmount;
		rightleg.yRot = -0.0872665F;
		leftleg.yRot = 0.0872665F;
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

	private void animationThrow() {
		rightarm.xRot = -1.0472F;
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