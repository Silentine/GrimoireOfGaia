package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.entity.Dwarf;
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
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class DwarfModel extends EntityModel<Dwarf> implements HeadedModel, ArmedModel {
	private final ModelPart head;
	private final ModelPart headLight;
	private final ModelPart body;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart rightleg;
	private final ModelPart leftleg;

	public DwarfModel(ModelPart root) {
		this.head = root.getChild("head");
		this.headLight = this.head.getChild("headlight");
		this.body = root.getChild("body");
		this.rightarm = root.getChild("rightarm");
		this.leftarm = root.getChild("leftarm");
		this.rightleg = root.getChild("rightleg");
		this.leftleg = root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition headlight = head.addOrReplaceChild("headlight", CubeListBuilder.create().texOffs(64, 44).addBox(-1.5F, -9.0F, -5.0F, 3.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headaccessory = head.addOrReplaceChild("headaccessory", CubeListBuilder.create().texOffs(64, 0).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headbeard = head.addOrReplaceChild("headbeard", CubeListBuilder.create().texOffs(64, 18).addBox(-4.5F, -2.0F, -4.5F, 9.0F, 9.0F, 9.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(64, 36).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 10.0F, 4.0F), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition rightarm = partdefinition.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(-5.0F, 6.0F, 0.0F));

		PartDefinition rightarmpauldron = rightarm.addOrReplaceChild("rightarmpauldron", CubeListBuilder.create().texOffs(100, 0).addBox(-3.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightarmgauntlet = rightarm.addOrReplaceChild("rightarmgauntlet", CubeListBuilder.create().texOffs(100, 10).addBox(-3.5F, 3.5F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftarm = partdefinition.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(24, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F).mirror(false), PartPose.offset(5.0F, 6.0F, 0.0F));

		PartDefinition leftarmpauldron = leftarm.addOrReplaceChild("leftarmpauldron", CubeListBuilder.create().texOffs(100, 0).mirror().addBox(-1.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftarmgauntlet = leftarm.addOrReplaceChild("leftarmgauntlet", CubeListBuilder.create().texOffs(100, 10).mirror().addBox(-1.5F, 3.5F, -2.5F, 5.0F, 5.0F, 5.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(-2.0F, 14.0F, 0.0F));

		PartDefinition rightlegupper = rightleg.addOrReplaceChild("rightlegupper", CubeListBuilder.create().texOffs(100, 20).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightlegboot = rightleg.addOrReplaceChild("rightlegboot", CubeListBuilder.create().texOffs(100, 30).addBox(-2.5F, 5.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F).mirror(false), PartPose.offset(2.0F, 14.0F, 0.0F));

		PartDefinition leftlegupper = leftleg.addOrReplaceChild("leftlegupper", CubeListBuilder.create().texOffs(100, 20).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftlegboot = leftleg.addOrReplaceChild("leftlegboot", CubeListBuilder.create().texOffs(100, 30).mirror().addBox(-2.5F, 5.0F, -2.5F, 5.0F, 5.0F, 5.0F).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void prepareMobModel(Dwarf dwarf, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(dwarf, limbSwing, limbSwingAmount, partialTick);
		this.headLight.visible = dwarf.getVariant() == 2;
	}

	@Override
	public void setupAnim(Dwarf dwarf, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.yRot = netHeadYaw / 57.295776F;
		head.xRot = headPitch / 57.295776F;

		// arms
		rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

		rightarm.zRot = 0.0F;
		leftarm.zRot = 0.0F;

		ItemStack itemstack = dwarf.getMainHandItem();
		if (dwarf.isAggressive() && (itemstack.getItem() instanceof BowItem)) {
			holdingBow(ageInTicks);
		} else if (attackTime > -9990.0F) {
			holdingMelee();
		}

		rightarm.zRot += (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.zRot -= (Mth.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.025F;

		// legs (walk_normal)
		rightleg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		leftleg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		rightleg.yRot = 0.0F;
		leftleg.yRot = 0.0F;
		rightleg.zRot = 0.0F;
		leftleg.zRot = 0.0F;

		if (riding) {
			rightarm.xRot += -((float) Math.PI / 5F);
			leftarm.xRot += -((float) Math.PI / 5F);
			rightleg.xRot = -1.4137167F;
			rightleg.yRot = ((float) Math.PI / 10F);
			rightleg.zRot = 0.07853982F;
			leftleg.xRot = -1.4137167F;
			leftleg.yRot = -((float) Math.PI / 10F);
			leftleg.zRot = -0.07853982F;
		}
	}

	private void holdingBow(float ageInTicks) {
		float f = Mth.sin(attackTime * (float) Math.PI);
		float f1 = Mth.sin((1.0F - (1.0F - attackTime) * (1.0F - attackTime)) * (float) Math.PI);

		rightarm.zRot = -0.3F;
		leftarm.zRot = 0.3F;
		rightarm.yRot = -(0.1F - f * 0.6F);
		leftarm.yRot = 0.3F - f * 0.6F;
		rightarm.xRot = -((float) Math.PI / 2F);
		leftarm.xRot = -((float) Math.PI / 2F);
		rightarm.xRot -= f * 1.2F - f1 * 0.4F;
		leftarm.xRot -= f * 1.2F - f1 * 0.4F;
		rightarm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
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
		rightarm.xRot += (body.yRot * 2.0F);
		rightarm.zRot = (Mth.sin(attackTime * (float) Math.PI) * -0.4F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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
		getArm(arm).translateAndRotate(poseStack);
	}
}