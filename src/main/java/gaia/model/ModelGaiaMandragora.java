package gaia.model;

import gaia.entity.monster.EntityGaiaMandragora;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMandragora extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymiddle;
	private ModelRenderer bodymiddlebutton;
	private ModelRenderer bodybottom;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer waist;

	private static final float SCALE_AMOUNT_HEAD = 0.75F;
	private static final float SCALE_AMOUNT_BODY = 0.5F;
	// Increasing the value moves it closer to the ground
	private static final float Y_OFFSET_HEAD = 15.5F;
	private static final float Y_OFFSET_BODY = 23.5F;

	public ModelGaiaMandragora() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0.0349066F, 0F, 0.0872665F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0.0349066F, 0F, -0.0872665F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0.0349066F, 0F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0.0349066F, 0F, 0.0349066F);
		ModelRenderer headflower1 = new ModelRenderer(this, 36, 28);
		headflower1.addBox(-3F, -12.5F, 0F, 6, 6, 0);
		headflower1.setRotationPoint(0F, 1F, 0F);
		headflower1.setTextureSize(64, 32);
		setRotation(headflower1, 0F, -0.7853982F, 0F);
		ModelRenderer headflower2 = new ModelRenderer(this, 36, 28);
		headflower2.addBox(-3F, -12.5F, 0F, 6, 6, 0);
		headflower2.setRotationPoint(0F, 1F, 0F);
		headflower2.setTextureSize(64, 32);
		setRotation(headflower2, 0F, 0.7853982F, 0F);
		ModelRenderer headhairright = new ModelRenderer(this, 36, 34);
		headhairright.addBox(-4.5F, -2F, 0.5F, 4, 14, 4);
		headhairright.setRotationPoint(0F, 1F, 0F);
		headhairright.setTextureSize(64, 32);
		setRotation(headhairright, 0.0436332F, 0F, 0.0436332F);
		ModelRenderer headhairleft = new ModelRenderer(this, 36, 34);
		headhairleft.addBox(0.5F, -2F, 0.5F, 4, 14, 4);
		headhairleft.setRotationPoint(0F, 1F, 0F);
		headhairleft.setTextureSize(64, 32);
		setRotation(headhairleft, 0.0436332F, 0F, -0.0436332F);
		waist = new ModelRenderer(this, 36, 52);
		waist.addBox(-3.5F, 8.5F, -3F, 7, 5, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);
		ModelRenderer headleaf1 = new ModelRenderer(this, 36, 14);
		headleaf1.addBox(-3F, -10F, -6F, 6, 8, 0);
		headleaf1.setRotationPoint(0F, 1F, 0F);
		headleaf1.setTextureSize(64, 32);
		setRotation(headleaf1, -1.308997F, -0.7853982F, 0F);
		ModelRenderer headleaf2 = new ModelRenderer(this, 36, 14);
		headleaf2.addBox(-3F, -10F, -6F, 6, 8, 0);
		headleaf2.setRotationPoint(0F, 1F, 0F);
		headleaf2.setTextureSize(64, 32);
		setRotation(headleaf2, -1.308997F, 0.7853982F, 0F);
		ModelRenderer headleaf3 = new ModelRenderer(this, 36, 14);
		headleaf3.addBox(-3F, -10F, -6F, 6, 8, 0);
		headleaf3.setRotationPoint(0F, 1F, 0F);
		headleaf3.setTextureSize(64, 32);
		setRotation(headleaf3, -1.308997F, 2.356194F, 0F);
		ModelRenderer headleaf4 = new ModelRenderer(this, 36, 14);
		headleaf4.addBox(-3F, -10F, -6F, 6, 8, 0);
		headleaf4.setRotationPoint(0F, 1F, 0F);
		headleaf4.setTextureSize(64, 32);
		setRotation(headleaf4, -1.308997F, -2.356194F, 0F);
		ModelRenderer headleafs1 = new ModelRenderer(this, 36, 22);
		headleafs1.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
		headleafs1.setRotationPoint(0F, 1F, 0F);
		headleafs1.setTextureSize(64, 32);
		setRotation(headleafs1, -1.047198F, 0F, 0F);
		ModelRenderer headleafs2 = new ModelRenderer(this, 36, 22);
		headleafs2.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
		headleafs2.setRotationPoint(0F, 1F, 0F);
		headleafs2.setTextureSize(64, 32);
		setRotation(headleafs2, -1.047198F, 1.570796F, 0F);
		ModelRenderer headleafs3 = new ModelRenderer(this, 36, 22);
		headleafs3.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
		headleafs3.setRotationPoint(0F, 1F, 0F);
		headleafs3.setTextureSize(64, 32);
		setRotation(headleafs3, -1.047198F, 3.141593F, 0F);
		ModelRenderer headleafs4 = new ModelRenderer(this, 36, 22);
		headleafs4.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
		headleafs4.setRotationPoint(0F, 1F, 0F);
		headleafs4.setTextureSize(64, 32);
		setRotation(headleafs4, -1.047198F, -1.570796F, 0F);
		headflower1 = new ModelRenderer(this, 36, 28);
		headflower1.addBox(-3F, -12.5F, 0F, 6, 6, 0);
		headflower1.setRotationPoint(0F, 1F, 0F);
		headflower1.setTextureSize(64, 32);
		setRotation(headflower1, 0F, -0.7853982F, 0F);
		headflower2 = new ModelRenderer(this, 36, 28);
		headflower2.addBox(-3F, -12.5F, 0F, 6, 6, 0);
		headflower2.setRotationPoint(0F, 1F, 0F);
		headflower2.setTextureSize(64, 32);
		setRotation(headflower2, 0F, 0.7853982F, 0F);
		headhairright = new ModelRenderer(this, 36, 34);
		headhairright.addBox(-4.5F, -2F, 0.5F, 4, 14, 4);
		headhairright.setRotationPoint(0F, 1F, 0F);
		headhairright.setTextureSize(64, 32);
		setRotation(headhairright, 0.0436332F, 0F, 0.0436332F);
		headhairleft = new ModelRenderer(this, 36, 34);
		headhairleft.addBox(0.5F, -2F, 0.5F, 4, 14, 4);
		headhairleft.setRotationPoint(0F, 1F, 0F);
		headhairleft.setTextureSize(64, 32);
		setRotation(headhairleft, 0.0436332F, 0F, -0.0436332F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 48);
		rightear.addBox(-4F, -4F, -1F, 0, 2, 4);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(64, 32);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 48);
		leftear.mirror = true;
		leftear.addBox(4F, -4F, -1F, 0, 2, 4);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		waist = new ModelRenderer(this, 64, 0);
		waist.addBox(-3.5F, 8.5F, -3F, 7, 5, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);

		convertToChild(head, headflower1);
		convertToChild(head, headflower2);
		convertToChild(head, headhairright);
		convertToChild(head, headhairleft);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(head, headleaf1);
		convertToChild(head, headleaf2);
		convertToChild(head, headleaf3);
		convertToChild(head, headleaf4);
		convertToChild(head, headleafs1);
		convertToChild(head, headleafs2);
		convertToChild(head, headleafs3);
		convertToChild(head, headleafs4);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		EntityGaiaMandragora entityGaiaMandragora = (EntityGaiaMandragora) entityIn;

		if (!entityGaiaMandragora.isChild()) {
			head.render(scale);
			headaccessory.render(scale);
			neck.render(scale);
			bodytop.render(scale);
			bodymiddle.render(scale);
			bodymiddlebutton.render(scale);
			bodybottom.render(scale);
			rightarm.render(scale);
			leftarm.render(scale);
			rightleg.render(scale);
			leftleg.render(scale);
			waist.render(scale);

			if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
				headeyes.render(scale);
			}
		} else {
			/* SCALING */
			GlStateManager.pushMatrix();
			GlStateManager.scale(SCALE_AMOUNT_HEAD, SCALE_AMOUNT_HEAD, SCALE_AMOUNT_HEAD);
			GlStateManager.translate(0.0F, Y_OFFSET_HEAD * scale, 0.0F);
			head.render(scale);

			if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
				headeyes.render(scale);
			}

			headaccessory.render(scale);
			GlStateManager.popMatrix();
			/* SCALING */
			GlStateManager.pushMatrix();
			GlStateManager.scale(SCALE_AMOUNT_BODY, SCALE_AMOUNT_BODY, SCALE_AMOUNT_BODY);
			GlStateManager.translate(0.0F, Y_OFFSET_BODY * scale, 0.0F);
			neck.render(scale);
			bodytop.render(scale);
			bodymiddle.render(scale);
			bodymiddlebutton.render(scale);
			bodybottom.render(scale);
			rightarm.render(scale);
			leftarm.render(scale);
			rightleg.render(scale);
			leftleg.render(scale);
			waist.render(scale);
			GlStateManager.popMatrix();
			/* SCALING */
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		rightleg.rotateAngleX += 0.0349066F;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX += 0.0349066F;
	}

	public void holdingMelee() {
		float f6;
		float f7;

		f6 = 1.0F - swingProgress;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = MathHelper.sin(f6 * (float) Math.PI);
		float f8 = MathHelper.sin(swingProgress * (float) Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;

		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleX += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
