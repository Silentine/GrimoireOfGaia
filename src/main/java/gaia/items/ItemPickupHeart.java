package gaia.items;

import gaia.helpers.ModelLoaderHelper;
import gaia.proxy.IClientRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPickupHeart extends ItemBase implements IClientRegister {
	public ItemPickupHeart() {
		super("pickup_heart");
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

		if (!(entityIn instanceof EntityPlayer))
			return;

		EntityPlayer player = (EntityPlayer) entityIn;
		BlockPos pos = new BlockPos(player.posX, player.posY + player.getYOffset(), player.posZ);

		if (!player.capabilities.isCreativeMode) {
			player.heal(2);
			stack.shrink(1);

			for (int i1 = 0; i1 < 15; ++i1) {
				double d0 = itemRand.nextGaussian() * 0.02D;
				double d1 = itemRand.nextGaussian() * 0.02D;
				double d2 = itemRand.nextGaussian() * 0.02D;
				worldIn.spawnParticle(EnumParticleTypes.HEART, (double) ((float) pos.getX() + itemRand.nextFloat()), ((double) pos.getY() + 1.0f) + (double) itemRand.nextFloat() * 2.0f, (double) ((float) pos.getZ() + itemRand.nextFloat()), d0, d1, d2, new int[0]);
			}
		}
	}
}
