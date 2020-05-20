package gaia.client.renderer.layers;

import gaia.client.model.ModelGaia;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class GaiaGlowingLayer<T extends MobEntity, M extends ModelGaia<T>> extends AbstractEyesLayer<T, M> {
	private static RenderType RENDER_TYPE;

	public GaiaGlowingLayer(IEntityRenderer<T, M> entityRenderer, RenderType renderType) {
		super(entityRenderer);
		this.RENDER_TYPE = renderType;
	}

	public RenderType getRenderType() {
		return this.RENDER_TYPE;
	}
}
