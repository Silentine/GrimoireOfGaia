package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaCecaelia extends ModelGaia {

	ModelRenderer head;
	ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer righteye;
	ModelRenderer lefteye;
	ModelRenderer righttentacle1;
	ModelRenderer righttentacle2;
	ModelRenderer righttentacle3;
	ModelRenderer lefttentacle1;
	ModelRenderer lefttentacle2;
	ModelRenderer lefttentacle3;
	ModelRenderer righttentaclelower1;
	ModelRenderer righttentaclelower2;
	ModelRenderer lefttentaclelower1;
	ModelRenderer lefttentaclelower2;
	ModelRenderer tailbase1;
	ModelRenderer tailbase2;
	ModelRenderer tailbasesw;
	ModelRenderer tailbasese;
	ModelRenderer tailbasenw;
	ModelRenderer tailbasene;
	ModelRenderer tail1sw;
	ModelRenderer tail2sw;
	ModelRenderer tail3sw;
	ModelRenderer tail4sw;
	ModelRenderer tail1se;
	ModelRenderer tail2se;
	ModelRenderer tail3se;
	ModelRenderer tail4se;
	ModelRenderer tail1nw;
	ModelRenderer tail2nw;
	ModelRenderer tail3nw;
	ModelRenderer tail4nw;
	ModelRenderer tail1ne;
	ModelRenderer tail2ne;
	ModelRenderer tail3ne;
	ModelRenderer tail4ne;

	private static final double CYCLES_PER_BLOCK = 0.1D;
	private float[][] undulationCycle = new float[][] { { 10F, -10F, -10F, 0F, 10F, 10F, 0F, -10F }, { 5F, 10F, -10F, -10F, 0F, 10F, 10F, 0F }, { 0F, 25F, 0F, -10F, -10F, 0F, 10F, 10F }, { -10F, 10F, 10F, 0F, -10F, -10F, 0F, 10F }, { -5F, -10F, 10F, 10F, 0F, -10F, -10F, 0F }, { 0F, -25F, 0F, 10F, 10F, 0F, -10F, -10F }, };

	public ModelGaiaCecaelia() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		ModelRenderer righteye = new ModelRenderer(this, 36, 14);
		righteye.addBox(-4.5F, -5.5F, -2.5F, 3, 3, 3);
		righteye.setRotationPoint(0F, 1F, 0F);
		setRotation(righteye, 0F, 0F, 0F);
		ModelRenderer lefteye = new ModelRenderer(this, 36, 14);
		lefteye.mirror = true;
		lefteye.addBox(1.5F, -5.5F, -2.5F, 3, 3, 3);
		lefteye.setRotationPoint(0F, 1F, 0F);
		setRotation(lefteye, 0F, 0F, 0F);
		ModelRenderer righttentacle1 = new ModelRenderer(this, 36, 20);
		righttentacle1.addBox(-5F, -8F, 1F, 4, 4, 4);
		righttentacle1.setRotationPoint(0F, 1F, 0F);
		setRotation(righttentacle1, 0F, 0F, 0F);
		ModelRenderer righttentacle2 = new ModelRenderer(this, 36, 28);
		righttentacle2.addBox(-6F, -5F, 3F, 3, 3, 3);
		righttentacle2.setRotationPoint(0F, 1F, 0F);
		setRotation(righttentacle2, 0F, 0F, 0F);
		ModelRenderer righttentacle3 = new ModelRenderer(this, 36, 34);
		righttentacle3.addBox(-7F, -6F, 5F, 2, 2, 2);
		righttentacle3.setRotationPoint(0F, 1F, 0F);
		setRotation(righttentacle3, 0F, 0F, 0F);
		ModelRenderer lefttentacle1 = new ModelRenderer(this, 36, 20);
		lefttentacle1.mirror = true;
		lefttentacle1.addBox(1F, -8F, 1F, 4, 4, 4);
		lefttentacle1.setRotationPoint(0F, 1F, 0F);
		setRotation(lefttentacle1, 0F, 0F, 0F);
		ModelRenderer lefttentacle2 = new ModelRenderer(this, 36, 28);
		lefttentacle2.mirror = true;
		lefttentacle2.addBox(3F, -5F, 3F, 3, 3, 3);
		lefttentacle2.setRotationPoint(0F, 1F, 0F);
		setRotation(lefttentacle2, 0F, 0F, 0F);
		ModelRenderer lefttentacle3 = new ModelRenderer(this, 36, 34);
		lefttentacle3.mirror = true;
		lefttentacle3.addBox(5F, -6F, 5F, 2, 2, 2);
		lefttentacle3.setRotationPoint(0F, 1F, 0F);
		setRotation(lefttentacle3, 0F, 0F, 0F);
		righttentaclelower1 = new ModelRenderer(this, 36, 38);
		righttentaclelower1.addBox(-5F, -1F, 2F, 3, 6, 3);
		righttentaclelower1.setRotationPoint(0F, 1F, 0F);
		setRotation(righttentaclelower1, 0F, 0F, 0F);
		righttentaclelower2 = new ModelRenderer(this, 36, 47);
		righttentaclelower2.addBox(-6F, 4F, 4F, 2, 2, 2);
		righttentaclelower2.setRotationPoint(0F, 1F, 0F);
		setRotation(righttentaclelower2, 0F, 0F, 0F);
		lefttentaclelower1 = new ModelRenderer(this, 36, 38);
		lefttentaclelower1.mirror = true;
		lefttentaclelower1.addBox(2F, -1F, 2F, 3, 6, 3);
		lefttentaclelower1.setRotationPoint(0F, 1F, 0F);
		setRotation(lefttentaclelower1, 0F, 0F, 0F);
		lefttentaclelower2 = new ModelRenderer(this, 36, 47);
		lefttentaclelower2.mirror = true;
		lefttentaclelower2.addBox(4F, 4F, 4F, 2, 2, 2);
		lefttentaclelower2.setRotationPoint(0F, 1F, 0F);
		setRotation(lefttentaclelower2, 0F, 0F, 0F);
		tailbase1 = new ModelRenderer(this, 64, 0);
		tailbase1.addBox(-3.5F, 0F, -3.5F, 7, 3, 7);
		tailbase1.setRotationPoint(0F, 11F, 0F);
		setRotation(tailbase1, 0F, 0F, 0F);
		tailbase2 = new ModelRenderer(this, 64, 10);
		tailbase2.addBox(-3.5F, 0F, -3.5F, 9, 6, 9);
		tailbase2.setRotationPoint(-1F, 13F, -1F);
		setRotation(tailbase2, 0F, 0F, 0F);
		
		tailbasesw = new ModelRenderer(this, 64, 25);
		tailbasesw.addBox(-4F, -3.5F, -2.5F, 5, 6, 5);
		tailbasesw.setRotationPoint(-2.5F, 19F, -2.5F);
		setRotation(tailbasesw, 0F, -0.7853982F, 0F);
		tailbasese = new ModelRenderer(this, 64, 25);
		tailbasese.mirror = true;
		tailbasese.addBox(-1F, -2.5F, -2.5F, 5, 6, 5);
		tailbasese.setRotationPoint(2.5F, 18F, -2.5F);
		setRotation(tailbasese, 0F, 0.7853982F, 0F);
		tailbasenw = new ModelRenderer(this, 64, 25);
		tailbasenw.addBox(-4F, -2.5F, -2.5F, 5, 6, 5);
		tailbasenw.setRotationPoint(-2.5F, 18F, 2.5F);
		setRotation(tailbasenw, 0F, 0.7853982F, 0F);
		tailbasene = new ModelRenderer(this, 64, 25);
		tailbasene.mirror = true;
		tailbasene.addBox(-1F, -2.5F, -2.5F, 5, 6, 5);
		tailbasene.setRotationPoint(2.5F, 18F, 2.5F);
		setRotation(tailbasene, 0F, -0.7853982F, 0F);
		tail1sw = new ModelRenderer(this, 64, 36);
		tail1sw.addBox(-5F, 0F, -2.5F, 6, 5, 5);
		tail1sw.setRotationPoint(-4.5F, 19F, -4.5F);
		setRotation(tail1sw, 0F, 0F, 0F);
		tail2sw = new ModelRenderer(this, 64, 46);
		tail2sw.addBox(-4F, 0F, -2F, 5, 4, 4);
		tail2sw.setRotationPoint(-9.5F, 19F, -4.5F);
		setRotation(tail2sw, 0F, 0F, 0F);
		tail3sw = new ModelRenderer(this, 64, 54);
		tail3sw.addBox(-3F, 0F, -1.5F, 4, 3, 3);
		tail3sw.setRotationPoint(-13.5F, 19F, -4.5F);
		setRotation(tail3sw, 0F, 0F, 0F);
		tail4sw = new ModelRenderer(this, 64, 60);
		tail4sw.addBox(-2F, 0F, -1F, 3, 2, 2);
		tail4sw.setRotationPoint(-16.5F, 19F, -4.5F);
		setRotation(tail4sw, 0F, 0F, 0F);
		tail1se = new ModelRenderer(this, 64, 36);
		tail1se.mirror = true;
		tail1se.addBox(-1F, 0F, -2.5F, 6, 5, 5);
		tail1se.setRotationPoint(4.5F, 19F, -4.5F);
		setRotation(tail1se, 0F, 0F, 0F);
		tail2se = new ModelRenderer(this, 64, 46);
		tail2se.mirror = true;
		tail2se.addBox(-1F, 0F, -2F, 5, 4, 4);
		tail2se.setRotationPoint(9.5F, 19F, -4.5F);
		setRotation(tail2se, 0F, 0F, 0F);
		tail3se = new ModelRenderer(this, 64, 54);
		tail3se.mirror = true;
		tail3se.addBox(-1F, 0F, -1.5F, 4, 3, 3);
		tail3se.setRotationPoint(13.5F, 19F, -4.5F);
		setRotation(tail3se, 0F, 0F, 0F);
		tail4se = new ModelRenderer(this, 64, 60);
		tail4se.mirror = true;
		tail4se.addBox(-1F, 0F, -1F, 3, 2, 2);
		tail4se.setRotationPoint(16.5F, 19F, -4.5F);
		setRotation(tail4se, 0F, 0F, 0F);
		tail1nw = new ModelRenderer(this, 64, 36);
		tail1nw.addBox(-5F, 0F, -2.5F, 6, 5, 5);
		tail1nw.setRotationPoint(-4.5F, 19F, 4.5F);
		setRotation(tail1nw, 0F, 0F, 0F);
		tail2nw = new ModelRenderer(this, 64, 46);
		tail2nw.addBox(-4F, 0F, -2F, 5, 4, 4);
		tail2nw.setRotationPoint(-9.5F, 19F, 4.5F);
		setRotation(tail2nw, 0F, 0F, 0F);
		tail3nw = new ModelRenderer(this, 64, 54);
		tail3nw.addBox(-3F, 0F, -1.5F, 4, 3, 3);
		tail3nw.setRotationPoint(-13.5F, 19F, 4.5F);
		setRotation(tail3nw, 0F, 0F, 0F);
		tail4nw = new ModelRenderer(this, 64, 60);
		tail4nw.addBox(-2F, 0F, -1F, 3, 2, 2);
		tail4nw.setRotationPoint(-16.5F, 19F, 4.5F);
		setRotation(tail4nw, 0F, 0F, 0F);
		tail1ne = new ModelRenderer(this, 64, 36);
		tail1ne.mirror = true;
		tail1ne.addBox(-1F, 0F, -2.5F, 6, 5, 5);
		tail1ne.setRotationPoint(4.5F, 19F, 4.5F);
		setRotation(tail1ne, 0F, 0F, 0F);
		tail2ne = new ModelRenderer(this, 64, 46);
		tail2ne.mirror = true;
		tail2ne.addBox(-1F, 0F, -2F, 5, 4, 4);
		tail2ne.setRotationPoint(9.5F, 19F, 4.5F);
		setRotation(tail2ne, 0F, 0F, 0F);
		tail3ne = new ModelRenderer(this, 64, 54);
		tail3ne.mirror = true;
		tail3ne.addBox(-1F, 0F, -1.5F, 4, 3, 3);
		tail3ne.setRotationPoint(13.5F, 19F, 4.5F);
		setRotation(tail3ne, 0F, 0F, 0F);
		tail4ne = new ModelRenderer(this, 64, 60);
		tail4ne.mirror = true;
		tail4ne.addBox(-1F, 0F, -1F, 3, 2, 2);
		tail4ne.setRotationPoint(16.5F, 19F, 4.5F);
		setRotation(tail4ne, 0F, 0F, 0F);


		convertToChild(head, righteye);
		convertToChild(head, lefteye);
		convertToChild(head, righttentacle1);
		convertToChild(head, righttentacle2);
		convertToChild(head, righttentacle3);
		convertToChild(head, lefttentacle1);
		convertToChild(head, lefttentacle2);
		convertToChild(head, lefttentacle3);

		convertToChild(tail3sw, tail4sw);
		convertToChild(tail2sw, tail3sw);
		convertToChild(tail1sw, tail2sw);

		convertToChild(tail3se, tail4se);
		convertToChild(tail2se, tail3se);
		convertToChild(tail1se, tail2se);

		convertToChild(tail3nw, tail4nw);
		convertToChild(tail2nw, tail3nw);
		convertToChild(tail1nw, tail2nw);

		convertToChild(tail3ne, tail4ne);
		convertToChild(tail2ne, tail3ne);
		convertToChild(tail1ne, tail2ne);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
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
		righttentaclelower1.render(scale);
		righttentaclelower2.render(scale);
		lefttentaclelower1.render(scale);
		lefttentaclelower2.render(scale);
		tailbase1.render(scale);
		tailbase2.render(scale);
		tailbasesw.render(scale);
		tailbasese.render(scale);
		tailbasenw.render(scale);
		tailbasene.render(scale);
	    tail1sw.render(scale);
	    tail1se.render(scale);
	    tail1nw.render(scale);
	    tail1ne.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		righttentaclelower1.rotateAngleY = head.rotateAngleY;
		righttentaclelower2.rotateAngleY = head.rotateAngleY;
		lefttentaclelower1.rotateAngleY = head.rotateAngleY;
		lefttentaclelower2.rotateAngleY = head.rotateAngleY;

		// arms
		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			float armDefaultAngleZ = 0.1745329F;

			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}

		if (itemstack.getItem() == Items.ARROW) {
			animationThrow();
		}

		// legs
		updateDistanceMovedTotal(entityIn);
		int cycleIndex = (int) ((getDistanceMovedTotal() * CYCLES_PER_BLOCK) % undulationCycle.length);
		float radAngle = 0.785398F;

		tail1sw.rotateAngleY = -radAngle;
		tail2sw.rotateAngleY = degToRad(undulationCycle[cycleIndex][1]);
		tail3sw.rotateAngleY = degToRad(undulationCycle[cycleIndex][2]);
		tail4sw.rotateAngleY = degToRad(undulationCycle[cycleIndex][3]);
		tail2sw.rotateAngleZ = +radAngle;
		tail3sw.rotateAngleZ = +radAngle;
		tail4sw.rotateAngleZ = +radAngle;

		tail1se.rotateAngleY = +radAngle;
		tail2se.rotateAngleY = tail2sw.rotateAngleY;
		tail3se.rotateAngleY = tail3sw.rotateAngleY;
		tail4se.rotateAngleY = tail4sw.rotateAngleY;
		tail2se.rotateAngleZ = -radAngle;
		tail3se.rotateAngleZ = -radAngle;
		tail4se.rotateAngleZ = -radAngle;

		tail1nw.rotateAngleY = +radAngle;
		tail2nw.rotateAngleY = tail2sw.rotateAngleY;
		tail3nw.rotateAngleY = tail3sw.rotateAngleY;
		tail4nw.rotateAngleY = tail4sw.rotateAngleY;
		tail2nw.rotateAngleZ = +radAngle;
		tail3nw.rotateAngleZ = +radAngle;
		tail4nw.rotateAngleZ = +radAngle;

		tail1ne.rotateAngleY = -radAngle;
		tail2ne.rotateAngleY = tail2sw.rotateAngleY;
		tail3ne.rotateAngleY = tail3sw.rotateAngleY;
		tail4ne.rotateAngleY = tail4sw.rotateAngleY;
		tail2ne.rotateAngleZ = -radAngle;
		tail3ne.rotateAngleZ = -radAngle;
		tail4ne.rotateAngleZ = -radAngle;
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

	private void animationThrow() {
		rightarm.rotateAngleX = -1.0472F;
		leftarm.rotateAngleX = -1.0472F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
