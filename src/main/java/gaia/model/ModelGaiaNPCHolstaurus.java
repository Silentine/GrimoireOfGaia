package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNPCHolstaurus extends ModelBase {
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
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer horn;
	ModelRenderer righthorn;
	ModelRenderer lefthorn;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer bell;
	ModelRenderer waistupper;
	ModelRenderer rightwaist;
	ModelRenderer leftwaist;
	ModelRenderer tail;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer rightfoot;
	ModelRenderer leftfoot;

	public ModelGaiaNPCHolstaurus() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, 0F);
		this.headeyes.setTextureSize(128, 64);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(128, 64);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, 0F);
		this.neck.setTextureSize(128, 64);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(128, 64);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(128, 64);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(128, 64);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(128, 64);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
		this.rightchest.setRotationPoint(-1.5F, 3.5F, -2F);
		this.rightchest.setTextureSize(128, 64);
		this.setRotation(rightchest, 0.7853982F, 0.3490659F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
		this.leftchest.setRotationPoint(1.5F, 3.5F, -2F);
		this.leftchest.setTextureSize(128, 64);
		this.setRotation(leftchest, 0.7853982F, -0.3490659F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, 0F, 0F, -0.1745329F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		this.rightleg.setRotationPoint(-2F, 11F, -0.5F);
		this.rightleg.setTextureSize(128, 64);
		this.setRotation(rightleg, -0.1745329F, -0.1745329F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 22);
		this.leftleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		this.leftleg.setRotationPoint(2F, 11F, -0.5F);
		this.leftleg.setTextureSize(128, 64);
		this.setRotation(leftleg, -0.1745329F, 0.1745329F, 0F);
		this.hair1 = new ModelRenderer(this, 36, 14);
		this.hair1.addBox(-4F, -6F, 1F, 8, 4, 3);
		this.hair1.setRotationPoint(0F, 1F, 0F);
		this.hair1.setTextureSize(128, 64);
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 21);
		this.hair2.addBox(-4.5F, -3F, 1.5F, 9, 4, 3);
		this.hair2.setRotationPoint(0F, 1F, 0F);
		this.hair2.setTextureSize(128, 64);
		this.setRotation(hair2, 0F, 0F, 0F);
		this.horn = new ModelRenderer(this, 36, 28);
		this.horn.addBox(-4.5F, -7.5F, -0.5F, 9, 3, 2);
		this.horn.setRotationPoint(0F, 1F, 0F);
		this.horn.setTextureSize(128, 64);
		this.setRotation(horn, 0.3490659F, 0F, 0F);
		this.righthorn = new ModelRenderer(this, 36, 33);
		this.righthorn.addBox(-3.5F, -9.5F, -0.5F, 2, 2, 2);
		this.righthorn.setRotationPoint(0F, 1F, 0F);
		this.righthorn.setTextureSize(128, 64);
		this.setRotation(righthorn, 0.3490659F, 0F, 0F);
		this.lefthorn = new ModelRenderer(this, 36, 33);
		this.lefthorn.addBox(1.5F, -9.5F, -0.5F, 2, 2, 2);
		this.lefthorn.setRotationPoint(0F, 1F, 0F);
		this.lefthorn.setTextureSize(128, 64);
		this.setRotation(lefthorn, 0.3490659F, 0F, 0F);
		this.rightear = new ModelRenderer(this, 36, 33);
		this.rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		this.rightear.setRotationPoint(0F, 1F, 0F);
		this.rightear.setTextureSize(128, 64);
		this.setRotation(rightear, 0F, -0.5235988F, 0F);
		this.leftear = new ModelRenderer(this, 36, 33);
		this.leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		this.leftear.setRotationPoint(0F, 1F, 0F);
		this.leftear.setTextureSize(128, 64);
		this.setRotation(leftear, 0F, 0.5235988F, 0F);
		this.bell = new ModelRenderer(this, 36, 41);
		this.bell.addBox(-1F, 0F, -1.5F, 2, 2, 2);
		this.bell.setRotationPoint(0F, 3F, -1.5F);
		this.bell.setTextureSize(128, 64);
		this.setRotation(bell, -2.356194F, 0F, 0F);
		this.waistupper = new ModelRenderer(this, 36, 45);
		this.waistupper.addBox(-3F, 0F, -2F, 6, 9, 4);
		this.waistupper.setRotationPoint(0F, 1F, 0F);
		this.waistupper.setTextureSize(128, 64);
		this.setRotation(waistupper, -0.0872665F, 0F, 0F);
		this.rightwaist = new ModelRenderer(this, 64, 0);
		this.rightwaist.addBox(-2F, -1.5F, -2.5F, 4, 3, 5);
		this.rightwaist.setRotationPoint(-2F, 11F, -0.5F);
		this.rightwaist.setTextureSize(128, 64);
		this.setRotation(rightwaist, 0.0872665F, 0F, 0F);
		this.leftwaist = new ModelRenderer(this, 82, 0);
		this.leftwaist.addBox(-2F, -1.5F, -2.5F, 4, 3, 5);
		this.leftwaist.setRotationPoint(2F, 11F, -0.5F);
		this.leftwaist.setTextureSize(128, 64);
		this.setRotation(leftwaist, 0.0872665F, 0F, 0F);
		this.tail = new ModelRenderer(this, 64, 8);
		this.tail.addBox(-1F, 0F, 0F, 2, 10, 0);
		this.tail.setRotationPoint(0F, 10F, 2F);
		this.tail.setTextureSize(128, 64);
		this.setRotation(tail, 0.4014257F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 64, 18);
		this.rightleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		this.rightleglower.setRotationPoint(-2F, 11F, -0.5F);
		this.rightleglower.setTextureSize(128, 64);
		this.setRotation(rightleglower, -0.1745329F, -0.1745329F, 0F);
		this.leftleglower = new ModelRenderer(this, 80, 18);
		this.leftleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		this.leftleglower.setRotationPoint(2F, 11F, -0.5F);
		this.leftleglower.setTextureSize(128, 64);
		this.setRotation(leftleglower, -0.1745329F, 0.1745329F, 0F);
		this.rightfoot = new ModelRenderer(this, 64, 30);
		this.rightfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		this.rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		this.rightfoot.setTextureSize(128, 64);
		this.setRotation(rightfoot, 0F, -0.1745329F, 0F);
		this.leftfoot = new ModelRenderer(this, 64, 30);
		this.leftfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		this.leftfoot.setRotationPoint(2F, 11F, -0.5F);
		this.leftfoot.setTextureSize(128, 64);
		this.setRotation(leftfoot, 0F, 0.1745329F, 0F);
		
		this.convertToChild(head, hair1);
		this.convertToChild(head, hair2);
		this.convertToChild(head, horn);
		this.convertToChild(head, righthorn);
		this.convertToChild(head, lefthorn);
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.neck.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
//		this.hair1.render(par7);
//		this.hair2.render(par7);
//		this.horn.render(par7);
//		this.righthorn.render(par7);
//		this.lefthorn.render(par7);
//		this.rightear.render(par7);
//		this.leftear.render(par7);
		this.bell.render(par7);
		this.waistupper.render(par7);
		this.rightwaist.render(par7);
		this.leftwaist.render(par7);
		this.tail.render(par7);
		this.rightleglower.render(par7);
		this.leftleglower.render(par7);
		this.rightfoot.render(par7);
		this.leftfoot.render(par7);

		if (entity.ticksExisted % 60 == 0 && par3 <= 0.1F) {
			this.headeyes.render(par7);
		} 
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;

        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;

		//body
		this.rightchest.rotateAngleX = ((MathHelper.cos(par1 * 0.6662F) * 0.8F * par2)) + 0.7853982F;
		this.leftchest.rotateAngleX = this.rightchest.rotateAngleX;
		this.tail.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.rightleglower.rotateAngleX = this.rightleg.rotateAngleX - 0.1745329F;
		this.rightwaist.rotateAngleX = this.rightleg.rotateAngleX;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX;
		this.rightleg.rotateAngleX = rightleg.rotateAngleX - 0.1745329F;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
		this.leftleglower.rotateAngleX = this.leftleg.rotateAngleX - 0.1745329F;
		this.leftwaist.rotateAngleX = this.leftleg.rotateAngleX;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX;
		this.leftleg.rotateAngleX = leftleg.rotateAngleX - 0.1745329F;
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
