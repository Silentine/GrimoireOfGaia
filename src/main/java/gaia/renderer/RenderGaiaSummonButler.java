package gaia.renderer;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSummonButler extends RenderBiped {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Summon_Butler.png");

	public RenderGaiaSummonButler() {
		super(new ModelBiped(), 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
