package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.EnderDragonGirlModel;
import gaia.client.renderer.layer.EnderDragonGirlEyesLayer;
import gaia.entity.EnderDragonGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class EnderDragonGirlRenderer extends MobRenderer<EnderDragonGirl, EnderDragonGirlModel> {
	private final Random random = new Random();
	public static final ResourceLocation[] ENDER_DRAGON_GIRL_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/ender_dragon_girl/ender_dragon_girl.png")
	};

	public EnderDragonGirlRenderer(Context context) {
		super(context, new EnderDragonGirlModel(context.bakeLayer(ClientHandler.ENDER_DRAGON_GIRL)), ClientHandler.smallShadow);
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new EnderDragonGirlEyesLayer(this));
	}

	public Vec3 getRenderOffset(EnderDragonGirl enderDragonGirl, float partialTick) {
		if (enderDragonGirl.isScreaming()) {
			double d0 = 0.02D;
			return new Vec3(this.random.nextGaussian() * d0, 0.0D, this.random.nextGaussian() * d0);
		} else {
			return super.getRenderOffset(enderDragonGirl, partialTick);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(EnderDragonGirl enderDragonGirl) {
		return ENDER_DRAGON_GIRL_LOCATIONS[enderDragonGirl.getVariant()];
	}
}
