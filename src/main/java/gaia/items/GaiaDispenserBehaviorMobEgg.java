package gaia.items;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class GaiaDispenserBehaviorMobEgg extends BehaviorDefaultDispenseItem 
{
	public ItemStack dispenseStack(IBlockSource BlockSource, ItemStack stack) 
	{
		//EnumFacing enumfacing = BlockDispenser.func_149937_b(BlockSource.getBlockMetadata());
		EnumFacing enumfacing = BlockDispenser.getFacing(BlockSource.getBlockMetadata());
		double d0 = BlockSource.getX() + (double)enumfacing.getFrontOffsetX();
		//double d1 = (double)((float)BlockSource.getYInt() + 0.2F);
		double d1 = BlockSource.getY() +(double)enumfacing.getFrontOffsetY();
		double d2 = BlockSource.getZ() + (double)enumfacing.getFrontOffsetZ();
		Entity entity = ItemGaiaSpawnEgg.spawnCreature(BlockSource.getWorld(), stack.getItemDamage(), d0, d1, d2);

		if(entity instanceof EntityLivingBase && stack.hasDisplayName()) 
		{
			((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
		}

		stack.splitStack(1);
		return stack;
	}
}
