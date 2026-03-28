package gaia.client.model;

import gaia.client.state.CobbleGolemRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class CobbleGolemModel extends EntityModel<CobbleGolemRenderState> {
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart rightarm;
	private final ModelPart leftarm;
	private final ModelPart rightleg;
	private final ModelPart leftleg;

	public CobbleGolemModel(ModelPart root) {
		super(root);
		this.root = root.getChild("cobble_golem");
		ModelPart body = this.root.getChild("bodylower").getChild("body");
		this.head = body.getChild("head");
		this.rightarm = body.getChild("rightarm");
		this.leftarm = body.getChild("leftarm");
		this.rightleg = this.root.getChild("rightleg");
		this.leftleg = this.root.getChild("leftleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cobble_golem = partdefinition.addOrReplaceChild("cobble_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bodylower = cobble_golem.addOrReplaceChild("bodylower", CubeListBuilder.create().texOffs(0, 28).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition body = bodylower.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 8).addBox(-7.0F, -12.0F, -7.0F, 14.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -7.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(44, 0).addBox(-6.0F, -4.0F, -3.0F, 6.0F, 12.0F, 6.0F)
				.texOffs(44, 18).addBox(-5.0F, 8.0F, -2.0F, 4.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(-7.0F, -8.0F, -3.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(0.0F, -4.0F, -3.0F, 6.0F, 12.0F, 6.0F).mirror(false)
				.texOffs(44, 18).addBox(1.0F, 8.0F, -2.0F, 4.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(7.0F, -8.0F, -3.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightleg = cobble_golem.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(44, 36).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, -8.5F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightleglower = rightleg.addOrReplaceChild("rightleglower", CubeListBuilder.create().texOffs(44, 45).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -0.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition leftleg = cobble_golem.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(44, 36).mirror().addBox(-1.5F, -1.5F, -1.5F, 3.0F, 6.0F, 3.0F).mirror(false), PartPose.offsetAndRotation(3.0F, -8.5F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftleglower = leftleg.addOrReplaceChild("leftleglower", CubeListBuilder.create().texOffs(44, 45).mirror().addBox(-2.0F, -2.0F, 0.0F, 4.0F, 6.0F, 4.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 4.5F, -0.5F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(CobbleGolemRenderState state) {
		super.setupAnim(state);

		int i = state.attackAnimationTick;
		float rotation = -(Mth.DEG_TO_RAD * 15);
		if (i > 0) {
			rightarm.xRot = rotation - 2.0F + 1.5F * Mth.triangleWave((float) i - state.partialTick, 10.0F);
			leftarm.xRot = rotation - 2.0F + 1.5F * Mth.triangleWave((float) i - state.partialTick, 10.0F);
		} else {
			rightarm.xRot = rotation + (-0.2F + 1.5F * Mth.triangleWave(state.walkAnimationPos, 13.0F)) * state.walkAnimationSpeed;
			leftarm.xRot = rotation + (-0.2F - 1.5F * Mth.triangleWave(state.walkAnimationPos, 13.0F)) * state.walkAnimationSpeed;
		}

		// head
		head.yRot = state.yRot / 57.295776F;
		head.xRot = state.xRot / 57.295776F;

		// legs
		rightleg.xRot = -1.5F * Mth.triangleWave(state.walkAnimationPos, 13.0F) * state.walkAnimationSpeed;
		rightleg.xRot -= 0.1745329F;
		leftleg.xRot = 1.5F * Mth.triangleWave(state.walkAnimationPos, 13.0F) * state.walkAnimationSpeed;
		leftleg.xRot -= 0.1745329F;
	}

}