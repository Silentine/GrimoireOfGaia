package gaia.item.weapon.book;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class GaiaBookItem extends Item {
	public GaiaBookItem(Properties properties) {
		super(properties);
	}

	public void executeHurtEffect(ItemStack stack, LivingEntity target, LivingEntity attacker) {
	}
}
