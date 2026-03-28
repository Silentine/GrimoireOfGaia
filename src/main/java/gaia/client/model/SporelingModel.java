package gaia.client.model;

import gaia.client.state.SporelingRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.util.Mth;

public class SporelingModel extends EntityModel<SporelingRenderState> implements HeadedModel {
	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart headalt;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public SporelingModel(ModelPart root) {
		super(root);
		this.root = root.getChild("sporeling");
		this.body = this.root.getChild("body");
		this.head = body.getChild("head");
		this.headalt = body.getChild("headalt");
		this.leftleg = this.root.getChild("leftleg");
		this.rightleg = this.root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition sporeling = partdefinition.addOrReplaceChild("sporeling", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = sporeling.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 6.0F, 8.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition headalt = body.addOrReplaceChild("headalt", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 3.0F, 8.0F), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition rightleg = sporeling.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(32, 11).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(-1.5F, -3.0F, 0.0F));

		PartDefinition leftleg = sporeling.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(32, 11).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offset(1.5F, -3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(SporelingRenderState state) {
		super.setupAnim(state);

		this.head.visible = state.variant == 0;
		this.headalt.visible = state.variant == 1;

		// head
		head.yRot = state.yRot / 57.295776F;
		headalt.yRot = state.yRot / 57.295776F;

		// body
		if (state.attackTime > 0.0F) {
			holdingMelee(state);
		}

		// legs
		rightleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F) * 0.5F * state.walkAnimationSpeed;
		leftleg.xRot = Mth.cos(state.walkAnimationPos * 0.6662F + (float) Math.PI) * 0.5F * state.walkAnimationSpeed;
	}

	public void holdingMelee(ArmedEntityRenderState state) {
		float f6;
		float f7;

		f6 = 1.0F - state.attackTime;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = Mth.sin(f6 * (float) Math.PI);
		float f8 = Mth.sin(state.attackTime * (float) Math.PI) * -(body.xRot - 0.7F) * 0.75F;

		body.xRot -= (float) ((double) body.xRot - ((double) f7 * 1.2D + (double) f8));
	}


	@Override
	public ModelPart getHead() {
		return head;
	}
}