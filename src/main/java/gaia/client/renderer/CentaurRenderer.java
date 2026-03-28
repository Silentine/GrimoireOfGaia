package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CentaurModel;
import gaia.client.state.CentaurRenderState;
import gaia.entity.Centaur;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;

public class CentaurRenderer extends MobRenderer<Centaur, CentaurRenderState, CentaurModel> {
	public static final Identifier[] CENTAUR_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/centaur/centaur01.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/centaur/centaur02.png")
	};
	public static final Identifier[] CENTAUR_MALE_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/centaur/centaur01_male.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/centaur/centaur02_male.png")
	};

	public CentaurRenderer(Context context) {
		super(context, new CentaurModel(context.bakeLayer(ClientHandler.CENTAUR)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public CentaurRenderState createRenderState() {
		return new CentaurRenderState();
	}

	@Override
	public void extractRenderState(Centaur entity, CentaurRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.isMale = entity.isMale();
		state.isAggressive = entity.isAggressive();
		state.isFleeing = entity.isFleeing();
		Vec3 movement = entity.getDeltaMovement();
		state.moving = movement.x * movement.x + movement.z * movement.z > 2.500000277905201E-7D;
	}

	@Override
	public Identifier getTextureLocation(CentaurRenderState renderState) {
		return renderState.isMale ? CENTAUR_MALE_LOCATIONS[renderState.variant] : CENTAUR_LOCATIONS[renderState.variant];
	}
}
