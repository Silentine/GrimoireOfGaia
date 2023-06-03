package gaia.item.edible;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MandrakeItem extends EdibleEffectItem {
	public MandrakeItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		list.add(new TranslatableComponent("text.grimoireofgaia.gain_hearts", 2));
		list.add(new TranslatableComponent("text.grimoireofgaia.lose_hunger", 4));
		super.appendHoverText(stack, level, list, flag);
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
