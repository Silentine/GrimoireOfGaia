package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



@SideOnly(Side.CLIENT)
public class ModelExampleMob extends ModelBase{
  ModelRenderer head;
  ModelRenderer headaccessory;
  ModelRenderer hair;
  ModelRenderer ears;
  ModelRenderer body;
  ModelRenderer backpack;
  public static ModelRenderer rightarm;
  ModelRenderer rightarmcloth;
  ModelRenderer leftarm;
  ModelRenderer leftarmcloth;
  ModelRenderer waist;
  ModelRenderer tail1;
  ModelRenderer tail2;
  ModelRenderer tail3;
  ModelRenderer rightleg;
  ModelRenderer rightlegcloth;
  ModelRenderer rightlegclothlower;
  ModelRenderer leftleg;
  ModelRenderer leftlegcloth;
  ModelRenderer leftlegclothlower;
  
  public ModelExampleMob()
  {
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.head = new ModelRenderer(this, 0, 0);
    this.head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
    this.head.setRotationPoint(0.0F, 1.0F, 0.0F);
    this.head.setTextureSize(128, 64);
    this.head.mirror = true;
    setRotation(this.head, 0.0F, 0.0F, 0.0F);
    this.headaccessory = new ModelRenderer(this, 36, 0);
    this.headaccessory.addBox(-3.5F, -7.0F, -3.5F, 7, 7, 7);
    this.headaccessory.setRotationPoint(0.0F, 1.0F, 0.0F);
    this.headaccessory.setTextureSize(128, 64);
    this.headaccessory.mirror = true;
    setRotation(this.headaccessory, 0.0F, 0.0F, 0.0F);
    this.hair = new ModelRenderer(this, 36, 19);
    this.hair.addBox(-4.5F, -5.0F, -2.5F, 9, 6, 5);
    this.hair.setRotationPoint(0.0F, 1.0F, 0.0F);
    this.hair.setTextureSize(128, 64);
    this.hair.mirror = true;
    setRotation(this.hair, 0.0F, 0.0F, 0.0F);
    this.ears = new ModelRenderer(this, 36, 14);
    this.ears.addBox(-5.5F, -8.0F, 0.5F, 11, 4, 1);
    this.ears.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ears.setTextureSize(128, 64);
    this.ears.mirror = true;
    setRotation(this.ears, 0.0F, 0.0F, 0.0F);
    this.body = new ModelRenderer(this, 0, 12);
    this.body.addBox(-2.5F, 0.0F, -1.5F, 5, 10, 3);
    this.body.setRotationPoint(0.0F, 1.0F, 0.0F);
    this.body.setTextureSize(128, 64);
    this.body.mirror = true;
    setRotation(this.body, 0.0F, 0.0F, 0.0F);
    this.backpack = new ModelRenderer(this, 36, 40);
    this.backpack.addBox(-3.0F, 0.0F, 2.5F, 6, 7, 5);
    this.backpack.setRotationPoint(0.0F, 1.0F, 0.0F);
    this.backpack.setTextureSize(128, 64);
    this.backpack.mirror = true;
    setRotation(this.backpack, -0.122173F, 0.0F, 0.0F);
    this.rightarm = new ModelRenderer(this, 16, 12);
    this.rightarm.addBox(-2.0F, -1.0F, -1.0F, 2, 10, 2);
    this.rightarm.setRotationPoint(-2.5F, 2.5F, 0.0F);
    this.rightarm.setTextureSize(128, 64);
    this.rightarm.mirror = true;
    setRotation(this.rightarm, 0.0F, 0.0F, 0.1745329F);
    this.rightarmcloth = new ModelRenderer(this, 36, 30);
    this.rightarmcloth.addBox(-2.5F, 1.0F, -1.5F, 3, 7, 3);
    this.rightarmcloth.setRotationPoint(-2.5F, 2.5F, 0.0F);
    this.rightarmcloth.setTextureSize(128, 64);
    this.rightarmcloth.mirror = true;
    setRotation(this.rightarmcloth, 0.0F, 0.0F, 0.1745329F);
    this.leftarm = new ModelRenderer(this, 16, 12);
    this.leftarm.addBox(0.0F, -1.0F, -1.0F, 2, 10, 2);
    this.leftarm.setRotationPoint(2.5F, 2.5F, 0.0F);
    this.leftarm.setTextureSize(128, 64);
    this.leftarm.mirror = true;
    setRotation(this.leftarm, 0.0F, 0.0F, -0.1745329F);
    this.leftarmcloth = new ModelRenderer(this, 48, 30);
    this.leftarmcloth.addBox(-0.5F, 1.0F, -1.5F, 3, 7, 3);
    this.leftarmcloth.setRotationPoint(2.5F, 2.5F, 0.0F);
    this.leftarmcloth.setTextureSize(128, 64);
    this.leftarmcloth.mirror = true;
    setRotation(this.leftarmcloth, 0.0F, 0.0F, -0.1745329F);
    this.waist = new ModelRenderer(this, 36, 52);
    this.waist.addBox(-3.0F, 8.0F, -2.0F, 6, 4, 4);
    this.waist.setRotationPoint(0.0F, 1.0F, 0.0F);
    this.waist.setTextureSize(128, 64);
    this.waist.mirror = true;
    setRotation(this.waist, 0.0F, 0.0F, 0.0F);
    this.tail1 = new ModelRenderer(this, 0, 48);
    this.tail1.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 4);
    this.tail1.setRotationPoint(0.0F, 11.0F, 2.0F);
    this.tail1.setTextureSize(128, 64);
    this.tail1.mirror = true;
    setRotation(this.tail1, 0.0F, 0.0F, 0.0F);
    this.tail2 = new ModelRenderer(this, 0, 56);
    this.tail2.addBox(-1.5F, -0.5F, 4.0F, 3, 3, 2);
    this.tail2.setRotationPoint(0.0F, 11.0F, 2.0F);
    this.tail2.setTextureSize(128, 64);
    this.tail2.mirror = true;
    setRotation(this.tail2, 0.0F, 0.0F, 0.0F);
    this.tail3 = new ModelRenderer(this, 0, 61);
    this.tail3.addBox(-1.0F, 1.0F, 6.0F, 2, 2, 1);
    this.tail3.setRotationPoint(0.0F, 11.0F, 2.0F);
    this.tail3.setTextureSize(128, 64);
    this.tail3.mirror = true;
    setRotation(this.tail3, 0.0F, 0.0F, 0.0F);
    this.rightleg = new ModelRenderer(this, 24, 12);
    this.rightleg.addBox(-1.0F, 0.0F, -1.0F, 2, 13, 2);
    this.rightleg.setRotationPoint(-1.5F, 11.0F, 0.0F);
    this.rightleg.setTextureSize(128, 64);
    this.rightleg.mirror = true;
    setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
    this.rightlegcloth = new ModelRenderer(this, 64, 0);
    this.rightlegcloth.addBox(-2.5F, 0.0F, -2.0F, 4, 9, 4);
    this.rightlegcloth.setRotationPoint(-1.5F, 11.0F, 0.0F);
    this.rightlegcloth.setTextureSize(128, 64);
    this.rightlegcloth.mirror = true;
    setRotation(this.rightlegcloth, 0.0F, 0.0F, 0.0F);
    this.rightlegclothlower = new ModelRenderer(this, 64, 13);
    this.rightlegclothlower.addBox(-1.5F, 9.0F, -1.5F, 3, 1, 3);
    this.rightlegclothlower.setRotationPoint(-1.5F, 11.0F, 0.0F);
    this.rightlegclothlower.setTextureSize(128, 64);
    this.rightlegclothlower.mirror = true;
    setRotation(this.rightlegclothlower, 0.0F, 0.0F, 0.0F);
    this.leftleg = new ModelRenderer(this, 24, 12);
    this.leftleg.addBox(-1.0F, 0.0F, -1.0F, 2, 13, 2);
    this.leftleg.setRotationPoint(1.5F, 11.0F, 0.0F);
    this.leftleg.setTextureSize(128, 64);
    this.leftleg.mirror = true;
    setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
    this.leftlegcloth = new ModelRenderer(this, 80, 0);
    this.leftlegcloth.addBox(-1.5F, 0.0F, -2.0F, 4, 9, 4);
    this.leftlegcloth.setRotationPoint(1.5F, 11.0F, 0.0F);
    this.leftlegcloth.setTextureSize(128, 64);
    this.leftlegcloth.mirror = true;
    setRotation(this.leftlegcloth, 0.0F, 0.0F, 0.0F);
    this.leftlegclothlower = new ModelRenderer(this, 64, 13);
    this.leftlegclothlower.addBox(-1.5F, 9.0F, -1.5F, 3, 1, 3);
    this.leftlegclothlower.setRotationPoint(1.5F, 11.0F, 0.0F);
    this.leftlegclothlower.setTextureSize(128, 64);
    this.leftlegclothlower.mirror = true;
    setRotation(this.leftlegclothlower, 0.0F, 0.0F, 0.0F);
  }
  
  public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7)
  {
    super.render(entity, par2, par3, par4, par5, par6, par7);
    setRotationAngles(par2, par3, par4, par5, par6, par7);
    this.head.render(par7);
    this.headaccessory.render(par7);
    this.hair.render(par7);
    this.ears.render(par7);
    this.body.render(par7);
    this.backpack.render(par7);
    this.rightarm.render(par7);
    this.rightarmcloth.render(par7);
    this.leftarm.render(par7);
    this.leftarmcloth.render(par7);
    this.waist.render(par7);
    this.tail1.render(par7);
    this.tail2.render(par7);
    this.tail3.render(par7);
    this.rightleg.render(par7);
    this.rightlegcloth.render(par7);
    this.rightlegclothlower.render(par7);
    this.leftleg.render(par7);
    this.leftlegcloth.render(par7);
    this.leftlegclothlower.render(par7);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
  {
    this.head.rotateAngleY = (par4 / 57.295776F);
    this.head.rotateAngleX = (par5 / 57.295776F);
    this.headaccessory.rotateAngleY = this.head.rotateAngleY;
    this.headaccessory.rotateAngleX = this.head.rotateAngleX;
    this.hair.rotateAngleY = this.head.rotateAngleY;
    this.hair.rotateAngleX = this.head.rotateAngleX;
    this.ears.rotateAngleY = this.head.rotateAngleY;
    this.ears.rotateAngleX = this.head.rotateAngleX;
    this.rightarm.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 0.8F * par2 * 0.5F);
    this.leftarm.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F);
    this.rightarmcloth.rotateAngleX = this.rightarm.rotateAngleX;
    this.leftarmcloth.rotateAngleX = this.leftarm.rotateAngleX;
    this.rightleg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 0.5F * par2);
    this.leftleg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 0.5F * par2);
    this.rightlegcloth.rotateAngleX = this.rightleg.rotateAngleX;
    this.rightlegclothlower.rotateAngleX = this.rightleg.rotateAngleX;
    this.leftlegcloth.rotateAngleX = this.leftleg.rotateAngleX;
    this.leftlegclothlower.rotateAngleX = this.leftleg.rotateAngleX;
  }
}
