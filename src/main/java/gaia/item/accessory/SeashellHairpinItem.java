package gaia.item.accessory;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SeashellHairpinItem extends AbstractAccessoryItem {

	public SeashellHairpinItem(Properties properties) {
		super(properties.durability(1));
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);

		list.add(Component.translatable("text.grimoireofgaia.trinket.tag").withStyle(ChatFormatting.YELLOW));


		if (Screen.hasShiftDown()) {
			list.add(Component.translatable(MobEffects.WATER_BREATHING.getDescriptionId()).append(Component.literal(" (0:20)")).withStyle(ChatFormatting.GRAY));
		} else {
			list.add(Component.translatable("text.grimoireofgaia.hold_shift").withStyle(ChatFormatting.ITALIC));
		}
	}

	@Override
	public boolean isModifier() {
		return true;
	}

	@Override
	public void doEffect(LivingEntity player, ItemStack stack) {
		if (stack.getDamageValue() == 0 && !player.hasEffect(MobEffects.WATER_BREATHING) && player.isInWater()) {
			player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20 * 20, 0, true, false));
			stack.setDamageValue(1);
		} else if (stack.getDamageValue() == 1 && !player.isInWater()) {
			player.removeEffect(MobEffects.WATER_BREATHING);
			stack.setDamageValue(0);
		}
	}

	@Override
	public void applyModifier(LivingEntity player, ItemStack stack) {
	}

	@Override
	public void removeModifier(LivingEntity player, ItemStack stack) {
	}
}
