package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.ValkyrieModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.entity.Valkyrie;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class ValkyrieRenderer extends MobRenderer<Valkyrie, ValkyrieModel> {
	public static final ResourceLocation[] VALKYRIE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/valkyrie/valkyrie.png")
	};

	public ValkyrieRenderer(Context context) {
		super(context, new ValkyrieModel(context.bakeLayer(ClientHandler.VALKYRIE)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new AuraLayer<>(this, () -> new ValkyrieModel(context.bakeLayer(ClientHandler.VALKYRIE))));
	}

	@Override
	public ResourceLocation getTextureLocation(Valkyrie valkyrie) {
		return VALKYRIE_LOCATIONS[valkyrie.getVariant()];
	}
}
