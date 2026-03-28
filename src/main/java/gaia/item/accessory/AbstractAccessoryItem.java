package gaia.item.accessory;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.ModList;

public abstract class AbstractAccessoryItem extends Item {
	public AbstractAccessoryItem(Properties properties) {
		super(properties.rarity(Rarity.RARE));
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return ModList.get().isLoaded("curios");
	}

	public boolean isModifier() {
		return false;
	}

	public abstract void doEffect(LivingEntity player, ItemStack stack);

	public abstract void applyModifier(LivingEntity player, ItemStack stack);

	public abstract void removeModifier(LivingEntity player, ItemStack stack);

	public void onEquip(LivingEntity livingEntity, ItemStack stack) {
		if (isModifier()) {
			applyModifier(livingEntity, stack);
		}
	}

	public void onUnequip(LivingEntity livingEntity, ItemStack stack) {
		if (isModifier()) {
			removeModifier(livingEntity, stack);
		}
	}

	public void onTick(LivingEntity livingEntity, ItemStack stack) {
		doEffect(livingEntity, stack);
	}
}
