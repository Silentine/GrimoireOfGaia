package gaia.client.state;

import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;

public class ValkyrieRenderState extends ArmedEntityRenderState implements PoweredState{
	public int variant;
	public boolean isRiding;
	public int animationState;
	public boolean powered;

	@Override
	public boolean isPowered() {
		return powered;
	}
}