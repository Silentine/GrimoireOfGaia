package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.config.GaiaConfig;
import gaia.entity.Cecaelia;
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

public class CecaeliaModel extends EntityModel<Cecaelia> implements HeadedModel, ArmedModel {
	private static final double CYCLES_PER_BLOCK = 0.1D;
	private final float[][] undulationCycle = new float[][]{
			{10F, -10F, -10F, 0F, 10F, 10F, 0F, -10F},
			{5F, 10F, -10F, -10F, 0F, 10F, 10F, 0F},
			{0F, 25F, 0F, -10F, -10F, 0F, 10F, 10F},
			{-10F, 10F, 10F, 0F, -10F, -10F, 0F, 10F},
			{-5F, -10F, 10F, 10F, 0F, -10F, -10F, 0F},
			{-10F, 10F, 10F, 0F, -10F, -10F, 0F, 10F},
			{0F, 25F, 0F, -10F, -10F, 0F, 10F, 10F},
			{5F, 10F, -10F, -10F, 0F, 10F, 10F, 0F},
	};

	private final ModelPart root;
	private final ModelPart bodytop;
	private final ModelPart head;
	private final ModelPart headeyes;
	private final ModelPart chest;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart[] tailsSW;
	private final ModelPart[] tailsSE;
	private final ModelPart[] tailsNW;
	private final ModelPart[] tailsNE;

	public CecaeliaModel(ModelPart root) {
		this.root = root.getChild("cecaelia");
		ModelPart bodybottom = this.root.getChild("bodybottom");
		this.bodytop = bodybottom.getChild("bodymiddle").getChild("bodytop");
		ModelPart neck = this.bodytop.getChild("neck");
		this.head = neck.getChild("head");
		this.headeyes = this.head.getChild("headeyes");
		this.chest = this.bodytop.getChild("chest");
		this.leftarm = this.bodytop.getChild("leftarm");
		this.rightarm = this.bodytop.getChild("rightarm");

		ModelPart tailbase = this.root.getChild("tailbase1");
		tailsSW = getTailParts(tailbase, "sw");
		tailsSE = getTailParts(tailbase, "se");
		tailsNW = getTailParts(tailbase, "nw");
		tailsNE = getTailParts(tailbase, "ne");
	}

