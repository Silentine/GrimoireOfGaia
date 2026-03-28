package gaia.util;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

public class EnchantUtil {

	public static Holder<Enchantment> getEnchantmentHolder(Entity entity, ResourceKey<Enchantment> resourceKey) {
		return entity.level().holderOrThrow(resourceKey);
	}

	public static Holder<Enchantment> getEnchantmentHolder(Level level, ResourceKey<Enchantment> resourceKey) {
		return level.holderOrThrow(resourceKey);
	}
}
