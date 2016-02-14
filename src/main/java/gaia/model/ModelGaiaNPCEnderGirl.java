package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNPCEnderGirl extends ModelBase {

	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer hair;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer waist;
	ModelRenderer rightleg;
	ModelRenderer leftleg;

	public ModelGaiaNPCEnderGirl() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, -3F, 0F);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, -3F, 0F);
		headaccessory.setTextureSize(128, 64);
		headaccessory.mirror = true;
		setRotation(headaccessory, 0F, 0F, 0F);
		hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-3.5F, -3.5F, -3.5F, 7, 12, 7);
		hair.setRotationPoint(0F, -3F, 0F);
		hair.setTextureSize(128, 64);
		hair.mirror = true;
		setRotation(hair, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 12);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 5, 3);
		bodytop.setRotationPoint(0F, -3F, 0F);
		bodytop.setTextureSize(128, 64);
		bodytop.mirror = true;
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 20);
		bodymiddle.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, -3F, 0F);
		bodymiddle.setTextureSize(128, 64);
		bodymiddle.mirror = true;
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 20);
		bodymiddlebutton.addBox(-0.5F, 5F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, -3F, 0F);
		bodymiddlebutton.setTextureSize(128, 64);
		bodymiddlebutton.mirror = true;
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 25);
		bodybottom.addBox(-2.5F, 7F, -2.5F, 5, 4, 3);
		bodybottom.setRotationPoint(0F, -3F, 0F);
		bodybottom.setTextureSize(128, 64);
		bodybottom.mirror = true;
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 32);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, -1F, -1.5F);
		rightchest.setTextureSize(128, 64);
		rightchest.mirror = true;
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 8, 32);
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, -1F, -1.5F);
		leftchest.setTextureSize(128, 64);
		leftchest.mirror = true;
		setRotation(leftchest, -0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, -2F, 0F);
		rightarm.setTextureSize(128, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0.0872665F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, -2F, 0F);
		leftarm.setTextureSize(128, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, -0.0872665F);
		waist = new ModelRenderer(this, 36, 33);
		waist.addBox(-3F, 9F, -2F, 6, 2, 4);
		waist.setRotationPoint(0F, -1F, 0F);
		waist.setTextureSize(128, 64);
		waist.mirror = true;
		setRotation(waist, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1F, 0F, -1F, 2, 15, 2);
		rightleg.setRotationPoint(-1.5F, 9F, 0F);
		rightleg.setTextureSize(128, 64);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1F, 0F, -1F, 2, 15, 2);
		leftleg.setRotationPoint(1.5F, 9F, 0F);
		leftleg.setTextureSize(128, 64);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		head.render(par7);
		headaccessory.render(par7);
		hair.render(par7);
		bodytop.render(par7);
		bodymiddle.render(par7);
		bodymiddlebutton.render(par7);
		bodybottom.render(par7);
		rightchest.render(par7);
		leftchest.render(par7);
		rightarm.render(par7);
		leftarm.render(par7);
		waist.render(par7);
		rightleg.render(par7);
		leftleg.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.hair.rotateAngleX = head.rotateAngleX;
		this.hair.rotateAngleY = this.head.rotateAngleY;
		this.hair.rotateAngleX = this.head.rotateAngleX;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
	}
}
