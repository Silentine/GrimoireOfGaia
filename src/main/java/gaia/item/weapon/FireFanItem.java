package gaia.item.weapon;

import gaia.registry.GaiaRegistry;
import gaia.util.EnchantUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;

public class FireFanItem extends FanItem {

	public FireFanItem(Properties properties) {
		super(properties.repairable(GaiaRegistry.SOULFIRE.get()));
	}

	@Override
	public void onCraftedBy(ItemStack itemStack, Player player) {
		super.onCraftedBy(itemStack, player);
		itemStack.enchant(EnchantUtil.getEnchantmentHolder(player, Enchantments.FIRE_ASPECT), 2);
		itemStack.enchant(EnchantUtil.getEnchantmentHolder(player, Enchantments.KNOCKBACK), 1);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return false;
	}
}
