package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCTrader;
import gaia.model.ModelGaiaNPCWeresheep;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaNPCWeresheep extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Weresheep.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaNPCWeresheep(float shadowSize) {
        super(rend, new ModelGaiaNPCWeresheep(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaNPCWeresheep.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaNPCWeresheep.leftarm));
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
