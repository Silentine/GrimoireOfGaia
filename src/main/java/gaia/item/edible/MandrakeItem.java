package gaia.item.edible;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class MandrakeItem extends EdibleEffectItem {
	public MandrakeItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		builder.accept(Component.translatable("text.grimoireofgaia.gain_hearts", 2));
		builder.accept(Component.translatable("text.grimoireofgaia.lose_hunger", 4));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		if (entity instanceof Player player) {
			player.heal(4.0F);
			player.causeFoodExhaustion(40.0F);
		}
		return super.finishUsingItem(stack, level, entity);
	}
}
