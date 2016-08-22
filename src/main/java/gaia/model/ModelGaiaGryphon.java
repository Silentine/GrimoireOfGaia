package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaGryphon extends ModelBase {
	ModelRenderer head;
	ModelRenderer eyes;
	ModelRenderer beak;
	ModelRenderer neck1;
	ModelRenderer neck2;
	ModelRenderer rightwing;
	ModelRenderer leftwing;
	ModelRenderer body1;
	ModelRenderer armor;
	ModelRenderer body2;
	ModelRenderer frontrightleg1;
	ModelRenderer frontrightpauldron;
	ModelRenderer frontrightleg2;
	ModelRenderer frontrightclaw;
	ModelRenderer frontleftleg1;
	ModelRenderer frontleftpauldron;
	ModelRenderer frontleftleg2;
	ModelRenderer frontleftclaw;
	ModelRenderer backrightleg1;
	ModelRenderer backrightleg2;
	ModelRenderer backrightleg3;
	ModelRenderer backrightfoot;
	ModelRenderer backleftleg1;
	ModelRenderer backleftleg2;
	ModelRenderer backleftleg3;
	ModelRenderer backleftfoot;
	ModelRenderer tail;

	public ModelGaiaGryphon() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-2.5F, -9.5F, -7.5F, 5, 5, 5);
		this.head.setRotationPoint(0F, 8F, -7F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0.1745329F, 0F, 0F);
		this.eyes = new ModelRenderer(this, 0, 10);
		this.eyes.addBox(-2F, -11.5F, -7F, 4, 3, 4);
		this.eyes.setRotationPoint(0F, 8F, -7F);
		this.eyes.setTextureSize(64, 32);
		this.setRotation(eyes, 0.6108652F, 0F, 0F);
		this.beak = new ModelRenderer(this, 0, 17);
		this.beak.addBox(-1.5F, -7.5F, -11.5F, 3, 3, 4);
		this.beak.setRotationPoint(0F, 8F, -7F);
		this.beak.setTextureSize(64, 32);
		this.setRotation(beak, 0.1745329F, 0F, 0F);
		this.neck1 = new ModelRenderer(this, 0, 24);
		this.neck1.addBox(-3F, -9F, -3.5F, 6, 6, 6);
		this.neck1.setRotationPoint(0F, 8F, -7F);
		this.neck1.setTextureSize(64, 32);
		this.setRotation(neck1, 0.6108652F, 0F, 0F);
		this.neck2 = new ModelRenderer(this, 0, 36);
		this.neck2.addBox(-3.5F, -4.5F, -4F, 7, 8, 7);
		this.neck2.setRotationPoint(0F, 8F, -7F);
		this.neck2.setTextureSize(64, 32);
		this.setRotation(neck2, 0.4363323F, 0F, 0F);
		this.rightwing = new ModelRenderer(this, 98, 38);
		this.rightwing.addBox(0F, 0F, 0F, 0, 16, 10);
		this.rightwing.setRotationPoint(-4F, 7F, -6F);
		this.rightwing.setTextureSize(64, 32);
		this.setRotation(rightwing, 1.047198F, -0.1745329F, 0.2617994F);
		this.leftwing = new ModelRenderer(this, 108, 38);
		this.leftwing.addBox(0F, 0F, 0F, 0, 16, 10);
		this.leftwing.setRotationPoint(4F, 7F, -6F);
		this.leftwing.setTextureSize(64, 32);
		this.setRotation(leftwing, 1.047198F, 0.1745329F, -0.2617994F);
		this.body1 = new ModelRenderer(this, 28, 0);
		this.body1.addBox(-4F, -4F, -8F, 8, 9, 10);
		this.body1.setRotationPoint(0F, 8F, -3F);
		this.body1.setTextureSize(64, 32);
		this.setRotation(body1, 1.22173F, 0F, 0F);
		this.armor = new ModelRenderer(this, 82, 0);
		this.armor.addBox(-4F, -1F, -9F, 8, 9, 4);
		this.armor.setRotationPoint(0F, 8F, -3F);
		this.armor.setTextureSize(64, 32);
		this.setRotation(armor, 0.1745329F, 0F, 0F);
		this.body2 = new ModelRenderer(this, 28, 19);
		this.body2.addBox(-3F, 1F, -8F, 6, 12, 8);
		this.body2.setRotationPoint(0F, 8F, -3F);
		this.body2.setTextureSize(64, 32);
		this.setRotation(body2, 1.658063F, 0F, 0F);
		this.frontrightleg1 = new ModelRenderer(this, 64, 0);
		this.frontrightleg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		this.frontrightleg1.setRotationPoint(-4F, 9F, -6F);
		this.frontrightleg1.setTextureSize(64, 32);
		this.setRotation(frontrightleg1, 0.1745329F, 0F, -0.0349066F);
		this.frontrightpauldron = new ModelRenderer(this, 82, 13);
		this.frontrightpauldron.addBox(-2F, -1F, -2F, 4, 6, 4);
		this.frontrightpauldron.setRotationPoint(-4F, 9F, -6F);
		this.frontrightpauldron.setTextureSize(64, 32);
		this.setRotation(frontrightpauldron, 0.1745329F, 0F, 0.1745329F);
		this.frontrightleg2 = new ModelRenderer(this, 64, 11);
		this.frontrightleg2.addBox(-1F, 7F, 2F, 2, 7, 2);
		this.frontrightleg2.setRotationPoint(-4F, 9F, -6F);
		this.frontrightleg2.setTextureSize(64, 32);
		this.setRotation(frontrightleg2, -0.1745329F, 0F, -0.0349066F);
		this.frontrightclaw = new ModelRenderer(this, 64, 20);
		this.frontrightclaw.addBox(-2F, 14F, -4F, 4, 1, 4);
		this.frontrightclaw.setRotationPoint(-4F, 9F, -6F);
		this.frontrightclaw.setTextureSize(64, 32);
		this.setRotation(frontrightclaw, 0.0872665F, 0F, -0.0349066F);
		this.frontleftleg1 = new ModelRenderer(this, 64, 0);
		this.frontleftleg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		this.frontleftleg1.setRotationPoint(4F, 9F, -6F);
		this.frontleftleg1.setTextureSize(64, 32);
		this.setRotation(frontleftleg1, 0.1745329F, 0F, 0.0349066F);
		this.frontleftpauldron = new ModelRenderer(this, 82, 13);
		this.frontleftpauldron.addBox(-2F, -1F, -2F, 4, 6, 4);
		this.frontleftpauldron.setRotationPoint(4F, 9F, -6F);
		this.frontleftpauldron.setTextureSize(64, 32);
		this.setRotation(frontleftpauldron, 0.1745329F, 0F, -0.1745329F);
		this.frontleftleg2 = new ModelRenderer(this, 64, 11);
		this.frontleftleg2.addBox(-1F, 7F, 2F, 2, 7, 2);
		this.frontleftleg2.setRotationPoint(4F, 9F, -6F);
		this.frontleftleg2.setTextureSize(64, 32);
		this.setRotation(frontleftleg2, -0.1745329F, 0F, 0.0349066F);
		this.frontleftclaw = new ModelRenderer(this, 64, 20);
		this.frontleftclaw.addBox(-2F, 14F, -4F, 4, 1, 4);
		this.frontleftclaw.setRotationPoint(4F, 9F, -6F);
		this.frontleftclaw.setTextureSize(64, 32);
		this.setRotation(frontleftclaw, 0.0872665F, 0F, 0.0349066F);
		this.backrightleg1 = new ModelRenderer(this, 64, 25);
		this.backrightleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
		this.backrightleg1.setRotationPoint(-3F, 8F, 9F);
		this.backrightleg1.setTextureSize(64, 32);
		this.setRotation(backrightleg1, -0.296706F, 0F, -0.0349066F);
		this.backrightleg2 = new ModelRenderer(this, 64, 39);
		this.backrightleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
		this.backrightleg2.setRotationPoint(-3F, 8F, 9F);
		this.backrightleg2.setTextureSize(64, 32);
		this.setRotation(backrightleg2, -0.8726646F, 0F, -0.0349066F);
		this.backrightleg3 = new ModelRenderer(this, 64, 48);
		this.backrightleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
		this.backrightleg3.setRotationPoint(-3F, 8F, 9F);
		this.backrightleg3.setTextureSize(64, 32);
		this.setRotation(backrightleg3, -0.2617994F, 0F, -0.0349066F);
		this.backrightfoot = new ModelRenderer(this, 64, 57);
		this.backrightfoot.addBox(-1.5F, 14F, -5F, 3, 2, 3);
		this.backrightfoot.setRotationPoint(-3F, 8F, 9F);
		this.backrightfoot.setTextureSize(64, 32);
		this.setRotation(backrightfoot, 0.0872665F, 0F, -0.0349066F);
		this.backleftleg1 = new ModelRenderer(this, 64, 25);
		this.backleftleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
		this.backleftleg1.setRotationPoint(3F, 8F, 9F);
		this.backleftleg1.setTextureSize(64, 32);
		this.setRotation(backleftleg1, -0.296706F, 0F, 0.0349066F);
		this.backleftleg2 = new ModelRenderer(this, 64, 39);
		this.backleftleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
		this.backleftleg2.setRotationPoint(3F, 8F, 9F);
		this.backleftleg2.setTextureSize(64, 32);
		this.setRotation(backleftleg2, -0.8726646F, 0F, 0.0349066F);
		this.backleftleg3 = new ModelRenderer(this, 64, 48);
		this.backleftleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
		this.backleftleg3.setRotationPoint(3F, 8F, 9F);
		this.backleftleg3.setTextureSize(64, 32);
		this.setRotation(backleftleg3, -0.2617994F, 0F, 0.0349066F);
		this.backleftfoot = new ModelRenderer(this, 64, 57);
		this.backleftfoot.addBox(-1.5F, 14F, -5F, 3, 2, 3);
		this.backleftfoot.setRotationPoint(3F, 8F, 9F);
		this.backleftfoot.setTextureSize(64, 32);
		this.setRotation(backleftfoot, 0.0872665F, 0F, 0.0349066F);
		this.tail = new ModelRenderer(this, 28, 39);
		this.tail.addBox(-1F, 0F, -1F, 2, 14, 2);
		this.tail.setRotationPoint(0F, 8F, 10F);
		this.tail.setTextureSize(64, 32);
		this.setRotation(tail, 0.6108652F, 0F, 0F);
		
		this.convertToChild(head, eyes);
		this.convertToChild(head, beak);
		this.convertToChild(head, neck1);
		this.convertToChild(head, neck2);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
