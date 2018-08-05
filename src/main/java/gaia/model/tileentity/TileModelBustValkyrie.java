package gaia.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileModelBustValkyrie extends ModelBase implements IModelBust {

	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer helmet;
	ModelRenderer featherright;
	ModelRenderer featherleft;
	ModelRenderer hair;
	ModelRenderer body;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightpauldron;
	ModelRenderer rightarm;
	ModelRenderer leftpauldron;
	ModelRenderer leftarm;
	ModelRenderer stand1;
	ModelRenderer stand2;
	ModelRenderer stand3;

	public TileModelBustValkyrie() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 14F, 0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 14F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.helmet = new ModelRenderer(this, 36, 27);
		this.helmet.addBox(-3F, -7F, -4F, 6, 3, 4);
		this.helmet.setRotationPoint(0F, 14F, 0F);
		this.helmet.setTextureSize(64, 32);
		this.setRotation(helmet, 0F, 0F, 0F);
		this.featherright = new ModelRenderer(this, 36, 34);
		this.featherright.addBox(-4.5F, -7F, 0F, 1, 6, 8);
		this.featherright.setRotationPoint(0F, 14F, 0F);
		this.featherright.setTextureSize(64, 32);
		this.setRotation(featherright, 0.3490659F, -0.2617994F, 0F);
		this.featherleft = new ModelRenderer(this, 54, 34);
		this.featherleft.addBox(3.5F, -7F, 0F, 1, 6, 8);
		this.featherleft.setRotationPoint(0F, 14F, 0F);
		this.featherleft.setTextureSize(64, 32);
		this.setRotation(featherleft, 0.3490659F, 0.2617994F, 0F);
		this.hair = new ModelRenderer(this, 36, 14);
		this.hair.addBox(-3.5F, -3F, 1F, 7, 10, 3);
		this.hair.setRotationPoint(0F, 14F, 0F);
		this.hair.setTextureSize(64, 32);
		this.setRotation(hair, 0.2617994F, 0F, 0F);
		this.body = new ModelRenderer(this, 0, 12);
		this.body.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.body.setRotationPoint(0F, 14F, 0F);
		this.body.setTextureSize(64, 32);
		this.setRotation(body, 0F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 21);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 16F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 8, 21);
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 16F, -1.5F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightpauldron = new ModelRenderer(this, 72, 0);
		this.rightpauldron.addBox(-4F, -2F, -2F, 4, 3, 4);
		this.rightpauldron.setRotationPoint(-2.5F, 16F, 0F);
		this.rightpauldron.setTextureSize(64, 32);
		this.setRotation(rightpauldron, 0.0872665F, 0F, -0.3490659F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2.5F, -1F, -1F, 2, 4, 2);
		this.rightarm.setRotationPoint(-2F, 16F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, -0.2617994F);
		this.leftpauldron = new ModelRenderer(this, 88, 0);
		this.leftpauldron.addBox(0F, -2F, -2F, 4, 3, 4);
		this.leftpauldron.setRotationPoint(2.5F, 16F, 0F);
		this.leftpauldron.setTextureSize(64, 32);
		this.setRotation(leftpauldron, 0.0872665F, 0F, 0.3490659F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0.5F, -1F, -1F, 2, 4, 2);
		this.leftarm.setRotationPoint(2F, 16F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, 0.2617994F);
		this.stand1 = new ModelRenderer(this, 0, 25);
		this.stand1.addBox(-1.5F, 6F, -1.5F, 3, 1, 3);
		this.stand1.setRotationPoint(0F, 14F, 0F);
		this.stand1.setTextureSize(64, 32);
		this.setRotation(stand1, 0F, 0F, 0F);
		this.stand2 = new ModelRenderer(this, 0, 29);
		this.stand2.addBox(-1F, 7F, -1F, 2, 2, 2);
		this.stand2.setRotationPoint(0F, 14F, 0F);
		this.stand2.setTextureSize(64, 32);
		this.setRotation(stand2, 0F, 0F, 0F);
		this.stand3 = new ModelRenderer(this, 0, 33);
		this.stand3.addBox(-2F, 9F, -2F, 4, 1, 4);
		this.stand3.setRotationPoint(0F, 14F, 0F);
		this.stand3.setTextureSize(64, 32);
		this.setRotation(stand3, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.head.render(scale);
		this.headaccessory.render(scale);
		this.helmet.render(scale);
		this.featherright.render(scale);
		this.featherleft.render(scale);
		this.hair.render(scale);
		this.body.render(scale);
		this.rightchest.render(scale);
		this.leftchest.render(scale);
		this.rightpauldron.render(scale);
		this.rightarm.render(scale);
		this.leftpauldron.render(scale);
		this.leftarm.render(scale);
		this.stand1.render(scale);
		this.stand2.render(scale);
		this.stand3.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void renderModel(float scale) {
		this.head.render(scale);
		this.headaccessory.render(scale);
		this.helmet.render(scale);
		this.featherright.render(scale);
		this.featherleft.render(scale);
		this.hair.render(scale);
		this.body.render(scale);
		this.rightchest.render(scale);
		this.leftchest.render(scale);
		this.rightpauldron.render(scale);
		this.rightarm.render(scale);
		this.leftpauldron.render(scale);
		this.leftarm.render(scale);
		this.stand1.render(scale);
		this.stand2.render(scale);
		this.stand3.render(scale);
	}
}
