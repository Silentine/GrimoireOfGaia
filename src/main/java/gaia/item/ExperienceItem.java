package gaia.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class ExperienceItem extends Item {
	private final int levels;

	public ExperienceItem(Properties properties, int levels) {
		super(properties);
		this.levels = levels;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (livingEntity instanceof Player player) {
			if (!player.getAbilities().instabuild) {
				stack.shrink(1);
			}

			if (!level.isClientSide()) {
				level.playSound((Player) null, livingEntity.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.5F, level.getRandom().nextFloat() * 0.1F + 0.9F);
				player.giveExperienceLevels(levels);
			}
		} else {
			stack.shrink(1);
		}
		return super.finishUsingItem(stack, level, livingEntity);
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		player.startUsingItem(hand);
		return InteractionResult.CONSUME;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		if (levels == 1) {
			builder.accept(Component.translatable("text.grimoireofgaia.gain_level", levels).withStyle(ChatFormatting.GRAY));
		} else {
			builder.accept(Component.translatable("text.grimoireofgaia.gain_levels", levels).withStyle(ChatFormatting.GRAY));
		}
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity livingEntity) {
		return 20;
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack stack) {
		return ItemUseAnimation.BOW;
	}
}
