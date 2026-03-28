package gaia.item.accessory;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class RingItem extends AbstractAccessoryItem {
	private final List<Supplier<MobEffectInstance>> mobEffects;

	public RingItem(Properties properties, List<Supplier<MobEffectInstance>> mobEffects) {
		super(properties.durability(1));
		this.mobEffects = mobEffects;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
		builder.accept(Component.translatable("text.grimoireofgaia.ring.tag").withStyle(ChatFormatting.YELLOW));

		if (tooltipFlag.hasShiftDown()) {
			for (Supplier<MobEffectInstance> effect : mobEffects) {
				builder.accept(Component.translatable(effect.get().getDescriptionId()).withStyle(ChatFormatting.GRAY));
			}
		} else {
			builder.accept(Component.translatable("text.grimoireofgaia.hold_shift").withStyle(ChatFormatting.ITALIC));
		}
	}

	@Override
	public boolean isModifier() {
		return true;
	}

	@Override
	public void doEffect(LivingEntity player, ItemStack stack) {
		for (Supplier<MobEffectInstance> effect : mobEffects) {
			player.addEffect(effect.get());
		}
	}

	@Override
	public void applyModifier(LivingEntity player, ItemStack stack) {
	}

	@Override
	public void removeModifier(LivingEntity player, ItemStack stack) {
	}
}
