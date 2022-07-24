package gaia.item.shield;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.ToolAction;

import java.util.function.Supplier;

public class TieredShieldItem extends Item {
	private final LazyLoadedValue<Ingredient> repairIngredient;

	public TieredShieldItem(Item.Properties properties, Supplier<Ingredient> ingredientSupplier) {
		super(properties);
		DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
		this.repairIngredient = new LazyLoadedValue<>(ingredientSupplier);
	}

	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BLOCK;
	}

	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		player.startUsingItem(hand);
		return InteractionResultHolder.consume(itemstack);
	}

	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return repair.is(ItemTags.PLANKS) || repairIngredient.get().test(repair) || super.isValidRepairItem(toRepair, repair);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
		return net.minecraftforge.common.ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
	}
}
