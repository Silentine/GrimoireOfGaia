package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.BowItem;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaMinotaurus<T extends MobEntity> extends ModelGaia<T> {
	private RendererModel head;
	private RendererModel headeyes;
	private RendererModel headaccessory;
	private RendererModel neck;
	private RendererModel bodytop;
	private RendererModel bodymiddle;
	private RendererModel bodymiddlebutton;
	private RendererModel bodybottom;
	private RendererModel rightchest;
	private RendererModel leftchest;
	private RendererModel rightarm;
	private RendererModel leftarm;
	private RendererModel rightleg;
	private RendererModel leftleg;
	private RendererModel ring;
	private RendererModel waist;
	private RendererModel tail;

	public ModelGaiaMinotaurus() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(128, 64);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(128, 64);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(128, 64);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(128, 64);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(128, 64);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(128, 64);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(128, 64);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		rightchest.setTextureSize(128, 64);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		leftchest.setTextureSize(128, 64);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-3F, -1F, -1.5F, 3, 12, 3);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, 0F, 0F, 0.0872665F);
		leftarm = new RendererModel(this, 16, 36);
		leftarm.addBox(0F, -1F, -1.5F, 3, 12, 3);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, 0F, 0F, -0.0872665F);
		rightleg = new RendererModel(this, 64, 18);
		rightleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		rightleg.setRotationPoint(-2F, 11F, -0.5F);
		rightleg.setTextureSize(128, 64);
		setRotation(rightleg, -0.1745329F, 0F, 0F);
		leftleg = new RendererModel(this, 64, 18);
		leftleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		leftleg.setRotationPoint(2F, 11F, -0.5F);
		leftleg.setTextureSize(128, 64);
		setRotation(leftleg, -0.1745329F, 0F, 0F);
		RendererModel righthorn1 = new RendererModel(this, 36, 18);
		righthorn1.addBox(-5F, -7F, -2F, 2, 2, 2);
		righthorn1.setRotationPoint(0F, 1F, 0F);
		righthorn1.setTextureSize(128, 64);
		setRotation(righthorn1, 0F, 0F, 0F);
		RendererModel righthorn2 = new RendererModel(this, 36, 22);
		righthorn2.addBox(-4F, -8F, -3F, 2, 2, 2);
		righthorn2.setRotationPoint(0F, 1F, 0F);
		righthorn2.setTextureSize(128, 64);
		setRotation(righthorn2, 0F, 0F, 0F);
		RendererModel righthorn3 = new RendererModel(this, 36, 26);
		righthorn3.addBox(-2.5F, -8.5F, -1.5F, 1, 1, 1);
		righthorn3.setRotationPoint(0F, 1F, 0F);
		righthorn3.setTextureSize(128, 64);
		setRotation(righthorn3, 0F, 0F, 0F);
		RendererModel lefthorn1 = new RendererModel(this, 36, 18);
		lefthorn1.mirror = true;
		lefthorn1.addBox(3F, -7F, -2F, 2, 2, 2);
		lefthorn1.setRotationPoint(0F, 1F, 0F);
		lefthorn1.setTextureSize(128, 64);
		lefthorn1.mirror = true;
		setRotation(lefthorn1, 0F, 0F, 0F);
		RendererModel lefthorn2 = new RendererModel(this, 36, 22);
		lefthorn2.mirror = true;
		lefthorn2.addBox(2F, -8F, -3F, 2, 2, 2);
		lefthorn2.setRotationPoint(0F, 1F, 0F);
		lefthorn2.setTextureSize(128, 64);
		setRotation(lefthorn2, 0F, 0F, 0F);
		RendererModel lefthorn3 = new RendererModel(this, 36, 26);
		lefthorn3.mirror = true;
		lefthorn3.addBox(1.5F, -8.5F, -1.5F, 1, 1, 1);
		lefthorn3.setRotationPoint(0F, 1F, 0F);
		lefthorn3.setTextureSize(128, 64);
		setRotation(lefthorn3, 0F, 0F, 0F);
		RendererModel rightear = new RendererModel(this, 36, 28);
		rightear.addBox(-3.5F, -5F, 0.5F, 0, 4, 4);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(128, 64);
		setRotation(rightear, 0F, -0.7853982F, 0F);
		RendererModel leftear = new RendererModel(this, 36, 28);
		leftear.mirror = true;
		leftear.addBox(3.5F, -5F, 0.5F, 0, 4, 4);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(128, 64);
		setRotation(leftear, 0F, 0.7853982F, 0F);
		ring = new RendererModel(this, 36, 36);
		ring.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 1);
		ring.setRotationPoint(0F, 3F, -1.5F);
		ring.setTextureSize(128, 64);
		setRotation(ring, -0.6981317F, 0F, 0F);
		RendererModel rightpauldron = new RendererModel(this, 36, 40);
		rightpauldron.addBox(-3.5F, -1.5F, -2F, 4, 4, 4);
		rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		rightpauldron.setTextureSize(128, 64);
		setRotation(rightpauldron, 0F, 0F, 0.0872665F);
		RendererModel leftpauldron = new RendererModel(this, 36, 40);
		leftpauldron.mirror = true;
		leftpauldron.addBox(-0.5F, -1.5F, -2F, 4, 4, 4);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		leftpauldron.setTextureSize(128, 64);
		setRotation(leftpauldron, 0F, 0F, -0.0872665F);
		RendererModel rightarmband = new RendererModel(this, 36, 48);
		rightarmband.addBox(-3.5F, 8F, -2F, 4, 1, 4);
		rightarmband.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmband.setTextureSize(128, 64);
		setRotation(rightarmband, 0F, 0F, 0.0872665F);
		RendererModel leftarmband = new RendererModel(this, 52, 48);
		leftarmband.addBox(-0.5F, 8F, -2F, 4, 1, 4);
		leftarmband.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmband.setTextureSize(128, 64);
		setRotation(leftarmband, 0F, 0F, -0.0872665F);
		waist = new RendererModel(this, 64, 0);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(128, 64);
		setRotation(waist, 0.0872665F, 0F, 0F);
		tail = new RendererModel(this, 64, 8);
		tail.addBox(-1F, 0F, 0F, 2, 10, 0);
		tail.setRotationPoint(0F, 10F, 2F);
		tail.setTextureSize(128, 64);
		setRotation(tail, 0.4014257F, 0F, 0F);
		RendererModel rightleglower = new RendererModel(this, 64, 28);
		rightleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		rightleglower.setRotationPoint(-2F, 11F, -0.5F);
		rightleglower.setTextureSize(128, 64);
		setRotation(rightleglower, -0.1745329F, 0F, 0F);
		RendererModel leftleglower = new RendererModel(this, 64, 28);
		leftleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		leftleglower.setRotationPoint(2F, 11F, -0.5F);
		leftleglower.setTextureSize(128, 64);
		setRotation(leftleglower, -0.1745329F, 0F, 0F);
		RendererModel rightfoot = new RendererModel(this, 64, 40);
		rightfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		rightfoot.setTextureSize(128, 64);
		setRotation(rightfoot, 0F, 0F, 0F);
		RendererModel leftfoot = new RendererModel(this, 64, 40);
		leftfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		leftfoot.setRotationPoint(2F, 11F, -0.5F);
		leftfoot.setTextureSize(128, 64);
		setRotation(leftfoot, 0F, 0F, 0F);

		convertToChild(head, righthorn1);
		convertToChild(head, righthorn2);
		convertToChild(head, righthorn3);
		convertToChild(head, lefthorn1);
		convertToChild(head, lefthorn2);
		convertToChild(head, lefthorn3);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightarm, rightpauldron);
		convertToChild(rightarm, rightarmband);
		convertToChild(leftarm, leftpauldron);
		convertToChild(leftarm, leftarmband);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightfoot);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftfoot);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymiddle.render(scale);
		bodymiddlebutton.render(scale);
		bodybottom.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		ring.render(scale);
		waist.render(scale);
		tail.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
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

		if (entityIn.isAggressive() && (entityIn.getHeldItemMainhand().getItem() instanceof BowItem)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		tail.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(15);

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.1745329F;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX -= 0.1745329F;
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2F);
		rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
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

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
