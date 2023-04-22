package gaia.item.accessory;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class KnucklesItem extends AbstractAccessoryItem {
	private static final int damage = 2;
	private static final AttributeModifier BOOST = new AttributeModifier(UUID.fromString("d2cc095e-1f15-49a9-a32b-993e7f5c4910"), "GoG Knuckles Damage boost", (double) damage, Operation.ADDITION);

	public KnucklesItem(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, level, list, flag);
		list.add(new TranslatableComponent("text.grimoireofgaia.charm.tag").withStyle(ChatFormatting.YELLOW));

		if (Screen.hasShiftDown()) {
			list.add(new TranslatableComponent("text.grimoireofgaia.charm.damage", damage));
		} else {
			list.add(new TranslatableComponent("text.grimoireofgaia.hold_shift").withStyle(ChatFormatting.ITALIC));
		}
	}

	@Override
	public boolean isModifier() {
		return true;
	}

	@Override
	public void doEffect(LivingEntity player, ItemStack stack) {
	}

	@Override
	public void applyModifier(LivingEntity player, ItemStack stack) {
		AttributeInstance attribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
		if (!attribute.hasModifier(BOOST)) {
			attribute.addTransientModifier(BOOST);
		}
	}

	@Override
	public void removeModifier(LivingEntity player, ItemStack stack) {
		AttributeInstance attribute = player.getAttribute(Attributes.ATTACK_DAMAGE);
		if (attribute.hasModifier(BOOST)) {
			attribute.removeModifier(BOOST);
		}
	}
}
