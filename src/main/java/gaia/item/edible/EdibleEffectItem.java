package gaia.item.edible;

import gaia.config.GaiaConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class EdibleEffectItem extends Item {
	public EdibleEffectItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		Consumable consumable = itemStack.get(DataComponents.CONSUMABLE);
		if (consumable != null && !GaiaConfig.CLIENT.hideFoodEffectTooltips.getAsBoolean()) {
			for (ConsumeEffect consumeEffect : consumable.onConsumeEffects()) {
				if (consumeEffect instanceof ApplyStatusEffectsConsumeEffect applyStatusEffectsConsumeEffect) {
					for (MobEffectInstance effect : applyStatusEffectsConsumeEffect.effects()) {
						int totalSeconds = effect.getDuration() / 20;
						int minutes = (totalSeconds % 3600) / 60;
						int seconds = totalSeconds % 60;
						builder.accept(Component.translatable(effect.getDescriptionId())
								.append(Component.literal(String.format(" (%d:%02d)", minutes, seconds))).withStyle(ChatFormatting.GRAY));
					}
				}
			}
		}
	}

	protected void rewardEXP(Player player, int value) {
		Level level = player.level();
		ExperienceOrb orb = new ExperienceOrb(level, player.getX(), player.getY() + 1, player.getZ(), value);
		if (!level.isClientSide()) {
			level.addFreshEntity(orb);
		}
	}
}
