package gaia.util;

import net.minecraft.world.entity.player.Player;

public class RandomUtil {
	public static Player getPlayer() {
		return net.minecraft.client.Minecraft.getInstance().player;
	}
}
