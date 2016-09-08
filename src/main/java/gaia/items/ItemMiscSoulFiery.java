package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemMiscSoulFiery extends Item {
	String texture;

	public ItemMiscSoulFiery(String texture) {
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.MiscSoulFiery");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.FuelForSeconds", new Object[]{Integer.valueOf(1000)}));
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.MiscSoulFiery.desc"));
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World par3World, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        IBlockState iblockstate = par3World.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        
        pos = pos.offset(side);
        
        if (!player.canPlayerEdit(pos, side, stack)) {
            return false;
        } else {
			if (par3World.isAirBlock(pos)) {
				par3World.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), "mob.ghast.scream", 0.4F, 0.8F);
				par3World.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
			}

			stack.damageItem(1, player);
			return true;
        }
    }
}
