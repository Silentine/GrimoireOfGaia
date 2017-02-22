package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.model.ModelGaiaBanshee;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaBanshee extends RenderLiving<EntityGaiaBanshee> {

	private static final ResourceLocation bansheeEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Banshee.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Banshee.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaBanshee( float shadowSize) {
        super(rend, new ModelGaiaBanshee(), shadowSize);
        this.addLayer(new LayerGlowing(this, bansheeEyesTexture));
    }

	protected ResourceLocation getEntityTexture(EntityGaiaBanshee entity) {
		return texture;
	}
}
