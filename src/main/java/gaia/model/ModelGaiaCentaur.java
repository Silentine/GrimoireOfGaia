package gaia.model;

import gaia.entity.monster.EntityGaiaCentaur;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaCentaur extends ModelBase {
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
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer rightpauldron;
	ModelRenderer rightarmguard;
	ModelRenderer saddle1;
	ModelRenderer saddle2;
	ModelRenderer saddle3;
	ModelRenderer front;
	ModelRenderer body1;
	ModelRenderer body2;
	ModelRenderer rightsaddlestrap1;
	ModelRenderer leftsaddlestrap1;
	ModelRenderer rightsaddlestrap2;
	ModelRenderer leftsaddlestrap2;
	ModelRenderer rightlegupper;
	ModelRenderer leftlegupper;
	ModelRenderer rightlegbracelet;
	ModelRenderer leftlegbracelet;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer rightlegback1;
	ModelRenderer leftlegback1;
	ModelRenderer rightlegback2;
	ModelRenderer leftlegback2;
	ModelRenderer rightlegback3;
	ModelRenderer leftlegback3;
	ModelRenderer tail;

	public ModelGaiaCentaur() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, -6F, -7.5F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, -6F, -7.5F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, -6F, -7.5F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, -6F, -7.5F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -2F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, -6F, -7F);
		this.bodytop.setTextureSize(64, 32);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -2F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, -6F, -7F);
		this.bodymiddle.setTextureSize(64, 32);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 5.5F, -2.1F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, -5.5F, -7F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -3F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, -6F, -7F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, -4F, -9F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, -4F, -9F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, -5F, -7.5F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 36);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, -5F, -7.5F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, -0.1745329F);
		this.hair1 = new ModelRenderer(this, 36, 14);
		this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		this.hair1.setRotationPoint(0F, -6F, -7.5F);
		this.hair1.setTextureSize(64, 32);
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 25);
		this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		this.hair2.setRotationPoint(0F, -6F, -7.5F);
		this.hair2.setTextureSize(64, 32);
		this.setRotation(hair2, 0F, 0F, 0F);
		this.rightear = new ModelRenderer(this, 36, 33);
		this.rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		this.rightear.setRotationPoint(0F, -6F, -7.5F);
		this.rightear.setTextureSize(64, 32);
		this.setRotation(rightear, 0F, -0.5235988F, 0F);
		this.leftear = new ModelRenderer(this, 36, 33);
		this.leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		this.leftear.setRotationPoint(0F, -6F, -7.5F);
		this.leftear.setTextureSize(64, 32);
		this.setRotation(leftear, 0F, 0.5235988F, 0F);
		this.rightpauldron = new ModelRenderer(this, 36, 41);
		this.rightpauldron.addBox(-3F, -1.5F, -2F, 4, 3, 4);
		this.rightpauldron.setRotationPoint(-2.5F, -5F, -7.5F);
		this.rightpauldron.setTextureSize(64, 32);
		this.setRotation(rightpauldron, 0F, 0F, 0.1745329F);
		this.rightarmguard = new ModelRenderer(this, 36, 48);
		this.rightarmguard.addBox(-2.5F, 5F, -1.5F, 3, 4, 3);
		this.rightarmguard.setRotationPoint(-2.5F, -5F, -7.5F);
		this.rightarmguard.setTextureSize(64, 32);
		this.setRotation(rightarmguard, 0F, 0F, 0.1745329F);
		this.saddle1 = new ModelRenderer(this, 36, 55);
		this.saddle1.addBox(-4F, 13.5F, 5F, 8, 1, 8);
		this.saddle1.setRotationPoint(0F, -10F, -8F);
		this.saddle1.setTextureSize(64, 32);
		this.setRotation(saddle1, 0F, 0F, 0F);
		this.saddle2 = new ModelRenderer(this, 68, 0);
		this.saddle2.addBox(-1F, 12.5F, 5F, 2, 1, 2);
		this.saddle2.setRotationPoint(0F, -10F, -8F);
		this.saddle2.setTextureSize(64, 32);
		this.setRotation(saddle2, 0F, 0F, 0F);
		this.saddle3 = new ModelRenderer(this, 76, 0);
		this.saddle3.addBox(-3F, 12.5F, 11F, 6, 1, 2);
		this.saddle3.setRotationPoint(0F, -10F, -8F);
		this.saddle3.setTextureSize(64, 32);
		this.setRotation(saddle3, 0F, 0F, 0F);
		this.front = new ModelRenderer(this, 68, 10);
		this.front.addBox(-3.5F, 7.5F, -2F, 7, 10, 3);
		this.front.setRotationPoint(0F, -6F, -7F);
		this.front.setTextureSize(64, 32);
		this.setRotation(front, -0.0872665F, 0F, 0F);
		this.body1 = new ModelRenderer(this, 68, 23);
		this.body1.addBox(-4F, 14F, 0F, 8, 9, 9);
		this.body1.setRotationPoint(0F, -10F, -8F);
		this.body1.setTextureSize(64, 32);
		this.setRotation(body1, -0.0872665F, 0F, 0F);
		this.body2 = new ModelRenderer(this, 68, 41);
		this.body2.addBox(-3.5F, 15.5F, 5F, 7, 8, 12);
		this.body2.setRotationPoint(0F, -10F, -8F);
		this.body2.setTextureSize(64, 32);
		this.setRotation(body2, 0.0872665F, 0F, 0F);
		this.rightsaddlestrap1 = new ModelRenderer(this, 68, 3);
		this.rightsaddlestrap1.addBox(-0.5F, -0.5F, -0.5F, 1, 6, 1);
		this.rightsaddlestrap1.setRotationPoint(-4F, 4F, 0F);
		this.rightsaddlestrap1.setTextureSize(64, 32);
		this.setRotation(rightsaddlestrap1, 0F, 0F, 0F);
		this.leftsaddlestrap1 = new ModelRenderer(this, 68, 3);
		this.leftsaddlestrap1.addBox(-0.5F, -0.5F, -0.5F, 1, 6, 1);
		this.leftsaddlestrap1.setRotationPoint(4F, 4F, 0F);
		this.leftsaddlestrap1.setTextureSize(64, 32);
		this.setRotation(leftsaddlestrap1, 0F, 0F, 0F);
		this.rightsaddlestrap2 = new ModelRenderer(this, 72, 3);
		this.rightsaddlestrap2.addBox(-0.5F, 5.5F, -1F, 1, 2, 2);
		this.rightsaddlestrap2.setRotationPoint(-4F, 4F, 0F);
		this.rightsaddlestrap2.setTextureSize(64, 32);
		this.setRotation(rightsaddlestrap2, 0F, 0F, 0F);
		this.leftsaddlestrap2 = new ModelRenderer(this, 72, 3);
		this.leftsaddlestrap2.addBox(-0.5F, 5.5F, -1F, 1, 2, 2);
		this.leftsaddlestrap2.setRotationPoint(4F, 4F, 0F);
		this.leftsaddlestrap2.setTextureSize(64, 32);
		this.setRotation(leftsaddlestrap2, 0F, 0F, 0F);
		this.rightlegupper = new ModelRenderer(this, 106, 0);
		this.rightlegupper.addBox(-1.466667F, -1.5F, -1.5F, 3, 8, 3);
		this.rightlegupper.setRotationPoint(-4F, 9F, -7F);
		this.rightlegupper.setTextureSize(64, 32);
		this.setRotation(rightlegupper, 0F, 0F, -0.0872665F);
		this.leftlegupper = new ModelRenderer(this, 106, 0);
		this.leftlegupper.addBox(-1.466667F, -1.5F, -1.5F, 3, 8, 3);
		this.leftlegupper.setRotationPoint(4F, 9F, -7F);
		this.leftlegupper.setTextureSize(64, 32);
		this.setRotation(leftlegupper, 0F, 0F, 0.0872665F);
		this.rightlegbracelet = new ModelRenderer(this, 106, 11);
		this.rightlegbracelet.addBox(-1.5F, 10.5F, -1F, 3, 2, 3);
		this.rightlegbracelet.setRotationPoint(-4F, 9F, -7F);
		this.rightlegbracelet.setTextureSize(64, 32);
		this.setRotation(rightlegbracelet, 0F, 0F, -0.0872665F);
		this.leftlegbracelet = new ModelRenderer(this, 106, 11);
		this.leftlegbracelet.addBox(-1.5F, 10.5F, -1F, 3, 2, 3);
		this.leftlegbracelet.setRotationPoint(4F, 9F, -7F);
		this.leftlegbracelet.setTextureSize(64, 32);
		this.setRotation(leftlegbracelet, 0F, 0F, 0.0872665F);
		this.rightleglower = new ModelRenderer(this, 106, 16);
		this.rightleglower.addBox(-1F, 6.5F, -0.5F, 2, 8, 2);
		this.rightleglower.setRotationPoint(-4F, 9F, -7F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(rightleglower, 0F, 0F, -0.0872665F);
		this.leftleglower = new ModelRenderer(this, 106, 16);
		this.leftleglower.addBox(-1F, 6.5F, -0.5F, 2, 8, 2);
		this.leftleglower.setRotationPoint(4F, 9F, -7F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(leftleglower, 0F, 0F, 0.0872665F);
		this.rightlegback1 = new ModelRenderer(this, 106, 26);
		this.rightlegback1.addBox(-0.5F, -2.5F, -1.5F, 3, 8, 6);
		this.rightlegback1.setRotationPoint(-4F, 7F, 7F);
		this.rightlegback1.setTextureSize(64, 32);
		this.setRotation(rightlegback1, -0.296706F, 0F, -0.0872665F);
		this.leftlegback1 = new ModelRenderer(this, 106, 26);
		this.leftlegback1.addBox(-2.5F, -2.5F, -1.5F, 3, 8, 6);
		this.leftlegback1.setRotationPoint(4F, 7F, 7F);
		this.leftlegback1.setTextureSize(64, 32);
		this.setRotation(leftlegback1, -0.296706F, 0F, 0.0872665F);
		this.rightlegback2 = new ModelRenderer(this, 106, 40);
		this.rightlegback2.addBox(-1.5F, 2F, 2.5F, 3, 3, 6);
		this.rightlegback2.setRotationPoint(-4F, 7F, 7F);
		this.rightlegback2.setTextureSize(64, 32);
		this.setRotation(rightlegback2, -1.047198F, 0F, -0.0872665F);
		this.leftlegback2 = new ModelRenderer(this, 106, 40);
		this.leftlegback2.addBox(-1.5F, 2F, 2.5F, 3, 3, 6);
		this.leftlegback2.setRotationPoint(4F, 7F, 7F);
		this.leftlegback2.setTextureSize(64, 32);
		this.setRotation(leftlegback2, -1.047198F, 0F, 0.0872665F);
		this.rightlegback3 = new ModelRenderer(this, 106, 44);
		this.rightlegback3.addBox(-1F, 8F, 1.5F, 2, 8, 2);
		this.rightlegback3.setRotationPoint(-4F, 7F, 7F);
		this.rightlegback3.setTextureSize(64, 32);
		this.setRotation(rightlegback3, -0.122173F, 0F, -0.0872665F);
		this.leftlegback3 = new ModelRenderer(this, 106, 49);
		this.leftlegback3.addBox(-1F, 8F, 1.5F, 2, 8, 2);
		this.leftlegback3.setRotationPoint(4F, 7F, 7F);
		this.leftlegback3.setTextureSize(64, 32);
		this.setRotation(leftlegback3, -0.122173F, 0F, 0.0872665F);
		this.tail = new ModelRenderer(this, 106, 51);
		this.tail.addBox(-1F, -1F, -0.5F, 2, 2, 8);
		this.tail.setRotationPoint(0F, 6F, 10F);
		this.tail.setTextureSize(64, 32);
		this.setRotation(tail, -1.047198F, 0F, 0F);
		
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(rightarm, rightpauldron);
		this.convertToChild(rightarm, rightarmguard);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7, entity);
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
		this.hair1.render(par7);
		this.hair2.render(par7);
//		this.rightear.render(par7);
//		this.leftear.render(par7);
//		this.rightpauldron.render(par7);
//		this.rightarmguard.render(par7);
		this.saddle1.render(par7);
		this.saddle2.render(par7);
		this.saddle3.render(par7);
		this.front.render(par7);
		this.body1.render(par7);
		this.body2.render(par7);
		this.rightsaddlestrap1.render(par7);
		this.leftsaddlestrap1.render(par7);
		this.rightsaddlestrap2.render(par7);
		this.leftsaddlestrap2.render(par7);
		this.rightlegupper.render(par7);
		this.leftlegupper.render(par7);
		this.rightlegbracelet.render(par7);
		this.leftlegbracelet.render(par7);
		this.rightleglower.render(par7);
		this.leftleglower.render(par7);
		this.rightlegback1.render(par7);
		this.leftlegback1.render(par7);
		this.rightlegback2.render(par7);
		this.leftlegback2.render(par7);
		this.rightlegback3.render(par7);
		this.leftlegback3.render(par7);
		this.tail.render(par7);

		if (entity.ticksExisted % 60 == 0 && par3 <= 0.1F) {
			this.headeyes.render(par7);
		} 
	}
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entityIn) {
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.hair1.rotateAngleY = this.head.rotateAngleY;
		this.hair2.rotateAngleY = (this.head.rotateAngleY) * 0.75F;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2 * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        float f6;
        float f7;
        ItemStack itemstack = ((EntityLivingBase)entityIn).getHeldItemMainhand();
        EntityGaiaCentaur entity = (EntityGaiaCentaur)entityIn;
		 
		if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)){
			holdingbow(par1, par2, par3, par4, par5,par6, entityIn );
		}
		 else{
        if (this.swingProgress > -9990.0F) {
            f6 = this.swingProgress;
            f6 = 1.0F - this.swingProgress;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            f7 = MathHelper.sin(f6 * (float)Math.PI);
            float f8 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        	}
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
		}

        //body
		this.rightsaddlestrap1.rotateAngleX = MathHelper.cos(par1 * 0.7862F) * 0.4F * par2;
		this.rightsaddlestrap2.rotateAngleX = this.rightsaddlestrap1.rotateAngleX;
		this.leftsaddlestrap1.rotateAngleX = this.rightsaddlestrap1.rotateAngleX;
		this.leftsaddlestrap2.rotateAngleX = this.rightsaddlestrap1.rotateAngleX;
		this.tail.rotateAngleY = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		
		//legs
		this.rightlegupper.rotateAngleX = MathHelper.cos(par1 * 0.7862F) * 0.8F * par2;
		this.leftlegupper.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;
		this.rightlegbracelet.rotateAngleX = this.rightlegupper.rotateAngleX;
		this.leftlegbracelet.rotateAngleX = this.leftlegupper.rotateAngleX;
		this.rightleglower.rotateAngleX = this.rightlegupper.rotateAngleX;
		this.leftleglower.rotateAngleX = this.leftlegupper.rotateAngleX;
		this.rightlegback1.rotateAngleX = MathHelper.cos(par1 * 0.7662F + (float)Math.PI) * 0.8F * par2;
		this.leftlegback1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.rightlegback2.rotateAngleX = this.rightlegback1.rotateAngleX - 1.047198F;
		this.leftlegback2.rotateAngleX = this.leftlegback1.rotateAngleX - 1.047198F;
		this.rightlegback3.rotateAngleX = this.rightlegback1.rotateAngleX - 0.122173F;
		this.leftlegback3.rotateAngleX = this.leftlegback1.rotateAngleX - 0.122173F;
		this.rightlegback1.rotateAngleX -= 0.296706F;
		this.leftlegback1.rotateAngleX -= 0.296706F;
	}
	
	public void holdingbow(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn){
		
        float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
        float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
        this.rightarm.rotateAngleZ = -0.3F;
        this.leftarm.rotateAngleZ = 0.3F;
        this.rightarm.rotateAngleY = -(0.1F - f * 0.6F);
        this.leftarm.rotateAngleY = 0.3F - f * 0.6F;
        this.rightarm.rotateAngleX = -((float)Math.PI / 2.2F);
        this.leftarm.rotateAngleX = -((float)Math.PI / 2.2F);
        this.rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
        this.leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
        this.rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
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
