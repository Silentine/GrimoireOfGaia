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
public class ModelGaiaNineTails extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymiddle;
	private ModelRenderer bodymiddlebutton;
	private ModelRenderer bodybottom;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer hair1;
	private ModelRenderer hair2;
	private ModelRenderer tie;
	private ModelRenderer rightarmclothupper;
	private ModelRenderer leftarmclothupper;
	private ModelRenderer rightarmcloth;
	private ModelRenderer leftarmcloth;
	private ModelRenderer toprighttail1;
	private ModelRenderer toprighttail2;
	private ModelRenderer toptail1;
	private ModelRenderer toptail2;
	private ModelRenderer toplefttail1;
	private ModelRenderer toplefttail2;
	private ModelRenderer midrighttail1;
	private ModelRenderer midrighttail2;
	private ModelRenderer midtail1;
	private ModelRenderer midtail2;
	private ModelRenderer midlefttail1;
	private ModelRenderer midlefttail2;
	private ModelRenderer bottomrighttail1;
	private ModelRenderer bottomrighttail2;
	private ModelRenderer bottomtail1;
	private ModelRenderer bottomtail2;
	private ModelRenderer bottomlefttail1;
	private ModelRenderer bottomlefttail2;
	private ModelRenderer rightlegcloth;
	private ModelRenderer leftlegcloth;
	private ModelRenderer rightsandal;
	private ModelRenderer leftsandal;

	public ModelGaiaNineTails() {
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
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightleg, 0F, -0.0872665F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		setRotation(leftleg, 0F, 0.0872665F, 0.0349066F);
		hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, 1F, 0F);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 36, 25);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, 1F, 0F);
		setRotation(hair2, 0F, 0F, 0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 37);
		rightear.addBox(-4.5F, -10F, -1.5F, 3, 4, 3);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.mirror = true;
		setRotation(rightear, 0F, 0F, 0.0872665F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 37);
		leftear.mirror = true;
		leftear.addBox(1.5F, -10F, -1.5F, 3, 4, 3);
		leftear.setRotationPoint(0F, 1F, 0F);
		setRotation(leftear, 0F, 0F, -0.0872665F);
		tie = new ModelRenderer(this, 64, 0);
		tie.addBox(-1.5F, 3F, -2.5F, 3, 2, 1);
		tie.setRotationPoint(0F, 1F, 0F);
		setRotation(tie, 0F, 0F, 0F);
		rightarmclothupper = new ModelRenderer(this, 64, 3);
		rightarmclothupper.addBox(-3F, 0.5F, -2F, 4, 2, 4);
		rightarmclothupper.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarmclothupper, 0F, 0F, 0.1745329F);
		leftarmclothupper = new ModelRenderer(this, 64, 3);
		leftarmclothupper.mirror = true;
		leftarmclothupper.addBox(-1F, 0.5F, -2F, 4, 2, 4);
		leftarmclothupper.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarmclothupper, 0F, 0F, -0.1745329F);
		rightarmcloth = new ModelRenderer(this, 64, 9);
		rightarmcloth.addBox(-2.5F, 2.5F, -1.5F, 3, 8, 3);
		rightarmcloth.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarmcloth, 0F, 0F, 0.1745329F);
		leftarmcloth = new ModelRenderer(this, 64, 9);
		leftarmcloth.mirror = true;
		leftarmcloth.addBox(-0.5F, 2.5F, -1.5F, 3, 8, 3);
		leftarmcloth.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarmcloth, 0F, 0F, -0.1745329F);
		toprighttail1 = new ModelRenderer(this, 64, 20);
		toprighttail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		toprighttail1.setRotationPoint(-2F, 8F, 2F);
		setRotation(toprighttail1, 0F, 0F, 0F);
		toprighttail2 = new ModelRenderer(this, 64, 29);
		toprighttail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		toprighttail2.setRotationPoint(-2F, 8F, 7F);
		setRotation(toprighttail2, 0F, 0F, 0F);
		toptail1 = new ModelRenderer(this, 64, 20);
		toptail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		toptail1.setRotationPoint(0F, 8F, 2F);
		setRotation(toptail1, 0F, 0F, 0F);
		toptail2 = new ModelRenderer(this, 64, 29);
		toptail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		toptail2.setRotationPoint(0F, 8F, 7F);
		setRotation(toptail2, 0F, 0F, 0F);
		toplefttail1 = new ModelRenderer(this, 64, 20);
		toplefttail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		toplefttail1.setRotationPoint(2F, 8F, 2F);
		setRotation(toplefttail1, 0F, 0F, 0F);
		toplefttail2 = new ModelRenderer(this, 64, 29);
		toplefttail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		toplefttail2.setRotationPoint(2F, 8F, 7F);
		setRotation(toplefttail2, 0F, 0F, 0F);
		midrighttail1 = new ModelRenderer(this, 64, 20);
		midrighttail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		midrighttail1.setRotationPoint(-2F, 10F, 2F);
		setRotation(midrighttail1, 0F, 0F, 0F);
		midrighttail2 = new ModelRenderer(this, 64, 29);
		midrighttail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		midrighttail2.setRotationPoint(-2F, 10F, 7F);
		setRotation(midrighttail2, 0F, 0F, 0F);
		midtail1 = new ModelRenderer(this, 64, 20);
		midtail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		midtail1.setRotationPoint(0F, 10F, 2F);
		setRotation(midtail1, 0F, 0F, 0F);
		midtail2 = new ModelRenderer(this, 64, 29);
		midtail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		midtail2.setRotationPoint(0F, 10F, 7F);
		setRotation(midtail2, 0F, 0F, 0F);
		midlefttail1 = new ModelRenderer(this, 64, 20);
		midlefttail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		midlefttail1.setRotationPoint(2F, 10F, 2F);
		setRotation(midlefttail1, 0F, 0F, 0F);
		midlefttail2 = new ModelRenderer(this, 64, 29);
		midlefttail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		midlefttail2.setRotationPoint(2F, 10F, 7F);
		setRotation(midlefttail2, 0F, 0F, 0F);
		bottomrighttail1 = new ModelRenderer(this, 64, 20);
		bottomrighttail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		bottomrighttail1.setRotationPoint(-2F, 12F, 2F);
		setRotation(bottomrighttail1, 0F, 0F, 0F);
		bottomrighttail2 = new ModelRenderer(this, 64, 29);
		bottomrighttail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		bottomrighttail2.setRotationPoint(-2F, 12F, 7F);
		setRotation(bottomrighttail2, 0F, 0F, 0F);
		bottomtail1 = new ModelRenderer(this, 64, 20);
		bottomtail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		bottomtail1.setRotationPoint(0F, 12F, 2F);
		setRotation(bottomtail1, 0F, 0F, 0F);
		bottomtail2 = new ModelRenderer(this, 64, 29);
		bottomtail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		bottomtail2.setRotationPoint(0F, 12F, 7F);
		setRotation(bottomtail2, 0F, 0F, 0F);
		bottomlefttail1 = new ModelRenderer(this, 64, 20);
		bottomlefttail1.addBox(-2F, -2F, 0F, 4, 4, 5);
		bottomlefttail1.setRotationPoint(2F, 12F, 2F);
		setRotation(bottomlefttail1, 0F, 0F, 0F);
		bottomlefttail2 = new ModelRenderer(this, 64, 29);
		bottomlefttail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 4);
		bottomlefttail2.setRotationPoint(2F, 12F, 7F);
		setRotation(bottomlefttail2, 0F, 0F, 0F);
		rightlegcloth = new ModelRenderer(this, 86, 0);
		rightlegcloth.addBox(-2F, -1F, -2F, 4, 4, 4);
		rightlegcloth.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightlegcloth, 0F, 0F, 0F);
		leftlegcloth = new ModelRenderer(this, 86, 0);
		leftlegcloth.mirror = true;
		leftlegcloth.addBox(-2F, -1F, -2F, 4, 4, 4);
		leftlegcloth.setRotationPoint(2F, 11F, 0F);
		setRotation(leftlegcloth, 0F, 0F, 0F);
		rightsandal = new ModelRenderer(this, 86, 8);
		rightsandal.addBox(-1.5F, 11F, -2F, 3, 1, 4);
		rightsandal.setRotationPoint(-2F, 11F, 0F);
		rightsandal.mirror = true;
		setRotation(rightsandal, 0F, -0.0872665F, -0.0349066F);
		leftsandal = new ModelRenderer(this, 86, 8);
		leftsandal.addBox(-1.5F, 11F, -2F, 3, 1, 4);
		leftsandal.setRotationPoint(2F, 11F, 0F);
		setRotation(leftsandal, 0F, 0.0872665F, 0.0349066F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);

		convertToChild(rightarm, rightarmclothupper);
		convertToChild(rightarm, rightarmcloth);
		convertToChild(leftarm, leftarmclothupper);
		convertToChild(leftarm, leftarmcloth);

		convertToChild(toprighttail1, toprighttail2);
		convertToChild(toptail1, toptail2);
		convertToChild(toplefttail1, toplefttail2);
		convertToChild(midrighttail1, midrighttail2);
		convertToChild(midtail1, midtail2);
		convertToChild(midlefttail1, midlefttail2);
		convertToChild(bottomrighttail1, bottomrighttail2);
		convertToChild(bottomtail1, bottomtail2);
		convertToChild(bottomlefttail1, bottomlefttail2);

		convertToChild(rightleg, rightlegcloth);
		convertToChild(leftleg, leftlegcloth);
		convertToChild(rightleg, rightsandal);
		convertToChild(leftleg, leftsandal);
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
		rightleg.render(scale);
		leftleg.render(scale);
		hair1.render(scale);
		hair2.render(scale);
		tie.render(scale);
		toprighttail1.render(scale);
		toptail1.render(scale);
		toplefttail1.render(scale);
		midrighttail1.render(scale);
		midtail1.render(scale);
		midlefttail1.render(scale);
		bottomrighttail1.render(scale);
		bottomtail1.render(scale);
		bottomlefttail1.render(scale);

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
		hair1.rotateAngleY = head.rotateAngleY;
		hair2.rotateAngleY = head.rotateAngleY;

		// arms
		if (itemstack.isEmpty()) {
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
		}

		if (itemstack.getItem() == Items.ARROW) {
			animationThrow();
		}

		// body
		float chestDefaultRotateAngleX = 0.7853982F;

		rightchest.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount) + chestDefaultRotateAngleX;
		leftchest.rotateAngleX = rightchest.rotateAngleX;

		float topAngleX = 30;
		float topAngleY = 20;
		toprighttail1.rotateAngleX = +degToRad(topAngleX);
		toprighttail2.rotateAngleX = +degToRad(topAngleX);
		toprighttail1.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(1);
		toprighttail2.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		toptail1.rotateAngleX = +degToRad(topAngleX + 15);
		toptail2.rotateAngleX = +degToRad(topAngleX);
		toptail1.rotateAngleY = toprighttail1.rotateAngleY;
		toptail2.rotateAngleY = toprighttail2.rotateAngleY;
		toplefttail1.rotateAngleX = +degToRad(topAngleX);
		toplefttail2.rotateAngleX = +degToRad(topAngleX);
		toplefttail1.rotateAngleY = toprighttail1.rotateAngleY;
		toplefttail2.rotateAngleY = toprighttail2.rotateAngleY;

		float midAngleX = 15;
		float midAngleY = 40;
		midrighttail1.rotateAngleX = +degToRad(midAngleX);
		midrighttail2.rotateAngleX = +degToRad(midAngleX);
		midrighttail1.rotateAngleY = toprighttail1.rotateAngleY - degToRad(midAngleY);
		midrighttail2.rotateAngleY = toprighttail2.rotateAngleY;
		midtail1.rotateAngleX = +degToRad(midAngleX + 10);
		midtail2.rotateAngleX = +degToRad(midAngleX);
		midtail1.rotateAngleY = toprighttail1.rotateAngleY;
		midtail2.rotateAngleY = toprighttail2.rotateAngleY;
		midlefttail1.rotateAngleX = +degToRad(midAngleX);
		midlefttail2.rotateAngleX = +degToRad(midAngleX);
		midlefttail1.rotateAngleY = toprighttail1.rotateAngleY + degToRad(midAngleY);
		midlefttail2.rotateAngleY = toprighttail2.rotateAngleY;

		float bottomAngleX = 5;
		float bottomAngleY = 60;
		bottomrighttail1.rotateAngleX = +degToRad(bottomAngleX);
		bottomrighttail2.rotateAngleX = +degToRad(bottomAngleX);
		bottomrighttail1.rotateAngleY = toprighttail1.rotateAngleY - degToRad(bottomAngleY);
		bottomrighttail2.rotateAngleY = toprighttail2.rotateAngleY;
		bottomtail1.rotateAngleX = +degToRad(bottomAngleX + 5);
		bottomtail2.rotateAngleX = +degToRad(bottomAngleX);
		bottomtail1.rotateAngleY = toprighttail1.rotateAngleY;
		bottomtail2.rotateAngleY = toprighttail2.rotateAngleY;
		bottomlefttail1.rotateAngleX = +degToRad(bottomAngleX);
		bottomlefttail2.rotateAngleX = +degToRad(bottomAngleX);
		bottomlefttail1.rotateAngleY = toprighttail1.rotateAngleY + degToRad(bottomAngleY);
		bottomlefttail2.rotateAngleY = toprighttail2.rotateAngleY;

		toprighttail1.rotateAngleY = -degToRad(topAngleY);
		toplefttail1.rotateAngleY = +degToRad(topAngleY);

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.1F * limbSwingAmount;
        rightleg.rotateAngleY = -0.0872665F;
        leftleg.rotateAngleY = 0.0872665F;
        rightleg.rotateAngleZ = -0.0349066F;
        leftleg.rotateAngleZ = 0.0349066F;
		
		if (isRiding) {
			rightarm.rotateAngleX += -((float) Math.PI / 5F);
			leftarm.rotateAngleX += -((float) Math.PI / 5F);
			rightleg.rotateAngleX = -1.4137167F;
			rightleg.rotateAngleY = ((float) Math.PI / 10F);
			rightleg.rotateAngleZ = 0.07853982F;
			leftleg.rotateAngleX = -1.4137167F;
			leftleg.rotateAngleY = -((float) Math.PI / 10F);
			leftleg.rotateAngleZ = -0.07853982F;
		}
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
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
