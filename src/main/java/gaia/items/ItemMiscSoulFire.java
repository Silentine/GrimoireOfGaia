package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemMiscSoulFire extends Item {
	String texture;

	public ItemMiscSoulFire(String texture) {

		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.MiscSoulFire");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocalFormatted("text.GrimoireOfGaia.FuelForSeconds", new Object[]{Integer.valueOf(580)}));
		par3List.add(StatCollector.translateToLocal("item.GrimoireOfGaia.MiscSoulFire.desc"));
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = par3World.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if(!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        
        pos = pos.offset(side);
        
        if (!par2EntityPlayer.canPlayerEdit(pos, side, par1ItemStack))
        {
            return false;
        }
        else {
			if(par3World.isAirBlock(pos)) {
				par3World.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), "mob.ghast.scream", 0.4F, 0.8F);
				par3World.setBlockState(pos, Blocks.fire.getDefaultState());
			}

			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
        }
    }
	
	/*public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(par7 == 0) {
			--par5;
		}

		if(par7 == 1) {
			++par5;
		}

		if(par7 == 2) {
			--par6;
		}

		if(par7 == 3) {
			++par6;
		}

		if(par7 == 4) {
			--par4;
		}

		if(par7 == 5) {
			++par4;
		}

		if(!par2EntityPlayer.capabilities.isCreativeMode) {
			--par1ItemStack.stackSize;
		}

		if(!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
			return false;
		} else {
			Block i1 = par3World.getBlock(par4, par5, par6);
			if(i1 == Blocks.air) {
				par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "mob.ghast.death", 0.15F, itemRand.nextFloat() * 0.4F + 0.8F);
				par3World.setBlock(par4, par5, par6, Blocks.fire);
			}

			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}
	}*/

	/*public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon("gaia:" + this.texture);
	}*/
   }
