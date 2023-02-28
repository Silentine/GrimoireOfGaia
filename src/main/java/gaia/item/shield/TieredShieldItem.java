package gaia.item.shield;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.ToolAction;

import java.util.function.Supplier;

public class TieredShieldItem extends ShieldItem {
	private final LazyLoadedValue<Ingredient> repairIngredient;

	public TieredShieldItem(Item.Properties properties, Supplier<Ingredient> ingredientSupplier) {
		super(properties);
		DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
		this.repairIngredient = new LazyLoadedValue<>(ingredientSupplier);
	}

	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return repairIngredient.get().test(repair) || super.isValidRepairItem(toRepair, repair);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
		return net.minecraftforge.common.ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
	}
}
