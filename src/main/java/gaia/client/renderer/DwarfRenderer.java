package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.DwarfModel;
import gaia.client.renderer.layer.DwarfEyeLayer;
import gaia.entity.Dwarf;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class DwarfRenderer extends MobRenderer<Dwarf, DwarfModel> {
	public static final ResourceLocation[] DWARF_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/dwarf/dwarf01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/dwarf/dwarf02.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/dwarf/dwarf03.png")
	};

	public DwarfRenderer(Context context) {
		super(context, new DwarfModel(context.bakeLayer(ClientHandler.DWARF)), ClientHandler.smallShadow);
		this.addLayer(new DwarfEyeLayer(this));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Dwarf dwarf) {
		return DWARF_LOCATIONS[dwarf.getVariant()];
	}
}
