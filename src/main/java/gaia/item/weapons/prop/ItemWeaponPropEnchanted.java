package gaia.item.weapons.prop;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemWeaponPropEnchanted extends ItemWeaponProp {
	public ItemWeaponPropEnchanted(Item.Properties builder) {
		super(builder.maxStackSize(1)); //"weapon_prop_enchanted");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.UNCOMMON;
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity host) {
		if (!(host instanceof PlayerEntity) || !((PlayerEntity) host).abilities.isCreativeMode) {
			stack.shrink(1);
		}

		return true;
	}
}
