package gaia.items;

import gaia.Gaia;
import gaia.init.Sounds;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemMiscSoulFiery extends Item {

	public ItemMiscSoulFiery(String name) {
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.FuelForSeconds", new Object[]{Integer.valueOf(1000)}));
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.MiscSoulFiery.desc"));
	}
	
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		IBlockState iblockstate = world.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        
        pos = pos.offset(side);
        
        if (!player.canPlayerEdit(pos, side, stack)) {
        	return EnumActionResult.FAIL;
        } else {
			if (world.isAirBlock(pos)) {
				world.playSound(player, player.getPosition(), SoundEvents.ENTITY_GHAST_SCREAM, SoundCategory.PLAYERS, 0.4F, 0.8F);
				world.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
			}

			stack.damageItem(1, player);
			return EnumActionResult.SUCCESS;
        }
    }
}
