package gaia.item;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class ItemMiscSoulFiery extends Item {

	private int fuelTimeTicks = 20000;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemMiscSoulFiery(Item.Properties builder) {
		super(builder); //"misc_soul_fiery");
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
		tooltip.add(new TranslationTextComponent("item.grimoireofgaia.misc_soul_fiery.desc").applyTextStyle(TextFormatting.ITALIC));
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity player = context.getPlayer();
		World world = context.getWorld();
		ItemStack stack = context.getItem();

		if (!player.abilities.isCreativeMode) {
			stack.shrink(1);
		}

		BlockPos offsetPos = context.getPos().offset(context.getFace());

		if (!player.canPlayerEdit(offsetPos, context.getFace(), stack)) {
			return ActionResultType.FAIL;
		} else {
			if (world.isAirBlock(offsetPos)) {
				world.playSound(player, player.getPosition(), SoundEvents.ENTITY_GHAST_SCREAM, SoundCategory.PLAYERS, 0.4F, 0.8F);
				world.setBlockState(offsetPos, Blocks.LAVA.getDefaultState());
			}

			stack.damageItem(1, player, (entity) -> { entity.sendBreakAnimation(context.getHand()); });

			return ActionResultType.SUCCESS;
		}
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
