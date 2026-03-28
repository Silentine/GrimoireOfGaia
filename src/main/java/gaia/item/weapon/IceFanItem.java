package gaia.item.weapon;

import gaia.registry.GaiaRegistry;
import gaia.util.EnchantUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.function.Consumer;

public class IceFanItem extends FanItem {

	public IceFanItem(Properties properties) {
		super(properties.repairable(GaiaRegistry.SOULFIRE.get()));
	}

	@Override
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		super.hurtEnemy(stack, target, attacker);
		target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 100, 3));
	}

	@Override
	public void onCraftedBy(ItemStack itemStack, Player player) {
		super.onCraftedBy(itemStack, player);
		itemStack.enchant(EnchantUtil.getEnchantmentHolder(player, Enchantments.KNOCKBACK), 4);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {

		builder.accept(Component.translatable("effect.minecraft.slowness").append(" IV (0:05)").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return false;
	}
}
