package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MinotaurModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.client.renderer.layer.MinotaurEyesLayer;
import gaia.entity.Minotaur;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class MinotaurRenderer extends MobRenderer<Minotaur, MinotaurModel> {
	public static final ResourceLocation[] MINOTAURUS_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/minotaur/minotaur.png")
	};

	public MinotaurRenderer(Context context) {
		super(context, new MinotaurModel(context.bakeLayer(ClientHandler.MINOTAUR)), ClientHandler.medShadow);
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
		this.addLayer(new MinotaurEyesLayer(this));
		this.addLayer(new AuraLayer<>(this, () -> new MinotaurModel(context.bakeLayer(ClientHandler.MINOTAUR))));
	}

	@Override
	protected void scale(Minotaur minotaur, PoseStack poseStack, float partialTicks) {
		poseStack.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	public ResourceLocation getTextureLocation(Minotaur minotaur) {
		return MINOTAURUS_LOCATIONS[minotaur.getVariant()];
	}
}
