package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaCentaur<T extends MobEntity> extends ModelGaia<T> {
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
	private RendererModel bodytopmale;
	private RendererModel bodymidmale;
	private RendererModel hair1;
	private RendererModel hair2;
	private RendererModel rightear;
	private RendererModel leftear;
	private RendererModel rightpauldron;
	private RendererModel leftpauldron;
	private RendererModel front;
	private RendererModel body1;
	private RendererModel body2;
	private RendererModel rightlegupper;
	private RendererModel leftlegupper;
	private RendererModel rightlegbracelet;
	private RendererModel leftlegbracelet;
	private RendererModel rightleglower;
	private RendererModel leftleglower;
	private RendererModel rightlegback1;
	private RendererModel leftlegback1;
	private RendererModel rightlegback2;
	private RendererModel leftlegback2;
	private RendererModel rightlegback3;
	private RendererModel leftlegback3;
	private RendererModel tail;

	public ModelGaiaCentaur() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, -6F, -7.5F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, -6F, -7.5F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, -6F, -7.5F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, -6F, -7.5F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -2F, 5, 6, 3);
		bodytop.setRotationPoint(0F, -6F, -7F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -2F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, -6F, -7F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 5.5F, -2.1F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, -5.5F, -7F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -3F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, -6F, -7F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, -4F, -9F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, -4F, -9F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, -5F, -7.5F);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new RendererModel(this, 24, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, -5F, -7.5F);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		bodytopmale = new RendererModel(this, 0, 50);
		bodytopmale.addBox(-3F, 0F, -2F, 6, 6, 3);
		bodytopmale.setRotationPoint(0F, -6F, -7F);
		setRotation(bodytopmale, -0.0872665F, 0F, 0F);
		bodymidmale = new RendererModel(this, 0, 59);
		bodymidmale.addBox(-2.5F, 5.5F, -2F, 5, 3, 2);
		bodymidmale.setRotationPoint(0F, -6F, -7F);
		setRotation(bodymidmale, 0F, 0F, 0F);
		hair1 = new RendererModel(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, -6F, -7.5F);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new RendererModel(this, 36, 25);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, -6F, -7.5F);
		setRotation(hair2, 0F, 0F, 0F);
		rightear = new RendererModel(this, 36, 33);
		rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		rightear.setRotationPoint(0F, -6F, -7.5F);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		leftear = new RendererModel(this, 36, 33);
		leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		leftear.setRotationPoint(0F, -6F, -7.5F);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		rightpauldron = new RendererModel(this, 36, 41);
		rightpauldron.addBox(-2.5F, -1.5F, -1.5F, 3, 3, 3);
		rightpauldron.setRotationPoint(-2.5F, -5F, -7.5F);
		setRotation(rightpauldron, 0F, 0F, 0.1745329F);
		leftpauldron = new RendererModel(this, 36, 41);
		leftpauldron.mirror = true;
		leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 3, 3);
		leftpauldron.setRotationPoint(2.5F, -5F, -7.5F);
		setRotation(leftpauldron, 0F, 0F, -0.1745329F);
		front = new RendererModel(this, 64, 0);
		front.addBox(-3.5F, 7.5F, -2F, 7, 8, 3);
		front.setRotationPoint(0F, -6F, -7F);
		setRotation(front, -0.0872665F, 0F, 0F);
		body1 = new RendererModel(this, 64, 11);
		body1.addBox(-4F, 14F, 0F, 8, 9, 9);
		body1.setRotationPoint(0F, -10F, -8F);
		setRotation(body1, -0.0872665F, 0F, 0F);
		body2 = new RendererModel(this, 64, 29);
		body2.addBox(-3.5F, 15.5F, 5F, 7, 8, 12);
		body2.setRotationPoint(0F, -10F, -8F);
		setRotation(body2, 0.0872665F, 0F, 0F);
		rightlegupper = new RendererModel(this, 106, 0);
		rightlegupper.addBox(-1.466667F, -1.5F, -1.5F, 3, 8, 3);
		rightlegupper.setRotationPoint(-4F, 9F, -7F);
		setRotation(rightlegupper, 0F, 0F, -0.0872665F);
		leftlegupper = new RendererModel(this, 106, 0);
		leftlegupper.addBox(-1.466667F, -1.5F, -1.5F, 3, 8, 3);
		leftlegupper.setRotationPoint(4F, 9F, -7F);
		setRotation(leftlegupper, 0F, 0F, 0.0872665F);
		rightlegbracelet = new RendererModel(this, 106, 11);
		rightlegbracelet.addBox(-1.5F, 10.5F, -1F, 3, 2, 3);
		rightlegbracelet.setRotationPoint(-4F, 9F, -7F);
		setRotation(rightlegbracelet, 0F, 0F, -0.0872665F);
		leftlegbracelet = new RendererModel(this, 106, 11);
		leftlegbracelet.addBox(-1.5F, 10.5F, -1F, 3, 2, 3);
		leftlegbracelet.setRotationPoint(4F, 9F, -7F);
		setRotation(leftlegbracelet, 0F, 0F, 0.0872665F);
		rightleglower = new RendererModel(this, 106, 16);
		rightleglower.addBox(-1F, 6.5F, -0.5F, 2, 8, 2);
		rightleglower.setRotationPoint(-4F, 9F, -7F);
		setRotation(rightleglower, 0F, 0F, -0.0872665F);
		leftleglower = new RendererModel(this, 106, 16);
		leftleglower.addBox(-1F, 6.5F, -0.5F, 2, 8, 2);
		leftleglower.setRotationPoint(4F, 9F, -7F);
		setRotation(leftleglower, 0F, 0F, 0.0872665F);
		rightlegback1 = new RendererModel(this, 106, 26);
		rightlegback1.addBox(-0.5F, -2.5F, -1.5F, 3, 8, 6);
		rightlegback1.setRotationPoint(-4F, 7F, 7F);
		setRotation(rightlegback1, -0.296706F, 0F, -0.0872665F);
		leftlegback1 = new RendererModel(this, 106, 26);
		leftlegback1.addBox(-2.5F, -2.5F, -1.5F, 3, 8, 6);
		leftlegback1.setRotationPoint(4F, 7F, 7F);
		setRotation(leftlegback1, -0.296706F, 0F, 0.0872665F);
		rightlegback2 = new RendererModel(this, 106, 40);
		rightlegback2.addBox(-1.5F, 2F, 2.5F, 3, 3, 6);
		rightlegback2.setRotationPoint(-4F, 7F, 7F);
		setRotation(rightlegback2, -1.047198F, 0F, -0.0872665F);
		leftlegback2 = new RendererModel(this, 106, 40);
		leftlegback2.addBox(-1.5F, 2F, 2.5F, 3, 3, 6);
		leftlegback2.setRotationPoint(4F, 7F, 7F);
		setRotation(leftlegback2, -1.047198F, 0F, 0.0872665F);
		rightlegback3 = new RendererModel(this, 106, 49);
		rightlegback3.addBox(-1F, 8F, 1.5F, 2, 8, 2);
		rightlegback3.setRotationPoint(-4F, 7F, 7F);
		setRotation(rightlegback3, -0.122173F, 0F, -0.0872665F);
		leftlegback3 = new RendererModel(this, 106, 49);
		leftlegback3.addBox(-1F, 8F, 1.5F, 2, 8, 2);
		leftlegback3.setRotationPoint(4F, 7F, 7F);
		setRotation(leftlegback3, -0.122173F, 0F, 0.0872665F);
		tail = new RendererModel(this, 106, 51);
		tail.addBox(-1F, -1F, -0.5F, 2, 2, 8);
		tail.setRotationPoint(0F, 6F, 10F);
		setRotation(tail, -1.047198F, 0F, 0F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(getRightArm(), rightpauldron);
		convertToChild(getLeftArm(), leftpauldron);
		convertToChild(rightlegupper, rightlegbracelet);
		convertToChild(rightlegupper, rightleglower);
		convertToChild(leftlegupper, leftlegbracelet);
		convertToChild(leftlegupper, leftleglower);
		convertToChild(rightlegback1, rightlegback2);
		convertToChild(rightlegback1, rightlegback3);
		convertToChild(leftlegback1, leftlegback2);
		convertToChild(leftlegback1, leftlegback3);
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
		bodytopmale.render(scale);
		bodymidmale.render(scale);
		hair1.render(scale);
		hair2.render(scale);
		front.render(scale);
		body1.render(scale);
		body2.render(scale);
		rightlegupper.render(scale);
		leftlegupper.render(scale);
		rightlegback1.render(scale);
		leftlegback1.render(scale);
		tail.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && ageInTicks <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		ItemStack itemstack = entityIn.getItemStackFromSlot(EquipmentSlotType.HEAD);
		ItemStack itemstackChest = entityIn.getItemStackFromSlot(EquipmentSlotType.CHEST);
		ItemStack equipstack = entityIn.getHeldItemMainhand();

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;
		hair1.rotateAngleY = head.rotateAngleY;
		hair2.rotateAngleY = (head.rotateAngleY) * 0.75F;

		// arms
		if (itemstackChest.getItem() == Items.STICK) {
			rightarm.rotationPointX = -3F;
			leftarm.rotationPointX = 3F;
		}

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (entityIn.isAggressive() && (equipstack.getItem() instanceof BowItem)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		if (itemstack.getItem() == Items.FEATHER) {
			Vec3d motion = entityIn.getMotion();
			if (motion.getX() * motion.getX() + motion.getZ() * motion.getZ() > 2.500000277905201E-7D) {
				animationFlee();
			}
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		tail.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(10);

		// legs
		rightlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.7862F) * 0.8F * limbSwingAmount;
		leftlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightlegback1.rotateAngleX = MathHelper.cos(limbSwing * 0.7662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightlegback1.rotateAngleX -= 0.296706F;
		leftlegback1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftlegback1.rotateAngleX -= 0.296706F;
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2.2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2.2F);
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

	private void animationFlee() {
		leftarm.rotateAngleX += 1.0472F;
	}

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
