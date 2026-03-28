package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WerecatModel;
import gaia.client.renderer.layer.WerecatEyesLayer;
import gaia.client.state.WerecatRenderState;
import gaia.entity.Werecat;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;

public class WerecatRenderer extends MobRenderer<Werecat, WerecatRenderState, WerecatModel> {
	public static final Identifier[] WERECAT_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/werecat/werecat01.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/werecat/werecat02.png")};

	public WerecatRenderer(EntityRendererProvider.Context context) {
		super(context, new WerecatModel(context.bakeLayer(ClientHandler.WERECAT)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new WerecatEyesLayer(this));
	}

	@Override
	public WerecatRenderState createRenderState() {
		return new WerecatRenderState();
	}

	@Override
	public void extractRenderState(Werecat entity, WerecatRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.isFleeing = entity.isFleeing();
		Vec3 movement = entity.getDeltaMovement();
		state.moving = movement.x * movement.x + movement.z * movement.z > 2.500000277905201E-7D;
	}

	@Override
	public Identifier getTextureLocation(WerecatRenderState state) {
		return WERECAT_LOCATIONS[state.variant];
	}
}
