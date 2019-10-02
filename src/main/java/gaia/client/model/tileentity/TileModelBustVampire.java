package gaia.client.model.tileentity;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TileModelBustVampire extends Model implements IModelBust {
	private RendererModel head;
	private RendererModel headaccessory;
	private RendererModel headflower;
	private RendererModel headleaves;
	private RendererModel earright;
	private RendererModel earleft;
	private RendererModel body;
	private RendererModel rightchest;
	private RendererModel leftchest;
	private RendererModel chestribbon;
	private RendererModel rightshoulder;
	private RendererModel rightarm;
	private RendererModel leftshoulder;
	private RendererModel leftarm;
	private RendererModel stand1;
	private RendererModel stand2;
	private RendererModel stand3;

	public TileModelBustVampire() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -9F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 17F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -9.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 17F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		headflower = new RendererModel(this, 36, 20);
		headflower.addBox(-6F, -10F, -1F, 2, 1, 2);
		headflower.setRotationPoint(0F, 18F, 0F);
		headflower.setTextureSize(64, 32);
		setRotation(headflower, 0F, 0F, 0.7853982F);
		headleaves = new RendererModel(this, 36, 23);
		headleaves.addBox(-7F, -9F, -1.5F, 4, 0, 3);
		headleaves.setRotationPoint(0F, 18F, 0F);
		headleaves.setTextureSize(64, 32);
		setRotation(headleaves, 0F, 0F, 0.7853982F);
		earright = new RendererModel(this, 36, 14);
		earright.addBox(-3.5F, -7F, -1.5F, 0, 2, 4);
		earright.setRotationPoint(0F, 17F, 0F);
		earright.setTextureSize(64, 32);
		setRotation(earright, 0F, -0.2617994F, 0F);
		earleft = new RendererModel(this, 44, 14);
		earleft.addBox(3.5F, -7F, -1.5F, 0, 2, 4);
		earleft.setRotationPoint(0F, 17F, 0F);
		earleft.setTextureSize(64, 32);
		setRotation(earleft, 0F, 0.2617994F, 0F);
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
		chestribbon = new RendererModel(this, 36, 26);
		chestribbon.addBox(-1.5F, -1.1F, -2F, 3, 0, 3);
		chestribbon.setRotationPoint(0F, 16F, -1.5F);
		chestribbon.setTextureSize(64, 32);
		setRotation(chestribbon, 0.7853982F, 0F, 0F);
		rightshoulder = new RendererModel(this, 64, 0);
		rightshoulder.addBox(-3F, -1F, -2F, 4, 4, 4);
		rightshoulder.setRotationPoint(-2.5F, 15.5F, 0F);
		rightshoulder.setTextureSize(64, 32);
		setRotation(rightshoulder, 0.0872665F, 0F, 0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 4, 2);
		rightarm.setRotationPoint(-2.5F, 15.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0.0872665F, 0F, -0.0872665F);
		leftshoulder = new RendererModel(this, 80, 0);
		leftshoulder.addBox(-1F, -1F, -2F, 4, 4, 4);
		leftshoulder.setRotationPoint(2.5F, 15.5F, 0F);
		leftshoulder.setTextureSize(64, 32);
		setRotation(leftshoulder, 0.0872665F, 0F, -0.0872665F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 4, 2);
		leftarm.setRotationPoint(2.5F, 15.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0.0872665F, 0F, 0.0872665F);
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
		headflower.render(scale);
		headleaves.render(scale);
		earright.render(scale);
		earleft.render(scale);
		body.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		chestribbon.render(scale);
		rightshoulder.render(scale);
		rightarm.render(scale);
		leftshoulder.render(scale);
		leftarm.render(scale);
		stand1.render(scale);
		stand2.render(scale);
		stand3.render(scale);
	}
}
