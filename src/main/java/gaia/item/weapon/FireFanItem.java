package gaia.item.weapon;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;
import gaia.registry.GaiaRegistry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class FireFanItem extends FanItem {
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public FireFanItem(Properties properties) {
		super(properties);
		this.attackDamage = 7;

		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double) this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double) -2.4000000953674316D, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	@Override
	public void onCraftedBy(ItemStack stack, Level level, Player player) {
		super.onCraftedBy(stack, level, player);
		stack.enchant(Enchantments.FIRE_ASPECT, 2);
		stack.enchant(Enchantments.KNOCKBACK, 1);
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
		return equipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getAttributeModifiers(equipmentSlot, stack);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return false;
	}

	@Override
	public boolean isValidRepairItem(ItemStack stack, ItemStack repairStack) {
		return repairStack.is(GaiaRegistry.SOULFIRE.get());
	}
}