//		this.eyes.render(par7);
//		this.beak.render(par7);
//		this.neck1.render(par7);
//		this.neck2.render(par7);
		this.rightwing.render(par7);
		this.leftwing.render(par7);
		this.body1.render(par7);
		this.armor.render(par7);
		this.body2.render(par7);
		this.frontrightleg1.render(par7);
		this.frontrightpauldron.render(par7);
		this.frontrightleg2.render(par7);
		this.frontrightclaw.render(par7);
		this.frontleftleg1.render(par7);
		this.frontleftpauldron.render(par7);
		this.frontleftleg2.render(par7);
		this.frontleftclaw.render(par7);
		this.backrightleg1.render(par7);
		this.backrightleg2.render(par7);
		this.backrightleg3.render(par7);
		this.backrightfoot.render(par7);
		this.backleftleg1.render(par7);
		this.backleftleg2.render(par7);
		this.backleftleg3.render(par7);
		this.backleftfoot.render(par7);
		this.tail.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		
		//arms
		this.frontrightleg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.frontrightclaw.rotateAngleX = this.frontrightleg1.rotateAngleX + 0.0872665F;
		this.frontrightleg2.rotateAngleX = this.frontrightleg1.rotateAngleX - 0.1745329F;
		this.frontrightleg1.rotateAngleX += 0.1745329F;
		this.frontleftleg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
		this.frontleftclaw.rotateAngleX = this.frontleftleg1.rotateAngleX + 0.0872665F;
		this.frontleftleg2.rotateAngleX = this.frontleftleg1.rotateAngleX - 0.1745329F;
		this.frontleftleg1.rotateAngleX += 0.1745329F;
		
		//body
		this.rightwing.rotateAngleY = MathHelper.cos(par3 * 0.6662F + (float)Math.PI) * 1.0F * par2 * 0.5F;
		this.leftwing.rotateAngleY = MathHelper.cos(par3 * 0.6662F) * 1.0F * par2 * 0.5F;
		this.rightwing.rotateAngleY -= 0.1745329F;
		this.leftwing.rotateAngleY += 0.1745329F;
		
		//legs
		this.backrightleg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
		this.backleftleg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.backrightleg2.rotateAngleX = this.backrightleg1.rotateAngleX - 0.8726646F;
		this.backleftleg2.rotateAngleX = this.backleftleg1.rotateAngleX - 0.8726646F;
		this.backrightleg3.rotateAngleX = this.backrightleg1.rotateAngleX - 0.2617994F;
		this.backleftleg3.rotateAngleX = this.backleftleg1.rotateAngleX - 0.2617994F;
		this.backrightfoot.rotateAngleX = this.backrightleg1.rotateAngleX + 0.0872665F;
		this.backleftfoot.rotateAngleX = this.backleftleg1.rotateAngleX + 0.0872665F;
		this.backrightleg1.rotateAngleX -= 0.296706F;
		this.backleftleg1.rotateAngleX -= 0.296706F;
	}
	
	protected void convertToChild(ModelRenderer parParent, ModelRenderer parChild) {
		parChild.rotationPointX -= parParent.rotationPointX;
		parChild.rotationPointY -= parParent.rotationPointY;
		parChild.rotationPointZ -= parParent.rotationPointZ;
		parChild.rotateAngleX -= parParent.rotateAngleX;
		parChild.rotateAngleY -= parParent.rotateAngleY;
		parChild.rotateAngleZ -= parParent.rotateAngleZ;
		parParent.addChild(parChild);
	}
}
