package gaia.items.debug;

import gaia.helpers.ModelLoaderHelper;
import gaia.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * DEBUG item
 * 
 * Used to test .json files
 * 
 * Disable item in GaiaItems before release.
 */
public class ItemDebugItem extends ItemBase {

	public ItemDebugItem() {
		super("debug_item");
		maxStackSize = 1;
		setHasSubtypes(true);
		
//		setCreativeTab(null);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);

		if (!player.capabilities.isCreativeMode) {
			stack.shrink(1);
		}

		BlockPos offsetPos = pos.offset(facing);

		if (!player.canPlayerEdit(offsetPos, facing, stack)) {
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
	
	/* SUBITEMS */
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 1; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this, 
				ModelLoaderHelper.getSuffixedLocation(this, "01")
		);
	}
	/* SUBITEMS */
}
