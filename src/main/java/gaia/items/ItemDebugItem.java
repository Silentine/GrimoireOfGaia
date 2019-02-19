package gaia.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * DEBUG item
 * 
 * Used to test .json files
 * 
 * Disable item in GaiaItems before release.
 */
public class ItemDebugItem extends ItemBase {

	public ItemDebugItem(Item.Properties builder) {
		super(builder.maxStackSize(1).group(null)); //"debug_item");
//		setHasSubtypes(true);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}
	
	@Override
	public EnumActionResult onItemUse(ItemUseContext context) {
		EntityPlayer player = context.getPlayer();
		World world = context.getWorld();
		ItemStack stack = context.getItem();

		if (!player.abilities.isCreativeMode) {
			stack.shrink(1);
		}

		BlockPos offsetPos = context.getPos().offset(context.getFace());

		if (!player.canPlayerEdit(offsetPos, context.getFace(), stack)) {
			return EnumActionResult.FAIL;
		} else {
			if (world.isAirBlock(offsetPos)) {
				world.playSound(player, player.getPosition(), SoundEvents.ENTITY_GHAST_SCREAM, SoundCategory.PLAYERS, 0.4F, 0.8F);
				world.setBlockState(offsetPos, Blocks.FIRE.getDefaultState());
			}

			stack.damageItem(1, player);

			return EnumActionResult.SUCCESS;
		}
	}
	
//
//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public void registerClient() {
//		ModelLoaderHelper.registerItem(this, 
//				ModelLoaderHelper.getSuffixedLocation(this, "01")
//		);
//	}
	/* SUBITEMS */
}
