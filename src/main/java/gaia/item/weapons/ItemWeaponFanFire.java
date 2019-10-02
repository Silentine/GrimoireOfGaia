package gaia.item.weapons;

import com.google.common.collect.Multimap;
import gaia.init.GaiaItems;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemWeaponFanFire extends ItemWeaponFan {
	private int attackDamage;

	public ItemWeaponFanFire(Item.Properties builder) {
		super(builder); //"weapon_fan_fire");
		attackDamage = 7;
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity host) {
		stack.damageItem(1, host, (entity) -> { entity.sendBreakAnimation(host.getActiveHand()); });
		return true;
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack itemStack) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot, itemStack);

		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) attackDamage, AttributeModifier.Operation.MULTIPLY_BASE));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, AttributeModifier.Operation.MULTIPLY_BASE));
		}

		return multimap;
	}

	@Override
	public void onCreated(ItemStack stack, World world, PlayerEntity player) {
		stack.addEnchantment(Enchantments.FIRE_ASPECT, 2);
		stack.addEnchantment(Enchantments.KNOCKBACK, 1);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return GaiaItems.MISC_SOUL_FIERY == repair.getItem();
	}

	@OnlyIn(Dist.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return false;
	}
}
