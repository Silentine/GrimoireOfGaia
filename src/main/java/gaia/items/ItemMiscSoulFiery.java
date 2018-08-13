package gaia.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMiscSoulFiery extends ItemBase {
	public ItemMiscSoulFiery() {
		super("misc_soul_fiery");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.FuelForSeconds", TileEntityFurnace.getItemBurnTime(stack)));
		tooltip.add(TextFormatting.ITALIC + I18n.format("item.grimoireofgaia.misc_soul_fiery.desc"));
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
				world.setBlockState(offsetPos, Blocks.FLOWING_LAVA.getDefaultState());
			}

			stack.damageItem(1, player);

			return EnumActionResult.SUCCESS;
		}
	}

	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return 1000;
	}
}