	private ModelPart[] getTailParts(ModelPart root, String direction) {
		ModelPart[] tails = new ModelPart[4];
		tails[0] = root.getChild("tailbase" + direction);
		tails[1] = tails[0].getChild("tail1" + direction);
		tails[2] = tails[1].getChild("tail2" + direction);
		tails[3] = tails[2].getChild("tail3" + direction);
		return tails;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cecaelia = partdefinition.addOrReplaceChild("cecaelia", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodybottom = cecaelia.addOrReplaceChild("bodybottom", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bodymiddle = bodybottom.addOrReplaceChild("bodymiddle", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -2.5F, -2.05F, 4.0F, 3.0F, 2.0F)
				.texOffs(0, 25).addBox(-0.5F, -2.0F, -2.15F, 1.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 1.05F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bodytop = bodymiddle.addOrReplaceChild("bodytop", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -0.05F, -0.0873F, 0.0F, 0.0F));

		PartDefinition neck = bodytop.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F)
				.texOffs(36, 0).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F)
				.texOffs(36, 14).addBox(-4.5F, -5.5F, -2.5F, 3.0F, 3.0F, 3.0F)
				.texOffs(36, 14).mirror().addBox(1.5F, -5.5F, -2.5F, 3.0F, 3.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition headeyes = head.addOrReplaceChild("headeyes", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righttentacle = head.addOrReplaceChild("righttentacle", CubeListBuilder.create().texOffs(36, 20).addBox(-5.0F, -8.0F, 1.0F, 4.0F, 4.0F, 4.0F)
				.texOffs(36, 28).addBox(-6.0F, -5.0F, 3.0F, 3.0F, 3.0F, 3.0F)
				.texOffs(36, 34).addBox(-7.0F, -6.0F, 5.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lefttentacle = head.addOrReplaceChild("lefttentacle", CubeListBuilder.create().texOffs(36, 20).addBox(1.0F, -8.0F, 1.0F, 4.0F, 4.0F, 4.0F)
				.texOffs(36, 28).addBox(3.0F, -5.0F, 3.0F, 3.0F, 3.0F, 3.0F)
				.texOffs(36, 34).addBox(5.0F, -6.0F, 5.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righttentaclelower = head.addOrReplaceChild("righttentaclelower", CubeListBuilder.create().texOffs(36, 38).addBox(-5.0F, -1.0F, 2.0F, 3.0F, 6.0F, 3.0F)
				.texOffs(36, 47).addBox(-6.0F, 4.0F, 4.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftentaclelower = head.addOrReplaceChild("leftentaclelower", CubeListBuilder.create().texOffs(36, 38).addBox(2.0F, -1.0F, 2.0F, 3.0F, 6.0F, 3.0F)
				.texOffs(36, 47).addBox(4.0F, 4.0F, 4.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition chest = bodytop.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 36).addBox(-2.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F)
				.texOffs(0, 36).addBox(0.3F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -5.5F, -2.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition rightarm = bodytop.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 12).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition rightarmlower = rightarm.addOrReplaceChild("rightarmlower", CubeListBuilder.create().texOffs(16, 20).addBox(-1.005F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-1.0F, 5.0F, 1.0F));

		PartDefinition leftarm = bodytop.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 12).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offsetAndRotation(2.5F, -4.5F, -1.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition leftarmlower = leftarm.addOrReplaceChild("leftarmlower", CubeListBuilder.create().texOffs(16, 20).mirror().addBox(-0.995F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F).mirror(false), PartPose.offset(1.0F, 5.0F, 1.0F));

		PartDefinition tailbase1 = cecaelia.addOrReplaceChild("tailbase1", CubeListBuilder.create().texOffs(64, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F)
				.texOffs(64, 10).addBox(-4.5F, 2.0F, -4.5F, 9.0F, 6.0F, 9.0F), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition tailbasew_r1 = tailbase1.addOrReplaceChild("tailbasew_r1", CubeListBuilder.create().texOffs(100, 23).addBox(-1.0F, 0.0F, -4.5F, 1.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(4.5F, 2.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition tailbases_r1 = tailbase1.addOrReplaceChild("tailbases_r1", CubeListBuilder.create().texOffs(100, 5).addBox(-4.5F, 0.0F, -1.0F, 9.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 4.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tailbasee_r1 = tailbase1.addOrReplaceChild("tailbasee_r1", CubeListBuilder.create().texOffs(100, 10).addBox(0.0F, 0.0F, -4.5F, 1.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(-4.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition tailbasen_r1 = tailbase1.addOrReplaceChild("tailbasen_r1", CubeListBuilder.create().texOffs(100, 0).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -4.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tailbasesw = tailbase1.addOrReplaceChild("tailbasesw", CubeListBuilder.create().texOffs(64, 25).addBox(-1.0F, -3.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(2.5F, 8.0F, -2.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition tail1sw = tailbasesw.addOrReplaceChild("tail1sw", CubeListBuilder.create().texOffs(64, 36).addBox(-1.0F, 0.0F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offset(4.0F, -3.5F, 0.0F));

		PartDefinition tail2sw = tail1sw.addOrReplaceChild("tail2sw", CubeListBuilder.create().texOffs(64, 46).addBox(-1.0F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition tail3sw = tail2sw.addOrReplaceChild("tail3sw", CubeListBuilder.create().texOffs(64, 54).addBox(-1.0F, 0.0F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition tail4sw = tail3sw.addOrReplaceChild("tail4sw", CubeListBuilder.create().texOffs(64, 60).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition tailbasese = tailbase1.addOrReplaceChild("tailbasese", CubeListBuilder.create().texOffs(64, 25).mirror().addBox(-4.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 7.0F, -2.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition tail1se = tailbasese.addOrReplaceChild("tail1se", CubeListBuilder.create().texOffs(64, 36).addBox(-6.0F, 0.0F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offset(-3.0F, -2.5F, 0.0F));

		PartDefinition tail2se = tail1se.addOrReplaceChild("tail2se", CubeListBuilder.create().texOffs(64, 46).addBox(-4.0F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F), PartPose.offset(-6.0F, 0.0F, 0.0F));

		PartDefinition tail3se = tail2se.addOrReplaceChild("tail3se", CubeListBuilder.create().texOffs(64, 54).addBox(-3.0F, 0.0F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition tail4se = tail3se.addOrReplaceChild("tail4se", CubeListBuilder.create().texOffs(64, 60).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition tailbasenw = tailbase1.addOrReplaceChild("tailbasenw", CubeListBuilder.create().texOffs(64, 25).addBox(-1.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(2.5F, 7.0F, 2.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition tail1nw = tailbasenw.addOrReplaceChild("tail1nw", CubeListBuilder.create().texOffs(64, 36).addBox(-1.0F, 0.0F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offset(4.0F, -2.5F, 0.0F));

		PartDefinition tail2nw = tail1nw.addOrReplaceChild("tail2nw", CubeListBuilder.create().texOffs(64, 46).addBox(-1.0F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition tail3nw = tail2nw.addOrReplaceChild("tail3nw", CubeListBuilder.create().texOffs(64, 54).addBox(-1.0F, 0.0F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition tail4nw = tail3nw.addOrReplaceChild("tail4nw", CubeListBuilder.create().texOffs(64, 60).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition tailbasene = tailbase1.addOrReplaceChild("tailbasene", CubeListBuilder.create().texOffs(64, 25).mirror().addBox(-4.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 7.0F, 2.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition tail1ne = tailbasene.addOrReplaceChild("tail1ne", CubeListBuilder.create().texOffs(64, 36).addBox(-5.0F, 0.0F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offset(-4.0F, -2.5F, 0.0F));

		PartDefinition tail2ne = tail1ne.addOrReplaceChild("tail2ne", CubeListBuilder.create().texOffs(64, 46).addBox(-4.0F, 0.0F, -2.0F, 5.0F, 4.0F, 4.0F), PartPose.offset(-5.0F, 0.0F, 0.0F));

		PartDefinition tail3ne = tail2ne.addOrReplaceChild("tail3ne", CubeListBuilder.create().texOffs(64, 54).addBox(-3.0F, 0.0F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition tail4ne = tail3ne.addOrReplaceChild("tail4ne", CubeListBuilder.create().texOffs(64, 60).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(-3.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Cecaelia cecaelia, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(cecaelia, limbSwing, limbSwingAmount, partialTick);
		this.chest.visible = !GaiaConfig.CLIENT.genderNeutral.get() && !cecaelia.isBaby();
	}

	@Override
	public void setupAnim(Cecaelia cecaelia, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		headeyes.visible = cecaelia.tickCount % 60 == 0 && limbSwingAmount <= 0.1F;

		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		if (cecaelia.isThrowing()) {
			animationThrow();
		} else {
			rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.zRot = 0.0F;
			leftarm.zRot = 0.0F;

			if (attackTime > -9990.0F) {
				holdingMelee();
			}

			float armDefaultAngleZ = 0.1745329F;

			rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
			rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
			leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		}

		// legs
		float usedValue = cecaelia.isInWater() ? ageInTicks : limbSwing;
		int cycleIndex = (int) ((usedValue * CYCLES_PER_BLOCK) % undulationCycle.length);
		float radAngle = 0.785398F;

		tailsSW[0].yRot = radAngle;
		tailsSW[1].yRot = 0.15F * Mth.cos(usedValue * (Mth.DEG_TO_RAD * undulationCycle[cycleIndex][1]));
		tailsSW[2].yRot = 0.15F * Mth.cos(usedValue * (Mth.DEG_TO_RAD * undulationCycle[cycleIndex][2]));
		tailsSW[3].yRot = 0.15F * Mth.cos(usedValue * (Mth.DEG_TO_RAD * undulationCycle[cycleIndex][3]));
		tailsSW[1].zRot = -radAngle;
		tailsSW[2].zRot = -radAngle;
		tailsSW[3].zRot = -radAngle;

		tailsSE[0].yRot = -radAngle;
		tailsSE[1].yRot = tailsSW[1].yRot;
		tailsSE[2].yRot = tailsSW[2].yRot;
		tailsSE[3].yRot = tailsSW[3].yRot;
		tailsSE[1].zRot = radAngle;
		tailsSE[2].zRot = radAngle;
		tailsSE[3].zRot = radAngle;

		tailsNW[0].yRot = -radAngle;
		tailsNW[1].yRot = tailsSW[1].yRot;
		tailsNW[2].yRot = tailsSW[2].yRot;
		tailsNW[3].yRot = tailsSW[3].yRot;
		tailsNW[1].zRot = -radAngle;
		tailsNW[2].zRot = -radAngle;
		tailsNW[3].zRot = -radAngle;

		tailsNE[0].yRot = radAngle;
		tailsNE[1].yRot = tailsSW[1].yRot;
		tailsNE[2].yRot = tailsSW[2].yRot;
		tailsNE[3].yRot = tailsSW[3].yRot;
		tailsNE[1].zRot = radAngle;
		tailsNE[2].zRot = radAngle;
		tailsNE[3].zRot = radAngle;
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
		leftarm.xRot = -1.0472F;
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
		poseStack.translate(-0.125D, 0.5D, 0);
		if (arm == HumanoidArm.LEFT) {
			poseStack.translate(0.125F, 0, 0.0625D);
		}
		getArm(arm).translateAndRotate(poseStack);
	}
}