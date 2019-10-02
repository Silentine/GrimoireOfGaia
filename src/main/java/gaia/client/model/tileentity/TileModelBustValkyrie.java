package gaia.client.model.tileentity;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TileModelBustValkyrie extends Model implements IModelBust {
	private RendererModel head;
	private RendererModel headaccessory;
	private RendererModel helmet;
	private RendererModel featherright;
	private RendererModel featherleft;
	private RendererModel hair;
	private RendererModel body;
	private RendererModel rightchest;
	private RendererModel leftchest;
	private RendererModel rightpauldron;
	private RendererModel rightarm;
	private RendererModel leftpauldron;
	private RendererModel leftarm;
	private RendererModel stand1;
	private RendererModel stand2;
	private RendererModel stand3;

	public TileModelBustValkyrie() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 14F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 14F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		helmet = new RendererModel(this, 36, 27);
		helmet.addBox(-3F, -7F, -4F, 6, 3, 4);
		helmet.setRotationPoint(0F, 14F, 0F);
		helmet.setTextureSize(64, 32);
		setRotation(helmet, 0F, 0F, 0F);
		featherright = new RendererModel(this, 36, 34);
		featherright.addBox(-4.5F, -7F, 0F, 1, 6, 8);
		featherright.setRotationPoint(0F, 14F, 0F);
		featherright.setTextureSize(64, 32);
		setRotation(featherright, 0.3490659F, -0.2617994F, 0F);
		featherleft = new RendererModel(this, 54, 34);
		featherleft.addBox(3.5F, -7F, 0F, 1, 6, 8);
		featherleft.setRotationPoint(0F, 14F, 0F);
		featherleft.setTextureSize(64, 32);
		setRotation(featherleft, 0.3490659F, 0.2617994F, 0F);
		hair = new RendererModel(this, 36, 14);
		hair.addBox(-3.5F, -3F, 1F, 7, 10, 3);
		hair.setRotationPoint(0F, 14F, 0F);
		hair.setTextureSize(64, 32);
		setRotation(hair, 0.2617994F, 0F, 0F);
		body = new RendererModel(this, 0, 12);
		body.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		body.setRotationPoint(0F, 14F, 0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 21);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 16F, -1.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 8, 21);
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 16F, -1.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightpauldron = new RendererModel(this, 72, 0);
		rightpauldron.addBox(-4F, -2F, -2F, 4, 3, 4);
		rightpauldron.setRotationPoint(-2.5F, 16F, 0F);
		rightpauldron.setTextureSize(64, 32);
		setRotation(rightpauldron, 0.0872665F, 0F, -0.3490659F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2.5F, -1F, -1F, 2, 4, 2);
		rightarm.setRotationPoint(-2F, 16F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, -0.2617994F);
		leftpauldron = new RendererModel(this, 88, 0);
		leftpauldron.addBox(0F, -2F, -2F, 4, 3, 4);
		leftpauldron.setRotationPoint(2.5F, 16F, 0F);
		leftpauldron.setTextureSize(64, 32);
		setRotation(leftpauldron, 0.0872665F, 0F, 0.3490659F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.addBox(0.5F, -1F, -1F, 2, 4, 2);
		leftarm.setRotationPoint(2F, 16F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, 0.2617994F);
		stand1 = new RendererModel(this, 0, 25);
		stand1.addBox(-1.5F, 6F, -1.5F, 3, 1, 3);
		stand1.setRotationPoint(0F, 14F, 0F);
		stand1.setTextureSize(64, 32);
		setRotation(stand1, 0F, 0F, 0F);
		stand2 = new RendererModel(this, 0, 29);
		stand2.addBox(-1F, 7F, -1F, 2, 2, 2);
		stand2.setRotationPoint(0F, 14F, 0F);
		stand2.setTextureSize(64, 32);
		setRotation(stand2, 0F, 0F, 0F);
		stand3 = new RendererModel(this, 0, 33);
		stand3.addBox(-2F, 9F, -2F, 4, 1, 4);
		stand3.setRotationPoint(0F, 14F, 0F);
		stand3.setTextureSize(64, 32);
		setRotation(stand3, 0F, 0F, 0F);
	}

	private void setRotation(RendererModel model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void renderModel(float scale) {
		head.render(scale);
		headaccessory.render(scale);
		helmet.render(scale);
		featherright.render(scale);
		featherleft.render(scale);
		hair.render(scale);
		body.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightpauldron.render(scale);
		rightarm.render(scale);
		leftpauldron.render(scale);
		leftarm.render(scale);
		stand1.render(scale);
		stand2.render(scale);
		stand3.render(scale);
	}
}
