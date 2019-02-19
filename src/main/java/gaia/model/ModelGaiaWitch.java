package gaia.model;

import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaWitch extends ModelGaia {
	private ModelRenderer anchor;
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer broompumpkin;

	public ModelGaiaWitch() {
		textureWidth = 128;
		textureHeight = 64;

		float rotationPointZ = -2F;

		anchor = new ModelRenderer(this, 0, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(-1.5F, 10F, 4F + rotationPointZ);
		anchor.setTextureSize(64, 32);
		setRotation(anchor, 0F, 0F, 0F);

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		ModelRenderer neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		ModelRenderer bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, 0.4363323F, 0F, 0F);
		ModelRenderer bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -0.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0.3490659F, 0F, 0F);
		ModelRenderer bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -0.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0.3490659F, 0F, 0F);
		ModelRenderer bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -1F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.3490659F, 0F, 0F);
		ModelRenderer rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -0.5F + rotationPointZ);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 1.22173F, -0.1745329F, 0F);
		ModelRenderer leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -0.5F + rotationPointZ);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 1.22173F, 0.1745329F, 0F);
		ModelRenderer rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F + rotationPointZ);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, -0.6981317F, -0.3490659F, 0F);
		ModelRenderer leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F + rotationPointZ);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, -0.6981317F, 0.3490659F, 0F);
		ModelRenderer rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, 0F, -1.5F, 3, 6, 3);
		rightleg.setRotationPoint(-2F, 10F, 4F + rotationPointZ);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -0.9599311F, 0F, -0.0872665F);
		ModelRenderer leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, 0F, -1F, 3, 6, 3);
		leftleg.setRotationPoint(2F, 10F, 4F + rotationPointZ);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -0.6981317F, 0F, 0.0872665F);
		ModelRenderer hat1 = new ModelRenderer(this, 36, 14);
		hat1.addBox(-5F, -5F, -7F, 14, 2, 14);
		hat1.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		hat1.setTextureSize(64, 32);
		setRotation(hat1, 0F, 0F, -0.5235988F);
		ModelRenderer hat2 = new ModelRenderer(this, 36, 30);
		hat2.addBox(-2F, -10F, -4F, 8, 5, 8);
		hat2.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		hat2.setTextureSize(64, 32);
		setRotation(hat2, 0F, 0F, -0.5235988F);
		ModelRenderer hat3 = new ModelRenderer(this, 68, 30);
		hat3.addBox(1F, -12F, -1F, 6, 4, 6);
		hat3.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		hat3.setTextureSize(64, 32);
		setRotation(hat3, 0F, 0F, -0.5235988F);
		ModelRenderer hat4 = new ModelRenderer(this, 36, 43);
		hat4.addBox(4F, -13F, 2F, 4, 4, 4);
		hat4.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		hat4.setTextureSize(64, 32);
		setRotation(hat4, 0F, 0F, -0.5235988F);
		ModelRenderer hat5 = new ModelRenderer(this, 52, 43);
		hat5.addBox(6F, -11F, 4F, 3, 3, 3);
		hat5.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		hat5.setTextureSize(64, 32);
		setRotation(hat5, 0F, 0F, -0.5235988F);
		ModelRenderer hat6 = new ModelRenderer(this, 36, 51);
		hat6.addBox(8F, -9F, 6F, 2, 2, 2);
		hat6.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		hat6.setTextureSize(64, 32);
		setRotation(hat6, 0F, 0F, -0.5235988F);
		ModelRenderer amulet = new ModelRenderer(this, 36, 55);
		amulet.addBox(-1F, 0F, -3.5F, 2, 2, 2);
		amulet.setRotationPoint(0F, 1F, 0F);
		amulet.setTextureSize(64, 32);
		setRotation(amulet, 0.4363323F, 0F, 0F);
		ModelRenderer mantle1 = new ModelRenderer(this, 92, 0);
		mantle1.addBox(-5F, -1F, -1.5F, 10, 6, 3);
		mantle1.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		mantle1.setTextureSize(64, 32);
		setRotation(mantle1, 0.8726646F, 0F, 0F);
		ModelRenderer mantle2 = new ModelRenderer(this, 92, 9);
		mantle2.addBox(-4.5F, 2F, -1F, 9, 10, 3);
		mantle2.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		mantle2.setTextureSize(64, 32);
		setRotation(mantle2, 0.6108652F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 24, 21);
		rightleglower.addBox(-1.5F, -0.5F, -7F, 3, 6, 3);
		rightleglower.setRotationPoint(-2F, 10F, 4F + rotationPointZ);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, 0.6108652F, 0F, -0.0872665F);
		ModelRenderer leftleglower = new ModelRenderer(this, 24, 21);
		leftleglower.addBox(-1.5F, 0F, -7F, 3, 6, 3);
		leftleglower.setRotationPoint(2F, 10F, 4F + rotationPointZ);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, 0.8726646F, 0F, 0.0872665F);
		ModelRenderer skirt1 = new ModelRenderer(this, 92, 22);
		skirt1.addBox(-3.5F, 7.5F, -2.5F, 7, 2, 6);
		skirt1.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		skirt1.setTextureSize(64, 32);
		setRotation(skirt1, 0.3490659F, 0F, 0F);
		ModelRenderer skirt2 = new ModelRenderer(this, 92, 30);
		skirt2.addBox(-4F, 8.5F, -3F, 8, 4, 7);
		skirt2.setRotationPoint(0F, 1F, 0F + rotationPointZ);
		skirt2.setTextureSize(64, 32);
		setRotation(skirt2, 0.3316126F, 0F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 92, 41);
		rightfoot.addBox(-2F, 1.5F, -7.5F, 4, 4, 4);
		rightfoot.setRotationPoint(-2F, 10F, 4F + rotationPointZ);
		rightfoot.setTextureSize(64, 32);
		setRotation(rightfoot, 0.6108652F, 0F, -0.0872665F);
		ModelRenderer leftfoot = new ModelRenderer(this, 92, 41);
		leftfoot.addBox(-2F, 2F, -7.5F, 4, 4, 4);
		leftfoot.setRotationPoint(2F, 10F, 4F + rotationPointZ);
		leftfoot.setTextureSize(64, 32);
		setRotation(leftfoot, 0.8726646F, 0F, 0.0872665F);
		ModelRenderer broomstick = new ModelRenderer(this, 122, 0);
		broomstick.addBox(1F, -12.5F, -1.5F, 1, 20, 1);
		broomstick.setRotationPoint(-1.5F, 10F, 4F + rotationPointZ);
		broomstick.setTextureSize(64, 32);
		setRotation(broomstick, 1.570796F, 0F, 0F);
		ModelRenderer broom = new ModelRenderer(this, 92, 49);
		broom.addBox(0F, 6.5F, -2.5F, 3, 10, 3);
		broom.setRotationPoint(-1.5F, 10F, 4F + rotationPointZ);
		broom.setTextureSize(64, 32);
		setRotation(broom, 1.570796F, 0F, 0F);
		broompumpkin = new ModelRenderer(this, 104, 49);
		broompumpkin.addBox(0F, 2.5F, 6.5F, 3, 3, 3);
		broompumpkin.setRotationPoint(-1.5F, 10F, 4F + rotationPointZ);
		broompumpkin.setTextureSize(64, 32);
		setRotation(broompumpkin, 0F, 0F, 0F);

		anchor.addChild(head);
		anchor.addChild(headeyes);
		anchor.addChild(headaccessory);
		anchor.addChild(neck);
		anchor.addChild(bodytop);
		anchor.addChild(bodymiddle);
		anchor.addChild(bodymiddlebutton);
		anchor.addChild(bodybottom);
		anchor.addChild(rightchest);
		anchor.addChild(leftchest);
		anchor.addChild(rightarm);
		anchor.addChild(leftarm);
		anchor.addChild(rightleg);
		anchor.addChild(leftleg);
		convertToChild(head, hat1);
		convertToChild(head, hat2);
		convertToChild(head, hat3);
		convertToChild(head, hat4);
		convertToChild(head, hat5);
		convertToChild(head, hat6);
		anchor.addChild(amulet);
		anchor.addChild(mantle1);
		anchor.addChild(mantle2);
		anchor.addChild(rightleglower);
		anchor.addChild(leftleglower);
		anchor.addChild(skirt1);
		anchor.addChild(skirt2);
		anchor.addChild(rightfoot);
		anchor.addChild(leftfoot);
		anchor.addChild(broomstick);
		anchor.addChild(broom);
		anchor.addChild(broompumpkin);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// anchor
		anchor.rotationPointY = -2.0F + MathHelper.cos((1.5F + ageInTicks) * 0.5F) * 0.5F;
		anchor.rotateAngleZ = (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount) * 0.05F;

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		headeyes.showModel = entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F;

		// body
		broompumpkin.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
	}

	public ModelRenderer getAnchor() {
		return anchor;
	}
}
