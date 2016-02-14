package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSwamper extends ModelBase {
	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer bodyback;
	ModelRenderer bodyfront;
	ModelRenderer bodymid;
	ModelRenderer rightpauldron;
	ModelRenderer rightarm;
	ModelRenderer rightarmlower;
	ModelRenderer leftpauldron;
	ModelRenderer leftarm;
	ModelRenderer leftarmlower;
	ModelRenderer waist;
	ModelRenderer rightleg;
	ModelRenderer rightfoot;
	ModelRenderer leftleg;
	ModelRenderer leftfoot;

	public ModelGaiaSwamper() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -7F, -4F, 6, 6, 6);
		this.head.setRotationPoint(0F, 2F, -4F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(head, 0.1745329F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 32, 0);
		this.headaccessory.addBox(-3.5F, -7.5F, -4.5F, 7, 9, 7);
		this.headaccessory.setRotationPoint(0F, 2F, -4F);
		this.headaccessory.setTextureSize(64, 32);
		this.headaccessory.mirror = true;
		this.setRotation(headaccessory, 0.1745329F, 0F, 0F);
		this.bodyback = new ModelRenderer(this, 32, 27);
		this.bodyback.addBox(-7F, -2F, 1F, 14, 8, 5);
		this.bodyback.setRotationPoint(0F, 0F, -3F);
		this.bodyback.setTextureSize(64, 32);
		this.bodyback.mirror = true;
		this.setRotation(bodyback, 0.3490659F, 0F, 0F);
		this.bodyfront = new ModelRenderer(this, 32, 16);
		this.bodyfront.addBox(-5.5F, -1F, -3F, 11, 7, 4);
		this.bodyfront.setRotationPoint(0F, -1F, -3F);
		this.bodyfront.setTextureSize(64, 32);
		this.bodyfront.mirror = true;
		this.setRotation(bodyfront, 0.3490659F, 0F, 0F);
		this.bodymid = new ModelRenderer(this, 32, 40);
		this.bodymid.addBox(-4F, 4F, 0F, 8, 6, 6);
		this.bodymid.setRotationPoint(0F, 0F, -3F);
		this.bodymid.setTextureSize(64, 32);
		this.bodymid.mirror = true;
		this.setRotation(bodymid, 0.1745329F, 0F, 0F);
		this.rightpauldron = new ModelRenderer(this, 70, 0);
		this.rightpauldron.addBox(-2.5F, -5F, -2.5F, 5, 5, 5);
		this.rightpauldron.setRotationPoint(-6F, 2F, -1F);
		this.rightpauldron.setTextureSize(64, 32);
		this.rightpauldron.mirror = true;
		this.setRotation(rightpauldron, 0.3490659F, 0F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 70, 10);
		this.rightarm.addBox(-3F, -2F, -1.5F, 3, 8, 3);
		this.rightarm.setRotationPoint(-6F, 2F, -1F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0.5235988F, -0.2617994F, 0.0872665F);
		this.rightarmlower = new ModelRenderer(this, 70, 21);
		this.rightarmlower.addBox(-3F, 2.5F, 3.5F, 3, 10, 3);
		this.rightarmlower.setRotationPoint(-6F, 2F, -1F);
		this.rightarmlower.setTextureSize(64, 32);
		this.rightarmlower.mirror = true;
		this.setRotation(rightarmlower, -0.5235988F, -0.2617994F, 0.0872665F);
		this.leftpauldron = new ModelRenderer(this, 90, 0);
		this.leftpauldron.addBox(-2.5F, -5F, -2.5F, 5, 5, 5);
		this.leftpauldron.setRotationPoint(6F, 2F, -1F);
		this.leftpauldron.setTextureSize(64, 32);
		this.leftpauldron.mirror = true;
		this.setRotation(leftpauldron, 0.3490659F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 70, 10);
		this.leftarm.addBox(0F, -2F, -1.5F, 3, 8, 3);
		this.leftarm.setRotationPoint(6F, 2F, -1F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0.5235988F, 0.2617994F, -0.0872665F);
		this.leftarmlower = new ModelRenderer(this, 82, 21);
		this.leftarmlower.addBox(0F, 2.5F, 3.5F, 3, 10, 3);
		this.leftarmlower.setRotationPoint(6F, 2F, -1F);
		this.leftarmlower.setTextureSize(64, 32);
		this.leftarmlower.mirror = true;
		this.setRotation(leftarmlower, -0.5235988F, 0.2617994F, -0.0872665F);
		this.waist = new ModelRenderer(this, 32, 52);
		this.waist.addBox(-3F, 10F, 3F, 6, 5, 5);
		this.waist.setRotationPoint(0F, -1F, -3.5F);
		this.waist.setTextureSize(64, 32);
		this.waist.mirror = true;
		this.setRotation(waist, 0F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 70, 34);
		this.rightleg.addBox(-1.5F, 0F, -1.5F, 3, 7, 3);
		this.rightleg.setRotationPoint(-2.5F, 11F, 2F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, -0.2617994F, 0F, 0.0349066F);
		this.rightfoot = new ModelRenderer(this, 70, 44);
		this.rightfoot.addBox(-1.5F, 5F, -1.5F, 3, 8, 3);
		this.rightfoot.setRotationPoint(-2.5F, 11F, 2F);
		this.rightfoot.setTextureSize(64, 32);
		this.rightfoot.mirror = true;
		this.setRotation(rightfoot, -0.0872665F, 0F, 0.0349066F);
		this.leftleg = new ModelRenderer(this, 70, 34);
		this.leftleg.addBox(-1.5F, 0F, -1.5F, 3, 7, 3);
		this.leftleg.setRotationPoint(2.5F, 11F, 2F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, -0.2617994F, 0F, -0.0349066F);
		this.leftfoot = new ModelRenderer(this, 70, 44);
		this.leftfoot.addBox(-1.5F, 5F, -1.5F, 3, 8, 3);
		this.leftfoot.setRotationPoint(2.5F, 11F, 2F);
		this.leftfoot.setTextureSize(64, 32);
		this.leftfoot.mirror = true;
		this.setRotation(leftfoot, -0.0872665F, 0F, -0.0349066F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.bodyback.render(par7);
		this.bodyfront.render(par7);
		this.bodymid.render(par7);
		this.rightpauldron.render(par7);
		this.rightarm.render(par7);
		this.rightarmlower.render(par7);
		this.leftpauldron.render(par7);
		this.leftarm.render(par7);
		this.leftarmlower.render(par7);
		this.waist.render(par7);
		this.rightleg.render(par7);
		this.rightfoot.render(par7);
		this.leftleg.render(par7);
		this.leftfoot.render(par7);
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
		this.rightpauldron.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftpauldron.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.rightarm.rotateAngleX = this.rightpauldron.rotateAngleX + 0.5235988F;
		this.leftarm.rotateAngleX = this.leftpauldron.rotateAngleX +  0.5235988F;
		this.rightarmlower.rotateAngleX = this.rightpauldron.rotateAngleX - 0.5235988F;
		this.leftarmlower.rotateAngleX = this.leftpauldron.rotateAngleX - 0.5235988F;
		this.rightpauldron.rotateAngleX += 0.3490659F;
		this.leftpauldron.rotateAngleX += 0.3490659F;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX - 0.0872665F;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX - 0.0872665F;
		this.rightleg.rotateAngleX -= 0.2617994F;
		this.leftleg.rotateAngleX -= 0.2617994F;
	}
}
