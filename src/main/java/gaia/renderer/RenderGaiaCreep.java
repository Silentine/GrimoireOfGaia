package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.monster.EntityGaiaCreep;
import gaia.model.ModelGaiaCreep;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaCreep extends RenderLiving {

	private static final ResourceLocation armoredCreeperTextures = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Creep.png");
	private ModelBase GaiaCreepModel = new ModelGaiaCreep(2.0F);

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaCreep(float shadowSize) {
        super(rend, new ModelGaiaCreep(), shadowSize);
    }

	protected void updateCreepScale(EntityGaiaCreep par1EntityGaiaCreep, float par2) {
		float f1 = par1EntityGaiaCreep.getGaiaCreepFlashIntensity(par2);
		float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;
		if(f1 < 0.0F) {
			f1 = 0.0F;
		}

		if(f1 > 1.0F) {
			f1 = 1.0F;
		}

		f1 *= f1;
		f1 *= f1;
		float f3 = (1.0F + f1 * 0.4F) * f2;
		float f4 = (1.0F + f1 * 0.1F) / f2;
		GL11.glScalef(f3, f4, f3);
	}

	protected int updateCreepColorMultiplier(EntityGaiaCreep par1EntityGaiaCreep, float par2, float par3) {
		float f2 = par1EntityGaiaCreep.getGaiaCreepFlashIntensity(par3);
		if((int)(f2 * 10.0F) % 2 == 0) {
			return 0;
		} else {
			int i = (int)(f2 * 0.2F * 255.0F);
			if(i < 0) {
				i = 0;
			}

			if(i > 255) {
				i = 255;
			}

			short short1 = 255;
			short short2 = 255;
			short short3 = 255;
			return i << 24 | short1 << 16 | short2 << 8 | short3;
		}
	}

	protected int renderCreepPassModel(EntityGaiaCreep par1EntityGaiaCreep, int par2, float par3) {
		if(par1EntityGaiaCreep.getPowered()) {
			if(par1EntityGaiaCreep.isInvisible()) {
				GL11.glDepthMask(false);
			} else {
				GL11.glDepthMask(true);
			}

			if(par2 == 1) {
				float f1 = (float)par1EntityGaiaCreep.ticksExisted + par3;
				this.bindTexture(armoredCreeperTextures);
				GL11.glMatrixMode(5890);
				GL11.glLoadIdentity();
				float f2 = f1 * 0.01F;
				float f3 = f1 * 0.01F;
				GL11.glTranslatef(f2, f3, 0.0F);
				this.setRenderPassModel(this.GaiaCreepModel);
				GL11.glMatrixMode(5888);
				GL11.glEnable(3042);
				float f4 = 0.5F;
				GL11.glColor4f(f4, f4, f4, 1.0F);
				GL11.glDisable(2896);
				GL11.glBlendFunc(1, 1);
				return 1;
			}

			if(par2 == 2) {
				GL11.glMatrixMode(5890);
				GL11.glLoadIdentity();
				GL11.glMatrixMode(5888);
				GL11.glEnable(2896);
				GL11.glDisable(3042);
			}
		}

		return -1;
	}

	//new
	private void setRenderPassModel(ModelBase gaiaCreepModel2) {
		
	}

	protected int func_77061_b(EntityGaiaCreep par1EntityGaiaCreep, int par2, float par3) {
		return -1;
	}
	
	//Normally EntityLivingBase
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		this.updateCreepScale((EntityGaiaCreep)par1EntityLivingBase, par2);
	}
	
	//Normally EntityLivingBase
	protected int getColorMultiplier(EntityLivingBase par1EntityLivingBase, float par2, float par3) {
		return this.updateCreepColorMultiplier((EntityGaiaCreep)par1EntityLivingBase, par2, par3);
	}

	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
		return this.renderCreepPassModel((EntityGaiaCreep)par1EntityLivingBase, par2, par3);
	}

	protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3) {
		return this.func_77061_b((EntityGaiaCreep)par1EntityLivingBase, par2, par3);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
