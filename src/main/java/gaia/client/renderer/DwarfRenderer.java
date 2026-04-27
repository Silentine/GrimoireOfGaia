package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.DwarfModel;
import gaia.client.renderer.layer.DwarfEyeLayer;
import gaia.client.state.DwarfRenderState;
import gaia.entity.Dwarf;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class DwarfRenderer extends MobRenderer<Dwarf, DwarfRenderState, DwarfModel> {
	public static final Identifier[] DWARF_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/dwarf/dwarf01.png"),
			GrimoireOfGaia.modLoc("textures/entity/dwarf/dwarf02.png"),
			GrimoireOfGaia.modLoc("textures/entity/dwarf/dwarf03.png")
	};

	public DwarfRenderer(Context context) {
		super(context, new DwarfModel(context.bakeLayer(ClientHandler.DWARF)), ClientHandler.smallShadow);
		this.addLayer(new DwarfEyeLayer(this));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public DwarfRenderState createRenderState() {
		return new DwarfRenderState();
	}

	@Override
	public void extractRenderState(Dwarf entity, DwarfRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.isAggressive = entity.isAggressive();
	}

	@Override
	public Identifier getTextureLocation(DwarfRenderState state) {
		return DWARF_LOCATIONS[state.variant];
	}
}
