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
import java.util.Random;
import java.util.function.Function;

public class XPEdibleItem extends EdibleEffectItem {
	private final Function<Random, Integer> experienceFunction;

	public XPEdibleItem(Properties properties, Function<Random, Integer> experienceFunction) {
		super(properties);
		this.experienceFunction = experienceFunction;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		list.add(new TranslatableComponent("text.grimoireofgaia.gain_experience"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		if (entity instanceof Player player) {
			rewardEXP(player, experienceFunction.apply(level.random));
		}
		return super.finishUsingItem(stack, level, entity);
	}
}
