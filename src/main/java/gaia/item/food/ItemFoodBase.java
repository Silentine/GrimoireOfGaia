package gaia.item.food;

import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ItemFoodBase extends Item {
	public ItemFoodBase(Item.Properties builder) {
		super(builder);
	}

	/**
	 * Spawns EntityXPOrb
	 */
	static void rewardEXP(PlayerEntity player, int value) {
		World world = player.world;
		ExperienceOrbEntity entity = new ExperienceOrbEntity(world, player.getPosX(), player.getPosY() + 1, player.getPosZ(), value);

		if (!world.isRemote) {
			world.addEntity(entity);
		}
	}
}
