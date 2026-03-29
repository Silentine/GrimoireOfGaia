package gaia.item.fuel;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

//TODO: Make this use the datamap!
public class FuelItem extends Item {
	public FuelItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		if (context.level() == null) return;
		builder.accept(Component.translatable("text.grimoireofgaia.fuel_for_seconds",
				(itemStack.getBurnTime(null, context.level().fuelValues()) / 20)).withStyle(ChatFormatting.GRAY));
	}
}
